package com.appowner.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.AccountingGroup;
import com.appowner.model.AddTemplateMessage;
import com.appowner.model.AssetCategory;
import com.appowner.model.Assets;
import com.appowner.model.BroadCastMessage1;
import com.appowner.model.ChartOfAccount;
import com.appowner.model.Expense;
import com.appowner.model.FacilityNeeded;
import com.appowner.model.MessageTemplateMaster;
import com.appowner.model.MessageType;
import com.appowner.model.OrganizationLogo;
import com.appowner.model.Parking;
import com.appowner.model.Pool;
import com.appowner.model.ServiceRequest;
import com.appowner.model.UserApartment;
import com.appowner.model.Vote;
import com.appowner.model.WaterPayment;
import com.appowner.util.Util;

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
		String hql="select str_assetcat_name from AssetCategory where int_AppartmentId IN ('0',"+Util.getAppartmentId()+')';
		return getSessionFactory().getCurrentSession().createQuery(hql).list();
	}

	@Override
	public void addExpenses(Expense expense) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(expense);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expense> getExpenseList(String query) {
System.out.println(query+"queryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		if(query.isEmpty())
		{
			List<Expense> elist= getSessionFactory().getCurrentSession().createQuery("from Expense where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).list();
			
			System.out.println(query+"queryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
			return elist;
		}
		else
		{
			String hql="from Expense where int_AppartmentId=? and "+query;
			List<Expense> elist1= getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, Util.getAppartmentId()).list();
			System.out.println(hql+"queryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy1");
			return elist1;
		}
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

		List<Parking>  plist= getSessionFactory().getCurrentSession().createQuery("from Parking where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).list();
		Collections.sort(plist);
		return plist;
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
		String hql="select str_BlockName from UserBlocks where int_ApartmentId=?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, appartmentId).list();
	}

	@Override
	public void addAsset(Assets ac) {
		getSessionFactory().getCurrentSession().save(ac);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_AssetNameList(String str_AssetCategoryType) {
		String hql="select str_AssetName from Assets where str_assetcat_name=? and int_AppartmentId=?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_AssetCategoryType).setParameter(1, Util.getAppartmentId()).list();
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

		List<AssetCategory> alist= getSessionFactory().getCurrentSession().createQuery("from AssetCategory where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).setCacheable(true).list();
		Collections.sort(alist);
       return alist;
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
		return getSessionFactory().getCurrentSession().createQuery("from ChartOfAccount where int_ApartmentId=?").setParameter(0, Util.getAppartmentId()).setCacheable(true).list();
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
		List<Assets> alist = getSessionFactory().getCurrentSession().createQuery("from Assets where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).setCacheable(true).list();
		
		Collections.sort(alist);
		return alist;
	}

	@Override
	public void addFacility(FacilityNeeded facilityNeeded) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(facilityNeeded);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacilityNeeded> getFacilityNeededList(int firstRow, int rowPerPage) {

		System.out.println(firstRow+"100");
		return getSessionFactory().getCurrentSession().createQuery("from FacilityNeeded where int_ApartmentId=?").setParameter(0, Util.getAppartmentId()).setFirstResult(firstRow).setMaxResults(rowPerPage).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getFacilityTypeList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("select str_FacilityName from FacilityNeeded where int_ApartmentId=?").setParameter(0, Util.getAppartmentId()).list();
	}

	@Override
	public void addPool(Pool pool) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(pool);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pool> getPoolList(Date date_FromDate, Date date_ToDate, String str_Status) {
		
		if( date_FromDate==null && date_ToDate==null && str_Status==null)
		{
			
			 
			List<Pool> plist= getSessionFactory().getCurrentSession().createQuery("from Pool where int_OrganizationId=?").setParameter(0, Util.getAppartmentId()).list();
		 Collections.sort(plist);	
		 return plist;
		 }
		else if(date_FromDate==null && date_ToDate==null && !(str_Status.equalsIgnoreCase("All")))
		{
			List<Pool> plist1= getSessionFactory().getCurrentSession().createQuery("from Pool where int_OrganizationId=? and str_Status=?").setParameter(0, Util.getAppartmentId()).setParameter(1, str_Status).list();
			 Collections.sort(plist1);	
			 return plist1;
		}
		else if(date_FromDate!=null && date_ToDate!=null && str_Status==null)
		{
			List<Pool> plist3 =sessionFactory.getCurrentSession().createCriteria(Pool.class).setCacheable(true).add(Restrictions.between("dat_StartDate", date_FromDate,date_ToDate)).add(Restrictions.eq("int_OrganizationId", Util.getAppartmentId())).list(); 
			// TODO Auto-generated method stub
			Collections.sort(plist3);	
			 return plist3;
		}
		else if(date_FromDate!=null && date_ToDate!=null && str_Status.equalsIgnoreCase("All"))
		{
			List<Pool> plist5 =sessionFactory.getCurrentSession().createCriteria(Pool.class).setCacheable(true).add(Restrictions.between("dat_StartDate", date_FromDate,date_ToDate)).add(Restrictions.eq("int_OrganizationId", Util.getAppartmentId())).list(); 
			// TODO Auto-generated method stub
			Collections.sort(plist5);	
			 return plist5;
		}
		else if(date_FromDate==null && date_ToDate==null && str_Status.equalsIgnoreCase("All"))
		{
			 
			List<Pool> plist4 =sessionFactory.getCurrentSession().createQuery("from Pool where int_OrganizationId=?").setParameter(0, Util.getAppartmentId()).list();
			// TODO Auto-generated method stub
			Collections.sort(plist4);	
			 return plist4;
		}
	else
	{
		 
		List<Pool> plist2 =sessionFactory.getCurrentSession().createCriteria(Pool.class).setCacheable(true).add(Restrictions.between("dat_StartDate", date_FromDate,date_ToDate)).add(Restrictions.eq("int_OrganizationId", Util.getAppartmentId())).add(Restrictions.between("dat_StartDate", date_FromDate,date_ToDate)).add(Restrictions.eq("str_Status", str_Status)).list(); 
		// TODO Auto-generated method stub
		Collections.sort(plist2);	
		 return plist2;
	}
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
		String hql="select count(*) from Vote  where int_PoolId=? and int_OrganizationId=?";
		return (Long) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_PoolId).setParameter(1, Util.getAppartmentId()).uniqueResult();
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
		return getSessionFactory().getCurrentSession().createQuery("from ServiceRequest where int_ApartmentId=?").setParameter(0, Util.getAppartmentId()).setCacheable(true).list();
	}

	@Override
	public Pool getLatestPolls() {
		// TODO Auto-generated method stub
		String hql=" select max(int_PoolId) from Pool where int_OrganizationId=? and str_Status=?";
		//String hql="from Pool order by int_PoolId desc limit 1,1;";
		Integer id=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, Util.getAppartmentId()).setParameter(1, "Open").uniqueResult();

		return  (Pool) getSessionFactory().getCurrentSession().createQuery("from Pool where int_PoolId=?").setParameter(0, id).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assets> getAssetList(String  query) 
			{
		if(query=="")
		{
			List<Assets> alist= getSessionFactory().getCurrentSession().createQuery("from Assets where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).setCacheable(true).list();
			Collections.sort(alist);
			return alist;
		}
		 
		else
		{
			String hql="from Assets where int_AppartmentId=? and "+query; 
			List<Assets> alist1= getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, Util.getAppartmentId()).setCacheable(true).list();
		Collections.sort(alist1);
		return alist1;
		}
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



	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().createCriteria(FacilityNeeded.class).setProjection(Projections.rowCount()).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMessageTempTypeList() {
		// TODO Auto-generated method stub
		System.out.println(sessionFactory.getCurrentSession().createCriteria(MessageTemplateMaster.class).setCacheable(true).setProjection(Projections.property("str_MessageTempType")).list()+"kalpana");
		return sessionFactory.getCurrentSession().createCriteria(MessageTemplateMaster.class).setCacheable(true).setProjection(Projections.property("str_MessageTempType")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageType> getMessageTypeList() {
		// TODO Auto-generated method stub
		System.out.println(sessionFactory.getCurrentSession().createCriteria(MessageType.class).setCacheable(true).list()+"kalpana1");
		return sessionFactory.getCurrentSession().createCriteria(MessageType.class).setCacheable(true).list();
	}

	@Override
	public void addBroadCastMessage(BroadCastMessage1 broadCastMessage) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(broadCastMessage);
	}

	@Override
	public String getSubject(String str_MessageType) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_Subject from AddTemplateMessage where str_MessageType=?").setParameter(0, str_MessageType).uniqueResult();
	}

	@Override
	public void addTemplateMessage(AddTemplateMessage atm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(atm);
	}

	@Override
	public Integer getInt_MessageTypeId(String str_MessageType) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().createQuery("select int_MessageTypeId from MessageType where str_MessageType=?").setParameter(0, str_MessageType).uniqueResult();

	}

	@Override
	public String getStr_Venue(Integer int_MessageTypeId) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_Venue from AddTemplateMessage where int_MessageTypeId=?").setParameter(0, int_MessageTypeId).uniqueResult();

	}

	@Override
	public String getTextLogo(Integer appartmentId) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_TextLogo from OrganizationLogo where int_AppartmentId=?").setParameter(0, appartmentId).uniqueResult();
	}

	@Override
	public String organizationLogo(Integer appartmentId) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_Appartment_Logo from OrganizationLogo where int_AppartmentId=?").setParameter(0, appartmentId).uniqueResult();
	}

	@Override
	public String getAppartmentImg(Integer appartmentId) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_Appartment_Img from OrganizationLogo where int_AppartmentId=?").setParameter(0, appartmentId).uniqueResult();
	}

	@Override
	public void updateAppartmentImg(String path1) {
		// TODO Auto-generated method stub
		Integer id=(Integer) sessionFactory.getCurrentSession().createQuery("select int_OthersInfoId from OrganizationLogo where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).uniqueResult();


		OrganizationLogo ol=new OrganizationLogo();

		ol=(OrganizationLogo) sessionFactory.getCurrentSession().createQuery("from OrganizationLogo where int_OthersInfoId=?").setParameter(0, id).uniqueResult();
		if(ol!=null)
		{
			ol.setStr_Appartment_Img(path1);
			sessionFactory.getCurrentSession().saveOrUpdate(ol);
		}
	}

	@Override
	public void updateOrganizationLogo(String path) {
		// TODO Auto-generated method stubInteger id=(Integer) sessionFactory.getCurrentSession().createQuery("select int_OthersInfoId from OrganizationLogo where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).uniqueResult();

		Integer id=(Integer) sessionFactory.getCurrentSession().createQuery("select int_OthersInfoId from OrganizationLogo where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).uniqueResult();
		OrganizationLogo ol=new OrganizationLogo();

		ol=(OrganizationLogo) sessionFactory.getCurrentSession().createQuery("from OrganizationLogo where int_OthersInfoId=?").setParameter(0, id).uniqueResult();
		if(ol!=null)
		{
			ol.setStr_Appartment_Logo(path);

			sessionFactory.getCurrentSession().saveOrUpdate(ol);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_AccountNameList() {
		// TODO Auto-generated method stub
		String hql="select str_AccountName from ChartOfAccount where str_AccountType IN ('Cash', 'Bank') and int_ApartmentId IN ('0',"+Util.getAppartmentId()+')';
		return (List<String>) sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<FacilityNeeded> getFacilityNeededList() {
		// TODO Auto-generated method stub
		List<FacilityNeeded> flist= sessionFactory.getCurrentSession().createQuery("from FacilityNeeded where int_ApartmentId=?").setParameter(0, Util.getAppartmentId()).list();
		 Collections.sort(flist);
		 return flist;
	}

	@Override
	public void updateAssetImage(String path3, Integer assetId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("update Assets set str_AssetImg=?  where int_asset_id=?").setParameter(0, path3).setParameter(1, assetId).executeUpdate();
	}


	@Override
	public void updateStatusOfEstimate(String str_ExpenseId, String str_Status) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("update Expense set str_Status=?  where str_ExpenseId=?").setParameter(0, str_Status).setParameter(1, str_ExpenseId).executeUpdate();

	}

	@Override
	public String getAssetImg(Integer int_asset_id) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_AssetImg from Assets where int_asset_id=?").setParameter(0, int_asset_id).uniqueResult();
	}

	@Override
	public String getAdditionalInfo(Integer int_asset_id) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_AdditionalInfo from Assets where int_asset_id=?").setParameter(0, int_asset_id).uniqueResult();
	}

	@Override
	public List<String> getListChoice(Integer int_PoolId) {
		// TODO Auto-generated method stub
		return (List<String>) sessionFactory.getCurrentSession().createQuery("select str_Choise1,str_Choise2,str_Choise3 from Pool where int_PoolId=?").setParameter(0, int_PoolId).list();
	}

	@Override
	public List<String> getEmailIds(Integer appartmentId, String recipients) {
		// TODO Auto-generated method stub
		if(recipients.equalsIgnoreCase("Admin and Committees"))
		{
			List< Integer> uid=sessionFactory.getCurrentSession().createQuery("select int_UserId from CommiteeMember where int_ApartmentId=?").setParameter(0,Util.getAppartmentId()).list();
			ListIterator itr=uid.listIterator();
			List<String> emails=new ArrayList();
			while(itr.hasNext())
			{
				Integer id=(Integer) itr.next();
				String email=(String) sessionFactory.getCurrentSession().createQuery("select str_Email from User where int_UserId=?").setParameter(0, id).uniqueResult();
				emails.add(email);

			}
			return  emails;
		}
		else

			return sessionFactory.getCurrentSession().createQuery("select str_Email from User where int_ApartmentId=?").setParameter(0, appartmentId).list();
	}

	@Override
	public OrganizationLogo getOrganizationDetails() {
		// TODO Auto-generated method stub
		return (OrganizationLogo) sessionFactory.getCurrentSession().createQuery("from OrganizationLogo where int_AppartmentId=?").setParameter(0, Util.getAppartmentId()).uniqueResult();
	}

	@Override
	public String checkStatus(String str_ExpenseId) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_Status from Expense where str_ExpenseId=?").setParameter(0, str_ExpenseId).uniqueResult();
	}

	@Override
	public FacilityNeeded getOneFacilityNeeded(Integer fid) {
		// TODO Auto-generated method stub
		return (FacilityNeeded) sessionFactory.getCurrentSession().get(FacilityNeeded.class, fid);
	}

	@Override
	public Parking getOneParking(Integer pid) {
		// TODO Auto-generated method stub
		return (Parking) sessionFactory.getCurrentSession().get(Parking.class, pid);
	}

	@Override
	public AssetCategory getAssetCategory1(Integer assetCatId) {
		// TODO Auto-generated method stub
		return (AssetCategory) sessionFactory.getCurrentSession().get(AssetCategory.class, assetCatId);
	}

	 

	@Override
	public String getStr_Document_Upload(Integer appartmentId) {
		// TODO Auto-generated method stub
		  return (String) sessionFactory.getCurrentSession().createQuery("select str_Document_Upload from OrganizationLogo where int_AppartmentId=?").setParameter(0, appartmentId).uniqueResult();
	}

	@Override
	public void updateOrganizationDocument(String path2) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("update OrganizationLogo set str_Document_Upload=? where int_AppartmentId=?").setParameter(0, path2).setParameter(1, Util.getAppartmentId()).executeUpdate();
	}

	@Override
	public Assets getOneAssets(Integer aid) {
		// TODO Auto-generated method stub
		return (Assets) sessionFactory.getCurrentSession().get(Assets.class, aid);
	}

	@Override
	public String checkStatusOfPoll(Integer int_PoolId) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createQuery("select str_Status From Pool where int_PoolId=?").setParameter(0, int_PoolId).uniqueResult();
	}

	@Override
	public void updateStatusOfPoll(Integer int_PoolId, String str_Status) {
		// TODO Auto-generated method stub
	String hql="update Pool set str_Status=? where int_PoolId=?"; 
		sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,str_Status).setParameter(1, int_PoolId).executeUpdate();
	}
}
