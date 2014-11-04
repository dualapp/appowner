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

@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="tb_messagetempmaster")
public class MessageTemplateMaster  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Integer int_MessageTempId;
	@Column(name="var_MessageTempType")
	private String str_MessageTempType;
	
	public Integer getInt_MessageTempId() {
		return int_MessageTempId;
	}
	public void setInt_MessageTempId(Integer int_MessageTempId) {
		this.int_MessageTempId = int_MessageTempId;
	}
	 
	public String getStr_MessageTempType() {
		return str_MessageTempType;
	}
	public void setStr_MessageTempType(String str_MessageTempType) {
		this.str_MessageTempType = str_MessageTempType;
	}
	 

}
