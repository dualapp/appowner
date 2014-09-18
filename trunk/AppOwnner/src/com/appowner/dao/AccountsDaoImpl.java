package com.appowner.dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;







































import javax.faces.model.SelectItem;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.AccountingGroup;
import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;
import com.appowner.model.Vendor;

@Repository
public class AccountsDaoImpl implements AccountsDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<AccountsOpeningBalance> listOpeningBalance()
	{
		return getSessionFactory().getCurrentSession().createCriteria(AccountsOpeningBalance.class).list();
	}
	public void addAccounts(Integer int_Accounts_OpeningID, Double int_Debit)
	{   String hql="update  AccountsOpeningBalance  set int_Debit =?  where int_Accounts_OpeningID =?";
        
	  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_Debit).setParameter(1,int_Accounts_OpeningID).executeUpdate();
	}
	public void saveAccounts(Integer int_Accounts_OpeningID, Double int_Credit)
	{
		String hql="update  AccountsOpeningBalance  set int_Credit =?  where int_Accounts_OpeningID =?";
      
	  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_Credit).setParameter(1,int_Accounts_OpeningID).executeUpdate();
		
	}
	public void addManualJournal(ManualJournal journal){
		getSessionFactory().getCurrentSession().save(journal);
	}
	public void addBalance(Date date, Integer id1, Integer id)
	{   System.out.println(id);
	
		String hql="update  AccountsOpeningBalance  set dat_openingDate =?,int_ApartmentID=?  where int_Accounts_OpeningID =?";
	    getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, date).setParameter(1, id1).setParameter(2, id).executeUpdate();
	}
	

	@Override
	public void saveChartOfAccount(ChartOfAccount chartOfAccount) {
		getSessionFactory().getCurrentSession().save(chartOfAccount);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChartOfAccount> getChartOfAccountList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(ChartOfAccount.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Character> getCh_AccountGroup() {
				return getSessionFactory().getCurrentSession().createCriteria(AccountingGroup.class).setProjection(Projections.property("ch_Group")).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Character> getCh_AccountGroup1() {
		List<Character> ddd=(List<Character>) getSessionFactory().getCurrentSession().createCriteria(ChartOfAccount.class).setProjection(Projections.property("ch_Group")).list();
		Collections.sort(ddd);
		
		return ddd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAccountTypeList(Character l) {
		String hql="select str_Acct_GroupName from  AccountingGroup where ch_Group=?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, l).list();
	 
	}
	@SuppressWarnings("unchecked")
	public List<String> getAccountTypeList1(Character k)
	{
		String hql="select str_AccountName from  ChartOfAccount where ch_Group=?";
		List<String> ddd=(List<String>)  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,k).list();
		Collections.sort(ddd);
		
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<SelectItem> getAccounts()
	{
		String hql="select str_Acct_GroupName from AccountingGroup  where ch_Group='R'";
		List<SelectItem> ddd=(List<SelectItem>)getSessionFactory().getCurrentSession().createQuery(hql).list();
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<SelectItem> getAccount()
	{
		String hql="select str_Acct_GroupName from AccountingGroup  where ch_Group='R'";
		List<SelectItem> ddd=(List<SelectItem>)getSessionFactory().getCurrentSession().createQuery(hql).list();
		
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public String getAccountName(Integer id1)
	{   
	    if(id1==null)
	    {
		String hql="select str_AccountsHead from AccountsOpeningBalance where int_Accounts_OpeningID=2";
		String sss2=(String)getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
		return sss2;
	    }
	    else
	    {  
	    	String str="select str_AccountsHead from AccountsOpeningBalance where int_Accounts_OpeningID=?";
	    	String sss=(String)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,id1).uniqueResult();
	        
	    	if(sss.equalsIgnoreCase("Income from Resident"))
	    	{
	    		String str1="select str_AccountsHead from AccountsOpeningBalance where int_Accounts_OpeningID=2";
		    	String sss1=(String)getSessionFactory().getCurrentSession().createQuery(str1).uniqueResult();
		    	
		    	return sss1;
	    	}
	    	else  if(sss.equalsIgnoreCase("Accounts Receivable"))
	    	 {  String sss3="from InvoiceTransaction where str_Status='Paid'";
			   List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createQuery(sss3).list();
			  
			   if(ddd.listIterator().hasNext()==true)
			   
	    		return "Accounts Receivable1";
			   else
				   return "Accounts Receivable";
	    	 }
	    	
	      else  if(sss.equalsIgnoreCase("Tax Payable"))
	    	{
	    		return "Tax Payable";
	    	}
	       else 
	    	{   
	    		String str6="select str_paymentAccount from InvoiceTransaction where str_paymentAccount=?";
	    		String Other=(String)getSessionFactory().getCurrentSession().createQuery(str6).setParameter(0, sss).uniqueResult();
	    		
	    	      if(Other==null)
	    		       return sss;
	    	      else 
	    	    	  return Other;
	    	}
	    	
	    }
	
	}
	public double getCreditBalance(Integer id1)
	{   if(id1==null)
	   {
		String hql="select int_Credit from AccountsOpeningBalance where int_Accounts_OpeningID=2";
		Double sss=(Double)getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
		
		return sss;
	   }
	   else
	   {
		   String hql="select int_Credit from AccountsOpeningBalance where int_Accounts_OpeningID=?";
			Double sss=(Double)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,id1).uniqueResult();
			
			return sss;
	   }
	}	
	public double getDebitBalance(Integer id1)	{
		if(id1==null)
		{
		String hql="select int_Debit from AccountsOpeningBalance where int_Accounts_OpeningID=2";
		Double sss=(Double)getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
		
		return sss;
	}
		else{
			String hql="select int_Debit from AccountsOpeningBalance where int_Accounts_OpeningID=?";
			Double sss=(Double)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,id1).uniqueResult();
			
			return sss;
		}
	}
	public int getAccountId(String str)
	{
		String hql="select int_Accounts_OpeningID from AccountsOpeningBalance where str_AccountsHead=?";
		Integer sss=(Integer)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str).uniqueResult();
		
		return sss;
	}
	public String getAccountName1(Integer id1)
	{
		String hql="select str_AccountsHead from AccountsOpeningBalance where int_Accounts_OpeningID=?";
		String sss=(String)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, id1).uniqueResult();
		
		return sss;
	}
	
	@SuppressWarnings("unchecked")
	 public List<InvoiceTransaction> listInvoiceTransaction(String str_Accounts)
	{ 
		if(str_Accounts==null)
	   {  	
			return getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).list();
	   }
		else if(str_Accounts.equalsIgnoreCase("Income from Resident"))
		{  
		  return getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).list();
		}
		else if(str_Accounts.equalsIgnoreCase("Accounts Receivable"))
		{   // String str="From InvoiceTransaction where str_Status='paid'";
			//listInvoiceTransaction1(String str_Accounts)
			 return getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).list();
		}
		else if(str_Accounts.equalsIgnoreCase("Tax Payable"))
		{
			 return getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).list();
		}
	else 
	{   
		String sss="from InvoiceTransaction where str_Status='paid' and str_paymentAccount=?";
		List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createQuery(sss).setParameter(0,str_Accounts).list();
		
		return ddd;
		
	}
	}
	@SuppressWarnings("unchecked")
	 public List<InvoiceTransaction> listInvoiceTransaction1(String str_Accounts)
	{ 
		String sss="from InvoiceTransaction where str_Status='Paid'";
		List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createQuery(sss).list();
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<Double> getTotalBalance()
	{
		String sss="Select totalDue from InvoiceTransaction";
        List<Double> ddd=(List<Double>)getSessionFactory().getCurrentSession().createQuery(sss).list();
		
		return ddd;
	}
	@Override
	public String getStatus(String str_Accounts) {
		// TODO Auto-generated method stub
		return null;
	}
	public Character getChGroup(String str_AccountType)
	{
		String str="select ch_Group from AccountingGroup where str_Acct_GroupName=?";
		return (Character) getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,str_AccountType).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<ManualJournal> getlistManualJournal()
	{
		return getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).list();
	 }
	@SuppressWarnings("unchecked")
	public List<ManualJournal> getlistManualJournal1(String str_Accounts)
	{   System.out.println(str_Accounts+"jamu");
		if(str_Accounts==null)
		{
	     String str="from ManualJournal where str_DebitAccount='Income from Resident' OR str_CreditAccount='Income from Resident'";
		 List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createQuery(str).list();
		 System.out.println(ddd.listIterator().hasNext());
		 return ddd;
		}
		else
		{
			String str="from ManualJournal where str_DebitAccount=? OR str_CreditAccount=?";
			 List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_Accounts).setParameter(1, str_Accounts).list();
			 System.out.println(ddd.listIterator().hasNext());
			 return ddd;
		}
	}
	@SuppressWarnings("unchecked")
	public ManualJournal getManualAccount(Integer id)
	{
		String str="from ManualJournal where int_ManualJournalID=?";
		ManualJournal journal=(ManualJournal)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,id).uniqueResult();
		System.out.println(journal);
		return journal;
	}
	public double getDebitAmount(Integer id)
	{
		String str="Select dbl_DebitAmount from ManualJournal where int_ManualJournalID=?";
		double ddd=(double)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,id).uniqueResult();
		System.out.println(ddd);
		return ddd;
	}
	public double getCreditAmount(Integer id)
	{
		String str="Select dbl_CreditAmount from ManualJournal where int_ManualJournalID=?";
		double ddd=(double)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,id).uniqueResult();
		System.out.println(ddd);
		return ddd;
	}
	
	
	
}
