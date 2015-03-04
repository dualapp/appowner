package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="tb_complain")
public class Complain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ComplainID")
	private Integer int_ComplainID;
	@OneToMany(targetEntity = Vendor.class, cascade = { CascadeType.ALL })
	public Integer getInt_ComplainID() {
		return int_ComplainID;
	}
	public void setInt_ComplainID(Integer int_ComplainID) {
		this.int_ComplainID = int_ComplainID;
	}
	@Column(name = "Complaint")
	private char ch_Complain;
	public char getCh_Complain() {
		return ch_Complain;
	}
	public void setCh_Complain(char ch_Complain) {
		this.ch_Complain = ch_Complain;
	}
	public String getStr_VendorType() {
		return str_VendorType;
	}
	public void setStr_VendorType(String str_VendorType) {
		this.str_VendorType = str_VendorType;
	}
	
	@Column(name = "VenderType")
	private String str_VendorType;
	
	@Column(name = "ComplainType")
	private String str_ComplainType;

	public String getStr_ComplainType() {
		return str_ComplainType;
	}
	public void setStr_ComplainType(String str_ComplainType) {
		this.str_ComplainType = str_ComplainType;
	}
	@Column(name = "Description")
	private String str_Description;

	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
   
	private String str_File;
	
	
	
	 public String getStr_File() {
		return str_File;
	}
	public void setStr_File(String str_File) {
		this.str_File = str_File;
	}
	@Column(name="VenderName")
	private String str_VenderName;
	public String getStr_VenderName() {
		return str_VenderName;
	}
	public void setStr_VenderName(String str_VenderName) {
		this.str_VenderName = str_VenderName;
	}
	private String Flat;
	public String getFlat() {
		return Flat;
	}
	private String block;
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setFlat(String flat) {
		Flat = flat;
	}
	private Integer status;
	private String adminReason;
	public String getAdminReason() {
		return adminReason;
	}
	public void setAdminReason(String adminReason) {
		this.adminReason = adminReason;
	}
	
}
