package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.QnaReplyDTO;
import onedo.mvc.dto.ReviewDTO;
import onedo.mvc.paging.PageCnt;
import onedo.mvc.util.DbUtil;

public class QnaDAOImpl implements QnaDAO {
	private Properties proFile = DbUtil.getProFile();

	@Override
	public List<QnaDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		
		String sql = "select * from QnA_board order by goods_code";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QnaDTO qdto = new QnaDTO(
						rs.getInt(1),
						rs.getInt(2),	
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8));
				
				qnaList.add(qdto);
			}
			}finally {
				DbUtil.dbClose(rs, ps, con);	
			}
			
			return qnaList;
		}

	@Override
	public List<QnaDTO> getBoardList(int pageNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		

		String sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM QnA_board ORDER BY qna_No desc) a) where  rnum>=? and rnum <=?";
		
		try {

		
			 //전체레코드 수를 구해서 총페이지 수를 구하고 db에서 꺼내올 게시물을 개수를 pagesize만큼 가져온다.
			int totalCount = this.getTotalCount();
			int totalPage = totalCount%PageCnt.getPagesize() ==0 ? totalCount/PageCnt.getPagesize() : (totalCount/PageCnt.getPagesize())+1 ;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);//전페페이지수를 저장해준다.
			pageCnt.setPageNo(pageNo); //사용자가 클릭한 page번호를 설정
						
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//의 2개의 값 설정
			ps.setInt(1, (pageNo-1)*PageCnt.pagesize+1); //시작점번호
			ps.setInt(2, pageNo*PageCnt.pagesize); //끝점 번호
					
			rs = ps.executeQuery();
			while(rs.next()) {QnaDTO qdto = new QnaDTO(
					rs.getInt(1),
					rs.getInt(2),	
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8));
			
			qnaList.add(qdto);
		}
		}finally {
			DbUtil.dbClose(rs, ps, con);	
		}
		
		return qnaList;
	}
	
	/**
	 * 전체레코드 수
	 * */
	private int getTotalCount()throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int totalCount=0;
		String sql = "select count(*) from QnA_board";
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
	public QnaDTO selectByQnaCode(int qnaNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		QnaDTO qnaDTO=null;
		
		String sql = "select * from QnA_board where qna_no=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			
			System.out.println(qnaNo+"상세보기dao");
			
			rs = ps.executeQuery();
			if(rs.next()) {
				qnaDTO = new QnaDTO(
						rs.getInt(1),
						rs.getInt(2),	
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8));
					
				
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println(qnaDTO);
		return qnaDTO;
	}

	@Override
	public int insert(QnaDTO qnaDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "insert into QnA_board values(QNA_NO_SEQ.NEXTVAL,?,?,?,?,CURRENT_DATE,?,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaDTO.getGoodsCode());
			ps.setString(2, qnaDTO.getUserid());
			ps.setString(3, qnaDTO.getQnaSubject());
			ps.setString(4, qnaDTO.getQnaContent());
			ps.setString(5, qnaDTO.getQnaImg());
			ps.setString(6, qnaDTO.getQnaPwd());
			
			result = ps.executeUpdate();
		}finally {
			
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(int qnaNo,String qnaPwd) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "delete QnA_board where qna_no=? and qna_pwd=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,qnaNo);
			ps.setString(2,qnaPwd);
		
			
			result = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int update(QnaDTO qnaDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "update QnA_board set goods_code=?,qna_subject=?,qna_content=? where qna_no=? and qna_pwd=?" ;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
		
			ps.setInt(1,qnaDTO.getGoodsCode());
			ps.setString(2, qnaDTO.getQnaSubject());
			ps.setString(3, qnaDTO.getQnaContent());
			ps.setInt(4,qnaDTO.getQnaNo());
			ps.setString(5, qnaDTO.getQnaPwd());
			
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;

	}

	@Override
	public List<QnaReplyDTO> selectRepliesByModelNum(String modelNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<QnaReplyDTO> repliesList = new ArrayList<QnaReplyDTO>();
		String sql=proFile.getProperty("reply.selectByParentNum");
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, modelNum);
			rs= ps.executeQuery();
			
			while (rs.next()) {
				QnaReplyDTO reply =
					new QnaReplyDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				repliesList.add(reply);
			}
			
		}finally {
			
			DbUtil.dbClose(rs, ps, con);
			
		}
		
		return repliesList;
	}

	@Override
	public List<QnaDTO> selectQnaByGoodsCode(int goodsCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<QnaDTO> list = new ArrayList<QnaDTO>();
		QnaDTO qnaDTO = null;
		
		String sql = proFile.getProperty("qna.selectQnaByGoodsCode");//select * from qna_board where goods_code=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsCode);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				qnaDTO = new QnaDTO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				list.add(qnaDTO);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

}
