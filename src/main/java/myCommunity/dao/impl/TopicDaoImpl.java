package myCommunity.dao.impl;

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
import myCommunity.dao.TopicDao;
import myCommunity.entity.Topic;

@Repository
public class TopicDaoImpl implements TopicDao {

	@Autowired
	private HibernateTemplate db;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findAll() {
		return db.execute(new HibernateCallback<List<Topic>>() {
			public List<Topic> doInHibernate(Session sess) throws HibernateException, SQLException {
				return sess.createQuery("from Topic order by updateTime desc").setMaxResults(6).list();
			}
		});
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findForumID(int forumId) {
		
		return (List<Topic>) db.find("from Topic where forumId=? order by updateTime desc ",forumId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> gainTopics(int forumId,Boolean isBest, String title) {
		return db.execute(new HibernateCallback<List<Topic>>() {
			public List<Topic> doInHibernate(Session sess) throws HibernateException, SQLException {
				String hql = "from Topic t where 1=1 and t.forum.id=:forumId and t.isBest=:isBest";
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("forumId", forumId);
				map.put("isBest", isBest);
				if(title!=null && !title.isEmpty()) {
					hql+=" and t.title like :title";
					map.put("title", "%"+title+"%");
				}
				hql+=" order by t.updateTime desc";
				return sess.createQuery(hql).setProperties(map).list();
			}	
		});
	}
	
	@Override
	public List<Topic> gainTopics(int forumId, String title, int pageNum, int pageSize) {
		return db.execute(new HibernateCallback<List<Topic>>() {
			@SuppressWarnings("unchecked")
			public List<Topic> doInHibernate(Session sess) throws HibernateException, SQLException {
				String hql = "from Topic t where 1=1 and t.forum.id=:forumId";
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("forumId", forumId);
				if(title!=null && !title.isEmpty()) {
					hql+=" and t.title like :title";
					map.put("title", "%"+title+"%");
				}
				hql+=" order by t.updateTime desc";
				return sess.createQuery(hql).setProperties(map).setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
			}	
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> gainTopics(int forumId, Boolean isBest, String title, int pageNum, int pageSize) {
		return db.execute(new HibernateCallback<List<Topic>>() {
			public List<Topic> doInHibernate(Session sess) throws HibernateException, SQLException {
				String hql = "from Topic t where 1=1 and t.forum.id=:forumId and t.isBest=:isBest";
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("forumId", forumId);
				map.put("isBest", isBest);
				if(title!=null && !title.isEmpty()) {
					hql+=" and t.title like :title";
					map.put("title", "%"+title+"%");
				}
				hql+=" order by t.updateTime desc";
				return sess.createQuery(hql).setProperties(map).setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
			}	
		});
	}
	
	@Override
	public int fetchTopicRows(Boolean isBest, String title) {
		return db.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session sess) throws HibernateException, SQLException {
				String hql = "select count(t.id) from Topic t where 1=1 and t.isBest=:isBest";
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("isBest", isBest);
				if(title!=null && !title.isEmpty()) {
					hql+=" and t.title like :title";
					map.put("title", "%"+title+"%");
				}
				Number num = (Number) sess.createQuery(hql).setProperties(map).uniqueResult();
				return num.intValue();
			}
		});
	}
	
	@Override
	public int fetchTopicRows(String title) {
		return db.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session sess) throws HibernateException, SQLException {
				String hql = "select count(t.id) from Topic t where 1=1";
				Map<String, Object> map = new HashMap<String, Object>();
				if(title!=null && !title.isEmpty()) {
					hql+=" and t.title like :title";
					map.put("title", "%"+title+"%");
				}
				Number num = (Number) sess.createQuery(hql).setProperties(map).uniqueResult();
				return num.intValue();
			}
		});
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		TopicDao topicDao = ctx.getBean(TopicDao.class);
		for(Topic t :topicDao.gainTopics(3,"测试",1,3)) {
			System.out.println(t.getForum().getId()+"\t"+t.getTitle()+"\t"+t.getUser().getNickname()+"\t"+t.getCommentTimes()+"/"+t.getClicks()+"\t"+t.getUpdateTime());
		}
		
		System.out.println("-------------------------");
		for(Topic t :topicDao.gainTopics(3,true,"")) {
			System.out.println(t.getForum().getId()+"\t"+t.getTitle()+"\t"+t.getUser().getNickname()+"\t"+t.getCommentTimes()+"/"+t.getClicks()+"\t"+t.getUpdateTime());
		}
		
		System.out.println("-------------------------");
		for(Topic t :topicDao.gainTopics(3,false,"测试",1,3)) {
			System.out.println(t.getForum().getId()+"\t"+t.getTitle()+"\t"+t.getUser().getNickname()+"\t"+t.getCommentTimes()+"/"+t.getClicks()+"\t"+t.getUpdateTime());
		}
		System.out.println("-------------------------");
		System.out.println(topicDao.fetchTopicRows(""));
	}
	

}
