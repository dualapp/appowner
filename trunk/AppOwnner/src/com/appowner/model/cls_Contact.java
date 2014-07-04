package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.util.Date;


@Entity
@Table(name="tb_contactform")
public class cls_Contact implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "contactid")
	private Integer contactId;
    private String str_Username;
	@Column
	private String str_Email;

	private Integer int_UserId;
	public Integer getInt_UserId() {
		return int_UserId;
	}

	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}


	private String additionalInfo;
	private String contactPhone;
	private String contactService1;
	private String str_PhoneNo;
	private Integer int_ApartmentId;
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	
/*	@Column(name="date_Date")
	private Date date_Date;
	*/
		
	

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactService1() {
		return contactService1;
	}

	public void setContactService1(String contactService1) {
		this.contactService1= contactService1;
	}
	
	public String getStr_PhoneNo() {
		return str_PhoneNo;
	}

	public void setStr_PhoneNo(String str_PhoneNo) {
		this.str_PhoneNo = str_PhoneNo;
	}

	 

	public String getAdditionalInfo() {
		return additionalInfo;
	}
	
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo=additionalInfo;
	}
	
	public String getStr_Email() {
		return str_Email;
	}

	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}

	 
	@Column(name="contactname")
	private String contactName;
	

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	
	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getStr_Username() {
		return str_Username;
	}

	public void setStr_Username(String str_Username) {
		this.str_Username = str_Username;
	}

	

	

/*	public Date getDate_Date() {
		return date_Date;
	}
	public void setDate_Date(Date date_Date) {
		this.date_Date = date_Date;
	}*/

	}

	
	
