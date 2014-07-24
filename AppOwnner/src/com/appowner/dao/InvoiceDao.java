package com.appowner.dao;

import java.util.List;

import com.appowner.model.InvoiceTransaction;

public interface InvoiceDao {
 public List<String> getInvoiceName();

public void saveInvoiceTransaction(InvoiceTransaction invoice);

public List<String> taxList();
}
