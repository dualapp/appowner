package com.appowner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_country")
public class UserCountry {
	@Id
	@Column(name="int_CountryId")
	private Integer int_CountryId;
	
	@Column(name="var_CountryName")
	private String str_CountryName;

	public Integer getInt_CountryId() {
		return int_CountryId;
	}

	public void setInt_CountryId(Integer int_CountryId) {
		this.int_CountryId = int_CountryId;
	}

	public String getStr_CountryName() {
		return str_CountryName;
	}

	public void setStr_CountryName(String str_CountryName) {
		this.str_CountryName = str_CountryName;
	}

}
