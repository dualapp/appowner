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
@Table(name="tb_InvoiceTemplate")
public class InvoiceTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_InvoiceTemplateID;
	@Column(name = "int_ApartmentID")
	private Integer int_Organisation;
	@Column(name="var_InvoiceTemplateName")
	private String str_InvoiceTemplateName;
	
	private Boolean bl_Show;
	@Column(name="var_Frequency")
	private String str_Frequency;
	@Column(name="var_MessageCategory")
	private String str_MessageCategory;
	public Integer getInt_InvoiceTemplateID() {
		return int_InvoiceTemplateID;
	}
	public void setInt_InvoiceTemplateID(Integer int_InvoiceTemplateID) {
		this.int_InvoiceTemplateID = int_InvoiceTemplateID;
	}
	
	
	public Integer getInt_Organisation() {
		return int_Organisation;
	}
	public void setInt_Organisation(Integer int_Organisation) {
		this.int_Organisation = int_Organisation;
	}
	public String getStr_InvoiceTemplateName() {
		return str_InvoiceTemplateName;
	}
	public void setStr_InvoiceTemplateName(String str_InvoiceTemplateName) {
		this.str_InvoiceTemplateName = str_InvoiceTemplateName;
	}
	public Boolean getBl_Show() {
		return bl_Show;
	}
	public void setBl_Show(Boolean bl_Show) {
		this.bl_Show = bl_Show;
	}
	public String getStr_Frequency() {
		return str_Frequency;
	}
	public void setStr_Frequency(String str_Frequency) {
		this.str_Frequency = str_Frequency;
	}
	public String getStr_MessageCategory() {
		return str_MessageCategory;
	}
	public void setStr_MessageCategory(String str_MessageCategory) {
		this.str_MessageCategory = str_MessageCategory;
	}
	public String getStr_MessageTemplate() {
		return str_MessageTemplate;
	}
	public void setStr_MessageTemplate(String str_MessageTemplate) {
		this.str_MessageTemplate = str_MessageTemplate;
	}
	@Column(name="var_MessageTemplate")
	private String str_MessageTemplate;
	@Column(name="var_Description")
	private String str_Description;
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	@Column(name="var_DueTemplate")
	private String str_DueInvoiceTemplate;
	public String getStr_DueInvoiceTemplate() {
		return str_DueInvoiceTemplate;
	}
	public void setStr_DueInvoiceTemplate(String str_DueInvoiceTemplate) {
		this.str_DueInvoiceTemplate = str_DueInvoiceTemplate;
	}
	
}
