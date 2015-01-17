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
@Table(name="tb_adminstration_access")
@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class AdministrationAccess implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer Int_AdminAccessID;
	
	@Column
	private Integer Int_RoleID;
	@Column
	private Integer Int_UserID;
	@Column
	private Integer  Int_AppartmentID;
	public Integer getInt_AdminAccessID() {
		return Int_AdminAccessID;
	}
	 
	public void setInt_AdminAccessID(Integer int_AdminAccessID) {
		Int_AdminAccessID = int_AdminAccessID;
	}
	public Integer getInt_RoleID() {
		return Int_RoleID;
	}
	public void setInt_RoleID(Integer int_RoleID) {
		Int_RoleID = int_RoleID;
	}
	public Integer getInt_UserID() {
		return Int_UserID;
	}
	public void setInt_UserID(Integer int_UserID) {
		Int_UserID = int_UserID;
	}
	public Integer getInt_AppartmentID() {
		return Int_AppartmentID;
	}
	public void setInt_AppartmentID(Integer int_AppartmentID) {
		Int_AppartmentID = int_AppartmentID;
	}
}
