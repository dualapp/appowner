package com.appowner.service;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.AccountsDao;
import com.appowner.model.Account;
import com.appowner.model.AccountingGroup;
import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.Expense;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;
import com.appowner.model.customize;

@Service("AccountsService")
@Transactional 
public class AccountsServiceImpl implements AccountsService {
	@Autowired
	private AccountsDao accountsDao;

	public AccountsDao getAccountsDao() {
		return accountsDao;
	}

	public void setAccountsDao(AccountsDao accountsDao) {
		this.accountsDao = accountsDao;
	}
	public List<AccountsOpeningBalance> listOpeningBalance(Integer id)
	{
		return getAccountsDao().listOpeningBalance(id);
	}
	public void addAccounts(Integer int_Accounts_OpeningID, Double int_Debit)
	{ 
		getAccountsDao().addAccounts(int_Accounts_OpeningID,int_Debit);
	}
	public void saveAccounts(Integer int_Accounts_OpeningID, Double int_Credit)
	{
		getAccountsDao().saveAccounts(int_Accounts_OpeningID,int_Credit);
	}
	public void addManualJournal(ManualJournal journal)
	{
		getAccountsDao().addManualJournal(journal);
	}
	public void addBalance(Date date,Integer id1, double adjustmentBalance, double adjustmentBalance1)
	{
		getAccountsDao().addBalance(date, id1,adjustmentBalance,adjustmentBalance1);
	}
	

	@Override
	public void saveChartOfAccount(ChartOfAccount chartOfAccount) {
		
		getAccountsDao().saveChartOfAccount(chartOfAccount);
	}

	@Override
	public List<ChartOfAccount> getChartOfAccountList() {
	
		return getAccountsDao().getChartOfAccountList();
	}

	@Override
	public List<Character> getCh_AccountGroup() {
		
		return getAccountsDao().getCh_AccountGroup();
	}
	public List<Character> getCh_AccountGroup1()
	{
		return getAccountsDao().getCh_AccountGroup1();
	}

	@Override
	public List<String> getAccountTypeList(){
		
		return getAccountsDao().getAccountTypeList();
	}
	public List<String> getAccountTypeList1()
	{
		return getAccountsDao().getAccountTypeList1();
	}

	
	public List<SelectItem> getAccounts()
	{
		return getAccountsDao().getAccounts();
	}
	public List<SelectItem>  getAccount()
	{
		return getAccountsDao().getAccount();
	}
	public String getAccountName(Integer id1)
	{
		return getAccountsDao().getAccountName( id1);
	}
	public double getCreditBalance(Integer id1)
	{
		return getAccountsDao().getCreditBalance(id1);
	}

	public double getDebitBalance(Integer id1, Date openingdate, String str)
	{
		return getAccountsDao().getDebitBalance(id1,openingdate,str);
	}
	public int getAccountId(String str)
	{
		return getAccountsDao().getAccountId(str);
	}
	public String getAccountName1(Integer id1)
	{
		return getAccountsDao().getAccountName1(id1);
	}

	public List<InvoiceTransaction> listInvoiceTransaction(
			String str_Accounts, Date dat_From, Date dat_ToDate)
	{
		return getAccountsDao().listInvoiceTransaction(str_Accounts,dat_From,dat_ToDate);
	}
	public List<InvoiceTransaction> listInvoiceTransaction1(
			String str_Accounts, Date dat_FromDate, Date dat_ToDate)

	{
		return getAccountsDao().listInvoiceTransaction1(str_Accounts,dat_FromDate,dat_ToDate);
	}
	public String getStatus(String str_Accounts)
	{
		return getAccountsDao().getStatus(str_Accounts);
	}
	public List<Double> getTotalBalance()
	{
		return getAccountsDao().getTotalBalance();
	}
	public Character getChGroup(String str_AccountType)
	{
		return getAccountsDao().getChGroup(str_AccountType);	
		}
	public List<ManualJournal> getlistManualJournal()
	{
		return getAccountsDao().getlistManualJournal();
	}
	public List<ManualJournal> getlistManualJournal1(String str_Accounts, Date dat_FromDate, Date dat_ToDate)
	{
		return getAccountsDao().getlistManualJournal1(str_Accounts,dat_FromDate,dat_ToDate);
	}
	public ManualJournal getManualAccount(Integer id)
	{
		return (ManualJournal) getAccountsDao().getManualAccount(id);
	}
	public void updateManualJournal(ManualJournal journal)
	{
		getAccountsDao().updateManualJournal(journal);
	}
	public double getDebitAmount(Integer id)
	{
		return getAccountsDao().getDebitAmount(id);
	}
	public double getCreditAmount(Integer id)
	{
		return getAccountsDao().getCreditAmount(id);
	}
	public List<Expense> getExpenseList(String str, Date dat_FromDate, Date dat_ToDate)
	{
		return getAccountsDao().getExpenseList(str,dat_FromDate,dat_ToDate);
	}
	public List<ChartOfAccount> listAssets()
	{
		return getAccountsDao().listAssets();
	}
	public List<String> group()
	{
		return getAccountsDao().group();
	}
	public void updateClosingBalance(double debit, double credit, String str,double credit1)
	{
		getAccountsDao().updateClosingBalance(debit,credit,str,credit1);
	}
	
	public List<Expense> expenseList(Date dat_FromDate,Date dat_ToDate)
	{
		return getAccountsDao().expenseList(dat_FromDate,dat_ToDate);
	}
	public void addAccount(Account account)
	{
		getAccountsDao().addAccount(account);
	}
	public List<Account> listAccounts()
	{
		return getAccountsDao().listAccounts();
		
	}
	public List<String> listAccount()
	{
		return getAccountsDao().listAccount();
	}
	public List<AccountingGroup>  getAsset()
	{
		return getAccountsDao().getAsset();
	}

	public List<AccountingGroup> getRevenues()
	{
		return (List<AccountingGroup>)getAccountsDao().getRevenues();
	}

	public List<AccountingGroup> getLiabilities()
	{
		return (List<AccountingGroup>)getAccountsDao().getLiabilities();
	}

	public List<AccountingGroup> getExpense()
	{
		return (List<AccountingGroup>)getAccountsDao().getExpense();
	}
	public List<AccountingGroup> getGroups(char d)
	{
		return (List<AccountingGroup>)getAccountsDao().getGroups(d);
	}
	public void addAccountGroup(AccountingGroup account)
	{
		getAccountsDao().addAccountGroup(account);
	}
	public void deleteGroup(AccountingGroup account)
	{
		getAccountsDao().deleteGroup(account);
	}
	public void saveOpeningAccount(AccountsOpeningBalance balance)
	{
		getAccountsDao().saveOpeningAccount(balance);
	}
	public void addCustomized(customize customer)
	{
		getAccountsDao().addCustomized(customer);
	}
	public void deleteManualJournal(Integer id)
	{
		getAccountsDao().deleteManualJournal(id);
	}
	public List<InvoiceTransaction> listInvoiceTransaction2(Date dat_From, Date dat_To)
	{
		return (List<InvoiceTransaction>)getAccountsDao().listInvoiceTransaction2(dat_From,dat_To);
	}
	public List<Double> getExpenseAmount(Date dat_To)
	{
		return (List<Double>)getAccountsDao().getExpenseAmount(dat_To);
	}
	public List<Double> getIncomeAmount(Date dat_To)
	{
		return (List<Double>)getAccountsDao().getIncomeAmount(dat_To);
	}
	public List<ManualJournal> getlistManualJournal2(String str,Date dat_From, Date dat_To)
	{
		return getAccountsDao().getlistManualJournal2(str,dat_From, dat_To);
	}
	public List<ManualJournal> getlistManualJournal3(String str,Date dat_From, Date dat_To)
	{
		return getAccountsDao().getlistManualJournal3(str,dat_From, dat_To);
	}
	public double getCreditAmount(String str, Date dat_ToDate)
	{
		return getAccountsDao().getCreditAmount(str,dat_ToDate);
	}
	public double getDebitAmount(String str, Date dat_ToDate)
	{
		return getAccountsDao().getDebitAmount(str,dat_ToDate);
	}
	public List<ChartOfAccount> getAccountTypeList2()
	{
		return getAccountsDao().getAccountTypeList2();
	}
	public List<String> getIncome()
	{
		return getAccountsDao().getIncome();
	}

	public List<String> getExpense1()
	{
		return getAccountsDao().getExpense1();
	}
	public Date getOpeningDate()
	{
		return getAccountsDao().getOpeningDate();
	}
	
}
