package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.cls_Event;
 
 

public interface cls_EventService {

	public  void addEvent(cls_Event eve);

	public  List<cls_Event>  listEvents();
	
	public cls_Event getEvent(Integer eventId);

	public void deleteEvent(cls_Event eve);

	public List<String> getStr_eventcatnames();
	
	public Integer int_eventcatid (String str_eventcatnames);

	public List<String> getStr_eventcatnamelist();

	public List<String> str_eventcatnamelist(String str_eventcatname);

	//public String getCatnames(Integer int_eventcatid);

	public void update(cls_Event eve);

	public List<String> str_eventcatnamelist();

	public void update1(cls_Event eve);

	//public String getEventName(Integer int_eventcatid);

	

	 
}
