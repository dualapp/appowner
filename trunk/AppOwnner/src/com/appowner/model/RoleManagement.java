package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_role_master")
public class RoleManagement implements Serializable{
	@Id
	@Column(name="int_Role_ID")
	private  Integer int_RoleID;
	@Column(name="Var_Role_Name")
	private String str_RoleName;
	@Column(name="int_Apartment_ID")
	private Integer int_ApartmentID;
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
	@Column(name="int_IsActive")
	private Integer int_IsActive;
	@Column(name="int_IsDelete")
	private Integer int_IsDelete;

	 
	public Integer getInt_RoleID() {
		return int_RoleID;
	}
	public void setInt_RoleID(Integer int_RoleID) {
		this.int_RoleID = int_RoleID;
	}
	 
	public String getStr_RoleName() {
		return str_RoleName;
	}
	public void setStr_RoleName(String str_RoleName) {
		this.str_RoleName = str_RoleName;
	}
	public Integer getInt_IsActive() {
		return int_IsActive;
	}
	public void setInt_IsActive(Integer int_IsActive) {
		this.int_IsActive = int_IsActive;
	}
	public Integer getInt_IsDelete() {
		return int_IsDelete;
	}
	public void setInt_IsDelete(Integer int_IsDelete) {
		this.int_IsDelete = int_IsDelete;
	}
	 
	
}
