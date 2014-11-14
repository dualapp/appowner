
package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "tb_blockDetails")
public class UserBlocks implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="int_BlockId")
	private Integer int_BlockId;
	@Column(name="int_ApartmentId")
	private Integer int_ApartmentId;
	@JoinColumn(name = "int_ApartmentId", insertable = false, updatable=false)
	//private UserCity userCity;
	@Column(name="var_BlockName")
	private String str_BlockName;
	@Column 
	private Integer int_SetupId;
	@Column 
	private Integer int_NoOfHouses;
	
	public Integer getInt_BlockId() {
		return int_BlockId;
	}
	public void setInt_BlockId(Integer int_BlockId) {
		this.int_BlockId = int_BlockId;
	}
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	public String getStr_BlockName() {
		return str_BlockName;
	}
	public void setStr_BlockName(String str_BlockName) {
		this.str_BlockName = str_BlockName;
	}
	
}
