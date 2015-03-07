package com.appowner.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FileUploadEvent;

import com.appowner.model.Account;
import com.appowner.model.AccountingGroup;
import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.customize;
import com.appowner.service.AccountsService;
import com.appowner.util.Util;

@ManagedBean
@RequestScoped
public class AccountsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{AccountsService}")
	private AccountsService accountsService;
	public AccountsService getAccountsService() {
		return accountsService;
	}
	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}
private String	str_Organisation;

	public String getStr_Organisation() {
		str_Organisation=Util.getAppartmentName();
	return str_Organisation;
}
public void setStr_Organisation(String str_Organisation) {
	this.str_Organisation = str_Organisation;
}
	private Integer int_Accounts_OpeningID;
	private String str_Accounts;
	private double int_Debit;
	public Date getDat_openingDate() {
		return dat_openingDate;
	}
	public void setDat_openingDate(Date dat_openingDate) {
		this.dat_openingDate = dat_openingDate;
	}
	private Date dat_openingDate;
	
	
	
	
	private double int_Credit;
	public Integer getInt_Accounts_OpeningID() {
		return int_Accounts_OpeningID;
	}
	public void setInt_Accounts_OpeningID(Integer int_Accounts_OpeningID) {
		this.int_Accounts_OpeningID = int_Accounts_OpeningID;
	}
	public String getStr_Accounts() {
		return str_Accounts;
	}
	public void setStr_Accounts(String str_Accounts) {
		this.str_Accounts = str_Accounts;
	}
	
	
	public double getInt_Debit() {
		return int_Debit;
	}
	public void setInt_Debit(double int_Debit) {
		this.int_Debit = int_Debit;
	}
	public double getInt_Credit() {
		return int_Credit;
	}
	public void setInt_Credit(double int_Credit) {
		this.int_Credit = int_Credit;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getTotalAmount1() {
		return totalAmount1;
	}
	public void setTotalAmount1(double totalAmount1) {
		this.totalAmount1 = totalAmount1;
	}
	public double getAdjustmentBalance() {
		return adjustmentBalance;
	}
	public void setAdjustmentBalance(double adjustmentBalance) {
		this.adjustmentBalance = adjustmentBalance;
	}
	public double getAdjustmentBalance1() {
		return adjustmentBalance1;
	}
	public void setAdjustmentBalance1(double adjustmentBalance1) {
		this.adjustmentBalance1 = adjustmentBalance1;
	}
	public double getTotalAdjustBalance() {
		return totalAdjustBalance;
	}
	public void setTotalAdjustBalance(double totalAdjustBalance) {
		this.totalAdjustBalance = totalAdjustBalance;
	}
	public double getTotalAdjustBalance1() {
		return totalAdjustBalance1;
	}
	public void setTotalAdjustBalance1(double totalAdjustBalance1) {
		this.totalAdjustBalance1 = totalAdjustBalance1;
	}
	public List<AccountsOpeningBalance> getListOpeningBalance() {
		listOpeningBalance=new ArrayList<AccountsOpeningBalance>();
		listOpeningBalance.addAll(getAccountsService().listOpeningBalance());
		ListIterator list=listOpeningBalance.listIterator();
		totalAmount=0.0;
		totalAmount1=0.0;
		while(list.hasNext())
		{
			Object obj=list.next();
			accounts=(AccountsOpeningBalance)obj;
			
			totalAmount+=accounts.getInt_Debit();
			totalAmount1+=accounts.getInt_Credit();
			if(totalAmount==totalAmount1)
			{
				adjustmentBalance=0.0;
				adjustmentBalance1=0.0;
				totalAdjustBalance=totalAmount;
				totalAdjustBalance1=totalAmount1;
				
			}
			else
			  {
				if(totalAmount>totalAmount1)
				{
					adjustmentBalance1=totalAmount-totalAmount1;
					adjustmentBalance=0.0;
					totalAdjustBalance=totalAmount+adjustmentBalance;
					totalAdjustBalance1=totalAmount1+adjustmentBalance1;
					
			    }
			  else
			    {
				  adjustmentBalance=totalAmount1-totalAmount;
				  adjustmentBalance1=0.0;
				  totalAdjustBalance=totalAmount+adjustmentBalance;
				  totalAdjustBalance1=totalAmount1+adjustmentBalance1;
			    }
				
		}
		}
		return listOpeningBalance;
	}
	public void setListOpeningBalance(
			List<AccountsOpeningBalance> listOpeningBalance) {
		this.listOpeningBalance = listOpeningBalance;
	}
	public void setInt_Credit(Double int_Credit) {
		this.int_Credit = int_Credit;
	}
	private List<AccountsOpeningBalance> listOpeningBalance;
	private HtmlDataTable updatedAccounts;
	
	
	public HtmlDataTable getUpdatedAccounts() {
		return updatedAccounts;
	}
	public void setUpdatedAccounts(HtmlDataTable updatedAccounts) {
		this.updatedAccounts = updatedAccounts;
	}
	private AccountsOpeningBalance accounts=new AccountsOpeningBalance();
	        
	
	public AccountsOpeningBalance getAccounts() {
		return accounts;
	}
	public void setAccounts(AccountsOpeningBalance accounts) {
		this.accounts = accounts;
	}
	
	public void addAccountsHead()  
	   { System.out.println("gud"); 
		
		
		
	   Date  date=getDat_openingDate();
	   System.out.println(date+"dkkdffklfkf");
	   Integer id1=Util.getAppartmentId();
	    System.out.println(id);
	     
	      getAccountsService().addBalance(date,id1,id);
	     
		
	    }
	private static Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private  static double credit;
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	private static double debit;
public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
public void processValueChange(ValueChangeEvent event)  
	        throws AbortProcessingException { 
	accounts=(AccountsOpeningBalance) updatedAccounts.getRowData();
	int_Accounts_OpeningID=accounts.getInt_Accounts_OpeningID();
	id=accounts.getInt_Accounts_OpeningID();
	System.out.println(int_Accounts_OpeningID+"hjh");
	System.out.println(id+"hjhjhj");
	str_Accounts=accounts.getStr_AccountsHead();
	System.out.println(str_Accounts);
	//accounts.setInt_Accounts_OpeningID(int_Accounts_OpeningID);
	System.out.println(accounts);
	int_Debit=(Double) event.getNewValue();
	debit=(Double) event.getNewValue();
	//accounts.setInt_Debit(int_Debit);
	int_Credit=((Double) event.getOldValue());
	credit=((Double) event.getOldValue());
	System.out.println(int_Credit);
	System.out.println(int_Debit);
	
	getAccountsService().addAccounts(int_Accounts_OpeningID,int_Debit);  
	
	
	
	
	    } 
public void processValueChange1(ValueChangeEvent event)  
        throws AbortProcessingException {  
	System.out.println("hi");
	accounts=(AccountsOpeningBalance) updatedAccounts.getRowData();
	int_Accounts_OpeningID=accounts.getInt_Accounts_OpeningID(); 
	id=accounts.getInt_Accounts_OpeningID(); 
	System.out.println(id);
	int_Credit=(Double) event.getNewValue();
	credit=(Double) event.getNewValue();
	accounts.setInt_Credit(int_Credit);
	getAccountsService().saveAccounts(int_Accounts_OpeningID,int_Credit);   
        }
private double totalAmount;

private double totalAmount1;

private double adjustmentBalance;
private double adjustmentBalance1;

private double totalAdjustBalance;
private double totalAdjustBalance1;




//ACCOUNT
private Integer int_account_ID;
private String str_acount_Name;
private String str_account_No;
private String str_account_Type;
private String str_Bank;
private String str_Branch;
private String str_City;
private double dou_opening_Balance;
private String str_IFSC_Code;
public Integer getInt_account_ID() {
	return int_account_ID;
}
public void setInt_account_ID(Integer int_account_ID) {
	this.int_account_ID = int_account_ID;
}
public String getStr_acount_Name() {
	return str_acount_Name;
}
public void setStr_acount_Name(String str_acount_Name) {
	this.str_acount_Name = str_acount_Name;
}
public String getStr_account_No() {
	return str_account_No;
}
public void setStr_account_No(String str_account_No) {
	this.str_account_No = str_account_No;
}
public String getStr_account_Type() {
	return str_account_Type;
}
public void setStr_account_Type(String str_account_Type) {
	this.str_account_Type = str_account_Type;
}
public String getStr_Bank() {
	return str_Bank;
}
public void setStr_Bank(String str_Bank) {
	this.str_Bank = str_Bank;
}
public String getStr_Branch() {
	return str_Branch;
}
public void setStr_Branch(String str_Branch) {
	this.str_Branch = str_Branch;
}
public String getStr_City() {
	return str_City;
}
public void setStr_City(String str_City) {
	this.str_City = str_City;
}
public double getDou_opening_Balance() {
	return dou_opening_Balance;
}
public void setDou_opening_Balance(double dou_opening_Balance) {
	this.dou_opening_Balance = dou_opening_Balance;
}
public String getStr_IFSC_Code() {
	return str_IFSC_Code;
}
public void setStr_IFSC_Code(String str_IFSC_Code) {
	this.str_IFSC_Code = str_IFSC_Code;
}
public String addAccounts()
{
	try
	{
		Account account=new Account();
		account.setInt_account_ID(int_account_ID);
		account.setDou_opening_Balance(dou_opening_Balance);
		account.setStr_account_No(str_account_No);
		account.setStr_account_Type(str_account_Type);
		account.setStr_acount_Name(str_acount_Name);
		account.setStr_Bank(str_Bank);
		account.setStr_Branch(str_Branch);
		account.setStr_City(str_City);
		account.setStr_IFSC_Code(str_IFSC_Code);
		getAccountsService().addAccount(account); 
		
		return "accounts.xhtml";
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "accounts.xhtml";
}
public String cancel()
{
	return "accounts.xhtml";
}
private List<Account> listAccounts;

public List<Account> getListAccounts() {
	listAccounts=new ArrayList<Account>();
	listAccounts.addAll(getAccountsService().listAccounts());
	return listAccounts;
}
public void setListAccounts(List<Account> listAccounts) {
	this.listAccounts = listAccounts;
}
//TRANSFER AMOUNT
private Integer int_Transfer_ID;
private double  dob_transfer_Amount;
private Date dat_transfer_Date;
private String from_Account;
private String to_Acconut;
private String str_Notes;
public Integer getInt_Transfer_ID() {
	return int_Transfer_ID;
}
public void setInt_Transfer_ID(Integer int_Transfer_ID) {
	this.int_Transfer_ID = int_Transfer_ID;
}
public double getDob_transfer_Amount() {
	return dob_transfer_Amount;
}
public void setDob_transfer_Amount(double dob_transfer_Amount) {
	this.dob_transfer_Amount = dob_transfer_Amount;
}
public Date getDat_transfer_Date() {
	return dat_transfer_Date;
}
public void setDat_transfer_Date(Date dat_transfer_Date) {
	this.dat_transfer_Date = dat_transfer_Date;
}
public String getFrom_Account() {
	return from_Account;
}
public void setFrom_Account(String from_Account) {
	this.from_Account = from_Account;
}
public String getTo_Acconut() {
	return to_Acconut;
}
public void setTo_Acconut(String to_Acconut) {
	this.to_Acconut = to_Acconut;
}
public String getStr_Notes() {
	return str_Notes;
}
public void setStr_Notes(String str_Notes) {
	this.str_Notes = str_Notes;
}
private List<String> accountName;
public List<String> getAccountName() {
	accountName=new ArrayList<String>();
	accountName.addAll(getAccountsService().listAccount());
	return accountName;
}
public void setAccountName(List<String> accountName) {
	this.accountName = accountName;
}
private List<AccountingGroup> asset;
private List<AccountingGroup> revenues;
private List<AccountingGroup> liabilities;
private List<AccountingGroup>  expense;
public List<AccountingGroup> getAsset() {
	asset=new ArrayList<AccountingGroup>();
	asset.addAll(getAccountsService().getAsset());
	ListIterator list=asset.listIterator();
	while(list.hasNext())
	{
		AccountingGroup account=(AccountingGroup)list.next();
		group=account.getCh_Group();
		
		
	}
	return asset;
}

public void setAsset(List<AccountingGroup> asset) {
	this.asset = asset;
}
public List<AccountingGroup> getRevenues() {
	revenues=new ArrayList<AccountingGroup>();
	revenues.addAll(getAccountsService().getRevenues());
	ListIterator list=revenues.listIterator();
	while(list.hasNext())
	{
		AccountingGroup account=(AccountingGroup)list.next();
		group1=account.getCh_Group();
	}
	return revenues;
}

public List<AccountingGroup> getLiabilities() {
	liabilities=new ArrayList<AccountingGroup>();
	liabilities.addAll(getAccountsService().getLiabilities());
	ListIterator list=liabilities.listIterator();
	while(list.hasNext())
	{
		AccountingGroup account=(AccountingGroup)list.next();
		group2=account.getCh_Group();
	}
	return liabilities;
}

public List<AccountingGroup> getExpense() {
	expense=new ArrayList<AccountingGroup>();
	expense.addAll(getAccountsService().getExpense());
	ListIterator list=expense.listIterator();
	while(list.hasNext())
	{
		AccountingGroup account=(AccountingGroup)list.next();
		group3=account.getCh_Group();
	}
	return expense;
}

public void setRevenues(List<AccountingGroup> revenues) {
	this.revenues = revenues;
}
public void setLiabilities(List<AccountingGroup> liabilities) {
	this.liabilities = liabilities;
}
public void setExpense(List<AccountingGroup> expense) {
	this.expense = expense;
}
private String accounthead;
public String getAccounthead() {
	return accounthead;
}
public void setAccounthead(String accounthead) {
	this.accounthead = accounthead;
}
public char group;
 public char getGroup() {
	return group;
}
public void setGroup(char group) {
	this.group = group;
}
private char group1;
private char group2;
private char group3;
public char getGroup1() {
	return group1;
}
public void setGroup1(char group1) {
	this.group1 = group1;
}
public char getGroup2() {
	return group2;
}
public void setGroup2(char group2) {
	this.group2 = group2;
}
public char getGroup3() {
	return group3;
}
public void setGroup3(char group3) {
	this.group3 = group3;
}
private  static char group4;

public static char getGroup4() {
	return group4;
}
public static void setGroup4(char group4) {
	AccountsBean.group4 = group4;
}
private String groupName;
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public String getAccountsHead(char d)
 {  System.out.println(d+"jdfjjf");
    if(d=='A')
    {
    	groupName="Asset";
    }
    else if(d=='R')
    {
    	groupName="Revenue";
    	
    }
    else if(d=='L')
    {
    	groupName="Liability";
    	
    }
    else
    {
    	groupName="Expense"	;
    }
      group4=d;
 System.out.println(group4+"jbjj");
 // groups.addAll(getAccountsService().getGroups(d));
	 return "addaccountshead.xhtml";
 }
public String addAccountHead()
{   System.out.println("jhujhuj");
	AccountingGroup account=new AccountingGroup();
	account.setStr_Acct_GroupName(accounthead);
	System.out.println(group4+"vhhh");
	account.setCh_Group(group4);
	account.setBl_Default(1);
	account.setInt_ApartmentID(Util.getAppartmentId());
	getAccountsService().addAccountGroup(account);
	return "addaccountshead.xhtml";
}
private List<AccountingGroup>  groups;
public List<AccountingGroup> getGroups() {
	groups=new ArrayList<AccountingGroup>();
	groups.addAll(getAccountsService().getGroups(group4));
	return groups;
}
public void setGroups(List<AccountingGroup> groups) {
	this.groups = groups;
}
public String deleteGroup(int id)
{   System.out.println("hjhhjj");
	AccountingGroup account=new AccountingGroup();
	account.setInt_Acct_GroupID(id);
	getAccountsService().deleteGroup(account);
	return "addaccountshead.xhtml";
	
}
//CUSTOMIZE SETTING 
private Integer int_customize_ID;
private String str_PAN_No;
private String str_Tax_No;
private String str_Socity_Regd_No;
private String str_Address;
private String str_Term_Condition;
private String str_Customization;
private String str_Contact_Name;
private String str_Contact_Number;
private String str_Contact_Email;
public Integer getInt_customize_ID() {
	return int_customize_ID;
}
public void setInt_customize_ID(Integer int_customize_ID) {
	this.int_customize_ID = int_customize_ID;
}
public String getStr_PAN_No() {
	return str_PAN_No;
}
public void setStr_PAN_No(String str_PAN_No) {
	this.str_PAN_No = str_PAN_No;
}
public String getStr_Tax_No() {
	return str_Tax_No;
}
public void setStr_Tax_No(String str_Tax_No) {
	this.str_Tax_No = str_Tax_No;
}
public String getStr_Socity_Regd_No() {
	return str_Socity_Regd_No;
}
public void setStr_Socity_Regd_No(String str_Socity_Regd_No) {
	this.str_Socity_Regd_No = str_Socity_Regd_No;
}
public String getStr_Address() {
	return str_Address;
}
public void setStr_Address(String str_Address) {
	this.str_Address = str_Address;
}
public String getStr_Term_Condition() {
	return str_Term_Condition;
}
public void setStr_Term_Condition(String str_Term_Condition) {
	this.str_Term_Condition = str_Term_Condition;
}
public String getStr_Customization() {
	return str_Customization;
}
public void setStr_Customization(String str_Customization) {
	this.str_Customization = str_Customization;
}
public String getStr_Contact_Name() {
	return str_Contact_Name;
}
public void setStr_Contact_Name(String str_Contact_Name) {
	this.str_Contact_Name = str_Contact_Name;
}
public String getStr_Contact_Number() {
	return str_Contact_Number;
}
public void setStr_Contact_Number(String str_Contact_Number) {
	this.str_Contact_Number = str_Contact_Number;
}
public String getStr_Contact_Email() {
	return str_Contact_Email;
}
public void setStr_Contact_Email(String str_Contact_Email) {
	this.str_Contact_Email = str_Contact_Email;
}
private String blb_image;
public String getBlb_image() {
	return blb_image;
}
public void setBlb_image(String blb_image) {
	this.blb_image = blb_image;
}
	//FILE UPLOAD CONCEPT
	 public void handleFileUpload(FileUploadEvent event) throws IOException {
		 System.out.println("hi");
		 String path = FacesContext.getCurrentInstance().getExternalContext()
		            .getRealPath("/");
		    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		    String name = fmt.format(new Date())
		            + event.getFile().getFileName().substring(
		                  event.getFile().getFileName().lastIndexOf('.'));
		    System.out.println(name);
		      File file= new File("E:\\myUploads//" + "images" + name);
             System.out.println(file);
             blb_image=file.getAbsolutePath();
		    InputStream is = event.getFile().getInputstream();
		    OutputStream out = new FileOutputStream(file);
		    byte buf[] = new byte[1024];
		    int len;
		    str_Customization=file.getName();
		    while ((len = is.read(buf)) > 0)
		        out.write(buf, 0, len);
		    is.close();
		    out.close();
		    
		
	    
	    }
public String addCustomized()
{
	try
	{
		customize customer=new customize();
		customer.setInt_customize_ID(int_customize_ID);
		customer.setStr_PAN_No(str_PAN_No);
		customer.setStr_Tax_No(str_Tax_No);
		customer.setStr_Socity_Regd_No(str_Socity_Regd_No);
		customer.setStr_Address(str_Address);
		customer.setStr_Term_Condition(str_Term_Condition);
		customer.setStr_Customization(str_Customization);
		customer.setStr_Contact_Name(str_Contact_Name);
		customer.setStr_Contact_Number(str_Contact_Number);
		customer.setStr_Contact_Email(str_Contact_Email);
		getAccountsService().addCustomized(customer);
		return "customized.xhtml";
	}
	catch(Exception e)
	{
	e.printStackTrace();
	
	}
	return "customized.xhtml";
}
public void reset()
{
	this.setStr_PAN_No("");
	this.setStr_Socity_Regd_No("");
	this.setStr_Tax_No("");
	this.setStr_Term_Condition("");
	this.setStr_Contact_Email("");
	this.setStr_Contact_Name("");
	this.setStr_Contact_Number("");
	this.setStr_Address("");
}

//NOTIFICATION SETTING
private Integer Int_NotificationId;

private boolean visibility;

private String  smsemail_notification="true";

private String invoice_generate; 
private String before_due_date;
private String defaulter;
private String cc_email;
public Integer getInt_NotificationId() {
	return Int_NotificationId;
}
public void setInt_NotificationId(Integer int_NotificationId) {
	Int_NotificationId = int_NotificationId;
}
public boolean isVisibility() {
	return visibility;
}
public void setVisibility(boolean visibility) {
	this.visibility = visibility;
}
public String getSmsemail_notification() {
	return smsemail_notification;
}
public void setSmsemail_notification(String smsemail_notification) {
	this.smsemail_notification = smsemail_notification;
}
public String getInvoice_generate() {
	return invoice_generate;
}
public void setInvoice_generate(String invoice_generate) {
	this.invoice_generate = invoice_generate;
}
public String getBefore_due_date() {
	return before_due_date;
}
public void setBefore_due_date(String before_due_date) {
	this.before_due_date = before_due_date;
}
public String getDefaulter() {
	return defaulter;
}
public void setDefaulter(String defaulter) {
	this.defaulter = defaulter;
}
public String getCc_email() {
	return cc_email;
}
public void setCc_email(String cc_email) {
	this.cc_email = cc_email;
}
private boolean sms=true;
private boolean sms1=true;
private boolean email=true;
private boolean email1=true;
private boolean grace_period;
private Integer due_days;
public boolean isSms() {
	return sms;
}
public void setSms(boolean sms) {
	this.sms = sms;
}
public boolean isSms1() {
	return sms1;
}
public void setSms1(boolean sms1) {
	this.sms1 = sms1;
}
public boolean isEmail() {
	return email;
}
public void setEmail(boolean email) {
	this.email = email;
}
public boolean isEmail1() {
	return email1;
}
public void setEmail1(boolean email1) {
	this.email1 = email1;
}
public boolean isGrace_period() {
	return grace_period;
}
public void setGrace_period(boolean grace_period) {
	this.grace_period = grace_period;
}
public Integer getDue_days() {
	return due_days;
}
public void setDue_days(Integer due_days) {
	this.due_days = due_days;
}
public void processValueChange2(ValueChangeEvent event)
{
	System.out.println("jjkjk");
}
public void addNotification()
{
	
}
private List<SelectItem> listAccountName1;
public List<SelectItem> getListAccountName1() {
	return listAccountName1;
}
public void setListAccountName1(List<SelectItem> listAccountName1) {
	this.listAccountName1 = listAccountName1;
}

private List<String> accountTypeList;
public List<String> getAccountTypeList() {
	return accountTypeList;
}
public void setAccountTypeList(List<String> accountTypeList) {
	this.accountTypeList = accountTypeList;
}


    }  
	
	
	 

