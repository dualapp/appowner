package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Notice")
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="int_NoticeID")
	private Integer int_NoticeID;
	
	public Integer getInt_NoticeID() {
		return int_NoticeID;
	}
	public void setInt_NoticeID(Integer int_NoticeID) {
		this.int_NoticeID = int_NoticeID;
	}
	public String getStr_Subject() {
		return str_Subject;
	}
	public void setStr_Subject(String str_Subject) {
		this.str_Subject = str_Subject;
	}
	
	public Boolean getBool_Flash() {
		return bool_Flash;
	}
	public void setBool_Flash(Boolean bool_Flash) {
		this.bool_Flash = bool_Flash;
	}
	
	public Integer getInt_ExpireDay() {
		return int_ExpireDay;
	}
	public void setInt_ExpireDay(Integer int_ExpireDay) {
		this.int_ExpireDay = int_ExpireDay;
	}
	
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	public Boolean getBool_SpecialNotice() {
		return bool_SpecialNotice;
	}
	public void setBool_SpecialNotice(Boolean bool_SpecialNotice) {
		this.bool_SpecialNotice = bool_SpecialNotice;
	}
	public Boolean getBool_Staff() {
		return bool_Staff;
	}
	public void setBool_Staff(Boolean bool_Staff) {
		this.bool_Staff = bool_Staff;
	}
	public String getStr_Visible() {
		return str_Visible;
	}
	public void setStr_Visible(String str_Visible) {
		this.str_Visible = str_Visible;
	}

	@Column(name="var_Subject")
	private String str_Subject;
	@Column(name="bool_Flash")
	private Boolean bool_Flash;
	@Column(name="int_ExpireDay")
	private Integer int_ExpireDay;
	@Column(name="var_Document")
	private String  str_Document;
	public void setStr_Document(String str_Document) {
		this.str_Document = str_Document;
	}
	

	@Column(name="var_Description")
	private String str_Description;
	@Column(name="bool_SpecialNotice")
	private Boolean bool_SpecialNotice;
	@Column(name="bool_Staff")
	private Boolean bool_Staff;
	@Column(name="var_Visible")
	private String str_Visible;
	@Column(name="dat_EntryDate")
	private Date dat_EntryDate;

	public Date getDat_EntryDate() {
		return dat_EntryDate;
	}
	public void setDat_EntryDate(Date dat_EntryDate) {
		this.dat_EntryDate = dat_EntryDate;
	}
	private Date dat_ExpireOn;

	public Date getDat_ExpireOn() {
		return dat_ExpireOn;
	}
	public void setDat_ExpireOn(Date dat_ExpireOn) {
		this.dat_ExpireOn = dat_ExpireOn;
	}
	
}
