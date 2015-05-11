package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.DueTransaction;

public interface DueService {

	public List<String> getAccountsList();

	public List<String> getDueTemplate(String ddd);

	public Integer saveDueTransaction(DueTransaction due);

	public List<DueTransaction> listDueTransaction(String str_DueTemplate, String str_Block, String str_ApartmentNo, String str_Period, String str_Status);

	public List<String> getBlockList(String str_Organisation);

	public List<String> getApartmentlist(String str_Block);

	public List<DueTransaction> listUserDueTransaction(String query);

	public DueTransaction getUserDueTransaction(Integer int_DueTransactionID);

	public double getDueAmount(String str_Block, String str_DueTemplate);

	public List <String> listRavenues();

	

	public List<Integer> getDueTemplate1(String invoiceNo);

	public double getDueAmount1(Integer str1);

	public void updateDueTransaction(String str_Status, Integer str1, double dueAmount, double paidAmount1);

	public void deleteDues(Integer id);

	public String getFrequency(String ddd);

	

	public void updateDue(Integer id, String int_InvoiceNo);

	public List<DueTransaction> listDueTransaction1(String str_DueTemplate, String str_Block, String str_ApartmentNo,String str_BillPeriod, Integer int_Year);

	public boolean getInvoiceNo(Integer id);

	public DueTransaction getDueTransaction(Integer int_DueTransactionID);

	public List<DueTransaction> listDueTransaction(String query);
			
			

	

}
