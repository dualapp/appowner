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
@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "tb_pool")
public class Pool implements  Serializable,Comparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_PoolId;
	@Column
	private Integer int_OrganizationId;
	@Column(name="var_PoolQuestion")
	private String str_poolQuestion;
	@Column 
	private Date dat_StartDate;
	@Column 
	private Date date_EndDate;
	 
	 
	 
	 
	public Date getDat_StartDate() {
		return dat_StartDate;
	}
	public void setDat_StartDate(Date dat_StartDate) {
		this.dat_StartDate = dat_StartDate;
	}
	public Date getDate_EndDate() {
		return date_EndDate;
	}
	public void setDate_EndDate(Date date_EndDate) {
		this.date_EndDate = date_EndDate;
	}

	@Column(name="var_CreatedBy")
	private String str_CreatedBy;
	@Column(name="var_Status")
	private String str_Status;
	@Column (name="var_poolAudience")
	private String str_poolAudience;
	@Column 
	private Integer int_userId;
	@Column 
	private Long int_Vote;
	@Column(name="var_Choise1")
	private String str_Choise1;
	@Column(name="var_Choise2")
	private String str_Choise2;
	@Column(name="var_Choise3")
	private String str_Choise3;
	
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
	 

	public String getStr_poolAudience() {
		return str_poolAudience;
	}
	public void setStr_poolAudience(String str_poolAudience) {
		this.str_poolAudience = str_poolAudience;
	}
	public Long getInt_Vote() {
		return int_Vote;
	}
	public void setInt_Vote(Long int_Vote) {
		this.int_Vote = int_Vote;
	}
	public String getStr_Choise1() {
		return str_Choise1;
	}
	public void setStr_Choise1(String str_Choise1) {
		this.str_Choise1 = str_Choise1;
	}
	public String getStr_Choise2() {
		return str_Choise2;
	}
	public void setStr_Choise2(String str_Choise2) {
		this.str_Choise2 = str_Choise2;
	}
	public String getStr_Choise3() {
		return str_Choise3;
	}
	public void setStr_Choise3(String str_Choise3) {
		this.str_Choise3 = str_Choise3;
	}
	public int compareTo(Object poll) {
		 Integer id=((Pool) poll).getInt_PoolId();
	        /* For Ascending order*/
	      //  return this.studentage-compareage;

	        /* For Descending order do like this */
	       return id-this.int_PoolId ;
	  
	}

	
	
	
	
	

}
