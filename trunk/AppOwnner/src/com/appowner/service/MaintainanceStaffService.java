package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.AdministrationAccess;
import com.appowner.model.MaintainanceStaff;
import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;
import com.appowner.model.RoleMenuManagement;

public interface MaintainanceStaffService {

	void addMaintainanceStaff(MaintainanceStaff maintainanceStaff);

	List<String> getStr_MaintainanceStaffRoles();

	List< MaintainanceStaff> getMaintainanceStaffList();

	MaintainanceStaff getOneMaintainanceStaff(Integer int_UserId);

	void updateMaintainanceStaff(MaintainanceStaff maintainanceStaff);

	void deleteMaintainanceStaff(MaintainanceStaff maintainanceStaff);

	List<String> getStr_Roles();

	Integer getRoleId(String str_RoleName);

	void saveRoleManagement(RoleAssignment roleAssignment);

	Integer getMaintainanceStaffRoleId(String str_RoleName);

	String getUserName(Integer int_UserId);

	Integer getApartmentId(Integer int_UserId);

	Character getUserType(Integer int_UserId);

	Integer getUserId(String str_UserName);
	List<RoleAssignment> getAssignedIds(Integer int_UserId);

	List<RoleAssignment> getRoleName(Integer roleId);

	List<RoleAssignment> getRoleNames(Integer int_UserId);

	void deleteAssignedRoles(String str_RoleName,Integer int_UserId);

	List<Integer> getRoleID(Integer int_UserId);

	List<RoleManagement> getRoleManagementList();

	String getRoleNameFromRoleMaster(Integer roleId1);

	void saveAdministrationAccess(AdministrationAccess administrationAccess);

	public List<String> getMenulist();

	Integer getMenuID(String str);

	void saveRolemenuManagement(RoleMenuManagement menu);

	List<String> getRoleMenus(Integer i);

	List<String> getMenulist1();

	void deleteAssignedMenus(Integer int_RoleId);

	//void deleteAssignedRoles(RoleManagement rm);

	 
}
