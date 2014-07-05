package com.appowner.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appowner.model.Contact;
import com.appowner.model.cls_Contact;
import com.appowner.service.cls_ContactService;
@ManagedBean
@SessionScoped
public class cls_ContactUpdateBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{cls_ContactService}")
	private cls_ContactService contactService;
	public cls_ContactService getContactService() {
		
		return contactService;
	}
	public void setContactService(cls_ContactService contactService) {
		this.contactService = contactService;
	}
	private cls_Contact contact;
	public cls_Contact getcontact() {
		return contact;
	}
	public void setcontact(cls_Contact contact) {
		this.contact = contact;
	}
	 
private int contactId;
	
	public int getContactId() {
	return contactId;
}
public void setContactId(int contactId) {
	this.contactId = contactId;
}
	public void getContact()
	{ contact=new cls_Contact();
	System.out.println(contactId);
		contact=getContactService().getContact(contactId);
		}
	public String saveContact( ) {
		 
	
		if(contact.getContactId()!=null)
	
			getContactService().update(contact);
		else		
			getContactService().addContact(contact);
		
		
		
		return "ViewContact.xhtml?faces-redirect=true";
	}

}