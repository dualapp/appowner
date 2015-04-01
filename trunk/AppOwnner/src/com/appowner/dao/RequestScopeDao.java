package com.appowner.dao;

import java.util.Date;
import java.util.List;

import org.primefaces.model.ScheduleEvent;

import com.appowner.model.BookAFacility;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.cls_Event;

public interface RequestScopeDao {

	List<ServiceRequest> getListServiceRequest();

	List<Pool> getPollList();

	ServiceRequest getOneServiceRequest(Integer serviceRequestId);

	void updateOneServiceRequest(ServiceRequest serviceRequest);

	void deleteOneServiceRequest(ServiceRequest servicerequest1);

	void updateStatusOfServiceRequest(ServiceRequest serviceRequest);

	void deleteOneServiceRequest(List<ServiceRequest> entitiesToDelete);

	List<ServiceRequest> getListServiceRequest(Integer int_ApartmentId,
			String str_Status, String str_VendorType, Date dat_ToDate);

	void deleteOnefacility(List<BookAFacility> entitiesToDelete);

	void updateBookAFacility(BookAFacility bf1);

	List<BookAFacility> getSelectedBookFacility(Integer int_ApartmentId,
			String str_Status, Date str_Period, String str_FacilityType, String str_EventType);

	List<cls_Event> getEventList();

	void addEvent(cls_Event event);

	void updateEvent(cls_Event event);

	void updateStatusOfServiceRequest(Integer int_ServiceRequestId,
			String str_Status);

	void updateStatusOfBookFacility(Integer int_FacilityBookId,
			String str_Status);

}
