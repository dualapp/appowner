package com.appowner.bean;

 import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;


import javax.faces.event.ValueChangeEvent;

import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.MessageTemplate;
import com.appowner.model.TaxTemplate;
import com.appowner.service.TemplateService;

@ManagedBean
@ViewScoped
public class TemplateBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{TemplateService}")
	private TemplateService templateService;
	public TemplateService getTemplateService() {
		return templateService;
	}
	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}
	private Integer int_DueTemplateID;
	public Integer getInt_DueTemplateID() {
		return int_DueTemplateID;
	}
	public void setInt_DueTemplateID(Integer int_DueTemplateID) {
		this.int_DueTemplateID = int_DueTemplateID;
	}

	public String getStr_DueTemplate() {
		return str_DueTemplate;
	}
	public void setStr_DueTemplate(String str_DueTemplate) {
		this.str_DueTemplate = str_DueTemplate;
	}
	public String getStr_Accounts() {
		return str_Accounts;
	}
	public void setStr_Accounts(String str_Accounts) {
		this.str_Accounts = str_Accounts;
	}
	public String getStr_Frequency() {
		return str_Frequency;
	}
	public void setStr_Frequency(String str_Frequency) {
		this.str_Frequency = str_Frequency;
	}
	public String getStr_Calculation() {
		return str_Calculation;
	}
	public void setStr_Calculation(String str_Calculation) {
		this.str_Calculation = str_Calculation;
	}
	public String getStr_Rate() {
		return str_Rate;
	}
	public void setStr_Rate(String str_Rate) {
		this.str_Rate = str_Rate;
	}
	public String getStr_TaxTemplate() {
		return str_TaxTemplate;
	}
	public void setStr_TaxTemplate(String str_TaxTemplate) {
		this.str_TaxTemplate = str_TaxTemplate;
	}
	private String str_Organisation;
	public String getStr_Organisation() {
		return str_Organisation;
	}
	public void setStr_Organisation(String str_Organisation) {
		this.str_Organisation = str_Organisation;
	}
	private String str_DueTemplate;
	private String str_Accounts;
	private String str_Frequency;
	private String str_Calculation;
	private String str_Rate;
	private String str_TaxTemplate;
	private List<String> ravenues;
	public List<String> getRavenues() {
		ravenues=new ArrayList<String>();
		ravenues.addAll(getTemplateService().listRavenues());
		return ravenues;
	}
	public void setRavenues(List<String> ravenues) {
		this.ravenues = ravenues;
	}
	private List<String> str_TaxTemplates;
	public List<String> getStr_TaxTemplates() {
		str_TaxTemplates=new ArrayList<String>();
		str_TaxTemplates.addAll(getTemplateService().getTaxName());
		return str_TaxTemplates;
	}
	public void setStr_TaxTemplates(List<String> str_TaxTemplates) {
		this.str_TaxTemplates = str_TaxTemplates;
	}
	private DueTemplate dueTemplate;

	public DueTemplate getDueTemplate() {
		return dueTemplate;
	}
	public void setDueTemplate(DueTemplate dueTemplate) {
		this.dueTemplate = dueTemplate;
	}
	public void getDueTemplate1()
	{
		dueTemplate=getTemplateService().getDueTemplate(int_DueTemplateID);
	}
	public String addDueTemplate()
	{
		try{
		DueTemplate duetemplate=new DueTemplate();
		duetemplate.setStr_Organisation(getStr_Organisation());
		duetemplate.setStr_Accounts(getStr_Accounts());
		duetemplate.setStr_Calculation(getStr_Calculation());
		duetemplate.setStr_DueTemplate(getStr_DueTemplate());
		duetemplate.setStr_Frequency(getStr_Frequency());
		duetemplate.setStr_Rate(getStr_Rate());
		duetemplate.setStr_TaxTemplate(getStr_TaxTemplate());
		getTemplateService().saveDueTemplate(duetemplate);
		return "Due Template.xhtml";
	   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	private List<DueTemplate> listDues;
	
	public List<DueTemplate> getListDues() {
		listDues=new ArrayList<DueTemplate>();
		listDues.addAll(getTemplateService().listDueTemplate());
		return listDues;
	}
	public void setListDues(List<DueTemplate> listDues) {
		this.listDues = listDues;
	}
	public String saveDueTemplate( ) {
		 
		//System.out.println(emp.getEmpId());
		
		getTemplateService().updateDueTemplate(dueTemplate);
			
		
		
		
		return "Due Template.xhtml";
	}
	//TAX TEMPLATE
	private Integer int_TaxTemplateID;
	public Integer getInt_TaxTemplateID() {
		return int_TaxTemplateID;
	}
	public void setInt_TaxTemplateID(Integer int_TaxTemplateID) {
		this.int_TaxTemplateID = int_TaxTemplateID;
	}
	public Integer getInt_Percentage() {
		return int_Percentage;
	}
	public void setInt_Percentage(Integer int_Percentage) {
		this.int_Percentage = int_Percentage;
	}
	public Integer getInt_TaxExemption() {
		return int_TaxExemption;
	}
	public void setInt_TaxExemption(Integer int_TaxExemption) {
		this.int_TaxExemption = int_TaxExemption;
	}
	public String getStr_TaxName() {
		return str_TaxName;
	}
	public void setStr_TaxName(String str_TaxName) {
		this.str_TaxName = str_TaxName;
	}
	private Integer int_Percentage;
	private Integer int_TaxExemption;
	private String str_TaxName;
	public String addTaxTemplate()
	{ try{
		TaxTemplate taxtemplate=new TaxTemplate();
		taxtemplate.setStr_Organisation(getStr_Organisation());
		taxtemplate.setInt_Percentage(getInt_Percentage());
		taxtemplate.setStr_TaxName(getStr_TaxName());
		taxtemplate.setInt_TaxExemption(getInt_TaxExemption());
		getTemplateService().saveTaxTemplate(taxtemplate);
		return "TaxTemplate.xhtml";
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	}
	private List<TaxTemplate> listTaxs;
	public List<TaxTemplate> getListTaxs() {
		listTaxs=new ArrayList<TaxTemplate>();
		listTaxs.addAll(getTemplateService().listTaxTemplate());
		return listTaxs;
	}
	public void setListTaxs(List<TaxTemplate> listTaxs) {
		this.listTaxs = listTaxs;
	}
	private TaxTemplate taxTemplate;
	public TaxTemplate getTaxTemplate() {
		return taxTemplate;
	}
	public void setTaxTemplate(TaxTemplate taxTemplate) {
		this.taxTemplate = taxTemplate;
	}
	public void getTaxTemplate1()
	{
		taxTemplate=getTemplateService().getTaxTemplate(int_TaxTemplateID);
	}
	public String saveTaxTemplate()
	{
		getTemplateService().updateTaxTemplate(taxTemplate);
		return "TaxTemplate.xhtml";
	}
	//INVOICE TEMPLATE
	private Integer int_InvoiceTemplateID;
	public Integer getInt_InvoiceTemplateID() {
		return int_InvoiceTemplateID;
	}
	public void setInt_InvoiceTemplateID(Integer int_InvoiceTemplateID) {
		this.int_InvoiceTemplateID = int_InvoiceTemplateID;
	}
	private String str_InvoiceTemplateName;
	private Boolean bl_Show;
	public String getStr_InvoiceTemplateName() {
		return str_InvoiceTemplateName;
	}
	public void setStr_InvoiceTemplateName(String str_InvoiceTemplateName) {
		this.str_InvoiceTemplateName = str_InvoiceTemplateName;
	}
	public Boolean getBl_Show() {
		return bl_Show;
	}
	public void setBl_Show(Boolean bl_Show) {
		this.bl_Show = bl_Show;
	}
	public String getStr_MessageCategory() {
		return str_MessageCategory;
	}
	public void setStr_MessageCategory(String str_MessageCategory) {
		this.str_MessageCategory = str_MessageCategory;
	}
	public String getStr_MessageTemplate() {
		return str_MessageTemplate;
	}
	public void setStr_MessageTemplate(String str_MessageTemplate) {
		this.str_MessageTemplate = str_MessageTemplate;
	}
	private String str_MessageCategory;
	private String str_MessageTemplate;
	public String addInvoiceTemplate()
	{ try{
		
	
	  InvoiceTemplate invoicetemplate=new InvoiceTemplate();
	  invoicetemplate.setStr_Organisation(getStr_Organisation());
	  invoicetemplate.setStr_InvoiceTemplateName(getStr_InvoiceTemplateName());
	  invoicetemplate.setBl_Show(getBl_Show());
	  invoicetemplate.setStr_Frequency(getStr_Frequency());
	  invoicetemplate.setStr_MessageCategory(getStr_MessageCategory());
	  invoicetemplate.setStr_MessageTemplate(getStr_MessageTemplate());
	  invoicetemplate.setStr_Description(getStr_Description());
	  getTemplateService().saveInvoiceTemplate(invoicetemplate);
	  return "InvoiceTemplate.xhtml";
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	}
	
	private List<InvoiceTemplate> listInvoices;
	
	
	public List<InvoiceTemplate> getListInvoices() {
		listInvoices=new ArrayList<InvoiceTemplate>();
		listInvoices.addAll(getTemplateService().listInvoiceTemplate());
		return listInvoices;
	}
	public void setListInvoices(List<InvoiceTemplate> listInvoices) {
		this.listInvoices = listInvoices;
	}
	private InvoiceTemplate invoiceTemplate;
	public InvoiceTemplate getInvoiceTemplate() {
		return invoiceTemplate;
	}
	public void setInvoiceTemplate(InvoiceTemplate invoiceTemplate) {
		this.invoiceTemplate = invoiceTemplate;
	}
	public void getInvoiceTemplate1()
	{
		invoiceTemplate=getTemplateService().getInvoiceTemplate(int_InvoiceTemplateID);
	}
	public String saveInvoiceTemplate()
	{
		getTemplateService().updateInvoiceTemplate(invoiceTemplate);
		return "InvoiceTemplate.xhtml";
	}
	//MESSAGE TEMPLATE
	private Integer int_MessageTemplateID;
	private String str_CreatedBy;
	private String str_Email;
	private String dat_Date;
	private String str_Mode;
	private String str_Category;
	private String str_Title;
	private String str_Description;
	public Integer getInt_MessageTemplateID() {
		return int_MessageTemplateID;
	}
	public void setInt_MessageTemplateID(Integer int_MessageTemplateID) {
		this.int_MessageTemplateID = int_MessageTemplateID;
	}
	public String getStr_CreatedBy() {
		return str_CreatedBy;
	}
	public void setStr_CreatedBy(String str_CreatedBy) {
		this.str_CreatedBy = str_CreatedBy;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getDat_Date() throws Exception{
		java.util.Date d=new java.util.Date();
		 SimpleDateFormat ft = 
			      new SimpleDateFormat ("dd-MM-yyyy");
		String str=ft.format(d);
		
		return str;
	}
	public void setDat_Date(String dat_Date) {
		this.dat_Date = dat_Date;
	}
	public String getStr_Mode() {
		return str_Mode;
	}
	public void setStr_Mode(String str_Mode) {
		this.str_Mode = str_Mode;
	}
	public String getStr_Category() {
		return str_Category;
	}
	public void setStr_Category(String str_Category) {
		this.str_Category = str_Category;
	}
	public String getStr_Title() {
		return str_Title;
	}
	public void setStr_Title(String str_Title) {
		this.str_Title = str_Title;
	}
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	public String addMessageTemplate()
	{
		try {
		MessageTemplate messagetemplate=new MessageTemplate();
		messagetemplate.setStr_CreatedBy(getStr_CreatedBy());
		messagetemplate.setStr_Email(getStr_Email());
		messagetemplate.setDat_Date(getDat_Date());
		messagetemplate.setStr_Category(getStr_Category());
		messagetemplate.setStr_Mode(getStr_Mode());
		messagetemplate.setStr_Title(getStr_Title());
		messagetemplate.setStr_Description(getStr_Description());
		getTemplateService().saveMessageTemplate(messagetemplate);
		return "MessageTemplate.xhtml";
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private List<MessageTemplate> listMessages;
	public List<MessageTemplate> getListMessages() {
		listMessages=new ArrayList<MessageTemplate>();
		listMessages.addAll(getTemplateService().listMessageTemplate());
		return listMessages;
	}
	public void setListMessages(List<MessageTemplate> listMessages) {
		this.listMessages = listMessages;
	}
	private MessageTemplate messageTemplate;
	public MessageTemplate getMessageTemplate() {
		return messageTemplate;
	}
	public void setMessageTemplate(MessageTemplate messageTemplate) {
		this.messageTemplate = messageTemplate;
	}
	public void getMessageTemplate1()
	{
		invoiceTemplate=getTemplateService().getInvoiceTemplate(int_MessageTemplateID);
	}
	public String saveMessageTemplate()
	{
		getTemplateService().updateMessageTemplate(messageTemplate);
		return "MessageTemplate.xhtml";
	}
}
