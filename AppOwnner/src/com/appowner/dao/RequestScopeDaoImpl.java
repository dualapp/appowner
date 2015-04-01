package com.appowner.dao;

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
		return (List<ServiceRequest>)getSessionFactory().getCurrentSession().createCriteria(ServiceRequest.class).setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pool> getPollList() {
		// TODO Auto-generated method stub
		List<Pool> poolList=getSessionFactory().getCurrentSession().createCriteria(Pool.class).setCacheable(true).list();
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
			String str_Status, String str_VendorType,Date dat_ToDate) {
		if(int_ApartmentId!=null&&str_Status!=null&&str_VendorType!=null)
		{
			if(str_Status.equalsIgnoreCase("All"))
			{
				String query="from ServiceRequest where  Str_VendorType=? AND int_ApartmentId=? AND dat_OpenDate=?";
				
				return sessionFactory.getCurrentSession().createQuery(query).setCacheable(true).setParameter(0,str_VendorType).setParameter(1, int_ApartmentId).setParameter(2, dat_ToDate).list();
			}
			String query="from ServiceRequest where Str_Status=? AND Str_VendorType=? AND int_ApartmentId=? AND dat_OpenDate=?";
		
			return sessionFactory.getCurrentSession().createQuery(query).setCacheable(true).setParameter(0, str_Status).setParameter(1,str_VendorType).setParameter(2, int_ApartmentId).setParameter(3, dat_ToDate).list();
			
		}
		 
		return sessionFactory.getCurrentSession().createQuery("from ServiceRequest where int_ApartmentId=? ").setParameter(0, int_ApartmentId).setCacheable(true).list();
		 
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
	public List<BookAFacility> getSelectedBookFacility(
			Integer int_ApartmentId, String str_Status, Date str_OpenDate,
			String str_FacilityType,String str_EventType) {
		if(int_ApartmentId!=null&&str_Status!=null&&str_OpenDate!=null&&str_FacilityType!=null&&str_EventType!=null)
		{
			if(str_Status.equalsIgnoreCase("All"))
			{
				String query="from BookAFacility where  str_FacilityType=? AND int_ApartmentId=? AND str_OpenDate=? AND str_EventType=? ";
				
				return sessionFactory.getCurrentSession().createQuery(query).setParameter(0,str_FacilityType).setParameter(1, int_ApartmentId).setParameter(2,str_OpenDate).setParameter(3, str_EventType).list();
			}
			String query="from BookAFacility where Str_Status=? AND str_FacilityType=? AND int_ApartmentId=? AND dat_OpenDate=? AND str_EventType=?";
		
			return sessionFactory.getCurrentSession().createQuery(query).setParameter(0, str_Status).setParameter(1,str_FacilityType).setParameter(2, int_ApartmentId).setParameter(3, str_OpenDate).setParameter(4, str_EventType).list();
			
		}
		 
		return sessionFactory.getCurrentSession().createQuery("from  BookAFacility where int_ApartmentId=?").setParameter(0, int_ApartmentId).setCacheable(true).list();
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
			String str_Status) {
		sessionFactory.getCurrentSession().createQuery("update ServiceRequest set Str_Status=? where int_ServiceRequestId=?").setParameter(0, str_Status).setParameter(1, int_ServiceRequestId).executeUpdate();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatusOfBookFacility(Integer int_FacilityBookId,
			String str_Status) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("update BookAFacility set Str_Status=? where int_FacilityBookId=?").setParameter(0, str_Status).setParameter(1, int_FacilityBookId).executeUpdate();
	}
}

