package com.appowner.service;

import java.util.Collection;
import java.util.List;

//import javax.persistence.Query;





































import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.Option;
import com.appowner.model.Subcript;
//import com.mukesh.bean.ScriptBean;

/**
 * @author mukesh
 * @param <subscriptname>
 *
 */
public interface SubcriptService<subscriptname> {
	
	
	public void addUsers(Subcript usr);

	public List<Subcript> listSubcripts();
	
	public Subcript getSubcript(int subcriptID);
	

	

	public void update(Subcript usr);

	public void addOptions(Subcript usr1);

	public Collection<? extends Option> listOptions();

	public void addOptions(Option usr1);

	

	

	

public void addSubcriptions(Cls_SubcriptionOption sop);

	public Collection<? extends Cls_SubcriptionOption> listCls_SubcriptionOptions();

	

	 
	public int getSubcriptID1(String subscriptname);

	public List<String> getOptionNames();

	void addService(Cls_SubcriptionOption s);

	public Integer getInt_OptionId(String optionName);

	public List<String> getSubscriptnames();

	public Integer getInt_OptionId1(String optionname);

	public Integer  getSubscriptname1(String subscriptname);

	public List<Cls_SubcriptionOption> getScriptionOptionList();

	

	public void AddDocument1(Cls_DocumentCategory d);

	public List<Cls_DocumentCategory> getDocumentList();

	public String getInt_Document_CatNM1(String int_Document_CatNM1);

	public List < String> getInt_Document_CatNM();

	public List<String> getInt_Document_CatNM1();

	public void documents(Cls_CreateDocumentManagement d);

	public List<Cls_CreateDocumentManagement> getListCreatedocument();

	public Integer getInt_Document_CatID(String int_Document_CatNM);

	public Integer getInt_Document_CatNM2(int int_Document_CatID);

	public void addmanagement(Cls_CreateDocumentManagement m);



	public int getdocid1(String intdocid);

	public Integer getInt_Document_CatID1(String int_Document_CatNM);



	public Cls_DocumentCategory getCls_DocumentCategory(Integer int_Document_CatID);

	public void update1(Cls_DocumentCategory cat);

	

	public void Deletedoc(Cls_DocumentCategory category);

	

	public int getAprId1(String aprid);

	

	


	



	

	 



	
	

	

	

	

	

	

	 

	
}

