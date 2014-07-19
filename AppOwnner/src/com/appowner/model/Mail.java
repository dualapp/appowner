package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Mail")
public class Mail implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
private Integer mailID;
public Integer getMailID() {
	return mailID;
}
public void setMailID(Integer mailID) {
	this.mailID = mailID;
}
@Column(name="mail")
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
private String mail;
}
