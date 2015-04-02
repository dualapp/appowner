package com.appowner.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.bean.LoginBean;
import com.appowner.model.Complain;
import com.appowner.model.Contact;
import com.appowner.model.User;
import com.appowner.model.Vendor;
import com.appowner.util.Util;

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
	 {  System.out.println(LoginBean.isAdmin()+"dkjdjkfekjfe");
		 if(LoginBean.isAdmin())
	   {
		 return (List<Complain>) getSessionFactory().getCurrentSession().createQuery("from Complain where int_ApartmentId=?").setParameter(0,Util.getAppartmentId()).setCacheable(true).list();
	   }
	 else
		 return (List<Complain>) getSessionFactory().getCurrentSession().createQuery("from Complain where int_ApartmentId=? and Flat=? and block=?").setParameter(0,Util.getAppartmentId()).setParameter(1,Util.getStr_Flat()).setParameter(2,Util.getBlock()).setCacheable(true).list();
	 }
	 @SuppressWarnings("unchecked")
	public List<Complain> adminlistComplain()
	 {
		 return (List<Complain>) getSessionFactory().getCurrentSession().createQuery("from Complain where int_ApartmentId=?").setParameter(0,Util.getAppartmentId()).setCacheable(true).list(); 
	 }
	 @SuppressWarnings("unchecked")
	public List<Contact> listContact()
	 {
		 return (List<Contact>) getSessionFactory().getCurrentSession().createCriteria(Contact.class).setCacheable(true).list();
	 }
	
	
	 @SuppressWarnings("unchecked")
	public List<String> vendorList()
	{
		List<String> vendorList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(Vendor.class).setCacheable(true).setProjection(Projections.property("str_VendorType")).list();
		  System.out.println( (vendorList).listIterator().hasNext());
		  System.out.println(vendorList);
		  return  vendorList;
	 }
	 @SuppressWarnings("unchecked")
	public List<String> vendorListName(String str_VendorType)
	 {
		 System.out.println(str_VendorType);
			String hql=" select str_VendorName from Vendor  where str_VendorType=?";
			List<String> nameList=(List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,str_VendorType).list();
			 
			
			return nameList; 
	 }
	  @SuppressWarnings("unchecked")
	public List<String> blockList()
	  {
		  String hql="select str_BlockName from UserBlocks where int_ApartmentId=?";
			return (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Util.getAppartmentId()).list();
	  }
	  @SuppressWarnings("unchecked")
	public List<String> flatListBlock(String Block)
	  {
		  String hql="select int_BlockId from UserBlocks where str_BlockName=? and int_ApartmentId=?";
			List<Integer> list=(List<Integer>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, Block).setParameter(1,Util.getAppartmentId()).list();
			ListIterator itr=list.listIterator();
			List<String> str2=new ArrayList<String>();
			while(itr.hasNext())
			{
				Integer id=(Integer) itr.next();
				System.out.println(id+"gfgfkgfkj");
				str2=(List<String>) getSessionFactory().getCurrentSession().createQuery("select str_HouseNo from HouseDetails where int_ApartmentId=? and int_BlockId=?").setParameter(0,Util.getAppartmentId()).setParameter(1,id).list();
				
			}
		System.out.println(str2+"fdjdff");
			return str2;
	  }
	  @SuppressWarnings("unchecked")
	public List<String> renterListFlat(String Flat) {
		  System.out.println(Flat);
			String hql=" select str_Username from User  where str_Flat=?";
			List<String> renterList= (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,Flat).list();
			 
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
	 public void updateAdminReason(Integer iD, String str_Description)
	 {
		 String str="update Complain set status=1,adminReason=? where int_ComplainID=?";
		 sessionFactory.getCurrentSession().createQuery(str).setParameter(0,str_Description).setParameter(1, iD).executeUpdate();
	 }
	

	
	

}