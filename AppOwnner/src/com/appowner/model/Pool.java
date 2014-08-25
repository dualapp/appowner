package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_pool")
public class Pool implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_PoolId;
	@Column
	private Integer int_OrganizationId;
	@Column(name="var_PoolQuestion")
	private String str_poolQuestion;
	@Column(name="var_Startdate")
	private String str_StartDate;
	@Column(name="var_EndDate")
	private String str_EndDate;
	@Column(name="var_CreatedBy")
	private String str_CreatedBy;
	@Column(name="var_Status")
	private String str_Status;
	@Column 
	private Integer int_poolAudience;
	@Column 
	private Integer int_userId;
	
	public Integer getInt_PoolId() {
		return int_PoolId;
	}
	public void setInt_PoolId(Integer int_PoolId) {
		this.int_PoolId = int_PoolId;
	}
	public Integer getInt_OrganizationId() {
		return int_OrganizationId;
	}
	public void setInt_OrganizationId(Integer int_OrganizationId) {
		this.int_OrganizationId = int_OrganizationId;
	}
	public String getStr_poolQuestion() {
		return str_poolQuestion;
	}
	public void setStr_poolQuestion(String str_poolQuestion) {
		this.str_poolQuestion = str_poolQuestion;
	}
	public String getStr_StartDate() {
		return str_StartDate;
	}
	public void setStr_StartDate(String str_StartDate) {
		this.str_StartDate = str_StartDate;
	}
	 
	public String getStr_EndDate() {
		return str_EndDate;
	}
	public void setStr_EndDate(String str_EndDate) {
		this.str_EndDate = str_EndDate;
	}
	public Integer getInt_userId() {
		return int_userId;
	}
	public void setInt_userId(Integer int_userId) {
		this.int_userId = int_userId;
	}
	public String getStr_CreatedBy() {
		return str_CreatedBy;
	}
	public void setStr_CreatedBy(String str_CreatedBy) {
		this.str_CreatedBy = str_CreatedBy;
	}
	public String getStr_Status() {
		return str_Status;
	}
	public void setStr_Status(String str_Status) {
		this.str_Status = str_Status;
	}
	public Integer getInt_poolAudience() {
		return int_poolAudience;
	}
	public void setInt_poolAudience(Integer int_poolAudience) {
		this.int_poolAudience = int_poolAudience;
	}
	public Integer getInt_Vote() {
		return int_Vote;
	}
	public void setInt_Vote(Integer int_Vote) {
		this.int_Vote = int_Vote;
	}
	@Column 
	private Integer int_Vote;
	
	
	
	

}
