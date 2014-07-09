package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.AdministrationAccess;
import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;
import com.appowner.model.User;
import com.appowner.service.AdministrationAccessService;
import com.appowner.service.MaintainanceStaffService;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
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

private List<String> str_AssinedRoles;
private List<Integer> roleIds;
public List<String> getStr_AssinedRoles() {
	str_AssinedRoles =new ArrayList<String>();
	roleIds=new ArrayList<Integer>();
	System.out.println(int_UserId);
	roleIds.addAll(getAdministrationAccessService().getRoleNames(int_UserId));
	ListIterator itr=roleIds.listIterator();
	while(itr.hasNext())
	{
		Integer roleId=(Integer) itr.next();
		String roleName=getMaintainanceStaffService().getRoleNameFromRoleMaster(roleId);
		str_AssinedRoles.add(roleName);
	}
	return str_AssinedRoles;
}
public RoleManagement getRm() {
	return rm;
}
public void setRm(RoleManagement rm) {
	this.rm = rm;
}
public void setStr_AssinedRoles(List<String> str_AssinedRoles) {
	this.str_AssinedRoles = str_AssinedRoles;
}
public void setStr_RoleMasters(List<RoleManagement> str_RoleMasters) {
	this.str_RoleMasters = str_RoleMasters;
}
public MaintainanceStaffService getMaintainanceStaffService() {
	return maintainanceStaffService;
}


public void setMaintainanceStaffService(
		MaintainanceStaffService maintainanceStaffService) {
	this.maintainanceStaffService = maintainanceStaffService;
}

private Set<String> str_AdminNames;
public Set<String> getStr_AdminNames() {
	str_AdminNames=new TreeSet<String>();
	str_AdminNames.addAll(getStr_CommitteeMembers());
	str_AdminNames.addAll(getStr_MaintainanceStaffmembers());
	return str_AdminNames;
}

private List<String>  admins;
 

 

public List<String> getAdmins() {
	Iterator itr=getStr_AdminNames().iterator();
	admins=new ArrayList<String>();
	while(itr.hasNext())
	{
		String name=(String) itr.next();
		admins.add(name);
	}
	return admins;
}


public AdministrationAccess getAdministrationAccess() {
	return administrationAccess;
}


public void setAdministrationAccess(AdministrationAccess administrationAccess) {
	this.administrationAccess = administrationAccess;
}


public void setStr_AdminNames(List<String> str_AdminNames) {
	this.str_AdminNames = (Set<String>) str_AdminNames;
}
private List<String> str_CommitteeMembers;
private List<String> str_MaintainanceStaffmembers;
/*
 * get All Committee Members
 */
public List<String> getStr_CommitteeMembers() {
	str_CommitteeMembers=new ArrayList<String>();
	str_CommitteeMembers.addAll(getAdministrationAccessService().getAllCommitteeMembers());
	
	return str_CommitteeMembers;
}


public void setAdmins(List<String> admins) {
	admins = admins;
}


public void setStr_CommitteeMembers(List<String> str_CommitteeMembers) {
	this.str_CommitteeMembers = str_CommitteeMembers;
}
/*
 * get All Maintainance Members
 */

public List<String> getStr_MaintainanceStaffmembers() {
	str_MaintainanceStaffmembers=new ArrayList<String>();
	str_MaintainanceStaffmembers.addAll(getAdministrationAccessService().getAllMaintainanceMembers());
	return str_MaintainanceStaffmembers;
}


public void setStr_MaintainanceStaffmembers(
		List<String> str_MaintainanceStaffmembers) {
	this.str_MaintainanceStaffmembers = str_MaintainanceStaffmembers;
}
private List<User> users ;

private User user;
public List getUsers() {
	 //List user1=new ArrayList();
	Iterator itr1=getAdmins().iterator();
	users=new ArrayList<User>();
	while(itr1.hasNext())
	{
		String name=(String) itr1.next();
		Integer userid=getAdministrationAccessService().getUserId(name);
		user=new User();
		 user.setInt_UserId(userid);
		 user.setStr_Username(name);
		 users.add(user);
		 System.out.println("#############################");
		System.out.println( users);
		//return users;
	}
	//System.out.println( user1);
	return users;
}


 private AdministrationAccess administrationAccess;
 


public void setUsers(List<User> users) {
	users = users;
}
private List list1;
private List list;
private Integer int_UserId;
public Integer getInt_UserId() {
	return int_UserId;
}


public void setInt_UserId(Integer int_UserId) {
	this.int_UserId = int_UserId;
}


@SuppressWarnings("unchecked")
public void roleChangeListener(ValueChangeEvent event)
{  
	 list1=new ArrayList();
     list1.addAll((List<String>) event.getOldValue());
	ListIterator itr1=list1.listIterator();
	ListIterator itr2=getRoleIds().listIterator();
	while(itr1.hasNext()||itr2.hasNext())
	{
	String 	str_RoleName=(String) itr1.next();
	Integer roleid=(Integer) itr2.next();
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		//System.out.println(int_UserId);
	getAdministrationAccessService().deleteAssignedRoles(roleid,int_UserId);
	}
	System.out.println(list);
	
	 
	 //return "committeememberlist.xhtml";
list=new ArrayList();
	list.addAll((List<String>) event.getNewValue());
	 
	 
}
public List<Integer> getRoleIds() {
	return roleIds;
}
public void setRoleIds(List<Integer> roleIds) {
	this.roleIds = roleIds;
}
public List<Integer> getRoleId() {
	return roleId;
}
public void setRoleId(List<Integer> roleId) {
	this.roleId = roleId;
}
private String str_RoleName;
List<Integer> roleId;
public String  addRoleManagement()
{
	@SuppressWarnings("rawtypes")
	ListIterator itr1=list.listIterator();
	while(itr1.hasNext())
	{ 
		str_RoleName=(String) itr1.next();
		System.out.println(str_RoleName);
		administrationAccess=new AdministrationAccess();
		administrationAccess.setInt_RoleID(getMaintainanceStaffService().getRoleId(str_RoleName));
		administrationAccess.setInt_UserID(int_UserId);
		administrationAccess.setInt_AppartmentID(getMaintainanceStaffService().getApartmentId(int_UserId));
		roleId=new ArrayList<Integer>();
	    roleId.addAll(getMaintainanceStaffService().getRoleID(int_UserId));
		 ListIterator itr=roleId.listIterator();
		 while(itr.hasNext())
		 {
			 System.out.println(roleId);
				
			 Integer roleId1=(Integer) itr.next();
			String roleName= getMaintainanceStaffService().getRoleNameFromRoleMaster(roleId1);
			 if( roleName.equals(str_RoleName))
			 {
				System.out.println(roleName);
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( getStr_RoleName()+" is already Assigned  to u plz Choose another Role "));
			 return null;
			 }
			
			 System.out.println("k1111111111111111111111");
		   
	} getAdministrationAccessService().saveAdministrationAccess(administrationAccess);
		 }
 
	 return  null;
	
}
/*
 * get All RoleMasters Data
 */
private List<RoleManagement> str_RoleMasters;
private	RoleManagement rm;
public List<RoleManagement> getStr_RoleMasters() {
	str_RoleMasters=new ArrayList<RoleManagement>();
   rm=new RoleManagement();
	str_RoleMasters=getAdministrationAccessService().getRoleMaster();
	 
	
	return str_RoleMasters;
}


public List getList1() {
	return list1;
}


public void setList1(List list1) {
	this.list1 = list1;
}


public List getList() {
	return list;
}


public void setList(List list) {
	this.list = list;
}


public String getStr_RoleName() {
	return str_RoleName;
}


public void setStr_RoleName(String str_RoleName) {
	this.str_RoleName = str_RoleName;
}


public void setStr_AdminNames(Set<String> str_AdminNames) {
	this.str_AdminNames = str_AdminNames;
}
private List<AdministrationAccess> ListAdministrationAccess;

public List<AdministrationAccess> getListAdministrationAccess() {
	ListAdministrationAccess=new ArrayList<AdministrationAccess>();
	ListAdministrationAccess.addAll(getAdministrationAccessService().getListAdministrationAccess());
	
	return ListAdministrationAccess;
}

public void setListAdministrationAccess(
		List<AdministrationAccess> listAdministrationAccess) {
	ListAdministrationAccess = listAdministrationAccess;
} 

}
