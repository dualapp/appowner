package com.appowner.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.VendorDao;
import com.appowner.model.Vendor;
import com.appowner.model.VendorServiceDetails;
import com.appowner.model.WaterPayment;
import com.appowner.model.WaterVendorTransaction;
import com.appowner.model.WorkOrderCategory;

@Service("VendorService")
@Transactional 
public class VendorServiceImpl  implements VendorService
{
@Autowired
private VendorDao vendordao;
	public VendorDao getVendordao() {
	return vendordao;
}

public void setVendordao(VendorDao vendordao) {
	this.vendordao = vendordao;
}

	@Override
	public void addVendor(Vendor vendor) {
		getVendordao().addVendor(vendor); 
		
	}

	@Override
	public List<Vendor> vendorList(String str_VendorName,String str_VendorType) {
		 
		return getVendordao().vendorList(str_VendorName,str_VendorType);
	}

	@Override
	public Vendor getVendor(int empid) {
		 
		return getVendordao().getVendor(empid);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		getVendordao().deleteVendor(vendor);
		
	}

	@Override
	public void update(Vendor vendor) {
		getVendordao().update(vendor);
		
	}

	 

	@Override
	public List<String> cityList() {
		return getVendordao().cityList();
	}

	@Override
	public List<String> countryList() {
		return getVendordao().countryList();
	}

	@Override
	public List<String> stateList() {
		return getVendordao().stateList();
 	}
 
	 

	@Override
	public List<String> cityList1(String str_VendorState) {
		return getVendordao().cityList1(str_VendorState);
	}

	 

	@Override
	public void addServiceDetails(VendorServiceDetails vendorServiceDetails1) {
		getVendordao().addServiceDetails(vendorServiceDetails1);
	}

	@Override
	public int getVendorId(String str_VendorName) {
		 
		return 	getVendordao().getVendorId(str_VendorName);
	
	}

	@Override
	public void update(VendorServiceDetails vendorServiceDetails1) {
		getVendordao().update( vendorServiceDetails1);
		
	}

	@Override
	public List<VendorServiceDetails> getVendorServiceDetails(int int_VendorId) {
		return getVendordao().getVendorServiceDetails( int_VendorId);
	}

	@Override
	public VendorServiceDetails getServiceDetails(int int_ServiceId) {
		return getVendordao().getServiceDetails(int_ServiceId);
		 
		 
	}

	@Override
	public void updateVendorServiceDetails(
			VendorServiceDetails vendorServiceDetails1) {
		getVendordao().updateVendorServiceDetails(vendorServiceDetails1);
	}

	@Override
	public List<String> listOfVendorNameByType(String str_VendorType) {
		return getVendordao().listOfVendorNameByType(str_VendorType);
		 
	}

	@Override
	public void saveWaterTransaction(
			WaterVendorTransaction waterVendorTransaction) {
		 
		getVendordao().saveWaterTransaction( waterVendorTransaction);
	}

	@Override
	public List<WaterVendorTransaction> getWaterVendortransaction() {
		return getVendordao(). getWaterVendortransaction();
	}

	@Override
	public void deleteVendorTransaction(
			WaterVendorTransaction waterVendortransaction2) {
		getVendordao().deleteVendorTransaction( waterVendortransaction2);
	}

	@Override
	public WaterVendorTransaction getOneWaterVendorTransaction(int int_TransactionId) {
	return	getVendordao().getOneWaterVendorTransaction(int_TransactionId);
		
	}

	@Override
	public void updateWaterVendorTransaction(
			WaterVendorTransaction waterVendortransaction3) {
		getVendordao().updateWaterVendorTransaction(waterVendortransaction3);
		
	}

	@Override
	public void saveWaterVendorPayment(WaterPayment waterPayment) {
		getVendordao().saveWaterVendorPayment(waterPayment) ;
		
	}

	@Override
	public List<WaterPayment> getWaterPaymentList() {
		 return getVendordao().getWaterPaymentList();
	}

	@Override
	public void deleteWaterpayment( WaterPayment waterPayment) {
		 
		  getVendordao().deleteWaterpayment(waterPayment);
	}

	@Override
	public WaterPayment getWaterPayment1(int int_WaterPaymentId) {
		return getVendordao().getWaterPayment1(int_WaterPaymentId);
		
	}

	@Override
	public void updateWaterPayment(WaterPayment waterPayment) {
		getVendordao().updateWaterPayment(waterPayment);
		
	}

	@Override
	public WaterPayment getSearchVendorByName(String str_VendorName) {
		// TODO Auto-generated method stub
		return getVendordao().getSearchVendorByName(str_VendorName);
	}

	@Override
	public Vendor searchVendorByName1(String str_VendorName) {
		return getVendordao().getSearchVendorByName1(str_VendorName);
	}

	@Override
	public Integer getInt_VendorId(String str_VendorPhone) {
		// TODO Auto-generated method stub
		return getVendordao().getInt_VendorId(str_VendorPhone);
	}

	@Override
	public List<WaterPayment> getSearchByVendortype(String str_VendorType,
			Date date_FromDate, Date date_ToDate) {
		// TODO Auto-generated method stub
		return getVendordao().getSearchByVendortype(str_VendorType,date_FromDate, date_ToDate);
	}

	@Override
	public List<String> getStr_VendorTypes() {
		// TODO Auto-generated method stub
		return getVendordao().getStr_VendorTypes();
	}

	@Override
	public List<String> getVendorNameList() {
		// TODO Auto-generated method stub
		return getVendordao().getVendorNameList();
	}

	@Override
	public List<Vendor> getVendorListByName(String str_VendorName) {
		// TODO Auto-generated method stub
		return getVendordao().getVendorListByName(str_VendorName);
	}

	@Override
	public List<String> getStr_VendorTypeList() {
		// TODO Auto-generated method stub
		return getVendordao().getStr_VendorTypeList();
	}

	@Override
	public List<WorkOrderCategory> getWorkOrderCategoryList() {
		// TODO Auto-generated method stub
		return getVendordao().getWorkOrderCategoryList();
	}

	@Override
	public void saveWorkOrderCategory(WorkOrderCategory workOrderCategory) {
		// TODO Auto-generated method stub
		getVendordao().saveWorkOrderCategory(workOrderCategory);
	}

	@Override
	public void deleteVendor1(List<Vendor> entitiesToDelete) {
		// TODO Auto-generated method stub
		getVendordao().deleteVendor1(entitiesToDelete);
	}

	@Override
	public void updateWorkOrder(WorkOrderCategory w) {
		// TODO Auto-generated method stub
		getVendordao().updateWorkOrder( w);
	}

	@Override
	public void deleteWorkOrder(List<WorkOrderCategory> entitiesToDelete) {
		// TODO Auto-generated method stub
		getVendordao().deleteWorkOrder(entitiesToDelete);
	}

	 
}
	 
 