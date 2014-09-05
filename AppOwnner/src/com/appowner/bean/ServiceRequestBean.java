package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.component.datatable.DataTable;

import com.appowner.model.ServiceRequest;
import com.appowner.service.ServiceRequestService;
@ManagedBean
@RequestScoped
public class ServiceRequestBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{RequestService}")
	private ServiceRequestService  requestService;

	 
	public ServiceRequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(ServiceRequestService requestService) {
		this.requestService = requestService;
	}
	private List<ServiceRequest> serviceRequestList;
	public List<ServiceRequest> getServiceRequestList() {
		serviceRequestList=new ArrayList<ServiceRequest>();
		serviceRequestList.addAll(getRequestService().getServiceRequestList());
		
		return serviceRequestList;
	}

	public void setServiceRequestList(List<ServiceRequest> serviceRequestList) {
		this.serviceRequestList = serviceRequestList;
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
	 
	public void processListener()
	{
		serviceRequest=(ServiceRequest)dataTable.getRowData();
		serviceRequestId=serviceRequest.getInt_ServiceRequestId();
		 
		System.out.println(serviceRequestId);
	}
	public void assignRequestedService()
	{
	serviceRequest.setStr_Status("Progress");
	System.out.println(serviceRequestId+"sudhaaaaaa");
	serviceRequest.setInt_ServiceRequestId(serviceRequestId);

	//getServiceRequestService().updateStatusOfServiceRequest(serviceRequest);
	}
	public void closeRequestedService()
	{
		
	serviceRequest.setStr_Status("RequestClosed");
	   
	//getServiceRequestService().updateStatusOfServiceRequest(serviceRequest);
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
	 // servicerequest1=getServiceRequestService().getOneServiceRequest(serviceRequestId);
  }
public void updateOneServiceRequest()
{
	//getServiceRequestService().updateOneServiceRequest(serviceRequest);
}
public void deleteOneServiceRequest()
{
	servicerequest1.setInt_ServiceRequestId(serviceRequestId);
	//getServiceRequestService().deleteOneServiceRequest(servicerequest1);
}
	
}
