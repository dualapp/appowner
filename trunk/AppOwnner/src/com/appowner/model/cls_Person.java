package com.appowner.model;

import java.io.Serializable;
import java.util.*;

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
	private String enquiry_selectedCountries;
	  private List<String>  stateByCountry;
	  private List<String> cityListByState;
	private String personPhone;
	private String personZip;
//	private String RandomnumberGenerator;
	
	
/*	public String getRandomnumberGenerator() {
		return RandomnumberGenerator;
	}

	public void setRandomnumberGenerator(String randomnumberGenerator) {
		RandomnumberGenerator = randomnumberGenerator;
	}*/
	
	

	public String getPersonPhone() {
		return personPhone;
	}

	public List<String> getCityListByState() {
		return cityListByState;
	}

	public void setCityListByState(List<String> cityListByState) {
		this.cityListByState = cityListByState;
	}

	public List<String> getStateByCountry() {
		return stateByCountry;
	}

	public void setStateByCountry(List<String> stateByCountry) {
		this.stateByCountry = stateByCountry;
	}

	public String getEnquiry_selectedCountries() {
		return enquiry_selectedCountries;
	}

	public void setEnquiry_selectedCountries(String enquiry_selectedCountries) {
		this.enquiry_selectedCountries = enquiry_selectedCountries;
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

	
	}	

	