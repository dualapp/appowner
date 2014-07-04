package com.appowner.service;

import java.util.Collection;
import java.util.List;

//import javax.faces.bean.ManagedProperty;







































import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





































//import com.kalpana.dao.EmployeeDao;


import com.appowner.dao.SubcriptDao;
import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.Option;
import com.appowner.model.Subcript;

 
@SuppressWarnings("rawtypes")
@Service("SubcriptService")
@Transactional 
public   class SubcriptServiceImpl implements SubcriptService {
	@Autowired
	private SubcriptDao subcriptDao;
	public SubcriptDao getSubcriptDao() {
		return subcriptDao;
	}

	public void setSubcriptDao(SubcriptDao subcriptDao) {
		this.subcriptDao = subcriptDao;
	}
	public void addOptions(Subcript usr1)
	{
		System.out.println("oooooooooooooooooooooooooooooooooooooooo");
		getSubcriptDao().addOptions(usr1);
		
	}
	public void addUsers(Subcript usr)
	{
		System.out.println("oooooooooooooooooooooooooooooooooooooooo");
		getSubcriptDao().addUsers(usr);
		
	}
	public void update(Subcript usr)
	{
		
		getSubcriptDao().update(usr);
		
	}
	public void addSubcriptions(Subcript sop)
	{
		System.out.println("oooooooooooooooooooooooooooooooooooooooo");
		getSubcriptDao().addSubcriptions(sop);
		
	}

	@Override
	public List<Subcript> listSubcripts() {
		return getSubcriptDao().listSubcripts();
	}

	@Override
	public Subcript getSubcript(int subcriptID) {
		return getSubcriptDao().getSubcript( subcriptID);
	}

	@Override
	public Collection<? extends Option> listOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOptions(Option usr1) {
		getSubcriptDao().addUsers1(usr1);
	}

	@Override
	public void addSubcriptions(Cls_SubcriptionOption sop) {
		getSubcriptDao().addSubcriptions(sop);
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<? extends Cls_SubcriptionOption> listCls_SubcriptionOptions() {
		return (Collection<? extends Cls_SubcriptionOption>) subcriptDao;
		
	}

	@Override
	public void addService(Cls_SubcriptionOption s) {
		getSubcriptDao().addService(s); 
		
	}


	@Override
	public int getSubcriptID1(String subscriptname) {
		// TODO Auto-generated method stub
		return getSubcriptDao().getSubcriptID(subscriptname);
	}

	@Override
	public List<String> getOptionNames() {
		// TODO Auto-generated method stub
		return getSubcriptDao(). getOptionNames();
	}

	@Override
	public Integer getInt_OptionId(String optionName) {
		// TODO Auto-generated method stub
		return getSubcriptDao().getInt_OptionId(optionName);
	}

	@Override
	public List<String>  getSubscriptnames() {
		 
		return (List<String>) getSubcriptDao().getSubscriptnames();	
	}

	@Override
	public Integer getInt_OptionId1(String optionname) {
		// TODO Auto-generated method stub
		return getSubcriptDao().getInt_OptionId1(optionname);
	}

	@Override
	public Integer getSubscriptname1(String subscriptname) {
		return getSubcriptDao().getSubscriptname1(subscriptname);
	}

	@Override
	public List getScriptionOptionList() {
		// TODO Auto-generated method stub
		return getSubcriptDao().getScriptionOptionList();
	}

	@Override
	public void AddDocument1(Cls_DocumentCategory d) {
		getSubcriptDao().AddDocument1(d);
		
	}

	@Override
	public List<Cls_DocumentCategory> getDocumentList() {
		
		 return getSubcriptDao().getDocumentList();
	}

	
	

	@Override
	public List getInt_Document_CatNM() {
		return (List<String>) getSubcriptDao().getInt_Document_CatNM();
		
	}

	@Override
	public List getInt_Document_CatNM1() {
		return (List<String>) getSubcriptDao().getInt_Document_CatNM1();
	}

	@Override
	public String getInt_Document_CatNM1(String int_Document_CatNM1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void documents(Cls_CreateDocumentManagement d) {
		System.out.println("documents.......................");
		getSubcriptDao().documents(d);
		
	}

	@Override
	public List getListCreatedocument() {
		return getSubcriptDao().getListCreatedocument();
		
	}

	@Override
	public Integer getInt_Document_CatID(String int_Document_CatNM) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getInt_Document_CatNM2(int int_Document_CatID) {
		return getSubcriptDao().getInt_Document_CatNM2(int_Document_CatID);
	}

	@Override
	public void addmanagement(Cls_CreateDocumentManagement m) {
		getSubcriptDao().addmanagement(m);
		
	}

	@Override
	public int  getdocid1(String intdocid) {
		System.out.println("sssssssssssssssssssssssssssssssssssssssss");
		System.out.println(intdocid);
		return getSubcriptDao().getdocid1(intdocid);
	}

	@Override
	public Integer getInt_Document_CatID1(String int_Document_CatNM) {
		return getSubcriptDao().getInt_Document_CatID1(int_Document_CatNM);
	}

	
	@Override
	public void update1(Cls_DocumentCategory cat) {
		getSubcriptDao().update1(cat);
	}

	@Override
	public Cls_DocumentCategory getCls_DocumentCategory(
			Integer int_Document_CatID) {
		return getSubcriptDao().getCls_DocumentCategory(int_Document_CatID);
	}

	
	
	@Override
	public void Deletedoc(Cls_DocumentCategory category) {
		getSubcriptDao().Deletedoc(category);
	}

	

	@Override
	public int getAprId1(String aprid) {
		return getSubcriptDao().getAprId1( aprid);
	}

	

	
	
	
	}

	 

	
	

	
	

	
	
	
	
	


	 


	 


