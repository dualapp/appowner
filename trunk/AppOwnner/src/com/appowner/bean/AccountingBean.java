package com.appowner.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
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
import javax.faces.component.UISelectItems;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.component.datatable.DataTable;

import com.appowner.model.AccountingGroup;
import com.appowner.model.Assets;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.DueTemplate;
import com.appowner.model.DueTransaction;
import com.appowner.model.Expense;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;
import com.appowner.service.AccountsService;
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
	
private String dat_FromDate;
private String dat_ToDate;
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
public String getDat_FromDate() {
	java.util.Date d=new java.util.Date();
	 SimpleDateFormat ft = 
		      new SimpleDateFormat ("dd-MM-yyyy");
	String str=ft.format(d);
	
	return str;
}
public void setDat_FromDate(String dat_FromDate) {
	this.dat_FromDate = dat_FromDate;
}
public String getDat_ToDate() {
	
   return dat_ToDate;
	
}
public void setDat_ToDate(String dat_ToDate) {
	this.dat_ToDate = dat_ToDate;
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
public String getDat_Date() {
	java.util.Date d=new java.util.Date();
	 SimpleDateFormat ft = 
		      new SimpleDateFormat ("dd-MM-yyyy");
	String str=ft.format(d);
	
	return str;
	
}
public void setDat_Date(String dat_Date) {
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
private String dat_Date;
private String str_Reference;
private String str_Notes;
private String str_DebitAccount;
private String str_CreditAccount;
private Double str_DebitAmount;
private Double str_CreditAmount;
public void addInvoiceManualJournal() throws AccountingBean
{ try{
	ManualJournal journal=new ManualJournal();
 //   journal.setStr_OrganisationID(Util.getAppartmentId());
    journal.setDat_Date(getDat_Date());
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
{    System.out.println("hi");
	ManualJournal journal=new ManualJournal();
	journal=(ManualJournal)dataTable.getRowData();
	id=journal.getInt_ManualJournalID();
	System.out.println(id);
}
private Date  dat_From;
private Date dat_To;
public Date getDat_From() {
	return dat_From;
}
public void setDat_From(Date dat_From) {
	this.dat_From = dat_From;
}
public Date getDat_To() {
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
	str_OrganizationName="priya";
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
public List<ChartOfAccount> getChartOfAccountList() {
	chartOfAccountList=new ArrayList<ChartOfAccount>();
	chartOfAccountList.addAll(getAccountsService().getChartOfAccountList());
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

/*

@PostConstruct
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
    	System.out.println(accountGroup+"fdfggf");
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
	System.out.println(str_AccountType);
	ch_Group=getAccountsService().getChGroup(str_AccountType);
	System.out.println(ch_Group);
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
	listInvoiceTransaction1.addAll(getAccountsService().listInvoiceTransaction1(str_Accounts));
	return listInvoiceTransaction1;
	
}
	

 public void setListInvoiceTransaction1(
		List<InvoiceTransaction> listInvoiceTransaction1) {
	this.listInvoiceTransaction1 = listInvoiceTransaction1;
}
private String str_Accounts;
 public String getStr_Accounts() {
	
	str_Accounts=getAccountsService().getAccountName(id1);
     System.out.println(str_Accounts+"priyaa");
	
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

public String getSearch()
{  
	
	
   str_Accounts=getAccountsService().getAccountName1(id1);
  
   if(str_Accounts.equals("Accounts Receivable"))
   { 
     listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
	listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts));
	
    
    
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
	 return "accountstransaction.xhtml";
   }
   else if(str_Accounts.equalsIgnoreCase("Income from Resident"))
   {
	   listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
		listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts));
		 return "accountstransaction.xhtml";  
   }
   else if(str_Accounts.equalsIgnoreCase("Tax Payable"))
   {
	   listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
		listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts));
		
		 return "accountstransaction.xhtml"; 
   }
 
   return "accountstransaction.xhtml";  
}
private double debit=0.00;
private double credit=0.00;
public double getCredit() {
	credit=int_Credit;
	System.out.println(int_Debit+"anupam1");
	System.out.println(credit+"anupam");
 ListIterator list2=listManualJournal1.listIterator();
	  {  
	    totalBalance=0.00;
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
						totalBalance=totalBalance+balance3;
						System.out.println(totalBalance+"123");
					}
					else
					{
					    double balance4=getAccountsService().getCreditAmount(id);
					    credit=credit+balance4;
					    System.out.println(credit+"jjj");
					}
					
				}
		 totalBalance=totalBalance+int_Debit;
		
		System.out.println(credit+"ji");
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
				
				   totalBalance=totalBalance+balance6;
				   System.out.println(totalBalance+"kjihu");
			}
		 }
	}

	
	
	
	if(str_Accounts.equalsIgnoreCase(str))
	{    
	   if(str_Accounts.equalsIgnoreCase("Bank") || str_Accounts.equalsIgnoreCase("Cash"))
	   {
		 ListIterator list=listInvoiceTransaction.listIterator();
		 {
			 while(list.hasNext())
			 {
				 InvoiceTransaction invoice1=(InvoiceTransaction)list.next();
				 Double balance2=invoice1.getTotalDue();
				System.out.println(balance2+"kji");
				totalBalance=totalBalance+balance2;
				 System.out.println(totalBalance+"kkk");
				 
			 }
		
			 if(totalBalance>credit)
			 {
				 credit=totalBalance-credit; 
			 }
			 else
			 {
				 credit=credit-totalBalance;
			 }
			 System.out.println(totalBalance+"priya");
			 System.out.println(credit+"jjs");
			 if(totalBalance>credit)
			 {
				
				 type1="false";
				 System.out.println(type1+"kunku");
			 }
			 else
			 { 
				 type1="true";
				
				 System.out.println(type1+"kunku1");
			 }
		 }
		
	
	return credit;
	}
	  
	   if(totalBalance>credit)
		 {
			 credit=totalBalance-credit; 
		 }
		 else
		 {
			 credit=credit-totalBalance;
		 }
		 System.out.println(totalBalance+"priya");
		 System.out.println(credit+"jjs");
		 if(totalBalance>credit)
		 {
			
			 type1="false";
			 System.out.println(type1+"kunku2");
			
		 }
		 else
		  { 
			 type1="true";
			  System.out.println(type1+"kunku3");
			
		  }
	return credit;	
	}	
	else
	System.out.println(credit+"huy");
	return credit;
}
public void setCredit(double credit) {
	this.credit = credit;
}
public void setDebit(double debit) {
	this.debit = debit;
}
private String type1;
public String getType1() {
	return type1;
}
public void setType1(String type1) {
	this.type1 = type1;
}

private double totalBalance;
public double getDebit() {
	debit=int_Debit;
	System.out.println(debit+"huy");
	System.out.println(int_Credit+"huy1");
	/* ListIterator list2=listManualJournal1.listIterator();
	 {  System.out.println(debit+"phy");
	    totalBalance=0.00;
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
						totalBalance=totalBalance+balance3;
						System.out.println(totalBalance+"123");
					}
					else
					{
					    double balance4=getAccountsService().getCreditAmount(id);
					    totalBalance=totalBalance-balance4;
					    System.out.println(totalBalance+"jjj");
					}
					
				}
		
			 }
			

	 debit=debit+totalBalance;
	 System.out.println(debit+"pp");
	
*/
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
		
		   debit=debit+balance1;
		System.out.println(debit+"juhy");
	     }
	       debit=debit+int_Credit;
	     return debit;
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
		
		totalBalance=totalBalance+balance1;
		System.out.println(totalBalance+"huy");
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
					    totalBalance=totalBalance+balance4;
					    System.out.println(totalBalance+"jjj");
					}
					
				}
		
			 }
	  if(totalBalance>debit)
      {
		 debit=totalBalance-debit;
		 System.out.println(debit+"pp");
      }
      else
      {
    	  debit=debit-totalBalance;
			 System.out.println(debit+"pp1");  
      }
		
	return debit;		

	
	
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
					  debit=balance1+tax;
				
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
					
					 totalBalance=totalBalance+balance2;
					 System.out.println(totalBalance+"huyt");
					 
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
							    totalBalance=totalBalance+balance4;
							    System.out.println(totalBalance+"jjj");
							}
							
						}
				
					 }
					
			
	
			  if(totalBalance>debit)
	          {
				 debit=totalBalance-debit;
				 System.out.println(debit+"pp");
	          }
	          else
	          {
	        	  debit=debit-totalBalance;
	 			 System.out.println(debit+"pp1");  
	          }
				
				
				return debit;
			
		
	}		
		
	
	else
	
	return debit;
	
}



private List<InvoiceTransaction>  listInvoiceTransaction;
public List<InvoiceTransaction> getListInvoiceTransaction() {
	
	listInvoiceTransaction=new CopyOnWriteArrayList<InvoiceTransaction>();
	listInvoiceTransaction.addAll(getAccountsService().listInvoiceTransaction(str_Accounts));
	
	ListIterator list=listInvoiceTransaction.listIterator();
	
	while(list.hasNext())
	{
		
		InvoiceTransaction invoice=(InvoiceTransaction)list.next();
		
		double id=invoice.getSubTotal();
		type="Income";
	  
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
	listManualJournal1.addAll(getAccountsService().getlistManualJournal1(str));
	
	return listManualJournal1;
}
public void setListManualJournal1(List<ManualJournal> listManualJournal1) {
	  this.listManualJournal1 = listManualJournal1;
}
public List<Expense>   listExpense;
public List<Expense> getListExpense() {
	listExpense=new ArrayList<Expense>();
	 listExpense.addAll(getAccountsService().getExpenseList(str));
	 return listExpense;
}
public void setListExpense(List<Expense> listExpense) {
	this.listExpense = listExpense;
}
}
