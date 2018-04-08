package myCommunity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CommunityUser")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String nickname;
	
	@Column(name="`password`")
	private String password;
	private String signature;
	private String email;
	private int grade;
    private int roleId;
    
    @Column(name="`status`")
    private boolean  status;
    
    public User() {}
	public User(int id, String username, String nickname, String password, String signature, String email, int grade,
			int roleId, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.signature = signature;
		this.email = email;
		this.grade = grade;
		this.roleId = roleId;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
    
    

}
