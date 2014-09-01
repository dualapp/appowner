package com.appowner.dao;

import java.util.Date;
import java.util.List;







import javax.faces.model.SelectItem;

import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.ManualJournal;

public interface AccountsDao {
	public List<AccountsOpeningBalance> listOpeningBalance();
	public void addAccounts(Integer int_Accounts_OpeningID, Double int_Debit);
	public void saveAccounts(Integer int_Accounts_OpeningID, Double int_Credit);

	public void addManualJournal(ManualJournal journal);
	
	public void addBalance(Date date, Integer id1, Integer id);
	void saveChartOfAccount(ChartOfAccount chartOfAccount);

	List<ChartOfAccount> getChartOfAccountList();

	List<Character> getCh_AccountGroup();

	List<String> getAccountTypeList(Character l);
	public List<SelectItem> getAccounts();
	public List<SelectItem> getAccount();
}
