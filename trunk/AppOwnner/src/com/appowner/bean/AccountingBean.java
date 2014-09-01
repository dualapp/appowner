package com.appowner.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UISelectItems;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import com.appowner.model.AccountingGroup;
import com.appowner.model.Assets;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.ManualJournal;
import com.appowner.service.AccountsService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped
public class AccountingBean implements Serializable{
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
	
	
private String dat_FromDate;
private String dat_ToDate;
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
public String addInvoiceManualJournal()
{ try{
	ManualJournal journal=new ManualJournal();
    journal.setStr_Organisation(getStr_Organisation());
    journal.setDat_Date(getDat_Date());
    journal.setStr_Reference(getStr_Reference());
    journal.setStr_Notes(getStr_Notes());
    journal.setStr_DebitAccount(getStr_DebitAccount());
    journal.setStr_CreditAccount(getStr_CreditAccount());
    journal.setDbl_DebitAmount(getStr_DebitAmount());
    journal.setDbl_CreditAmount(getStr_CreditAmount());
    getAccountsService().addManualJournal(journal);
    return null;
    }
  catch(Exception e)
  {
	e.printStackTrace();
  }
	return null;
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
/*(private List<SelectItem> list;
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


@PostConstruct
public void init(){ 
	Object[] st1=getList().toArray();
	//String a=st1.toString();
	SelectItem[] st2=new SelectItem[0];
	int st3=st2.length;
	
	
	  

   SelectItemGroup g1 = new SelectItemGroup("Income");
    g1.setSelectItems(st2);
  
    cars = new ArrayList<SelectItem>();
    cars.add(g1);
   
   
 
     
  
}*/

 
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
	
  /*  SelectItemGroup g2 = new SelectItemGroup("American Cars");
    g2.setSelectItems(new SelectItem[] {new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford")});
     
    listAcc.add(g2);?
}  */

public List<String> getStr_AccountGroup() {
	
	Iterator itr=getCh_AccountGroup().iterator();
	while(itr.hasNext())
	{
		Character c=(Character) itr.next();
		if(c=='A')
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
	
	/*accountTypeList.addAll(getExpenseService().getAccountTypeList());
	System.out.println(accountTypeList+"kskskskskkskskskkskssssssssssssssssssssssssssssssskkkkkkkkkkkkkk"); */
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
	
	System.out.println("hi");
	str_AccountType =(String) event.getNewValue();
	System.out.println(str_AccountType);
	System.out.println("hello");
	
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

}
