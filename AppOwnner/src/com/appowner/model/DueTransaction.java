package com.appowner.model;

import java.io.Serializable;

import java.util.Date;

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
@Table(name="tb_DueTransaction")
public class DueTransaction implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_DueTransactionID;
	@Column(name="var_Accounts")
	private String str_Accounts;
	@Column(name="int_DueTemplate")
	private String str_DueTemplate;
	@Column(name="var_Period")
	private String str_Period;
	
	private Integer int_Year;
	@Column(name="dat_InitiatedOn")
	private String str_InitiatedOn;
	private Date dat_LastDate;
	@Column(name="int_Organisation")
	private String str_Organisation;
	@Column(name="var_Block")
	private String str_Block;
	@Column(name="var_ApartmentNo")
	private String str_ApartmentNo;
	
	public Integer getInt_DueTransactionID() {
		return int_DueTransactionID;
	}
	public void setInt_DueTransactionID(Integer int_DueTransactionID) {
		this.int_DueTransactionID = int_DueTransactionID;
	}
	public String getStr_Accounts() {
		return str_Accounts;
	}
	public void setStr_Accounts(String str_Accounts) {
		this.str_Accounts = str_Accounts;
	}
	public String getStr_DueTemplate() {
		return str_DueTemplate;
	}
	public void setStr_DueTemplate(String str_DueTemplate) {
		this.str_DueTemplate = str_DueTemplate;
	}
	public String getStr_Period() {
		return str_Period;
	}
	public void setStr_Period(String str_Period) {
		this.str_Period = str_Period;
	}
	public Integer getInt_Year() {
		return int_Year;
	}
	public void setInt_Year(Integer int_Year) {
		this.int_Year = int_Year;
	}
	public String getStr_InitiatedOn() {
		return str_InitiatedOn;
	}
	public void setStr_InitiatedOn(String str_InitiatedOn) {
		this.str_InitiatedOn = str_InitiatedOn;
	}
	public Date getDat_LastDate() {
		return dat_LastDate;
	}
	public void setDat_LastDate(Date dat_LastDate) {
		this.dat_LastDate = dat_LastDate;
	}
	public String getStr_Organisation() {
		return str_Organisation;
	}
	public void setStr_Organisation(String str_Organisation) {
		this.str_Organisation = str_Organisation;
	}
	public String getStr_Block() {
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public String getStr_ApartmentNo() {
		return str_ApartmentNo;
	}
	public void setStr_ApartmentNo(String str_ApartmentNo) {
		this.str_ApartmentNo = str_ApartmentNo;
	}
	public Double getDbl_DueAmount() {
		return dbl_DueAmount;
	}
	public void setDbl_DueAmount(Double dbl_DueAmount) {
		this.dbl_DueAmount = dbl_DueAmount;
	}
	public Double getDbl_TotalDueAmount() {
		return dbl_TotalDueAmount;
	}
	public void setDbl_TotalDueAmount(Double dbl_TotalDueAmount) {
		this.dbl_TotalDueAmount = dbl_TotalDueAmount;
	}
	private Double dbl_DueAmount;
	private Double dbl_TotalDueAmount;
	@Column(name="var_Status")
	private String str_Status;

	public String getStr_Status() {
		return str_Status;
	}
	public void setStr_Status(String str_Status) {
		this.str_Status = str_Status;
	}
	private String int_InvoiceNo;

	public String getInt_InvoiceNo() {
		return int_InvoiceNo;
	}
	public void setInt_InvoiceNo(String int_InvoiceNo) {
		this.int_InvoiceNo = int_InvoiceNo;
	}
    private Double int_paidAmount=0.00;

	public Double getInt_paidAmount() {
		return int_paidAmount;
	}
	public void setInt_paidAmount(Double int_paidAmount) {
		this.int_paidAmount = int_paidAmount;
	}

	
	
}
