package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.RequestScopeDao;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;

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

}
