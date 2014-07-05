package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





//import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.dao.DataAccessException;

import com.appowner.model.cls_Contact;
import com.appowner.service.cls_ContactService;
@ManagedBean
@SessionScoped

public class cls_ContactBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "ViewContact";
	private static final String ERROR   = "error";
	private String contactName;
	private String contactPhone;
	private String contactService1;
//	private String str_Username;
	public String getContactService1() {
		return contactService1;
	}
	public void setContactService1(String contactService1) {
		this.contactService1 = contactService1;
	}
	
	//private Date date_Date;
	private String str_PhoneNo;
	private String str_Email;
	//private Integer int_UserId;
	private String additionalInfo;
	private int contactId;
	private List<cls_Contact> contactList;
	
/*	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}*/
	public List<cls_Contact> getContactList() {
		contactList= new ArrayList<cls_Contact>();
			contactList.addAll(getContactService().listContacts());
		//	int_UserId=getContactService().getInt_UserId(str_Email);
			//System.out.println(int_UserId); 
			//contactList.add(int_UserId);
			return contactList;
	}
	public void setContactList(List<cls_Contact> contactlist) {
		contactList = contactlist;
	}
	

	/*public String getStr_Username() {
		return str_Username;
	}
	public void setStr_Username(String str_Username) {
		this.str_Username = str_Username;
	}*/
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@ManagedProperty(value="#{cls_ContactService}")
	private cls_ContactService contactService;
	
	
	public cls_ContactService getContactService() {
		return contactService;
	}
	public void setContactService(cls_ContactService contactService) {
		this.contactService = contactService;
	}
	
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
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
		this.additionalInfo = additionalInfo;
	}
	 
	
	
	public int con;
	public String con1;
	public String addContact()
	{  
		try{
			System.out.println("Hi");
			cls_Contact contact=new cls_Contact();
			//contact.setDate_Date(getDate_Date());
			contact.setContactId(getContactId());
		    contact.setContactName(getContactName());
		    contact.setContactService1(getContactService1());
		    contact.setContactPhone(getContactPhone());
		  //  contact.setStr_Username(getStr_Username());
		    contact.setStr_PhoneNo(getStr_PhoneNo());
		    contact.setStr_Email(getStr_Email());		    
		    System.out.println(con);
		    contact.setAdditionalInfo(getAdditionalInfo());
		    getContactService().addContact(contact);
	
		 return SUCCESS;
	}
	catch(DataAccessException e)
	{e.printStackTrace();
		
	}
	return ERROR;
		
	}
	
	
	public String deleteContact(int ContactId)
	 {
		 cls_Contact contact=new cls_Contact();
		 
		 contact.setContactId(ContactId);
		
		 getContactService().deleteContact(contact);
		 return SUCCESS;
	 }
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	
	public void reset() {
        this.setContactId(0);
        this.setContactName("");
        
    }
	
	
}