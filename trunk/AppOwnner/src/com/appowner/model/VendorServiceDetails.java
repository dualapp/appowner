package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "tb_vendorservicedetails")
public class VendorServiceDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
    private Integer int_ServiceId;
	@Column 
    private String str_ServiceName;
	@Column(name="int_ServicePrice")
    private String int_ServicePrice;
	@Column(name="int_VendorId")
	private Integer int_VendorId;
	 
	public Integer getInt_VendorId() {
		return int_VendorId;
	}
	public void setInt_VendorId(Integer int_VendorId) {
		this.int_VendorId = int_VendorId;
	}
	public String getStr_ServiceName() {
		return str_ServiceName;
	}
	public void setStr_ServiceName(String str_ServiceName) {
		this.str_ServiceName = str_ServiceName;
	}
	public String getInt_ServicePrice() {
		return int_ServicePrice;
	}
	public void setInt_ServicePrice(String int_ServicePrice2) {
		this.int_ServicePrice = int_ServicePrice2;
	}
	public Integer getInt_ServiceId() {
		return int_ServiceId;
	}
	public void setInt_ServiceId(Integer int_ServiceId) {
		this.int_ServiceId = int_ServiceId;
	}
	 
	
	

}
