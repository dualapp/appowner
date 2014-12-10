package com.appowner.dao;

import java.util.List;

import com.appowner.model.CommunitySetup;
import com.appowner.model.CommunityType;
import com.appowner.model.Employee;
import com.appowner.model.HouseDetails;
import com.appowner.model.User;
import com.appowner.model.UserBlocks;

public interface ApartmentDetailsDao {
 
	void saveBlockDetails(UserBlocks ub);

	List<UserBlocks> getListBlockDetails();

	List<HouseDetails> getListHouseDetails(String str_BlockName);

	void saveCommunitySetup(CommunitySetup cs);

	void saveHouseDetails(HouseDetails housedetails);

	List<String> getBlockNameList();

	List<String> getHouseNoList(String str_BlockName);

	HouseDetails getHouseDetailByHouseNo(String str_HouseNo);

	List<HouseDetails> getListHouseDetails();

	Integer getBlockId(String str_BlockName);

	User primaryOwnerDetailsByHouseNo(String str_HouseNo, int role);

	 
	void saveHouseDetails1(List<HouseDetails> hDetailsList);

	void updateProfilePic(User user);

	Long getNoOfUsers(String str_HouseNo);

	HouseDetails getHouseDetails(Integer houseId);

	void deleteHouseDetails(HouseDetails hd);

	void deleteSelectedHouse(List<HouseDetails> entitiesToDelete);

	void updateHouseDetails(HouseDetails housedetails);

	List<CommunitySetup> getCommunityType(Integer userId);

	CommunitySetup getCommunitySetup(Integer userId);

	void updateCommunitySetup(CommunitySetup cs);

	List<String> getBlockNameByApartmentName(String str_UserApartment);

	List<String> getCommunityTypelist();

	void saveCommunitySetup(CommunityType communityType);

	Integer getCommunityType(String str_CommunityType);

	Integer getCommunitySetupId(Integer userId);

}
