package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import com.appowner.model.AccountsOpeningBalance;
import com.appowner.service.AccountsService;

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
	private Integer int_Accounts_OpeningID;
	private String str_Accounts;
	private Double int_Debit;
	public Date getDat_openingDate() {
		return dat_openingDate;
	}
	public void setDat_openingDate(Date dat_openingDate) {
		this.dat_openingDate = dat_openingDate;
	}
	private Date dat_openingDate;
	
	
	
	
	private Double int_Credit;
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
	
	public Double getInt_Debit() {
		return int_Debit;
	}
	public void setInt_Debit(Double int_Debit) {
		this.int_Debit = int_Debit;
	}
	public Double getInt_Credit() {
		return int_Credit;
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
	@SuppressWarnings("unchecked")
	public void addAccountsHead()  
	   {  
		/*accounts=(AccountsOpeningBalance) updatedAccounts.getRowData();
		System.out.println(getAccounts());
	     System.out.println(accounts);
	    // accounts.setInt_Debit(getInt_Debit());
	   int_Debit=accounts.getInt_Debit();
	    	System.out.println(int_Debit);
	    	
	    */	
	    }
public void processValueChange(ValueChangeEvent event)  
	        throws AbortProcessingException { 
	accounts=(AccountsOpeningBalance) updatedAccounts.getRowData();
	int_Accounts_OpeningID=accounts.getInt_Accounts_OpeningID();
	System.out.println(int_Accounts_OpeningID);
	str_Accounts=accounts.getStr_AccountsHead();
	System.out.println(str_Accounts);
	//accounts.setInt_Accounts_OpeningID(int_Accounts_OpeningID);
	System.out.println(accounts);
	int_Debit=(Double) event.getNewValue();
	accounts.setInt_Debit(int_Debit);
	int_Credit=((Double) event.getOldValue());
	System.out.println(int_Credit);
	System.out.println(int_Debit);
	getAccountsService().addAccounts(int_Accounts_OpeningID,int_Debit);    
	     /*   if (int_Debit != event.getNewValue()) {  
	        	
	        	accounts.setInt_Debit(Double.parseDouble(event.getNewValue().toString()));  
	               int_Debit=accounts.getInt_Debit();
	            //   System.out.println(int_Debit);  
	              // getAccountsService().addAccounts(accounts);          
	        }  */
	    } 
public void processValueChange1(ValueChangeEvent event)  
        throws AbortProcessingException {  
	System.out.println("hi");
	accounts=(AccountsOpeningBalance) updatedAccounts.getRowData();
	int_Accounts_OpeningID=accounts.getInt_Accounts_OpeningID(); 
	int_Credit=(Double) event.getNewValue();
	accounts.setInt_Credit(int_Credit);
	getAccountsService().saveAccounts(int_Accounts_OpeningID,int_Credit);   
        }
private Double totalAmount;
public Double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(Double totalAmount) {
	this.totalAmount = totalAmount;
}
private Double totalAmount1;
public Double getTotalAmount1() {
	return totalAmount1;
}
public void setTotalAmount1(Double totalAmount1) {
	this.totalAmount1 = totalAmount1;
}
private Double adjustmentBalance;
private Double adjustmentBalance1;
public Double getAdjustmentBalance() {
	return adjustmentBalance;
}
public void setAdjustmentBalance(Double adjustmentBalance) {
	this.adjustmentBalance = adjustmentBalance;
}
public Double getAdjustmentBalance1() {
	return adjustmentBalance1;
}
public void setAdjustmentBalance1(Double adjustmentBalance1) {
	this.adjustmentBalance1 = adjustmentBalance1;
}
private Double totalAdjustBalance;
private Double totalAdjustBalance1;
public Double getTotalAdjustBalance() {
	return totalAdjustBalance;
}
public void setTotalAdjustBalance(Double totalAdjustBalance) {
	this.totalAdjustBalance = totalAdjustBalance;
}
public Double getTotalAdjustBalance1() {
	return totalAdjustBalance1;
}
public void setTotalAdjustBalance1(Double totalAdjustBalance1) {
	this.totalAdjustBalance1 = totalAdjustBalance1;
}
    }  
	
	
	 

