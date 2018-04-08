package myCommunity.dao;

import java.util.List;

import myCommunity.entity.Topic;

public interface TopicDao {
	
	List<Topic> findAll();
	
	List<Topic> findForumID(int forumId);
	
	
	List<Topic> gainTopics(int forumId,String title,int pageSize,int pageNum);
	
	List<Topic> gainTopics(int forumId, Boolean isBest, String title);
	
	List<Topic> gainTopics(int forumId, Boolean isBest, String title, int pageNum, int pageSize);
	
	int fetchTopicRows(Boolean isBest,String title);
	
	int fetchTopicRows(String title);
	
}
