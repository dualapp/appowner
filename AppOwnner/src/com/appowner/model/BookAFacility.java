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
@Table(name="tb_bookafacility")
public class BookAFacility implements  Serializable,Comparable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer int_FacilityBookId;
	@Column(name="var_StartTime")
	private String  str_StartTime;
	@Column(name="var_StartTime1")
	private String  str_StartTime1;
	
	public String getStr_StartTime1() {
		return str_StartTime1;
	}
	public String getStr_EndTime1() {
		return str_EndTime1;
	}
	public void setStr_EndTime1(String str_EndTime1) {
		this.str_EndTime1 = str_EndTime1;
	}
	public void setStr_StartTime1(String str_StartTime1) {
		this.str_StartTime1 = str_StartTime1;
	}
	@Column(name="var_EndTime")
	private String  str_EndTime;
	@Column(name="var_EndTime1")
	private String  str_EndTime1;
	@Column(name="var_EventType")
	private String  str_EventType;
	@Column(name="var_EventName")
	private String  str_EventName;
	
	@Column(name="var_FacilityType")
	private String  str_FacilityType;
	@Column 
	private Integer int_ApartmentId;
	@Column 
	private Integer int_UserId;
	 
	@Column (name="var_EmailId")
	private String Str_EmailId;
	 
	@Column (name="var_Description")
	private String Str_Description;
	@Column  
	private Date dat_OpenDate;
	@Column  
	private Date dat_CloseDate;
	@Column (name="var_Mobile")
	private String Str_Mobile;
	@Column (name="var_LandLineNum")
	private String Str_LandLineNum;
	 
	@Column (name="var_UesrType")
	private String Str_UserType;
	@Column (name="var_Flat")
	private String Str_Flat;
	@Column (name="var_Status")
	private String Str_Status;
	@Column(name="str_CreatedBy")
	private String  str_CreatedBy;
	public String getStr_CreatedBy() {
		return str_CreatedBy;
	}
	public void setStr_CreatedBy(String str_CreatedBy) {
		this.str_CreatedBy = str_CreatedBy;
	}
	public String getStr_Status() {
		return Str_Status;
	}
	public void setStr_Status(String str_Status) {
		Str_Status = str_Status;
	}
	public Integer getInt_FacilityBookId() {
		return int_FacilityBookId;
	}
	public void setInt_FacilityBookId(Integer int_FacilityBookId) {
		this.int_FacilityBookId = int_FacilityBookId;
	}
	public String getStr_StartTime() {
		return str_StartTime;
	}
	public void setStr_StartTime(String str_StartTime) {
		this.str_StartTime = str_StartTime;
	}
	public String getStr_EndTime() {
		return str_EndTime;
	}
	public void setStr_EndTime(String str_EndTime) {
		this.str_EndTime = str_EndTime;
	}
	public String getStr_EventType() {
		return str_EventType;
	}
	public void setStr_EventType(String str_EventType) {
		this.str_EventType = str_EventType;
	}
	public String getStr_FacilityType() {
		return str_FacilityType;
	}
	public void setStr_FacilityType(String str_FacilityType) {
		this.str_FacilityType = str_FacilityType;
	}
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}
	public String getStr_EmailId() {
		return Str_EmailId;
	}
	public void setStr_EmailId(String str_EmailId) {
		Str_EmailId = str_EmailId;
	}
	 
	public Date getDat_OpenDate() {
		return dat_OpenDate;
	}
	public void setDat_OpenDate(Date dat_OpenDate) {
		this.dat_OpenDate = dat_OpenDate;
	}
	 
	public Date getDat_CloseDate() {
		return dat_CloseDate;
	}
	public void setDat_CloseDate(Date dat_CloseDate) {
		this.dat_CloseDate = dat_CloseDate;
	}
	public void setStr_Mobile(String str_Mobile) {
		Str_Mobile = str_Mobile;
	}
	public String getStr_LandLineNum() {
		return Str_LandLineNum;
	}
	public void setStr_LandLineNum(String str_LandLineNum) {
		Str_LandLineNum = str_LandLineNum;
	}
	public String getStr_UserType() {
		return Str_UserType;
	}
	public void setStr_UserType(String str_UserType) {
		Str_UserType = str_UserType;
	}
	public String getStr_Flat() {
		return Str_Flat;
	}
	public void setStr_Flat(String str_Flat) {
		Str_Flat = str_Flat;
	}
	public String getStr_EventName() {
		return str_EventName;
	}
	public void setStr_EventName(String str_EventName) {
		this.str_EventName = str_EventName;
	}
	public String getStr_Description() {
		return Str_Description;
	}
	public void setStr_Description(String str_Description) {
		Str_Description = str_Description;
	}
	@Override
	public int compareTo(Object bookAFacility) {
		// TODO Auto-generated method stub
		Integer bid=((BookAFacility)bookAFacility).int_FacilityBookId;
		/* For Ascending order*/
	      //  return this.int_FacilityBookId;

	        /* For Descending order do like this */
		return bid-this.int_FacilityBookId;
	}
	
	
	 

}
