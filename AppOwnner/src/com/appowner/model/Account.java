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
@Table(name="tb_account")
		
public class Account implements Serializable {

	
	private static final long serialVersionUID = 8692141488072943674L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_account_ID;
	@Column(name="var_acount_Name")
	private String str_acount_Name;
	@Column(name="var_acount_No")
	private String str_account_No;
	@Column(name="var_acount_Type")
	private String str_account_Type;
	@Column(name="var_Bank")
	private String str_Bank;
	@Column(name="var_Branch")
	private String str_Branch;
	@Column(name="var_City")
	private String str_City;
	
	private double dou_opening_Balance;
	@Column(name="var_IFSC_Code")
	private String str_IFSC_Code;
	public Integer getInt_account_ID() {
		return int_account_ID;
	}
	public void setInt_account_ID(Integer int_account_ID) {
		this.int_account_ID = int_account_ID;
	}
	public String getStr_acount_Name() {
		return str_acount_Name;
	}
	public void setStr_acount_Name(String str_acount_Name) {
		this.str_acount_Name = str_acount_Name;
	}
	public String getStr_account_No() {
		return str_account_No;
	}
	public void setStr_account_No(String str_account_No) {
		this.str_account_No = str_account_No;
	}
	public String getStr_account_Type() {
		return str_account_Type;
	}
	public void setStr_account_Type(String str_account_Type) {
		this.str_account_Type = str_account_Type;
	}
	public String getStr_Bank() {
		return str_Bank;
	}
	public void setStr_Bank(String str_Bank) {
		this.str_Bank = str_Bank;
	}
	public String getStr_Branch() {
		return str_Branch;
	}
	public void setStr_Branch(String str_Branch) {
		this.str_Branch = str_Branch;
	}
	public String getStr_City() {
		return str_City;
	}
	public void setStr_City(String str_City) {
		this.str_City = str_City;
	}
	public double getDou_opening_Balance() {
		return dou_opening_Balance;
	}
	public void setDou_opening_Balance(double dou_opening_Balance) {
		this.dou_opening_Balance = dou_opening_Balance;
	}
	public String getStr_IFSC_Code() {
		return str_IFSC_Code;
	}
	public void setStr_IFSC_Code(String str_IFSC_Code) {
		this.str_IFSC_Code = str_IFSC_Code;
	}
	private Integer int_Organisation;
	public Integer getInt_Organisation() {
		return int_Organisation;
	}
	public void setInt_Organisation(Integer int_Organisation) {
		this.int_Organisation = int_Organisation;
	}
}