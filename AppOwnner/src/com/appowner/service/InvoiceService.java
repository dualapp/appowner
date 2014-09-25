package com.appowner.service;


import java.util.Collection;
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

public void updatePayment(String accountName, String str_Status, Integer id, String dat_InvoiceDate);

public InvoiceTransaction getInvoice(Integer int_InvoiceTransactionID);
}
