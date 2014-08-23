package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.AdministrationAccessDao;
import com.appowner.model.AdministrationAccess;
import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;

@Service("AdministrationAccessService")
@Transactional
public class AdministrationServiceImpl implements AdministrationAccessService{
	@Autowired
	private AdministrationAccessDao administrationAccessDao;

	
	public AdministrationAccessDao getAdministrationAccessDao() {
		return administrationAccessDao;
	}

	public void setAdministrationAccessDao(
			AdministrationAccessDao administrationAccessDao) {
		this.administrationAccessDao = administrationAccessDao;
	}
	
	
	@Override
	public List<RoleAssignment> getRoleAssignmentList() {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getRoleAssignmentList();
	}

	 
	@Override
	public List<Integer> getUserIds() {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getUserIds();
	}

	@Override
	public  String  getUserName(Integer id) {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getUserName(id);
	}

	@Override
	public List<String> getStr_Roles(String username) {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getStr_Roles(username);
	}

	@Override
	public List<String> getAllCommitteeMembers() {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getAllCommitteeMembers();
	}

	@Override
	public List<String> getAllMaintainanceMembers() {
		// TODO Auto-generated method stub
		return  getAdministrationAccessDao().getAllMaintainanceMembers();
	}

	@Override
	public Integer getUserId(String name) {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getUserId(name);
	}

	@Override
	public void addAdmin(AdministrationAccess administrationAccess) {
		getAdministrationAccessDao().addAdmin( administrationAccess);
		
	}

	@Override
	public void saveAdministrationAccess(
			AdministrationAccess administrationAccess) {
		getAdministrationAccessDao().saveAdministrationAccess( administrationAccess);
		
	}

	@Override
	public void deleteAssignedRoles(Integer RoleId, Integer int_UserId) {
		getAdministrationAccessDao().deleteAssignedRoles( RoleId, int_UserId) ;
		
	}

	@Override
	public List<Integer> getroleids(Integer int_UserId) {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getroleids(int_UserId);
	}

	@Override
	public List<String> getRoleMaster() {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getRoleMaster();
	}

	@Override
	public List<AdministrationAccess> getListAdministrationAccess() {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getListAdministrationAccess();
	}

	@Override
	public String getRoleName(Integer roleid) {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getRoleName(roleid);
	}

	@Override
	public List<Integer> getRoleIds() {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getRoleIds();
	}

	@Override
	public List<Integer> getRoleMasterIds() {
		// TODO Auto-generated method stub
		return getAdministrationAccessDao().getRoleMasterIds();
	}

	

}
