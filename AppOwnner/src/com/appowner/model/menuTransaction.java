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
@Table(name="tb_menutransaction")
public class menuTransaction implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_menuTransactionID;
	private Integer int_subcriptionID;
	@Column(name="var_menuID")
	private String str_menuID;
	public Integer getInt_menuTransactionID() {
		return int_menuTransactionID;
	}
	public void setInt_menuTransactionID(Integer int_menuTransactionID) {
		this.int_menuTransactionID = int_menuTransactionID;
	}
	public Integer getInt_subcriptionID() {
		return int_subcriptionID;
	}
	public void setInt_subcriptionID(Integer int_subcriptionID) {
		this.int_subcriptionID = int_subcriptionID;
	}
	public String getStr_menuID() {
		return str_menuID;
	}
	public void setStr_menuID(String str_menuID) {
		this.str_menuID = str_menuID;
	}
}
