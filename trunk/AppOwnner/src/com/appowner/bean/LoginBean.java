package com.appowner.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.appowner.model.BookAFacility;
import com.appowner.model.MemberLog;
import com.appowner.model.ServiceRequest;
import com.appowner.model.User;
import com.appowner.service.In_UserService;
import com.appowner.util.Util;
@ManagedBean
@SessionScoped
public class LoginBean {
	private String userloginpassword;
	private String userloginname;
	private String facebook_userloginname;
	private String facebook_userloginpassword;
	private String linkddin_userloginname;
	private String linkddin_userloginpassword;
	public String formuserloginusername;
	public String formuserloginuserpassword;
	private Integer int_ApartmentId;
	private String str_ApartmentName;
	private String str_LoggedInTime;
	private String str_LoggedOutTime;
	private String str_Mobile;
	private String str_LandLineNum;
	private String str_EmailId;
	private String str_UserType;
	private String str_Block;
	private String str_OpenDate;
	private String str_CloseDate;
	private String str_VendorType;
	private String str_Description;
	private String str_Title;
	private String str_Flat;
	private String str_VendorName;
    private static String subject="subject";
	private static String content="content";
	 private static String Email="Email";
	 private static String str_Block1;
	 private static String str_Title1;
	 private static String str_ApartmentName1;
	 private static String str_Flat1;
	 private static String str_VendorType1;
	 private static String ss="approved";
     public static String getSs() {
		return ss;
	}
    public static void setSs(String ss) {
		LoginBean.ss = ss;
	}

    private static String cls="Closed";
    public static String getCls() {
	return cls;
    }
     public static void setCls(String cls) {
	   LoginBean.cls = cls;
       }
    public static String res="Rejected";
    public static String getRes() {
		return res;
	}
   public static void setRes(String res) {
		LoginBean.res = res;
   }
	 public List<ServiceRequest> getServiceRequestList() {
		 serviceRequestList=new ArrayList<ServiceRequest>();
		 serviceRequestList.addAll(getUserService().getServiceRequestList());
		return serviceRequestList;
	}





	public void setServiceRequestList(List<ServiceRequest> serviceRequestList) {
		this.serviceRequestList = serviceRequestList;
	}





	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}





	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	private static String str_OpenDate1;
	 private String str_EventName;
	 private String str_StartTime;
	 private String str_EndTime;
	 private String str_EventType;
	 private String str_FacilityType;
	 private BookAFacility bookAFacility;
	 private List<BookAFacility> bookAFacilityList;
	 private String Var_ImageName1;
		private String blb_image1;
		private String blb_images2;
		private String path2;
		private String cropimage;
		private String str_userRoleName;
		private List<ServiceRequest> serviceRequestList;

	 
		public String getStr_userRoleName() {
			return str_userRoleName;
		}





		public void setStr_userRoleName(String str_userRoleName) {
			this.str_userRoleName = str_userRoleName;
		}





		public String getCropimage() {
			System.out.println("+++++++++++++++++++++++iiiiiiiiiiiiiiiiiiiiiiii+++++++++++++++++++++");
			System.out.println(cropimage);
			return cropimage;//("")+File.separator+"images"+File.separator+"saphi"+File.separator+"crop"+File.separator+"images20140811143252.jpg";
		}





		public void setCropimage(String cropimage) {
			this.cropimage = cropimage;
		}





		public String getPath2() {
			return path2;
		}





		public void setPath2(String path2) {
			this.path2 = path2;
		}





		public String getBlb_images2() {
			
			return blb_images2;
		}





		public void setBlb_images2(String blb_images2) {
			this.blb_images2 = blb_images2;
		}





		public String getBlb_image1() {
			return blb_image1;
		}





		public void setBlb_image1(String blb_image1) {
			this.blb_image1 = blb_image1;
		}





		public String getVar_ImageName1() {
			return Var_ImageName1;
		}





		public void setVar_ImageName1(String var_ImageName1) {
			Var_ImageName1 = var_ImageName1;
		}





	 
	   // private static String content="content";
	
	public String getStr_EventName() {
		return str_EventName;
	}


	public void setStr_EventName(String str_EventName) {
		this.str_EventName = str_EventName;
	}


	public String getStr_StartTime() {
		return str_StartTime;
	}


	public void setStr_StartTime(String str_StartTime) {
		this.str_StartTime = str_StartTime;
	}


	public String getStr_EndTime() {
		return str_EndTime;
	}


	public void setStr_EndTime(String str_EndTime) {
		this.str_EndTime = str_EndTime;
	}


	public String getStr_EventType() {
		return str_EventType;
	}


	public void setStr_EventType(String str_EventType) {
		this.str_EventType = str_EventType;
	}


	public String getStr_FacilityType() {
		return str_FacilityType;
	}


	public void setStr_FacilityType(String str_FacilityType) {
		this.str_FacilityType = str_FacilityType;
	}


	public static String getStr_OpenDate1() {
		return str_OpenDate1;
	}


	public static void setStr_OpenDate1(String str_OpenDate1) {
		LoginBean.str_OpenDate1 = str_OpenDate1;
	}


	public static String getStr_Block1() {
		
		return str_Block1;
	}


	public static void setStr_Block1(String str_Block1) {
		LoginBean.str_Block1 = str_Block1;
	}


	public static String getStr_Title1() {
		return str_Title1;
	}


	public static void setStr_Title1(String str_Title1) {
		LoginBean.str_Title1 = str_Title1;
	}


	public static String getStr_ApartmentName1() {
		return str_ApartmentName1;
	}


	public static void setStr_ApartmentName1(String str_ApartmentName1) {
		LoginBean.str_ApartmentName1 = str_ApartmentName1;
	}


	public BookAFacility getBookAFacility() {
		return bookAFacility;
	}


	public void setBookAFacility(BookAFacility bookAFacility) {
		this.bookAFacility = bookAFacility;
	}


	public List<BookAFacility> getBookAFacilityList() {
		bookAFacilityList=getUserService().getBookAFacilityList();
		return bookAFacilityList;
	}


	public void setBookAFacilityList(List<BookAFacility> bookAFacilityList) {
		this.bookAFacilityList = bookAFacilityList;
	}


	public static String getStr_Flat1() {
		return str_Flat1;
	}


	public static void setStr_Flat1(String str_Flat1) {
		LoginBean.str_Flat1 = str_Flat1;
	}


	public static String getStr_VendorType1() {
		return str_VendorType1;
	}


	public static void setStr_VendorType1(String str_VendorType1) {
		LoginBean.str_VendorType1 = str_VendorType1;
	}


	public String getStr_VendorName() {
		return str_VendorName;
	}


	public static String getSubject() {
		
		return subject;
		
	}


	public static void setSubject(String subject) {
		LoginBean.subject = subject;
	}


	public static String getContent() {
		return content;
	}


	public static void setContent(String content) {
		LoginBean.content = content;
	}


	public static String getEmail() {
		return Email;
	}


	public static void setEmail(String email) {
		Email = email;
	}


	public void setStr_VendorName(String str_VendorName) {
		this.str_VendorName = str_VendorName;
	}


	public String getStr_Flat() {
		str_Flat=user.getStr_Flat();
		return str_Flat;
	}


	public void setStr_Flat(String str_Flat) {
		this.str_Flat = str_Flat;
	}


	public String getStr_Mobile() {
		str_Mobile=user.getStr_PhoneNo();
		return str_Mobile;
	}


	public void setStr_Mobile(String str_Mobile) {
		this.str_Mobile = str_Mobile;
	}


	public String getStr_LandLineNum() {
		 
		return str_LandLineNum;
	}


	public void setStr_LandLineNum(String str_LandLineNum) {
		this.str_LandLineNum = str_LandLineNum;
	}


	public String getStr_EmailId() {
		str_EmailId=user.getStr_Email();
		return str_EmailId;
	}


	public void setStr_EmailId(String str_EmailId) {
		this.str_EmailId = str_EmailId;
	}


	public String getStr_UserType() {
		int role=user.getInt_UserRole();
		if(role==1)
			return str_UserType="Tenant";
			
		return str_UserType="Owner";
	}


	 

	public void setStr_UserType(String str_UserType) {
		
		this.str_UserType = str_UserType;
	}


	public String getStr_Block() {
		str_Block=user.getStr_Block();
		return str_Block;
	}


	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}


	 


	public String getStr_OpenDate() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
		str_OpenDate=dateFormat.format(date);
		return str_OpenDate;
	}


	public void setStr_OpenDate(String str_OpenDate) {
		this.str_OpenDate = str_OpenDate;
	}


	public String getStr_CloseDate() {
		str_CloseDate="Not Applicable";
		return str_CloseDate;
	}


	public void setStr_CloseDate(String str_CloseDate) {
		this.str_CloseDate = str_CloseDate;
	}


	public String getStr_VendorType() {
		return str_VendorType;
	}


	public void setStr_VendorType(String str_VendorType) {
		this.str_VendorType = str_VendorType;
	}


	public String getStr_Description() {
		return str_Description;
	}


	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}


	public String getStr_Title() {
		return str_Title;
	}


	public void setStr_Title(String str_Title) {
		this.str_Title = str_Title;
	}


	public String getStr_Status() {
		return str_Status;
	}


	public void setStr_Status(String str_Status) {
		this.str_Status = str_Status;
	}

	private String str_Status;
	
	
	public String getStr_ApartmentName() {
		str_ApartmentName=user.getStr_Apartment();
		return str_ApartmentName;
	}

 
	public void setStr_ApartmentName(String str_ApartmentName) {
		this.str_ApartmentName = str_ApartmentName;
	}

	private Integer int_UserId;
	
	public String getUserloginpassword() {
		
		return userloginpassword;
	}





	public void setUserloginpassword(String userloginpassword) {
		this.userloginpassword = userloginpassword;
	}





	public String getUserloginname() {
		 
		return userloginname;
	}





	public void setUserloginname(String userloginname) {
		this.userloginname = userloginname;
	}





	public String getFacebook_userloginname() {
		return facebook_userloginname;
	}





	public void setFacebook_userloginname(String facebook_userloginname) {
		this.facebook_userloginname = facebook_userloginname;
	}





	 


	public String getStr_LoggedInTime() {
		return str_LoggedInTime;
	}


	public void setStr_LoggedInTime(String str_LoggedInTime) {
		this.str_LoggedInTime = str_LoggedInTime;
	}


	public String getStr_LoggedOutTime() {
		return str_LoggedOutTime;
	}


	public void setStr_LoggedOutTime(String str_LoggedOutTime) {
		this.str_LoggedOutTime = str_LoggedOutTime;
	}


	public String getFacebook_userloginpassword() {
		return facebook_userloginpassword;
	}





	public void setFacebook_userloginpassword(String facebook_userloginpassword) {
		this.facebook_userloginpassword = facebook_userloginpassword;
	}





	public String getLinkddin_userloginname() {
		return linkddin_userloginname;
	}





	public void setLinkddin_userloginname(String linkddin_userloginname) {
		this.linkddin_userloginname = linkddin_userloginname;
	}





	public String getLinkddin_userloginpassword() {
		return linkddin_userloginpassword;
	}





	public void setLinkddin_userloginpassword(String linkddin_userloginpassword) {
		this.linkddin_userloginpassword = linkddin_userloginpassword;
	}
	  public void getDetails()
	  	{
	  		System.out.println(int_UserId);
	  		user=getUserService().getUserList1(int_UserId);
	  		//pro=getProductDetailService().editproduct(Int_ProductId);	
	  		
	  		
	  	}

	@ManagedProperty(value = "#{cls_UserService}")
	private In_UserService userService;
	public In_UserService getUserService() {
		return userService;
	}
	public void setUserService(In_UserService userService) {
		this.userService = userService;
	}



private User user;

	public User getUser() {
	return user;
}





public void setUser(User user) {
	this.user = user;
}



 private MemberLog memberLog;
 private List<MemberLog> listMemberLog;

	public MemberLog getMemberLog() {
	return memberLog;
}


public void setMemberLog(MemberLog memberLog) {
	this.memberLog = memberLog;
}


public List<MemberLog> getListMemberLog() {
	listMemberLog=new ArrayList<MemberLog>();
	listMemberLog=getUserService().getListMemberLog();
	return listMemberLog;
}


public void setListMemberLog(List<MemberLog> listMemberLog) {
	this.listMemberLog = listMemberLog;
}


	public String userLogin()
	{

		System.out.println("//////////////////////////////////");
		formuserloginusername=getUserloginname();
		formuserloginuserpassword=getUserloginpassword();
		
		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		System.out.println(formuserloginusername);
		System.out.println(formuserloginuserpassword);
		user=getUserService().getUserList(formuserloginusername);
		System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		System.out.println(user);
		str_userRoleName=user.getStr_UserRoleName();
		System.out.println(user.getStr_Password());
		str_Block=user.getStr_Block();
		str_Flat=user.getStr_Flat();
		int_UserId=user.getInt_UserId();
		str_EmailId=user.getStr_Email();
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjppppppppppppppppppppppppppppppppppppppppppppppppppppppppjjjjjjjjjjjjjjjjjjj");
		System.out.println(str_userRoleName);
		String admin1="admin";
		
		if(formuserloginuserpassword.equals(user.getStr_Password()))
		{   
			System.out.println("+++++++++++++++++++++++++++66666666666666666666666666666666");
			System.out.println(str_userRoleName);
			System.out.println(admin1);
		   if(admin1.equals(str_userRoleName))
		   {
			int_ApartmentId=user.getInt_ApartmentId();
			int_UserId=user.getInt_UserId();
			
			
			HttpSession session = Util.getSession();
            session.setAttribute("username", userloginname);
            session.setAttribute("int_ApartmentId", int_ApartmentId);
            session.setAttribute("int_UserId", int_UserId);
            session.setAttribute("str_Block",str_Block);
            session.setAttribute("str_Flat",str_Flat);
            session.setAttribute("ApartmentName", user.getStr_Apartment());
            session.setAttribute("str_EmailId",str_EmailId);
            session.setAttribute("str_Country",user.getStr_Country());
            System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqfff555555555555fffqqqqqqqqqqqqqqqqqqqqqqqq");
			System.out.println(user.getStr_Country());
            session.setAttribute("str_State",user.getStr_State());
            session.setAttribute("str_City",user.getStr_City());
            session.setAttribute("str_Apartment",user.getStr_Apartment());
			System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
			System.out.println("hiiiiiiiiiiiii");
		 	String index="Adminwelcomepage.xhtml";
		  return index;
		   }
		   else
		   {
			   int_ApartmentId=user.getInt_ApartmentId();
				int_UserId=user.getInt_UserId();
				
				HttpSession session = Util.getSession();
				 
	            session.setAttribute("username", userloginname);
				session.setAttribute("ApartmentName", user.getStr_Apartment());
				session.setAttribute("str_Block",str_Block);
				session.setAttribute("str_Flat",str_Flat);
	            session.setAttribute("int_ApartmentId", int_ApartmentId);
	            session.setAttribute("int_UserId", int_UserId);
	            session.setAttribute("str_EmailId",str_EmailId);
	            session.setAttribute("str_Country",user.getStr_Country());
	            
	            session.setAttribute("str_State",user.getStr_State());
	            session.setAttribute("str_City",user.getStr_City());
	            session.setAttribute("str_Apartment",user.getStr_Apartment());
				System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqffffffqqqqqqqqqqqqqqqqqqqqqqqq");
				System.out.println(user.getStr_Country());
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				//get current date time with Date()
				Date date = new Date();
				 
				str_LoggedInTime= dateFormat.format(date);
				System.out.println(str_LoggedInTime);
				/*memberLog=new MemberLog();
				memberLog.setInt_ApartmentId(int_ApartmentId);
				memberLog.setInt_UserId(int_UserId);
				memberLog.setStr_Block(user.getStr_Block());
				memberLog.setStr_UserEmailId(user.getStr_Email());
				memberLog.setStr_LoggedInTime(str_LoggedInTime);
				memberLog.setStr_LogOutTime("N/A");
				//memberLog.setStr_LogOutTime(str_LoggedOutTime);
				
				
				getUserService().addMemberLog(memberLog);*/
				str_LoggedInTime=dateFormat.format(date);
				if(session==null)
				  memberLog();
			 String index1= "welcomepage.xhtml";
			 return index1;
		   }
		}
 
		else
		{FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("User name or password id invalid!"));
		return "layout.xhtml?error=yes";
		}
	}
	public Integer getInt_UserId() {
		return int_UserId;
	}





	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}

	//image uploading
			public void handleFileUpload1(FileUploadEvent event) throws IOException {
				 System.out.println("hi");
				 String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
				    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
				    String name = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
				    System.out.println(name);
				    File file= new File("C://Users//Pankaj Singh//workspace10//AppOwnner//WebContent//images//saphi//crop\\"+ "images" + name);
				    
				   
				    final UploadedFile uploadedFile = event.getFile();
				    blb_image1=file.getAbsolutePath();
				    System.out.println("ppppppppppppppppppppppppppppppppppppppppppppppppppppp");
				    System.out.println(blb_image1);
				    blb_images2=blb_image1.substring(55);
				    cropimage="/"+blb_images2;
				    System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
				    System.out.println(cropimage);
			        System.out.println(file);
				    InputStream is = event.getFile().getInputstream();
				    OutputStream out = new FileOutputStream(file);
				    byte buf[] = new byte[1024];
				    int len;
				    while ((len = is.read(buf)) > 0)
				        out.write(buf, 0, len);
				    is.close();
				    out.close();
				    path2=file.getName();
				    System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooo");
				    System.out.println(path2);
			}



	public String logout() {
	      HttpSession session = Util.getSession();
	      session.invalidate();
	      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    //get current date time with Date()
	    Date date = new Date();
	      str_LoggedOutTime=dateFormat.format(date);
	      memberLog();
	      return "layout.xhtml";
	   }
	private ServiceRequest serviceRequest;
	public String addServiceRequest()
	{
		serviceRequest=new ServiceRequest();
		serviceRequest.setInt_ApartmentId(int_ApartmentId);
		serviceRequest.setInt_UserId(int_UserId);
		serviceRequest.setStr_Description(str_Description);
		serviceRequest.setStr_EmailId(str_EmailId);
		serviceRequest.setStr_Flat(str_Flat);
		serviceRequest.setStr_LandLineNum(str_LandLineNum);
		serviceRequest.setStr_Mobile(str_Mobile);
		serviceRequest.setStr_Status("open");
		serviceRequest.setStr_Title(str_Title);
		serviceRequest.setStr_UserType(str_UserType);
		serviceRequest.setStr_VendorName(str_VendorName);
		serviceRequest.setStr_VendorType(str_VendorType);
		serviceRequest.setStr_OpenDate(str_OpenDate);
		serviceRequest.setStr_CloseDate(str_CloseDate);
		 getUserService().addServiceRequest(serviceRequest);
		 FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Service Request Saved Successfully !", "Service Request Saved Successfully !"));
		 //Email=user.getStr_Email();
		 Email="devroutaray@gmail.com";
		 subject="Service Request";
		 content="sir i need ur BsnlBroadBand service so plz provice it";
		 str_ApartmentName1=user.getStr_Apartment();
		 str_Flat1=user.getStr_Flat();
		 str_Block1=user.getStr_Block();
		 str_VendorType1=getStr_VendorType();
		 str_Title1=getStr_Title();
		 str_OpenDate1=getStr_OpenDate();
		 return "workordercategory1.jsp";
		
	}
	public void addBookAFacility()
	{
		bookAFacility=new BookAFacility();
		bookAFacility.setInt_UserId(int_UserId);
		bookAFacility.setInt_ApartmentId(int_ApartmentId);
		bookAFacility.setStr_EmailId(str_EmailId);
		bookAFacility.setStr_EndTime(str_EndTime);
		bookAFacility.setStr_EventType(str_EventType);
		bookAFacility.setStr_FacilityType(str_FacilityType);
		bookAFacility.setStr_Flat(str_Flat);
		bookAFacility.setStr_Mobile(str_Mobile);
		bookAFacility.setStr_OpenDate(str_OpenDate);
		bookAFacility.setStr_CloseDate(str_CloseDate);
		bookAFacility.setStr_StartTime(str_StartTime);
		bookAFacility.setStr_UserType(str_UserType);
		getUserService().addBookAFacility(bookAFacility);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"  Successfully  Book A Facility!", " Successfully  Book A Facility !"));
	}
	/*
	 * add member login and logout info
	 */
	public void memberLog()
	{
		 memberLog=new MemberLog();
			memberLog.setInt_ApartmentId(int_ApartmentId);
			memberLog.setInt_UserId(int_UserId);
			memberLog.setStr_Block(user.getStr_Block());
			memberLog.setStr_UserEmailId(user.getStr_Email());
			memberLog.setStr_LoggedInTime(str_LoggedInTime);
	      
	      memberLog.setStr_LogOutTime(str_LoggedOutTime);
	      getUserService().addMemberLog(memberLog);
	      System.out.println(str_LoggedOutTime);
	      
	    
	}
	public String updateUser(){
		user.setVar_FileName1(getPath2());
		user.setVar_ImageName1(getBlb_image1());
		getUserService().updateUs(user);
		//System.out.println(pro);
		return "updationconfirmation.xhtml";
		}
	

	public void facebookuserLogin()
	{
		
		
		
	}
	public void linkedinuserLogin()
	{
		
		
		
	}

}

