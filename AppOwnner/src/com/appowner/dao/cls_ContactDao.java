package com.appowner.dao;

import java.util.List;

import com.appowner.model.*;

public interface cls_ContactDao {
		
		public void addContact(cls_Contact contact);

		public List<cls_Contact> listContacts();
		
		public cls_Contact getContact(int contactid);
		
		public void deleteContact(cls_Contact contact);

		 

		public void update(cls_Contact contact);

	//	public int getInt_UserId(String con1);

		

	
		
	}