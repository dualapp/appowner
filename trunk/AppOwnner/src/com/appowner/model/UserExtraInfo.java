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
@Table(name="tb_userextrainfo")
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
	private String bool_gender;
	 
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
	
	public Integer getInt_UserID() {
		return int_UserID;
	}
	public void setInt_UserID(Integer int_UserID) {
		this.int_UserID = int_UserID;
	}
	public Integer getInt_UserExtraID() {
		return int_UserExtraID;
	}
	public void setInt_UserExtraID(Integer int_UserExtraID) {
		this.int_UserExtraID = int_UserExtraID;
	}
	
	public Date getDate_DateOfBirth() {
		return date_DateOfBirth;
	}
	public void setDate_DateOfBirth(Date date_DateOfBirth) {
		this.date_DateOfBirth = date_DateOfBirth;
	}
	
	 
	public String getBool_gender() {
		return bool_gender;
	}
	public void setBool_gender(String bool_gender) {
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
	
	private int int_UserRole;
	public int getInt_UserRole() {
		return int_UserRole;
	}
	public void setInt_UserRole(int int_UserRole) {
		this.int_UserRole = int_UserRole;
	}

	private String str_Block;
	private String str_Username;
	private String residence;
	private String Var_ImageName1;
	public String getStr_Block() {
		return str_Block;
	}
	public String getStr_Username() {
		return str_Username;
	}
	public String getResidence() {
		return residence;
	}
	
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public void setStr_Username(String str_Username) {
		this.str_Username = str_Username;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getVar_ImageName1() {
		return Var_ImageName1;
	}
	public void setVar_ImageName1(String var_ImageName1) {
		Var_ImageName1 = var_ImageName1;
	}
	private String str_Flat;
	public String getStr_Flat() {
		return str_Flat;
	}
	public void setStr_Flat(String str_Flat) {
		this.str_Flat = str_Flat;
	}
	private String str_PhoneNo;
	public String getStr_PhoneNo() {
		return str_PhoneNo;
	}
	public void setStr_PhoneNo(String str_PhoneNo) {
		this.str_PhoneNo = str_PhoneNo;
	}
	
	private String str_Email;
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	
}
