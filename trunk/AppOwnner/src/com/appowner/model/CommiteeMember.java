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
@Table(name = "tb_Commiteemember")
public class CommiteeMember implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="int_MemberId")
	private Integer int_MemberId;
	@Column(name="int_UserId")
	private Integer int_UserId;
	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}
	@Column(name="var_UserName")
	private String str_UserName;
	@Column(name="var_committeeRole")
	private String str_CommitteeRole;
	@Column(name="var_ResponsibleFor")
private String str_ResponsibleFor;
	@Column(name="date_Electiondate")
	private Date date_Electiondate;
	@Column(name="char_User_Type")
	private Character char_User_Type;
	public Character getChar_User_Type() {
		return char_User_Type;
	}
	public void setChar_User_Type(Character char_User_Type) {
		this.char_User_Type = char_User_Type;
	}
	public Integer getInt_MemberId() {
		return int_MemberId;
	}
	public void setInt_MemberId(Integer int_MemberId) {
		this.int_MemberId = int_MemberId;
	}
	public String getStr_UserName() {
		return str_UserName;
	}
	public void setStr_UserName(String str_UserName) {
		this.str_UserName = str_UserName;
	}
	public String getStr_CommitteeRole() {
		return str_CommitteeRole;
	}
	public void setStr_CommitteeRole(String str_CommitteeRole) {
		this.str_CommitteeRole = str_CommitteeRole;
	}
	public String getStr_ResponsibleFor() {
		return str_ResponsibleFor;
	}
	public void setStr_ResponsibleFor(String str_ResponsibleFor) {
		this.str_ResponsibleFor = str_ResponsibleFor;
	}
	public Date getDate_Electiondate() {
		return date_Electiondate;
	}
	public void setDate_Electiondate(Date date_Electiondate) {
		this.date_Electiondate = date_Electiondate;
	}
	
	
	
}
