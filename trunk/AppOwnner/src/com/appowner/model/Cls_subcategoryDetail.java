package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_subcategory")
public class Cls_subcategoryDetail implements Serializable{

	/**
	 * mukesh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
    private int int_subcategoryId;
	@Column
	private String var_subscategoryname;
	private int int_Ad_categoryId;
	@Column
	
	public int getInt_subcategoryId() {
		return int_subcategoryId;
	}
	public int getInt_Ad_categoryId() {
		return int_Ad_categoryId;
	}
	public void setInt_Ad_categoryId(int int_Ad_categoryId) {
		this.int_Ad_categoryId = int_Ad_categoryId;
	}
	public void setInt_subcategoryId(int int_subcategoryId) {
		this.int_subcategoryId = int_subcategoryId;
	}
	public String getVar_subscategoryname() {
		return var_subscategoryname;
	}
	public void setVar_subscategoryname(String var_subscategoryname) {
		this.var_subscategoryname = var_subscategoryname;
	}
   
	



}
