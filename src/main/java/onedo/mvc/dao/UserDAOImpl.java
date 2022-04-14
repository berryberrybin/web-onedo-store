package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.UserDTO;
import onedo.mvc.util.DbUtil;

public class UserDAOImpl implements UserDAO {
	private Properties proFile = new Properties();
	
	@Override
	public int join(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		UserDTO dbDTO = null;
		String sql ="insert into Users values(?,?,?,?,?,?,?)";
		
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
		
		String sql ="select * from users where user_id=? and pwd=?";
		UserDTO dbDTO = null;
		
		try {
			con=DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getUserPwd());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dbDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3));
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
		
		String sql =proFile.getProperty("user.select");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserDTO user = new UserDTO(rs.getString(1), rs.getString(2),rs.getString(3)
						,rs.getString(4));
				
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
		   ps = con.prepareStatement("update users set userPwd=?, userName=?, userPhone=?,userAddr=?, birth=?, gender=? where userId=?");
		   
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getUserPwd());
			ps.setString(3, userDTO.getUserName());
			ps.setString(4, userDTO.getUserPhone());
			ps.setString(5, userDTO.getUserAddr());
			ps.setString(6, userDTO.getBirth());
			ps.setString(7, userDTO.getGender());
		   
		   result = ps.executeUpdate();
		   
		  } catch (SQLException e) {
			  e.printStackTrace();
		   
		  } finally {
			  DbUtil.dbClose( ps , con);
		  }
		  
		  return result;
	}

	@Override
	public int delete(String userId) {
		  PreparedStatement ps = null;
		  Connection con =null;
		  int result=0;
		  
		  try {
			   con = DbUtil.getConnection();
			   ps = con.prepareStatement("delete from users where id=?");
			   ps.setString(1, userId);
			   result = ps.executeUpdate();
			   
		  } catch (SQLException e) {
		   e.printStackTrace();
		   
		  } finally {
		   DbUtil.dbClose( ps, con);
		  }
		  return result;
	}
	
	


}
