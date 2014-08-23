package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="tb_assets")
@Entity
public class Assets  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_asset_id;
	@Column
	private Integer int_AppartmentId;
	@Column(name="var_assetcat_name")
	private String str_assetcat_name;
	@Column(name="var_Block")
	private String str_Block;
	@Column(name="var_AssetImg") 
	private String str_AssetImg;
	@Column(name="var_OrganizationName")
	private String str_OrganizationName;
	@Column(name="var_AssetName")
	private String str_AssetName;
	@Column 
	private Boolean bool_Rentable;
	@Column(name="var_VendorType")
	private String str_VendorType;
	@Column(name="var_VendorName")
	private String str_VendorName;
	@Column
	private Date date_PurchaseDate;
	@Column
	private Date date_WarrantyStartDate;
	@Column
	private Date  date_WarrantyEndDate;
	@Column
	private Double dbl_Price;
	@Column(name="var_SellerNameAnddetails")
	private String str_SellerNameAnddetails;
	@Column 
	private Date date_AMCStartDate;
	@Column
	private Date  date_AMCEndDate;
	@Column(name="var_PurchaseImg")
	private String str_PurchaseImg;
	
	public Integer getInt_AppartmentId() {
		return int_AppartmentId;
	}
	public void setInt_AppartmentId(Integer int_AppartmentId) {
		this.int_AppartmentId = int_AppartmentId;
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
	public Date getDate_PurchaseDate() {
		return date_PurchaseDate;
	}
	public void setDate_PurchaseDate(Date date_PurchaseDate) {
		this.date_PurchaseDate = date_PurchaseDate;
	}
	public Date getDate_WarrantyStartDate() {
		return date_WarrantyStartDate;
	}
	public void setDate_WarrantyStartDate(Date date_WarrantyStartDate) {
		this.date_WarrantyStartDate = date_WarrantyStartDate;
	}
	public Date getDate_WarrantyEndDate() {
		return date_WarrantyEndDate;
	}
	public void setDate_WarrantyEndDate(Date date_WarrantyEndDate) {
		this.date_WarrantyEndDate = date_WarrantyEndDate;
	}
	public Double getDbl_Price() {
		return dbl_Price;
	}
	public void setDbl_Price(Double dbl_Price) {
		this.dbl_Price = dbl_Price;
	}
	public String getStr_SellerNameAnddetails() {
		return str_SellerNameAnddetails;
	}
	public void setStr_SellerNameAnddetails(String str_SellerNameAnddetails) {
		this.str_SellerNameAnddetails = str_SellerNameAnddetails;
	}
	public Date getDate_AMCStartDate() {
		return date_AMCStartDate;
	}
	public void setDate_AMCStartDate(Date date_AMCStartDate) {
		this.date_AMCStartDate = date_AMCStartDate;
	}
	public Date getDate_AMCEndDate() {
		return date_AMCEndDate;
	}
	public void setDate_AMCEndDate(Date date_AMCEndDate) {
		this.date_AMCEndDate = date_AMCEndDate;
	}
	public String getStr_PurchaseImg() {
		return str_PurchaseImg;
	}
	public void setStr_PurchaseImg(String str_PurchaseImg) {
		this.str_PurchaseImg = str_PurchaseImg;
	}
	public Boolean getBool_Rentable() {
		return bool_Rentable;
	}
	public void setBool_Rentable(Boolean bool_Rentable) {
		this.bool_Rentable = bool_Rentable;
	}
	public String getStr_AssetName() {
		return str_AssetName;
	}
	public void setStr_AssetName(String str_AssetName) {
		this.str_AssetName = str_AssetName;
	}
	public String getStr_OrganizationName() {
		return str_OrganizationName;
	}
	public void setStr_OrganizationName(String str_OrganizationName) {
		this.str_OrganizationName = str_OrganizationName;
	}
	public String getStr_AssetImg() {
		return str_AssetImg;
	}
	public void setStr_AssetImg(String str_AssetImg) {
		this.str_AssetImg = str_AssetImg;
	}
	public String getStr_Block() {
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	 
	public Integer getInt_asset_id() {
		return int_asset_id;
	}
	public void setInt_asset_id(Integer int_asset_id) {
		this.int_asset_id = int_asset_id;
	}
	public String getStr_assetcat_name() {
		return str_assetcat_name;
	}
	public void setStr_assetcat_name(String str_assetcat_name) {
		this.str_assetcat_name = str_assetcat_name;
	}

}
