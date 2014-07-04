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


public interface ComplainService {
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
    public List<Company> listCompany();
    public List<CompanyPerson> listCompanyPerson();
    public List<Contact> listContact();
    public List<PanelPrice> listPanelPrice();
    public List<Staff> listStaffRoles();
    public List<CommiteeRole> listCommiteeRoles();
    public List<RoleMaster> listRoleMaster();
    public List<String> vendorList();
    public List<Notice> listNotices();
    public List<String> vendorListName(String str_VendorType);
    public List<String> blockList();
    public List<String> faltListBlock(String Block);
    public List<String> renterListFlat(String Flat);
	public Complain getComplain(int int_ComplainID);
	public Company getCompany(int int_CompanyID);
	public List<CompanyPerson> getCompanyPerson(int int_CompanyID);
	public void update(Complain cmp);
	public void update(Company cmp1);
	public void update(CompanyPerson person);
	public void deleteComplain(Complain complain);
	public CompanyPerson getCompanyPerson1(int int_CompanyPersonID);
//	public int getNoPerson(String str_CompanyName);
	public void updatePanel(PanelPrice panel);
}

