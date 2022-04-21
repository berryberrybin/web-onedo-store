package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.UserDAO;
import onedo.mvc.dao.UserDAOImpl;
import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.SalesDTO;
import onedo.mvc.dto.UserDTO;
import onedo.mvc.exception.AuthenticationException;

public class UserServiceImpl implements UserService {
	private UserDAO dao = new UserDAOImpl();
	
	@Override
	public void userJoin(UserDTO userDTO) throws SQLException, AuthenticationException {
		int result = dao.join(userDTO);
		if(result==0) {
			throw new AuthenticationException("회원 가입에 실패했습니다.");
		}
	}
	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
		UserDTO dbDTO = dao.loginCheck(userDTO);
		if(dbDTO==null) {
			throw new AuthenticationException("회원 정보를 다시 입력해주세요");
		}

		return dbDTO;
	}

	@Override
	public List<UserDTO> selectAll() throws SQLException {
		List<UserDTO> list = dao.selectAll();
		
		return list;
	}

	@Override
	public void update(UserDTO userDTO) throws SQLException, AuthenticationException {
		int result = dao.update(userDTO);
		if(result==0) {
			throw new AuthenticationException("회원정보 수정에 실패했습니다.");
		}

	}

	@Override
	public boolean idCheck(String userId) throws SQLException, AuthenticationException {
		boolean result = dao.idCheck(userId);
		if(result==false) {
			throw new AuthenticationException("중복 확인에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int typeUpdate(String userId, String userType) throws Exception {
		int type;
		if(userType.equals("정지")) {
			type = 2;
		}else{
			type = 1;
		}
		int result = dao.userType(userId, type);
		return result;
	}

	
	@Override
	public void dorCheck(String userId) throws SQLException, AuthenticationException {
		int result = dao.dorCheck(userId);
		if(result==2) {
			throw new AuthenticationException("휴면 회원으로 전환되었습니다. 관리자에게 문의하세요.");
		}
		
	}

	@Override
	public List<SalesDTO> selectMyOrder(String userId) throws SQLException {
		List<SalesDTO> myList = dao.selectMyOrder(userId);
		return myList;
	}
	
	@Override
	public List<SalesDTO> selectMyOrder(String userId, int pageNo) throws SQLException {
		List<SalesDTO> myList = dao.selectMyOrder(userId, pageNo);
		return myList;
	}

	@Override
	public List<SalesDTO> selectMyOrderLine(String userId, int orderCode) throws SQLException {
		List<SalesDTO> myList = dao.selectMyOrderLine(userId, orderCode);
		return myList;
	}

	@Override
	public List<QnaDTO> selectMyBoard(String userId) throws SQLException {
		List<QnaDTO> myBoard = dao.selectMyBoard(userId);
		return myBoard;
	}


	
}

