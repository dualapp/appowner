package com.appowner.dao;

import java.util.Date;
import java.util.List;

import com.appowner.model.Vendor;
import com.appowner.model.VendorCity;
import com.appowner.model.VendorServiceDetails;
import com.appowner.model.WaterPayment;
import com.appowner.model.WaterVendorTransaction;
import com.appowner.model.WorkOrderCategory;

 

public interface VendorDao {
	public void addVendor(Vendor vendor);

	public List<Vendor> vendorList(String str_VendorName, String str_VendorType);
	
	public Vendor getVendor(int  vendor_id);
	
	public void deleteVendor(Vendor vendor);

	 

	public void update(Vendor vendor);

	public List<String> cityList();

	public List<String> countryList();

	public List<String> stateList(String str_VendorCountry);

	public List<String> cityList1(String str_VendorState);

	public void addServiceDetails(VendorServiceDetails vendorServiceDetails1);

	public int getVendorId(String str_VendorName);

	public void update(VendorServiceDetails vendorServiceDetails1);

	public List<VendorServiceDetails> getVendorServiceDetails(int int_VendorId);

	public VendorServiceDetails getServiceDetails(int int_ServiceId);

	public void updateVendorServiceDetails(
			VendorServiceDetails vendorServiceDetails1);

	public List<String> listOfVendorNameByType(String str_VendorType);

	public void saveWaterTransaction(
			WaterVendorTransaction waterVendorTransaction);

	public List<WaterVendorTransaction> getWaterVendortransaction();

	public void deleteVendorTransaction(
			WaterVendorTransaction waterVendortransaction2);

	public WaterVendorTransaction getOneWaterVendorTransaction(int int_TransactionId);

	public void updateWaterVendorTransaction(
			WaterVendorTransaction waterVendortransaction3);

	public void saveWaterVendorPayment(WaterPayment waterPayment);

	public List<WaterPayment> getWaterPaymentList();

	public void deleteWaterpayment(WaterPayment waterPayment);

	public WaterPayment getWaterPayment1(int int_WaterPaymentId);

	public void updateWaterPayment(WaterPayment waterPayment);

	public WaterPayment getSearchVendorByName(String str_VendorName);

	public Vendor getSearchVendorByName1(String str_VendorName);

	public Integer getInt_VendorId(String str_VendorPhone);

	public List<WaterPayment> getSearchByVendortype(String str_VendorType,
			Date date_FromDate, Date date_ToDate);

	public List<String> getStr_VendorTypes();

	public List<String> getVendorNameList();

	public List<Vendor> getVendorListByName(String str_VendorName);

	public List<String> getStr_VendorTypeList();

	public List<WorkOrderCategory> getWorkOrderCategoryList();

	public void saveWorkOrderCategory(WorkOrderCategory workOrderCategory);

	public void deleteVendor1(List<Vendor> entitiesToDelete);

	public void updateWorkOrder(WorkOrderCategory w);

	public void deleteWorkOrder(List<WorkOrderCategory> entitiesToDelete);

	public void deleteVendorService(VendorServiceDetails service);

}
