package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="tb_assetcategory")
@Entity
public class AssetCategory  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_assetcat_id;
	@Column(name="var_assetcat_name")
	private String str_assetcat_name;
	public Integer getInt_assetcat_id() {
		return int_assetcat_id;
	}
	public void setInt_assetcat_id(Integer int_assetcat_id) {
		this.int_assetcat_id = int_assetcat_id;
	}
	public String getStr_assetcat_name() {
		return str_assetcat_name;
	}
	public void setStr_assetcat_name(String str_assetcat_name) {
		this.str_assetcat_name = str_assetcat_name;
	}

}
