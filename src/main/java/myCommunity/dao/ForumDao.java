package myCommunity.dao;

import java.util.List;

import myCommunity.entity.Forum;


public interface ForumDao {
	
	List<Forum> findAll();
	
	List<Forum> findId(int id);
	
	

}
