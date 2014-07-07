package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.AdministrationAccessDao;
import com.appowner.model.RoleAssignment;

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

	

}
