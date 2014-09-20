package com.appowner.bean;

 import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.DualListModel;

import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.Complain;
import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.MessageTemplate;
import com.appowner.model.TaxTemplate;
import com.appowner.model.Vendor;
import com.appowner.service.TemplateService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped
public class TemplateBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//private static final String dueTemplate1="dueTemplate";
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
	
	public String getStr_TaxTemplate() {
		return str_TaxTemplate;
	}
	public void setStr_TaxTemplate(String str_TaxTemplate) {
		this.str_TaxTemplate = str_TaxTemplate;
	}
	private String str_Organisation;
	public String getStr_Organisation() {
		str_Organisation=Util.getAppartmentName();
		return str_Organisation;
	}
	public void setStr_Organisation(String str_Organisation) {
		this.str_Organisation = str_Organisation;
	}
	private String str_DueTemplate;
	private String str_Accounts;
	private String str_Frequency;
	private String str_Calculation;
	private Double str_Rate;
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
	    System.out.println(id);
	  
	 
	 
		   dueTemplate=getTemplateService().getDueTemplate(id);
	}
	public void getDueTemplate2()
	{   System.out.println(int_DueTemplateID);
	dueTemplate=getTemplateService().getDueTemplate(int_DueTemplateID);
	}
	 FacesContext facesContext = FacesContext.getCurrentInstance();
	public String addDueTemplate()
	{
		try{
		DueTemplate duetemplate=new DueTemplate();
		duetemplate.setStr_Organisation(getStr_Organisation());
		duetemplate.setStr_Accounts(getStr_Accounts());
		duetemplate.setStr_Calculation(getStr_Calculation());
		duetemplate.setStr_DueTemplate(getStr_DueTemplate());
		duetemplate.setStr_Frequency(getStr_Frequency());
		duetemplate.setStr_Rate(str_Rate);
		duetemplate.setStr_TaxTemplate(getStr_TaxTemplate());
		Integer yes=getTemplateService().saveDueTemplate(duetemplate);
		if(yes!=0)
			{
			 FacesContext facesContext = FacesContext.getCurrentInstance();
	           facesContext.addMessage(null, new FacesMessage("Informatin Saved Successfully!!!!!!!!!!!"));
	           return "infomation.xhtml?faces-redirect=true";
			}
		
	   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		  return "infomation.xhtml?faces-redirect=true";
	}
	
	public Double getStr_Rate() {
		return str_Rate;
	}
	public void setStr_Rate(Double str_Rate) {
		this.str_Rate = str_Rate;
	}
	private List<DueTemplate> listDues;
	
	public List<DueTemplate> getListDues() {
		listDues=new ArrayList<DueTemplate>();
	  	listDues.addAll(getTemplateService().listDueTemplate(str_Accounts));
		return listDues;
	}
	public void setListDues(List<DueTemplate> listDues) {
		this.listDues = listDues;
	}
	public String saveDueTemplate( ) {
		 
		//System.out.println(emp.getEmpId());
		
		getTemplateService().updateDueTemplate(dueTemplate);
			
		
		
		
		return "duetemplate.xhtml";
	}
  
   
	
	public String deleteDue(){
		DueTemplate dueTemplate=new DueTemplate();
		System.out.println(int_DueTemplateID);
	dueTemplate.setInt_DueTemplateID(int_DueTemplateID);
	getTemplateService().deleteDue(dueTemplate);
		return "duetemplate.xhtml?faces-redirect=true";
	  
	}
	public String deleteDueTemplate() {
	    List<DueTemplate> delete = new ArrayList<DueTemplate>();
   
	    for (DueTemplate template :selectedDueTemplate) {
	    	
	    	if (template.getInt_DueTemplateID()!=null) 
	    	{
	            delete.add(template);
	        }
	    	FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Vendor deleted Successfully!", "Vendor deleted Successfully!"));
	    } 
System.out.println(delete+"entyt todelete");
     getTemplateService().deleteDue1(delete);
	    return "duetemplate.xhtml?faces-redirect=true";
	}
    public String cancelDue() {
		return "duetemplate.xhtml?faces-redirect=true";
	}
    private HtmlDataTable updatedAccounts;
	public HtmlDataTable getUpdatedAccounts() {
		return updatedAccounts;
	}
	public void setUpdatedAccounts(HtmlDataTable updatedAccounts) {
		this.updatedAccounts = updatedAccounts;
	}
	private static Integer id;
	public static Integer getId() {
		return id;
	}
	public static void setId(Integer id) {
		TemplateBean.id = id;
	}
	private DataTable dataTable;
	public void processValueChange(ValueChangeEvent event)  
	        throws AbortProcessingException { 
		dueTemplate=(DueTemplate)dataTable.getRowData();
		id=dueTemplate.getInt_DueTemplateID();
		System.out.println(id);
	}
	private List<DueTemplate> selectedDueTemplate;

	
	
	
	public List<DueTemplate> getSelectedDueTemplate() {
		return selectedDueTemplate;
	}
	public void setSelectedDueTemplate(List<DueTemplate> selectedDueTemplate) {
		this.selectedDueTemplate = selectedDueTemplate;
	}
	public DataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}
	public String saveDueTemplate(DueTemplate dueTemplate) {
		if (dueTemplate.getInt_DueTemplateID() != null) {
			getTemplateService().updateDueTemplate(dueTemplate);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);

			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

		} else
			getTemplateService().saveDueTemplate(dueTemplate);
		return "duetemplate.xhtml";
	}
	//TAX TEMPLATE
	private Integer int_TaxTemplateID;
	public Integer getInt_TaxTemplateID() {
		return int_TaxTemplateID;
	}
	public void setInt_TaxTemplateID(Integer int_TaxTemplateID) {
		this.int_TaxTemplateID = int_TaxTemplateID;
	}
	
	public Double getInt_Percentage() {
		return int_Percentage;
	}
	public void setInt_Percentage(Double int_Percentage) {
		this.int_Percentage = int_Percentage;
	}
	public Double getInt_TaxExemption() {
		return int_TaxExemption;
	}
	public void setInt_TaxExemption(Double int_TaxExemption) {
		this.int_TaxExemption = int_TaxExemption;
	}
	public String getStr_TaxName() {
		return str_TaxName;
	}
	public void setStr_TaxName(String str_TaxName) {
		this.str_TaxName = str_TaxName;
	}
	private Double int_Percentage;
	private Double int_TaxExemption;
	private String str_TaxName;
	public String addTaxTemplate()
	{ try{
		TaxTemplate taxtemplate=new TaxTemplate();
		taxtemplate.setStr_Organisation(getStr_Organisation());
		taxtemplate.setInt_Percentage(getInt_Percentage());
		taxtemplate.setStr_TaxName(getStr_TaxName());
		taxtemplate.setInt_TaxExemption(getInt_TaxExemption());
	Integer yes=getTemplateService().saveTaxTemplate(taxtemplate);
		
		if(yes!=0)
		{
		 FacesContext facesContext = FacesContext.getCurrentInstance();
           facesContext.addMessage(null, new FacesMessage("Informatin Saved Successfully!!!!!!!!!!!"));
           return "infomation.xhtml?faces-redirect=true";
		}
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "infomation.xhtml?faces-redirect=true";
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
	public void getTaxTemplate2()
	{
		taxTemplate=getTemplateService().getTaxTemplate(id);
	}
	public String saveTaxTemplate()
	{
		getTemplateService().updateTaxTemplate(taxTemplate);
		return "taxtemplate.xhtml";
	}
	public String deleteTax(){
		TaxTemplate tax=new TaxTemplate();
		
		tax.setInt_TaxTemplateID(int_TaxTemplateID);
	getTemplateService().deleteTax(tax);
		return "taxtemplate.xhtml?faces-redirect=true";
	  
	}
	public String cancelTax()
	{
		return "taxtemplate.xhtml?faces-redirect=true";
	}
	 public void processValueChange3(ValueChangeEvent event)  
		        throws AbortProcessingException { 
	    	taxTemplate=(TaxTemplate)dataTable.getRowData();
			id=taxTemplate.getInt_TaxTemplateID();
			System.out.println(id);
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
	public String getStr_InvoiceTemplateName() {
		return str_InvoiceTemplateName;
	}
	public void setStr_InvoiceTemplateName(String str_InvoiceTemplateName) {
		this.str_InvoiceTemplateName = str_InvoiceTemplateName;
	}
	private Boolean bl_Show;

	
	
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
	public String getStr_description() {
		
		return description;
	}
	public void setStr_description(String str_description) {
		this.str_description = str_description;
	}
	@SuppressWarnings("unused")
	private String str_description;
	
	private List<String> str_DueInvoiceTemplate;
	public List<String> getStr_DueInvoiceTemplate() {
		
		return str_DueInvoiceTemplate;
		
	}
	public void setStr_DueInvoiceTemplate(List<String> str_DueInvoiceTemplate) {
		this.str_DueInvoiceTemplate = str_DueInvoiceTemplate;
	}
	
	private String str1_Frequency;
	public String getStr1_Frequency() {
		return str1_Frequency;
	}
	public void setStr1_Frequency(String str1_Frequency) {
		this.str1_Frequency = str1_Frequency;
	}
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
	  invoicetemplate.setStr_DueInvoiceTemplate(str);
	 Integer yes=getTemplateService().saveInvoiceTemplate(invoicetemplate);
	  if(yes!=0)
		{
		 FacesContext facesContext = FacesContext.getCurrentInstance();
         facesContext.addMessage(null, new FacesMessage("Informatin Saved Successfully!!!!!!!!!!!"));
         return "infomation.xhtml?faces-redirect=true";
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "infomation.xhtml?faces-redirect=true";
	}
	private List<String> str_MessageTemplate1;
	public List<String> getStr_MessageTemplate1() {
		str_MessageTemplate1=new ArrayList<String>();
		str_MessageTemplate1= getTemplateService().getMessageTemplate();
		
		return str_MessageTemplate1;
	}
	
	
	
	public void setStr_MessageTemplate1(List<String> str_MessageTemplate1) {
		this.str_MessageTemplate1 = str_MessageTemplate1;
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
	public void getInvoiceTemplate2()
	{   System.out.println(id);
		invoiceTemplate=getTemplateService().getInvoiceTemplate(id);
	}
	public String saveInvoiceTemplate()
	{
		getTemplateService().updateInvoiceTemplate(invoiceTemplate);
		return "invoicetemplate.xhtml";
	}
	private List<String> dueTemplates;
	public List<String> getDueTemplates() {
		
	        return dueTemplates;
	}
	public void setDueTemplates(List<String> dueTemplates) {
		this.dueTemplates = dueTemplates;
	}
  public List<String> frequencyChangeListener(ValueChangeEvent event)
  {
	   str1_Frequency=(String)event.getNewValue();
	    dueTemplates=new ArrayList<String>();
	     dueTemplates.addAll(getTemplateService().getDueTemplate(str1_Frequency));
	        return dueTemplates;
		
	}
     @SuppressWarnings("rawtypes")
	 List list1=new ArrayList();
	@SuppressWarnings("rawtypes")
	public List getList1() {
		return list1;
	}
	@SuppressWarnings("rawtypes")
	public void setList1(List list1) {
		this.list1 = list1;
	}
	private String str;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	private String Str1;
	
	public String getStr1() {
		return Str1;
	}
	public void setStr1(String str1) {
		Str1 = str1;
	}
	@SuppressWarnings("unchecked")
	public void roleChangeListener(ValueChangeEvent event)
	{   System.out.println("hi");
		list1.addAll((List<String>)event.getNewValue());
		System.out.println(list1);
		StringBuilder out = new StringBuilder();
		for (Object o : list1)
		{
		  out.append(o.toString());
		  out.append(",");
		}
		str=out.toString();
	System.out.println(str);	
	//	Str1 = str.substring(0, str.lastIndexOf(","));
//	System.out.println(Str1);
		}
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String templateChangeListener(ValueChangeEvent event)
	{
		String str=(String)event.getNewValue();
		description=getTemplateService().getDescription(str);
		return description;
		
	}
	public String deleteInvoice(){
		InvoiceTemplate invoice=new InvoiceTemplate();
		System.out.println(int_DueTemplateID);
		invoice.setInt_InvoiceTemplateID(int_InvoiceTemplateID);
	getTemplateService().deleteInvoice(invoice);
		return "invoicetemplate.xhtml?faces-redirect=true";
	  
	}
	public String deleteInvoice1(){
		InvoiceTemplate invoice=new InvoiceTemplate();
		System.out.println(int_DueTemplateID);
		invoice.setInt_InvoiceTemplateID(id);
	getTemplateService().deleteInvoice(invoice);
		return "invoicetemplate.xhtml?faces-redirect=true";
	  
	}
	
    public String cancelInvoice() {
		return "invoicetemplate.xhtml?faces-redirect=true";
	}
    public void processValueChange1(ValueChangeEvent event)  
	        throws AbortProcessingException { 
    	invoiceTemplate=(InvoiceTemplate)dataTable.getRowData();
		id=invoiceTemplate.getInt_InvoiceTemplateID();
		System.out.println(id);
	}
	
	//MESSAGE TEMPLATE
	private Integer int_MessageTemplateID;
	private String str_CreatedBy;
	private String str_Email;
	@SuppressWarnings("unused")
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
		str_CreatedBy=Util.getUserName();
		return str_CreatedBy;
	}
	public void setStr_CreatedBy(String str_CreatedBy) {
		this.str_CreatedBy = str_CreatedBy;
	}
	public String getStr_Email() {
		str_Email=Util.getEmailId();
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
	Integer yes=getTemplateService().saveMessageTemplate(messagetemplate);
		if(yes!=0)
		{
		 FacesContext facesContext = FacesContext.getCurrentInstance();
         facesContext.addMessage(null, new FacesMessage("Informatin Saved Successfully!!!!!!!!!!!"));
         return "infomation.xhtml?faces-redirect=true";
		}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return "infomation.xhtml?faces-redirect=true";
	}
	private List<MessageTemplate> listMessages;
	public List<MessageTemplate> getListMessages() {
		listMessages=new ArrayList<MessageTemplate>();
		listMessages.addAll(getTemplateService().listMessageTemplate(str_Mode,str_Category));
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
	{   System.out.println(int_MessageTemplateID);
		messageTemplate=getTemplateService().getMessageTemplate(int_MessageTemplateID);
	}
	public void getMessageTemplate2()
	{   System.out.println(int_MessageTemplateID);
		messageTemplate=getTemplateService().getMessageTemplate(id);
	}
	public String saveMessageTemplate()
	{
		getTemplateService().updateMessageTemplate(messageTemplate);
		return "messagetemplate.xhtml?faces-redirect=true";
	}
	public String messageSerch()
	{
		listMessages=new ArrayList<MessageTemplate>();
		listMessages.addAll(getTemplateService().listMessageTemplate(str_Mode,str_Category));
		return "messagetemplate.xhtml";
	}
	public String deleteMessage(){
		MessageTemplate message=new MessageTemplate();
		System.out.println(int_DueTemplateID);
		message.setInt_MessageTemplateID(int_MessageTemplateID);
	getTemplateService().deleteMessage(message);
		return "messagetemplate.xhtml?faces-redirect=true";
	  
	}
	public String cancelMessage()
	{
		return "messageTemplate.xhtml";
	}
	  public void processValueChange2(ValueChangeEvent event)  
		        throws AbortProcessingException { 
	    	messageTemplate=(MessageTemplate)dataTable.getRowData();
			id=messageTemplate.getInt_MessageTemplateID();
			System.out.println(id);
		}
	
}
