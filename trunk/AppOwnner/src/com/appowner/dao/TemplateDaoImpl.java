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
	public Integer saveDueTemplate(DueTemplate dueTemplate)
	{
		int rr=(Integer) getSessionFactory().getCurrentSession().save(dueTemplate);
		
		return rr;
	}
	@SuppressWarnings("unchecked")
	public List<String> listRavenues()
	{
	String hql=" select str_AccountName from ChartOfAccount  where str_AccountType='Income'";
	 
	List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
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
	 {   if(str_Accounts==null)
	     {
		    return (List<DueTemplate>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setCacheable(true).list();
	     }
	 else
	 {
		 String hql="from DueTemplate  where str_Accounts=?";
		    return (List<DueTemplate>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_Accounts).setCacheable(true).list();
	 }
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<InvoiceTemplate> listInvoiceTemplate(){
		 return (List<InvoiceTemplate>) getSessionFactory().getCurrentSession().createCriteria(InvoiceTemplate.class).setCacheable(true).list(); 
	 }
	 @SuppressWarnings("unchecked")
	public List<TaxTemplate> listTaxTemplate()
	 {
		 return (List<TaxTemplate>) getSessionFactory().getCurrentSession().createCriteria(TaxTemplate.class).setCacheable(true).list();
	 }
	 @SuppressWarnings("unchecked")
	 public List<MessageTemplate> listMessageTemplate(String str_Mode, String str_Category)
	{  if(str_Mode==null && str_Category==null)
	    {
		 return (List<MessageTemplate>) getSessionFactory().getCurrentSession().createCriteria(MessageTemplate.class).setCacheable(true).list(); 
	     }
	   else
	   {
		   String hql="from MessageTemplate  where str_Mode=? and str_Category=?";
		   return (List<MessageTemplate>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_Mode).setParameter(1,str_Category).setCacheable(true).list();
	   }
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<String> getTaxName(){
		 String hql=" select str_TaxName from TaxTemplate";
		 
			List<String> taxList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
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
	{
		String hql="select str_DueTemplate from DueTemplate where str_Frequency=?";
		List<String> dueList=(List<String>)  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,frequency).setCacheable(true).list();
		//  List<String> dueList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).add(Restrictions.eq("salary", 2000));
			return dueList;  
	 }
	@SuppressWarnings("unchecked")
	public List<String> getMessageTemplate()
	{
		String hql="select str_Title from MessageTemplate where str_Category='Dues'";
		List<String> str= (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return str;
		
	}
	public String getDescription(String str)
	{    String hql=" select int_MessageTemplateID from MessageTemplate  where str_Title=?";
	      int ID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str).setCacheable(true).uniqueResult();
	 
	   String hql1="select str_Description from MessageTemplate where int_MessageTemplateID="+ID;
	   String str1= (String)getSessionFactory().getCurrentSession().createQuery(hql1).setCacheable(true).uniqueResult();
	    return str1;
		
	}
	@SuppressWarnings("unchecked")
	public List<DueTemplate> searchDueTemplate(String account)
	{
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
}
