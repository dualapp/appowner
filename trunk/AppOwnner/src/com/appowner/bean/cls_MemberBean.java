package com.appowner.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;
import javax.persistence.Column;

import com.appowner.model.Members;
import com.appowner.service.MembersDetailService;
import com.appowner.service.ProductsDetailService;

public class cls_MemberBean implements Serializable{
	
private static final long serialVersionUID = 1L;

private Integer int_memberid;;
private String str_firstname;
private String str_lasttname;
private int int_mobile;
private int int_phone;
private int int_intercom;
private String str_address;
private String str_email;
private String str_password;;
private String str_conformpassword;
private String str_organizationtype;
private String str_organization;
private String str_role;
@ManagedProperty(value ="#{MembersDetailService}")
	 
private MembersDetailService MembersDetailService;


public MembersDetailService getMembersDetailService() {
	return MembersDetailService;
}
public void setMembersDetailService(MembersDetailService membersDetailService) {
	MembersDetailService = membersDetailService;
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
public String getStr_organizationtype() {
	return str_organizationtype;
}
public void setStr_organizationtype(String str_organizationtype) {
	this.str_organizationtype = str_organizationtype;
}
public String getStr_organization() {
	return str_organization;
}
public void setStr_organization(String str_organization) {
	this.str_organization = str_organization;
}
public String getStr_role() {
	return str_role;
}
public void setStr_role(String str_role) {
	this.str_role = str_role;
}

	
	
	
	public void Addmember()
	{
		
		Members m1= new Members();
		m1.setInt_mobile(getInt_mobile());
		m1.setInt_intercom(getInt_intercom());
		m1.setInt_phone(getInt_phone());
		m1.setStr_address(getStr_address());
		m1.setStr_email(getStr_email());
		m1.setStr_password(getStr_password());
		m1.setStr_firstname(getStr_firstname());
		m1.setStr_lasttname(getStr_lasttname());
		m1.setStr_conformpassword(getStr_conformpassword());
	    m1.setStr_organization(getStr_organization());
	    m1.setStr_organizationtype(getStr_organizationtype());
	    m1.setStr_role(getStr_role());
	    getMembersDetailService().addmembers(m1);
	    
	}
	
	
	
	
	

}
