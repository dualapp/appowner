package com.appowner.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.appowner.model.BookAFacility;
import com.appowner.model.ServiceRequest;
import com.appowner.model.Vendor;
import com.appowner.service.In_UserService;
import com.appowner.service.RequestScopeService;
import com.appowner.util.Util;
@ManagedBean
@ViewScoped
public class RequestScopeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

@ManagedProperty(value = "#{RequestScopeService}")
private RequestScopeService requestScopeService;
private String str_Status;
private String str_VendorType;
private String str_Period;
 private String Today;

 public String getStr_Period() {
	 
	return str_Period;
}
public void setStr_Period(String str_Period) {
	this.str_Period = str_Period;
}
 
 
public String getStr_Status() {
	
	return str_Status;
}
public void setStr_Status(String str_Status) {
	this.str_Status = str_Status;
}
public String getStr_VendorType() {
	return str_VendorType;
}
public void setStr_VendorType(String str_VendorType) {
	this.str_VendorType = str_VendorType;
}
public RequestScopeService getRequestScopeService() {
	return requestScopeService;
}
public void setRequestScopeService(RequestScopeService requestScopeService) {
	this.requestScopeService = requestScopeService;
}
private List<ServiceRequest> selectedServices;
public List<ServiceRequest> getSelectedServices() {
	return selectedServices;
}
public void setSelectedServices(List<ServiceRequest> selectedServices) {
	this.selectedServices = selectedServices;
}
private List<ServiceRequest> listServiceRequest;
public List<ServiceRequest> getListServiceRequest() {
	listServiceRequest=new ArrayList<ServiceRequest>();
	listServiceRequest.addAll(getRequestScopeService().getListServiceRequest(Util.getAppartmentId(),str_Status,str_VendorType));
	return listServiceRequest;
	
}
 
public static void setServiceRequestId(Integer serviceRequestId) {
	RequestScopeBean.serviceRequestId = serviceRequestId;
}
public void setListServiceRequest(List<ServiceRequest> listServiceRequest) {
	this.listServiceRequest = listServiceRequest;
}
private DataTable dataTable;




public DataTable getDataTable() {
	return dataTable;
}

public void setDataTable(DataTable dataTable) {
	this.dataTable = dataTable;
}

private   ServiceRequest serviceRequest;
private static Integer serviceRequestId; 
  
public static Integer getServiceRequestId() {
	return serviceRequestId;
}
 
 
 
 
 
public ServiceRequest processListener()
{ 
	servicerequest1=(ServiceRequest)dataTable.getRowData();
	serviceRequestId=servicerequest1.getInt_ServiceRequestId();
	 
	System.out.println(serviceRequestId);
	return servicerequest1;
}
public void assignRequestedService(ServiceRequest serviceRequest)
{
	 
serviceRequest.setStr_Status("Progress");
 
getRequestScopeService().updateStatusOfServiceRequest(serviceRequest);
 
}
public void closeRequestedService(ServiceRequest serviceRequest)
{
	 
serviceRequest.setStr_Status("RequestClosed");
 
   
getRequestScopeService().updateStatusOfServiceRequest(serviceRequest);
}
private ServiceRequest servicerequest1;
public ServiceRequest getServicerequest1() {
	 
	 
	return servicerequest1;
}
public void setServicerequest1(ServiceRequest servicerequest1) {
	this.servicerequest1 = servicerequest1;
}

public String deleteServices(){
    List<ServiceRequest> entitiesToDelete = new ArrayList<ServiceRequest>();
System.out.println(selectedServices+"venders");
    for (ServiceRequest service :selectedServices) {
    	 
    	if (service.getInt_ServiceRequestId()!=null) 
    	{
            entitiesToDelete.add(service);
        }
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Service deleted Successfully!", "Service deleted Successfully!"));
    } 
System.out.println(entitiesToDelete+"entyt todelete");
getRequestScopeService().deleteOneServiceRequest(entitiesToDelete);
    return "servicerequest.xhtml?faces-redirect=true";
}
 
public void getOneServiceRequest()
{   
  servicerequest1=getRequestScopeService().getOneServiceRequest(serviceRequestId);
	   System.out.println(servicerequest1+"servicerequest");
  
}
public void updateOneServiceRequest(ServiceRequest servicerequest)
{
	getRequestScopeService().updateOneServiceRequest(servicerequest);
	
}
public void updateOneServiceRequest()
{ servicerequest1=new ServiceRequest();
	servicerequest1=processListener();
getRequestScopeService().updateOneServiceRequest(servicerequest1);
}
public void deleteOneServiceRequest()
{ 
servicerequest1.setInt_ServiceRequestId(serviceRequestId);
getRequestScopeService().deleteOneServiceRequest(servicerequest1);
}
public ServiceRequest getServiceRequest() {
	return serviceRequest;
}

/*
 * book a facility
 */
 
private List<BookAFacility> selectedBookAFacility;
private String str_FacilityType;
private List<BookAFacility> bookAFacilityList;
private String str_OrganizationName;
private String str_EventType;
public String getStr_EventType() {
	return str_EventType;
}
public void setStr_EventType(String str_EventType) {
	this.str_EventType = str_EventType;
}
 
public String deleteBookedFacility(){
    List<BookAFacility> entitiesToDelete = new ArrayList<BookAFacility>();
System.out.println(selectedServices+"venders");
    for (BookAFacility facility :selectedBookAFacility) {
    	 
    	if (facility.getInt_FacilityBookId()!=null) 
    	{
            entitiesToDelete.add(facility);
        }
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Service deleted Successfully!", "Service deleted Successfully!"));
    } 
System.out.println(entitiesToDelete+"entyt todelete");
getRequestScopeService().deleteOnefacility(entitiesToDelete);
    return "servicerequest.xhtml?faces-redirect=true";
}

public List<BookAFacility> getSelectedBookAFacility() {
	return selectedBookAFacility;
}
public void setSelectedBookAFacility(List<BookAFacility> selectedBookAFacility) {
	this.selectedBookAFacility = selectedBookAFacility;
}
public void updateBookAFacility(BookAFacility bf1)
{
	getRequestScopeService().updateBookAFacility(bf1);
}
public String getStr_FacilityType() {
	return str_FacilityType;
}
public void setStr_FacilityType(String str_FacilityType) {
	this.str_FacilityType = str_FacilityType;
}
public List<BookAFacility> getBookAFacilityList() {
	bookAFacilityList=new ArrayList<BookAFacility>();
	bookAFacilityList.addAll(getRequestScopeService().getSelectedBookFacility(Util.getAppartmentId(),str_Status,str_Period,str_FacilityType,str_EventType));
	return bookAFacilityList;
}
public void setBookAFacilityList(List<BookAFacility> bookAFacilityList) {
	this.bookAFacilityList = bookAFacilityList;
}
public String getStr_OrganizationName() {
	return str_OrganizationName;
}
public void setStr_OrganizationName(String str_OrganizationName) {
	this.str_OrganizationName = str_OrganizationName;
}
public String getToday() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //get current date time with Date()
    Date date = new Date();
    Today=dateFormat.format(date);
	return Today;
}
public void setToday(String today) {
	Today = today;
}
//Schedule Event
private ScheduleModel eventModel;
public ScheduleModel getEventModel() {
	return eventModel;
}
public void setEventModel(ScheduleModel eventModel) {
	this.eventModel = eventModel;
}
@PostConstruct
public void init() {
	Date date = new Date();
	 
    eventModel = new DefaultScheduleModel();
    eventModel.addEvent(new DefaultScheduleEvent("Birth Day Party",nextDay9Am(),nextDay11Am() ));
    
 
}
private Calendar today() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

    return calendar;
}
private Date nextDay9Am() {
    Calendar t = (Calendar) today().clone();
    t.set(Calendar.AM_PM, Calendar.AM);
    t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
    t.set(Calendar.HOUR, 10);
     
    return t.getTime();
}
 
private Date nextDay11Am() {
    Calendar t = (Calendar) today().clone();
    t.set(Calendar.AM_PM, Calendar.AM);
    t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
    t.set(Calendar.HOUR, 11);
     
    return t.getTime();
}
}

