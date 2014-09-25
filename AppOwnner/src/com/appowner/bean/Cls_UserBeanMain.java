package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;









import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

//import org.primefaces.event.RateEvent;













import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserCity;
import com.appowner.model.UserCountry;
import com.appowner.model.UserState;
import com.appowner.service.In_UserService;
 
@ManagedBean
@ViewScoped
public class Cls_UserBeanMain implements Serializable {

	 private List<String> str_UserCities;
	 private List<String>  cityListByState;
	 private List<String> str_ApartmentListByState;
	 private String counter;
	 private String state;
	 private String city;
	 private String apartment;
	 private String str_userapartment;
	 private String str_apart;
	 private String str_Username;
	 public String str_UserCountry;
	 private static String el="el";
	    private static String pd="pd";
	    private static String fn="fn";
	    private static String un="un";
	    private static String an="an";
	    private static String subject="subject";
	    private static String content="content";
		private String str_getRoleNameUser;
		public String value;
	    public String value1;
	    private int aparmentid1;
	    private List<String> strBlocks;
	    public List<String> getStrBlocks() {
			return strBlocks;
		}
		public void setStrBlocks(List<String> strBlocks) {
			this.strBlocks = strBlocks;
		}
		public int getAparmentid1() {
			return aparmentid1;
		}
		public void setAparmentid1(int aparmentid1) {
			this.aparmentid1 = aparmentid1;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getValue1() {
			return value1;
		}
		public void setValue1(String value1) {
			this.value1 = value1;
		}
		public static String getEl() {
			return el;
		}
		public static void setEl(String el) {
			Cls_UserBeanMain.el = el;
		}
		public static String getPd() {
			return pd;
		}
		public static void setPd(String pd) {
			Cls_UserBeanMain.pd = pd;
		}
		public static String getFn() {
			return fn;
		}
		public static void setFn(String fn) {
			Cls_UserBeanMain.fn = fn;
		}
		public static String getUn() {
			return un;
		}
		public static void setUn(String un) {
			Cls_UserBeanMain.un = un;
		}
		public static String getAn() {
			return an;
		}
		public static void setAn(String an) {
			Cls_UserBeanMain.an = an;
		}
		public static String getSubject() {
			return subject;
		}
		public static void setSubject(String subject) {
			Cls_UserBeanMain.subject = subject;
		}
		public static String getContent() {
			return content;
		}
		public static void setContent(String content) {
			Cls_UserBeanMain.content = content;
		}
		public  String EmailForm;
	 
	 /*to get value  cityy name from select one menu bean*/
	 public String selectOneMenuBeanCityName;
	 
	public String getStr_Username() {
		return str_Username;
	}
	public void setStr_Username(String str_Username) {
		this.str_Username = str_Username;
	}
	public String getStr_userapartment() {
		return str_userapartment;
	}
	public void setStr_userapartment(String str_userapartment) {
		this.str_userapartment = str_userapartment;
	}
	public String getState() {
		return  getSelectonemenubean().getState();
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return getSelectonemenubean().getCity();
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getApartment() {
		return str_userapartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getCounter() {
		return getSelectonemenubean().getCount1();
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}
	public List<String> getStr_ApartmentListByState() {
		return str_ApartmentListByState;
	}
	public void setStr_ApartmentListByState(List<String> str_ApartmentListByState) {
		this.str_ApartmentListByState = str_ApartmentListByState;
	}
	public void setCityListByState(List<String> cityListByState) {
		this.cityListByState = cityListByState;
	}
	private List<String> str_UserCountries;
	 private List<String> str_UserStates;
	 private String str_UserState;
	 private String str_UserApartment;
	 private String str_ApartmentName;
	public String getStr_UserApartment() {
		return str_UserApartment;
	}
	public void setStr_UserApartment(String str_UserApartment) {
		this.str_UserApartment = str_UserApartment;
	}
	public String getStr_ApartmentName() {
		return str_ApartmentName;
	}
	public void setStr_ApartmentName(String str_ApartmentName) {
		this.str_ApartmentName = str_ApartmentName;
	}
	public String getStr_UserState() {
		return str_UserState;
	}
	public void setStr_UserState(String str_UserState) {
		this.str_UserState = str_UserState;
	}
	 private String str_UserCity;
	public String getStr_StateName() {
		return str_StateName;
	}
	public void setStr_StateName(String str_StateName) {
		this.str_StateName = str_StateName;
	}
	//private String CountryName;
	 private String  str_StateName;
	 private List<User> userList;
	public String getStr_UserCity() {
		return str_UserCity;
	}
	public void setStr_UserCity(String str_UserCity) {
		this.str_UserCity = str_UserCity;
	}
	public String getStr_UserCountry() {
		return str_UserCountry;
	}
	public void setStr_UserCountry(String str_UserCountry) {
		this.str_UserCountry = str_UserCountry;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 //private static final String vendorlist= "vendorlist";
	 
	
	// VendorState model class
	private UserState userState;
	  
	 
 public UserState getUserState() {
		return userState;
	}
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	

	public void setStr_UserStates(List<String> str_UserStates) {
		this.str_UserStates = str_UserStates;
	}
	// Vendor model class
	private User user;
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	// VendorCountry model class with getter and setter
	private UserCountry userCountry;
	public UserCountry getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(UserCountry userCountry) {
		this.userCountry = userCountry;
	}
// VendorCity model class with getter and setter
	private UserCity userCity;
	 public UserCity getUserCity() {
		return userCity;
	}
	
	public void setUserCity(UserCity userCity) {
		this.userCity = userCity;
	}
	 /**
     * This listener cleans up the State value if a new Country is selected.
     *
     * @param event a change event when the value of the country changes.
     */
	
	public void countryChangeListener(ValueChangeEvent event) {
	       if ((event.getNewValue() != str_UserCountry)) {
	            str_UserState = null;
	           // str_VendorCity = null;
	            
	        }
	       System.out.println("kalpanaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	        str_UserCountry=(String) event.getNewValue();
	        getSelectonemenubean().getCount1(str_UserCountry);
	        System.out.println(str_UserCountry);
	        
	        
	    }
	
	/**
     * This listener cleans up the city value if a new state is selected.
     *
     * @param event a change event when the value of the state changes.
	 * @return 
     */
    public List<String> stateChangeListener(ValueChangeEvent event) {
    	 if ((event.getNewValue() != str_UserState)) {
    		 str_UserCity = null;
    	 }
       System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
       System.out.println(event.getNewValue());
        str_StateName=(String) event.getNewValue();
       cityListByState=new ArrayList<String>();
       cityListByState.addAll( getUserService().cityList1(str_StateName));
       System.out.println( cityListByState);
       System.out.println("hi");
       getSelectonemenubean().getState(str_StateName);
       return cityListByState;
       }
    //this is  listener for apartment change
    @SuppressWarnings("unchecked")
	public void apartmentChangeListener(ValueChangeEvent event) {
	       
	        str_userapartment=(String) event.getNewValue();
	        aparmentid1=getUserService().apartmentidget( str_userapartment);
	        System.out.println(" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx11111111111xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	        System.out.println( aparmentid1);
	        strBlocks=(List<String>) getUserService().blocks(aparmentid1);
	        System.out.println("yyyyyyyyyyyyyyyyyyyyyygggggggggggggggggggyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
	        System.out.println( strBlocks);
	        getSelectonemenubean().getApartment(str_userapartment);
	        getSelectonemenubean().getBlocks(strBlocks);
	        
	    }
    public void blockChangeListener(ValueChangeEvent event)
    {
    	
    	System.out.println("blockssssssssssssssssssssssssssssssssssssssssssssssss");
    	
    }
    
    /**
     * Gets a {@code List of Country.
     *
     * @return a list of  Country 
      
     */
    
 public List<String> getStr_UserCountries() {
		str_UserCountries=new ArrayList<String>();
		str_UserCountries.addAll(getUserService().countryList());
		return str_UserCountries;
	}
	/**
     * Gets a {@code List of States based on the selected Country.
     *
     * @return a list of States based on selected Country, or an empty list if no
     * Country is selected.
     */
    public List<String> getStr_UserStates() {
   	 if(str_UserCountry!=null)
   		{
   		 str_UserStates=new ArrayList<String>();
   		 str_UserStates.addAll( getUserService().stateList());
   		return str_UserStates;
   	}
   	 else
   	   return new ArrayList<String>();
   	 
   	 }
    /**
     * Gets a {@code List of cities based on the selected state.
     *
     * @return a list of cities based on selected state, or an empty list if no
     * state is selected.
     */
	public List<String> getStr_UserCities() {
		if((str_UserState!=null)){
		 System.out.println(cityListByState);
		 System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		return cityListByState ;
		}
		else
			 return new ArrayList<String>();
	}
	
	public List<String>cityChangeListener(ValueChangeEvent event) {
		if ((event.getNewValue() != str_UserCity)) {
			str_UserApartment = null;
   	 }
	       System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhaafffffffffffffffaaaaaaaaaaaaaaaaaaaaaaaaaa");
	       System.out.println(event.getNewValue());
	       str_ApartmentName=(String) event.getNewValue();
	       str_apart=str_ApartmentName;
	       str_ApartmentListByState=new ArrayList<String>();
	       str_ApartmentListByState.addAll( getUserService().apatrmentList1(str_ApartmentName));
	       System.out.println( str_ApartmentListByState);
	       System.out.println("hi");
	       getSelectonemenubean().getCity(str_ApartmentName);
	       return str_ApartmentListByState;
	       }
	private List<String> str_UserApartments;
	
	 
	public List<String> getStr_UserApartments() {
		 System.out.println("lllllllllllllllllllllllllllllllllll");
		 
			return str_ApartmentListByState ;
		//return str_UserApartments;
	}
	public void setStr_UserApartments(List<String> str_UserApartments) {
		this.str_UserApartments = str_UserApartments;
	}
	public void setStr_UserCities(List<String> str_UserCities) {
		this.str_UserCities = str_UserCities;
	}	
	public void setStr_UserCountries(List<String> str_UserCountries) {
		this.str_UserCountries = str_UserCountries;
	}
	public User getUser() {
		return user;
	}
	/*adding class cls_userservice object
	 
	 */
	@ManagedProperty(value = "#{cls_UserService}")
	private In_UserService userService;
	public In_UserService getUserService() {
		return userService;
	}
	public void setUserService(In_UserService userService) {
		this.userService = userService;
	}
	
	/*adding class cls_userservice object
	 
	 */
	@ManagedProperty(value = "#{selectOneMenuBean}")
	private SelectOneMenuBean selectonemenubean;
	public SelectOneMenuBean getSelectonemenubean() {
		return selectonemenubean;
	}
	public void setSelectonemenubean(SelectOneMenuBean selectonemenubean) {
		this.selectonemenubean = selectonemenubean;
	}
	
	
	/* Code for adding apartment*/
	//private String str_ApartmentName;
	private int int_NoOfFlates;
	private String str_Address;
	//private String str_City;
	private int int_PinCode;
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
	private int int_getappartmentid;
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
	public int getInt_NoOfFlates() {
		return int_NoOfFlates;
	}
	public void setInt_NoOfFlates(int int_NoOfFlates) {
		this.int_NoOfFlates = int_NoOfFlates;
	}
	public String getStr_Address() {
		return str_Address;
	}
	public void setStr_Address(String str_Address) {
		this.str_Address = str_Address;
	}
	public int getInt_PinCode() {
		return int_PinCode;
	}
	public void setInt_PinCode(int int_PinCode) {
		this.int_PinCode = int_PinCode;
	}
	private double sqft;
	public double getSqft() {
		return sqft;
	}
	public void setSqft(double sqft) {
		this.sqft = sqft;
	}
	
	public String addApartment()
	{
		selectOneMenuBeanCityName=getSelectonemenubean().getCity();
		System.out.println("2222222222222222222222222222222222222222222222222222233");
		System.out.println(selectOneMenuBeanCityName);
		int id=getUserService().getCityId( selectOneMenuBeanCityName);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaeeeeeeeeeeeeeeeeeeeeeyyyyyy");
		System.out.println(str_apart);
		UserApartment ua=new UserApartment();
		ua.setStr_ApartmentName(getStr_ApartmentName());
		ua.setInt_NoOfFlates(getInt_NoOfFlates());
		ua.setStr_Address(getStr_Address());
		ua.setInt_PinCode(getInt_PinCode());
		ua.setInt_CityId(id);
		getUserService().addApartment(ua);
		int_getappartmentid=getUserService().getAppartmenId(getStr_ApartmentName());
		str_getRoleNameUser=getUserService().getRoleNameUser(24);
		System.out.println("~~~~F~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(str_getRoleNameUser);
		User usr=new User();
		usr.setStr_Country(getCounter());
		usr.setStr_State(getState());
		usr.setStr_Username(getStr_Username());
		usr.setStr_City(getCity());
		usr.setStr_Apartment(getStr_ApartmentName());
		usr.setInt_ApartmentId(int_getappartmentid);
		//usr.setInt_UserId(getInt_UserId());
		usr.setStr_FirstName(getStr_FirstName());
		usr.setStr_LastName(getStr_LastName());
		usr.setStr_Email(getStr_Email());
		System.out.println("llllllllllllllllllllllllllllllllpppppppppppppppppppp");
		System.out.println(getStr_Email());
		//usr.setStr_ConfirmEmail(getStr_ConfirmEmail());
		usr.setStr_Password(getStr_Password());
		//usr.setStr_ConfirmPassword(getStr_ConfirmPassword());
        usr.setInt_UserRole(getInt_UserRole());
        usr.setStr_Flat(getStr_Flat());
		usr.setStr_Block(getStr_Block());
		//user.setSqft(sqft);
		usr.setStr_PhoneNo(getStr_PhoneNo());
		usr.setStr_UserRoleName("admin");
		Integer activationbit1=0;
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeemmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmiiiiiiiiiiiiiiiiiiillllllll");
		final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		
		//System.out.println(uuid);
		//String s= UUID.randomUUID().toString();
		//System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrraaaaaaaaaaaaaaaaaaaaaaaaaaaaaannnnnnnnnnnnnn");
		//System.out.println(s);
		usr.setStr_activationkey(uuid);
		usr.setInt_activationbit(0);
		getUserService().addUser(usr);
		el=getStr_Email();
		un=getStr_Username();
		pd=getStr_Password();
		an=getStr_ApartmentName();
		fn=getStr_FirstName();
		String url="http://localhost:8088/AppOwnner/activate.jsp?activationkey="+uuid;
		subject="AppOwner.com";
		content="Hello."+" "  +fn+
			   "\n Thank you for registering your Apartment Complex with AppOwner.\n"
				+ "You are registered as the moderator for "+","  +an
			  
				+"UserName:  "+" "  +un+" "+"\n"
			   + "Password:  "+" "  +pd+
			    "\n Please Click here to Activate your Account "+" "+url ;
		
		return "EmailForm1.jsp";
		
	}
	//for user id and email validation
	
	public void dataChange1()
	{
		user=getUserService().validate(getStr_Username());
          if(user==null)
        	{  
        	  setValue("User name is available.");
        	}
   else    
   { 
	   setValue("This name is taken by someone try another.");
   }
		
		
	}
	
	public void dataChange2()
	{
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
}

	 
	     
	   
  
  


 

