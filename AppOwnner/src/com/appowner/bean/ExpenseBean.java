package com.appowner.bean;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.apache.commons.lang.RandomStringUtils;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ResizeEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.UploadedFile;

import com.appowner.model.AccountingGroup;
import com.appowner.model.AssetCategory;
import com.appowner.model.Assets;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.CommiteeMember;
import com.appowner.model.Expense;
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;
import com.appowner.service.ExpenseService;
import com.appowner.util.Util;
import com.ibm.icu.text.SimpleDateFormat;

@ManagedBean
@SessionScoped
public class ExpenseBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String str_AssetCategoryType;
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
	@ManagedProperty(value="#{ExpenseService}")
	private ExpenseService expenseService;
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
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Added Successfully!", "Updated Successfully!"));
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


public List<Expense> getExpenseList() {
	expenseList=new ArrayList<Expense>();
	expenseList.addAll(getExpenseService().getExpenseList());
	
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
public String updateOneExpense()
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
{System.out.println("HBNNNNNNNNNNNNNNNNNNNNNNNNNm");
	Parking p=new Parking();
	System.out.println(int_ParkingId+"kalpana");
	p.setInt_ParkingId(int_ParkingId);
	getExpenseService().deleteParkingSlot(p);
	return  "parkingspace.xhtml?faces-redirect=true";
}
public void onCellEdit(CellEditEvent event) {
    Object oldValue = event.getOldValue();
    Object newValue = event.getNewValue();
     
    if(newValue != null && !newValue.equals(oldValue)) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
 
public Parking getParking() {
	return parking;
}
public void setParking(Parking parking) {
	this.parking = parking;
}
private List<String> parkingSpaceList;
 
public List<String> getParkingSpaceList() {
	parkingSpaceList=new ArrayList<String>();
	parkingSpaceList.addAll(getExpenseService().getParkingSlotList());
 
	return parkingSpaceList;
}
public void setParkingSpaceList(List<String> parkingSpaceList) {
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
	 System.out.println("hi");
	 
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
	 System.out.println("hi");
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
    
    System.out.println(str_AppartmentImg);
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
    System.out.println(path1);
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
	getExpenseService().addAsset(asset);
	
}
public void saveAssetCategory()
{
	assetcategory=new AssetCategory();
	assetcategory.setStr_assetcat_name(str_AssetCategoryType);
	assetcategory.setStr_OrganizationName(str_OrganizationName);
	
	getExpenseService().saveAssetCategory(assetcategory);
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
	
	
}
}





