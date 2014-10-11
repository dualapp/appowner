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
@Table(name="tb_AccountingGroup")
public class AccountingGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_Acct_GroupID;
	@Column(name="var_Acct_GroupName")
	private String str_Acct_GroupName;
	private Character ch_Group;
	private Boolean bl_Default;
	public Integer getInt_Acct_GroupID() {
		return int_Acct_GroupID;
	}
	public void setInt_Acct_GroupID(Integer int_Acct_GroupID) {
		this.int_Acct_GroupID = int_Acct_GroupID;
	}
	public String getStr_Acct_GroupName() {
		return str_Acct_GroupName;
	}
	public void setStr_Acct_GroupName(String str_Acct_GroupName) {
		this.str_Acct_GroupName = str_Acct_GroupName;
	}
	public Character getCh_Group() {
		return ch_Group;
	}
	public void setCh_Group(Character ch_Group) {
		this.ch_Group = ch_Group;
	}
	public Boolean getBl_Default() {
		return bl_Default;
	}
	public void setBl_Default(Boolean bl_Default) {
		this.bl_Default = bl_Default;
	}
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
	private Integer int_ApartmentID;
	
}
