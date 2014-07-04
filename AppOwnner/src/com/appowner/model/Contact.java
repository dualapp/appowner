package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Contact")
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_ContactID;
    
	
	@Column(name="var_ContactName")
	private String str_ContactName;
   
	
    public Integer getInt_ContactID() {
		return int_ContactID;
	}
	public void setInt_ContactID(Integer int_ContactID) {
		this.int_ContactID = int_ContactID;
	}
	public String getStr_ContactName() {
		return str_ContactName;
	}
	public void setStr_ContactName(String str_ContactName) {
		this.str_ContactName = str_ContactName;
	}
	public String getStr_Query() {
		return str_Query;
	}
	public void setStr_Query(String str_Query) {
		this.str_Query = str_Query;
	}
	private String str_Query;
    
	
	private String str_MobileNo;
	public String getStr_MobileNo() {
		return str_MobileNo;
	}
	public void setStr_MobileNo(String str_MobileNo) {
		this.str_MobileNo = str_MobileNo;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	private String str_Email;
   
    
}


