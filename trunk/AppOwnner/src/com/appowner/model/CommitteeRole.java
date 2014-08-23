package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_Commitee_Roles")
public class CommitteeRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="int_Commitee_Role_ID")
	private Integer int_Committee_Role_ID;
	@Column(name="var_Commitee_Role_Name")
	private String str_Committee_Role_Name;
	@Column(name="ch_Commitee_Type")
	
	private Character ch_Committee_Type;
	@Column(name="int_ApartmentID")
	private Integer int_AppartmentID;
	@Column(name="isActive")
	private Boolean bool_is_Active;
	public Boolean getBool_is_Active() {
		return bool_is_Active;
	}
	public void setBool_is_Active(Boolean bool_is_Active) {
		this.bool_is_Active = bool_is_Active;
	}
	@Column(name="isDelete")
	private Boolean bool_is_Delete;
	
	 
	public Integer getInt_Committee_Role_ID() {
		return int_Committee_Role_ID;
	}
	public void setInt_Committee_Role_ID(Integer int_Committee_Role_ID) {
		this.int_Committee_Role_ID = int_Committee_Role_ID;
	}
	public Integer getInt_AppartmentID() {
		return int_AppartmentID;
	}
	public void setInt_AppartmentID(Integer int_AppartmentID) {
		this.int_AppartmentID = int_AppartmentID;
	}
 
	public Boolean getBool_is_Delete() {
		return bool_is_Delete;
	}
	public void setBool_is_Delete(Boolean bool_is_Delete) {
		this.bool_is_Delete = bool_is_Delete;
	}
	public String getStr_Committee_Role_Name() {
		return str_Committee_Role_Name;
	}
	public void setStr_Committee_Role_Name(String str_Committee_Role_Name) {
		this.str_Committee_Role_Name = str_Committee_Role_Name;
	}
	public Character getCh_Committee_Type() {
		return ch_Committee_Type;
	}
	public void setCh_Committee_Type(Character ch_Committee_Type) {
		this.ch_Committee_Type = ch_Committee_Type;
	}
	

}
