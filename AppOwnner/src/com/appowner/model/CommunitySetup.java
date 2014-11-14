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
