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
@Table(name = "tb_communitysetup")
public class CommunitySetup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private Integer int_CommunitySetupId;
	@Column 
	private Integer int_TotalNoOfHouses;
	@Column 
	private Integer int_NoOfBlocks;
	@Column 
	private Integer int_year;
	@Column 
	private Integer int_UserId;
	@Column 
	private Integer int_ApartmentID;
	 
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
	public Integer getInt_TotalNoOfHouses() {
		return int_TotalNoOfHouses;
	}
	public Integer getInt_CommunitySetupId() {
		return int_CommunitySetupId;
	}
	public void setInt_CommunitySetupId(Integer int_CommunitySetupId) {
		this.int_CommunitySetupId = int_CommunitySetupId;
	}
	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
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
	 
	 
	
	 

}
