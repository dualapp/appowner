package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.cls_Event;
 
 

public interface cls_EventService {

	public  void addEvent(cls_Event eve);

	public  List<cls_Event>  listEvents();
	
	public cls_Event getEvent(String eventId);
	
	public List<Integer> getEventcatidlist();
	
	public List<Integer> eventcatidlist();

	public String str_eventcatnames(Integer int_eventcatid);

	

	 
}
