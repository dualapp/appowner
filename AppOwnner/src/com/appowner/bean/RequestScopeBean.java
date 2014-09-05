package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.component.datatable.DataTable;

import com.appowner.model.ServiceRequest;
import com.appowner.service.In_UserService;
import com.appowner.service.RequestScopeService;
@ManagedBean
@RequestScoped
public class RequestScopeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

@ManagedProperty(value = "#{RequestScopeService}")
private RequestScopeService requestScopeService;
 

public RequestScopeService getRequestScopeService() {
	return requestScopeService;
}
public void setRequestScopeService(RequestScopeService requestScopeService) {
	this.requestScopeService = requestScopeService;
}
private List<ServiceRequest> listServiceRequest;
public List<ServiceRequest> getListServiceRequest() {
	listServiceRequest=new ArrayList<ServiceRequest>();
	listServiceRequest.addAll(getRequestScopeService().getListServiceRequest());
	return listServiceRequest;
}
public static void setServiceRequest(ServiceRequest serviceRequest) {
	RequestScopeBean.serviceRequest = serviceRequest;
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

private  static ServiceRequest serviceRequest;
private static Integer serviceRequestId; 
  
public static Integer getServiceRequestId() {
	return serviceRequestId;
}
 
 
 
public static ServiceRequest getServiceRequest() {
	return serviceRequest;
}
 
public ServiceRequest processListener()
{ 
	servicerequest1=(ServiceRequest)dataTable.getRowData();
	serviceRequestId=servicerequest1.getInt_ServiceRequestId();
	 
	System.out.println(serviceRequestId);
	return servicerequest1;
}
public void assignRequestedService()
{
	servicerequest1=processListener();
servicerequest1.setStr_Status("Progress");
System.out.println(servicerequest1.getInt_ServiceRequestId()+"sudhaaaaaa");
 //servicerequest1.setInt_ServiceRequestId(serviceRequestId);

getRequestScopeService().updateStatusOfServiceRequest(servicerequest1);
 
}
public void closeRequestedService()
{
	servicerequest1=processListener();
servicerequest1.setStr_Status("RequestClosed");
 
   
getRequestScopeService().updateStatusOfServiceRequest(servicerequest1);
}
private ServiceRequest servicerequest1;
public ServiceRequest getServicerequest1() {
	 
	 
	return servicerequest1;
}
public void setServicerequest1(ServiceRequest servicerequest1) {
	this.servicerequest1 = servicerequest1;
}
public void getOneServiceRequest()
{   
  servicerequest1=getRequestScopeService().getOneServiceRequest(serviceRequestId);
	   System.out.println(servicerequest1+"servicerequest");
  
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
}

