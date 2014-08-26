package com.appowner.service;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.AccountsDao;
import com.appowner.model.AccountsOpeningBalance;
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

}
