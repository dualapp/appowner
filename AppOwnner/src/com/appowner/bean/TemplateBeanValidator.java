package com.appowner.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.component.selectcheckboxmenu.SelectCheckboxMenu;

@ManagedBean
@ViewScoped
	@FacesValidator("limitCheckboxMenuValidator")
	public class TemplateBeanValidator implements Validator {
       public TemplateBeanValidator()
       {
    	   
       }
	   
	   @SuppressWarnings("unchecked")
	@Override
	   public void validate(FacesContext context, UIComponent component,
	           Object value) throws ValidatorException { 
	      System.out.println("fjkgfkjggkjhgkjh");
	    
	     List<String> str=(List<String>)component.getAttributes().get("minLimit");
	     System.out.println(str+"dfjfjkffgk");
	  if(str==null)
	  {
		  FacesMessage msg
          = new FacesMessage();
         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ValidatorException(msg);
	  }
} 
}
