package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.GoodsDAO;
import onedo.mvc.dao.GoodsDAOImpl;
import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	/**
	 * 상품전체검색
	 * */
	@Override
	public List<GoodsDTO> selectAll() throws SQLException {
        List<GoodsDTO> list = goodsDAO.selectAll();
        
		return list;
	}
	
	/**
	 * 상품등록
	 * */
	@Override
	public int insert(GoodsDTO goodsDTO, GoodsAttrDTO goodsAttrDTO) throws SQLException {
		int result = goodsDAO.insert(goodsDTO, goodsAttrDTO);
		if (result == 0) throw new SQLException("상품 등록 실패");
		return result;
	}

	/**
	 * 상품검색,상세보기
	 * */
	@Override
	public GoodsDTO selectByGoodsCode(String goodsCode, boolean flag) throws SQLException {
		GoodsDTO goodsDTO = goodsDAO.selectByGoodsCode(Integer.parseInt(goodsCode));
		
		if(flag) {
			//조회수 증가
			goodsDAO.increamentGoodsView(Integer.parseInt(goodsCode));
		}
		
		return goodsDTO;
	}
	
	/**
	 *  상품이름이나 타입으로 상품검색
	 * */
	public List<GoodsDTO> selectMultipleGoods(String searchField, String searchValue, int pageNo) throws SQLException {
		List<GoodsDTO> list = goodsDAO.selectMultipleGoods(searchField, searchValue, pageNo);
		System.out.println("service의 pageNo = " + pageNo);
		return list;
	}

	/**
	 * 상품삭제 --판매중지(2)이면 안보이게
	 * */
	@Override
	public void delete(int goodsCode) throws SQLException {
		int result = goodsDAO.delete(goodsCode);
		if (result == 0)
			throw new SQLException("상품 삭제 실패");

	}

	/**
	 * 상품수정
	 * */
	@Override
	public int update(GoodsDTO goodsDTO, GoodsAttrDTO goodsAttrDTO) throws SQLException {
		int result = goodsDAO.update(goodsDTO, goodsAttrDTO);
		if (result == 0) throw new SQLException("수정 실패");
		return result;

	}

	/**
	 * 판매량 순으로 상품검색
	 * */
	@Override
	public List<GoodsDTO> selectGoodsOrderBySalesRank() throws SQLException {
        List<GoodsDTO> list = goodsDAO.selectGoodsOrderBySalesRank();
        
		return list;
	}
	
	/**
	 * 상품 이미지 등록
	 * */
	@Override
	public int insertGoodsImg(GoodsDTO goodsDTO) throws SQLException {
		int result = goodsDAO.insertGoodsImg(goodsDTO);
		if (result == 0) throw new SQLException("상품 이미지 등록 실패");
		return result;
	}

	@Override
	public List<GoodsDTO> orderByCondition(int orderMethod) throws SQLException {
		List<GoodsDTO> list = goodsDAO.orderByCondition(orderMethod);
        
		return list;
	}
	
}
