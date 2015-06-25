package com.appowner.dao;

import java.util.List;

import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.GroupMember;
import com.appowner.model.Option;
import com.appowner.model.Subcript;
import com.appowner.model.User;
import com.appowner.model.UserExtraInfo;
import com.appowner.model.cls_Group;
import com.appowner.model.cls_hobby;

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

	public List getMailIds();

	public String getDocumentName(Integer int_Document_CatID);

	public List getSearchByName(String username);

	public void Deleted(Cls_CreateDocumentManagement category);

	public Cls_CreateDocumentManagement editproduct(int int_DocumentID);

	public int editproductaa(Integer int_DocumentID);

	public String editpro(int prointcatid);

	public void deleteInvoice(Subcript detail);

	public void deleted(Cls_DocumentCategory detail);

	public List document();

	public void groupadd(cls_Group group);

	public List getgroupNames();

	public List<String> listgroup();

	public void hobby(cls_hobby hb);

	public List getCategories();

	public List getCategories2();

	public List cityList(String enquiry_selectedState);

	public cls_Group getEdit1(int id1);

	public void update3(cls_Group edit1);

	public void addContact1(cls_Group edit1);

	public List<String> cityList();

	public List getlist();

	public cls_Group alldata(int int_GroupId);

	public cls_Group getEdit5(int int_GroupId);

	public void deleteInvoice(cls_Group detail);

	public List Categories();

	public List Categor();

	public List company();

	public List<User> getsearch(String str_State,
			String str_Username,String str_blocks);

	public List getgroup();

	public void insertes(GroupMember m1);

	public int adv1(String selectes);

	public cls_Group allname(String str_GroupNm);

	public cls_Group getEdit8(int int_GroupId);

	public void updates(cls_Group edit1);

	public void addsetting(cls_Group edit2);

	public List<String> listblock();

	public List<UserExtraInfo> getsearch1(String str_Hobbies,
			String str_Profession,String residence,String status, String married_status1,int statusid, String block, String str_State, String str_City );

	public UserExtraInfo searchuser(Integer int_UserExtraID);

	public UserExtraInfo searchuser1(Integer int_UserId);

	public int searchh(Integer int_UserId);

	public String searchhh(int searchid);

	public UserExtraInfo searchuser12(Integer int_UserExtraID);

	public int searchh1(Integer int_UserExtraID);

	public String searchhh4(int searchid);

	public User searchhh6(Integer uid);

	public List reside();

	public UserExtraInfo alldatas(Integer int_UserId);

	public int addmember(String selecte);

	public User allnames(String str_Username);

	public List allusers(int int_GroupId);

	public User usrname(String str_Username);

	public int adduser(String selecte);

	public List memberid(String str_Hobbies);

	public String count(int meberids);

	public Cls_CreateDocumentManagement listname(Integer postid);

	public void deletedetail(Cls_CreateDocumentManagement detail);

	public int getname(String intdocid);

	public void updatepost(Cls_CreateDocumentManagement document);

	public void updateposts(Cls_CreateDocumentManagement doc);

	public void updateposts(String txtfile, Integer postid, String path,
			String filename);

	public List getcommiteid();

	public List getgroupid();

	public List getadminname();

	public void deletemembergroup(cls_Group detail);

	public Cls_CreateDocumentManagement getdocdetail(int docid);

	public List getdocdetails(Integer int_Document_CatID);

	public Cls_CreateDocumentManagement getdetail(int docId);

	public List getdocumentdetail(Integer int_Document_CatID);

	public String documentnames(Integer int_Document_CatID);

	public cls_Group groupdetail(int groupId);

	public List getlistgrouo(Integer int_GroupId);

	public cls_Group grouedit(int groupid);

	public cls_Group groupsetting(int groupid);

	public List memberId(String str_Hobbies);

	public List ProfessionId(String str_Profession);

	public List MarriedId(String married_status1);

	public List hobbyId(String hobby);

	public List res_profession(String reistences, String str_Profession);

	public List res_hobby(String reistences, String str_Hobbies);

	public List res_married(String reistences, String married_status1);

	public List res_gender(String reistences, String gender);

	public List pro_hobby(String str_Profession, String str_Hobbies);

	public List pro_married(String str_Profession, String married_status1);

	public List pro_gender(String str_Profession, String gender);

	public List married_gen(String married_status1, String gender);

	public List res_pro_hoby(String reistences, String str_Profession,
			String str_Hobbies);

	public List res_married_gender(String reistences, String married_status1,
			String gender);

	public List res_hobby_gender(String reistences, String str_Hobbies,
			String gender);

	public List stateId(String str_State);

	public List usrId(String str_City, String str_State);

	public List block_usrid(String block);

	public cls_Group getusrid(int memberid);

	public UserExtraInfo getallinfo(int userId);

	public List getuserinformation(String str_Hobby, String str_Profession1,
			String reistence, String gender1, String married_statuss,
			int statusid, String block1, String str_State1, String str_City1);

	
	

	
	

	

	
	
	
	

	 

	
	
	

	 


	






	
	
	

	
	

	 
}
