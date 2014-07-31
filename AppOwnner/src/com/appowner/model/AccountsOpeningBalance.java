package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Accounts_Opening_Balance")
public class AccountsOpeningBalance implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_Accounts_OpeningID;
	public Integer getInt_Accounts_OpeningID() {
		return int_Accounts_OpeningID;
	}
	public void setInt_Accounts_OpeningID(Integer int_Accounts_OpeningID) {
		this.int_Accounts_OpeningID = int_Accounts_OpeningID;
	}
	
	public String getStr_AccountsHead() {
		return str_AccountsHead;
	}
	public void setStr_AccountsHead(String str_AccountsHead) {
		this.str_AccountsHead = str_AccountsHead;
	}
	public Double getInt_Debit() {
		return int_Debit;
	}
	public void setInt_Debit(Double int_Debit) {
		this.int_Debit = int_Debit;
	}
	public Double getInt_Credit() {
		return int_Credit;
	}
	public void setInt_Credit(Double int_Credit) {
		this.int_Credit = int_Credit;
	}
	@Column(name="var_AccountsHead")
	private String str_AccountsHead;
	private Double int_Debit;
	private Double int_Credit;
	
	
}
