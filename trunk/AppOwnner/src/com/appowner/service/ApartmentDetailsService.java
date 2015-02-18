package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.CommunitySetup;
import com.appowner.model.CommunityType;
import com.appowner.model.Employee;
import com.appowner.model.HouseDetails;
import com.appowner.model.User;
import com.appowner.model.UserBlocks;

public interface ApartmentDetailsService {

	void saveBlockDetails(UserBlocks ub);

	void saveHouseDetails(HouseDetails housedetails);

	List<UserBlocks> getListBlockDetails(Integer integer);

	List<HouseDetails> getListHouseDetails(String str_BlockName);

	void saveCommunitySetup(CommunitySetup cs);

	List<String> getBlockNameList(Integer integer);

	List<String> getHouseNoList(String str_BlockName);

	HouseDetails getHouseDetailByHouseNo(String str_HouseNo);

	List<HouseDetails> getListHouseDetails(String str_BlockName, Integer integer);

	Integer getBlockId(String str_BlockName);

	User primaryOwnerDetailsByHouseNo(String str_HouseNo, int role);
 
	void saveHouseDetails1(List<HouseDetails> hDetailsList);

	void updateProfilePic(User user);

	Long getNoOfUsers(String str_HouseNo);

	HouseDetails getHouseDetails(Integer houseId);

	void deleteHouseDetails(HouseDetails housedetails);

	void deleteSelectedHouse(List<HouseDetails> entitiesToDelete);

	void updateHouseDetails(HouseDetails housedetails);

	 List<CommunitySetup> getCommunityType(Integer userId);

	CommunitySetup getCommunitySetup(Integer userId);

	void updateCommunitySetup(CommunitySetup cs);

	List<String> getBlockNameByApartmentName(
			String str_UserApartment);

	List<String> getCommunityTypelist();

	void saveCommunitySetup(CommunityType communityType);

	Integer getCommunityType(String str_CommunityType);

	Integer getCommunitySetupId(Integer userId);

	List<Integer> getCommunityTypeIdLists(Integer int_CommunitySetupId);

	String getCommunityMasterType(Integer cid);

	void deleteCommunityType(String str_CommunityType);

	void updateBlockDetails(UserBlocks ub);

}
