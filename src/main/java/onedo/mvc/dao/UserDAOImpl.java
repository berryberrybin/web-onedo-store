package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.SalesDTO;
import onedo.mvc.dto.UserDTO;
import onedo.mvc.util.DbUtil;

public class UserDAOImpl implements UserDAO {
	private Properties proFile = DbUtil.getProFile();

	@Override
	public int join(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		UserDTO dbDTO = null;
		String sql ="insert into Users(user_id, user_Pwd, user_Name, user_Phone, user_Addr, birth, gender) values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con=DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getUserPwd());
			ps.setString(3, userDTO.getUserName());
			ps.setString(4, userDTO.getUserPhone());
			ps.setString(5, userDTO.getUserAddr());
			ps.setString(6, userDTO.getBirth());
			ps.setString(7, userDTO.getGender());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}
	
	
	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		String sql ="select user_id,user_pwd,user_name,user_phone,user_addr,birth,gender,user_type from users where user_id=? and user_pwd=?";
		UserDTO dbDTO = null;
		
		try {
			con=DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getUserPwd());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dbDTO = new UserDTO(rs.getString(1),
						rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return dbDTO;
	
	}

	@Override
	public List<UserDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<UserDTO> userList = new ArrayList<UserDTO>();
		//String sql = proFile.getProperty("query.select");
		
		String sql =proFile.getProperty("user.selectAll");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserDTO user = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				
				userList.add(user);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return userList;
	}



	@Override
	public int update(UserDTO userDTO) {
		  PreparedStatement ps = null;
		  Connection con =null;
		  int result=0;
		  
		  try {
		   con = DbUtil.getConnection();
		   ps = con.prepareStatement("update users set user_Pwd=?, user_Name=?, user_Phone=?, user_Addr=?, birth=?, gender=? where user_Id=?");
		   
			ps.setString(1, userDTO.getUserPwd());
			ps.setString(2, userDTO.getUserName());
			ps.setString(3, userDTO.getUserPhone());
			ps.setString(4, userDTO.getUserAddr());
			ps.setString(5, userDTO.getBirth());
			ps.setString(6, userDTO.getGender());
			ps.setString(7, userDTO.getUserId());
		   
		   result = ps.executeUpdate();
		   
		  } catch (SQLException e) {
			  e.printStackTrace();
		   
		  } finally {
			  DbUtil.dbClose( ps , con);
		  }
		  
		  return result;
	}

	@Override
	public boolean idCheck(String userId) {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			boolean result=false;
			String sql="select user_Id from users where user_Id=?";
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				//?가 있다면 개수만큼 setXxx()필요
				ps.setString(1, userId);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					result = true;
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtil.dbClose(rs, ps, con);
			}
			return result;
		}
	


	@Override
	public int userType(String userId, int type) {
		PreparedStatement ps = null;
		Connection con =null;
		String sql = proFile.getProperty("user.typeUpdate");
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, type);
			ps.setString(2, userId);
			
			   
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose( ps , con);
		}
		System.out.println(result);
		return result;
	}

	@Override
	public int dorCheck(String userId) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result= 0;
		String sql="select user_type from users where user_Id=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 개수만큼 setXxx()필요
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	@Override
	public List<SalesDTO> selectMyOrder(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<SalesDTO> myList = new ArrayList<SalesDTO>();
		int num = 0;
		String sql = "select min(goods_Name), min(goods_code), min(order_qty), min(order_date), min(order_price), order_Code, min(orderline_code), count(*) from orders join orderline using(order_code) join goods using(goods_code) where user_id=? group by order_code order by order_code desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				SalesDTO sales = new SalesDTO(
						rs.getString(1),
						rs.getInt(2), 
						rs.getInt(3), 
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7)
						);

				num = rs.getInt(8);
				if(num>1) sales.setGoodsName(sales.getGoodsName()+" 외 "+ (num-1) +"건");
				myList.add(sales);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return myList;
	}

	@Override
	public List<SalesDTO> selectMyOrderLine(String userId, int orderCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<SalesDTO> myList = new ArrayList<SalesDTO>();
		String sql = "select goods_Name, goods_code, order_qty, order_date, order_price, order_Code, orderline_code, goods_price from orders join orderline using(order_code) join goods using(goods_code) where user_id=? and order_code=? order by goods_name";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, orderCode);
			rs = ps.executeQuery();
			while (rs.next()) {
				SalesDTO sales = new SalesDTO(
						rs.getString(1),
						rs.getInt(2), 
						rs.getInt(3), 
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)
						);

				myList.add(sales);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return myList;
	}

	@Override
	public List<QnaDTO> selectMyBoard(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<QnaDTO> myBoard = new ArrayList<QnaDTO>();
		String sql = "select qna_no, goods_code, user_id, qna_subject, qna_content, qna_date, qna_img, qna_pwd from qna_board where user_id=? order by qna_date desc";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				QnaDTO boards = new QnaDTO(
						rs.getInt(1),
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
						);

				myBoard.add(boards);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return myBoard;
	}
		
	
	

}
