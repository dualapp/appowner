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
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.lang.RandomStringUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.UploadedFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.appowner.model.BookAFacility;
import com.appowner.model.MemberLog;
import com.appowner.model.ServiceRequest;
import com.appowner.model.User;
import com.appowner.model.UserExtraInfo;
import com.appowner.service.ApartmentDetailsService;
import com.appowner.service.In_UserService;
import com.appowner.service.MaintainanceStaffService;
import com.appowner.util.Util;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userloginpassword;
	private String userloginname;
	private String str_FacebookId;
	 public static String str_ImagePath;
		
		public static String getStr_ImagePath() {
			str_ImagePath="C://Program Files//MyUploads";
			return str_ImagePath;
		}
		public static void setStr_ImagePath(String str_ImagePath) {
			LoginBean.str_ImagePath = str_ImagePath;
		}

	private String linkddin_userloginname;
	private String currentPassword;
	private String newPassword;

	private String str_LinkedInId;

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
	private static String subject = "subject";
	private static String content = "content";
	private static String Email = "Email";
	private static String str_Block1;
	private static String str_Title1;
	private static String str_ApartmentName1;
	private static String str_Flat1;
	private static String str_VendorType1;
	private static String ss = "approved";
	private static String str_firstName;
	private static String str_UserName;

	private String str_BloodGroup;

	private String str_MaritalStatus;
	private String str_Hobbies;
	private String str_Proffession;
	private List<String> str_IntrestedIn;
	private String str_TwitterId;
	private String str_PersonalBlog;
	private String str_Gender;
	private Date date_DateOfBirth;
	private String str_FirstName;
	private String str_Country;
	private String str_State;
	private String str_City;
	private static String str_RecoverPassword;

	public static String getStr_UserName() {
		return str_UserName;
	}

	public static void setStr_UserName(String str_UserName) {
		LoginBean.str_UserName = str_UserName;
	}

	public String getStr_FacebookId() {
		str_FacebookId = Util.getEmailId();
		return str_FacebookId;
	}

	public void setStr_FacebookId(String str_FacebookId) {
		this.str_FacebookId = str_FacebookId;
	}

	public String getStr_LinkedInId() {
		return str_LinkedInId;
	}

	public void setStr_LinkedInId(String str_LinkedInId) {
		this.str_LinkedInId = str_LinkedInId;
	}

	private int status;

	 

	public String getStr_Country() {
		return str_Country;
	}

	public void setStr_Country(String str_Country) {
		this.str_Country = str_Country;
	}

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

	private String str_LastName;

	public String getStr_FirstName() {
		str_FirstName = Util.getStr_FirstName();
		return str_FirstName;
	}

	public void setStr_FirstName(String str_FirstName) {
		this.str_FirstName = str_FirstName;
	}

	public String getStr_LastName() {
		str_LastName = Util.getStr_LastName();
		return str_LastName;
	}

	public void setStr_LastName(String str_LastName) {
		this.str_LastName = str_LastName;
	}

	public String getStr_BloodGroup() {
		return str_BloodGroup;
	}

	public void setStr_BloodGroup(String str_BloodGroup) {
		this.str_BloodGroup = str_BloodGroup;
	}

	public String getStr_MaritalStatus() {
		return str_MaritalStatus;
	}

	public void setStr_MaritalStatus(String str_MaritalStatus) {
		this.str_MaritalStatus = str_MaritalStatus;
	}

	public String getStr_Hobbies() {
		return str_Hobbies;
	}

	public void setStr_Hobbies(String str_Hobbies) {
		this.str_Hobbies = str_Hobbies;
	}

	public String getStr_Proffession() {
		return str_Proffession;
	}

	public void setStr_Proffession(String str_Proffession) {
		this.str_Proffession = str_Proffession;
	}

	public String getStr_TwitterId() {
		return str_TwitterId;
	}

	public void setStr_TwitterId(String str_TwitterId) {
		this.str_TwitterId = str_TwitterId;
	}

	public String getStr_PersonalBlog() {
		return str_PersonalBlog;
	}

	public void setStr_PersonalBlog(String str_PersonalBlog) {
		this.str_PersonalBlog = str_PersonalBlog;
	}

	public String getStr_Gender() {

		if (str_Gender == null) {
			str_Gender = Util.getGender();

			return str_Gender;
		}
		return str_Gender;
	}

	public void setStr_Gender(String str_Gender) {
		this.str_Gender = str_Gender;
	}

	public Date getDate_DateOfBirth() {
		return date_DateOfBirth;
	}

	public void setDate_DateOfBirth(Date date_DateOfBirth) {
		this.date_DateOfBirth = date_DateOfBirth;
	}

	public static String getSs() {
		return ss;
	}

	public static void setSs(String ss) {
		LoginBean.ss = ss;
	}

	private static String cls = "Closed";

	public static String getCls() {
		return cls;
	}

	public static void setCls(String cls) {
		LoginBean.cls = cls;
	}

	public static String res = "Rejected";

	public static String getRes() {
		return res;
	}

	public static void setRes(String res) {
		LoginBean.res = res;
	}

	public List<ServiceRequest> getServiceRequestList() {
		serviceRequestList = new ArrayList<ServiceRequest>();
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
		System.out
				.println("+++++++++++++++++++++++iiiiiiiiiiiiiiiiiiiiiiii+++++++++++++++++++++");
		System.out.println(cropimage);
		return cropimage;// ("")+File.separator+"images"+File.separator+"saphi"+File.separator+"crop"+File.separator+"images20140811143252.jpg";
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
		// Var_ImageName1=user.getVar_ImageName1();
		if (Var_ImageName1 == null) {
			Var_ImageName1 = "/images/profilepic.png";
			System.out.println(Var_ImageName1 + "img1");
		}

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
		bookAFacilityList = getUserService().getBookAFacilityList();
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

		return str_Flat;
	}

	public void setStr_Flat(String str_Flat) {
		this.str_Flat = str_Flat;
	}

	public String getStr_Mobile() {

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

	private String str_Email;

	public String getStr_Email() {
		return str_Email;
	}

	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}

	public String getStr_EmailId() {
		if (str_EmailId == null)
			str_EmailId = Util.getEmail();
		return str_EmailId;
	}

	public void setStr_EmailId(String str_EmailId) {
		this.str_EmailId = str_EmailId;
	}

	public String getStr_UserType() {
		int role = Util.getInt_UserRole();
		if (role == 1)
			return str_UserType = "Tenant";

		return str_UserType = "Owner";
	}

	public void setStr_UserType(String str_UserType) {

		this.str_UserType = str_UserType;
	}

	public String getStr_Block() {

		return str_Block;
	}

	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}

	public String getStr_OpenDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		str_OpenDate = dateFormat.format(date);
		return str_OpenDate;
	}

	public void setStr_OpenDate(String str_OpenDate) {
		this.str_OpenDate = str_OpenDate;
	}

	public String getStr_CloseDate() {
		str_CloseDate = "Not Applicable";
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
		str_ApartmentName = Util.getAppartmentName();
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
		user=new User();
		user=getUserService().getUser(Util.getUserId());
		if (user!= null) {
			userloginname = user.getStr_Username();
			

		}

		return userloginname;
	}

	public void setUserloginname(String userloginname) {
		this.userloginname = userloginname;
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

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getLinkddin_userloginname() {
		return linkddin_userloginname;
	}

	public void setLinkddin_userloginname(String linkddin_userloginname) {
		this.linkddin_userloginname = linkddin_userloginname;
	}

	public void getDetails() {

		user = getUserService().getUserList1(Util.getUserId());

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
		listMemberLog = new ArrayList<MemberLog>();
		listMemberLog = getUserService().getListMemberLog();
		return listMemberLog;
	}

	public void setListMemberLog(List<MemberLog> listMemberLog) {
		this.listMemberLog = listMemberLog;
	}

	private static boolean admin;

	public static boolean isAdmin() {
		return admin;
	}

	public static void setAdmin(boolean admin) {
		LoginBean.admin = admin;
	}

	private static boolean user1;

	public static boolean isUser1() {
		return user1;
	}

	public static void setUser1(boolean user1) {
		LoginBean.user1 = user1;
	}

	public String updatePassword() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);

		formuserloginuserpassword = getUserService().getPassword(
				Util.getUserId());
		if (formuserloginuserpassword.equals(getCurrentPassword())) {
			getUserService().updatePassword(Util.getUserId(), getNewPassword());
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Password Changed Successfully!",
					"password Changed Successfully!"));

		} else {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Current Password is Wrong!",
					"Current Password is Wrong!"));

			return "";
		}

		return "/AfrteLoginViews/welcomepage.xhtml";
	}
    public List<String> roleAssign;
	
	public List<String> getRoleAssign() {
		return roleAssign;
	}
	public void setRoleAssign(List<String> roleAssign) {
		this.roleAssign = roleAssign;
	}
	@SuppressWarnings("unused")
	public String getStr_RecoverPassword1() {
		User u = new User();
		u = getUserService().getUser(getStr_Email());

		if(u!=null)
		{
			System.out.println(u.getStr_FirstName()+"user exist");
		System.out.println(str_RecoverPassword + "fpassword");
		  Email=getStr_Email();
		//Email = "kalpanasudha1990@gmail.com";
		str_RecoverPassword = RandomStringUtils.randomAlphanumeric(6);
		getUserService().setPassword(getStr_Email(), str_RecoverPassword);

		subject = "Reset Password Instructions for you on AppOwner";
		content = "" + "";
		str_firstName = u.getStr_FirstName();
		System.out.println(str_firstName + "firstname");
		str_UserName = u.getStr_Username();
		System.out.println(Email);
		return "forgotpassword1.jsp";
	}
	else
		
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("We couldn't find your account with that information ,Please try searching for your email again! "));
		 
		 return "forgotpassword.xhtml";
	}
		
	}

	public static String getStr_RecoverPassword() {
		return str_RecoverPassword;
	}

	public static void setStr_RecoverPassword(String str_RecoverPassword) {
		LoginBean.str_RecoverPassword = str_RecoverPassword;
	}
	public Integer expireDay;

	public Integer getExpireDay() {
		return expireDay;
	}
	public void setExpireDay(Integer expireDay) {
		this.expireDay = expireDay;
	}
	public Integer actvationkey;
	public Integer getActvationkey() {
		return actvationkey;
	}
	@ManagedProperty(value="#{MaintainanceStaffService}")
	private  MaintainanceStaffService maintainanceStaffService;
	public MaintainanceStaffService getMaintainanceStaffService() {
		return maintainanceStaffService;
	}
	public void setMaintainanceStaffService(
			MaintainanceStaffService maintainanceStaffService) {
		this.maintainanceStaffService = maintainanceStaffService;
	}
	public void setActvationkey(Integer actvationkey) {
		this.actvationkey = actvationkey;
	}
	public String userLogin()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String userName=request.getParameter("Userloginname");
		System.out.println(userName+"klkk123");
		 String userPassword=request.getParameter("userPassword");
		 System.out.println(userPassword+"sdjdskjdskj");
		formuserloginusername=userName;
		formuserloginuserpassword=userPassword;
		System.out.println(formuserloginusername+"klkk");
		System.out.println(formuserloginuserpassword+"fdkfd");
		System.out.println(userloginpassword+"jjkjkkjkj");
		if(formuserloginusername==null)
		{
			user=getUserService().getUserList(Util.getUserName());
		}
		else
		user=getUserService().getUserList(formuserloginusername);
				 
		 
		str_userRoleName=user.getStr_UserRoleName();
		 str_Country=user.getStr_Country();
		//formuserloginuserpassword=user.getStr_Password();
		 System.out.println(formuserloginuserpassword+"kldfkldlk");
		 str_State=user.getStr_State();
		 str_City=user.getStr_City();
		str_Block=user.getStr_Block();
		str_FirstName=user.getStr_FirstName();
		str_LastName=user.getStr_LastName();
		str_Flat=user.getStr_Flat();
		str_Mobile=user.getStr_PhoneNo();
		int_UserId=user.getInt_UserId();
		str_EmailId=user.getStr_Email();
		int_ApartmentId=user.getInt_ApartmentId();
		str_ApartmentName=user.getStr_Apartment();
		roleAssign=getUserService().getRoleAssign(int_UserId,int_ApartmentId);
		System.out.println(roleAssign+"gfgfkjgfjk");
		System.out.println(roleAssign+"fdkjfdkjfdkj");
		 status=getUserService().getStatus(str_ApartmentName);
		 actvationkey=user.getInt_activationbit();
		 System.out.println(status+"fkdfdkj");
		String admin1="admin";
	
	if(status==0)
	{ if(actvationkey==1)
	  {
		if(formuserloginuserpassword.equals(user.getStr_Password()) )
		  {    
		
		     if(admin1.equals(str_userRoleName))
		    {
			int_ApartmentId=user.getInt_ApartmentId();
			java.util.Date Entrydate=new java.util.Date();
			Date EndDate=getUserService().getEndDate(int_ApartmentId);
			expireDay=(int) ((EndDate.getTime() - Entrydate.getTime())/(1000 * 60 * 60 * 24));
			System.out.println(expireDay+"fdkjfdjkfdkj");
			System.out.println(Entrydate+"lkfklfddf");
			System.out.println(EndDate+"dksdsksdk");
			int_UserId=user.getInt_UserId();
			admin=admin1.equals(str_userRoleName);
			user1=!admin1.equals(str_userRoleName);
			System.out.println(formuserloginusername+"fkjdfdkjfdkj8888888888888888888888888888888888888888");
			 HttpSession session = Util.getSession();
			 session.setAttribute("str_FirstName", str_FirstName);
			 session.setAttribute("str_LastName", str_LastName);
			  
            session.setAttribute("username", formuserloginusername);
            session.setAttribute("str_Password", formuserloginuserpassword);
            session.setAttribute("int_ApartmentId", int_ApartmentId);
            session.setAttribute("int_UserId", int_UserId);
            session.setAttribute("str_Block",str_Block);
            session.setAttribute("str_Flat",str_Flat);
            session.setAttribute("str_Mobile",str_Mobile);
            
            session.setAttribute("str_EmailId",str_EmailId);
            session.setAttribute("str_Country",str_Country);
            
            session.setAttribute("str_State",str_State);
            session.setAttribute("str_City",str_City);
            session.setAttribute("str_Apartment",user.getStr_Apartment());
            session.setAttribute("str_userRoleName", str_userRoleName);
			 
            session.setAttribute("int_UserRole", user.getInt_UserRole());
		     return "/AfrteLoginViews/Adminwelcomepage.xhtml";
		   }
		   else if(str_userRoleName.equalsIgnoreCase("user") && roleAssign.isEmpty())
		   {   System.out.println( "fdufdkjfdjkfdjgffggffg");
			   int_ApartmentId=user.getInt_ApartmentId();
				int_UserId=user.getInt_UserId();
				admin=admin1.equals(str_userRoleName);
				user1=!admin1.equals(str_userRoleName);
				
				HttpSession session = Util.getSession();
				 session.setAttribute("str_Password", formuserloginuserpassword);
				session.setAttribute("str_FirstName", str_FirstName);
				 session.setAttribute("str_LastName", str_LastName);
				 session.setAttribute("int_UserRole", user.getInt_UserRole());
				 
	            session.setAttribute("username", userloginname);
				 
				session.setAttribute("str_Block",str_Block);
				session.setAttribute("str_Flat",str_Flat);
	            session.setAttribute("int_ApartmentId", int_ApartmentId);
	            session.setAttribute("int_UserId", int_UserId);
	            session.setAttribute("str_EmailId",str_EmailId);
	            session.setAttribute("str_Country",str_Country);
	            
	            session.setAttribute("str_State",str_State);
	            session.setAttribute("str_City",str_City);
	            session.setAttribute("str_Mobile",str_Mobile);
	            
	            session.setAttribute("str_Apartment",user.getStr_Apartment());
	            session.setAttribute("str_userRoleName", str_userRoleName);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				//get current date time with Date()
				Date date = new Date();
				 
				str_LoggedInTime= dateFormat.format(date);
				System.out.println(str_LoggedInTime);
				
				str_LoggedInTime=dateFormat.format(date);
				if(session==null)
				  memberLog();
				
				 return "/AfrteLoginViews/welcomepage.xhtml";
		   }
		   else
		   {   System.out.println("njvvkjjkfgjkgfgjkgfkj");
			   int_ApartmentId=user.getInt_ApartmentId();
				int_UserId=user.getInt_UserId();
				admin=admin1.equals(str_userRoleName);
				user1=!admin1.equals(str_userRoleName);
				
				HttpSession session = Util.getSession();
				 session.setAttribute("str_Password", formuserloginuserpassword);
				session.setAttribute("str_FirstName", str_FirstName);
				 session.setAttribute("str_LastName", str_LastName);
				 session.setAttribute("int_UserRole", user.getInt_UserRole());
				 
	            session.setAttribute("username", userloginname);
				 
				session.setAttribute("str_Block",str_Block);
				session.setAttribute("str_Flat",str_Flat);
	            session.setAttribute("int_ApartmentId", int_ApartmentId);
	            session.setAttribute("int_UserId", int_UserId);
	            session.setAttribute("str_EmailId",str_EmailId);
	            session.setAttribute("str_Country",str_Country);
	            
	            session.setAttribute("str_State",str_State);
	            session.setAttribute("str_City",str_City);
	            session.setAttribute("str_Mobile",str_Mobile);
	            
	            session.setAttribute("str_Apartment",user.getStr_Apartment());
	            session.setAttribute("str_userRoleName", str_userRoleName);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				//get current date time with Date()
				Date date = new Date();
				 
				str_LoggedInTime= dateFormat.format(date);
				System.out.println(str_LoggedInTime);
				
				str_LoggedInTime=dateFormat.format(date);
				if(session==null)
				  memberLog();
				 return "/AfrteLoginViews/Adminwelcomepage.xhtml";
		   }
		}
	  else
		   {
			   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"User name or password is invalid!","User name or password is invalid!"));
				return "layout.xhtml";  
		   }
	
	}
	else
	{
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Plz activate ur account! Credential sent to ur Email","Plz activate ur account! Credential sent to ur Email"));
			return "layout.xhtml"; 
	}
	
	}
		else
		{
			
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Status is Disabled.PlZ contact to Admin!","Status is Disabled.PlZ contact to Admin!"));
				
			
		}
			
		
		return "layout.xhtml";	
		
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getInt_UserId() {
		return int_UserId;
	}

	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}
	public boolean indicator;
	public boolean isIndicator() {
		return indicator;
	}
	public void setIndicator(boolean indicator) {
		this.indicator = indicator;
	}
	public String logout() {
		System.out.println("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
	     
	      memberLog();
	      HttpSession session = Util.getSession();
	      session.invalidate();
	      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    //get current date time with Date()
	    Date date = new Date();
	    indicator=true;
	      str_LoggedOutTime=dateFormat.format(date);
	      System.out.println("djjdffjfjdfj");
	      return "/layout.xhtml";
	   }

	private ServiceRequest serviceRequest;

	public String addServiceRequest() {
		serviceRequest = new ServiceRequest();
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
		facesContext.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"Service Request Saved Successfully !",
				"Service Request Saved Successfully !"));
		 Email=user.getStr_Email();
		//Email = "kalpana.j5599@gmail.com";
		subject = "Service Request";
		content = "Service Related";
		str_ApartmentName1 = user.getStr_Apartment();
		str_Flat1 = user.getStr_Flat();
		str_Block1 = user.getStr_Block();
		str_VendorType1 = getStr_VendorType();
		str_Title1 = getStr_Title();
		str_OpenDate1 = getStr_OpenDate();
		return "workordercategory1.jsp";

	}

	public String addBookAFacility() {
		bookAFacility = new BookAFacility();
		bookAFacility.setStr_CreatedBy(userloginname);
		bookAFacility.setInt_UserId(int_UserId);
		bookAFacility.setInt_ApartmentId(int_ApartmentId);
		bookAFacility.setStr_EventName(str_EventName);
		bookAFacility.setStr_EmailId(str_EmailId);
		bookAFacility.setStr_EndTime(str_EndTime);
		bookAFacility.setStr_EventType(str_EventType);
		bookAFacility.setStr_FacilityType(str_FacilityType);
		bookAFacility.setStr_Flat(str_Flat);
		bookAFacility.setStr_Status("Open");
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
		facesContext.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO, "  Successfully  Book A Facility!",
				" Successfully  Book A Facility !"));
		return "/AfrteLoginViews/Facilities/facilityneeded.xhtml";
	}

	/*
	 * add member login and logout info
	 */
	public void memberLog() {
		memberLog = new MemberLog();
		memberLog.setInt_ApartmentId(int_ApartmentId);
		memberLog.setInt_UserId(int_UserId);
		// memberLog.setStr_Block(user.getStr_Block());
		// memberLog.setStr_UserEmailId(user.getStr_Email());

		memberLog.setStr_LoggedInTime(str_LoggedInTime);

		memberLog.setStr_LogOutTime(str_LoggedOutTime);
		getUserService().addMemberLog(memberLog);
		System.out.println(str_LoggedOutTime);

	}

	private UserExtraInfo userExtraInfo;

	public String updateUser() {
		User user = new User();
		user=getUserService().getUser(Util.getUserId());
		System.out.println(user+"uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu"+Util.getUserId());
		userExtraInfo = new UserExtraInfo();
		userExtraInfo=getUserService().getUserExtraInfo(Util.getUserId());
		if(userExtraInfo!=null)
		{

		userExtraInfo.setStr_gender(getStr_Gender());
		userExtraInfo.setDate_DateOfBirth(getDate_DateOfBirth());
		userExtraInfo.setStr_BloodGroup(str_BloodGroup);
		 
		userExtraInfo.setStr_FaceBookId(str_FacebookId);
		userExtraInfo.setStr_Hobbies(str_Hobbies);
		 
		// userExtraInfo.setStr_IntrestedIn(str_IntrestedIn);

		userExtraInfo.setStr_LinkedInId(str_LinkedInId);
		userExtraInfo.setStr_MaritalStatus(str_MaritalStatus);
		userExtraInfo.setStr_PersonalBlog(str_PersonalBlog);
		userExtraInfo.setStr_TwitterId(str_TwitterId);
		userExtraInfo.setStr_Profession(str_Proffession);
		user.setUserExtraInfo(userExtraInfo);
		}
		
		else
		{
			userExtraInfo = new UserExtraInfo();
			userExtraInfo.setStr_gender(getStr_Gender());
			userExtraInfo.setDate_DateOfBirth(getDate_DateOfBirth());
			userExtraInfo.setStr_BloodGroup(str_BloodGroup);
			userExtraInfo.setInt_UserID(Util.getUserId());
			userExtraInfo.setStr_FaceBookId(str_FacebookId);
			userExtraInfo.setStr_Hobbies(str_Hobbies);
			// userExtraInfo.setStr_IntrestedIn(str_IntrestedIn);

			userExtraInfo.setStr_LinkedInId(str_LinkedInId);
			userExtraInfo.setStr_MaritalStatus(str_MaritalStatus);
			userExtraInfo.setStr_PersonalBlog(str_PersonalBlog);
			userExtraInfo.setStr_TwitterId(str_TwitterId);
			userExtraInfo.setStr_Profession(str_Proffession);
			user.setUserExtraInfo(userExtraInfo);
			
		}
		user.setUserExtraInfo(userExtraInfo);
 
		user.setStr_Email(str_EmailId);
		user.setStr_FirstName(str_FirstName);
		user.setStr_LastName(str_LastName);
		user.setStr_PhoneNo(str_Mobile);
		 
		user.setStr_Flat(str_Flat);
		System.out.println(str_Country + "counttttttttttttttttttttttry");
		user.setStr_Country(str_Country);
		user.setStr_City(str_City);
		user.setStr_Block(str_Block);
		user.setStr_State(str_State);
		 
		user.setStr_Apartment(str_ApartmentName);
		 

		user.setVar_FileName1(getPath2());
		user.setVar_ImageName1(getPath());
		getUserService().updateUs(user);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO, "  Successfully Updated!",
				"Successfully Updated!"));

		return "editprofile.xhtml";
	}

	public void facebookuserLogin() {

	}

	public void linkedinuserLogin() {

	}

	@ManagedProperty(value = "#{ApartmentDetailsService}")
	private ApartmentDetailsService apartmentDetailsService;

	public ApartmentDetailsService getApartmentDetailsService() {
		return apartmentDetailsService;
	}

	public void setApartmentDetailsService(
			ApartmentDetailsService apartmentDetailsService) {
		this.apartmentDetailsService = apartmentDetailsService;
	}

	public List<String> getHouseNoList() {
		houseNoList = new ArrayList<String>();
		houseNoList.addAll(getApartmentDetailsService().getHouseNoList(
				getStr_Block()));

		return houseNoList;
	}

	public void setHouseNoList(List<String> houseNoList) {
		this.houseNoList = houseNoList;
	}

	private List<String> houseNoList;
	private Integer int_ExtraUserId;

	public Integer getInt_ExtraUserId() {
		return int_ExtraUserId;
	}

	public void setInt_ExtraUserId(Integer int_ExtraUserId) {
		this.int_ExtraUserId = int_ExtraUserId;
	}

	public void getUserExtraInfo() {
		System.out.println(Util.getUserId() + "uid1");
		userExtraInfo = getUserService().getUserExtraInfo(Util.getUserId());
		User u = new User();
		u = getUserService().getFbUser(Util.getUserId());
		System.out.println(u + "user");
		if (userExtraInfo != null && u != null) {
			str_FirstName = u.getStr_FirstName();
			str_LastName = u.getStr_LastName();
			str_Country = u.getStr_Country();
			System.out.println(str_Country + "cccouuunnnttrrryyy");
			formuserloginuserpassword = u.getStr_Password();
			str_State = u.getStr_State();
			str_City = u.getStr_City();
			str_Flat = u.getStr_Flat();
			str_Block = u.getStr_Block();
			str_EmailId = u.getStr_Email();
			str_Mobile = u.getStr_PhoneNo();
			str_Gender = userExtraInfo.getStr_gender();
			date_DateOfBirth = userExtraInfo.getDate_DateOfBirth();
			str_BloodGroup = userExtraInfo.getStr_BloodGroup();
			str_MaritalStatus = userExtraInfo.getStr_MaritalStatus();
			str_Hobbies = userExtraInfo.getStr_Hobbies();
			str_Proffession = userExtraInfo.getStr_Profession();
			// str_IntrestedIn=userExtraInfo.getStr_IntrestedIn();
			str_FacebookId = userExtraInfo.getStr_FaceBookId();
			str_LinkedInId = userExtraInfo.getStr_IntrestedIn();
			str_TwitterId = userExtraInfo.getStr_TwitterId();
			str_PersonalBlog = userExtraInfo.getStr_PersonalBlog();
			int_ExtraUserId = userExtraInfo.getInt_UserExtraID();

		}

	}

	public List<String> getStr_IntrestedIn() {
		return str_IntrestedIn;
	}

	public void setStr_IntrestedIn(List<String> str_IntrestedIn) {
		this.str_IntrestedIn = str_IntrestedIn;
	}

	public void setUserExtraInfo(UserExtraInfo userExtraInfo) {
		this.userExtraInfo = userExtraInfo;
	}

	// file Upload

	private Part part;
	private String statusMessage;
	private String path;

	public String uploadFile() throws IOException {

		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = fmt.format(new Date())
				+ getFileName(part).substring(
						getFileName(part).lastIndexOf('.'));
		// Extract file name from content-disposition header of file part
		// String fileName = getFileName(part);
		System.out.println("***** fileName: " + fileName);
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

		// String basePath = "D:" + File.separator + "temp" + File.separator;
		// File outputFilePath = new File(basePath + fileName);
		String basePath =servletContext.getRealPath("")
				+ File.separator + "images" + File.separator
				+ Util.getAppartmentName() + File.separator;
		System.out.println(basePath);
		File outputFilePath = new File(basePath);
		 if (!outputFilePath.exists()) {
			   	if (outputFilePath.mkdir()) {
			   		System.out.println("Directory is created!");
			   	} else {
			   		System.out.println("Failed to create directory!");
			   	}
		 }
		 outputFilePath = new File(basePath, fileName);
		System.out.println(path + "path");
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
			path = "/images" + File.separator + Util.getAppartmentName()
					+ File.separator + fileName;
			user.setVar_ImageName1(path);
			user.setInt_UserId(user.getInt_UserId());
			getApartmentDetailsService().updateProfilePic(user);
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
		return null; // return to same page
	}

	 
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

	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext().getSession(false);

	public String getPath() {
		System.out.println(path + "path1");
		path = (String) session.getAttribute("str_ImageName1");
		if (user.getVar_ImageName1() != null)

			path = user.getVar_ImageName1();
		  
		else
			path = "/images/profilepic.png";
		 
			
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static String getStr_firstName() {
		return str_firstName;
	}

	public static void setStr_firstName(String str_firstName) {
		LoginBean.str_firstName = str_firstName;
	}
}
