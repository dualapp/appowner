package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="tb_maintainance_staff")
public class MaintainanceStaff  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="int_Maintainance_StaffID")
private Integer int_MaintainanceStaffID;
	@Column(name="int_VendorId")
	private Integer int_VendorId;
public Integer getInt_VendorId() {
		return int_VendorId;
	}
	public void setInt_VendorId(Integer int_VendorId) {
		this.int_VendorId = int_VendorId;
	}
@Column(name="var_UserName")
private String str_UserName;
@Column(name="var_Email")
private String str_Email;
@Column(name="var_Mobile")
private String str_Mobile;
@Column(name="int_Role_ID")
private Integer int_RoleId;
@Column(name="char_User_Type")
private Character char_User_Type;
@Column(name="int_UserId")
private Integer int_UserId;
public Integer getInt_UserId() {
	return int_UserId;
}
public void setInt_UserId(Integer int_UserId) {
	this.int_UserId = int_UserId;
}
public Character getChar_User_Type() {
	return char_User_Type;
}
public void setChar_User_Type(Character char_User_Type) {
	this.char_User_Type = char_User_Type;
}
public Integer getInt_RoleId() {
	return int_RoleId;
}
public void setInt_RoleId(Integer int_RoleId) {
	this.int_RoleId = int_RoleId;
}
@Column(name="var_RoleName")
private String str_RoleName;
 
public Integer getInt_MaintainanceStaffID() {
	return int_MaintainanceStaffID;
}
public void setInt_MaintainanceStaffID(Integer int_MaintainanceStaffID) {
	this.int_MaintainanceStaffID = int_MaintainanceStaffID;
}
public String getStr_UserName() {
	return str_UserName;
}
public void setStr_UserName(String str_UserName) {
	this.str_UserName = str_UserName;
}
public String getStr_Email() {
	return str_Email;
}
public void setStr_Email(String str_Email) {
	this.str_Email = str_Email;
}
public String getStr_Mobile() {
	return str_Mobile;
}
public void setStr_Mobile(String str_Mobile) {
	this.str_Mobile = str_Mobile;
}
public String getStr_RoleName() {
	return str_RoleName;
}
public void setStr_RoleName(String str_RoleName) {
	this.str_RoleName = str_RoleName;
}


	
	

}
