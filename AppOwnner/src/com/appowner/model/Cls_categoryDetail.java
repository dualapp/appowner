package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="tb_ad_category")
public class Cls_categoryDetail implements Serializable{

	/**
	 * mukesh
	 */
	private static final long serialVersionUID = 1L;
private Integer Int_Category;
private String Var_CategoryName;
public Integer getInt_Category() {
	return Int_Category;
}
public void setInt_Category(Integer int_Category) {
	Int_Category = int_Category;
}
public String getVar_CategoryName() {
	return Var_CategoryName;
}
public void setVar_CategoryName(String var_CategoryName) {
	Var_CategoryName = var_CategoryName;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
}
