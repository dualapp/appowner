package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_CompanyPerson")
public class CompanyPerson implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer int_CompanyPersonID;
	public Integer getInt_CompanyPersonID() {
		return int_CompanyPersonID;
	}
	public void setInt_CompanyPersonID(Integer int_CompanyPersonID) {
		this.int_CompanyPersonID = int_CompanyPersonID;
	}
	public String getStr_CompanyPersonName() {
		return str_CompanyPersonName;
	}
	public void setStr_CompanyPersonName(String str_CompanyPersonName) {
		this.str_CompanyPersonName = str_CompanyPersonName;
	}
	public String getStr_Designation() {
		return str_Designation;
	}
	public void setStr_Designation(String str_Designation) {
		this.str_Designation = str_Designation;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getStr_MobileNo() {
		return str_MobileNo;
	}
	public void setStr_MobileNo(String str_MobileNo) {
		this.str_MobileNo = str_MobileNo;
	}
	private String str_CompanyPersonName;
	private String str_Designation;
	private String str_Email;
	private String str_MobileNo;
	private String str_CompanyName;
	public String getStr_CompanyName() {
		return str_CompanyName;
	}
	public void setStr_CompanyName(String str_CompanyName) {
		this.str_CompanyName = str_CompanyName;
	}
	private Integer int_CompanyID;
	public Integer getInt_CompanyID() {
		return int_CompanyID;
	}
	public void setInt_CompanyID(Integer int_CompanyID) {
		this.int_CompanyID = int_CompanyID;
	}
	
	

}
