package com.appowner.bean;

 import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectcheckboxmenu.SelectCheckboxMenu;
import org.primefaces.component.selectmanycheckbox.SelectManyCheckbox;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.Complain;
import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.MessageTemplate;
import com.appowner.model.TaxTemplate;
import com.appowner.model.Vendor;
import com.appowner.service.TemplateService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped

public class TemplateBean implements Serializable,Validator {
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
	@PostConstruct
	public void init() {
		str_Calculation="Sqft";
	
	}
	
	public String getStr_TaxTemplate() {
		return str_TaxTemplate;
	}
	public void setStr_TaxTemplate(String str_TaxTemplate) {
		this.str_TaxTemplate = str_TaxTemplate;
	}
	private Integer int_Organisation;
	public Integer getInt_Organisation() {
		int_Organisation=Util.getAppartmentId();
		
		return int_Organisation;
	}
	public void setInt_Organisation(Integer int_Organisation) {
		this.int_Organisation = int_Organisation;
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
	private double str_Rate;
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
	private DueTemplate dueTemplate1=new DueTemplate();

	
	
	
	
	public void setDueTemplate1(DueTemplate dueTemplate1) {
		this.dueTemplate1 = dueTemplate1;
	}
	
	public DueTemplate getDueTemplate1() {
		return dueTemplate1;
	}
	public void getDueTemplate2(int id1)
	{  System.out.println(id1+"jdskjfd");
	   dueTemplate1=getTemplateService().getDueTemplate(id1);
	  
	}
	public void validate1(FacesContext context, UIComponent component,
	           Object value) throws ValidatorException { 
	     
	      
	      InputText inputtext=(InputText) component;
	      System.out.println( inputtext.getSubmittedValue());
	      double amount2= Double.parseDouble((String) inputtext.getSubmittedValue());
	      if(amount2==0.0) {
				FacesMessage msg
		          = new FacesMessage();
				 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			        throw new ValidatorException(msg);
			}
			else
			{   
				
			}
	    
	 
} 
	public String addDueTemplate()
	{  
		try{
		DueTemplate duetemplate3=new DueTemplate();
		
		duetemplate3.setInt_Organisation(getInt_Organisation());
		
		duetemplate3.setStr_Accounts(getStr_Accounts());
		duetemplate3.setStr_Calculation(getStr_Calculation());
	
		duetemplate3.setStr_DueTemplate(getStr_DueTemplate());
		duetemplate3.setStr_Frequency(getStr_Frequency());
		duetemplate3.setStr_Rate(str_Rate);
		
		if(str_TaxTemplate.isEmpty())
		{
			str_TaxTemplate="None";
		}
		duetemplate3.setStr_TaxTemplate(str_TaxTemplate);
		getTemplateService().saveDueTemplate(duetemplate3);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," DueTemplate  added Successfully!", " DueTemplate added Successfully!"));
		return "duetemplate.xhtml";
		}
		catch(Exception e)
				{
			            e.printStackTrace();
				}
		return "duetemplate.xhtml";
	}
	
	public Double getStr_Rate() {
		return str_Rate;
	}
	public void setStr_Rate(Double str_Rate) {
		this.str_Rate = str_Rate;
	}
	private List<DueTemplate> listDues;
	
	public List<DueTemplate> getListDues() {
		try
		{
			listDues=new ArrayList<DueTemplate>();
		 if(str_Accounts==null  )
			{  
				query="";
			}
			 
		    
			 if(!(str_Accounts==null) && !(str_Accounts.isEmpty()) )
			{
				query=query+"str_Accounts="+"'"+str_Accounts+"'";
			}
		 
	    
			
			if(query.indexOf("and")==1)
			{   
			  
			   query=query.replaceFirst("and","" );
	                   
			}
			
			}
	
			catch(Exception e)
			{
				e.printStackTrace();
			}
		listDues.addAll(getTemplateService().listDueTemplate(query));
			query="";
		
		
		Collections.sort(listDues);
		return listDues;
	}
	public void setListDues(List<DueTemplate> listDues) {
		this.listDues = listDues;
	}
	public String saveDueTemplate() {
		 
	
	
	if(dueTemplate1.getStr_Calculation().equalsIgnoreCase("None"))
	{
		dueTemplate1.setStr_Rate(0.00);
	}
		getTemplateService().updateDueTemplate(dueTemplate1);
		
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully!"));
		
		
		 return "duetemplate.xhtml?faces-redirect=true";
	}
	
	
   
	
	public String deleteDue(DueTemplate dueTemplate){
		
	
		System.out.println(dueTemplate.getInt_DueTemplateID()+"dhhjhjf");
		dueTemplate.setInt_DueTemplateID(dueTemplate.getInt_DueTemplateID());
		 String str=dueTemplate.getStr_DueTemplate();
    	 System.out.println(str+"fjfgvkjgfjkgfjk");
 	    boolean id1=getTemplateService().detectDueTemplate(str);
 	    System.out.println(id1+"jffkjfj");
 	   FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
 	    if(id1==true)
 	    {
 	    	 facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cannot delete Due Template. Delete the due instances and try again.", "Cannot delete Due Template. Delete the due instances and try again."));
 	    }
 	    else
 	    {
	     getTemplateService().deleteDue(dueTemplate);
	     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
 	    }
		return "duetemplate.xhtml?faces-redirect=true";
	  
	}
	private boolean indicator;
	public boolean isIndicator() {
		return indicator;
	}
	public void setIndicator(boolean indicator) {
		this.indicator = indicator;
	}
	public String deleteDueTemplate() {
		try
		   {
			if(indicate==false)
					{
				FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
				return "duetemplate.xhtml?faces-redirect=true";
					}
			else
			{
	    DueTemplate delete = new DueTemplate();
	 
	   FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		delete.setInt_DueTemplateID(selectedDueTemplate.getInt_DueTemplateID());
	   
	    	 String str=selectedDueTemplate.getStr_DueTemplate();
	    	 
	 	    boolean id=getTemplateService().detectDueTemplate(str);
	 	   
	 	    if(id==true)
	 	    {
	 	    	indicator=true;
	 	    }
	   
	   
	    if(indicator==true)	
	    {
	    	 facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cannot delete Due Template. Delete the due instances and try again.", "Cannot delete Due Template. Delete the due instances and try again."));	
	    }
			
	    else
	    {
        getTemplateService().deleteDue(delete);
    
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"DueTemplate deleted Successfully!", "DueTemplate deleted Successfully!"));
     
	    }
			}
		   }
			catch(Exception e)
			{
				e.printStackTrace();
			}
    return "duetemplate.xhtml?faces-redirect=true";
	}
    public String cancelDue() {
		return "duetemplate.xhtml?faces-redirect=true";
	}
   
	private static Integer id;
	public static Integer getId() {
		return id;
	}
	public static void setId(Integer id) {
		TemplateBean.id = id;
	}
	
	private DueTemplate selectedDueTemplate;
	public String frequencyChangeListener1(ValueChangeEvent event)
	{ 
		str_Calculation=(String) event.getNewValue();
		
		return str_Calculation;
		
	}
	
	
	
	
	
	public DueTemplate getSelectedDueTemplate() {
		return selectedDueTemplate;
	}
	public void setSelectedDueTemplate(DueTemplate selectedDueTemplate) {
		this.selectedDueTemplate = selectedDueTemplate;
	}
	public String saveDueTemplate(DueTemplate dueTemplate) {
		if (dueTemplate.getInt_DueTemplateID() != null) {
			
			if(dueTemplate.getStr_Calculation().equalsIgnoreCase("None"))
			{   
				dueTemplate.setStr_Rate(0.00);
			}
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
		taxtemplate.setInt_Organisation(getInt_Organisation());
		taxtemplate.setInt_Percentage(getInt_Percentage());
		taxtemplate.setStr_TaxName(getStr_TaxName());
		taxtemplate.setInt_TaxExemption(getInt_TaxExemption());
	    getTemplateService().saveTaxTemplate(taxtemplate);
	    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("TaxTemplate Saved Successfully!"));
		
         
           return "taxtemplate.xhtml?faces-redirect=true";
		
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	   return "taxtemplate.xhtml?faces-redirect=true";
	}
	private List<TaxTemplate> listTaxs;
	
	public List<TaxTemplate> getListTaxs() {
		try
		{
			listTaxs=new ArrayList<TaxTemplate>();
			 if(str_TaxTemplate==null )
				{ 
					query="";
				}
				 
			    
				 if(!(str_TaxTemplate==null) && !(str_TaxTemplate.isEmpty()) )
				{
					query=query+"str_TaxName="+"'"+str_TaxTemplate+"'";
				}
			 
				
				if(query.indexOf("and")==1)
				{   
				  
				   query=query.replaceFirst("and","" );
		                   
				}
				
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
		listTaxs.addAll(getTemplateService().listTaxTemplate(query));
				query="";
			
			
			Collections.sort(listTaxs);
			
		return listTaxs;
	}
	
	
	public void setListTaxs(List<TaxTemplate> listTaxs) {
		this.listTaxs = listTaxs;
	}
	private TaxTemplate taxTemplate=new TaxTemplate();
	public TaxTemplate getTaxTemplate() {
		return taxTemplate;
	}
	public void setTaxTemplate(TaxTemplate taxTemplate) {
		this.taxTemplate = taxTemplate;
	}
	public void getTaxTemplate1(String str)
	{  
	System.out.println(str+"fdkfkjgfk");
		int id1=getTemplateService().getTaxID(str);
	System.out.println(id1+"cfkjjkdf");
		taxTemplate=getTemplateService().getTaxTemplate(id1);
	}
	public void getTaxTemplate1(int id1)
	{
		taxTemplate=getTemplateService().getTaxTemplate(id1);
	}
	
	public String saveTaxTemplate()
	{
		getTemplateService().updateTaxTemplate(taxTemplate);
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully!"));  
		return "taxtemplate.xhtml";
	}
	public String deleteTax(TaxTemplate tax){
		
		
		
		 boolean id1=getTemplateService().detectTaxTemplate(tax.getStr_TaxName());
	  	    
	  	   
	  	   FacesContext facesContext = FacesContext.getCurrentInstance();
	 		Flash flash = facesContext.getExternalContext().getFlash();
	 		flash.setKeepMessages(true);
	 		flash.setRedirect(true);
	  	    if(id1==true)
	  	    {
	  	    	 facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cannot delete Tax Template. Delete the due instances and try again.", "Cannot delete Tax Template. Delete the due instances and try again."));
	  	    }
	  	    else
	  	    {
	  getTemplateService().deleteTax(tax);
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
		
	  
	}
	  	  return "taxtemplate.xhtml?faces-redirect=true";
	}
	public String cancelTax()
	{
		return "taxtemplate.xhtml?faces-redirect=true";
	}
	private TaxTemplate selectedTaxTemplate;
	
	public TaxTemplate getSelectedTaxTemplate() {
		return selectedTaxTemplate;
	}
	public void setSelectedTaxTemplate(TaxTemplate selectedTaxTemplate) {
		this.selectedTaxTemplate = selectedTaxTemplate;
	}
	public String saveTaxTemplate(TaxTemplate taxTemplate) {
			if (taxTemplate.getInt_TaxTemplateID()!= null) {
				getTemplateService().updateTaxTemplate(taxTemplate);
				FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);

				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

			} else
				getTemplateService().saveTaxTemplate(taxTemplate);
			return "taxtemplate.xhtml";
		}
	    public String deleteTaxTemplate() {
	    	try
			   {
				if(indicate==false)
						{
					FacesContext facesContext = FacesContext.getCurrentInstance();
					Flash flash = facesContext.getExternalContext().getFlash();
					flash.setKeepMessages(true);
					flash.setRedirect(true);
					facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
					return "taxtemplate.xhtml?faces-redirect=true";
						}
				else
				{
		    TaxTemplate delete = new TaxTemplate();
	         delete.setInt_TaxTemplateID(selectedTaxTemplate.getInt_TaxTemplateID());
	         boolean id1=getTemplateService().detectTaxTemplate(selectedTaxTemplate.getStr_TaxName());
	  	    System.out.println(id1+"jffkjfj");
	  	   
	  	   FacesContext facesContext = FacesContext.getCurrentInstance();
	 		Flash flash = facesContext.getExternalContext().getFlash();
	 		flash.setKeepMessages(true);
	 		flash.setRedirect(true);
	  	    if(id1==true)
	  	    {
	  	    	 facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cannot delete Tax Template. Delete the due instances and try again.", "Cannot delete Tax Template. Delete the due instances and try again."));
	  	    }
	  	    else
	  	    {
	         getTemplateService().deleteTax(delete);
		    	
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Deleted Successfully!", "Deleted Successfully!"));
		   

	    
		    return "taxtemplate.xhtml?faces-redirect=true";
		    }
			   }
			   }
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return null;
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
	private InvoiceTemplate selectedInvoiceTemplate;
	
	public InvoiceTemplate getSelectedInvoiceTemplate() {
		return selectedInvoiceTemplate;
	}
	public void setSelectedInvoiceTemplate(InvoiceTemplate selectedInvoiceTemplate) {
		this.selectedInvoiceTemplate = selectedInvoiceTemplate;
	}
	private boolean indicate;
	public boolean isIndicate() {
		return indicate;
	}
	public void setIndicate(boolean indicate) {
		this.indicate = indicate;
	}
	private boolean indicate2;
	public boolean isIndicate2() {
		return indicate2;
	}
	private boolean indicate1;
	public boolean isIndicate1() {
		return indicate1;
	}
	public void setIndicate1(boolean indicate1) {
		this.indicate1 = indicate1;
	}
	public void setIndicate2(boolean indicate2) {
		this.indicate2 = indicate2;
	}
	public void desabledListener( SelectEvent event)
	{
		System.out.println("hdhfhfhfdfhj77777777777777777777777777777777777777777777777777777777777777777");
		indicate=true;
	} 
	
	@SuppressWarnings("unused")
	public String desabled1Listener(SelectEvent event)
	{  
		InvoiceTemplate	invoiceTemplate=(InvoiceTemplate) event.getObject();
		System.out.println("klcfkfkjfgfgkffkg33333333333333333333333333333");
		indicate=true;
		 String str=invoiceTemplate.getStr_InvoiceTemplateName();
		 indicate1=getTemplateService().detectInvoiceTemplate(str);
		 if(indicate==true )
			 
		 { 
           if(indicate1==true)
           {  System.out.println("jhfjugfjgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
			 indicate2=false;
			
           }
           else
           { System.out.println("vjkgjkkjgfhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        	   indicate2=true; 
        	   str_Frequency=invoiceTemplate.getStr_Frequency();
        		 String str1=invoiceTemplate.getStr_DueInvoiceTemplate();
        		
        		 String[] strArray = str1.split(",");
        		 str_DueInvoiceTemplate=new ArrayList<String>();
        		  for (String str2 : strArray) {
        		      
        		       
        		       str_DueInvoiceTemplate.add(str2);
        		      
        		       
        		          
        		        }
             }
		   }
		
		
		          
		     
		
		  return "invoicetemplate.xhtml";
		
	}
	public String addInvoiceTemplate()
	{ try{
		
	
	  InvoiceTemplate invoicetemplate=new InvoiceTemplate();
	  invoicetemplate.setInt_Organisation(getInt_Organisation());
	  invoicetemplate.setStr_InvoiceTemplateName(getStr_InvoiceTemplateName());
	  invoicetemplate.setBl_Show(getBl_Show());
	  invoicetemplate.setStr_Frequency(getStr_Frequency());
	  invoicetemplate.setStr_MessageCategory(getStr_MessageCategory());
	  invoicetemplate.setStr_MessageTemplate(getStr_MessageTemplate());
	 
	  invoicetemplate.setStr_Description(description);
	  invoicetemplate.setStr_DueInvoiceTemplate(str);
	  getTemplateService().saveInvoiceTemplate(invoicetemplate);
	  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Invoice Template Saved Successfully!"));
         return "invoicetemplate.xhtml";
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "infomation.xhtml?faces-redirect=true";
	}
	private List<String> str_MessageTemplate1;
	public List<String> getStr_MessageTemplate1() {
		
		
		return str_MessageTemplate1;
	}
	
	
	
	public void setStr_MessageTemplate1(List<String> str_MessageTemplate1) {
		this.str_MessageTemplate1 = str_MessageTemplate1;
	}
	private List<InvoiceTemplate> listInvoices;
	
	
	public List<InvoiceTemplate> getListInvoices() {
		try
		{
			listInvoices=new ArrayList<InvoiceTemplate>();
		 if(str_InvoiceTemplateName==null && str1_Frequency==null )
			{  
				query="";
			}
			 
		    
			 if(!(str_InvoiceTemplateName==null) && !(str_InvoiceTemplateName.isEmpty()) )
			{
				query=query+"str_InvoiceTemplateName="+"'"+str_InvoiceTemplateName+"'";
			}
		 if(!(str1_Frequency==null) && !(str1_Frequency.isEmpty()))
			{  
				query=query+" and "+"str_Frequency="+"'"+str1_Frequency+"'";
			}
	    
			
			
			if(query.indexOf("and")==1)
			{   
			  
			   query=query.replaceFirst("and","" );
	                   
			}
			
			}
	
			catch(Exception e)
			{
				e.printStackTrace();
			}
		listInvoices.addAll(getTemplateService().listInvoiceTemplate(query));
			query="";
		
		
		Collections.sort(listInvoices);
		return listInvoices;
	}
	public void setListInvoices(List<InvoiceTemplate> listInvoices) {
		this.listInvoices = listInvoices;
	}
	public void detectInvoiceTemplate()
	{
		System.out.println("vcnmjnngffgjmfgmjngfgfm111111111111111111111111111111111");
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select an Item to View!"));
	}
	public void detectInvoiceTemplate1()
	{  System.out.println("111111111116666666666666666677777777777777777777777777777");
		if(indicate==false)
	   {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select an Item to View!"));
	    }
		else if(indicate2==false)
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("This invoice template already exists for the selected invoice. Duplicate invoice template cannot be created.")); 
		}
		
	}
	private InvoiceTemplate invoiceTemplate=new InvoiceTemplate();
	public InvoiceTemplate getInvoiceTemplate() {
		return invoiceTemplate;
	}
	public void setInvoiceTemplate(InvoiceTemplate invoiceTemplate) {
		this.invoiceTemplate = invoiceTemplate;
	}
	public void getInvoiceTemplate1(int id1)
	{   
		invoiceTemplate=getTemplateService().getInvoiceTemplate(id1);
        String str=invoiceTemplate.getStr_InvoiceTemplateName();
		 
		 boolean indicate1=getTemplateService().detectInvoiceTemplate(str);
		
		 
		
           if(indicate1==true)
           {  
			 indicate2=false;
			
           }
           else
           {
        	   indicate2=true;  
           }
          
	}
	public void getInvoiceTemplate2()
	{  
		invoiceTemplate=getTemplateService().getInvoiceTemplate(id);
	}
	public String saveInvoiceTemplate()
	{   invoiceTemplate.setStr_DueInvoiceTemplate(str);
	  
		
		getTemplateService().updateInvoiceTemplate(invoiceTemplate);
		  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully!"));
		return "invoicetemplate.xhtml";
	}
	private List<String> dueTemplates;
	public List<String> getDueTemplates() {
		
		 dueTemplates=new ArrayList<String>();
	     dueTemplates.addAll(getTemplateService().getDueTemplate(str_Frequency));
	        return dueTemplates;
	}
	public void setDueTemplates(List<String> dueTemplates) {
		this.dueTemplates = dueTemplates;
	}
  public List<String> frequencyChangeListener(ValueChangeEvent event)
  {  
	   str_Frequency=(String)event.getNewValue();
	
	    dueTemplates=new ArrayList<String>();
	     dueTemplates.addAll(getTemplateService().getDueTemplate(str_Frequency));
	     if(dueTemplates.isEmpty())
	     {   
	    	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"When no template is selected .You must select atleast one due template to create invoice template!","When no template is selected .You must select atleast one due template to create invoice template!")); 
	     }
	     
	    
	        return dueTemplates;
	    
		
	}
     @SuppressWarnings("rawtypes")
	private  List list1;
	@SuppressWarnings("rawtypes")
	public List getList1() {
		return list1;
	}
	@SuppressWarnings("rawtypes")
	public void setList1(List list1) {
		this.list1 = list1;
	}
	private static String str;


	
	public static String getStr() {
		return str;
	}
	public static void setStr(String str) {
		TemplateBean.str = str;
	}
	@SuppressWarnings("unchecked")
	public void roleChangeListener(ValueChangeEvent event) 
	{   
	    

         list1=new ArrayList<String>();
	   
		list1.addAll((List<String>)event.getNewValue());
		
		StringBuilder out = new StringBuilder();
		for (Object o : list1)
		{
		  out.append(o.toString());
		  out.append(",");
		}
		str=out.toString();

	
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
	public List<String> templateChangeListener1(ValueChangeEvent event)
	{
		String str=(String)event.getNewValue();
		
		str_MessageTemplate1=new ArrayList<String>();
		str_MessageTemplate1= getTemplateService().getMessageTemplate(str);
		
		return str_MessageTemplate1;
		
	}
	public String deleteInvoice(InvoiceTemplate invoice){
	System.out.println("jhcvjhv11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");	
		System.out.println(invoice.getInt_InvoiceTemplateID()+"dfjfjjfdjfjfdjffffffffffffffffffffffffffffffffffffffff");
		String str=invoice.getStr_InvoiceTemplateName();
		boolean invoiceindicate=getTemplateService().detectInvoiceTemplate(str);
		if(invoiceindicate==true)
			
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cannot delete Invoice Template. Delete the due instances and try again.", "Cannot delete Invoice Template. Delete the due instances and try again."));
 	    
		}
		else
		{
	getTemplateService().deleteInvoice(invoice);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"InvoiceTemplate Deleted Successfully!", "InvoiceTemplate Deleted Successfully!"));
		}
		return "invoicetemplate.xhtml";
	  
	}
	public String deleteInvoice1(){
		InvoiceTemplate invoice=new InvoiceTemplate();
		System.out.println(int_DueTemplateID);
		invoice.setInt_InvoiceTemplateID(id);
	getTemplateService().deleteInvoice(invoice);
		return "invoicetemplate.xhtml?faces-redirect=true";
	  
	}
	
    
   
    public String saveInvoiceTemplate(InvoiceTemplate invoiceTemplate) {
    	try
    	{
			


			
			invoiceTemplate.setStr_DueInvoiceTemplate(str);
			
			
			getTemplateService().updateInvoiceTemplate(invoiceTemplate);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);

			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

		} 
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return "invoicetemplate.xhtml?faces-redirect=true";
	}
    public String deleteInvoiceTemplate() {
    	System.out.println("hvgfhjugvfjgfjgf1111111111111111111111111111111111111111111111111111111111111111111111111");
    	try
		   {
			if(indicate==false)
					{
				FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
				
					}
			else
			{ String str=selectedInvoiceTemplate.getStr_InvoiceTemplateName();
			boolean invoiceindicate=getTemplateService().detectInvoiceTemplate(str);
			if(invoiceindicate==true)
				
			{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cannot delete Invoice Template. Delete the due instances and try again.", "Cannot delete Invoice Template. Delete the due instances and try again."));
	 	    
			}
			else
			{
		getTemplateService().deleteInvoice(selectedInvoiceTemplate);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"InvoiceTemplate Deleted Successfully!", "InvoiceTemplate Deleted Successfully!"));
			}
			}
		   }
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
    
	    return "invoicetemplate.xhtml?faces-redirect=true";
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
		messagetemplate.setInt_Organisation(getInt_Organisation());
		messagetemplate.setDat_Date(getDat_Date());
		messagetemplate.setStr_Category(getStr_Category());
		messagetemplate.setStr_Mode(getStr_Mode());
		messagetemplate.setStr_Title(getStr_Title());
		messagetemplate.setStr_Description(getStr_Description());
	     getTemplateService().saveMessageTemplate(messagetemplate);
	     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("MessageTemplate Saved Successfully!"));
		return "messagetemplate.xhtml";
	   }
		catch(Exception e)
				{
			e.printStackTrace();
				}
		return "messagetemplate.xhtml";
	}
	private String query="";
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	private List<MessageTemplate> listMessages;
	public List<MessageTemplate> getListMessages() {
		try
		{
		listMessages=new ArrayList<MessageTemplate>();
		 if(str_Mode==null && str_Category==null )
			{ 
				query="";
			}
			 
		    
			 if(!(str_Mode==null) && !(str_Mode.isEmpty()) )
			{
				query=query+"str_Mode="+"'"+str_Mode+"'";
			}
		 if(!(str_Category==null) && !(str_Category.isEmpty()))
			{  
				query=query+" and "+"str_Category="+"'"+str_Category+"'";
			}
	    
			
			
			if(query.indexOf("and")==1)
			{  
			  
			   query=query.replaceFirst("and","" );
	                   
			}
			
			}
	
			catch(Exception e)
			{
				e.printStackTrace();
			}
		listMessages.addAll(getTemplateService().listMessageTemplate(query));
			query="";
		
		
		Collections.sort(listMessages);
		return listMessages;
	}
	public void setListMessages(List<MessageTemplate> listMessages) {
		this.listMessages = listMessages;
	}
	private MessageTemplate messageTemplate=new MessageTemplate();
	public MessageTemplate getMessageTemplate() {
		return messageTemplate;
	}
	public void setMessageTemplate(MessageTemplate messageTemplate) {
		this.messageTemplate = messageTemplate;
	}
	public void getMessageTemplate1()
	{  
		messageTemplate=getTemplateService().getMessageTemplate(int_MessageTemplateID);
	}
	public void getMessageTemplate2(int id1)
	{  
		messageTemplate=getTemplateService().getMessageTemplate(id1);
	}
	public String saveMessageTemplate()
	{   System.out.println("hujy");
		getTemplateService().updateMessageTemplate(messageTemplate);
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("MessageTemplate Updated Successfully!"));
		return "messagetemplate.xhtml?faces-redirect=true";
	}
	
	public String deleteMessage(MessageTemplate message){
		
		
	  getTemplateService().deleteMessage(message);
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
		return "messagetemplate.xhtml?faces-redirect=true";
	  
	}
	public String cancelMessage()
	{
		return "messageTemplate.xhtml";
	}
	private MessageTemplate selectedMessageTemplate;
	 
	
	
	public MessageTemplate getSelectedMessageTemplate() {
		return selectedMessageTemplate;
	}
	public void setSelectedMessageTemplate(MessageTemplate selectedMessageTemplate) {
		this.selectedMessageTemplate = selectedMessageTemplate;
	}
	public String saveMessageTemplate(MessageTemplate messageTemplate) {
			if (messageTemplate.getInt_MessageTemplateID()!= null) {
				getTemplateService().updateMessageTemplate(messageTemplate);
				FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);

				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

			} else
				getTemplateService().saveTaxTemplate(taxTemplate);
			return "messagetemplate.xhtml";
		}
	    public String deleteMessageTemplate() {
	    	try
	    	   {
	    		if(indicate==false)
	    				{
	    			FacesContext facesContext = FacesContext.getCurrentInstance();
	    			Flash flash = facesContext.getExternalContext().getFlash();
	    			flash.setKeepMessages(true);
	    			flash.setRedirect(true);
	    			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
	    			return "messagetemplate.xhtml?faces-redirect=true";
	    				}
	    		else
	    		{
		    MessageTemplate delete = new MessageTemplate();
	   
		    delete.setInt_MessageTemplateID(selectedMessageTemplate.getInt_MessageTemplateID());
		    getTemplateService().deleteMessage(delete);
		    	FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"MessageTemplate deleted Successfully!", "MessageTemplate deleted Successfully!"));
		   

	     
		    return "messagetemplate.xhtml?faces-redirect=true";
		}
	    	   }catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	    	return null;
	    }
	    @Override
		   public void validate(FacesContext context, UIComponent component,
		           Object value) throws ValidatorException { 
		      
		      
		      java.util.ArrayList checkbox1=(ArrayList)value;
		    
		      if(checkbox1.size()==0) {
					FacesMessage msg
			          = new FacesMessage();
					 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				        throw new ValidatorException(msg);
				}
				else
				{   
					
				}
		    
		 
	} 
}
