package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="tb_broadcastmsg")
public class BroadCastMessage1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer int_BroadcastMsgId;
	@Column 
	private Integer int_MessageTempId;
	@Column(name="var_MessageType")
	private String str_MessageType;
	@Column(name="var_Venue")
	private String str_Venue;
	@Column(name="var_MessageTempType")
	private String str_MessageTempType;
	@Column(name="var_Subject")
	private String str_Subject;
	@Column(name="var_Description")
	private String str_Description;
	@Column(name="var_Date")
	private String str_Date;
	public Integer getInt_BroadcastMsgId() {
		return int_BroadcastMsgId;
	}
	public void setInt_BroadcastMsgId(Integer int_BroadcastMsgId) {
		this.int_BroadcastMsgId = int_BroadcastMsgId;
	}
	public Integer getInt_MessageTempId() {
		return int_MessageTempId;
	}
	public void setInt_MessageTempId(Integer int_MessageTempId) {
		this.int_MessageTempId = int_MessageTempId;
	}
	public String getStr_MessageType() {
		return str_MessageType;
	}
	public void setStr_MessageType(String str_MessageType) {
		this.str_MessageType = str_MessageType;
	}
	public String getStr_MessageTempType() {
		return str_MessageTempType;
	}
	public void setStr_MessageTempType(String str_MessageTempType) {
		this.str_MessageTempType = str_MessageTempType;
	}
	public String getStr_Subject() {
		return str_Subject;
	}
	public void setStr_Subject(String str_Subject) {
		this.str_Subject = str_Subject;
	}
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	public String getStr_Date() {
		return str_Date;
	}
	public void setStr_Date(String str_Date) {
		this.str_Date = str_Date;
	}
	
	

	
	

}
