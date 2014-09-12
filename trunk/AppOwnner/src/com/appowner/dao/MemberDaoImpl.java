package com.appowner.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Members;

@Repository
public class MemberDaoImpl  implements MemberDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addmembers(Members m1) {
		getSessionFactory().getCurrentSession().save(m1);
		
	}
	

}
