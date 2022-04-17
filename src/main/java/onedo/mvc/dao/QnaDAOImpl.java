package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.QnaReply;
import onedo.mvc.paging.PageCnt;
import onedo.mvc.util.DbUtil;

public class QnaDAOImpl implements QnaDAO {
private Properties proFile = new Properties();
	
	public QnaDAOImpl(){
		try {
			//proFile.load(new FileInputStream("src/~~~~"));
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버에서 실행될때 classes폴더의 위치를 동적으로 가져와서 경로를 설정해야한다.
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<QnaDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		
		//String sql = proFile.getProperty("select * from QnA_board order by goods_code");
		String sql = proFile.getProperty("query.select");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QnaDTO qdto = new QnaDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getInt(8));
				
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
		
		String sql = proFile.getProperty("");
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
			while(rs.next()) {QnaDTO qdto = new QnaDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getInt(5),
					rs.getString(6),
					rs.getInt(7),
					rs.getInt(8));
			
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
		String sql = proFile.getProperty(" ");
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
		
		String sql = proFile.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				qnaDTO = new QnaDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getInt(8));						
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return qnaDTO;
	}

	@Override
	public int insert(QnaDTO qnaDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty(" ");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaDTO.getQnaNo());
			ps.setString(2, qnaDTO.getUserid());
			ps.setString(3, qnaDTO.getQnaSubject());
			ps.setString(4, qnaDTO.getQnaContent());
			ps.setInt(5, qnaDTO.getQnaDate());
			ps.setString(6, qnaDTO.getQnaImg());
			ps.setInt(7, qnaDTO.getQnaPwd());
			ps.setInt(8, qnaDTO.getGoodsCode());
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(int qnaNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty(" ");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,qnaNo);
		
			
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
		String sql = proFile.getProperty(" ");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, qnaDTO.getQnaSubject());
			ps.setString(2, qnaDTO.getQnaContent());
			ps.setInt(3, qnaDTO.getQnaDate());
			ps.setString(4, qnaDTO.getQnaImg());
			ps.setInt(5, qnaDTO.getQnaPwd());
			
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;

	}

	@Override
	public List<QnaReply> selectRepliesByModelNum(String modelNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<QnaReply> repliesList = new ArrayList<QnaReply>();
		String sql=proFile.getProperty("reply.selectByParentNum");
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, modelNum);
			rs= ps.executeQuery();
			
			while (rs.next()) {
				QnaReply reply =
					new QnaReply(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4));
				
				repliesList.add(reply);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return repliesList;
	}

}
