package myCommunity.dao;

import java.util.List;

import myCommunity.entity.Comment;
import myCommunity.entity.Topic;

public interface CommentDao {
	
	List<Comment> findAll(int referenceId, int pageNum, int pageSize);

	Topic findSingle(int id);
	
	int fetchRow(int referenceId);
	
	void add(Comment comment);
}
