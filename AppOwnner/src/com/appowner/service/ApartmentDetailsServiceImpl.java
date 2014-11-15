package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ApartmentDetailsDao;
import com.appowner.model.CommunitySetup;
import com.appowner.model.HouseDetails;
import com.appowner.model.UserBlocks;
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
	public void saveBlockDetails(UserBlocks ub) {
		getApartmentDetailsDao().saveBlockDetails( ub);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveHouseDetails(HouseDetails housedetails) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().saveHouseDetails(housedetails);
	}

	@Override
	public List<UserBlocks> getListBlockDetails() {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getListBlockDetails();
	}

	@Override
	public List<HouseDetails> getListHouseDetails(String str_BlockName) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getListHouseDetails(str_BlockName);
	}

	@Override
	public void saveCommunitySetup(CommunitySetup cs) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().saveCommunitySetup(cs);
	}

	@Override
	public List<String> getBlockNameList() {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getBlockNameList();
	}

	@Override
	public List<String> getHouseNoList(String str_BlockName) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getHouseNoList( str_BlockName);
	}

}
