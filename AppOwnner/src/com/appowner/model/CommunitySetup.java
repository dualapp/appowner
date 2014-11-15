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
@Table(name = "tb_CommunitySetup")
public class CommunitySetup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private Integer int_SetupId;
	public Integer getInt_SetupId() {
		return int_SetupId;
	}
	public void setInt_SetupId(Integer int_SetupId) {
		this.int_SetupId = int_SetupId;
	}
	public Integer getInt_TotalNoOfHouses() {
		return int_TotalNoOfHouses;
	}
	public void setInt_TotalNoOfHouses(Integer int_TotalNoOfHouses) {
		this.int_TotalNoOfHouses = int_TotalNoOfHouses;
	}
	public Integer getInt_NoOfBlocks() {
		return int_NoOfBlocks;
	}
	public void setInt_NoOfBlocks(Integer int_NoOfBlocks) {
		this.int_NoOfBlocks = int_NoOfBlocks;
	}
	public Integer getInt_year() {
		return int_year;
	}
	public void setInt_year(Integer int_year) {
		this.int_year = int_year;
	}
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	public String getStr_CommunitySetupType() {
		return str_CommunitySetupType;
	}
	public void setStr_CommunitySetupType(String str_CommunitySetupType) {
		this.str_CommunitySetupType = str_CommunitySetupType;
	}
	@Column 
	private Integer int_TotalNoOfHouses;
	@Column 
	private Integer int_NoOfBlocks;
	@Column 
	private Integer int_year;
	@Column 
	private Integer int_ApartmentId;
	@Column(name="var_CommunitySetupType")
	private String str_CommunitySetupType;

}
