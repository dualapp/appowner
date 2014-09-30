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
@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="tb_waterpayment")
public class WaterPayment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="int_WaterPaymentId")
	private Integer int_WaterPaymentId;
	@Column(name="var_VendorType")
	private String str_VendorType;
	@Column(name="var_VendorName")
	private String str_VendorName;
	@Column(name="int_NoOfTankers")
	private Integer int_NoOfTankers;
	
	@Column(name="dbl_PricePerTanker")
	private Double dbl_PricePerTanker;
	@Column(name="dbl_TotalPrice")
	private Double dbl_TotalPrice;
	@Column(name="date_ToDate")
	private Date date_ToDate;
	@Column(name="date_FromDate")
	private Date date_FromDate;
	@Column(name="var_Description")
	private String str_Description;
	@Column(name="date_Date")
	private Date date_Date;
	public Integer getInt_WaterPaymentId() {
		return int_WaterPaymentId;
	}
	public void setInt_WaterPaymentId(Integer int_WaterPaymentId) {
		this.int_WaterPaymentId = int_WaterPaymentId;
	}
	public String getStr_VendorType() {
		return str_VendorType;
	}
	public void setStr_VendorType(String str_VendorType) {
		this.str_VendorType = str_VendorType;
	}
	public String getStr_VendorName() {
		return str_VendorName;
	}
	public void setStr_VendorName(String str_VendorName) {
		this.str_VendorName = str_VendorName;
	}
	public Integer getInt_NoOfTankers() {
		return int_NoOfTankers;
	}
	public void setInt_NoOfTankers(Integer int_NoOfTankers) {
		this.int_NoOfTankers = int_NoOfTankers;
	}
	 
	public Double getDbl_PricePerTanker() {
		return dbl_PricePerTanker;
	}
	public void setDbl_PricePerTanker(Double dbl_PricePerTanker) {
		this.dbl_PricePerTanker = dbl_PricePerTanker;
	}
	public Double getDbl_TotalPrice() {
		
		return dbl_TotalPrice;
	}
	public void setDbl_TotalPrice(Double dbl_TotalPrice) {
		this.dbl_TotalPrice = dbl_TotalPrice;
	}
	public Date getDate_ToDate() {
		return date_ToDate;
	}
	public void setDate_ToDate(Date date_ToDate) {
		this.date_ToDate = date_ToDate;
	}
	public Date getDate_FromDate() {
		return date_FromDate;
	}
	public void setDate_FromDate(Date date_FromDate) {
		this.date_FromDate = date_FromDate;
	}
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	public Date getDate_Date() {
		return date_Date;
	}
	public void setDate_Date(Date date_Date) {
		this.date_Date = date_Date;
	}
	
}
