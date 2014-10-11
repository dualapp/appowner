package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import com.appowner.model.AccountsOpeningBalance;
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
	System.out.println(int_Accounts_OpeningID);
	System.out.println(id);
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
private List<SelectItem> listAccountName;
@PostConstruct
public void init() {
listAccountName= new ArrayList<SelectItem>();
   
    
    Iterator<String> itr=(getStr_AccountGroup()).iterator();
     
    while(itr.hasNext())
    {
    //	list=new ArrayList<String>();
    	String accountGroup=(String) itr.next();
    	System.out.println(accountGroup+"fdfggf");
    	 accountTypeList=new ArrayList<String>();
    	
    	accountTypeList.addAll(getAccountsService().getAccountTypeList1(accountGroup.charAt(0)));
    	 ListIterator itr1=accountTypeList.listIterator();
    	 while(itr1.hasNext())
    	 {
    		 SelectItemGroup g1 = new SelectItemGroup(accountGroup);
    		 accountGroup=null;
    		 String str=(String) itr1.next();
    		
    		 
    		 g1.setSelectItems(new SelectItem[] {new SelectItem(str)});
    		 
    		 listAccountName.add(g1);
    	 }
    	 
    } 	
}


public List<SelectItem> getListAccountName() {

    	 
      
	return listAccountName;
}
public void setListAccountName(List<SelectItem> listAccountName) {
	this.listAccountName = listAccountName;
}
private Set<String> str_AccountGroup;
private Set<Character> ch_AccountGroup1;
public Set<Character> getCh_AccountGroup1() {
	ch_AccountGroup1=new HashSet<Character>();
	
	ch_AccountGroup1.addAll(getAccountsService().getCh_AccountGroup1());
	return ch_AccountGroup1;
}
public void setCh_AccountGroup1(Set<Character> ch_AccountGroup1) {
	this.ch_AccountGroup1 = ch_AccountGroup1;
}
public Set<String> getStr_AccountGroup() {
	str_AccountGroup=new TreeSet<String>();
	Iterator itr=getCh_AccountGroup1().iterator();
	while(itr.hasNext())
	{
		Character c=(Character) itr.next();
		System.out.println(c.charValue());
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
	 else
		 
		 str_AccountGroup.add("Expense");
	}
	
	return str_AccountGroup;
}

public void setStr_AccountGroup(Set<String> str_AccountGroup) {
	this.str_AccountGroup = str_AccountGroup;
}
private List<String> accountTypeList;
public List<String> getAccountTypeList() {
	return accountTypeList;
}
public void setAccountTypeList(List<String> accountTypeList) {
	this.accountTypeList = accountTypeList;
}

    }  
	
	
	 

