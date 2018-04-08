package myCommunity.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import myCommunity.dao.CommentDao;
import myCommunity.entity.Comment;
import myCommunity.entity.Topic;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private HibernateTemplate db;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll(int referenceId, int pageNum, int pageSize) {		
		return db.execute(new HibernateCallback<List<Comment>>() {
			public List<Comment> doInHibernate(Session sess) throws HibernateException, SQLException {
				String hql = "from Comment c where c.commentType=1 and c.topic.id=? or c.commentType=2 and c.topic.id=?";
				hql+="order by c.id,c.commentType,c.commentTime asc";
				return sess.createQuery(hql).setInteger(0, referenceId).setInteger(1, referenceId).setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
			}
		});
	}
	
	@Override
	public int fetchRow(int referenceId) {
		return db.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session sess) throws HibernateException, SQLException {
				String hql="select count(c.id) from Comment c where c.topic.id=?";
				Number num=(Number) sess.createQuery(hql).setInteger(0, referenceId).uniqueResult();
				return num.intValue();
			}
			
			
		});
	}
	

	public Topic findSingle(int id) {
		return db.get(Topic.class, id);
	}
	
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-beans.xml");
		CommentDao dao=ctx.getBean(CommentDao.class);
		/*for(Comment c :dao.findAll(1, 1, 10)) {
			System.out.println(c.getUser().getNickname());
		}
			
		System.out.println(dao.fetchRow(1));*/
		
		System.out.println(dao.findSingle(2).getTitle());
		
		//Comment comment=new Comment(0,"持反对态度",new Date(System.currentTimeMillis()),"1111", commentType, status, topic, user)
	}

	@Override
	public void add(Comment comment) {
		db.save(comment);
		
	}




	
}
