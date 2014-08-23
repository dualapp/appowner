package com.appowner.model;

import java.io.Serializable;
import java.util.*;

import javax.faces.event.ValueChangeEvent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_EnquiryForm")
public class cls_Person implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	 

	 

	@Id
	@Column(name = "personid")
	private String personId;
	@Column
	private String personEmail;
	private String personMessage;
	private String enquiry_selectedCountry;
	private String enquiry_selectedState;
	private String enquiry_selectedCity;
	private String personPhone;
	private String personZip;
	/*private List<String> str_UserCities;
	 private List<String>  cityListByState;
	 private List<String> str_ApartmentListByState;
	 private List<String> str_UserCountries;
	 private List<String> str_UserStates; */
	 
//	private String RandomnumberGenerator;
	
	
/*	public String getRandomnumberGenerator() {
		return RandomnumberGenerator;
	}

	public void setRandomnumberGenerator(String randomnumberGenerator) {
		RandomnumberGenerator = randomnumberGenerator;
	}*/

/*	public List<String> getStr_UserCities() {
		return str_UserCities;
	}

	public void setStr_UserCities(List<String> str_UserCities) {
		this.str_UserCities = str_UserCities;
	}

	public List<String> getCityListByState() {
		return cityListByState;
	}

	public void setCityListByState(List<String> cityListByState) {
		this.cityListByState = cityListByState;
	}

	public List<String> getStr_ApartmentListByState() {
		return str_ApartmentListByState;
	}

	public void setStr_ApartmentListByState(List<String> str_ApartmentListByState) {
		this.str_ApartmentListByState = str_ApartmentListByState;
	}

	public List<String> getStr_UserCountries() {
		return str_UserCountries;
	}

	public void setStr_UserCountries(List<String> str_UserCountries) {
		this.str_UserCountries = str_UserCountries;
	}

	public List<String> getStr_UserStates() {
		return str_UserStates;
	}

	public void setStr_UserStates(List<String> str_UserStates) {
		this.str_UserStates = str_UserStates;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}*/

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getPersonZip() {
		return personZip;
	}

	public void setPersonZip(String personZip) {
		this.personZip = personZip;
	}


	
	 
	public String getEnquiry_selectedCountry() {
		return enquiry_selectedCountry;
	}

	public void setEnquiry_selectedCountry(String enquiry_selectedCountry) {
		this.enquiry_selectedCountry = enquiry_selectedCountry;
	}

	public String getEnquiry_selectedState() {
		return enquiry_selectedState;
	}

	public void setEnquiry_selectedState(String enquiry_selectedState) {
		this.enquiry_selectedState = enquiry_selectedState;
	}

	public String getEnquiry_selectedCity() {
		return enquiry_selectedCity;
	}

	public void setEnquiry_selectedCity(String enquiry_selectedCity) {
		this.enquiry_selectedCity = enquiry_selectedCity;
	}


	/*private String enquiry_zip;

	public String getEnquiry_zip() {
		return enquiry_zip;
	}

	public void setEnquiry_zip(String enquiry_zip) {
		this.enquiry_zip = enquiry_zip;
	}*/

	 

	public String getPersonMessage() {
		return personMessage;
	}
	
	public void setPersonMessage(String personMessage) {
		this.personMessage=personMessage;
	}
	
	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	 
	@Column(name="personname")
	private String personName;
	

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	
	
	//eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
	
/* public void countryChangeListener(ValueChangeEvent event) {
	       if ((event.getNewValue() != personCountry)) {
	    	   personState = null;
	           // str_VendorCity = null;
	            
	        }
	       System.out.println("kalpanaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	       personCountry=(String) event.getNewValue();
	       // getSelectonemenubean().getCount1(str_UserCountry);
	       // System.out.println(str_UserCountry);
	        
	        
	    }*/
	
	/**
  * This listener cleans up the city value if a new state is selected.
  *
  * @param event a change event when the value of the state changes.
	 * @return 
  */
/* public List<String> stateChangeListener(ValueChangeEvent event) {
 	 if ((event.getNewValue() !=  personState)) {
 		personCity = null;
 	 }
    System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
    System.out.println(event.getNewValue());
    personCity=(String) event.getNewValue();
    cityListByState=new ArrayList<String>();
   // cityListByState.addAll( getUserService().cityList1(str_StateName));
    System.out.println( cityListByState);
    System.out.println("hi");
    //getSelectonemenubean().getState(str_StateName);
    return cityListByState;
    }*/
 //this is  listener for apartment change
 
 
 /**
  * Gets a {@code List of Country.
  *
  * @return a list of  Country 
   
  */
 

	
/*	public List<String>cityChangeListener(ValueChangeEvent event) {
		if ((event.getNewValue() != personCity)) {
			//str_UserApartment = null;
	 }
	       System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhaafffffffffffffffaaaaaaaaaaaaaaaaaaaaaaaaaa");
	       System.out.println(event.getNewValue());
	       //str_ApartmentName=(String) event.getNewValue();
	       //str_apart=str_ApartmentName;
	       str_ApartmentListByState=new ArrayList<String>();
	      // str_ApartmentListByState.addAll( getUserService().apatrmentList1(str_ApartmentName));
	       System.out.println( str_ApartmentListByState);
	       System.out.println("hi");
	      // getSelectonemenubean().getCity(str_ApartmentName);
	       return str_ApartmentListByState;
	       }*/
	//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr

	
	}	

	