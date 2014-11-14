package com.appowner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ApartmentDetailsDao;
@Service("ApartmentDetailsService")
@Transactional
public class ApartmentDetailsServiceImpl implements ApartmentDetailsService{
	@Autowired
	private ApartmentDetailsDao apartmentDetailsDao;

	public ApartmentDetailsDao getApartmentDetailsDao() {
		return apartmentDetailsDao;
	}

	public void setApartmentDetailsDao(ApartmentDetailsDao apartmentDetailsDao) {
		this.apartmentDetailsDao = apartmentDetailsDao;
	}

	@Override
	public void saveCommunitySetup() {
		// TODO Auto-generated method stub
		System.out.println("save");
		
	}

}
