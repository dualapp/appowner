package com.appowner.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.appowner.model.Assets;
import com.appowner.model.BookAFacility;
import com.appowner.model.ServiceRequest;
import com.appowner.model.Vendor;
import com.appowner.model.cls_Event;
import com.appowner.service.In_UserService;
import com.appowner.service.RequestScopeService;
import com.appowner.service.VendorService;
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
@ManagedProperty(value = "#{VendorService}")
private VendorService vendorservice;
 
public VendorService getVendorservice() {
	return vendorservice;
}
public void setVendorservice(VendorService vendorservice) {
	this.vendorservice = vendorservice;
}
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
private Date dat_ToDate;
public Date getDat_ToDate() {
	return dat_ToDate;
}
public void setDat_ToDate(Date dat_ToDate) {
	this.dat_ToDate = dat_ToDate;
}
private List<SelectItem> dates;
public List<SelectItem> getDates() {
	return dates;
}
public void setDates(List<SelectItem> dates) {
	this.dates = dates;
}
 
private  String str;

public String getStr() {
	
	
	return str;
}
public void setStr(String str) {
	this.str = str;
}
public Date accountchangeListener3(ValueChangeEvent event)
{
	System.out.println("hjjhjhjk");
	str=(String)event.getNewValue();
  
   if(str.equalsIgnoreCase("This Week End"))
		   {
	   Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		
		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;
		   }
   else if(str.equalsIgnoreCase("This Month End"))
   {
	   Calendar c = Calendar.getInstance();
	 		
	 		c.getActualMaximum(Calendar.DAY_OF_MONTH);
	 		c.add(Calendar.MONTH, 1);  
	        c.set(Calendar.DAY_OF_MONTH, 1);  
	        c.add(Calendar.DATE, -1);  

	 		dat_ToDate=c.getTime();
	 		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
	 		return dat_ToDate; 
   }
   else if(str.equalsIgnoreCase("This Quarter End"))
   {  
   Calendar c = Calendar.getInstance();
	c.setTime(dat_ToDate);
	int factor = 0;
	int month = c.get(Calendar.MONTH);
	if (month == Calendar.JANUARY
		|| month == Calendar.APRIL
		|| month == Calendar.JULY
		|| month == Calendar.OCTOBER) {
		factor = 2;
	} else if (
		month == Calendar.FEBRUARY
		|| month == Calendar.MAY
		|| month == Calendar.AUGUST
		|| month == Calendar.NOVEMBER) {
		factor = 1;
		} else {
			factor = 0;
	}

	c.add(Calendar.MONTH, factor);
	c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
	dat_ToDate=c.getTime();
	return dat_ToDate;
}
   
   else if(str.equalsIgnoreCase("This Year End"))
   {
	   Calendar c = Calendar.getInstance();
		
		c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int year=c.getWeekYear()+1;
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, 2); 
		c.set(Calendar.DAY_OF_MONTH, 31); // new years eve


		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;  
   }
   else if(str.equalsIgnoreCase("Yesterday"))
   {
	   Calendar c = Calendar.getInstance();
	   c.add(Calendar.DATE, -1);
		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;
   }
   else if(str.equalsIgnoreCase("Custom"))
   {  dat_ToDate=null;
	  return dat_ToDate;
   }
   else if(str.equalsIgnoreCase("Previous Week End"))
   {
	   Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		c.set(Calendar.DATE,-1);
		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;
   }
   else if(str.equalsIgnoreCase("Previous Month End"))
   {
	   Calendar aCalendar = Calendar.getInstance();
	   aCalendar.set(Calendar.DATE, 1);
	   aCalendar.add(Calendar.DAY_OF_MONTH, -1);
	   dat_ToDate = aCalendar.getTime();
	   System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
	   
   }
   else if(str.equalsIgnoreCase("Previous Quarter End"))
   {
	   Calendar c = Calendar.getInstance();
	   c.add(Calendar.MONTH,-3);
		int factor = 0;
		int month = c.get(Calendar.MONTH);
		if (month == Calendar.JANUARY
			|| month == Calendar.APRIL
			|| month == Calendar.JULY
			|| month == Calendar.OCTOBER) {
			factor = 2;
		} else if (
			month == Calendar.FEBRUARY
			|| month == Calendar.MAY
			|| month == Calendar.AUGUST
			|| month == Calendar.NOVEMBER) {
			factor = 1;
			} else {
				factor = 0;
		}

		c.add(Calendar.MONTH, factor);
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
		dat_ToDate=c.getTime();
		return dat_ToDate;
	   
   }
   else if(str.equalsIgnoreCase("Previous Year End"))
   {
	   Calendar c = Calendar.getInstance();
		
		
		int year=c.getWeekYear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, 2); 
		c.set(Calendar.DAY_OF_MONTH, 31); // new years eve


		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;  
   }
    return null;
	
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
private String query1;
public String getQuery1() {
	return query1;
}
public void setQuery1(String query1) {
	this.query1 = query1;
}
public List<ServiceRequest> getListServiceRequest() {
	try{
		listServiceRequest=new ArrayList<ServiceRequest>();
		if(str_Status==null && str_VendorType==null&& dat_ToDate==null )
		{   
			query1="";
		}
		if(!(str_Status==null) && !(str_Status.isEmpty()))
		{
			query1=query1+"Str_Status="+"'"+str_Status+"'";
		}
		
		 if(!(str_VendorType==null) && !(str_VendorType.isEmpty()))
			{
				query1=query1+" and "+"Str_VendorType="+"'"+str_VendorType+"'";
			}
		 if(!(dat_ToDate==null))
			{
			
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String date=formatter.format(dat_ToDate) ;
			 
				 System.out.println(date+"dddddddddddddddd");
				query1=query1+" and "+"dat_OpenDate="+"'"+date+"'";
			}
		 if(query1.indexOf("and")==1)
			{    
			   query1=query1.replaceFirst("and","" );
	                
			}
			 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	listServiceRequest.addAll(getRequestScopeService().getListServiceRequest(query1));
	query1="";
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
private   ServiceRequest serviceReq=new ServiceRequest() ;
public ServiceRequest getServiceReq() {
	return serviceReq;
}
public void setServiceReq(ServiceRequest serviceReq) {
	this.serviceReq = serviceReq;
}
private static Integer serviceRequestId; 
  
public static Integer getServiceRequestId() {
	return serviceRequestId;
}
 
 public void getServiceRequest1(Integer sid)
 {
	 serviceReq= getRequestScopeService().getOneServiceRequest(sid);
	 if(serviceReq!=null)
	 {
		 str_VendorNameByType=new ArrayList<String>();
			str_VendorNameByType.addAll(getVendorservice().listOfVendorNameByType(serviceReq.getStr_VendorType()));
	 }
 }
 
  private List<String>  str_VendorTypeList;
public List<String> getStr_VendorTypeList() {
	str_VendorTypeList=new ArrayList<String>();
	str_VendorTypeList.addAll(getVendorservice().getStr_VendorTypeList());
	System.out.println(str_VendorTypeList);
	return str_VendorTypeList;
}
private  List<String> str_VendorNameByType;
public List<String> vendorTypeChangeListener(ValueChangeEvent event)
{   
	str_VendorType=(String) event.getNewValue();
	if(str_VendorType!=null)
	{
	System.out.println(str_VendorType);
	str_VendorNameByType=new ArrayList<String>();
	str_VendorNameByType.addAll(getVendorservice().listOfVendorNameByType(str_VendorType));
	System.out.println(str_VendorNameByType);
	return str_VendorNameByType ;
	}
	else
		return str_VendorNameByType=new ArrayList<String>();
	
}

public List<String> getStr_VendorNameByType() {
	 
		 
		return str_VendorNameByType;
	 
	 
}
 private BookAFacility bf1=new BookAFacility();
 public void getBookAFacility1(Integer bid)
 {
 bf1= getRequestScopeService().getOneBookAFacility(bid);
 }
 
public String assignRequestedService(ServiceRequest serviceRequest)
{
	String status=getRequestScopeService().checkStatusOfServiceRequest(serviceRequest.getInt_ServiceRequestId());
	if(status.equalsIgnoreCase("Progress"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Only Open status service request can be assigned"));
		return "servicerequest.xhtml";
	}
	 
	else if(serviceRequest.getStr_Status().equalsIgnoreCase("RequestClosed"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Only Open status service request can be assigned"));
		return "servicerequest.xhtml";
	}
	 str_Status="Progress";
	 
 
getRequestScopeService().updateStatusOfServiceRequest(serviceRequest.getInt_ServiceRequestId(),str_Status, new Date());
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Service Assigned Successfully"));
    return "servicerequest.xhtml";
}
public String closeRequestedService(ServiceRequest serviceRequest)
{
	 
	String status=getRequestScopeService().checkStatusOfServiceRequest(serviceRequest.getInt_ServiceRequestId());
	if(status.equalsIgnoreCase("RequestClosed"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Service Request Already Closed"));
		return "servicerequest.xhtml";
	}
	
	str_Status="RequestClosed";
	 
getRequestScopeService().updateStatusOfServiceRequest2(serviceRequest.getInt_ServiceRequestId(),str_Status, new Date());
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Service Closed Successfully"));
    return "servicerequest.xhtml";
}
public String assignBookFacility(BookAFacility baf)
{
	String status=getRequestScopeService().checkStatusOfBookFacility(baf.getInt_FacilityBookId());
	if(status.equalsIgnoreCase("Progress"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Only Open status Book A Facility can be assigned"));
		return "book a facility.xhtml";
	}
	 
	else if(baf.getStr_Status().equalsIgnoreCase("RequestClosed"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Only Open status Book A Facility can be assigned"));
		return "book a facility.xhtml";
	}
	 str_Status="Progress";
	 
 
getRequestScopeService().updateStatusOfBookFacility(baf.getInt_FacilityBookId(),str_Status);
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Assigned Successfully"));
    return "book a facility.xhtml";
}
public String closeBookFacility(BookAFacility baf)
{
	 
String status=getRequestScopeService().checkStatusOfBookFacility(baf.getInt_FacilityBookId());
if(status.equalsIgnoreCase("RequestClosed"))
{
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Book A Facility Already Closed"));
	return "book a facility.xhtml";
}
 
 
	str_Status="RequestClosed";
getRequestScopeService().updateStatusOfBookFacility(baf.getInt_FacilityBookId(),str_Status);
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Closed Successfully"));
    return "book a facility.xhtml";
}
 

public String deleteServices(){
    List<ServiceRequest> entitiesToDelete = new ArrayList<ServiceRequest>();
System.out.println(selectedServices+"venders");
    for (ServiceRequest service :selectedServices) {
    	 
    	if (service.getInt_ServiceRequestId()!=null) 
    	{
            entitiesToDelete.add(service);
            System.out.println(service.getInt_ServiceRequestId());
        }
    	
    } 
System.out.println(entitiesToDelete+"entyt todelete");
getRequestScopeService().deleteOneServiceRequest(entitiesToDelete);
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully"));
    return "servicerequest.xhtml";
}
 
 
public String updateOneServiceRequest()
{
	if(serviceReq.getInt_ServiceRequestId()!=null)
	{
	getRequestScopeService().updateOneServiceRequest(serviceReq);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully"));
	}
	return "servicerequest.xhtml";
	
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
    	
    } 
    
System.out.println(entitiesToDelete+"entyt todelete");
getRequestScopeService().deleteOnefacility(entitiesToDelete);
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully"));
 
    return "book a facility.xhtml";
}

public List<BookAFacility> getSelectedBookAFacility() {
	return selectedBookAFacility;
}
public void setSelectedBookAFacility(List<BookAFacility> selectedBookAFacility) {
	this.selectedBookAFacility = selectedBookAFacility;
}
public String updateBookAFacility()
{if(bf1!=null)
{
	getRequestScopeService().updateBookAFacility(bf1);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully"));
}
	    return "book a facility.xhtml";
}
public BookAFacility getBf1() {
	return bf1;
}
public void setBf1(BookAFacility bf1) {
	this.bf1 = bf1;
}
public String getStr_FacilityType() {
	return str_FacilityType;
}
public void setStr_FacilityType(String str_FacilityType) {
	this.str_FacilityType = str_FacilityType;
}
private String query;
public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public List<BookAFacility> getBookAFacilityList() {
	try{
		bookAFacilityList=new ArrayList<BookAFacility>();
		if(str_Status==null && str_VendorType==null&& dat_ToDate==null)
		{   
			query="";
		}
		if(!(str_Status==null) && !(str_Status.isEmpty()))
		{
			query=query+"Str_Status="+"'"+str_Status+"'";
		}
		 if(!(dat_ToDate==null))
			{
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String date=formatter.format(dat_ToDate) ;
			 
				 System.out.println(date+"dddddddddddddddd");
				query=query+" and "+"dat_OpenDate="+"'"+date+"'";
			}
		 if(!(str_FacilityType==null) && !(str_FacilityType.isEmpty()))
			{
				query=query+" and "+"str_FacilityType="+"'"+str_FacilityType+"'";
			}
		 if(!( str_EventType==null) && !( str_EventType.isEmpty()))
			{
				query=query+" and "+" str_EventType="+"'"+ str_EventType+"'";
			}
		
		 if(query.indexOf("and")==1)
			{    
			   query=query.replaceFirst("and","" );
	                
			}
			 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	bookAFacilityList.addAll(getRequestScopeService().getSelectedBookFacility(query));
	query="";
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
private List<cls_Event> eventList;
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
    
    ListIterator<cls_Event> itr=getEventList().listIterator();
    while(itr.hasNext())
    {
    	  event1=itr.next();
    	String ename=event1.getStr_EventTitle();
    	String user=event1.getStr_UserName();
    	Date sDate=event1.getDat_StartDate();
    	Date eDate=event1.getDat_EndDate();
    	 eventModel.addEvent(new DefaultScheduleEvent(ename,sDate,eDate, user));
    }
    
    SelectItemGroup g1 = new SelectItemGroup("Current");
    g1.setSelectItems(new SelectItem[] {new SelectItem("Today", "Today"), new SelectItem("This Week End", "This Week End"), new SelectItem("This Month End", "This Month End"),new SelectItem("This Quarter End", "This Quarter End"),new SelectItem("This Year End", "This Year End")});
     
    SelectItemGroup g2 = new SelectItemGroup("Previous");
    g2.setSelectItems(new SelectItem[] {new SelectItem("Yesterday", "Yesterday"), new SelectItem("Previous Week End", "Previous Week End"), new SelectItem("Previous Month End", "Previous Month End"),new SelectItem("Previous Quarter End", "Previous Quarter End"),new SelectItem("Previous Year End", "Previous Year End")});
     
    SelectItemGroup g3 = new SelectItemGroup("Custom");
    g3.setSelectItems(new SelectItem[] {new SelectItem("Custom", "Custom")});
    dates = new ArrayList<SelectItem>();
    dates.add(g1);
    dates.add(g2);
    dates.add(g3);
 
}
private ScheduleEvent event = new DefaultScheduleEvent();
private String str_EventTitle;
private Date dat_StartDate;
public String getStr_EventTitle() {
	return str_EventTitle;
}
public void setStr_EventTitle(String str_EventTitle) {
	this.str_EventTitle = str_EventTitle;
}
public Date getDat_StartDate() {
	return dat_StartDate;
}
public void setDat_StartDate(Date dat_StartDate) {
	this.dat_StartDate = dat_StartDate;
}
public Date getDat_EndDate() {
	return dat_EndDate;
}
public void setDat_EndDate(Date dat_EndDate) {
	this.dat_EndDate = dat_EndDate;
}
private Date dat_EndDate;

public void addEvent() {
	if(event.getId() == null)
	{
		System.out.println(event.getId() == null);
	event1=new cls_Event();
	event1.setStr_EventTitle(str_EventTitle);
	event1.setStr_UserName(Util.getUserName());
	event1.setDat_StartDate(dat_StartDate);
	event1.setDat_EndDate(dat_EndDate);
         getRequestScopeService().addEvent(event1);
	}
    else
    {
    	event1.setStr_EventTitle(str_EventTitle);
    	event1.setStr_UserName(Util.getUserName());
    	event1.setDat_StartDate(dat_StartDate);
    	event1.setDat_EndDate(dat_EndDate);
     
    	getRequestScopeService().updateEvent(event1);
    }
     
    event = new DefaultScheduleEvent();
	
}
public void onEventSelect(SelectEvent selectEvent) {
	System.out.println(selectEvent.toString()+"kk");
    event = (ScheduleEvent) selectEvent.getObject();
}
public void onDateSelect(SelectEvent selectEvent) {
    setEvent(new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject()));
}
private Calendar today() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

    return calendar;
}
private Date previousDay8Pm() {
    Calendar t = (Calendar) today().clone();
    t.set(Calendar.AM_PM, Calendar.PM);
    t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
    t.set(Calendar.HOUR, 8);
     
    return t.getTime();
}
 
private Date previousDay11Pm() {
    Calendar t = (Calendar) today().clone();
    t.set(Calendar.AM_PM, Calendar.PM);
    t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
    t.set(Calendar.HOUR, 11);
     
    return t.getTime();
}
 
private Date theDayAfter3Pm() {
    Calendar t = (Calendar) today().clone();
    t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);     
    t.set(Calendar.AM_PM, Calendar.PM);
    t.set(Calendar.HOUR, 3);
     
    return t.getTime();
}
private Date fourDaysLater3pm() {
    Calendar t = (Calendar) today().clone(); 
    t.set(Calendar.AM_PM, Calendar.PM);
    t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
    t.set(Calendar.HOUR, 3);
     
    return t.getTime();
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
public ScheduleEvent getEvent() {
	return event;
}
public void setEvent(ScheduleEvent event) {
	this.event = event;
}
private cls_Event event1;
public List<cls_Event> getEventList() {
	eventList=new ArrayList<cls_Event>();
	eventList.addAll(getRequestScopeService().getEventList());
	return eventList;
}
public void setEventList(List<cls_Event> eventList) {
	this.eventList = eventList;
}
public cls_Event getEvent1() {
	return event1;
}
public void setEvent1(cls_Event event1) {
	this.event1 = event1;
}
public void rowSelectListener( SelectEvent event)
{ 
	 System.out.println("seemaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	indicate=true;
}
private boolean indicate;
 

public boolean isIndicate() {
	return indicate;
}
public void setIndicate(boolean indicate) {
	this.indicate = indicate;
}
public String select()
{   
  try{ 
   if(indicate==false)
   {   System.out.println("jcvkvcjvj11111111111111111111111111111111111111111111111111");
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select an item to proceed!"));
		return "servicerequest.xhtml";
   }
   else
   {  
	   indicate=true;
	  return "servicerequest.xhtml";
   }
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return null;
}
public String select1()
{   
  try{ 
   if(indicate==false)
   {   System.out.println("jcvkvcjvj11111111111111111111111111111111111111111111111111");
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select an item to proceed!"));
		return "book a facility.xhtml";
   }
   else
   {  
	   indicate=true;
	  return "book a facility.xhtml";
   }
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return null;
}
}

