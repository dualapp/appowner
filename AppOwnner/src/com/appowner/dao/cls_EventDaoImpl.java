package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.*;

@Repository
public class cls_EventDaoImpl implements cls_EventDao {

	@Autowired
	private SessionFactory sessionFactory;
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addEvent(cls_Event eve) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(eve);
	}

	@SuppressWarnings("unchecked")
	public List<cls_Event> listEvents() {
		return (List<cls_Event>) getSessionFactory().getCurrentSession().createCriteria(cls_Event.class).list();
	}

	public cls_Event getEvent(String eventId) {
		return (cls_Event) getSessionFactory().getCurrentSession().get(cls_Event.class, eventId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getEventcatidList() {
		 
		List<Integer> eventcatidList=getSessionFactory().getCurrentSession().createCriteria(cls_Event.class).setProjection(Projections.property("int_eventcatid")).list();
		return  eventcatidList;
		}
	
	@SuppressWarnings("unchecked")
	public List<Integer> eventcatidList() {
		 
		// String hql=" select str_CityName from VendorCity where str_StateName=str_StateName";
	
		List<Integer> eventcatidList= (List<Integer>) getSessionFactory().getCurrentSession().createCriteria(cls_EventCategory.class).setProjection(Projections.property("int_eventcatid")).list();
		   
		  return  eventcatidList ;
	}

	@Override
	public String str_eventcatname(Integer int_eventcatid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String str_eventcatnames(Integer int_eventcatid) {
		String hql="select str_eventcatname from cls_EventCategory where int_eventcatid=?";
		return   (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_eventcatid).uniqueResult();
		
	}
	
	/*public String str_eventcatname(Integer int_eventcatid) {
		String hql="select int_eventcatid from cls_EventCategory where str_eventcatname=?";
		return  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_eventcatname).uniqueResult();
		
	}
*/
	 
	
}
