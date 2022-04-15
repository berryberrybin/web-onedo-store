package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.util.DbUtil;

public class GoodsDAOImpl implements GoodsDAO {
	private Properties proFile = new Properties();

	public GoodsDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	GoodsDTO goodsDTO = new GoodsDTO();

	@Override
	public List<GoodsDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		
		String sql=proFile.getProperty("goods.selectAll");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				goodsDTO = new GoodsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
				list.add(goodsDTO);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	@Override
	public List<GoodsDTO> getBoardList(int pageNo) throws SQLException {
		//페이징처리
		return null;
	}

	@Override
	public GoodsDTO selectByGoodsCode(int goodsCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=proFile.getProperty("goods.selectByGoodsCode"); //select * from goods where goods_code=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,goodsCode);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				goodsDTO = new GoodsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return goodsDTO;
	}

	@Override
	public int increamentByReadgoodsCode(int goodsCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품등록
	 */
	@Override
	public int insert(GoodsDTO goodsDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("goods.insert");
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsDTO.getGoodsCode());
			ps.setString(2, goodsDTO.getGoodsType());
			ps.setString(3, goodsDTO.getGoodsName());
			ps.setInt(4, goodsDTO.getGoodsPrice());
			ps.setInt(5, goodsDTO.getGoodsStock());
			ps.setString(6, goodsDTO.getGoodsDetail());
			ps.setInt(7, goodsDTO.getIsSoldout());
			ps.setInt(8, goodsDTO.getGoodsView());
			ps.setString(9, goodsDTO.getGoodsImg());

			result = ps.executeUpdate();

			con.commit();

		} finally {
			con.rollback();
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	/**
	 * 상품수정
	 */
	@Override
	public int update(GoodsDTO goodsDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("goods.update");
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, goodsDTO.getGoodsName());
			ps.setInt(2, goodsDTO.getGoodsPrice());
			ps.setInt(3, goodsDTO.getGoodsStock());
			ps.setString(4, goodsDTO.getGoodsDetail());
			ps.setInt(5, goodsDTO.getIsSoldout());
			ps.setString(6, goodsDTO.getGoodsImg());

			result = ps.executeUpdate();
			con.commit();

		} finally {
			con.rollback();
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	/**
	 * 상품삭제
	 */
	@Override
	public int delete(int goodsCode, String password) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품 재고가 0이면 isSoldOut 0(품절)만들기
	 */
	@Override
	public int isSoldoutUpdate(GoodsDTO goodsDTO) throws SQLException {
		
		return 0;
		
	}

}
