package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Management")
public class Cls_SubcriptionOption implements Serializable 
{
/**
	 * mukesh
	 */
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_ServiceId;
	@Column
	private Integer subcriptID;
	
	 @Column
	 private Integer int_OptionId;
public Integer getInt_OptionId() {
		return int_OptionId;
	}
	public void setInt_OptionId(Integer int_OptionId) {
		this.int_OptionId = int_OptionId;
	}
public Integer getSubcriptID() {
		return subcriptID;
	}
	public void setSubcriptID(Integer subcriptID) {
		this.subcriptID = subcriptID;
	}
public Integer getInt_ServiceId() {
		return int_ServiceId;
	}
	public void setInt_ServiceId(Integer int_ServiceId) {
		this.int_ServiceId = int_ServiceId;
	}
@Column(name="str_ServiceName")
public String getStr_ServiceName() {
	return str_ServiceName;
}
private String str_ServiceName;

public static long getSerialversionuid() {
	return serialVersionUID;
}
public void setStr_ServiceName( String str_ServiceName) {
	this.str_ServiceName =str_ServiceName;
	
}





}
	
		
	


	