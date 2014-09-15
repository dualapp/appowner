package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="tb_feedbackform")
public class cls_Feedback implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "feedbackid")
	private Integer feedbackId;
	@Column(name = "var_Email")
	private String str_Email;
	@Column(name = "var_feedbackName")
	private String feedbackName;
	@Column(name="var_satisfactionname")
	private String var_satisfactionname;
	@Column(name="var_feedbacktopicname")
	private String var_feedbacktopicname;
	@Column(name = "var_feedbackmsg")
	private String feedbackMsg;
	@Column
	private String date;
	 
	
	
	 
	 
	public String getVar_feedbacktopicname() {
		return var_feedbacktopicname;
	}
	public void setVar_feedbacktopicname(String var_feedbacktopicname) {
		this.var_feedbacktopicname = var_feedbacktopicname;
	}
	public String getVar_satisfactionname() {
		return var_satisfactionname;
	}
	public void setVar_satisfactionname(String var_satisfactionname) {
		this.var_satisfactionname = var_satisfactionname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getFeedbackName() {
		return feedbackName;
	}
	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}
	public String getFeedbackMsg() {
		return feedbackMsg;
	}
	public void setFeedbackMsg(String feedbackMsg) {
		this.feedbackMsg = feedbackMsg;
	}
	
 
}
