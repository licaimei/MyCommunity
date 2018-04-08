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
@Table(name = "CommunityTopic")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private Date createTime;
	private int forumId;
	private int authorId;
	private String iP;
	private int commentTimes;
	private Date updateTime;
	private int clicks;
	private Boolean isBest;

	@ManyToOne
	@JoinColumn(name = "AuthorId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "ForumId")
	private Forum forum;

	@Column(name = "`status`")
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getiP() {
		return iP;
	}

	public void setiP(String iP) {
		this.iP = iP;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public int getCommentTimes() {
		return commentTimes;
	}

	public void setCommentTimes(int commentTimes) {
		this.commentTimes = commentTimes;
	}

	public Boolean getIsBest() {
		return isBest;
	}

	public void setIsBest(Boolean isBest) {
		this.isBest = isBest;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Topic(int id, String title, String content, Date createTime, int forumId, int authorId, String iP,
			int commentTimes, Date updateTime, int clicks, Boolean isBest, int status) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.forumId = forumId;
		this.authorId = authorId;
		this.iP = iP;
		commentTimes = commentTimes;
		this.updateTime = updateTime;
		this.clicks = clicks;
		this.isBest = isBest;
		this.status = status;
	}

	public Topic() {
	}

}
