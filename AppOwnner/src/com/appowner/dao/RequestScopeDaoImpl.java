package com.appowner.dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.primefaces.model.ScheduleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.BookAFacility;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.Vendor;
import com.appowner.model.cls_Event;
import com.appowner.util.Util;

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
		List<ServiceRequest> slist=getSessionFactory().getCurrentSession().createCriteria(ServiceRequest.class).setCacheable(true).list();
		Collections.sort(slist);
		return slist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pool> getPollList() {
		// TODO Auto-generated method stub
		List<Pool> poolList=getSessionFactory().getCurrentSession().createCriteria(Pool.class).setCacheable(true).list();
		System.out.println(poolList+"poollist");
		Collections.sort(poolList);
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
	public List<ServiceRequest> getListServiceRequest(String query) {
		if(query.isEmpty())
		{

			 
			List<ServiceRequest> slist= sessionFactory.getCurrentSession().createQuery("from ServiceRequest where int_ApartmentId=? ").setParameter(0, Util.getAppartmentId()).setCacheable(true).list();
			Collections.sort(slist);
			return slist;
		}
		 
		List<ServiceRequest> slist1= sessionFactory.getCurrentSession().createQuery("from ServiceRequest where int_ApartmentId=? and "+query).setParameter(0, Util.getAppartmentId()).setCacheable(true).list();
		Collections.sort(slist1);
		return slist1;
	}

	@Override
	public void deleteOnefacility(List<BookAFacility> entitiesToDelete) {
		ListIterator itr=entitiesToDelete.listIterator();
		while(itr.hasNext())
		{
			BookAFacility bf=(BookAFacility) itr.next();
		sessionFactory.getCurrentSession().delete(bf);
		 
	}
		
	}

	@Override
	public void updateBookAFacility(BookAFacility bf1) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(bf1);
	}

	@Override
	public List<BookAFacility> getSelectedBookFacility(String query)
			 {
		if(query.isEmpty())
		{

			List<BookAFacility> blist= sessionFactory.getCurrentSession().createQuery("from  BookAFacility where int_ApartmentId=?").setParameter(0, Util.getAppartmentId()).list();
			Collections.sort(blist);
			return blist;
		}
		 
		List<BookAFacility> blist1= sessionFactory.getCurrentSession().createQuery("from  BookAFacility where int_ApartmentId=? and "+query).setParameter(0, Util.getAppartmentId()).list();
		Collections.sort(blist1);
		return blist1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<cls_Event> getEventList() {
		//String hql="select str_EventTitle,dat_StartDate,dat_EndDate,str_UserName from cls_Event";
		return sessionFactory.getCurrentSession().createCriteria(cls_Event.class).setCacheable(true).list();
	}

	@Override
	public void addEvent(cls_Event event) {
		// TODO Auto-generated method stub
		   sessionFactory.getCurrentSession().save(event);
	}

	@Override
	public void updateEvent(cls_Event event) {
		
		 sessionFactory.getCurrentSession().update(event);
	 
		 
	}

	@Override
	public void updateStatusOfServiceRequest(Integer int_ServiceRequestId,
			String str_Status,Date dat_AssignDate) {
		sessionFactory.getCurrentSession().createQuery("update ServiceRequest set Str_Status=? ,dat_AssignDate=? where int_ServiceRequestId=?").setParameter(0, str_Status).setParameter(1, dat_AssignDate).setParameter(2, int_ServiceRequestId).executeUpdate();
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateStatusOfServiceRequest2(Integer int_ServiceRequestId,
			String str_Status,Date dat_CloseDate) {
		sessionFactory.getCurrentSession().createQuery("update ServiceRequest set Str_Status=?,dat_CloseDate=? where int_ServiceRequestId=?").setParameter(0, str_Status).setParameter(1, dat_CloseDate).setParameter(2, int_ServiceRequestId).executeUpdate();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatusOfBookFacility(Integer int_FacilityBookId,
			String str_Status) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("update BookAFacility set Str_Status=? where int_FacilityBookId=?").setParameter(0, str_Status).setParameter(1, int_FacilityBookId).executeUpdate();
	}

	@Override
	public String checkStatusOfServiceRequest(Integer int_ServiceRequestId) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select Str_Status from ServiceRequest where int_ServiceRequestId=?").setParameter(0, int_ServiceRequestId).uniqueResult();
	}

	@Override
	public BookAFacility getOneBookAFacility(Integer bid) {
		// TODO Auto-generated method stub
		return (BookAFacility) sessionFactory.getCurrentSession().get(BookAFacility.class,bid );
	}

	@Override
	public String checkStatusOfBookFacility(Integer int_FacilityBookId) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select Str_Status from BookAFacility where int_FacilityBookId=?").setParameter(0, int_FacilityBookId).uniqueResult();
	}
}

