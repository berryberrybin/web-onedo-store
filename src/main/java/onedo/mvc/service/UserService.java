package onedo.mvc.service;

import java.sql.SQLException;

import onedo.mvc.dto.UserDTO;
import onedo.mvc.exception.AuthenticationException;

public interface UserService {
	
	/**
	 * 로그인 체크
	 * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;

}
