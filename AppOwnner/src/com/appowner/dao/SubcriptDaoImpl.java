package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Company;
import com.appowner.model.GroupMember;
import com.appowner.model.Mail;
import com.appowner.model.Option;
import com.appowner.model.Subcript;
import com.appowner.model.User;
import com.appowner.model.UserBlocks;
import com.appowner.model.UserExtraInfo;
import com.appowner.model.agency_information;
import com.appowner.model.cls_Contact;
import com.appowner.model.cls_Feedback;
import com.appowner.model.cls_Group;
import com.appowner.model.cls_PersonCity;
import com.appowner.model.cls_PersonState;
import com.appowner.model.cls_hobby;
import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

/**
 * @author mukesh
 *
 */
@Repository
public class SubcriptDaoImpl implements SubcriptDao {

	@Autowired
	private SessionFactory sessionFactory;
	private String subscriptname;
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addUsers(Subcript usr) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(usr);
		
	}
	@Override
	public void addOptions(Subcript usr1) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(usr1);
		
	}
	public void update(Subcript usr) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().update(usr);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Subcript> listSubcripts() {
		return (List<Subcript>)getSessionFactory().getCurrentSession().createCriteria(Subcript.class).list();
	}

	

	@Override
	public Subcript getSubcript(int subcriptID) {
		
		return(Subcript)getSessionFactory().getCurrentSession().get(Subcript.class,subcriptID);
	}

	public void save(Subcript usr1) {
		// TODO Auto-generated method stub
		
	}

	public void addUsers1(Option usr1) {
		getSessionFactory().getCurrentSession().save(usr1);

		
	}

	@Override
	public void addSubcriptions(Cls_SubcriptionOption sop) {
		getSessionFactory().getCurrentSession().save(sop);
		
	}

	@Override
	public void addSubcriptions(Subcript sop) {
		getSessionFactory().getCurrentSession().save(sop);
		
	}

	@Override
	public void addService(Cls_SubcriptionOption s) {
		 
		getSessionFactory().getCurrentSession().save(s);
	}

	@Override
	public int getSubcriptID(String subscriptname) {
		System.out.println(subscriptname);
		String hql3="select subcriptID from Subcript where subscriptname=?";
		 
		return (int) getSessionFactory().getCurrentSession().createQuery(hql3).setParameter(0, subscriptname).uniqueResult();
	}

	 
	@Override
	public String getOptionName(String optionName) {
		System.out.println(optionName);
		String hql3="select int_optionId from Subcript where optionName=?";
		 
		return (String) getSessionFactory().getCurrentSession().createQuery(hql3).setParameter(0, optionName).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getOptionNames() {
		
		return getSessionFactory().getCurrentSession().createCriteria( Option.class).setProjection(Projections.property("optionName")).list();
	}

	@Override
	public Integer getInt_OptionId(String optionName) {
		String hql4="select int_optionId from Option where optionName=?";
		return  (Integer) getSessionFactory().getCurrentSession().createQuery(hql4).setParameter(0, optionName).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getSubscriptnames() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(Subcript.class).setProjection(Projections.property("subscriptname")).list();
	}

	public Integer getInt_OptionId1(String optionName) {
		return getInt_OptionId(optionName);
	}
	
	
	

	@Override
	public Integer getSubscriptname1(String subscriptname) {
		String hql6="select subcriptID from Subcript where subscriptname=?";
		 
		return (Integer) getSessionFactory().getCurrentSession().createQuery(hql6).setParameter(0, subscriptname).uniqueResult();
		  
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getScriptionOptionList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(Subcript.class).list();
	}

	
	@Override
	public void AddDocument1(Cls_DocumentCategory d) {
		 getSessionFactory().getCurrentSession().save(d);
	
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_DocumentCategory> getDocumentList() {
	
		return getSessionFactory().getCurrentSession().createCriteria(Cls_DocumentCategory.class).list();
	}

	@Override
	public Integer AddDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInt_Document_CatNM(String int_Document_CatNM) {
		
		return getInt_Document_CatNM(int_Document_CatNM); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getInt_Document_CatNM() {
		return getSessionFactory().getCurrentSession().createCriteria(Cls_DocumentCategory.class).setProjection(Projections.property("Int_Document_CatNM")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getInt_Document_CatNM1() {
		return getSessionFactory().getCurrentSession().createCriteria(Cls_DocumentCategory.class).setProjection(Projections.property("Int_Document_CatNM")).list();
	}

	@Override
	public void documents(Cls_CreateDocumentManagement d) {
		getSessionFactory().getCurrentSession().save(d);
		
	}

	public String getSubscriptname() {
		return subscriptname;
	}

	public void setSubscriptname(String subscriptname) {
		this.subscriptname = subscriptname;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_CreateDocumentManagement> getListCreatedocument() {
		List<Cls_CreateDocumentManagement> sss= getSessionFactory().getCurrentSession().createCriteria(Cls_CreateDocumentManagement.class).list();
		System.out.println(sss);
		return sss;
	}

	@Override
	public Integer getInt_Document_CatNM2(int int_Document_CatID) {
		String hql6="select int_Document_CatID from Cls_DocumentCategory where int_Document_CatNM=?";
		 
		return (int) getSessionFactory().getCurrentSession().createQuery(hql6).setParameter(0, int_Document_CatID).uniqueResult();
	
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List addmanagement(Cls_CreateDocumentManagement m) {
		return getSessionFactory().getCurrentSession().createCriteria(Cls_CreateDocumentManagement.class).list();
	}

	
	

	
	public int getdocid1(String intdocid) {
		String hql6="select Int_Document_CatID from Cls_DocumentCategory where Int_Document_CatNM=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql6);
		 
		 Integer cid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql6).setParameter(0, intdocid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	
		
	}

	@Override
	public Integer getInt_Document_CatID1(String int_Document_CatNM) {
		String hql7="select int_Document_CatID from Cls_DocumentCategory where int_Document_CatNM=?";
		 
		 return (int) getSessionFactory().getCurrentSession().createQuery(hql7).setParameter(0,int_Document_CatNM).uniqueResult();
	}

	@Override
	public void update1(Cls_DocumentCategory cat) {
	 getSessionFactory().getCurrentSession().update(cat);
		
	}

	@Override
	public Cls_DocumentCategory getCls_DocumentCategory(
			Integer int_Document_CatID) {
		return(Cls_DocumentCategory)getSessionFactory().getCurrentSession().get(Cls_DocumentCategory.class,int_Document_CatID);
	}

	
	@Override
	public void Deletedoc(Cls_DocumentCategory category) 
		{
			System.out.println("pip");
			 getSessionFactory().getCurrentSession().createQuery("delete from Cls_DocumentCategory where Int_Document_CatID="+category.getInt_Document_CatID()).executeUpdate();
			
		}

	@Override
	public void Delete1(Cls_DocumentCategory cat) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public int getAprId1(String aprid) {
		System.out.println("hiiiiiiii");
		String hql10="select int_ApartmentId from UserApartment where str_ApartmentName=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql10);
		 
		 Integer cid1=(Integer)getSessionFactory().getCurrentSession().createQuery(hql10).setParameter(0, aprid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid1);
		 return cid1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMailIds() {
		List<String> list= (List<String>)getSessionFactory().getCurrentSession().createCriteria(User.class).setProjection(Projections.property("str_Email")).list();
         System.out.println(list);
         return list;
	}
	public String getDocumentName(Integer int_Document_CatID)
	{
		String hql="select Int_Document_CatNM from Cls_DocumentCategory where Int_Document_CatID=?";
		String sss=(String)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_Document_CatID).uniqueResult();
		System.out.println(sss);
		return sss;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_CreateDocumentManagement> getSearchByName(String username) {
		{   if(username==null)
		{
			
			String  query = "{ CALL category() }";
		
			 List<Cls_CreateDocumentManagement> kkk = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_CreateDocumentManagement.class)
			          ).list();
		      System.out.println("kkk");   
			 return kkk;
		}
		else
		{
			String  query = "{ CALL categorys('admin') }";
			
			 List<Cls_CreateDocumentManagement> kkk = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_CreateDocumentManagement.class)
			          ).list();
		      System.out.println("kkk");   
			 return kkk;
		}
			
			
		}
	}

	@Override
	public void Deleted(Cls_CreateDocumentManagement category) {
		// TODO Auto-generated method stub
		System.out.println("pip");
		 getSessionFactory().getCurrentSession().createQuery("delete from Cls_CreateDocumentManagement where Int_DocumentID="+category.getInt_DocumentID()).executeUpdate();
	}

	@Override
	public Cls_CreateDocumentManagement editproduct(int int_DocumentID) {
		return(Cls_CreateDocumentManagement)getSessionFactory().getCurrentSession().get(Cls_CreateDocumentManagement.class,int_DocumentID);
	}

	@Override
	public int editproductaa(Integer int_DocumentID) {
		{
			System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
			System.out.println(int_DocumentID);
			String hql2="select Int_Document_CatID from Cls_CreateDocumentManagement where Int_DocumentID=?";
			System.out.println("8888888888888888888888888888888888");
			return (int) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, int_DocumentID).uniqueResult();
					
		}
	}

	@Override
	public String editpro(int prointcatid) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(prointcatid);
		String hql2="select Int_Document_CatNM from Cls_DocumentCategory where Int_Document_CatID=?";
		System.out.println("8888888888888888888888888888888888");
		return (String) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, prointcatid).uniqueResult();
	}

	@Override
	public void deleteInvoice(Subcript detail) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Subcript WHERE subcriptID="+detail.getSubcriptID()).executeUpdate();
		
	}

	@Override
	public void deleted(Cls_DocumentCategory detail) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Cls_DocumentCategory WHERE Int_Document_CatID="+detail.getInt_Document_CatID()).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List document() {
		return (List<cls_Feedback>) getSessionFactory().getCurrentSession().createCriteria(Cls_CreateDocumentManagement.class).list();
	}

	@Override
	public void groupadd(cls_Group group) {
		 getSessionFactory().getCurrentSession().save(group);
	}

	@Override
	public List getgroupNames() {
		return getSessionFactory().getCurrentSession().createCriteria( UserBlocks.class).setProjection(Projections.property("str_BlockName")).list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> listgroup()
	{
		String hql2="select str_BlockName from UserBlocks";		
		System.out.println("8888888888888888888888888888888888");
		return  sessionFactory.getCurrentSession().createQuery(hql2).list();
	}

	@Override
	public void hobby(cls_hobby hb) {
		getSessionFactory().getCurrentSession().save(hb);
		
	}

	@Override
	public List getCategories() {
		return getSessionFactory().getCurrentSession().createCriteria(cls_hobby.class).setProjection(Projections.property("HobbyName")).list();
	}

	@Override
	public List getCategories2() {
		return getSessionFactory().getCurrentSession().createCriteria(User.class).setProjection(Projections.property("str_State")).list();
	}

	@Override
	public List cityList(String enquiry_selectedState) {
		String	hql1="select int_stateId from cls_PersonState where str_StateName=?";
		int stateId=(int) sessionFactory.getCurrentSession().createQuery(hql1).setParameter(0, enquiry_selectedState).uniqueResult();
		 System.out.println(stateId);
			String hql2="select str_CityName from cls_PersonCity where int_StateId=?";
			
			List<String> cityList= sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, stateId).list();
			System.out.println(cityList);
			System.out.println( ( cityList).listIterator().hasNext());
			return cityList;
	}

	@Override
	public cls_Group getEdit1(int id1) {
		return (cls_Group) getSessionFactory().getCurrentSession().get(cls_Group.class, id1);
	}

	@Override
	public void update3(cls_Group edit1) {
		sessionFactory.getCurrentSession().update(edit1);
	}

	@Override
	public void addContact1(cls_Group edit1) {
		sessionFactory.getCurrentSession().save(edit1);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> cityList() {
		 
		List<String> cityList=getSessionFactory().getCurrentSession().createCriteria(User.class).setProjection(Projections.property("str_City")).list();
		return cityList;
	}

	@Override
	public List getlist() {
		List<String> cityList=getSessionFactory().getCurrentSession().createCriteria(cls_Group.class).list();
		return cityList;
	}

	@Override
	public cls_Group alldata(int int_GroupId) {
		String	hql1="from cls_Group where int_GroupId=?";
		return (cls_Group) sessionFactory.getCurrentSession().createQuery(hql1).setParameter(0, int_GroupId).uniqueResult();
	}

	@Override
	public cls_Group getEdit5(int int_GroupId) {
		return (cls_Group) getSessionFactory().getCurrentSession().get(cls_Group.class, int_GroupId);
	}

	@Override
	public void deleteInvoice(cls_Group detail) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM cls_Group  WHERE int_GroupId="+detail.getInt_GroupId()).executeUpdate();
		
	}

	@Override
	public List Categories() {
		return getSessionFactory().getCurrentSession().createCriteria(cls_Group.class).setProjection(Projections.property("str_groupPrivate")).list();
	}

	@Override
	public List Categor() {
		return getSessionFactory().getCurrentSession().createCriteria(cls_Group.class).setProjection(Projections.property("isCh_EmailAllow")).list();
	}

	@Override
	public List company() {
		return getSessionFactory().getCurrentSession().createCriteria(cls_Group.class).setProjection(Projections.property("str_GroupNm")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getsearch(String str_State,String str_Username,String str_blocks) {
		if(str_State==null&&str_Username==null&&str_blocks==null)
		{ 
			return  getSessionFactory().getCurrentSession().createCriteria(User.class).setCacheable(true).list();
	}
		
		else
		{
			System.out.println("ggggggggggggggggggggggggggggggggggggggggg");
			System.out.println(str_Username+"jjjjjjjjjjjjjjjjjjjjjj");
			String hql="from User  where str_State=? and str_Username=? and str_Block=? ";
	        return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_State).setParameter(1,str_Username).setParameter(2, str_blocks).setCacheable(true).list();
 }
	}

	@Override
	public List getgroup() {
		List<String> cityList=getSessionFactory().getCurrentSession().createCriteria(User.class).list();
		return cityList;
	}

	@Override
	public void insertes(GroupMember m1) {
		
		sessionFactory.getCurrentSession().save(m1);
		
		
	}

	@Override
	public int  adv1(String selectes) {
		System.out.println(selectes+"mmmmmmkkkkkkkkkkk");
		String hql1="select int_GroupId  from cls_Group  where str_GroupNm=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid1=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, selectes).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid1);
		return cid1;
		
	}

	@Override
	public cls_Group allname(String str_GroupNm) {
		String	hql1="from cls_Group where str_GroupNm=?";
		return (cls_Group) sessionFactory.getCurrentSession().createQuery(hql1).setParameter(0, str_GroupNm).uniqueResult();
		
	}

	@Override
	public cls_Group getEdit8(int int_GroupId) {
		return (cls_Group) getSessionFactory().getCurrentSession().get(cls_Group.class, int_GroupId);
	}

	@Override
	public void updates(cls_Group edit2) {
		String	hql1="update  cls_Group set bol_Smsallow=?,bol_Emailallow=?  where int_GroupId=?";
		getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,edit2).executeUpdate();
	}

	@Override
	public void addsetting(cls_Group edit2) {
		sessionFactory.getCurrentSession().save(edit2);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public  List<String> listblock() {
		String hql2="select str_BlockName from UserBlocks";		
		System.out.println("8888888888888888888888888888888888");
		return  sessionFactory.getCurrentSession().createQuery(hql2).list();
		
	}

	
	@Override
	public List<UserExtraInfo> getsearch1(String str_Hobbies,String str_Profession) {
		
			System.out.println(str_Profession+"jjjjjjjjjjjjjjjjjjjjjj");
			System.out.println(str_Hobbies);
			String query="{call member()}";
			List<UserExtraInfo> conn=sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(UserExtraInfo.class)).list();
			return conn;
 }


	@Override
	public UserExtraInfo searchuser(Integer int_UserExtraID) {
		return(UserExtraInfo)getSessionFactory().getCurrentSession().get(UserExtraInfo.class,int_UserExtraID);
	}

	@Override
	public UserExtraInfo searchuser1(Integer int_UserId) {
		return(UserExtraInfo)getSessionFactory().getCurrentSession().get(UserExtraInfo.class,int_UserId);
	}

	@Override
	public int searchh(Integer int_UserId) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(int_UserId);
		String hql2="select int_UserExtraID from agency_information where int_UserId=?";
		System.out.println("8888888888888888888888888888888888");
		return (int) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, int_UserId).uniqueResult();
	}

	@Override
	public String searchhh(int searchid) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(searchid);
		String hql2=" from  User int_CompanyID=?";
		System.out.println("8888888888888888888888888888888888");
		return""  ;
	}

	@Override
	public UserExtraInfo searchuser12(Integer int_UserExtraID) {
		return(UserExtraInfo)getSessionFactory().getCurrentSession().get(UserExtraInfo.class,int_UserExtraID);
	}

	@Override
	public int searchh1(Integer int_UserExtraID) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(int_UserExtraID);
		String hql2="select int_UserId from UserExtraInfo where int_UserExtraID=?";
		System.out.println("8888888888888888888888888888888888");
		return (int) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, int_UserExtraID).uniqueResult();
	}

	@Override
	public String searchhh4(int searchid) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(searchid);
		String hql2="select str_Block,str_Username,str_UserRoleName from User where int_UserId=?";
		System.out.println("8888888888888888888888888888888888");
		return   (String) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, searchid).uniqueResult();

	}

	
	@Override
	public User searchhh6(Integer uid) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(uid);
		String hql2=" from User where int_UserId=?";
		System.out.println("8888888888888888888888888888888888");
		return    (User) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0,uid).uniqueResult();

	}
	}

	
	
	



	
	
	

	

	
	

	
	
	

	
