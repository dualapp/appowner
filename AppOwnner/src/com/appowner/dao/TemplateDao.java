package com.appowner.dao;

import java.util.List;

import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.MessageTemplate;
import com.appowner.model.TaxTemplate;

public interface TemplateDao {
  public Integer saveDueTemplate(DueTemplate dueTemplate);
  public List<String> listRavenues();
  public Integer saveTaxTemplate(TaxTemplate taxTemplate);
  public Integer saveInvoiceTemplate(InvoiceTemplate invoiceTemplate);
  public Integer saveMessageTemplate(MessageTemplate messageTemplate);
  public List<DueTemplate> listDueTemplate(String str_Accounts);
  public List<InvoiceTemplate> listInvoiceTemplate();
  public List<TaxTemplate> listTaxTemplate();
  public List<MessageTemplate> listMessageTemplate(String str_Mode, String str_Category);
public List<String> getTaxName();
public DueTemplate getDueTemplate(Integer int_DueTemplateID);
public void updateDueTemplate(DueTemplate dueTemplate);
public InvoiceTemplate getInvoiceTemplate(Integer int_InvoiceTemplateID);
public void updateInvoiceTemplate(InvoiceTemplate invoiceTemplate);
public TaxTemplate getTaxTemplate(Integer int_TaxTemplateID);
public void updateTaxTemplate(TaxTemplate taxTemplate);
public MessageTemplate getMessageTemplate(Integer int_MessageTemplateID);
public void updateMessageTemplate(MessageTemplate messageTemplate);
public List<String> getDueTemplate( String frequency);
public List<String> getMessageTemplate();
public String getDescription(String str);
public List<DueTemplate> searchDueTemplate(String account);
public void deleteDue(DueTemplate dueTemplate);
public void deleteInvoice(InvoiceTemplate invoice);
public void deleteMessage(MessageTemplate message);
public void deleteTax(TaxTemplate tax);
public void deleteDue1(List<DueTemplate> delete);
public void deleteInvoice1(List<InvoiceTemplate> delete);
public void deleteMessage1(List<MessageTemplate> delete);
public void deleteTax1(List<TaxTemplate> delete);
public String detectDueTemplate(String str);
}
