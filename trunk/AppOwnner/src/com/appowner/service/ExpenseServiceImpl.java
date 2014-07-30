package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ExpenseDao;
import com.appowner.model.Expense;
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

}
