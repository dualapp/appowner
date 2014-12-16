package com.appowner.service;

import java.util.Collection;
import java.util.List;

//import javax.persistence.Query;

















































































import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.GroupMember;
import com.appowner.model.Option;
import com.appowner.model.Subcript;
import com.appowner.model.User;
import com.appowner.model.UserBlocks;
import com.appowner.model.UserExtraInfo;
//import com.mukesh.bean.ScriptBean;
import com.appowner.model.cls_Group;
import com.appowner.model.cls_hobby;

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

	public List<String> getMailIds();

	public String getDocumentName(Integer int_Document_CatID);

	public List<Cls_CreateDocumentManagement> getSearchByName(
			String username);

	public void Deleted(Cls_CreateDocumentManagement category);

	public Cls_CreateDocumentManagement editproduct(int Int_DocumentID);

	public int editproductaa(Integer int_DocumentID);

	public int editproductaa(int int_DocumentID);

	public String editproduct2(int prointcatid);

	public String editpro(int prointcatid);

	public void deleteInvoice(Subcript detail);

	public void deleted(Cls_DocumentCategory detail);

	public List<Cls_CreateDocumentManagement> document();

	public void groupadd(cls_Group group);

	public List<String> getgroupNames();

	public List<String> listgroup();

	public void hobby(cls_hobby hb);

	public List<String> getCategories();

	public List<String> getCategories2();

	public List<String> cityList(String enquiry_selectedState);

	public cls_Group getEdit1(int id1);

	public void update3(cls_Group edit1);

	public void addContact1(cls_Group edit1);
	
	public List< String> cityList();

	public List<cls_Group> getlist();

	public cls_Group alldata(int int_GroupId);

	public cls_Group getEdit5(int int_GroupId);

	public void deleteInvoice(cls_Group detail);

	public List< String> Categories();

	public List<String> Categor();

	public List< String> company();

	public List< User> getsearch(String str_State,
			String str_Username,String str_blocks);

	public List<User> getgroup();

	public void insertes(GroupMember m1);

	public int adv1(String selectes);

	public cls_Group allname(String str_GroupNm);

	public cls_Group getEdit8(int int_GroupId);

	public void updates(cls_Group edit2);

	public void addsetting(cls_Group edit2);

	public List<String> listblock();

	

	public UserExtraInfo searchuser(Integer int_UserExtraID);

	public UserExtraInfo searchuser1(Integer int_UserId);

	public int searchh(Integer int_UserId);

	public String searchhh(int searchid);

	public UserExtraInfo searchuser12(Integer int_UserExtraID);

	public int searchh1(Integer int_UserExtraID);

	public String  searchhh4(int searchid);

	public User searchhh6(Integer uid);

	public List< String> reside();

	public List<UserExtraInfo> getsearch1(String str_Hobbies, String str_Profession,String residence,String status
			);

	public UserExtraInfo alldatas(Integer int_UserId);

	List<UserExtraInfo> alldatas();

	public int addmember(String selecte);

	public User allnames(String str_Username);

	
	
	

	


	



	

	 



	
	

	

	

	

	

	

	 

	
}

