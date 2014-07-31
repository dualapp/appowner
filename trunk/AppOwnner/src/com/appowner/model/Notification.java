package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ad_notification")
public class Notification implements Serializable {

	/**
	 * mukesh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Int_NotificationId;
	@Column
	private String str_Intent;
	@Column
	private String str_Status;
	@Column
	private String str_Posted;
	@Column
	private String str_Type;
	public Integer getInt_NotificationId() {
		return Int_NotificationId;
	}
	public void setInt_NotificationId(Integer int_NotificationId) {
		Int_NotificationId = int_NotificationId;
	}
	public String getStr_Intent() {
		return str_Intent;
	}
	public void setStr_Intent(String str_Intent) {
		this.str_Intent = str_Intent;
	}
	public String getStr_Status() {
		return str_Status;
	}
	public void setStr_Status(String str_Status) {
		this.str_Status = str_Status;
	}
	public String getStr_Posted() {
		return str_Posted;
	}
	public void setStr_Posted(String str_Posted) {
		this.str_Posted = str_Posted;
	}
	public String getStr_Type() {
		return str_Type;
	}
	public void setStr_Type(String str_Type) {
		this.str_Type = str_Type;
	}
	
	
}