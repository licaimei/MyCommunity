package myCommunity.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myCommunity.dao.UserDao;
import myCommunity.entity.User;


@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateTemplate db;
	 

	@Override
	public User checkLogin(String username, String password) {
		List<User> user = (List<User>) db.find("from User where username=? and password=?",username,password);
		return user.size()>0?user.get(0):null;
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-beans.xml");
		UserDao dao=ctx.getBean(UserDao.class);
		System.out.println(dao.checkLogin("jack","123").getNickname());
		
		User user=new User(1,"sss","sss","sss", "sss","sss",1000,1,true);
		//dao.register(user);
		dao.update(user);
	}



	@Override
	public void register(User user) {
			db.save(user);
		
	}


	@Override
	public boolean checkUsername(String username) {
		List<User> list = (List<User>) db.find("from User u where u.username=?", username);
		return list.size()>0;
	}



	@Override
	public int update(User user) {
		return db.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session sess) throws HibernateException, SQLException {
				return sess.createQuery("update User u set u.nickname=?,u.password=?,u.signature=? where u.id=?")
						.setString(0, user.getNickname())
						.setString(1, user.getPassword())
						.setString(2, user.getSignature())
						.setInteger(3, user.getId()).executeUpdate();				
			}
		});
	}

}
