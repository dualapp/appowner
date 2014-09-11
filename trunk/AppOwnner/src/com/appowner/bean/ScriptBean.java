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

import org.primefaces.event.FileUploadEvent;
import org.springframework.dao.DataAccessException;

import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_SubcriptionOption;
import com.appowner.model.Option;
import com.appowner.model.Subcript;
import com.appowner.service.SubcriptService;
import com.appowner.util.Util;
import com.ibm.icu.text.SimpleDateFormat;

@ManagedBean
@RequestScoped
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

		private String str_UserName;
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
	public String getStr_UserName() {
		return str_UserName;
	}
	public void setStr_UserName(String str_UserName) {
		this.str_UserName = str_UserName;
	}

	private Integer int_UserId;
	 
	 
		
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
		public SubcriptService getSubcriptService() {
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
			
			return "SubcriptionList.xhtml";
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
	return "DocumentRepository.xhtml";
	
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

}




