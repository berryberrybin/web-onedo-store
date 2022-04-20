package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import onedo.mvc.dto.SalesDTO;
import onedo.mvc.util.DbUtil;

public class SalesDAOImpl implements SalesDAO {

	@Override
	public List<SalesDTO> selectAll() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<SalesDTO> salesList = new ArrayList<SalesDTO>();

		String sql = "select order_code, orderline_code, goods_name, goods_price, order_qty, user_id, order_date, order_price from orders join orderline using(order_code)join goods using(goods_code)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				SalesDTO sales = new SalesDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getInt(8));
				salesList.add(sales);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return salesList;
	}

	@Override
	public List<SalesDTO> selectGroupByGoodsCode() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<SalesDTO> salesList = new ArrayList<SalesDTO>();

		String sql = "select b.goods_name, a.goods_code, sum(order_qty) from orderline a join goods b on a.goods_code=b.goods_code group by a.goods_code, b.goods_name";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				SalesDTO sales = new SalesDTO(rs.getString(1), rs.getInt(2), rs.getInt(3));
				salesList.add(sales);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return salesList;
	}

	@Override
	public List<SalesDTO> selectGroupByOrderDate() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<SalesDTO> salesList = new ArrayList<SalesDTO>();

		String sql ="select * from (select To_char(order_date,'YYYYMMDD'), sum(order_price) from orders group by To_char(order_date,'YYYYMMDD') order by To_char(order_date,'YYYYMMDD') desc) where rownum <= 10"; 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				SalesDTO sales = new SalesDTO(rs.getString(1), rs.getInt(2));
				salesList.add(sales);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return salesList;
	}
}
