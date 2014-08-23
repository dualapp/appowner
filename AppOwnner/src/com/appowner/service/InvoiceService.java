package com.appowner.service;


import java.util.Collection;
import java.util.List;

import com.appowner.model.InvoiceTransaction;

public interface InvoiceService {
	
 public List<String> getInvoiceName();

public void saveInvoiceTransaction(InvoiceTransaction invoice);

public String taxList(String select);

public List<String> getTaxList(String str);

public List<InvoiceTransaction> listInvoiceTransaction();

public List<String> getBlockList(String str_Organisation);

public List<String> getApartmentlist(String str_Block);
}
