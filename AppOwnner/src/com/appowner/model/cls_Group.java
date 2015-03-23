package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_group")
public class  cls_Group implements Serializable 
{
/**
	 * mukesh
	 */
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_GroupId;
	public Integer getInt_GroupId() {
		return int_GroupId;
	}
	public void setInt_GroupId(Integer int_GroupId) {
		this.int_GroupId = int_GroupId;
	}
	@Column
	private String str_GroupNm;
	@Column
	private  String str_Groupaddress;
	@Column
	private String  str_groupPrivate;
	@Column
	private String str_GroupDescription;
	@Column
	private char  isCh_EmailAllow;
	@Column
	private int int_ApartmentID;
	@Column
	private Integer userId;
	
	@Column
	private Boolean bol_Smsallow;
	@Column
	private Boolean bol_Emailallow;
	@Column
	private int  int_Nomember;
	public int getInt_Nomember() {
		return int_Nomember;
	}
	public void setInt_Nomember(int int_Nomember) {
		this.int_Nomember = int_Nomember;
	}
	public Boolean getBol_Smsallow() {
		return bol_Smsallow;
	}
	public Boolean getBol_Emailallow() {
		return bol_Emailallow;
	}
	public void setBol_Smsallow(Boolean bol_Smsallow) {
		this.bol_Smsallow = bol_Smsallow;
	}
	public void setBol_Emailallow(Boolean bol_Emailallow) {
		this.bol_Emailallow = bol_Emailallow;
	}
	public String getStr_GroupNm() {
		return str_GroupNm;
	}
	public void setStr_GroupNm(String str_GroupNm) {
		this.str_GroupNm = str_GroupNm;
	}
	public String getStr_Groupaddress() {
		return str_Groupaddress;
	}
	public void setStr_Groupaddress(String str_Groupaddress) {
		this.str_Groupaddress = str_Groupaddress;
	}
	public String getStr_groupPrivate() {
		return str_groupPrivate;
	}
	public void setStr_groupPrivate(String str_groupPrivate) {
		this.str_groupPrivate = str_groupPrivate;
	}
	
	
	public char getIsCh_EmailAllow() {
		return isCh_EmailAllow;
	}
	public void setIsCh_EmailAllow(char isCh_EmailAllow) {
		this.isCh_EmailAllow = isCh_EmailAllow;
	}
	public String getStr_GroupDescription() {
		return str_GroupDescription;
	}
	public void setStr_GroupDescription(String str_GroupDescription) {
		this.str_GroupDescription = str_GroupDescription;
	}
	public int getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(int int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}

	
	

	