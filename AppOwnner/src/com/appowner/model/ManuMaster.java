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
@Table(name="tb_menumaster")
public class ManuMaster implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_MenuID;
	@Column(name="var_MenuName")
	private String str_MenuName;
	public Integer getInt_MenuID() {
		return int_MenuID;
	}
	public void setInt_MenuID(Integer int_MenuID) {
		this.int_MenuID = int_MenuID;
	}
	public String getStr_MenuName() {
		return str_MenuName;
	}
	public void setStr_MenuName(String str_MenuName) {
		this.str_MenuName = str_MenuName;
	}
	public Integer getInt_MenuParentID() {
		return int_MenuParentID;
	}
	public void setInt_MenuParentID(Integer int_MenuParentID) {
		this.int_MenuParentID = int_MenuParentID;
	}
	private Integer int_MenuParentID;
}
