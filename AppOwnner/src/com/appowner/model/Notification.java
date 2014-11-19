package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notification")
public class Notification implements Serializable {

	/**
	 * priya
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer Int_NotificationId;
	
	public Integer getInt_NotificationId() {
		return Int_NotificationId;
	}
	public void setInt_NotificationId(Integer int_NotificationId) {
		Int_NotificationId = int_NotificationId;
	}
	public boolean isVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	
	
	public String getSmsemail_notification() {
		return smsemail_notification;
	}
	public void setSmsemail_notification(String smsemail_notification) {
		this.smsemail_notification = smsemail_notification;
	}
	public String getInvoice_generate() {
		return invoice_generate;
	}
	public void setInvoice_generate(String invoice_generate) {
		this.invoice_generate = invoice_generate;
	}
	public String getBefore_due_date() {
		return before_due_date;
	}
	public void setBefore_due_date(String before_due_date) {
		this.before_due_date = before_due_date;
	}
	public String getDefaulter() {
		return defaulter;
	}
	public void setDefaulter(String defaulter) {
		this.defaulter = defaulter;
	}
	public String getCc_email() {
		return cc_email;
	}
	public void setCc_email(String cc_email) {
		this.cc_email = cc_email;
	}


	private boolean visibility;
	
	private String  smsemail_notification;
	
	private String invoice_generate; 
	private String before_due_date;
	private String defaulter;
	private String cc_email;
	private boolean sms;
	public boolean isSms() {
		return sms;
	}
	public void setSms(boolean sms) {
		this.sms = sms;
	}
	public boolean isSms1() {
		return sms1;
	}
	public void setSms1(boolean sms1) {
		this.sms1 = sms1;
	}
	public boolean isEmail() {
		return email;
	}
	public void setEmail(boolean email) {
		this.email = email;
	}
	public boolean isEmail1() {
		return email1;
	}
	public void setEmail1(boolean email1) {
		this.email1 = email1;
	}
	public boolean isGrace_period() {
		return grace_period;
	}
	public void setGrace_period(boolean grace_period) {
		this.grace_period = grace_period;
	}
	public Integer getDue_days() {
		return due_days;
	}
	public void setDue_days(Integer due_days) {
		this.due_days = due_days;
	}


	private boolean sms1;
	private boolean email;
	private boolean email1;
	private boolean grace_period;
	private Integer due_days;
}