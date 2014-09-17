package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.PanelPrice;

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
}
