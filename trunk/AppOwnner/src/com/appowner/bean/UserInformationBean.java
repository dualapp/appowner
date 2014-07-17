package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.service.AdminService;

@ManagedBean
@ViewScoped
public class UserInformationBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{AdminService}")
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String validate (String name1,String Password)  
	{	user=getAdminService().validate(name1,Password);
	          if(user==null)
	        	{  
	        		FacesContext facesContext = FacesContext.getCurrentInstance();
		    	   facesContext.addMessage(null, new FacesMessage("invalid user name or password!!!!!"));
		    	       return "SuperAdmin.xhtml";  
		       
	        	}
	   else    
	   { 
		   FacesContext facesContext = FacesContext.getCurrentInstance();
           facesContext.addMessage(null, new FacesMessage("Login Successful!!!!!!!!!!!"));
           return "ApartmentView.xhtml";
	   }
	      
}
	 private List<UserApartment> listApartment;
	   	public List<UserApartment> getListApartment() {
	   		listApartment=new ArrayList<UserApartment>();
	   		listApartment.addAll(getAdminService().listApartment());
	   		ListIterator list=listApartment.listIterator();
	   		while(list.hasNext())
	   		{   Object o=list.next();
	   			UserApartment name = (UserApartment)o;
	   			String name1=name.getStr_ApartmentName();
	   			System.out.println(name1);
	   			Long count=(Long)getAdminService().count(name1);
	   			System.out.println(count);
	   			name.setInt_NoOfUser(count);
	   			
	   		}
			return listApartment;
	   		
	   	}
	   	public void setListApartment(List<UserApartment> listApartment) {
	   		this.listApartment = listApartment;
	   	} 
	   	
		private List<User> userlist;
		
	   	
		
		public List<User> getUserlist() {
			userlist=new ArrayList<User>();
			userlist.addAll(getAdminService().getUserlist(str_ApartmentName));
			System.out.println(userlist);
			return userlist;
		}
		public void setUserlist(List<User> userlist) {
			this.userlist = userlist;
		}
		private String str_ApartmentName;
		public String getStr_ApartmentName() {
			return str_ApartmentName;
		}
		public void setStr_ApartmentName(String str_ApartmentName) {
			this.str_ApartmentName = str_ApartmentName;
		}
		
}
