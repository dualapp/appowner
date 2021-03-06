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
import javax.servlet.http.HttpServletRequest;

import org.hibernate.search.annotations.Factory;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RateEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
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
	    	
	    } 
	 
	    getVendorservice().deleteWorkOrder(entitiesToDelete);
	    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Workorder deleted Successfully!"));
		 
		return "workordercategory.xhtml";
	}
	public String updateWorkOrder()
	
	{
		if(w!=null)
		{
		 
		getVendorservice().updateWorkOrder(w);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Workorder Updated Successfully!"));
		return "workordercategory.xhtml";
		}
		else{
			 FacesMessage message = null;
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "workordercategory.xhtml";

		}
		
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
	private Double int_ServicePrice;

	public String getStr_ServiceName() {
		return str_ServiceName;
	}

	public void setStr_ServiceName(String str_ServiceName) {
		this.str_ServiceName = str_ServiceName;
	}

	 

	public Double getInt_ServicePrice() {
		return int_ServicePrice;
	}
	public void setInt_ServicePrice(Double int_ServicePrice) {
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
	private List<Double> list1= new ArrayList<Double>();

	@SuppressWarnings("rawtypes")
	private List<String> list = new ArrayList<String>();

	public List getList1() {
		return list1;
	}
	public void setList1(List list1) {
		this.list1 = list1;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	
	 public void onRowEdit(RowEditEvent event) {
		 Object o =event.getObject();
		  VendorServiceDetails  vs=(VendorServiceDetails)o;
		  System.out.println("Edit: " +vs.getStr_ServiceName()+""+vs.getInt_ServicePrice());
         getVendorservice().update(vs);
         
	        FacesMessage msg = new FacesMessage(" Row  Edited" );
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	    	 
		        FacesMessage msg = new FacesMessage(" Row Canceled" );
		        FacesContext.getCurrentInstance().addMessage(null, msg);
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
	private Vendor vendor=new Vendor();

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
  
		 
		list.add((String) event.getNewValue());
		 

	}

	@SuppressWarnings("unchecked")
	public void vendorServiceDetailsListener1(ValueChangeEvent event) {
     
      
		list1.add(Double.parseDouble((String) event.getNewValue()));
	 

	}

	public List<String> getCityListByState() {
		
		return cityListByState;
	}
	/**
	 * This listener cleans up the State value if a new Country is selected.
	 * 
	 * @param event
	 *            a change event when the value of the country changes.
	 */

	public void countryChangeListener(ValueChangeEvent event) {
		str_VendorCountry=(String) event.getNewValue();
		if (str_VendorCountry != null) {
			str_VendorStates = new ArrayList<String>();
			str_VendorStates.addAll(getVendorservice().stateList(str_VendorCountry));
			 
		} else
			str_VendorStates= new ArrayList<String>();

		cityListByState=new ArrayList<String>();
	}

	/**
	 * This listener cleans up the city value if a new state is selected.
	 * 
	 * @param event
	 *            a change event when the value of the state changes.
	 * @return
	 */
	public List<String> stateChangeListener(ValueChangeEvent event) {
		 
		str_VendorState = (String) event.getNewValue();
		if (str_VendorState!= null) {
		cityListByState = new ArrayList<String>();
		cityListByState.addAll(getVendorservice().cityList1(str_VendorState));
		}
		else
			cityListByState= new ArrayList<String>();

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
		
			return str_VendorStates;
		 

	}

/**
     * Gets a {@code List of cities based on the selected state.
     *
     * @return a list of cities based on selected state, or an empty list if no
     * state is selected.
     */
	public List<String> getStr_VendorCities() {
		 
			return cityListByState;
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
		if(selectedVendor!=null)
		{
		 for (Vendor vendor :selectedVendor) {
	     
			str_VendorStates=new ArrayList<String>();
			str_VendorStates.addAll(getVendorservice().stateList(vendor.getStr_CountryName()));
			cityListByState = new ArrayList<String>();
			 
			cityListByState.addAll(getVendorservice().cityList1(vendor.getStr_StateName()));
		}
	}
		 
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
		if (vendor!= null) {
			getVendorservice().update(vendor);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);

			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

		} else{
			 FacesMessage message = null;
		FacesContext.getCurrentInstance().addMessage(null, message);

		}
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
	 for (VendorServiceDetails service :vendorServiceDetails3){
		 service.setEditable(false);
		 getVendorservice().updateVendorServiceDetails(vendorServiceDetails5);
		 
		}
		
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully"));
		  return null;
	 }
	
	 
	private   List<VendorServiceDetails> vendorServiceDetails3;
	 /**
	  * 
	  * @return list of serviceDetails according to vendor id
	  */
	  
	public List<VendorServiceDetails> getVendorServiceDetails3() {
		//vendorServiceDetails3=new ArrayList<VendorServiceDetails>();
		//Thread.dumpStack();
		
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
		 
 
		vendorServiceDetails1 = new VendorServiceDetails();
		vendorServiceDetails2 = new VendorServiceDetails();
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		str_VendorComments=request.getParameter("limitedtextfield");
		str_AdditionalInfo=request.getParameter("limitedtextfield1");
		Vendor vendor = new Vendor();

		 

		vendor.setBool_IsaCompany(isBool_IsACompany());
		vendor.setBool_IsVendorActive(isBool_IsVendorActive());

		 vendor.setBool_VisibleToPublic(getBool_VisibleToPublic());
		 vendor.setInt_TdsCharge(getInt_TdsCharge());
		 vendor.setStr_AdditionalInfo(str_AdditionalInfo);
		 vendor.setStr_ContactPersonName(getStr_ContactPersonName());
		 vendor.setStr_PanNo(getStr_PanNo());
		 vendor.setStr_ServiceTaxNo(getStr_ServiceTaxNo());
		 vendor.setStr_Website(getStr_Website());
		vendor.setStr_StateName(str_VendorState);
		vendor.setStr_CityName(str_VendorCity);
		vendor.setStr_CountryName(str_VendorCountry);
 
		vendor.setInt_VendorId(getInt_VendorId());
		vendor.setStr_VendorComments(str_VendorComments);
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
		vendor.setInt_ApartmentId(Util.getAppartmentId());
		/*
		 * checks for existing mobile num
		 */
		 Integer vid=getVendorservice().getInt_VendorId(getStr_VendorPhone());
		 System.out.println(vid);
		 if(vid!=null)
		 {
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("This mobile  number already exist!"));
			  
		 return null;
		 }
		 else
		 {
		getVendorservice().addVendor(vendor);
		 
		int vendorId = getVendorservice().getVendorId(str_VendorName);
		System.out.println(vendorId);
		 
		ListIterator itr = list.listIterator();
		ListIterator itr1 = list1.listIterator();
		while (itr.hasNext() || itr1.hasNext()) {
			 
			str_ServiceName = (String) itr.next();
			 int_ServicePrice = (Double) itr1.next();
			 
			 
			System.out.println(str_ServiceName);
			System.out.println(int_ServicePrice);
			vendorServiceDetails1.setStr_ServiceName(str_ServiceName);
			vendorServiceDetails1.setInt_ServicePrice(int_ServicePrice);
			vendorServiceDetails1.setInt_VendorId(vendorId);
			getVendorservice().addServiceDetails(vendorServiceDetails1);
			 
			
		 
		}

		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Vendor Added Successfully!"));

		return "vendorlists.xhtml";
	}
	}
	private WorkOrderCategory workOrderCategory;
	public String saveWorkOrderCategory()
	{
		if(str_VendorCategoryType!=null)
		{
		workOrderCategory=new WorkOrderCategory();
		
		workOrderCategory.setStr_VendorCategoryType(str_VendorCategoryType);
		workOrderCategory.setInt_ApartmentId(Util.getAppartmentId());
		getVendorservice().saveWorkOrderCategory(workOrderCategory);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Added Successfully!"));
		}
		else{
			 FacesMessage message = null;
		FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return "workordercategory.xhtml";
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
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully"));
		return "vendorlists.xhtml";

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
		if(indicate1==false)
		   {   System.out.println("jcvkvcjvj11111111111111111111111111111111111111111111111111");
		   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select an item to delete!"));
				return null;
		   }
		   else{
			   indicate1=false;
	    List<Vendor> entitiesToDelete = new ArrayList<Vendor>();
 
	    for (Vendor vendor :selectedVendor) {
	    	 
	    	if (vendor.getInt_VendorId()!=null) 
	    	{
	            entitiesToDelete.add(vendor);
	        }
	    	
	    }  
System.out.println(entitiesToDelete+"entyt todelete");
	    getVendorservice().deleteVendor1(entitiesToDelete);
	    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Delete Successful!"));
	    return null;
		   }
	}
	 
/**
 * get particular vendor according to vendor id
 */
	public void getVendor1(Integer int_VendorId) {

		vendor = getVendorservice().getVendor(int_VendorId);
		 
		if(vendor!=null)
		{
			str_VendorStates=new ArrayList<String>();
			str_VendorStates.addAll(getVendorservice().stateList(vendor.getStr_CountryName()));
			cityListByState = new ArrayList<String>();
			 
			cityListByState.addAll(getVendorservice().cityList1(vendor.getStr_StateName()));
			vendorServiceDetails3=new ArrayList<VendorServiceDetails>();
			vendorServiceDetails3.addAll(getVendorservice().getVendorServiceDetails(vendor.getInt_VendorId()));
		}
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
	 private boolean isEditable;

	 
	public String editAction(VendorServiceDetails service) {

		 service.setEditable(true);     
        return null;
    }

    public void editar(VendorServiceDetails service){

    	getVendorservice().updateVendorServiceDetails(service);
        setEditable(false);

    }
    
    public String deleteService(VendorServiceDetails service)
    {
    	 
    	getVendorservice().deleteVendorService(service);   
    	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully"));
		return null;
    }  
	public boolean isEditable() {
		return isEditable;
	}
	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}
	public void rowUnSelectListener()
	{ 
		 
		  indicate=false;
		  indicate1=false;
	}
	public  void rowSelectListener( SelectEvent event)
	{ 
		
		 
		  indicate=true;
		  indicate1=true;
	}
	private boolean indicate;
	private boolean indicate1;
	 

	public boolean isIndicate() {
		if(selectedVendor!=null)
		{
		if (selectedVendor.size() >= 2)
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
		   if (selectedVendor.size() >= 2) {
	           
			   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("This operation is applicable when only one item is selected."));
			   
	           return "vendorlists.xhtml";
	       }
		   else if(indicate==false)
	   {   
	   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please select an item to proceed!"));
			return "vendorlists.xhtml";
	   }
	    
	   
	   else
	   {  
		   indicate=true;
		  return "vendorlists.xhtml";
	   }
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return null;
	}
	public WorkOrderCategory getW() {
		return w;
	}
	public void setW(WorkOrderCategory w) {
		this.w = w;
	}
	public boolean isIndicate1() {
		return indicate1;
	}
	public void setIndicate1(boolean indicate1) {
		this.indicate1 = indicate1;
	}
	public VendorServiceDetails getService() {
		return service;
	}

	private WorkOrderCategory w=new WorkOrderCategory();
	public void getWorkOrder1(Integer wid)
	{
		w=getVendorservice().getWorkOrder1(wid);
	}
	private VendorServiceDetails service=new VendorServiceDetails();
	public void getService(Integer sid) {
		service=getVendorservice().getServiceDetails(sid);
		 
	}
	public void setService(VendorServiceDetails service) {
		this.service = service;
	}
	public void editService(VendorServiceDetails service)
	{
		 getVendorservice().updateVendorServiceDetails(service);
		 
	}
}