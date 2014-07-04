package com.appowner.dao;

import java.util.List;

import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.Option;
import com.appowner.model.Subcript;

/**
 * @author mukesh
 *
 */
public interface SubcriptDao {
	
	public void addUsers(Subcript usr);

	public List<Subcript> listSubcripts();

	public Subcript getSubcript(int subcriptID);
	

	public void update(Subcript usr);

	public void addOptions(Subcript usr1);

	//public void addUsers1(Option usr1);

	//public void addUsers1(Option usr1);

	public void addUsers1(Option usr1);

	public void addSubcriptions(Cls_SubcriptionOption sop);

	public void addSubcriptions(Subcript sop);

	public void addService(Cls_SubcriptionOption s);

	public int getSubcriptID(String subscriptname);

	String  getOptionName(String optionName);

	public List<String> getOptionNames();

	public Integer getInt_OptionId(String optionName);

	public List<String> getSubscriptnames();

	public Integer getInt_OptionId1(String optionname);

	public Integer getSubscriptname1(String subscriptname);

	@SuppressWarnings("rawtypes")
	public List getScriptionOptionList();
	public Integer AddDocument();

	public void AddDocument1(Cls_DocumentCategory d);

	public List<Cls_DocumentCategory> getDocumentList();

	public String getInt_Document_CatNM(String int_Document_CatNM);

	public List<String> getInt_Document_CatNM();

	public List<String> getInt_Document_CatNM1();

	public void documents(Cls_CreateDocumentManagement d);

	public List<Cls_CreateDocumentManagement> getListCreatedocument();

	public Integer getInt_Document_CatNM2(int int_Document_CatID);

	@SuppressWarnings("rawtypes")
	public List addmanagement(Cls_CreateDocumentManagement m);

	

	

	public int getdocid1(String intdocid);

	public Integer getInt_Document_CatID1(String int_Document_CatNM);

	public void update1(Cls_DocumentCategory cat);

	public Cls_DocumentCategory getCls_DocumentCategory(
			Integer int_Document_CatID);

	public void Delete1(Cls_DocumentCategory cat);

	public void Deletedoc(Cls_DocumentCategory category);



	public int getAprId1(String aprid);

	
	
	
	

	 

	
	
	

	 


	






	
	
	

	
	

	 
}
