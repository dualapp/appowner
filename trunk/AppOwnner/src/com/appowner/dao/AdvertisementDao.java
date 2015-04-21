package com.appowner.dao;

import java.util.List;

import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.PanelPrice;
import com.appowner.model.agency_information;
import com.appowner.model.cls_MakePayment;

public interface AdvertisementDao {
	public void addCompany(Company company);
	public void addCompanyPerson(CompanyPerson person);
	public void addPanel(PanelPrice panel);
	 public List<Company> listCompany();
	 public List<PanelPrice> listPanelPrice();
	  public List<CompanyPerson> listCompanyPerson();
	  public Company getCompany(int int_CompanyID);
	  public List<CompanyPerson> getCompanyPerson(int int_CompanyID);
	  public void update(Company cmp1);
		public void update(CompanyPerson person);
		public CompanyPerson getCompanyPerson1(int int_CompanyPersonID);
		public void updatePanel(PanelPrice panel);
		public List<Company> listperson();
		public List<Company> listoperation(String select);
		public int addagencies(agency_information agency);
		public int agency1(String agencyname1);
		public List<agency_information> agencies1();
		public void Deleted(agency_information category);
		public agency_information editproduct(Integer int_agencyid);
		public int editproductaa(Integer int_agencyid);
		public List<String> editproduct2(int prointcatid);
		public void deleted(agency_information detail);
		public void payment(cls_MakePayment pay);
		public int adv(String intdocid1);
		public int adv1(String intdocid1);
		public int companysid(int agencyid1);
		public List<agency_information> allinf(int postid);
		public void deletepost(agency_information detail);
	
		
	
}
