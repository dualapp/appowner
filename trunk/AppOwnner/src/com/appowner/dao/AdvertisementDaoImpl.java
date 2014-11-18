package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.PanelPrice;
import com.appowner.model.agency_information;
import com.appowner.model.cls_MakePayment;

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
		 return (List<PanelPrice>) getSessionFactory().getCurrentSession().createCriteria(PanelPrice.class).setCacheable(true).list();
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
	@Override
	public void addagencies(agency_information agency) {
		getSessionFactory().getCurrentSession().save(agency);	
	}
	@Override
	public int agency1(String agencyname1) {
		String hql1="select int_CompanyID from Company  where str_CompanyName=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, agencyname1).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	}
	@Override
	public List<agency_information> agencies1() {
		String  query = "{ CALL agency() }";
		
		 @SuppressWarnings("unchecked")
		List<agency_information> kkk = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(agency_information.class)
		).list();
	      System.out.println("kkk");   
		 return kkk;
	}
	@Override
	public void Deleted(agency_information category) {
		getSessionFactory().getCurrentSession().createQuery("delete from agency_information where   int_agencyid="+category.getInt_agencyid()).executeUpdate();
		
	}
	@Override
	public agency_information editproduct(Integer int_agencyid) {
		return(agency_information)getSessionFactory().getCurrentSession().get(agency_information.class,int_agencyid);
	}
	@Override
	public int editproductaa(Integer int_agencyid) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(int_agencyid);
		String hql2="select int_CompanyID from agency_information where int_agencyid=?";
		System.out.println("8888888888888888888888888888888888");
		return (int) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, int_agencyid).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> editproduct2(int prointcatid) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(prointcatid);
		String hql2=" from Company where int_CompanyID=?";
		System.out.println("8888888888888888888888888888888888");
		return   sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, prointcatid).list();
	}
	@Override
	public void deleted(agency_information detail) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM agency_information WHERE int_agencyid="+detail.getInt_agencyid()).executeUpdate();
		
	}
	@Override
	public void payment(cls_MakePayment pay) {
		getSessionFactory().getCurrentSession().save(pay);
		
	}
	@Override
	public int adv(String intdocid1) {
		String hql1="select int_agencyid from agency_information  where ads_type=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, intdocid1).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	
	}
	@Override
	public int adv1(String intdocid1) {
		String hql1="select int_agencyid from agency_information  where str_CompanyName=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid1=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, intdocid1).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid1);
		 return cid1;
	}
	

}
