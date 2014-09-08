package com.appowner.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.dao.DataAccessException;

import com.appowner.model.cls_Event;
import com.appowner.service.cls_EventService;
import com.appowner.util.Util;
@ManagedBean
@SessionScoped

public class cls_EventBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "ViewEvent";
	private static final String ERROR   = "error";
	private Date dat_StartDate;
	private Date dat_EndDate;
	private Integer eventId;
	private String str_EventTitle;
	private String str_EventDescription;
	private String str_EventVenue;
	private Integer int_eventcatid;
	private String str_Email;
//	private Integer> int_eventcatids;
	private List<cls_Event> eventList;
	private List<String> str_eventcatnamelist;
	private String str_eventcatname;
	private String str_UserName;
	
	private void parserdat_StartDate() {
	    String dateStr = "";
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    try {
	    	dat_StartDate = formatter.parse(dateStr);
	    } catch (ParseException ex) {
	        // handle
	    }
	}

	public Date getDat_StartDate() {
	    if (dat_StartDate == null)
	        parserdat_StartDate();
	    return dat_StartDate;
	}

	public void setDat_StartDate(Date dat_StartDate) {
		this.dat_StartDate = dat_StartDate;
	}
	
	private void parserdat_EndDate() {
	    String dateStr = "";
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    try {
	    	dat_EndDate = formatter.parse(dateStr);
	    } catch (ParseException ex) {
	        // handle
	    }
	}

	public Date getDat_EndDate() {
	    if (dat_EndDate == null)
	        parserdat_EndDate();
	    return dat_EndDate;
	}

	public void setDat_EndDate(Date dat_EndDate) {
		this.dat_EndDate = dat_EndDate;
	}
	
	
	private List<String> str_eventcatnames;
	
	public List<String> getStr_eventcatnames() {
		str_eventcatnames=new ArrayList<String>();
		str_eventcatnames.addAll(getEventService().str_eventcatnamelist());
		System.out.println(str_eventcatnames);
		return str_eventcatnames;
	}

	public void setStr_eventcatnames(List<String> str_eventcatnames) {
		this.str_eventcatnames = str_eventcatnames;
	}

	public String getStr_UserName() {
		str_UserName=Util.getUserName();
		return str_UserName;
	}

	public void setStr_UserName(String str_UserName) {
		this.str_UserName = str_UserName;
	}

	public String getStr_eventcatname() {
		return str_eventcatname;
	}

	public void setStr_eventcatname(String str_eventcatname) {
		this.str_eventcatname = str_eventcatname;
	}

	private List<cls_Event> ListEvent;
	
	public List<cls_Event> getListEvent() { 		
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		ListEvent= new ArrayList<cls_Event>();
		ListEvent.addAll(getEventService().listEvents());
		return ListEvent;
	}
	
	public void setListEvent(List<cls_Event> listEvent) {
		ListEvent = listEvent;
	}
	
	@ManagedProperty(value="#{cls_EventService}")
	private cls_EventService eventService;
	
	
	public cls_EventService getEventService() {
		return eventService;
	}
	public void setEventtService(cls_EventService eventService) {
		this.eventService = eventService;
	}

	 
	  public List<cls_Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<cls_Event> eventList) {
		this.eventList = eventList;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public void setEventService(cls_EventService eventService) {
		this.eventService = eventService;
	}

	 
	
	

	public Integer getEventId() {
		return eventId;
	}

	public String getStr_EventTitle() {
		return str_EventTitle;
	}

	public void setStr_EventTitle(String str_EventTitle) {
		this.str_EventTitle = str_EventTitle;
	}

	public String getStr_EventDescription() {
		return str_EventDescription;
	}

	public void setStr_EventDescription(String str_EventDescription) {
		this.str_EventDescription = str_EventDescription;
	}
	
	 

	public List<String> getStr_eventcatnamelist() {
		str_eventcatnamelist=new ArrayList<String>();
		str_eventcatnamelist.addAll(getEventService().getStr_eventcatnamelist());
		return str_eventcatnamelist;
	}

	public void setStr_eventcatnamelist(List<String> str_eventcatnamelist) {
		this.str_eventcatnamelist = str_eventcatnamelist;
	}

	public String getStr_EventVenue() {
		return str_EventVenue;
	}

	public void setStr_EventVenue(String str_EventVenue) {
		this.str_EventVenue = str_EventVenue;
	}

	 

	public Integer getInt_eventcatid() {
		return int_eventcatid;
	}

	public void setInt_eventcatid(Integer int_eventcatid) {
		this.int_eventcatid = int_eventcatid;
	}

	public String getStr_Email() {
		return str_Email;
	}

	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	
	public String addEvent()
	{  
		try{
			System.out.println("Hi");
			cls_Event eve=new cls_Event();
			eve.setDat_StartDate(getDat_StartDate());
			eve.setDat_EndDate(getDat_EndDate());
		    eve.setInt_eventcatid(getInt_eventcatid());
		    System.out.println(str_eventcatname);
			int_eventcatid=getEventService().int_eventcatid(str_eventcatname); 
			eve.setStr_eventcatname(str_eventcatname);
			System.out.println(str_eventcatname);
			eve.setInt_eventcatid(int_eventcatid);
			System.out.println(int_eventcatid); 
		    eve.setStr_UserName(getStr_UserName());
		    eve.setStr_Email(getStr_Email());
		    eve.setStr_EventTitle(getStr_EventTitle());
		    eve.setStr_EventVenue(getStr_EventVenue());
		    eve.setStr_EventDescription(getStr_EventDescription());
		    getEventService().addEvent(eve);
	
		 return SUCCESS;
	}
	catch(DataAccessException e)
	{e.printStackTrace();
		
	}
	return ERROR;
		
	}
	
	public String deleteEvent(){
		cls_Event eve=new cls_Event();
		System.out.println(eventId);
		eve.setEventId(eventId);
		getEventService().deleteEvent(eve);
		return "ViewEvent.xhtml?faces-redirect=true";
	}
	public String cancelComplain() {
		return "ViewEvent.xhtml?faces-redirect=true";
	}
	
	public void reset() {
        this.setEventId(0);
        this.setStr_EventTitle("");
        
    }
	
	private cls_Event eve;
	
	
	
	public cls_Event getEve() {
		return eve;
	}

	public void setEve(cls_Event eve) {
		this.eve = eve;
	}

	public void getEvent()
	{
		System.out.println(eventId);
		eve=getEventService().getEvent(eventId);
		}
	
	
	public String saveEvent() {
	    System.out.println("hihihihihihihihi");
		if(eve.getEventId()!=null)
		{	System.out.println(str_eventcatname);
			//eve.setStr_eventcatname(str_eventcatname);
			getEventService().update1(eve);
		}
			else
			{	
				addEvent();
			}
		return "ViewEvent.xhtml?faces-redirect=true";
	}
}
