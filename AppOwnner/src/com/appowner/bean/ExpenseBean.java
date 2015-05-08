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
import java.util.TreeSet;

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
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.engine.RowSelection;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.appowner.model.AddTemplateMessage;
import com.appowner.model.AssetCategory;
import com.appowner.model.Assets;
import com.appowner.model.BroadCastMessage1;
import com.appowner.model.Expense;
import com.appowner.model.FacilityNeeded;
import com.appowner.model.MessageType;
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.Vendor;
import com.appowner.model.VendorServiceDetails;
import com.appowner.model.Vote;
import com.appowner.service.ExpenseService;
import com.appowner.service.VendorService;
import com.appowner.util.Util;
 

@ManagedBean
@SessionScoped
public class ExpenseBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{ExpenseService}")
	
	private ExpenseService expenseService;
	@ManagedProperty(value = "#{VendorService}")
	private VendorService vendorservice;
	 
	public VendorService getVendorservice() {
		return vendorservice;
	}
	public void setVendorservice(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	private String str_AssetCategoryType;
	private String str_Name ;
	public String getStr_AssetCategoryType() {
		return str_AssetCategoryType;
	}
	public void setStr_AssetCategoryType(String str_AssetCategoryType) {
		this.str_AssetCategoryType = str_AssetCategoryType;
	}
	public Parking getParking11() {
		return parking11;
	}
	public void setParking11(Parking parking11) {
		this.parking11 = parking11;
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
	private Date date_FromDate;
	private Date date_ToDate;
	
	
	public Date getDate_FromDate() {
		return date_FromDate;
	}
	public void setDate_FromDate(Date date_FromDate) {
		this.date_FromDate = date_FromDate;
	}
	public Date getDate_ToDate() {
		return date_ToDate;
	}
	public void setDate_ToDate(Date date_ToDate) {
		this.date_ToDate = date_ToDate;
	}
	private String str_AccountName;
	private List<String> str_OrganizationNameList;
	private List<String> str_AssetCatNameList;
	
	private String str_WelcomeMsg;
	private String str_ApptAddress;
	private String blb_image;
	private String Var_FileName;
	private String Var_ImageName;
	
	private String str_offcInTiming;
	private String str_offcInTiming1;
	private String str_offcOutTiming;
	private String str_offcOutTiming1;
	
	
	private String str_AdditionalInfo;
	private  String str_OrganizationLogo;
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
	@PostConstruct
    public void init() {
		str_PoolAudience="All Members";
		str_Rentable="Yes";
		 
		     }
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
	public String getStr_offcInTiming1() {
		return str_offcInTiming1;
	}
	public void setStr_offcInTiming1(String str_offcInTiming1) {
		this.str_offcInTiming1 = str_offcInTiming1;
	}
	public String getStr_offcOutTiming1() {
		return str_offcOutTiming1;
	}
	public void setStr_offcOutTiming1(String str_offcOutTiming1) {
		this.str_offcOutTiming1 = str_offcOutTiming1;
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
		str_AppartmentImg=getExpenseService().getAppartmentImg(Util.getAppartmentId());
		if(str_AppartmentImg==null)
		{
			str_AppartmentImg="/images/no_attach.png";
		}
		return str_AppartmentImg;
	}
	public void setStr_AppartmentImg(String str_AppartmentImg) {
		this.str_AppartmentImg = str_AppartmentImg;
	}
	public String getStr_Document_Upload() {
		str_Document_Upload=getExpenseService().getStr_Document_Upload(Util.getAppartmentId());
		 
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
	 
	public void getStr_AdditionalInfo1() {
		if(selectedAssets!=null)
		{
			ListIterator itr=selectedAssets.listIterator();
			while(itr.hasNext())
			{
				Assets a=(Assets) itr.next();
				 
		  str_AdditionalInfo=a.getStr_AdditionalInfo();
				 
				 
			}
		}
		 
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
	private Boolean renderlogo;
	 
	public String getStr_OrganizationLogo() {
		str_OrganizationLogo=getExpenseService().organizationLogo(Util.getAppartmentId());
		
		if(str_OrganizationLogo==null)
		{
			str_OrganizationLogo="/images/no_attach.png";
		}
		return str_OrganizationLogo;
	}
	public Boolean getRenderlogo() {
		if(getStr_OrganizationLogo()!=null)
		{
			renderlogo=true;
		}
		else
			renderlogo=false;
		return renderlogo;
	}
	public void setRenderlogo(Boolean renderlogo) {
		this.renderlogo = renderlogo;
	}
	public void setstr_OrganizationLogo(String str_OrganizationLogo) {
		this.str_OrganizationLogo = str_OrganizationLogo;
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
	private AssetCategory assetsCategory1=new AssetCategory();
	/*
	 * get  one Assetcategory by assetCatId
	 */
public void getAssetCategory1(Integer assetCatId)
{
	assetsCategory1=getExpenseService().getAssetCategory1(assetCatId);
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
	 if(str_ParkingSlot!=null)
	 {
	parking=new Parking();
	parking.setStr_OrganizationName(Util.getAppartmentName());
	parking.setStr_ParkingSlot(getStr_ParkingSlot());
	parking.setInt_AppartmentId(Util.getAppartmentId());
	getExpenseService().saveParking(parking);
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Parking Saved Successfully!"));
	 str_ParkingSlot="";
	 }
	 else{
    	 FacesMessage message = null;
     FacesContext.getCurrentInstance().addMessage(null, message);
     
     }
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
    	 
    } 
 
    getExpenseService().deleteParkingSpace(entitiesToDelete);
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Parking Deleted Successfully!"));
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

public  String  updateParkingSpace()
{
	if(parking11!=null)
	{
	System.out.println("updateeeeeeee");
	getExpenseService().updateParkingSpace(parking11);
	System.out.println("updat");
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Parking Updated Successfully!"));
	 return "parkingspace.xhtml";
	}
	 else{
    	 FacesMessage message = null;
     FacesContext.getCurrentInstance().addMessage(null, message);
     return "parkingspace.xhtml";
     }
	
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

private String path2;
public String getPath2() {
	return path2;
}
public void setPath2(String path2) {
	this.path2 = path2;
}
public String getBlb_image() {
	return blb_image;
}
public void setBlb_image(String blb_image) {
	this.blb_image = blb_image;
}
/*
 * Upload Appartment Logo
 */

/*
public void  handleFileUpload(FileUploadEvent event) throws IOException {
	 System.out.println("hi kalpana");
	 
	   path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	    str_OrganizationLogo = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
	    File file=new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images",Util.getAppartmentName());
	    if (!file.exists()) {
    	if (file.mkdir()) {
    		System.out.println("Directory is created!");
    	} else {
    		System.out.println("Failed to create directory!");
    	}
     }
	    file= new File(file,str_OrganizationLogo);
	    
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
*/
//file Upload

	
	private String statusMessage;
  
	public String uploadApartmentImage() throws IOException {

		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		str_AppartmentImg = fmt.format(new Date()) +getFileName(part).substring(getFileName(part).lastIndexOf('.'));
		// Extract file name from content-disposition header of file part
		//String fileName = getFileName(part);
		System.out.println("***** fileName: " +str_AppartmentImg);

		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
		System.out.println(basePath);
		File outputFilePath = new File(basePath);
		if (!outputFilePath.exists()) {
		   	if (outputFilePath.mkdir()) {
		   		System.out.println("Directory is created!");
		   	} else {
		   		System.out.println("Failed to create directory!");
		   	}
	 }
		 outputFilePath = new File(basePath,str_AppartmentImg);
		System.out.println(outputFilePath+"outputFilePath");
		// Copy uploaded file to destination path
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = part.getInputStream();
			outputStream = new FileOutputStream(outputFilePath);

			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			path1="/images"+ File.separator +Util.getAppartmentName()+File.separator+str_AppartmentImg;
			 System.out.println(path1+"path1");
			 addOrganizationLogo();
			 getExpenseService().updateAppartmentImg(path1);
			statusMessage = "File upload successfull !!";
			getStr_AppartmentImg();
		} catch (IOException e) {
			e.printStackTrace();
			statusMessage = "File upload failed !!";
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return null;    // return to same page
	}
	public String uploadOrganizationLogo() throws IOException {

		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		str_OrganizationLogo = fmt.format(new Date()) +getFileName(part1).substring(getFileName(part1).lastIndexOf('.'));
		// Extract file name from content-disposition header of file part
		//String fileName = getFileName(part);
		System.out.println("***** fileName: " +str_OrganizationLogo);

		//String basePath = "D:" + File.separator + "temp" + File.separator;
		//File outputFilePath = new File(basePath + fileName);
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
		File outputFilePath = new File(basePath);
		if (!outputFilePath.exists()) {
		   	if (outputFilePath.mkdir()) {
		   		System.out.println("Directory is created!");
		   	} else {
		   		System.out.println("Failed to create directory!");
		   	}
	 }
		System.out.println(outputFilePath+"outputFilePath2");
		outputFilePath = new File(basePath,str_OrganizationLogo);
		// Copy uploaded file to destination path
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = part1.getInputStream();
			outputStream = new FileOutputStream(outputFilePath);

			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			path="/images"+ File.separator +Util.getAppartmentName()+File.separator+str_OrganizationLogo;
			addOrganizationLogo();
			getExpenseService().updateOrganizationLogo(path);
			getStr_OrganizationName();
			 
			 System.out.println(path+"path");
			statusMessage = "File upload successfull !!";
			
		} catch (IOException e) {
			e.printStackTrace();
			statusMessage = "File upload failed !!";
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return null;    // return to same page
	}
	public String uploadDocument() throws IOException {

		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		str_Document_Upload = fmt.format(new Date()) +getFileName(part2).substring(getFileName(part2).lastIndexOf('.'));
		 
		System.out.println("***** fileName: " +str_Document_Upload);
 
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
		System.out.println(basePath);
		File outputFilePath = new File(basePath);
		//create directory dynamicaly
		if (!outputFilePath.exists()) {
		   	if (outputFilePath.mkdir()) {
		   		System.out.println("Directory is created!");
		   	} else {
		   		System.out.println("Failed to create directory!");
		   	}
	 }
		outputFilePath = new File(basePath,str_Document_Upload);
		// Copy uploaded file to destination path
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = part2.getInputStream();
			outputStream = new FileOutputStream(outputFilePath);

			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			path2=str_Document_Upload;
			getExpenseService().updateOrganizationDocument(path2);
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("RWA Information Updated successfully!"));
			 System.out.println(path2);
			statusMessage = "File upload successfull !!";
			
		} catch (IOException e) {
			e.printStackTrace();
			statusMessage = "File upload failed !!";
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return null;    // return to same page
	}
	private Part part;
	private Part part1;
	private Part part2;
	public Part getPart3() {
		return part3;
	}
	public void setPart3(Part part3) {
		this.part3 = part3;
	}
	private Part part3;
	public Part getPart1() {
		return part1;
	}
	public void setPart1(Part part1) {
		this.part1 = part1;
	}
	public Part getPart2() {
		return part2;
	}
	public void setPart2(Part part2) {
		this.part2 = part2;
	}
	
	public Part getPart() throws IOException {
		 
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	// Extract file name from content-disposition header of file part
	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("***** partHeader: " + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

	 

	 public  void  getOrganizationDetails()
	 {
		 OrganizationLogo organizationLogo=new OrganizationLogo();
			 
		 organizationLogo=getExpenseService().getOrganizationDetails();
		 if(organizationLogo!=null)
		 {
		 textLogo=organizationLogo.getStr_TextLogo();
		// str_WelcomeMsg=organizationLogo.getStr_WelcomeMsg();
		 str_Day=organizationLogo.getStr_Day();
		 str_ApptAddress=organizationLogo.getStr_ApptAddress();
		 str_offcOutTiming=organizationLogo.getStr_OutTime();
		 str_offcInTiming=organizationLogo.getStr_InTime();
	 }
		 
	 }
 
public String addOrganizationLogo ()
{
	ol=new OrganizationLogo();
	Integer logoid=getExpenseService().getLogoId(Util.getAppartmentId());
	
	
	 if(logoid!=null)
	{ 
		 ol.setInt_OthersInfoId(logoid);
		 ol.setStr_Appartment_Logo(getStr_OrganizationLogo());
			ol.setStr_InTime(getStr_offcInTiming());
			ol.setStr_OutTime(getStr_offcOutTiming());
			ol.setStr_TextLogo(getTextLogo());
			ol.setStr_ApptAddress(getStr_ApptAddress());
		//	ol.setStr_WelcomeMsg(getStr_WelcomeMsg());
			System.out.println(Util.getAppartmentId());
			ol.setInt_AppartmentId(Util.getAppartmentId());
			 
			//ol.setStr_Document_Upload(getStr_Document_Upload());
			ol.setStr_Appartment_Img(getStr_AppartmentImg());
			ol.setStr_Day(str_Day);
			ol.setStr_Appartment_Img(getStr_AppartmentImg());
			ol.setStr_InTime1(getStr_offcInTiming1());
			ol.setStr_OutTime1(getStr_offcOutTiming1());
			getExpenseService().updateLogo(ol);
			 getTextLogo();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("RWA Information updated successfully"));
	 
	}
	else
	{
	ol.setStr_Appartment_Logo(getStr_OrganizationLogo());
	ol.setStr_InTime(getStr_offcInTiming());
	ol.setStr_OutTime(getStr_offcOutTiming());
	ol.setStr_InTime1(getStr_offcInTiming1());
	ol.setStr_OutTime1(getStr_offcOutTiming1());
	ol.setStr_TextLogo(getTextLogo());
	ol.setStr_ApptAddress(getStr_ApptAddress());
	//ol.setStr_WelcomeMsg(getStr_WelcomeMsg());
	System.out.println(Util.getAppartmentId());
	ol.setInt_AppartmentId(Util.getAppartmentId());
	//ol.setStr_Document_Upload(getStr_Document_Upload());
	ol.setStr_Appartment_Img(getStr_AppartmentImg());
     
	getExpenseService().addOrganizationLogo(ol);
	getTextLogo();
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("RWA Information Added successfully"));
	}
	  
	return null;
	 
	 
}
 
 

public   void getOrganizationLogo()
{ ol=new OrganizationLogo();
  ol=getExpenseService().getOrganizationLogo(Util.getAppartmentId());
  System.out.println(ol+""+"hgxdddddddddddddddd");
  ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
  File file=new File(basePath);
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
private String str_TextLogo1;
public String getStr_TextLogo1() {
	//textLogo=getExpenseService().getTextLogo(Util.getAppartmentId());
	return textLogo;
}
public void setStr_TextLogo1(String str_TextLogo1) {
	this.str_TextLogo1 = str_TextLogo1;
}
public String getTextLogo() {
	
	return textLogo;
}
public void setTextLogo(String textLogo) {
	this.textLogo = textLogo;
}
 
 
public String getPath() {
	 
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
private String str_Rentable;
private AssetCategory assetcategory;
private List<AssetCategory> assetCategoryList;
private List<AssetCategory> assetCategoryList1;
public String updateAssetCategory()
{
	 
	if(assetsCategory1!= null) {
	getExpenseService().updateAssetCategory(assetsCategory1);
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Assetcategory Updated Successfully!"));
	 return "assetcategory.xhtml";
	}
	 else{
    	 FacesMessage message = null;
     FacesContext.getCurrentInstance().addMessage(null, message);
     return "assetcategory.xhtml";
     
     }
	
}
public AssetCategory getAssetsCategory1() {
	return assetsCategory1;
}
public void setAssetsCategory1(AssetCategory assetsCategory1) {
	this.assetsCategory1 = assetsCategory1;
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
 
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Assetcategory Deleted Successfully!"));
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
 
 
public String getStr_Rentable() {
	return str_Rentable;
}
public void setStr_Rentable(String str_Rentable) {
	this.str_Rentable = str_Rentable;
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
private List<String>  str_VendorTypeList;
private List<String>  str_VendorTypeList1;
public List<String> getStr_VendorTypeList1() {
	str_VendorTypeList1=new ArrayList<String>();
	str_VendorTypeList1.addAll(getVendorservice().getStr_VendorTypeList());
	System.out.println(str_VendorTypeList1);
	return str_VendorTypeList1;
}
public void setStr_VendorTypeList1(List<String> str_VendorTypeList1) {
	this.str_VendorTypeList1 = str_VendorTypeList1;
}
public void setStr_VendorTypeList(List<String> str_VendorTypeList) {
	this.str_VendorTypeList = str_VendorTypeList;
}
public List<String> getStr_VendorTypeList() {
	str_VendorTypeList=new ArrayList<String>();
	str_VendorTypeList.addAll(getVendorservice().getStr_VendorTypeList());
	System.out.println(str_VendorTypeList);
	return str_VendorTypeList;
}
private  List<String> str_VendorNameByType;
private  List<String> str_VendorNameByType1;
private String str_VendorType1;
private String str_VendorName1;
public String getStr_VendorName1() {
	return str_VendorName1;
}
public void setStr_VendorName1(String str_VendorName1) {
	this.str_VendorName1 = str_VendorName1;
}
public String getStr_VendorType1() {
	return str_VendorType1;
}
public void setStr_VendorType1(String str_VendorType1) {
	this.str_VendorType1 = str_VendorType1;
}
public List<String> vendorTypeChangeListener(ValueChangeEvent event)
{   
	str_VendorType=(String) event.getNewValue();
	if(str_VendorType!=null)
	{
	System.out.println(str_VendorType);
	str_VendorNameByType=new ArrayList<String>();
	str_VendorNameByType.addAll(getVendorservice().listOfVendorNameByType(str_VendorType));
	System.out.println(str_VendorNameByType);
	return str_VendorNameByType ;
	}
	else
		return str_VendorNameByType=new ArrayList<String>();
	
}
public List<String> vendorTypeChangeListener1(ValueChangeEvent event)
{   
	str_VendorType1=(String) event.getNewValue();
	if(str_VendorType1!=null)
	{
	System.out.println(str_VendorType1);
	str_VendorNameByType1=new ArrayList<String>();
	str_VendorNameByType1.addAll(getVendorservice().listOfVendorNameByType(str_VendorType1));
	System.out.println(str_VendorNameByType1);
	return str_VendorNameByType1 ;
	}
	else
		return str_VendorNameByType1=new ArrayList<String>();
	
}

public List<String> getStr_VendorNameByType1() {
	return str_VendorNameByType1;
}
public void setStr_VendorNameByType1(List<String> str_VendorNameByType1) {
	this.str_VendorNameByType1 = str_VendorNameByType1;
}
public void setStr_VendorNameByType(List<String> str_VendorNameByType) {
	this.str_VendorNameByType = str_VendorNameByType;
}
public List<String> getStr_VendorNameByType() {
	 
		 
		return str_VendorNameByType;
	 
	 
}
public String updateOneAsset()
{ 
	getExpenseService().updateOneasset(a);
	 
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Flash flash = facesContext.getExternalContext().getFlash();
	flash.setKeepMessages(true);
	flash.setRedirect(true);
	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Asset Updated Successfully!", "Asset Updated Successfully!"));
	selectedAssets=null;
	str_AdditionalInfo=null;
	str_AssetCategoryType=null;
	str_Block=null;
	str_Rentable="Yes";
	return "assets.xhtml";
}
/*
 * get asset,purchase,amc list
 */
private String query1;
public String getQuery1() {
	return query1;
}
public void setQuery1(String query1) {
	this.query1 = query1;
}
public List<Assets> getAssetList() {
	try{
	assetList= new ArrayList<Assets>();
	if(str_AssetCategoryType==null && str_Block==null )
	{   
		query1="";
	}
	 if(!(str_AssetCategoryType==null) && !(str_AssetCategoryType.isEmpty()))
		{
			query1=query1+"str_assetcat_name="+"'"+str_AssetCategoryType+"'";
		}
	 if(!(str_Block==null) && !(str_Block.isEmpty()))
		{
			query1=query1+" and "+"str_Block="+"'"+str_Block+"'";
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

 assetList.addAll(getExpenseService().getAssetList(query1));

	 
	query1="";
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

public String addAsset()
{
	asset =new Assets();
	asset.setStr_assetcat_name(str_AssetCategoryType);
	asset.setStr_AssetImg(assetimg);
	asset.setStr_AssetName(str_AssetName);
	asset.setStr_Block(str_Block);
	asset.setStr_OrganizationName(str_OrganizationName);
	asset.setStr_Rentable(getStr_Rentable());
	asset.setDate_AMCStartDate(date_AMCStartDate);
	asset.setDate_AMCEndDate(date_AMCEndDate);
	asset.setDate_PurchaseDate(date_PurchaseDate);
	asset.setDate_WarrantyEndDate(date_WarrantyEndDate);
	asset.setDate_WarrantyStartDate(date_WarrantyStartDate);
	asset.setDbl_Price(dbl_Price);
	asset.setStr_PurchaseImg(str_PurchaseImg);
	 
	 
	asset.setStr_VendorName(str_VendorName);
	asset.setStr_VendorName1(str_VendorName1);
	asset.setStr_VendorType(str_VendorType);
	asset.setStr_VendorType1(str_VendorType1);
 asset.setStr_AdditionalInfo(str_AdditionalInfo);
	asset.setInt_AppartmentId(Util.getAppartmentId());
	getExpenseService().addAsset(asset);
	
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Saved Successfully!"));
	str_VendorType=null;
	str_VendorType1=null;
	str_AdditionalInfo=null;
	str_Block=null;
	
	str_Rentable="Yes";
	str_VendorName=null;
	str_SellerNameAnddetails=null;
	dbl_Price=0.0;
	 
	str_AssetName=null;
	 
	assetimg=null;
	str_AssetCategoryType=null;
	date_AMCEndDate=null;
	date_AMCStartDate=null;
	date_WarrantyEndDate=null;
	date_WarrantyStartDate=null;
	selectedAssets=null;
	 return "assets.xhtml";
}
/*
 * Asset Image
 */


public void  uploadAssetsFile( ) throws IOException   {
	 
	   
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	    str_AssetImg = fmt.format(new Date()) +getFileName(part3).substring(getFileName(part3).lastIndexOf('.'));
	    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
	    File outputFilePath=new File(basePath);
	    if (!outputFilePath.exists()) {
		   	if (outputFilePath.mkdir()) {
		   		System.out.println("Directory is created!");
		   	} else {
		   		System.out.println("Failed to create directory!");
		   	}
	 }
	    outputFilePath = new File(basePath,str_AssetImg);
	 // Copy uploaded file to destination path
	 		InputStream inputStream = null;
	 		OutputStream outputStream = null;
	 		try {
	 			inputStream = part3.getInputStream();
	 			outputStream = new FileOutputStream(outputFilePath);

	 			int read = 0;
	 			final byte[] bytes = new byte[1024];
	 			while ((read = inputStream.read(bytes)) != -1) {
	 				outputStream.write(bytes, 0, read);
	 			}
	 			assetimg="/images"+ File.separator +Util.getAppartmentName()+File.separator+str_AssetImg;
	 			 System.out.println(path4);
	 			statusMessage = "File upload successfull !!";
	 			
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 			statusMessage = "File upload failed !!";
	 		} finally {
	 			if (outputStream != null) {
	 				outputStream.close();
	 			}
	 			if (inputStream != null) {
	 				inputStream.close();
	 			}
	 		}
	 		 part3=null;
}
public void  uploadAssetsFile1( ) throws IOException   {
	 
	   
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
    str_AssetImg = fmt.format(new Date()) +getFileName(part3).substring(getFileName(part3).lastIndexOf('.'));
    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
    File outputFilePath=new File(basePath);
    if (!outputFilePath.exists()) {
	   	if (outputFilePath.mkdir()) {
	   		System.out.println("Directory is created!");
	   	} else {
	   		System.out.println("Failed to create directory!");
	   	}
 }
    outputFilePath = new File(basePath,str_AssetImg);
 // Copy uploaded file to destination path
 		InputStream inputStream = null;
 		OutputStream outputStream = null;
 		try {
 			inputStream = part3.getInputStream();
 			outputStream = new FileOutputStream(outputFilePath);

 			int read = 0;
 			final byte[] bytes = new byte[1024];
 			while ((read = inputStream.read(bytes)) != -1) {
 				outputStream.write(bytes, 0, read);
 			}
 			path3="/images"+ File.separator +Util.getAppartmentName()+File.separator+str_AssetImg;
 		 
 			getExpenseService().updateAssetImage(path3,a.getInt_asset_id());
 			 System.out.println(path3);
 			statusMessage = "File upload successfull !!";
 			
 		 
 			
 		} catch (IOException e) {
 			e.printStackTrace();
 			statusMessage = "File upload failed !!";
 		} finally {
 			if (outputStream != null) {
 				outputStream.close();
 			}
 			if (inputStream != null) {
 				inputStream.close();
 			}
 		}
 		 
}
/*
public void  handleFileUpload4(FileUploadEvent event) throws IOException {
	System.out.println("seemooooooooooooooooooo");
	 
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
	    
	    
	    
}*/
private String path4;
private String assetimg;

public String getAssetimg() {
	if(assetimg==null)
	{
		assetimg="/images/no_attach.png";
	}
	return assetimg;
}
public void setAssetimg(String assetimg) {
	this.assetimg = assetimg;
}
public String getPath3() {
	 
	 if(selectedAssets!=null)
	{
		ListIterator itr=selectedAssets.listIterator();
		while(itr.hasNext())
		{
			Assets asset=(Assets) itr.next();
			if(asset.getInt_asset_id()!=null)
			{
			path3= getExpenseService().getAssetImg(asset.getInt_asset_id());
			System.out.println(path3+"imagesssssssssssssssss");
			}
		}
		
	}
	return path3; 
}
	 public String getPath4() {
		 path4=null;
		 path4= getExpenseService().getAssetImg(a.getInt_asset_id());
		 if(path4==null)
			{
				path4="/images/no_attach.png";
			}
			 
				return path4;
			} 
	

public void setPath3(String path3) {
	this.path3 = path3;
}
public String saveAssetCategory()
{  
     if(str_AssetCategoryType!= null) {
	assetcategory=new AssetCategory();
	assetcategory.setStr_assetcat_name(str_AssetCategoryType);
	assetcategory.setStr_OrganizationName(str_OrganizationName);
	assetcategory.setInt_AppartmentId(Util.getAppartmentId());
	getExpenseService().saveAssetCategory(assetcategory);
	  
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Saved Successfully!"));
	  
	 str_AssetCategoryType="";
 
     }
     else{
    	 FacesMessage message = null;
     FacesContext.getCurrentInstance().addMessage(null, message);
     
     }
	return"assetcategory.xhtml";
}

private List<String> list;

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
private FacilityNeeded facilityNeeded1=new FacilityNeeded() ;
public void getFacility1(Integer fid)
{
	facilityNeeded1=getExpenseService().getOneFacilityNeeded(fid);
}
public List<FacilityNeeded> getFacilityNeededList() {
	
	facilityNeededList=new ArrayList<FacilityNeeded>();
	facilityNeededList.addAll((getExpenseService().getFacilityNeededList()));
	return facilityNeededList;
}
public FacilityNeeded getFacilityNeeded1() {
	return facilityNeeded1;
}
public void setFacilityNeeded1(FacilityNeeded facilityNeeded1) {
	this.facilityNeeded1 = facilityNeeded1;
}
public void setFacilityNeededList(List<FacilityNeeded> facilityNeededList) {
	this.facilityNeededList = facilityNeededList;
}
public String updateFacility()
{ 
	if(facilityNeeded1!=null)
	{
	getExpenseService().updateFacility(facilityNeeded1);
	
	facilityNeeded1=null;
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Facility Updated Successfully!"));
return null;
}
else{
	 FacesMessage message = null;
FacesContext.getCurrentInstance().addMessage(null, message);
return null;

}
 

}
public FacilityNeeded getFacilityNeeded() {
	return facilityNeeded;
}
public void setFacilityNeeded(FacilityNeeded facilityNeeded) {
	this.facilityNeeded = facilityNeeded;
}
public String addFacility()
{
	if(str_FacilityName!=null)
	{
	facilityNeeded=new FacilityNeeded();
	facilityNeeded.setStr_FacilityName(str_FacilityName);
	facilityNeeded.setInt_ApartmentId(Util.getAppartmentId());
	getExpenseService().addFacility(facilityNeeded);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Facility Added Successfully!"));
	str_FacilityName=null;
	return null;
	}
	 else{
    	 FacesMessage message = null;
     FacesContext.getCurrentInstance().addMessage(null, message);
     return null;
     }
	
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
 
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Facility Deleted Successfully!"));
return null;
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
 

private Date dat_StartDate;
public Date getDat_StartDate() {
	return dat_StartDate;
}
public void setDat_StartDate(Date dat_StartDate) {
	this.dat_StartDate = dat_StartDate;
}
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
private Pool p=new Pool();
public String getpoll1(Integer pid)
{
	p=getExpenseService().getOnePool(pid);
	return "editpoll.xhtml";
}
public String getpoll2(Integer pid)
{
	p=getExpenseService().getOnePool(pid);
	return "viewpoll.xhtml";
}
public Pool getP() {
	return p;
}
public void setP(Pool p) {
	this.p = p;
}
public String deleteOnePoll1()
{
	
	  
		   if(indicate==false)
		   {   System.out.println("jcvkvcjvj11111111111111111111111111111111111111111111111111");
		   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select a poll to delete!"));
				return null;
		   }
		   else
		   {  indicate=false;
			   System.out.println(onePoll+"onePolllllllllll");
				getExpenseService().deleteOnePoll(onePoll);
				onePoll=null;
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Pool Deleted Successfully!"));
				return null;
		   }
	
	
}
public String sendBulkEmailOfPoll()
{
	 subject=Util.getAppartmentName()+"-A New Poll";
	  content=PollMsgs;
	return "/AfrteLoginViews/Communication/poll.jsp";
}
 private Set<String> emailIds;
public Set<String> getEmailIds() {
	emailIds=new TreeSet<String>();
	if(onePoll!=null){
	String  recipients=onePoll.getStr_poolAudience();
	emailIds.addAll(getExpenseService().getEmailIds(Util.getAppartmentId(),recipients));
	
	mailids=emailIds;
	}
	return emailIds;
}
private static Set<String> mailids;

private String PollMsgs;



public String getPollMsgs() {
	if(onePoll!=null){
	PollMsgs="A new poll"+"'"+onePoll.getStr_poolQuestion()+"'"+ "has been created.";
	System.out.println(PollMsgs+"pollmsgggggggggggggggggggggg");
	}
	return PollMsgs;
}
public void setPollMsgs(String pollMsgs) {
	PollMsgs = pollMsgs;
}
public static String getMailids() {
	
	
StringBuilder out = new StringBuilder();
for (Object o : mailids)
{
  out.append(o.toString());
  out.append(",");
}
return out.toString();
	
	
	
}
 
public void setEmailIds(Set<String> emailIds) {
	this.emailIds = emailIds;
}
public static void setMailids(Set<String> mailids) {
	ExpenseBean.mailids = mailids;
}
private static String subject="subject";
private static String content="content";
	
public static String getSubject() {
	return subject;
}
public static void setSubject(String subject) {
	ExpenseBean.subject = subject;
}
public static String getContent() {
	return content;
}
public static void setContent(String content) {
	ExpenseBean.content = content;
}
private String query="";
public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public void datechangeListener1(ValueChangeEvent event)
{    System.out.println("priyyyyyyssssssssss");
date_ToDate=null;
date_ToDate=(Date)event.getNewValue();
System.out.println(date_ToDate+"jjjjjjjjjjjjjjjjjjjjjjjjjjjlokiiiiiiiiiiiiiiiii");

}
public void datechangeListener(ValueChangeEvent event)
{    System.out.println("priyyyyyyssssssssss");
date_FromDate=null;
date_FromDate=(Date)event.getNewValue();
System.out.println(date_FromDate+"jjjjjjjjjjjjjjjjjjjjjjjjjjjlokiiiiiiiiiiiiiiiii");

}
public List<Pool> getPoolList() {
	
	/*poolList=new ArrayList<Pool>();
	 System.out.println(getDate_FromDate()+""+getDate_ToDate()+""+getStr_Status()+"pollllllistssssssssssss");
	
	poolList.addAll(getExpenseService().getPoolList(getDate_FromDate(),getDate_ToDate(),getStr_Status()));
	date_FromDate=null;
	date_ToDate=null;
    str_Status=null;*/
	 
	poolList=new ArrayList<Pool>();
	 System.out.println(getDate_FromDate()+""+getDate_ToDate()+""+getStr_Status()+"pollllllistssssssssssss");
	
	poolList .addAll(getExpenseService().getPoolList(getDate_FromDate(),getDate_ToDate(),getStr_Status()));
	System.out.println(poolList+"pppppplist");
	return poolList;
}  
 
public String closeRequestedPoll()
{
	 if(onePoll!=null)
	 {
	String status=getExpenseService().checkStatusOfPoll(onePoll.getInt_PoolId());
	if(status.equalsIgnoreCase("Closed"))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Poll Already Closed"));
		return "servicerequest.xhtml";
	}
	
	str_Status="Closed";
	 
	getExpenseService().updateStatusOfPoll(onePoll.getInt_PoolId(),str_Status);
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Poll Closed Successfully"));
str_Status=null;
	 }
    return "pools.xhtml";
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
 public String updateOnePoll()
 {
	  
			getExpenseService().UpdatePool(p);
			p=null;
			str_PoolQuestion="";
			str_Choise1="";
			str_Choise2="";
			str_Choise3="";
			str_EndDate="";
			str_PoolAudience="All Members";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Pool Updated Successfully!"));
			
			return"pools.xhtml";
		}
		 
 
public String addPool()
{
	
	pool=new Pool();
	pool.setInt_OrganizationId(Util.getAppartmentId());
	pool.setStr_poolAudience(str_PoolAudience);
	pool.setInt_Vote(0l);
	pool.setInt_userId(Util.getUserId());
	pool.setDat_StartDate(new Date());
	 
	pool.setDate_EndDate(getDate_EndDate());
    pool.setStr_Status("Open");
	pool.setStr_CreatedBy(Util.getUserName());
	pool.setStr_poolQuestion(str_PoolQuestion);
	pool.setStr_Choise1(str_Choise1);
	pool.setStr_Choise2(str_Choise2);
	pool.setStr_Choise3(str_Choise3);
	 
		getExpenseService().addPool(pool);
		
		str_PoolQuestion=null;
		str_Choise1=null;
		str_Choise2=null;
		str_Choise3=null;
		str_EndDate=null;
		str_PoolAudience="All Members";
		onePoll=null;
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Pool Created Successfully!"));
		return"pools.xhtml";
	 
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
	latestCount1=null;
	latestCount1=getExpenseService().getChoise1Vote(latestPolls.getStr_Choise1(),latestPolls.getInt_PoolId());
	  Long res=0l;
	 
		 if(latestPolls.getInt_Vote()!=0)
		 {
		 
	  res= latestCount1*100/latestPolls.getInt_Vote();
		 }
	 
	 return res;
	 }
	 
	
 


public Long getChoise1Vote()
{ count1=null;
	  count1=getExpenseService().getChoise1Vote(onePoll.getStr_Choise1(),onePoll.getInt_PoolId());
	 
	 Long res= count1*100/onePoll.getInt_Vote();
	 System.out.println(res+"result");
	 return res;
	
}
private Long latestCount1;
private Long latestCount2;
private Long latestCount3;
public Long getLatestCount1()
{
	latestCount1=null;
	  return latestCount1=getExpenseService().getChoise1Vote(latestPolls.getStr_Choise1(),latestPolls.getInt_PoolId());
}
public Long getLatestCount2()
{
	latestCount2=null;
	  return latestCount2=getExpenseService().getChoise1Vote(latestPolls.getStr_Choise2(),latestPolls.getInt_PoolId());
}
public void setLatestCount1(Long latestCount1) {
	this.latestCount1 = latestCount1;
}
public void setLatestCount2(Long latestCount2) {
	this.latestCount2 = latestCount2;
}
public void setLatestCount3(Long latestCount3) {
	this.latestCount3 = latestCount3;
}
public Long getLatestCount3()
{
	latestCount3=null;
	  return latestCount3=getExpenseService().getChoise1Vote(latestPolls.getStr_Choise3(),latestPolls.getInt_PoolId());
}

public Long getCount1() {
	if(onePoll!=null)
	{
	count1=null;
	System.out.println(onePoll.getStr_Choise1()+"checkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"+onePoll.getInt_PoolId());
	  count1=getExpenseService().getChoise1Vote(onePoll.getStr_Choise1(),onePoll.getInt_PoolId());
	 System.out.println(count1+"count1111111111111111111111111111111111111");
	}
	 
	return count1;
}
public void setCount1(Long count1) {
	this.count1 = count1;
}
public Long getCount2() {
	if(onePoll!=null)
	{
	 
	System.out.println(onePoll.getStr_Choise2()+"checkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"+onePoll.getInt_PoolId());
	count2=null;
	 
	  count2=getExpenseService().getChoise2Vote(onePoll.getStr_Choise2(),onePoll.getInt_PoolId());
	 System.out.println(count2+"count222222222222222222222222222");
	}
	 
	return count2;
}
public void setCount2(Long count2) {
	this.count2 = count2;
}
public Long getCount3() {
	if(onePoll!=null)
	{
		count3=null;
		   count3=getExpenseService().getChoise3Vote(onePoll.getStr_Choise3(),onePoll.getInt_PoolId());
		   System.out.println(count3+"count3333333333333333333333333333333333");
	}
	 
	 
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
	latestCount2=null;
	 
	latestCount2=getExpenseService().getChoise2Vote(latestPolls.getStr_Choise2(),latestPolls.getInt_PoolId());
	  
	  Long res=0l;
		 
		 if(latestPolls.getInt_Vote()!=0)
		 {
		 
	   res= latestCount2*100/latestPolls.getInt_Vote();
		 }
	  
	 return res;
	
}
public Long getChoise2Vote()
{
	count2=null;
	 
	  count2=getExpenseService().getChoise2Vote(onePoll.getStr_Choise2(),onePoll.getInt_PoolId());
	  
	 Long res= count2*100/onePoll.getInt_Vote();
	 System.out.println(res+"result");
	 return res;
	
}
private List<String> ListChoice;
public List<String> getListChoice() {
	ListChoice=new ArrayList<String>();
	ListChoice.addAll(getExpenseService().getListChoice(onePoll.getInt_PoolId()));
	return ListChoice;
}
public void setListChoice(List<String> listChoice) {
	ListChoice = listChoice;
}
public Long getLatestChoise3Vote()
{ 
	latestCount3=null;
	latestCount3=getExpenseService().getChoise3Vote(latestPolls.getStr_Choise3(),latestPolls.getInt_PoolId());
	   Long res=0l;
		 
		 if(latestPolls.getInt_Vote()!=0)
		 {
		 
	   res= latestCount3*100/latestPolls.getInt_Vote();
		 }
	   
	  return res;
}
public Long getChoise3Vote()
{ 
count3=null;
	   count3=getExpenseService().getChoise3Vote(onePoll.getStr_Choise3(),onePoll.getInt_PoolId());
	   
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
private Boolean disabled1;
public Boolean getDisabled1() {
	if(getIsVoted()==null)
		 
		disabled1=true;
	else
		disabled1=false;
	 
	return disabled1;
}
public void setDisabled1(Boolean disabled1) {
	this.disabled1 = disabled1;
}
public void desabled1Listener( SelectEvent event)
{ 
	if(getIsVoted()==null)
	{
		disabled=false;	 
		disabled1=true;
	}
	else
	{
		disabled1=false;
		disabled=true;
	}
	indicate=true;
}
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
private Integer isVoted1;
public void setIsVoted1(Integer isVoted1) {
	this.isVoted1 = isVoted1;
}
public Integer getIsVoted1() {
	getLatestPolls();
	 if(latestPolls!=null){
		 
		 isVoted1=getExpenseService().isVoted(Util.getUserId(),latestPolls.getInt_PoolId());
		 System.out.println(isVoted1+"Vote");
	 }
	 
	return isVoted1;
}
public Integer getIsVoted() {
	 
	if(onePoll!=null)
	{
 
		isVoted=getExpenseService().isVoted(Util.getUserId(),onePoll.getInt_PoolId());
		System.out.println(isVoted);
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
	 
	vote=new Vote();
	vote.setInt_OrganizationId(Util.getAppartmentId());
	vote.setInt_UserId(Util.getUserId());
	vote.setStr_Remark(str_Remark);
	vote.setStr_Choise(str_Choise);
	 
		vote.setInt_PoolId(onePoll.getInt_PoolId());
		isVoted=getExpenseService().isVoted(Util.getUserId(),onePoll.getInt_PoolId());
	 
		 
	 
	getExpenseService().addVote(vote);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Your Vote has been registered Successfully. Thank you participating!"));
	 
	 long_Vote= getExpenseService().getTotalVote(onePoll.getInt_PoolId());
	 onePoll.setInt_Vote(long_Vote);
	System.out.println( long_Vote);
	getExpenseService().UpdatePool(onePoll);
	onePoll=null;
  return "pools.xhtml";
}
public String addVote1()
{
	 
	vote=new Vote();
	vote.setInt_OrganizationId(Util.getAppartmentId());
	vote.setInt_UserId(Util.getUserId());
	vote.setStr_Remark(str_Remark);
	vote.setStr_Choise(str_Choise);
	 
	vote.setInt_PoolId(latestPolls.getInt_PoolId());
	 isVoted=getExpenseService().isVoted( Util.getUserId(),latestPolls.getInt_PoolId());
		 
   
	getExpenseService().addVote(vote);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Your Vote has been registered Successfully. Thank you participating!"));
	 
	long_Vote= getExpenseService().getTotalVote(latestPolls.getInt_PoolId());
	latestPolls.setInt_Vote(long_Vote);
	System.out.println( long_Vote);
	getExpenseService().UpdatePool(latestPolls);
	onePoll=null;
	 
	 
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
	 
			 
	if(getIsVoted1()==null&&!(getExpenseService().getLatestPolls()==null))
		 
		rendered=true;
	else
		rendered=false;
	  
	return rendered;
}
public void setRendered(Boolean rendered) {
	this.rendered = rendered;
}
public Boolean getRendered1() {
	if(getIsVoted1()==null)
		 
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

 private Assets a=new Assets();
 public Assets getA() {
	return a;
}
public void setA(Assets a) {
	this.a = a;
}
public String editAssets(Integer aid)
 {
	a=getExpenseService().getOneAssets(aid);
	 return "editasset.xhtml";
 }
 public String viewAssets(Integer aid)
 {
	 a=getExpenseService().getOneAssets(aid);
	 return "viewasset.xhtml";
 }
 
public List<Assets> getSelectedAssets() {
	return selectedAssets;
}
public void setSelectedAssets(List<Assets> selectedAssets) {
	this.selectedAssets = selectedAssets;
}
private Parking parking11=new Parking();
public void getParking1(Integer pid)
{
	parking11=getExpenseService().getOneParking(pid);
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

 
private boolean indicate;
 

public boolean isIndicate() {
	return indicate;
}
public void setIndicate(boolean indicate) {
	this.indicate = indicate;
}
public String select()
{   
  try{ 
   if(indicate==false)
   {    
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select a poll to view!"));
		return "pools.xhtml";
   }
   else
   {  
	   indicate=false;
	  return "viewpool.xhtml";
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
   {   System.out.println("jcvkvcjvj11111111111111111111111111111111111111111111111111");
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select a poll to vote!"));
		return "pools.xhtml";
   }
   else
   {  
	   indicate=false;
	  return "vote.xhtml";
   }
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return null;
}
public String select2()
{   
  try{ 
   if(indicate==false)
   {   
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select an Asset!"));
		return "assets.xhtml";
   }
   else
   {  indicate=false;
	    
	  return "viewasset.xhtml";
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
}
public  void rowSelectListener( SelectEvent event)
{ 
	
	 
	  indicate=true;
}
public String select3()
{   
  try{ 
   if(indicate==false)
   {    
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select an Asset!"));
		return "assets.xhtml";
   }
   else
   {  indicate=false;
	   
	  return "editasset.xhtml";
   }
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return null;
}
public String select4()
{   
  try{ 
   if(indicate==false)
   {    
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select an item to proceed!"));
		return null;
   }
   else
   {  
	   indicate=false;
	  return null;
   }
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return null;
}
	
}



