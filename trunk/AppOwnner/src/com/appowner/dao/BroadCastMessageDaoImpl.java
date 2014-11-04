package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.MessageTemplateMaster;
import com.appowner.model.MessageType;
@Repository
public class BroadCastMessageDaoImpl  implements BroadCastMessageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMessageTempTypeList() {
		// TODO Auto-generated method stub
		System.out.println(sessionFactory.getCurrentSession().createCriteria(MessageTemplateMaster.class).setCacheable(true).setProjection(Projections.property("str_MessageTempType")).list());
		return sessionFactory.getCurrentSession().createCriteria(MessageTemplateMaster.class).setCacheable(true).setProjection(Projections.property("str_MessageTempType")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageType> getMessageTypeList() {
		// TODO Auto-generated method stub
		System.out.println(sessionFactory.getCurrentSession().createCriteria(MessageType.class).setCacheable(true).list());
		return sessionFactory.getCurrentSession().createCriteria(MessageType.class).setCacheable(true).list();
	}
}
