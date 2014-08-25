package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_facilityneeded")
public class FacilityNeeded implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer int_FacilityId;
	@Column(name="var_FacilityName")
	private String str_FacilityName;
	@Column 
	private Integer int_ApartmentId;
	public Integer getInt_FacilityId() {
		return int_FacilityId;
	}
	public void setInt_FacilityId(Integer int_FacilityId) {
		this.int_FacilityId = int_FacilityId;
	}
	public String getStr_FacilityName() {
		return str_FacilityName;
	}
	public void setStr_FacilityName(String str_FacilityName) {
		this.str_FacilityName = str_FacilityName;
	}
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	
}
