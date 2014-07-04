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
@Table(name="tb_watervendortransaction")
public class WaterVendorTransaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="int_TransactionId")
	private Integer int_TransactionId;
	public Integer getInt_TransactionId() {
		return int_TransactionId;
	}
	public void setInt_TransactionId(Integer int_TransactionId) {
		this.int_TransactionId = int_TransactionId;
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
	public Integer getInt_WaterPrice() {
		return int_WaterPrice;
	}
	public void setInt_WaterPrice(Integer int_WaterPrice) {
		this.int_WaterPrice = int_WaterPrice;
	}
	public Integer getInt_WaterCapacity() {
		return int_WaterCapacity;
	}
	public void setInt_WaterCapacity(Integer int_WaterCapacity) {
		this.int_WaterCapacity = int_WaterCapacity;
	}
 

	public String getStr_DriverName() {
		return str_DriverName;
	}
	public void setStr_DriverName(String str_DriverName) {
		this.str_DriverName = str_DriverName;
	}
	public Date getDate_TranscationDate() {
		return date_TranscationDate;
	}
	public void setDate_TranscationDate(Date date_TranscationDate) {
		this.date_TranscationDate = date_TranscationDate;
	}



	@Column(name="var_VendorType")
	private String str_VendorType;
	@Column(name="var_VendorName")
	private String str_VendorName;
	@Column(name="int_NoOfTankers")
	private Integer int_NoOfTankers;
	
	@Column(name="int_WaterPrice")
	private Integer int_WaterPrice;
	@Column(name="int_WaterCapacity")
	private Integer int_WaterCapacity;
	
	@Column(name="var_DriverName")
	private String str_DriverName;
	@Column(name="date_TDate")
	private  Date date_TranscationDate;
}
