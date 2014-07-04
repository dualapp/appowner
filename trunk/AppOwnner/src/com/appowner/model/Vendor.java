package com.appowner.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_VendorManagement")
 
public class Vendor implements Serializable 
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="int_VendorId", insertable = false, updatable=false)
 private Integer int_VendorId;
	@Column(name="Var_PanNo")
private String str_PanNo;
@Column(name="Var_ServiceTaxNo")
	private String str_ServiceTaxNo;
@Column(name="var_AdditionalInfo")
	private String str_AdditionalInfo;
@Column(name="ch_VisibleToPublic")
	private Boolean bool_VisibleToPublic;
public String getStr_PanNo() {
	return str_PanNo;
}
public void setStr_PanNo(String str_PanNo) {
	this.str_PanNo = str_PanNo;
}
public String getStr_ServiceTaxNo() {
	return str_ServiceTaxNo;
}
public void setStr_ServiceTaxNo(String str_ServiceTaxNo) {
	this.str_ServiceTaxNo = str_ServiceTaxNo;
}
public String getStr_AdditionalInfo() {
	return str_AdditionalInfo;
}
public void setStr_AdditionalInfo(String str_AdditionalInfo) {
	this.str_AdditionalInfo = str_AdditionalInfo;
}
public Boolean getBool_VisibleToPublic() {
	return bool_VisibleToPublic;
}
public void setBool_VisibleToPublic(Boolean bool_VisibleToPublic) {
	this.bool_VisibleToPublic = bool_VisibleToPublic;
}
public Integer getInt_TdsCharge() {
	return int_TdsCharge;
}
public void setInt_TdsCharge(Integer int_TdsCharge) {
	this.int_TdsCharge = int_TdsCharge;
}
public String getStr_Website() {
	return str_Website;
}
public void setStr_Website(String str_Website) {
	this.str_Website = str_Website;
}



@Column(name="int_TdsCharge")
	private Integer int_TdsCharge;
@Column(name="var_Website")
	private String str_Website;
	
	@Column(name="var_VendorType")
	private String str_VendorType;
	public String getStr_VendorType() {
		return str_VendorType;
	}
	public void setStr_VendorType(String str_VendorType) {
		this.str_VendorType = str_VendorType;
	}



	@Column(name="var_VendorName")
 private String str_VendorName;
	
	@Column(name="var_ContactPersonName")
	 private String str_ContactPersonName;
	@Column(name="var_VendorComments")
	private String str_VendorComments;
	public String getStr_VendorComments() {
		return str_VendorComments;
	}
	public void setStr_VendorComments(String str_VendorComments) {
		this.str_VendorComments = str_VendorComments;
	}
	 
	
	 
	public String getStr_ContactPersonName() {
		return str_ContactPersonName;
	}
	public void setStr_ContactPersonName(String str_ContactPersonName) {
		this.str_ContactPersonName = str_ContactPersonName;
	}



	@Column(name="var_VendorPhone")
    private String str_VendorPhone;
	/*@Column(name="var_VendorService")
	private List<String> str_Services;
	@Column(name="int_VendorExpense")
	private List<Integer> int_Prices;
	public List<String> getStr_Services() {
		return str_Services;
	}
	public void setStr_Services(List<String> str_Services) {
		this.str_Services = str_Services;
	}
	public List<Integer> getInt_Prices() {
		return int_Prices;
	}
	public void setInt_Prices(List<Integer> int_Prices) {
		this.int_Prices = int_Prices;
	}*/
	 
	 
	 
	@Column(name="var_StateName")
	private String str_StateName;
	@Column(name="var_CountryName")
	private String str_CountryName;
	@Column(name="var_CityName")
	private String str_CityName;
	public String getStr_StateName() {
		return str_StateName;
	}
	public void setStr_StateName(String str_StateName) {
		this.str_StateName = str_StateName;
	}
	public String getStr_CountryName() {
		return str_CountryName;
	}
	public void setStr_CountryName(String str_CountryName) {
		this.str_CountryName = str_CountryName;
	}
	public String getStr_CityName() {
		return str_CityName;
	}
	public void setStr_CityName(String str_CityName) {
		this.str_CityName = str_CityName;
	}
	@Column(name="var_VendorZip")
	private String str_Zip;
	@Column(name="var_VendorAddressLine1")
	private String str_AddressLine1;
	public String getStr_Zip() {
		return str_Zip;
	}
	public void setStr_Zip(String str_Zip) {
		this.str_Zip = str_Zip;
	}
	public String getStr_AddressLine1() {
		return str_AddressLine1;
	}
	public void setStr_AddressLine1(String str_AddressLine1) {
		this.str_AddressLine1 = str_AddressLine1;
	}



	@Column(name="var_VendorEmail")
	private String str_VendorEmail;
	@Column(name="var_VendorBankAccount")
	private String str_VendorAccount;
	@Column(name="var_VendorBankName")
	private String str_VendorBankName;
	@Column(name="var_VendorBankNeftOrIfsc")
	private String str_VendorBankNeftOrIfsc;
	
	@Column(name="ch_IsVendorActive")
	private Boolean bool_IsVendorActive;
	@Column(name="ch_IsaCompany")
	private Boolean bool_IsaCompany;
	
	 @Column(name="int_VendorServiceRating")
	private Integer int_VendorServiceRating;
	
	
	public Integer getInt_VendorId() {
		return int_VendorId;
	}
	public void setInt_VendorId(Integer int_VendorId) {
		this.int_VendorId = int_VendorId;
	}
	public String getStr_VendorName() {
		return str_VendorName;
	}
	public void setStr_VendorName(String str_VendorName) {
		this.str_VendorName = str_VendorName;
	}
	public String getStr_VendorPhone() {
		return str_VendorPhone;
	}
	public void setStr_VendorPhone(String str_VendorPhone) {
		this.str_VendorPhone = str_VendorPhone;
	}
	 
	
	public String getStr_VendorEmail() {
		return str_VendorEmail;
	}
	public void setStr_VendorEmail(String str_VendorEmail) {
		this.str_VendorEmail = str_VendorEmail;
	}
	public String getStr_VendorAccount() {
		return str_VendorAccount;
	}
	public void setStr_VendorAccount(String str_VendorAccount) {
		this.str_VendorAccount = str_VendorAccount;
	}
	public String getStr_VendorBankName() {
		return str_VendorBankName;
	}
	public void setStr_VendorBankName(String str_VendorBankName) {
		this.str_VendorBankName = str_VendorBankName;
	}
	public String getStr_VendorBankNeftOrIfsc() {
		return str_VendorBankNeftOrIfsc;
	}
	public void setStr_VendorBankNeftOrIfsc(String str_VendorBankNeftOrIfsc) {
		this.str_VendorBankNeftOrIfsc = str_VendorBankNeftOrIfsc;
	}
	 
	public Boolean getBool_IsVendorActive() {
		return bool_IsVendorActive;
	}
	public void setBool_IsVendorActive(Boolean bool_IsVendorActive) {
		this.bool_IsVendorActive = bool_IsVendorActive;
	}
	public Boolean getBool_IsaCompany() {
		return bool_IsaCompany;
	}
	public void setBool_IsaCompany(Boolean bool_IsaCompany) {
		this.bool_IsaCompany = bool_IsaCompany;
	}
	
	public Integer getInt_VendorServiceRating() {
		return int_VendorServiceRating;
	}
	public void setInt_VendorServiceRating(Integer int_VendorServiceRating) {
		this.int_VendorServiceRating = int_VendorServiceRating;
	}
	public void setList(List list) {
		// TODO Auto-generated method stub
		
	}
	 
	 
	 
	
	
	 
}
