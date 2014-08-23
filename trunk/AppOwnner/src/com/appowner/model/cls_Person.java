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
	private String personCountry;
	private String personState;
	private String personCity;
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

	
	}	

	