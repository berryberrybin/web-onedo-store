package onedo.mvc.dao;

import java.sql.SQLException;

import onedo.mvc.dto.UserDTO;

public interface UserDAO {
	
	/**
	 * 로그인 기능
	 * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;

}
