package com.appowner.dao;

import java.util.List;

import com.appowner.model.*;

public interface cls_PersonDao {
		
		public void addPerson(cls_Person person);

		public List<cls_Person> listPersons();
		
		public cls_Person getPerson(String personid);
		
		public void deletePerson(cls_Person person);

		 

		public void update(cls_Person person);

		public List<String> cityList1(String enquiry_selectedState);

		public List<String> getStateList();

		public List<String> stateList(String enquiry_selectedCountry);

		public List<String> getCountryList();

		public List<String> countryList();

		public List<String> stateList();

		public List<String> cityList();

		
	}
