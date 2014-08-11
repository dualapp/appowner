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
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;

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
	public List<Expense> getExpenseList() {
		// TODO Auto-generated method stub
		return getExpenseDao().getExpenseList();
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
	public List<String> getParkingSlotList() {
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

}
