package com.appowner.dao;

import java.util.Date;
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
		  System.out.println("priyahuyt");
		   return (List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).list();
		}
		else if(str_InvoiceTemplate.isEmpty())
		{
			System.out.println("priyahuyt111111");
			   return (List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).list();
		}
		else
		{    System.out.println("simranhvhh");
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
	public void updatePayment(String accountName, double totalBalance,double dueBalance, String str_Status, Integer id, Date dat_InvoiceDate,Date payment_Date, Integer payment_No)
	{
		String hql="update InvoiceTransaction set str_Status=?,totalBalance=?,dueBalance=?,str_paymentAccount=?,dat_PaymentDate=?,Payment_No=?,Payment_Date=? where int_InvoiceTransactionID=?";
		getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_Status).setParameter(1,totalBalance).setParameter(2, dueBalance).setParameter(3,accountName).setDate(4,dat_InvoiceDate).setParameter(5, payment_No).setParameter(6, payment_Date).setParameter(7,id).executeUpdate();
	}
	public InvoiceTransaction getInvoice(Integer int_InvoiceTransactionID)
	{
		return (InvoiceTransaction) getSessionFactory().getCurrentSession().get(InvoiceTransaction.class, int_InvoiceTransactionID);
	}
	public double getAmount(Integer id)
	{
		String hql="select totalDue from InvoiceTransaction where int_InvoiceTransactionID=?";
		return (double) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,id).uniqueResult();
	}
	
	
}
