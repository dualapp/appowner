package com.appowner.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.InvoiceTemplate;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.TaxTemplate;
import com.appowner.model.Vendor;
import com.appowner.util.Util;


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
	{   System.out.println(str_InvoiceTemplate+"kjjj");
	    System.out.println(str_Block+"jjjh");
	    System.out.println(str_ApartmentNo+"kjnjj");
	    System.out.println(str_Status+"hjhjjh");
	    System.out.println(str_BillPeriod+"jhjfddj");
	    System.out.println("hjfjhfjgj");
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
		else if(str_Status==null)
		{   System.out.println("jkfdfjkdfgfg");
			 String hql="from InvoiceTransaction where str_InvoiceTemplate=? AND str_BillPeriod=? AND str_Block=? AND  str_ApartmentNo=?"; 
				return (List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,str_InvoiceTemplate).setParameter(1,str_BillPeriod).setParameter(2, str_Block)
			          .setParameter(3, str_ApartmentNo).list(); 
		 }
		 else
		 {   System.out.println("jndfjfdjfjdk");
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
		String str="select str_AccountName from ChartOfAccount where str_AccountType=? OR str_AccountType=?";
		List<String> str1=(List<String>)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,"Bank").setParameter(1, "Cash").setCacheable(true).list();
		
		
		
		return str1;
	}
	public void updatePayment(String accountName,String paymentMode, double totalBalance,double dueBalance, String str_Status, Integer id, Date dat_InvoiceDate,Date payment_Date, Integer payment_No, String deposite_Account_Name)
	{
		String hql="update InvoiceTransaction set str_Status=?,str_paymentMode=?,totalBalance=?,dueBalance=?,str_paymentAccount=?,dat_PaymentDate=?,Payment_No=?,Payment_Mode_Date=?,deposit_Account=? where int_InvoiceTransactionID=?";
		getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_Status).setParameter(1,paymentMode).setParameter(2, totalBalance).setParameter(3,dueBalance).setParameter(4,accountName).setDate(5, dat_InvoiceDate).setParameter(6, payment_No).setDate(7, payment_Date).setParameter(8, deposite_Account_Name).setParameter(9,id).executeUpdate();
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
	public void deleteInvoice(Integer id)
	{
		getSessionFactory().getCurrentSession().createQuery("DELETE FROM InvoiceTransaction WHERE int_InvoiceTransactionID = "+id).executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<String> getlistAccountName()
	{
		String hql="select str_acount_Name from Account";
		return getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	}
	public void deleteDues(String str)
	{
		String hql="update DueTransaction set int_InvoiceNo=? where int_InvoiceNo=?";
		getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,null).setParameter(1,str).executeUpdate();
		
	}
	public String getStatus(int id)
	{
		String hql="select str_Status from InvoiceTransaction where int_InvoiceTransactionID=?";
		return (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,id).setCacheable(true).uniqueResult();
	}
	public String getPeriod(String select)
	{   System.out.println(select+"hjyhjjuhjuj");
		String hql="select str_Frequency from InvoiceTemplate  where str_InvoiceTemplateName=?";
		return (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,select).setCacheable(true).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Double> getOutstandingBalance()
	{
		Integer  id=Util.getAppartmentId();
		String hql="select totalBalance from InvoiceTransaction  where int_Organisation=?";
		return (List<Double>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,id).setCacheable(true).list();
	}
	
}
