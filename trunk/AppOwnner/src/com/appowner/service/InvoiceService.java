package com.appowner.service;


import java.util.List;

import com.appowner.model.InvoiceTransaction;

public interface InvoiceService {
	
 public List<String> getInvoiceName();

public void saveInvoiceTransaction(InvoiceTransaction invoice);

public String taxList(String select);

public List<String> getTaxList(String str);

public List<InvoiceTransaction> listInvoiceTransaction();
}
