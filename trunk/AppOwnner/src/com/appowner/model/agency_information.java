package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_agency")
public class agency_information implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_agencyid;
	
	
	private String str_CompanyName;
	private String ads_type;
	private String str_addposition;
	private String str_content;
	private String var_ImageName;
	private Integer int_CompanyID;
	private String str_CompanyAddress;
	private String str_City;
	private String str_State;
    private String str_Mobile;
	
	public String getStr_CompanyAddress() {
		return str_CompanyAddress;
	}
	public void setStr_CompanyAddress(String str_CompanyAddress) {
		this.str_CompanyAddress = str_CompanyAddress;
	}
	public String getStr_City() {
		return str_City;
	}
	public void setStr_City(String str_City) {
		this.str_City = str_City;
	}
	public String getStr_State() {
		return str_State;
	}
	public void setStr_State(String str_State) {
		this.str_State = str_State;
	}
	public String getStr_Mobile() {
		return str_Mobile;
	}
	public void setStr_Mobile(String str_Mobile) {
		this.str_Mobile = str_Mobile;
	}
	public Integer getInt_CompanyID() {
		return int_CompanyID;
	}
	public void setInt_CompanyID(Integer int_CompanyID) {
		this.int_CompanyID = int_CompanyID;
	}
	public String getVar_ImageName() {
		return var_ImageName;
	}
	public void setVar_ImageName(String var_ImageName) {
		this.var_ImageName = var_ImageName;
	}
	public Integer getInt_agencyid() {
		return int_agencyid;
	}
	public void setInt_agencyid(Integer int_agencyid) {
		this.int_agencyid = int_agencyid;
	}
	
	public String getStr_CompanyName() {
		return str_CompanyName;
	}
	public void setStr_CompanyName(String str_CompanyName) {
		this.str_CompanyName = str_CompanyName;
	}
	public String getAds_type() {
		return ads_type;
	}
	public void setAds_type(String ads_type) {
		this.ads_type = ads_type;
	}
	public String getStr_addposition() {
		return str_addposition;
	}
	public void setStr_addposition(String str_addposition) {
		this.str_addposition = str_addposition;
	}
	public String getStr_content() {
		return str_content;
	}
	public void setStr_content(String str_content) {
		this.str_content = str_content;
	}
}
