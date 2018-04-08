package myCommunity.web.action;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import myCommunity.dao.CommentDao;
import myCommunity.entity.Comment;
import myCommunity.entity.Topic;
import myCommunity.entity.User;

@Component
@Scope("prototype")
public class CommentAction {
	
	@Autowired
	private CommentDao cdao;
	
	private Topic topic;
	private int id;		
	private List<Comment> comments;
	//private int referenceId;
	private int pageSize;
	private int pageNum;
	private int totalPages;	
	private Comment comment;
		
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String comment() {
		//推送数据过去页面
		this.pageNum=this.pageNum==0?1:this.pageNum;
		if(this.pageNum>1){
			this.pageSize=5;
		}else {
			this.pageSize=4;
		}
		this.topic=cdao.findSingle(id);
		int rows=cdao.fetchRow(id);
		this.totalPages=rows%this.pageSize==0?rows/this.pageSize:rows/this.pageSize+1;
		this.comments=cdao.findAll(id,pageNum, pageSize);
		return "comment";
	}
	
	
	public String publish() throws UnknownHostException {
		InetAddress address=InetAddress.getLocalHost();
		HttpServletRequest req=ServletActionContext.getRequest();
		this.comment.setiP(address.getHostAddress());
		this.comment.setStatus(1);
		this.comment.setCommentTime(new Date(System.currentTimeMillis()));
		this.comment.setCommentType(1);
		User user=new User();
		//
		cdao.add(comment);
		return "comment";
	}

}
