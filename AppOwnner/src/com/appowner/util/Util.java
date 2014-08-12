package com.appowner.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
	 public static HttpSession getSession() {
	        return (HttpSession)
	          FacesContext.
	          getCurrentInstance().
	          getExternalContext().
	          getSession(false);
	      }
	       
	      public static HttpServletRequest getRequest() {
	       return (HttpServletRequest) FacesContext.
	          getCurrentInstance().
	          getExternalContext().getRequest();
	      }
	 
	      public static String getUserName()
	      {
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return  session.getAttribute("username").toString();
	      }
	       public static String getApartmentName()
	       {
	    	   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		        return  session.getAttribute("str_Apartment").toString();  
	       }
	       public static String getEmail(){
	    	   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		        return  session.getAttribute("str_Email").toString();   
	       }
	      
	     public static Integer AppartmentId()
	      {
	    	  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	    	  return   (Integer) session.getAttribute("int_ApartmentId");
	      }
	      public static Integer getUserId()
	      {
	        HttpSession session = getSession();
	        if ( session != null )
	            return (Integer) session.getAttribute("int_UserId");
	        else
	            return null;
	      }

		 
		 

}
