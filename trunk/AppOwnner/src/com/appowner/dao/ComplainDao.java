package com.appowner.dao;

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


public interface ComplainDao {
	public void addComplain(Complain complain);
	public void addContact(Contact contact);
	public void addCompany(Company company);
	public void addCompanyPerson(CompanyPerson person);
	public void addPanel(PanelPrice panel);
	public void addStaff(Staff staff);
	public void addRole(CommiteeRole role);
	public void addMaster(RoleMaster master);
	public void addNotice(Notice notice); 
	 public List<Complain> listComplain();
	 public List<Contact> listContact();
	 public List<Company> listCompany();
	 public List<PanelPrice> listPanelPrice();
	 public List<Notice> listNotices();
	    public List<CompanyPerson> listCompanyPerson();
		public Complain getComplain(int int_ComplainID);
		public Company getCompany(int int_CompanyID);
		public List<CompanyPerson> getCompanyPerson(int int_CompanyID);
		 public List<String> vendorList();
		 public List<Staff> listStaffRoles();
		  public List<CommiteeRole> listCommiteeRoles();
		  public List<RoleMaster> listRoleMaster();
		  public List<String> blockList();
		  public List<String> flatListBlock(String Block);
		  public List<String> renterListFlat(String Flat);
		 public List<String> vendorListName(String str_VendorType);
		public void update(Complain cmp);
		public void update(Company cmp1);
		public void update(CompanyPerson person);
		public void deleteComplain(Complain complain);
		public CompanyPerson getCompanyPerson1(int int_CompanyPersonID);
	//	public int getNoPerson(String str_CompanyName);
		public void updatePanel(PanelPrice panel);
		public User validate(String name,String password);
		}
	

