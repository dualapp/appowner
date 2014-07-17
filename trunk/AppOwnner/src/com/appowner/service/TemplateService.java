package com.appowner.service;

import java.util.List;

import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.MessageTemplate;
import com.appowner.model.TaxTemplate;

public interface TemplateService {
 public void saveDueTemplate(DueTemplate dueTemplate);
 public List<String> listRavenues();
 public void saveTaxTemplate(TaxTemplate taxTemplate);
 public void saveInvoiceTemplate(InvoiceTemplate invoiceTemplate);
 public void saveMessageTemplate(MessageTemplate messageTemplate);

}
