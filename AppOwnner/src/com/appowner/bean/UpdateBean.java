package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.Complain;
import com.appowner.service.ComplainService;

@ManagedBean
@SessionScoped
public class UpdateBean implements Serializable {
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
	private Complain cmp;
	 public Complain getCmp() {
		return cmp;
	}
	public void setCmp(Complain cmp) {
		this.cmp = cmp;
	}
	
	private Integer int_ComplainID;
	
	 

	
	public Integer getInt_ComplainID() {
		return int_ComplainID;
	}
	public void setInt_ComplainID(Integer int_ComplainID) {
		this.int_ComplainID = int_ComplainID;
	}
	public void getComplain()
	{
	cmp=getComplainService().getComplain(int_ComplainID);
		
	}
	
	
	public String saveUser( ) {
		 
		//System.out.println(emp.getEmpId());
		
			getComplainService().update(cmp);
			
		
		
		
		return "ComplainView.xhtml";
	}
	
	
	
	private Integer int_CompanyID;
	public Integer getInt_CompanyID() {
		return int_CompanyID;
	}
	public void setInt_CompanyID(Integer int_CompanyID) {
		this.int_CompanyID = int_CompanyID;
	}
	private Company cmp1;
	public Company getCmp1() {
		return cmp1;
	}
	public void setCmp1(Company cmp1) {
		this.cmp1 = cmp1;
	}
	public void getCompany()
	{
	cmp1=getComplainService().getCompany(int_CompanyID);
		
	}
	
	
	public String saveCompany( ) {
		 
		//System.out.println(emp.getEmpId());
		
			getComplainService().update(cmp1);
			
		
		
		
		return "companysuccess.xhtml";
	}
	 private  List<CompanyPerson> listCompanyPerson1;
	 public  List<CompanyPerson> getListCompanyPerson1() {
		 listCompanyPerson1= new ArrayList<CompanyPerson>();
		 listCompanyPerson1.addAll(getComplainService().getCompanyPerson(int_CompanyID));
			return listCompanyPerson1;
			 
	}
	public  void setListCompanyPerson1(List<CompanyPerson> listCompanyPerson1) {
		this.listCompanyPerson1 = listCompanyPerson1;
	}
	 public CompanyPerson getCmpp() {
		return cmpp;
	}
	public void setCmpp(CompanyPerson cmpp) {
		this.cmpp = cmpp;
	}
	private CompanyPerson cmpp;

	
	
	
	private Integer int_CompanyPersonID;
	public Integer getInt_CompanyPersonID() {
		return int_CompanyPersonID;
	}
	public void setInt_CompanyPersonID(Integer int_CompanyPersonID) {
		this.int_CompanyPersonID = int_CompanyPersonID;
	}
	
	public void getCompanyPerson1()
	
	{	
		 cmpp=getComplainService().getCompanyPerson1(int_CompanyPersonID);
		
	}
	
	
	public String saveCompanyPerson( ) {
		 
		//System.out.println(emp.getEmpId());
		
			getComplainService().update(cmpp);
			
		
		
		
		return "person1.xhtml";
	}
	
}

