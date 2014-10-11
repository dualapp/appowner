package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="tb_MessageTemplate")
public class MessageTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_MessageTemplateID;
	@Column(name="var_CreatedBy")
	private String str_CreatedBy;
	@Column(name="var_Email")
	private String str_Email;
	@Column(name="dat_Date")
	 private String dat_Date;
	 public Integer getInt_MessageTemplateID() {
		return int_MessageTemplateID;
	}
	public void setInt_MessageTemplateID(Integer int_MessageTemplateID) {
		this.int_MessageTemplateID = int_MessageTemplateID;
	}
	public String getStr_CreatedBy() {
		return str_CreatedBy;
	}
	public void setStr_CreatedBy(String str_CreatedBy) {
		this.str_CreatedBy = str_CreatedBy;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	
	
	public String getDat_Date() {
		return dat_Date;
	}
	public void setDat_Date(String dat_Date) {
		this.dat_Date = dat_Date;
	}
	public String getStr_Mode() {
		return str_Mode;
	}
	public void setStr_Mode(String str_Mode) {
		this.str_Mode = str_Mode;
	}
	public String getStr_Category() {
		return str_Category;
	}
	public void setStr_Category(String str_Category) {
		this.str_Category = str_Category;
	}
	public String getStr_Title() {
		return str_Title;
	}
	public void setStr_Title(String str_Title) {
		this.str_Title = str_Title;
	}
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	@Column(name="var_Mode")
	private String str_Mode;
	@Column(name="var_Category")
	private String str_Category;
	@Column(name="var_Title")
	private String str_Title;
	@Column(name="var_Description")
	private String str_Description;
	@Column(name="var_Organisation")
	private String str_Organisation;
	public String getStr_Organisation() {
		return str_Organisation;
	}
	public void setStr_Organisation(String str_Organisation) {
		this.str_Organisation = str_Organisation;
	}
	
	
}
