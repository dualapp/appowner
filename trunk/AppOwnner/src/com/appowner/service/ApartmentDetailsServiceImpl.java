package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ApartmentDetailsDao;
import com.appowner.model.CommunitySetup;
import com.appowner.model.CommunityType;
import com.appowner.model.Employee;
import com.appowner.model.HouseDetails;
import com.appowner.model.User;
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
	public List<UserBlocks> getListBlockDetails(Integer apartmentid) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getListBlockDetails(apartmentid);
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
	public List<String> getBlockNameList(Integer ApartmentId) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getBlockNameList(ApartmentId);
	}

	@Override
	public List<String> getHouseNoList(String str_BlockName) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getHouseNoList( str_BlockName);
	}

	@Override
	public HouseDetails getHouseDetailByHouseNo(String str_HouseNo) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getHouseDetailByHouseNo(str_HouseNo);
	}

	@Override
	public List<HouseDetails> getListHouseDetails(String str_BlockName, Integer ApartmentID) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getListHouseDetails(str_BlockName,ApartmentID);
	}

	@Override
	public Integer getBlockId(String str_BlockName) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getBlockId(str_BlockName);
	}

	@Override
	public User primaryOwnerDetailsByHouseNo(String str_HouseNo,int role) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().primaryOwnerDetailsByHouseNo(str_HouseNo,role);
	}

	 

	@Override
	public void saveHouseDetails1(List<HouseDetails> hDetailsList) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().saveHouseDetails1( hDetailsList);
	}

	@Override
	public void updateProfilePic(User user) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().updateProfilePic(user);
	}

	@Override
	public Long getNoOfUsers(String str_HouseNo) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getNoOfUsers(str_HouseNo);
	}

	@Override
	public HouseDetails getHouseDetails(Integer houseId) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getHouseDetails(houseId);
	}

	@Override
	public void deleteHouseDetails(HouseDetails hd) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().deleteHouseDetails(hd);
	}

	@Override
	public void deleteSelectedHouse(List<HouseDetails> entitiesToDelete) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().deleteSelectedHouse(entitiesToDelete);
	}

	@Override
	public void updateHouseDetails(HouseDetails housedetails) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().updateHouseDetails(housedetails);
	}

	@Override
	public List<CommunitySetup> getCommunityType(Integer userId) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getCommunityType(userId);
	}

	@Override
	public CommunitySetup getCommunitySetup(Integer userId) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao(). getCommunitySetup(userId);
	}

	@Override
	public void updateCommunitySetup(CommunitySetup cs) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().updateCommunitySetup(cs);
	}

	@Override
	public List<String> getBlockNameByApartmentName(String str_UserApartment) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getBlockNameByApartmentName(str_UserApartment);
	}

	@Override
	public List<String> getCommunityTypelist() {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getCommunityTypelist();
	}

	@Override
	public void saveCommunitySetup(CommunityType communityType) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().saveCommunitySetup(communityType);
	}

	@Override
	public Integer getCommunityType(String str_CommunityType) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getCommunityType(str_CommunityType);
	}

	@Override
	public Integer getCommunitySetupId(Integer userId) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getCommunitySetupId(userId);
	}

	@Override
	public List<Integer> getCommunityTypeIdLists(Integer int_CommunitySetupId) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getCommunityTypeIdLists(int_CommunitySetupId);
	}

	@Override
	public String getCommunityMasterType(Integer cid) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getCommunityMasterType(cid);
	}

	@Override
	public void deleteCommunityType(String str_CommunityType) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().deleteCommunityType(str_CommunityType);
	}

	@Override
	public void updateBlockDetails(UserBlocks ub,String oldBlockName) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().updateBlockDetails(ub,oldBlockName);
	}

	@Override
	public void updateOneBlock(UserBlocks selectedBlock) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().updateOneBlock(selectedBlock) ;
	}

	@Override
	public void deleteBlock(Integer blockId) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().deleteBlock(blockId);
	}

	@Override
	public UserBlocks getBlock(Integer blockId) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getBlock(blockId);
	}

	@Override
	public void updateUserBlock(String oldBlock, String newBlock,
			Integer appartmentId) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().updateUserBlock(  oldBlock,   newBlock, appartmentId);
				 
	}

	@Override
	public void updateUserFlat(String oldHouseNo, String newHouseNo,
			String blockName, Integer appartmentId) {
		// TODO Auto-generated method stub
		getApartmentDetailsDao().updateUserFlat( oldHouseNo,  newHouseNo,
				  blockName,  appartmentId);
	}

	@Override
	public List getHouseDetailsByBlockId(Integer int_blockId) {
		// TODO Auto-generated method stub
		return getApartmentDetailsDao().getHouseDetailsByBlockId(int_blockId);
	}

	 

}
