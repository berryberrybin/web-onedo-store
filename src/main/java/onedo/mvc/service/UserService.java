package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.UserDTO;
import onedo.mvc.exception.AuthenticationException;

public interface UserService {
	
	/**
	 * 회원 가입
	 * */
	void userJoin(UserDTO userDTO)throws SQLException , AuthenticationException;
	
	
	/**
	 * 로그인 체크(아이디 중복)
	 * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
	
	/**
	 * 전체 회원 검색
	 * */
	List<UserDTO> selectAll() throws SQLException;
	
	/**
	 * 회원 수정 (해당 ID의 회원 수정)
	 * @return 
	 * */
	void update(UserDTO userDTO) throws SQLException, AuthenticationException;
	
	
	/**
	 * 회원 삭제 (해당 ID의 회원 삭제)
	 * */
	void delete(String userId) throws SQLException, AuthenticationException;

	


}
