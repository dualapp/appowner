package com.appowner.bean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.apache.commons.lang.RandomStringUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;

import com.appowner.model.AccountingGroup;
import com.appowner.model.AddTemplateMessage;
import com.appowner.model.AssetCategory;
import com.appowner.model.Assets;
import com.appowner.model.BookAFacility;
import com.appowner.model.BroadCastMessage1;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.Expense;
import com.appowner.model.FacilityNeeded;
import com.appowner.model.MessageType;
import com.appowner.model.Notice;
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.Vote;
import com.appowner.service.ExpenseService;
import com.appowner.util.Util;
 

@ManagedBean
@ViewScoped
public class ExpenseBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{ExpenseService}")
	private ExpenseService expenseService;
	private String str_AssetCategoryType;
	private String str_Name ;
	public String getStr_AssetCategoryType() {
		return str_AssetCategoryType;
	}
	public void setStr_AssetCategoryType(String str_AssetCategoryType) {
		this.str_AssetCategoryType = str_AssetCategoryType;
	}
	private String str_AssetName;
	private String str_OrganizationName;
	private String str_ExcepenseType;
	private String str_ExpenseCategory;
	private Integer int_ExpenseId;
	private Integer int_Ammount;
	private String str_Description;
	private Integer int_ParkingId;
	private String Str_Organization;
	private String str_ParkingSlot;
	
	private String str_AccountName;
	private List<String> str_OrganizationNameList;
	private List<String> str_AssetCatNameList;
	
	private String str_WelcomeMsg;
	private String str_ApptAddress;
	private String blb_image;
	private String Var_FileName;
	private String Var_ImageName;
	
	private String str_offcInTiming;
	private String str_offcOutTiming;
	private String str_AdditionalInfo;
	private  String str_AppartmentLogo;
	private String str_AppartmentImg;
	private String str_Document_Upload;
	
	private String str_VendorType;
	private String str_VendorName;
	private Date date_PurchaseDate;
	private Date date_WarrantyStartDate;
	private Date  date_WarrantyEndDate;
	
	private Double dbl_Price;
	private String str_SellerNameAnddetails;
	private Date date_AMCStartDate;
	private Date  date_AMCEndDate;
	private String str_PurchaseImg;
	private List<String> images;
	private List<Assets>selectedAssets;
	public List<String> getImages() {
		images=new ArrayList<String>();
		images.addAll(getExpenseService().getOrganizationImages());
		 
		images.add("20140909095522.png");
		images.add("20140909100413.jpg");
		images.add("20140909100617.jpg");
		images.add("20140909101141.jpg");
		System.out.println(images+"images");
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public String getStr_PurchaseImg() {
		return str_PurchaseImg;
	}
	public void setStr_PurchaseImg(String str_PurchaseImg) {
		this.str_PurchaseImg = str_PurchaseImg;
	}
	 
	public Date getDate_AMCStartDate() {
		return date_AMCStartDate;
	}
	public void setDate_AMCStartDate(Date date_AMCStartDate) {
		this.date_AMCStartDate = date_AMCStartDate;
	}
	public Date getDate_AMCEndDate() {
		return date_AMCEndDate;
	}
	public void setDate_AMCEndDate(Date date_AMCEndDate) {
		this.date_AMCEndDate = date_AMCEndDate;
	}
	public String getStr_VendorType() {
		return str_VendorType;
	}
	public void setStr_VendorType(String str_VendorType) {
		this.str_VendorType = str_VendorType;
	}
	public String getStr_VendorName() {
		return str_VendorName;
	}
	public String getStr_SellerNameAnddetails() {
		return str_SellerNameAnddetails;
	}
	public void setStr_SellerNameAnddetails(String str_SellerNameAnddetails) {
		this.str_SellerNameAnddetails = str_SellerNameAnddetails;
	}
	public void setStr_VendorName(String str_VendorName) {
		this.str_VendorName = str_VendorName;
	}
	public Date getDate_PurchaseDate() {
		return date_PurchaseDate;
	}
	public void setDate_PurchaseDate(Date date_PurchaseDate) {
		this.date_PurchaseDate = date_PurchaseDate;
	}
	public Date getDate_WarrantyStartDate() {
		return date_WarrantyStartDate;
	}
	public void setDate_WarrantyStartDate(Date date_WarrantyStartDate) {
		this.date_WarrantyStartDate = date_WarrantyStartDate;
	}
	public Date getDate_WarrantyEndDate() {
		return date_WarrantyEndDate;
	}
	public void setDate_WarrantyEndDate(Date date_WarrantyEndDate) {
		this.date_WarrantyEndDate = date_WarrantyEndDate;
	}
	public Double getDbl_Price() {
		return dbl_Price;
	}
	public void setDbl_Price(Double dbl_Price) {
		this.dbl_Price = dbl_Price;
	}
	
	public String getStr_AppartmentImg() {
		return str_AppartmentImg;
	}
	public void setStr_AppartmentImg(String str_AppartmentImg) {
		this.str_AppartmentImg = str_AppartmentImg;
	}
	public String getStr_Document_Upload() {
		return str_Document_Upload;
	}
	public void setStr_Document_Upload(String str_Document_Upload) {
		this.str_Document_Upload = str_Document_Upload;
	}
	@ManagedProperty(value ="#{loginBean}")
	private LoginBean loginBean;
	
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	 
	public String getStr_offcInTiming() {
		return str_offcInTiming;
	}
	public void setStr_offcInTiming(String str_offcInTiming) {
		this.str_offcInTiming = str_offcInTiming;
	}
	public String getStr_offcOutTiming() {
		return str_offcOutTiming;
	}
	public void setStr_offcOutTiming(String str_offcOutTiming) {
		this.str_offcOutTiming = str_offcOutTiming;
	}
	public String getStr_AdditionalInfo() {
		return str_AdditionalInfo;
	}
	public void setStr_AdditionalInfo(String str_AdditionalInfo) {
		this.str_AdditionalInfo = str_AdditionalInfo;
	}
	public String getStr_Day() {
		return str_Day;
	}
	public void setStr_Day(String str_Day) {
		this.str_Day = str_Day;
	}
	private String str_Day;
	 public String getVar_FileName() {
		return Var_FileName;
	}
	public void setVar_FileName(String var_FileName) {
		Var_FileName = var_FileName;
	}
	public String getVar_ImageName() {
		return Var_ImageName;
	}
	public void setVar_ImageName(String var_ImageName) {
		Var_ImageName = var_ImageName;
	}
	private String blb_images1;

	public String getBlb_images1() {
		return blb_images1;
	}
	public String getStr_AppartmentLogo() {
		return str_AppartmentLogo;
	}
	public void setStr_AppartmentLogo(String str_AppartmentLogo) {
		this.str_AppartmentLogo = str_AppartmentLogo;
	}
	public OrganizationLogo getOl() {
		return ol;
	}
	public void setOl(OrganizationLogo ol) {
		this.ol = ol;
	}
	public void setBlb_images1(String blb_images1) {
		this.blb_images1 = blb_images1;
	}
	
	public String getStr_ApptAddress() {
		return str_ApptAddress;
	}
	public void setStr_ApptAddress(String str_ApptAddress) {
		this.str_ApptAddress = str_ApptAddress;
	}
	public String getStr_WelcomeMsg() {
		return str_WelcomeMsg;
	}
	public void setStr_WelcomeMsg(String str_WelcomeMsg) {
		this.str_WelcomeMsg = str_WelcomeMsg;
	}
	 
	public ExpenseService getExpenseService() {
		return expenseService;
	}
	public void setExpenseService(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	private Date date_Duration;
	 
	public String getStr_AssetName() {
		return str_AssetName;
	}
	public void setStr_AssetName(String str_AssetName) {
		this.str_AssetName = str_AssetName;
	}
	public String getStr_OrganizationName() {
		str_OrganizationName=Util.getAppartmentName();
		return str_OrganizationName;
	}
	 
	public void setStr_OrganizationName(String str_OrganizationName) {
		this.str_OrganizationName = str_OrganizationName;
	}
	public String getStr_ExcepenseType() {
		return str_ExcepenseType;
	}
	public void setStr_ExcepenseType(String str_ExcepenseType) {
		
		this.str_ExcepenseType = str_ExcepenseType;
	}
	public String getStr_ExpenseCategory() {
		return str_ExpenseCategory;
	}
	public void setStr_ExpenseCategory(String str_ExpenseCategory) {
		this.str_ExpenseCategory = str_ExpenseCategory;
	}

	
	public String getStr_AccountName() {
		return str_AccountName;
	}
	public void setStr_AccountName(String str_AccountName) {
		this.str_AccountName = str_AccountName;
	}
	public Integer getInt_ExpenseId() {
		return int_ExpenseId;
	}
	public void setInt_ExpenseId(Integer int_ExpenseId) {
		this.int_ExpenseId = int_ExpenseId;
	}
	public Date getDate_Duration() {
		return date_Duration;
	}
	public void setDate_Duration(Date date_Duration) {
		this.date_Duration = date_Duration;
	}
	

	
/*
 * return All AppartmentName from Appartment table
 */
	public List<String> getStr_OrganizationNameList() {
		//createDir();
		str_OrganizationNameList=new ArrayList<String>();
		str_OrganizationNameList=getExpenseService().getOrgationNameList();
		return str_OrganizationNameList;
	}
	public void setStr_OrganizationNameList(List<String> str_OrganizationNameList) {
		this.str_OrganizationNameList = str_OrganizationNameList;
	}
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
	 
	public Integer getInt_ParkingId() {
		return int_ParkingId;
	}
	public void setInt_ParkingId(Integer int_ParkingId) {
		this.int_ParkingId = int_ParkingId;
	}
	public String getStr_Organization() {
		return Str_Organization;
	}
	public void setStr_Organization(String str_Organization) {
		Str_Organization = str_Organization;
	}
	public String getStr_ParkingSlot() {
		return str_ParkingSlot;
	}
	public void setStr_ParkingSlot(String str_ParkingSlot) {
		this.str_ParkingSlot = str_ParkingSlot;
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

	
	/*
	 * Random number
	 */
	 
	String str_ExpenseId;
	 
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
	private List<String> str_AssetNameList;
private List assetNameList=new ArrayList();
private List assetCatnameList=new ArrayList();
private List dateList=new ArrayList();
private List expenseCategoryList=new ArrayList();
private List expenseTypeList=new ArrayList();
private List accountList=new ArrayList();
private List descriptionList=new ArrayList();
private List ammountList=new ArrayList();
/*
 * get assetName By assetCategory
 */
public List<String> getStr_AssetNameList() {
	//str_AssetNameList=new ArrayList<String>();
	return str_AssetNameList;
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
	
	assetNameList.add(event.getNewValue());
	
}
public String getStr_ExpenseId() {
	return str_ExpenseId;
}
public void setStr_ExpenseId(String str_ExpenseId) {
	this.str_ExpenseId = str_ExpenseId;
}
public List<String> assetCatNameListener(ValueChangeEvent  event)
{
	
	if ((event.getNewValue() != str_AssetCategoryType)) {
		str_AssetNameList = null;
		// str_VendorCity = null;

	}
 
	str_AssetCategoryType=(String) event.getNewValue();
str_AssetNameList=new ArrayList<String>();
str_AssetNameList.addAll(getExpenseService().getStr_AssetNameList(str_AssetCategoryType));
System.out.println(str_AssetNameList);
	
assetCatnameList.add(event.getNewValue());
return str_AssetNameList;
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
	 
	ListIterator  assetName=str_AssetNameList.listIterator();
	ListIterator assetCategory=assetCatnameList.listIterator();
	ListIterator expensetype=expenseTypeList.listIterator();
	ListIterator expensecategory=expenseCategoryList.listIterator();
	ListIterator dateduration=dateList.listIterator();
	ListIterator ammountlist=ammountList.listIterator();
	ListIterator descriptionlist=descriptionList.listIterator();
	ListIterator accountlist=accountList.listIterator();
	 
	while(assetName.hasNext() || assetCategory.hasNext()||expensetype.hasNext()||expensecategory.hasNext()||dateduration.hasNext()||ammountlist.hasNext()||descriptionlist.hasNext()||accountlist.hasNext())
	{
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
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Added Successfully!", "Added Successfully!"));
		}
		else
			return "Expenses.xhtml";
	
	}
	return "Expenses.xhtml";
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
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Expense deleted Successfully!", "Expense deleted Successfully!"));
    } 
 
    getExpenseService().deleteSelectedExpenses(entitiesToDelete);
    return "Expenses.xhtml?faces-redirect=true";

	
}
public String deleteOneExpense()
{expense=new Expense();
expense.setStr_ExpenseId(str_ExpenseId );
getExpenseService().deleteOneExpense(expense);
	return  "Expenses.xhtml?faces-redirect=true";
	
}
public String cancelCommitteeMember () {
	
	
	return "Expenses.xhtml?faces-redirect=true";
	
}
public void onRowEdit(RowEditEvent event) {
	System.out.println("EDITTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
    FacesMessage msg = new FacesMessage("Car Edited");
    FacesContext.getCurrentInstance().addMessage(null, msg);
}
 
public void onRowCancel(RowEditEvent event) {
    FacesMessage msg = new FacesMessage("Edit Cancelled");
    FacesContext.getCurrentInstance().addMessage(null, msg);
}

private Parking parking;

 
public String saveParking()
{
	 
	parking=new Parking();
	parking.setStr_OrganizationName(Util.getAppartmentName());
	parking.setStr_ParkingSlot(getStr_ParkingSlot());
	parking.setInt_AppartmentId(Util.getAppartmentId());
	getExpenseService().saveParking(parking);
	 return "parkingspace.xhtml";
}
 
public String deleteParkingSlot()
{
	System.out.println("HBNNNNNNNNNNNNNNNNNNNNNNNNNm");
	Parking p=new Parking();
	System.out.println(int_ParkingId+"kalpana");
	p.setInt_ParkingId(int_ParkingId);
	getExpenseService().deleteParkingSlot(p);
	return  "parkingspace.xhtml?faces-redirect=true";
}
public String deleteParkingSpace()
{
	List<Parking> entitiesToDelete = new ArrayList<Parking>();
	 
    for (Parking parking :parkingSpaceList1) {
    	 
    	if (parking.getInt_ParkingId()!=null) 
    	{
            entitiesToDelete.add(parking);
        }
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Parking Space deleted Successfully!", "Parking Space deleted Successfully!"));
    } 
 
    getExpenseService().deleteParkingSpace(entitiesToDelete);
	return "parkingspace.xhtml";
}
  
public Parking getParking() {
	return parking;
}
public void setParking(Parking parking) {
	this.parking = parking;
}
private List<Parking> parkingSpaceList;
private List<Parking> parkingSpaceList1;

public  void updateParkingSpace(Parking p)
{
	System.out.println("updateeeeeeee");
	getExpenseService().updateParkingSpace( p);
	System.out.println("updat");
	 
	
}
 
public List<Parking> getParkingSpaceList() {
	parkingSpaceList=new ArrayList<Parking>();
	parkingSpaceList.addAll(getExpenseService().getParkingSlotList());
 
	return parkingSpaceList;
}
public void setParkingSpaceList(List<Parking> parkingSpaceList) {
	this.parkingSpaceList = parkingSpaceList;
}
 
/*
 * file Upload
 */
/**
 * create directory dynamically
 */
/*public void createDir()
{
File file = new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images\\SaphiParadise");
 if (!file.exists()) {
	if (file.mkdir()) {
		System.out.println("Directory is created!");
	} else {
		System.out.println("Failed to create directory!");
	}
 }
}*/
private String path1;
private String path;
private String textLogo;
private OrganizationLogo ol;


public String getBlb_image() {
	return blb_image;
}
public void setBlb_image(String blb_image) {
	this.blb_image = blb_image;
}
/*
 * Upload Appartment Logo
 */
public void  handleFileUpload(FileUploadEvent event) throws IOException {
	 System.out.println("hi kalpana");
	 
	   path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	    str_AppartmentLogo = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
	    File file=new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images",Util.getAppartmentName());
	    if (!file.exists()) {
    	if (file.mkdir()) {
    		System.out.println("Directory is created!");
    	} else {
    		System.out.println("Failed to create directory!");
    	}
     }
	    file= new File(file,str_AppartmentLogo);
	    
	    //final UploadedFile uploadedFile = event.getFile();
	    
	    path=file.getAbsolutePath();
	     
      
	    InputStream is = event.getFile().getInputstream();
	    
	    OutputStream out = new FileOutputStream(file);
	    byte buf[] = new byte[1024];
	    int len;
	    while ((len = is.read(buf)) > 0)
	        out.write(buf, 0, len);
	    
	    FacesMessage msg = new FacesMessage("Succesful",
                event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
	    is.close();
	    out.close();
	    
	    
	    
}
/*
 * upload Document
 */
private String path2;
public String getPath2() {
	return path2;
}
public void setPath2(String path2) {
	this.path2 = path2;
}
public void  handleFileUpload2(FileUploadEvent event) throws IOException {
	 System.out.println("hi sudha");
	   path2 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	    str_Document_Upload = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
	     
	    File file=new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images",Util.getAppartmentName());
	    if (!file.exists()) {
   	if (file.mkdir()) {
   		System.out.println("Directory is created!");
   	} else {
   		System.out.println("Failed to create directory!");
   	}
    }
	    file= new File(file,str_Document_Upload);
	 
	    //final UploadedFile uploadedFile = event.getFile();
	    
	    path2=file.getAbsolutePath();
	    System.out.println(path2+"path2");
     
	    InputStream is = event.getFile().getInputstream();
	    OutputStream out = new FileOutputStream(file);
	    byte buf[] = new byte[1024];
	    int len;
	    while ((len = is.read(buf)) > 0)
	        out.write(buf, 0, len);
	    is.close();
	    out.close();
	    FacesMessage msg = new FacesMessage("Succesful",
                event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
	    
}
/*
 * upload Appartment Image
 */
public void  handleFileUpload1(FileUploadEvent event) throws IOException {
	  path1 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
    str_AppartmentImg = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
    
   // System.out.println(str_AppartmentImg);
    File file=new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images",Util.getAppartmentName());
    if (!file.exists()) {
	if (file.mkdir()) {
		System.out.println("Directory is created!");
	} else {
		System.out.println("Failed to create directory!");
	}
 }
    file= new File(file,str_AppartmentImg);
//  file.renameTo(new File( path+"//mackback.png"));
   
    //final UploadedFile uploadedFile = event.getFile();
    path1=file.getAbsolutePath();
    System.out.println(path1+"path");
    InputStream is = event.getFile().getInputstream();
    OutputStream out = new FileOutputStream(file);
    byte buf[] = new byte[1024];
    int len;
    while ((len = is.read(buf)) > 0)
        out.write(buf, 0, len);
    is.close();
    out.close();
    FacesMessage msg = new FacesMessage("Succesful",
            event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	
}
 
public void addOrganizationLogo ()
{
	ol=new OrganizationLogo();
	Integer logoid=getExpenseService().getLogoId(Util.getAppartmentId());
	 if(logoid!=null)
	{ 
		 ol.setInt_OthersInfoId(logoid);
		 ol.setInt_AppartmentId(Util.getAppartmentId());
		 ol.setStr_Appartment_Img(getStr_AppartmentImg());
		 ol.setStr_Appartment_Logo(getStr_AppartmentLogo());
	 getExpenseService().updateLogo(ol);
	}
	else
	{
	ol.setStr_Appartment_Logo(getStr_AppartmentLogo());
	ol.setStr_InTime(getStr_offcInTiming());
	ol.setStr_OutTime(getStr_offcOutTiming());
	ol.setStr_TextLogo(getTextLogo());
	ol.setStr_ApptAddress(getStr_ApptAddress());
	ol.setStr_WelcomeMsg(getStr_WelcomeMsg());
	System.out.println(Util.getAppartmentId());
	ol.setInt_AppartmentId(Util.getAppartmentId());
	ol.setStr_Document_Upload(getStr_Document_Upload());
	ol.setStr_Appartment_Img(getStr_AppartmentImg());
     
	getExpenseService().addOrganizationLogo(ol);
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"   Added Successfully!", "  Added Successfully!"));
	 
	}
	 
}
 
 

public   void getOrganizationLogo()
{ ol=new OrganizationLogo();
  ol=getExpenseService().getOrganizationLogo(Util.getAppartmentId());
  System.out.println(ol+""+"hgxdddddddddddddddd");
  File file=new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images",Util.getAppartmentName());
  if (!file.exists()) {
	if (file.mkdir()) {
		System.out.println("Directory is created!");
	} else {
		System.out.println("Failed to create directory!");
	}
}
  path="/images"+"/"+Util.getAppartmentName()+"/"+ol.getStr_Appartment_Img();
  System.out.println(path1);
  path1="/images"+"/"+Util.getAppartmentName()+"/"+ol.getStr_Appartment_Logo();
  if(ol==null)
  System.out.println(ol+""+"sudhaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	 
}
public String getTextLogo() {
	return textLogo;
}
public void setTextLogo(String textLogo) {
	this.textLogo = textLogo;
}
 

public String getPath() {
	getOrganizationLogo();
	System.out.println(path);
	 
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getPath1() {
	 
	System.out.println(path1+""+"kalpana");
	return path1;
}

public void setPath1(String path1) {
	this.path1 = path1;
}
/*
 * Asset concept
 */
private List<String> str_BlockListByAppartmentName;
private String str_Block;
private Assets asset;
private Boolean bool_Rentable;
private AssetCategory assetcategory;
private List<AssetCategory> assetCategoryList;
private List<AssetCategory> assetCategoryList1;
public void updateAssetCategory(AssetCategory ac)
{
	getExpenseService().updateAssetCategory( ac);
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"   Updated Successfully!", "  Updated Successfully!"));
	 
}
public String deleteAssetsCategory()
{
	 List<AssetCategory> entitiesToDelete = new ArrayList<AssetCategory>();
	  
     for (AssetCategory ac :assetCategoryList1) {
     	 
     	if (ac.getInt_assetcatId()!=null) 
     	{
             entitiesToDelete.add(ac);
         }
     	
     } 
     
  
     getExpenseService().delectAssetsCategory(entitiesToDelete);
 
FacesContext facesContext = FacesContext.getCurrentInstance();
Flash flash = facesContext.getExternalContext().getFlash();
flash.setKeepMessages(true);
flash.setRedirect(true);
facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," AssetCategory deleted Successfully!", "AssetCategory deleted Successfully!"));
return "assetcategory.xhtml";
}
public List<AssetCategory> getAssetCategoryList1() {
	return assetCategoryList1;
}
public void setAssetCategoryList1(List<AssetCategory> assetCategoryList1) {
	this.assetCategoryList1 = assetCategoryList1;
}
private String path3;
private List<Assets> assetList;

public void setAssetCategoryList(List<AssetCategory> assetCategoryList) {
	this.assetCategoryList = assetCategoryList;
}
public AssetCategory getAssetcategory() {
	return assetcategory;
}
public void setAssetcategory(AssetCategory assetcategory) {
	this.assetcategory = assetcategory;
}
public Boolean getBool_Rentable() {
	return bool_Rentable;
}
public void setBool_Rentable(Boolean bool_Rentable) {
	this.bool_Rentable = bool_Rentable;
}
 
public Assets getAsset() {
	return asset;
}
public void setAsset(Assets asset) {
	this.asset = asset;
}
public String deleteOneAsset1()
{ 
	 List<Assets> entitiesToDelete = new ArrayList<Assets>();
	  
	     for (Assets asset :selectedAssets) {
	     	 
	     	if (asset.getInt_asset_id()!=null) 
	     	{
	             entitiesToDelete.add(asset);
	         }
	     	
	     } 
	     
	  
	     getExpenseService().deleteOnefacility(entitiesToDelete);
	 
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Asset deleted Successfully!", "asset deleted Successfully!"));
	 return "assets.xhtml?faces-redirect=true";
	
}

public String updateOneAsset(Assets asset)
{
	getExpenseService().updateOneasset( asset);
	 
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Asset Updated Successfully!", "Asset Updated Successfully!"));
	return "assets.xhtml";
}
/*
 * get asset,purchase,amc list
 */
public List<Assets> getAssetList() {
	assetList= new ArrayList<Assets>();
	assetList.addAll(getExpenseService().getAssetList(str_AssetCategoryType,str_Block,Util.getAppartmentId()));
	return assetList;
}
public void setAssetList(List<Assets> assetList) {
	this.assetList = assetList;
}
public String getStr_AssetImg() {
	return str_AssetImg;
}
public void setStr_AssetImg(String str_AssetImg) {
	this.str_AssetImg = str_AssetImg;
}
private String str_AssetImg;
public String getStr_Block() {
	return str_Block;
}
public void setStr_Block(String str_Block) {
	this.str_Block = str_Block;
}
public List<AssetCategory> getAssetCategoryList() {
	assetCategoryList=new ArrayList<AssetCategory>();
	assetCategoryList.addAll(getExpenseService().getAssetCategoryList1());
	return assetCategoryList;
}
public List<String> getStr_BlockListByAppartmentName() {
	str_BlockListByAppartmentName=new ArrayList<String>();
	str_BlockListByAppartmentName.addAll(getExpenseService().getStr_BlockListByAppartmentName(Util.getAppartmentId()));
	return str_BlockListByAppartmentName;
}
public void setStr_BlockListByAppartmentName(
		List<String> str_BlockListByAppartmentName) {
	this.str_BlockListByAppartmentName = str_BlockListByAppartmentName;
}

public void addAsset()
{
	asset =new Assets();
	asset.setStr_assetcat_name(str_AssetCategoryType);
	asset.setStr_AssetImg(str_AssetImg);
	asset.setStr_AssetName(str_AssetName);
	asset.setStr_Block(str_Block);
	asset.setStr_OrganizationName(str_OrganizationName);
	asset.setBool_Rentable(getBool_Rentable());
	asset.setDate_AMCStartDate(date_AMCStartDate);
	asset.setDate_AMCEndDate(date_AMCEndDate);
	asset.setDate_PurchaseDate(date_PurchaseDate);
	asset.setDate_WarrantyEndDate(date_WarrantyEndDate);
	asset.setDate_WarrantyStartDate(date_WarrantyStartDate);
	asset.setDbl_Price(dbl_Price);
	asset.setStr_PurchaseImg(str_PurchaseImg);
	asset.setStr_SellerNameAnddetails(str_SellerNameAnddetails);
	asset.setStr_VendorName(str_VendorName);
	asset.setStr_VendorType(str_VendorType);
	asset.setInt_AppartmentId(Util.getAppartmentId());
	getExpenseService().addAsset(asset);
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Asset Added Successfully!", "Asset Added Successfully!"));
	
}
/*
 * Asset Image
 */


public void  handleFileUpload4(FileUploadEvent event) throws IOException {
	 
	   path3 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	    str_AssetImg = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
	    File file=new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images",Util.getAppartmentName());
	    if (!file.exists()) {
   	if (file.mkdir()) {
   		System.out.println("Directory is created!");
   	} else {
   		System.out.println("Failed to create directory!");
   	}
    }
	    file= new File(file,str_AssetImg);
	    
	    //final UploadedFile uploadedFile = event.getFile();
	    
	    path3=file.getAbsolutePath();
	     
     
	    InputStream is = event.getFile().getInputstream();
	    
	    OutputStream out = new FileOutputStream(file);
	    byte buf[] = new byte[1024];
	    int len;
	    while ((len = is.read(buf)) > 0)
	        out.write(buf, 0, len);
	    
	    FacesMessage msg = new FacesMessage("Succesful",
               event.getFile().getFileName() + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, msg);
	    is.close();
	    out.close();
	    
	    
	    
}
public String getPath3() {
	return path3;
}
public void setPath3(String path3) {
	this.path3 = path3;
}
public String saveAssetCategory()
{
	assetcategory=new AssetCategory();
	assetcategory.setStr_assetcat_name(str_AssetCategoryType);
	assetcategory.setStr_OrganizationName(str_OrganizationName);
	
	getExpenseService().saveAssetCategory(assetcategory);
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"   Added Successfully!", " Added Successfully!"));
	return"assetcategory.xhtml";
}
/*
 * chart of accounts concept
 */
private String str_AccountType;
private List<ChartOfAccount> chartOfAccountList;

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
	chartOfAccountList.addAll(getExpenseService().getChartOfAccountList());
	return chartOfAccountList;
}
public void setChartOfAccountList(List<ChartOfAccount> chartOfAccountList) {
	this.chartOfAccountList = chartOfAccountList;
}
private List<String> list;
@PostConstruct
public void init() {
     
    
	listAccountType= new ArrayList<SelectItem>();
   
    
    ListIterator itr=getStr_AccountGroup().listIterator();
     
    while(itr.hasNext())
    {
    	list=new ArrayList<String>();
    	String accountGroup=(String) itr.next();
    	 accountTypeList=new ArrayList<String>();
    	
    	accountTypeList.addAll(getExpenseService().getAccountTypeList(accountGroup.charAt(0)));
    	 ListIterator itr1=accountTypeList.listIterator();
    	 while(itr1.hasNext())
    	 {
    		 SelectItemGroup g1 = new SelectItemGroup(accountGroup);
    		 accountGroup=null;
    		 String str=(String) itr1.next();
    		 /*list.add(str);
    		 list.add(System.setProperty("line.separator", "\n"));
    		 g1.setSelectItems(new SelectItem[] {new SelectItem(list.toString().replaceAll("[\\[\\],]",""))});*/
    		 
    		 g1.setSelectItems(new SelectItem[] {new SelectItem(str)});
    		 
    		 listAccountType.add(g1);
    	 }
    	 
    	
    	 
    }
   
	System.out.println( listAccountType);
    /*SelectItemGroup g2 = new SelectItemGroup("American Cars");
    g2.setSelectItems(new SelectItem[] {new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford")});
     
    listAcc.add(g2);*/
}
public List<String> getList() {
	return list;
}
public void setList(List<String> list) {
	this.list = list;
}
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
	ch_AccountGroup.addAll(getExpenseService().getCh_AccountGroup());
	 
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

public void saveChartOfAccount()
{
	chartOfAccount=new ChartOfAccount();
	chartOfAccount.setInt_UserId(Util.getUserId());
	chartOfAccount.setInt_ApartmentId(Util.getAppartmentId());
	chartOfAccount.setStr_AccountName(str_AccountName);
	chartOfAccount.setStr_OrganizationName(str_OrganizationName);
	chartOfAccount.setStr_AccountType(str_AccountType);
	getExpenseService().saveChartOfAccount(chartOfAccount);
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"   Added Successfully!", " Added Successfully!"));
	
	
}
private List<Assets> assetsList;
public List<Assets> getAssetsList() {
	assetsList=new ArrayList<Assets>();
	assetsList.addAll(getExpenseService().getAssetsList());
	
	return assetsList;
}
public void setAssetsList(List<Assets> assetsList) {
	this.assetsList = assetsList;
}
/*
 * FacilityNeeded concept
 */
private String str_FacilityName;
private List<FacilityNeeded>  facilityNeededList;
private FacilityNeeded facilityNeeded;
private List<String> facilityTypeList;
private List<FacilityNeeded> selectedFacilities;
public List<FacilityNeeded> getSelectedFacilities() {
	return selectedFacilities;
}
public void setSelectedFacilities(List<FacilityNeeded> selectedFacilities) {
	this.selectedFacilities = selectedFacilities;
}
public List<String> getFacilityTypeList() {
	facilityTypeList=new ArrayList<String>();
	facilityTypeList.addAll(getExpenseService().getFacilityTypeList());
	return facilityTypeList;
}
public void setFacilityTypeList(List<String> facilityTypeList) {
	this.facilityTypeList = facilityTypeList;
}
public String getStr_FacilityName() {
	return str_FacilityName;
}
public void setStr_FacilityName(String str_FacilityName) {
	this.str_FacilityName = str_FacilityName;
}
/*
 * paging concept
 */
private int rowPerPage=5;
private Integer pageCurrent;
 
private Integer totalRows;
 
private int firstRow;
private Integer[] pages ;
private int pageRange = 10; 
private int totalPages;

public int getTotalPages() {
	return totalPages;
}
public void setTotalPages(int totalPages) {
	this.totalPages = totalPages;
}
public Integer getTotalRows() {
	return totalRows;
}
public void setTotalRows(Integer totalRows) {
	this.totalRows = totalRows;
}
public Integer getPageCurrent() {
	 
	return pageCurrent;
}
public void setPageCurrent(Integer pageCurrent) {
	this.pageCurrent = pageCurrent;
}
public int getrowPerPage() {
	 
	return rowPerPage;
}
public void setrowPerPage(int rowPerPage) {
	this.rowPerPage = rowPerPage;
}
 
 
public int getFirstRow() {
    return firstRow;
}
 
public void setFirstRow(Integer firstRow) {
	this.firstRow = firstRow;
}
public Integer[] getPages() {
	return pages;
}
public void setPages(Integer[] pages) {
	this.pages = pages;
}
 /*
  * paging Actions
  */
public void pageFirst() {
    page(0);
}

public void pageNext() {
    page(firstRow + rowPerPage);
}

public void pagePrevious() {
    page(firstRow - rowPerPage);
}

public void pageLast() {
    page(totalRows - ((totalRows % rowPerPage != 0) ? totalRows % rowPerPage : rowPerPage));
}
private void page(int firstRow) {
    this.firstRow = firstRow;
    loadFacilityNeededList(); // Load requested page.
}
public void page(ActionEvent event) {
    page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowPerPage);
}


 
private void loadFacilityNeededList()
{
	facilityNeededList=new ArrayList<FacilityNeeded>();
	facilityNeededList.addAll(getExpenseService().getFacilityNeededList(firstRow, rowPerPage));
	
	 totalRows=getExpenseService().count();
	  
	 System.out.println(totalRows+"totalrows");
	 totalPages = (totalRows / rowPerPage) + ((totalRows % rowPerPage != 0) ? 1 : 0); 
	 pageCurrent=(totalRows / rowPerPage) - ((totalRows - 0) / rowPerPage) + 1;
	 int pagesLength = Math.min(pageRange, totalPages);    
     pages = new Integer[pagesLength];  
     int firstPage = Math.min(Math.max(0, pageCurrent - (pageRange / 2)), totalPages - pagesLength);  
     // Create pages (page numbers for page links).  
     for (int i = 0; i < pagesLength; i++) {  
         pages[i] = ++firstPage;  
     }   
}
public List<FacilityNeeded> getFacilityNeededList() {
	
	if (facilityNeededList== null) {
		loadFacilityNeededList(); // Preload page for the 1st view.
    }
	return facilityNeededList;
}
public void setFacilityNeededList(List<FacilityNeeded> facilityNeededList) {
	this.facilityNeededList = facilityNeededList;
}
public String updateFacility(FacilityNeeded fn1)
{  getExpenseService().updateFacility(fn1);

FacesContext facesContext = FacesContext.getCurrentInstance();
Flash flash = facesContext.getExternalContext().getFlash();
flash.setKeepMessages(true);
flash.setRedirect(true);
facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"   Updated Successfully!", " Updated Successfully!"));
return "facilityneeded.xhtml";
}
public FacilityNeeded getFacilityNeeded() {
	return facilityNeeded;
}
public void setFacilityNeeded(FacilityNeeded facilityNeeded) {
	this.facilityNeeded = facilityNeeded;
}
public String addFacility()
{
	facilityNeeded=new FacilityNeeded();
	facilityNeeded.setStr_FacilityName(str_FacilityName);
	facilityNeeded.setInt_ApartmentId(Util.getAppartmentId());
	getExpenseService().addFacility(facilityNeeded);
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"   added Successfully!", " added Successfully!"));
	return "facilityneeded.xhtml";
}
public String deletefacilityNeeded()
{
	 List<FacilityNeeded> entitiesToDelete = new ArrayList<FacilityNeeded>();
	  
     for (FacilityNeeded fn :selectedFacilities) {
     	 
     	if (fn.getInt_FacilityId()!=null) 
     	{
             entitiesToDelete.add(fn);
         }
     	
     } 
     
  
     getExpenseService().deletefacilityNeeded(entitiesToDelete);
 
FacesContext facesContext = FacesContext.getCurrentInstance();
Flash flash = facesContext.getExternalContext().getFlash();
flash.setKeepMessages(true);
flash.setRedirect(true);
facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"   deleted Successfully!", " deleted Successfully!"));
return "facilityneeded.xhtml";
}

/*
 * pool concept
 */
private String str_Choise1;
private String str_Choise2;
private String str_Choise3;
private String str_PoolQuestion;
private String str_PoolAudience;
private Long long_Vote;
private String str_EndDate;
 

private String str_StartDate;
private List<Pool> poolList;
private Pool pool;
private String str_Status;
private Integer int_PoolId;
private String str_Remark;
private Date date_StartDate;
private Date date_EndDate;
private String str_Choise;
public String getStr_PoolAudience() {
	return str_PoolAudience;
}
public void setStr_PoolAudience(String str_PoolAudience) {
	this.str_PoolAudience = str_PoolAudience;
}
public String getStr_EndDate() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	str_EndDate=dateFormat.format(getDate_EndDate());
	System.out.println(str_EndDate+"nsddddddddddddddddddddddd");
	return str_EndDate;
}
public void setStr_EndDate(String str_EndDate) {
	this.str_EndDate = str_EndDate;
}
public String getStr_StartDate() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date d=new Date();
	str_StartDate=dateFormat.format(d);
	System.out.println(str_StartDate);
	
	return str_StartDate;
}
public void setStr_StartDate(String str_StartDate) {
	this.str_StartDate = str_StartDate;
}
public String getStr_Remark() {
	return str_Remark;
}
public void setStr_Remark(String str_Remark) {
	this.str_Remark = str_Remark;
}
 
 
public Long getLong_Vote() {
	return long_Vote;
}
public void setLong_Vote(Long long_Vote) {
	this.long_Vote = long_Vote;
}
public Integer getInt_PoolId() {
	return int_PoolId;
}
public void setInt_PoolId(Integer int_PoolId) {
	this.int_PoolId = int_PoolId;
}
public String getStr_Status() {
	str_Status="open";
	return str_Status;
}
public void setStr_Status(String str_Status) {
	this.str_Status = str_Status;
}
public String getStr_Choise1() {
	return str_Choise1;
}
public void setStr_Choise1(String str_Choise1) {
	this.str_Choise1 = str_Choise1;
}
public String getStr_Choise2() {
	return str_Choise2;
}
public void setStr_Choise2(String str_Choise2) {
	this.str_Choise2 = str_Choise2;
}
public String getStr_Choise3() {
	return str_Choise3;
}
public void setStr_Choise3(String str_Choise3) {
	this.str_Choise3 = str_Choise3;
}
public String getStr_PoolQuestion() {
	return str_PoolQuestion;
}
public void setStr_PoolQuestion(String str_PoolQuestion) {
	this.str_PoolQuestion = str_PoolQuestion;
}
public String deleteOnePoll1()
{
	getExpenseService().deleteOnePoll(onePoll);
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Poll deleted Successfully!", "Poll deleted Successfully!"));
	return "pools.xhtml";
	
}
 
public List<Pool> getPoolList() {
	poolList=new ArrayList<Pool>();
	poolList.addAll(getExpenseService().getPoolList());
	
	return poolList;
}
public void setPoolList(List<Pool> poolList) {
	this.poolList = poolList;
}
public Pool getPool() {
	return pool;
}
public void setPool(Pool pool) {
	this.pool = pool;
}
 
public void addPool()
{
	System.out.println("Poollllllllllllllllllllll");
	pool=new Pool();
	pool.setInt_OrganizationId(Util.getAppartmentId());
	pool.setStr_poolAudience(str_PoolAudience);
	pool.setInt_Vote(0l);
	pool.setInt_userId(Util.getUserId());
	pool.setStr_StartDate(getStr_StartDate());
	System.out.println(getStr_EndDate()+"seemaaaaaaaaaaa");
	pool.setStr_EndDate(getStr_EndDate());
    pool.setStr_Status(str_Status);
	pool.setStr_CreatedBy(Util.getUserName());
	pool.setStr_poolQuestion(str_PoolQuestion);
	pool.setStr_Choise1(str_Choise1);
	pool.setStr_Choise2(str_Choise2);
	pool.setStr_Choise3(str_Choise3);
	pool.setStr_Status(str_Status);
	 
	 
		getExpenseService().addPool(pool);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Poll Created Successfully!", "Poll Created Successfully!"));
}
public String getStr_Choise() {
	return str_Choise;
}
public void setStr_Choise(String str_Choise) {
	this.str_Choise = str_Choise;
}
public Date getDate_StartDate() {
	
	return date_StartDate;
}
public void setDate_StartDate(Date date_StartDate) {
	this.date_StartDate = date_StartDate;
}
public Date getDate_EndDate() {
	return date_EndDate;
}
public void setDate_EndDate(Date date_EndDate) {
	this.date_EndDate = date_EndDate;
}

private Vote vote;
 
private int number;
public Vote getVote() {
	return vote;
}
public void setVote(Vote vote) {
	this.vote = vote;
}


public int getNumber() {
    return number;
}

 
public int increment() {
    return number++;
}
private Boolean rendered;
private Boolean rendered1;
private String templateIndicator;
private Boolean isEnable;
public Boolean getIsEnable() {
	if(LoginBean.isAdmin())
	 
		isEnable=true;
	 
	else
		isEnable=false;
	return isEnable;
}
public void setIsEnable(Boolean isEnable) {
	this.isEnable = isEnable;
}
public String getTemplateIndicator() {
	if(LoginBean.isAdmin())
	 
		templateIndicator="template1.xhtml";
	 
	else
		templateIndicator="template.xhtml";
	return templateIndicator;
}
public void setTemplateIndicator(String templateIndicator) {
	this.templateIndicator = templateIndicator;
}

public Long getLatestChoise1Vote()
{
	  count1=getExpenseService().getChoise1Vote(latestPolls.getStr_Choise1(),latestPolls.getInt_PoolId());
	 System.out.println(latestPolls.getInt_PoolId());
	 System.out.println(count1+"kalpanaaaaaaaaaaaaaaaaaaaaaaaa");
	 System.out.println(latestPolls.getStr_Choise1());
	 System.out.println(int_PoolId+"pid");
	 
	 System.out.println(latestPolls.getInt_Vote()+"voteeeeeeeeeeeeeeeeeeee");
	 
	 Long res= count1*100/latestPolls.getInt_Vote();
	 System.out.println(res+"result");
	 return res;
	
}


public Long getChoise1Vote()
{ 
	  count1=getExpenseService().getChoise1Vote(onePoll.getStr_Choise1(),onePoll.getInt_PoolId());
	 System.out.println(onePoll.getInt_PoolId());
	 System.out.println(count1+"kalpanaaaaaaaaaaaaaaaaaaaaaaaa");
	 System.out.println(onePoll.getStr_Choise1());
	 System.out.println(int_PoolId+"pid");
	 
	 System.out.println(onePoll.getInt_Vote()+"voteeeeeeeeeeeeeeeeeeee");
	 
	 Long res= count1*100/onePoll.getInt_Vote();
	 System.out.println(res+"result");
	 return res;
	
}
public Long getCount1() {
	return count1;
}
public void setCount1(Long count1) {
	this.count1 = count1;
}
public Long getCount3() {
	return count3;
}
public void setCount3(Long count3) {
	this.count3 = count3;
}
private Long count2;
private Long count1;
private Long count3;

public Long getLatestChoise2Vote()
{
	System.out.println(latestPolls.getInt_PoolId());
	  count2=getExpenseService().getChoise2Vote(latestPolls.getStr_Choise2(),latestPolls.getInt_PoolId());
	 System.out.println(latestPolls.getStr_Choise2());
	 System.out.println(int_PoolId+"pid");
	 System.out.println(count2);
	 System.out.println(latestPolls.getInt_Vote()+"voteeeeeeeeeeeeeeeeeeee");
	 Long res= count2*100/latestPolls.getInt_Vote();
	 System.out.println(res+"result");
	 return res;
	
}
public Long getChoise2Vote()
{
	System.out.println(onePoll.getInt_PoolId());
	  count2=getExpenseService().getChoise2Vote(onePoll.getStr_Choise2(),onePoll.getInt_PoolId());
	 System.out.println(onePoll.getStr_Choise2());
	 System.out.println(int_PoolId+"pid");
	 System.out.println(count2);
	 System.out.println(onePoll.getInt_Vote()+"voteeeeeeeeeeeeeeeeeeee");
	 Long res= count2*100/onePoll.getInt_Vote();
	 System.out.println(res+"result");
	 return res;
	
}
public Long getCount2() {
	return count2;
}
public void setCount2(Long count2) {
	this.count2 = count2;
}
public Long getLatestChoise3Vote()
{System.out.println(latestPolls.getInt_PoolId());
	   count3=getExpenseService().getChoise3Vote(latestPolls.getStr_Choise3(),latestPolls.getInt_PoolId());
	  System.out.println(latestPolls.getStr_Choise3());
		 System.out.println(int_PoolId+"pid");
		 System.out.println(count3);
		 System.out.println(latestPolls.getInt_Vote()+"voteeeeeeeeeeeeeeeeeeee");
	  Long res= count3*100/latestPolls.getInt_Vote();
	  System.out.println(res+"result");
	  return res;
}
public Long getChoise3Vote()
{System.out.println(onePoll.getInt_PoolId());
	   count3=getExpenseService().getChoise3Vote(onePoll.getStr_Choise3(),onePoll.getInt_PoolId());
	  System.out.println(onePoll.getStr_Choise3());
		 System.out.println(int_PoolId+"pid");
		 System.out.println(count3);
		 System.out.println(onePoll.getInt_Vote()+"voteeeeeeeeeeeeeeeeeeee");
	  Long res= count3*100/onePoll.getInt_Vote();
	  System.out.println(res+"result");
	  return res;
}
private static Pool pool1;
private static Integer int_PoolId1;
private Number totalVote;
public Number getTotalVote() {
	return totalVote;
}
public void setTotalVote(Number totalVote) {
	this.totalVote = totalVote;
}
public static Integer getInt_PoolId1() {
	return int_PoolId1;
}
public static void setInt_PoolId1(Integer int_PoolId1) {
	ExpenseBean.int_PoolId1 = int_PoolId1;
}
public void processListener1()
{   /*pool1=new Pool();
	pool1=(Pool)dataTable1.getRowData();
	int_PoolId1=pool1.getInt_PoolId();
	 
	System.out.println(int_PoolId1);
	*/
}
public static Pool getPool1() {
	return pool1;
}
public static void setPool1(Pool pool1) {
	ExpenseBean.pool1 = pool1;
}
private String msg;
public Boolean getDisabled() {
	if(getIsVoted()==null)
	 
		disabled=false;
	else
		disabled=true;
	 
	return disabled;
}
public void setDisabled(Boolean disabled) {
	this.disabled = disabled;
}
private Boolean disabled;
private Integer  isVoted;
private List<Pool> selectedPolls;
private Pool onePoll;
public Pool getOnePoll() {
	return onePoll;
}
public void setOnePoll(Pool onePoll) {
	this.onePoll = onePoll;
}
public List<Pool> getSelectedPolls() {
	return selectedPolls;
}
public void setSelectedPolls(List<Pool> selectedPolls) {
	this.selectedPolls = selectedPolls;
}
public Integer getIsVoted() {
	getLatestPolls();
	if(onePoll!=null)
	{
 
		isVoted=getExpenseService().isVoted(Util.getUserId(),onePoll.getInt_PoolId());
		System.out.println(isVoted);
	}
    
	else
	{
		System.out.println(Util.getUserId());
 
		 
		 isVoted=getExpenseService().isVoted(Util.getUserId(),latestPolls.getInt_PoolId());
		 System.out.println(isVoted+"Vote");
	}
	return isVoted;
}
public void setIsVoted(Integer isVoted) {
	this.isVoted = isVoted;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String addVote()
{
	System.out.println("sumantaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	vote=new Vote();
	vote.setInt_OrganizationId(Util.getAppartmentId());
	vote.setInt_UserId(Util.getUserId());
	vote.setStr_Remark(str_Remark);
	vote.setStr_Choise(str_Choise);
	System.out.println(int_PoolId+"poolId");
//	System.out.println(pool.getInt_userId()+"userId");
	
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	 
	if(onePoll!=null)
	{
		vote.setInt_PoolId(onePoll.getInt_PoolId());
		isVoted=getExpenseService().isVoted(Util.getUserId(),onePoll.getInt_PoolId());
	}
    
	else
	{
		vote.setInt_PoolId(latestPolls.getInt_PoolId());
		 isVoted=getExpenseService().isVoted( Util.getUserId(),latestPolls.getInt_PoolId());
		 
    System.out.println(isVoted+"voteId");
	}
	if(isVoted!=null)
	{
		System.out.println(isVoted+"voteId1");
		
		
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"u have already voted Thank u for participating!", "u have already voted Thank u for participating!"));
		
		return null;
	}
	 
	getExpenseService().addVote(vote);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Vote Successfully!", "Vote Saved Successfully!"));
	System.out.println(int_PoolId);
	if(onePoll!=null)
	{
	 long_Vote= getExpenseService().getTotalVote(onePoll.getInt_PoolId());
	 onePoll.setInt_Vote(long_Vote);
	System.out.println( long_Vote);
	getExpenseService().UpdatePool(onePoll);
	}
	else
	{
	long_Vote= getExpenseService().getTotalVote(latestPolls.getInt_PoolId());
	latestPolls.setInt_Vote(long_Vote);
	System.out.println( long_Vote);
	getExpenseService().UpdatePool(latestPolls);
	}
 return null;
}
public void getOnePool()
{   pool=new Pool();
	System.out.println(int_PoolId1+"sudhiiiiiiiiiiiiiiiii");
	pool=getExpenseService().getOnePool(int_PoolId);
	
}
private Pool latestPolls;
private Boolean render;
public Boolean getRendered() {
	 
			 
	if(getIsVoted()==null)
		 
		rendered=true;
	else
		rendered=false;
	  
	return rendered;
}
public void setRendered(Boolean rendered) {
	this.rendered = rendered;
}
public Boolean getRendered1() {
	if(getIsVoted()==null)
		 
		rendered1=false;
	else
		rendered1=true;
	 
	 
	return rendered1;
}
public void setRendered1(Boolean rendered1) {
	 
	this.rendered1 = rendered1;
}
public Boolean getRender() {
	if(onePoll==null)
	{
		render=false;
	}
	else
		render=true;
	return render;
}
public void setRender(Boolean render) {
	this.render = render;
}
public Pool getLatestPolls() {
	latestPolls=new Pool();
	latestPolls=getExpenseService().getLatestPolls();
	if(getExpenseService().getLatestPolls()==null)
		   
		render=false;
	else
	{
		 render=true;
	latestPolls=getExpenseService().getLatestPolls();
	
	}
	 System.out.println(render+"renderd");
	return latestPolls;
}
public void setLatestPolls(Pool latestPolls) {
	this.latestPolls = latestPolls;
}
 




	 

	private  static ServiceRequest serviceRequest;
	private static Integer serviceRequestId; 
	  
	public static Integer getServiceRequestId() {
		return serviceRequestId;
	}
	 
	public static void setServiceRequestId(Integer serviceRequestId) {
		ExpenseBean.serviceRequestId = serviceRequestId;
	}
	 
	public static ServiceRequest getServiceRequest() {
		return serviceRequest;
	}
	public static void setServiceRequest(ServiceRequest serviceRequest) {
		ExpenseBean.serviceRequest = serviceRequest;
	}
	 
	public void assignRequestedService()
	{
	serviceRequest.setStr_Status("Progress");
	System.out.println(serviceRequestId+"sudhaaaaaa");
	serviceRequest.setInt_ServiceRequestId(serviceRequestId);

	getExpenseService().updateStatusOfServiceRequest(serviceRequest);
	}
	public void closeRequestedService()
	{
		
	serviceRequest.setStr_Status("RequestClosed");
	   
	getExpenseService().updateStatusOfServiceRequest(servicerequest1);
	}
	private ServiceRequest servicerequest1;
  public ServiceRequest getServicerequest1() {
		return servicerequest1;
	}
	public void setServicerequest1(ServiceRequest servicerequest1) {
		this.servicerequest1 = servicerequest1;
	}
public void getOneServiceRequest()
  {
	  servicerequest1=getExpenseService().getOneServiceRequest(serviceRequestId);
  }
public void updateOneServiceRequest()
{
	getExpenseService().updateOneServiceRequest(serviceRequest);
}
public void deleteOneServiceRequest()
{
	servicerequest1.setInt_ServiceRequestId(serviceRequestId);
	getExpenseService().deleteOneServiceRequest(servicerequest1);
}
public List<Expense> getSelectedExpenses() {
	return selectedExpenses;
}
public void setSelectedExpenses(List<Expense> selectedExpenses) {
	this.selectedExpenses = selectedExpenses;
}
public List<Assets> getSelectedAssets() {
	return selectedAssets;
}
public void setSelectedAssets(List<Assets> selectedAssets) {
	this.selectedAssets = selectedAssets;
}
public List<Parking> getParkingSpaceList1() {
	return parkingSpaceList1;
}
public void setParkingSpaceList1(List<Parking> parkingSpaceList1) {
	this.parkingSpaceList1 = parkingSpaceList1;
}
private String str_Path;
public String getStr_Name() {
	str_Name="../../";
	return str_Name;
}
public void setStr_Name(String str_Name) {
	this.str_Name = str_Name;
}
public String getStr_Path() {
	str_Path="././";
	return str_Path;
}
public void setStr_Path(String str_Path) {
	this.str_Path = str_Path;
}

 /*
  * Sms gate way
  */
 
 
private String str_MessageType="Event";
private String str_MessageTempType;
private String str_Subject;
private String str_Subject1;
private String str_Venue;
private String str_Venue1;
private String str_Date;
private Integer int_MessageTypeId;
public Integer getInt_MessageTypeId() {
	int_MessageTypeId=getExpenseService().getInt_MessageTypeId(getStr_MessageType());
	System.out.println(int_MessageTypeId);
	return int_MessageTypeId;
}
public void setInt_MessageTypeId(Integer int_MessageTypeId) {
	this.int_MessageTypeId = int_MessageTypeId;
}
private List<String> messageTempTypeList;
private List<MessageType> messageTypeList;
private AddTemplateMessage atm;
public void addTemplateMessage()
{
	atm=new AddTemplateMessage();
atm.setInt_MessageTypeId(int_MessageTypeId);
atm.setStr_MessageType(str_MessageType);
atm.setStr_Subject(str_Subject1);
atm.setStr_Description(str_Description);
atm.setStr_Venue(str_Venue1);
getExpenseService().addTemplateMessage(atm);
	
}

public String getStr_MessageType() {
	System.out.println(str_MessageType+"messagetype");
	return str_MessageType;
}
public void setStr_MessageType(String str_MessageType) {
	this.str_MessageType = str_MessageType;
}
public String getStr_MessageTempType() {
	return str_MessageTempType;
}
public void setStr_MessageTempType(String str_MessageTempType) {
	this.str_MessageTempType = str_MessageTempType;
}
public String getStr_Subject() {
	
	return str_Subject;
}

public void setStr_Subject(String str_Subject) {
	this.str_Subject = str_Subject;
}
 
public String getStr_Date() {
	return str_Date;
}
public void setStr_Date(String str_Date) {
	this.str_Date = str_Date;
}
 
 
public List<String> getMessageTempTypeList() {
	messageTempTypeList=new ArrayList<String>();
	messageTempTypeList.addAll(getExpenseService().getMessageTempTypeList());
	return messageTempTypeList;
}
 
public List<String> getMessageTypeList1() {
messageTypeList1=new ArrayList<String>();
	
	 
	ListIterator itr=getMessageTypeList().listIterator();
	while(itr.hasNext())
	{
		MessageType  messageType=(MessageType) itr.next();
		String m=messageType.getStr_MessageType();
		messageTypeList1.add(m);
		
	}
	return messageTypeList1;
}
public Boolean checkType(String type1) {
	System.out.println(type1+"type1");
    Boolean tmp =getStr_MessageType().equalsIgnoreCase(type1);
     
    return tmp;
}
 
public void setMessageTypeList1(List<String> messageTypeList1) {
	this.messageTypeList1 = messageTypeList1;
}
private List<String> messageTypeList1;
 
 
public List<MessageType> getMessageTypeList() {
	 
	messageTypeList=new ArrayList<MessageType>();
	messageTypeList.addAll(getExpenseService().getMessageTypeList());
	 
	return messageTypeList;
}
public void setMessageTypeList(List<MessageType> messageTypeList) {
	this.messageTypeList = messageTypeList;
}
private BroadCastMessage1  broadCastMessage;
public void addBroadCastMessage()
{
	broadCastMessage=new BroadCastMessage1();
	broadCastMessage.setStr_MessageTempType(str_MessageTempType);
	broadCastMessage.setStr_MessageType(str_MessageType);
	broadCastMessage.setStr_Subject(str_Subject);
	broadCastMessage.setStr_Date(str_Date);
	broadCastMessage.setStr_Description(str_Description);
	
	getExpenseService().addBroadCastMessage(broadCastMessage);
}
public String getStr_Venue() {
	return str_Venue;
}

 
public String getStr_Subject1() {
	str_Subject1=getExpenseService().getSubject(getStr_MessageType());
	return str_Subject1;
}
 
public String getStr_Venue1() {
	System.out.println(getInt_MessageTypeId()+"id");
	str_Venue1=getExpenseService().getStr_Venue(getInt_MessageTypeId());
	System.out.println(str_Venue1);
	return str_Venue1;
}
 
	
}


