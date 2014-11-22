package com.appowner.dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Account;
import com.appowner.model.AccountingGroup;
import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.Expense;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;
import com.appowner.model.customize;

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
		return getSessionFactory().getCurrentSession().createCriteria(AccountsOpeningBalance.class).setCacheable(true).list();
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
		
		return getSessionFactory().getCurrentSession().createCriteria(ChartOfAccount.class).setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Character> getCh_AccountGroup() {
				return getSessionFactory().getCurrentSession().createCriteria(AccountingGroup.class).setCacheable(true).setProjection(Projections.property("ch_Group")).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Character> getCh_AccountGroup1() {
		List<Character> ddd=(List<Character>) getSessionFactory().getCurrentSession().createCriteria(ChartOfAccount.class).setCacheable(true).setProjection(Projections.property("ch_Group")).list();
		Collections.sort(ddd);
		
		return ddd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAccountTypeList(Character l) {
		String hql="select str_Acct_GroupName from  AccountingGroup where ch_Group=?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0, l).list();
	 
	}
	@SuppressWarnings("unchecked")
	public List<String> getAccountTypeList1()
	{  
		String hql="select str_AccountName from  ChartOfAccount ";
		List<String> ddd=(List<String>)  getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		Collections.sort(ddd);
		
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<SelectItem> getAccounts()
	{
		String hql="select str_Acct_GroupName from AccountingGroup  where ch_Group='R'";
		List<SelectItem> ddd=(List<SelectItem>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<SelectItem> getAccount()
	{
		String hql="select str_Acct_GroupName from AccountingGroup  where ch_Group='R'";
		List<SelectItem> ddd=(List<SelectItem>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public String getAccountName(Integer id1)
	{  
	    if(id1==null)
	    {
		String hql="select str_AccountsHead from AccountsOpeningBalance where int_Accounts_OpeningID=2";
		String sss2=(String)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).uniqueResult();
		return sss2;
	    }
	    else
	    {  
	    	String str="select str_AccountsHead from AccountsOpeningBalance where int_Accounts_OpeningID=?";
	    	String sss=(String)getSessionFactory().getCurrentSession().createQuery(str).setCacheable(true).setParameter(0,id1).uniqueResult();
	      
	    	if(sss.equalsIgnoreCase("Income from Resident"))
	    	{
	    		String str1="select str_AccountsHead from AccountsOpeningBalance where int_Accounts_OpeningID=2";
		    	String sss1=(String)getSessionFactory().getCurrentSession().createQuery(str1).setCacheable(true).uniqueResult();
		    	
		    	return sss1;
	    	}
	    	else  if(sss.equalsIgnoreCase("Accounts Receivable"))
	    	 {  String sss3="from InvoiceTransaction where str_Status='Paid'";
			   List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createQuery(sss3).setCacheable(true).list();
			  
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
	    		List<String> Other=getSessionFactory().getCurrentSession().createQuery(str6).setCacheable(true).setParameter(0, sss).list();
	    		System.out.println(Other.listIterator().hasNext()+"gyhtfr");
	    		System.out.println(Other+"hvhjhj");
	    		 for(String s:Other)
	    		 {
	    	      if(s==null)
	    		       return sss;
	    	      else 
	    	    	  return s;
	    		 }
	    	}
	         return sss;	
	    }
		
	
	}
	public double getCreditBalance(Integer id1)
	{   if(id1==null)
	   {
		String hql="select int_Credit from AccountsOpeningBalance where int_Accounts_OpeningID=2";
		Double sss=(Double)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).uniqueResult();
		
		return sss;
	   }
	   else
	   {
		   String hql="select int_Credit from AccountsOpeningBalance where int_Accounts_OpeningID=?";
			Double sss=(Double)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,id1).uniqueResult();
			
			return sss;
	   }
	}	
	public double getDebitBalance(Integer id1)	{
		if(id1==null)
		{
		String hql="select int_Debit from AccountsOpeningBalance where int_Accounts_OpeningID=2";
		Double sss=(Double)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).uniqueResult();
		
		return sss;
	}
		else{
			String hql="select int_Debit from AccountsOpeningBalance where int_Accounts_OpeningID=?";
			Double sss=(Double)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,id1).uniqueResult();
			
			return sss;
		}
	}
	public int getAccountId(String str)
	{
		String hql="select int_Accounts_OpeningID from AccountsOpeningBalance where str_AccountsHead=?";
		Integer sss=(Integer)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,str).uniqueResult();
		System.out.println(sss+"jhjkkj");
		return sss;
	}
	public String getAccountName1(Integer id1)
	{
		String hql="select str_AccountsHead from AccountsOpeningBalance where int_Accounts_OpeningID=?";
		String sss=(String)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0, id1).uniqueResult();
		System.out.println(sss+"kjiuyt");
		return sss;
	}
	
	@SuppressWarnings("unchecked")
	public List<InvoiceTransaction> listInvoiceTransaction(String str_Accounts, Date dat_From, Date dat_ToDate)
	{    
	   if(str_Accounts==null)
	   {
		   if(dat_From==null|| dat_ToDate==null)
		   {
			   {
					System.out.println(dat_From+"priya1");
					return getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).list();
			      }  
		   }
	   }
		if(str_Accounts==null)
	   {  	 if(dat_From!=null|| dat_ToDate!=null)
	      {
			System.out.println(dat_From+"priya");
			return getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).list();
	      }
	   }
		else if(str_Accounts.equalsIgnoreCase("Income from Resident")) 
		{  
		 if(dat_From!=null|| dat_ToDate!=null)
		 {
			 
		 
		  List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.between("dat_InvoiceDate", dat_From,dat_ToDate)).list();
		  System.out.println(ddd.listIterator().hasNext()+"jiuyre");
		  return ddd;
		 }
		}
		else if(str_Accounts.equalsIgnoreCase("Accounts Receivable"))
		{   
			 if(dat_From!=null || dat_ToDate!=null)
			 {  
				 List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.between("dat_InvoiceDate", dat_From,dat_ToDate)).list();
				  System.out.println(ddd.listIterator().hasNext()+"jiuyre11111111111");
				  return ddd;
				 }
		}
	   else if(str_Accounts.equalsIgnoreCase("Tax Payable")) 
		{    
		  if(dat_From!=null || dat_ToDate!=null)
		  {
			
			  List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.between("dat_InvoiceDate", dat_From,dat_ToDate)).list();
			  System.out.println(ddd.listIterator().hasNext()+"jiuyre22222222222");
			  return ddd;
		  }
		}
		
	   else 
	    { 
		   System.out.println("jihytfff");
		   
		  String sss="from InvoiceTransaction where str_Status='paid' and str_paymentAccount=?";
		  List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createQuery(sss).setCacheable(true).setParameter(0,str_Accounts).list();
		     System.out.println(ddd.listIterator().hasNext()+"pitabass");
		   return ddd;
		
	    }
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<InvoiceTransaction> listInvoiceTransaction1(String str_Accounts, Date dat_FromDate, Date dat_ToDate)
	{ 
		
		List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.eq("str_Status", "Paid")).add(Restrictions.between("dat_InvoiceDate", dat_FromDate,dat_ToDate)).list();
		System.out.println(ddd.listIterator().hasNext()+"amulya");
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<Double> getTotalBalance()
	{
		String sss="Select totalDue from InvoiceTransaction";
        List<Double> ddd=(List<Double>)getSessionFactory().getCurrentSession().createQuery(sss).setCacheable(true).list();
		
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
		return (Character) getSessionFactory().getCurrentSession().createQuery(str).setCacheable(true).setParameter(0,str_AccountType).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<ManualJournal> getlistManualJournal()
	{
		return getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).setCacheable(true).list();
	 }
	@SuppressWarnings("unchecked")
	public List<ManualJournal> getlistManualJournal1(String str_Accounts, Date dat_FromDate, Date dat_ToDate)
	{   
		if(str_Accounts==null)
		{
	     String str="from ManualJournal where str_DebitAccount='Income from Resident' OR str_CreditAccount='Income from Resident'";
	     List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createQuery(str).list();
	    // List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).setCacheable(true).add(Restrictions.disjunction().add(Restrictions.eq("str_DebitAccount","Income from Resident")).add(Restrictions.eq("str_CreditAccount","Income from Resident"))).add(Restrictions.between("dat_Date", dat_FromDate,dat_ToDate)).list();
		 return ddd;
		}
		else
		{
			String str="from ManualJournal where str_DebitAccount=? OR str_CreditAccount=?";
			  List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_Accounts).setParameter(1, str_Accounts).list();
			// List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).setCacheable(true).add(Restrictions.disjunction()
			 //   .add(Restrictions.eq("str_DebitAccount",str_Accounts))
			  //  .add(Restrictions.eq("str_CreditAccount",str_Accounts))).add(Restrictions.between("dat_Date", dat_FromDate,dat_ToDate)).list();
			 System.out.println(ddd.listIterator().hasNext()+"jiur");
			 return ddd;
		}
	}
	@SuppressWarnings("unchecked")
	public ManualJournal getManualAccount(Integer id)
	{
		String str="from ManualJournal where int_ManualJournalID=?";
		ManualJournal journal=(ManualJournal)getSessionFactory().getCurrentSession().createQuery(str).setCacheable(true).setParameter(0,id).uniqueResult();
		
		return journal;
	}
	public double getDebitAmount(Integer id)
	{
		String str="Select dbl_DebitAmount from ManualJournal where int_ManualJournalID=?";
		double ddd=(double)getSessionFactory().getCurrentSession().createQuery(str).setCacheable(true).setParameter(0,id).uniqueResult();
		
		return ddd;
	}
	public double getCreditAmount(Integer id)
	{
		String str="Select dbl_CreditAmount from ManualJournal where int_ManualJournalID=?";
		double ddd=(double)getSessionFactory().getCurrentSession().createQuery(str).setCacheable(true).setParameter(0,id).uniqueResult();
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<Expense> getExpenseList(String str, Date dat_FromDate, Date dat_ToDate)
	{  System.out.println(str+"huiop");
	    if(str==null)
	    {
	    	List<Expense> ddd=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).add(Restrictions.eq("str_AccountName", str)).add(Restrictions.eq("str_ExpenseType","Expense")).list();
	         System.out.println(ddd.listIterator().hasNext()+"jikoooooooooooooooo");
	          return ddd;
	    }
	    else if(str.equalsIgnoreCase("Expense"))
		{
			List<Expense> ddd1=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).add(Restrictions.eq("str_ExpenseType","Expense")).list();
			System.out.println(ddd1.listIterator().hasNext()+"jikoooooooooooooooojjjjjjjjjjjjjjjjj");
			return ddd1;
			
			
	    }
			
		
		else 
	   {
			 List<Expense> ddd=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).add(Restrictions.eq("str_AccountName", str)).add(Restrictions.eq("str_ExpenseType","Expense")).list();
	         System.out.println(ddd.listIterator().hasNext()+"jikoooooooooooooooo");
	          return ddd;
	   } 
		
      
}
	@SuppressWarnings("unchecked")
	public List<ChartOfAccount> listAssets()
	{
		String hql="from ChartOfAccount  where ch_Group='A'";
		 
		List<ChartOfAccount> ravenueList= (List<ChartOfAccount>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 
	}
	@SuppressWarnings("unchecked")
	public List<String> group()
	{
		String hql="select ch_Group from ChartOfAccount";
		List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).list();
		return ravenueList;
	}
	public void updateClosingBalance(double debit, double credit, String str)
	{
		String hql="update  ChartOfAccount  set debit_closingBalance =?,credit_closingBalance=?  where str_AccountName =?";
	      
		  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,debit).setParameter(1,credit).setParameter(2, str).executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<ChartOfAccount> listExpense()
	{
		String hql="from ChartOfAccount  where ch_Group='E'";
		 
		List<ChartOfAccount> ravenueList= (List<ChartOfAccount>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 
	}
	@SuppressWarnings("unchecked")
	public List<ChartOfAccount> listLiability()
	{
		String hql="from ChartOfAccount  where ch_Group='L'";
		 
		List<ChartOfAccount> ravenueList= (List<ChartOfAccount>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 	
	}
	@SuppressWarnings("unchecked")
	public List<ChartOfAccount> listEquity()
	{
		String hql="from ChartOfAccount  where ch_Group='Q'";
		 
		List<ChartOfAccount> ravenueList= (List<ChartOfAccount>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 
	}
	@SuppressWarnings("unchecked")
	public List<ChartOfAccount> listRavenues()
	{

		String hql=" from ChartOfAccount  where ch_Group='R'";
		 
		List<ChartOfAccount> ravenueList= (List<ChartOfAccount>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 
	}
	@SuppressWarnings("unchecked")
	public List<Expense> expenseList(Date dat_FromDate, Date dat_ToDate)
	{    if(dat_FromDate==null || dat_ToDate==null)
	    {  
		   System.out.println(dat_FromDate+"huyt");
		 List<Expense> ddd=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).list();
		  System.out.println(ddd.listIterator().hasNext()+"jiuyre111111");
		  return ddd;
	    }
	return null;
	}
	public void addAccount(Account account)
	{
		getSessionFactory().getCurrentSession().save(account);
	}
	@SuppressWarnings("unchecked")
	public List<Account> listAccounts()
	{
		return (List<Account>)getSessionFactory().getCurrentSession().createCriteria(Account.class).setCacheable(true).list();
	}
	@SuppressWarnings("unchecked")
	public List<String> listAccount()
	{
		String hql="select str_acount_Name from Account";
		return (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	}
	@SuppressWarnings("unchecked")
	public List<AccountingGroup>  getAsset()
	{
		String hql=" from  AccountingGroup where ch_Group='A' ";
		return (List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	public List<AccountingGroup> getRevenues()
	{String hql="from  AccountingGroup where ch_Group='R' ";
	return (List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		
	}

	@SuppressWarnings("unchecked")
	public List<AccountingGroup> getLiabilities()
	{
		String hql=" from  AccountingGroup where ch_Group='L' ";
		return (List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	public List<AccountingGroup> getExpense()
	
	{
		String hql="from  AccountingGroup where ch_Group='E' ";
		return (List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	}
	@SuppressWarnings("unchecked")
	public List<AccountingGroup> getGroups(char d)
	{   System.out.println(d+"jjjn");
		String hql="from  AccountingGroup where ch_Group=? ";
		return (List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, d).setCacheable(true).list();
	}
	public void addAccountGroup(AccountingGroup account)
	{
		getSessionFactory().getCurrentSession().save(account);
	}
	public void deleteGroup(AccountingGroup account)
	{
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM AccountingGroup WHERE int_Acct_GroupID = "+account.getInt_Acct_GroupID()).executeUpdate();
	}
	public void saveOpeningAccount(AccountsOpeningBalance balance)
	{
		getSessionFactory().getCurrentSession().save(balance);
	}
	public void addCustomized(customize customer)
	{
		getSessionFactory().getCurrentSession().save(customer);
	}
	public void updateManualJournal(ManualJournal journal)
	{
		getSessionFactory().getCurrentSession().update(journal);
	}
	public void deleteManualJournal(Integer id)
	{   System.out.println(id+"gcccccccccccccccccccccc");
		getSessionFactory().getCurrentSession().createQuery("DELETE FROM ManualJournal WHERE int_ManualJournalID = "+id).executeUpdate();
		System.out.println("hjujjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	}
}
			 
		       
		      
		
		
		
	