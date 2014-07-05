package com.appowner.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appowner.model.cls_Person;
import com.appowner.service.cls_PersonService;
@ManagedBean
@SessionScoped
public class cls_EnquiryUpdateBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{cls_PersonService}")
	private cls_PersonService personService;
	public cls_PersonService getPersonService() {
		
		return personService;
	}
	public void setPersonService(cls_PersonService personService) {
		this.personService = personService;
	}
	private cls_Person person;
	public cls_Person getperson() {
		return person;
	}
	public void setperson(cls_Person person) {
		this.person = person;
	}
	 
private int personId;
	
	public int getpersonId() {
	return personId;
}
public void setpersonId(int personId) {
	this.personId = personId;
}
	public void getPerson()
	{ person=new cls_Person();
		System.out.println(personId);
		person=getPersonService().getPerson(personId);
		}
	public String savePerson( ) {
		 
	
		if(person.getPersonId()!=null)
	
			getPersonService().update(person);
		else		
			getPersonService().addPerson(person);
		
		
		
		return "ViewEnquiry.xhtml?faces-redirect=true";
	}

}