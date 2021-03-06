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
	private String str_Email;
	private String str_Block;
	private String str_PhoneNo;
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getStr_Block() {
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public String getStr_PhoneNo() {
		return str_PhoneNo;
	}
	public void setStr_PhoneNo(String str_PhoneNo) {
		this.str_PhoneNo = str_PhoneNo;
	}
	public int getInt_Ad_categoryId() {
	return int_Ad_categoryId;
	}
	public void setInt_Ad_categoryId(int int_Ad_categoryId) {
		this.int_Ad_categoryId = int_Ad_categoryId;
	}
	@Column
	private String Ch_Product_Type;
	@Column
	private String Var_Title;
	@Column
	private String Var_FileName;
	@Column
	private String Ch_Ad_Type;
	@Column
	private int UserId;
	@Column
	private int ApartementId;
	private String username;
	private Date dt_date;
	private String Status;
	private Date closedate;
	
	
	
	
	public Date getClosedate() {
		return closedate;
	}
	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getDt_date() {
		return dt_date;
	}
	public void setDt_date(Date dt_date) {
		this.dt_date = dt_date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	
	public String getCh_Ad_Type() {
		return Ch_Ad_Type;
	}
	public void setCh_Ad_Type(String string) {
		Ch_Ad_Type = string;
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
	public String getCh_Product_Type() {
		return Ch_Product_Type;
	}
	public void setCh_Product_Type(String ch_Product_Type) {
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
	
	private String var_Ad_CategoryName;

	public String getVar_Ad_CategoryName() {
		return var_Ad_CategoryName;
	}
	public void setVar_Ad_CategoryName(String var_Ad_CategoryName) {
		this.var_Ad_CategoryName = var_Ad_CategoryName;
	}
private String str_ApartmentName;
public String getStr_ApartmentName() {
		return str_ApartmentName;
	}
	public void setStr_ApartmentName(String str_ApartmentName) {
		this.str_ApartmentName = str_ApartmentName;
	}
private String var_subscategoryname;

public String getVar_subscategoryname() {
	return var_subscategoryname;
}
public void setVar_subscategoryname(String var_subscategoryname) {
	this.var_subscategoryname = var_subscategoryname;
}
private int int_subcategoryId;

public int getInt_subcategoryId() {
	return int_subcategoryId;
}
public void setInt_subcategoryId(int int_subcategoryId) {
	this.int_subcategoryId = int_subcategoryId;
}

	
	}

