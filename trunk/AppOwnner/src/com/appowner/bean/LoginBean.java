package com.appowner.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

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



 

	public String userLogin()
	{
		formuserloginusername=getUserloginname();
		formuserloginuserpassword=getUserloginpassword();
		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		System.out.println(formuserloginusername);
		System.out.println(formuserloginuserpassword);
		user=getUserService().getUserList(formuserloginusername);
		System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		System.out.println(user);
		System.out.println(user.getStr_Password());
		
		if(formuserloginuserpassword.equals(user.getStr_Password()))
		{   
		
			int_ApartmentId=user.getInt_ApartmentId();
			int_UserId=user.getInt_UserId();
			
			HttpSession session = Util.getSession();
            session.setAttribute("username", userloginname);
            session.setAttribute("int_ApartmentId", int_ApartmentId);
            session.setAttribute("int_UserId", int_UserId);
			System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
			System.out.println("hiiiiiiiiiiiii");
		 	String index="welcomepage.xhtml";
		  return index;
		}
		else
		{FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("User name or password id invalid!"));
		return "layout.xhtml?error=yes";
		}
	}
	public String logout() {
	      HttpSession session = Util.getSession();
	      session.invalidate();
	      return "layout.xhtml";
	   }
	public void facebookuserLogin()
	{
		
		
		
	}
	public void linkedinuserLogin()
	{
		
		
		
	}

}
