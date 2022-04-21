package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.CartItemDTO;
import onedo.mvc.dto.OrderLineDTO;
import onedo.mvc.dto.OrdersDTO;
import onedo.mvc.util.DbUtil;

public class OrdersDAOImpl implements OrdersDAO {
	private Properties proFile = DbUtil.getProFile();

	@Override
	public int ordersInsert(OrdersDTO ordersDTO, CartDTO cartDTO) throws Exception {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = proFile.getProperty("order.ordersInsert");
		//insert into orders(order_code, state_no, user_id, order_date, order_addr, order_phone, order_price) values(order_code_seq.nextval, 0, ?, CURRENT_DATE, ?, ?, ?)
		try {
			con=DbUtil.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ordersDTO.getUserId());
			ps.setString(2, ordersDTO.getOrderAddr());
			ps.setString(3, ordersDTO.getOrderPhone());
			ps.setInt(4, ordersDTO.getOrderPrice());
			
			result = ps.executeUpdate();
			if(result==0) {
				   con.rollback();
				   throw new SQLException("주문 실패...");
			}else {
				int re [] = orderLineInsert(con, cartDTO); //주문상세 등록하기 
				for(int i : re) {
					if(i != 1) {//
					con.rollback();
					throw new SQLException("주문 할수 없습니다....");
					}
				}
			}
			
			decrementStock(con, cartDTO);
			con.commit();
		}finally {
			con.commit();
			DbUtil.dbClose(ps, con);
		}

		return result;
	}
	
	/**
	 * orderLine저장
	 */
	public int[] orderLineInsert(Connection con  , CartDTO cartDTO) throws SQLException{
		PreparedStatement ps =null;
		String sql = proFile.getProperty("order.ordersLineInsert");
		//insert into orderline(orderlinde_code, order_code, goods_code, order_qty) values(orderline_code_seq.nextval, order_code_seq.currval, ?, ?)
		int result [] =null;
		try {
			ps = con.prepareStatement(sql);
			for(CartItemDTO cartItemDTO : cartDTO.getCartItemList()) {
				ps.setInt(1, cartItemDTO.getGoods().getGoodsCode());
				ps.setInt(2, cartItemDTO.getAmount());
				ps.addBatch();
				ps.clearParameters();
			}
			result = ps.executeBatch();
		} finally {
			DbUtil.dbClose(ps , null);
		}
		return result;
	}
	
	/**
	 * 재고량 감소시키키
	 * */
	public int[] decrementStock(Connection con , CartDTO cartDTO)throws SQLException {
		PreparedStatement ps=null;
		String sql = proFile.getProperty("order.decrementStock");
		int result [] =null;
		try {
			ps = con.prepareStatement(sql);
			for(CartItemDTO cartItemDTO : cartDTO.getCartItemList()) {
				ps.setInt(1, cartItemDTO.getAmount());
				ps.setInt(2, cartItemDTO.getGoods().getGoodsCode());

				ps.addBatch(); //일괄처리할 작업에 추가
				ps.clearParameters();
			}
		  
			result = ps.executeBatch();//일괄처리
		}finally {
			DbUtil.dbClose(ps , null);
		}
			
		return result;
	}
}
