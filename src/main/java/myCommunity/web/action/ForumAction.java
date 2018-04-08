package myCommunity.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import myCommunity.dao.ForumDao;
import myCommunity.dao.TopicDao;
import myCommunity.entity.Forum;
import myCommunity.entity.Topic;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class ForumAction extends ActionSupport {
	
	@Autowired
	private ForumDao fdao;
	
	@Autowired
	private TopicDao dao;
	
	private List<Forum> forums;
	private List<Topic> topics;
	
	public List<Forum> getForums() {
		return forums;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	
	public String index() {
		 this.forums=fdao.findAll();
		 this.topics=dao.findAll();
		 return "index";
	}

}
