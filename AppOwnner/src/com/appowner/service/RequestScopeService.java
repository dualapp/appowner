package com.appowner.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.primefaces.model.ScheduleEvent;

import com.appowner.model.BookAFacility;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.cls_Event;

public interface RequestScopeService {

List<ServiceRequest> getListServiceRequest();

List< Pool> getPollList();

ServiceRequest getOneServiceRequest(Integer serviceRequestId);

void updateOneServiceRequest(ServiceRequest serviceRequest);

void deleteOneServiceRequest(ServiceRequest servicerequest1);

 
void deleteOneServiceRequest(List<ServiceRequest> entitiesToDelete);

List<ServiceRequest> getListServiceRequest(
		String str_Status);

void deleteOnefacility(List<BookAFacility> entitiesToDelete);

void updateBookAFacility(BookAFacility bf1);

List<BookAFacility> getSelectedBookFacility(
		String str_Status);

List<cls_Event> getEventList();

void addEvent(cls_Event event);

void updateEvent(cls_Event event);

void updateStatusOfServiceRequest(Integer int_ServiceRequestId,
		String str_Status, Date dat_AssignDate);

void updateStatusOfBookFacility(Integer int_FacilityBookId, String str_Status);

String checkStatusOfServiceRequest(Integer int_ServiceRequestId);

BookAFacility getOneBookAFacility(Integer bid);

String checkStatusOfBookFacility(Integer int_FacilityBookId);

void updateStatusOfServiceRequest2(Integer int_ServiceRequestId,
		String str_Status, Date dat_CloseDate);

}
