package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.CommiteeRole;
import com.appowner.model.Complain;
import com.appowner.model.RoleMaster;
import com.appowner.model.Staff;
import com.appowner.model.menuTransaction;

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
			 return (List<Staff>) getSessionFactory().getCurrentSession().createCriteria(Staff.class).setCacheable(true).list(); 
		  }
		  @SuppressWarnings("unchecked")
		public List<CommiteeRole> listCommiteeRoles()
		  {
			  return (List<CommiteeRole>) getSessionFactory().getCurrentSession().createCriteria(CommiteeRole.class).setCacheable(true).list(); 
		  }
		  @SuppressWarnings("unchecked")
		public List<RoleMaster> listRoleMaster()
		  {
			  return (List<RoleMaster>) getSessionFactory().getCurrentSession().createCriteria(RoleMaster.class).setCacheable(true).list();  
		  }
		@Override
		public Long getNoOfRoles() {
			String hql="Select Count(*) from Staff";
			Long count=(Long)getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println(count);
			
			return count;
		}
		public Staff getStaffRole(Integer int_StaffID)
		{
			 return (Staff)getSessionFactory().getCurrentSession().get(Staff.class,int_StaffID);
		}
		public void updateStaffRole(Staff staff1)
		{
			getSessionFactory().getCurrentSession().update(staff1);
		}
		public RoleMaster getRoleMaster(Integer int_RoleID)
		{
			return (RoleMaster)getSessionFactory().getCurrentSession().get(RoleMaster.class,int_RoleID);
		}
		public void updateRoleMaster(RoleMaster master2)
		{
			getSessionFactory().getCurrentSession().update(master2);
		}
		public CommiteeRole getCommiteeRole(Integer int_Commitee_RoleID)
		{
			return (CommiteeRole)getSessionFactory().getCurrentSession().get(CommiteeRole.class,int_Commitee_RoleID);
		}
		public void updateCommiteeRole(CommiteeRole role2)
		{
			getSessionFactory().getCurrentSession().update(role2);
		}
		@SuppressWarnings("unchecked")
		public List<String> subcriptlist()
		{
		  return 	getSessionFactory().getCurrentSession().createQuery("select subscriptname from Subcript").setCacheable(true).list();
		}
		public Integer getSubcriptId(String subscriptName)
		{
			return (Integer) getSessionFactory().getCurrentSession().createQuery("select subcriptID from Subcript where subscriptname=?").setParameter(0, subscriptName).setCacheable(true).uniqueResult();
		}
		public void saveMenuTransaction(menuTransaction menu)
		{
			getSessionFactory().getCurrentSession().save(menu);
		}
}
