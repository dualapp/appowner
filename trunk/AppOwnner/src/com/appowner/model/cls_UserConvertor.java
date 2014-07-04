package com.appowner.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.appowner.service.cls_UserService;

@ManagedBean
public class cls_UserConvertor implements Converter {

	@ManagedProperty(value = "#{UserService}")
	 
	 

	private cls_UserService UserService;
	 
	
	public cls_UserService getUserService() {
		return UserService;
	}

	public void setUserService(cls_UserService userService) {
		this.UserService = userService;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		int userId = Integer.parseInt(value);
		
		return UserService.getUser(userId);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Integer userId = ((cls_User) value).getUserId();
		
		return (userId != null) ? userId.toString() : null;
	}

}
