package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;
import com.appowner.service.MaintainanceStaffService;

@ManagedBean
@ViewScoped
public class RoleManagementBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6855014349863115406L;
	@ManagedProperty(value="#{MaintainanceStaffService}")
	private  MaintainanceStaffService maintainanceStaffService;
     private String str_RoleName;
     private Integer int_RoleId;
     private Integer int_ApartmentId;
     private Integer int_UserId;
     private List<String> str_Roles;
	public MaintainanceStaffService getMaintainanceStaffService() {
		
		return maintainanceStaffService;
	}

	public String getStr_RoleName() {
		return str_RoleName;
	}

	public void setStr_RoleName(String str_RoleName) {
		this.str_RoleName = str_RoleName;
	}
private Boolean Selected=true;
	public Boolean getSelected() {
	return Selected;
}

public void setSelected(Boolean selected) {
	Selected = selected;
}
private List<RoleManagement> roleManagementList;
	public List<RoleManagement> getRoleManagementList() {
		roleManagementList= new ArrayList<RoleManagement>();
		roleManagementList.addAll( getMaintainanceStaffService().getRoleManagementList());
	return roleManagementList;
}

public void setRoleManagementList(List<RoleManagement> roleManagementList) {
	this.roleManagementList = roleManagementList;
}

	@SuppressWarnings("unchecked")
	public void deleteAssignedRolesListener(ValueChangeEvent event)
	{str_AssignedRoleName=new ArrayList<String>();
	System.out.println(str_AssignedRoleName);
		 str_AssignedRoleName.addAll((List<String>) event.getNewValue());
		 System.out.println("testttttttttttttttttttttttttttttttttttttt");
		// getMaintainanceStaffService().deleteAssignedRoles(str_AssignedRoleName);
		System.out.println(str_AssignedRoleName);
		@SuppressWarnings("rawtypes")
		ListIterator itr = str_AssignedRoleName.listIterator();
		/*while(itr.hasNext())
		{
			str_RoleName=(String) itr.next();
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
			System.out.println(str_RoleName);
		 getMaintainanceStaffService().deleteAssignedRoles(str_RoleName);
		}*/
		while(itr.hasNext())
		{
			String rm=(String) itr.next();
			RoleAssignment r=new RoleAssignment();
			 
			//getMaintainanceStaffService().deleteAssignedRoles(rm);
		}
	}
	public List<String> getStr_Roles() {
		str_Roles=new ArrayList<String>();
		str_Roles.addAll( getMaintainanceStaffService().getStr_Roles());
		return str_Roles;
	}

	public void setStr_Roles(List<String> str_Roles) {
		this.str_Roles = str_Roles;
	}
   private List<RoleAssignment> str_AssinedRoles;
	public List<RoleAssignment> getStr_AssinedRoles() {
		System.out.println(str_AssinedRoles);
	return str_AssinedRoles;
	}
public void setStr_AssinedRoles(List<RoleAssignment> str_AssinedRoles) {
	this.str_AssinedRoles = str_AssinedRoles;
}
private List<String> str_AssignedRoleName;
public Boolean roleSelected;
public Boolean getRoleSelected() {
	return roleSelected;
}

public void setRoleSelected(Boolean roleSelected) {
	this.roleSelected = roleSelected;
}
Integer roleid;
public  void getAssignedRoles()
{
	List<RoleAssignment> roleId =new ArrayList<RoleAssignment>();
	   roleId.addAll(getMaintainanceStaffService().getAssignedIds(int_UserId));
	   
	/*@SuppressWarnings("rawtypes")
	ListIterator itr = roleId.listIterator();
	while(itr.hasNext())
	{
		  roleid=(Integer) itr.next();	
		  System.out.println("ks");
		  System.out.println(roleid);
		  str_AssinedRoles =new ArrayList<RoleAssignment>(); 
			str_AssinedRoles.addAll(getMaintainanceStaffService().getRoleName(roleid)); 
			System.out.println();
			//return str_AssinedRoles;
			
}
 
	//System.out.println("sudha");
	//System.out.println(roleid);
	//return  str_AssinedRoles;
	*/
	str_AssinedRoles =new ArrayList<RoleAssignment>();
	System.out.println(int_UserId);
	str_AssinedRoles.addAll(getMaintainanceStaffService().getRoleNames(int_UserId));
	System.out.println(str_AssinedRoles);
	
	 }

	public Integer getRoleid() {
	return roleid;
}

public void setRoleid(Integer roleid) {
	this.roleid = roleid;
}

	public List<String> getStr_AssignedRoleName() {
	return str_AssignedRoleName;
}

public void setStr_AssignedRoleName(List<String> str_AssignedRoleName) {
	this.str_AssignedRoleName = str_AssignedRoleName;
}

	public void setMaintainanceStaffService(
			MaintainanceStaffService maintainanceStaffService) {
		this.maintainanceStaffService = maintainanceStaffService;
	}
	 
	List list=new ArrayList();

public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	List list1=new ArrayList();

public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

@SuppressWarnings("unchecked")
public void roleChangeListener(ValueChangeEvent event)
{  

 
	//str_AssignedRoleName=new ArrayList<String>();
	list1.addAll((List<String>) event.getOldValue());
	ListIterator itr1=list1.listIterator();
	while(itr1.hasNext())
	{
		str_RoleName=(String) itr1.next();
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		System.out.println(str_RoleName);
		System.out.println(int_UserId);
	 getMaintainanceStaffService().deleteAssignedRoles(str_RoleName,int_UserId);
	}
	System.out.println(list);
	
	 
	 //return "committeememberlist.xhtml";

	list.addAll((List<String>) event.getNewValue());
	 
	 
}
 
private RoleManagement roleManagement;
public Integer getInt_RoleId() {
	return int_RoleId;
}

public void setInt_RoleId(Integer int_RoleId) {
	this.int_RoleId = int_RoleId;
}

public Integer getInt_ApartmentId() {
	return int_ApartmentId;
}

public void setInt_ApartmentId(Integer int_ApartmentId) {
	this.int_ApartmentId = int_ApartmentId;
}

public Integer getInt_UserId() {
	return int_UserId;
}

public void setInt_UserId(Integer int_UserId) {
	this.int_UserId = int_UserId;
}

public RoleManagement getRoleManagement() {
	return roleManagement;
}

public void setRoleManagement(RoleManagement roleManagement) {
	this.roleManagement = roleManagement;
}
private RoleAssignment  roleAssignment ;
public RoleAssignment getRoleAssignment() {
	return roleAssignment;
}

public Character getC() {
	return C;
}

public void setC(Character c) {
	C = c;
}

public Character getS() {
	return S;
}

public void setS(Character s) {
	S = s;
}

public void setRoleAssignment(RoleAssignment roleAssignment) {
	this.roleAssignment = roleAssignment;
}
private Character C;
private Character S;
public String  addRoleManagement()
{S=S;
C=C;
	@SuppressWarnings("rawtypes")
	ListIterator itr1=list.listIterator();
	while(itr1.hasNext())
	{ 
		str_RoleName=(String) itr1.next();
		System.out.println(str_RoleName);
		roleAssignment=new RoleAssignment();
		
		roleAssignment.setStr_RoleName(str_RoleName);
		roleAssignment.setInt_RoleId(getMaintainanceStaffService().getRoleId(str_RoleName));
		roleAssignment.setInt_UserId(int_UserId);
		 
		S=getMaintainanceStaffService().getUserType(int_UserId);
		System.out.println(S);
		if(S==null)
		{
		roleAssignment.setChar_User_Type('C');
		}
		else{
			roleAssignment.setChar_User_Type('S');
		}
		roleAssignment.setInt_ApartmentId(getMaintainanceStaffService().getApartmentId(int_UserId));
		List<Integer> roleId=getMaintainanceStaffService().getRoleID(int_UserId);
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
		   
	} getMaintainanceStaffService().saveRoleManagement(roleAssignment);
		 }
 
	 return  null;
	
}
private String str_UserName;
public void getUserName()
{
	System.out.println("kalpana1");
	System.out.println(int_UserId);
	 str_UserName=getMaintainanceStaffService().getUserName(int_UserId);
	 System.out.println(str_UserName);
	 
}

public String getStr_UserName() {
	return str_UserName;
}

public void setStr_UserName(String str_UserName) {
	this.str_UserName = str_UserName;
}
}
