package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.*;
import com.appowner.model.*;


@Service("cls_EventService")
@Transactional 
public class cls_EventServiceImpl implements cls_EventService {
	
	@Autowired
	private cls_EventDao eventDao;
	
	 public cls_EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(cls_EventDao eventDao) {
		this.eventDao = eventDao;
	}
	
	public void addEvent(cls_Event eve) {
		 System.out.println(eventDao);
		 
		getEventDao().addEvent(eve);
	}
	
	public List<cls_Event> listEvents() {
		return getEventDao().listEvents();
	}

	public cls_Event getEvent(Integer eventId) {
		return eventDao.getEvent(eventId);
	}

	@Override
	public void deleteEvent(cls_Event eve) {
		getEventDao().deleteEvent(eve);
		
	}
	
 
	 public Integer int_eventcatid (String str_eventcatnames) {
		 return getEventDao().int_eventcatid(str_eventcatnames);
	 }

	@Override
	public List<String>  getStr_eventcatnames() {
		 
		return (List<String>) getEventDao().getStr_eventcatnames();	
	}

	public String getEventName(Integer int_eventcatid) {
		return  getEventDao().eventName(int_eventcatid);
	}

	@Override
	public List<String> getStr_eventcatnamelist() {
		return getEventDao().getStr_eventcatnamelist();
	}

	@Override
	public List<String> str_eventcatnamelist(String str_eventcatname) {
		return getEventDao().str_eventcatnamelist(str_eventcatname) ;
	}

/*	@Override
	public String getCatnames(Integer int_eventcatid) {
		 return getEventDao().catnames(int_eventcatid);
	}*/

	@Override
	public void update(cls_Event eve) {
		getEventDao().update(eve);
		
	}

	@Override
	public List<String> str_eventcatnamelist() {
		// TODO Auto-generated method stub
		return getEventDao().str_eventcatnamelist();
	}

	@Override
	public void update1(cls_Event eve) {
		getEventDao().update1(eve);
		
	}
	



}
