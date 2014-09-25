package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_TaxTemplate")
public class TaxTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer int_TaxTemplateID;
	@Column(name = "var_Organisation")
	private String str_Organisation;
	@Column(name = "var_TaxName")
	private String str_TaxName;
	
	public Integer getInt_TaxTemplateID() {
		return int_TaxTemplateID;
	}
	public void setInt_TaxTemplateID(Integer int_TaxTemplateID) {
		this.int_TaxTemplateID = int_TaxTemplateID;
	}
	public String getStr_Organisation() {
		return str_Organisation;
	}
	public void setStr_Organisation(String str_Organisation) {
		this.str_Organisation = str_Organisation;
	}
	public String getStr_TaxName() {
		return str_TaxName;
	}
	public void setStr_TaxName(String str_TaxName) {
		this.str_TaxName = str_TaxName;
	}
	
	
	

	public double getInt_Percentage() {
		return int_Percentage;
	}
	public void setInt_Percentage(double int_Percentage) {
		this.int_Percentage = int_Percentage;
	}
	public double getInt_TaxExemption() {
		return int_TaxExemption;
	}
	public void setInt_TaxExemption(double int_TaxExemption) {
		this.int_TaxExemption = int_TaxExemption;
	}




	private double int_Percentage;
	@Column(name = "var_Frequency")
	private double int_TaxExemption;
}
