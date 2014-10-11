package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="tb_Role_Master")
public class RoleMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="int_Role_ID")
	private Integer int_RoleID;
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
	@Column(name="var_Role_Name")
	private String str_RoleName;
	@Column(name="isActive")
	private Integer isActive;
	@Column(name="isDelete")
	private Integer isDelete;
	@Column(name="int_Apartment_ID")
	private Integer int_ApartmentID;
	private Integer flag;
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Column(name="ch_RoleMaster_Type")
	private char ch_RoleMasterType;
	public char getCh_RoleMasterType() {
		return ch_RoleMasterType;
	}
	public void setCh_RoleMasterType(char ch_RoleMasterType) {
		this.ch_RoleMasterType = ch_RoleMasterType;
	}
}
