package com.app.db;
import org.hibernate.SessionFactory;

public class DBUtils {
	private SessionFactory sessionFactory;
		
	public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		
	}


