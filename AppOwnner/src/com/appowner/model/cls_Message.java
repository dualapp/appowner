package com.appowner.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_messageform")
public class cls_Message implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	 

	 

	@Id
	@Column(name = "messageid")
	private String messageId;
	@Column
	private String str_Email;
	private String var_MessageDetails;
	private String MessageMode;
	private String MessageCategory;
	private String var_MessageSubject;
	
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getVar_MessageDetails() {
		return var_MessageDetails;
	}
	public void setVar_MessageDetails(String var_MessageDetails) {
		this.var_MessageDetails = var_MessageDetails;
	}
	public String getMessageMode() {
		return MessageMode;
	}
	public void setMessageMode(String messageMode) {
		MessageMode = messageMode;
	}
	public String getMessageCategory() {
		return MessageCategory;
	}
	public void setMessageCategory(String messageCategory) {
		MessageCategory = messageCategory;
	}
	public String getVar_MessageSubject() {
		return var_MessageSubject;
	}
	public void setVar_MessageSubject(String var_MessageSubject) {
		this.var_MessageSubject = var_MessageSubject;
	}
	
 
	}
