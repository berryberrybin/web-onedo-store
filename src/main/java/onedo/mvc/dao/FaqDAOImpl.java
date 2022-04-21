package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.FaqDTO;
import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.ReviewDTO;
import onedo.mvc.paging.PageCnt;
import onedo.mvc.util.DbUtil;

public class FaqDAOImpl implements FaqDAO {
	private Properties proFile = DbUtil.getProFile();

	@Override
	public List<FaqDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<FaqDTO> faqList = new ArrayList<FaqDTO>();
		
		String sql = "select * from FAQ_board order by FAQ_NO";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				FaqDTO rdto = new FaqDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3));
				
				faqList.add(rdto);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);	
		}
		System.out.println(faqList.size()+"dao");
		return faqList;
	}


	@Override
	public List<FaqDTO> getBoardList(int pageNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<FaqDTO> faqList = new ArrayList<FaqDTO>();
		
		String sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM FAQ_board ORDER BY faq_no desc) a) where  rnum>=? and rnum <=?";
		try {
			//전체레코드 수를 구해서 총페이지 수를 구하고 db에서 꺼내올 게시물을 개수를 pagesize만큼 가져온다.
			int totalCount = this.getTotalCount();
			int totalPage = totalCount%PageCnt.getPagesize() ==0 ? totalCount/PageCnt.getPagesize() : (totalCount/PageCnt.getPagesize())+1 ;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);//전페페이지수를 저장해준다.
			pageCnt.setPageNo(pageNo); //사용자가 클릭한 page번호를 설정
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?의 2개의 값 설정
			ps.setInt(1, (pageNo-1)*PageCnt.pagesize+1); //시작점번호
			ps.setInt(2, pageNo*PageCnt.pagesize); //끝점 번호

			
			rs = ps.executeQuery();
			while(rs.next()) {
				FaqDTO rdto = new FaqDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3));
				faqList.add(rdto);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);	
		}
		
		return faqList;
	}
	
	/**
	 * 전체레코드 수
	 * */
	private int getTotalCount()throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int totalCount=0;
		String sql = "select count(*) from FAQ_board";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
					
				}
			}finally {
				DbUtil.dbClose(rs, ps, con);
			}
			
			return totalCount;
		}

	@Override
	public FaqDTO selectByFaqCode(int faqNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		FaqDTO faqDTO=null;
		
		String sql = "select * from FAQ_board where faq_no=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, faqNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				faqDTO = new FaqDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return faqDTO;
	}

	@Override
	public int insert(FaqDTO faqDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty(" ");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, faqDTO.getFaqNo());
			ps.setString(2, faqDTO.getFaqSubject());
			ps.setString(3, faqDTO.getFaqContent());
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(int faqNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty(" ");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,faqNo);
		
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}


	@Override
	public int update(FaqDTO faqDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty(" ");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, faqDTO.getFaqSubject());
			ps.setString(2, faqDTO.getFaqContent());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;

	}
}
