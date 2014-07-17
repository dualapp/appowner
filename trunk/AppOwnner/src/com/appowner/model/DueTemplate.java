package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_DueTemplate")
public class DueTemplate implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "int_DueTemplateID")
	private Integer int_DueTemplateID;
	public Integer getInt_DueTemplateID() {
		return int_DueTemplateID;
	}
	public void setInt_DueTemplateID(Integer int_DueTemplateID) {
		this.int_DueTemplateID = int_DueTemplateID;
	}

	public String getStr_DueTemplate() {
		return str_DueTemplate;
	}
	public void setStr_DueTemplate(String str_DueTemplate) {
		this.str_DueTemplate = str_DueTemplate;
	}
	public String getStr_Accounts() {
		return str_Accounts;
	}
	public void setStr_Accounts(String str_Accounts) {
		this.str_Accounts = str_Accounts;
	}
	public String getStr_Frequency() {
		return str_Frequency;
	}
	public void setStr_Frequency(String str_Frequency) {
		this.str_Frequency = str_Frequency;
	}
	public String getStr_Calculation() {
		return str_Calculation;
	}
	public void setStr_Calculation(String str_Calculation) {
		this.str_Calculation = str_Calculation;
	}
	public String getStr_Rate() {
		return str_Rate;
	}
	public void setStr_Rate(String str_Rate) {
		this.str_Rate = str_Rate;
	}
	public String getStr_TaxTemplate() {
		return str_TaxTemplate;
	}
	public void setStr_TaxTemplate(String str_TaxTemplate) {
		this.str_TaxTemplate = str_TaxTemplate;
	}
	@Column(name = "int_ApartmentID")
	private String str_Organisation;
	public String getStr_Organisation() {
		return str_Organisation;
	}
	public void setStr_Organisation(String str_Organisation) {
		this.str_Organisation = str_Organisation;
	}
	@Column(name = "var_DueTemplate")
	private String str_DueTemplate;
	@Column(name = "var_Accounts")
	private String str_Accounts;
	@Column(name = "var_Frequency")
	private String str_Frequency;
	@Column(name = "var_Calculation")
	private String str_Calculation;
	@Column(name = "int_Rate")
	private String str_Rate;
	@Column(name = "var_TaxTemplate")
	private String str_TaxTemplate;
	
}
