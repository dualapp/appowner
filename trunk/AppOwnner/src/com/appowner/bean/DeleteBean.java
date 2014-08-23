package com.appowner.bean;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.Complain;
import com.appowner.service.ComplainService;

@ManagedBean
@SessionScoped
public class DeleteBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{ComplainService}")
	private ComplainService complainService;
	public ComplainService getComplainService() {
		//System.out.println(employeeService);
		return complainService;
	}
	public void setComplainService(ComplainService complainService) {
		this.complainService =complainService;
	}
	
	
	private Integer int_ComplainID;
	
	 

	
	public Integer getInt_ComplainID() {
		return int_ComplainID;
	}
	public void setInt_ComplainID(Integer int_ComplainID) {
		this.int_ComplainID = int_ComplainID;
	}
	public String deleteComplain(){
		Complain cmp=new Complain();
		System.out.println(int_ComplainID);
		cmp.setInt_ComplainID(int_ComplainID);
		getComplainService().deleteComplain(cmp);
		return "ComplianView.xhtml?faces-redirect=true";
	}
	public String cancelComplain() {
		return "ComplianView.xhtml?faces-redirect=true";
	}
	
	
	
}
