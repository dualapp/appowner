package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_memberlog")
public class MemberLog implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Integer int_MemberLogId;
	@Column 
	private Integer int_UserId;
	
	@Column 
	private Integer int_ApartmentId;
	
	@Column(name="var_Block")
	private String str_Block;
	@Column(name="var_UserEmailId")
	private String str_UserEmailId;
	@Column(name="var_LoggedInTime")
	private String str_LoggedInTime;
	@Column(name="var_LogOutTime")
	private String str_LogOutTime;
	
	
	public String getStr_LoggedInTime() {
		return str_LoggedInTime;
	}
	public void setStr_LoggedInTime(String str_LoggedInTime) {
		this.str_LoggedInTime = str_LoggedInTime;
	}
	public String getStr_LogOutTime() {
		return str_LogOutTime;
	}
	public void setStr_LogOutTime(String str_LogOutTime) {
		this.str_LogOutTime = str_LogOutTime;
	}
	public Integer getInt_MemberLogId() {
		return int_MemberLogId;
	}
	public void setInt_MemberLogId(Integer int_MemberLogId) {
		this.int_MemberLogId = int_MemberLogId;
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
	public String getStr_Block() {
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public String getStr_UserEmailId() {
		return str_UserEmailId;
	}
	public void setStr_UserEmailId(String str_UserEmailId) {
		this.str_UserEmailId = str_UserEmailId;
	}
	
	
	

}
