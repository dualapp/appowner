package com.appowner.service;

import java.util.List;

import com.appowner.model.DueTransaction;

public interface DueService {

	public List<String> getAccountsList();

	public List<String> getDueTemplate();

	public void saveDueTransaction(DueTransaction due);

	public List<DueTransaction> listDueTransaction();

	public List<String> getBlockList(String str_Organisation);

	public List<String> getApartmentlist(String str_Block);

	public List<DueTransaction> listUserDueTransaction(String str_ApartmentNo);

	public DueTransaction getUserDueTransaction(Integer int_DueTransactionID);

}
