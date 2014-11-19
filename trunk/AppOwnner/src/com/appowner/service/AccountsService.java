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

public interface AccountsService {

	public List<AccountsOpeningBalance> listOpeningBalance();

	public void addAccounts(Integer int_Accounts_OpeningID, Double int_Debit);

	public void saveAccounts(Integer int_Accounts_OpeningID, Double int_Credit);


	public void addManualJournal(ManualJournal journal);

	

	public void addBalance(Date date, Integer id1, Integer id);
	List<String> getAccountTypeList();

	void saveChartOfAccount(ChartOfAccount chartOfAccount);

	List<ChartOfAccount> getChartOfAccountList();

	List<Character> getCh_AccountGroup();
	List<Character> getCh_AccountGroup1();
	List<String> getAccountTypeList(Character c);

	public List<SelectItem> getAccounts();
	public List<SelectItem> getAccount();

	public List<String> getAccountTypeList1(Character k);

	public String getAccountName(Integer id1);

	public double getCreditBalance(Integer id1);

	public double getDebitBalance(Integer id1);

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

	public void updateClosingBalance(double debit, double credit, String str);
	public List<ChartOfAccount> listExpense();
	public List<ChartOfAccount> listLiability();
	public List<ChartOfAccount> listEquity();

	public List<ChartOfAccount> listRavenues();

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

	
	

}
