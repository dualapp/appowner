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
	      public static String getEmailId()
		     {
		    	 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		    	  return   (String) session.getAttribute("str_EmailId").toString(); 
		     }
	 
	      public static String getUserName()
	      {
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return  session.getAttribute("username").toString();
	      }
	      public static String getAppartmentName()
	      {
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return  session.getAttribute("ApartmentName").toString();
	      }
	      public static String getStr_Country()
	      {
	    	  
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return  session.getAttribute("str_Country").toString();
	      }
	      public static String getStr_State()
	      {
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return  session.getAttribute("str_State").toString();
	      }
	      public static String getStr_City()
	      {
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return  session.getAttribute("str_City").toString();
	      }
	      public static String getStr_Apartment()
	      {
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return  session.getAttribute("str_Apartment").toString();
	      }
	     
	     public static Integer getAppartmentId()
	      {
	    	  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	    	  return   (Integer) session.getAttribute("int_ApartmentId");
	      }
	     public static String getBlock()
	      {
	    	  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	    	  return   (String) session.getAttribute("str_Block").toString();
	      }
	     public static String getFlatNo()
	      {
	    	  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	    	  return   (String) session.getAttribute("str_Flat").toString();
	      }
	     
	      public static Integer getUserId()
	      {
	    	  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	         
	            return (Integer) session.getAttribute("int_UserId");
	         
	      }

	      public static String getEmail(){
	    	   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		        return  session.getAttribute("str_EmailId").toString();   
	       }


		public static int getInt_UserRole() {
			// TODO Auto-generated method stub
			 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			return (int) session.getAttribute("str_UserType");
		}


		public static String getStr_PhoneNo() {
			 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return  (String) session.getAttribute("str_Mobile").toString();
		}


		public static String getStr_Flat() {
			 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		        return  (String) session.getAttribute("str_Flat").toString();

		} 
		public static String getGender() {
			 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		        return    (String) session.getAttribute("gender");

		}


		public static String getStr_FirstName() {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return    (String) session.getAttribute("firstName");
		} 
		public static String getStr_LastName() {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        return    (String) session.getAttribute("lastName");
		} 
}
