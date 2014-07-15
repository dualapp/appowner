package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_ad_category")
public class Cls_categoryDetail implements Serializable{

	/**
	 * mukesh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
    private int int_Ad_categoryId;
	@Column
	private String var_Ad_CategoryName;
   
	public int getInt_Ad_categoryId() {
		return int_Ad_categoryId;
	}
	public void setInt_Ad_categoryId(int int_Ad_categoryId) {
		this.int_Ad_categoryId = int_Ad_categoryId;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getVar_Ad_CategoryName() {
		return var_Ad_CategoryName;
	}
	public void setVar_Ad_CategoryName(String var_Ad_CategoryName) {
		this.var_Ad_CategoryName = var_Ad_CategoryName;
	}




}
