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
@Table(name = "tb_communitytypemaster")
public class CommunityTypeMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer getInt_MasterCommunityTypeId() {
		return int_MasterCommunityTypeId;
	}
	public void setInt_MasterCommunityTypeId(Integer int_MasterCommunityTypeId) {
		this.int_MasterCommunityTypeId = int_MasterCommunityTypeId;
	}
	public String getStr_CommunityType() {
		return str_CommunityType;
	}
	public void setStr_CommunityType(String str_CommunityType) {
		this.str_CommunityType = str_CommunityType;
	}
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private Integer int_MasterCommunityTypeId;
	@Column(name="var_CommunityType")
	private String str_CommunityType;
	

}
