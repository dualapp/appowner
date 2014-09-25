package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.PanelPrice;
import com.appowner.model.agency_information;

public interface AdvertisementService {
	public void addCompany(Company company);
	public void addCompanyPerson(CompanyPerson person);
	public void addPanel(PanelPrice panel);
	public List<Company> listCompany();
    public List<CompanyPerson> listCompanyPerson();
    public List<PanelPrice> listPanelPrice();
	public Company getCompany(int int_CompanyID);
	public List<CompanyPerson> getCompanyPerson(int int_CompanyID);
	public void update(Company cmp1);
	public void update(CompanyPerson person);
	public CompanyPerson getCompanyPerson1(int int_CompanyPersonID);
	public void updatePanel(PanelPrice panel);
	public List<Company> listperson1();
	public List<Company> listoperation(String select);
	public void addagencies(agency_information agency);
	public int agency1(String agencyname1);
	public List<agency_information> agencies1();
	public void Deleted(agency_information category);
	public agency_information editproduct(Integer int_agencyid);
	public int editproductaa(Integer int_agencyid);
	public List<String> editproduct2(int prointcatid);
	
	
}
