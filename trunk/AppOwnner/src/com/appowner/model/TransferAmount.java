package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="tb_transferamount")
		
public class TransferAmount implements Serializable {

	
	private static final long serialVersionUID = 8692141488072943674L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_Transfer_ID;
	private double  dob_transfer_Amount;
	private Date dat_transfer_Date;
	private String from_Account;
	private String to_Acconut;
	@Column(name="var_Notes")
	private String str_Notes;
	public Integer getInt_Transfer_ID() {
		return int_Transfer_ID;
	}
	public void setInt_Transfer_ID(Integer int_Transfer_ID) {
		this.int_Transfer_ID = int_Transfer_ID;
	}
	public double getDob_transfer_Amount() {
		return dob_transfer_Amount;
	}
	public void setDob_transfer_Amount(double dob_transfer_Amount) {
		this.dob_transfer_Amount = dob_transfer_Amount;
	}
	public Date getDat_transfer_Date() {
		return dat_transfer_Date;
	}
	public void setDat_transfer_Date(Date dat_transfer_Date) {
		this.dat_transfer_Date = dat_transfer_Date;
	}
	public String getFrom_Account() {
		return from_Account;
	}
	public void setFrom_Account(String from_Account) {
		this.from_Account = from_Account;
	}
	public String getTo_Acconut() {
		return to_Acconut;
	}
	public void setTo_Acconut(String to_Acconut) {
		this.to_Acconut = to_Acconut;
	}
	public String getStr_Notes() {
		return str_Notes;
	}
	public void setStr_Notes(String str_Notes) {
		this.str_Notes = str_Notes;
	}
}
