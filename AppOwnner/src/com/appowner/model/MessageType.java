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
@Table(name="tb_messagetype")
public class MessageType  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Integer int_MessageTypeId;
	@Column(name="var_MessageType")
	private String str_MessageType;
	public Integer getInt_MessageTypeId() {
		return int_MessageTypeId;
	}
	public void setInt_MessageTypeId(Integer int_MessageTypeId) {
		this.int_MessageTypeId = int_MessageTypeId;
	}
	public String getStr_MessageType() {
		return str_MessageType;
	}
	public void setStr_MessageType(String str_MessageType) {
		this.str_MessageType = str_MessageType;
	}
	 
	

}
