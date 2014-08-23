package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.AdministrationAccess;
import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;
import com.appowner.model.User;

public interface AdministrationAccessService {

	List<RoleAssignment> getRoleAssignmentList();

	List<Integer> getUserIds();

	String getUserName(Integer id);

	List<String> getStr_Roles(String username);

	List<String> getAllCommitteeMembers();

	List<String> getAllMaintainanceMembers();

	Integer getUserId(String name);

	void addAdmin(AdministrationAccess administrationAccess);

	void saveAdministrationAccess(AdministrationAccess administrationAccess);

	void deleteAssignedRoles(Integer roleid, Integer int_UserId);

	List<Integer> getroleids(Integer int_UserId);

	List<String> getRoleMaster();

	List<AdministrationAccess> getListAdministrationAccess();

	String getRoleName(Integer roleid);

	List<Integer> getRoleIds();

	List<Integer> getRoleMasterIds();

}
