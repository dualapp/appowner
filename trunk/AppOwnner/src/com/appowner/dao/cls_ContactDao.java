package com.appowner.dao;

import java.util.Date;
import java.util.List;

import com.appowner.model.*;

public interface cls_ContactDao {
		
		public void addContact(cls_Contact contact);

		public List<cls_Contact> listContacts();
		
		public cls_Contact getContact(int contactid);
		
		public void deleteContact1(cls_Contact contact);
		
		//public cls_Contact getDate(Date date);
		
		public void update(cls_Contact contact);

	//	public int getInt_UserId(String con1);

		

	
		
	}