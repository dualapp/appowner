package com.appowner.service;

import java.util.Date;
import java.util.List;

import org.primefaces.model.ScheduleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.RequestScopeDao;
import com.appowner.model.BookAFacility;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.cls_Event;

@Service("RequestScopeService")
@Transactional
public class RequestScopeServiceImpl implements RequestScopeService{

	@Autowired
	private RequestScopeDao requestScopeDao;
	public RequestScopeDao getRequestScopeDao() {
		return requestScopeDao;
	}
	public void setRequestScopeDao(RequestScopeDao requestScopeDao) {
		this.requestScopeDao = requestScopeDao;
	}
	@Override
	public List<ServiceRequest> getListServiceRequest() {
		// TODO Auto-generated method stub
		return getRequestScopeDao().getListServiceRequest();
	}
	@Override
	public List<Pool> getPollList() {
		// TODO Auto-generated method stub
		System.out.println("HIIIIIIIIIIIIIIIII");
		return getRequestScopeDao().getPollList();
	}
	@Override
	public ServiceRequest getOneServiceRequest(Integer serviceRequestId) {
		// TODO Auto-generated method stub
		return getRequestScopeDao().getOneServiceRequest(serviceRequestId);
	}
	@Override
	public void updateOneServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		getRequestScopeDao().updateOneServiceRequest(serviceRequest);
	}
	@Override
	public void deleteOneServiceRequest(ServiceRequest servicerequest1) {
		// TODO Auto-generated method stub
		getRequestScopeDao().deleteOneServiceRequest(servicerequest1);
	}
	@Override
	public void updateStatusOfServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		getRequestScopeDao().updateStatusOfServiceRequest(serviceRequest);
	}
	@Override
	public void deleteOneServiceRequest(List<ServiceRequest> entitiesToDelete) {
		// TODO Auto-generated method stub
		getRequestScopeDao().deleteOneServiceRequest(entitiesToDelete);
	}
	@Override
	public List<ServiceRequest> getListServiceRequest(Integer int_ApartmentId,
			String str_Status, String str_VendorType,Date dat_ToDate) {
		return getRequestScopeDao().getListServiceRequest( int_ApartmentId,
				str_Status,  str_VendorType,dat_ToDate);
		 
	}
	@Override
	public void deleteOnefacility(List<BookAFacility> entitiesToDelete) {
		// TODO Auto-generated method stub
		getRequestScopeDao().deleteOnefacility(entitiesToDelete);
	}
	@Override
	public void updateBookAFacility(BookAFacility bf1) {
		// TODO Auto-generated method stub
		getRequestScopeDao().updateBookAFacility(bf1);
	}
	@Override
	public List<BookAFacility> getSelectedBookFacility(
			Integer int_ApartmentId, String str_Status, Date str_Period,
			String str_FacilityType,String str_EventType) {
		// TODO Auto-generated method stub
		return getRequestScopeDao().getSelectedBookFacility(
				int_ApartmentId,   str_Status,   str_Period,
				  str_FacilityType,str_EventType);
	}
	@Override
	public List<cls_Event> getEventList() {
		// TODO Auto-generated method stub
		return getRequestScopeDao().getEventList();
	}
	@Override
	public void addEvent(cls_Event event) {
		// TODO Auto-generated method stub
		  getRequestScopeDao().addEvent(event);
	}
	@Override
	public void updateEvent(cls_Event event) {
		// TODO Auto-generated method stub
		  getRequestScopeDao().updateEvent(event);
	}
	 

}
