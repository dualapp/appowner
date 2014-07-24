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
	public List<String> taxList() {
		String hql="from DueTemplate";
		List<String> taxlist=(List<String>) getSessionFactory().getCurrentSession().createQuery(hql).list();
		System.out.println(taxlist);
		return taxlist;
	}
}
