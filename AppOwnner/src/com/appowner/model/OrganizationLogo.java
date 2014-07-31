package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_othersapptinfo")
public class OrganizationLogo  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Integer int_OthersInfoId;
	@Column 
	private Integer int_AppartmentId;
	@Column(name="var_Appartment_Img")
	private String str_Appartment_Img;
	@Column(name="var_Appartment_Logo")
	private String str_Appartment_Logo;
	@Column(name="var_InTime")
	private String  str_InTime;
	@Column(name="var_OutTime")
	private String str_OutTime;
	@Column(name="var_TextLogo")
	private String str_TextLogo;
	@Column(name="var_WelcomeMsg")
	private String str_WelcomeMsg;
	@Column(name="var_Document_Upload")
	private String str_Document_Upload;
	@Column(name="var_ApptAddress")
	private String str_ApptAddress;
	public String getStr_ApptAddress() {
		return str_ApptAddress;
	}
	public void setStr_ApptAddress(String str_ApptAddress) {
		this.str_ApptAddress = str_ApptAddress;
	}
	 
	public Integer getInt_OthersInfoId() {
		return int_OthersInfoId;
	}
	public void setInt_OthersInfoId(Integer int_OthersInfoId) {
		this.int_OthersInfoId = int_OthersInfoId;
	}
	public Integer getInt_AppartmentId() {
		return int_AppartmentId;
	}
	public void setInt_AppartmentId(Integer int_AppartmentId) {
		this.int_AppartmentId = int_AppartmentId;
	}
	public String getStr_Appartment_Img() {
		return str_Appartment_Img;
	}
	public void setStr_Appartment_Img(String str_Appartment_Img) {
		this.str_Appartment_Img = str_Appartment_Img;
	}
	public String getStr_Appartment_Logo() {
		return str_Appartment_Logo;
	}
	public void setStr_Appartment_Logo(String str_Appartment_Logo) {
		this.str_Appartment_Logo = str_Appartment_Logo;
	}
	public String getStr_InTime() {
		return str_InTime;
	}
	public void setStr_InTime(String str_InTime) {
		this.str_InTime = str_InTime;
	}
	public String getStr_OutTime() {
		return str_OutTime;
	}
	public void setStr_OutTime(String str_OutTime) {
		this.str_OutTime = str_OutTime;
	}
	public String getStr_TextLogo() {
		return str_TextLogo;
	}
	public void setStr_TextLogo(String str_TextLogo) {
		this.str_TextLogo = str_TextLogo;
	}
	public String getStr_WelcomeMsg() {
		return str_WelcomeMsg;
	}
	public void setStr_WelcomeMsg(String str_WelcomeMsg) {
		this.str_WelcomeMsg = str_WelcomeMsg;
	}
	public String getStr_Document_Upload() {
		return str_Document_Upload;
	}
	public void setStr_Document_Upload(String str_Document_Upload) {
		this.str_Document_Upload = str_Document_Upload;
	}
	 
 
}
