package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.SalesDTO;
import onedo.mvc.util.DbUtil;

public class SalesDAOImpl implements SalesDAO {
	private Properties proFile = DbUtil.getProFile();
	
	@Override
	public List<SalesDTO> selectAll() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<SalesDTO> salesList = new ArrayList<SalesDTO>();

		String sql = "select goods_code, goods_price, order_qty, user_id, order_date, order_price from orders join orderline using(order_code)join goods using(goods_code)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				SalesDTO sales = new SalesDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
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
