package com.appowner.dao;

import java.util.List;

import com.appowner.model.*;

public interface cls_EventDao {
		
		public void addEvent(cls_Event eve);

		public List<cls_Event> listEvents();
		
		public cls_Event getEvent(String eventid);

		public List<Integer> getEventcatidList();

		public List<Integer> eventcatidList();

		public String str_eventcatname(Integer int_eventcatid);

		

		public String str_eventcatnames(Integer int_eventcatid);
}
