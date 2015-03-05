package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ComplainDao;
import com.appowner.model.CommiteeRole;
import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.Complain;
import com.appowner.model.Contact;
import com.appowner.model.Notice;
import com.appowner.model.PanelPrice;
import com.appowner.model.Staff;
import com.appowner.model.RoleMaster;
import com.appowner.model.User;
import com.appowner.model.UserApartment;


@Service("ComplainService")
@Transactional 
public class ComplainServiceImpl implements ComplainService{
	@Autowired
	private ComplainDao complainDao;
	public ComplainDao getComplainDao() {
		return complainDao;
	}
	public void setComplainDao(ComplainDao complainDao) {
		this.complainDao = complainDao;
	}
	public void addComplain(Complain complain)
	{
		getComplainDao().addComplain(complain);
	}

	
	public void addContact(Contact contact)
	{
		getComplainDao().addContact(contact);
	}
	
	
	  public List<String> blockList()
	  {
		 return  getComplainDao().blockList(); 
	  }
	 
	
	  @Override
		public List<String> faltListBlock(String Block) {
		     System.out.println(Block);
			 return  getComplainDao().flatListBlock(Block); 
		}  
	  public List<String> renterListFlat(String Flat) {
			 return  getComplainDao().renterListFlat(Flat); 
		}  
	
	
	public List<Complain> listComplain() {
		return getComplainDao().listComplain();
	}
	public List<Contact> listContact() {
		return getComplainDao().listContact();
	}
	 public List<String> vendorList()
	 { 
		 return getComplainDao().vendorList(); 
	 }
	 public List<String> vendorListName(String str_VendorType)
	 {
		 return getComplainDao().vendorListName(str_VendorType);  
	 }
	
	
	public Complain getComplain(int int_ComplainID) {
		return getComplainDao().getComplain(int_ComplainID);
	}
	
	public void update(Complain cmp)
	{
		getComplainDao().update(cmp);
	}
	
	public void deleteComplain(Complain complain)
	{
		getComplainDao().deleteComplain(complain);
	}
	public void updateAdminReason(Integer iD, String str_Description)
	{
		getComplainDao().updateAdminReason(iD,str_Description);
	}
	public List<Complain> adminlistComplain()
	{
		return getComplainDao().adminlistComplain();
	}
	
/*	public int getNoPerson(String str_CompanyName)
	{
		return getComplainDao().getNoPerson(str_CompanyName);
	}*/
	
	
}
