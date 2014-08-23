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
		    	System.out.println(str);
		    	String str1=str.concat("eneric");
		    	System.out.println(str1);
		    	return str1;
		     }
		     else
		     {String str3=c.toString();
		       System.out.println(str3);
		     String str4=str3.concat("ustom");
		     System.out.println(str4);
		     return str4;
		     }
	   }
	}

