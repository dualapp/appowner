package com.appowner.dao;

import java.util.List;

import com.appowner.model.RoleAssignment;

public interface AdministrationAccessDao {

	List<RoleAssignment> getRoleAssignmentList();

	List<Integer> getUserIds();

	String getUserName(Integer id);

	List<String> getStr_Roles(String username);

}
