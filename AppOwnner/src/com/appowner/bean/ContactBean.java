package com.appowner.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;

import com.appowner.model.Contact;
import com.appowner.service.ComplainService;
@ManagedBean
@RequestScoped
public class ContactBean {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static final String ERROR   = "error";
	@ManagedProperty(value = "#{ComplainService}")
	private ComplainService complainService;
	public ComplainService getComplainService() {
		return complainService;
	}
	public void setComplainService(ComplainService complainService) {
		this.complainService = complainService;
	}
private String str_ContactName;
 private Integer int_ContactID;  
	
    public Integer getInt_ContactID() {
		return int_ContactID;
	}
	public void setInt_ContactID(Integer int_ContactID) {
		this.int_ContactID = int_ContactID;
	}
	public String getStr_ContactName() {
		return str_ContactName;
	}
	public void setStr_ContactName(String str_ContactName) {
		this.str_ContactName = str_ContactName;
	}
	public String getStr_Query() {
		return str_Query;
	}
	public void setStr_Query(String str_Query) {
		this.str_Query = str_Query;
	}
	private String str_Query;
    
	
	private String str_MobileNo;
	public String getStr_MobileNo() {
		return str_MobileNo;
	}
	public void setStr_MobileNo(String str_MobileNo) {
		this.str_MobileNo = str_MobileNo;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	private String str_Email;
	 public String addContact()
		{  try{
			Contact contact=new Contact();
			 contact.setInt_ContactID(getInt_ContactID());
			 contact.setStr_ContactName(getStr_ContactName());
			 contact.setStr_Email(getStr_Email());
			 contact.setStr_MobileNo(getStr_MobileNo());
			 contact.setStr_Query(getStr_Query());
			 
			getComplainService().addContact(contact);
			
			return null;
		}
		catch(DataAccessException e)
		{e.printStackTrace();
			
		}
		return ERROR;
			
		}
	 private List<Contact> ListContact;
		public List<Contact> getListContact() {
			ListContact= new ArrayList<Contact>();
			ListContact.addAll(getComplainService().listContact());
			return ListContact;
		}
		public void setListContact(List<Contact> listContact) {
			ListContact = listContact;
		}
    
}




