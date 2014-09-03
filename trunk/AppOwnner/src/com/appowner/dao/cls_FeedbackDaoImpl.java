package com.appowner.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.*;

@Repository
public class cls_FeedbackDaoImpl implements cls_FeedbackDao {
@Autowired
	private SessionFactory sessionFactory;



public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

@Override
public void addFeedback(cls_Feedback feedback) {
	getSessionFactory().getCurrentSession().save(feedback);
}

@SuppressWarnings("unchecked")
@Override
public List<cls_Feedback> listFeedbacks() {
	return (List<cls_Feedback>) getSessionFactory().getCurrentSession().createCriteria(cls_Feedback.class).list();
}

@Override
public void deleteFeedback1(cls_Feedback feedback) {
	sessionFactory.getCurrentSession().createQuery("DELETE FROM cls_Feedback WHERE feedbackid = "+feedback.getFeedbackId()).executeUpdate();
}

@Override
public cls_Feedback getFeedback1(Integer feedbackId) {
	return (cls_Feedback) getSessionFactory().getCurrentSession().get(cls_Feedback.class,feedbackId);
}

@Override
public void update(cls_Feedback feedback) {
	sessionFactory.getCurrentSession().update(feedback);
}
}
