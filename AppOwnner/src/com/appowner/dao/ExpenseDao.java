package com.appowner.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import com.appowner.model.AssetCategory;
import com.appowner.model.Assets;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.Expense;
import com.appowner.model.FacilityNeeded;
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.Vote;

public interface ExpenseDao {

	List<String> getOrgationNameList();

	List<String> getAssetCategoryList();

	void addExpenses(Expense expense);

	List<Expense> getExpenseList(String str_AssetName, String str_AssetCategoryType, String str_ExpenseCategory, String str_ExcepenseType, Integer int_ApartmentId);

	Expense getOneExpense(String str_ExpenseId);

	void updateOneExpense(Expense expense);

	void deleteOneExpense(Expense expense);

	void saveParking(Parking parking);

	List<Parking> getParkingSlotList();

	void addOrganizationLogo(OrganizationLogo ol);

	void deleteParkingSlot(Parking p);

	Integer getLogoId(Integer int_AppartmentId);

	Integer getInt_AppartmentId(String str_UserName);

	void updateLogo(OrganizationLogo ol);

	OrganizationLogo getOrganizationLogo(Integer appartmentId);

	List<String> getStr_BlockListByAppartmentName(Integer appartmentId);

	void addAsset(Assets ac);

	List<String> getStr_AssetNameList(String str_AssetCategoryType);

	void saveAssetCategory(AssetCategory assetcategory);

	List<AssetCategory> getAssetCategoryList1();

	List<String> getAccountTypeList();

	void saveChartOfAccount(ChartOfAccount chartOfAccount);

	List<ChartOfAccount> getChartOfAccountList();

	List<Character> getCh_AccountGroup();

	List<String> getAccountTypeList(Character l);

	List<Assets> getAssetsList();

	void addFacility(FacilityNeeded facilityNeeded);

	List<FacilityNeeded> getFacilityNeededList();

	List<String> getFacilityTypeList();

	void addPool(Pool pool);

	List<Pool> getPoolList();

	Pool getOnePool(Integer int_PoolId);

	Integer addVote(Vote vote);

	void UpdatePool(Pool pool);

	Long getChoise1Vote(String str_Choise1, Integer int_PoolId);

	Long getChoise2Vote(String str_Choise2,Integer int_PoolId);

	Long getChoise3Vote(String str_Choise3,Integer int_PoolId);

	void updateStatusOfServiceRequest(ServiceRequest serviceRequest);

	ServiceRequest getOneServiceRequest(Integer serviceRequestId);

	void updateOneServiceRequest(ServiceRequest serviceRequest);

	void deleteOneServiceRequest(ServiceRequest servicerequest1);

	Long getTotalVote(Integer int_PoolId);

	Integer isVoted(Integer int_UserId,Integer int_PoolId);

	List<String> getOrganizationImages();

	List<ServiceRequest> getListServiceRequest();

	Pool getLatestPolls();

	List<Assets> getAssetList(String str_AssetCategoryType, String str_Block, Integer int_ApartmentId);

	void deleteSelectedExpenses(List<Expense> entitiesToDelete);

	void deleteOnePoll(Pool onePoll);

	void deleteOnefacility(List<Assets> entitiesToDelete);

	void updateOneasset(Assets asset);

	void updateParkingSpace(Parking p);

	void deleteParkingSpace(List<Parking> entitiesToDelete);

	void delectAssetsCategory(List<AssetCategory> entitiesToDelete);

	void updateAssetCategory(AssetCategory ac);

	void updateFacility(FacilityNeeded fn1);

	void deletefacilityNeeded(List<FacilityNeeded> entitiesToDelete);

}
