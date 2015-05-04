package com.appowner.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.RandomStringUtils;
import org.primefaces.event.SelectEvent;

import com.appowner.model.Expense;
import com.appowner.model.ServiceRequest;
import com.appowner.service.ExpenseService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped
public class ExpenseBean1  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{ExpenseService}")
	private ExpenseService expenseService;
	/*
	 * Random number
	 */
	 
	String str_ExpenseId;
	 
	private Date date_Duration;
	public String getStr_Name() {
		return str_Name;
	}
	public void setStr_Name(String str_Name) {
		this.str_Name = str_Name;
	}
	public String getStr_AssetName() {
		return str_AssetName;
	}
	public void setStr_AssetName(String str_AssetName) {
		this.str_AssetName = str_AssetName;
	}
	 
	public String getstr_ExpenseType() {
		return str_ExpenseType;
	}
	public void setstr_ExpenseType(String str_ExpenseType) {
		this.str_ExpenseType = str_ExpenseType;
	}
	public Integer getInt_ExpenseId() {
		return int_ExpenseId;
	}
	public void setInt_ExpenseId(Integer int_ExpenseId) {
		this.int_ExpenseId = int_ExpenseId;
	}
	 
	public Double getDbl_Ammount() {
		return dbl_Ammount;
	}
	public void setDbl_Ammount(Double dbl_Ammount) {
		this.dbl_Ammount = dbl_Ammount;
	}
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	private String str_AssetCategoryType;
	private String str_Name ;
	public String getStr_AssetCategoryType() {
		return str_AssetCategoryType;
	}
	public void setStr_AssetCategoryType(String str_AssetCategoryType) {
		this.str_AssetCategoryType = str_AssetCategoryType;
	}
	public String getStr_AccountName() {
		return str_AccountName;
	}
	public void setStr_AccountName(String str_AccountName) {
		this.str_AccountName = str_AccountName;
	}
	 
	public Date getDate_Duration() {
		return date_Duration;
	}
	public void setDate_Duration(Date date_Duration) {
		this.date_Duration = date_Duration;
	}
	private String str_AssetName;
	private String str_OrganizationName;
	private String str_ExpenseType;
	private String str_ExpenseCategory;
	private Integer int_ExpenseId;
	private Double dbl_Ammount;
	private String str_Description;
	private String str_AccountName;
	 
	
	 
	public String randomId()
	{
		
	  str_ExpenseId=RandomStringUtils.randomAlphanumeric(12);
		 
		return str_ExpenseId;
	}
	 private Integer startIndex=1;
	 private Integer int_UpTosize=2;
public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getInt_UpTosize() {
		return int_UpTosize;
	}
	public void setInt_UpTosize(Integer int_UpTosize) {
		this.int_UpTosize = int_UpTosize;
	}
private List<String>  str_AssetNameList;
private List<String>  str_AccountNameList;
public List<String> getStr_AccountNameList() {
	str_AccountNameList=new ArrayList<String>();
	str_AccountNameList.addAll(getExpenseService().getStr_AccountNameList());
	return str_AccountNameList;
}
public void setStr_AccountNameList(List<String> str_AccountNameList) {
	this.str_AccountNameList = str_AccountNameList;
}
private String str_AssetName1;
private String str_AssetCategoryType1;
public String getStr_AssetCategoryType1() {
	return str_AssetCategoryType1;
}
public void setStr_AssetCategoryType1(String str_AssetCategoryType1) {
	this.str_AssetCategoryType1 = str_AssetCategoryType1;
}
public String getStr_OrganizationName() {
	str_OrganizationName=Util.getAppartmentName();
	return str_OrganizationName;
}
 
public void setStr_OrganizationName(String str_OrganizationName) {
	this.str_OrganizationName = str_OrganizationName;
}
private List<String>  str_AssetNameList1;
private List assetNameList=new ArrayList();
private List assetCatnameList=new ArrayList();
private List dateList=new ArrayList();
private List expenseCategoryList=new ArrayList();
private List expenseTypeList=new ArrayList();
private List accountList=new ArrayList();
private List descriptionList=new ArrayList();
private List ammountList=new ArrayList();
private List<String> str_AssetCatNameList;
/*
 * return all AssetCategoryName from AssetCategory table
 */
public List<String> getStr_AssetCatNameList() {
	str_AssetCatNameList=new ArrayList<String>();
	str_AssetCatNameList=getExpenseService().getAssetCategoryList();
	System.out.println(str_AssetCatNameList);
	return str_AssetCatNameList;
}
public void setStr_AssetCatNameList(List<String> str_AssetCatNameList) {
	
	this.str_AssetCatNameList = str_AssetCatNameList;
}
/*
 * get assetName By assetCategory
 */
public List<String> getStr_AssetNameList() {
	 
	return str_AssetNameList;
}
public List<String> getStr_AssetNameList1() {
	str_AssetNameList1=new ArrayList<String>();
	  
	 str_AssetNameList1.addAll(getExpenseService().getStr_AssetNameList(str_AssetCategoryType1));
	 System.out.println(str_AssetNameList1);
	 
	return str_AssetNameList1;
}
public void setStr_AssetNameList(List<String> str_AssetNameList) {
	this.str_AssetNameList = str_AssetNameList;
}
/*
 * Listeners
 */
public void assetNameListener(ValueChangeEvent  event)
{
	randomId();
	
	 
		 str_AssetName=(String) event.getNewValue();
		 System.out.println(str_AssetName+"assetname");
		 
		 assetNameList.add(str_AssetName);
	 
	 
	//assetNameList.add(event.getNewValue());
	
}
public void assetNameListener1(ValueChangeEvent  event)
{
	randomId();
	 
		 str_AssetName1=(String) event.getNewValue();
		 assetNameList.add(str_AssetName1);
	  
}
public String getStr_ExpenseId() {
	return str_ExpenseId;
}
public void setStr_ExpenseId(String str_ExpenseId) {
	this.str_ExpenseId = str_ExpenseId;
}

public void assetCatNameListener(ValueChangeEvent  event)
{  
	str_AssetCategoryType=(String) event.getNewValue();
	if (str_AssetCategoryType!= null) {
		
		str_AssetNameList = new ArrayList<String>();
		str_AssetNameList.addAll(getExpenseService().getStr_AssetNameList(str_AssetCategoryType));
		}
		else
			str_AssetNameList= new ArrayList<String>();
	assetCatnameList.add(str_AssetCategoryType);
	 
}
public void assetCatNameListener1(ValueChangeEvent  event)
{
	 
   assetCatnameList.add(event.getNewValue());
 
}
public void dateListener(ValueChangeEvent  event)
{
	dateList.add(event.getNewValue());
}
public void expenseCategoryListener(ValueChangeEvent  event)
{
	expenseCategoryList.add(event.getNewValue());
}

public void accountListener(ValueChangeEvent  event)
{
	accountList.add(event.getNewValue());
}
public void descriptionListener(ValueChangeEvent  event)
{
	descriptionList.add(event.getNewValue());
}
public void expenseTypeListener(ValueChangeEvent  event)
{
	expenseTypeList.add(event.getNewValue());
	
}
public void  amountListener(ValueChangeEvent  event)
{
	ammountList.add(event.getNewValue());
}

private Expense expense=new Expense() ;
 
public String addExpenses()
{     
	//ListIterator itr=IDS.listIterator();
	 System.out.println(assetNameList+"seema");
	 System.out.println(assetCatnameList+"sudha");
	ListIterator  assetName=assetNameList.listIterator();
	ListIterator assetCategory=assetCatnameList.listIterator();
	ListIterator expensetype=expenseTypeList.listIterator();
	ListIterator expensecategory=expenseCategoryList.listIterator();
	ListIterator dateduration=dateList.listIterator();
	ListIterator ammountlist=ammountList.listIterator();
	ListIterator descriptionlist=descriptionList.listIterator();
	ListIterator accountlist=accountList.listIterator();
	 
	while(assetName.hasNext() || assetCategory.hasNext()||expensetype.hasNext()||expensecategory.hasNext()||dateduration.hasNext()||ammountlist.hasNext()||descriptionlist.hasNext()||accountlist.hasNext())
	{ 
		
		System.out.println(assetName.hasNext()+"check");
		if(assetName.hasNext()==true && dateduration.hasNext()==true&& assetCategory.hasNext()==true)
		{
		str_AssetName=(String)assetName.next();
		str_AssetCategoryType=(String)assetCategory.next();
		 str_ExpenseType=(String)expensetype.next();
		  str_ExpenseCategory=(String)expensecategory.next();
		 date_Duration=(Date)dateduration.next();
		  dbl_Ammount=(Double)ammountlist.next();
		  str_Description=(String)descriptionlist.next();
		  str_AccountName=(String)accountlist.next();
		 
		  System.out.println(str_ExpenseId);
	
	expense=new Expense();
	expense.setStr_ExpenseId(randomId());
	if(str_ExpenseType.equals("Estimate"))
		
	expense.setStr_Status("Pending Approval");
	else
		expense.setStr_Status("Approved");
	expense.setDate_Duration(getDate_Duration());
	expense.setDbl_Ammount(getDbl_Ammount());
	expense.setStr_AccountName(getStr_AccountName());
	expense.setStr_AssetCatType(getStr_AssetCategoryType());
	expense.setStr_AssetName(getStr_AssetName());
	expense.setStr_ExpenseCategory(getStr_ExpenseCategory());
	expense.setStr_ExpenseType(getstr_ExpenseType());
	expense.setStr_OrganizationName(getStr_OrganizationName());
	expense.setStr_Description(getStr_Description());
	expense.setInt_AppartmentId(Util.getAppartmentId());
	
	getExpenseService().addExpenses(expense);
	
	
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Transaction Saved Successfully!"));
			return "Expenses.xhtml";
		}
	}
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Transaction Saved Successfully!"));
	
	return "Expenses.xhtml";
}
 private String str_Status;
public String getStr_Status() {
	return str_Status;
}
public void setStr_Status(String str_Status) {
	this.str_Status = str_Status;
}
public String getStr_ExpenseCategory() {
	return str_ExpenseCategory;
}
public void setStr_ExpenseCategory(String str_ExpenseCategory) {
	this.str_ExpenseCategory = str_ExpenseCategory;
}
public Expense getExpense() {
	return expense;
}
public void setExpense(Expense expense) {
	this.expense = expense;
}
private List<Expense> expenseList;
private List<Expense> selectedExpenses;

private String query1;
public String getQuery1() {
	return query1;
}
public void setQuery1(String query1) {
	this.query1 = query1;
}
public List<Expense> getExpenseList() {
	
	try{
		expenseList=new ArrayList<Expense>();
		if(str_AssetName==null && str_AssetCategoryType==null && str_ExpenseCategory==null && str_ExpenseType==null && date_Duration==null )
		{   
			query1="";
		}
		if(!(str_AssetName==null) && !(str_AssetName.isEmpty()))
		{
			query1=query1+"str_AssetName="+"'"+str_AssetName+"'";
		}
		
		 if(!(str_AssetCategoryType==null) && !(str_AssetCategoryType.isEmpty()))
			{
				query1=query1+" and "+"str_AssetCatType="+"'"+str_AssetCategoryType+"'";
			}
		 if(!(str_ExpenseCategory==null)&& !(str_ExpenseCategory.isEmpty()))
			{
				query1=query1+" and "+"str_ExpenseCategory="+"'"+str_ExpenseCategory+"'";
			}
		 if(!(str_ExpenseType==null)&& !(str_ExpenseType.isEmpty()))
			{
				query1=query1+" and "+"str_ExpenseType="+"'"+str_ExpenseType+"'";
			}
		 if(!(date_Duration==null))
			{
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String date=formatter.format(date_Duration) ;
			 
				 System.out.println(date+"dddddddddddddddd");
			 
				query1=query1+" and "+"date_Duration="+"'"+date+"'";
			}
		 if(query1.indexOf("and")==1)
			{    
			   query1=query1.replaceFirst("and","" );
	               
			}
			 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	 System.out.println(query1+"qqqqqqqqqqqqqqqqqqqqqqqq");
	expenseList.addAll(getExpenseService().getExpenseList( query1));
	query1="";
	
	
	return expenseList;
}
public void setExpenseList(List<Expense> expenseList) {
	this.expenseList = expenseList;
}
private boolean indicate;
private boolean indicate1;


public boolean isIndicate1() {
	return indicate1;
}
public void setIndicate1(boolean indicate1) {
	this.indicate1 = indicate1;
}
public boolean isIndicate() {
	if(selectedExpenses!=null)
	{
	if (selectedExpenses.size() >= 2)
	{
		indicate=false;
	}
	}
	return indicate;
}
public void setIndicate(boolean indicate) {
	this.indicate = indicate;
}
public String select()
{   
  try{ 
	  if (selectedExpenses.size() >= 2) {
          
		   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("You cannot selected more than 1 row to proceed"));
		   return "Expenses.xhtml";
	  }
	  else if(indicate==false)
   {    
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select a row  to view!"));
   return "Expenses.xhtml";
   }
   
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return null;
}
public String select1()
{   
  try{ 
   if(indicate==false)
   {    
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select a row to edit!"));
		return "Expenses.xhtml";
   }
   
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return null;
}
public void rowUnSelectListener()
{ 
	  
	  indicate=false;
	  indicate1=false;
}
public  void rowSelectListener( SelectEvent event)
{ 
	
	indicate1=true;
	  indicate=true;
}
private Expense expense1;
public void getExpense1(String str_ExpenseId) {
	 
	 
	expense=getExpenseService().getOneExpense(str_ExpenseId);
	if(expense!=null)
	{
		
		str_AssetNameList = new ArrayList<String>();
		str_AssetNameList.addAll(getExpenseService().getStr_AssetNameList(expense.getStr_AssetCatType()));
	}
	
	 
}
public void setExpense1(Expense expense1) {
	this.expense1 = expense1;
}
/*
 * get One Expense Object
 */
public void getOneExpense()
{
	System.out.println(str_ExpenseId);
	
	expense=getExpenseService().getOneExpense(str_ExpenseId);
}
/*
 * Update One Expense Object
 */
public String updateOneExpense()
{
	if(expense.getStr_ExpenseId()!=null)
	{
	getExpenseService().updateOneExpense(expense);
	System.out.println("nbcsjjjjjjjjjjjjjjjzn");
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Updated Successfully!", "Updated Successfully!"));
	}
	return "Expenses.xhtml";
	
}
public String deleteSelectedExpenses()
{
	if(indicate1==false)
	   {    
	   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select an item to delete!"));
	   return "Expenses.xhtml";
	   }
	   else{
		   indicate1=false;
List<Expense> entitiesToDelete = new ArrayList<Expense>();
 
    for (Expense expense :selectedExpenses) {
    	 
    	if (expense.getStr_ExpenseId()!=null) 
    	{
            entitiesToDelete.add(expense);
        }
    	
    } 
 
    getExpenseService().deleteSelectedExpenses(entitiesToDelete);
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Expense Deleted Successfully!"));
	 
    return "Expenses.xhtml";

	   }
}
public String deleteOneExpense()
{expense=new Expense();
expense.setStr_ExpenseId(str_ExpenseId );
getExpenseService().deleteOneExpense(expense);
	return  "Expenses.xhtml?faces-redirect=true";
	
}
public List<Expense> getSelectedExpenses() {
	return selectedExpenses;
}
public void setSelectedExpenses(List<Expense> selectedExpenses) {
	this.selectedExpenses = selectedExpenses;
}
public String getStr_AssetName1() {
	return str_AssetName1;
}
public void setStr_AssetName1(String str_AssetName1) {
	this.str_AssetName1 = str_AssetName1;
}
public ExpenseService getExpenseService() {
	return expenseService;
}
public void setExpenseService(ExpenseService expenseService) {
	this.expenseService = expenseService;
}
public String assignRequestedEstimate(Expense expense)
{ 
	String status=getExpenseService().checkStatus(expense.getStr_ExpenseId());
	System.out.println(status);
	if(status.equalsIgnoreCase("Approved"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(expense.getStr_ExpenseType()+""+" Already Approved"));
		return "Expenses.xhtml";
	}
	
	else if(expense.getStr_Status().equalsIgnoreCase("Rejected"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(expense.getStr_ExpenseType()+""+" Already Rejected"));
		return "Expenses.xhtml";
	}
	str_Status="Approved";
 
getExpenseService().updateStatusOfEstimate(expense.getStr_ExpenseId(),str_Status);
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(expense.getStr_ExpenseType()+""+" Approved Successfully"));
    return "Expenses.xhtml";
}
public String closeRequestedEstimate(Expense expense)
{
	String status=getExpenseService().checkStatus(expense.getStr_ExpenseId());
	System.out.println(status);
	if(status.equalsIgnoreCase("Rejected"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(expense.getStr_ExpenseType()+""+" Already Rejected"));
		return "Expenses.xhtml";
	}
	else if(expense.getStr_Status().equalsIgnoreCase("Approved"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(expense.getStr_ExpenseType()+""+" Already Approved"));
		return "Expenses.xhtml";
	}
	str_Status="Rejected";
	 
	getExpenseService().updateStatusOfEstimate(expense.getStr_ExpenseId(),str_Status);
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(expense.getStr_ExpenseType()+""+"Closed Successfully"));
    return "Expenses.xhtml";
}
}
