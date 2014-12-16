package com.appowner.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

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
import com.appowner.util.Util;

@Repository
public class AccountsDaoImpl implements AccountsDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Integer apartmentID;
	public Integer getApartmentID() {
		apartmentID=Util.getAppartmentId();
		
		return apartmentID;
	}
	public void setApartmentID(Integer apartmentID) {
		this.apartmentID = apartmentID;
	}
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
	public List<String> getAccountTypeList() {
		String hql="select str_Acct_GroupName from  AccountingGroup ";
		return getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	 
	}
	@SuppressWarnings("unchecked")
	public List<String> getAccountTypeList1()
	{  getApartmentID();
		String hql="select str_AccountName from  ChartOfAccount where int_ApartmentId=? or int_ApartmentId=0 ";
		List<String> ddd=(List<String>)  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,apartmentID).setCacheable(true).list();
		Collections.sort(ddd);
		
		
		return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<ChartOfAccount> getAccountTypeList2()
	{
		 getApartmentID();
			String hql="from  ChartOfAccount where int_ApartmentId=? or int_ApartmentId=0 ";
			List<ChartOfAccount> ddd=(List<ChartOfAccount>)  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,apartmentID).setCacheable(true).list();
			
			
			
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
	    		
	    		 for(String s:Other)
	    		 {
	    	      if(Other==null)
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
	{  getApartmentID();  
	   if(str_Accounts==null)
	   {
		   if(dat_From==null|| dat_ToDate==null)
		   {
			   {
					System.out.println(dat_From+"priya1");
					return getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).add(Restrictions.eq("int_Organisation",apartmentID)).setCacheable(true).list();
			      }  
		   }
	   }
		if(str_Accounts==null)
	   {  	 if(dat_From!=null|| dat_ToDate!=null)
	      {
			System.out.println(dat_From+"priya");
			return getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.eq("int_Organisation",apartmentID)).list();
	      }
	   }
		else if(str_Accounts.equalsIgnoreCase("Income from Resident")) 
		{  
		 if(dat_From!=null|| dat_ToDate!=null)
		 {
			 
		 
		  List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.eq("int_Organisation",apartmentID)).add(Restrictions.between("dat_InvoiceDate", dat_From,dat_ToDate)).list();
		  System.out.println(ddd.listIterator().hasNext()+"jiuyre");
		  return ddd;
		 }
		}
		else if(str_Accounts.equalsIgnoreCase("Accounts Receivable"))
		{   
			 if(dat_From!=null || dat_ToDate!=null)
			 {  
				 List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.between("dat_InvoiceDate", dat_From,dat_ToDate)).add(Restrictions.eq("int_Organisation",apartmentID)).list();
				  System.out.println(ddd.listIterator().hasNext()+"jiuyre11111111111");
				  return ddd;
				 }
		}
	   else if(str_Accounts.equalsIgnoreCase("Tax Payable")) 
		{    
		  if(dat_From!=null || dat_ToDate!=null)
		  {
			
			  List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.between("dat_InvoiceDate", dat_From,dat_ToDate)).add(Restrictions.eq("int_Organisation",apartmentID)).list();
			  System.out.println(ddd.listIterator().hasNext()+"jiuyre22222222222");
			  return ddd;
		  }
		}
		
	   else 
	    { 
		   System.out.println("jihytfff");
		   
		  String sss="from InvoiceTransaction where str_Status='paid' and str_paymentAccount=?";
		  List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.eq("int_Organisation",apartmentID)).add(Restrictions.eq("str_Status", "paid")).add(Restrictions.eq("str_paymentAccount",str_Accounts)).add(Restrictions.between("dat_InvoiceDate", dat_From,dat_ToDate)).list();
		     System.out.println(ddd.listIterator().hasNext()+"pitabass");
		   return ddd;
		
	    }
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<InvoiceTransaction> listInvoiceTransaction1(String str_Accounts, Date dat_FromDate, Date dat_ToDate)
	{ 
		getApartmentID();
		List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.eq("str_Status", "Paid")).add(Restrictions.eq("int_Organisation",apartmentID)).add(Restrictions.between("dat_InvoiceDate", dat_FromDate,dat_ToDate)).list();
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
	{    getApartmentID();
		return getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).setCacheable(true).add(Restrictions.eq("str_OrganisationID", apartmentID)).list();
	 }
	@SuppressWarnings("unchecked")
	public List<ManualJournal> getlistManualJournal1(String str_Accounts, Date dat_FromDate, Date dat_ToDate)
	{   getApartmentID();
		if(str_Accounts==null)
		{
			System.out.println("ggggggggggggggggggggggggggggggggggggggg");
	     //String str="from ManualJournal where str_DebitAccount='Income from Resident' OR str_CreditAccount='Income from Resident'";
	    // List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createQuery(str).list();
	     List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).setCacheable(true).add(Restrictions.eq("str_OrganisationID", apartmentID)).add(Restrictions.disjunction().add(Restrictions.eq("str_DebitAccount","Income from Resident")).add(Restrictions.eq("str_CreditAccount","Income from Resident"))).add(Restrictions.between("dat_Date", dat_FromDate,dat_ToDate)).list();
	     System.out.println(ddd+"kkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		 return ddd;
		}
		else
		{  System.out.println("ooooooooooooooooooooo");
		//	String str="from ManualJournal where str_DebitAccount=? OR str_CreditAccount=?";
		//	  List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_Accounts).setParameter(1, str_Accounts).list();
			 List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).setCacheable(true).add(Restrictions.eq("str_OrganisationID", apartmentID)).add(Restrictions.disjunction()
			 .add(Restrictions.eq("str_DebitAccount",str_Accounts))
			  .add(Restrictions.eq("str_CreditAccount",str_Accounts))).add(Restrictions.between("dat_Date", dat_FromDate,dat_ToDate)).list();
			 System.out.println(ddd.listIterator().hasNext()+"jiur");
			 System.out.println(ddd+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
			 return ddd;
		}
	}
	@SuppressWarnings("unchecked")
	public List<ManualJournal> getlistManualJournal2(String str,Date dat_From, Date dat_To)
	{    getApartmentID();
		 List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).setCacheable(true).add(Restrictions.eq("str_OrganisationID", apartmentID)).add(Restrictions.eq("str_CreditAccount",str)).add(Restrictions.between("dat_Date", dat_From,dat_To)).list();
	    
		 return ddd;
	}
	@SuppressWarnings("unchecked")
	public List<ManualJournal> getlistManualJournal3(String str, Date dat_From, Date dat_To)
	{     getApartmentID();
		 List<ManualJournal> ddd=(List<ManualJournal>)getSessionFactory().getCurrentSession().createCriteria(ManualJournal.class).setCacheable(true).add(Restrictions.eq("str_OrganisationID", apartmentID)).add(Restrictions.eq("str_DebitAccount",str)).add(Restrictions.between("dat_Date", dat_From,dat_To)).list();
	     System.out.println(ddd+"kkkkkkkkkkkkkkk");
		 return ddd;
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
	getApartmentID();
	    if(str==null)
	    {
	    	List<Expense> ddd=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).add(Restrictions.eq("int_AppartmentId",apartmentID)).add(Restrictions.eq("str_AccountName", str)).add(Restrictions.eq("str_ExpenseType","Expense")).add(Restrictions.between("date_Duration", dat_FromDate, dat_ToDate)).list();
	         System.out.println(ddd.listIterator().hasNext()+"jikoooooooooooooooo");
	          return ddd;
	    }
	    else if(str.equalsIgnoreCase("Expense"))
		{
			List<Expense> ddd1=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).add(Restrictions.eq("int_AppartmentId",apartmentID)).add(Restrictions.eq("str_ExpenseType","Expense")).add(Restrictions.between("date_Duration", dat_FromDate, dat_ToDate)).list();
			System.out.println(ddd1.listIterator().hasNext()+"jikoooooooooooooooojjjjjjjjjjjjjjjjj");
			return ddd1;
			
			
	    }
			
		
		else 
	   {
			 List<Expense> ddd=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).add(Restrictions.eq("int_AppartmentId",apartmentID)).add(Restrictions.eq("str_AccountName", str)).add(Restrictions.eq("str_ExpenseType","Expense")).add(Restrictions.between("date_Duration", dat_FromDate, dat_ToDate)).list();
	         System.out.println(ddd.listIterator().hasNext()+"jikoooooooooooooooo");
	         System.out.println(ddd+"anupammmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
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
	public void updateClosingBalance(double debit, double credit, String str,double credit1)
	{
		String hql="update  ChartOfAccount  set debit_closingBalance =?,credit_closingBalance=?,closingBalance=?  where str_AccountName =?";
	      
		  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,debit).setParameter(1,credit).setParameter(2, credit1).setParameter(3, str).executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<String> listExpense()
	{   getApartmentID();
		String hql="select str_AccountName from ChartOfAccount  where ch_Group='E' AND int_ApartmentId";
		 
		List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 
	}
	@SuppressWarnings("unchecked")
	public List<String> listLiability()
	{
		String hql=" select str_AccountName from ChartOfAccount  where ch_Group='L'";
		 
		List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 	
	}
	@SuppressWarnings("unchecked")
	public List<String> listEquity()
	{
		String hql=" select str_AccountName from ChartOfAccount  where ch_Group='Q'";
		 
		List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 
	}
	@SuppressWarnings("unchecked")
	public List<String> listRavenues()
	{

		String hql=" select str_AccountName from ChartOfAccount  where ch_Group='R'";
		 
		List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		return ravenueList; 
	}
	@SuppressWarnings("unchecked")
	public List<Expense> expenseList(Date dat_FromDate, Date dat_ToDate)
	{   getApartmentID(); 
		if(dat_FromDate==null || dat_ToDate==null)
	    {  
		   System.out.println(dat_FromDate+"huyt");
		 List<Expense> ddd=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).add(Restrictions.eq("int_AppartmentId",apartmentID)).add(Restrictions.eq("str_ExpenseType","Expense")).add(Restrictions.between("date_Duration", dat_FromDate, dat_ToDate)).list();
		 
		  return ddd;
	    }
	else
	{
		System.out.println(dat_FromDate+"huythhhhhhhhhhhh");
		 List<Expense> ddd=(List<Expense>)getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).add(Restrictions.eq("int_AppartmentId",apartmentID)).add(Restrictions.eq("str_ExpenseType","Expense")).add(Restrictions.between("date_Duration", dat_FromDate, dat_ToDate)).list();
		
		  return ddd;
	}
	
	}
	@SuppressWarnings("unchecked")
	public List<InvoiceTransaction> listInvoiceTransaction2(Date dat_From, Date dat_To)
	{
		getApartmentID();
		 
			 List<InvoiceTransaction> ddd=(List<InvoiceTransaction>)getSessionFactory().getCurrentSession().createCriteria(InvoiceTransaction.class).setCacheable(true).add(Restrictions.eq("int_Organisation",apartmentID)).add(Restrictions.between("dat_InvoiceDate",dat_From,dat_To)).list();
			  System.out.println(ddd.listIterator().hasNext()+"jiuyre111111llll22222222222");
			  System.out.println(ddd+"hhhhhhhhhhhhhh");
			  return ddd; 
		
		
		
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
	{  Integer id=Util.getAppartmentId();
		String hql=" from  AccountingGroup where int_ApartmentID=0 and ch_Group='A'";
		List<AccountingGroup> str=(List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
		
		String hql1="from  AccountingGroup where ch_Group='A'and int_ApartmentID=? ";
		List<AccountingGroup> str1=(List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql1).setCacheable(true).setParameter(0, id).list();
		
		Set<AccountingGroup> str3 = new LinkedHashSet<AccountingGroup>(str);
		
		str3.addAll(str1);
	List<AccountingGroup> str4 = new ArrayList(str3);
		
		return str4;
	}

	@SuppressWarnings("unchecked")
	public List<AccountingGroup> getRevenues()
	{    Integer id=Util.getAppartmentId();
		String hql="from  AccountingGroup where ch_Group='R' and int_ApartmentID=0  ";
	List<AccountingGroup> str=(List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	String hql1="from  AccountingGroup where ch_Group='R'and int_ApartmentID=? ";
	List<AccountingGroup> str1=(List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql1).setCacheable(true).setParameter(0, id).list();
	
	Set<AccountingGroup> str2 = new LinkedHashSet<AccountingGroup>(str);
	
	str2.addAll(str1);
     List<AccountingGroup> str3 = new ArrayList(str2);
	
	 return str3;
	}

	@SuppressWarnings("unchecked")
	public List<AccountingGroup> getLiabilities()
	{
		Integer id=Util.getAppartmentId();
		String hql="from  AccountingGroup where ch_Group='L' and int_ApartmentID=0  ";
	List<AccountingGroup> str=(List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	String hql1="from  AccountingGroup where ch_Group='L'and int_ApartmentID=? ";
	List<AccountingGroup> str1=(List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql1).setCacheable(true).setParameter(0, id).list();
	
	Set<AccountingGroup> str2 = new LinkedHashSet<AccountingGroup>(str);
	
	str2.addAll(str1);
     List<AccountingGroup> str3 = new ArrayList(str2);
	
	return str3;
	}

	@SuppressWarnings("unchecked")
	public List<AccountingGroup> getExpense()
	
	{
		Integer id=Util.getAppartmentId();
		String hql="from  AccountingGroup where ch_Group='E' and int_ApartmentID=0  ";
	List<AccountingGroup> str=(List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).list();
	String hql1="from  AccountingGroup where ch_Group='E'and int_ApartmentID=? ";
	List<AccountingGroup> str1=(List<AccountingGroup>)getSessionFactory().getCurrentSession().createQuery(hql1).setCacheable(true).setParameter(0, id).list();
	
	Set<AccountingGroup> str2 = new LinkedHashSet<AccountingGroup>(str);
	
	str2.addAll(str1);
     List<AccountingGroup> str3 = new ArrayList(str2);
	
	return str3;
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
	{  
		getSessionFactory().getCurrentSession().createQuery("DELETE FROM ManualJournal WHERE int_ManualJournalID = "+id).executeUpdate();
		
	}
	@SuppressWarnings("unchecked")
	public List<Double> getExpenseAmount()
	{   getApartmentID();
		String str="select int_Ammount from Expense where str_ExpenseType='Expense' and int_AppartmentId=?";
		return getSessionFactory().getCurrentSession().createQuery(str).setCacheable(true).setParameter(0,apartmentID).list();
	}
	@SuppressWarnings("unchecked")
	public List<Double> getIncomeAmount(Date dat_To)
	{   getApartmentID();
		String str="select totalDue from InvoiceTransaction where int_Organisation=? AND dat_InvoiceDate <= ?";
		return getSessionFactory().getCurrentSession().createQuery(str).setCacheable(true).setParameter(0, apartmentID).setDate(1, dat_To).list();
	}
	@SuppressWarnings("unchecked")
	public double getCreditAmount(String str, Date dat_ToDate)
	{
		getApartmentID();
		double amounts=0.00;
		
		if(str.equalsIgnoreCase("Income from Resident"))
		{    String hql="select totalDue from InvoiceTransaction where dat_InvoiceDate <=? AND int_Organisation=?";
		  List<Double>	amount=getSessionFactory().getCurrentSession().createQuery(hql).setDate(0, dat_ToDate).setCacheable(true).setParameter(1,apartmentID).list();
		  System.out.println(amount+"priya");
		  ListIterator list=amount.listIterator();
		  while(list.hasNext())
			 {
				 double amount3=(double) list.next();
				
				 amounts=amounts+amount3;
			 }
		 
		}
		if(str.equalsIgnoreCase("Accounts Receivable"))
		{    String hql="select totalDue from InvoiceTransaction where dat_InvoiceDate <=? AND int_Organisation=? AND str_Status=?";
		  List<Double>	amount=getSessionFactory().getCurrentSession().createQuery(hql).setDate(0, dat_ToDate).setCacheable(true).setParameter(1,apartmentID).setParameter(2,"Paid").list();
		  System.out.println(amount+"priya1");
		  ListIterator list=amount.listIterator();
		  while(list.hasNext())
			 {
				 double amount3=(double) list.next();
				
				 amounts=amounts+amount3;
			 }
		 
		}
		 String hql="select int_Ammount from Expense where date_Duration <=? AND int_AppartmentId=? AND str_ExpenseType=? AND str_AccountName=?";
		 List<Double> amount1=(List<Double>) getSessionFactory().getCurrentSession().createQuery(hql).setDate(0,dat_ToDate).setParameter(1, apartmentID).setParameter(2, "Expense").setParameter(3,str).list();
		 System.out.println(amount1+"kunku");
		 String hq11="select dbl_CreditAmount from ManualJournal where str_OrganisationID=? AND str_CreditAccount=? AND dat_Date <= ?";
		 List<Double> amount2=(List<Double>) getSessionFactory().getCurrentSession().createQuery(hq11).setParameter(0, apartmentID).setParameter(1,str).setDate(2, dat_ToDate).list();
		System.out.println(amount2+"anupam");
		 ListIterator list1=amount1.listIterator();
		 ListIterator list2=amount2.listIterator();
		 while(list1.hasNext())
		 {
			 double amount4=(double)list1.next();
			
			 amounts=amounts+amount4;
		 }
		 while(list2.hasNext())
		 {
			 double amount5=(double) list2.next();
			
			 amounts=amounts+amount5;
		 }	 
			 
		
		return amounts;
	}
	@SuppressWarnings("unchecked")
	public double getDebitAmount(String str, Date dat_ToDate)
	{
		getApartmentID();
		double amounts=0.00;
		
		if(str.equalsIgnoreCase("Accounts Receivable"))
		{    String hql="select totalDue from InvoiceTransaction where dat_InvoiceDate <=? AND int_Organisation=?";
		  List<Double>	amount=getSessionFactory().getCurrentSession().createQuery(hql).setDate(0, dat_ToDate).setCacheable(true).setParameter(1,apartmentID).list();
		  System.out.println(amount+"priya");
		  ListIterator list=amount.listIterator();
		  while(list.hasNext())
			 {
				 double amount3=(double) list.next();
				
				 amounts=amounts+amount3;
			 }
		 
		}
		if(str.equalsIgnoreCase("Expense"))
		{
		 String hql="select int_Ammount from Expense where date_Duration <=? AND int_AppartmentId=? AND str_ExpenseType=?";
		 List<Double> amount1=(List<Double>) getSessionFactory().getCurrentSession().createQuery(hql).setDate(0,dat_ToDate).setParameter(1, apartmentID).setParameter(2, "Expense").list();
		 System.out.println(amount1+"kunku");
		 ListIterator list1=amount1.listIterator();
		 while(list1.hasNext())
		 {
			 double amount4=(double) list1.next();
			
			 amounts=amounts+amount4;
		 }
		}
		  String hql="select totalDue from InvoiceTransaction where dat_InvoiceDate <=? AND int_Organisation=? AND str_Status=? AND str_paymentAccount=?";
		  List<Double>	amount=getSessionFactory().getCurrentSession().createQuery(hql).setDate(0, dat_ToDate).setCacheable(true).setParameter(1,apartmentID).setParameter(2,"Paid").setParameter(3,str).list();
		  System.out.println(amount+"priya1");
		  ListIterator list=amount.listIterator();
		  while(list.hasNext())
			 {
				 double amount3=(double) list.next();
				
				 amounts=amounts+amount3;
			 }
		 String hq11="select dbl_DebitAmount from ManualJournal where str_OrganisationID=? AND str_DebitAccount=? AND dat_Date <= ?";
		 List<Double> amount2=(List<Double>) getSessionFactory().getCurrentSession().createQuery(hq11).setParameter(0, apartmentID).setParameter(1,str).setDate(2, dat_ToDate).list();
		System.out.println(amount2+"anupam");
		
		 ListIterator list2=amount2.listIterator();
		
		 while(list2.hasNext())
		 {
			 double amount5=(double) list2.next();
			
			 amounts=amounts+amount5;
		 }	 
			 
		
		return amounts;
	}
	@SuppressWarnings("unchecked")
	public List<String> getIncome()
	{
		 getApartmentID();
			String hql="select str_AccountName from ChartOfAccount  where ch_Group='R' AND int_ApartmentId=0 or int_ApartmentId=?";
			 
			List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0, apartmentID).list();
			return ravenueList; 
	}

	@SuppressWarnings("unchecked")
	public List<String> getExpense1()
	{
		 getApartmentID();
			String hql="select str_AccountName from ChartOfAccount  where ch_Group='E' AND int_ApartmentId=0 or int_ApartmentId=?";
			 
			List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,apartmentID).list();
			System.out.println(ravenueList+"jjjkjkj");
			ravenueList.remove(0);
			return ravenueList; 
	}
	
}
			 
		       
		      
		
		
		
	