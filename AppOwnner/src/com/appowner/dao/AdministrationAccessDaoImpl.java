package com.appowner.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.AdministrationAccess;
import com.appowner.model.CommiteeMember;
import com.appowner.model.MaintainanceStaff;
import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;
import com.appowner.model.Vendor;

@Repository
public class AdministrationAccessDaoImpl implements AdministrationAccessDao{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleAssignment> getRoleAssignmentList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(RoleAssignment.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getUserIds() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(RoleAssignment.class).setProjection(Projections.property("int_UserId")).list();
	}

	@Override
	public String getUserName(Integer id) {
		 String hql="select str_Username from User where int_UserId=?";
		return (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, id).uniqueResult();
	}

	@Override
	public List<String> getStr_Roles(String username) {
		 String hql="select int_UserId from User where str_Username=?";
		Integer id= (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, username).uniqueResult();
		String hql1="select str_RoleName from RoleAssignment where int_UserId=?";
		@SuppressWarnings("unchecked")
		List<String> roles=getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, id).list();
		return roles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllCommitteeMembers() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(CommiteeMember.class).setProjection(Projections.property("str_UserName")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllMaintainanceMembers() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(MaintainanceStaff.class).setProjection(Projections.property("str_UserName")).list();
	}

	@Override
public Integer getUserId(String name) {
		 String hql="select int_UserId from User where str_Username=?";
		 Integer id= (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,name).uniqueResult();
		return id;
	}

	@Override
	public void addAdmin(AdministrationAccess administrationAccess) {
		getSessionFactory().getCurrentSession().save(administrationAccess);
		
	}

	@Override
	public void saveAdministrationAccess(
			AdministrationAccess administrationAccess) {
		getSessionFactory().getCurrentSession().save(administrationAccess);
	}

	@Override
	public void deleteAssignedRoles(Integer RoleId, Integer int_UserId) {
 
		String hql="delete from AdministrationAccess where int_RoleID=? and int_UserID=?";
		 
			getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,RoleId).setParameter(1, int_UserId).executeUpdate();
					 
	}

	@Override
	public List<Integer> getRoleNames(Integer int_UserId) {
		String hql="select  Int_RoleID  from  AdministrationAccess where int_UserID =?";
		return getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_UserId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleManagement> getRoleMaster() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(RoleManagement.class).list();
	}

	@Override
	public List<AdministrationAccess> getListAdministrationAccess() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(AdministrationAccess.class).list();
	}
	
	
}
