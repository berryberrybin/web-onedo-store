package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.GoodsDAO;
import onedo.mvc.dao.GoodsDAOImpl;
import onedo.mvc.dto.GoodsDTO;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDAO goodsDAO;
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

	@Override
	public void insert(GoodsDTO goodsDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public GoodsDTO selectByGoodsCode(String goodsCode, boolean flag) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String goodsCode, String password, String path) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GoodsDTO goodsDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

}
