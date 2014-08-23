package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="tb_Company")
public class Company implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_CompanyID;
	
	public Integer getInt_CompanyID() {
		return int_CompanyID;
	}
	public void setInt_CompanyID(Integer int_CompanyID) {
		this.int_CompanyID = int_CompanyID;
	}
	public String getStr_CompanyName() {
		return str_CompanyName;
	}
	public void setStr_CompanyName(String str_CompanyName) {
		this.str_CompanyName = str_CompanyName;
	}
	public String getStr_CompanyAddress() {
		return str_CompanyAddress;
	}
	public void setStr_CompanyAddress(String str_CompanyAddress) {
		this.str_CompanyAddress = str_CompanyAddress;
	}
	public String getStr_City() {
		return str_City;
	}
	public void setStr_City(String str_City) {
		this.str_City = str_City;
	}
	public String getStr_State() {
		return str_State;
	}
	public void setStr_State(String str_State) {
		this.str_State = str_State;
	}
	public Integer getInt_Zipcode() {
		return int_Zipcode;
	}
	public void setInt_Zipcode(Integer int_Zipcode) {
		this.int_Zipcode = int_Zipcode;
	}
	public String getStr_Mobile() {
		return str_Mobile;
	}
	public void setStr_Mobile(String str_Mobile) {
		this.str_Mobile = str_Mobile;
	}
	private String str_CompanyName;
	private String str_CompanyAddress;
	private String str_City;
	private String str_State;
	private Integer int_Zipcode;
	private String str_Mobile;
	private String str_CompanyType;
	public String getStr_CompanyType() {
		return str_CompanyType;
	}
	public void setStr_CompanyType(String str_CompanyType) {
		this.str_CompanyType = str_CompanyType;
	}

	private Integer int_NoOfPerson;
	public Integer getInt_NoOfPerson() {
		return int_NoOfPerson;
	}
	public void setInt_NoOfPerson(Integer int_NoOfPerson) {
		this.int_NoOfPerson = int_NoOfPerson;
	}
	
	
	
}
