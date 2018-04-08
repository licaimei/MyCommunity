package myCommunity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myCommunity.dao.ForumDao;
import myCommunity.entity.Forum;

@Repository
public class ForumDaoImpl implements ForumDao{
	
	@Autowired
	private HibernateTemplate  db;

	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAll() {
		return (List<Forum>) db.find("select distinct f from Forum f left join fetch f.list");
	}
	
	public static void main(String[] args) {
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-beans.xml");
		 ForumDao dao=ctx.getBean(ForumDao.class);
		 /*for(Forum f :dao.findAll()) {
			 if(f.getParentId()==null) {
				 System.out.println(f.getName());
				 for(Forum fd :f.getList()) {
					 System.out.println("\t"+fd.getName());
				 }
			 }
		 }*/
		 
		 System.out.println(dao.findId(1).size());
	}

	@Override
	public List<Forum> findId(int id) {
		
		return (List<Forum>) db.find("from Forum f where f.id=?",id);
	}

}
