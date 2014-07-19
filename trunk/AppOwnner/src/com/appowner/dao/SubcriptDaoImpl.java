package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.Option;
import com.appowner.model.Subcript;
import com.appowner.model.User;

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
	public List getListCreatedocument() {
		return getSessionFactory().getCurrentSession().createCriteria(Cls_CreateDocumentManagement.class).list();
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
}

	
	
	

	

	
	

	
	
	

	
