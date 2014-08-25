package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.DueTemplate;
import com.appowner.model.DueTransaction;
import com.appowner.model.Vendor;

@Repository
public class DueDaoImpl implements DueDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<String> getAccountsList()
	{
		List<String> accountList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setProjection(Projections.property("str_Accounts")).list();
		return accountList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getDueTemplate()
	{
		List<String> dueTemplateList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setProjection(Projections.property("str_DueTemplate")).list();
		return dueTemplateList;
	}
	public void saveDueTransaction(DueTransaction due)
	{
		getSessionFactory().getCurrentSession().save(due);
	}
	@SuppressWarnings("unchecked")
	public List<DueTransaction> listDueTransaction()
	{
		return getSessionFactory().getCurrentSession().createCriteria(DueTransaction.class).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<String> getBlockList(String str_Organisation)
	{
		String hql="select str_Block from User where str_Apartment=?";
		return (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Organisation).list();
	}
	@SuppressWarnings("unchecked")
	public List<String> getApartmentlist(String str_Block)
	{
		String hql="select str_Flat from User where str_Block=?";
		List<String> list=(List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Block).list();
		System.out.println(list);
		return list;
	}
}
