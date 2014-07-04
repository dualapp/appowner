package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.Vendor;
import com.appowner.model.WaterPayment;
import com.appowner.service.VendorService;

@ManagedBean
@ViewScoped
public class WaterPaymentBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<String> str_VendorNameByType ;
private Date date_FromDate;
private Date date_ToDate;
private String str_VendorType;
private String str_VendorName;
private int int_NoOfTankers;
 
private double dbl_PricePerTanker;
private List<WaterPayment> waterPaymentList;
 
 
public List<WaterPayment> getWaterPaymentList() {
	waterPaymentList=new ArrayList<WaterPayment>();
	 waterPaymentList.addAll(getVendorservice().getWaterPaymentList());
	
	return waterPaymentList;
}

public void setWaterPaymentList(List<WaterPayment> waterPaymentList) {
	this.waterPaymentList = waterPaymentList;
}

public List<String> getStr_VendorNameByType() {
	return str_VendorNameByType;
}

public void setStr_VendorNameByType(List<String> str_VendorNameByType) {
	this.str_VendorNameByType = str_VendorNameByType;
}

public String getStr_VendorName() {
	return str_VendorName;
}

public void setStr_VendorName(String str_VendorName) {
	this.str_VendorName = str_VendorName;
}
private double dbl_TotalPrice;
private String str_Description;
private Date date_Date;

@ManagedProperty(value = "#{VendorService}")
private VendorService vendorservice;

 
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

public String getStr_VendorType() {
	return str_VendorType;
}

public void setStr_VendorType(String str_VendorType) {
	this.str_VendorType = str_VendorType;
}
 

public int getInt_NoOfTankers() {
	return int_NoOfTankers;
}

public void setInt_NoOfTankers(int int_NoOfTankers) {
	this.int_NoOfTankers = int_NoOfTankers;
}
 
public String getStr_Description() {
	return str_Description;
}

public void setStr_Description(String str_Description) {
	this.str_Description = str_Description;
}

public Date getDate_Date() {
	return date_Date;
}

public void setDate_Date(Date date_Date) {
	this.date_Date = date_Date;
}

public VendorService getVendorservice() {
	return vendorservice;
}
private WaterPayment waterPayment;
public WaterPayment getWaterPayment() {
	return waterPayment;
}

public void setWaterPayment(WaterPayment waterPayment) {
	this.waterPayment = waterPayment;
}

public void setVendorservice(VendorService vendorservice) {
	this.vendorservice = vendorservice;
}
 
public String saveWaterVendorPayment()
{    waterPayment=new WaterPayment();
	waterPayment.setDate_Date(getDate_Date());
	waterPayment.setDate_FromDate(getDate_FromDate());
	waterPayment.setDate_ToDate(getDate_ToDate());
	waterPayment.setInt_NoOfTankers(getInt_NoOfTankers());
	waterPayment.setDbl_PricePerTanker(getDbl_PricePerTanker());
	waterPayment.setDbl_TotalPrice(getDbl_TotalPrice());
	//waterPayment.setInt_WaterPaymentId(getInt_WaterPaymentId);
	waterPayment.setStr_Description(getStr_Description());
	waterPayment.setStr_VendorName(getStr_VendorName());
	waterPayment.setStr_VendorType(getStr_VendorType());
	getVendorservice().saveWaterVendorPayment(waterPayment);
	return "waterpaymentlist.xhtml";
	
}

public double getDbl_PricePerTanker() {
	return dbl_PricePerTanker;
}

public void setDbl_PricePerTanker(double dbl_PricePerTanker) {
	this.dbl_PricePerTanker = dbl_PricePerTanker;
}

public double getDbl_TotalPrice() {
	dbl_PricePerTanker=getDbl_PricePerTanker();
	int_NoOfTankers=getInt_NoOfTankers();
	dbl_TotalPrice=dbl_PricePerTanker*int_NoOfTankers;
	return dbl_TotalPrice;
}

public void setDbl_TotalPrice(double dbl_TotalPrice) {
	this.dbl_TotalPrice = dbl_TotalPrice;
}
public List<String> vendorTypeChangeListener(ValueChangeEvent event)
{   
	str_VendorType=(String) event.getNewValue();
	System.out.println(str_VendorType);
	str_VendorNameByType=new ArrayList<String>();
	str_VendorNameByType.addAll(getVendorservice().listOfVendorNameByType(str_VendorType));
	System.out.println(str_VendorNameByType);
	return str_VendorNameByType ;
	
}
private int int_WaterPaymentId;
 public int getInt_WaterPaymentId() {
	return int_WaterPaymentId;
}

public void setInt_WaterPaymentId(int int_WaterPaymentId) {
	this.int_WaterPaymentId = int_WaterPaymentId;
}

public String deleteWaterPayment()
 {
	 waterPayment=new WaterPayment();
	 waterPayment.setInt_WaterPaymentId(int_WaterPaymentId);
	 getVendorservice().deleteWaterpayment(waterPayment);
	 return "waterpaymentlist.xhtml";
	 
 }
public String getOneWaterPaymentDetails() {
	return oneWaterPaymentDetails;
}

public void setOneWaterPaymentDetails(String oneWaterPaymentDetails) {
	this.oneWaterPaymentDetails = oneWaterPaymentDetails;
}

public String cancel() 
{
	return "waterpaymentlist.xhtml?faces-redirect=true";
}
 private String oneWaterPaymentDetails;
public void getOneWaterPayment()
{waterPayment=new WaterPayment();
	waterPayment=getVendorservice().getWaterPayment1(int_WaterPaymentId);
}

public String updateWaterPayment()
{
	getVendorservice(). updateWaterPayment(waterPayment);
	return "waterpaymentlist";
}
 private WaterPayment searchVendorByName;


public WaterPayment getSearchVendorByName() {
	 System.out.println(str_VendorName);
	searchVendorByName=getVendorservice().getSearchVendorByName(str_VendorName);
	System.out.println(searchVendorByName);
	return searchVendorByName;
}

public void setSearchVendorByName(WaterPayment searchVendorByName) {
	this.searchVendorByName = searchVendorByName;
}
private Vendor vendor=new Vendor();
public Vendor getVendor() {
	return vendor;
}
private List<String> str_VendorTypes;
public List<String> getStr_VendorTypes() {
	str_VendorTypes=new ArrayList<String>();
	str_VendorTypes.addAll(getVendorservice().getStr_VendorTypes());
	
	return str_VendorTypes;
}

public void setStr_VendorTypes(List<String> str_VendorTypes) {
	this.str_VendorTypes = str_VendorTypes;
}

/*public List<WaterPayment> getSearchByVendortype() {
	System.out.println(str_VendorType);
	//searchByVendortype=new ArrayList<WaterPayment>();
	//searchByVendortype.addAll(getVendorservice().getSearchByVendortype(str_VendorType,date_FromDate,date_ToDate));
	//System.out.println(searchByVendortype);
	 
	return searchByVendortype;
	
}
public String getSearchByVendortype1()
{
	searchByVendortype=new ArrayList<WaterPayment>();
	searchByVendortype.addAll(getVendorservice().getSearchByVendortype(str_VendorType,date_FromDate,date_ToDate));
	//System.out.println(searchByVendortype);
	return "viewpaymentlistbyvendortype.xhtml";
}

public void setSearchByVendortype(List<WaterPayment> searchByVendortype) {
	this.searchByVendortype = searchByVendortype;
}*/

public void setVendor(Vendor vendor) {
	this.vendor = vendor;
}


private List<WaterPayment> searchByVendortype;
 

public String searchVendorByName1() {
	//vendor=new Vendor();
	System.out.println(str_VendorName);
	vendor = getVendorservice().searchVendorByName1(str_VendorName);
	System.out.println(vendor);
	if (vendor!= null) {
		return "viewatwerpaymentbyvendorname.xhtml?faces-redirect=true";
		
	} else
	{
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("vendor does not exist!!!!!"));
		return null;
	}
}
 
}
