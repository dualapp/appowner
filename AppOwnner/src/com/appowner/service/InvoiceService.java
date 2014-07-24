package com.appowner.service;

import java.util.List;

import com.appowner.model.InvoiceTransaction;

public interface InvoiceService {
	
 public List<String> getInvoiceName();

public void saveInvoiceTransaction(InvoiceTransaction invoice);

public List<String> taxList();
}
