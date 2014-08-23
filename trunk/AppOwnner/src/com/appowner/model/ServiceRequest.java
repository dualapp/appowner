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
@Table(name = "tb_servicerequest")
public class ServiceRequest implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Integer int_ServiceRequestId;
	
	@Column 
	private Integer int_ApartmentId;
	@Column 
	private Integer int_UserId;
	@Column (name="var_VendorType")
	private String Str_VendorType;
	@Column (name="var_VendorName")
	private String Str_VendorName;
	@Column (name="var_EmailId")
	private String Str_EmailId;
	@Column (name="var_Title")
	private String Str_Title;
	@Column (name="var_Description")
	private String Str_Description;
	@Column (name="str_OpenDate")
	private String str_OpenDate;
	@Column (name="str_CloseDate")
	private String str_CloseDate;
	@Column (name="var_Mobile")
	private String Str_Mobile;
	@Column (name="var_LandLineNum")
	private String Str_LandLineNum;
	@Column (name="var_Status")
	private String Str_Status;
	@Column (name="var_UesrType")
	private String Str_UserType;
	@Column (name="var_Flat")
	private String Str_Flat;
	public String getStr_Flat() {
		return Str_Flat;
	}
	public void setStr_Flat(String str_Flat) {
		Str_Flat = str_Flat;
	}
	
	public Integer getInt_ServiceRequestId() {
		return int_ServiceRequestId;
	}
	public void setInt_ServiceRequestId(Integer int_ServiceRequestId) {
		this.int_ServiceRequestId = int_ServiceRequestId;
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
	public String getStr_VendorType() {
		return Str_VendorType;
	}
	public void setStr_VendorType(String str_VendorType) {
		Str_VendorType = str_VendorType;
	}
	public String getStr_VendorName() {
		return Str_VendorName;
	}
	public void setStr_VendorName(String str_VendorName) {
		Str_VendorName = str_VendorName;
	}
	public String getStr_EmailId() {
		return Str_EmailId;
	}
	public void setStr_EmailId(String str_EmailId) {
		Str_EmailId = str_EmailId;
	}
	public String getStr_Title() {
		return Str_Title;
	}
	public void setStr_Title(String str_Title) {
		Str_Title = str_Title;
	}
	public String getStr_Description() {
		return Str_Description;
	}
	public void setStr_Description(String str_Description) {
		Str_Description = str_Description;
	}
	 
	public String getStr_Mobile() {
		return Str_Mobile;
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
	public String getStr_OpenDate() {
		return str_OpenDate;
	}
	public void setStr_OpenDate(String str_OpenDate) {
		this.str_OpenDate = str_OpenDate;
	}
	public String getStr_CloseDate() {
		return str_CloseDate;
	}
	public void setStr_CloseDate(String str_CloseDate) {
		this.str_CloseDate = str_CloseDate;
	}
	public String getStr_Status() {
		return Str_Status;
	}
	public void setStr_Status(String str_Status) {
		Str_Status = str_Status;
	}
	public String getStr_UserType() {
		return Str_UserType;
	}
	public void setStr_UserType(String str_UserType) {
		Str_UserType = str_UserType;
	}
	
	
	
	


}
