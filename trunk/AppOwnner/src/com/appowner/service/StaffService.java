package com.appowner.service;

import java.util.List;

import com.appowner.model.CommiteeRole;
import com.appowner.model.RoleMaster;
import com.appowner.model.Staff;

public interface StaffService {
	public void addStaff(Staff staff);
	public void addRole(CommiteeRole role);
	public void addMaster(RoleMaster master);
	  public List<Staff> listStaffRoles();
	    public List<CommiteeRole> listCommiteeRoles();
	    public List<RoleMaster> listRoleMaster();
}
