package com.appowner.bean;

import java.io.Serializable;
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

import com.appowner.model.Expense;
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
	 
	public String getStr_ExcepenseType() {
		return str_ExcepenseType;
	}
	public void setStr_ExcepenseType(String str_ExcepenseType) {
		this.str_ExcepenseType = str_ExcepenseType;
	}
	public Integer getInt_ExpenseId() {
		return int_ExpenseId;
	}
	public void setInt_ExpenseId(Integer int_ExpenseId) {
		this.int_ExpenseId = int_ExpenseId;
	}
	public Integer getInt_Ammount() {
		return int_Ammount;
	}
	public void setInt_Ammount(Integer int_Ammount) {
		this.int_Ammount = int_Ammount;
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
	private String str_ExcepenseType;
	private String str_ExpenseCategory;
	private Integer int_ExpenseId;
	private Integer int_Ammount;
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
	
	 
		str_AssetNameList=new ArrayList<String>();
		 
	 
	 str_AssetNameList.addAll(getExpenseService().getStr_AssetNameList(str_AssetCategoryType));
	 System.out.println(str_AssetNameList);
	 
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
	
   assetCatnameList.add(event.getNewValue());
 
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

private Expense expense;
 
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
		if(assetName.hasNext()==true && dateduration.hasNext()==true)
		{
		str_AssetName=(String)assetName.next();
		str_AssetCategoryType=(String)assetCategory.next();
		 str_ExcepenseType=(String)expensetype.next();
		  str_ExpenseCategory=(String)expensecategory.next();
		 date_Duration=(Date)dateduration.next();
		  int_Ammount=(Integer)ammountlist.next();
		  str_Description=(String)descriptionlist.next();
		  str_AccountName=(String)accountlist.next();
		 
		  System.out.println(str_ExpenseId);
	
	expense=new Expense();
	expense.setStr_ExpenseId(randomId());
	expense.setDate_Duration(getDate_Duration());
	expense.setInt_Ammount(getInt_Ammount());
	expense.setStr_AccountName(getStr_AccountName());
	expense.setStr_AssetCatType(getStr_AssetCategoryType());
	expense.setStr_AssetName(getStr_AssetName());
	expense.setStr_ExpenseCategory(getStr_ExpenseCategory());
	expense.setStr_ExpenseType(getStr_ExcepenseType());
	expense.setStr_OrganizationName(getStr_OrganizationName());
	expense.setStr_Description(getStr_Description());
	expense.setInt_AppartmentId(Util.getAppartmentId());
	
	getExpenseService().addExpenses(expense);
		}
		else
			return "Expenses.xhtml";
	}
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Transaction Saved Successfully!"));
	
	return "Expenses.xhtml";
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


public List<Expense> getExpenseList() {
	expenseList=new ArrayList<Expense>();
	expenseList.addAll(getExpenseService().getExpenseList(str_AssetName,str_AssetCategoryType,str_ExpenseCategory,str_ExcepenseType,Util.getAppartmentId()));
	
	return expenseList;
}
public void setExpenseList(List<Expense> expenseList) {
	this.expenseList = expenseList;
}
private Expense expense1;
public void getExpense1() {
	expense=new Expense();
	 
	expense=getExpenseService().getOneExpense(str_ExpenseId);
	System.out.println(expense.getStr_AssetName());
	 
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
public String updateOneExpense(Expense expense)
{
	getExpenseService().updateOneExpense(expense);
	System.out.println("nbcsjjjjjjjjjjjjjjjzn");
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Updated Successfully!", "Updated Successfully!"));
	return "Expenses.xhtml";
	
}
public String deleteSelectedExpenses()
{
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
}
