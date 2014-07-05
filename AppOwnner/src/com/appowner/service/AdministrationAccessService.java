package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.RoleAssignment;

public interface AdministrationAccessService {

	List<RoleAssignment> getRoleAssignmentList();

	List<Integer> getUserIds();

	String getUserName(Integer id);

	List<String> getStr_Roles(String username);

}
