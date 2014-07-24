package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.DueTransaction;

public interface DueService {

	public List<String> getAccountsList();

	public List<String> getDueTemplate();

	public void saveDueTransaction(DueTransaction due);

	public List<DueTransaction> listDueTransaction();

}
