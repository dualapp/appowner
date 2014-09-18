package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Manual_Journal")
public class ManualJournal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_ManualJournalID;
	@Column(name="var_OrganisationID")
	private Integer str_OrganisationID;
	
	private String dat_Date;
	@Column(name="var_Reference")
	private String str_Reference;
	@Column(name="var_Notes")
	private String str_Notes;
	@Column(name="var_DebitAccount")
	private String str_DebitAccount;
	@Column(name="var_CreditAccount")
	private String str_CreditAccount;
	private Double dbl_DebitAmount;
	private Double dbl_CreditAmount;
	public Integer getInt_ManualJournalID() {
		return int_ManualJournalID;
	}
	public void setInt_ManualJournalID(Integer int_ManualJournalID) {
		this.int_ManualJournalID = int_ManualJournalID;
	}
	
	
	public Integer getStr_OrganisationID() {
		return str_OrganisationID;
	}
	public void setStr_OrganisationID(Integer str_OrganisationID) {
		this.str_OrganisationID = str_OrganisationID;
	}
	public String getDat_Date() {
		return dat_Date;
	}
	public void setDat_Date(String dat_Date) {
		this.dat_Date = dat_Date;
	}
	public String getStr_Reference() {
		return str_Reference;
	}
	public void setStr_Reference(String str_Reference) {
		this.str_Reference = str_Reference;
	}
	public String getStr_Notes() {
		return str_Notes;
	}
	public void setStr_Notes(String str_Notes) {
		this.str_Notes = str_Notes;
	}
	public String getStr_DebitAccount() {
		return str_DebitAccount;
	}
	public void setStr_DebitAccount(String str_DebitAccount) {
		this.str_DebitAccount = str_DebitAccount;
	}
	public String getStr_CreditAccount() {
		return str_CreditAccount;
	}
	public void setStr_CreditAccount(String str_CreditAccount) {
		this.str_CreditAccount = str_CreditAccount;
	}
	public Double getDbl_DebitAmount() {
		return dbl_DebitAmount;
	}
	public void setDbl_DebitAmount(Double dbl_DebitAmount) {
		this.dbl_DebitAmount = dbl_DebitAmount;
	}
	public Double getDbl_CreditAmount() {
		return dbl_CreditAmount;
	}
	public void setDbl_CreditAmount(Double dbl_CreditAmount) {
		this.dbl_CreditAmount = dbl_CreditAmount;
	}
	
	
}
