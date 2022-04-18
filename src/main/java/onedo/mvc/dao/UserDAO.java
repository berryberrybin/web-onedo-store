package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.UserDTO;

public interface UserDAO {
	
	
	/**
	 * 회원가입 기능
	 * @return 0이면 가입 실패
	 * */
	int join(UserDTO userDTO) throws SQLException;
	
	/**
	 * 로그인 기능
	 * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;
	
	
	/**
	 * ID중복여부 체크
	 * @return: true이면 중복이다, false이면 중복아니다
	 *  SELECT ID FROM MEMBER WHERE ID=?
	 * */
     boolean idCheck(String userId);
	
	
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
	
	/**
	 * 회원타입변경
	 */
	int userType(String userId, int type);

}
