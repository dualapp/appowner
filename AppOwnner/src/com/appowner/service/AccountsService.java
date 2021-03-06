package com.appowner.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.appowner.model.Account;
import com.appowner.model.AccountingGroup;
import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.Expense;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;
import com.appowner.model.customize;

public interface AccountsService {

	public List<AccountsOpeningBalance> listOpeningBalance(Integer id);

	public void addAccounts(Integer int_Accounts_OpeningID, Double int_Debit);

	public void saveAccounts(Integer int_Accounts_OpeningID, Double int_Credit);


	public void addManualJournal(ManualJournal journal);

	

	public void addBalance(Date date,Integer id1, double adjustmentBalance, double adjustmentBalance1);
	

	void saveChartOfAccount(ChartOfAccount chartOfAccount);

	List<ChartOfAccount> getChartOfAccountList();

	List<Character> getCh_AccountGroup();
	List<Character> getCh_AccountGroup1();
	List<String> getAccountTypeList(String account);

	public List<SelectItem> getAccounts();
	public List<SelectItem> getAccount();

	public List<String> getAccountTypeList1();

	public String getAccountName(Integer id1);

	public double getCreditBalance(Integer id1);

	public double getDebitBalance(Integer id1, Date openingdate, String str);

	public int getAccountId(String str);

	public String getAccountName1(Integer id1);

	

	public List<InvoiceTransaction> listInvoiceTransaction(
			String str_Accounts, Date dat_From, Date dat_ToDate);

	public String getStatus(String str_Accounts);

	public List<Double> getTotalBalance();

	public Character getChGroup(String str_AccountType);

	public List<InvoiceTransaction> listInvoiceTransaction1(
			String str_Accounts, Date dat_FromDate, Date dat_ToDate);

	public List<ManualJournal> getlistManualJournal();

	public List<ManualJournal> getlistManualJournal1(String str_Accounts, Date dat_FromDate, Date dat_ToDate);

	public ManualJournal getManualAccount(Integer id);

	public double getDebitAmount(Integer id);

	public double getCreditAmount(Integer id);

	public List<Expense> getExpenseList(String str, Date dat_FromDate, Date dat_ToDate);

	public List<ChartOfAccount> listAssets();

	public List<String> group();

	public void updateClosingBalance(double debit, double credit, String str, double credit2);
	

	public List<Expense> expenseList(Date dat_FromDate,Date dat_ToDate);

	public void addAccount(Account account);

	public List<Account> listAccounts();

	public List<String> listAccount();

	public List<AccountingGroup>  getAsset();

	public List<AccountingGroup> getRevenues();

	public List<AccountingGroup> getLiabilities();

	public List<AccountingGroup> getExpense();

	public List<AccountingGroup> getGroups(char d);

	public void addAccountGroup(AccountingGroup account);

	public void deleteGroup(AccountingGroup account);

	public void saveOpeningAccount(AccountsOpeningBalance balance);

	public void addCustomized(customize customer);

	public void updateManualJournal(ManualJournal journal);

	public void deleteManualJournal(Integer id);

	public List<InvoiceTransaction> listInvoiceTransaction2(Date dat_From, Date dat_To);

	public List<Double> getExpenseAmount(Date dat_To);

	public List<Double> getIncomeAmount(Date dat_To);

	public List<ManualJournal> getlistManualJournal2(String str, Date dat_From, Date dat_To);

	public List<ManualJournal> getlistManualJournal3(String str, Date dat_From, Date dat_To);

	public double getCreditAmount(String str, Date dat_ToDate);

	public double getDebitAmount(String str, Date dat_ToDate);

	public List<ChartOfAccount> getAccountTypeList2();

	public List<String> getIncome();

	public List<String> getExpense1();

	public Date getOpeningDate();

	public ManualJournal getManualJournal(int id1);

	public List< ManualJournal> getlistManualJourna4(
			Date dat_From, Date dat_To);

	
			

	
		
			

	
	

}
