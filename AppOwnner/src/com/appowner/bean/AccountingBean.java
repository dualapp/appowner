package com.appowner.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import com.appowner.model.ManualJournal;
import com.appowner.service.AccountsService;

@ManagedBean
@SessionScoped
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
	private List<SelectItem> accounts;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public List<SelectItem> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<SelectItem> accounts) {
		this.accounts = accounts;
	}
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init() {
		 accounts = new ArrayList<SelectItem>();
	  SelectItemGroup g1 = new SelectItemGroup("Asset");
	  g1.setSelectItems(new SelectItem[] {
			  new SelectItem("Accounts Receival","Accounts Receival"),
			  new SelectItem("Bank", "Bank"), 
			  new SelectItem("Cash", "Cash")
			  });
	  accounts.add(g1);
       
      SelectItemGroup g2 = new SelectItemGroup("Expense");
      g2.setSelectItems(new SelectItem[] {
    		  new SelectItem("Expense", "Expense"), 
    		
    		  });
      accounts.add(g2);
      SelectItemGroup g3 = new SelectItemGroup("Income");
      g3.setSelectItems(new SelectItem[]{ new SelectItem("Income from Residents","Income from Residents")});
       accounts.add(g3);
       
     
        SelectItemGroup g4 = new SelectItemGroup("Liability");
        g4.setSelectItems(new SelectItem[]{ new SelectItem("Opening Balance Adjustment","Opening Balance Adjustment"),new SelectItem("Tax Payable","Tax Payable")});
         accounts.add(g4);
         
       
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

private Integer index;
public Integer getIndex() {
	return index;
}
public void setIndex(Integer index) {
	this.index = index;
}
public String redirect(int a)
{
   if (a==1)
   {
      index=1;
     return "AccountsTransaction.xhtml";
   }
   else if (a==2)
   {
    index =2;
    return "Manual Journal.xhtml";
   }
   return "AccountsTransaction.xhtml";
}
}
