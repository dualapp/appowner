package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_agency")
public class agency_information implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_agencyid;
	
	
	private String str_agencyname;
	private String ads_type;
	private String str_addposition;
	private String str_content;
	public Integer getInt_agencyid() {
		return int_agencyid;
	}
	public void setInt_agencyid(Integer int_agencyid) {
		this.int_agencyid = int_agencyid;
	}
	public String getStr_agencyname() {
		return str_agencyname;
	}
	public void setStr_agencyname(String str_agencyname) {
		this.str_agencyname = str_agencyname;
	}
	public String getAds_type() {
		return ads_type;
	}
	public void setAds_type(String ads_type) {
		this.ads_type = ads_type;
	}
	public String getStr_addposition() {
		return str_addposition;
	}
	public void setStr_addposition(String str_addposition) {
		this.str_addposition = str_addposition;
	}
	public String getStr_content() {
		return str_content;
	}
	public void setStr_content(String str_content) {
		this.str_content = str_content;
	}
}
