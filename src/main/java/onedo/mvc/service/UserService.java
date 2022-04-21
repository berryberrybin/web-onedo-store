package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.SalesDTO;
import onedo.mvc.dto.UserDTO;
import onedo.mvc.exception.AuthenticationException;

public interface UserService {
	
	/**
	 * 회원 가입
	 * */
	void userJoin(UserDTO userDTO)throws SQLException , AuthenticationException;
	
	
	/**
	 * 로그인 체크 (휴면 회원이라면 로그인 불가능하게)
	 * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
	
	
	/**
	 * ID중복여부 체크
	 * @return: true이면 중복이다, false이면 중복아니다
	 *  SELECT ID FROM MEMBER WHERE ID=?
	 * */
     boolean idCheck(String userId) throws SQLException, AuthenticationException;
	
     /**
      * 휴면 회원 여부 체크
      * */
     void dorCheck(String userId) throws SQLException, AuthenticationException;
     
	
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
	 * 유저타입변경
	 */
	int typeUpdate(String userId, String userType) throws Exception;

	
	/**
	 * 마이페이지 
	 * @param userId 
	 * */
	List<SalesDTO> selectMyOrder(String userId) throws SQLException;
	
	
	/**
	 * 마이페이지 주문 상세페이지
	 * */
	List<SalesDTO> selectMyOrderLine(String userId, int orderCode) throws SQLException;
	
	
	/**
	 * 마이페이지 내가 쓴 글 조회
	 * */
	List<QnaDTO> selectMyBoard(String userId) throws SQLException;

	
}
