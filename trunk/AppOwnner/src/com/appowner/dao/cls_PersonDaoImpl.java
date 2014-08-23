package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.*;

@Repository
public class cls_PersonDaoImpl implements cls_PersonDao {

	@Autowired
	private SessionFactory sessionFactory;
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addPerson(cls_Person person) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(person);
	}

	@SuppressWarnings("unchecked")
	public List<cls_Person> listPersons() {
		return (List<cls_Person>) getSessionFactory().getCurrentSession().createCriteria(cls_Person.class).list();
	}

	public cls_Person getPerson(String personId) {
		return (cls_Person) getSessionFactory().getCurrentSession().get(cls_Person.class, personId);
	}

 
	

	public void deletePerson(cls_Person person) {
		getSessionFactory().getCurrentSession().delete(person);
		
	}

	 

	public void update(cls_Person person) {
		System.out.println(person.getPersonId());
		sessionFactory.getCurrentSession().update(person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> cityList1(String enquiry_selectedState) {
		System.out.println(enquiry_selectedState);
	String	hql1="select int_stateId from cls_PersonState where str_StateName=?";
	int stateId=(int) sessionFactory.getCurrentSession().createQuery(hql1).setParameter(0, enquiry_selectedState).uniqueResult();
	 System.out.println(stateId);
		String hql2="select str_CityName from cls_PersonCity where int_StateId=?";
		
		List<String> cityList= sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, stateId).list();
		System.out.println(cityList);
		System.out.println( ( cityList).listIterator().hasNext());
		return cityList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStateList() {
		 
	List<String> stateList=getSessionFactory().getCurrentSession().createCriteria(cls_PersonState.class).setProjection(Projections.property("str_StateName")).list();
	return  stateList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> stateList(String enquiry_selectedCountry) {
	  System.out.println(enquiry_selectedCountry);
	String	hql1="select int_CountryId from cls_PersonCountry where str_CountryName=?";
	int countryId=(int) sessionFactory.getCurrentSession().createQuery(hql1).setParameter(0, enquiry_selectedCountry).uniqueResult();
	 
		String hql2="select str_StateName from cls_PersonState where int_CountryId=?";
		
		List<String> stateList= sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, countryId).list();
		 
		 
		return stateList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCountryList() {
		 
	List<String> countryList=getSessionFactory().getCurrentSession().createCriteria(cls_PersonCountry.class).setProjection(Projections.property("str_CountryName")).list();
	return  countryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> countryList() {
		 
		// String hql=" select str_CityName from VendorCity where str_StateName=str_StateName";
	 
		List<String> countryList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(cls_PersonCountry.class).setProjection(Projections.property("str_CountryName")).list();
		   
		  return  countryList ;
	}

	@Override
	public List<String> stateList() {

		@SuppressWarnings("unchecked")
		List<String> stateList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(cls_PersonState.class).setProjection(Projections.property("str_StateName")).list();
		  
		  return  stateList ;
		 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> cityList() {
		List<String> cityList=getSessionFactory().getCurrentSession().createCriteria(cls_PersonCity.class).setProjection(Projections.property("str_CityName")).list();
		return cityList;
	}

	 
}
