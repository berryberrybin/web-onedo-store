package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.UserDTO;

public interface UserDAO {
	
	
	/**
	 * 회원가입 기능
	 * @return 1이면 가입 성공, 0이면 가입 실패
	 * */
	int join(UserDTO userDTO) throws SQLException;
	
	
	/**
	 * 로그인 기능
	 * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;
	
	/**
	 * 전체 회원 검색
	 * */
	List<UserDTO> selectAll() throws SQLException;
	
	
	/**
	 * 회원 수정 (해당 ID의 회원 수정)
	 * */
	int update(UserDTO userDTO);
	
	
	/**
	 * 회원 삭제 (해당 ID의 회원 삭제)
	 * */
	int delete(String userId);

}
