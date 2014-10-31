package com.appowner.bean;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BroadCastMessage {
	private String type="two";

    public String getType() {
    	System.out.println(type+"type");
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Boolean checkType(String type1) {
        Boolean tmp =getType().equalsIgnoreCase(type1);
        System.out.println("checkType: "+this.type+" == "+type+"?  ("+tmp+")");
        return tmp;
    }

}
