package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_makepayment")
public class cls_MakePayment implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer int_paymentid;
	
	@Column
	private String str_bankname;
	@Column
	private String str_paymenttype;
	@Column
	private Integer int_agencyid;
	public Integer getInt_agencyid() {
		return int_agencyid;
	}
	public void setInt_agencyid(Integer int_agencyid) {
		this.int_agencyid = int_agencyid;
	}
	@Column
	private Date checkdate;
	public int getApartementId() {
		return ApartementId;
	}
	public void setApartementId(int apartementId) {
		ApartementId = apartementId;
	}
	@Column
	private int ApartementId;
	public Date getStr_paymentDate() {
		return str_paymentDate;
	}
	public void setStr_paymentDate(Date str_paymentDate) {
		this.str_paymentDate = str_paymentDate;
	}
	private Date str_paymentDate;
	
	
	
	
	private String str_checkNo;
	
	
	public Integer getInt_paymentid() {
		return int_paymentid;
	}
	public void setInt_paymentid(Integer int_paymentid) {
		this.int_paymentid = int_paymentid;
	}
	
	public String getStr_bankname() {
		return str_bankname;
	}
	public void setStr_bankname(String str_bankname) {
		this.str_bankname = str_bankname;
	}
	
	public String getStr_checkNo() {
		return str_checkNo;
	}
	public void setStr_checkNo(String str_checkNo) {
		this.str_checkNo = str_checkNo;
	}
	
	public Date getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}
	public String getStr_paymenttype() {
		return str_paymenttype;
	}
	public void setStr_paymenttype(String str_paymenttype) {
		this.str_paymenttype = str_paymenttype;
	}
	
	
	
	
	


}
