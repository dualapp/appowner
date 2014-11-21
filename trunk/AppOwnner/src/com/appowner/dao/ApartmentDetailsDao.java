package com.appowner.dao;

import java.util.List;

import com.appowner.model.CommunitySetup;
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

	User primaryOwnerDetailsByHouseNo(String str_HouseNo);

}