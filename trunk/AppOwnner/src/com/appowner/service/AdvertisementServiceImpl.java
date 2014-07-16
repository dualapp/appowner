package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.AdvertisementDao;
import com.appowner.dao.ComplainDao;
import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.PanelPrice;

@Service("AdvertisementService")
@Transactional 
	
public class AdvertisementServiceImpl implements AdvertisementService {
	@Autowired
	private AdvertisementDao advertisementDao;

	public AdvertisementDao getAdvertisementDao() {
		return advertisementDao;
	}

	public void setAdvertisementDao(AdvertisementDao advertisementDao) {
		this.advertisementDao = advertisementDao;
	}
	public void addCompany(Company company)
	{
		getAdvertisementDao().addCompany(company);
	}
	public void addCompanyPerson(CompanyPerson person)
	{
		getAdvertisementDao().addCompanyPerson(person);
	}
	public void addPanel(PanelPrice panel)
	{
		getAdvertisementDao().addPanel(panel);
	}
	public List<PanelPrice> listPanelPrice()
	{
		return getAdvertisementDao().listPanelPrice();
	}
	public Company getCompany(int int_CompanyID)
	{
		return getAdvertisementDao().getCompany(int_CompanyID);
	}
	public List<CompanyPerson> getCompanyPerson(int int_CompanyID)
	{
		return getAdvertisementDao().getCompanyPerson(int_CompanyID);
	}
	
	 public List<Company> listCompany()
	 {
		 return getAdvertisementDao().listCompany(); 
	 }
	    public List<CompanyPerson> listCompanyPerson()
	    {
	    	return getAdvertisementDao().listCompanyPerson();
	    }public void update(Company cmp1)
		{
	    	getAdvertisementDao().update(cmp1);
		}
		public void update(CompanyPerson person)
		{
			getAdvertisementDao().update(person);
		}
		public CompanyPerson getCompanyPerson1(int int_CompanyPersonID)
		{
			 return getAdvertisementDao().getCompanyPerson1(int_CompanyPersonID);
		}
		public void updatePanel(PanelPrice panel)
		{
			getAdvertisementDao().updatePanel(panel);
		}
}
