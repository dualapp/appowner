package com.appowner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tb_Members")
public class Members {
private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_memberid;;
	@Column
	private String str_firstname;
	@Column
	private String str_lasttname;
	@Column
	private int int_mobile;
	@Column
	private int int_phone;
	@Column
	private int int_intercom;
	@Column
	private String str_address;
	@Column
	private String str_email;
	@Column
	private String str_password;;
	@Column
	private String str_conformpassword;
	
	@Column
	private String str_organizationtype;
	
	@Column
	private String str_organization;
	
	@Column
	private String str_role;
	
	
	
	public String getStr_email() {
		return str_email;
	}
	public void setStr_email(String str_email) {
		this.str_email = str_email;
	}
	
	public String getStr_password() {
		return str_password;
	}
	public void setStr_password(String str_password) {
		this.str_password = str_password;
	}
	public String getStr_conformpassword() {
		return str_conformpassword;
	}
	public void setStr_conformpassword(String str_conformpassword) {
		this.str_conformpassword = str_conformpassword;
	}
	public Integer getInt_memberid() {
		return int_memberid;
	}
	public void setInt_memberid(Integer int_memberid) {
		this.int_memberid = int_memberid;
	}
	public String getStr_firstname() {
		return str_firstname;
	}
	public void setStr_firstname(String str_firstname) {
		this.str_firstname = str_firstname;
	}
	public String getStr_lasttname() {
		return str_lasttname;
	}
	public void setStr_lasttname(String str_lasttname) {
		this.str_lasttname = str_lasttname;
	}
	public int getInt_mobile() {
		return int_mobile;
	}
	public void setInt_mobile(int int_mobile) {
		this.int_mobile = int_mobile;
	}
	public int getInt_phone() {
		return int_phone;
	}
	public void setInt_phone(int int_phone) {
		this.int_phone = int_phone;
	}
	public int getInt_intercom() {
		return int_intercom;
	}
	public void setInt_intercom(int int_intercom) {
		this.int_intercom = int_intercom;
	}
	public String getStr_address() {
		return str_address;
	}
	public void setStr_address(String str_address) {
		this.str_address = str_address;
	}
	
	
}
