package com.appowner.model;


import java.io.Serializable;

import javax.persistence.Cacheable;

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
@Table(name="tb_role_management")
public class RoleMenuManagement implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_MenuManagementID;
	
	private Integer int_RoleID; 
	private Integer int_MenuID;
	private Integer bt_Visible;
	public Integer getInt_MenuManagementID() {
		return int_MenuManagementID;
	}
	public void setInt_MenuManagementID(Integer int_MenuManagementID) {
		this.int_MenuManagementID = int_MenuManagementID;
	}
	public Integer getInt_RoleID() {
		return int_RoleID;
	}
	public void setInt_RoleID(Integer int_RoleID) {
		this.int_RoleID = int_RoleID;
	}
	public Integer getInt_MenuID() {
		return int_MenuID;
	}
	public void setInt_MenuID(Integer int_MenuID) {
		this.int_MenuID = int_MenuID;
	}
	public Integer getBt_Visible() {
		return bt_Visible;
	}
	public void setBt_Visible(Integer bt_Visible) {
		this.bt_Visible = bt_Visible;
	}
	private Integer int_ApartmentID;
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
}


