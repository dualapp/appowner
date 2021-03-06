package com.appowner.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.bean.FileUploadValidator;
import com.appowner.model.AccountingGroup;
import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.CommiteeMember;
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
import com.appowner.util.Util;
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
		
			String  query = "{ CALL uploaddocument() }";
			
			 List<Cls_CreateDocumentManagement> fileupload = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_CreateDocumentManagement.class)
			          ).list();
		     System.out.println(fileupload.listIterator().hasNext());
			 return fileupload;	
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
		String hql2=" from cls_Group where int_ApartmentId=? ";		
		System.out.println("8888888888888888888888888888888888");
		return  sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0,Util.getAppartmentId()).list();
		
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
	int groupid=m1.getInt_GroupId();
        String str=m1.getInt_UserId();
        System.out.println(str+"hfjjggjjgjfjfjfj");
        String hql1="  from GroupMember where int_GroupId=?";
       GroupMember cid1=(GroupMember) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, groupid).uniqueResult();
        System.out.println(cid1);
        if(cid1==null)
        {
        	sessionFactory.getCurrentSession().save(m1);
        }
        else
        {
        	Integer id1=cid1.getInt_GroupmemberId();
            Integer id2=cid1.getInt_GroupId();
            String id3=cid1.getInt_UserId();
            
           if(id2==groupid)
           {
        	   System.out.println(str+"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzkkkkkkkkkkkkk");
        	String hql3="select  int_UserId from GroupMember where int_GroupId=?"; 
        	 String  usrid=(String) sessionFactory.getCurrentSession().createQuery(hql3).setParameter(0, id2).uniqueResult();
        	 System.out.println(usrid+"zzzoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooozzzzzzzkkkkkkkkkkkkk");
        		
                   
                    Set<String> str2=new HashSet<String>();
              System.out.println(str2+"hhjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");      
            String[] str1=usrid.split(","); 
            for(String id:str1)
            { System.out.println(str2.contains(id)+"pppppppppppppppppp");
                
            	str2.add(id);
            
           }
            System.out.println(str2+"hhshhshssssfffffffffffffffffffttttttttttttttttttttttttttttttttttttttttttttttt");
            String[] str3=str.split(","); 
            for(String id:str3)
            { System.out.println(str2.contains(id)+"pppppppppppppppppp");
                
            	str2.add(id);
            
           }
			
        	if (str.length() > 0 && str.charAt(str.length()-1)==',') {
        		str = str.substring(0, str.length()-1);
        	  }
        	
        	
        	if(id3==str)
        	{
        		sessionFactory.getCurrentSession().save(m1);	
        	}
        	else{
        		StringBuilder out = new StringBuilder();
        		for (Object o : str2)
        		{
        		out.append(o.toString());
        		  out.append(",");
        		}

        		str=out.toString();
        
        	System.out.println(str+"chhhfhhhhhhhhhhhhhhhhhhhhhhhhhh");
           	System.out.println(hql3+"mukeshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
           	String hql2="update GroupMember set int_UserId=? where int_GroupmemberId=?";
       		sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0,str).setParameter(1, id1).executeUpdate();	
           }
           
        	}
           }
		
		
	}

	@Override
	public int  adv1(String selectes) {
		System.out.println(selectes+"mmmmmmkkkkkkkkkkk");
		String hql1="select int_GroupId  from cls_Group  where str_GroupNm=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer getid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, selectes).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(getid);
		return getid;
		
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
		String hql2="select str_BlockName from UserBlocks  ";		
		System.out.println("8888888888888888888888888888888888");
		return  sessionFactory.getCurrentSession().createQuery(hql2).list();
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserExtraInfo> getsearch1(String str_Hobbies, String str_Profession,
			String residence, String status, String married_status1 ,int statusid,String block,String str_State, String str_City) {
System.out.println(str_Profession+"jjjjjjjjjjjjjjjjjjjjjj");
			System.out.println(str_Hobbies);
		    System.out.println(block+"kfjkgf");
           System.out.println( statusid+"kfjkgfmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
           System.out.println(residence+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        if(statusid==0)
           {
        	  System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"); 
        	 return null;
           }
           else
           
           {
        String query="{call member(?,?,?,?,?,?,?,?,?)}";
			List<UserExtraInfo> conn=sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(UserExtraInfo.class)).setParameter
					(0, str_Hobbies).setParameter(1, str_Profession).setParameter(2, residence).
					setParameter(3, status).setParameter(4, married_status1).
					setParameter(5, statusid).setParameter(6, block).setParameter(7, str_State).setParameter(8, str_City).list();
			return conn;
} 
           
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

	@Override
	public List reside() {
		String hql2="select residence from UserExtraInfo";		
		System.out.println("8888888888888888888888888888888888");
		return  sessionFactory.getCurrentSession().createQuery(hql2).list();
	}

	@Override
	public UserExtraInfo alldatas(Integer int_UserId) {
		String query="{call member1(?)}";
		UserExtraInfo conn=(UserExtraInfo) sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(UserExtraInfo.class)).setParameter(0,int_UserId).uniqueResult();
		System.out.println("bbbbbbbbbbbbbzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		return (UserExtraInfo) conn;
	}

	@Override
	public int addmember(String selecte) {
		System.out.println(selecte+"mmmmmmkkkkkkkkkkk");
		String hql1="select userId  from cls_Group  where str_GroupNm=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid1=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, selecte).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid1);
		return cid1;
		
	}

	@Override
	public User allnames(String str_Username) {
		String	hql1="from User where str_Username=?";
		return (User) sessionFactory.getCurrentSession().createQuery(hql1).setParameter(0, str_Username).uniqueResult();
	}

	@Override
	public List allusers(int int_GroupId) {
		String	hql1="Select int_UserId  from  GroupMember where int_GroupId=?";
		 String id = (String) sessionFactory.getCurrentSession().createQuery(hql1).setParameter(0, int_GroupId).uniqueResult();
		 System.out.println(id+"hjjhujjk");
		 if(id==null)
		 {
			 List<UserExtraInfo> conn1=new ArrayList<UserExtraInfo>();
			 return conn1;
		 }
		 else
		 {
		 
		 String[] array=id.split(",");
		 List<UserExtraInfo> conn1=new ArrayList<UserExtraInfo>();
		 
			 
		 for(String id1:array)
		 {  
			 if(id1.isEmpty())
			 {
				 System.out.println(id1+"jjhhjjjazzzzzzzzzzzzzzzzzzzzzzzzzzvvvvvvvvvvvvvvvvvvvvvvvvv");  
			 }
			 else
			 System.out.println(id1+"jjhhjjj"); 
			 int id2=Integer.parseInt(id1);
			 System.out.println(id2+"jjkjkjjklllllllllllllllllllllllllllllll");
			 String query="{ call member1(?)}";
				UserExtraInfo conn=(UserExtraInfo) sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(UserExtraInfo.class)).setParameter(0,id2).uniqueResult();
				conn1.add(conn);
		 }
		 
		// Set<Integer> str2 = new HashSet<Integer>(id);
		// List<Integer> str3 = new ArrayList(str2);
		/* System.out.println(str3+"hhjj");
		 System.out.println(str2+"kfkfk");
		 List<UserExtraInfo> conn1=new ArrayList<UserExtraInfo>();
		 ListIterator itr=(ListIterator) str3.listIterator();
			System.out.println(itr);
			while(itr.hasNext())
			{
				System.out.println(".,,,,,,,,,,,,,,,,,,,,,,,,,,,,,................>>>>>>>>>>");
				String u=(String) itr.next();
				Integer id=u.
				System.out.println(u+"jjfjfj");
				String query="{ call member1(?)}";
				UserExtraInfo conn=(UserExtraInfo) sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(UserExtraInfo.class)).setParameter(0,u).uniqueResult();
				conn1.add(conn);
				
				
		 
			}*/
		 System.out.println(conn1+"jjjjmnnnnnnnnnnnnnnnnnnnnnnnnnnmmmmmmmmmmmmmmmmmmmmmmmmmm");
	   return conn1;
		 }
		
		
		
	}

	@Override
	public User usrname(String str_Username) {
		String	hql1="from User where str_Username=?";
		return (User) sessionFactory.getCurrentSession().createQuery(hql1).setParameter(0, str_Username).uniqueResult();
	}

	@Override
	public int adduser(String selecte) {
		System.out.println(selecte+"mmmmmmkkkkkkkkkkk");
		String hql1="select int_UserId  from User  where str_Username=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid1=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, selecte).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid1);
		return cid1;
	}

	@Override
	public List memberid(String str_Hobbies) {
	    System.out.println(str_Hobbies+"mmmmmmkkkkkkkkkkkppppppppppppp");
        String hql1="select int_UserId  from UserExtraInfo  where str_Hobbies=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> cid1=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, str_Hobbies).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid1);
		return cid1;
	}

	@Override
	public String count(int meberids) {
		String hql="select int_UserId from GroupMember where int_GroupId=?";
		 String count1=(String) sessionFactory.getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,meberids).uniqueResult();
		 return count1;
	}

	@Override
	public Cls_CreateDocumentManagement listname(Integer postid) {
		System.out.println(postid+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="from Cls_CreateDocumentManagement where Int_DocumentID=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		Cls_CreateDocumentManagement  name= (Cls_CreateDocumentManagement) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,postid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(name);
		 return name;
	}

	@Override
	public void deletedetail(Cls_CreateDocumentManagement detail) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Cls_CreateDocumentManagement WHERE Int_DocumentID="+detail.getInt_DocumentID()).executeUpdate();
		
	}

	@Override
	public int getname(String intdocid) {
		
		String hql1="select Int_Document_CatID  from Cls_DocumentCategory where Int_Document_CatNM=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer getid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, intdocid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( getid);
		return  getid;
	}

	@Override
	public void updatepost(Cls_CreateDocumentManagement document) {
		sessionFactory.getCurrentSession().update( document);
	}

	
		 
	@Override
	public void updateposts(Cls_CreateDocumentManagement doc) {
		sessionFactory.getCurrentSession().update( doc);
		
	}

	@Override
	public void updateposts(String txtfile, Integer postid, String path,
			String filename) {
		  System.out.println(txtfile+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		  System.out.println(FileUploadValidator.filename+"ppppppppppppppppppppppppppppppppppppppppppppppppppppppp");
		 System.out.println(path+"mkmmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkm");
			String hql="update  Cls_CreateDocumentManagement  set  image=?, str_FolderNM=?, str_FileNM=? where Int_DocumentID=?";
			 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, txtfile).setParameter(1, filename).setParameter(2, path).setParameter(3, postid).executeUpdate();
			System.out.println(hql+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		}

	@Override
	public List getcommiteid() {
		List<Integer> list= (List<Integer>)getSessionFactory().getCurrentSession().createCriteria(CommiteeMember.class).setProjection(Projections.property("int_UserId")).list();
		ListIterator itr=(ListIterator) list.listIterator();
		System.out.println(itr);
		List<String> mailids=new ArrayList<String>();
		while(itr.hasNext())
		{
	    Object obj= itr.next();
		    System.out.println(".,,,,,,,,,,,,,,,,,,,,,,,,,,,,,................>>>>>>>>>>");

		   int int_UserId=(int) obj;
	        System.out.println(int_UserId+"cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmm");
	        String hql1="select str_Email  from User where  int_UserId=?";
			System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
			System.out.println(hql1);
			 
			String mailid=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, int_UserId).uniqueResult();
			 System.out.println("cccccccccccccccccccccccccccccccccccccc");
			 System.out.println( mailid+"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			 mailids.add(mailid);
		}
		 System.out.println(list);
	        return mailids;	
	}

	@Override
	public List getgroupid() {
		List<Integer> list= (List<Integer>)getSessionFactory().getCurrentSession().createCriteria(cls_Group.class).setProjection(Projections.property("userId")).list();
		ListIterator itr=(ListIterator) list.listIterator();
		System.out.println(itr);
		List<String> mailids=new ArrayList<String>();
		while(itr.hasNext())
		{
	    Object obj= itr.next();
		    System.out.println(".,,,,,,,,,,,,,,,,,,,,,,,,,,,,,................>>>>>>>>>>");

		   int userId=(int) obj;
	        System.out.println(userId+"cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmm");
	        String hql1="select str_Email  from User where  int_UserId=?";
			System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
			System.out.println(hql1);
			 
			String mailid=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, userId).uniqueResult();
			 System.out.println("cccccccccccccccccccccccccccccccccccccc");
			 System.out.println( mailid+"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			 mailids.add(mailid);
		}
		 System.out.println(list);
	        return mailids;	
	}

	@Override
	public List getadminname() {
		List<Integer> list= (List<Integer>)getSessionFactory().getCurrentSession().createCriteria(User.class).setProjection(Projections.property("str_UserRoleName")).list();
		ListIterator itr=(ListIterator) list.listIterator();
		System.out.println(itr);
		List<String> mailids=new ArrayList<String>();
		while(itr.hasNext())
		{
	    Object obj= itr.next();
		    System.out.println(".,,,,,,,,,,,,,,,,,,,,,,,,,,,,,................>>>>>>>>>>");

		  String  str_UserRoleName=(String) obj;
	        System.out.println(str_UserRoleName+"cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmm");
	        String hql1="select str_Email  from User where  str_UserRoleName=?";
			System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
			System.out.println(hql1);
			 
		List<String>mailid=(List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, str_UserRoleName).list();
			 System.out.println("cccccccccccccccccccccccccccccccccccccc");
			 System.out.println( mailid+"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			 mailids.addAll(mailid);
		
		}
		 System.out.println(list);
	        return mailids;	
	}

	@Override
	public void deletemembergroup(cls_Group detail) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM GroupMember  WHERE int_GroupId="+detail.getInt_GroupId()).executeUpdate();
		
		
	}

	@Override
	public Cls_CreateDocumentManagement getdocdetail(int docid) {
		System.out.println(docid+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		Cls_CreateDocumentManagement docdetail= (Cls_CreateDocumentManagement) getSessionFactory().getCurrentSession().get(Cls_CreateDocumentManagement.class, docid);
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( docdetail);
		 return  docdetail;
	}

	@Override
	public List getdocdetails(Integer int_Document_CatID) {
		return getSessionFactory().getCurrentSession().createQuery("select Int_Document_CatNM from Cls_DocumentCategory where int_Document_CatID=?").setParameter(0,int_Document_CatID).list();
	}

	@Override
	public Cls_CreateDocumentManagement getdetail(int docId) {
		String hql1="from Cls_CreateDocumentManagement where Int_DocumentID=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		Cls_CreateDocumentManagement documentdetail= (Cls_CreateDocumentManagement) getSessionFactory().getCurrentSession().get(Cls_CreateDocumentManagement.class, docId);
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( documentdetail);
		 return  documentdetail;
	}

	@Override
	public List<String> getdocumentdetail(Integer int_Document_CatID) {
		return getSessionFactory().getCurrentSession().createCriteria(Cls_DocumentCategory.class).setProjection(Projections.property("Int_Document_CatNM")).list();
	}

	@Override
	public String documentnames(Integer int_Document_CatID) {
		String hql1="select Int_Document_CatNM  from   Cls_DocumentCategory where  int_Document_CatID=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		String catname=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, int_Document_CatID).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( catname+"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
		 
        return catname;	
}

	@Override
	public cls_Group groupdetail(int groupId) {
		System.out.println(groupId+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="from cls_Group where int_GroupId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		cls_Group groupdetail= (cls_Group) getSessionFactory().getCurrentSession().get(cls_Group.class,groupId);
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( groupdetail);
		 return  groupdetail;
	}

	@Override
	public List getlistgrouo(Integer int_GroupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public cls_Group grouedit(int groupid) {
		System.out.println(groupid+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="from cls_Group where int_GroupId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		cls_Group groupdetail= (cls_Group) getSessionFactory().getCurrentSession().get(cls_Group.class,groupid);
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( groupdetail);
		 return  groupdetail;
	}

	@Override
	public cls_Group groupsetting(int groupid) {
		System.out.println(groupid+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="from cls_Group where int_GroupId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		cls_Group groupdetail= (cls_Group) getSessionFactory().getCurrentSession().get(cls_Group.class,groupid);
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( groupdetail);
		 return  groupdetail;
	}

	@Override
	public List memberId(String str_Hobbies) {
		System.out.println(str_Hobbies+"mmmmmmkkkkkkkkkkkppppppppppppp");
		
		
		String hql1="select int_UserId  from UserExtraInfo  where residence=? ";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> cid1=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, str_Hobbies).list();
		 
		 System.out.println(cid1+"cccccccccccccccccccccccccccccccccccccc");
		return cid1;
	}

	@Override
	public List ProfessionId(String str_Profession) {
System.out.println(str_Profession+"mmmmmmkkkkkkkkkkkppppppppppppp");
	String hql1="select int_UserId  from UserExtraInfo  where  str_Profession=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> professionId=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, str_Profession).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(professionId);
		return professionId;
	}

	@Override
	public List MarriedId(String married_status1) {
		String hql1="select int_UserId  from UserExtraInfo  where str_MaritalStatus=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> married_status=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, married_status1).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(married_status);
		return married_status;
	}

	@Override
	public List hobbyId(String hobby) {
		String hql1="select int_UserId  from UserExtraInfo  where str_gender=? ";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> hobby1=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, hobby).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(hobby1);
		return hobby1;
	}

	@Override
	public List res_profession(String reistences, String str_Profession) {
		String hql1="select int_UserId  from UserExtraInfo  where reistences=? and str_Profession=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> profession=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,reistences).setParameter(1,str_Profession).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(profession);
		return profession;
	}

	@Override
	public List res_hobby(String reistences, String str_Hobbies) {
		String hql1="select int_UserId  from UserExtraInfo  where reistences=? and str_Hobbies=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> profession=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,reistences).setParameter(1,str_Hobbies).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(profession);
		return profession;
	
	}

	@Override
	public List res_married(String reistences, String married_status1) {
		String hql1="select int_UserId  from UserExtraInfo  where reistences=? and str_MaritalStatus=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> married=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,reistences).setParameter(1,married_status1).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(married);
		return married;
	}

	@Override
	public List res_gender(String reistences, String gender) {
		String hql1="select int_UserId  from UserExtraInfo  where reistences=? and str_gender=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> married=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,reistences).setParameter(1,gender).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(married);
		return married;
	}

	@Override
	public List pro_hobby(String str_Profession, String str_Hobbies) {
		String hql1="select int_UserId  from UserExtraInfo  where str_Profession=? and str_Hobbies=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> pro_hobby=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,str_Profession).setParameter(1,str_Hobbies).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(pro_hobby);
		return pro_hobby;
	}

	@Override
	public List pro_married(String str_Profession, String married_status1) {
		String hql1="select int_UserId  from UserExtraInfo  where str_Profession=? and str_MaritalStatus=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> pro_hobby=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,str_Profession).setParameter(1,married_status1).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(pro_hobby);
		return pro_hobby;
	}

	@Override
	public List pro_gender(String str_Profession, String gender) {
		String hql1="select int_UserId  from UserExtraInfo  where str_Profession=? and str_gender=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> pro_hobby=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,str_Profession).setParameter(1,gender).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(pro_hobby);
		return pro_hobby;
	}

	@Override
	public List married_gen(String married_status1, String gender) {
		String hql1="select int_UserId  from UserExtraInfo  where str_MaritalStatus=? and str_gender=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> pro_hobby=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,married_status1).setParameter(1,gender).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(pro_hobby);
		return pro_hobby;
	}

	@Override
	public List res_pro_hoby(String reistences, String str_Profession,String str_Hobbies) {
		String hql1="select int_UserId  from UserExtraInfo  where reistences=? and str_Profession=? and str_Hobbies=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> pro_res=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,reistences).setParameter(1,str_Profession).setParameter(2,str_Hobbies).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(pro_res);
		return pro_res;
	}

	@Override
	public List res_married_gender(String reistences, String married_status1,
			String gender) {
		String hql1="select int_UserId  from UserExtraInfo  where reistences=? and str_MaritalStatus=? and str_gender=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> pro_married=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,reistences).setParameter(1,married_status1).setParameter(2,gender).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(pro_married);
		return pro_married;
	}

	@Override
	public List res_hobby_gender(String reistences, String str_Hobbies,
			String gender) {
		String hql1="select int_UserId  from UserExtraInfo  where reistences=? and str_Hobbies=? and str_gender=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> pro_married=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,reistences).setParameter(1,str_Hobbies).setParameter(2,gender).list();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(pro_married);
		return pro_married;
	}

	@Override
	public List stateId(String str_State) {
		
			String hql1="select int_UserId  from User  where str_State=? ";
			System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
			System.out.println(hql1);
			 
			List <Integer> usrid=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, str_State).list();
			System.out.println(usrid+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbbbbbbbbbb");
			return usrid;
		}

	@Override
	public List usrId(String str_City,String str_State) {
		String hql1="select int_UserId  from User  where str_City=? and str_State=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> usrId=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, str_City).setParameter(1, str_State).list();
		System.out.println(usrId+"cccccccccccccccccccccccccccccccccccccccccbbbbbbbbbbbbbbbbb");
		return usrId;
	}

	@Override
	public List block_usrid(String block) {
		String hql1="select int_UserId  from User  where str_Block=? ";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		List <Integer> usrId=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, block).list();
		System.out.println(usrId+"mukkkkkkkkkkkeshhhhhhhhhhhhhhhhhhhhhhhhhhh");
		return usrId;
	}

	@Override
	public cls_Group getusrid(int memberid) {
		System.out.println(memberid+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="from cls_Group where int_UserId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		cls_Group groupdetail= (cls_Group) getSessionFactory().getCurrentSession().get(cls_Group.class,memberid);
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( groupdetail);
		 return  groupdetail;
	}

	@Override
	public UserExtraInfo getallinfo(int userId) {
		System.out.println(userId+"bbbbbbbbbbbbbbbbbbbjmmmmmmmmmmmmjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		String query="{call member1(?)}";
		UserExtraInfo conn=(UserExtraInfo) sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(UserExtraInfo.class)).setParameter(0,userId).uniqueResult();
		return (UserExtraInfo) conn;
	}

	@Override
	public List getuserinformation(String str_Hobby, String str_Profession1,
			String reistence, String gender1, String married_statuss,
			int statusid, String block1, String str_State1, String str_City1) 
		{
			System.out.println(str_Profession1+"jjjjjjjjjjjjjjjjjjjjjj");
						System.out.println(str_Hobby);
					    System.out.println(block1+"kfjkgf");
			           System.out.println( statusid+"kfjkgfmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
			           System.out.println(reistence+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			           System.out.println(gender1+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			        if(statusid==0)
			           {
			        	  System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"); 
			        	 return null;
			           }
			           else
			           
			           {
			        String query="{call member(?,?,?,?,?,?,?,?,?)}";
						List<UserExtraInfo> conn=sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(UserExtraInfo.class)).setParameter
								(0, str_Hobby).setParameter(1, str_Profession1).setParameter(2, reistence).
								setParameter(3, married_statuss).setParameter(4, married_statuss).
								setParameter(5, statusid).setParameter(6, block1).setParameter(7, str_State1).setParameter(8, str_City1).list();
						return conn;
			} 
	}
	
	}

	
	
	
	


		
	
		
	

		
	

	

	

	
	
	

	
