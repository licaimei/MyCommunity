package myCommunity.dao;

import myCommunity.entity.User;

public interface UserDao {
	
	
	User checkLogin(String username,String password);
	
	void register(User user);
	
	boolean checkUsername(String username);
	
	int update(User user);

}
