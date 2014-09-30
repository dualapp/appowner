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
@Table(name="tb_vote")
public class Vote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Integer int_VoteId;
	@Column 
	private Integer int_UserId;
	@Column 
	private Integer int_OrganizationId;
	@Column 
	private Integer int_PoolId;
	@Column(name="var_Remark")
	private String str_Remark;
	@Column(name="var_Choise")
	private String str_Choise;
	
	public String getStr_Remark() {
		return str_Remark;
	}
	public void setStr_Remark(String str_Remark) {
		this.str_Remark = str_Remark;
	}
	public String getStr_Choise() {
		return str_Choise;
	}
	public void setStr_Choise(String str_Choise) {
		this.str_Choise = str_Choise;
	}
	public Integer getInt_VoteId() {
		return int_VoteId;
	}
	public void setInt_VoteId(Integer int_VoteId) {
		this.int_VoteId = int_VoteId;
	}
	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}
	public Integer getInt_OrganizationId() {
		return int_OrganizationId;
	}
	public void setInt_OrganizationId(Integer int_OrganizationId) {
		this.int_OrganizationId = int_OrganizationId;
	}
	public Integer getInt_PoolId() {
		return int_PoolId;
	}
	public void setInt_PoolId(Integer int_PoolId) {
		this.int_PoolId = int_PoolId;
	}
	
	

}
