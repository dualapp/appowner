package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.CommiteeRole;
import com.appowner.model.RoleMaster;
import com.appowner.model.Staff;

@Repository
public class StaffDaoImpl implements StaffDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addStaff(Staff staff)
	{
		getSessionFactory().getCurrentSession().save(staff);	
	}
	public void addRole(CommiteeRole role)
	{
		getSessionFactory().getCurrentSession().save(role);	
	}
	public void addMaster(RoleMaster master)
	{
		getSessionFactory().getCurrentSession().save(master);	
	}
	 @SuppressWarnings("unchecked")
		public List<Staff> listStaffRoles()
		  {
			 return (List<Staff>) getSessionFactory().getCurrentSession().createCriteria(Staff.class).list(); 
		  }
		  @SuppressWarnings("unchecked")
		public List<CommiteeRole> listCommiteeRoles()
		  {
			  return (List<CommiteeRole>) getSessionFactory().getCurrentSession().createCriteria(CommiteeRole.class).list(); 
		  }
		  @SuppressWarnings("unchecked")
		public List<RoleMaster> listRoleMaster()
		  {
			  return (List<RoleMaster>) getSessionFactory().getCurrentSession().createCriteria(RoleMaster.class).list();  
		  }
		@Override
		public Long getNoOfRoles() {
			String hql="Select Count(*) from Staff";
			Long count=(Long)getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
			System.out.println(count);
			
			return count;
		}
		
		
}
