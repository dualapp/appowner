package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;











import com.appowner.model.DueTransaction;
import com.appowner.service.DueService;
import com.appowner.util.Util;


@ManagedBean
@SessionScoped

public class DueBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{DueService}")
			private DueService dueService;
	public DueService getDueService() {
		return dueService;
	}
	public void setDueService(DueService dueService) {
		this.dueService = dueService;
	}
	private Integer int_DueTransactionID;
	private String str_Accounts;
	private String str_DueTemplate;
	private String str_Period;
	private Integer int_Year;
	private Date str_InitiatedOn;
	private Date dat_LastDate;
	private String str_Organisation;
 	public String getStr_Status() {
		return str_Status;
	}
	 private boolean indicator;
	
    	public boolean isIndicator() {
		indicator=LoginBean.isAdmin();
		
		return indicator;
	}
    	private String indicator2;
	
		
	public String getIndicator2() {
		if(LoginBean.isAdmin())
		{
		indicator2="template1.xhtml";
			return indicator2;
		}
		else
			return "template.xhtml";
		}
		public void setIndicator2(String indicator2) {
			this.indicator2 = indicator2;
		}
	public void setIndicator(boolean indicator) {
		this.indicator = indicator;
	}
	public void setStr_Status(String str_Status) {
		this.str_Status = str_Status;
	}
	private String str_Block;
	private String str_Block1;
	private String str_ApartmentNo;
	private String str_ApartmentNo1;
	 public String getStr_Block1() {
		str_Block1=Util.getBlock();
					
		return str_Block1;
	}
	public void setStr_Block1(String str_Block1) {
		this.str_Block1 = str_Block1;
	}
	public String getStr_ApartmentNo1() {
		str_ApartmentNo1=Util.getFlatNo();
	System.out.println(str_ApartmentNo1+"priya");
		return str_ApartmentNo1;
	}
	public void setStr_ApartmentNo1(String str_ApartmentNo1) {
		this.str_ApartmentNo1 = str_ApartmentNo1;
	}
	  private String str_Status;
	 private Double dbl_DueAmount=0.00;
	private Double dbl_TotalDueAmount=0.00;
	public Integer getInt_DueTransactionID() {
		return int_DueTransactionID;
	}
	public void setInt_DueTransactionID(Integer int_DueTransactionID) {
		this.int_DueTransactionID = int_DueTransactionID;
	}
	public String getStr_Accounts() {
		return str_Accounts;
	}
	public void setStr_Accounts(String str_Accounts) {
		this.str_Accounts = str_Accounts;
	}
	public String getStr_DueTemplate() {
		
		return str_DueTemplate;
	}
	public void setStr_DueTemplate(String str_DueTemplate) {
		this.str_DueTemplate = str_DueTemplate;
	}
	public String getStr_Period() {
		return str_Period;
	}
	public void setStr_Period(String str_Period) {
		this.str_Period = str_Period;
	}
	public Integer getInt_Year() {
		return int_Year;
	}
	public void setInt_Year(Integer int_Year) {
		this.int_Year = int_Year;
	}
	public Date getStr_InitiatedOn() {
		str_InitiatedOn=new java.util.Date();
		 
		
		return str_InitiatedOn;
	}
	
	public void setStr_InitiatedOn(Date str_InitiatedOn) {
		this.str_InitiatedOn = str_InitiatedOn;
	}
	public Date getDat_LastDate() {
		return dat_LastDate;
	}
	public void setDat_LastDate(Date dat_LastDate) {
		this.dat_LastDate = dat_LastDate;
	}
	private Integer int__Organisation;
	public Integer getInt__Organisation() {
		int__Organisation=Util.getAppartmentId();
		return int__Organisation;
	}
	public void setInt__Organisation(Integer int__Organisation) {
		this.int__Organisation = int__Organisation;
	}
	public String getStr_Organisation() {
		str_Organisation=Util.getAppartmentName();
		return str_Organisation;
	}
	public void setStr_Organisation(String str_Organisation) {
		this.str_Organisation = str_Organisation;
	}
	public String getStr_Block() {
	
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public String getStr_ApartmentNo() {
	
		return str_ApartmentNo;
	}
	public void setStr_ApartmentNo(String str_ApartmentNo) {
		this.str_ApartmentNo = str_ApartmentNo;
	}
	public Double getDbl_DueAmount() {
		return dbl_DueAmount;
	}
	public void setDbl_DueAmount(Double dbl_DueAmount) {
		this.dbl_DueAmount = dbl_DueAmount;
	}
	public Double getDbl_TotalDueAmount() {
		return dbl_TotalDueAmount;
	}
	public void setDbl_TotalDueAmount(Double dbl_TotalDueAmount) {
		this.dbl_TotalDueAmount = dbl_TotalDueAmount;
	}
	private List<String> str_Account;
	public List<String> getStr_Account() {
		str_Account=new ArrayList<String>();
		str_Account.addAll(getDueService().getAccountsList());
		return str_Account;
	}
	private String str_DueTemplate1;
	public String getStr_DueTemplate1() {
		return str_DueTemplate1;
	}
	public void setStr_DueTemplate1(String str_DueTemplate1) {
		this.str_DueTemplate1 = str_DueTemplate1;
	}
	public void setStr_Account(List<String> str_Account) {
		this.str_Account = str_Account;
	}private List<String> str_DueTemplates;
	public List<String> getStr_DueTemplates() {
		str_DueTemplates=new ArrayList<String>();
		str_DueTemplates.addAll(getDueService().getDueTemplate());
		if(str_DueTemplates.listIterator().hasNext())
		{
		str_DueTemplate1=str_DueTemplates.get(0);
		
		}
		System.out.println(str_DueTemplate1+"dfjdfjk");
		periodIndicator=getDueService().getFrequency(str_DueTemplate1);
		return str_DueTemplates;
	}
	public void setStr_DueTemplates(List<String> str_DueTemplates) {
		this.str_DueTemplates = str_DueTemplates;
	}
	private List<String> ravenues;
	public List<String> getRavenues() {
		ravenues=new ArrayList<String>();
		ravenues.addAll(getDueService().listRavenues());
		return ravenues;
	}
	public void setRavenues(List<String> ravenues) {
		this.ravenues = ravenues;
	}
	public String addDueTransaction()
	{
		try
		{
			DueTransaction due=new DueTransaction();
			due.setStr_Accounts(getStr_Accounts());
			due.setStr_DueTemplate(getStr_DueTemplate());
			
			due.setStr_Period(getStr_Period());
			due.setInt_Year(getInt_Year());
			due.setStr_InitiatedOn(getStr_InitiatedOn());
			due.setDat_LastDate(getDat_LastDate());
			due.setStr_Organisation(int__Organisation);
			due.setStr_Block(getStr_Block());
			due.setStr_ApartmentNo(getStr_ApartmentNo());
			due.setDbl_DueAmount(getDbl_DueAmount());
			due.setDbl_TotalDueAmount(getDbl_DueAmount());
			due.setStr_Status("Due");
			getDueService().saveDueTransaction(due);
			return "dues.xhtml";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "dues.xhtml";
	}
	private List<DueTransaction> listDueTransaction1;
	public List<DueTransaction> getListDueTransaction1() {
		listDueTransaction1=new ArrayList<DueTransaction>();
		listDueTransaction1.addAll(getDueService().listDueTransaction1(str_DueTemplate,str_Block,str_ApartmentNo,str_Period,int_Year));
		
		return listDueTransaction1;
	}
	public void setListDueTransaction1(List<DueTransaction> listDueTransaction1) {
		this.listDueTransaction1 = listDueTransaction1;
	}
	public List<DueTransaction> getListDueTransaction() {
		listDueTransaction=new ArrayList<DueTransaction>();
		listDueTransaction.addAll(getDueService().listDueTransaction(str_DueTemplate,str_Block,str_ApartmentNo,str_Period,str_Status));
		return listDueTransaction;
	}
	public void setListDueTransaction(List<DueTransaction> listDueTransaction) {
		this.listDueTransaction = listDueTransaction;
	}
	private List<DueTransaction> listDueTransaction;
	private List<String> str_Blocks;
	public List<String> getStr_Blocks() {
		str_Blocks=new ArrayList<String>();
		str_Blocks.addAll(getDueService().getBlockList(str_Organisation));
		return str_Blocks;
	}
	public void setStr_Blocks(List<String> str_Blocks) {
		this.str_Blocks = str_Blocks;
	}
	private List<String> str_BlockNo;
	public List<String> getStr_BlockNo() {
		return str_BlockNo;
	}
	public void setStr_BlockNo(List<String> str_BlockNo) {
		this.str_BlockNo = str_BlockNo;
	}
	
	public List<String> blockChangeListener(ValueChangeEvent event)
	{   str_Block=(String)event.getNewValue();
	     System.out.println(str_Block);
		str_BlockNo=new ArrayList<String>();
		str_BlockNo.addAll(getDueService().getApartmentlist(str_Block));
		return str_BlockNo;
	}
	private String periodIndicator;
	public String getPeriodIndicator() {
		return periodIndicator;
	}
	public void setPeriodIndicator(String periodIndicator) {
		this.periodIndicator = periodIndicator;
	}
	public String templateChangeListener(ValueChangeEvent event)
	{  
		 String ddd=(String)event.getNewValue();  
	periodIndicator=getDueService().getFrequency(ddd);
	  System.out.println(ddd+"hjhjjh");  
		return periodIndicator;
	}
	public void periodChangeListener(ValueChangeEvent event)
	{
		str_Period=(String)event.getNewValue();
		System.out.println(str_Period+"lksakalkska");
	}
	public void periodChangeListener1(ValueChangeEvent event)
	{
		int_Year=(Integer) event.getNewValue();
		System.out.println(int_Year+"kjgfjg");
	}
	
	public double apartmentChangeListener(ValueChangeEvent event)
	{   String str=(String)event.getNewValue();
	    System.out.println(str_DueTemplate+"jjkjkjj");
	    System.out.println(str_Block+"hjh");
	    System.out.println(str+"jhjhj");
	    str_ApartmentNo=str;
	    System.out.println(int_Year+"hjjhjh");
	    System.out.println(str_Period+"hjjhjj");
	    getListDueTransaction1();
	    System.out.println(listDueTransaction1+"hjjhjhjj");
	    FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		
	    ListIterator list=listDueTransaction1.listIterator();
	   
	    System.out.println(list.hasNext());
	
	    if(list.hasNext())
	   {
			dbl_DueAmount=0.00;
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Message", "This due already exists for the selected apartment. Duplicate dues cannot be created.!"));
   		System.out.println("jjkjkjkjkdf");
   		return dbl_DueAmount;
		}
		 dbl_DueAmount= getDueService().getDueAmount(str,str_DueTemplate);	  
		    return dbl_DueAmount;	
	}
	private List<DueTransaction>   listUserDueTransaction;
	public List<DueTransaction> getListUserDueTransaction() {
		listUserDueTransaction=new ArrayList<DueTransaction>();
	
		listUserDueTransaction.addAll(getDueService().listUserDueTransaction(str_Block1,str_ApartmentNo1,str_Status,str_Period,str_DueTemplate));
		return listUserDueTransaction;
	}
	public void setListUserDueTransaction(
			List<DueTransaction> listUserDueTransaction) {
		this.listUserDueTransaction = listUserDueTransaction;
	}
	
	
	
	public String reset()
	{
		return "userdues.xhtml";
	}
	private DueTransaction selectedDue;
	
	public DueTransaction getSelectedDue() {
		return selectedDue;
	}
	public void setSelectedDue(DueTransaction selectedDue) {
		this.selectedDue = selectedDue;
	}
	private boolean indicator1;
	public boolean isIndicator1() {
		indicator1=LoginBean.isUser1();
		return indicator1;
	}
	public void setIndicator1(boolean indicator1) {
		this.indicator1 = indicator1;
	}
	public String select()
	{  System.out.println("hhhhhh");
		return "viewuserdues.xhtml";
		
	}
	public String deleteDues(){
		System.out.println("hyjhhhhhhhhhhhhhhhhhhhhhhhhhhh");

		Integer id=selectedDue.getInt_DueTransactionID();
		boolean track=getDueService().getInvoiceNo(id);
		System.out.println(track+"ddkjd");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		if(track==true)
		{   System.out.println("fdjkdfkjfdfd");
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Message!", "Cannot delete Due . Delete the invoice instances and try again.!"));
		}
		else
		{	
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Message!", "Delete Due? Payments recorded against this due will also be deleted.!"));
		getDueService().deleteDues(id);
		System.out.println("hjjcjdf");
		}
	    return "dues.xhtml";

			
			
	} 
	{
		
	}

}

    
	    	
	    		
	    	
	    	
	    	 
	   
	   
	 
		
	  
		
	
	 