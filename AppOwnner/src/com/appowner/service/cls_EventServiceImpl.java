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

	public cls_Event getEvent(String eventId) {
		return eventDao.getEvent(eventId);
	}
	
 
	public List<Integer> getEventcatidlist() {
		 
		return getEventDao().getEventcatidList();
	}
	
	public List<Integer> eventcatidlist() {
		return getEventDao().eventcatidList();
	}

	@Override
	public String str_eventcatnames(Integer int_eventcatid) {
		return getEventDao().str_eventcatnames(int_eventcatid);
	}
	
	



}
