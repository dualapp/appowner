package com.appowner.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="tb_UserExtraInfo")
public class UserExtraInfo  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_UserExtraID;
	@Column
	private Integer int_UserID;
	@Column
	private  Date date_DateOfBirth;
	@Column
	private Boolean bool_gender;
	 
	@Column(name="var_BloodGroup")
	private String str_BloodGroup;
	@Column(name="var_MaritalStatus")
	private String str_MaritalStatus;
	@Column(name="var_Hobbies")
	private String str_Hobbies;
	@Column(name="var_Profession")
	private String str_Profession;
	@Column(name="var_IntrestedIn")
	private String str_IntrestedIn;
	@Column(name="var_FaceBookId")
	private String str_FaceBookId;
	@Column(name="var_LinkedInId")
	private String str_LinkedInId;
	@Column(name="var_TwitterId")
	private String str_TwitterId;
	@Column(name="var_PersonalBlog")
	private String str_PersonalBlog;
	 @OneToOne  
	 @PrimaryKeyJoinColumn  
	 private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getInt_UserExtraID() {
		return int_UserExtraID;
	}
	public void setInt_UserExtraID(Integer int_UserExtraID) {
		this.int_UserExtraID = int_UserExtraID;
	}
	public Integer getInt_UserID() {
		return int_UserID;
	}
	public void setInt_UserID(Integer int_UserID) {
		this.int_UserID = int_UserID;
	}
	public Date getDate_DateOfBirth() {
		return date_DateOfBirth;
	}
	public void setDate_DateOfBirth(Date date_DateOfBirth) {
		this.date_DateOfBirth = date_DateOfBirth;
	}
	public Boolean getBool_gender() {
		return bool_gender;
	}
	public void setBool_gender(Boolean bool_gender) {
		this.bool_gender = bool_gender;
	}
	 
	public String getStr_BloodGroup() {
		return str_BloodGroup;
	}
	public void setStr_BloodGroup(String str_BloodGroup) {
		this.str_BloodGroup = str_BloodGroup;
	}
	public String getStr_MaritalStatus() {
		return str_MaritalStatus;
	}
	public void setStr_MaritalStatus(String str_MaritalStatus) {
		this.str_MaritalStatus = str_MaritalStatus;
	}
	public String getStr_Hobbies() {
		return str_Hobbies;
	}
	public void setStr_Hobbies(String str_Hobbies) {
		this.str_Hobbies = str_Hobbies;
	}
	public String getStr_Profession() {
		return str_Profession;
	}
	public void setStr_Profession(String str_Profession) {
		this.str_Profession = str_Profession;
	}
	public String getStr_IntrestedIn() {
		return str_IntrestedIn;
	}
	public void setStr_IntrestedIn(String str_IntrestedIn) {
		this.str_IntrestedIn = str_IntrestedIn;
	}
	public String getStr_FaceBookId() {
		return str_FaceBookId;
	}
	public void setStr_FaceBookId(String str_FaceBookId) {
		this.str_FaceBookId = str_FaceBookId;
	}
	public String getStr_LinkedInId() {
		return str_LinkedInId;
	}
	public void setStr_LinkedInId(String str_LinkedInId) {
		this.str_LinkedInId = str_LinkedInId;
	}
	public String getStr_TwitterId() {
		return str_TwitterId;
	}
	public void setStr_TwitterId(String str_TwitterId) {
		this.str_TwitterId = str_TwitterId;
	}
	public String getStr_PersonalBlog() {
		return str_PersonalBlog;
	}
	public void setStr_PersonalBlog(String str_PersonalBlog) {
		this.str_PersonalBlog = str_PersonalBlog;
	}
	
	
	
	

}
