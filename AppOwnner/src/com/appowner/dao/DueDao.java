package com.appowner.dao;

import java.util.List;

import com.appowner.model.DueTransaction;

public interface DueDao {
	public List<String> getAccountsList();

	public List<String> getDueTemplate();
	public List<DueTransaction> listDueTransaction();

	public void saveDueTransaction(DueTransaction due);
}
