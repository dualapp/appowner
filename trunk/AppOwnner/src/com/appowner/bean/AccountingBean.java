package com.appowner.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.TabChangeEvent;

import com.appowner.model.AccountingGroup;
import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.Expense;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;
import com.appowner.service.AccountsService;
import com.appowner.service.TemplateService;
import com.appowner.util.Util;

@ManagedBean
@RequestScoped
public class AccountingBean  extends RuntimeException implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{AccountsService}")
	private AccountsService accountsService;
	public AccountsService getAccountsService() {
		return accountsService;
	}
	 public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}
	private String account;
	
	public String getAccount() {
		
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public AccountingBean()
	{
		
	}
	public AccountingBean(String msg)
	{
		super(msg);
	}

private Date dat_FromDate;

public void setDat_FromDate(Date dat_FromDate) {
	this.dat_FromDate = dat_FromDate;
}
private Date dat_ToDate=new java.util.Date();
public void setDat_ToDate(Date dat_ToDate) {
	this.dat_ToDate = dat_ToDate;
}
private String dat_FromDate1;
public String getDat_FromDate1() {
	java.util.Date d=new java.util.Date();
	 SimpleDateFormat ft = 
		      new SimpleDateFormat ("dd-MM-yyyy");
	//String str=ft.format(d);
	 Calendar c = Calendar.getInstance(); 
	 c.setTime(dat_FromDate);
	 
	 c.add(Calendar.DATE,-1);
	
	 d= c.getTime();
	System.out.println(d+"kunkupriya");

	 String str=ft.format(d);
	
		return str;
	
	
}
public void setDat_FromDate1(String dat_FromDate1) {
	this.dat_FromDate1 = dat_FromDate1;
}
private Date from_date=getDat_FromDate();

public Date getFrom_date() {
	return from_date;
}
public void setFrom_date(Date from_date) {
	this.from_date = from_date;
}
public Date getDat_FromDate() {
	dat_FromDate= new java.util.Date();
	Calendar cal1 = Calendar.getInstance();


	cal1.add(Calendar.MONTH,-1);
	dat_FromDate=cal1.getTime();
	return dat_FromDate;
}

public Date getDat_ToDate() {
	
   return dat_ToDate;
	
}

//MANUAL JOURNAL
private Integer int_ManualJournalID;
public Integer getInt_ManualJournalID() {
	return int_ManualJournalID;
}
public void setInt_ManualJournalID(Integer int_ManualJournalID) {
	this.int_ManualJournalID = int_ManualJournalID;
}
public String getStr_Organisation() {
	str_Organisation=Util.getAppartmentName();
	return str_Organisation;
}
public void setStr_Organisation(String str_Organisation) {
	this.str_Organisation = str_Organisation;
}
public Date getDat_Date() {
	//dat_Date=new java.util.Date();
	
	
	return dat_Date;
	
}

public void setDat_Date(Date dat_Date) {
	this.dat_Date = dat_Date;
}
public String getStr_Reference() {
	return str_Reference;
}
public void setStr_Reference(String str_Reference) {
	this.str_Reference = str_Reference;
}
public String getStr_Notes() {
	return str_Notes;
}
public void setStr_Notes(String str_Notes) {
	this.str_Notes = str_Notes;
}
public String getStr_DebitAccount() {
	return str_DebitAccount;
}
public void setStr_DebitAccount(String str_DebitAccount) {
	this.str_DebitAccount = str_DebitAccount;
}
public String getStr_CreditAccount() {
	return str_CreditAccount;
}
public void setStr_CreditAccount(String str_CreditAccount) {
	this.str_CreditAccount = str_CreditAccount;
}

public Double getStr_DebitAmount() {
	return str_DebitAmount;
}
public void setStr_DebitAmount(Double str_DebitAmount) {
	this.str_DebitAmount = str_DebitAmount;
}
public Double getStr_CreditAmount() {
	return str_CreditAmount;
}
public void setStr_CreditAmount(Double str_CreditAmount) {
	this.str_CreditAmount = str_CreditAmount;
}
private char account1;

public char getAccount1() {
	return account1;
}
public void setAccount1(char account1) {
	this.account1 = account1;
}
private String str_Organisation;
private Date dat_Date;
private String str_Reference;
private String str_Notes;
private String str_DebitAccount;
private String str_CreditAccount;
private Double str_DebitAmount;
private Double str_CreditAmount;
private ManualJournal selectedjournal;
public ManualJournal getSelectedjournal() {
	return selectedjournal;
}
public void setSelectedjournal(ManualJournal selectedjournal) {
	this.selectedjournal = selectedjournal;
}
public String addInvoiceManualJournal() throws AccountingBean
{ try{
	ManualJournal journal=new ManualJournal();
    journal.setStr_OrganisationID(Util.getAppartmentId());
    journal.setDat_Date(dat_Date);
    journal.setStr_Reference(getStr_Reference());
    journal.setStr_Notes(getStr_Notes());
    journal.setStr_DebitAccount(getStr_DebitAccount());
    journal.setStr_CreditAccount(getStr_CreditAccount());
    journal.setDbl_DebitAmount(getStr_DebitAmount());
    System.out.println(getStr_DebitAmount());
    journal.setDbl_CreditAmount(getStr_CreditAmount());
   
   
    
    	 getAccountsService().addManualJournal(journal);
   
   return "accountinglayout.xhtml";
    
    }
  catch(Exception e)
  {
	throw new  AccountingBean("CreditAmount Should be Same as DebitAmount");
  }

}
public String addManualJournal(ManualJournal journal) {
	System.out.println("jhvvnjhhhhhhhhhhhhhhhhhh");
	if (journal.getInt_ManualJournalID()!= null) {
		
		 getAccountsService().updateManualJournal(journal);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

	} else
		getAccountsService().addManualJournal(journal);
	return "accountinglayout.xhtml";
}
public String deleteManualJournal() {
	System.out.println("hyjhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	ManualJournal journal=new ManualJournal();
	Integer id=selectedjournal.getInt_ManualJournalID();
	System.out.println(id+"gchhhhhhhhhhhhhhhhhh");
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ManualJournal deleted Successfully!", "ManualJournal deleted Successfully!"));
   

   getAccountsService().deleteManualJournal(id);
    return "manualjournal.xhtml?faces-redirect=true";
}
private List<ManualJournal> listManualJournal;
public List<ManualJournal> getListManualJournal() {
	listManualJournal=new ArrayList<ManualJournal>();
	listManualJournal.addAll(getAccountsService().getlistManualJournal());
	return listManualJournal;
}
public void setListManualJournal(List<ManualJournal> listManualJournal) {
	this.listManualJournal = listManualJournal;
}
private DataTable dataTable;

public DataTable getDataTable() {
	return dataTable;
}
public void setDataTable(DataTable dataTable) {
	this.dataTable = dataTable;
}
private static Integer id;
public static Integer getId() {
	return id;
}
public static void setId(Integer id) {
	AccountingBean.id = id;
}
public void processValueChange(ValueChangeEvent event)  
        throws AbortProcessingException 
{  
	ManualJournal journal=new ManualJournal();
	journal=(ManualJournal)dataTable.getRowData();
	id=journal.getInt_ManualJournalID();
	System.out.println(id);
}
private Date  dat_From;
private Date dat_To;
public Date getDat_From() {
	Calendar cal = Calendar.getInstance();
	cal.set(Calendar.DAY_OF_MONTH, 1);
	cal.add(Calendar.MONTH,-1);
	dat_From = cal.getTime();
	
	return dat_From;
}
public void setDat_From(Date dat_From) {
	this.dat_From = dat_From;
}
public Date getDat_To()  {
	dat_To=new java.util.Date();
	 Calendar c = Calendar.getInstance(); 
	 c.setTime(dat_To); 
   
   
    c.set(Calendar.MONTH, Calendar.DECEMBER);
    c.set(Calendar.DATE, 31);
     
  
    dat_To=c.getTime();
	return dat_To;
}
public void setDat_To(Date dat_To) {
	this.dat_To = dat_To;
}



//ACCOUNT TRANSACTION
 private List<InvoiceTransaction>  listInvoiceTransaction1;
public List<InvoiceTransaction> getListInvoiceTransaction1() {
	
	listInvoiceTransaction1=new ArrayList<InvoiceTransaction>();
	listInvoiceTransaction1.addAll(getAccountsService().listInvoiceTransaction1(str_Accounts,dat_FromDate,dat_ToDate));
	return listInvoiceTransaction1;
	
}
private List<String> listAccountsName;	
private List<ChartOfAccount>  listAccountsName1;
 public List<ChartOfAccount> getListAccountsName1() {
	 listAccountsName1=new ArrayList<ChartOfAccount>();
	 listAccountsName1.addAll(getAccountsService().getAccountTypeList2());
	
	 ListIterator list=listAccountsName1.listIterator();
	 income1=new ArrayList<String>();
	 asset=new ArrayList<String>();
	 expense=new ArrayList<String>();
	 liability=new ArrayList<String>();
	 while(list.hasNext())
	 {
		 ChartOfAccount account=(ChartOfAccount) list.next();
		 String str=account.getStr_AccountName();
		System.out.println(str+"sjjssdjkdkj");
		 char ch=account.getCh_Group();
		System.out.println(ch+"hhjhjhj");
		 if(ch=='A')
		 {
			 asset.add(str);
		 }
		 else if(ch=='E')
		 {
			 expense.add(str);
			 
		 }
		 else if(ch=='R')
		 {
			 income1.add(str);
			 
		 }
		 else
		 {
			 liability.add(str) ;
		 }
	 }
	return listAccountsName1;
}
public void setListAccountsName1(List<ChartOfAccount> listAccountsName1) {
	this.listAccountsName1 = listAccountsName1;
}
public List<String> getListAccountsName() {
	 listAccountsName=new ArrayList<String>();
	 listAccountsName.addAll(getAccountsService().getAccountTypeList1());
	 getListAccountsName1();
	return listAccountsName;
}
public void setListAccountsName(List<String> listAccountsName) {
	this.listAccountsName = listAccountsName;
}
public void setListInvoiceTransaction1(
		List<InvoiceTransaction> listInvoiceTransaction1) {
	this.listInvoiceTransaction1 = listInvoiceTransaction1;
}
private String str_Accounts;
 public String getStr_Accounts() {
	
	 str_Accounts=getAccountsService().getAccountName(id1);
   System.out.println(str_Accounts+"vhhjhj");
	
	 return str_Accounts;
}
public void setStr_Accounts(String str_Accounts) {
	this.str_Accounts = str_Accounts;
}
private double int_Credit;
private double int_Debit;
public double getInt_Credit() {
	
	
	
	int_Credit=getAccountsService().getCreditBalance(id1);
	
	return int_Credit;
}
public void setInt_Credit(double int_Credit) {
	
	this.int_Credit = int_Credit;
}
public double getInt_Debit() {
	
	int_Debit=getAccountsService().getDebitBalance(id1);

	return int_Debit;
}
public void setInt_Debit(double int_Debit) {
	this.int_Debit = int_Debit;
}
private static Integer id1;
public static Integer getId1() {
	return id1;
}
public static void setId1(Integer id1) {
	AccountingBean.id1 = id1;
}
private  String str;

public String getStr() {
	
	
	return str;
}
public void setStr(String str) {
	this.str = str;
}
public void accountchangeListener1(ValueChangeEvent event)
 {
	
	str=(String)event.getNewValue();
    System.out.println(str+"lovejjjjjjjjjjjjjjjjj");
	id1=getAccountsService().getAccountId(str);
	System.out.println(id1+"jhjhj");
}



public void datechangeListener(ValueChangeEvent event)
{   System.out.println("jhjhjj");
	dat_FromDate=(Date)event.getNewValue();
	
}
public void datechangeListener1(ValueChangeEvent event)
{
	dat_ToDate=(Date)event.getNewValue();
	
}
public void datechangeListener2(ValueChangeEvent event)
{    System.out.println("priyyyyyyssssssssssssssssssssssssssssss");
    dat_To=(Date)event.getNewValue();
	
	System.out.println(dat_To+"kkkkkkkkkkklojiuhjjjjjjjjjjjjjjjjjjjjjj");
}
public void datechangeListener3(ValueChangeEvent event)
{    System.out.println("priyyyyyyssssssssss");
dat_From=(Date)event.getNewValue();
System.out.println(dat_From+"jjjjjjjjjjjjjjjjjjjjjjjjjjjlokiiiiiiiiiiiiiiiii");

}
public void getSearch()
{  
	
	
 str_Accounts=getAccountsService().getAccountName1(id1);
 System.out.println(str_Accounts+"juhy");
	
   if(str_Accounts.equals("Accounts Receivable"))
   {
     listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
	listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts,dat_FromDate,dat_ToDate));
	
    
    
	ListIterator list=listInvoiceTransaction.listIterator();
	str_TaxName="Tax Payable";
	
	if(getListInvoiceTransaction1().listIterator().hasNext())
    
	{
	income="true";
	}
	else
	{
		income="false";
	}
	
   }
   getListInvoiceTransaction();
   getListManualJournal1();
   getListExpense();
  getDebit();
  
}
private double debit=0.00;
private double credit=0.00;
public double getCredit() {
	return credit;
}

public void setCredit(double credit) {
	this.credit = credit;
}
public void setDebit(double debit) {
	this.debit = debit;
}
private boolean type1;
private boolean type2;



 public boolean isType1() {
	
	
	return type1;
}
public void setType1(boolean type1) {
	this.type1 = type1;
}
public boolean isType2() {
	
	
	return type2;
}
public double getTotalBalance() {
	return totalBalance;
}
public void setTotalBalance(double totalBalance) {
	this.totalBalance = totalBalance;
}
public void setType2(boolean type2) {
	this.type2 = type2;
}
private double totalBalance1;
public double getTotalBalance1() {
	return totalBalance1;
}
public void setTotalBalance1(double totalBalance1) {
	this.totalBalance1 = totalBalance1;
}
private double totalBalance;
public double getDebit() {
	debit=getInt_Debit();
	credit=getInt_Credit();
	System.out.println(debit+"huy");
	System.out.println(credit+"huy1");
	
	 if(str_Accounts.equalsIgnoreCase("Income from Resident"))
	 { System.out.println(str+"priyadddddddddddddddd");
		if(str==null)
	    {
		ListIterator list=listInvoiceTransaction.listIterator();
	       while(list.hasNext())
	      {
		    Object obj=list.next();
		   InvoiceTransaction invoice=(InvoiceTransaction)obj;
		     double balance1=invoice.getTotalDue();
		
		         credit=credit+balance1;
		      System.out.println(credit+"juhy");
	     
		  
		  
	    
	     }
	       return credit;
	    }
	   else if(str.equalsIgnoreCase("Income from Resident"))
	   {
		  System.out.println(str+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		ListIterator list=listInvoiceTransaction.listIterator();
	       while(list.hasNext())
	     {
		Object obj=list.next();
		InvoiceTransaction invoice=(InvoiceTransaction)obj;
		double balance1=invoice.getTotalDue();
		totalBalance1=invoice.getTaxAmount();
		System.out.println(totalBalance1);
		credit=credit+balance1;
		
		System.out.println(credit+"huy");
	     } 
	   }
	 ListIterator list2=listManualJournal1.listIterator();
	 {  
	    
		 while(list2.hasNext())
		 {
			 ManualJournal journal=(ManualJournal)list2.next();
			 id=journal.getInt_ManualJournalID();
			 System.out.println(id);
			
					 ManualJournal  account=(ManualJournal) getAccountsService().getManualAccount(id);
					
					 String sss=account.getStr_DebitAccount();
					 System.out.println(sss+"hjugt");
					 String sss1=account.getStr_CreditAccount();
					 System.out.println(sss1+"hjuygt");
					
					if(sss1.equalsIgnoreCase(str))
					{
						double balance3=getAccountsService().getDebitAmount(id);
						credit=credit+balance3;
						System.out.println(credit+"123");
					}
					else
					{
					    double balance4=getAccountsService().getCreditAmount(id);
					    debit=debit+balance4;
					    System.out.println(debit+"jjj");
					}
					
				}
		
			 }
	  if(credit>debit)
      {
		 credit=credit-debit;
		 type1=false;
		
		 type2=true;
		 debit=0.00;
		 totalBalance=credit;
		/* ListIterator list=listInvoiceTransaction.listIterator();
		 while(list.hasNext())
		 { System.out.println("jhbfjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		  System.out.println(totalBalance1+"jjjjjjjjjjjjjkkkkkk");
		 totalBalance1=credit-totalBalance1;
		 System.out.println(totalBalance1+"ggggggggggggggggggggggggggggggggggg");
		 getAccountsService().updateClosingBalance(debit,totalBalance1,str,-totalBalance1);	
		 return credit;
		 }
		*/
	   
		 System.out.println(debit+"pp");
		 System.out.println(credit+"jjj");
		 System.out.println(totalBalance+"jkfkjfkj");
		 return totalBalance;
      }
      else
      {
    	  debit=debit-credit;
    	  type1=true;
 		 type2=false;
 		 credit=0.00;
 		 totalBalance=debit;
 		
 		 System.out.println(debit+"pp1"); 
 		 return debit;
      }
	 
	

	
	
	 }

	else if( str_Accounts.equalsIgnoreCase("Accounts Receivable") || str_Accounts.equalsIgnoreCase("Accounts Receivable1"))
	{
		 ListIterator list=listInvoiceTransaction.listIterator();
			while(list.hasNext())
			{   
				if(str_Accounts.equalsIgnoreCase("Accounts Receivable"))
				{
					Object obj=list.next();
					InvoiceTransaction invoice=(InvoiceTransaction)obj;
					double balance1=invoice.getSubTotal();
					System.out.println(balance1);
					double tax=invoice.getTaxAmount();
					System.out.println(tax);
					  debit=debit+balance1+tax;
				
				  System.out.println(debit+"priya");
			
				}
				else
				{
				Object obj=list.next();
				InvoiceTransaction invoice=(InvoiceTransaction)obj;
				double balance1=invoice.getSubTotal();
				
				double tax=invoice.getTaxAmount();
				
				 double balance5=balance1+tax;
				 System.out.println(balance5);
				 debit=debit+balance5;
				
			   System.out.println(debit+"priya1");
			  
	
			    }
				System.out.println(debit+"kuy");
			}
			System.out.println(debit+"kuy1");
			 ListIterator list1=getListInvoiceTransaction1().listIterator();
			 {
				 while(list1.hasNext())
				 {
					 InvoiceTransaction invoice1=(InvoiceTransaction)list1.next();
					 Double balance2=invoice1.getTotalDue();
					
					 credit=credit+balance2;
					 System.out.println(credit+"huyt");
					 
				 }
			 }
			 ListIterator list2=listManualJournal1.listIterator();
			 { 
			   
				 while(list2.hasNext())
				 {
					 ManualJournal journal=(ManualJournal)list2.next();
					 id=journal.getInt_ManualJournalID();
					 System.out.println(id);
					
							 ManualJournal  account=(ManualJournal) getAccountsService().getManualAccount(id);
							
							 String sss=account.getStr_DebitAccount();
							 String sss1=account.getStr_CreditAccount();
							
							if(sss.equalsIgnoreCase(str))
							{
								double balance3=getAccountsService().getDebitAmount(id);
								debit=debit+balance3;
								System.out.println(debit+"123");
							}
							else
							{
							    double balance4=getAccountsService().getCreditAmount(id);
							    credit=credit+balance4;
							    System.out.println(credit+"jjj");
							    System.out.println(debit+"jnjkjkkj");
							}
							
						}
				
					 }
					
			
	
			  if(credit>debit)
	          {
				 credit=credit-debit;
				 totalBalance=credit;
				 type1=false;
				 type2=true;
				 debit=0.00;
				 totalBalance=credit;
				 System.out.println(debit+"pp");
				 System.out.println(credit+"ppp1");
				
				 return credit;
	          }
	          else
	          {
	        	  debit=debit-credit;
	        	  type1=true;
	        	  type2=false;
	        	  totalBalance=debit;
	        	  credit=0.00;
	 			 System.out.println(debit+"pp1");
	 			
	 			 return debit;
	          }
				
			  
			
		
	}		
		
	
	else if(str_Accounts.equalsIgnoreCase(str))
	{   System.out.println(str_Accounts.equalsIgnoreCase(str)+"kiju");
	   ListIterator list2=listManualJournal1.listIterator();
	   System.out.println(listManualJournal1+"kiju");
	  {  
	 System.out.println(listManualJournal1.listIterator().hasNext()+"lokiju");
		  while(list2.hasNext())
		   {
			 ManualJournal journal=(ManualJournal)list2.next();
			 id=journal.getInt_ManualJournalID();
			 System.out.println(id);
			
					 ManualJournal  account=(ManualJournal) getAccountsService().getManualAccount(id);
					
					 String sss=account.getStr_DebitAccount();
					 String sss1=account.getStr_CreditAccount();
					
					if(sss.equalsIgnoreCase(str))
					{
			  	  		double balance3=getAccountsService().getDebitAmount(id);
						debit=debit+balance3;
						System.out.println(debit+"123");
					}
					else
					{
					    double balance4=getAccountsService().getCreditAmount(id);
					    credit=credit+balance4;
					    System.out.println(credit+"jjj");
					}
					
				}
		
		
		
			 }
	ListIterator list4=listExpense.listIterator();
	{
		while(list4.hasNext())
		{
			Expense expense=(Expense)list4.next();
			String account=expense.getStr_AccountName();
			String account1=expense.getStr_ExpenseType();
			if(account.equalsIgnoreCase(str))
			{
			  double balance5=expense.getInt_Ammount();
			   System.out.println(balance5);
			
			   credit=credit+balance5;
			   System.out.println(credit+"huytr");
			}
			else if(account1.equalsIgnoreCase(str))
			{
				double balance6=expense.getInt_Ammount();
				   System.out.println(balance6);
				
				   debit=debit+balance6;
				   System.out.println(debit+"kjihu");
			}
		 }
	}

	
try{	
	
	if(str_Accounts.equalsIgnoreCase(str))
	{  
	  System.out.println(str_Accounts.equalsIgnoreCase(str)+"jiuynnnnnnnnnnnnnnn");
	   if(str_Accounts.equalsIgnoreCase("Bank") || str_Accounts.equalsIgnoreCase("Cash"))
	   {
		  
		 ListIterator list=listInvoiceTransaction.listIterator();
		System.out.println(listInvoiceTransaction+"hujyt");
		 {
			 while(list.hasNext())
			 {   
				 InvoiceTransaction invoice1=(InvoiceTransaction)list.next();
				 Double balance2=invoice1.getTotalDue();
				 totalBalance1=invoice1.getTaxAmount();
				System.out.println(balance2+"kji");
				debit=debit+balance2;
				 System.out.println(debit+"kkk");
				 
			 }
			
			 if(debit>credit)
			 {   System.out.println("sagarika");
				 debit=debit-credit; 
				type1=true;
				 type2=false;
				
				totalBalance=debit;
				 credit=0.00;
				
				 return debit;
			 }
			 else
			 {   System.out.println("malay");
				 credit=credit-debit;
				     type1=false;
					  type2=true;
				 debit=0.00;
				 totalBalance=credit;
				
				 return credit;
			 }
			 
			
		 }
		
	}
	   if(str_Accounts.equalsIgnoreCase("Tax Payable"))
	   {
		 ListIterator list=listInvoiceTransaction.listIterator();
		 System.out.println("Excuse me");
		 {
			 while(list.hasNext())
			 {
				 InvoiceTransaction invoice1=(InvoiceTransaction)list.next();
				
				 totalBalance1=invoice1.getTaxAmount();
				 System.out.println(totalBalance1+"huytjjjjjj");
				
			 }
			
			 if(debit>=credit)
			 {   System.out.println("sai");
				 debit=debit-credit; 
				 type1=true;
				 type2=false;
				// double  debit1=0.00;
				 totalBalance=debit;
			/*	 if(debit<totalBalance1)
				 {
					 
					 credit=totalBalance1-debit;
					System.out.println(credit+"ghytre");
				 getAccountsService().updateClosingBalance(debit1,credit,str,debit1);	
				 return debit;
				 }
				 else
				 {
					 debit1=debit-totalBalance1;
					 credit=0.00;
					 getAccountsService().updateClosingBalance(debit1,credit,str,debit1);	
					 return debit;
				 }  */
				
				 return debit;
			 }
			 else
			 {   System.out.println("simran");
				 credit=credit-debit;
				 System.out.println(credit+"jjj");
				 type1=false;
				 type2=true;
				 debit=0.00;
				 totalBalance=credit;
				// double credit1=0.00;
				// credit1=totalBalance1+credit;
				
				 return totalBalance;
			 }
			 
			
		 }
		
	 }
	   if(debit>credit)
		 {   System.out.println("swadhin");
			 debit=debit-credit; 
			 System.out.println(debit);
			 type1=true;
			 type2=false;
			 credit=0.00;
			totalBalance=debit;
			if(str_Accounts.equalsIgnoreCase("Opening Balance Adjustment"))
			{
			
			 return debit;
			}
			else
			{
				
				 return debit;
			}
		 }
		 else
		  {   System.out.println("rosy");
			 credit=credit-debit;
			 type1=false;
			 type2=true;
			 debit=0.00;
			 totalBalance=credit;
			 if(str_Accounts.equalsIgnoreCase("Opening Balance Adjustment")) 
			 {
			
			 return credit;
			 }
			 else
			 {
				
				 return credit; 
			 }
		 }
   
     
	}
	}
	catch(Exception e)
	{
		e.getMessage();
	}
}
return debit;
	
}
	

private List<InvoiceTransaction>  listInvoiceTransaction;
public List<InvoiceTransaction> getListInvoiceTransaction() {
	
	try{
	listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
	
	listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts,dat_FromDate,dat_ToDate));
	
	ListIterator list=listInvoiceTransaction.listIterator();
	
	while(list.hasNext())
	{
		
		InvoiceTransaction invoice=(InvoiceTransaction)list.next();
		
		double id=invoice.getSubTotal();
		type="Income";
	   
	}
	
	return  listInvoiceTransaction;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return  null;
}
public void setListInvoiceTransaction(
		List<InvoiceTransaction> listInvoiceTransaction) {
	this.listInvoiceTransaction = listInvoiceTransaction;
}
private double int_blank;
private double int_blank1;
public double getInt_blank() {
	return int_blank;
}
public void setInt_blank(double int_blank) {
	this.int_blank = int_blank;
}
public double getInt_blank1() {
	return int_blank1;
}
public void setInt_blank1(double int_blank1) {
	this.int_blank1 = int_blank1;
}
private String str_TaxName;
public String getStr_TaxName() {
	
	return str_TaxName;
}
public void setStr_TaxName(String str_TaxName) {
	this.str_TaxName = str_TaxName;
}
private String type;
public String getType() {
	
	return type;
}
public void setType(String type) {
	this.type = type;
}
private String date;
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
private String income;
public String getIncome() {
	return income;
}
public void setIncome(String income) {
	this.income = income;
}
private List<ManualJournal> listManualJournal1;

public List<ManualJournal> getListManualJournal1() {
	listManualJournal1=new ArrayList<ManualJournal>();
	listManualJournal1.addAll(getAccountsService().getlistManualJournal1(str,dat_FromDate,dat_ToDate));
	
	return listManualJournal1;
}
public void setListManualJournal1(List<ManualJournal> listManualJournal1) {
	  this.listManualJournal1 = listManualJournal1;
}
public List<Expense>   listExpense;
public List<Expense> getListExpense() {
	listExpense=new ArrayList<Expense>();
	 listExpense.addAll(getAccountsService().getExpenseList(str,dat_FromDate,dat_ToDate));
	 return listExpense;
}
public void setListExpense(List<Expense> listExpense) {
	this.listExpense = listExpense;
}
@ManagedProperty(value = "#{TemplateService}")
private TemplateService templateService;
public TemplateService getTemplateService() {
	return templateService;
}
public void setTemplateService(TemplateService templateService) {
	this.templateService = templateService;
}
/*
 * chart of accounts concept
 */
private Integer  int_AccountId;
private String str_OrganizationName;
private String str_AccountName;
private String str_AccountType;
private String str_AccountName1;
private String str_AccountType1;
public String getStr_AccountName1() {
	return str_AccountName1;
}
public void setStr_AccountName1(String str_AccountName1) {
	this.str_AccountName1 = str_AccountName1;
}
public String getStr_AccountType1() {
	return str_AccountType1;
}
public void setStr_AccountType1(String str_AccountType1) {
	this.str_AccountType1 = str_AccountType1;
}
private Integer int_UserId;
public Integer getInt_AccountId() {
	return int_AccountId;
}
public void setInt_AccountId(Integer int_AccountId) {
	this.int_AccountId = int_AccountId;
}
public String getStr_OrganizationName() {
	str_OrganizationName=Util.getAppartmentName();
	return str_OrganizationName;
}
public void setStr_OrganizationName(String str_OrganizationName) {
	this.str_OrganizationName = str_OrganizationName;
}


public String getStr_AccountName() {
	return str_AccountName;
}
public void setStr_AccountName(String str_AccountName) {
	this.str_AccountName = str_AccountName;
}
public Integer getInt_UserId() {
	return int_UserId;
}
public void setInt_UserId(Integer int_UserId) {
	this.int_UserId = int_UserId;
}
private AccountingGroup accountGroup;


public AccountingGroup getAccountGroup() {
	return accountGroup;
}
public void setAccountGroup(AccountingGroup accountGroup) {
	this.accountGroup = accountGroup;
}

private Character ch_Group;

 
 public Character getCh_Group() {
	return ch_Group;
}
public void setCh_Group(Character ch_Group) {
	this.ch_Group = ch_Group;
}


public String getStr_AccountType() {
	return str_AccountType;
}
public void setStr_AccountType(String str_AccountType) {
	this.str_AccountType = str_AccountType;
} 
public void accountchangeListener(ValueChangeEvent event){
	
	
	str_AccountType =(String) event.getNewValue();
	System.out.println(str_AccountType+"jjkkjkjkjjk");
	ch_Group=getAccountsService().getChGroup(str_AccountType);
	System.out.println(ch_Group+"hjjhjhhj");
	
} 
private List<String> listAccountsType;

public List<String> getListAccountsType() {
	listAccountsType=new ArrayList<String>();
	listAccountsType.addAll(getAccountsService().getAccountTypeList());
	return listAccountsType;
}
public void setListAccountsType(List<String> listAccountsType) {
	this.listAccountsType = listAccountsType;
}
public String saveChartOfAccount()
{   System.out.println("jkfjkgfgjk");

ChartOfAccount chartOfAccount=new ChartOfAccount();
	chartOfAccount.setInt_UserId(Util.getUserId());
	chartOfAccount.setInt_ApartmentId(Util.getAppartmentId());
	System.out.println(str_AccountName+"hjjjkjk");
	chartOfAccount.setStr_AccountName(str_AccountName);
	System.out.println(str_AccountType+"skdskjdkdf");
	chartOfAccount.setStr_AccountType(str_AccountType);
	System.out.println(ch_Group+"jhjhjh");
	chartOfAccount.setCh_Group(ch_Group);
	getAccountsService().saveChartOfAccount(chartOfAccount);
	AccountsOpeningBalance balance=new AccountsOpeningBalance();
	balance.setInt_Debit(int_Debit);
	balance.setInt_Credit(int_Credit);
	balance.setInt_ApartmentID(Util.getAppartmentId());
	balance.setStr_AccountsHead(str_AccountName);
	getAccountsService().saveOpeningAccount(balance);
	return "chartofaccount.xhtml";
	
	
	
}
private double debitNetTotal=0.00;
private double creditNetTotal=0.00;

public double getDebitNetTotal() {
	return debitNetTotal;
}
public void setDebitNetTotal(double debitNetTotal) {
	this.debitNetTotal = debitNetTotal;
}
public double getCreditNetTotal() {
	return creditNetTotal;
}
public void setCreditNetTotal(double creditNetTotal) {
	this.creditNetTotal = creditNetTotal;
}
private ChartOfAccount chartOfAccount;

public ChartOfAccount getChartOfAccount() {
	return chartOfAccount;
}
public void setChartOfAccount(ChartOfAccount chartOfAccount) {
	this.chartOfAccount = chartOfAccount;
}

private List<String> income1;
public List<String> getIncome1() {
	
	
	return income1;
	
}

public List<String> getAsset() {
	
	
	return asset;
}



public void setIncome1(List<String> income1) {
	this.income1 = income1;
}
private List<String> asset;


private List<String> expense;
public List<String> getExpense() {
	
	return expense;
}

private List<String> liability;
private List<String> equity;
public List<String> getLiability() {
	
	
	return liability;
}

public List<String> getEquity() {
	
	return equity;
}

public void setAsset(List<String> asset) {
	this.asset = asset;
}
public void setExpense(List<String> expense) {
	this.expense = expense;
}
public void setLiability(List<String> liability) {
	this.liability = liability;
}
public void setEquity(List<String> equity) {
	this.equity = equity;
}
private List<ManualJournal> listManualJournal2;
public List<ManualJournal> getListManualJournal2() {
	
	return listManualJournal2;
}
public void setListManualJournal2(List<ManualJournal> listManualJournal2) {
	this.listManualJournal2 = listManualJournal2;
}
private List<InvoiceTransaction>  listInvoiceTransaction2;
private List<String>   income2;
private List<String>   expense2;
public List<String> getIncome2() {
	income2=getAccountsService().getIncome();
	
	return income2;
}
public void setIncome2(List<String> income2) {
	this.income2 = income2;
}
public List<String> getExpense2() {
	expense2=getAccountsService().getExpense1();
	return expense2;
}
public void setExpense2(List<String> expense2) {
	this.expense2 = expense2;
}
private double totalIncome1=0.00;
public double getTotalIncome1() {
	return totalIncome1;
}
public void setTotalIncome1(double totalIncome1) {
	this.totalIncome1 = totalIncome1;
}
private  double totalIncome2=0.00;
public double getTotalIncome2() {
	return totalIncome2;
}
public void setTotalIncome2(double totalIncome2) {
	this.totalIncome2 = totalIncome2;
}
private String incomeCrditAccount;

public String getIncomeCrditAccount() {
	return incomeCrditAccount;
}
public void setIncomeCrditAccount(String incomeCrditAccount) {
	this.incomeCrditAccount = incomeCrditAccount;
}
public String getIncomeAccount() {
	return incomeAccount;
}
public void setIncomeAccount(String incomeAccount) {
	this.incomeAccount = incomeAccount;
}
private String incomeAccount;
public List<InvoiceTransaction> getListInvoiceTransaction2() {
	totalIncome2=0.00;
	totalIncome1=0.00;
	System.out.println(dat_From+"jjj");
	System.out.println(dat_To+"hujy");
	try{
    listInvoiceTransaction2=new ArrayList<InvoiceTransaction>();
	
	listInvoiceTransaction2.addAll(getAccountsService().listInvoiceTransaction2(dat_From,dat_To));
	System.out.println("jdfjfjffjffj");
	ListIterator list=listInvoiceTransaction2.listIterator();
	totalIncome=new ArrayList<Double>();
	while(list.hasNext())
	{
		
		InvoiceTransaction invoice=(InvoiceTransaction)list.next();
		
		double id=invoice.getTotalDue();
		
	    totalIncome1=totalIncome1+id;
	    System.out.println(totalIncome1+"kkkk");
	   
	}
	 getIncome2();
		
	 ListIterator list1=income2.listIterator();
	 while(list1.hasNext())
	 {
		 incomeCrditAccount=(String)list1.next();
		 System.out.println(incomeCrditAccount);
		 
	   listManualJournal2=new ArrayList<ManualJournal>();
	  listManualJournal2.addAll(getAccountsService().getlistManualJournal2(incomeCrditAccount,dat_From,dat_To));
	  if(listManualJournal2.listIterator().hasNext())
	  {
	    ListIterator list2=listManualJournal2.listIterator();
	    while(list2.hasNext())
	    	
		
		   {
			 ManualJournal journal=(ManualJournal)list2.next();
			 id=journal.getInt_ManualJournalID();
			 System.out.println(id);
			 ManualJournal  account=(ManualJournal) getAccountsService().getManualAccount(id);
				
				
			 incomeAccount=account.getStr_CreditAccount();
			 System.out.println(incomeAccount+"hjuygt");
			double balance3=account.getDbl_CreditAmount();
				 if(incomeAccount.equalsIgnoreCase("Income from Resident"))
					{System.out.println("jfdjkfdjfjfd");
					 totalIncome1=totalIncome1+balance3;
					 System.out.println(totalIncome1+"jjjj");
					}
				 else
				 {
					System.out.println("jkdfkjfkjg");
					 totalIncome2=totalIncome2+balance3;
					 System.out.println(totalIncome2+"jjkjkjk");
				 }
				 
		    }		
	  
	    totalIncome.add(totalIncome2);
	  }					  
	  else if(incomeCrditAccount.equalsIgnoreCase("Income from Resident"))
	  {   System.out.println("jdfjkdfjfjj");
		  totalIncome.add(totalIncome1);			  
	  }
	  else
	  {   System.out.println("hhffhfh");
	  System.out.println(totalIncome2+"kjfkffdk");
		  totalIncome.add(totalIncome2);	 
	  }						
					
					
	
					
				
	    
	
	    
	 }	
	 totalIncome2=totalIncome2+totalIncome1;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return listInvoiceTransaction2;
}
public void setListInvoiceTransaction2(
		List<InvoiceTransaction> listInvoiceTransaction2) {
	this.listInvoiceTransaction2 = listInvoiceTransaction2;
}
private List<ManualJournal> listManualJournal3;
public List<ManualJournal> getListManualJournal3() {
	return listManualJournal3;
}
public void setListManualJournal3(List<ManualJournal> listManualJournal3) {
	this.listManualJournal3 = listManualJournal3;
}
private List<Double>   expenseAmount1;
public List<Double> getExpenseAmount1() {
	return expenseAmount1;
}
public void setExpenseAmount1(List<Double> expenseAmount1) {
	this.expenseAmount1 = expenseAmount1;
}
private List<Expense> expenseList;
public List<Expense> getExpenseList() {
	expenseList=new ArrayList<Expense>();
	debitNetTotal=0.00;
	expenseList.addAll(getAccountsService().expenseList(dat_From,dat_To));
	expenseAmount1=new ArrayList<Double>();
	ListIterator list=expenseList.listIterator();
	while(list.hasNext())
	{
		Expense expense=(Expense) list.next();
		double ddd=expense.getInt_Ammount();
		debitNetTotal=debitNetTotal+ddd;
		
	}	
	System.out.println(debitNetTotal+"kjdfkdfk");
	 getExpense2();
	 ListIterator list1=expense2.listIterator();
	 while(list1.hasNext())
	 {
		 String str=(String)list1.next();
		 System.out.println(str);
	   listManualJournal3=new ArrayList<ManualJournal>();
 	   listManualJournal3.addAll(getAccountsService().getlistManualJournal3(str,dat_From,dat_To));
 	   if(listManualJournal3.listIterator().hasNext())
 	   {
	  ListIterator list2=listManualJournal3.listIterator();
	  
	    
		 while(list2.hasNext())
		 {
			 ManualJournal journal=(ManualJournal)list2.next();
			 id=journal.getInt_ManualJournalID();
			 System.out.println(id);
			
					 ManualJournal  account=(ManualJournal) getAccountsService().getManualAccount(id);
					
					 String sss=account.getStr_DebitAccount();
						double balance3=account.getDbl_DebitAmount();
					 System.out.println(sss+"hjuygt");
					
					   if(sss.equalsIgnoreCase("Expense"))
					    {
						
						debitNetTotal=debitNetTotal+balance3;
						System.out.println(debitNetTotal+"123fghj");
						
					    }
					
					   
				     }
		 expenseAmount1.add(debitNetTotal);
	       }
	
	 
	 else
	   {
		 expenseAmount1.add(debitNetTotal); 
	   }
	 }
	return expenseList;
}
public void setExpenseList(List<Expense> expenseList) {
	this.expenseList = expenseList;
}
private List<Double> expenseAmount;
public List<Double> getExpenseAmount() {
	expenseAmount=new ArrayList<Double>();
	expenseAmount.addAll(getAccountsService().getExpenseAmount());
	System.out.println(expenseAmount+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjdddddddddddddddddddddd");
	ListIterator list=expenseAmount.listIterator();
	netProfit2=0.00;
	while(list.hasNext())
	{
		double id=(Double)list.next();
		netProfit2=netProfit2+id;
		System.out.println(netProfit2+"gggggggggggg");
	}
	 getExpense2();
	 ListIterator list1=expense2.listIterator();
	 while(list1.hasNext())
	 {
		 String str=(String)list1.next();
		 System.out.println(str);
	listManualJournal3=new ArrayList<ManualJournal>();
	listManualJournal3.addAll(getAccountsService().getlistManualJournal3(str,dat_From,dat_To));
	 ListIterator list2=listManualJournal3.listIterator();
	
	    
		 while(list2.hasNext())
		 {
			 ManualJournal journal=(ManualJournal)list2.next();
			 id=journal.getInt_ManualJournalID();
			 System.out.println(id);
			
					 ManualJournal  account=(ManualJournal) getAccountsService().getManualAccount(id);
					
					 String sss=account.getStr_DebitAccount();
					 System.out.println(sss+"hjugt");
					 double balance3=account.getDbl_DebitAmount();
					
					if(sss.equalsIgnoreCase(str))
					{
						
						netProfit2=netProfit2+balance3;
						System.out.println(netProfit2+"123fghj");
					}
				
					
				}
	 }
	return expenseAmount;
}
private List<Double> totalIncome;

public List<Double> getTotalIncome() {
	return totalIncome;
}
public void setTotalIncome(List<Double> totalIncome) {
	this.totalIncome = totalIncome;
}
public double netProfit3;
public double getNetProfit3() {
	indicator="Profit";
	netProfit3=totalIncome2-debitNetTotal;
	return netProfit3;
}
public void setNetProfit3(double netProfit3) {
	this.netProfit3 = netProfit3;
}
private List<Double>  incomeAmount;
public List<Double> getIncomeAmount() {
	incomeAmount=new ArrayList<Double>();
	incomeAmount.addAll(getAccountsService().getIncomeAmount(dat_To));
	System.out.println(incomeAmount+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	ListIterator list=incomeAmount.listIterator();
	totalIncome1=0.00;
	while(list.hasNext())
	{
		double balance=(Double)list.next();
		totalIncome1=totalIncome1+balance;
		System.out.println(totalIncome1+"ggggggggggggsssssssss");
	}
	 getIncome2();
		
	 ListIterator list1=income2.listIterator();
	 while(list1.hasNext())
	 {
		 String str=(String)list1.next();
		 System.out.println(str);
	listManualJournal2=new ArrayList<ManualJournal>();
	listManualJournal2.addAll(getAccountsService().getlistManualJournal2(str,dat_From,dat_To));
	 ListIterator list2=listManualJournal2.listIterator();
	
	    
		 while(list2.hasNext())
		 {
			 ManualJournal journal=(ManualJournal)list2.next();
			 id=journal.getInt_ManualJournalID();
			 System.out.println(id);
			
					 ManualJournal  account=(ManualJournal) getAccountsService().getManualAccount(id);
					
					
					 String sss1=account.getStr_CreditAccount();
					 System.out.println(sss1+"hjuygt");
					 double balance3=account.getDbl_CreditAmount();
					if(sss1.equalsIgnoreCase(str))
					{
						
						totalIncome1=totalIncome1+balance3;
						System.out.println(totalIncome1+"123fghj");
					}
				
					
				}
	}
	return incomeAmount;
}
public void setIncomeAmount(List<Double> incomeAmount) {
	this.incomeAmount = incomeAmount;
}
private String indicator;
public String getIndicator() {
	
	return indicator;
}
public void setIndicator(String indicator) {
	this.indicator = indicator;
}
public void setExpenseAmount(List<Double> expenseAmount) {
	this.expenseAmount = expenseAmount;
}
public double netProfit;
public double getNetProfit() {
	getIncomeAmount();
	getExpenseAmount();
	
	if(totalIncome1>netProfit2)
	{   System.out.println(totalIncome1+"hhhhhhhhhhhhhh");
	    System.out.println(netProfit2+"hhhhhhjjjjjjjjjjj");
		indicator="Profit";
		netProfit=totalIncome1-netProfit2;
	}
	return netProfit;
}
public void setNetProfit(double netProfit) {
	this.netProfit = netProfit;
}
public  double netProfit1;
public  double getNetProfit1() {
	netProfit1=netProfit+int_blank;
	return netProfit1;
}
public  void setNetProfit1(double netProfit1) {
	this.netProfit1 = netProfit1;
}
private double netProfit2=0.00;
public double getNetProfit2() {
	
	return netProfit2;
}
public void setNetProfit2(double netProfit2) {
	this.netProfit2 = netProfit2;
}
public String reset(){
	return "manualjournal.xhtml";
}
//TRIALBALANCE
private List<SelectItem> dates;
public List<SelectItem> getDates() {
	return dates;
}
public void setDates(List<SelectItem> dates) {
	this.dates = dates;
}
@PostConstruct
public void init() {
    //cars
    SelectItemGroup g1 = new SelectItemGroup("Current");
    g1.setSelectItems(new SelectItem[] {new SelectItem("Today", "Today"), new SelectItem("This Week End", "This Week End"), new SelectItem("This Month End", "This Month End"),new SelectItem("This Quarter End", "This Quarter End"),new SelectItem("This Year End", "This Year End")});
     
    SelectItemGroup g2 = new SelectItemGroup("Previous");
    g2.setSelectItems(new SelectItem[] {new SelectItem("Yesterday", "Yesterday"), new SelectItem("Previous Week End", "Previous Week End"), new SelectItem("Previous Month End", "Previous Month End"),new SelectItem("Previous Quarter End", "Previous Quarter End"),new SelectItem("Previous Year End", "Previous Year End")});
     
    SelectItemGroup g3 = new SelectItemGroup("Custom");
    g3.setSelectItems(new SelectItem[] {new SelectItem("Custom", "Custom")});
    dates = new ArrayList<SelectItem>();
    dates.add(g1);
    dates.add(g2);
    dates.add(g3);
    getListInvoiceTransaction2(); 
    getExpenseList(); 
    getSearch2();
    getSearch3();
  
}
private String date4;
public String getDate4() {
	return date4;
}
public void setDate4(String date4) {
	this.date4 = date4;
}
private Date date3=getDat_From();
public Date getDate3() {
	return date3;
}
public void setDate3(Date date3) {
	this.date3 = date3;
}
private Date date5=getDat_To();
public Date getDate5() {
	return date5;
}
public void setDate5(Date date5) {
	this.date5 = date5;
}
public void getSearch1(){
	getExpenseList();
	getListInvoiceTransaction2();
	
}

public Date accountchangeListener3(ValueChangeEvent event)
{
	System.out.println("hjjhjhjk");
	str=(String)event.getNewValue();
  
   if(str.equalsIgnoreCase("This Week End"))
		   {
	   Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		
		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;
		   }
   else if(str.equalsIgnoreCase("This Month End"))
   {
	   Calendar c = Calendar.getInstance();
	 		
	 		c.getActualMaximum(Calendar.DAY_OF_MONTH);
	 		c.add(Calendar.MONTH, 1);  
	        c.set(Calendar.DAY_OF_MONTH, 1);  
	        c.add(Calendar.DATE, -1);  

	 		dat_ToDate=c.getTime();
	 		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
	 		return dat_ToDate; 
   }
   else if(str.equalsIgnoreCase("This Quarter End"))
   {  
   Calendar c = Calendar.getInstance();
	c.setTime(dat_ToDate);
	int factor = 0;
	int month = c.get(Calendar.MONTH);
	if (month == Calendar.JANUARY
		|| month == Calendar.APRIL
		|| month == Calendar.JULY
		|| month == Calendar.OCTOBER) {
		factor = 2;
	} else if (
		month == Calendar.FEBRUARY
		|| month == Calendar.MAY
		|| month == Calendar.AUGUST
		|| month == Calendar.NOVEMBER) {
		factor = 1;
		} else {
			factor = 0;
	}

	c.add(Calendar.MONTH, factor);
	c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
	dat_ToDate=c.getTime();
	return dat_ToDate;
}
   
   else if(str.equalsIgnoreCase("This Year End"))
   {
	   Calendar c = Calendar.getInstance();
		
		c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int year=c.getWeekYear()+1;
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, 2); 
		c.set(Calendar.DAY_OF_MONTH, 31); // new years eve


		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;  
   }
   else if(str.equalsIgnoreCase("Yesterday"))
   {
	   Calendar c = Calendar.getInstance();
	   c.add(Calendar.DATE, -1);
		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;
   }
   else if(str.equalsIgnoreCase("Custom"))
   {  dat_ToDate=null;
	  return dat_ToDate;
   }
   else if(str.equalsIgnoreCase("Previous Week End"))
   {
	   Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		c.set(Calendar.DATE,-1);
		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;
   }
   else if(str.equalsIgnoreCase("Previous Month End"))
   {
	   Calendar aCalendar = Calendar.getInstance();
	   aCalendar.set(Calendar.DATE, 1);
	   aCalendar.add(Calendar.DAY_OF_MONTH, -1);
	   dat_ToDate = aCalendar.getTime();
	   System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
	   
   }
   else if(str.equalsIgnoreCase("Previous Quarter End"))
   {
	   Calendar c = Calendar.getInstance();
	   c.add(Calendar.MONTH,-3);
		int factor = 0;
		int month = c.get(Calendar.MONTH);
		if (month == Calendar.JANUARY
			|| month == Calendar.APRIL
			|| month == Calendar.JULY
			|| month == Calendar.OCTOBER) {
			factor = 2;
		} else if (
			month == Calendar.FEBRUARY
			|| month == Calendar.MAY
			|| month == Calendar.AUGUST
			|| month == Calendar.NOVEMBER) {
			factor = 1;
			} else {
				factor = 0;
		}

		c.add(Calendar.MONTH, factor);
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
		dat_ToDate=c.getTime();
		return dat_ToDate;
	   
   }
   else if(str.equalsIgnoreCase("Previous Year End"))
   {
	   Calendar c = Calendar.getInstance();
		
		
		int year=c.getWeekYear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, 2); 
		c.set(Calendar.DAY_OF_MONTH, 31); // new years eve


		dat_ToDate=c.getTime();
		System.out.println(dat_ToDate+"hhhhhhhhhhhhhhhhhhhh");
		return dat_ToDate;  
   }
    return null;
	
}
private List<Double>  assetDebitBalance;
private List<Double>  assetCreditBalance;
private List<Double>  incomeDebitBalance;
private List<Double>  expenseDebitBalance;
private List<Double>  expenseCreditBalance;
private List<Double>   liabilityDebitBalance;
private List<Double>   liabilityCreditBalance;
private List<Double>    assetBalance;
private List<Double>    liabilityBalance;
public List<Double> getExpenseDebitBalance() {
	return expenseDebitBalance;
}
public void setExpenseDebitBalance(List<Double> expenseDebitBalance) {
	this.expenseDebitBalance = expenseDebitBalance;
}
public List<Double> getExpenseCreditBalance() {
	return expenseCreditBalance;
}
public void setExpenseCreditBalance(List<Double> expenseCreditBalance) {
	this.expenseCreditBalance = expenseCreditBalance;
}
public List<Double> getLiabilityDebitBalance() {
	return liabilityDebitBalance;
}
public void setLiabilityDebitBalance(List<Double> liabilityDebitBalance) {
	this.liabilityDebitBalance = liabilityDebitBalance;
}
public List<Double> getLiabilityCreditBalance() {
	return liabilityCreditBalance;
}
public void setLiabilityCreditBalance(List<Double> liabilityCreditBalance) {
	this.liabilityCreditBalance = liabilityCreditBalance;
}
public List<Double> getIncomeDebitBalance() {
	return incomeDebitBalance;
}
public void setIncomeDebitBalance(List<Double> incomeDebitBalance) {
	this.incomeDebitBalance = incomeDebitBalance;
}
private List<Double>  incomeCreditBalance;
public List<Double> getIncomeCreditBalance() {
	return incomeCreditBalance;
}
public void setIncomeCreditBalance(List<Double> incomeCreditBalance) {
	this.incomeCreditBalance = incomeCreditBalance;
}
public List<Double> getAssetDebitBalance() {
	return assetDebitBalance;
}
public void setAssetDebitBalance(List<Double> assetDebitBalance) {
	this.assetDebitBalance = assetDebitBalance;
}
public List<Double> getAssetCreditBalance() {
	return assetCreditBalance;
}
public void setAssetCreditBalance(List<Double> assetCreditBalance) {
	this.assetCreditBalance = assetCreditBalance;
}
private double debitNetTotal1=0.00;
public double getDebitNetTotal1() {
	return debitNetTotal1;
}
public void setDebitNetTotal1(double debitNetTotal1) {
	this.debitNetTotal1 = debitNetTotal1;
}
public void getSearch2()
{    
	getListAccountsName1();
	assetDebitBalance=new ArrayList<Double>();
	assetCreditBalance=new ArrayList<Double>();
	
	ListIterator list=asset.listIterator();
	ListIterator list1=income1.listIterator();
	ListIterator list2=expense.listIterator();
	ListIterator list3=liability.listIterator();
	debitNetTotal1=0.00;
	creditNetTotal=0.00;
	while(list.hasNext())
	{
		String str=(String)list.next();
		System.out.println(str);
		Double balance=getAccountsService().getCreditAmount(str,dat_ToDate);
		
		System.out.println(balance+"jkjjkjk");
		
		
		Double balance1=getAccountsService().getDebitAmount(str,dat_ToDate);
		System.out.println(balance1+"kjfgfgg");
	     if(balance1 > balance)
	     {
	    	balance1=balance1-balance; 
	    	balance=0.00;
	    	
	     }
	     else
	     {
	    	 balance=balance-balance1;
	    	 balance1=0.00;
	    	
	     }
	
		assetDebitBalance.add(balance1);
		
		
		assetCreditBalance.add(balance);
		creditNetTotal=creditNetTotal+balance;
		debitNetTotal1=debitNetTotal1+balance1;
		
		
	}
	incomeDebitBalance=new ArrayList<Double>();
	incomeCreditBalance=new ArrayList<Double>();
	while(list1.hasNext())
	{
		String str=(String)list1.next();
		System.out.println(str);
		Double balance=getAccountsService().getCreditAmount(str,dat_ToDate);
		Double balance1=getAccountsService().getDebitAmount(str,dat_ToDate);
		System.out.println(balance1+"kjfgfgg");
		System.out.println(balance+"jkjjkjk");
		 if(balance1 > balance)
	     {
	    	balance1=balance1-balance; 
	    	balance=0.00;
	     }
	     else
	     {
	    	 balance=balance-balance1;
	    	 balance1=0.00;
	     }
		debitNetTotal1=debitNetTotal1+balance1;
		incomeDebitBalance.add(balance1);
		creditNetTotal=creditNetTotal+balance;
		incomeCreditBalance.add(balance);
		
	}
	expenseDebitBalance=new ArrayList<Double>();
	expenseCreditBalance=new ArrayList<Double>();
	while(list2.hasNext())
	{
		String str=(String)list2.next();
		System.out.println(str);
		Double balance=getAccountsService().getCreditAmount(str,dat_ToDate);
		
		Double balance1=getAccountsService().getDebitAmount(str,dat_ToDate);
		System.out.println(balance1+"kjfgfgg");
		System.out.println(balance+"jkjjkjk");
		 if(balance1 > balance)
	     {
	    	balance1=balance1-balance; 
	    	balance=0.00;
	     }
	     else
	     {
	    	 balance=balance-balance1;
	    	 balance1=0.00;
	     }
		expenseDebitBalance.add(balance1);
		debitNetTotal1=debitNetTotal1+balance1;
		expenseCreditBalance.add(balance);
		creditNetTotal=creditNetTotal+balance;
		
	}
	liabilityDebitBalance=new ArrayList<Double>();
	liabilityCreditBalance=new ArrayList<Double>();
	
	while(list3.hasNext())
	{    System.out.println(dat_ToDate+"jjkjkjk");
		String str=(String)list3.next();
		System.out.println(str);
		Double balance=getAccountsService().getCreditAmount(str,dat_ToDate);
		
		Double balance1=getAccountsService().getDebitAmount(str,dat_ToDate);
		System.out.println(balance1+"kjfgfgg");
		System.out.println(balance+"jkjjkjk");
		 if(balance1 > balance)
	     {
	    	balance1=balance1-balance; 
	    	balance=0.00;
	    	
	     }
	     else
	     {
	    	 balance=balance-balance1;
	    	 balance1=0.00;
	    	
	     }
		liabilityDebitBalance.add(balance1);
		debitNetTotal1=debitNetTotal1+balance1;
		liabilityCreditBalance.add(balance);
		creditNetTotal=creditNetTotal+balance;
		
	}
	
}
public List<Double> getAssetBalance() {
	return assetBalance;
}
public void setAssetBalance(List<Double> assetBalance) {
	this.assetBalance = assetBalance;
}
public List<Double> getLiabilityBalance() {
	return liabilityBalance;
}
public void setLiabilityBalance(List<Double> liabilityBalance) {
	this.liabilityBalance = liabilityBalance;
}
public void getSearch3()
{
	getListAccountsName1();
	assetBalance=new ArrayList<Double>();
	ListIterator list=asset.listIterator();
	ListIterator list3=liability.listIterator();
	System.out.println(dat_To+"hjhjjhjjj");
	while(list.hasNext())
	{
		String str=(String)list.next();
		System.out.println(str);
		Double balance=getAccountsService().getCreditAmount(str,dat_To);
		
		System.out.println(balance+"jkjjkjk");
		
		
		Double balance1=getAccountsService().getDebitAmount(str,dat_To);
		System.out.println(balance1+"kjfgfgg");
	     if(balance1 > balance)
	     {
	    	balance1=balance1-balance; 
	    	balance=0.00;
	    	assetBalance.add(balance1);
	     }
	     else
	     {
	    	 balance=balance-balance1;
	    	 balance1=0.00;
	    	 if(balance==0.00)
	    	 {
	    		 assetBalance.add(balance); 
	    	 }
	    	 else
	    	 {
	    	 assetBalance.add(-balance);
	    	 }
	     }
	}
	liabilityBalance=new ArrayList<Double>();
	while(list3.hasNext())
	{    System.out.println(dat_ToDate+"jjkjkjk");
		String str=(String)list3.next();
		System.out.println(str);
		Double balance=getAccountsService().getCreditAmount(str,dat_To);
		
		Double balance1=getAccountsService().getDebitAmount(str,dat_To);
		System.out.println(balance1+"kjfgfgg");
		System.out.println(balance+"jkjjkjk");
		 if(balance1 > balance)
	     {
	    	balance1=balance1-balance; 
	    	balance=0.00;
	    	 if(balance1==0.00)
	    	 {
	    		 assetBalance.add(balance1); 
	    	 }
	    	 else
	    	 {
	    		 liabilityBalance.add(-balance1); 
	    	 }
	    	
	     }
	     else
	     {
	    	 balance=balance-balance1;
	    	 balance1=0.00;
	    	 liabilityBalance.add(balance);
	     }
	}
	ListIterator list5=assetBalance.listIterator();
	int_blank1=0.00;
	while(list5.hasNext())
	{
		double balance =(double) list5.next();
		int_blank1=int_blank1+balance;
		System.out.println(int_blank1+"hhjhj");
	}
	ListIterator list6=liabilityBalance.listIterator();
	int_blank=0.00;
	while(list6.hasNext())
	{
		double balance1 =(double) list6.next();
		int_blank=int_blank+balance1;
		System.out.println(int_blank+"hhjhj123");
	}
}

	
}


