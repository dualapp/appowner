package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.MaintainanceStaffDao;
import com.appowner.model.AdministrationAccess;
import com.appowner.model.MaintainanceStaff;
import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;
import com.appowner.model.RoleMenuManagement;

@Service("MaintainanceStaffService")
@Transactional
public class MaintainanceStaffServiceImpl implements MaintainanceStaffService {
	@Autowired
	private MaintainanceStaffDao maintainanceStaffDao;

	public MaintainanceStaffDao getMaintainanceStaffDao() {
		return maintainanceStaffDao;
	}

	public void setMaintainanceStaffDao(MaintainanceStaffDao maintainanceStaffDao) {
		this.maintainanceStaffDao = maintainanceStaffDao;
	}

	@Override
	public void addMaintainanceStaff(MaintainanceStaff maintainanceStaff) {
		getMaintainanceStaffDao().addMaintainanceStaff(maintainanceStaff);
	}

	@Override
	public List<String> getStr_MaintainanceStaffRoles() {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getStr_MaintainanceStaffRoles();
	}

	@Override
	public List<MaintainanceStaff> getMaintainanceStaffList() {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getMaintainanceStaffList();
	}

	@Override
	public MaintainanceStaff getOneMaintainanceStaff(Integer int_UserId) {
		// TODO Auto-generated method stub
	 return getMaintainanceStaffDao().getOneMaintainanceStaff(int_UserId);
	}

	@Override
	public void updateMaintainanceStaff(MaintainanceStaff maintainanceStaff) {
		getMaintainanceStaffDao().updateMaintainanceStaff(maintainanceStaff);
		
	}

	@Override
	public void deleteMaintainanceStaff(MaintainanceStaff maintainanceStaff) {
		getMaintainanceStaffDao().deleteMaintainanceStaff(maintainanceStaff);
		
	}

	@Override
	public List<String> getStr_Roles() {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getStr_Roles();
	}

	@Override
	public Integer getRoleId(String str_RoleName) {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getRoleId(str_RoleName);
	}

	@Override
	public void saveRoleManagement(RoleAssignment roleAssignment) {
		getMaintainanceStaffDao().saveRoleManagement(roleAssignment);
		
	}
	
	@Override
	public Integer getMaintainanceStaffRoleId(String str_RoleName) {
	return	getMaintainanceStaffDao().getMaintainanceStaffRoleId(str_RoleName);
	}

	@Override
	public String getUserName(Integer int_UserId) {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getUserName(int_UserId);
	}

	@Override
	public Integer getApartmentId(Integer int_UserId) {
		// TODO Auto-generated method stub
		return  getMaintainanceStaffDao().getApartmentId(int_UserId);
	}

	@Override
	public Character getUserType(Integer int_UserId) {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao(). getUserType(int_UserId);
	}

	@Override
	public Integer getUserId(String str_UserName) {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getUserId(str_UserName) ;
	}

	 
	@Override
	public List<RoleAssignment> getAssignedIds(Integer int_UserId) {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getAssignedIds(int_UserId);
	}
 

	@Override
	public List<RoleAssignment> getRoleName( Integer roleId) {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getRoleName(roleId);
	}

	@Override
	public List<RoleAssignment> getRoleNames(Integer int_UserId) {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getRoleNames(int_UserId);
	}

	@Override
	public void deleteAssignedRoles(String str_RoleName,Integer int_UserId) {
		 getMaintainanceStaffDao().deleteAssignedRoles(str_RoleName,int_UserId);
		
	}
 
	@Override
	public List<Integer> getRoleID(Integer int_UserId) {
		// TODO Auto-generated method stub
		  return  getMaintainanceStaffDao().getRoleID((int_UserId));
	}

	@Override
	public List<RoleManagement> getRoleManagementList() {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getRoleManagementList();
	}

	@Override
	public String getRoleNameFromRoleMaster(Integer roleId1) {
		// TODO Auto-generated method stub
		return getMaintainanceStaffDao().getRoleNameFromRoleMaster(roleId1);
	}

	@Override
	public void saveAdministrationAccess(
			AdministrationAccess administrationAccess) {
		
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void deleteAssignedRoles(RoleManagement rm) {
		getMaintainanceStaffDao().deleteAssignedRoles(rm);
		
	}*/
	public List<String> getMenulist()
	{
		return getMaintainanceStaffDao().getMenulist();
	}
	public List<String> getMenulist1()
	{
		return getMaintainanceStaffDao().getMenulist1();
	}
	public Integer getMenuID(String str)
	{
		return getMaintainanceStaffDao().getMenuID(str);
	}
	public void saveRolemenuManagement(RoleMenuManagement menu)
	{
		getMaintainanceStaffDao().saveRolemenuManagement(menu);
	}
	public void deleteAssignedMenus(Integer int_RoleId)
	{
		getMaintainanceStaffDao().deleteAssignedMenus(int_RoleId);
	}

	@Override
	public List<String> getRoleMenus(Integer i) {
		
		 return getMaintainanceStaffDao().getRoleMenus(i);
	}
public	List<String> getSideMenu()
	{
		return getMaintainanceStaffDao().getSideMenu();
	}
	 
	 
}
