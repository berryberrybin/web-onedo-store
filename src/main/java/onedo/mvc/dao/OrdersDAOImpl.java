package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import onedo.mvc.dto.OrdersDTO;
import onedo.mvc.util.DbUtil;

public class OrdersDAOImpl implements OrdersDAO {
	private Properties proFile = new Properties();
	@Override
	public int orders(OrdersDTO ordersDTO) throws Exception {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = proFile.getProperty("survey.select");
		
		try {
			con=DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

}
