package com.appowner.dao;

import java.util.List;


import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ManualJournal;

public interface AccountsDao {
	public List<AccountsOpeningBalance> listOpeningBalance();
	public void addAccounts(Integer int_Accounts_OpeningID, Double int_Debit);
	public void saveAccounts(Integer int_Accounts_OpeningID, Double int_Credit);

	public void addManualJournal(ManualJournal journal);
}
