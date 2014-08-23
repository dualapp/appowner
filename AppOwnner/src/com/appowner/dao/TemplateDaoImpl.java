package com.appowner.dao;

import java.util.List;

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
	public void saveDueTemplate(DueTemplate dueTemplate)
	{
		getSessionFactory().getCurrentSession().save(dueTemplate);
	}
	@SuppressWarnings("unchecked")
	public List<String> listRavenues()
	{System.out.println("hi");
	String hql=" select str_Acct_GroupName from AccountingGroup  where ch_Group='R'";
	 
	List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).list();
	System.out.println(ravenueList);
	return ravenueList; 
	}
	 public void saveTaxTemplate(TaxTemplate taxTemplate)
	 {
		 getSessionFactory().getCurrentSession().save(taxTemplate); 
	 }
	 public void saveInvoiceTemplate(InvoiceTemplate invoiceTemplate)
	 {
		 getSessionFactory().getCurrentSession().save(invoiceTemplate);  
	 }
	 public void saveMessageTemplate(MessageTemplate messageTemplate)
	 {
		 getSessionFactory().getCurrentSession().save(messageTemplate);  
	 }
	 @SuppressWarnings("unchecked")
	public List<DueTemplate> listDueTemplate()
	 {
		 return (List<DueTemplate>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).list();
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<InvoiceTemplate> listInvoiceTemplate(){
		 return (List<InvoiceTemplate>) getSessionFactory().getCurrentSession().createCriteria(InvoiceTemplate.class).list(); 
	 }
	 @SuppressWarnings("unchecked")
	public List<TaxTemplate> listTaxTemplate()
	 {
		 return (List<TaxTemplate>) getSessionFactory().getCurrentSession().createCriteria(TaxTemplate.class).list();
	 }
	 @SuppressWarnings("unchecked")
	public List<MessageTemplate> listMessageTemplate()
	{
		 return (List<MessageTemplate>) getSessionFactory().getCurrentSession().createCriteria(MessageTemplate.class).list(); 
	 }
	 @SuppressWarnings("unchecked")
	public List<String> getTaxName(){
		 String hql=" select str_TaxName from TaxTemplate";
		 
			List<String> taxList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).list();
			System.out.println(taxList);
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
	
	public List<String> getDueTemplate(String frequency)
	 {    System.out.println(frequency);
		  @SuppressWarnings("unchecked")
		  List<String> dueList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setProjection(Projections.property("str_DueTemplate")).list();
		  System.out.println(dueList.iterator().hasNext());
			System.out.println(dueList);
			return dueList;  
	 }
	@SuppressWarnings("unchecked")
	public List<String> getMessageTemplate()
	{
		String hql="select str_Title from MessageTemplate where str_Category='Dues'";
		List<String> str= (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).list();
		System.out.println(str);
		return str;
		
	}
	public String getDescription(String str)
	{    String hql=" select int_MessageTemplateID from MessageTemplate  where str_Title=?";
	      int ID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str).uniqueResult();
	 
	   String hql1="select str_Description from MessageTemplate where int_MessageTemplateID="+ID;
	   String str1= (String)getSessionFactory().getCurrentSession().createQuery(hql1).uniqueResult();
	    System.out.println(str1);
	    return str1;
		
	}
}
