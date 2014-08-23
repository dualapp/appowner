package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.*;

@SuppressWarnings("unchecked")
@Repository
public class cls_MessageTemplateDaoImpl implements cls_MessageTemplateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addMessage(cls_Message msg) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(msg);
	}
	
	public List<cls_Message> listMessages() {
		return (List<cls_Message>) getSessionFactory().getCurrentSession().createCriteria(cls_Message.class).list();
	}
	
	public cls_Message getMessage(String messageId) {
		return (cls_Message) getSessionFactory().getCurrentSession().get(cls_Message.class, messageId);
	}
	
	public void deleteMessage(cls_Message msg) {
		System.out.println(msg.getMessageId());
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM cls_Message WHERE messageid = "+msg.getMessageId()).executeUpdate();
	}

	 

	public void update(cls_Message msg) {
		System.out.println(msg.getMessageId());
		sessionFactory.getCurrentSession().update(msg);
	}

	@Override
	public List<String> getMessageCategoryList() {
		System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
		List<String> messageCategoryList= (List<String>)getSessionFactory().getCurrentSession().createCriteria(cls_MessageCategory.class).setProjection(Projections.property("var_MessageCategory")).list();
		System.out.println("hi");
		System.out.println(messageCategoryList);
		return messageCategoryList;
		 
	}
	
	

	 
}
