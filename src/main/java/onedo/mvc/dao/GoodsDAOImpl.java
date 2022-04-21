package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.CartItemDTO;
import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.paging.PageCnt;
import onedo.mvc.util.DbUtil;

public class GoodsDAOImpl implements GoodsDAO {
	private Properties proFile = DbUtil.getProFile();
	GoodsDTO goodsDTO = new GoodsDTO();

	/**
	 * 상품전체검색
	 * */
	@Override
	public List<GoodsDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		
		String sql=proFile.getProperty("goods.selectAll");
		GoodsAttrDTO attrDTO = goodsDTO.getGoodsAttrDTO();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				goodsDTO = new GoodsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
				
				//속성을 가져오는 메소드 호출
				
				attrDTO = new GoodsAttrDTO(rs.getInt(1), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
				goodsDTO.setGoodsAttrDTO(attrDTO);
				list.add(goodsDTO);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	/**
	 * 상품코드로 상품검색
	 * */
	@Override
	public GoodsDTO selectByGoodsCode(int goodsCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql=proFile.getProperty("goods.selectByGoodsCode"); //select * from goods join goods_attr using(goods_code) where goods_code=?
		GoodsAttrDTO attrDTO = goodsDTO.getGoodsAttrDTO();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,goodsCode);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				goodsDTO = new GoodsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
				//상품속성 가져오기
				attrDTO = new GoodsAttrDTO(rs.getInt(1), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
				goodsDTO.setGoodsAttrDTO(attrDTO);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return goodsDTO;
	}

	/**
	 * 상품조회수증가 
	 * */
	@Override
	public int increamentGoodsView(int goodsCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		String sql=proFile.getProperty("goods.increamentGoodsView");//update goods set goods_view=goods_view+1 goods_view where goods_code=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsCode);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	/**
	 * 상품등록
	 */
	@Override
	public int insert(GoodsDTO goodsDTO, GoodsAttrDTO goodsAttrDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("goods.insert");
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, goodsDTO.getGoodsType());
			ps.setString(2, goodsDTO.getGoodsName());
			ps.setInt(3, goodsDTO.getGoodsPrice());
			ps.setInt(4, goodsDTO.getGoodsStock());
			ps.setString(5, goodsDTO.getGoodsDetail());
			ps.setInt(6, goodsDTO.getIsSoldout());

			result = ps.executeUpdate(); //등록되면 1
			if(result==0) {
				   con.rollback();
				   throw new SQLException("상품등록 실패");
			}else {
				insertGoodsAttr(con, goodsAttrDTO); //상품특징 등록하기 
			}
			con.commit();
		} finally {
			con.rollback();
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * 상품 속성 등록하기
	 * */
	public int insertGoodsAttr(Connection con  , GoodsAttrDTO goodsAttrDTO) throws SQLException{
		PreparedStatement ps =null;
		String sql = proFile.getProperty("goods.insertGoodsAttr");
		
		int result =0;
		try {
			ps = con.prepareStatement(sql);
				ps.setInt(1, goodsAttrDTO.getSour());
				ps.setInt(2, goodsAttrDTO.getSweet());
				ps.setInt(3, goodsAttrDTO.getAroma());
				ps.setInt(4, goodsAttrDTO.getBody());
				
				result = ps.executeUpdate();
		
		} finally {
			DbUtil.dbClose(ps , null);
		}
		return result;
	}

	/**
	 * 상품수정 //+goods.updateGoodsAttr
	 */
	@Override
	public int update(GoodsDTO goodsDTO, GoodsAttrDTO goodsAttrDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("goods.update");
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			
			ps.setString(1, goodsDTO.getGoodsType());
			ps.setString(2, goodsDTO.getGoodsName());
			ps.setInt(3, goodsDTO.getGoodsPrice());
			ps.setInt(4, goodsDTO.getGoodsStock());
			ps.setString(5, goodsDTO.getGoodsDetail());
			ps.setInt(6, goodsDTO.getIsSoldout());	
			ps.setInt(7, goodsDTO.getGoodsCode());

			result = ps.executeUpdate(); //수정되면 1
			if(result==0) {
				   con.rollback();
				   throw new SQLException("상품 수정 실패");
			}else {
				updateGoodsAttr(con, goodsAttrDTO); //상품특징 등록하기 
			}
			con.commit();
		} finally {
			con.rollback();
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	
	/**
	 * 상품 속성 수정하기
	 * */
	public int updateGoodsAttr(Connection con  , GoodsAttrDTO goodsAttrDTO) throws SQLException{
		PreparedStatement ps =null;
		String sql = proFile.getProperty("goods.updateGoodsAttr");
		System.out.println(goodsAttrDTO.getGoodsCode());
		int result =0;
		try {
			ps = con.prepareStatement(sql);
				ps.setInt(1, goodsAttrDTO.getSour());
				ps.setInt(2, goodsAttrDTO.getSweet());
				ps.setInt(3, goodsAttrDTO.getAroma());
				ps.setInt(4, goodsAttrDTO.getBody());
				ps.setInt(5, goodsAttrDTO.getGoodsCode());
				
				result = ps.executeUpdate();
		
		} finally {
			DbUtil.dbClose(ps , null);
		}
		return result;
	}

	/**
	 * 상품삭제 : isSoldout을 2판매중지로 바꾸는 메소드
	 */
	@Override
	public int delete(int goodsCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("goods.delete");//update goods set is_soldout = 2 where goods_code = ?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsCode);
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
		
	}
	

	/**
	 * 상품 품절 자동처리
	 */
	@Override
	public int isSoldoutUpdate(Connection con, int goodsCode) throws SQLException {
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("goods.soldout"); // stock 0 ->soldOut
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsCode);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
		
	}

	/**
	 *  상품이름이나 타입으로 상품검색
	 * */
	@Override
	public List<GoodsDTO> selectMultipleGoods(String searchField, String searchValue, int pageNo) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		
		String sql=proFile.getProperty("goods.selectMultipleGoods");//select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM goods where 
		
		switch(searchField) {
			case "goodsType" : sql+="goods_type = ?";  break;
			case "goodsName" : sql+="goods_name like ?"; break;
		}
		
		try {
			sql+=" and not is_soldout =2 ORDER BY goods_code) a) where rnum>=? and rnum <=?";
		   
			System.out.println("sql="+sql);
			
			int totalCount = this.getTotalCount(searchField, searchValue);
			int totalPage = totalCount%PageCnt.getPagesize()==0? totalCount/PageCnt.getPagesize() : totalCount/PageCnt.getPagesize()+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage); //전체페이지수를 저장해준다.
			pageCnt.setPageNo(pageNo); //사용자가 클릭한 page번호를 설정
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			switch(searchField) {
			  case "goodsType" : ps.setString(1, searchValue);  break;
			  case "goodsName" : ps.setString(1, "%"+searchValue+"%"); break;
			}
			
			ps.setInt(2,(pageNo-1)*PageCnt.pagesize+1); //시작점번호
			ps.setInt(3, pageNo*PageCnt.pagesize); //끝점 번호
			
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
	

	/**
	 * 전체레코드수 가져오기
	 * */
	private int getTotalCount(String searchField, String searchValue) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int totalCount=0;
		
		String sql = proFile.getProperty("goods.totalCount");//select count(*) from goods where
		switch(searchField) {
		case "goodsType" : sql+="goods_type = ?"; break;
		case "goodsName" : sql+="goods_name like ?"; break;
		}
		System.out.println(sql);
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			if(searchField.equals("goodsType"))ps.setString(1,searchValue);
			else if(searchField.equals("goodsName")) ps.setString(1,"%"+searchValue+"%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return totalCount;
	}
	
	/**
	 * 상품이미지등록
	 * */
	@Override
	public int insertGoodsImg(GoodsDTO goodsDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("goods.insertGoodsImg");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsDTO.getGoodsCode());
			ps.setString(2, goodsDTO.getGoodsImg());
			
			result = ps.executeUpdate(); //1
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	


	/**
	 * 판매량 순으로 상품검색
	 * */
	@Override
	public List<GoodsDTO> selectGoodsOrderBySalesRank() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		
		//굿즈코드 찾을 쿼리
		String sql=proFile.getProperty("goods.selectGoodsOrderBySalesRank");//판매량높은순으로 4순위까지 가져온다
		//굿즈코드 담을 변수
		int goodsCode =0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				goodsCode = rs.getInt(1);
				//굿즈코드로 GoodsDTO찾기
				goodsDTO = selectByGoodsCode(goodsCode);
				list.add(goodsDTO);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<GoodsDTO> orderByCondition(int orderMethod) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		
		String sql=proFile.getProperty("goods.orderByCondition");//select * from goods join goods_attr using(goods_code) where not is_soldout = 2 order by 
		switch(orderMethod) {
			case 1: sql+= "goods_price"; break;
			case 2: sql+= "goods_price desc"; break;
			case 3: sql+= "goods_view desc"; break;
		}
		GoodsAttrDTO attrDTO = goodsDTO.getGoodsAttrDTO();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				goodsDTO = new GoodsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
				
				//속성을 가져오는 메소드 호출
				
				attrDTO = new GoodsAttrDTO(rs.getInt(1), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
				goodsDTO.setGoodsAttrDTO(attrDTO);
				list.add(goodsDTO);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
}
