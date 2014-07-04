package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_maintenence_staff_roles")

public class MaintainanceStaffRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="int_Staff_Roles_ID")
	private Integer int_MaintainanceStafRoleId;
	@Column(name="var_Staff_Roles_Name")
	private String str_MaintainanceStaffRoleName;
	@Column(name="ch_Staff_Roles_Type")
	private Character ch_MaintainanceStafType;
	@Column(name="int_Apartment_ID")
	private Integer int_AppartmentID;
	@Column(name="isActive")
	private Integer int_IsActive;
	@Column(name="isDelete")
	private Integer int_IsDelete;
	public Integer getInt_MaintainanceStafRoleId() {
		return int_MaintainanceStafRoleId;
	}
	public void setInt_MaintainanceStafRoleId(Integer int_MaintainanceStafRoleId) {
		this.int_MaintainanceStafRoleId = int_MaintainanceStafRoleId;
	}
	public String getStr_MaintainanceStaffRoleName() {
		return str_MaintainanceStaffRoleName;
	}
	public void setStr_MaintainanceStaffRoleName(
			String str_MaintainanceStaffRoleName) {
		this.str_MaintainanceStaffRoleName = str_MaintainanceStaffRoleName;
	}
	public Character getCh_MaintainanceStafType() {
		return ch_MaintainanceStafType;
	}
	public void setCh_MaintainanceStafType(Character ch_MaintainanceStafType) {
		this.ch_MaintainanceStafType = ch_MaintainanceStafType;
	}
	public Integer getInt_AppartmentID() {
		return int_AppartmentID;
	}
	public void setInt_AppartmentID(Integer int_AppartmentID) {
		this.int_AppartmentID = int_AppartmentID;
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
