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
@Table(name="tb_invoicetransaction")
public class InvoiceTransaction implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer int_InvoiceTransactionID;
	@Column(name="int_InvoiceTemplate")
	private String str_InvoiceTemplate;
	@Column(name="var_BillPeriod")
	private String str_BillPeriod;
	
	private Integer int_Year;
	private Date dat_InvoiceDate;
	private Date dat_DueDate;
	@Column(name="int_Organisation")
	private Integer int_Organisation;
	@Column(name="var_Block")
	private String str_Block;
	@Column(name="var_ApartmentNo")
	private String str_ApartmentNo;
	public Date getDat_DueDate() {
		return dat_DueDate;
	}
	public void setDat_DueDate(Date dat_DueDate) {
		this.dat_DueDate = dat_DueDate;
	}
	public Integer getInt_InvoiceTransactionID() {
		return int_InvoiceTransactionID;
	}
	public void setInt_InvoiceTransactionID(Integer int_InvoiceTransactionID) {
		this.int_InvoiceTransactionID = int_InvoiceTransactionID;
	}
	public String getStr_InvoiceTemplate() {
		return str_InvoiceTemplate;
	}
	public void setStr_InvoiceTemplate(String str_InvoiceTemplate) {
		this.str_InvoiceTemplate = str_InvoiceTemplate;
	}
	public String getStr_BillPeriod() {
		return str_BillPeriod;
	}
	public void setStr_BillPeriod(String str_BillPeriod) {
		this.str_BillPeriod = str_BillPeriod;
	}
	public Integer getInt_Year() {
		return int_Year;
	}
	
	public void setInt_Year(Integer int_Year) {
		this.int_Year = int_Year;
	}
	
	
	
	
	
	public Date getDat_InvoiceDate() {
		return dat_InvoiceDate;
	}
	public void setDat_InvoiceDate(Date dat_InvoiceDate) {
		this.dat_InvoiceDate = dat_InvoiceDate;
	}
	
	public Integer getInt_Organisation() {
		return int_Organisation;
	}
	public void setInt_Organisation(Integer int_Organisation) {
		this.int_Organisation = int_Organisation;
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
	
	
	@Column(name="var_Status")
	private String str_Status;
	public String getStr_Status() {
		return str_Status;
	}
	public void setStr_Status(String str_Status) {
		this.str_Status = str_Status;
	}
	
	
	public String getInt_InvoiceNo() {
		return int_InvoiceNo;
	}
	public void setInt_InvoiceNo(String int_InvoiceNo) {
		this.int_InvoiceNo = int_InvoiceNo;
	}
	private String int_InvoiceNo;
	private double subTotal;
	private double taxAmount;
	private double totalDue;
	

	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}


	private double totalBalance;
	@Column(name="var_paymentMode")
	private String str_paymentMode;
	public String getStr_paymentMode() {
		return str_paymentMode;
	}
	public void setStr_paymentMode(String str_paymentMode) {
		this.str_paymentMode = str_paymentMode;
	}


	@Column(name="var_paymentAccount")
	private String str_paymentAccount;
	public String getStr_paymentAccount() {
		return str_paymentAccount;
	}
	public void setStr_paymentAccount(String str_paymentAccount) {
		this.str_paymentAccount = str_paymentAccount;
	}
	public Date dat_PaymentDate;
	
	public Date getDat_PaymentDate() {
		return dat_PaymentDate;
	}
	public void setDat_PaymentDate(Date dat_PaymentDate) {
		this.dat_PaymentDate = dat_PaymentDate;
	}


	private Integer Payment_No;
	public Integer getPayment_No() {
		return Payment_No;
	}
	public void setPayment_No(Integer payment_No) {
		Payment_No = payment_No;
	}
	private Integer int_Admin_ID;
	public Integer getInt_Admin_ID() {
		return int_Admin_ID;
	}
	public void setInt_Admin_ID(Integer int_Admin_ID) {
		this.int_Admin_ID = int_Admin_ID;
	}
	private Date Payment_Mode_Date;
	
	public Date getPayment_Mode_Date() {
		return Payment_Mode_Date;
	}
	public void setPayment_Mode_Date(Date payment_Mode_Date) {
		Payment_Mode_Date = payment_Mode_Date;
	}


	private double dueBalance;
	public double getDueBalance() {
		return dueBalance;
	}
	public void setDueBalance(double dueBalance) {
		this.dueBalance = dueBalance;
	}
	private String deposit_Account;
	public String getDeposit_Account() {
		return deposit_Account;
	}
	public void setDeposit_Account(String deposit_Account) {
		this.deposit_Account = deposit_Account;
	}
	
}
