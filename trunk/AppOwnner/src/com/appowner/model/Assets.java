package com.appowner.model;

import java.io.Serializable;

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
