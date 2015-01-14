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
import com.appowner.model.GroupMember;
import com.appowner.model.Option;
import com.appowner.model.Subcript;
import com.appowner.model.User;
import com.appowner.model.UserBlocks;
import com.appowner.model.UserExtraInfo;
import com.appowner.model.cls_Group;
import com.appowner.model.cls_hobby;

 
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

	@Override
	public List getMailIds() {
		return getSubcriptDao().getMailIds();
	}
	public String getDocumentName(Integer int_Document_CatID)
	{
		return getSubcriptDao().getDocumentName(int_Document_CatID);
	}

	@Override
	public List getSearchByName(String username) {
		return getSubcriptDao().getSearchByName(username);
	}

	@Override
	public void Deleted(Cls_CreateDocumentManagement category) {
		 getSubcriptDao().Deleted(category);
		
	}

	@Override
	public Cls_CreateDocumentManagement editproduct(int Int_DocumentID) {
		return getSubcriptDao().editproduct(Int_DocumentID);
	}

	@Override
	public int editproductaa(int int_DocumentID) {
		return getSubcriptDao().editproductaa(int_DocumentID);
	}

	@Override
	public int editproductaa(Integer int_DocumentID) {
		return getSubcriptDao().editproductaa(int_DocumentID);
	}

	@Override
	public String editproduct2(int prointcatid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editpro(int prointcatid) {
		return getSubcriptDao().editpro(prointcatid);
	}

	@Override
	public void deleteInvoice(Subcript detail) {
		 getSubcriptDao().deleteInvoice(detail);
		
		
	}

	@Override
	public void deleted(Cls_DocumentCategory detail) {
		 getSubcriptDao().deleted(detail);
		
	}

	@Override
	public List document() {
		return getSubcriptDao().document();
		
	}

	@Override
	public void groupadd(cls_Group group) {
		getSubcriptDao().groupadd( group); 
		
	}

	@Override
	public List getgroupNames() {
		return getSubcriptDao().getgroupNames();
		
	}

	@Override
	public List<String> listgroup()	{
		return getSubcriptDao().listgroup();
	}

	@Override
	public void hobby(cls_hobby hb) {
		getSubcriptDao().hobby( hb);
		
	}

	@Override
	public List getCategories() {
		return getSubcriptDao().getCategories();
	}

	@Override
	public List getCategories2() {
		return getSubcriptDao().getCategories2();
	}

	@Override
	public List cityList(String enquiry_selectedState) {
		return getSubcriptDao().cityList( enquiry_selectedState);
	}

	@Override
	public cls_Group getEdit1(int id1) {
		return getSubcriptDao().getEdit1( id1);
	}

	@Override
	public void update3(cls_Group edit1) {
		 getSubcriptDao().update3(edit1);
		
	}

	@Override
	public void addContact1(cls_Group edit1) {
		getSubcriptDao().addContact1( edit1);
		
	}

	@Override
	public List cityList() {
		return getSubcriptDao().cityList();
	}

	@Override
	public List getlist() {
		return getSubcriptDao().getlist();
	}

	@Override
	public cls_Group alldata(int int_GroupId) {
		return getSubcriptDao().alldata(int_GroupId);	
		}

	@Override
	public cls_Group getEdit5(int int_GroupId) {
		return getSubcriptDao().getEdit5( int_GroupId);
	}

	@Override
	public void deleteInvoice(cls_Group detail) {
		getSubcriptDao().deleteInvoice( detail);
		
	}

	@Override
	public List Categories() {
		return getSubcriptDao().Categories();
	}

	@Override
	public List Categor() {
		return getSubcriptDao().Categor();
	}

	@Override
	public List company() {
		return getSubcriptDao().company();
	}

	@Override
	public List<User> getsearch(String str_State,
			String str_Username, String str_blocks) {
		return getSubcriptDao().getsearch(str_State,  
			 str_Username,str_blocks);
	}

	@Override
	public List getgroup() {
		return getSubcriptDao().getgroup();
	}

	@Override
	public void insertes(GroupMember m1) {
		getSubcriptDao().insertes( m1);
		
	}

	@Override
	public int adv1(String selectes) {
		return getSubcriptDao().adv1( selectes);
	}

	@Override
	public cls_Group allname(String str_GroupNm) {
		return getSubcriptDao().allname(str_GroupNm);
	
	}

	@Override
	public cls_Group getEdit8(int int_GroupId) {
		return getSubcriptDao().getEdit8( int_GroupId);
	}

	@Override
	public void updates(cls_Group edit2) {
		getSubcriptDao().updates(edit2);
		
	}

	@Override
	public void addsetting(cls_Group edit2) {
		getSubcriptDao().addsetting( edit2);
		
	}

	@Override
	public List listblock() {
		return getSubcriptDao().listblock();
	}

	@Override
	public List<UserExtraInfo> getsearch1(String str_Hobbies,
			String str_Profession,String residence,String status) {
		return getSubcriptDao().getsearch1( str_Hobbies,
				 str_Profession,residence,status);
	}

	@Override
	public UserExtraInfo searchuser(Integer int_UserExtraID) {
		return getSubcriptDao().searchuser( int_UserExtraID);
	}

	@Override
	public UserExtraInfo searchuser1(Integer int_UserId) {
		return getSubcriptDao().searchuser1(int_UserId);
	}

	@Override
	public int searchh(Integer int_UserId) {
		return getSubcriptDao().searchh(int_UserId);
	}

	@Override
	public String searchhh(int searchid) {
		return getSubcriptDao().searchhh( searchid);
	}

	@Override
	public UserExtraInfo searchuser12(Integer int_UserExtraID) {
		return getSubcriptDao().searchuser12( int_UserExtraID);
	}

	@Override
	public int searchh1(Integer int_UserExtraID) {
		return getSubcriptDao().searchh1( int_UserExtraID);
	}

	@Override
	public String searchhh4(int searchid) {
		return getSubcriptDao().searchhh4(searchid);
	}

	@Override
	public User searchhh6(Integer uid) {
		return getSubcriptDao().searchhh6( uid);
	}

	@Override
	public List reside() {
		return getSubcriptDao(). reside() ;
	}

	@Override
	public UserExtraInfo alldatas(Integer int_UserId) {
		return getSubcriptDao().alldatas( int_UserId);
	}

	@Override
	public List alldatas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addmember(String selecte) {
		return getSubcriptDao().addmember(selecte);
	}

	@Override
	public User allnames(String str_Username) {
		return getSubcriptDao().allnames( str_Username);
	}

	@Override
	public List allusers(int int_GroupId ) {
		return getSubcriptDao().allusers(int_GroupId);
	}

	@Override
	public User usrname(String str_Username) {
		return getSubcriptDao().usrname(str_Username);
	}

	@Override
	public int adduser(String selecte) {
		return getSubcriptDao().adduser( selecte);
	}

	@Override
	public List memberid(String str_Hobbies, String str_Profession) 
	{
		return getSubcriptDao().memberid(str_Hobbies,  str_Profession); 
	}

	
	
	

	}
	
	
	

	 

	
	

	
	

	
	
	
	
	


	 


	 


