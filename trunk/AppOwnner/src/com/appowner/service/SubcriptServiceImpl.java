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
import com.appowner.model.UserBlocks;
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

	
	

	
	
	
	}

	 

	
	

	
	

	
	
	
	
	


	 


	 


