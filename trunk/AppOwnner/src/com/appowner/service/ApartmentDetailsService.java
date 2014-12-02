package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.CommunitySetup;
import com.appowner.model.Employee;
import com.appowner.model.HouseDetails;
import com.appowner.model.User;
import com.appowner.model.UserBlocks;

public interface ApartmentDetailsService {

	void saveBlockDetails(UserBlocks ub);

	void saveHouseDetails(HouseDetails housedetails);

	List<UserBlocks> getListBlockDetails();

	List<HouseDetails> getListHouseDetails(String str_BlockName);

	void saveCommunitySetup(CommunitySetup cs);

	List<String> getBlockNameList();

	List<String> getHouseNoList(String str_BlockName);

	HouseDetails getHouseDetailByHouseNo(String str_HouseNo);

	List<HouseDetails> getListHouseDetails();

	Integer getBlockId(String str_BlockName);

	User primaryOwnerDetailsByHouseNo(String str_HouseNo, int role);
 
	void saveHouseDetails1(List<HouseDetails> hDetailsList);

	void updateProfilePic(User user);

}
