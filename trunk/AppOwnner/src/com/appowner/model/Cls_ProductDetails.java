package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_ad_products")
public class Cls_ProductDetails implements Serializable {

	/**
	 * mukesh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Int_ProductId;
	@Column
	private int int_Ad_categoryId;
	public int getInt_Ad_categoryId() {
	return int_Ad_categoryId;
	}
	public void setInt_Ad_categoryId(int int_Ad_categoryId) {
		this.int_Ad_categoryId = int_Ad_categoryId;
	}
	@Column
	private char Ch_Product_Type;
	@Column
	private String Var_Title;
	@Column
	private String Var_FileName;
	@Column
	private char Ch_Ad_Type;
	@Column
	private int UserId;
	@Column
	private int ApartementId;
	
	public int getApartementId() {
		return ApartementId;
	}
	public void setApartementId(int apartementId) {
		ApartementId = apartementId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public char getCh_Ad_Type() {
		return Ch_Ad_Type;
	}
	public void setCh_Ad_Type(char ch_Ad_Type) {
		Ch_Ad_Type = ch_Ad_Type;
	}
	@Column
	private String Var_ImageName;
	@Column
	private String Var_Description;
	
	
	public Integer getInt_ProductId() {
		return Int_ProductId;
	}
	public void setInt_ProductId(Integer int_ProductId) {
		Int_ProductId = int_ProductId;
	}
	
	
	public char getCh_Product_Type() {
		return Ch_Product_Type;
	}
	public void setCh_Product_Type(char ch_Product_Type) {
		Ch_Product_Type = ch_Product_Type;
	}
	public String getVar_Title() {
		return Var_Title;
	}
	public void setVar_Title(String var_Title) {
		Var_Title = var_Title;
	}
	public String getVar_FileName() {
		return Var_FileName;
	}
	public void setVar_FileName(String var_FileName) {
		Var_FileName = var_FileName;
	}
	public String getVar_ImageName() {
		return Var_ImageName;
	}
	public void setVar_ImageName(String var_ImageName) {
		Var_ImageName = var_ImageName;
	}
	
	public String getVar_Description() {
		return Var_Description;
	}
	public void setVar_Description(String var_Description) {
		Var_Description = var_Description;
	}
	
	
	
	
	

}

