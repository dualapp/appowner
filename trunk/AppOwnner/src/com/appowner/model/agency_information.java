package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

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
    private String str_Url;
    private String str_bankname;
    public Date getStr_paymentDate() {
		return str_paymentDate;
	}
	public void setStr_paymentDate(Date str_paymentDate) {
		this.str_paymentDate = str_paymentDate;
	}
	private Date str_paymentDate;
    public String getStr_bankname() {
		return str_bankname;
	}
	public void setStr_bankname(String str_bankname) {
		this.str_bankname = str_bankname;
	}
	public String getStr_vedio() {
		return str_vedio;
	}
	public void setStr_vedio(String str_vedio) {
		this.str_vedio = str_vedio;
	}
	public String getStr_Url() {
		return str_Url;
	}
	public void setStr_Url(String str_Url) {
		this.str_Url = str_Url;
	}
	private String  str_vedio;
	
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
	public int getInt_till() {
		return int_till;
	}
	public void setInt_till(int int_till) {
		this.int_till = int_till;
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
	private int int_till;
	private int int_paymentid ;
//	
	public int getInt_paymentid() {
		return int_paymentid;
	}
	public void setInt_paymentid(int int_paymentid) {
		this.int_paymentid = int_paymentid;
	}
}
