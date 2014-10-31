package com.appowner.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped

public class NavigationBean implements Serializable{

	private String pageName="/AfrteLoginViews/Accounting/accountstransaction.xhtml";
	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public void navigateTo() 
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
	     String target = ctx.getCurrentInstance().getExternalContext().getRequestParameterMap().get("navParam");
	     System.out.println(target);
	     setPageName(target);
	}
}
