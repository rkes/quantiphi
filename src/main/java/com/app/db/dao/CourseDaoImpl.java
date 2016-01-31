package com.app.db.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.app.db.Entity.Course;

public class CourseDaoImpl  {

	
	private Session session;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		

	

	public void addEntry(Course p) {
		session=getSessionFactory().getCurrentSession();
		session.save(p);
	}

	public List<Course> getCourse(String course) {
		session=getSessionFactory().getCurrentSession();
		Query query=session.createQuery("from Course where title = :course");
		query.setParameter("course", course);
		List lst=query.list();
		return lst;
	}
	public String getCount() {
		session=getSessionFactory().getCurrentSession();
		//Query query=session.createQuery("from Course where title = :course");
		
		Long count= (Long)session.createCriteria(Course.class).setProjection(Projections.rowCount()).uniqueResult();
		return new String(count+"");
		//return lst;
	}
}
