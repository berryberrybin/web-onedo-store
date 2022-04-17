package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.UserDTO;
import onedo.mvc.exception.AuthenticationException;

public interface UserService {
	
	/**
	 * 회원 가입
	 * */
	UserDTO userJoin(UserDTO userDTO)throws SQLException , AuthenticationException;
	
	
	/**
	 * 로그인 체크
	 * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
	
	
	/**
	 * ID중복여부 체크
	 * @return: true이면 중복이다, false이면 중복아니다
	 *  SELECT ID FROM MEMBER WHERE ID=?
	 * */
     boolean duplicateById(String userId);
	
	
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
