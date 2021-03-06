package com.appowner.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
//package org.primefaces.showcase.view.ajax;




















import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
//import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.dao.DataAccessException;

import com.appowner.model.DueTransaction;
import com.appowner.model.HouseDetails;
import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserBlocks;
import com.appowner.model.VendorServiceDetails;
import com.appowner.service.ApartmentDetailsService;
import com.appowner.service.In_UserService;
import com.appowner.util.Util;
/*
 * Develope by kalpana .
 * This class is for Adding new user and perform
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
	    private String criticaNome;
	    public String value;
	    public String value1;
	    public String arrow;
	    private String lastname;
	    public Integer int_apartment_id;
	    private List<String> blocksNa;
	    private User editlis;
	    private int edituserid2;
	    @ManagedProperty(value="#{ApartmentDetailsService}")
		private ApartmentDetailsService apartmentDetailsService;
		public ApartmentDetailsService getApartmentDetailsService() {
			return apartmentDetailsService;
		}
		public void setApartmentDetailsService(
				ApartmentDetailsService apartmentDetailsService) {
			this.apartmentDetailsService = apartmentDetailsService;
		}
		public String getStr_HouseNo() {
			return str_HouseNo;
		}
		public void setStr_HouseNo(String str_HouseNo) {
			this.str_HouseNo = str_HouseNo;
		}
		public int getEdituserid2() {
			return edituserid2;
		}
		public void setEdituserid2(int edituserid2) {
			this.edituserid2 = edituserid2;
		}
		public User getEditlis() {
			return editlis;
		}
		public void setEditlis(User editlis) {
			this.editlis = editlis;
		}
		@SuppressWarnings("unchecked")
		public List<String> getBlocksNa() {
			blocksNa=(List<String>) getUserService().blocks(Util.getAppartmentId());
			return blocksNa;
		}
		public void setBlocksNa(List<String> blocksNa) {
			this.blocksNa = blocksNa;
		}
		public int getInt_getappartmentid() {
			int_apartment_id=Util.getAppartmentId();
			return int_getappartmentid;
		}
		public void setInt_getappartmentid(int int_getappartmentid) {
			this.int_getappartmentid = int_getappartmentid;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		
		public String getValue1() {
			return value1;
		}
		public void setValue1(String value1) {
			this.value1 = value1;
		}
		public String getValue() {
			System.out.println("99999999999999999eeee999888889999999999999999999999");
			//dataChange1();
			System.out.println();
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getCriticaNome() {
			return criticaNome;
		}
		public void setCriticaNome(String criticaNome) {
			this.criticaNome = criticaNome;
		}
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
		 private String str_Apartment;
		public String getStr_Apartment() {
			return str_Apartment;
		}
		public void setStr_Apartment(String str_Apartment) {
			this.str_Apartment = str_Apartment;
		}
		public String getUserapartment() {
			String s4=getSelectonemenubean().getApartment();
			System.out.println(s4+"fdjkfdjkdfjkfd");
			System.out.println(userapartment+"hjjkjk");
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
		private static String url;
		public static String getUrl() {
			return url;
		}
		public static void setUrl(String url) {
			Cls_UserBean.url = url;
		}
		public void roleChangeListener(ValueChangeEvent event)
		{
			if(event.getNewValue()!=null)
			{
			int_UserRole=(int) event.getNewValue();
			 System.out.println(getInt_UserRole()+"kkkkkkkkkkkkkkkk"+int_UserRole);
			 user=getUserService().isUserStaying(str_HouseNo,int_UserRole);
			 System.out.println(user+"uuuuuuuuuuuuuu");
			 if(user!=null)
			 {
				 render=true;
				 if(user.getInt_UserRole()==2)
				 {
					 user.setStr_UserRoleName("Owner");
				 }
				 else
					 user.setStr_UserRoleName("Tenant");
				 
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("This House Is Already Booked For: " +"" + user.getStr_UserRoleName()+":"+""+user.getStr_Username()));
			 }
		}
}
		public void houseNoChangeListener(ValueChangeEvent event)
		{
			str_HouseNo=(String) event.getNewValue();
		 
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
			if(userapartment==null)
			{
				System.out.println(str_Apartment+"fffkjjk");
				int id=getUserService().getCityId(getCity());
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaeeeeeeeeeeeeeeeeeeeeeyyyyyy");
				
				UserApartment ua=new UserApartment();
				ua.setStr_ApartmentName(str_Apartment);
				ua.setInt_NoOfFlates(132);
				ua.setInt_PinCode(565434);
				ua.setStr_Address(getCity());
				ua.setInt_CityId(id);
				ua.setInt_subscriptID(1);
				ua.setStatus(0);
				java.util.Date d=new java.util.Date();
				System.out.println(d+"dskdskdslkk");
				Calendar cal1 = Calendar.getInstance();


				cal1.add(Calendar.MONTH,6);
				d=cal1.getTime();
				System.out.println(d+"sdkk");
				ua.setDat_ExpireDate(d);
				
				getUserService().addApartment(ua);
				int_getappartmentid=getUserService().getAppartmenId(str_Apartment);
				usr.setStr_Apartment(str_Apartment);
				usr.setInt_ApartmentId(int_getappartmentid);
				usr.setStr_UserRoleName("admin");
				an=str_Apartment;
			}
			else
			{
			usr.setStr_Apartment(getUserapartment());
			int_getappartmentid=getUserService().getAppartmenId(getUserapartment());
			usr.setInt_ApartmentId(int_getappartmentid);
			usr.setStr_UserRoleName("user");
			an=getUserapartment();
			}
			
			usr.setInt_UserId(getInt_UserId());
			usr.setStr_FirstName(getStr_FirstName());
			usr.setStr_LastName(getStr_LastName());
			usr.setStr_Email(getStr_Email());
			//usr.setStr_ConfirmEmail(getStr_ConfirmEmail());
			usr.setStr_Password(getStr_Password());
			 
	        usr.setInt_UserRole(getInt_UserRole());
	        usr.setStr_Flat(getStr_Flat());
			usr.setStr_Block(getStr_Block());
			usr.setStr_PhoneNo(getStr_PhoneNo());
			usr.setStr_Username(getStr_Username());
			
			Integer activationbit2=0;
			System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeemmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmiiiiiiiiiiiiiiiiiiillllllll");
			final String uuid1 = UUID.randomUUID().toString().replaceAll("-", "");
			
			
			usr.setStr_activationkey(uuid1);
			usr.setInt_activationbit(0);
			System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppllllllllllllllllllllllllllllllll");
			getUserService().addUser(usr);
			 el=getStr_Email();
			 un=getStr_Username();
			pd=getStr_Password();
			fn=getStr_FirstName();
			
			Bn="admin";
			url="http://www.appowners.com/AppOwnner/activate.jsp?activationkey="+uuid1;
			System.out.println(url+"fdjjkjkfdjkdffdj");
			subject="AppOwner.com";
			content="gggggg";
					
				
			List<String> list=new ArrayList<String>();
			list.add(el);
			list.add(pd);
			
			
			
			
			
				
			
			
			return "EmailForm2.jsp";
			}
			else
			{
				
				if(str_Password.equals(str_ConfirmPassword))
				{
					System.out.println("hello");
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("email and confirm email should same"));
					return "NewRegistration.xhtml";
				}
				if(str_Email.equals(str_ConfirmEmail))
				{ 
					
							FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("password  and confirm password should same"));
							return "NewRegistration.xhtml";
				}
				//else(email.equals(confirmemail)&&password.equals(confirmpassword))
				//{ 
					
							FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("password,confirm password and email,confirm email should same"));
							return "NewRegistration.xhtml";
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
		public static String Bn;
		public static String getBn() {
			return Bn;
		}
		public static void setBn(String bn) {
			Bn = bn;
		}
		private Boolean show;
		public Boolean getShow() {
			return show;
		}
		public void setShow(Boolean show) {
			this.show = show;
		}
		public String addnewUser()
		{
			try{
				
				User usr=new User();
				String str=getStr_Password();
				String str1=getStr_ConfirmPassword();
				if (str_Password.equals(str_ConfirmPassword)&&str_Email.equals(str_ConfirmEmail))
				{ 
				usr.setStr_Apartment(Util.getAppartmentName());
				//int_getappartmentid=getUserService().getAppartmenId(getUserapartment());
				usr.setInt_ApartmentId(Util.getAppartmentId());
				usr.setInt_UserId(getInt_UserId());
				usr.setStr_FirstName(getStr_FirstName());
				usr.setStr_LastName(getStr_LastName());
				usr.setStr_Email(getStr_Email());
				//usr.setStr_ConfirmEmail(getStr_ConfirmEmail());
				usr.setStr_Password(getStr_Password());
				//usr.setStr_ConfirmPassword(getStr_ConfirmPassword());
		        usr.setInt_UserRole(getInt_UserRole());
		        usr.setStr_Flat(str_HouseNo);
				usr.setStr_Block(str_BlockName);
				usr.setStr_PhoneNo(getStr_PhoneNo());
				usr.setStr_Username(getStr_Username());
				usr.setVar_ImageName1("/images/profilepic.png");
				usr.setStr_UserRoleName("user");
				Integer activationbit2=0;
				 
				final String uuid1 = UUID.randomUUID().toString().replaceAll("-", "");
				
				//System.out.println(uuid);
				//String s= UUID.randomUUID().toString();
				//System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrraaaaaaaaaaaaaaaaaaaaaaaaaaaaaannnnnnnnnnnnnn");
				
				usr.setStr_activationkey(uuid1);
				usr.setInt_activationbit(0);
				 
				getUserService().addUser(usr);
			Long noOfUser=getApartmentDetailsService().getNoOfUsers(str_BlockName,str_HouseNo);
			System.out.println(noOfUser+"noOfUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
			getApartmentDetailsService().updateNoOfUsersForAHouse(str_BlockName,str_HouseNo,noOfUser);
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("User Added Successfully"));
				 show=true;
				 el=getStr_Email();
				 un=getStr_Username();
				pd=getStr_Password();
				fn=getStr_FirstName();
				an=Util.getAppartmentName();
				Bn="user";
				url="http://www.appowners.com//AppOwnner/activate.jsp?activationkey="+uuid1;
				System.out.println(url+"fdjjkjkfdjkdffdj");
				subject="AppOwner.com";
				content="gggggg";
						
					
				List<String> list=new ArrayList<String>();
				list.add(el);
				list.add(pd);
				
				return "EmailForm2.jsp";
				}
				else
				{
					
					if(str_Password.equals(str_ConfirmPassword))
					{
						System.out.println("hello");
						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("email and confirm email should same"));
						return "null";
					}
					if(str_Email.equals(str_ConfirmEmail))
					{ 
						
								FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("password  and confirm password should same"));
								return "null";
					}
					//else(email.equals(confirmemail)&&password.equals(confirmpassword))
					//{ 
						
								FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("password,confirm password and email,confirm email should same"));
								return "null";
					//}
											
					
				}
				 
			}
			catch(DataAccessException e)
			{e.printStackTrace();
				
			}
			return ERROR;
				
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
		public String deleteUser(Integer id)
		{
			//System.out.println(userid);
			System.out.println("jkgfgjggfh111111111111111111111111111");
			
			User u=new User();
			u=getApartmentDetailsService().getUser(id);
			String blockName=u.getStr_Block();
			String flatName=u.getStr_Flat();
			getUserService().deleteUser2(id);
			getUserService().deleteRole(id);
			Long noOfUser=getApartmentDetailsService().getNoOfUsers(blockName,flatName);
			System.out.println(noOfUser+"noOfUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
			getApartmentDetailsService().updateNoOfUsersForAHouse(blockName,flatName,noOfUser);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Deleted Successful", "Deleted Successful"));
			return "apartments_memberdetails.xhtml";
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
			if(indicator==true)
			{
			return "NewRegistration.xhtml";
			}
			else
				return "layout.xhtml";
		}
		public void setRegistration(String registration) {
			Registration = registration;
		}
		private User user;
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public void dataChange1()
		{
			user=getUserService().validate(getStr_Username());
	          if(user==null)
	        	{  
	        	  setValue(" ");
	        	}
	   else    
	   { 
		   setValue("This name is taken by someone try another.");
	   }
			
			
		}
		
		public void dataChange2()
		{  System.out.println("176788779999999999999999999999999999999999999");
			user=getUserService().validate1(getStr_Email());
	          if(user!=null)
	        	{  
	        	  setValue1(" Email id is already used give another email-id.");
	        	}
	          else    
	   	   { 
	   		   setValue1(" ");
	   	   }
	   
			
		}
		private List<User> ListUser1;
		
		
		public List<User> getListUser1() {
			ListUser1=new ArrayList<User>();
			System.out.println("////////////////ggg/////////////////////");
			System.out.println(Util.getAppartmentId());
			ListUser1.addAll(getUserService().userDetails(Util.getAppartmentId()));
		
			return ListUser1;
		}
		public void setListUser1(List<User> listUser1) {
			ListUser1 = listUser1;
		}
		private User template1;
		public User getTemplate1() {
			return template1;
		}
		public void setTemplate1(User template1) {
			this.template1 = template1;
		}
		
		private DataTable dataTable;
		public void processValueChange1(ValueChangeEvent event)  
		        throws AbortProcessingException 
		{    System.out.println("hi");
		     
			template1=(User)dataTable.getRowData();
			
		}
		
		public DataTable getDataTable() {
			return dataTable;
		}
		public void setDataTable(DataTable dataTable) {
			this.dataTable = dataTable;
		}
		public String returnStatement()
		{
			System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,");
			return "login.xhtml";
		}
		//for adding blocks by user
	    private String str_ServiceName;
	    
		public String getStr_ServiceName() {
			return str_ServiceName;
		}
		public void setStr_ServiceName(String str_ServiceName) {
			this.str_ServiceName = str_ServiceName;
		}

		private List<Object> list = new ArrayList<Object>();

		

		public List<Object> getList() {
			return list;
		}
		public void setList(List<Object> list) {
			this.list = list;
		}

		private String str_BlockName;
		
		public String getStr_BlockName() {
			return str_BlockName;
		}
		public void setStr_BlockName(String str_BlockName) {
			this.str_BlockName = str_BlockName;
		}

		private List<UserBlocks> userblock;
		@PostConstruct
	    public void init() {
			userblock=new ArrayList<UserBlocks>();
			 createLineModels();
		}

		public List<UserBlocks> getUserblock() {
			return userblock;
		}
		public void setUserblock(List<UserBlocks> userblock) {
			this.userblock = userblock;
		}
		public void addBloks() {
			UserBlocks v1=new UserBlocks();
			userblock.add(v1);
			 
		}
		@SuppressWarnings("unchecked")
		public void blockServiceDetailsListener(ValueChangeEvent event) {

			 
			list.add(event.getNewValue());
			 

		}
		public String addBlock()
		{
			UserBlocks us=new UserBlocks();
			ListIterator<Object> itr = list.listIterator();
		    while (itr.hasNext()) {
		    	
		   Object servicename = itr.next();
		   str_ServiceName = (String)servicename;
		   us.setStr_BlockName(getStr_ServiceName());
		   System.out.println("ooooooooooooooooooooooooooooooooo");
		   System.out.println(us.toString());
		   us.setInt_ApartmentId(Util.getAppartmentId());
		   getUserService().addBlock(us);
		    }
		   
		     
			return "BlockAddedConfirmation.xhtml";
		}
	public static Integer id;	
		public static Integer getId() {
		return id;
	}
	public static void setId(Integer id) {
		Cls_UserBean.id = id;
	}
		//@SuppressWarnings("unchecked")
		public void editUser()
		{
			
			System.out.println(int_UserId+"jjj");
		
			editlis=getUserService().edit(int_UserId);
			System.out.println("..............................................");
			//System.out.println(editlis.getStr_FirstName());
			edituserid2=editlis.getInt_UserId();
			str_BlockName=editlis.getStr_Block();
		//	return "userEdituser.xhtml";
		}
		public static String getFn() {
			return fn;
		}
		public static void setFn(String fn) {
			Cls_UserBean.fn = fn;
		}
		public static String getAn() {
			return an;
		}
		public static void setAn(String an) {
			Cls_UserBean.an = an;
		}
		public String updateUser(int usereditid)
		{
			
			System.out.println("fjghjfgjjkgjkfgj55555555555555555555555555");
			getUserService().updateUser(editlis);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Updated Successful", "Updated Successful"));
			return "apartments_memberdetails.xhtml";
			
		}
		private boolean indicator;
		
         
		public boolean isIndicator() {
			return indicator;
		}
		public void setIndicator(boolean indicator) {
			this.indicator = indicator;
		}
		public List<String> getBlockNameList() {
			blockNameList=new ArrayList<String>();
			
			blockNameList.addAll(getApartmentDetailsService().getBlockNameList(Util.getAppartmentId()));
			return blockNameList;
		}
		public void setBlockNameList(List<String> blockNameList) {
			this.blockNameList = blockNameList;
		}
		private Boolean render;
		public List<String> getHouseNoList() {
			houseNoList=new ArrayList<String>();
			System.out.println("1111155555555555551515151515511515");
			System.out.println(str_BlockName+"hjdfjhfdfdfdjfjf");
			houseNoList.addAll(getApartmentDetailsService().getHouseNoList(str_BlockName));
			
			 
			return houseNoList;
		}
		public void setHouseNoList(List<String> houseNoList) {
			this.houseNoList = houseNoList;
		}
		
		private String str_HouseNo;
		private List<String> houseNoList;
		private List<String> blockNameByApartmentName;
		private List<String> blockNameList;
		private String str_UserApartment;
		public String getStr_UserApartment() {
			return str_UserApartment;
		}
		public void setStr_UserApartment(String str_UserApartment) {
			this.str_UserApartment = str_UserApartment;
		}

		private User u;
		private User u1;
		public User getU1() {
			u1=new User();
			u1=getApartmentDetailsService().primaryOwnerDetailsByHouseNo(str_BlockName,str_HouseNo,1);
			return u1;
		}
		public void setU1(User u1) {
			this.u1 = u1;
		}

		private HouseDetails housedetails;
		private String userRole;
		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}
		public String getUserRole()
		{ 
			System.out.println(Util.getUserId()+"uid");
			int_UserRole=getUserService().getUserRole(Util.getUserId());
			if(int_UserRole==1)
				userRole="Tenant";
			 if(int_UserRole==2)
				 userRole="Owner";
				 
			return userRole ;
			
		}
		public HouseDetails getHousedetails() {
			System.out.println(str_HouseNo+"hno");
			System.out.println(str_BlockName+"blokkkkkkkkkkkkkkkkkkkk");
			housedetails=getApartmentDetailsService().getHouseDetailByHouseNo(str_HouseNo,str_BlockName);
			System.out.println(housedetails+"Hdetails");
			 
			return housedetails;
		}
		public void setHousedetails(HouseDetails housedetails) {
			this.housedetails = housedetails;
		}
		public User getU() {

			u=new User();
			System.out.println(str_BlockName+"blocknameeeeeeeeeeeeeeeeeeee");
			u=getApartmentDetailsService().primaryOwnerDetailsByHouseNo(str_BlockName,str_HouseNo,2);
			 
			return u;
		}
		public void setU(User u) {
			this.u = u;
		}
		public Boolean getRender()
		{ 
			 
			return render;
		}
		
		
		public List<String> getBlockNameByApartmentName() {
			System.out.println(str_UserApartment);
			str_UserApartment=getUserapartment();
			System.out.println(str_UserApartment+"fdkfdkj");
			 blockNameByApartmentName=new ArrayList<String>();
				blockNameByApartmentName.addAll(getApartmentDetailsService().getBlockNameByApartmentName(str_UserApartment));
			   System.out.println(blockNameByApartmentName+"blocks111111111111111111111111");
			return blockNameByApartmentName;
		}
		public void setBlockNameByApartmentName(
				List<String> blockNameByApartmentName) {
			this.blockNameByApartmentName = blockNameByApartmentName;
		}
	 
		 public void blockChangeListener(ValueChangeEvent event)
		    {
			 
			 str_BlockName=(String) event.getNewValue();
			
			  
		    	System.out.println(str_BlockName+"blockssssssssssssssssssssssssssssssssssssssssssssssss");
		    	
		    }
		 public User selectedUser;
		public User getSelectedUser() {
			return selectedUser;
		}
		public void setSelectedUser(User selectedUser) {
			this.selectedUser = selectedUser;
		}
		public String selectRole(int id)
		{   System.out.println("hjyhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		   System.out.println(id+"dfjkdfjkfkj");
			Cls_UserBean.id=id;
			System.out.println(Cls_UserBean.id+"fdfjfdjfd");
			return null;
			
		}
		private String indicator1;
		public String getIndicator1() {
			return indicator1;
		}
		public void setIndicator1(String indicator1) {
			this.indicator1 = indicator1;
		}
		public void validateCheckBox(FacesContext context, UIComponent component,Object o) {
			System.out.println("dfhfdhjfgv hufg vjhu");
			HtmlSelectBooleanCheckbox checkBox =(HtmlSelectBooleanCheckbox) component;
			
			
			if(checkBox.getSubmittedValue().equals(indicator)) {
				System.out.println("vfgfjkfkjgfkj");
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Plz Check Terms And Conditions"));
			
			
			}
	}
		 private LineChartModel lineModel;
		public LineChartModel getLineModel() {
			return lineModel;
		}
		public void setLineModel(LineChartModel lineModel) {
			this.lineModel = lineModel;
		}
		    
		  private void createLineModels() {
		        lineModel =  initLinearModel();
		        lineModel.setTitle("Linear Chart");
		       		       
		       
		            
		        	lineModel.getAxes().put(AxisType.X, new CategoryAxis("UserName"));
		       
		        	
		       
		        Axis yAxis = lineModel.getAxis(AxisType.Y);
		       
		        yAxis.setMin(0);
		        yAxis.setMax(30);
		       
		      
		    }
		     
		   
			private LineChartModel initLinearModel() {
		    	LineChartModel model = new LineChartModel();
		 
		        LineChartSeries series1 = new LineChartSeries();
		        series1.setLabel("Series 1");
		        series1.set("Praveen", 10);
		      
		       
		        series1.set("Raju", 20);
		        series1.set("Ajay", 13);
		        series1.set("Amit", 25);
		        series1.set("Rasmi", 8);
		       
		        
		 
		        
		 
		        model.addSeries(series1);
		       
		         
		        return  model;
		    }
		     
			  
		   	

}

