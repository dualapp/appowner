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

@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="tb_addtemplate_message")
public class AddTemplateMessage implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Integer int_AddTemplateMessageId;
	@Column(name="var_MessageType")
	private String str_MessageType;
	@Column(name="var_Subject")
	private String str_Subject;
	@Column(name="var_Description")
	private String str_Description;
	@Column(name="var_Venue")
	private String str_Venue;
	@Column 
	private Integer int_MessageTypeId;
	public Integer getInt_AddTemplateMessageId() {
		return int_AddTemplateMessageId;
	}
	public void setInt_AddTemplateMessageId(Integer int_AddTemplateMessageId) {
		this.int_AddTemplateMessageId = int_AddTemplateMessageId;
	}
	public Integer getInt_MessageTypeId() {
		return int_MessageTypeId;
	}
	public void setInt_MessageTypeId(Integer int_MessageTypeId) {
		this.int_MessageTypeId = int_MessageTypeId;
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
	 
	public String getStr_MessageType() {
		return str_MessageType;
	}
	public void setStr_MessageType(String str_MessageType) {
		this.str_MessageType = str_MessageType;
	}

}
