package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.AccountingGroup;
import com.appowner.model.AssetCategory;
import com.appowner.model.Assets;
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
		 
		return  getSessionFactory().getCurrentSession().createCriteria(UserApartment.class).setProjection(Projections.property("str_ApartmentName")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAssetCategoryList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(AssetCategory.class).setProjection(Projections.property("str_assetcat_name")).list();
	}

	@Override
	public void addExpenses(Expense expense) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(expense);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expense> getExpenseList() {
		// TODO Auto-generated method stub
		String  query = "{ CALL expenseList() }";
		List<Expense> expense=getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Expense.class)).list();
		return expense;
		//return getSessionFactory().getCurrentSession().createCriteria(Expense.class).list();
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

	@Override
	public List<String> getParkingSlotList() {
		String  query = "{ CALL parkingSpaceList() }";
		
		@SuppressWarnings("unchecked")
		List<String> parkingSpaceList=getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Parking.class)).list();
		System.out.println(parkingSpaceList);
		return parkingSpaceList;
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
		
		return getSessionFactory().getCurrentSession().createCriteria(AssetCategory.class).list();
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
		return getSessionFactory().getCurrentSession().createCriteria(ChartOfAccount.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Character> getCh_AccountGroup() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(AccountingGroup.class).setProjection(Projections.property("ch_Group")).list();
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
		return getSessionFactory().getCurrentSession().createCriteria(Assets.class).list();
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
		return getSessionFactory().getCurrentSession().createCriteria(FacilityNeeded.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getFacilityTypeList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(FacilityNeeded.class).setProjection(Projections.property("str_FacilityName")).list();
	}

	@Override
	public void addPool(Pool pool) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(pool);
	}

	@Override
	public List<Pool> getPoolList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(Pool.class).list();
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
		return getSessionFactory().getCurrentSession().createCriteria(OrganizationLogo.class).setProjection(Projections.property("str_Appartment_Img")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceRequest> getListServiceRequest() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(ServiceRequest.class).list();
	}

	@Override
	public Pool getLatestPolls() {
		// TODO Auto-generated method stub
		//String hql="from Pool WHERE int_PoolId = max(int_PoolId)";
		String hql="from Pool order by int_PoolId desc limit 1,1;";
		 
		return  (Pool) getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assets> getAssetList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(Assets.class).list();
	}
}
