package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Maintenence_Staff_Roles")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="int_Staff_Roles_ID")
	private Integer int_StaffID;
	public Integer getInt_StaffID() {
		return int_StaffID;
	}
	public void setInt_StaffID(Integer int_StaffID) {
		this.int_StaffID = int_StaffID;
	}
	public String getStr_StaffName() {
		return str_StaffName;
	}
	public void setStr_StaffName(String str_StaffName) {
		this.str_StaffName = str_StaffName;
	}
	
	public Integer getInt_isActive() {
		return int_isActive;
	}
	public void setInt_isActive(Integer int_isActive) {
		this.int_isActive = int_isActive;
	}
	public Integer getInt_isDelete() {
		return int_isDelete;
	}
	public void setInt_isDelete(Integer int_isDelete) {
		this.int_isDelete = int_isDelete;
	}
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
	@Column(name="var_Staff_Roles_Name")
	private String str_StaffName;
	@Column(name="ch_Staff_Roles_Type")
	private char ch_StaffType;
	
	public char getCh_StaffType() {
		return ch_StaffType;
	}
	public void setCh_StaffType(char ch_StaffType) {
		this.ch_StaffType = ch_StaffType;
	}
	@Column(name="isActive")
	private Integer int_isActive;
	@Column(name="isDelete")
	private Integer int_isDelete;
	@Column(name="int_Apartment_ID")
	private Integer int_ApartmentID;
	private Integer flag;
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
