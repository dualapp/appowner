package com.appowner.service;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.appowner.model.InvoiceTransaction;

public interface InvoiceService {
	
 public List<String> getInvoiceName();

public void saveInvoiceTransaction(InvoiceTransaction invoice);

public String taxList(String select);

public List<String> getTaxList(String str);

public List<InvoiceTransaction> listInvoiceTransaction(String str_InvoiceTemplate, String str_Block, String str_ApartmentNo, String str_Status, String str_BillPeriod);

public List<String> getBlockList(String str_Organisation);

public List<String> getApartmentlist(String str_Block);

public double getTaxAmount(String str1);

public double getSqft(String str);

public String getmailid(String str_ApartmentNo);

public List<String> getAccountName();

public void updatePayment(String accountName, String paymentMode, double totalBalance, double dueBalance, String str_Status, Integer id, Date dat_InvoiceDate, Date payment_Date, Integer payment_No, String deposite_Account_Name);

public InvoiceTransaction getInvoice(Integer int_InvoiceTransactionID);

public double getAmount(Integer id);

public void deleteInvoice(Integer id);

public List<String> getlistAccountName();

public void deleteDues(String str);

public String getStatus(int id);

public String getPeriod(String select);

public List<Double> getOutstandingBalance();

public List<InvoiceTransaction> listInvoiceTransaction1(String str_InvoiceTemplate, String str_Block, String str_ApartmentNo,
		Integer int_Year, String str_BillPeriod);
		


}
