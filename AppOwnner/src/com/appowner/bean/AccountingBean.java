package com.appowner.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.component.datatable.DataTable;

import com.appowner.model.AccountingGroup;
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
private Date dat_ToDate;
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
	 c.setTime(d); 
	 c.add(Calendar.DATE, -1);
	 d= c.getTime();
	 String str=ft.format(d);
		
		return str;
	
	
}
public void setDat_FromDate1(String dat_FromDate1) {
	this.dat_FromDate1 = dat_FromDate1;
}
public Date getDat_FromDate() {
	dat_FromDate=new java.util.Date();
	
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MONTH, -1);
	dat_FromDate = cal.getTime();
    
	return dat_FromDate;
}

public Date getDat_ToDate() {
	dat_ToDate=new java.util.Date();
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
	dat_Date=new java.util.Date();
	
	
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
private String str_Organisation;
private Date dat_Date;
private String str_Reference;
private String str_Notes;
private String str_DebitAccount;
private String str_CreditAccount;
private Double str_DebitAmount;
private Double str_CreditAmount;
public void addInvoiceManualJournal() throws AccountingBean
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
    System.out.println(getStr_CreditAmount());
    System.out.println(getStr_DebitAmount()==getStr_CreditAmount());
   
    
    	 getAccountsService().addManualJournal(journal);
   
   
    
    }
  catch(Exception e)
  {
	throw new  AccountingBean("CreditAmount Should be Same as DebitAmount");
  }
	
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
	dat_From = cal.getTime();

	return dat_From;
}
public void setDat_From(Date dat_From) {
	this.dat_From = dat_From;
}
public Date getDat_To() throws ParseException {
	dat_To=new java.util.Date();
	 Calendar c = Calendar.getInstance(); 
	 c.setTime(dat_To); 
    int d1=c.getWeekYear();
   
    
     
    String str=31+"-"+12+"-"+d1;
    SimpleDateFormat ft = 
		      new SimpleDateFormat ("dd-MM-yyyy");
    dat_To=ft.parse(str);
	return dat_To;
}
public void setDat_To(Date dat_To) {
	this.dat_To = dat_To;
}


/*
 * chart of accounts concept
 */
private Integer  int_AccountId;
private String str_OrganizationName;
private String str_AccountName;
private String str_AccountType;
private List<ChartOfAccount> chartOfAccountList;
private Integer int_UserId;
public Integer getInt_AccountId() {
	return int_AccountId;
}
public void setInt_AccountId(Integer int_AccountId) {
	this.int_AccountId = int_AccountId;
}
public String getStr_OrganizationName() {
	//str_OrganizationName=Util.getAppartmentName();
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
private ChartOfAccount chartOfAccount;

public ChartOfAccount getChartOfAccount() {
	return chartOfAccount;
}
public void setChartOfAccount(ChartOfAccount chartOfAccount) {
	this.chartOfAccount = chartOfAccount;
}
private List<String> accountTypeList;
public AccountingGroup getAccountGroup() {
	return accountGroup;
}
public void setAccountGroup(AccountingGroup accountGroup) {
	this.accountGroup = accountGroup;
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
private double totalIncome;
public double getTotalIncome() {
	return totalIncome;
}
public void setTotalIncome(double totalIncome) {
	this.totalIncome = totalIncome;
}
public List<ChartOfAccount> getChartOfAccountList() {
	chartOfAccountList=new ArrayList<ChartOfAccount>();
	chartOfAccountList.addAll(getAccountsService().getChartOfAccountList());
	ListIterator list=chartOfAccountList.listIterator();
	while(list.hasNext())
	{
		ChartOfAccount account=(ChartOfAccount)list.next();
		double ddd=account.getDebit_closingBalance();
		debitNetTotal=debitNetTotal+ddd;
		double ddd1=account.getCredit_closingBalance();
		creditNetTotal=creditNetTotal+ddd1;
		
	}
			
	return chartOfAccountList;
}
public void setChartOfAccountList(List<ChartOfAccount> chartOfAccountList) {
	this.chartOfAccountList = chartOfAccountList;
}
private Character ch_Group;
private List<SelectItem> list;
private String car;  
private List<SelectItem> cars;

public void setCars(List<SelectItem> cars) {
	this.cars = cars;
}
public void setCar(String car) {
	this.car = car;
}
public List<SelectItem> getList() {
	list=new ArrayList<SelectItem>();
	list.addAll(getAccountsService().getAccount());
	return list;
}

public void setList(List<SelectItem> list) {
	this.list = list;
}
public List<SelectItem> getCars() {
//	cars=new ArrayList<SelectItem>();
	//cars.addAll(getAccountsService().getAccounts());
	return cars;
}



/*?@PostConstruct
public void init(){ 
	Object[] st1=getList().toArray();
	List s=Arrays.asList(st1);
	
	SelectItem[] st2=new SelectItem[0];
	
	  

   SelectItemGroup g1 = new SelectItemGroup("Income");
    g1.setSelectItems(st2);
  
    cars = new ArrayList<SelectItem>();
    cars.add(g1);
   
   
 
     
 
}

*/ 
 
public Character getCh_Group() {
	return ch_Group;
}
public void setCh_Group(Character ch_Group) {
	this.ch_Group = ch_Group;
}

@PostConstruct
public void init() {
     
    
	listAccountType= new ArrayList<SelectItem>();
   
    
    ListIterator itr=getStr_AccountGroup().listIterator();
     
    while(itr.hasNext())
    {
    //	list=new ArrayList<String>();
    	String accountGroup=(String) itr.next();
    
    	 accountTypeList=new ArrayList<String>();
    	
    	accountTypeList.addAll(getAccountsService().getAccountTypeList(accountGroup.charAt(0)));
    	 ListIterator itr1=accountTypeList.listIterator();
    	 while(itr1.hasNext())
    	 {
    		 SelectItemGroup g1 = new SelectItemGroup(accountGroup);
    		 accountGroup=null;
    		 String str=(String) itr1.next();
    		
    		 
    		 g1.setSelectItems(new SelectItem[] {new SelectItem(str)});
    		 
    		 listAccountType.add(g1);
    	 }
    	 
    	
    	 
    }  
 }  
	
 

public List<String> getStr_AccountGroup() {
	
	Iterator itr=getCh_AccountGroup().iterator();
	while(itr.hasNext())
	{
		Character c=(Character) itr.next();
		if(c.equals('A'))
		{
			str_AccountGroup.add("Asset");
		}
		else if(c=='L')
		{
			str_AccountGroup.add("Liability");
			
		}
		else if(c=='R')
		{
			str_AccountGroup.add("Revenue");
		}
		else if(c=='Q')
		{
			str_AccountGroup.add("Qeity");
		}
		else
			str_AccountGroup.add("Expense");
	
	}
	return str_AccountGroup;
}  
public void setStr_AccountGroup(List<String> str_AccountGroup) {
	this.str_AccountGroup = str_AccountGroup;
}
private List<SelectItem> listAccountType;
 
public List<SelectItem> getListAccountType() {
	
	return listAccountType;
}
public void setListAccountType(List<SelectItem> listAccountType) {
	this.listAccountType = listAccountType;
}  
private List<String> str_AccountGroup;
private Set<Character> ch_AccountGroup;
public Set<Character> getCh_AccountGroup() {
	ch_AccountGroup=new HashSet<Character>();
	str_AccountGroup=new ArrayList<String>();
	ch_AccountGroup.addAll(getAccountsService().getCh_AccountGroup());
	 
	return ch_AccountGroup;
}
public void setCh_AccountGroup(Set<Character> ch_AccountGroup) {
	this.ch_AccountGroup = ch_AccountGroup;
}
public List<String> getAccountTypeList() {
	
	
	accountTypeList=new ArrayList<String>();
	
	
	return accountTypeList;
}
public void setAccountTypeList(List<String> accountTypeList) {
	this.accountTypeList = accountTypeList;
}
public String getStr_AccountType() {
	return str_AccountType;
}
public void setStr_AccountType(String str_AccountType) {
	this.str_AccountType = str_AccountType;
} 
public void accountchangeListener(ValueChangeEvent event){
	
	
	str_AccountType =(String) event.getNewValue();
	
	ch_Group=getAccountsService().getChGroup(str_AccountType);
	
}

public void saveChartOfAccount()
{
	chartOfAccount=new ChartOfAccount();
	chartOfAccount.setInt_UserId(Util.getUserId());
	chartOfAccount.setInt_ApartmentId(Util.getAppartmentId());
	chartOfAccount.setStr_AccountName(str_AccountName);
	chartOfAccount.setStr_OrganizationName(str_OrganizationName);
	chartOfAccount.setStr_AccountType(str_AccountType);
	chartOfAccount.setCh_Group(ch_Group);
	getAccountsService().saveChartOfAccount(chartOfAccount);
	
	
}
 private List<InvoiceTransaction>  listInvoiceTransaction1;
public List<InvoiceTransaction> getListInvoiceTransaction1() {
	
	listInvoiceTransaction1=new ArrayList<InvoiceTransaction>();
	listInvoiceTransaction1.addAll(getAccountsService().listInvoiceTransaction1(str_Accounts,dat_FromDate,dat_ToDate));
	return listInvoiceTransaction1;
	
}
	

 public void setListInvoiceTransaction1(
		List<InvoiceTransaction> listInvoiceTransaction1) {
	this.listInvoiceTransaction1 = listInvoiceTransaction1;
}
private String str_Accounts;
 public String getStr_Accounts() {
	
	 str_Accounts=getAccountsService().getAccountName(id1);
   
	
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
   
	id1=getAccountsService().getAccountId(str);
	
}
public void datechangeListener(ValueChangeEvent event)
{
	dat_FromDate=(Date)event.getNewValue();
	System.out.println("hi");
}
public void datechangeListener1(ValueChangeEvent event)
{
	dat_ToDate=(Date)event.getNewValue();
	
}
public void getSearch()
{  
	
	
  str_Accounts=getAccountsService().getAccountName1(id1);
  getDebit();
   if(str_Accounts.equals("Accounts Receivable"))
   {
     listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
	listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts,dat_FromDate,dat_ToDate));
	
    
    
	ListIterator list=listInvoiceTransaction.listIterator();
	str_TaxName="Tax Payable";
	System.out.println(getListInvoiceTransaction1().listIterator().hasNext());
	if(getListInvoiceTransaction1().listIterator().hasNext())
    
	{
	income="true";
	}
	else
	{
		income="false";
	}
	
   }
   else if(str_Accounts.equalsIgnoreCase("Income from Resident"))
   {   
	   listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
		listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts,dat_FromDate,dat_ToDate));
		
   }
   else if(str_Accounts.equalsIgnoreCase("Tax Payable"))
   { 
	   listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
		listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts,dat_FromDate,dat_ToDate));
		
		
   }
   else if(str_Accounts==null)
   {
	   listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
		listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts,dat_FromDate,dat_ToDate));
   }
  
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
private double totalBalance;
public double getDebit() {
	debit=int_Debit;
	credit=int_Credit;
	System.out.println(debit+"huy");
	System.out.println(credit+"huy1");
	
	 if(str_Accounts.equalsIgnoreCase("Income from Resident"))
	 {  System.out.println(str_Accounts != str);
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
		  if(debit>credit)
		  {
		     type1=true;
		     type2=false;
	     }
		  else
		  {
			  type1=true;
			  type2=false;
		  }
	     return debit;
	     }
	    }
	   else if(str.equalsIgnoreCase("Income from Resident"))
	   {
		   System.out.println(str_Accounts != str);
		ListIterator list=listInvoiceTransaction.listIterator();
	       while(list.hasNext())
	     {
		Object obj=list.next();
		InvoiceTransaction invoice=(InvoiceTransaction)obj;
		double balance1=invoice.getTotalDue();
		totalBalance=invoice.getTaxAmount();
		System.out.println(totalBalance);
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
					 String sss1=account.getStr_CreditAccount();
					
					if(sss.equalsIgnoreCase(str))
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
		 totalBalance=credit-totalBalance;
		 debit=0.00;
	 getAccountsService().updateClosingBalance(debit,totalBalance,str);	
		 System.out.println(debit+"pp");
		 return credit;
      }
      else
      {
    	  debit=debit-credit;
    	  type1=true;
 		 type2=false;
 		 credit=0.00;
 		 getAccountsService().updateClosingBalance(debit,credit,str);	
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
				 type1=false;
				 type2=true;
				 debit=0.00;
				 System.out.println(debit+"pp");
				 System.out.println(credit+"ppp1");
				 getAccountsService().updateClosingBalance(debit,credit,str);	
				 return credit;
	          }
	          else
	          {
	        	  debit=debit-credit;
	        	  type1=true;
	        	  type2=false;
	        	  credit=0.00;
	 			 System.out.println(debit+"pp1");
	 			 getAccountsService().updateClosingBalance(debit,credit,str);	
	 			 return debit;
	          }
				
			  
			
		
	}		
		
	
	else if(str_Accounts.equalsIgnoreCase(str))
	{
	 ListIterator list2=listManualJournal1.listIterator();
	  {  
	  //  totalBalance=0.00;
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
		
		 {
			 while(list.hasNext())
			 {   
				 InvoiceTransaction invoice1=(InvoiceTransaction)list.next();
				 Double balance2=invoice1.getTotalDue();
				 totalBalance=invoice1.getTaxAmount();
				System.out.println(balance2+"kji");
				debit=debit+balance2;
				 System.out.println(debit+"kkk");
				 
			 }
			
			 if(debit>credit)
			 {   System.out.println("sagarika");
				 debit=debit-credit; 
				type1=true;
				 type2=false;
				
				
				 credit=0.00;
				 getAccountsService().updateClosingBalance(debit,credit,str);	
				 return debit;
			 }
			 else
			 {   System.out.println("malay");
				 credit=credit-debit;
				     type1=false;
					  type2=true;
				 debit=0.00;
				 totalBalance=credit;
				 getAccountsService().updateClosingBalance(debit,credit,str);	
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
				
				 totalBalance=invoice1.getTaxAmount();
				 System.out.println(totalBalance+"huytjjjjjj");
				
			 }
			
			 if(debit>credit)
			 {   System.out.println("sai");
				 debit=debit-credit; 
				 type1=true;
				 type2=false;
				 double  debit1=0.00;
				 if(debit<totalBalance)
				 {
					 
					 credit=totalBalance-debit;
					
				 getAccountsService().updateClosingBalance(debit1,credit,str);	
				 return debit;
				 }
				 else
				 {
					 debit1=debit-totalBalance;
					 credit=0.00;
					 getAccountsService().updateClosingBalance(debit1,credit,str);	
					 return debit;
				 }
			 }
			 else
			 {   System.out.println("simran");
				 credit=credit-debit;
				 type1=false;
				 type2=true;
				 debit=0.00;
				 double credit1=0.00;
				 credit1=totalBalance+credit;
				 getAccountsService().updateClosingBalance(debit,credit1,str);	
				 return credit;
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
			
			 getAccountsService().updateClosingBalance(debit,credit,str);	
			 return debit;
		 }
		 else
		  {   System.out.println("rosy");
			 credit=credit-debit;
			 type1=false;
			 type2=true;
			 debit=0.00;
			
			 getAccountsService().updateClosingBalance(debit,credit,str);	
			 return credit;
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
	
	listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
	listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts,dat_FromDate,dat_ToDate));
	
	ListIterator list=listInvoiceTransaction.listIterator();
	
	while(list.hasNext())
	{
		
		InvoiceTransaction invoice=(InvoiceTransaction)list.next();
		
		double id=invoice.getSubTotal();
		type="Income";
	    totalIncome=totalIncome+id;
	}
	
	return  listInvoiceTransaction;
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
private List<ChartOfAccount> income1;
public List<ChartOfAccount> getIncome1() {
	income1=new ArrayList<ChartOfAccount>();
	income1.addAll(getAccountsService().listRavenues());
	getChartOfAccountList();
	
	return income1;
	
}

public List<ChartOfAccount> getAsset() {
	asset=new ArrayList<ChartOfAccount>();
	asset.addAll(getAccountsService().listAssets());
	
	return asset;
}


public void setIncome1(List<ChartOfAccount> income1) {
	this.income1 = income1;
}
private List<ChartOfAccount> asset;

public void setAsset(List<ChartOfAccount> asset) {
	this.asset = asset;
}
private List<ChartOfAccount> expense;
public List<ChartOfAccount> getExpense() {
	expense=new ArrayList<ChartOfAccount>();
	expense.addAll(getAccountsService().listExpense());
	return expense;
}

private List<ChartOfAccount> liability;
private List<ChartOfAccount> equity;
public List<ChartOfAccount> getLiability() {
	liability=new ArrayList<ChartOfAccount>();
	liability.addAll(getAccountsService().listLiability());
	
	return liability;
}

public List<ChartOfAccount> getEquity() {
	equity=new ArrayList<ChartOfAccount>();
	equity.addAll(getAccountsService().listEquity());
	return equity;
}
public void setExpense(List<ChartOfAccount> expense) {
	this.expense = expense;
}
public void setLiability(List<ChartOfAccount> liability) {
	this.liability = liability;
}
public void setEquity(List<ChartOfAccount> equity) {
	this.equity = equity;
}
public void getSearch1()
{
	listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
	listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts,dat_FromDate,dat_ToDate));
}
}

