package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.UserDAO;
import onedo.mvc.dao.UserDAOImpl;
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
	public void delete(String userId) throws SQLException, AuthenticationException {
		int result = dao.delete(userId);
		if(result==0) {
			throw new AuthenticationException("회원정보 삭제에 실패했습니다.");
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

}

