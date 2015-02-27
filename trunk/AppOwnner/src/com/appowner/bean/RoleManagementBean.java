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
import com.appowner.model.RoleMenuManagement;
import com.appowner.service.MaintainanceStaffService;
import com.appowner.util.Util;

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
public static Integer getId1() {
	return id1;
}

public static void setId1(Integer id1) {
	RoleManagementBean.id1 = id1;
}
Integer roleid;
public static Integer id1;
public  void getAssignedRoles(int int_UserId)
{
	List<RoleAssignment> roleId =new ArrayList<RoleAssignment>();
	   roleId.addAll(getMaintainanceStaffService().getAssignedIds(int_UserId));
	  id1= int_UserId;
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
	   System.out.println(int_UserId+"romemmmmmmmmmmmmmmmmmmmmmmmmmmm");
	str_AssinedRoles =new ArrayList<RoleAssignment>();
	System.out.println(int_UserId);
	str_AssinedRoles.addAll(getMaintainanceStaffService().getRoleNames(int_UserId));
	System.out.println(str_AssinedRoles);
	
	 }
public  void getAssignedRoleMenu()
{
	
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
		System.out.println(Cls_UserBean.id+"jfdffd");
		roleAssignment.setStr_RoleName(str_RoleName);
		roleAssignment.setInt_RoleId(getMaintainanceStaffService().getRoleId(str_RoleName));
		roleAssignment.setInt_UserId(id1);
		 
		S=getMaintainanceStaffService().getUserType(id1);
		System.out.println(S);
		if(S==null)
		{
		roleAssignment.setChar_User_Type('C');
		}
		else{
			roleAssignment.setChar_User_Type('S');
		}
		roleAssignment.setInt_ApartmentId(Util.getAppartmentId());
		List<Integer> roleId=getMaintainanceStaffService().getRoleID(id1);
		 ListIterator itr=roleId.listIterator();
		 while(itr.hasNext())
		 {
			 System.out.println(roleId);
				
			 Integer roleId1=(Integer) itr.next();
			String roleName= getMaintainanceStaffService().getRoleNameFromRoleMaster(roleId1);
			 if( roleName.equals(str_RoleName))
			 {
				System.out.println(roleName);
				 getMaintainanceStaffService().deleteAssignedRoles(str_RoleName,int_UserId);
				 
			 
			 }
			
			 System.out.println("k1111111111111111111111");
		   
	} 
		 getMaintainanceStaffService().saveRoleManagement(roleAssignment);
	
		 }
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Role Updated Successfully!"));
 
	 return "committeememberlist.xhtml";
	
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
private String roleName1;


public String getRoleName1() {
	return roleName1;
}

public void setRoleName1(String roleName1) {
	this.roleName1 = roleName1;
}
private List<String>  menuNames;
public List<String> getMenuNames() {
	menuNames=new ArrayList<String>();
	System.out.println(int_RoleId+"dkldslksdk");
	menuNames.addAll(getMaintainanceStaffService().getRoleMenus(int_RoleId));
	System.out.println(menuNames+"fgkfgk");
	return menuNames;
}

public void setMenuNames(List<String> menuNames) {
	this.menuNames = menuNames;
}
private List<String>  listMenuNames;
public List<String> getListMenuNames() {
	listMenuNames=new ArrayList<String>();
	listMenuNames.addAll(getMaintainanceStaffService().getMenulist());
	return listMenuNames;
}

public void setListMenuNames(List<String> listMenuNames) {
	this.listMenuNames = listMenuNames;
}
public void roleNameChangeListener(ValueChangeEvent event)
{
	roleName1=(String) event.getNewValue();
	System.out.println(roleName1+"dskkdffk");
	int_RoleId=getMaintainanceStaffService().getRoleId(roleName1);
	System.out.println(int_RoleId+"jjkkj");
	
}
private List<Integer>  int_menuID;
public List<Integer> getInt_menuID() {
	return int_menuID;
}

public void setInt_menuID(List<Integer> int_menuID) {
	this.int_menuID = int_menuID;
}

public void menuChangeListener(ValueChangeEvent event) 
{
	 list1=new ArrayList();
     list1.addAll((List<String>) event.getNewValue());
     System.out.println(list1+"dskkjfdkj");
     ListIterator itr=list1.listIterator();
     int_menuID=new ArrayList<Integer>();
     while(itr.hasNext())
     {   String str=(String) itr.next();
         System.out.println(str+"jkkejerkr");
         int_menuID.add(getMaintainanceStaffService().getMenuID(str)) ;
    	
     }
     System.out.println(int_menuID+"jjjjj");
}
private Integer id;
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public void addRoleMenuManagement()
{  
	try
	{
		RoleMenuManagement menu=new RoleMenuManagement();
		
		ListIterator itr=int_menuID.listIterator();
		getMaintainanceStaffService().deleteAssignedMenus(int_RoleId);
		while(itr.hasNext())
		{
			id=(int) itr.next();
			System.out.println(id+"hjhjjhjh");
			menu.setInt_MenuID(id);
			System.out.println(id+"fdjkdjfkdfjk");
			menu.setBt_Visible(0);
			menu.setInt_RoleID(int_RoleId);
			menu.setInt_ApartmentID(Util.getAppartmentId());
			getMaintainanceStaffService().saveRolemenuManagement(menu);
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
private List<String>  listSideMenu;
public List<String> getListSideMenu() {
	listSideMenu=new ArrayList<String>();
	listSideMenu=getMaintainanceStaffService().getSideMenu();
	return listSideMenu;
}

public void setListSideMenu(List<String> listSideMenu) {
	this.listSideMenu = listSideMenu;
}


}
