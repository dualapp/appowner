package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.Expense;
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;

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

	 

}
