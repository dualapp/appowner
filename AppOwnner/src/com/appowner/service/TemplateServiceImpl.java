package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.TemplateDao;
import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.MessageTemplate;
import com.appowner.model.TaxTemplate;

/**
 * @author priya
 *
 */
@Service("TemplateService")
@Transactional 
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	private TemplateDao templateDao;

	public TemplateDao getTemplateDao() {
		return templateDao;
	}

	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}
	public void saveDueTemplate(DueTemplate dueTemplate)
	{
		getTemplateDao().saveDueTemplate(dueTemplate);
	}
	public List<String> listRavenues()
	{
		return getTemplateDao().listRavenues();
	}
	public void saveTaxTemplate(TaxTemplate taxTemplate)
	{
		getTemplateDao().saveTaxTemplate(taxTemplate);
	}
	public void saveInvoiceTemplate(InvoiceTemplate invoiceTemplate)
	{
		getTemplateDao().saveInvoiceTemplate(invoiceTemplate);
	}
	public void saveMessageTemplate(MessageTemplate messageTemplate)
	{
		getTemplateDao().saveMessageTemplate(messageTemplate);
	}
	public List<DueTemplate>  listDueTemplate(String str_Accounts)
	{
		return getTemplateDao().listDueTemplate(str_Accounts);
	}
	public List<InvoiceTemplate> listInvoiceTemplate(){
		return getTemplateDao().listInvoiceTemplate();
	}
	public List<TaxTemplate> listTaxTemplate()
	{
		return getTemplateDao().listTaxTemplate();
	}
	 public List<MessageTemplate> listMessageTemplate(String str_Mode, String str_Category)
	  {
		  return getTemplateDao().listMessageTemplate(str_Mode,str_Category);  
	  }
	  public List<String> getTaxName()
	  {
		  return getTemplateDao().getTaxName(); 
	  }
	  public DueTemplate getDueTemplate(Integer int_DueTemplateID){
		  return getTemplateDao().getDueTemplate(int_DueTemplateID);
	  }
	  public void updateDueTemplate(DueTemplate dueTemplate)
	  {
		  getTemplateDao().updateDueTemplate(dueTemplate);
	  }
	  public InvoiceTemplate getInvoiceTemplate(Integer int_InvoiceTemplateID)
	  {
		  return getTemplateDao().getInvoiceTemplate(int_InvoiceTemplateID);
	  }
	  public void updateInvoiceTemplate(InvoiceTemplate invoiceTemplate)
	  {
		  getTemplateDao().updateInvoiceTemplate(invoiceTemplate);
	  }
	  public TaxTemplate getTaxTemplate(Integer int_TaxTemplateID)
	  {
		  return getTemplateDao().getTaxTemplate(int_TaxTemplateID);
	  }
	  public void updateTaxTemplate(TaxTemplate taxTemplate)
	  {
		  getTemplateDao().updateTaxTemplate(taxTemplate);
	  }
	  public MessageTemplate getMessageTemplate(Integer int_MessageTemplateID)
	  {
		  return getTemplateDao().getMessageTemplate(int_MessageTemplateID);
	  }
	  public void updateMessageTemplate(MessageTemplate messageTemplate)
	  {
		  getTemplateDao().updateMessageTemplate(messageTemplate);
	  }
	  public List<String> getDueTemplate(String frequency)
	  {
		  return getTemplateDao().getDueTemplate(frequency);
	  }
	  public List<String> getMessageTemplate()
	  {
		  return getTemplateDao().getMessageTemplate(); 
	  }
	  public String getDescription(String str)
	  {
		  return getTemplateDao().getDescription(str); 
	  }
	  public List<DueTemplate> searchDueTemplate(String account)
	  {
		  return getTemplateDao().searchDueTemplate(account);
	  }
	  public void deleteDue(DueTemplate dueTemplate)
	  {
		   getTemplateDao().deleteDue(dueTemplate);
	  }
	  public void deleteInvoice(InvoiceTemplate invoice)
	  {
		  getTemplateDao().deleteInvoice(invoice);
	  }
	
	  
	  
}
