package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;















import javax.faces.validator.ValidatorException;

import org.primefaces.event.SelectEvent;

import com.appowner.model.DueTransaction;
import com.appowner.service.DueService;
import com.appowner.util.Util;


@ManagedBean
@ViewScoped

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
		str_DueTemplates.addAll(getDueService().getDueTemplate(str_Accounts));
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
			due.setStr_Organisation(Util.getAppartmentId());
			due.setStr_Block(getStr_Block());
			due.setStr_ApartmentNo(getStr_ApartmentNo());
			due.setDbl_DueAmount(getDbl_DueAmount());
			due.setDbl_TotalDueAmount(getDbl_DueAmount());
			due.setStr_Status("Due");
			getDueService().saveDueTransaction(due);
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Dues Saved Successfully!"));
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
		listDueTransaction1.addAll(getDueService().listDueTransaction1(str_DueTemplate1,str_Block,str_ApartmentNo,str_Period,int_Year));
		
		return listDueTransaction1;
	}
	public void setListDueTransaction1(List<DueTransaction> listDueTransaction1) {
		this.listDueTransaction1 = listDueTransaction1;
	}
	private String query="";
	public List<DueTransaction> getListDueTransaction() {
		try
		{
		listDueTransaction=new ArrayList<DueTransaction>();
		 if(str_Block==null && str_ApartmentNo==null && str_Status==null && str_Period==null && str_DueTemplate==null)
			{  System.out.println("fdjfkjfjd111111111111111111111111111111111111111");
				query="";
			}
			 
		    
			 if(!(str_Block==null) && !(str_Block.isEmpty()) )
			{
				query=query+"str_Block="+"'"+str_Block+"'";
			}
		 if(!(str_ApartmentNo==null) && !(str_ApartmentNo.isEmpty()))
			{   System.out.println("hhh111111111111111111111111111111111111111111111111111111111111111");
				query=query+" and "+"str_ApartmentNo="+"'"+str_ApartmentNo+"'";
			}
	     if(!(str_Status==null) && !(str_Status.isEmpty()))
			{
				query=query+" and "+"str_Status="+"'"+str_Status+"'";
			}
		if(!(str_Period==null) && !(str_Period.isEmpty()))
			{
				query=query+" and "+"str_Period="+"'"+str_Period+"'";
			}
		if(!(str_DueTemplate==null) && !(str_DueTemplate.isEmpty()))
			{
				query=query+" and "+"str_DueTemplate="+"'"+str_DueTemplate+"'";
			} 
			 
			System.out.println(query+"jdffjkdjhfdjfdfdfdffdjfdjfdjfjddfjhdfjhfdjhfd");
			System.out.println(query.indexOf("and"));
			
			if(query.indexOf("and")==1)
			{   System.out.println("jhujugfjf11111111111111111111111111111111111111111111");
			  
			   query=query.replaceFirst("and","" );
	                   
			}
			System.out.println(query+"fdjjhgjjgfjgfjfjfjgjfgjgfjgfj");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		listDueTransaction.addAll(getDueService().listDueTransaction(query));
		Collections.sort(listDueTransaction);
			query="";
			
			return listDueTransaction;
		
		
		
	}
	public void setListDueTransaction(List<DueTransaction> listDueTransaction) {
		this.listDueTransaction = listDueTransaction;
	}
	
	public void detectInvoiceTemplate()
	{
		System.out.println("vcnmjnngffgjmfgmjngfgfm111111111111111111111111111111111");
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select an Item to View!"));
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
	public List<String> templateChangeListener1(ValueChangeEvent event)
	{  System.out.println("fggfkjfkjgfkj11111111111111111111111111111111");
	str_Accounts=(String)event.getNewValue();
		System.out.println(str_Accounts+"fdkjfdkjdkfkjfdkjfdjkfgkjgfkjgfkjgfk");
		str_DueTemplates=new ArrayList<String>();
		 str_DueTemplates.addAll(getDueService().getDueTemplate(str_Accounts));
		 System.out.println(str_DueTemplates+"dfjkjdfdjkfdjfdjfjfdjfjfdjfdjdfj");
		return str_DueTemplates;
	
	}
	public String templateChangeListener(ValueChangeEvent event)
	{  System.out.println(str_DueTemplate+"hvjggjfgjkfjkgfjkkgffg111111111111111111111111111111111111111111111");
	str_DueTemplate =(String)event.getNewValue();  
	periodIndicator=getDueService().getFrequency(str_DueTemplate);
	  System.out.println(str_DueTemplate+"hjhjjh");  
	 
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
	    System.out.println(str_DueTemplate1+"jjkjkjj");
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
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"This due already exists for the selected apartment. Duplicate dues cannot be created.", "This due already exists for the selected apartment. Duplicate dues cannot be created.!"));
   		System.out.println("jjkjkjkjkdf");
   		
   		return dbl_DueAmount;
		}
		 dbl_DueAmount= getDueService().getDueAmount(str,str_DueTemplate1);	  
		    return dbl_DueAmount;	
	}
	private List<DueTransaction>   listUserDueTransaction;
	public List<DueTransaction> getListUserDueTransaction() {
		
		try
		{
			listUserDueTransaction=new ArrayList<DueTransaction>();
		 if(str_Block==null && str_ApartmentNo==null && str_Status==null && str_Period==null && str_DueTemplate==null)
			{  System.out.println("fdjfkjfjd111111111111111111111111111111111111111");
				query="";
			}
			 
		    
			 if(!(str_Block1==null) && !(str_Block1.isEmpty()) )
			{
				query=query+"str_Block="+"'"+str_Block1+"'";
			}
		 if(!(str_ApartmentNo1==null) && !(str_ApartmentNo1.isEmpty()))
			{   System.out.println("hhh111111111111111111111111111111111111111111111111111111111111111");
				query=query+" and "+"str_ApartmentNo="+"'"+str_ApartmentNo1+"'";
			}
	     if(!(str_Status==null) && !(str_Status.isEmpty()))
			{
				query=query+" and "+"str_Status="+"'"+str_Status+"'";
			}
		if(!(str_Period==null) && !(str_Period.isEmpty()))
			{
				query=query+" and "+"str_Period="+"'"+str_Period+"'";
			}
		if(!(str_DueTemplate==null) && !(str_DueTemplate.isEmpty()))
			{
				query=query+" and "+"str_DueTemplate="+"'"+str_DueTemplate+"'";
			} 
			 
			System.out.println(query+"jdffjkdjhfdjfdfdfdffdjfdjfdjfjddfjhdfjhfdjhfd");
			System.out.println(query.indexOf("and"));
			
			if(query.indexOf("and")==1)
			{   System.out.println("jhujugfjf11111111111111111111111111111111111111111111");
			  
			   query=query.replaceFirst("and","" );
	                   
			}
			System.out.println(query+"fdjjhgjjgfjgfjfjfjgjfgjgfjgfj");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		listUserDueTransaction.addAll(getDueService().listUserDueTransaction(query));
		Collections.sort(listUserDueTransaction);
			query="";
			
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
		System.out.println("djfkdfkjfdkjfdkjfdjkfd");
		indicator1=LoginBean.isUser1();
		return indicator1;
	}
	public void setIndicator1(boolean indicator1) {
		this.indicator1 = indicator1;
	}
	private DueTransaction dueTranasction=new DueTransaction() ;
	public DueTransaction getDueTranasction() {
		dueTranasction=getDueService().getDueTransaction(id);
		System.out.println(dueTranasction.getInt_DueTransactionID()+"fkjfgjkfgkj");
		return dueTranasction;
	}
	public void setDueTranasction(DueTransaction dueTranasction) {
		this.dueTranasction = dueTranasction;
	}
	private static Integer id;
	public static Integer getId() {
		return id;
	}
	public static void setId(Integer id) {
		DueBean.id = id;
	}
	private boolean indicate;
	public String select()
	{   try{ 
		   if(indicate==false)
		   {   System.out.println("jcvkvcjvj11111111111111111111111111111111111111111111111111");
			   FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
				return "dues.xhtml";
		   }
		   else
		   { 
			   System.out.println("11111111111111111111111111111111111166666666666644444444444444444");
		System.out.println(selectedDue.getInt_DueTransactionID()+"gfvgfg");
		id=selectedDue.getInt_DueTransactionID();
		dueTranasction=getDueService().getDueTransaction(selectedDue.getInt_DueTransactionID());
		System.out.println(dueTranasction.getStr_Status()+"ffgkjfgjk");
		return "viewuserdues.xhtml";
		   }
	    }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	}
	public void desabledListener( SelectEvent event)
	{
		System.out.println("klcfkfkjfgfgkffkg33333333333333333333333333333");
		indicate=true;
	}
	public boolean isIndicate() {
		return indicate;
	}
	public void setIndicate(boolean indicate) {
		this.indicate = indicate;
	}
	public String deleteDues(){
		try
		{
		if(indicate==false)
		{
			 FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
				return "dues.xhtml?faces-redirect=true";
		}
		else
		{
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
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cannot delete Due . Delete the invoice instances and try again.!", "Cannot delete Due . Delete the invoice instances and try again.!"));
		}
		else
		{	
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Delete Due? Payments recorded against this due will also be deleted.!", "Delete Due? Payments recorded against this due will also be deleted.!"));
		getDueService().deleteDues(id);
		System.out.println("hjjcjdf");
		}
	    return "dues.xhtml";
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	return null;		
	} 
	public void validateAmount(FacesContext context, UIComponent component,Object o) 
	 {
		 System.out.println("166666666666666666666666666666666666666666666666666666666666666666666666666");
			HtmlInputText input =(HtmlInputText) component;
			double amount2= Double.parseDouble((String) input.getSubmittedValue());
			
			
			if(amount2==0.00)
			{   
				FacesMessage msg
		          = new FacesMessage();
				 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			        throw new ValidatorException(msg);
			}
	 }

}

    
	    	
	    		
	    	
	    	
	    	 
	   
	   
	 
		
	  
		
	
	 