package com.appowner.model;

import java.io.Serializable;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_InvoiceTransaction")
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
	private String dat_InvoiceDate;
	private Date dat_DueDate;
	@Column(name="int_Organisation")
	private String str_Organisation;
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
	
	public String getDat_InvoiceDate() {
		return dat_InvoiceDate;
	}
	public void setDat_InvoiceDate(String dat_InvoiceDate) {
		this.dat_InvoiceDate = dat_InvoiceDate;
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
	
}
