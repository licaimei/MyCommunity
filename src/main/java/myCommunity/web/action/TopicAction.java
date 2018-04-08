package myCommunity.web.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import myCommunity.biz.TopicBiz;
import myCommunity.entity.Topic;

@Component
@Scope("prototype")
public class TopicAction {
	
	private Integer pageNum;
	private int pageSize = 5;
	private int totalPages;
	private int forumId;
	private String title;
	
	private List<Topic> topics;
	private List<Topic> elitetopics;
	private List<Topic> generaltopics;
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public List<Topic> getElitetopics() {
		return elitetopics;
	}
	public List<Topic> getGeneraltopics() {
		return generaltopics;
	}
	@Autowired
	private TopicBiz topicBiz;
	
	public String list() {
		int rows = topicBiz.fetchTopicRows(this.title);
		int generalrows = topicBiz.fetchTopicRows(false, title);
		this.totalPages = rows%this.pageSize==0?rows/this.pageSize:rows/this.pageSize+1;
		this.totalPages = generalrows%this.pageSize==0?generalrows/this.pageSize:generalrows/this.pageSize+1;
		this.topics = topicBiz.gainTopics(this.forumId, title, this.pageNum==null?1:this.pageNum, this.pageSize);
		this.elitetopics = topicBiz.gainTopics(this.forumId,true, title);
		this.generaltopics = topicBiz.gainTopics(this.forumId,false, title, this.pageNum==null?1:this.pageNum, pageSize);
		return "topic-list";
	}

}
