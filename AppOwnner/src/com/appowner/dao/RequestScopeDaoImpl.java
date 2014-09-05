package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;

@Repository
public class RequestScopeDaoImpl implements RequestScopeDao {
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
	public List<ServiceRequest> getListServiceRequest() {
		// TODO Auto-generated method stub
		return (List<ServiceRequest>)getSessionFactory().getCurrentSession().createCriteria(ServiceRequest.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pool> getPollList() {
		// TODO Auto-generated method stub
		List<Pool> poolList=getSessionFactory().getCurrentSession().createCriteria(Pool.class).list();
		System.out.println(poolList+"poollist");
		return poolList;
	}

	@Override
	public ServiceRequest getOneServiceRequest(Integer serviceRequestId) {
		// TODO Auto-generated method stub
		return (ServiceRequest) getSessionFactory().getCurrentSession().get(ServiceRequest.class, serviceRequestId);
	}

	@Override
	public void updateOneServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(serviceRequest);
	}

	@Override
	public void deleteOneServiceRequest(ServiceRequest servicerequest1) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(servicerequest1);
	}

	@Override
	public void updateStatusOfServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(serviceRequest);
	}

}
