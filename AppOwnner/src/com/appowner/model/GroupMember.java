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
@Table(name="tb_Groupmember")
public class GroupMember implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_GroupmemberId;
	
	@Column
	private Integer int_GroupId;
	
	@Column
	 private Date DT_Date;
	private String int_UserId;
	
	

	public String getInt_UserId() {
		return int_UserId;
	}

	public void setInt_UserId(String int_UserId) {
		this.int_UserId = int_UserId;
	}

	public Integer getInt_GroupmemberId() {
		return int_GroupmemberId;
	}

	public Integer getInt_GroupId() {
		return int_GroupId;
	}

	
	public void setInt_GroupmemberId(Integer int_GroupmemberId) {
		this.int_GroupmemberId = int_GroupmemberId;
	}

	public void setInt_GroupId(Integer int_GroupId) {
		this.int_GroupId = int_GroupId;
	}

	public Date getDT_Date() {
		return DT_Date;
	}

	public void setDT_Date(Date dT_Date) {
		DT_Date = dT_Date;
	}

	
	
	
	
}
	