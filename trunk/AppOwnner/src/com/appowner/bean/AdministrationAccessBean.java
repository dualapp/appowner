package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.appowner.model.RoleAssignment;
import com.appowner.service.AdministrationAccessService;
import com.appowner.service.MaintainanceStaffService;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AdministrationAccessBean implements Serializable{
	
	
@ManagedProperty(value ="#{AdministrationAccessService}")

private AdministrationAccessService administrationAccessService;

public AdministrationAccessService getAdministrationAccessService() {
	return administrationAccessService;
}
@ManagedProperty(value="#{MaintainanceStaffService}")
private  MaintainanceStaffService maintainanceStaffService;
public void setAdministrationAccessService(
		AdministrationAccessService administrationAccessService) {
	this.administrationAccessService = administrationAccessService;
}
 private List<RoleAssignment> roleAssignmentList;
 private List<String> str_RoleMasters;

public List<String> getStr_RoleMasters() {
	str_RoleMasters=new ArrayList<String>();
	str_RoleMasters=getMaintainanceStaffService().getStr_Roles();
	return str_RoleMasters;
}


public void setStr_RoleMasters(List<String> str_RoleMasters) {
	this.str_RoleMasters = str_RoleMasters;
}


public List<RoleAssignment> getRoleAssignmentList() {
	roleAssignmentList=new ArrayList<RoleAssignment>();
	roleAssignmentList.addAll(getAdministrationAccessService().getRoleAssignmentList());
	return roleAssignmentList;
}
private List<String> user;
public List<String> getUser() {
	user=new ArrayList<String>();
	
	user.add("rajiv" );
	user.add("rahul" );
	
	return user;
}


public void setUser(List<String> user) {
	this.user = user;
}
private RoleManagementBean roleManagementBean ;
private List<String> str_Roles1;

public List<String> getStr_Roles1() {
	str_Roles1=new ArrayList<String>();
	 
	ListIterator itr=user.listIterator();
	while(itr.hasNext())
	{
		String username=(String) itr.next();
 	str_Roles1=getAdministrationAccessService().getStr_Roles(username);
	str_Roles1.addAll(str_Roles1);
	}
	
	System.out.println(str_Roles1);
	return str_Roles1;
}


public void setStr_Roles(List<String> str_Roles) {
	this.str_Roles1 = str_Roles1;
}

public MaintainanceStaffService getMaintainanceStaffService() {
	return maintainanceStaffService;
}


public void setMaintainanceStaffService(
		MaintainanceStaffService maintainanceStaffService) {
	this.maintainanceStaffService = maintainanceStaffService;
}


public void setRoleAssignmentList(List<RoleAssignment> roleAssignmentList) {
	this.roleAssignmentList = roleAssignmentList;
}

 private List<Integer> userIds;

public List<Integer> getUserIds() {
	userIds=new ArrayList<Integer>();
	userIds.addAll(getAdministrationAccessService().getUserIds());
	
	return userIds;
}

private List<String> userNames;
public List<String> getUserNames() {
	userNames=new ArrayList<String>();
	userIds=getUserIds();
	@SuppressWarnings("rawtypes")
	ListIterator itr=userIds.listIterator();
	while(itr.hasNext())
	{
		Integer id=(Integer) itr.next();
		String userName=getAdministrationAccessService().getUserName(id);
		userNames.add(userName);
	}
	
	return userNames;
}


public void setUserNames(List<String> userNames) {
	this.userNames = userNames;
}


public void setUserIds(List<Integer> userIds) {
	this.userIds = userIds;
}

}
