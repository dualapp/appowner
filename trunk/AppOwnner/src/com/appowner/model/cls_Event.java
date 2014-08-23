package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;

import java.util.Date;


@Entity
@Table(name="tb_eventform")
public class cls_Event implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "eventId")
	private Integer eventId;
	@Column(name = "var_EventTitle")
	private String str_EventTitle;
	@Column(name = "var_EventDescription")
	private String str_EventDescription;
	@Column(name = "var_EventVenue")
	private String str_EventVenue;
	@Column(name = "int_eventcatid")
	private Integer int_eventcatid;
	@Column(name = "var_eventcatname")
	private String str_eventcatname;
	@Column(name = "int_CreatedBy")
	private Integer int_UserId;
	@Column(name="dat_StartDate")
	private Date dat_StartDate;
	@Column(name = "dat_EndDate")
	private Date dat_EndDate;
	@Column
	private String str_Email;
	
	
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getStr_EventTitle() {
		return str_EventTitle;
	}
	public void setStr_EventTitle(String str_EventTitle) {
		this.str_EventTitle = str_EventTitle;
	}
	public String getStr_EventDescription() {
		return str_EventDescription;
	}
	public void setStr_EventDescription(String str_EventDescription) {
		this.str_EventDescription = str_EventDescription;
	}
	public String getStr_EventVenue() {
		return str_EventVenue;
	}
	public void setStr_EventVenue(String str_EventVenue) {
		this.str_EventVenue = str_EventVenue;
	}
	 
	public Integer getInt_eventcatid() {
		return int_eventcatid;
	}
	public void setInt_eventcatid(Integer int_eventcatid) {
		this.int_eventcatid = int_eventcatid;
	}
	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}
	public Date getDat_StartDate() {
		return dat_StartDate;
	}
	public void setDat_StartDate(Date dat_StartDate) {
		this.dat_StartDate = dat_StartDate;
	}
	public Date getDat_EndDate() {
		return dat_EndDate;
	}
	public void setDat_EndDate(Date dat_EndDate) {
		this.dat_EndDate = dat_EndDate;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getStr_eventcatname() {
		return str_eventcatname;
	}
	public void setStr_eventcatname(String str_eventcatname) {
		this.str_eventcatname = str_eventcatname;
	}
	
	
			
}
