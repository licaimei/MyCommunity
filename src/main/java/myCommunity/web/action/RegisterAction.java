package myCommunity.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import myCommunity.dao.UserDao;
import myCommunity.entity.User;

@Component
@Scope("prototype")
public class RegisterAction {
	
	@Autowired
	private UserDao udao;
	public String register() {
		return "register";
	}
	
	private User user;
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	private String username;
	
	
	public String getUsername() {
		return username;
	}


	public String saveRegister() {
		this.user.setStatus(true);
		this.user.setSignature("还没有个性签名哦");
		//this.user.setGrade(0);
		this.user.setRoleId(1);
		udao.register(user);
		return "login";
	}
	
	public void checkUserName() throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		out.print(udao.checkUsername(this.user.getUsername())==true?false:true);
	}

}
