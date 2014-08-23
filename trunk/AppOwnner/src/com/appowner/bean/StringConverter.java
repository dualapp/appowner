package com.appowner.bean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter("com.appowner.bean.StringConverter")
public class StringConverter  implements Converter {
	@Override
	   public Object getAsObject(FacesContext facesContext, 
	      UIComponent component, String value) 
	   {
	     
	     return null;
	   }
   
	   @Override
	   public String getAsString(FacesContext facesContext,
	      UIComponent component, Object value) 
	   {
		   Character c= ((Character) value).charValue();
		   System.out.println(c);
		     if(c=='G')
		     {
		    	String str=c.toString();
		    	String str1=str.concat("eneric");
		    	return str1;
		     }
		     else
		     {String str3=c.toString();
		     String str4=str3.concat("ustom");
		     return str4;
		     }
	   }
	}

