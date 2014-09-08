package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.ServiceRequest;

@Repository
public class ServiceRequestDaoImpl  implements ServiceRequestDao{
	@Autowired
	 private SessionFactory sessionFactory;
	 
	
	 

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}




	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceRequest> getServiceRequestList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(ServiceRequest.class).list();
	}
}
