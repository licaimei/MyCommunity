package myCommunity.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CommunityComment")
public class Comment {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
	private Date commentTime;
	private String iP;
	private int commentType;
	private int status;
	
	@ManyToOne
	@JoinColumn(name="ReferenceId")
    private Topic topic;
	
	@ManyToOne
	@JoinColumn(name="CommenterId")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getiP() {
		return iP;
	}

	public void setiP(String iP) {
		this.iP = iP;
	}

	public int getCommentType() {
		return commentType;
	}

	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment(int id, String content, Date commentTime, String iP, int commentType, int status, Topic topic,
			User user) {
		super();
		this.id = id;
		this.content = content;
		this.commentTime = commentTime;
		this.iP = iP;
		this.commentType = commentType;
		this.status = status;
		this.topic = topic;
		this.user = user;
	}

	public Comment() {}
	
	
}
