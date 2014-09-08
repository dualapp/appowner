package com.appowner.dao;

import java.util.List;

import com.appowner.model.*;

public interface cls_EventDao {
		
		public void addEvent(cls_Event eve);

		public List<cls_Event> listEvents();
		
		public cls_Event getEvent(Integer eventId);

		public void deleteEvent(cls_Event eve);

		public void update(cls_Event eve);

		public List<String> getStr_eventcatnames();

		public String eventName(Integer int_eventcatid);

		public Integer int_eventcatid(String str_eventcatnames);

		public List<String> getStr_eventcatnamelist();

		public List<String> str_eventcatnamelist(String str_eventcatname);

		public List<String> str_eventcatnamelist();

		public void update1(cls_Event eve);

	//	public String catnames(Integer int_eventcatid);
 
}
