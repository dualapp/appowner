package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.service.In_UserService;
/*
 * Develope by Pankaj singh.
 * This class is for Adding new user and perform various operation...
 */
@ManagedBean
@ViewScoped
public class Cls_UserBean implements Serializable{
	//Varialble declaration
		private static final long serialVersionUID = 1L;
		private int int_UserId;
		private String str_FirstName;    
		private String str_LastName;    
		private String str_Email;    
		private String str_ConfirmEmail;    
		private String str_Password;    
		private String str_ConfirmPassword;    
		private int int_UserRole;    
		private String str_Flat;    
		private String str_Block;    
		private String str_PhoneNo;
		public int int_getappartmentid;
	    private static final String SUCCESS = "success";
	    private static final String ERROR   = "error";
	    private static String el="el";
	    private static String pd="pd";
	    private static String fn="fn";
	    private static String un="un";
	    private static String an="an";
	    private static String subject="subject";
	    private static String content="content";
	    private String str_Username;
	    /*
	     * Getter and setter of the abobve varialble
	     */
		public static String getUn() {
			return un;
		}
		public static void setUn(String un) {
			Cls_UserBean.un = un;
		}
		public String getStr_Username() {
			return str_Username;
		}
		public void setStr_Username(String str_Username) {
			this.str_Username = str_Username;
		}
		public static String getSubject() {
			return subject;
		}
		public static void setSubject(String subject) {
			Cls_UserBean.subject = subject;
		}
		public static String getContent() {
			return content;
		}
		public static void setContent(String content) {
			Cls_UserBean.content = content;
		}
		public static String getEl() {
			return el;
		}
		public static void setEl(String el) {
			Cls_UserBean.el = el;
		}
		

		public static String getPd() {
			return pd;
		}
		public static void setPd(String pd) {
			Cls_UserBean.pd = pd;
		}
/*
 * variable declaration for return statements..
 */

		public  String EmailForm;
	    private  String Registraion;
		 private String Registration;
		 private String country;
		 private String state;
		 private String city;
		 /* Here userapartment variable and its setter and getter is declare to get the apartment value from select one menu bean class*/
		 private String userapartment;
		public String getUserapartment() {
			String s4=getSelectonemenubean().getApartment();
			return s4;
		}
		public void setUserapartment(String userapartment) {
			this.userapartment = userapartment;
		}
		public String getCity() {
			String s3=getSelectonemenubean().getCity();
			return s3;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			String s2=getSelectonemenubean().getState();
			return s2;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			String s1=getSelectonemenubean().getCount1();
			//System.out.println(s1);
			return s1;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public int getInt_UserId() {
			return int_UserId;
		}
		public void setInt_UserId(int int_UserId) {
			this.int_UserId = int_UserId;
		}
		public String getStr_FirstName() {
			return str_FirstName;
		}
		public void setStr_FirstName(String str_FirstName) {
			this.str_FirstName = str_FirstName;
		}
		public String getStr_LastName() {
			return str_LastName;
		}
		public void setStr_LastName(String str_LastName) {
			this.str_LastName = str_LastName;
		}
		public String getStr_Email() {
			return str_Email;
		}
		public void setStr_Email(String str_Email) {
			this.str_Email = str_Email;
		}
		public String getStr_ConfirmEmail() {
			return str_ConfirmEmail;
		}
		public void setStr_ConfirmEmail(String str_ConfirmEmail) {
			this.str_ConfirmEmail = str_ConfirmEmail;
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
		public int getInt_UserRole() {
			return int_UserRole;
		}
		public void setInt_UserRole(int int_UserRole) {
			this.int_UserRole = int_UserRole;
		}
		public String getStr_Flat() {
			return str_Flat;
		}
		public void setStr_Flat(String str_Flat) {
			this.str_Flat = str_Flat;
		}
		public String getStr_Block() {
			return str_Block;
		}
		public void setStr_Block(String str_Block) {
			this.str_Block = str_Block;
		}
		public String getStr_PhoneNo() {
			return str_PhoneNo;
		}
		public void setStr_PhoneNo(String str_PhoneNo) {
			this.str_PhoneNo = str_PhoneNo;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public static String getSuccess() {
			return SUCCESS;
		}
		public static String getError() {
			return ERROR;
		}
		/*
		 * here binding cls_UserServie and vendorBean and selectonemenu object with annotaions to access their getter and setter..
		 */
		@ManagedProperty(value = "#{cls_UserService}")
		private In_UserService userService;
		public In_UserService getUserService() {
			return userService;
		}
		public void setUserService(In_UserService userService) {
			this.userService = userService;
		}
		@ManagedProperty(value = "#{cls_UserBeanMain}")
		private Cls_UserBeanMain cls_UserBeanMain;
		public Cls_UserBeanMain getCls_UserBeanMain() {
			return cls_UserBeanMain;
		}
		public void setCls_UserBeanMain(Cls_UserBeanMain cls_UserBeanMain) {
			this.cls_UserBeanMain = cls_UserBeanMain;
		}

		@ManagedProperty(value = "#{selectOneMenuBean}")
		private SelectOneMenuBean selectonemenubean;
		
		public SelectOneMenuBean getSelectonemenubean() {
			return selectonemenubean;
		}
		public void setSelectonemenubean(SelectOneMenuBean selectonemenubean) {
			this.selectonemenubean = selectonemenubean;
		}
		public String userDetails()
		{
			
			
			return Registraion;
		}
		
		/*
		 * addUser method is define here to adding new user...
		 */
		public String addUser()
		{  
	
			try{
			
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			User usr=new User();
			String str=getStr_Password();
			String str1=getStr_ConfirmPassword();
			System.out.println(str);
			System.out.println(str1);
			
			if (str_Password.equals(str_ConfirmPassword)&&str_Email.equals(str_ConfirmEmail))
			{ 
				//System.out.println(password);
				System.out.println("***********33333333333333333333333@@@@@@@@@@@@@@@@@@@2*********************************************");
			usr.setStr_Country(getCountry());
			usr.setStr_State(getState());
			usr.setStr_City(getCity());
			usr.setStr_Apartment(getUserapartment());
			int_getappartmentid=getUserService().getAppartmenId(getUserapartment());
			usr.setInt_ApartmentId(int_getappartmentid);
			usr.setInt_UserId(getInt_UserId());
			usr.setStr_FirstName(getStr_FirstName());
			usr.setStr_LastName(getStr_LastName());
			usr.setStr_Email(getStr_Email());
			usr.setStr_ConfirmEmail(getStr_ConfirmEmail());
			usr.setStr_Password(getStr_Password());
			usr.setStr_ConfirmPassword(getStr_ConfirmPassword());
	        usr.setInt_UserRole(getInt_UserRole());
	        usr.setStr_Flat(getStr_Flat());
			usr.setStr_Block(getStr_Block());
			usr.setStr_PhoneNo(getStr_PhoneNo());
			usr.setStr_Username(getStr_Username());
			System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppllllllllllllllllllllllllllllllll");
			getUserService().addUser(usr);
			 el=getStr_Email();
			 un=getStr_Username();
			pd=getStr_Password();
			fn=getStr_FirstName();
			an=getUserapartment();
			subject="AppOwner.com";
			content="Hello."+" "  +fn+
					   "\n Thank you for registering your Apartment Complex with AppOwner.\n"
						+ "You are registered as the moderator for "+","  +an+
					   "\n Please log in to www.AppOwner.com with the following credentials and get going!\n"
						+"UserName:  "+" "  +un+" "+"\n"
					   + "Password:  "+" "  +pd;
					
				
			List<String> list=new ArrayList<String>();
			list.add(el);
			list.add(pd);
			
			return "EmailForm.jsp";
			}
			else
			{
				
				if(str_Password.equals(str_ConfirmPassword))
				{
					System.out.println("hello");
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("email and confirm email should same"));
					return "Registration.xhtml";
				}
				if(str_Email.equals(str_ConfirmEmail))
				{ 
					
							FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("password  and confirm password should same"));
							return "Registration.xhtml";
				}
				//else(email.equals(confirmemail)&&password.equals(confirmpassword))
				//{ 
					
							FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("password,confirm password and email,confirm email should same"));
							return "Registration.xhtml";
				//}
										
				
			}
			 
		}
		catch(DataAccessException e)
		{e.printStackTrace();
			
		}
		return ERROR;
			
		}
		/*
		 * here getListUser method to get list of users...
		 */
		private List<User> ListUser;
		public List<User> getListUser() {
			ListUser= new ArrayList<User>();
				ListUser.addAll( getUserService().listUsers());
			
			return ListUser;
		}
		public void setListUser(List<User> listUser) {
			ListUser = listUser;
		}
		/*
		 * reset method is for reset the value of adding new user form page..
		 */
		public void reset() {
			this.setInt_UserId(0);
	        this.setStr_FirstName("");
	        this.setStr_LastName("");
	        this.setStr_Email("");
	        this.setStr_ConfirmEmail("");
	        this.setStr_Password("");
	        this.setStr_ConfirmPassword("");
	        this.setStr_Flat("");
	        this.setStr_Block("");
	        this.setStr_PhoneNo("");    
	    }
		/*
		 * deleteUser method is to delete user..
		 */
		public void deleteUser(int int_UserId)
		{
			//System.out.println(userid);
			User usr=new User();
			usr.setInt_UserId(int_UserId);
			getUserService().deleteUser(usr);
		}
		/*
		 * addApartment is to adding aparmtne.
		 */
		public String addApartment()
		{
			return "Addapprt.xhtml";
			
		}
		public void getDum()
		{
			
			
		}
		
	
		public String getRegistration() {
			System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			return "Registration.xhtml";
		}
		public void setRegistration(String registration) {
			Registration = registration;
		}
		

	}



