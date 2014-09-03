package com.appowner.service;


import java.util.List;

import com.appowner.model.cls_Contact;


public interface cls_ContactService {
	
	public void addContact(cls_Contact contact);

	public List<cls_Contact> listContacts();
	
	 
	
	public void deleteContact1(cls_Contact contact);

	public void update(cls_Contact contact);

	public cls_Contact getContact1(int contactId);

 

}
