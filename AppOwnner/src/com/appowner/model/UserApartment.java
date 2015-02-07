package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "tb_apartment")
public class UserApartment   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="int_ApartmentId")
	private Integer int_ApartmentId;
	@Column(name="int_CityId")
	private Integer int_CityId;
	@JoinColumn(name = "int_CityId", insertable = false, updatable=false)
	//private UserCity userCity;
	@Column(name="var_ApartmentName")
	private String str_ApartmentName;
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	public Integer getInt_CityId() {
		return int_CityId;
	}
	public void setInt_CityId(Integer int_CityId) {
		this.int_CityId = int_CityId;
	}
	public String getStr_ApartmentName() {
		return str_ApartmentName;
	}
	public void setStr_ApartmentName(String str_ApartmentName) {
		this.str_ApartmentName = str_ApartmentName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/*property seter and getter for Adding Apartment*/
	@Column(name="int_NoOfFlates")
	private int int_NoOfFlates;
	@Column(name="str_Address")
	private String str_Address;
	@Column(name="int_PinCode")
	private int int_PinCode;
	
	public int getInt_NoOfFlates() {
		return int_NoOfFlates;
	}
	public void setInt_NoOfFlates(int int_NoOfFlates) {
		this.int_NoOfFlates = int_NoOfFlates;
	}
	public String getStr_Address() {
		return str_Address;
	}
	public void setStr_Address(String str_Address) {
		this.str_Address = str_Address;
	}
	
	public int getInt_PinCode() {
		return int_PinCode;
	}
	public void setInt_PinCode(int int_PinCode) {
		this.int_PinCode = int_PinCode;
	}
	@Column(name="str_User")
	private Long int_NoOfUser;
	public Long getInt_NoOfUser() {
		return int_NoOfUser;
	}
	public void setInt_NoOfUser(Long int_NoOfUser) {
		this.int_NoOfUser = int_NoOfUser;
	}
	private Date dat_EntryDate;
	public Integer getPayment_Status() {
		return payment_Status;
	}
	public void setPayment_Status(Integer payment_Status) {
		this.payment_Status = payment_Status;
	}
	private Date dat_ExpireDate;
	public Date getDat_ExpireDate() {
		return dat_ExpireDate;
	}
	public void setDat_ExpireDate(Date dat_ExpireDate) {
		this.dat_ExpireDate = dat_ExpireDate;
	}
	private Integer status;
	private Integer payment_Status;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getDat_EntryDate() {
		return dat_EntryDate;
	}
	public void setDat_EntryDate(Date dat_EntryDate) {
		this.dat_EntryDate = dat_EntryDate;
	}
	private Integer int_subscriptID;
	public Integer getInt_subscriptID() {
		return int_subscriptID;
	}
	public void setInt_subscriptID(Integer int_subscriptID) {
		this.int_subscriptID = int_subscriptID;
	}
	
	
	
}
