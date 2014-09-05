package com.appowner.dao;

import java.util.List;

import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;

public interface RequestScopeDao {

	List<ServiceRequest> getListServiceRequest();

	List<Pool> getPollList();

	ServiceRequest getOneServiceRequest(Integer serviceRequestId);

	void updateOneServiceRequest(ServiceRequest serviceRequest);

	void deleteOneServiceRequest(ServiceRequest servicerequest1);

	void updateStatusOfServiceRequest(ServiceRequest serviceRequest);

}
