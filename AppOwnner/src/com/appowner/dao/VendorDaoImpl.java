package com.appowner.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Expense;
import com.appowner.model.Parking;
import com.appowner.model.Vendor;
import com.appowner.model.VendorCity;
import com.appowner.model.VendorCountry;
import com.appowner.model.VendorServiceDetails;
import com.appowner.model.VendorState;
import com.appowner.model.WaterPayment;
import com.appowner.model.WaterVendorTransaction;
import com.appowner.model.WorkOrderCategory;
 
@Repository
public class VendorDaoImpl implements VendorDao{
	@Autowired
	private SessionFactory sessionFactory;
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addVendor(Vendor vendor) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(vendor);
	}
	@SuppressWarnings("unchecked")
	public List<Vendor> vendorList(String str_VendorName,String str_VendorType) {
		/*if(str_VendorName!=null)
		{
			String hql="from  Vendor where str_VendorName=?";
			return (List<Vendor>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_VendorName).list();
			
		}*/
		 if(str_VendorType!=null)
		{
			String hql="from  Vendor where str_VendorType=?";
			return (List<Vendor>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_VendorType).list();
			
		}
		return (List<Vendor>) getSessionFactory().getCurrentSession().createCriteria(Vendor.class).list();
	}
	
	public void deleteVendor(Vendor vendor) {
		sessionFactory.getCurrentSession().delete(vendor);
	}
	public void update(Vendor vendor) {
		 
		sessionFactory.getCurrentSession().update(vendor);
	}
	 
	@Override
	public Vendor getVendor(int vendor_id) {
		// TODO Auto-generated method stub
		  return (Vendor) getSessionFactory().getCurrentSession().get(Vendor.class, vendor_id);
	}

	@SuppressWarnings("unchecked")
	 
		@Override
		public List<String> cityList() {
		 
			 List<String> cityList= getSessionFactory().getCurrentSession().createCriteria(VendorCity.class).setProjection(Projections.property("str_CityName")).list();
			  System.out.println("hello");
			  System.out.println( cityList.listIterator().hasNext());
			  return  cityList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> countryList() {
		 
		// String hql=" select str_CityName from VendorCity where str_StateName=str_StateName";
	 
		List<String> countryList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(VendorCountry.class).setProjection(Projections.property("str_CountryName")).list();
		  System.out.println( ( countryList).listIterator().hasNext());
		  return  countryList ;
	}

	@Override
	public List<String> stateList() {

		@SuppressWarnings("unchecked")
		List<String> stateList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(VendorState.class).setProjection(Projections.property("str_StateName")).list();
		  System.out.println( ( stateList).listIterator().hasNext());
		  return  stateList ;
		 
	}

	@Override
	public List<String> cityList1(String str_VendorState) {
		System.out.println(str_VendorState);
		String hql=" select int_stateId from VendorState  where str_StateName=?";
		int StateId=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_VendorState).uniqueResult();
		 
		String hql1="select str_CityName from VendorCity where int_stateId="+StateId;
		@SuppressWarnings("unchecked")
		List<String> cityList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).list();
		System.out.println(cityList);
		return cityList;
		 
	}
 
	@Override
	public void addServiceDetails(
			VendorServiceDetails vendorServiceDetails1) {
		getSessionFactory().getCurrentSession().save(vendorServiceDetails1);
	}

	@Override
	public int getVendorId(String VendorName) {
		System.out.println( VendorName);
		String hql2="select int_VendorId from Vendor where str_VendorName=?" ;
		int id=(Integer) getSessionFactory().getCurrentSession().createQuery( hql2).setParameter(0,VendorName).uniqueResult();
     return id;
		
	}

	@Override
	public void update(VendorServiceDetails vendorServiceDetails1) {
		System.out.println(vendorServiceDetails1);
		sessionFactory.getCurrentSession().update(vendorServiceDetails1);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VendorServiceDetails> getVendorServiceDetails(int int_VendorId) {
		 String hql3="from VendorServiceDetails where int_VendorId=?";
		List<VendorServiceDetails> v1= (List<VendorServiceDetails>) getSessionFactory().getCurrentSession().createQuery(hql3).setParameter(0, int_VendorId).list();
		System.out.println(v1);
		return v1; 
		
		 
	}

	@Override
	public VendorServiceDetails getServiceDetails(int int_ServiceId) {
	return	(VendorServiceDetails) getSessionFactory().getCurrentSession().get(VendorServiceDetails.class, int_ServiceId);
		 
	}

	@Override
	public void updateVendorServiceDetails(
			VendorServiceDetails vendorServiceDetails1) {
		sessionFactory.getCurrentSession().update(vendorServiceDetails1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listOfVendorNameByType(String str_VendorType) {
		String hql4="select str_VendorName from Vendor where str_VendorType=?";
		List<String> VendorNames=sessionFactory.getCurrentSession().createQuery(hql4).setParameter(0, str_VendorType).list();
		System.out.println(VendorNames);
		return VendorNames;
		
	}

	@Override
	public void saveWaterTransaction(
			WaterVendorTransaction waterVendorTransaction) {
		sessionFactory.getCurrentSession().save(waterVendorTransaction);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaterVendorTransaction> getWaterVendortransaction() {
		 
		return  sessionFactory.getCurrentSession().createCriteria(WaterVendorTransaction.class).list();
	}

	@Override
	public void deleteVendorTransaction(
			WaterVendorTransaction waterVendortransaction2) {
		 
		sessionFactory.getCurrentSession().delete(waterVendortransaction2);
	}

	@Override
	public WaterVendorTransaction getOneWaterVendorTransaction(int int_TransactionId) {
		System.out.println("test");
		System.out.println(int_TransactionId);
		return (WaterVendorTransaction) sessionFactory.getCurrentSession().get(WaterVendorTransaction.class,int_TransactionId);
		
	}

	@Override
	public void updateWaterVendorTransaction(
			WaterVendorTransaction waterVendortransaction3) {
		sessionFactory.getCurrentSession().update(waterVendortransaction3);
		
	}

	@Override
	public void saveWaterVendorPayment(WaterPayment waterPayment) {
		sessionFactory.getCurrentSession().save(waterPayment);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaterPayment> getWaterPaymentList() {
		return sessionFactory.getCurrentSession().createCriteria(WaterPayment.class).list();
	}

	@Override
	public void deleteWaterpayment(WaterPayment waterPayment) {
		sessionFactory.getCurrentSession().delete(waterPayment);
	}

	@Override
	public WaterPayment getWaterPayment1(int int_WaterPaymentId) {
		return (WaterPayment) sessionFactory.getCurrentSession().get(WaterPayment.class,int_WaterPaymentId);
	}

	@Override
	public void updateWaterPayment(WaterPayment waterPayment) {
		sessionFactory.getCurrentSession().update(waterPayment);
	}

	@Override
	public WaterPayment getSearchVendorByName(String str_VendorName) {
		  String hql6="from WaterPayment where str_VendorName=?";
		  
		return (WaterPayment) sessionFactory.getCurrentSession().createQuery(hql6).setParameter(0, str_VendorName).uniqueResult();
	}

	@Override
	public Vendor getSearchVendorByName1(String str_VendorName) {
		 String hql7="from Vendor where str_VendorName=?";
		return (Vendor) sessionFactory.getCurrentSession().createQuery(hql7).setParameter(0, str_VendorName).uniqueResult();
	}

	@Override
	public Integer getInt_VendorId(String str_VendorPhone) {
		 String hql8="select int_VendorId from Vendor where str_VendorPhone=?";
		return (Integer) sessionFactory.getCurrentSession().createQuery(hql8).setParameter(0, str_VendorPhone).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaterPayment> getSearchByVendortype(String str_VendorType,
			Date date_FromDate, Date date_ToDate) {
		if( date_FromDate==null||date_ToDate==null||str_VendorType==null)
		 
			return  sessionFactory.getCurrentSession().createCriteria(WaterPayment.class).list();	
		 
		List<WaterPayment> l=(List<WaterPayment>) sessionFactory.getCurrentSession().createCriteria(WaterPayment.class).add(Restrictions.between("date_Date", date_FromDate,date_ToDate)).add(Restrictions.eq("str_VendorType", str_VendorType)).list(); 
		 
		return  l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_VendorTypes() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Vendor.class).setProjection(Projections.property("str_VendorType")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getVendorNameList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Vendor.class).setProjection(Projections.property("str_VendorName")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> getVendorListByName(String str_VendorName) {
		/*String  query = "{ CALL vendorListByName() }";
		return sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Vendor.class)).list();
	*/
		String hql="from Vendor where str_VendorName=?";
	 return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,str_VendorName).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_VendorTypeList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(WorkOrderCategory.class).setProjection(Projections.property("str_VendorCategoryType")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkOrderCategory> getWorkOrderCategoryList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(WorkOrderCategory.class).list();
	}

	@Override
	public void saveWorkOrderCategory(WorkOrderCategory workOrderCategory) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(workOrderCategory);
	}

	 
	 
}
