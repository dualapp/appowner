package com.appowner.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "tb_state")

public class VendorState implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="int_StateId")
	private Integer int_stateId;
	@Column(name="var_StateName")
	private String str_StateName;
	@Column(name="int_CountryId")
	private Integer int_CountryId;
	//one to many relation
	@OneToMany(targetEntity = VendorCity.class, cascade = { CascadeType.ALL })
	private List<String> cites;
	public List<String> getCites() {
		return cites;
	}
	public void setCites(List<String> cites) {
		this.cites = cites;
	}
	public Integer getInt_CountryId() {
		return int_CountryId;
	}
	public void setInt_CountryId(Integer int_CountryId) {
		this.int_CountryId = int_CountryId;
	}
	
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
