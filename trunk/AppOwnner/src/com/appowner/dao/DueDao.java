package com.appowner.dao;

import java.util.List;

import com.appowner.model.DueTransaction;

public interface DueDao {
	public List<String> getAccountsList();

	public List<String> getDueTemplate();
	public List<DueTransaction> listDueTransaction(String str_DueTemplate, String str_Block, String str_ApartmentNo, String str_Period, String str_Status);

	public Integer saveDueTransaction(DueTransaction due);

	public List<String> getBlockList(String str_Organisation);

	public List<String> getApartmentlist(String str_Block);

	public List<DueTransaction> listUserDueTransaction(String str_ApartmentNo, String str_ApartmentNo1, String str_Status, String str_Period, String str_DueTemplate);

	public DueTransaction getUserDueTransaction(Integer int_DueTransactionID);

	public double getDueAmount(String str_Block, String str_DueTemplate);

	public List<String> listRavenues();

	

	public List<Integer> getDueTemplate1(String invoiceNo);

	public double getDueAmount1(Integer str1);

	public void updateDueTransaction(String str_Status, Integer str1, double ddd);

	
}
