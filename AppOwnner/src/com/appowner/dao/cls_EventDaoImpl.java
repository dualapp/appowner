package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
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
	public List<cls_Event> listEvents1() {
		String  query = "{ CALL eventform() }";
		
		 List<cls_Event> sou = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(cls_Event.class)
		          ).list();
	      System.out.println("sou");   
		 return sou;
	}
	
	@SuppressWarnings("unchecked")
	public List<cls_Event> listEvents() {
		String  query = "{ CALL eventform() }";
		
		 List<cls_Event> sou = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(cls_Event.class)
		          ).list();
	      System.out.println("sou"); 
	      
	      System.out.println("ffffffffffffffffffffffffffffffffffffffff");
		 return sou;
	}

	public cls_Event getEvent(Integer eventId) {
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
	public void deleteEvent(cls_Event eve) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM cls_Event WHERE eventId = "+eve.getEventId()).executeUpdate();
		
	}

	@Override
	public void update(cls_Event eve) {
		System.out.println(eve.getEventId());
		sessionFactory.getCurrentSession().update(eve);
		
	}

	 

	@Override
	public Integer int_eventcatid(String str_eventcatnames) {
		 String hql="select int_eventcatid from cls_EventCategory where str_eventcatname=?"  ;
		 return (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_eventcatnames).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_eventcatnames() {
		return getSessionFactory().getCurrentSession().createCriteria(cls_EventCategory.class).setProjection(Projections.property("str_eventcatname")).list();
	}

	@Override
	public String eventName(Integer int_eventcatid) {
		String hql="select str_eventcatname  from cls_EventCategory where int_eventcatid=?"  ;
		 return (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_eventcatid).uniqueResult();
	}
	
	public String str_eventcatname(Integer int_eventcatid) {
		String hql="select int_eventcatid from cls_EventCategory where str_eventcatname=?";
		return  (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_eventcatid).uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_eventcatnamelist() {
		List<String> str_eventcatnamelist=getSessionFactory().getCurrentSession().createCriteria(cls_EventCategory.class).setProjection(Projections.property("str_eventcatname")).list();
		return  str_eventcatnamelist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> str_eventcatnamelist(String str_eventcatname) {
		List<String> str_eventcatnamelist= (List<String>) getSessionFactory().getCurrentSession().createCriteria(cls_EventCategory.class).setProjection(Projections.property("str_eventcatame")).list(); 
		  return  str_eventcatnamelist ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> str_eventcatnamelist() {
		List<String> str_eventcatnamelist= (List<String>) getSessionFactory().getCurrentSession().createCriteria(cls_EventCategory.class).setProjection(Projections.property("str_eventcatname")).list();   
		 return  str_eventcatnamelist ;
	
	}

	@Override
	public void update1(cls_Event eve) {
		System.out.println(eve.getEventId());
		sessionFactory.getCurrentSession().update(eve);
	}

	/*@Override
	public String catnames(Integer int_eventcatid) {
		String hql="select str_eventcatname  from cls_EventCategory where int_eventcatid=?"  ;
		 return (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_eventcatid).uniqueResult();
	}*/

}
