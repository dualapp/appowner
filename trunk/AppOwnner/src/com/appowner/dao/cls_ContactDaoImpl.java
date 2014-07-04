package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.*;

@Repository
public class cls_ContactDaoImpl implements cls_ContactDao {
@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addContact(cls_Contact contact) {
		//System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(contact);
	}

	@SuppressWarnings("unchecked")
	public List<cls_Contact> listContacts() {
		String query="{call contact()}";
		List<cls_Contact> conn=sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(cls_Contact.class)).list();
		return conn;
		//return (List<cls_Contact>) getSessionFactory().getCurrentSession().createCriteria(cls_Contact.class).list();
	}
	
	public cls_Contact getContact(int contactid) {
		return (cls_Contact) getSessionFactory().getCurrentSession().get(cls_Contact.class, contactid);
	}

	public void deleteContact(cls_Contact contact) {
		System.out.println(contact.getContactId());
		sessionFactory.getCurrentSession().createQuery("DELETE FROM cls_Contact WHERE contactid = "+contact.getContactId()).executeUpdate();
	}


	public void update(cls_Contact contact) {
		System.out.println(contact.getContactId());
		sessionFactory.getCurrentSession().update(contact);
	}

	/*@Override
	public int getInt_UserId(String con1) {
	System.out.println(con1);
		String	hql1="select int_UserId from cls_Contact where str_Username=?";
		int int_UserId=(Integer)getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, con1).uniqueResult();
		 return int_UserId;
	}*/


}
