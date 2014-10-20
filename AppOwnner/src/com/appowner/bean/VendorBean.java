package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.search.annotations.Factory;
import org.primefaces.event.RateEvent;
import org.springframework.context.annotation.Scope;

import com.appowner.model.Parking;
import com.appowner.model.Vendor;
import com.appowner.model.VendorCity;
import com.appowner.model.VendorCountry;
import com.appowner.model.VendorServiceDetails;
import com.appowner.model.VendorState;
import com.appowner.model.WorkOrderCategory;
import com.appowner.service.VendorService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped
public class VendorBean implements Serializable {
 private int int_ServiceId;
 private String str_VendorType;
 private String str_VendorCategoryType;
 private String str_OrganizationName;
 private String str_StateName;
	private String str_VendorCountry;
	private String str_VendorAddress;
	private List<Vendor> vendorList;
	private String str_VendorName;
	private String str_VendorPhone;
	private int int_VendorId;
	private String str_ZipCode;
	private VendorServiceDetails str_VendorService;
	private String str_VendorEmail;
	private String str_VendorComments;
	private int int_VendorServiceRating;
	private int int_VendorExpense;
	private boolean bool_IsVendorActive;
	private boolean bool_IsACompany;
	private String str_VendorBankAccount;
	private String str_VendorBankName;
	private String str_VendorBankNeftOrIfsc;
	private String str_PanNo;
	
	private String str_ServiceTaxNo;
	private String str_AdditionalInfo;
	private Boolean bool_VisibleToPublic;
	private int int_TdsCharge;
	private String str_Website;
	private List<WorkOrderCategory> workOrderCategoryList;
	private List<WorkOrderCategory> workOrderCategoryList1;
	
	public List<WorkOrderCategory> getWorkOrderCategoryList1() {
		return workOrderCategoryList1;
	}
	public  String deleteWorkOrder()
	{
		List<WorkOrderCategory> entitiesToDelete = new ArrayList<WorkOrderCategory>();
		 
	    for (WorkOrderCategory w :workOrderCategoryList1) {
	    	 
	    	if (w.getInt_WorkOrderCategoryId()!=null) 
	    	{
	            entitiesToDelete.add(w);
	        }
	    	FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Workorder deleted Successfully!", "Workorder deleted Successfully!"));
	    } 
	 
	    getVendorservice().deleteWorkOrder(entitiesToDelete);
		return "workordercategory.xhtml";
	}
	public String updateWorkOrder(WorkOrderCategory w)
	{
		getVendorservice().updateWorkOrder(w);
		return "null";
	}

	public void setWorkOrderCategoryList1(
			List<WorkOrderCategory> workOrderCategoryList1) {
		this.workOrderCategoryList1 = workOrderCategoryList1;
	}

	private List<Vendor>selectedVendor1;
  

	public String getStr_VendorCategoryType() {
	return str_VendorCategoryType;
}

public void setStr_VendorCategoryType(String str_VendorCategoryType) {
	this.str_VendorCategoryType = str_VendorCategoryType;
}

public String getStr_OrganizationName() {
	str_OrganizationName=Util.getAppartmentName();
	return str_OrganizationName;
}

public void setStr_OrganizationName(String str_OrganizationName) {
	this.str_OrganizationName = str_OrganizationName;
}

	public String getStr_VendorType() {
	return str_VendorType;
}

public void setStr_VendorType(String str_VendorType) {
	this.str_VendorType = str_VendorType;
}

	public int getInt_ServiceId() {
	return int_ServiceId;
}

public void setInt_ServiceId(int int_ServiceId) {
	this.int_ServiceId = int_ServiceId;
}
/*
 * get All VendorCategoryType
 */
public List<String> getStr_VendorTypeList() {
	str_VendorTypeList=new ArrayList<String>();
	str_VendorTypeList.addAll(getVendorservice().getStr_VendorTypeList());
	System.out.println(str_VendorTypeList);
	return str_VendorTypeList;
}


public void setWorkOrderCategoryList(
		List<WorkOrderCategory> workOrderCategoryList) {
	this.workOrderCategoryList = workOrderCategoryList;
}


public WorkOrderCategory getWorkOrderCategory() {
	return workOrderCategory;
}

public void setWorkOrderCategory(WorkOrderCategory workOrderCategory) {
	this.workOrderCategory = workOrderCategory;
}
/*
 * get WorkOrderCategoryList
 */
 
public List<WorkOrderCategory> getWorkOrderCategoryList() {
	workOrderCategoryList=new ArrayList<WorkOrderCategory>();
	workOrderCategoryList.addAll(getVendorservice().getWorkOrderCategoryList());
	System.out.println(workOrderCategoryList+"kalpana");
	return workOrderCategoryList;
}

public void setStr_VendorTypeList(List<String> str_VendorTypeList) {
	this.str_VendorTypeList = str_VendorTypeList;
}

private List<String> str_VendorTypeList;
private List<String> vendorNameList;
	public List<String> getVendorNameList() {
		vendorNameList=new ArrayList<String>();
		vendorNameList=getVendorservice().getVendorNameList();
	return vendorNameList;
}

public void setVendorNameList(List<String> vendorNameList) {
	this.vendorNameList = vendorNameList;
}
private List<Vendor> vendorListByName;


	public void getVendorName(ValueChangeEvent event) {
		int_VendorId= (int) event.getNewValue();
		System.out.println(int_VendorId);
		 
}
	
	public List<Vendor> getVendorListByName() {
		vendorListByName=new ArrayList<Vendor>();
		vendorListByName=getVendorservice().getVendorListByName(str_VendorName);
	return vendorListByName;
	}
public void setVendorListByName(List<Vendor> vendorListByName) {
	this.vendorListByName = vendorListByName;
}

	private List<String> str_VendorCities;
	private String Zip;
	private String AddressLine1;

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	private List<String> cityListByState;
	private VendorServiceDetails vendorServiceDetails1;
	private VendorServiceDetails vendorServiceDetails2;

	public VendorServiceDetails getVendorServiceDetails2() {
		return vendorServiceDetails2;
	}

	public void setVendorServiceDetails2(
			VendorServiceDetails vendorServiceDetails2) {
		this.vendorServiceDetails2 = vendorServiceDetails2;
	}

	public VendorServiceDetails getVendorServiceDetails1() {
		return vendorServiceDetails1;
	}

	public void setVendorServiceDetails1(
			VendorServiceDetails vendorServiceDetails1) {
		this.vendorServiceDetails1 = vendorServiceDetails1;
	}

	public VendorState getVendorState() {
		return vendorState;
	}

	public void setVendorState(VendorState vendorState) {
		this.vendorState = vendorState;
	}

	public void setCityListByState(List<String> cityListByState) {
		this.cityListByState = cityListByState;
	}

	private String str_ServiceName;
	private String int_ServicePrice;

	public String getStr_ServiceName() {
		return str_ServiceName;
	}

	public void setStr_ServiceName(String str_ServiceName) {
		this.str_ServiceName = str_ServiceName;
	}

	public String getInt_ServicePrice() {
		return int_ServicePrice;
	}

	public void setInt_ServicePrice(String int_ServicePrice) {
		this.int_ServicePrice = int_ServicePrice;
	}

	private List<String> str_VendorCountries;
	private List<String> str_VendorStates;
	private String str_VendorState;

	public String getStr_VendorState() {
		return str_VendorState;
	}

	public void setStr_VendorState(String str_VendorState) {
		this.str_VendorState = str_VendorState;
	}

	private String str_VendorCity;

	public String getStr_StateName() {
		return str_StateName;
	}

	public void setStr_StateName(String str_StateName) {
		this.str_StateName = str_StateName;
	}

	// private String CountryName;
	@SuppressWarnings("rawtypes")
	private List list1 = new ArrayList();

	public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

	@SuppressWarnings("rawtypes")
	private List list = new ArrayList();

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	
	public String getStr_PanNo() {
		return str_PanNo;
	}

	public void setStr_PanNo(String str_PanNo) {
		this.str_PanNo = str_PanNo;
	}

	public String getStr_ServiceTaxNo() {
		return str_ServiceTaxNo;
	}

	public void setStr_ServiceTaxNo(String str_ServiceTaxNo) {
		this.str_ServiceTaxNo = str_ServiceTaxNo;
	}

	public String getStr_AdditionalInfo() {
		return str_AdditionalInfo;
	}

	public void setStr_AdditionalInfo(String str_AdditionalInfo) {
		this.str_AdditionalInfo = str_AdditionalInfo;
	}

	 

	public Boolean getBool_VisibleToPublic() {
		return bool_VisibleToPublic;
	}

	public void setBool_VisibleToPublic(Boolean bool_VisibleToPublic) {
		this.bool_VisibleToPublic = bool_VisibleToPublic;
	}

	public int getInt_TdsCharge() {
		return int_TdsCharge;
	}

	public void setInt_TdsCharge(int int_TdsCharge) {
		this.int_TdsCharge = int_TdsCharge;
	}

	public String getStr_Website() {
		return str_Website;
	}

	public void setStr_Website(String str_Website) {
		this.str_Website = str_Website;
	}

	private String str_ContactPersonName;
	@ManagedProperty(value = "#{VendorService}")
	private VendorService vendorservice;

	public VendorService getVendorservice() {
		return vendorservice;
	}

	public void setVendorservice(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	private List<VendorServiceDetails> vendorServiceDetails; 
	//private List<VendorServiceDetails> vendorServiceDetails3;
	 
		@PostConstruct
	    public void init() {
			vendorServiceDetails=new ArrayList<VendorServiceDetails>();
			//vendorServiceDetails3=new ArrayList<VendorServiceDetails>();
			 
			     }
	public List<VendorServiceDetails> getVendorServiceDetails() {
		return vendorServiceDetails;
	}

	public void setVendorServiceDetails(
			List<VendorServiceDetails> vendorServiceDetails) {
		this.vendorServiceDetails = vendorServiceDetails;
	}
	

	public void add() {
		VendorServiceDetails v1=new VendorServiceDetails();
		vendorServiceDetails.add(v1);
		 
	}
	public String getStr_ContactPersonName() {
		return str_ContactPersonName;
	}

	public void setStr_ContactPersonName(String str_ContactPersonName) {
		this.str_ContactPersonName = str_ContactPersonName;
	}

	public String getStr_ZipCode() {
		return str_ZipCode;
	}

	public void setStr_ZipCode(String str_ZipCode) {
		this.str_ZipCode = str_ZipCode;
	}

	public String getStr_VendorAddress() {
		return str_VendorAddress;
	}

	public void setStr_VendorAddress(String str_VendorAddress) {
		this.str_VendorAddress = str_VendorAddress;
	}

	public void setStr_VendorService(VendorServiceDetails str_VendorService) {
		this.str_VendorService = str_VendorService;
	}

	public void setInt_VendorExpense(int int_VendorExpense) {
		this.int_VendorExpense = int_VendorExpense;
	}

	/*
	 * public void remove() { vendorServiceDetails.remove(new
	 * VendorServiceDetails ()); //vendorServiceDetails.remove(""); }
	 */

	public String getStr_VendorCity() {
		return str_VendorCity;
	}

	public void setStr_VendorCity(String str_VendorCity) {
		this.str_VendorCity = str_VendorCity;
	}

	public String getStr_VendorCountry() {
		return str_VendorCountry;
	}

	public void setStr_VendorCountry(String str_VendorCountry) {
		this.str_VendorCountry = str_VendorCountry;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static final String vendorlist= "vendorlist";

	// VendorState model class
	private VendorState vendorState;

	public VendorState getVendaorState() {
		return vendorState;
	}

	public void setVendaorState(VendorState vendaorState) {
		this.vendorState = vendaorState;
	}

	public void setStr_VendorStates(List<String> str_VendorStates) {
		this.str_VendorStates = str_VendorStates;
	}

	// Vendor model class
	private Vendor vendor;

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getStr_VendorName() {
		return str_VendorName;
	}

	public void setStr_VendorName(String str_VendorName) {
		this.str_VendorName = str_VendorName;
	}

	public String getStr_VendorPhone() {
		return str_VendorPhone;
	}

	public void setStr_VendorPhone(String str_VendorPhone) {
		this.str_VendorPhone = str_VendorPhone;
	}

	public int getInt_VendorId() {
		return int_VendorId;
	}

	public void setInt_VendorId(int int_VendorId) {
		this.int_VendorId = int_VendorId;
	}

	// VendorCountry model class with getter and setter
	private VendorCountry vendorCountry;

	public VendorCountry getVendorCountry() {
		return vendorCountry;
	}

	public void setVendorCountry(VendorCountry vendorCountry) {
		this.vendorCountry = vendorCountry;
	}

	// VendorCity model class with getter and setter
	private VendorCity vendorCity;

	public VendorCity getVendorCity() {
		return vendorCity;
	}

	public void setVendorCity(VendorCity vendorCity) {
		this.vendorCity = vendorCity;
	}

	/**
	 * This listener cleans up the State value if a new Country is selected.
	 * 
	 * @param event
	 *            a change event when the value of the country changes.
	 */

	@SuppressWarnings("unchecked")
	public void vendorServiceDetailsListener(ValueChangeEvent event) {

		 
		list.add(event.getNewValue());
		 

	}

	@SuppressWarnings("unchecked")
	public void vendorServiceDetailsListener1(ValueChangeEvent event) {

		 
		list1.add(event.getNewValue());
	 

	}

	/**
	 * This listener cleans up the State value if a new Country is selected.
	 * 
	 * @param event
	 *            a change event when the value of the country changes.
	 */

	public void countryChangeListener(ValueChangeEvent event) {
		if ((event.getNewValue() != str_VendorCountry)) {
			str_VendorState = null;
			// str_VendorCity = null;

		}

		str_VendorCountry = (String) event.getNewValue();
	}

	/**
	 * This listener cleans up the city value if a new state is selected.
	 * 
	 * @param event
	 *            a change event when the value of the state changes.
	 * @return
	 */
	public List<String> stateChangeListener(ValueChangeEvent event) {

		str_StateName = (String) event.getNewValue();
		cityListByState = new ArrayList<String>();
		cityListByState.addAll(getVendorservice().cityList1(str_StateName));

		return cityListByState;
	}

	/**
	 * this listener gets the value of Service field
	 * 
	 * @param event
	 */

	/*
	 * List<String> getCityListByState () //this method select cities according
	 * to selected state { int int_StateId= vendorState.getInt_stateId();
	 * System.out.println(int_StateId);
	 * 
	 * cityListByState=new ArrayList<String>(); cityListByState.addAll(
	 * getVendorservice().cityList1( int_StateId ));
	 * 
	 * //System.out.println(str_VendorCities.size()); return cityListByState ; }
	 */
/**
     * Gets a {@code List of Country.
     *
     * @return a list of  Country 
      
     */

	public List<String> getStr_VendorCountries() {

		str_VendorCountries = new ArrayList<String>();
		str_VendorCountries.addAll(getVendorservice().countryList());
		return str_VendorCountries;
	}

/**
     * Gets a {@code List of States based on the selected Country.
     *
     * @return a list of States based on selected Country, or an empty list if no
     * Country is selected.
     */
	public List<String> getStr_VendorStates() {
		if (str_VendorCountry != null) {
			str_VendorStates = new ArrayList<String>();
			str_VendorStates.addAll(getVendorservice().stateList());
			return str_VendorStates;
		} else
			return new ArrayList<String>();

	}

/**
     * Gets a {@code List of cities based on the selected state.
     *
     * @return a list of cities based on selected state, or an empty list if no
     * state is selected.
     */
	public List<String> getStr_VendorCities() {
		if ((str_VendorState != null)) {

			 
			return cityListByState;
		} else
			return new ArrayList<String>();
	}

	public void setStr_VendorCities(List<String> str_VendorCities) {
		this.str_VendorCities = str_VendorCities;
	}

	public void setStr_VendorCountries(List<String> str_VendorCountries) {
		this.str_VendorCountries = str_VendorCountries;
	}

	public VendorServiceDetails getStr_VendorService() {
		return str_VendorService;
	}

	public String getStr_VendorEmail() {
		return str_VendorEmail;
	}

	public void setStr_VendorEmail(String str_VendorEmail) {
		this.str_VendorEmail = str_VendorEmail;
	}

	public String getStr_VendorComments() {
		return str_VendorComments;
	}

	public void setStr_VendorComments(String str_VendorComments) {
		this.str_VendorComments = str_VendorComments;
	}

	public int getInt_VendorServiceRating() {
		return int_VendorServiceRating;
	}

	public void setInt_VendorServiceRating(int int_VendorServiceRating) {
		this.int_VendorServiceRating = int_VendorServiceRating;
	}
	 
	 public String getIdParam(FacesContext fc){
		 
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		System.out.println((params.get(int_VendorId)) );
		return   (params.get(2));
 
	}
	public Vendor getVendor() {
		/*FacesContext fc = FacesContext.getCurrentInstance();
		// int_VendorId = getIdParam(fc);
		
		vendor=new Vendor();
		
		System.out.println(int_VendorId+"vid");
		vendor = getVendorservice().getVendor(int_VendorId);*/
		System.out.println(vendor+"vvv");
		return vendor;
	} 
	private List<Vendor> selectedVendor;

	public List<Vendor> getSelectedVendor() {
		System.out.println(selectedVendor);
		return selectedVendor;
	}

	public void setSelectedVendor(List<Vendor> selectedVendor) {
		this.selectedVendor = selectedVendor;
	}

	public String getStr_VendorBankAccount() {
		return str_VendorBankAccount;
	}

	public void setStr_VendorBankAccount(String str_VendorBankAccount) {
		this.str_VendorBankAccount = str_VendorBankAccount;
	}

	public String getStr_VendorBankName() {
		return str_VendorBankName;
	}

	public void setStr_VendorBankName(String str_VendorBankName) {
		this.str_VendorBankName = str_VendorBankName;
	}

	public String getStr_VendorBankNeftOrIfsc() {
		return str_VendorBankNeftOrIfsc;
	}

	public void setStr_VendorBankNeftOrIfsc(String str_VendorBankNeftOrIfsc) {
		this.str_VendorBankNeftOrIfsc = str_VendorBankNeftOrIfsc;
	}

	public boolean isBool_IsVendorActive() {
		return bool_IsVendorActive;
	}

	public void setBool_IsVendorActive(boolean bool_IsVendorActive) {
		this.bool_IsVendorActive = bool_IsVendorActive;
	}

	public int getInt_VendorExpense() {
		return int_VendorExpense;
	}

	public boolean isBool_IsACompany() {
		return bool_IsACompany;
	}

	public Map<Long, Boolean> getChecked() {
		return checked;
	}

	public void setChecked(Map<Long, Boolean> checked) {
		this.checked = checked;
	}

	public void setBool_IsACompany(boolean bool_IsACompany) {
		this.bool_IsACompany = bool_IsACompany;
	}
	private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
	
  public String updateServiceDetails()
  {
	  getVendorservice().update(vendorServiceDetails1);
	  return "viewvendor.xhtml";
  }
  public String updateVendor(Vendor vendor) {
		if (vendor.getInt_VendorId() != null) {
			getVendorservice().update(vendor);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);

			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

		} else
			getVendorservice().addVendor(vendor);
		return "vendorlists.xhtml";
	}
	public String updateVendor() {
		if (vendor.getInt_VendorId() != null) {
			getVendorservice().update(vendor);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);

			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

		} else
			getVendorservice().addVendor(vendor);
		return "vendorlists.xhtml";
	}
	public String updateVendorServiceDetails(VendorServiceDetails vendorServiceDetails5)
	 {  int_ServicePrice=vendorServiceDetails5.getInt_ServicePrice();
	   str_ServiceName=vendorServiceDetails5.getStr_ServiceName();
	 
	 System.out.println( str_ServiceName);
	 System.out.println(int_ServicePrice);
	   vendorServiceDetails5.setEditable(false);
		getVendorservice().updateVendorServiceDetails(vendorServiceDetails5);
		 
		  return null;
	 }
	
	public String editAction(VendorServiceDetails vendorServiceDetails4) {
		vendorServiceDetails4.setEditable(true);
		 
		return  null;
	}
	private   List<VendorServiceDetails> vendorServiceDetails3=new ArrayList<VendorServiceDetails>();
	 /**
	  * 
	  * @return list of serviceDetails according to vendor id
	  */
	  
	public List<VendorServiceDetails> getVendorServiceDetails3() {
		//vendorServiceDetails3=new ArrayList<VendorServiceDetails>();
		//Thread.dumpStack();
		 
		vendorServiceDetails3.addAll(getVendorservice().getVendorServiceDetails(int_VendorId));
		 
		return vendorServiceDetails3;
	}
	 
	 
  
		public void setVendorServiceDetails3(
				List<VendorServiceDetails> vendorServiceDetails3) {
			this.vendorServiceDetails3 = vendorServiceDetails3;
		}

	public void getCity() {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String saveVendor() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
 
		vendorServiceDetails1 = new VendorServiceDetails();
		vendorServiceDetails2 = new VendorServiceDetails();
		Vendor vendor = new Vendor();

		 

		vendor.setBool_IsaCompany(isBool_IsACompany());
		vendor.setBool_IsVendorActive(isBool_IsVendorActive());

		 vendor.setBool_VisibleToPublic(getBool_VisibleToPublic());
		 vendor.setInt_TdsCharge(getInt_TdsCharge());
		 vendor.setStr_AdditionalInfo(getStr_AdditionalInfo());
		 vendor.setStr_ContactPersonName(getStr_ContactPersonName());
		 vendor.setStr_PanNo(getStr_PanNo());
		 vendor.setStr_ServiceTaxNo(getStr_ServiceTaxNo());
		 vendor.setStr_Website(getStr_Website());
		vendor.setStr_StateName(str_VendorState);
		vendor.setStr_CityName(str_VendorCity);
		vendor.setStr_CountryName(str_VendorCountry);
 
		vendor.setInt_VendorId(getInt_VendorId());
		vendor.setStr_VendorComments(getStr_VendorComments());
		vendor.setStr_VendorType(getStr_VendorType());
		vendor.setInt_VendorServiceRating(getInt_VendorServiceRating());
		vendor.setStr_VendorAccount(getStr_VendorBankAccount());
		vendor.setStr_VendorBankName(getStr_VendorBankName());
		vendor.setStr_VendorBankNeftOrIfsc(getStr_VendorBankNeftOrIfsc());
		vendor.setStr_VendorEmail(getStr_VendorEmail());
		vendor.setStr_VendorName(getStr_VendorName());
		vendor.setStr_Zip(getStr_ZipCode());
		vendor.setStr_AddressLine1(getAddressLine1());
		 
		vendor.setInt_VendorServiceRating(getInt_VendorServiceRating());
		vendor.setStr_VendorPhone(getStr_VendorPhone());
		/*
		 * checks for existing mobile num
		 */
		 Integer vid=getVendorservice().getInt_VendorId(getStr_VendorPhone());
		 System.out.println(vid);
		 if(vid!=null)
		 {
			
			 facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," This mobile  number already exist!", "This mobile  number already exist!"));
		 return null;
		 }
		 else
		 {
		getVendorservice().addVendor(vendor);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Vendor Added Successfully!", "Vendor added Successfully!"));
		int vendorId = getVendorservice().getVendorId(str_VendorName);
		System.out.println(vendorId);
		 
		ListIterator itr = list.listIterator();
		ListIterator itr1 = list1.listIterator();
		while (itr.hasNext() || itr1.hasNext()) {
			Object servicename = itr.next();
			str_ServiceName = (String) servicename;
			Object serviceprice = itr1.next();
			int_ServicePrice = (String) serviceprice;
			System.out.println(str_ServiceName);
			System.out.println(int_ServicePrice);
			vendorServiceDetails1.setStr_ServiceName(str_ServiceName);
			vendorServiceDetails1.setInt_ServicePrice(int_ServicePrice);
			vendorServiceDetails1.setInt_VendorId(vendorId);
			getVendorservice().addServiceDetails(vendorServiceDetails1);
			 
			
		 
		}

		 

		return "addvendor.xhtml";
	}
	}
	private WorkOrderCategory workOrderCategory;
	public void saveWorkOrderCategory()
	{
		workOrderCategory=new WorkOrderCategory();
		
		workOrderCategory.setStr_VendorCategoryType(str_VendorCategoryType);
		getVendorservice().saveWorkOrderCategory(workOrderCategory);
	}
	public List<Vendor> getVendorList() {
		vendorList = new ArrayList<Vendor>();
		vendorList.addAll(getVendorservice().vendorList(str_VendorName,str_VendorType));
 
		return vendorList;
	}

	public void setVendorList(List<Vendor> vendorList) {
		this.vendorList = vendorList;
	}

	public String deleteVendor() {
		Vendor vendor = new Vendor();
		vendor.setInt_VendorId(int_VendorId);
		

		getVendorservice().deleteVendor(vendor);

		return "vendorlists?faces-redirect=true";

	}
 
boolean myButton;
public VendorBean(){

        myButton = true;

}

public boolean isMyButton() {
	return myButton;
}

public void setMyButton(boolean myButton) {
	this.myButton = myButton;
}

public void enableButton(){

      myButton = true;
}

public void disableButton(){

      myButton = false;
}
public void myChangeListener(ValueChangeEvent e){
     
    System.out.println(e.getNewValue().toString()+"listner");
    System.out.println(e.getNewValue().toString().equals("1")+"listner1");
       if(e.getNewValue().toString().equals("1"))
                     enableButton();
       else
                   disableButton();
}
	public String deleteVendor1() {
	    List<Vendor> entitiesToDelete = new ArrayList<Vendor>();
 
	    for (Vendor vendor :selectedVendor) {
	    	 
	    	if (vendor.getInt_VendorId()!=null) 
	    	{
	            entitiesToDelete.add(vendor);
	        }
	    	
	    } 
System.out.println(entitiesToDelete+"entyt todelete");
	    getVendorservice().deleteVendor1(entitiesToDelete);
	    FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Vendor deleted Successfully!", "Vendor deleted Successfully!"));
	    return "vendorlists?faces-redirect=true";
	}
	public String cancelVendor() {
		return "vendorlists?faces-redirect=true";
	}
/**
 * get particular vendor according to vendor id
 */
	public void getVendor1() {

		vendor = getVendorservice().getVendor(int_VendorId);
		//System.out.println(vendor.getStr_VendorName());

	}
/**
 * get particular service details according to service id
 */
	 public void getServiceDetasils()
	 { System.out.println(int_ServiceId);
	  vendorServiceDetails1 =new VendorServiceDetails();
		 vendorServiceDetails1=getVendorservice().getServiceDetails(int_ServiceId);
	 }
	
	public void onrate(RateEvent rateEvent) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Vendor Rate ", "You rated:"
						+ ((Integer) rateEvent.getRating()).intValue());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void oncancel() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Cancel Event", "Rate Reset");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<Vendor> getSelectedVendor1() {
		System.out.println(selectedVendor1+"selectedVendor1");
		return selectedVendor1;
	}

	public void setSelectedVendor1(List<Vendor> selectedVendor1) {
		this.selectedVendor1 = selectedVendor1;
	}
	
}