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
	public void deleteOneServiceRequest(List<ServiceRequest> entitiesToDelete) {
		// TODO Auto-generated method stub
		getRequestScopeDao().deleteOneServiceRequest(entitiesToDelete);
	}
	@Override
	public List<ServiceRequest> getListServiceRequest(String query) {
		return getRequestScopeDao().getListServiceRequest(query);
		 
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
	public List<BookAFacility> getSelectedBookFacility(String query)
			  {
		// TODO Auto-generated method stub
		return getRequestScopeDao().getSelectedBookFacility(query);
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
	@Override
	public void updateStatusOfServiceRequest(Integer int_ServiceRequestId,
			String str_Status,Date dat_OpenDate) {
		getRequestScopeDao().updateStatusOfServiceRequest(int_ServiceRequestId, str_Status, dat_OpenDate) ;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateStatusOfBookFacility(Integer int_FacilityBookId,
			String str_Status) {
		// TODO Auto-generated method stub
		getRequestScopeDao().updateStatusOfBookFacility(int_FacilityBookId, str_Status) ;
	}
	@Override
	public String checkStatusOfServiceRequest(Integer int_ServiceRequestId) {
		// TODO Auto-generated method stub
		return getRequestScopeDao().checkStatusOfServiceRequest(int_ServiceRequestId);
	}
	@Override
	public BookAFacility getOneBookAFacility(Integer bid) {
		// TODO Auto-generated method stub
		return getRequestScopeDao().getOneBookAFacility(bid);
	}
	@Override
	public String checkStatusOfBookFacility(Integer int_FacilityBookId) {
		// TODO Auto-generated method stub
		return getRequestScopeDao().checkStatusOfBookFacility(int_FacilityBookId);
	}
	 
	 
	@Override
	public void updateStatusOfServiceRequest2(Integer int_ServiceRequestId,
			String str_Status, Date dat_CloseDate) {
		getRequestScopeDao().updateStatusOfServiceRequest2(int_ServiceRequestId, str_Status, dat_CloseDate) ;
		
	}
				 
	}
	 

 
