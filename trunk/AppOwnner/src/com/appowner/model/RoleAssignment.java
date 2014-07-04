package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_role_assignment")
public class RoleAssignment implements Serializable{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="int_Role_AssignID")
	private Integer int_RoleAssignID;
	@Column(name="int_User_ID")
	private Integer int_UserId;
	@Column(name="int_Apartment_ID")
	private Integer int_ApartmentId;
	@Column(name="int_Role_ID")
	private Integer int_RoleId;
	@Column(name="int_IsDelete")
	private Integer int_IsDelete;
	@Column(name="char_User_Type")
	private Character char_User_Type;
	@Column(name="str_RoleName")
	private String str_RoleName;
	 
	 
	public String getStr_RoleName() {
		return str_RoleName;
	}
	public void setStr_RoleName(String str_RoleName) {
		this.str_RoleName = str_RoleName;
	}
	public Character getChar_User_Type() {
		return char_User_Type;
	}
	public void setChar_User_Type(Character char_User_Type) {
		this.char_User_Type = char_User_Type;
	}
	public Integer getInt_RoleAssignID() {
		return int_RoleAssignID;
	}
	public void setInt_RoleAssignID(Integer int_RoleAssignID) {
		this.int_RoleAssignID = int_RoleAssignID;
	}
	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}
	 
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	public Integer getInt_RoleId() {
		return int_RoleId;
	}
	public void setInt_RoleId(Integer int_RoleId) {
		this.int_RoleId = int_RoleId;
	}
	public Integer getInt_IsDelete() {
		return int_IsDelete;
	}
	public void setInt_IsDelete(Integer int_IsDelete) {
		this.int_IsDelete = int_IsDelete;
	}
	
	
}
