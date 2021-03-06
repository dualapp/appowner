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

@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="tb_chartofaccount")
public class ChartOfAccount implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer  int_AccountId;
	
	@Column(name="var_AccountType")
	private String str_AccountType;
	@Column(name="var_AccountName")
	private String str_AccountName;
	@Column
	private Integer int_UserId;
	@Column
	private Integer int_ApartmentId;
	public Integer getInt_AccountId() {
		return int_AccountId;
	}
	public void setInt_AccountId(Integer int_AccountId) {
		this.int_AccountId = int_AccountId;
	}
	
	public String getStr_AccountType() {
		return str_AccountType;
	}
	public void setStr_AccountType(String str_AccountType) {
		this.str_AccountType = str_AccountType;
	}
	public String getStr_AccountName() {
		return str_AccountName;
	}
	public void setStr_AccountName(String str_AccountName) {
		this.str_AccountName = str_AccountName;
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
    private Character ch_Group;
	public Character getCh_Group() {
		return ch_Group;
	}
	public void setCh_Group(Character ch_Group) {
		this.ch_Group = ch_Group;
	}
	
	
}
