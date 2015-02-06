package com.appowner.dao;

import java.util.List;

import com.appowner.model.CommiteeRole;
import com.appowner.model.RoleMaster;
import com.appowner.model.Staff;
import com.appowner.model.menuTransaction;

public interface StaffDao {
	public void addStaff(Staff staff);
	public void addRole(CommiteeRole role);
	public void addMaster(RoleMaster master);
	 public List<Staff> listStaffRoles();
	  public List<CommiteeRole> listCommiteeRoles();
	  public List<RoleMaster> listRoleMaster();
	public Long getNoOfRoles();
	public Staff getStaffRole(Integer int_StaffID);
	public void updateStaffRole(Staff staff1);
	public RoleMaster getRoleMaster(Integer int_RoleID);
	public void updateRoleMaster(RoleMaster master2);
	public CommiteeRole getCommiteeRole(Integer int_Commitee_RoleID);
	public void updateCommiteeRole(CommiteeRole role2);
	public List<String> subcriptlist();
	public Integer getSubcriptId(String subscriptName);
	public void saveMenuTransaction(menuTransaction menu);
}
