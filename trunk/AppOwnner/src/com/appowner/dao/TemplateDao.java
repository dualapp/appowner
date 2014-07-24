package com.appowner.dao;

import java.util.List;

import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.MessageTemplate;
import com.appowner.model.TaxTemplate;

public interface TemplateDao {
  public void saveDueTemplate(DueTemplate dueTemplate);
  public List<String> listRavenues();
  public void saveTaxTemplate(TaxTemplate taxTemplate);
  public void saveInvoiceTemplate(InvoiceTemplate invoiceTemplate);
  public void saveMessageTemplate(MessageTemplate messageTemplate);
  public List<DueTemplate> listDueTemplate();
  public List<InvoiceTemplate> listInvoiceTemplate();
  public List<TaxTemplate> listTaxTemplate();
  public List<MessageTemplate> listMessageTemplate();
public List<String> getTaxName();
public DueTemplate getDueTemplate(Integer int_DueTemplateID);
public void updateDueTemplate(DueTemplate dueTemplate);
public InvoiceTemplate getInvoiceTemplate(Integer int_InvoiceTemplateID);
public void updateInvoiceTemplate(InvoiceTemplate invoiceTemplate);
public TaxTemplate getTaxTemplate(Integer int_TaxTemplateID);
public void updateTaxTemplate(TaxTemplate taxTemplate);
public MessageTemplate getMessageTemplate(Integer int_MessageTemplateID);
public void updateMessageTemplate(MessageTemplate messageTemplate);
}
