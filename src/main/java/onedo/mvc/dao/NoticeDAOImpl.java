package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.NoticeDTO;
import onedo.mvc.paging.PageCnt;
import onedo.mvc.util.DbUtil;

public class NoticeDAOImpl implements NoticeDAO {
	private Properties proFile = DbUtil.getProFile();

	@Override
	public List<NoticeDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
		
		String sql = "select * from notice_board order by notice_no";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				NoticeDTO ndto = new NoticeDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5));

				noticeList.add(ndto);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);	
		}
		
		return noticeList;
	}
		

	@Override
	public List<NoticeDTO> getBoardList(int pageNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
		String sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM notice_board ORDER BY notice_no desc) a) where  rnum>=? and rnum <=?";
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
				NoticeDTO ndto = new NoticeDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5));

				noticeList.add(ndto);
			}
				
			}finally {
				DbUtil.dbClose(rs, ps, con);
			}
		return noticeList;
	}
	/**
	 * 전체레코드 수
	 * */
	private int getTotalCount()throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int totalCount=0;
		String sql = "select count(*) from notice_board";
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
	public NoticeDTO selectByNoticeCode(int noticeNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		NoticeDTO noticeDTO=null;
		
		String sql = "select * from notice_board where notice_no=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, noticeNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				noticeDTO = new NoticeDTO(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5));
			}
			}finally {
				DbUtil.dbClose(rs, ps, con);
			}
			return noticeDTO;
			}
	

	@Override
	public int insert(NoticeDTO noticeDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql ="insert into notice_board values(NOTICE_NO_SEQ.NEXTVAL,?,?,CURRENT_DATE,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,noticeDTO.getNoticeSubject() );
			ps.setString(2,noticeDTO.getNoticeContent() );
			ps.setString(3,noticeDTO.getNoticeImg() );
		
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	

	@Override
	public int delete(int noticeNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "delete notice_board where faq_no=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,noticeNo);
		
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int update(NoticeDTO noticeDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "update notice_board set faq_subject=?,faq_content=? where faq_no=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
			ps.setString(1,noticeDTO.getNoticeSubject() );
			ps.setString(2,noticeDTO.getNoticeContent() );

			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;

	}

}
