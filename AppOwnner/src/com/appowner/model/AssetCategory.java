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
@Table(name="tb_assetscategory")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class AssetCategory  implements  Serializable,Comparable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_assetcatId;
	@Column(name="var_organizationname")
	
	private String str_OrganizationName;
	public Integer getInt_AppartmentId() {
		return int_AppartmentId;
	}
	public void setInt_AppartmentId(Integer int_AppartmentId) {
		this.int_AppartmentId = int_AppartmentId;
	}
	@Column
	private Integer int_AppartmentId;
	@Column(name="var_assetcat_name")
	private String str_assetcat_name;
	 
	public Integer getInt_assetcatId() {
		return int_assetcatId;
	}
	public String getStr_OrganizationName() {
		return str_OrganizationName;
	}
	public void setStr_OrganizationName(String str_OrganizationName) {
		this.str_OrganizationName = str_OrganizationName;
	}
	public void setInt_assetcatId(Integer int_assetcatId) {
		this.int_assetcatId = int_assetcatId;
	}
	public String getStr_assetcat_name() {
		return str_assetcat_name;
	}
	public void setStr_assetcat_name(String str_assetcat_name) {
		this.str_assetcat_name = str_assetcat_name;
	}
	@Override
	public int compareTo(Object assetCategory) {
		// TODO Auto-generated method stub
		Integer aid=((AssetCategory)assetCategory).getInt_assetcatId();
		/* For Ascending order*/
	      //  return this.int_FacilityBookId;

	        /* For Descending order do like this */
		return aid-this.int_assetcatId;
	}

}
