package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_event_category")
public class cls_EventCategory implements Serializable

{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="int_eventcatid")
	private Integer int_eventcatid;
	
	@Column(name="var_eventcatname")
	private String str_eventcatname;
	

	@Column(name="int_appartment_id")
	private Integer int_appartment_id;


	public Integer getInt_eventcatid() {
		return int_eventcatid;
	}


	public void setInt_eventcatid(Integer int_eventcatid) {
		this.int_eventcatid = int_eventcatid;
	}


	public String getStr_eventcatname() {
		return str_eventcatname;
	}


	public void setStr_eventcatname(String str_eventcatname) {
		this.str_eventcatname = str_eventcatname;
	}


	public Integer getInt_appartment_id() {
		return int_appartment_id;
	}


	public void setInt_appartment_id(Integer int_appartment_id) {
		this.int_appartment_id = int_appartment_id;
	}




}
