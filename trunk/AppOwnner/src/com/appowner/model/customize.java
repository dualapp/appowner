package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="tb_Customize")
		
public class customize implements Serializable {

	
	private static final long serialVersionUID = 8692141488072943674L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer int_customize_ID;
	@Column(name="var__PAN_No")
	private String str_PAN_No;
	@Column(name="var__Tax_No")
	private String str_Tax_No;
	@Column(name="var__Socity_Regd_No")
	private String str_Socity_Regd_No;
	@Column(name="var__Address")
	private String str_Address;
	@Column(name="var__Term_Condition")
	private String str_Term_Condition;
	@Column(name="var__Customization")
	private String str_Customization;
	@Column(name="var__Contact_Name")
	private String str_Contact_Name;
	@Column(name="var__Contact_Number")
	private String str_Contact_Number;
	@Column(name="var__Contact_Email")
	private String str_Contact_Email;
	public Integer getInt_customize_ID() {
		return int_customize_ID;
	}
	public void setInt_customize_ID(Integer int_customize_ID) {
		this.int_customize_ID = int_customize_ID;
	}
	public String getStr_PAN_No() {
		return str_PAN_No;
	}
	public void setStr_PAN_No(String str_PAN_No) {
		this.str_PAN_No = str_PAN_No;
	}
	public String getStr_Tax_No() {
		return str_Tax_No;
	}
	public void setStr_Tax_No(String str_Tax_No) {
		this.str_Tax_No = str_Tax_No;
	}
	public String getStr_Socity_Regd_No() {
		return str_Socity_Regd_No;
	}
	public void setStr_Socity_Regd_No(String str_Socity_Regd_No) {
		this.str_Socity_Regd_No = str_Socity_Regd_No;
	}
	public String getStr_Address() {
		return str_Address;
	}
	public void setStr_Address(String str_Address) {
		this.str_Address = str_Address;
	}
	public String getStr_Term_Condition() {
		return str_Term_Condition;
	}
	public void setStr_Term_Condition(String str_Term_Condition) {
		this.str_Term_Condition = str_Term_Condition;
	}
	public String getStr_Customization() {
		return str_Customization;
	}
	public void setStr_Customization(String str_Customization) {
		this.str_Customization = str_Customization;
	}
	public String getStr_Contact_Name() {
		return str_Contact_Name;
	}
	public void setStr_Contact_Name(String str_Contact_Name) {
		this.str_Contact_Name = str_Contact_Name;
	}
	public String getStr_Contact_Number() {
		return str_Contact_Number;
	}
	public void setStr_Contact_Number(String str_Contact_Number) {
		this.str_Contact_Number = str_Contact_Number;
	}
	public String getStr_Contact_Email() {
		return str_Contact_Email;
	}
	public void setStr_Contact_Email(String str_Contact_Email) {
		this.str_Contact_Email = str_Contact_Email;
	}
}
