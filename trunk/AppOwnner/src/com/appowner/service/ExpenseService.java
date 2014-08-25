package com.appowner.service;

import java.util.Collection;
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

public interface ExpenseService {

	List<String> getOrgationNameList();

	List<String> getAssetCategoryList();

	void addExpenses(Expense expense);

	List<Expense> getExpenseList();

	Expense getOneExpense(String str_ExpenseId);

	void updateOneExpense(Expense expense);

	void deleteOneExpense(Expense expense);

	void saveParking(Parking parking);

	List<String> getParkingSlotList();

	void addOrganizationLogo(OrganizationLogo ol);

	void deleteParkingSlot(Parking p);

	Integer getLogoId(Integer int_AppartmentId);

	Integer getInt_AppartmentId(String str_UserName);

	void updateLogo(Integer logoid);

	void updateLogo(OrganizationLogo ol);

	OrganizationLogo getOrganizationLogo(Integer appartmentId);

	List<String> getStr_BlockListByAppartmentName(
			Integer appartmentId);

	void addAsset(Assets asset );

	List<String> getStr_AssetNameList(
			String str_AssetCategoryType);

	void saveAssetCategory(AssetCategory assetcategory);

	List<AssetCategory> getAssetCategoryList1();

	List<String> getAccountTypeList();

	void saveChartOfAccount(ChartOfAccount chartOfAccount);

	List<ChartOfAccount> getChartOfAccountList();

	List<Character> getCh_AccountGroup();

	List<String> getAccountTypeList(Character c);

	List<Assets> getAssetsList();

	void addFacility(FacilityNeeded facilityNeeded);

	List<FacilityNeeded> getFacilityNeededList();

	List<String> getFacilityTypeList();

	void addPool(Pool pool);

	List<Pool> getPoolList();

	 

}
