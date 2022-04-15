package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.GoodsDAO;
import onedo.mvc.dao.GoodsDAOImpl;
import onedo.mvc.dto.GoodsDTO;

public class GoodsServiceImpl implements GoodsService {

	
	GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	@Override
	public List<GoodsDTO> selectAll() throws SQLException {
		goodsDAO = new GoodsDAOImpl();
		List<GoodsDTO> list = goodsDAO.selectAll();
		
		return list;
	}

	@Override
	public List<GoodsDTO> selectAll(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 상품등록
	 * */
	@Override
	public void insert(GoodsDTO goodsDTO) throws SQLException {
		int result = goodsDAO.insert(goodsDTO);
		if (result == 0) throw new SQLException("등록 실패");
	}

	@Override
	public GoodsDTO selectByGoodsCode(String goodsCode, boolean flag) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 상품삭제 --품절이면 안보이게
	 * */
	@Override
	public void delete(String goodsCode, String password, String path) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * 상품수정
	 * */
	@Override
	public void update(GoodsDTO goodsDTO) throws SQLException {
		int result = goodsDAO.update(goodsDTO);
		if (result == 0) throw new SQLException("수정 실패");

	}

}
