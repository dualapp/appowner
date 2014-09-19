package com.appowner.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.Vendor;

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

	@Override
	public void deleteOneServiceRequest(List<ServiceRequest> entitiesToDelete) {
		ListIterator itr=entitiesToDelete.listIterator();
		while(itr.hasNext())
		{
			ServiceRequest v=(ServiceRequest) itr.next();
		sessionFactory.getCurrentSession().delete(v);
		 
	}

	}

	@Override
	public List<ServiceRequest> getListServiceRequest(Integer int_ApartmentId,
			String str_Status, String str_VendorType) {
		if(int_ApartmentId!=null&&str_Status!=null&&str_VendorType!=null)
		{
			if(str_Status.equalsIgnoreCase("All"))
			{
				String query="from ServiceRequest where  Str_VendorType=? AND int_ApartmentId=?";
				
				return sessionFactory.getCurrentSession().createQuery(query).setParameter(0,str_VendorType).setParameter(1, int_ApartmentId).list();
			}
			String query="from ServiceRequest where Str_Status=? AND Str_VendorType=? AND int_ApartmentId=?";
		
			return sessionFactory.getCurrentSession().createQuery(query).setParameter(0, str_Status).setParameter(1,str_VendorType).setParameter(2, int_ApartmentId).list();
			
		}
		 
		return sessionFactory.getCurrentSession().createCriteria(ServiceRequest.class).list();
		 
	}
}
