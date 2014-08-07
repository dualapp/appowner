package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_expense")
@Entity
public class Expense implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="var_ExpenseId")
	private String str_ExpenseId;
	@Column
	private Integer int_AppartmentId;
	public Integer getInt_AppartmentId() {
		return int_AppartmentId;
	}
	public void setInt_AppartmentId(Integer int_AppartmentId) {
		this.int_AppartmentId = int_AppartmentId;
	}
	@Column(name="var_OrganizationName")
	private String str_OrganizationName;
	@Column(name="var_ExpenseCategory")
	private String str_ExpenseCategory;
	@Column(name="var_ExpenseType")
	private String str_ExpenseType;
	@Column(name="var_AssetName")
	private String str_AssetName;
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	@Column(name="var_AssetCatType")
	private String str_AssetCatType;
	@Column
	private Date date_Duration;
	@Column(name="var_AccountName")
	private String str_AccountName;
	@Column(name="var_Description")
	private String str_Description;
	
	 
	public String getStr_ExpenseId() {
		return str_ExpenseId;
	}
	public void setStr_ExpenseId(String str_ExpenseId) {
		this.str_ExpenseId = str_ExpenseId;
	}
	public String getStr_OrganizationName() {
		return str_OrganizationName;
	}
	public void setStr_OrganizationName(String str_OrganizationName) {
		this.str_OrganizationName = str_OrganizationName;
	}
	public String getStr_ExpenseCategory() {
		return str_ExpenseCategory;
	}
	public void setStr_ExpenseCategory(String str_ExpenseCategory) {
		this.str_ExpenseCategory = str_ExpenseCategory;
	}
	public String getStr_ExpenseType() {
		return str_ExpenseType;
	}
	public void setStr_ExpenseType(String str_ExpenseType) {
		this.str_ExpenseType = str_ExpenseType;
	}
	public String getStr_AssetName() {
		return str_AssetName;
	}
	public void setStr_AssetName(String str_AssetName) {
		this.str_AssetName = str_AssetName;
	}
	public String getStr_AssetCatType() {
		return str_AssetCatType;
	}
	public void setStr_AssetCatType(String str_AssetCatType) {
		this.str_AssetCatType = str_AssetCatType;
	}
	public Date getDate_Duration() {
		return date_Duration;
	}
	public void setDate_Duration(Date date_Duration) {
		this.date_Duration = date_Duration;
	}
	public String getStr_AccountName() {
		return str_AccountName;
	}
	public void setStr_AccountName(String str_AccountName) {
		this.str_AccountName = str_AccountName;
	}
	public Integer getInt_Ammount() {
		return int_Ammount;
	}
	public void setInt_Ammount(Integer int_Ammount) {
		this.int_Ammount = int_Ammount;
	}
	@Column
	private Integer int_Ammount;
	

}
