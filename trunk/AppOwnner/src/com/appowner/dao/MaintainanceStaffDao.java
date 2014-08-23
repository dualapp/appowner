package com.appowner.dao;

import java.util.List;

import com.appowner.model.MaintainanceStaff;
import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;

public interface MaintainanceStaffDao {

	void addMaintainanceStaff(MaintainanceStaff maintainanceStaff);

	List<String> getStr_MaintainanceStaffRoles();

	List<MaintainanceStaff> getMaintainanceStaffList();

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

	List<RoleAssignment> getRoleName(Integer roleid);

	List<RoleAssignment> getRoleNames(Integer int_UserId);

	void deleteAssignedRoles(String str_RoleName, Integer int_UserId);

	List<Integer> getRoleID(Integer int_UserId);

	List<RoleManagement> getRoleManagementList();

	String getRoleNameFromRoleMaster(Integer roleId1);

	//void deleteAssignedRoles(RoleManagement rm);

	 
}
