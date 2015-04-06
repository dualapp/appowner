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

	List<UserBlocks> getListBlockDetails(Integer apartmentid);

	List<HouseDetails> getListHouseDetails(String str_BlockName, Integer ApartmentId);

	void saveCommunitySetup(CommunitySetup cs);

	void saveHouseDetails(HouseDetails housedetails);

	List<String> getBlockNameList(Integer apartmentId);

	List<String> getHouseNoList(String str_BlockName);

	HouseDetails getHouseDetailByHouseNo(String str_HouseNo, String str_BlockName);

	List<HouseDetails> getListHouseDetails(String str_BlockName);

	Integer getBlockId(String str_BlockName);

	User primaryOwnerDetailsByHouseNo(String str_BlockNo, String str_HouseNo, int role);

	 
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

	List<Integer> getCommunityTypeIdLists(Integer int_CommunitySetupId);

	String getCommunityMasterType(Integer cid);

	void deleteCommunityType(String str_CommunityType);

	void updateBlockDetails(UserBlocks ub, String oldBlockName);

	void updateOneBlock(UserBlocks selectedBlock);

	void deleteBlock(Integer blockId);

	UserBlocks getBlock(Integer blockId);

	void updateUserBlock(String oldBlock, String newBlock, Integer appartmentId);

	void updateUserFlat(String oldHouseNo, String newHouseNo, String blockName,
			Integer appartmentId);

	List getHouseDetailsByBlockId(Integer int_blockId);

	Long getNoOfBlocks();

	Long getTotalNoOfHouses();

	void updateCommunitySetup1(Long int_NoOfBlock, Long int_TotalHouse);

	Long getTotalNoOfHousesInABlock(String str_BlockName, Integer appartmentId);

	void updateBlockTotalhouse(String str_BlockName, Long int_TotalHouse);

	String checkBlock(String str_BlockName, Integer appartmentId);

	String checkHouse(String str_HouseNo, Integer appartmentId,
			Integer int_BlockId);

}
