package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ComplainDao;
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
}
