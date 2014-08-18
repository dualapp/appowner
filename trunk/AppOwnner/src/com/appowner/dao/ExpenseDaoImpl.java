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
import com.appowner.model.Notice;
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;
import com.appowner.model.UserApartment;

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

	@Override
	public List<String> getStr_AssetNameList(String str_AssetCategoryType) {
		String hql="select str_AssetName from Assets where str_assetcat_name=?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_AssetCategoryType).list();
	}

	@Override
	public void saveAssetCategory(AssetCategory assetcategory) {
		 
		getSessionFactory().getCurrentSession().save(assetcategory);
	}

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

	@Override
	public List<ChartOfAccount> getChartOfAccountList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(ChartOfAccount.class).list();
	}

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
}
