package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Complain;
import com.appowner.model.Contact;
import com.appowner.model.User;
import com.appowner.model.Vendor;

@Repository
public class ComplainDaoImpl implements ComplainDao {
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addComplain(Complain complain)
	{
		getSessionFactory().getCurrentSession().save(complain);
	}
	public void addContact(Contact contact)
	{
		getSessionFactory().getCurrentSession().save(contact);
	}

	
	
	
	 @SuppressWarnings("unchecked")
	public List<Complain> listComplain()
	 {
		 return (List<Complain>) getSessionFactory().getCurrentSession().createCriteria(Complain.class).list();
	 }
	 @SuppressWarnings("unchecked")
	public List<Contact> listContact()
	 {
		 return (List<Contact>) getSessionFactory().getCurrentSession().createCriteria(Contact.class).list();
	 }
	
	
	 @SuppressWarnings("unchecked")
	public List<String> vendorList()
	{
		List<String> vendorList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(Vendor.class).setProjection(Projections.property("str_VendorType")).list();
		  System.out.println( (vendorList).listIterator().hasNext());
		  System.out.println(vendorList);
		  return  vendorList;
	 }
	 @SuppressWarnings("unchecked")
	public List<String> vendorListName(String str_VendorType)
	 {
		 System.out.println(str_VendorType);
			String hql=" select str_VendorName from Vendor  where str_VendorType=?";
			List<String> nameList=(List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_VendorType).list();
			 
			
			return nameList; 
	 }
	  @SuppressWarnings("unchecked")
	public List<String> blockList()
	  {
		  List<String> blockList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(User.class).setProjection(Projections.property("str_Block")).list();
		  System.out.println( (blockList).listIterator().hasNext());
		  System.out.println(blockList);
		  return  blockList;
	  }
	  @SuppressWarnings("unchecked")
	public List<String> flatListBlock(String Block)
	  {
		  System.out.println(Block);
			String hql=" select str_Flat from User  where str_Block=?";
			List<String> flatList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Block).list();
			 
		
			System.out.println(flatList);
			return flatList;  
	  }
	  @SuppressWarnings("unchecked")
	public List<String> renterListFlat(String Flat) {
		  System.out.println(Flat);
			String hql=" select str_Username from User  where str_Flat=?";
			List<String> renterList= (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Flat).list();
			 
			System.out.println(renterList);
			return renterList;    
	  }
	   
	 public Complain getComplain(int int_ComplainID)
	 { 
		 return (Complain)getSessionFactory().getCurrentSession().get(Complain.class,int_ComplainID);
	 }
	 
	 
	
	 
	 public void update(Complain cmp)
	 {
			sessionFactory.getCurrentSession().update(cmp);
	 }
	
	 public void deleteComplain(Complain complain)
	 {//System.out.println("int_ComplainID");
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM Complain WHERE int_ComplainID = "+complain.getInt_ComplainID()).executeUpdate();
	 }
	

	
	

}