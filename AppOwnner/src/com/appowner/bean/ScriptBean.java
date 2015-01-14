package com.appowner.bean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.springframework.dao.DataAccessException;

import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.Company;
import com.appowner.model.GroupMember;
import com.appowner.model.Option;
import com.appowner.model.Subcript;
import com.appowner.model.User;
import com.appowner.model.UserExtraInfo;
import com.appowner.model.cls_Group;
import com.appowner.model.cls_hobby;
import com.appowner.service.SubcriptService;
import com.appowner.util.Util;
import com.ibm.icu.text.SimpleDateFormat;

@ManagedBean
@SessionScoped
public class ScriptBean implements Serializable{
	
		private static final long serialVersionUID = 1L;
		private String error;
		/*getting the name of doc cat*/
		private String intdocid;
		public String Aprid;
		private int getdocid;
		private String Dt_Date;
		private String str_FileNM;
		private String Ch_Access;
		private Boolean Bit_emailsend;
		private String Var_ImageName;
		private String str_FolderNM;
		private String str_Description;
		private String subscriptname;    
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}

		private float price;       
	    private Integer subcriptID;
	    private Integer SubcriptionID;
	    private Integer sizeinkb;
	    private String uploadedon;
	    private String uploadedby;
	    public int intdocID;
	    public int   AprID; 
	    private int id;
	    public String username;
	    
	    
		private Integer int_ApartmentId;
	   
	    public String getIntdocid() {
			return intdocid;
		}
		public void setIntdocid(String intdocid) {
			this.intdocid = intdocid;
		}
 
	    private Integer flag;
	    private int userId;
	    private String str_ApartmentName;
		   public String getStr_ApartmentName() {
			  str_ApartmentName=Util.getAppartmentName();
			   System.out.println(str_ApartmentName);
				return str_ApartmentName;
			}
			public void setStr_ApartmentName(String str_ApartmentName) {
				this.str_ApartmentName = str_ApartmentName;
			}
	       public int getUserId() {
		   userId=Util.getUserId();
		
				return userId;
			}
			public void setUserId(int userId) {
				this.userId = userId;
			}
	public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
	 
	
	 
	 
		
	public void setId(int id) {
		this.id = id;
	}
		public String getUploadedon() {
		return uploadedon;
	}
	public void setUploadedon(String uploadedon) {
		this.uploadedon = uploadedon;
	}
	public String getUploadedby() {
		return uploadedby;
	}
	public void setUploadedby(String uploadedby) {
		this.uploadedby = uploadedby;
	}
		public int getGetdocid() {
			return getdocid;
		}
		public void setGetdocid(int getdocid) {
			this.getdocid = getdocid;
		}
		private String str_DocumentName;
		public String getStr_DocumentName() {
			return str_DocumentName;
		}
		public void setStr_DocumentName(String str_DocumentName) {
			this.str_DocumentName = str_DocumentName;
		}
		@SuppressWarnings("rawtypes")
		public List getList2() {
			return list2;
		}
		public Integer getInt_ApartmentId() {
			return int_ApartmentId;
		}
		public void setInt_ApartmentId(Integer int_ApartmentId) {
			this.int_ApartmentId = int_ApartmentId;
		}
		@SuppressWarnings("rawtypes")
		public void setList2(List list2) {
			this.list2 = list2;
		}
		


		public Boolean getBit_emailsend() {
			return Bit_emailsend;
		}
		public void setBit_emailsend(Boolean bit_emailsend) {
			Bit_emailsend = bit_emailsend;
		}

		//public int intdocID;
		private List<String> subscriptnames;
		@SuppressWarnings("unchecked")
		public List<String> getSubscriptnames() {
			subscriptnames=new ArrayList<String>();
			subscriptnames.addAll(getSubcriptService().getSubscriptnames());
			System.out.println(subscriptnames);
			return subscriptnames;
		}
		public void setSubscriptnames(List<String> subscriptnames) {
			this.subscriptnames = subscriptnames;
		}
		
		
		private String Action;
		
		private List<String> int_Document_CatNM1;
		@SuppressWarnings("unchecked")
		public List<String> getInt_Document_CatNM1(){
		int_Document_CatNM1=new ArrayList<String>();
		int_Document_CatNM1.addAll( getSubcriptService().getInt_Document_CatNM1());
			System.out.println(int_Document_CatNM1);
			
			return int_Document_CatNM1;
		}
		private List<String> list3=new ArrayList<String>();
		public List<String> getList3() {
			return list3;
		}
		
	 public Integer getSizeinkb() {
			return sizeinkb;
		}
		public void setSizeinkb(Integer sizeinkb) {
			this.sizeinkb = sizeinkb;
		}

	private List<String> optionNames;
		@SuppressWarnings("unchecked")
		public List<String> getOptionNames() {
			optionNames=new ArrayList<String>();
			optionNames.addAll( getSubcriptService().getOptionNames());
			System.out.println(optionNames);
			
			return optionNames;
		}
		private List<String> list=new ArrayList<String>();
		public void setOptionNames(List<String> optionNames) {
			this.optionNames = optionNames;
		}
        public Integer getInt_Document_CatID() {
			return Int_Document_CatID;
		}
		public void setInt_Document_CatID(Integer int_Document_CatID) {
			Int_Document_CatID = int_Document_CatID;
		}
		public void setList3(List<String> list3) {
			this.list3 = list3;
		}
		public void setInt_Document_CatNM1(List<String> int_Document_CatNM1) {
			this.int_Document_CatNM1 = int_Document_CatNM1;
		}
		public Integer getIsActive() {
			return isActive;
		}
		public void setIsActive(Integer isActive) {
			this.isActive = isActive;
		}
		public Integer getIsDelete() {
			return isDelete;
		}
		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}
		
		private Integer Int_Document_CatID;
		private Integer isActive;
	
		private Integer isDelete;
			private char Ch_Category_Status;
		
     public char getCh_Category_Status() {
				return Ch_Category_Status;
			}
			public void setCh_Category_Status(char ch_Category_Status) {
				Ch_Category_Status = ch_Category_Status;
			}

	private int int_OptionId;
		public int getInt_OptionId() {
		return int_OptionId;
	}
	public void setInt_OptionId(int int_OptionId) {
		this.int_OptionId = int_OptionId;
	}
		
	    public Integer getSubcriptionID() {
		return SubcriptionID;
	}
	    public String getInt_Document_CatNM() {
	    	return int_Document_CatNM;
	    }
	    public void setInt_Document_CatNM(String int_Document_CatNM) {
	    	this.int_Document_CatNM = int_Document_CatNM;
	    }

	public void setSubcriptionID(Integer subcriptionID) {
		SubcriptionID = subcriptionID;
	}private String optionName;
	    
private String str_ServiceName;
		 
		public String getStr_ServiceName() {
		return str_ServiceName;
	}
	public List<String> getSname() {
			return sname;
		}
	public void setStr_ServiceName(String str_ServiceName) {
		this.str_ServiceName = str_ServiceName;
	}

 
	private List<String> sname=new ArrayList<String>();
 
 
		public void setSname(List<String> sname) {
		this.sname = sname;
	}
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
		private String email;

		public List<String> getList() {
	return list;
}
public void setList(List<String> list) {
	this.list = list;
}
		public Integer getSubcriptID() {
			return subcriptID;
		}
		public void setSubcriptID(Integer subcriptID) {
			this.subcriptID = subcriptID;
		}
		public String getOptionName() {
			return optionName;
		}
		public void setOptionName(String optionName) {
			this.optionName = optionName;
		}
		public String getAction() {
			return Action;
		}
		public void setAction(String action) {
			Action = action;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getStr_Description() {
			return str_Description;
		}
		public void setStr_Description(String str_Description) {
			this.str_Description = str_Description;
		}
		
		private String int_Document_CatNM;
private Integer Int_DocumentID;
		
		
public Integer getInt_UserId() {
	return int_UserId;
}
public void setInt_UserId(Integer int_UserId) {
	this.int_UserId = int_UserId;
}


	public Integer getInt_DocumentID() {
			return Int_DocumentID;
		}

		public void setInt_DocumentID(Integer int_DocumentID) {
			Int_DocumentID = int_DocumentID;
		}

		public String getStr_FileNM() {
			return str_FileNM;
		}

		public void setStr_FileNM(String str_FileNM) {
			this.str_FileNM = str_FileNM;
		}

	public String getCh_Access() {
			return Ch_Access;
		}

		public void setCh_Access(String ch_Access) {
			Ch_Access = ch_Access;
		}

		

		public String getDt_Date() {
			return Dt_Date;
		}

		public void setDt_Date(String dt_Date) {
			Dt_Date = dt_Date;
		}

		public String getStr_FolderNM() {
			return str_FolderNM;
		}

		public void setStr_FolderNM(String str_FolderNM) {
			this.str_FolderNM = str_FolderNM;
		}
public String getSubscriptname() {
			return subscriptname;
		}
		public void setSubscriptname(String subscriptname) {
			this.subscriptname = subscriptname;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	
		@SuppressWarnings("unchecked")
		public void serviceListener(ValueChangeEvent event)
		{
			 list.addAll((List<String>) event.getNewValue());
			System.out.println(list);
			//System.out.println(list);
		}

@SuppressWarnings("rawtypes")
public void AddSubscription()

{	 System.out.println("kalpana");
	System.out.println(list);
	ListIterator itr1=list.listIterator();
	System.out.println("hello");
		while(itr1.hasNext())
   {
	   System.out.println("mukesh");
	   Object o=itr1.next();
	  // optionName =itr1.next();
	   optionName= (String) o;
	   System.out.println( optionName);
	   s.setStr_ServiceName( optionName);
	   s.setInt_OptionId(getSubcriptService().getInt_OptionId(optionName));;
	   //subcriptID=getSubcriptService().getSubcriptID1(str_ServiceName);
	    
	   s.setSubcriptID( getSubcriptService().getSubcriptID1(subscriptname));
	   getSubcriptService().addService(s);
   }
	   
   }
private Cls_CreateDocumentManagement m=new Cls_CreateDocumentManagement();
public Cls_CreateDocumentManagement getM() {
	return m;
}
public void setM(Cls_CreateDocumentManagement m) {
	this.m = m;

}
@SuppressWarnings("rawtypes")
public void AddDocManagement()

{	 	System.out.println("hiiiiii");
	System.out.println(list3);
	ListIterator itr1=list.listIterator();
	System.out.println("hello");
		while(itr1.hasNext())
   {
	   System.out.println("mukesh");
	   Object p=itr1.next();
	   int_Document_CatNM= (String) p;
	   System.out.println(int_Document_CatNM);
	  
	    m.setInt_Document_CatID(getSubcriptService().getInt_Document_CatID1(int_Document_CatNM));
	  getSubcriptService().addmanagement(m);
   }
}
  
@SuppressWarnings("rawtypes")
		@ManagedProperty(value = "#{SubcriptService}")
		private SubcriptService subcriptService;
		
		@SuppressWarnings("rawtypes")
		public SubcriptService<?> getSubcriptService() {
			return subcriptService;
		}
		@SuppressWarnings("rawtypes")
		public void setSubcriptService(SubcriptService subcriptService) {
			this.subcriptService = subcriptService;
		}
		public String addUser()
		{  
			String subscriptname=getSubscriptname();
			System.out.println(subscriptname);
			Integer subcriptID=getSubcriptService().getSubscriptname1(subscriptname);
			System.out.println(subcriptID);
			if(subcriptID!=null )
			{
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("SubcriptionName Already Exists"));
				 return null;
			}
			else
			{
			Subcript usr=new Subcript();
		
			
			usr.setSubscriptname(getSubscriptname());
			
			usr.setPrice(getPrice());
			 
			 getSubcriptService().addUsers(usr);
			
			return "";
			}
			
		}private String path1;
		public String getPath1() {
			return path1;
		}
		public void setPath1(String path1) {
			this.path1 = path1;
		}
		private static List<String> mailids;
		private static String content="content";
		private static String subject="subject";
		
	public static String getContent() {
			return content;
		}
		public static void setContent(String content) {
			ScriptBean.content = content;
		}
		public static String getSubject() {
			return subject;
		}
		public static void setSubject(String subject) {
			ScriptBean.subject = subject;
		}
	public static String getMailids() {
		System.out.println("hi");
		StringBuilder out=new StringBuilder();
		for(Object o:mailids)
		{
			out.append(o.toString());
		    out.append(",");
			
		}
		System.out.println(out.toString());
			return out.toString();
		}
		public static void setMailids(List<String> mailids) {
			ScriptBean.mailids = mailids;
		}
		private int size;
	public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
	//For create Document
	@SuppressWarnings("unchecked")
	public String document()
		{
		try{
		intdocid=getInt_Document_CatNM();
		System.out.println(intdocid);
		intdocID= getSubcriptService().getdocid1(intdocid);	
		Cls_CreateDocumentManagement d=new Cls_CreateDocumentManagement();
		    d.setInt_Document_CatID(intdocID);
			d.setBit_emailsend(getBit_emailsend());
			
			d.setCh_Access(getCh_Access());
			d.setDt_Date(getDt_Date());
			d.setStr_Description(getStr_Description());
		    d.setStr_FileNM(path1);
			System.out.println(path1);
			d.setInt_Userid(getUserId());
			d.setInt_ApartmentID(Util.getAppartmentId());
			d.setUsername(Util.getUserName());
			d.setStr_FolderNM("image");
			d.setStr_ApartmentName(getStr_ApartmentName());
			//d.setInt_Document_CatNM(getInt_Document_CatNM());
			//d.setInt_Document_CatNM("Circulars");
			d.setSize(size);
			d.setAction("");
			d.setInt_DocumentID(getInt_DocumentID());
			getSubcriptService().documents(d);
			if(Bit_emailsend==true)
			{  System.out.println(Bit_emailsend);
				mailids=getSubcriptService().getMailIds();
				System.out.println(mailids);
				content="Appowner.com";
				System.out.println(content);
				subject="hello";
				System.out.println(subject);
				return "CreateDocument1.jsp";
			
			}
			return null;
		}
			
		catch(DataAccessException e)
		{e.printStackTrace();
			
		}
		return null;
		}
			public String addOption()
		{  
			String optionname=getOptionName();
			System.out.println(optionname);
			Integer optnid=getSubcriptService().getInt_OptionId1(optionname);
			System.out.println(optnid);
			if(optnid!=null )
			{
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("OptionName Already Exists"));
				 return null;
			}
			else
			{
			 
			Option usr1=new Option();
	        usr1.setOptionName(getOptionName());
			getSubcriptService().addOptions(usr1);
			return "";
			
		}
	 
		}
			
		private Cls_DocumentCategory D=new Cls_DocumentCategory();
		public Cls_DocumentCategory getD() {
			return D;
		}
		public void setD(Cls_DocumentCategory D) {
			this.D = D;
	
		}

		private Cls_SubcriptionOption s=new Cls_SubcriptionOption();

		
	public Cls_SubcriptionOption getS() {
			return s;
		}
		public void setS(Cls_SubcriptionOption s) {
			this.s = s;
	
		}
public List<Subcript> getListSubcript() {
	return ListSubcript;
}
public void setListSubcript(List<Subcript> listSubcript){
	ListSubcript = listSubcript;
}

@SuppressWarnings("rawtypes")
private List list2=new ArrayList();
@SuppressWarnings("unchecked")
public void addDocumentListener(ValueChangeEvent event)
{
list2.add(event.getNewValue());	
}
public void AddDocument()

{	 	
	System.out.println(list2);
	@SuppressWarnings("rawtypes")
	ListIterator itr2=list2.listIterator();
	System.out.println("hello");
		while(itr2.hasNext())
   {
	   System.out.println("mukesh");
	   Object o=itr2.next();
	 
	    str_DocumentName= (String) o;
	    D.setInt_Document_CatNM(str_DocumentName);
	    D.setCh_Category_Status('C');
	    D.setFlag(2);
	   getSubcriptService().AddDocument1(D);
   }
	   
   } 
private List<Cls_CreateDocumentManagement> ListCreatedocument;
@SuppressWarnings("unchecked")
public List<Cls_CreateDocumentManagement> getListCreatedocument()
{
	System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	ListCreatedocument=new ArrayList<Cls_CreateDocumentManagement>();
	ListCreatedocument.addAll(getSubcriptService().getListCreatedocument());
	ListIterator list=ListCreatedocument.listIterator();
	while(list.hasNext())
	{
		Object obj=list.next();
		Cls_CreateDocumentManagement aa=(Cls_CreateDocumentManagement)obj;
		Int_Document_CatID=aa.getInt_Document_CatID();
		intdocid=getSubcriptService().getDocumentName(Int_Document_CatID);
		System.out.println(intdocid);
	}
	return ListCreatedocument;
}
public void setListCreatedocument(List<Cls_CreateDocumentManagement> listCreatedocument) {
	this.ListCreatedocument = listCreatedocument;
}
private List<Subcript> ListSubcript;
@SuppressWarnings("unchecked")
public List<Subcript> getListUser() {
	ListSubcript= new ArrayList<Subcript>();
		ListSubcript.addAll( getSubcriptService().listSubcripts());
	
	return ListSubcript;
}
public void setListUser(List<Subcript> listSubcript) {
	this.ListSubcript = listSubcript;
}
private List<Cls_SubcriptionOption> scriptionOptionList;
@SuppressWarnings("unchecked")
public List<Cls_SubcriptionOption> getScriptionOptionList() {
	scriptionOptionList=new ArrayList<Cls_SubcriptionOption>();
	scriptionOptionList.addAll(getSubcriptService().getScriptionOptionList());
	
	return scriptionOptionList;
}
public void setScriptionOptionList(
		List<Cls_SubcriptionOption> scriptionOptionList) {
	this.scriptionOptionList = scriptionOptionList;
}
	 
 private List<Cls_DocumentCategory> documentList;

@SuppressWarnings("unchecked")
public List<Cls_DocumentCategory> getDocumentList()
{
	documentList=new ArrayList<Cls_DocumentCategory>();
	documentList.addAll(getSubcriptService().getDocumentList());
	System.out.println(documentList);

	return documentList;
}
public void setDocumentList(
		List<Cls_DocumentCategory> documentList) {
	this.documentList = documentList;
}

//Search
/*private List<Cls_CreateDocumentManagement> SearchByName;

@SuppressWarnings("unchecked")
public List<Cls_CreateDocumentManagement> getSearchByName() {
	SearchByName=new ArrayList<Cls_CreateDocumentManagement>();
	SearchByName.addAll(getSubcriptService().getSearchByName(username));
		return SearchByName;
		
		
}
     @SuppressWarnings("unchecked")
	public String getSearchByProducttype1()
	{
    	 SearchByName=new ArrayList<Cls_CreateDocumentManagement>();
		 System.out.println(username);
		 SearchByName.addAll(getSubcriptService().getSearchByName(username));
		return "DocumentRepository.xhtml?faces-redirect=true";
	}
     public void setSearchByName(List<Cls_CreateDocumentManagement> searchByName) {
 		SearchByName = searchByName;
 	}
	
*/
private List<Cls_CreateDocumentManagement> SearchByName;

@SuppressWarnings("unchecked")
public List<Cls_CreateDocumentManagement> getSearchByName() {
	System.out.println("hhhhhhhhhhhhhhhhhhhhhhh");
	SearchByName=new ArrayList<Cls_CreateDocumentManagement>();
	SearchByName.addAll(getSubcriptService().getSearchByName(username));
		return SearchByName;
	
}
@SuppressWarnings("unchecked")
public String getSearchByProducttype1()
{
	 SearchByName=new ArrayList<Cls_CreateDocumentManagement>();
	 System.out.println(username);
	 SearchByName.addAll(getSubcriptService().getSearchByName(username));
	return "DocumentRepository.xhtml?faces-redirect=true";
}
 

public void setSearchByName(List<Cls_CreateDocumentManagement> searchByName) {
	SearchByName = searchByName;
}


// File Upload



public void handleFileUpload(FileUploadEvent event) throws IOException {
	 System.out.println("hi");
	 size=event.getFile().getFileName().length();
	 String path = FacesContext.getCurrentInstance().getExternalContext()
	            .getRealPath("/");
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	    String name = fmt.format(new Date())
	            +event.getFile().getFileName().substring(
	                  event.getFile().getFileName().lastIndexOf('.'));
	    System.out.println(name);
	    File file= new File("D://Image\\"+ "images" + name);
        System.out.println(file);
	    InputStream is = event.getFile().getInputstream();
	    OutputStream out = new FileOutputStream(file);
	    byte buf[] = new byte[1024];
	    int len;
	    while ((len = is.read(buf)) > 0)
	        out.write(buf, 0, len);
	    is.close();
	    out.close();
	    path1=file.getName();
	    System.out.println(path1);
}

public String deletedocument1(int id)
{
	System.out.println(id);
	Cls_CreateDocumentManagement document=new Cls_CreateDocumentManagement();
	document.setInt_DocumentID(id);
	getSubcriptService().Deleted(document);
	return "DocumentList.xhtml";
	
}
private Cls_CreateDocumentManagement pro2;

public Cls_CreateDocumentManagement getPro2() {
	return pro2;
}
public void setPro2(Cls_CreateDocumentManagement pro2) {
	this.pro2 = pro2;
}
private int prointcatid;

public int getProintcatid() {
	return prointcatid;
}
public void setProintcatid(int prointcatid) {
	this.prointcatid = prointcatid;
}
public void getview(){
	System.out.println(Int_DocumentID);
	pro2=getSubcriptService().editproduct(Int_DocumentID);
System.out.println("111111111111111111111111111111111111111111");
	System.out.println(pro2.getInt_ApartmentID());
	prointcatid=getSubcriptService().editproductaa(pro2.getInt_DocumentID());
	System.out.println("222222222222222222222222222");
	System.out.println(prointcatid);
	pro1=getSubcriptService().editpro(prointcatid);
	System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	System.out.println(pro1);

}
private String pro1;
public String getPro1() {
	return pro1;
}
public void setPro1(String pro1) {
	this.pro1 = pro1;
}



private Cls_CreateDocumentManagement pro;
public Cls_CreateDocumentManagement getPro() {
	return pro2;
}
public void setPro(Cls_CreateDocumentManagement pro2) {
	this.pro2 = pro2;
}


public String deleted(){
	Subcript detail=new Subcript();
	System.out.println(subcriptID);
	detail.setSubcriptID(subcriptID);
	getSubcriptService().deleteInvoice(detail);
	return "SubcriptionList.xhtml?faces-redirect=true";
  
}

public String delete(){
	Cls_DocumentCategory detail=new Cls_DocumentCategory();
	System.out.println(Int_Document_CatID);
	detail.setInt_Document_CatID(Int_Document_CatID);
	getSubcriptService().deleted(detail);
	return "DocumentList.xhtml?faces-redirect=true";
  
}
private List<Cls_CreateDocumentManagement>listdoc;
public List<Cls_CreateDocumentManagement> getListdoc(){
	listdoc=new ArrayList<Cls_CreateDocumentManagement>();
	listdoc.addAll(getSubcriptService().document());
	System.out.println(listdoc);
	
	return listdoc;
}
public void setListdoc(List<Cls_CreateDocumentManagement> listdoc) {
	this.listdoc = listdoc;
}



// Group Details///////////////////////////
private int int_GroupId;
private String str_GroupNm;
private  String str_Groupaddress;
private String  str_groupPrivate;
private String str_GroupDescription;
private char isCh_EmailAllow;




public char getIsCh_EmailAllow() {
	return isCh_EmailAllow;
}
public void setIsCh_EmailAllow(char isCh_EmailAllow) {
	this.isCh_EmailAllow = isCh_EmailAllow;
}

private int ApartementId;



public String getStr_GroupDescription() {
	return str_GroupDescription;
}
public void setStr_GroupDescription(String str_GroupDescription) {
	this.str_GroupDescription = str_GroupDescription;
}
public int getInt_GroupId() {
	return int_GroupId;
}public void setInt_GroupId(int int_GroupId) {
	this.int_GroupId = int_GroupId;
}public String getStr_GroupNm() {
	return str_GroupNm;
}public void setStr_GroupNm(String str_GroupNm) {
	this.str_GroupNm = str_GroupNm;
}public String getStr_Groupaddress() {
	return str_Groupaddress;
}public void setStr_Groupaddress(String str_Groupaddress) {
	this.str_Groupaddress = str_Groupaddress;
}public String getStr_groupPrivate() {
	return str_groupPrivate;
}
public void setStr_groupPrivate(String str_groupPrivate) {
	this.str_groupPrivate = str_groupPrivate;
}




public int getApartementId() {
	return ApartementId;
}
public void setApartementId(int apartementId) {
	ApartementId = apartementId;
}



public String group()
{
	cls_Group group=new cls_Group();
	group.setStr_GroupNm(getStr_GroupNm());
	group.setStr_Groupaddress(getStr_Groupaddress());
	group.setStr_GroupDescription(getStr_GroupDescription());
	group.setStr_groupPrivate(getStr_groupPrivate());
	group.setIsCh_EmailAllow(getIsCh_EmailAllow());
	group.setBol_Emailallow(getBol_Emailallow());
	group.setBol_Smsallow(getBol_Smsallow());
	System.out.println(isCh_EmailAllow+"uhujhju");
  
	group.setInt_ApartmentID(Util.getAppartmentId());
	group.setUserId(Util.getUserId());
	getSubcriptService().groupadd(group);
	return "Create-SubGroup.xhtml";
	
	
}
private List<String> groupNames;
@SuppressWarnings("unchecked")
public List<String> getGroupNames() {
	groupNames=new ArrayList<String>();
	groupNames.addAll( getSubcriptService().getgroupNames());
	System.out.println(groupNames);
	
	return optionNames;
}

public void setGroupNames(List<String> groupNames) {
	this.groupNames = groupNames;
}
public   boolean select;



public boolean isSelect() {
	return select;
}
public void setSelect(boolean select) {
	this.select = select;
}

public List<String> group1;

public boolean selectingroup(ValueChangeEvent event)
{  
	group1=new ArrayList<String>();
	str_group =(boolean) event.getNewValue();
	System.out.println(str_group+"jhdsjdf");
	group1.addAll(getSubcriptService().listblock());
	System.out.println(group1+"jhjjh");
	return str_group ;
	}




public List<String> getGroup1() {
	return group1;
}
public void setGroup1(List<String> group1) {
	this.group1 = group1;
}




public List<String> group2;

public List<String> getGroup2() {
	return group2;
}
public void setGroup2(List<String> group2) {
	this.group2 = group2;
}
private List<String> residing;

public List<String> getResiding() {
	return residing;
}
public void setResiding(List<String> residing) {
	this.residing = residing;
}

private boolean str_group;
public boolean isStr_group() {
	return str_group;
}
public void setStr_group(boolean str_group) {
	this.str_group = str_group;
}



public String select1;

public String getSelect1() {
	return select1;
}
public void setSelect1(String select1) {
	this.select1 = select1;
}
public String selectinfo1(ValueChangeEvent event)
{  
	select1 =( String )event.getNewValue();
	System.out.println(select1+"jhnhjj");
	return  "";
}
private boolean str_owner;



public boolean isSelect2() {
	return select2;
}
public void setSelect2(boolean select2) {
	this.select2 = select2;
}
public boolean isStr_owner() {
	return str_owner;
}
public void setStr_owner(boolean str_owner) {
	this.str_owner = str_owner;
}

public boolean select2;
private boolean residence;

public String selectinfo2(ValueChangeEvent event)
{  
	str_owner =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}
private boolean str_residence;

public boolean isStr_residence() {
	return str_residence;
}
public void setStr_residence(boolean str_residence) {
	this.str_residence = str_residence;
}
public String selectinfo3(ValueChangeEvent event)
{  
	str_residence =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}
private int hobbyid;

private String HobbyName;
public int getHobbyid() {
	return hobbyid;
}
public void setHobbyid(int hobbyid) {
	this.hobbyid = hobbyid;
}
public String getHobbyName() {
	return HobbyName;
}
public void setHobbyName(String hobbyName) {
	HobbyName = hobbyName;
}
public String hobbies()
{
	cls_hobby hb=new cls_hobby();
	hb.setHobbyName(getHobbyName());
	getSubcriptService().hobby(hb);
	return "";
}

public boolean Filter;



public boolean isFilter() {
	return Filter;
}
public void setFilter(boolean filter) {
	Filter = filter;
}
public String selectinfo4(ValueChangeEvent event)
{  
	Filter =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}

private List<String>Categories;
public List<String> getCategories() 
{
Categories=new ArrayList<String>();
Categories.addAll(getSubcriptService().getCategories());
System.out.println(Categories);
return Categories;
}
public void setCategories(List<String> categories) {
	this.Categories = categories;

}

public boolean str_hobby;
public boolean isStr_hobby() {
	return str_hobby;
}
public void setStr_hobby(boolean str_hobby) {
	this.str_hobby = str_hobby;
}

public String selectinfo6(ValueChangeEvent event)
{  
	str_hobby =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}

public boolean var_hobby;

public boolean isVar_hobby() {
	return var_hobby;
}
public void setVar_hobby(boolean var_hobby) {
	this.var_hobby = var_hobby;
}
public String selectinfo7(ValueChangeEvent event)
{  
	var_hobby =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}
private Boolean bol_Smsallow;

private Boolean bol_Emailallow;


public boolean martial;
public boolean isMartial() {
	return martial;
}
public void setMartial(boolean martial) {
	this.martial = martial;
}
public String selectinfo8(ValueChangeEvent event)
{  
	martial =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}


private List<String>Categories2;
public List<String> getCategories2() 
{
Categories2=new ArrayList<String>();
Categories2.addAll(getSubcriptService().getCategories2());
System.out.println(Categories2);
return Categories2;
}
public void setCategories2(List<String> categories2) {
	this.Categories2 = categories2;

}


public boolean str_state;
public boolean isStr_state() {
	return str_state;
}
public void setStr_state(boolean str_state) {
	this.str_state = str_state;
}



public String selectinfo9(ValueChangeEvent event)
{  
	str_state =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}

public String  enquiry_selectedState;

public String enquiry_selectedCity;
private List<String> enquiry_selecteCities;
private List<String> cityList;
public List<String> cityListByState;




public List<String> getCityList() {
	return cityList;
}
public void setCityList(List<String> cityList) {
	this.cityList = cityList;
}
public List<String> getCityListByState() {
	return cityListByState;
}
public List<String> getEnquiry_selecteCities() {
	if(enquiry_selectedState!=null)
	   {
		   return cityListByState;
	   }
	   else
		   
		   return new ArrayList<String>();

	
}
public void setEnquiry_selecteCities(List<String> enquiry_selecteCities) {
	this.enquiry_selecteCities = enquiry_selecteCities;
}
public String getEnquiry_selectedState() {
	return enquiry_selectedState;
}
public String getEnquiry_selectedCity() {
	return enquiry_selectedCity;
}
public void setEnquiry_selectedCity(String enquiry_selectedCity) {
	this.enquiry_selectedCity = enquiry_selectedCity;
}
public void setEnquiry_selectedState(String enquiry_selectedState) {
	this.enquiry_selectedState = enquiry_selectedState;
}
public void setCityListByState(List<String> cityListByState) {
	this.cityListByState = cityListByState;
}

public List<String> stateChangeListener(ValueChangeEvent event)
{  
      enquiry_selectedState=(String)event.getNewValue();
      System.out.println(enquiry_selectedState);
		cityListByState=new ArrayList<String>();
		cityListByState.addAll(getSubcriptService().cityList(enquiry_selectedState));
           System.out.println(cityListByState);
           return cityListByState;
	}
	 
private cls_Group edit1 ;


public cls_Group getEdit1() {
	return edit1;
}
public void setEdit1(cls_Group edit1) {
	this.edit1 = edit1;
}
public void getedit1()
{ 
	
edit1=new cls_Group();
System.out.println(int_GroupId);

edit1 =getSubcriptService().getEdit5(int_GroupId);
System.out.println(edit1);
}


public String saveContact1( )
{
	System.out.println("hjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjh");
	System.out.println(bol_Smsallow);
	 if(edit1.getInt_GroupId()!=null)
	 
		 getSubcriptService().update3(edit1);
	else		
		getSubcriptService().addContact1(edit1);
     return "Sub-GroupDetail.xhtml";
	 
}


private List<cls_Group> userlist;

	

public List<cls_Group> getUserlist() {
	userlist=new ArrayList<cls_Group>();
	userlist.addAll(getSubcriptService().getlist());
	System.out.println(userlist);
	return userlist;
}
public void setUserlist(List<cls_Group> userlist) {
	this.userlist = userlist; 
}



private cls_Group groups;
public cls_Group getGroups() {
	
	return groups;
}
public void setGroups(cls_Group groups) {
	this.groups = groups;
}


public void Subgroup()
{
	groups=getSubcriptService().alldata(int_GroupId);
}


public String deletedetail(){
	cls_Group detail=new cls_Group();
	System.out.println(int_GroupId);
	detail.setInt_GroupId(int_GroupId);
	getSubcriptService().deleteInvoice(detail);
	return "Create-SubGroup.xhtml?faces-redirect=true";
  
}

public String cancel() {
	return "Sub-GroupDetail.xhtml?faces-redirect=true";
	
	
}

private List<String>categories8;
public List<String> getCategories8() 
{
	categories8=new ArrayList<String>();
	categories8.addAll(getSubcriptService().Categories());
System.out.println(categories8);
return categories8;
}
public void setCategories8(List<String> categories8) {
	this.categories8 = categories8;
}

private List<String>categories9;
public List<String> getCategories9() 
{
	categories9=new ArrayList<String>();
	categories9.addAll(getSubcriptService().Categor());
System.out.println(categories9);
return categories9;
}
public void setCategories9(List<String> categories9) {
	this.categories9 = categories9;
}


private boolean male;
public boolean isMale() {
	return male;
}
public void setMale(boolean male) {
	this.male = male;
}
public String selectinfoq(ValueChangeEvent event)
{  
	male =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}


private List<String>addcompany;
public List<String> getAddcompany() {
	addcompany=new ArrayList<String>();
	addcompany.addAll(getSubcriptService().company());
	return addcompany;
}
public void setAddcompany(List<String> addcompany) {
	this.addcompany = addcompany;
}



private String str_State;
private String str_City;
public String getStr_Username() {
	return str_Username;
}
public void setStr_Username(String str_Username) {
	this.str_Username = str_Username;
}

private String str_Block;
private String str_Username;


public String getStr_State() {
	return str_State;
}
public void setStr_State(String str_State) {
	this.str_State = str_State;
}
public String getStr_City() {
	return str_City;
}
public void setStr_City(String str_City) {
	this.str_City = str_City;
}
public String getStr_Block() {
	return str_Block;
}
public int getInt_UserID() {
	return int_UserID;
}
public void setInt_UserID(int int_UserID) {
	this.int_UserID = int_UserID;
}
public void setStr_Block(String str_Block) {
	this.str_Block = str_Block;
}
 private  int int_UserID;
 
private List<UserExtraInfo> search;
public List<UserExtraInfo> getSearch() {
	search=new ArrayList<UserExtraInfo>();
	search.addAll(getSubcriptService().getsearch1(str_Hobbies,str_Profession,residence1,status));
	System.out.println(search+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	System.out.println(search.getClass());
	
	ListIterator itr=search.listIterator();
	System.out.println(itr);
	while(itr.hasNext())
	{
		Object u=(Object) itr.next();
		UserExtraInfo e=(UserExtraInfo) u;
		System.out.println(  e.getStr_Hobbies()+"k11111111k111111111111111");
		System.out.println(e.getResidence()+"hjjjhjhjhjhjjhjhhjjhhjhjjhhjhjhjjhhjhjhjhj");
		System.out.println(e.getInt_UserID()+"");
		 char ch1=e.getStr_PhoneNo().charAt(0);
		 char ch2=e.getStr_PhoneNo().charAt(9);
		 char em1=e.getStr_Email().charAt(0);
		
	     String 	ch4="********";
	    String 	ch5="***************";
		  first=ch1+ch4+ch2;
		  stt_email=em1+ch5;
        System.out.println(first+"kjfkjjfkj"); 
       
	}
	return search;
}
public void setStr_Profession(String str_Profession) {
	this.str_Profession = str_Profession;
}

private String stt_email;



public String getStt_email() {
	return stt_email;
}
public void setStt_email(String stt_email) {
	this.stt_email = stt_email;
}
public String getFirst() {
	return first;
}
public void setFirst(String first) {
	this.first = first;
}

private String first;


public void setSearch(List<UserExtraInfo> search) {
	this.search = search;
}

private String str_Uname;
public String getStr_Uname() {
	return str_Uname;
}
public void setStr_Uname(String str_Uname) {
	this.str_Uname = str_Uname;
}

private String str_blocks;

public String getStr_blocks() {
	return str_blocks;
}
public void setStr_blocks(String str_blocks) {
	this.str_blocks = str_blocks;
}
private String str_Profession;


private List<String>residences;


public List<String> getResidences() {
	residences=new ArrayList<String>();
	residences.addAll(getSubcriptService().reside());
	ListIterator itr=residences.listIterator();
	System.out.println(itr);
	while(itr.hasNext())
	{
		Object u=(Object) itr.next();
		 s1=(String) u;
		System.out.println(s1+".,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		System.out.println(residences+"ioooooooooooooioioioioioioioo");
	}
	return residences;
}

public String s1;

public String getS1() {
	return s1;
}
public void setS1(String s1) {
	this.s1 = s1;
}
public void setResidences(List<String> residences) {
	this.residences = residences;
}


public boolean isResidence() {
	return residence;
}
public void setResidence(boolean residence) {
	this.residence = residence;
}

private UserExtraInfo usr;;
private  User user;



private Integer int_UserExtraID;


public Integer getInt_UserExtraID() {
	return int_UserExtraID;
}
public void setInt_UserExtraID(Integer int_UserExtraID) {
	this.int_UserExtraID = int_UserExtraID;
}

public String getStr_Profession() {
	return str_Profession;
}


public boolean isStr_MaritalStatus() {
	return str_MaritalStatus;
}
public void setStr_MaritalStatus(boolean str_MaritalStatus) {
	this.str_MaritalStatus = str_MaritalStatus;
}
public String getStr_Hobbies() {
	return str_Hobbies;
}
public void setStr_Hobbies(String str_Hobbies) {
	this.str_Hobbies = str_Hobbies;
}
 

public UserExtraInfo getUsr() {
	return usr;
}


private String  str_Hobbies;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getSearchid() {
	return searchid;
}
public void setUsr(UserExtraInfo usr) {
	this.usr = usr;
}

public void setSearchid(int searchid) {
	this.searchid = searchid;
}

public int searchid;
private Integer int_UserRole;

public Integer getInt_UserRole() {
	return int_UserRole;
}
public void setInt_UserRole(Integer int_UserRole) {
	this.int_UserRole = int_UserRole;
}
 private UserExtraInfo  userExtraInfo;
public UserExtraInfo getUserExtraInfo() {
	return userExtraInfo;
}
public void setUserExtraInfo(UserExtraInfo userExtraInfo) {
	this.userExtraInfo = userExtraInfo;
}
private String residence1;

private String status;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

private boolean str_MaritalStatus;

public String getSearch1() {
	System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
	System.out.println(residence+"jjjkkj");
	search=new ArrayList<UserExtraInfo>();
	if(residence==true)
	{
		residence1="Non-Residing";
	}
	else
	{
		residence1="Residing";
	}
	if(str_MaritalStatus==true)
	{
		
		status="Single";
		}
		else
		{
			status="Married";
		}
	
	 search.addAll(getSubcriptService().getsearch1(str_Hobbies,str_Profession,residence1,status ));
	return "View-SubGroup.xhtml";
}
	




private Integer int_UserId;

public String getResidence1() {
	return residence1;
}
public void setResidence1(String residence1) {
	this.residence1 = residence1;
}

private List<String> blocks;


public List<String> getBlocks() {
	return blocks;
}
public void setBlocks(List<String> blocks) {
	this.blocks = blocks;
}





private List<User> subgrouplist;




public List<User> getSubgrouplist() {
	subgrouplist=new ArrayList<User>();
	subgrouplist.addAll(getSubcriptService().getgroup());
	
	return subgrouplist;
}
public void setSubgrouplist(List<User> subgrouplist) {
	this.subgrouplist = subgrouplist;
}
private Integer int_GroupmemberId;
private Date DTDate;




public Integer getInt_GroupmemberId() {
	return int_GroupmemberId;
}
public Date getDTDate() {
	return DTDate;
}
public void setInt_GroupmemberId(Integer int_GroupmemberId) {
	this.int_GroupmemberId = int_GroupmemberId;
}
public void setDTDate(Date dTDate) {
	DTDate = dTDate;
}

public  static  String selectes;


public static String getSelectes() {
	return selectes;
}
public static void setSelectes(String selectes) {
	ScriptBean.selectes = selectes;
}
public int  intdocid2;


public int getIntdocid2() {
	return intdocid2;
}
public void setIntdocid2(int intdocid2) {
	this.intdocid2 = intdocid2;
}
public  List<Integer> userinfo;

public List<Integer> getUserinfo() {
	return userinfo;
}
public void setUserinfo(List<Integer> userinfo) {
	this.userinfo = userinfo;
}

public  static  String selecte;


public static String getSelecte() {
	return selecte;
}
public static void setSelecte(String selecte) {
	ScriptBean.selecte = selecte;
}
private String userID;

public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String  memberadd() {
	
intdocid2=getSubcriptService().adv1(selectes);
userinfo=(List<Integer>) getSubcriptService().memberid(str_Hobbies,str_Profession);
System.out.println(userinfo+"mmmmmmmmmmmmmmmmmmmmmmmmppppppppppppppppppppppppppppppp");
System.out.println(userinfo);
StringBuilder out = new StringBuilder();
for (Object o : userinfo)
{
	out.append(o.toString());
  out.append(",");
}
userID=out.toString();
System.out.println(selectes+"mmmmmmmmmmmmmmmmmmmmmmmm");
System.out.println(intdocid2);
GroupMember m1=new GroupMember();
m1.setInt_GroupId(intdocid2);
m1.setInt_UserId(userID);
m1.setDT_Date(getDTDate());
m1.setInt_GroupmemberId(getInt_GroupmemberId());
getSubcriptService().insertes(m1);

return "View-SubGroup.xhtml";

}
public void subname()
{
	groups=getSubcriptService().allname(str_GroupNm);
	selectes=groups.getStr_GroupNm();
}
	



 
public Boolean getBol_Smsallow() {
	return bol_Smsallow;
}
public Boolean getBol_Emailallow() {
	return bol_Emailallow;
}
public void setBol_Smsallow(Boolean bol_Smsallow) {
	this.bol_Smsallow = bol_Smsallow;
}
public void setBol_Emailallow(Boolean bol_Emailallow) {
	this.bol_Emailallow = bol_Emailallow;
}

private cls_Group edit2 ;


public cls_Group getEdit2() {
	return edit2;
}
public void setEdit2(cls_Group edit2) {
	this.edit2 = edit2;
}
public void getedit2()
{ 
	
edit2=new cls_Group();
System.out.println(int_GroupId);

edit2 =getSubcriptService().getEdit8(int_GroupId);
System.out.println(edit2);
}


public void setPath(String path) {
	this.path = path;
}
public String saveSetting( )
{
	System.out.println("hjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjh");
	System.out.println(bol_Smsallow);
	 if(edit2.getInt_GroupId()!=null)
	 
		 getSubcriptService().updates(edit2);
	else		
		getSubcriptService().addsetting(edit2);
     return "Sub-GroupDetail.xhtml";
	 
}
public String uploadFile() throws IOException {

	SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	 String fileName = fmt.format(new Date()) +getFileName(part).substring(getFileName(part).lastIndexOf('.'));
	// Extract file name from content-disposition header of file part
	//String fileName = getFileName(part);
	System.out.println("***** fileName: " + fileName);

	//String basePath = "D:" + File.separator + "temp" + File.separator;
	//File outputFilePath = new File(basePath + fileName);
	String basePath = "D:" + File.separator + "AppOwner" + File.separator+"AppOwnner"+File.separator+"WebContent"+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
	System.out.println(basePath);
	File outputFilePath = new File(basePath+fileName);
	
	System.out.println(path+"path");
	// Copy uploaded file to destination path
	InputStream inputStream = null;
	OutputStream outputStream = null;
	try {
		inputStream = part.getInputStream();
		outputStream = new FileOutputStream(outputFilePath);

		int read = 0;
		final byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
		path="/images"+ File.separator +Util.getAppartmentName()+File.separator+fileName;
		user.setVar_ImageName1(path);
		user.setInt_UserId(user.getInt_UserId());
		//getApartmentDetailsService().updateProfilePic(user);
		statusMessage = "File upload successfull !!";
		
	} catch (IOException e) {
		e.printStackTrace();
		statusMessage = "File upload failed !!";
	} finally {
		if (outputStream != null) {
			outputStream.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
	}
	return null;    // return to same page
}
private Part part;
private String statusMessage;
public Part getPart() throws IOException {
	 
	return part;
}

public void setPart(Part part) {
	this.part = part;
}

public String getStatusMessage() {
	return statusMessage;
}

public void setStatusMessage(String statusMessage) {
	this.statusMessage = statusMessage;
}

// Extract file name from content-disposition header of file part
private String getFileName(Part part) {
	final String partHeader = part.getHeader("content-disposition");
	System.out.println("***** partHeader: " + partHeader);
	for (String content : part.getHeader("content-disposition").split(";")) {
		if (content.trim().startsWith("filename")) {
			return content.substring(content.indexOf('=') + 1).trim()
					.replace("\"", "");
		}
	}
	return null;
}

private String path;
private String Var_ImageName1;

public String getVar_ImageName1() {
	return Var_ImageName1;
}
public void setVar_ImageName1(String var_ImageName1) {
	Var_ImageName1 = var_ImageName1;
}
public String getPath() {
	System.out.println(path+"path1");
	path=user.getVar_ImageName1();
	if( path==null)
	{
		//path="/images/profilepic.png";
		System.out.println(path+"img1");
	}
	 
	return path ;
}
private UserExtraInfo groupes;
public UserExtraInfo getGroupes() {
	groupes= getSubcriptService().alldatas(int_UserId);
	return groupes;
}
public void setGroupes(UserExtraInfo groupes) {
	this.groupes = groupes;}
public void Subdetail()
{
System.out.println(int_UserId+"vbbbbvbvbbvbvbvbvvvbvbvbvvvvvvvvvvvvvvvvvvv");
	}


private List<UserExtraInfo> users;
public List<UserExtraInfo> getUsers() {
	System.out.println(int_UserId);
	users=getSubcriptService().allusers(int_GroupId);
	return users;
}
public void setUsers(List<UserExtraInfo> users) {
	this.users = users;
}

private static String recipient="recipient";
private static String mailid;
public static String getRecipient() {
	return recipient;
}
public static void setRecipient(String recipient) {
	ScriptBean.recipient = recipient;
}
public static String getMailid() {
	return mailid;
}
public static void setMailid(String mailid) {
	ScriptBean.mailid = mailid;
}
public String getTo() {
	to="im.mukeshkumar89@gmail.com";
	System.out.println(to+"fdjkfkjjkj");
	System.out.println(str1+"jjj");
	return to;
}

private String to;
public void setTo(String to) {
	this.to = to;
}
private static String str1;

public static String getStr1() {
	return str1;
}
public static void setStr11(String str1) {
	ScriptBean.str1 = str1;
}
public String getTo1(){
	System.out.println("dkjdkjdkj");

	to="im.mukeshkumar89@gmail.com";
	
	System.out.println(str1+"dkjdfk");
	return to;
}
public String send()
{
	recipient= getTo();
	content="";
	subject="Appowner.com";
	str_message=getMessage();
	aprtmentname=getStr_ApartmentName();
	blockname=Util.getBlock();
	usrname=Util.getUserName();
	str_date=getDates();
	System.out.println(recipient);
	System.out.println(content);
	return "/AfrteLoginViews/Repository/GroupEmail.jsp";
}


private static  Date str_date;
private Date dates;


public static Date getStr_date() {
	return str_date;
}
public static void setStr_date(Date str_date) {
	ScriptBean.str_date = str_date;
}
public Date getDates() {
	dates=new java.util.Date();
	return dates;
}
public void setDates(Date dates) {
	this.dates = dates;
}

private static String str_message;

public static String getStr_message() {
	return str_message;
}
public static void setStr_message(String str_message) {
	ScriptBean.str_message = str_message;
}

private String message;

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

private static String aprtmentname;
private static String  blockname;
private static String usrname;

public static String getUsrname() {
	return usrname;
}
public static void setUsrname(String usrname) {
	ScriptBean.usrname = usrname;
}
public static String getBlockname() {
	return blockname;
}
public static void setBlockname(String blockname) {
	ScriptBean.blockname = blockname;
}
public static String getAprtmentname() {
	return aprtmentname;
}
public static void setAprtmentname(String aprtmentname) {
	ScriptBean.aprtmentname = aprtmentname;
}


}




