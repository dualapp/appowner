package com.appowner.service;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.AccountsDao;
import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;

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
	public List<AccountsOpeningBalance> listOpeningBalance()
	{
		return getAccountsDao().listOpeningBalance();
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
	public void addBalance(Date date, Integer id1, Integer id)
	{
		getAccountsDao().addBalance(date, id1,id);
	}
	

	@Override
	public void saveChartOfAccount(ChartOfAccount chartOfAccount) {
		// TODO Auto-generated method stub
		getAccountsDao().saveChartOfAccount(chartOfAccount);
	}

	@Override
	public List<ChartOfAccount> getChartOfAccountList() {
		// TODO Auto-generated method stub
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
	public List<String> getAccountTypeList(Character l){
		
		return getAccountsDao().getAccountTypeList(l);
	}
	public List<String> getAccountTypeList1(Character k)
	{
		return getAccountsDao().getAccountTypeList1(k);
	}

	@Override
	public List<String> getAccountTypeList() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<SelectItem> getAccounts()
	{
		return getAccountsDao().getAccounts();
	}
	public List<SelectItem> getAccount()
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

	public double getDebitBalance(Integer id1)
	{
		return getAccountsDao().getDebitBalance(id1);
	}
	public int getAccountId(String str)
	{
		return getAccountsDao().getAccountId(str);
	}
	public String getAccountName1(Integer id1)
	{
		return getAccountsDao().getAccountName1(id1);
	}

	public List<InvoiceTransaction> listInvoiceTransaction(String str_Accounts)
	{
		return getAccountsDao().listInvoiceTransaction(str_Accounts);
	}
	public String getStatus(String str_Accounts)
	{
		return getAccountsDao().getStatus(str_Accounts);
	}





}
