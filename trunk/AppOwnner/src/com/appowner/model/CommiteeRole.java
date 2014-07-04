package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Commitee_Roles")
public class CommiteeRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="int_Commitee_Role_ID")
	private Integer int_Commitee_RoleID;
	public Integer getInt_Commitee_RoleID() {
		return int_Commitee_RoleID;
	}
	public void setInt_Commitee_RoleID(Integer int_Commitee_RoleID) {
		this.int_Commitee_RoleID = int_Commitee_RoleID;
	}
	public String getStr_Commitee_RoleName() {
		return str_Commitee_RoleName;
	}
	public void setStr_Commitee_RoleName(String str_Commitee_RoleName) {
		this.str_Commitee_RoleName = str_Commitee_RoleName;
	}
	public String getCh_Commitee_Type() {
		return ch_Commitee_Type;
	}
	public void setCh_Commitee_Type(String ch_Commitee_Type) {
		this.ch_Commitee_Type = ch_Commitee_Type;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
	@Column(name="var_Commitee_Role_Name")
	private String str_Commitee_RoleName;
	@Column(name="ch_Commitee_Role_Type")
	private String ch_Commitee_Type;
	@Column(name="isActive")
	private Integer isActive;
	@Column(name="isDelete")
	private Integer isDelete;
	@Column(name="int_Apartment_ID")
	private Integer int_ApartmentID;
}
