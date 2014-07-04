package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.*;
import com.appowner.model.*;


@Service("cls_PersonService")
@Transactional 
public class cls_PersonServiceImpl implements cls_PersonService {

	@Autowired
	private cls_PersonDao personDao;
	
	 public cls_PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(cls_PersonDao personDao) {
		this.personDao = personDao;
	}

	public void addPerson(cls_Person person) {
		 System.out.println(personDao);
		 
		getPersonDao().addPerson(person);
	}
	
	public List<cls_Person> listPersons() {
		return getPersonDao().listPersons();
	}

	public cls_Person getPerson(int personId) {
		return personDao.getPerson(personId);
	}
	
	public void deletePerson(cls_Person person) {
		getPersonDao().deletePerson(person);
	}
 

	@Override
	public void update(cls_Person person) {
		getPersonDao().update(person);
		
	}

	/*@Override
	public Object list(String enquiry_selectedState) {
		getPersonDao().update();
		
	}*/

	@Override
	public List<String> cityList1(String enquiry_selectedState) {
		  
		return getPersonDao().cityList1(enquiry_selectedState) ;
	}

	@Override
	public List<String> getStateList() {
		 
		return getPersonDao().getStateList();
	}

	@Override
	public List<String> stateList(String enquiry_selectedCountry) {
		  
		return getPersonDao().stateList(enquiry_selectedCountry) ;
	}

	@Override
	public List<String> getCountryList() {
		 
		return getPersonDao().getCountryList();
	}

	@Override
	public List<String> countryList() {
		return getPersonDao().countryList();
	}
	
	@Override
	public List<String> stateList() {
		return getPersonDao().stateList();
	}

	@Override
	public List<String> cityList() {
		// TODO Auto-generated method stub
		return getPersonDao().cityList();
	}

	

	
	}