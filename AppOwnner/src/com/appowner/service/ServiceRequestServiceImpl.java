package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ServiceRequestDao;
import com.appowner.model.ServiceRequest;

@Service("RequestService")
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {
	@Autowired
	private ServiceRequestDao serviceRequestDao;

	public ServiceRequestDao getServiceRequestDao() {
		return serviceRequestDao;
	}

	public void setServiceRequestDao(ServiceRequestDao serviceRequestDao) {
		this.serviceRequestDao = serviceRequestDao;
	}

	@Override
	public List<ServiceRequest> getServiceRequestList() {
		// TODO Auto-generated method stub
		return getServiceRequestDao().getServiceRequestList();
	}
}
