package com.appowner.service;

import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ExpenseDao;
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

@Service("ExpenseService")
 @Transactional
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private ExpenseDao expenseDao;
	
	 
	

	public ExpenseDao getExpenseDao() {
		return expenseDao;
	}

	public void setExpenseDao(ExpenseDao expenseDao) {
		this.expenseDao = expenseDao;
	}

	@Override
	public List<String> getOrgationNameList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getOrgationNameList();
	}

	@Override
	public List<String> getAssetCategoryList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getAssetCategoryList();
	}

	@Override
	public void addExpenses(Expense expense) {
		// TODO Auto-generated method stub
		getExpenseDao().addExpenses(expense);
	}

	@Override
	public List<Expense> getExpenseList(String str_AssetName, String str_AssetCategoryType, String str_ExpenseCategory, String str_ExcepenseType, Integer int_ApartmentId){
		// TODO Auto-generated method stub
		return getExpenseDao().getExpenseList(str_AssetName,str_AssetCategoryType,str_ExpenseCategory,str_ExcepenseType,int_ApartmentId);
	}

	@Override
	public Expense getOneExpense(String str_ExpenseId) {
		// TODO Auto-generated method stub
		return getExpenseDao().getOneExpense(str_ExpenseId);
	}

	@Override
	public void updateOneExpense(Expense expense) {
		getExpenseDao().updateOneExpense(expense);
		
	}

	@Override
	public void deleteOneExpense(Expense expense) {
		// TODO Auto-generated method stub
		getExpenseDao().deleteOneExpense(expense);
	}

	@Override
	public void saveParking(Parking parking) {
		// TODO Auto-generated method stub
		getExpenseDao(). saveParking(parking);
	}

	@Override
	public List<Parking> getParkingSlotList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getParkingSlotList();
	}

	@Override
	public void addOrganizationLogo(OrganizationLogo ol) {
		getExpenseDao().addOrganizationLogo(ol);
		
	}

	@Override
	public void deleteParkingSlot( Parking p) {
		getExpenseDao().deleteParkingSlot(p);
		
	}

	@Override
	public Integer getLogoId(Integer int_AppartmentId) {
		// TODO Auto-generated method stub
		return getExpenseDao().getLogoId(int_AppartmentId);
	}

	@Override
	public Integer getInt_AppartmentId(String str_UserName) {
		// TODO Auto-generated method stub
		return getExpenseDao().getInt_AppartmentId(str_UserName);
	}

	@Override
	public void updateLogo(Integer logoid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLogo(OrganizationLogo ol) {
		getExpenseDao().updateLogo(ol);
	}

	@Override
	public OrganizationLogo getOrganizationLogo(Integer appartmentId) {
		// TODO Auto-generated method stub
		return getExpenseDao().getOrganizationLogo(appartmentId);
	}

	@Override
	public List<String> getStr_BlockListByAppartmentName(Integer appartmentId) {
		// TODO Auto-generated method stub
		return getExpenseDao().getStr_BlockListByAppartmentName(appartmentId);
	}

	@Override
	public void addAsset(Assets  ac) {
		getExpenseDao().addAsset(ac);
		
	}

	@Override
	public List<String> getStr_AssetNameList(String str_AssetCategoryType) {
		// TODO Auto-generated method stub
		return getExpenseDao().getStr_AssetNameList(str_AssetCategoryType);
	}

	@Override
	public void saveAssetCategory(AssetCategory assetcategory) {
		getExpenseDao().saveAssetCategory(assetcategory);
		
	}

	@Override
	public List<AssetCategory> getAssetCategoryList1() {
		// TODO Auto-generated method stub
		return getExpenseDao().getAssetCategoryList1();
	}

	@Override
	public List<String> getAccountTypeList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getAccountTypeList();
	}

	@Override
	public void saveChartOfAccount(ChartOfAccount chartOfAccount) {
		// TODO Auto-generated method stub
		getExpenseDao().saveChartOfAccount(chartOfAccount);
	}

	@Override
	public List<ChartOfAccount> getChartOfAccountList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getChartOfAccountList();
	}

	@Override
	public List<Character> getCh_AccountGroup() {
		// TODO Auto-generated method stub
		return getExpenseDao().getCh_AccountGroup();
	}

	@Override
	public List<String> getAccountTypeList(Character l) {
		// TODO Auto-generated method stub
		return getExpenseDao().getAccountTypeList(l);
	}

	@Override
	public List<Assets> getAssetsList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getAssetsList();
	}

	@Override
	public void addFacility(FacilityNeeded facilityNeeded) {
		// TODO Auto-generated method stub
		getExpenseDao().addFacility(facilityNeeded);
	}

	@Override
	public List<FacilityNeeded> getFacilityNeededList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getFacilityNeededList();
	}

	@Override
	public List<String> getFacilityTypeList() {
		// TODO Auto-generated method stub
		return  getExpenseDao().getFacilityTypeList();
	}

	@Override
	public void addPool(Pool pool) {
		// TODO Auto-generated method stub
		getExpenseDao().addPool(pool);
	}

	@Override
	public List<Pool> getPoolList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getPoolList();
	}

	@Override
	public Pool getOnePool(Integer int_PoolId) {
		// TODO Auto-generated method stub
		return getExpenseDao().getOnePool(int_PoolId);
	}

	@Override
	public Integer addVote(Vote vote) {
		// TODO Auto-generated method stub
	 
		return getExpenseDao().addVote(vote);
	}

	@Override
	public void UpdatePool(Pool pool) {
		// TODO Auto-generated method stub
		getExpenseDao().UpdatePool(pool);
	}

	@Override
	public Long getChoise1Vote(String str_Choise1, Integer int_PoolId) {
		// TODO Auto-generated method stub
		return getExpenseDao().getChoise1Vote(str_Choise1,int_PoolId);
	}

	@Override
	public Long getChoise2Vote(String str_Choise2, Integer int_PoolId) {
		// TODO Auto-generated method stub
		return getExpenseDao().getChoise2Vote(str_Choise2,int_PoolId);
	}

	@Override
	public Long getChoise3Vote(String str_Choise3, Integer int_PoolId) {
		// TODO Auto-generated method stub
		return getExpenseDao().getChoise3Vote(str_Choise3,int_PoolId);
	}

	@Override
	public void updateStatusOfServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		getExpenseDao().updateStatusOfServiceRequest(serviceRequest);
	}

	@Override
	public ServiceRequest getOneServiceRequest(Integer serviceRequestId) {
		// TODO Auto-generated method stub
		
		return getExpenseDao(). getOneServiceRequest(serviceRequestId);
	}

	@Override
	public void updateOneServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		getExpenseDao().updateOneServiceRequest(serviceRequest);
	}

	@Override
	public void deleteOneServiceRequest(ServiceRequest servicerequest1) {
		// TODO Auto-generated method stub
		getExpenseDao().deleteOneServiceRequest(servicerequest1);
	}

	@Override
	public Long getTotalVote(Integer int_PoolId) {
		// TODO Auto-generated method stub
		return getExpenseDao(). getTotalVote(int_PoolId);
	}

	@Override
	public Integer isVoted(Integer int_UserId,Integer int_PoolId) {
		// TODO Auto-generated method stub
		return getExpenseDao().isVoted(int_UserId,int_PoolId);
	}

	@Override
	public List<String> getOrganizationImages() {
		// TODO Auto-generated method stub
		return getExpenseDao().getOrganizationImages();
	}

	@Override
	public List<ServiceRequest> getListServiceRequest() {
		// TODO Auto-generated method stub
		return getExpenseDao().getListServiceRequest();
	}

	@Override
	public Pool getLatestPolls() {
		// TODO Auto-generated method stub
		return getExpenseDao().getLatestPolls();
	}

	@Override
	public List<Assets> getAssetList(String str_AssetCategoryType,
			String str_Block, Integer int_ApartmentId) {
		return getExpenseDao().getAssetList(str_AssetCategoryType,str_Block,int_ApartmentId);
	}

	@Override
	public void deleteSelectedExpenses(List<Expense> entitiesToDelete) {
		// TODO Auto-generated method stub
		getExpenseDao().deleteSelectedExpenses(entitiesToDelete);
	}

	@Override
	public void deleteOnePoll(Pool onePoll) {
		// TODO Auto-generated method stub
		getExpenseDao().deleteOnePoll(onePoll);
	}

	@Override
	public void deleteOnefacility(List<Assets> entitiesToDelete) {
		// TODO Auto-generated method stub
		getExpenseDao().deleteOnefacility( entitiesToDelete);
	}

	@Override
	public void updateOneasset(Assets asset) {
		// TODO Auto-generated method stub
		getExpenseDao().updateOneasset(asset);
	}

	@Override
	public void updateParkingSpace(Parking p) {
		// TODO Auto-generated method stub
		getExpenseDao().updateParkingSpace( p);
	}

	@Override
	public void deleteParkingSpace(List<Parking> entitiesToDelete) {
		// TODO Auto-generated method stub
		getExpenseDao().deleteParkingSpace(entitiesToDelete);
	}

	@Override
	public void delectAssetsCategory(List<AssetCategory> entitiesToDelete) {
		// TODO Auto-generated method stub
		getExpenseDao().delectAssetsCategory(entitiesToDelete); 
	}

	@Override
	public void updateAssetCategory(AssetCategory ac) {
		// TODO Auto-generated method stub
		getExpenseDao().updateAssetCategory( ac);
	}

	@Override
	public void updateFacility(FacilityNeeded fn1) {
		// TODO Auto-generated method stub
		getExpenseDao().updateFacility(fn1);
	}

	@Override
	public void deletefacilityNeeded(List<FacilityNeeded> entitiesToDelete) {
		// TODO Auto-generated method stub
		getExpenseDao().deletefacilityNeeded(entitiesToDelete);
	}

	 

}
