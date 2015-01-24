package com.appowner.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.appowner.model.User;
import com.appowner.service.In_UserService;

@ManagedBean (name ="loginPageCode")
@SessionScoped
public class LoginPageCode implements Serializable {
    private static final long serialVersionUID = -1611162265998907599L;
    @ManagedProperty(value = "#{cls_UserService}")
	private static In_UserService userService;
	public static In_UserService getUserService() {
		return userService;
	}
	public String getStr_Password() {
		return str_Password;
	}
	public void setStr_Password(String str_Password) {
		this.str_Password = str_Password;
	}
	public String getStr_ConfirmPassword() {
		return str_ConfirmPassword;
	}
	public void setStr_ConfirmPassword(String str_ConfirmPassword) {
		this.str_ConfirmPassword = str_ConfirmPassword;
	}
	public void setUserService(In_UserService userService) {
		this.userService = userService;
	}
private  Integer id;
private String str_Password;
private String str_ConfirmPassword;
    public String getFacebookUrlAuth() {
        HttpSession session =
        (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String sessionId = session.getId();
         
        String appId = "1525993687671325";
        String redirectUrl = "http://www.AppOwners.com/index.sec";
        System.out.println(getUserService().getUserId((String) session.getAttribute(str_Username)+"kalpana"));
        String returnValue = "https://www.facebook.com/dialog/oauth?client_id="
                + appId + "&redirect_uri=" + redirectUrl
                + "&scope=email,user_birthday&state=" + sessionId;
        
       
		
        return returnValue;
        
    }
 public static User getUser(String userName)
 { 
	 User u=new User();
	u= getUserService().getUser(userName);
	return u;
	 
 }
    
    public Integer getId() {
    	id=getUserService().getUserId(getStr_Username());
    	if(id!=null)
    	{
    		User usr=new User();
    		usr=getUserService().getFbUser(id);
    		System.out.println(usr);
    		session.setAttribute("str_Flat",usr.getStr_Flat());
    		session.setAttribute("str_Block",usr.getStr_Block());
    		session.setAttribute("str_EmailId",usr.getStr_Email());
    		session.setAttribute("str_Mobile",usr.getStr_PhoneNo());
    		session.setAttribute("int_UserRole",usr.getInt_UserRole());
    		session.setAttribute("int_ApartmentId",usr.getInt_ApartmentId());
    		session.setAttribute("str_Apartment",usr.getStr_Apartment());
    		session.setAttribute("int_UserId", id);
    		session.setAttribute("str_Country", usr.getStr_Country());
    		session.setAttribute("str_State", usr.getStr_State());
    		session.setAttribute("str_UserRoleName", usr.getStr_UserRoleName());
    		session.setAttribute("str_City", usr.getStr_City());
    		session.setAttribute(str_Password, str_Password);
    		 
    		
    		
    		session.setAttribute("gender", getStr_Gender());
    		
    		
    		
    	}
		return id;
	}
   
	public void setId(Integer id) {
		this.id = id;
	}
	HttpSession session =
    		(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	private	String userName ;
    	private String str_FirstName;
    	private String str_lastName;
    	private String str_Email;
    	private	String str_Username;
    private String str_ImageName1;
    String str_Gender;
    public String getStr_Gender() {
    	str_Gender=(String) session.getAttribute("gender");
		return str_Gender;
	}
	public void setStr_Gender(String str_Gender) {
		this.str_Gender = str_Gender;
	}
	public String getStr_ImageName1() {
    	str_ImageName1=(String) session.getAttribute("str_ImageName1");
		return str_ImageName1;
	}
	public void setStr_ImageName1(String str_ImageName1) {
		this.str_ImageName1 = str_ImageName1;
	}
	public String getUserName() {
    	 userName=(String) session.getAttribute("FACEBOOK_USER");
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getStr_FirstName() {
			str_FirstName=(String) session.getAttribute("str_FirstName");
			return str_FirstName;
		}
		public void setStr_FirstName(String str_FirstName) {
			this.str_FirstName = str_FirstName;
		}
		public String getStr_lastName() {
			str_lastName=(String) session.getAttribute("str_LastName");
			return str_lastName;
		}
		public void setStr_lastName(String str_lastName) {
			this.str_lastName = str_lastName;
		}
		public String getStr_Email() {
			str_Email=(String) session.getAttribute("str_EmailId");
			return str_Email;
		}
		public void setStr_Email(String str_Email) {
			this.str_Email = str_Email;
		}
		public String getStr_Username() {
			str_Username=(String) session.getAttribute("str_EmailId");
			return str_Username;
		}
		public void setStr_Username(String str_Username) {
			this.str_Username = str_Username;
		}
	public String getUserFromSession() {
		
		
		
		
		if (userName!=null) {
			User usr=new User();
			
			if(getId()==null)
			{
			usr.setStr_FirstName(getStr_FirstName());
			usr.setStr_LastName(getStr_lastName());
			usr.setStr_Email(getStr_Email());
			usr.setStr_UserRoleName("Guest");
			usr.setStr_Username(getStr_Username());
			usr.setStr_Password(str_Password);
		 
			usr.setVar_ImageName1(str_ImageName1);
			usr.setInt_UserRole(1);
			usr.setStr_Apartment("kalpnavilla");
			usr.setInt_ApartmentId(25);
			usr.setStr_Block("WingA");
			usr.setStr_Flat("A");
			usr.setStr_City("kolkata");
			usr.setStr_Country("india");
			usr.setStr_State("Westbengal");
			usr.setStr_PhoneNo("0000000000");
			 getUserService().addUser(usr);
			 return "/AfrteLoginViews/welcomepage.xhtml";
			}
			else
			 
			return "/AfrteLoginViews/welcomepage.xhtml";
		}
		else {
			return "";
		}
}
}