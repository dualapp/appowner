package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author pankaj
 *
 */
@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="tb_User")
public class User implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "int_UserId")
	private Integer int_UserId;
	@Column
	private String str_Country;
	@Column
	private String str_State;
	@Column
	private String str_City;
	@Column
	private String str_Apartment;
	@Column
	private String str_FirstName;
	@Column
	private String str_LastName;
	@Column
	private String str_Email;
	
	@Column
	private String str_Password;
	
	@Column
	private Integer int_UserRole;
	@Column
	private String str_Flat;
	@Column
	private String str_Block;
	@Column
	private String str_Username;
	@Column 
	private String str_UserRoleName;
	@Column
	private String str_PhoneNo;
	@Column
	private String Var_FileName1;
	@Column
	private String Var_ImageName1;
	@Column
	private String str_activationkey;
	@Column Integer int_activationbit;
	@Column 
	private Integer int_ApartmentId;
	//@JoinColumn(name = "int_ApartmentId", insertable = false, updatable=false)
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)  
	 private UserExtraInfo userExtraInfo;  
	public UserExtraInfo getUserExtraInfo() {
		return userExtraInfo;
	}
	public void setUserExtraInfo(UserExtraInfo userExtraInfo) {
		this.userExtraInfo = userExtraInfo;
	}
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	public String getStr_Country() {
		return str_Country;
	}
	public void setStr_Country(String str_Country) {
		this.str_Country = str_Country;
	}
	public String getStr_State() {
		return str_State;
	}
	public void setStr_State(String str_State) {
		this.str_State = str_State;
	}
	public String getStr_City() {
		return str_City;
	}
	public void setStr_City(String str_City) {
		this.str_City = str_City;
	}
	public String getStr_Apartment() {
		return str_Apartment;
	}
	public void setStr_Apartment(String str_Apartment) {
		this.str_Apartment = str_Apartment;
	}
	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}
	public String getStr_FirstName() {
		return str_FirstName;
	}
	public void setStr_FirstName(String str_FirstName) {
		this.str_FirstName = str_FirstName;
	}
	public String getStr_LastName() {
		return str_LastName;
	}
	public void setStr_LastName(String str_LastName) {
		this.str_LastName = str_LastName;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	
	public String getStr_Password() {
		return str_Password;
	}
	public void setStr_Password(String str_Password) {
		this.str_Password = str_Password;
	}
	
	public Integer getInt_UserRole() {
		return int_UserRole;
	}
	public void setInt_UserRole(Integer int_UserRole) {
		this.int_UserRole = int_UserRole;
	}
	public String getStr_Flat() {
		return str_Flat;
	}
	public void setStr_Flat(String str_Flat) {
		this.str_Flat = str_Flat;
	}
	public String getStr_Block() {
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public String getStr_PhoneNo() {
		return str_PhoneNo;
	}
	public void setStr_PhoneNo(String str_PhoneNo) {
		this.str_PhoneNo = str_PhoneNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStr_Username() {
		return str_Username;
	}
	public void setStr_Username(String str_Username) {
		this.str_Username = str_Username;
	}
	public String getStr_UserRoleName() {
		return str_UserRoleName;
	}
	public void setStr_UserRoleName(String str_UserRoleName) {
		this.str_UserRoleName = str_UserRoleName;
	}
	public String getStr_activationkey() {
		return str_activationkey;
	}
	public void setStr_activationkey(String str_activationkey) {
		this.str_activationkey = str_activationkey;
	}
	public Integer getInt_activationbit() {
		return int_activationbit;
	}
	public void setInt_activationbit(Integer int_activationbit) {
		this.int_activationbit = int_activationbit;
	}
	public String getVar_FileName1() {
		return Var_FileName1;
	}
	public void setVar_FileName1(String var_FileName1) {
		Var_FileName1 = var_FileName1;
	}
	public String getVar_ImageName1() {
		return Var_ImageName1;
	}
	public void setVar_ImageName1(String var_ImageName1) {
		Var_ImageName1 = var_ImageName1;
	}
	@Column(name="SqareFeet")
	private double sqft;
	public double getSqft() {
		return sqft;
	}
	public void setSqft(double sqft) {
		this.sqft = sqft;
	}
	
	
}
