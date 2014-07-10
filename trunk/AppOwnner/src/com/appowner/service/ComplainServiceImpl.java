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
	public void addStaff(Staff staff)
	{
		getComplainDao().addStaff(staff);
	}
	
	public void addContact(Contact contact)
	{
		getComplainDao().addContact(contact);
	}
	public void addRole(CommiteeRole role)
	{
		getComplainDao().addRole(role);
	}
	public void addMaster(RoleMaster master)
	{
		getComplainDao().addMaster(master);
	}
	public void addNotice(Notice notice)
	{
		getComplainDao().addNotice(notice);
	}
	
	  public List<String> blockList()
	  {
		 return  getComplainDao().blockList(); 
	  }
	  public List<Staff> listStaffRoles()
	  {
		  return  getComplainDao().listStaffRoles();
	  }
	  public List<CommiteeRole> listCommiteeRoles()
	  {
		  return  getComplainDao().listCommiteeRoles(); 
	  }
	  public List<RoleMaster> listRoleMaster()
	  {
		  return  getComplainDao().listRoleMaster();  
	  }
	  public List<Notice> listNotices()
	  {
		  return  getComplainDao().listNotices();  
	  }
	  @Override
		public List<String> faltListBlock(String Block) {
		     System.out.println(Block);
			 return  getComplainDao().flatListBlock(Block); 
		}  
	  public List<String> renterListFlat(String Flat) {
			 return  getComplainDao().renterListFlat(Flat); 
		}  
	
	public void addCompany(Company company)
	{
		getComplainDao().addCompany(company);
	}
	public void addCompanyPerson(CompanyPerson person)
	{
		getComplainDao().addCompanyPerson(person);
	}
	public void addPanel(PanelPrice panel)
	{
		getComplainDao().addPanel(panel);
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
	
	public List<PanelPrice> listPanelPrice()
	{
		return getComplainDao().listPanelPrice();
	}
	public Complain getComplain(int int_ComplainID) {
		return getComplainDao().getComplain(int_ComplainID);
	}
	public Company getCompany(int int_CompanyID)
	{
		return getComplainDao().getCompany(int_CompanyID);
	}
	public List<CompanyPerson> getCompanyPerson(int int_CompanyID)
	{
		return getComplainDao().getCompanyPerson(int_CompanyID);
	}
	
	 public List<Company> listCompany()
	 {
		 return getComplainDao().listCompany(); 
	 }
	    public List<CompanyPerson> listCompanyPerson()
	    {
	    	return getComplainDao().listCompanyPerson();
	    }
	public void update(Complain cmp)
	{
		getComplainDao().update(cmp);
	}
	public void update(Company cmp1)
	{
		getComplainDao().update(cmp1);
	}
	public void update(CompanyPerson person)
	{
		getComplainDao().update(person);
	}
	public void deleteComplain(Complain complain)
	{
		getComplainDao().deleteComplain(complain);
	}
	public CompanyPerson getCompanyPerson1(int int_CompanyPersonID)
	{
		 return getComplainDao().getCompanyPerson1(int_CompanyPersonID);
	}
	
/*	public int getNoPerson(String str_CompanyName)
	{
		return getComplainDao().getNoPerson(str_CompanyName);
	}*/
	public void updatePanel(PanelPrice panel)
	{
		getComplainDao().updatePanel(panel);
	}
	public User validate(String name,String password)
	{
		 return getComplainDao().validate(name,password);
	}
	
	
	
}
