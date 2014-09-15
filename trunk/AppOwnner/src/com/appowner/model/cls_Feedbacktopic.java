package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_feedbacktopic")
public class cls_Feedbacktopic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="int_feedbacktopicid")
	private Integer int_feedbacktopicid;
	
	@Column(name="var_feedbacktopicname")
	private String var_feedbacktopicname;
	

	@Column(name="int_appertmentid")
	private Integer int_appartmentid;


	public Integer getInt_feedbacktopicid() {
		return int_feedbacktopicid;
	}


	public void setInt_feedbacktopicid(Integer int_feedbacktopicid) {
		this.int_feedbacktopicid = int_feedbacktopicid;
	}


	public String getVar_feedbacktopicname() {
		return var_feedbacktopicname;
	}


	public void setVar_feedbacktopicname(String var_feedbacktopicname) {
		this.var_feedbacktopicname = var_feedbacktopicname;
	}


	public Integer getInt_appartmentid() {
		return int_appartmentid;
	}


	public void setInt_appartmentid(Integer int_appartmentid) {
		this.int_appartmentid = int_appartmentid;
	}
	
	

}
