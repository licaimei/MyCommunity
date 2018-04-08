package myCommunity.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myCommunity.biz.TopicBiz;
import myCommunity.dao.TopicDao;
import myCommunity.entity.Topic;

@Service
public class TopicBizImpl implements TopicBiz {

	@Autowired
	private TopicDao dao;
	@Override
	public List<Topic> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Topic> findForumID(int forumId) {
		// TODO Auto-generated method stub
		return dao.findForumID(forumId);
	}

	@Override
	public List<Topic> gainTopics(int forumId, String title, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		return dao.gainTopics(forumId, title, pageSize, pageNum);
	}

	@Override
	public List<Topic> gainTopics(int forumId, Boolean isBest, String title) {
		// TODO Auto-generated method stub
		return dao.gainTopics(forumId, isBest, title);
	}

	@Override
	public List<Topic> gainTopics(int forumId, Boolean isBest, String title, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.gainTopics(forumId, isBest, title, pageNum, pageSize);
	}

	@Override
	public int fetchTopicRows(Boolean isBest, String title) {
		// TODO Auto-generated method stub
		return dao.fetchTopicRows(isBest, title);
	}

	@Override
	public int fetchTopicRows(String title) {
		// TODO Auto-generated method stub
		return dao.fetchTopicRows(title);
	}

}
