package com.appowner.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.AccountingGroup;
import com.appowner.model.AssetCategory;
import com.appowner.model.Assets;
import com.appowner.model.BookAFacility;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.Expense;
import com.appowner.model.FacilityNeeded;
import com.appowner.model.Notice;
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.UserApartment;
import com.appowner.model.Vote;

@Repository
public class ExpenseDaoImpl implements ExpenseDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getOrgationNameList() {
		 
		return  getSessionFactory().getCurrentSession().createCriteria(UserApartment.class).setCacheable(true).setProjection(Projections.property("str_ApartmentName")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAssetCategoryList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(AssetCategory.class).setCacheable(true).setProjection(Projections.property("str_assetcat_name")).list();
	}

	@Override
	public void addExpenses(Expense expense) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(expense);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expense> getExpenseList(String str_AssetName, String str_AssetCategoryType, String str_ExpenseCategory, String str_ExcepenseType, Integer int_ApartmentId) {
		// TODO Auto-generated method stub
		/*String  query = "{ CALL expenseList() }";
		List<Expense> expense=getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Expense.class)).list();
		return expense;*/
		
		if( str_AssetName!=null&&str_AssetCategoryType!=null&&str_ExpenseCategory!=null&&str_ExcepenseType!=null&&int_ApartmentId!=null)
		{
			//pending
		}
		return getSessionFactory().getCurrentSession().createCriteria(Expense.class).setCacheable(true).list();
	}

	@Override
	public Expense getOneExpense(String str_ExpenseId) {
		// TODO Auto-generated method stub
		return (Expense) getSessionFactory().getCurrentSession().get(Expense.class, str_ExpenseId);
	}

	@Override
	public void updateOneExpense(Expense expense) {
		getSessionFactory().getCurrentSession().update(expense);
		
	}

	@Override
	public void deleteOneExpense(Expense expense) {
		getSessionFactory().getCurrentSession().delete(expense);
	}

	@Override
	public void saveParking(Parking parking) {
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		getSessionFactory().getCurrentSession().save(parking);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parking> getParkingSlotList() {
		String  query = "{ CALL parkingSpaceList() }";
		
		 
		/*List<String> parkingSpaceList=getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Parking.class)).list();
		System.out.println(parkingSpaceList);*/
		return getSessionFactory().getCurrentSession().createCriteria(Parking.class).setCacheable(true).list();
	}

	@Override
	public void addOrganizationLogo(OrganizationLogo ol) {
		getSessionFactory().getCurrentSession().save(ol);
		
	}

	@Override
	public void deleteParkingSlot(Parking p) {
		getSessionFactory().getCurrentSession().delete(p);
		
	}

	@Override
	public Integer getLogoId(Integer int_AppartmentId) {
		String hql="select int_OthersInfoId from OrganizationLogo where int_AppartmentId=?";
		return (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_AppartmentId).uniqueResult();
	}

	@Override
	public Integer getInt_AppartmentId(String str_UserName) {
		String hql="select int_ApartmentId from User where str_Username=?";
		return (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_UserName).uniqueResult();
	}

	@Override
	public void updateLogo(OrganizationLogo ol) {
		getSessionFactory().getCurrentSession().update(ol);
		
	}

	@Override
	public OrganizationLogo getOrganizationLogo(Integer appartmentId) {
		// TODO Auto-generated method stub
		String hql="from  OrganizationLogo where int_AppartmentId=?";
		return (OrganizationLogo) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, appartmentId).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_BlockListByAppartmentName(Integer appartmentId) {
		String hql="select str_Block from User  where int_ApartmentId=?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, appartmentId).list();
	}

	@Override
	public void addAsset(Assets ac) {
		getSessionFactory().getCurrentSession().save(ac);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_AssetNameList(String str_AssetCategoryType) {
		String hql="select str_AssetName from Assets where str_assetcat_name=?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_AssetCategoryType).list();
	}

	@Override
	public void saveAssetCategory(AssetCategory assetcategory) {
		 
		getSessionFactory().getCurrentSession().save(assetcategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AssetCategory> getAssetCategoryList1() {
		/*String  query = "{ CALL assetCategoryList() }";
		List<Expense> expense=getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(AssetCategory.class)).list();
		*/
		
		return getSessionFactory().getCurrentSession().createCriteria(AssetCategory.class).setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAccountTypeList() {
		return null;
		// TODO Auto-generated method stub
//		return getSessionFactory().getCurrentSession().createCriteria(AccountingGroup.class).setProjection(Projections.property("str_Acct_GroupName")).list();
	}

	@Override
	public void saveChartOfAccount(ChartOfAccount chartOfAccount) {
		getSessionFactory().getCurrentSession().save(chartOfAccount);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChartOfAccount> getChartOfAccountList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(ChartOfAccount.class).setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Character> getCh_AccountGroup() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(AccountingGroup.class).setCacheable(true).setProjection(Projections.property("ch_Group")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAccountTypeList(Character l) {
		String hql="select str_Acct_GroupName from  AccountingGroup where ch_Group=?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, l).list();
	 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assets> getAssetsList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(Assets.class).setCacheable(true).list();
	}

	@Override
	public void addFacility(FacilityNeeded facilityNeeded) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(facilityNeeded);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacilityNeeded> getFacilityNeededList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(FacilityNeeded.class).setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getFacilityTypeList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(FacilityNeeded.class).setCacheable(true).setProjection(Projections.property("str_FacilityName")).list();
	}

	@Override
	public void addPool(Pool pool) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(pool);
	}

	@Override
	public List<Pool> getPoolList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(Pool.class).setCacheable(true).list();
	}

	@Override
	public Pool getOnePool(Integer int_PoolId) {
		// TODO Auto-generated method stub
		return (Pool) getSessionFactory().getCurrentSession().get(Pool.class, int_PoolId);
	}

	@Override
	public Integer addVote(Vote vote) {
		// TODO Auto-generated method stub
		return (Integer) getSessionFactory().getCurrentSession().save(vote);
	}

	@Override
	public void UpdatePool(Pool pool) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(pool);
	}

	@Override
	public Long getChoise1Vote(String  str_Choise1,Integer int_PoolId) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Vote  where str_Choise=? and int_PoolId=?";
		return (Long) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Choise1).setParameter(1,int_PoolId).uniqueResult();
		 
	}

	@Override
	public Long  getChoise2Vote(String  str_Choise2,Integer int_PoolId) {
		String hql="select count(*) from Vote  where str_Choise=? and int_PoolId=?";
		return (Long) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Choise2).setParameter(1, int_PoolId).uniqueResult();
	 
	}

	@Override
	public Long getChoise3Vote(String  str_Choise3,Integer int_PoolId) {
		String hql="select count(*) from Vote  where str_Choise=? and int_PoolId=?";
		return   (Long) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Choise3).setParameter(1, int_PoolId).uniqueResult();
		 
	}

	@Override
	public void updateStatusOfServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(serviceRequest);
	}

	@Override
	public ServiceRequest getOneServiceRequest(Integer serviceRequestId) {
		// TODO Auto-generated method stub
		
		return (ServiceRequest) getSessionFactory().getCurrentSession().get(ServiceRequest.class,serviceRequestId);
	}

	@Override
	public void updateOneServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(serviceRequest);
	}

	@Override
	public void deleteOneServiceRequest(ServiceRequest servicerequest1) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(servicerequest1);
	}

	@Override
	public Long getTotalVote(Integer int_PoolId) {
		String hql="select count(*) from Vote  where int_PoolId=?";
		return (Long) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_PoolId).uniqueResult();
	}

	@Override
	public Integer isVoted( Integer int_UserId,Integer int_PoolId) {
		String hql="select int_VoteId from Vote where int_UserId=? and int_PoolId=?";
		return   (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_UserId).setParameter(1, int_PoolId).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getOrganizationImages() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(OrganizationLogo.class).setCacheable(true).setProjection(Projections.property("str_Appartment_Img")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceRequest> getListServiceRequest() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(ServiceRequest.class).setCacheable(true).list();
	}

	@Override
	public Pool getLatestPolls() {
		// TODO Auto-generated method stub
		String hql=" select max(int_PoolId) from Pool";
		//String hql="from Pool order by int_PoolId desc limit 1,1;";
		Integer id=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
		 
		return  (Pool) getSessionFactory().getCurrentSession().get(Pool.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assets> getAssetList(String str_AssetCategoryType,
			String str_Block, Integer int_ApartmentId) 
			{
		if(str_AssetCategoryType!=null&&str_Block!=null&&int_ApartmentId!=null)
		{
			String hql="from Assets where str_assetcat_name=? AND str_Block=? AND int_AppartmentId=?";
			return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_AssetCategoryType).setParameter(1, str_Block).setParameter(2, int_ApartmentId).list();
		}
		return getSessionFactory().getCurrentSession().createCriteria(Assets.class).setCacheable(true).list();
	}

	@Override
	public void deleteSelectedExpenses(List<Expense> entitiesToDelete) {
		ListIterator itr=entitiesToDelete.listIterator();
		while(itr.hasNext())
		{
			Expense ex=(Expense) itr.next();
		sessionFactory.getCurrentSession().delete(ex);
	}
}

	@Override
	public void deleteOnePoll(Pool onePoll) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(onePoll);
	}

	@Override
	public void deleteOnefacility(List<Assets> entitiesToDelete) {
		ListIterator itr=entitiesToDelete.listIterator();
		while(itr.hasNext())
		{
			Assets ex=(Assets) itr.next();
		sessionFactory.getCurrentSession().delete(ex);
		}
		
	}

	@Override
	public void updateOneasset(Assets asset) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(asset);
	}

	@Override
	public void updateParkingSpace(Parking p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update( p);
	}

	@Override
	public void deleteParkingSpace(List<Parking> entitiesToDelete) {
		ListIterator itr=entitiesToDelete.listIterator();
		while(itr.hasNext())
		{
			Parking ex=(Parking) itr.next();
		sessionFactory.getCurrentSession().delete(ex);
		
	}
}

	@Override
	public void delectAssetsCategory(List<AssetCategory> entitiesToDelete) {
		ListIterator itr=entitiesToDelete.listIterator();
		while(itr.hasNext())
		{
			AssetCategory ex=(AssetCategory) itr.next();
		sessionFactory.getCurrentSession().delete(ex);
		
	}
	}

	@Override
	public void updateAssetCategory(AssetCategory ac) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(ac);
	}

	@Override
	public void updateFacility(FacilityNeeded fn1) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(fn1);
	}

	@Override
	public void deletefacilityNeeded(List<FacilityNeeded> entitiesToDelete) {
		// TODO Auto-generated method stub
		ListIterator itr=entitiesToDelete.listIterator();
		while(itr.hasNext())
		{
			FacilityNeeded fn=(FacilityNeeded) itr.next();
		sessionFactory.getCurrentSession().delete(fn);
		
	}
	}
}