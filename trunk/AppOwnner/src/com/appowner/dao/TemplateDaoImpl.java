package com.appowner.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Complain;
import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.MessageTemplate;
import com.appowner.model.TaxTemplate;
import com.appowner.model.Vendor;
import com.appowner.util.Util;

@Repository
public class TemplateDaoImpl implements TemplateDao {
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Integer apartmentID;
	public Integer getApartmentID() {
		apartmentID=Util.getAppartmentId();
		return apartmentID;
	}
	public void setApartmentID(Integer apartmentID) {
		this.apartmentID = apartmentID;
	}
	public Integer saveDueTemplate(DueTemplate dueTemplate)
	{
		int rr=(Integer) getSessionFactory().getCurrentSession().save(dueTemplate);
		
		return rr;
	}
	@SuppressWarnings("unchecked")
	public List<String> listRavenues()
	{getApartmentID();
	String hql=" select str_AccountName from ChartOfAccount  where ch_Group='R'AND int_ApartmentId=0 or int_ApartmentId=?" ;
	 
	List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0, apartmentID).list();
	return ravenueList; 
	}
	 public Integer saveTaxTemplate(TaxTemplate taxTemplate)
	 {
		return  (Integer) getSessionFactory().getCurrentSession().save(taxTemplate); 
	 }
	 public Integer saveInvoiceTemplate(InvoiceTemplate invoiceTemplate)
	 {
		return  (Integer) getSessionFactory().getCurrentSession().save(invoiceTemplate);  
	 }
	 public Integer saveMessageTemplate(MessageTemplate messageTemplate)
	 {
		return  (Integer) getSessionFactory().getCurrentSession().save(messageTemplate);  
	 }
	 @SuppressWarnings("unchecked")
	public List<DueTemplate> listDueTemplate(String str_Accounts)
	 {   getApartmentID();
		 if(str_Accounts==null)
	     {   System.out.println("dfjkjkdfdkj");
		    return (List<DueTemplate>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).add(Restrictions.eq("int_Organisation", apartmentID)).setCacheable(true).list();
	     }
	 else
	 {    System.out.println("jdjkdffjkfdjk");
	     System.out.println(str_Accounts+"fggfkj");
		 String hql="from DueTemplate  where str_Accounts=? AND int_Organisation=?";
		    return (List<DueTemplate>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_Accounts).setParameter(1, apartmentID).setCacheable(true).list();
	 }
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<InvoiceTemplate> listInvoiceTemplate(){
		 getApartmentID();
		 return (List<InvoiceTemplate>) getSessionFactory().getCurrentSession().createCriteria(InvoiceTemplate.class).setCacheable(true).add(Restrictions.eq("int_Organisation", apartmentID)).list(); 
	 }
	 @SuppressWarnings("unchecked")
	public List<TaxTemplate> listTaxTemplate()
	 { getApartmentID();
		 return (List<TaxTemplate>) getSessionFactory().getCurrentSession().createCriteria(TaxTemplate.class).setCacheable(true).add(Restrictions.eq("int_Organisation", apartmentID)).list();
	 }
	 @SuppressWarnings("unchecked")
	 public List<MessageTemplate> listMessageTemplate(String str_Mode, String str_Category)
	{  getApartmentID();
	System.out.println(str_Mode+"gfgfgf");
	System.out.println(str_Category+"fggkjgkjgf");
		 if(str_Mode==null && str_Category==null)
	    {  
		 return (List<MessageTemplate>) getSessionFactory().getCurrentSession().createCriteria(MessageTemplate.class).add(Restrictions.eq("int_Organisation", apartmentID)).setCacheable(true).list(); 
	     }
		 else if(str_Mode.isEmpty() && str_Category.isEmpty())
		 {
			 return (List<MessageTemplate>) getSessionFactory().getCurrentSession().createCriteria(MessageTemplate.class).add(Restrictions.eq("int_Organisation", apartmentID)).setCacheable(true).list(); 
		 }
	   else
	   {   System.out.println(apartmentID+"lkffgkl");
		   String hql="from MessageTemplate  where str_Mode=? and str_Category=? and int_Organisation=?";
		   return (List<MessageTemplate>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_Mode).setParameter(1,str_Category).setParameter(2, apartmentID).setCacheable(true).list();
	   }
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<String> getTaxName(){
		 getApartmentID();
		 String hql=" select str_TaxName from TaxTemplate where int_Organisation=?";
		 
			List<String> taxList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0, apartmentID).list();
			return taxList; 
	 }
	 public DueTemplate getDueTemplate(Integer int_DueTemplateID)
	 {
		 return (DueTemplate)getSessionFactory().getCurrentSession().get(DueTemplate.class,int_DueTemplateID);
	 }
	 public void updateDueTemplate(DueTemplate dueTemplate)
	 {
		 sessionFactory.getCurrentSession().update(dueTemplate);
	 }
	 public InvoiceTemplate getInvoiceTemplate(Integer int_InvoiceTemplateID)
	 {
		 return (InvoiceTemplate)getSessionFactory().getCurrentSession().get(InvoiceTemplate.class,int_InvoiceTemplateID); 
	 }
	 public void updateInvoiceTemplate(InvoiceTemplate invoiceTemplate)
	 {
		 sessionFactory.getCurrentSession().update(invoiceTemplate);
	 }
	 public TaxTemplate getTaxTemplate(Integer int_TaxTemplateID)
	 {
		 return (TaxTemplate)getSessionFactory().getCurrentSession().get(TaxTemplate.class,int_TaxTemplateID); 
	 }
	 public void updateTaxTemplate(TaxTemplate taxTemplate)
	 {
		 sessionFactory.getCurrentSession().update(taxTemplate);
	 }
	 public MessageTemplate getMessageTemplate(Integer int_MessageTemplateID)
	 {
		 return (MessageTemplate)getSessionFactory().getCurrentSession().get(MessageTemplate.class,int_MessageTemplateID);
	 }
	 public void updateMessageTemplate(MessageTemplate messageTemplate)
	 {
		 sessionFactory.getCurrentSession().update(messageTemplate);
	 }
	
	@SuppressWarnings("unchecked")
	public List<String> getDueTemplate(String frequency)
	{    getApartmentID();
	   if(frequency==null)
	   {
		   String hql="select str_DueTemplate from DueTemplate where str_Frequency=? and int_Organisation=?" ;
			List<String> dueList=(List<String>)  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,"Monthly").setParameter(1, apartmentID).setCacheable(true).list();
			
				return dueList; 
	   }
	   else
	   {   
		String hql="select str_DueTemplate from DueTemplate where str_Frequency=? and int_Organisation=?" ;
		List<String> dueList=(List<String>)  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,frequency).setParameter(1, apartmentID).setCacheable(true).list();
		
			return dueList; 
	   }
	 }
	@SuppressWarnings("unchecked")
	public List<String> getMessageTemplate(String str)
	{
		String hql="select str_Title from MessageTemplate where str_Category=? and int_Organisation=?";
		List<String> str1= (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str).setParameter(1,Util.getAppartmentId()).setCacheable(true).list();
		return str1;
		
	}
	public String getDescription(String str)
	{    String hql="select int_MessageTemplateID from MessageTemplate  where str_Title=? and int_Organisation=?";
	      int ID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str).setParameter(1,Util.getAppartmentId()).setCacheable(true).uniqueResult();
	 
	   String hql1="select str_Description from MessageTemplate where int_MessageTemplateID="+ID;
	   String str1= (String)getSessionFactory().getCurrentSession().createQuery(hql1).setCacheable(true).uniqueResult();
	    return str1;
		
	}
	@SuppressWarnings("unchecked")
	public List<DueTemplate> searchDueTemplate(String account)
	{     getApartmentID();
		 String hql="from DueTemplate  where str_Accounts=?";
	    return (List<DueTemplate>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,account).setCacheable(true).list();
	}
	public void deleteDue(DueTemplate dueTemplate)
	{
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM DueTemplate WHERE int_DueTemplateID = "+dueTemplate.getInt_DueTemplateID()).executeUpdate();
	}
	public void deleteInvoice(InvoiceTemplate invoice)
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM InvoiceTemplate WHERE int_InvoiceTemplateID="+invoice.getInt_InvoiceTemplateID()).executeUpdate();
	}
	public void deleteMessage(MessageTemplate message)
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM MessageTemplate WHERE int_MessageTemplateID = "+message.getInt_MessageTemplateID()).executeUpdate();
	}
	public void deleteTax(TaxTemplate tax)
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM TaxTemplate WHERE int_TaxTemplateID = "+tax.getInt_TaxTemplateID()).executeUpdate();
	}
	public void deleteDue1(List<DueTemplate> delete)
	{
		ListIterator itr=delete.listIterator();
		while(itr.hasNext())
		{
			DueTemplate v=(DueTemplate) itr.next();
		sessionFactory.getCurrentSession().delete(v);
		}
	}
	public void deleteInvoice1(List<InvoiceTemplate> delete)
	{
		ListIterator itr=delete.listIterator();
		while(itr.hasNext())
		{
			InvoiceTemplate v=(InvoiceTemplate) itr.next();
		sessionFactory.getCurrentSession().delete(v);
		}
	}
	public void deleteMessage1(List<MessageTemplate> delete)
	{
		ListIterator itr=delete.listIterator();
		while(itr.hasNext())
		{
			MessageTemplate v=(MessageTemplate) itr.next();
		sessionFactory.getCurrentSession().delete(v);
		}
	}
	public void deleteTax1(List<TaxTemplate> delete)
	{
		ListIterator itr=delete.listIterator();
		while(itr.hasNext())
		{
			TaxTemplate v=(TaxTemplate) itr.next();
		sessionFactory.getCurrentSession().delete(v);
		}
	}
	public boolean detectDueTemplate(String str)
	{   getApartmentID();
		String hql=" select str_DueTemplate from DueTransaction where str_DueTemplate=? and str_Organisation=?" ;
		List<String> id=(List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,str).setParameter(1, apartmentID).list();
		System.out.println(id.contains(str)+"jfdfd");
		return id.contains(str);
		
	}
	public boolean detectInvoiceTemplate(String str)
	{
		String hql=" select str_InvoiceTemplate from InvoiceTransaction where str_InvoiceTemplate=? and int_Organisation=?" ;
		List<String> id=(List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,str).setParameter(1,Util.getAppartmentId()).list();
		System.out.println(id+"dsjfdhjjfgjf");
		System.out.println(id.contains(str)+"jfdfd");
		return id.contains(str);
	}
	public String getCalculation()
	{
		 getApartmentID();
			String hql=" select str_Calculation from DueTemplate where int_DueTemplateID=3 and int_Organisation=12" ;
			String id=(String) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println(id+"jfdfd");
			return id;
	}
	public int getTaxID(String str)
	{
		 String hql="select int_TaxTemplateID from TaxTemplate where int_Organisation=? and str_TaxName=?";
		 Integer id=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Util.getAppartmentId()).setParameter(1,str).setCacheable(true).uniqueResult();
		 return id;
	}
}
