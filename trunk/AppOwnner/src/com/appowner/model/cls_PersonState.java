package com.appowner.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_State")

public class cls_PersonState implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="var_StateName")
	private String str_StateName;
	@Column(name="int_CountryID")
	private Integer int_CountryId;
	 
	public Integer getInt_CountryId() {
		return int_CountryId;
	}
	public void setInt_CountryId(Integer int_CountryId) {
		this.int_CountryId = int_CountryId;
	}
	@Column(name="int_StateID")
	private Integer int_stateId;
	public String getStr_StateName() {
		return str_StateName;
	}
	public void setStr_StateName(String str_StateName) {
		this.str_StateName = str_StateName;
	}
	public Integer getInt_stateId() {
		return int_stateId;
	}
	public void setInt_stateId(Integer int_stateId) {
		this.int_stateId = int_stateId;
	}

}

