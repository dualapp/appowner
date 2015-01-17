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
@Table(name="tb_enquiryform")
public class cls_Person implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	 

	 

	@Id
	@Column(name = "personid")
	private String personId;
	@Column
	private String personEmail;
	private String personMessage;
	private String personCountry;
	private String personState;
	private String personCity;
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


	
	 
	public String getPersonCountry() {
		return personCountry;
	}

	public void setPersonCountry(String personCountry) {
		this.personCountry = personCountry;
	}

	public String getPersonState() {
		return personState;
	}

	public void setPersonState(String personState) {
		this.personState = personState;
	}

	public String getPersonCity() {
		return personCity;
	}

	public void setPersonCity(String personCity) {
		this.personCity = personCity;
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
	
	/*public void countryChangeListener(ValueChangeEvent event) {
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
 /*public List<String> stateChangeListener(ValueChangeEvent event) {
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

	