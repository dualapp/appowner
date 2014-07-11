package com.appowner.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.cls_ContactDao;
import com.appowner.model.cls_Contact;


@Service("cls_ContactService")
@Transactional 
public class cls_ContactServiceImpl implements cls_ContactService {

	@Autowired
	private cls_ContactDao contactDao;
	
	 public cls_ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(cls_ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public void addContact(cls_Contact contact) {
		 System.out.println(contactDao);
		 
		 getContactDao().addContact(contact);
	}
	
	public List<cls_Contact> listContacts() {
		return getContactDao().listContacts();
	}

	public cls_Contact getContact(int contactId) {
		return contactDao.getContact(contactId);
	}
	
/*	public cls_Contact getDate(Date date) {
		return contactDao.getDate(date);
	}*/
	
	public void deleteContact1(cls_Contact contact) {
		getContactDao().deleteContact1(contact);
	}
 

	@Override
	public void update(cls_Contact contact) {
		getContactDao().update(contact);
		
	}

/*	@Override
	public int getInt_UserId(String con1) {
		
		return getContactDao().getInt_UserId(con1);
	}*/

	
	}
