package com.appowner.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appowner.model.cls_User;
import com.appowner.service.cls_UserService;
@ManagedBean
@SessionScoped
public class cls_EditBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{cls_UserService}")
	private cls_UserService userService;
	public cls_UserService getUserService() {
		
		return userService;
	}
	public void setUserService(cls_UserService userService) {
		this.userService = userService;
	}
	private cls_User user;
	public cls_User getuser() {
		return user;
	}
	public void setuser(cls_User user) {
		this.user = user;
	}
	 
private int userId;
	
	public int getuserId() {
	return userId;
}
public void setuserId(int userId) {
	this.userId = userId;
}
	public void getUser()
	{
		user=getUserService().getUser(userId);
		}
	public String saveUser( ) {
		 
	
		if(user.getUserId()!=null)
	
			getUserService().update(user);
		else
			
			getUserService().addUser(user);
		
		
		
		return "success.xhtml?faces-redirect=true";
	}

}