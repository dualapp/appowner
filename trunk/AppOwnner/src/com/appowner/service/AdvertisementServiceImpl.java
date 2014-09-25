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
import com.appowner.model.agency_information;

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

		
		public  List<Company> listperson1() {
			return getAdvertisementDao().listperson();
			
		}

		
		public List<Company> listoperation(String select) {
			return getAdvertisementDao().listoperation(select);
		}

		
		public void addagencies(agency_information agency) {
			 getAdvertisementDao().addagencies(agency);
			
		}

		@Override
		public int agency1(String agencyname1) {
			return getAdvertisementDao().agency1( agencyname1);
		}

		@Override
		public List<agency_information> agencies1() {
			return getAdvertisementDao().agencies1();
		}

		@Override
		public void Deleted(agency_information category) {
			getAdvertisementDao().Deleted(category);
			
		}

		@Override
		public agency_information editproduct(Integer int_agencyid) {
			return  getAdvertisementDao().editproduct( int_agencyid);
			
		}

		@Override
		public int editproductaa(Integer int_agencyid) {
			return  getAdvertisementDao().editproductaa(int_agencyid);
		}

		@Override
		public List<String> editproduct2(int prointcatid) {
			return  getAdvertisementDao().editproduct2( prointcatid);
		}

		

	
		}

		
		

