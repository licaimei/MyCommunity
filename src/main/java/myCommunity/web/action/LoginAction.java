package myCommunity.web.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import myCommunity.dao.UserDao;
import myCommunity.entity.User;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class LoginAction extends ActionSupport{
	
	@Autowired
	private  UserDao  dao;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private String message;
	public String getMessage() {
		return message;
	}

	public String login() {
		return "login";
	}
	
	private File headImage;					//上传的文件，属性名与input的name一致
	private String headImageFileName;		//上传文件的原文件名，注意命名规则
	private String headImageContentType;	//上传文件的内容类型mime类型
		
	public void setHeadImage(File headImage) {
		this.headImage = headImage;
	}

	public void setHeadImageFileName(String headImageFileName) {
		this.headImageFileName = headImageFileName;
	}

	public void setHeadImageContentType(String headImageContentType) {
		this.headImageContentType = headImageContentType;
	}

	public String checkLogin() {
		User loginUser=dao.checkLogin(user.getUsername(),user.getPassword());
		if(loginUser!=null) {
			HttpServletRequest req = ServletActionContext.getRequest();
      	    req.getSession().setAttribute("loginUser", loginUser);   	    
			return "index";
		}else {
			this.message = "用户名或密码有误";
			return "login";
		}
	}
	
	//销毁session
	public String remove() {
		HttpServletRequest req = ServletActionContext.getRequest();
		req.getSession().removeAttribute("loginUser");
		req.getSession().invalidate();
		return "index";				 
	}
	
	/*//个人资料
	public String person() {
		return "person";
	}*/
	
	/*修改个人资料*/
	public String update() throws IOException {
		
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession sess = req.getSession();
		if(dao.update(this.user)>0) {
			this.message = "修改成功，请您重新登录！";
			sess.setAttribute("message", this.message);
			sess.setMaxInactiveInterval(2);
			if(this.headImage!=null) {
      	    	String vPath = "/headImages/"+user.getId()+".jpg";
    			String path = ServletActionContext.getRequest().getServletContext().getRealPath(vPath);
    			File destFile = new File(path);
    			FileUtils.copyFile(this.headImage, destFile);
      	    }
			return "login";
		}else {
			this.message = "修改失败！";
			sess.setAttribute("message", this.message);
			return "person";
		}
	}
	

}
