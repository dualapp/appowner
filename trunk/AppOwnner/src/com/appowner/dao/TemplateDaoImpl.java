package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	 
}
