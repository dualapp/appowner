package com.appowner.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.InvoiceTemplate;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.TaxTemplate;


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
		List<String> invoiceList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(InvoiceTemplate.class).setCacheable(true).setProjection(Projections.property("str_InvoiceTemplateName")).list();
		
		  return  invoiceList;
	}
	public void saveInvoiceTransaction(InvoiceTransaction invoice)
	{
		getSessionFactory().getCurrentSession().save(invoice);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String taxList(String select) {
		
		String hql="Select int_InvoiceTemplateID from InvoiceTemplate  where str_InvoiceTemplateName=?";
		int invoiceID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,select).uniqueResult();
		
		String hql1="select str_DueInvoiceTemplate from InvoiceTemplate where int_InvoiceTemplateID="+invoiceID;
		String taxlist= (String) getSessionFactory().getCurrentSession().createQuery(hql1).uniqueResult();
		
		
		return taxlist;
	}
	@SuppressWarnings("unchecked")
	public List<String> getTaxList(String str)
	{
		String hql="Select int_DueTemplateID from DueTemplate  where str_DueTemplate=?";
		int dueID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str).uniqueResult();
		
		String hql1="from DueTemplate where int_DueTemplateID="+dueID;
		List<String> taxlist= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).list();
	
		return taxlist;
	}
	@SuppressWarnings("unchecked")
	public List<InvoiceTransaction> listInvoiceTransaction(String str_InvoiceTemplate, String str_Block, String str_ApartmentNo, String str_Status, String str_BillPeriod)
	{
		if(str_InvoiceTemplate==null && str_Block==null && str_ApartmentNo==null && str_Status==null && str_BillPeriod==null)
		{
		   return (List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).list();
	    }
		else
		{
			String hql="from InvoiceTransaction where str_InvoiceTemplate=? AND str_BillPeriod=? AND str_Block=? AND  str_ApartmentNo=? AND str_Status=?";
			return (List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,str_InvoiceTemplate).setParameter(1,str_BillPeriod).setParameter(2, str_Block)
		          .setParameter(3, str_ApartmentNo).setParameter(4, str_Status).list();
		}
		
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
	
		return list;
	}
	public double getTaxAmount(String str1)
	
	{
		
		String hql="select int_Percentage from TaxTemplate where str_TaxName=?";
		
		double ddd=(double)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str1).uniqueResult();
	     System.out.println(ddd);
		return ddd;
	
	}
	public double getSqft(String str)
	{
		String hql="select sqft from User where str_Flat=?";
		double ddd=(double)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str).uniqueResult();
	
		return ddd;
	}
	public String getmailid(String str_ApartmentNo)
	{
		String hql="select str_Email from User where str_Flat=?";
		return (String)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_ApartmentNo).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<String> getAccountName()
	{
		String hql="select str_AccountName from ChartOfAccount where ch_Group='A'";
		List<String> str=(List<String>)getSessionFactory().getCurrentSession().createQuery(hql).list();
		String str1=str.remove(2);
		
		
		return str;
	}
	public void updatePayment(String accountName, String str_Status, Integer id,String dat_InvoiceDate)
	{
		String hql="update InvoiceTransaction set str_Status=?,totalBalance=?,str_paymentAccount=?,dat_PaymentDate=? where int_InvoiceTransactionID=?";
		getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,"Paid").setParameter(1,0.00).setParameter(2,accountName).setParameter(3,dat_InvoiceDate).setParameter(4,id).executeUpdate();
	}
	public InvoiceTransaction getInvoice(Integer int_InvoiceTransactionID)
	{
		return (InvoiceTransaction) getSessionFactory().getCurrentSession().get(InvoiceTransaction.class, int_InvoiceTransactionID);
	}
	
	
	
}
