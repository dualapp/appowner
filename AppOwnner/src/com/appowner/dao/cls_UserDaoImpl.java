package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.*;

@Repository
public class cls_UserDaoImpl implements cls_UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(cls_User user) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<cls_User> listUsers() {
		return (List<cls_User>) getSessionFactory().getCurrentSession().createCriteria(cls_User.class).list();
	}

	public cls_User getUser(int userid) {
		return (cls_User) getSessionFactory().getCurrentSession().get(cls_User.class, userid);
	}

 
	

	public void deleteUser(cls_User user) {
		System.out.println(user.getUserId());
		sessionFactory.getCurrentSession().createQuery("DELETE FROM cls_User WHERE userid = "+user.getUserId()).executeUpdate();
	}

	 

	public void update(cls_User user) {
		System.out.println(user.getUserId());
		sessionFactory.getCurrentSession().update(user);
	}

	 
}
