package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.CommiteeRole;
import com.appowner.model.Staff;
import com.appowner.service.ComplainService;

@ManagedBean
@ViewScoped
public class CommiteeRoleBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ComplainService}")
	private ComplainService complainService;
	public ComplainService getComplainService() {
		return complainService;
	}
	public void setComplainService(ComplainService complainService) {
		this.complainService = complainService;
	}
	private Integer int_Commitee_RoleID;
	public Integer getInt_Commitee_RoleID() {
		return int_Commitee_RoleID;
	}
	public void setInt_Commitee_RoleID(Integer int_Commitee_RoleID) {
		this.int_Commitee_RoleID = int_Commitee_RoleID;
	}
	public String getStr_Commitee_RoleName() {
		return str_Commitee_RoleName;
	}
	public void setStr_Commitee_RoleName(String str_Commitee_RoleName) {
		this.str_Commitee_RoleName = str_Commitee_RoleName;
	}
	public String getCh_Commitee_Type() {
		return ch_Commitee_Type;
	}
	public void setCh_Commitee_Type(String ch_Commitee_Type) {
		this.ch_Commitee_Type = ch_Commitee_Type;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
		
	}
	private String str_Commitee_RoleName;
	private String ch_Commitee_Type;
	private Integer isActive;
	private Integer isDelete;
	private Integer int_ApartmentID;
    private List<CommiteeRole> ListCommiteeRoles;
	public List<CommiteeRole> getListCommiteeRoles() {
		ListCommiteeRoles=new ArrayList<CommiteeRole>();
		ListCommiteeRoles.addAll(getComplainService().listCommiteeRoles());
		return ListCommiteeRoles;
	}
	public void setListCommiteeRoles(List<CommiteeRole> listCommiteeRoles) {
		ListCommiteeRoles = listCommiteeRoles;
	}
private List<CommiteeRole> role; 
	
	
	
	public List<CommiteeRole> getRole() {
	return role;
}
public void setRole(List<CommiteeRole> role) {
	this.role = role;
}
	@PostConstruct
    public void init() {
	role=new ArrayList<CommiteeRole>();
	}
	public void add() {
		CommiteeRole role1=new CommiteeRole();
	    role.add(role1);
		 
	}
private List<Object> list=new ArrayList();
	
    public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public void rolechangeListener(ValueChangeEvent event) {

		
		list.add(event.getNewValue());
		
	}
private CommiteeRole role2=new CommiteeRole();;
	
	
	public CommiteeRole getRole2() {
	return role2;
}
public void setRole2(CommiteeRole role2) {
	this.role2 = role2;
}
	public String addRole()
    {  
        @SuppressWarnings("rawtypes")
		ListIterator itr=list.listIterator();
           
        while(itr.hasNext()){
        	Object o=itr.next();
        	  
        	str_Commitee_RoleName=(String)o;
        
        	role2.setStr_Commitee_RoleName(str_Commitee_RoleName);
        
        	getComplainService().addRole(role2);
        	
        }
        return "CommiteeRole.xhtml";
    }
}
