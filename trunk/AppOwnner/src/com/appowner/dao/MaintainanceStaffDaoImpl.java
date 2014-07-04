package com.appowner.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.MaintainanceStaff;
import com.appowner.model.MaintainanceStaffRole;
import com.appowner.model.RoleAssignment;
import com.appowner.model.RoleManagement;

@Repository
public class MaintainanceStaffDaoImpl implements  MaintainanceStaffDao {

	
	@Autowired
	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addMaintainanceStaff(MaintainanceStaff maintainanceStaff) {
		getSessionFactory().getCurrentSession().save(maintainanceStaff);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_MaintainanceStaffRoles() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(MaintainanceStaffRole.class).setProjection(Projections.property("str_MaintainanceStaffRoleName")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaintainanceStaff> getMaintainanceStaffList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(MaintainanceStaff.class).list();
	}

	@Override
	public MaintainanceStaff getOneMaintainanceStaff(Integer int_UserId) {
		// TODO Auto-generated method stub
		return (MaintainanceStaff) getSessionFactory().getCurrentSession().get(MaintainanceStaff.class, int_UserId);
	}

	@Override
	public void updateMaintainanceStaff(MaintainanceStaff maintainanceStaff) {
		getSessionFactory().getCurrentSession().update(maintainanceStaff);
		
	}

	@Override
	public void deleteMaintainanceStaff(MaintainanceStaff maintainanceStaff) {
		getSessionFactory().getCurrentSession().delete(maintainanceStaff);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_Roles() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(RoleManagement.class).setProjection(Projections.property("str_RoleName")).list();
	}

	@Override
	public Integer getRoleId(String str_RoleName) {
		// TODO Auto-generated method stub
		String hql="select int_RoleID from RoleManagement where str_RoleName=?";
		return (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_RoleName).uniqueResult() ;
	}

	@Override
	public void saveRoleManagement(RoleAssignment roleAssignment) {
		getSessionFactory().getCurrentSession().saveOrUpdate(roleAssignment);
		
	}

	@Override
	public Integer getMaintainanceStaffRoleId(String str_RoleName) {
		String hql="select int_MaintainanceStafRoleId from MaintainanceStaffRole where str_MaintainanceStaffRoleName=?";
		return  (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_RoleName).uniqueResult() ;
	}

	@Override
	public String getUserName(Integer int_UserId) {
		 String hql1="select str_FirstName from User where int_UserId=?";
		return (String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, int_UserId).uniqueResult() ;
	}

	@Override
	public Integer getApartmentId(Integer int_UserId) {
		System.out.println("kalpana2");
		System.out.println(int_UserId);
		//String hql2="select str_Apartment from User where int_UserId="+int_UserId;
		//String AppName=(String) getSessionFactory().getCurrentSession().createQuery(hql2).uniqueResult() ;
		 
		String hql3="select int_ApartmentId from User  where  int_UserId=?";
		 
		return (Integer) getSessionFactory().getCurrentSession().createQuery(hql3).setParameter(0, int_UserId).uniqueResult() ;
	}

	@Override
	public Character getUserType(Integer int_UserId) {
		String hql4="select char_User_Type from CommiteeMember where int_MemberId=?";
		return (Character) getSessionFactory().getCurrentSession().createQuery(hql4).setParameter(0, int_UserId).uniqueResult() ;
	}

	@Override
	public Integer getUserId(String str_UserName) {
		String hql="select int_UserId from User where str_FirstName=?";
		return (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_UserName).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	/*@Override
	public List<RoleAssignment> getAssignedRoles(Integer int_UserId) {
		List<RoleAssignment> RoleNames=null;
		//String roleName;
		 String hql5="select int_RoleId from  RoleAssignment where int_UserId=?";
		 List   roleId= getSessionFactory().getCurrentSession().createQuery(hql5).setParameter(0, int_UserId).list();
		@SuppressWarnings("rawtypes")
		ListIterator itr = roleId.listIterator();
		while(itr.hasNext())
		{
			Integer roleid=(Integer) itr.next();
			
			String hql6="select str_RoleName from  RoleManagement where int_RoleID=?";
			 // roleName= (String) getSessionFactory().getCurrentSession().createQuery(hql6).setParameter(0, roleid).uniqueResult();
			  RoleNames=new ArrayList<RoleAssignment>();
			  RoleNames.addAll((List<RoleAssignment>) getSessionFactory().getCurrentSession().createQuery(hql6).setParameter(0, roleid).list());
			  
		}
		 return  RoleNames;
	}
*/
	@Override
	public List<RoleAssignment> getAssignedIds(Integer int_UserId) {
		String hql5="select int_RoleId from  RoleAssignment where int_UserId=?";
		 List  roleId= getSessionFactory().getCurrentSession().createQuery(hql5).setParameter(0, int_UserId).list();
		return roleId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleAssignment> getRoleName(Integer roleid) {
		String hql6="select str_RoleName from  RoleManagement where int_RoleID=?";
		return  getSessionFactory().getCurrentSession().createQuery(hql6).setParameter(0, roleid).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleAssignment> getRoleNames(Integer int_UserId) {
		// TODO Auto-generated method stub
		String hql7="select str_RoleName from  RoleAssignment where int_UserId=?";
		return getSessionFactory().getCurrentSession().createQuery(hql7).setParameter(0, int_UserId).list();
	}

	@Override
	public void deleteAssignedRoles(String str_RoleName) {
		String hql="select int_RoleId from RoleAssignment where  str_RoleName=?";
		
		@SuppressWarnings("unchecked")
		List<Integer> roleId=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_RoleName).list();
		ListIterator itr= roleId.listIterator();
		while(itr.hasNext())
		{
			Integer roleID=(Integer) itr.next();
			
			String hql2="select  int_RoleAssignID from  RoleAssignment where int_RoleId =?";
			Integer assignedroleId= (Integer) getSessionFactory().getCurrentSession().createQuery(hql2).setParameter(0, roleID).uniqueResult();
			String hql1="delete from RoleAssignment where int_RoleAssignID=?";
			getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,assignedroleId).executeUpdate();
			
		}
		
		
		
	}

	 

	@Override
	public Integer getRoleID(Integer int_UserId) {
		String hql="select int_RoleAssignID from  RoleAssignment where int_UserId=?";
		
		return (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_UserId).uniqueResult();
	}
	
	
 }
