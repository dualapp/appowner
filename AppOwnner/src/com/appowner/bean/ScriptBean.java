package com.appowner.bean;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Column;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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
		private static List<int[]> usrids;
		
	
	public static List<int[]> getUsrids() {
			return usrids;
		}
		public static void setUsrids(List<int[]> usrids) {
			ScriptBean.usrids = usrids;
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
		    d.setStr_FileNM(path);
			System.out.println(path);
			d.setInt_Userid(getUserId());
			d.setInt_ApartmentID(Util.getAppartmentId());
			d.setUsername(Util.getUserName());
			d.setStr_FolderNM(FileUploadValidator.filename);
			d.setStr_ApartmentName(getStr_ApartmentName());
		    d.setInt_DocumentID(getInt_DocumentID());
		    d.setImage(txtfile);
			getSubcriptService().documents(d);
			if(Bit_emailsend==true)
				
			{  if(Ch_Access.equalsIgnoreCase("All Members"))
				{
			  mailids=getSubcriptService().getMailIds();
			  }
			else
			{
				if(Ch_Access.equalsIgnoreCase("Committee"))
				{
					mailids=getSubcriptService().getcommiteid();
			}
			}
			if(Ch_Access.equalsIgnoreCase("Group"))
			{
				mailids=getSubcriptService().getgroupid();	
			}
			
			else
			{
				if(Ch_Access.equalsIgnoreCase("Administrator"))
				{
					mailids=getSubcriptService().getadminname();	
				}
			}
			
			    System.out.println(mailids+"my countrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			    content="Appowner.com";
			    subject="";
			    return "/AfrteLoginViews/Repository/CreateDocument1.jsp";
			
			}
			
		}
			
		catch(DataAccessException e)
		{
			e.printStackTrace();
			
		}
		return null;
		}
	public static String Email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	list2=new ArrayList();
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
private String image;

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

private List<Cls_CreateDocumentManagement> ListCreatedocument;
@SuppressWarnings("unchecked")
public List<Cls_CreateDocumentManagement> getListCreatedocument()
{
	System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	ListCreatedocument=new ArrayList<Cls_CreateDocumentManagement>();
	ListCreatedocument.addAll(getSubcriptService().getListCreatedocument());
	System.out.println(username+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	ListIterator list=ListCreatedocument.listIterator();
	while(list.hasNext())
	{
		Object obj=list.next();
		Cls_CreateDocumentManagement aa=(Cls_CreateDocumentManagement)obj;
		Int_Document_CatID=aa.getInt_Document_CatID();
		intdocid=getSubcriptService().getDocumentName(Int_Document_CatID);
		System.out.println(intdocid+",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		intdocid=null;
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
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
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
	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	str_GroupDescription=request.getParameter("limitedtextfield");
	cls_Group group=new cls_Group();
	group.setStr_GroupNm(getStr_GroupNm());
	group.setStr_GroupDescription(str_GroupDescription);
	group.setStr_Groupaddress(getStr_Groupaddress());
	group.setStr_groupPrivate(getStr_groupPrivate());
	group.setIsCh_EmailAllow(getIsCh_EmailAllow());
	group.setBol_Emailallow(getBol_Emailallow());
	group.setBol_Smsallow(getBol_Smsallow());
	group.setInt_Nomember(int_Nomember);
	System.out.println(isCh_EmailAllow+"uhujhju");
    group.setInt_ApartmentID(Util.getAppartmentId());
	group.setUserId(Util.getUserId());
	getSubcriptService().groupadd(group);
	str_GroupNm=null;
    str_Groupaddress=null;
    str_groupPrivate=null;
    str_GroupDescription=null;
   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Group Created Successfully!"));
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


public boolean blockinfo;

public boolean isBlockinfo() {
	return blockinfo;
}
public void setBlockinfo(boolean blockinfo) {
	this.blockinfo = blockinfo;
}
public boolean isSelect() {
	return select;
}
public void setSelect(boolean select) {
	this.select = select;
}
public boolean selectingroup1(ValueChangeEvent event)
{  
	group1=new ArrayList<String>();
	blockinfo =(boolean) event.getNewValue();
	System.out.println(str_group+"jhdsjdfvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
	group1.addAll(getSubcriptService().listblock());
	System.out.println(group1+"jhjjhccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
	return str_group ;
	}


public List<String> group1;

public boolean selectingroup(ValueChangeEvent event)
{  
	group1=new ArrayList<String>();
	str_group =(boolean) event.getNewValue();
	System.out.println(str_group+"jhdsjdfvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
	group1.addAll(getSubcriptService().listblock());
	System.out.println(group1+"jhjjhccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
	return str_group ;
	}




public List<String> getGroup1() {
	return group1;
}
public void setGroup1(List<String> group1) {
	this.group1 = group1;
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
	System.out.println(str_residence+"jhnhjj");
	return  "";
}
public boolean str_residence2;

public boolean isStr_residence2() {
	return str_residence2;
}
public void setStr_residence2(boolean str_residence2) {
	this.str_residence2 = str_residence2;
}
public String residenceinfo(ValueChangeEvent event)
{  
	str_residence2 =( boolean )event.getNewValue();
	System.out.println(str_residence+"jhnhjj");
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
public boolean str_profession;

public boolean isStr_profession() {
	return str_profession;
}
public void setStr_profession(boolean str_profession) {
	this.str_profession = str_profession;
}
public String profession(ValueChangeEvent event)
{  
	str_profession =( boolean )event.getNewValue();
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
	System.out.println(var_hobby+"jhnhjj");
	return  "";
}
public boolean str_hobby1;

public boolean isStr_hobby1() {
	return str_hobby1;
}
public void setStr_hobby1(boolean str_hobby1) {
	this.str_hobby1 = str_hobby1;
}
public String  hobby(ValueChangeEvent event)
{  
	str_hobby1 =( boolean )event.getNewValue();
	System.out.println(var_hobby+"jhnhjj");
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
public boolean married;

public boolean isMarried() {
	return married;
}
public void setMarried(boolean married) {
	this.married = married;
}
public String married(ValueChangeEvent event)
{  
	married =( boolean )event.getNewValue();
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


public boolean str_state1;



public boolean isStr_state1() {
	return str_state1;
}
public void setStr_state1(boolean str_state1) {
	this.str_state1 = str_state1;
}
public String selectinfo9(ValueChangeEvent event)
{  
	str_state1 =( boolean )event.getNewValue();
	System.out.println(select2+"jhnhjj");
	return  "";
}
public boolean str_state2;

public boolean isStr_state2() {
	return str_state2;
}
public void setStr_state2(boolean str_state2) {
	this.str_state2 = str_state2;
}
public String stateinf(ValueChangeEvent event)
{  
	str_state2 =( boolean )event.getNewValue();
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

{   enquiry_selectedState=(String)event.getNewValue();
if(enquiry_selectedState!=null)
{
      System.out.println(enquiry_selectedState+"kjjfkjgtfkjgfgfkjgfkjgfgf2222222222222222222222222222222");
		cityListByState=new ArrayList<String>();
		cityListByState.addAll(getSubcriptService().cityList(enquiry_selectedState));
           System.out.println(cityListByState);
           return cityListByState;
}
           else
           { System.out.println("i my and uuuuuuuuuuuuuuuuuuuuu");
        	   return cityListByState;   
           }
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


public String saveContact1(int groupid )
{
	System.out.println("hjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjh");
	System.out.println(bol_Smsallow);
	 if(group.getInt_GroupId()!=null)
	 
		 getSubcriptService().update3(group);
	else		
		getSubcriptService().addContact1(group);
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully!"));
     return "Sub-GroupDetail.xhtml";
	 
}

private int  int_Nomember;
public int getInt_Nomember() {
	return int_Nomember;
}
public void setInt_Nomember(int int_Nomember) {
	this.int_Nomember = int_Nomember;
	}
String  count=null;
private List<cls_Group> userlist;
public List<cls_Group> getUserlist() {
	userlist=new ArrayList<cls_Group>();
	userlist.addAll(getSubcriptService().getlist());
	System.out.println(userlist);
	ListIterator list=userlist.listIterator();
	List<String> str1=new ArrayList<String>();
	
	while(list.hasNext())
		{   Object o=list.next();
		cls_Group memberid=(cls_Group) o;
		int meberids=memberid.getInt_GroupId();
		count=getSubcriptService().count(meberids);
	    System.out.println(count+"mkjmnjmnjknbgfddcvgfddsssss");
	  
	    if(count==null)
	    {
	    	System.out.println("fkjjkgfkjgfkj");
	    	str1=new ArrayList<String>();
	    }
	    else
	    {   str1=new ArrayList<String>(); 
	    	String[] strArray = count.split(",");
	      for (String str : strArray) {
	        System.out.println(str+"gjjgjdskfdskfjkdjfkdjsfkjdsfkjsdjf;sd");
	        str1.add(str);
	      
		}
	      System.out.println(str1+"jfjffjkj");
	      System.out.println(str1.size() +"sdbfsadkjhgkjhjkhjhashdjskhjbcndbshkjsdhjkhbnbnb");
	      
	    }     
	    memberid.setInt_Nomember(str1.size());    
	        }
	  
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
	getSubcriptService().deletemembergroup(detail);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
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
public boolean male1;

public boolean isMale1() {
	return male1;
}
public void setMale1(boolean male1) {
	this.male1 = male1;
}
public String genders(ValueChangeEvent event)
{  
	male1 =( boolean )event.getNewValue();
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



public String str_State;
public String str_City;
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
	try{
	search=new ArrayList<UserExtraInfo>();
	if(str_Hobby==null&& str_Profession1==null&&reistence==null && 
			gender1==null &&married_statuss==null && statusid==0 && block1==null &&
			str_State1==null  && str_City1==null){
	}
	
	else 
	{
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
search.addAll(getSubcriptService().getsearch1(str_Hobby,str_Profession1,reistence,gender1,married_statuss,statusid,block1,str_State1,str_City1));
	System.out.println(search+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	System.out.println(search.getClass());
	ListIterator itr=search.listIterator();
	System.out.println(itr);
	while(itr.hasNext())
	{
		Object u=(Object) itr.next();
		UserExtraInfo e=(UserExtraInfo) u;
		System.out.println( e.getStr_Hobbies()+"k11111111k111111111111111");
		System.out.println(e.getResidence()+"hjjjhjhjhjhjjhjhhjjhhjhjjhhjhjhjjhhjhjhjhj");
		//System.out.println(e.getInt_UserID()+"");
		 char ch1=e.getStr_PhoneNo().charAt(0);
		 char ch2=e.getStr_PhoneNo().charAt(9);
		 char em1=e.getStr_Email().charAt(0);
		
	     String 	ch4="********";
	    String 	ch5="***************";
		  first=ch1+ch4+ch2;
		  stt_email=em1+ch5;
        System.out.println(first+"kjfkjjfkj"); 
       
	}
	}}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	married_Status=null;
	blockdetails=null;
	married_status2=null;
	str_Gender=null;
	residing1=null;
	str_residence1=null;
	blockdetail=null;
	married_status1=null;
	str_gender=null;
	str_Hobby=null;
	str_Profession1=null;
	reistence=null;
	str_residence3=null;
	gender1=null;
	married_statuss=null;
	statusid=0;
	block1=null;
	str_State1=null;
	str_City1=null;
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
public String selectinfo5(ValueChangeEvent event)
{  
	str_residence1 =( List<String> )event.getNewValue();
	System.out.println(residence+"jhnhjj");
	return  "";
}

public String selectinfoos(ValueChangeEvent event)
{  
	str_residence3 =( List<String> )event.getNewValue();
	System.out.println(str_residence3+"jhnhjj");
	return  "";
}

public List<String> residing1;
public List<String> getResiding1() {
	residing1=new ArrayList<String>();
	residing1.add("residence");
	residing1.add("non-residence");
	System.out.println(residing1);
	return residing1;
}
public void setResiding1(List<String> residing1) {
	this.residing1 = residing1;
}
public String selectinfo12(ValueChangeEvent event)
{  
	married_status =( List<String> )event.getNewValue();
	System.out.println(str_MaritalStatus+"jhnhjj88888888888888888888888888888888888");
	return  "";
}
public String selectinfo10(ValueChangeEvent event)
{  
	str_Profession =( String )event.getNewValue();
	System.out.println(str_Profession+"jhnhjj77777777777777777777777777777777777");
	return  "";
}
public String selectinfo11(ValueChangeEvent event)
{  
	str_Hobbies =( String )event.getNewValue();
	System.out.println(str_Hobbies+"jhnhjj122222222222222222222222222");
	return  "";
}
private boolean str_MaritalStatus;
private int statusid;

public int getStatusid() {
	return statusid;
}
public void setStatusid(int statusid) {
	this.statusid = statusid;
}


public String getSearch1() {
	try
	{
		search=new ArrayList<UserExtraInfo>();
	
	if(blockdetail!=null)
	{
System.out.println(blockdetails+"llllllllllllllllllllllllllllllllllllllllllllllllLLLLLLLLLLLLLLLLLLLLLLLLL");
ListIterator itr=blockdetails.listIterator();
while(itr.hasNext())
{
	block1=(String) itr.next();
System.out.println(block1+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
}}
	else
	{
		
	}
	if(str_residence3!=null)
	{
System.out.println(str_residence3+"llllllllllllllllllllllllllllllllllllllllllllllllLLLLLLLLLLLLLLLLLLLLLLLLL");
ListIterator itr=str_residence3.listIterator();
while(itr.hasNext())
{
  reistence=(String) itr.next();
System.out.println(reistence+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
}}
	else
	{
		
	}
	if(married_Status!=null)
	{
ListIterator itr1=married_Status.listIterator();
while(itr1.hasNext())
{
	married_statuss=(String) itr1.next();
System.out.println(married_status1+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
}
	}
	else
	{
		
	}
	if(str_Gender!=null)
	{
ListIterator itr2=str_Gender.listIterator();
while(itr2.hasNext())
{
	gender1=(String) itr2.next();
System.out.println(gender1+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
}
	}
	else{
		
	}
	
System.out.println(str_residence+"fkjjfgkjgfjggfkj");
System.out.println(married_statuss+"fkjfjfjfj1111111111111111111111111111111111111111jjjjjjjjjjj");
System.out.println(str_Gender+"jdfffjgfj111111111111111111111111111111");
System.out.println(str_Hobby+"jdfkjfjkgfkj55555555555555555555555555555555555555555555");
System.out.println(str_Profession1+"222222222222222222222777777777777777777777777");


if(str_Hobby==null && str_Profession1==null && reistence==null && gender1==null && married_statuss==null && block1==null && str_State1==null &&str_City1==null)
{
	statusid=0;
}
if(!(str_Hobby==null) && !(str_Hobby.isEmpty()) )
{
	 statusid=1;
}
if(!(str_Profession1==null) && !(str_Profession1.isEmpty()) )
{
	 statusid=2;
}
if(!(reistence==null) && !(reistence.isEmpty()) )
{ System.out.println(reistence+"hjgjjjghhhhhhhhhhhhhhhhhhhhhhhhhh888888888888888888888888888888888888888888888888888888888888888");
	 statusid=3;
}
if(!(gender1==null) && !(gender1.isEmpty()) )
{
	 statusid=4;
}
if(!(married_statuss==null) && !(married_statuss.isEmpty()) )
{
	 statusid=5;
}
if(!(block1==null) && !(block1.isEmpty()) )
{
	 statusid=6;
}
if(!(str_State1==null ) && !(str_State1.isEmpty()))
{
	statusid=7;
}
if(!(str_City1==null ) && !(str_City1.isEmpty()))
{
	statusid=8;
}

	

search.addAll(getSubcriptService().getsearch1(str_Hobby,str_Profession1,reistence,gender1,married_statuss,statusid,block1,str_State1,str_City1));


blockinfo=false;
str_residence2=false;
str_profession=false;
str_hobby1=false;
married=false;
str_state2=false;
male1=false;
	}
catch(Exception e)
{
	e.printStackTrace();
}
	
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

private  static  String selectes;


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
 public   String reistences;


public String married_status1;

public String getMarried_status1() {
	return married_status1;
}
public void setMarried_status1(String married_status1) {
	this.married_status1 = married_status1;
}
public String gender;

public String block;

public String getBlock() {
	return block;
}
public void setBlock(String block) {
	this.block = block;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String  memberadd() {
	
	
	try{
	if(blockdetail!=null)
	{
System.out.println(blockdetail+"llllllllllllllllllllllllllllllllllllllllllllllllLLLLLLLLLLLLLLLLLLLLLLLLL");
ListIterator itr=blockdetail.listIterator();
while(itr.hasNext())
{
	block=(String) itr.next();
System.out.println(block+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
}}
	else
	{
		
	}
	if(str_residence1!=null)
	{
System.out.println(str_residence1+"llllllllllllllllllllllllllllllllllllllllllllllllLLLLLLLLLLLLLLLLLLLLLLLLL");
ListIterator itr=str_residence1.listIterator();
while(itr.hasNext())
{
  reistences=(String) itr.next();
System.out.println(reistences+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
}}
	else
	{
		
	}
	if(married_status!=null)
	{
ListIterator itr1=married_status.listIterator();
while(itr1.hasNext())
{
	married_status1=(String) itr1.next();
System.out.println(married_status1+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
}
	}
	else
	{
		
	}
	if(str_gender!=null)
	{
ListIterator itr2=str_gender.listIterator();
while(itr2.hasNext())
{
	gender=(String) itr2.next();
System.out.println(gender+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
}
	}
	else{
		
	}
	
System.out.println(str_residence+"fkjjfgkjgfjggfkj");
System.out.println(married_status+"fkjfjfjfj1111111111111111111111111111111111111111jjjjjjjjjjj");
System.out.println(str_gender+"jdfffjgfj111111111111111111111111111111");
System.out.println(str_Hobbies+"jdfkjfjkgfkj55555555555555555555555555555555555555555555");
System.out.println(str_Profession+"222222222222222222222777777777777777777777777");
System.out.println(str_State+"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
System.out.println(str_City+"cccccccccccccccccccccccccccccccccccccccccccccccccccc");
intdocid2=getSubcriptService().adv1(selectes);

if(block ==null && str_Hobbies==null && str_Profession==null && married_status1==null &&
gender==null && str_State==null && str_City==null && reistences==null )
{
	System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
}
else if(block!=null)
{
	userinfo=(List<Integer>) getSubcriptService().block_usrid(block);		
}
else if(reistences!=null)
{
userinfo=(List<Integer>) getSubcriptService().memberId(reistences);	
System.out.println(userinfo+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
}
else if(str_Hobbies!=null) 
{
userinfo=(List<Integer>) getSubcriptService().memberid(str_Hobbies);
}
else if(str_Profession!=null) 
{
userinfo=(List<Integer>) getSubcriptService().ProfessionId(str_Profession);
}
else if(married_status1!=null) 
{
userinfo=(List<Integer>) getSubcriptService().MarriedId(married_status1);
}
else if(gender!=null) 
{
userinfo=(List<Integer>) getSubcriptService().hobbyId(gender);
}
else if(str_State!=null) 
{
userinfo=(List<Integer>) getSubcriptService().stateId(str_State);
}
else if(str_State!=null && str_City!=null)
{
	userinfo=(List<Integer>) getSubcriptService().usrId(str_City,str_State);
	System.out.println(userinfo+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
}
else if(reistences!=null && str_Profession!=null) 
{
userinfo=(List<Integer>) getSubcriptService().res_profession(reistences,str_Profession);
}
else if(reistences!=null && str_Hobbies!=null) 
{
userinfo=(List<Integer>) getSubcriptService().res_hobby(reistences,str_Hobbies);
}
else if(reistences!=null && married_status1!=null) 
{
userinfo=(List<Integer>) getSubcriptService().res_married(reistences,married_status1);
}
else if(reistences!=null && gender!=null) 
{
userinfo=(List<Integer>) getSubcriptService().res_gender(reistences,gender);
}
else if(str_Profession!=null && str_Hobbies!=null) 
{
userinfo=(List<Integer>) getSubcriptService().pro_hobby(str_Profession,str_Hobbies);
}
else if(str_Profession!=null && married_status1!=null) 
{
userinfo=(List<Integer>) getSubcriptService().pro_married(str_Profession,married_status1);
}
else if(married_status1!=null && gender!=null) 
{
userinfo=(List<Integer>) getSubcriptService().married_gen(married_status1,gender);
}
else if(reistences!=null && str_Profession!=null &&str_Hobbies!=null) 
{
userinfo=(List<Integer>) getSubcriptService().res_pro_hoby(reistences,str_Profession,str_Hobbies);
}
else if(reistences!=null && married_status1!=null &&gender!=null) 
{
userinfo=(List<Integer>) getSubcriptService().res_married_gender(reistences,married_status1,gender);
}
else if(str_Profession!=null && str_Hobbies!=null &&gender!=null) 
{
userinfo=(List<Integer>) getSubcriptService().res_hobby_gender(reistences,str_Hobbies,gender);
}
System.out.println(userinfo+"mmmmmmmmmmmmmmmmmmmmmmmmpppppppppppppppppppppppppppppppcccccccc");
System.out.println(userinfo);
StringBuilder out = new StringBuilder();
for (Object o : userinfo)
{
out.append(o.toString());
  out.append(",");
}

userID=out.toString();
System.out.println(userID+"mmmmmmmmmmmmmmmmmmmmmmmm");
System.out.println(intdocid2);
GroupMember m1=new GroupMember();
System.out.println(intdocid2+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
m1.setInt_GroupId(intdocid2);
if (userID.length() > 0 && userID.charAt(userID.length()-1)==',') {
	userID = userID.substring(0, userID.length()-1);
  }
 
m1.setInt_UserId(userID);
m1.setDT_Date(getDTDate());
m1.setInt_GroupmemberId(getInt_GroupmemberId());
if(userinfo.isEmpty())
{
System.out.println(userinfo+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmccccccccccccccccccccccccccccccccccccccccccccccccccccc");	
}
else{
getSubcriptService().insertes(m1);
getSearch2();
}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	
	str_group=false;
	str_residence=false;
	str_hobby=false;
	var_hobby=false;
	martial=false;
	str_state1=false;
	male=false;
	
return "AddMember.xhtml";




}
public void subname()
{
	System.out.println(str_GroupNm+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	groups=getSubcriptService().allname(str_GroupNm);
	System.out.println(groups+"ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
	selectes=groups.getStr_GroupNm();
	System.out.println(selectes+",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
	
	
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
	 
}private Cls_CreateDocumentManagement file;
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
		//user.setVar_ImageName1(path);
		//user.setInt_UserId(user.getInt_UserId());
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


public String path;

public  String getPath() {
	System.out.println(path + "path1cvvvvvvvvvvvvvvvvvvvvvvvvvvcvcccccccccccvvvvvvvvvvvvv");
	System.out.println("i  $ youuuuuuuuuuuuuuuuuuuuuuu");
	if(path==null)
	{
		path = "/images/no_attach.png";
	}
	 return path;
	
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
	aprtmentname=Util.getAppartmentName();
	blockname=Util.getBlock();
	usrname=Util.getUserName();
	System.out.println(usrname+",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
	java.util.Date d=new java.util.Date();
	 SimpleDateFormat ft = 
		      new SimpleDateFormat ("dd-MM-yyyy");
	//String str=ft.format(d);
	 Calendar c = Calendar.getInstance(); 
	 c.setTime(d);
	 
	 
	
	 d= c.getTime();
	System.out.println(d+"kunkupriya");

	 String str=ft.format(d);
	str_date=str;
	System.out.println(str_date+"kgfkjkgkgkjlihhhhhhhhhhhjlllllllllllllllllllllllllll");
	System.out.println(recipient);
	System.out.println(content);
	return "/AfrteLoginViews/Repository/GroupEmail11.jsp";
}


private static  String  str_date;
private Date dates;




public static String getStr_date() {
	return str_date;
}
public static void setStr_date(String str_date) {
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
 public String txtfile;
 public String txtfile1;
 
public String getTxtfile() {
	return txtfile;
}
public void setTxtfile(String txtfile) {
	this.txtfile = txtfile;
}
public String getTxtfile1() {
	return txtfile1;
}
public void setTxtfile1(String txtfile1) {
	this.txtfile1 = txtfile1;
}
private  Cls_CreateDocumentManagement doc;

public Cls_CreateDocumentManagement getDoc() {
	return doc;
}
public void setDoc(Cls_CreateDocumentManagement doc) {
	this.doc = doc;
}
public String uploadFile1() throws IOException {
    System.out.println("fjkjkfdjkkjfjkfkj");
	SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	System.out.println(FileUploadValidator.filename+"gvfjkgfjkfcccccccccccccccccccccccccccccccccccccccccccccccccc");
	 String fileName = fmt.format(new Date()) +getFileName(part).substring(getFileName(part).lastIndexOf('.'));
     System.out.println(part.getContentType());
    if(part.getContentType().equals("text/plain"))
    {
    	txtfile="true";
    	txtfile1="false";
    	
    }
    if(part.getContentType().equals("application/msword"))
    {
    	txtfile="false";
    	txtfile1="true";
    }
	System.out.println(fileName+"dfjkjkfjkfduuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
	System.out.println(FileUploadValidator.filename+"ppppppppppppppppppppppppppppppppppppppppppppppppppppppp");
	System.out.println(path+"mkmmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkm");
	
	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	
	String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
	System.out.println(basePath);
	File outputFilePath = new File(basePath);
	
	System.out.println(outputFilePath+"path");
	if (!outputFilePath.exists()) {
	   	if (outputFilePath.mkdir()) {
	   		System.out.println("Directory is created!");
	   	} else {
	   		System.out.println("Failed to create directory!");
	   	}
 }
	outputFilePath = new File(basePath,fileName);
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

		System.out.println(document.getInt_DocumentID()+"Biharrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrpatnaaaaaaaaaaaaaa");
		if(document.getInt_DocumentID()!=null)
		{  System.out.println("fdhfd33333333333333333333333333333333333333333333333");
			System.out.println(txtfile+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
			System.out.println(FileUploadValidator.filename+"ppppppppppppppppppppppppppppppppppppppppppppppppppppppp");
			System.out.println(path+"mkmmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkm");
			getSubcriptService().updateposts(txtfile,document.getInt_DocumentID(),path,FileUploadValidator.filename);
		System.out.println(path1+"fkjdfkdl");
        statusMessage = "File upload successfull !!";
		}
	} 
		catch (IOException e) {
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
	part=null;
	return null;    // return to same page
}
private Cls_CreateDocumentManagement allinfo;
public Cls_CreateDocumentManagement getAllinfo() {
	return allinfo;
}
public void setAllinfo(Cls_CreateDocumentManagement allinfo) {
	this.allinfo = allinfo;
}
public static Integer postid;

 public static Integer getPostid() {
	return postid;
}
public static void setPostid(Integer postid) {
	ScriptBean.postid = postid;
}
public String viewcategory()
{
	if(indicate==false)
	  {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select One Item View"));
		str_Description=null;
	    str_FolderNM=null;
		 str_ApartmentName=null;
		 username=null;
		 return"DocumentRepository.xhtml";
	  }
	else
	{
	postid=allinfo.getInt_DocumentID();
	System.out.println(postid+"mukeshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	str_Description=null;
    str_FolderNM=null;
	 str_ApartmentName=null;
	 username=null;
	return"ViewDocpost.xhtml";
	
	}
	
 }
private  Cls_CreateDocumentManagement listdocpost;
public Cls_CreateDocumentManagement getListdocpost() {
	listdocpost=getSubcriptService().listname(postid);
	System.out.println(listdocpost.getInt_DocumentID()+"mnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn,,,,,,,,,,,,,,,,,");
	return listdocpost;
}
public void setListdocpost(Cls_CreateDocumentManagement listdocpost) {
	this.listdocpost = listdocpost;
}


public String deletepost(){
	Cls_CreateDocumentManagement detail=new Cls_CreateDocumentManagement();
	System.out.println(Int_DocumentID+"mukeshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	detail.setInt_DocumentID(Int_DocumentID);
	getSubcriptService().deletedetail(detail);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
	str_Description=null;
    str_FolderNM=null;
	 str_ApartmentName=null;
	 username=null;
	 
	return "DocumentRepository.xhtml?faces-redirect=true";
  
}

public String editcategory()
{
	if(indicate==false)
	  {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select One Item View"));
		str_Description=null;
	    str_FolderNM=null;
		 str_ApartmentName=null;
		 username=null;
		 return"DocumentRepository.xhtml";
	  }
	else
	{
	postid=allinfo.getInt_DocumentID();
	System.out.println(intdocid+"mukeshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	str_Description=null;
    str_FolderNM=null;
	 str_ApartmentName=null;
	 username=null;
	return"UpdateDocpost.xhtml";
	}
}

private int postsid;
public String editpost()
{
	if(intdocid==null)
	{
		System.out.println(intdocid+"<><><><>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
		else
		{
			System.out.println(intdocid+"<><><><>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			postsid=getSubcriptService().getname(intdocid);
			System.out.println(postsid+"herooooooooooooooooheroooooooooooooooooooooooooooo");
			document.setInt_Document_CatID(postsid);
		
		}
	if(document.getInt_DocumentID()!=null)
	{
	   document.setImage(path);
	   document.setInt_Document_CatNM(int_Document_CatNM);
      getSubcriptService().updatepost(document);
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully!"));
	
	str_Description=null;
     str_FolderNM=null;
	 str_ApartmentName=null;
	 username=null;
	} 
return "DocumentRepository.xhtml";
}

public static String allmembers;

public static String getAllmembers() {
	return allmembers;
}
public static void setAllmembers(String allmembers) {
	ScriptBean.allmembers = allmembers;
}

	 public String downloadFile(String path,String path1) throws IOException
	  {    System.out.println("1111111111111177777777777777777777777777777777777777777777777777777777777777777777777777777777777777");
	  ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		
		String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
		System.out.println(path1+"fdhjjdf333333333333333333333333333333333333333333");
		System.out.println(path+"hfdh111111111111111111111111111111111");
		path="20150420121913.txt";
			//String basePath = servletContext.getContextPath()+File.separator+"WebContent"+File.separator;
	     File file = new File(basePath+path);
	      System.out.println(file+"hhhjhj22222222222222222222222222555555555555555555555555555555555555555555555");
	     InputStream fis = new FileInputStream(file);
	     System.out.println(file.getAbsolutePath());
	     System.out.println(file.getName());
	     String str=file.getName();
	     System.out.println(path1+"fhffjfghj111111111111111111111111111");
	     byte[] buf = new byte[10000];
	     int offset = 0;
	     int numRead = 0;
	     while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) 
	     {
	       offset += numRead;
	     }
	     fis.close();
	     HttpServletResponse response =
	        (HttpServletResponse) FacesContext.getCurrentInstance()
	            .getExternalContext().getResponse();
	    
	    	response.setContentType("text/plain");
	       response.setHeader("Content-Disposition", "attachment;filename=Document");
	    response.getOutputStream().write(buf);
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	 
	    FacesContext.getCurrentInstance().responseComplete();
	    return null;
	  }
	 private StreamedContent downloadFile;
		public StreamedContent getDownloadFile() {
			return downloadFile;
		}
		public void setDownloadFile(StreamedContent downloadFile) {
			this.downloadFile = downloadFile;
		}
		private boolean indicate;
		public boolean isIndicate() {
			return indicate;
		}
		public void setIndicate(boolean indicate) {
			this.indicate = indicate;
		}
		private boolean indicate2;
		public boolean isIndicate2() {
			return indicate2;
		}
		public void setIndicate2(boolean indicate2) {
			this.indicate2 = indicate2;
		}
		public void desabledListener( SelectEvent event)
		{
			System.out.println("klcfkfkjfgfgkffkg33333333333333333333333333333mnmnmnmnnnnnnnnnnnnn");
			
			indicate=true;
			}
		private  Cls_CreateDocumentManagement document=new Cls_CreateDocumentManagement();
		public Cls_CreateDocumentManagement getDocument() {
			return document;
		}
		public void setDocument(Cls_CreateDocumentManagement document) {
			this.document = document;
		}
		
		public List<String>documents;
		
		public List<String> getDocuments() {
			return documents;
		}
		public void setDocuments(List<String> documents) {
			this.documents = documents;
		}
		public String documentname;
		
		
		public String getDocumentname() {
			return documentname;
		}
		public void setDocumentname(String documentname) {
			this.documentname = documentname;
		}
		public String documentupload( int docId)
		{
			document=getSubcriptService().getdetail(docId);
			//documentname=getSubcriptService().documentnames(document.getInt_Document_CatID());
			System.out.println(documentname+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
			if(document.getInt_Document_CatID()!=0)
			{
			documents=new ArrayList<String>();
		    documents.addAll(getSubcriptService().getdocumentdetail(document.getInt_Document_CatID()));
		   System.out.println(	documents+"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			}
			
			else
			{
				documents=new ArrayList<String>();
				
			}
			return "UpdateDocpost.xhtml";
		}
		
		public String documentview( int docId)
		{
			document=getSubcriptService().getdetail(docId);
			if(document.getInt_Document_CatID()!=0)
			{
				documents=new ArrayList<String>();
				documents.addAll(getSubcriptService().getdocumentdetail(document.getInt_Document_CatID()));
				
				System.out.println(	documents+"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			}
			
			else
			{
				documents=new ArrayList<String>();
				
			}
			return "ViewDocpost.xhtml";
		}
		
		
		
		
		private String getFileName(Part part) {
			System.out.println(part+"dfjfdkjfdkjfdkj");
			final String partHeader = part.getHeader("content-disposition");
			System.out.println("***** partHeader: " + partHeader);
			for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
					return content.substring(content.indexOf('=') + 1).trim()
							.replace("\"", "");
			}
			}
			return "filename";
		}
		
		cls_Group gropus=new cls_Group();
		
		public cls_Group getGropus() {
			return gropus;
		}
		public void setGropus(cls_Group gropus) {
			this.gropus = gropus;
		}
		public List<String>grouplists;
		
		public List<String> getGrouplists() {
			return grouplists;
		}
		public void setGrouplists(List<String> grouplists) {
			this.grouplists = grouplists;
		}
		public  String groupdetail( int groupId)
		{
			System.out.println(groupId+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn66666666666");
			gropus=getSubcriptService().groupdetail(groupId);
			System.out.println(gropus+"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
		     return "Sub-GroupDetail.xhtml";
		}
		cls_Group group=new cls_Group();
		
		public cls_Group getGroup() {
			return group;
		}
		public void setGroup(cls_Group group) {
			this.group = group;
		}
		public String groupedit(int groupid)
	{
			System.out.println(groupid+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn66666666666");
			group=getSubcriptService().grouedit(groupid);
			return"EditGroup.xhtml";
		}
		cls_Group groupset=new cls_Group();
       public String settingedit(int Groupid)
		{
		groupset=getSubcriptService().groupsetting(Groupid);
	    return "Sub_Group-Settings.xhtml";
		}
		public cls_Group getGroupset() {
			return groupset;
		}
		public void setGroupset(cls_Group groupset) {
			this.groupset = groupset;
		}
		public String savesetting( int settingid)
		{
			System.out.println("hjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjh");
			System.out.println(bol_Smsallow);
			 if(groupset.getInt_GroupId()!=null)
			 
				 getSubcriptService().update3(groupset);
			else		
				getSubcriptService().addContact1(groupset);
			 return "Sub-GroupDetail.xhtml";
			 
		}
		
		
		public String invitemember(int inviteid)
		{
			System.out.println(inviteid+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn66666666666");
			group=getSubcriptService().grouedit(inviteid);
			return"Invite-Members.xhtml";
		}
		public static int getusrid;
		
		public static int getGetusrid() {
			return getusrid;
		}
		public static void setGetusrid(int getusrid) {
			ScriptBean.getusrid = getusrid;
		}
		public String addmember(int inviteids)
		{
			System.out.println(str_GroupNm+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
			group=getSubcriptService().grouedit(inviteids);
			System.out.println(groups+"ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
			selectes=group.getStr_GroupNm();
			getusrid=group.getInt_GroupId();
			System.out.println(selectes+",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		    System.out.println(inviteids+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn66666666666");
			return"Add-member.xhtml";
			
			
}
		public static int alluserid;
		
		public static int getAlluserid() {
			return alluserid;
		}
		public static void setAlluserid(int alluserid) {
			ScriptBean.alluserid = alluserid;
		}
		public String viewmember(int inviteid)
		{
			users=getSubcriptService().allusers(inviteid);
		   System.out.println(getusrid+"ggggggggggggggnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn66666666666");
		   alluserid=inviteid;
			return"ViewMember.xhtml";
}
		
		public List<String> str_residence1;
		public List<String> getStr_residence1() {
			return str_residence1;
		}
		public void setStr_residence1(List<String> str_residence1) {
			this.str_residence1 = str_residence1;
		}
		public List<String>married_status;
		public List<String> getMarried_status() {
			return married_status;
		}
		public void setMarried_status(List<String> married_status) {
			this.married_status = married_status;
		}
		
		public List<String> str_gender;
		public List<String> getStr_gender() {
			return str_gender;
		}
		public void setStr_gender(List<String> str_gender) {
			this.str_gender = str_gender;
		}
		public String selectinfos(ValueChangeEvent event)
		{  System.out.println("hghjghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
			str_gender =( List<String> )event.getNewValue();
			System.out.println(str_Hobbies+"jhnhjj122222222222222222222222222");
			return  "";
}
		public void viewmember1()
		{
			users=getSubcriptService().allusers(getusrid);
		   System.out.println(getusrid+"ggggggggggggggnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn66666666666");
		
			
}
		public String block1;
		public String getBlock1() {
			return block1;
		}
		public void setBlock1(String block1) {
			this.block1 = block1;
		}
		public String getReistence() {
			return reistence;
		}
		public void setReistence(String reistence) {
			this.reistence = reistence;
		}
		public String getMarried_statuss() {
			return married_statuss;
		}
		public void setMarried_statuss(String married_statuss) {
			this.married_statuss = married_statuss;
		}
		public String getGender1() {
			return gender1;
		}
		public void setGender1(String gender1) {
			this.gender1 = gender1;
		}

		public String reistence;
		public String married_statuss;
		public String gender1;
		
		public List<UserExtraInfo> getSearch2() {
			
			if(blockdetail!=null)
			{
		System.out.println(blockdetail+"llllllllllllllllllllllllllllllllllllllllllllllllLLLLLLLLLLLLLLLLLLLLLLLLL");
		ListIterator itr=blockdetail.listIterator();
		while(itr.hasNext())
		{
			block=(String) itr.next();
		System.out.println(block1+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
		}}
			else
			{
				
			}
			if(str_residence1!=null)
			{
		System.out.println(str_residence1+"llllllllllllllllllllllllllllllllllllllllllllllllLLLLLLLLLLLLLLLLLLLLLLLLL");
		ListIterator itr=str_residence1.listIterator();
		while(itr.hasNext())
		{
			reistences=(String) itr.next();
		System.out.println(reistences+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
		}}
			else
			{
				
			}
			if(married_status1!=null)
			{
		ListIterator itr1=married_status.listIterator();
		while(itr1.hasNext())
		{
			married_statuss=(String) itr1.next();
		System.out.println(married_status1+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
		}
			}
			else
			{
				
			}
			if(str_gender!=null)
			{
		ListIterator itr2=str_gender.listIterator();
		while(itr2.hasNext())
		{
			gender=(String) itr2.next();
		System.out.println(gender+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbbbbbbbbbbbb");
		}
			}
			else{
				
			}
			
		System.out.println(str_residence+"fkjjfgkjgfjggfkj");
		System.out.println(married_statuss+"fkjfjfjfj1111111111111111111111111111111111111111jjjjjjjjjjj");
		System.out.println(str_Gender+"jdfffjgfj111111111111111111111111111111");
		System.out.println(str_Hobby+"jdfkjfjkgfkj55555555555555555555555555555555555555555555");
		System.out.println(str_Profession1+"222222222222222222222777777777777777777777777");
		try
		{
			getmember=new ArrayList<UserExtraInfo>();

		if(str_Hobbies==null && str_Profession==null && reistences==null && gender==null && married_status==null && block==null && str_State==null &&str_City==null)
		{
			statusid=0;
		}
		if(!(str_Hobbies==null) && !(str_Hobbies.isEmpty()) )
		{
			 statusid=1;
		}
		if(!(str_Profession==null) && !(str_Profession.isEmpty()) )
		{
			 statusid=2;
		}
		if(!(reistences==null) && !(reistences.isEmpty()) )
		{
			 statusid=3;
		}
		if(!(gender==null) && !(gender.isEmpty()) )
		{
			 statusid=4;
		}
		if(!(married_status1==null) && !(married_status1.isEmpty()) )
		{
			 statusid=5;
		}
		if(!(block==null) && !(block.isEmpty()) )
		{
			 statusid=6;
		}
		if(!(str_State==null ) && !(str_State.isEmpty()))
		{
			statusid=7;
		}
		if(!(str_City==null ) && !(str_City.isEmpty()))
		{
			statusid=8;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		getmember.addAll(getSubcriptService().getsearch1(str_Hobbies,str_Profession,reistences,gender,married_status1,statusid,block,str_State,str_City));
		str_gender=null;
		married_status1=null;
		str_residence1=null;
		blockdetail=null;
		block=null;
	    str_Hobbies=null;  
		str_Profession=null; 
		married_status1=null;
		gender=null; 
		str_State=null; 
		str_City=null; 
		reistences=null;
	    return getmember;
			 
		}
		public String str_State1;
		 public String str_City1;
		 
		public String getStr_State1() {
			return str_State1;
		}
		public void setStr_State1(String str_State1) {
			this.str_State1 = str_State1;
		}
		public String getStr_City1() {
			return str_City1;
		}
		public void setStr_City1(String str_City1) {
			this.str_City1 = str_City1;
		}

		private List<UserExtraInfo> getmember;
		public List<UserExtraInfo> getGetmember() {
			return getmember;
		}
		public void setGetmember(List<UserExtraInfo> getmember) {
			this.getmember = getmember;
		}
		
		public String selectinfoo(ValueChangeEvent event)
		{  
			blockdetail =( List<String> )event.getNewValue();
			System.out.println(blockdetail+"jhnhjjxxxxxxx");
			return  "";
		}
		public String selectinfs(ValueChangeEvent event)
		{  
			blockdetails =( List<String> )event.getNewValue();
			System.out.println(blockdetails+"jhnhjjxxxxxxx");
			return  "";
		}
		public List<String> blockdetail;
		public List<String> getBlockdetail() {
			
			return blockdetail;
		}
		public void setBlockdetail(List<String> blockdetail) {
			this.blockdetail = blockdetail;
		}
	public	UserExtraInfo useinfo=new UserExtraInfo();
	
  public UserExtraInfo getUseinfo() {
		return useinfo;
	}
	public void setUseinfo(UserExtraInfo useinfo) {
		this.useinfo = useinfo;
	}
public String memberdetail( int userId)
  {
	  
	  useinfo=getSubcriptService().getallinfo(userId);
	System.out.println(useinfo+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	  str_Hobbies=null;
	  str_Profession=null;reistences=null;
	  gender=null;
	  married_status1=null;
	  statusid=0;
	  block=null;
	  str_State=null;
	  str_City=null;
	  return"Viewprofile.xhtml";
	 
  }


public List<String> married_status2;

public List<String> getMarried_status2() {
	return married_status2;
}
public void setMarried_status2(List<String> married_status2) {
	this.married_status2 = married_status2;
}

public List<String>str_residence3;

public List<String> getStr_residence3() {
	return str_residence3;
}
public void setStr_residence3(List<String> str_residence3) {
	this.str_residence3 = str_residence3;
}
public List<String> getBlockdetails() {
	return blockdetails;
}
public void setBlockdetails(List<String> blockdetails) {
	this.blockdetails = blockdetails;
}

public List<String> blockdetails;
public List<String>str_gender1;
public List<String> getStr_gender1() {
	return str_gender1;
}
public void setStr_gender1(List<String> str_gender1) {
	this.str_gender1 = str_gender1;
}
public String str_Profession1;

public String getStr_Profession1() {
	return str_Profession1;
}
public void setStr_Profession1(String str_Profession1) {
	this.str_Profession1 = str_Profession1;
}
public String selectinfo15(ValueChangeEvent event)
{  
	str_Profession1 =( String )event.getNewValue();
	System.out.println(str_Profession+"jhnhjj77777777777777777777777777777777777");
	return  "";
}
public String str_Hobby;

public String getStr_Hobby() {
	return str_Hobby;
}
public void setStr_Hobby(String str_Hobby) {
	this.str_Hobby = str_Hobby;
}
public List<String>married_Status;

public List<String> getMarried_Status() {
	return married_Status;
}
public void setMarried_Status(List<String> married_Status) {
	this.married_Status = married_Status;
}
public String selectinfo17(ValueChangeEvent event)
{  
	married_status2 =( List<String> )event.getNewValue();
	System.out.println(str_MaritalStatus+"jhnhjj88888888888888888888888888888888888");
	return  "";
}
public String selectinfo16(ValueChangeEvent event)
{  
	str_Hobby =( String )event.getNewValue();
	System.out.println(str_Hobbies+"jhnhjj122222222222222222222222222");
	return  "";
}
public List<String>str_Gender;

public List<String> getStr_Gender() {
	return str_Gender;
}
public void setStr_Gender(List<String> str_Gender) {
	this.str_Gender = str_Gender;
}
public String selectinfo18(ValueChangeEvent event)
{  
	str_gender =( List<String> )event.getNewValue();
	System.out.println(str_Hobbies+"jhnhjj122222222222222222222222222");
	return  "";
}
}






