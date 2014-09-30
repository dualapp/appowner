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
@Table(name="tb_parkingspace")
@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Parking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer int_ParkingId;
	@Column
	private Integer int_AppartmentId;
	@Column(name="var_Organization")
	private String str_OrganizationName;
	public Integer getInt_ParkingId() {
		return int_ParkingId;
	}
	public void setInt_ParkingId(Integer int_ParkingId) {
		this.int_ParkingId = int_ParkingId;
	}
	public String getStr_OrganizationName() {
		return str_OrganizationName;
	}
	public void setStr_OrganizationName(String str_OrganizationName) {
		this.str_OrganizationName = str_OrganizationName;
	}
	public String getStr_ParkingSlot() {
		return str_ParkingSlot;
	}
	public Integer getInt_AppartmentId() {
		return int_AppartmentId;
	}
	public void setInt_AppartmentId(Integer int_AppartmentId) {
		this.int_AppartmentId = int_AppartmentId;
	}
	public void setStr_ParkingSlot(String str_ParkingSlot) {
		this.str_ParkingSlot = str_ParkingSlot;
	}
	@Column(name="var_ParkingSlot")
	private String str_ParkingSlot;

}
