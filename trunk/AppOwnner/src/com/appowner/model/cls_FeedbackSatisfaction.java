package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_feedbacksatisfaction")
public class cls_FeedbackSatisfaction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="int_satisficationid")
	private Integer int_satisficationid;
	
	@Column(name="var_satisfactionname")
	private String var_satisfactionname;
	

	@Column(name="int_appertmentid")
	private Integer int_appartmentid;


	public Integer getInt_satisficationid() {
		return int_satisficationid;
	}


	public void setInt_satisficationid(Integer int_satisficationid) {
		this.int_satisficationid = int_satisficationid;
	}


	public String getVar_satisfactionname() {
		return var_satisfactionname;
	}


	public void setVar_satisfactionname(String var_satisfactionname) {
		this.var_satisfactionname = var_satisfactionname;
	}


	public Integer getInt_appartmentid() {
		return int_appartmentid;
	}


	public void setInt_appartmentid(Integer int_appartmentid) {
		this.int_appartmentid = int_appartmentid;
	}
	
	

}
