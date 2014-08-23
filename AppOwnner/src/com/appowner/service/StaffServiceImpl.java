package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.StaffDao;
import com.appowner.model.CommiteeRole;
import com.appowner.model.RoleMaster;
import com.appowner.model.Staff;

@Service("StaffService")
@Transactional 
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	public void addStaff(Staff staff)
	{
		getStaffDao().addStaff(staff);
	}
	public void addRole(CommiteeRole role)
	{
		getStaffDao().addRole(role);
	}
	public void addMaster(RoleMaster master)
	{
		getStaffDao().addMaster(master);
	}
	 public List<Staff> listStaffRoles()
	  {
		  return  getStaffDao().listStaffRoles();
	  }
	  public List<CommiteeRole> listCommiteeRoles()
	  {
		  return  getStaffDao().listCommiteeRoles(); 
	  }
	  public List<RoleMaster> listRoleMaster()
	  {
		  return  getStaffDao().listRoleMaster();  
	  }
		public Long getNoOfRoles()
		{
			 return  getStaffDao().getNoOfRoles();
		}
}
