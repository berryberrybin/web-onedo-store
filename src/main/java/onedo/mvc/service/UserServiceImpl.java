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
	public int userJoin(UserDTO userDTO) throws SQLException, AuthenticationException {
		int result = dao.join(userDTO);
		if(result==0) {
			throw new AuthenticationException("회원 가입에 실패했습니다.");
		}

		return result;
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
	public int update(UserDTO userDTO) {
		int result = dao.update(userDTO);
		return result;
	}

	@Override
	public int delete(String userId) {
		int result = dao.delete(userId);
		return result;
	}


}