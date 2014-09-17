package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.PanelPrice;

@Repository
public class AdvertisementDaoImpl implements AdvertisementDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addCompany(Company company)
	{
		getSessionFactory().getCurrentSession().save(company);
	}
	public void addCompanyPerson(CompanyPerson person)
	{
		getSessionFactory().getCurrentSession().save(person);	
	}
	public void addPanel(PanelPrice panel)
	{
		getSessionFactory().getCurrentSession().save(panel);	
	}
	 @SuppressWarnings("unchecked")
	public List<PanelPrice> listPanelPrice()
	 {
		 return (List<PanelPrice>) getSessionFactory().getCurrentSession().createCriteria(PanelPrice.class).list();
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<Company> listCompany()
	 {
		 return (List<Company>) getSessionFactory().getCurrentSession().createCriteria(Company.class).list(); 
	 }
	 @SuppressWarnings("unchecked")
		public List<CompanyPerson> listCompanyPerson()
	    {
	    	 return (List<CompanyPerson>) getSessionFactory().getCurrentSession().createCriteria(CompanyPerson.class).list();	
	    }
	 public Company getCompany(int int_CompanyID)
	 {
		 return (Company)getSessionFactory().getCurrentSession().get(Company.class,int_CompanyID); 
	 }
	 @SuppressWarnings("unchecked")
	public List<CompanyPerson> getCompanyPerson(int int_CompanyID)
	 {String hql1="from CompanyPerson where int_CompanyID=?";
		List<CompanyPerson> person= (List<CompanyPerson>)getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,int_CompanyID).list();
		return person;
		  
		 
	 }
	 public void update(Company cmp1)
	 {
		 sessionFactory.getCurrentSession().update(cmp1); 
	 }
	 public void update(CompanyPerson person)
	 {
		 sessionFactory.getCurrentSession().update(person); 
	 }
	 public void updatePanel(PanelPrice panel)
	 {
		 sessionFactory.getCurrentSession().update(panel); 
	 }
	 public CompanyPerson getCompanyPerson1(int int_CompanyPersonID)
	 {
		 return (CompanyPerson)getSessionFactory().getCurrentSession().get(CompanyPerson.class,int_CompanyPersonID); 
	 }
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> listperson() {
		return getSessionFactory().getCurrentSession().createCriteria(Company.class).setProjection(Projections.property("str_CompanyName")).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> listoperation(String select) {
		String str="from Company where str_CompanyName=?";
		return (List<Company>) getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,select).list();
		
	}
	

}
