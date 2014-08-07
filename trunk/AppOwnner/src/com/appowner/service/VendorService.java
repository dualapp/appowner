package com.appowner.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.appowner.model.Vendor;
import com.appowner.model.VendorServiceDetails;
import com.appowner.model.WaterPayment;
import com.appowner.model.WaterVendorTransaction;

public interface VendorService {
	public void addVendor(Vendor vendor);

	public List<Vendor> vendorList(String str_VendorName);
	
	public Vendor getVendor(int empid);
	
	public void deleteVendor(Vendor vendor);

	 

	public void update(Vendor vendor);

	public List<String> cityList();

	public List<String> countryList();

	public List<String> stateList();

	public List<String> cityList1(String str_VendorState);

	public void addServiceDetails(VendorServiceDetails vendorServiceDetails1);

	public int getVendorId(String str_VendorName);

	public void update(VendorServiceDetails vendorServiceDetails1);

	public List<VendorServiceDetails> getVendorServiceDetails(int int_VendorId);

	public VendorServiceDetails getServiceDetails(int int_ServiceId);

	public void updateVendorServiceDetails(
			VendorServiceDetails vendorServiceDetails1);

	public List<String> listOfVendorNameByType(
			String str_VendorType);

	public void saveWaterTransaction(
			WaterVendorTransaction waterVendorTransaction);

	public List<WaterVendorTransaction> getWaterVendortransaction();

	public void deleteVendorTransaction(
			WaterVendorTransaction waterVendortransaction2);

	public WaterVendorTransaction getOneWaterVendorTransaction(int int_TransactionId);

	public void updateWaterVendorTransaction(
			WaterVendorTransaction waterVendortransaction3);

	public void saveWaterVendorPayment(WaterPayment waterPayment);

	public Collection<? extends WaterPayment> getWaterPaymentList();

	 
	public void deleteWaterpayment(WaterPayment waterPayment);

	public  WaterPayment getWaterPayment1(int int_WaterPaymentId);

	public void updateWaterPayment(WaterPayment waterPayment);

	public WaterPayment getSearchVendorByName(String str_VendorName);

	public Vendor searchVendorByName1(String str_VendorName);

	public Integer getInt_VendorId(String str_VendorPhone);

	public List<WaterPayment> getSearchByVendortype(
			String str_VendorType, Date date_FromDate, Date date_ToDate);

	public List<String> getStr_VendorTypes();

	public List<String> getVendorNameList();

	public List<Vendor> getVendorListByName(String str_VendorName);
}
