package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.InvoiceTemplate;
import com.appowner.model.InvoiceTransaction;


@Repository
public class InvoiceDaoImpl implements InvoiceDao {
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<String> getInvoiceName()
	{
		List<String> invoiceList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(InvoiceTemplate.class).setProjection(Projections.property("str_InvoiceTemplateName")).list();
		  System.out.println(invoiceList);
		  return  invoiceList;
	}
	public void saveInvoiceTransaction(InvoiceTransaction invoice)
	{
		getSessionFactory().getCurrentSession().save(invoice);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String taxList(String select) {
		System.out.println(select);
		String hql="Select int_InvoiceTemplateID from InvoiceTemplate  where str_InvoiceTemplateName=?";
		int invoiceID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,select).uniqueResult();
		System.out.println(invoiceID);
		String hql1="select str_DueInvoiceTemplate from InvoiceTemplate where int_InvoiceTemplateID="+invoiceID;
		String taxlist= (String) getSessionFactory().getCurrentSession().createQuery(hql1).uniqueResult();
		
		System.out.println(taxlist);
		return taxlist;
	}
	@SuppressWarnings("unchecked")
	public List<String> getTaxList(String str)
	{
		String hql="Select int_DueTemplateID from DueTemplate  where str_DueTemplate=?";
		int dueID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str).uniqueResult();
		System.out.println(dueID);
		String hql1="from DueTemplate where int_DueTemplateID="+dueID;
		List<String> taxlist= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).list();
		System.out.println(taxlist.iterator().hasNext());
		System.out.println(taxlist);
		return taxlist;
	}
	@SuppressWarnings("unchecked")
	public List<InvoiceTransaction> listInvoiceTransaction()
	{
		return (List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).list();
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
