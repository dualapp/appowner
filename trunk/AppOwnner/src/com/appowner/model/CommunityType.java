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
@Table(name = "tb_communitytype")
public class CommunityType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_CommunityTypeId;
	public Integer getInt_CommunityTypeId() {
		return int_CommunityTypeId;
	}
	public void setInt_CommunityTypeId(Integer int_CommunityTypeId) {
		this.int_CommunityTypeId = int_CommunityTypeId;
	}
	public Integer getInt_CommunitySetupId() {
		return int_CommunitySetupId;
	}
	public void setInt_CommunitySetupId(Integer int_CommunitySetupId) {
		this.int_CommunitySetupId = int_CommunitySetupId;
	}
	@Column
	private Integer int_CommunitySetupId;
	@Column
	private Integer int_MasterCommunityTypeId;
	public Integer getInt_MasterCommunityTypeId() {
		return int_MasterCommunityTypeId;
	}
	public void setInt_MasterCommunityTypeId(Integer int_MasterCommunityTypeId) {
		this.int_MasterCommunityTypeId = int_MasterCommunityTypeId;
	}
	
}
