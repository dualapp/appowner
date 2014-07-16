package com.appowner.service;

import java.util.List;

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


public interface ComplainService {
	public void addComplain(Complain complain);
	public void addContact(Contact contact);
	
	
    public List<Complain> listComplain();
    
    public List<Contact> listContact();
   
  
    public List<String> vendorList();
  
    public List<String> vendorListName(String str_VendorType);
    public List<String> blockList();
    public List<String> faltListBlock(String Block);
    public List<String> renterListFlat(String Flat);
	public Complain getComplain(int int_ComplainID);

	public void update(Complain cmp);
	
	public void deleteComplain(Complain complain);
	
//	public int getNoPerson(String str_CompanyName);

	
}

