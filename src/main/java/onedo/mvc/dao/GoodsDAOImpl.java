package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.GoodsDTO;

public class GoodsDAOImpl implements GoodsDAO {

	@Override
	public List<GoodsDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsDTO> getBoardList(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsDTO selectBygoodsCode(int goodsCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int increamentByReadgoodsCode(int goodsCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(GoodsDTO goodsDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int goodsCode, String password) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GoodsDTO goodsDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
