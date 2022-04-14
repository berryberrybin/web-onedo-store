package onedo.mvc.dto;

public class UserDTO {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String userAddr;
	private String birth;
	private String gender;
	
	public UserDTO() {}

	public UserDTO(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	public UserDTO(String userId, String userPwd, String userPhone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userPhone = userPhone;
	}
	
	
	public UserDTO(String userId, String userName, String userPhone, String birth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.birth = birth;
	}

	public UserDTO(String userId, String userPwd, String userName, String userPhone, String userAddr, String birth,
			String gender) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
		this.birth = birth;
		this.gender = gender;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
