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
	private In_UserService userService;
	public In_UserService getUserService() {
		return userService;
	}
	public void setUserService(In_UserService userService) {
		this.userService = userService;
	}

    public String getFacebookUrlAuth() {
        HttpSession session =
        (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String sessionId = session.getId();
        String appId = "1525993687671325";
       // String redirectUrl = "http://localhost:7656/AppOwnner/AfrteLoginViews/Administrator/welcomepage.xhtml";
		String redirectUrl = "http://localhost:4444/AppOwnner/index.sec";
        String returnValue = "https://www.facebook.com/dialog/oauth?client_id="
                + appId + "&redirect_uri=" + redirectUrl
                + "&scope=email,user_birthday&state=" + sessionId;
        return returnValue;
    }
 
    public String getUserFromSession() {
		HttpSession session =
		(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String userName = (String) session.getAttribute("FACEBOOK_USER");
		String str_FirstName=(String) session.getAttribute("firstName");
		String str_lastName=(String) session.getAttribute("lastName");
		String str_Email=(String) session.getAttribute("email");
		String str_Username=str_Email;
		
		 
		
		if (userName!=null) {
			User usr=new User();
			Integer id=getUserService().getUserId(str_Username);
			if(id==null)
			{
			usr.setStr_FirstName(str_FirstName);
			usr.setStr_LastName(str_lastName);
			usr.setStr_Email(str_Email);
			usr.setStr_UserRoleName("Guest");
			usr.setStr_Username(str_Username);
			 getUserService().addUser(usr);
			}
			  
			 
			return "Hello " + userName;
		}
		else {
			return "";
		}
}
}