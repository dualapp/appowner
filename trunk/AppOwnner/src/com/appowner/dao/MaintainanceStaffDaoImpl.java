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
import com.appowner.model.RoleMenuManagement;
import com.appowner.util.Util;

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
		return getSessionFactory().getCurrentSession().createCriteria(MaintainanceStaff.class).setCacheable(true).list();
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
		return getSessionFactory().getCurrentSession().createCriteria(RoleManagement.class).setCacheable(true).setProjection(Projections.property("str_RoleName")).list();
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
		 String hql1="select str_Username from User where int_UserId=?";
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
		String hql4="select char_User_Type from MaintainanceStaff where int_UserId=?";
		return (Character) getSessionFactory().getCurrentSession().createQuery(hql4).setParameter(0, int_UserId).uniqueResult() ;
	}

	@Override
	public Integer getUserId(String str_UserName) {
		String hql="select int_UserId from User where str_UserName=?";
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
		if(int_UserId==null)
		{
			return getSessionFactory().getCurrentSession().createQuery("select str_RoleName from RoleMaster where int_ApartmentID=0 or int_ApartmentID=?").setParameter(0,Util.getAppartmentId()).setCacheable(true).list();	
		}
		else
		{
		String hql7="select str_RoleName from  RoleAssignment where int_UserId=? and int_ApartmentId=?";
		//String hql8="from  RoleAssignment where int_UserId=?";
		return getSessionFactory().getCurrentSession().createQuery(hql7).setParameter(0, int_UserId).setParameter(1,Util.getAppartmentId()).list();
		 
		} 
		
	}

	@Override
	public void deleteAssignedRoles(String str_RoleName,Integer int_UserId) {
		String hql="select int_RoleId from RoleAssignment where  str_RoleName=?";
		
		@SuppressWarnings("unchecked")
		List<Integer> roleId=(List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_RoleName).list();
		@SuppressWarnings("rawtypes")
		ListIterator itr= roleId.listIterator();
		while(itr.hasNext())
		{
			Integer roleID=(Integer) itr.next();
			
			String hql2="select  int_RoleAssignID from  RoleAssignment where int_RoleId =? and int_UserId=?";
			Integer assignedroleId= (Integer) getSessionFactory().getCurrentSession().createQuery(hql2).setParameter(0, roleID).setParameter(1, int_UserId).uniqueResult();
			System.out.println(assignedroleId);
			String hql1="delete from RoleAssignment where int_RoleAssignID=?";
			getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,assignedroleId).executeUpdate();
			
		}
		
		
		
	}

	 

	@Override
	public List<Integer> getRoleID(Integer int_UserId) {
		String hql="select int_RoleId from  RoleAssignment where int_UserId=?";
		
		return (List<Integer>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_UserId).list();
	}

	@Override
	public List<RoleManagement> getRoleManagementList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(RoleAssignment.class).setCacheable(true).list();
	}

	@Override
	public String getRoleNameFromRoleMaster(Integer roleId1) {
		String hql="select str_RoleName from RoleManagement where int_RoleID=?";
		return (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, roleId1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<String> getMenulist()
	{  Integer id1=(Integer) getSessionFactory().getCurrentSession().createQuery("select int_subscriptID from UserApartment where int_ApartmentId=?").setParameter(0,Util.getAppartmentId()).setCacheable(true).uniqueResult();
	   System.out.println(id1+"fcjdfjkdfjkfd");
		/*String role=(String)getSessionFactory().getCurrentSession().createQuery("select str_UserRoleName from User where int_ApartmentId=?").setParameter(0,Util.getAppartmentId()).setCacheable(true).uniqueResult();
	    System.out.println(role+"fjdfjkfgkjf");
	    List<String> str3=new ArrayList<String>();
	    if(role.equalsIgnoreCase("admin"))
	    {
	      str3=getSessionFactory().getCurrentSession().createQuery("select str_MenuName from ManuMaster").setCacheable(true).list();
	      System.out.println(str3+"fjkfdkjdff");
	      return str3;
	    }
	    else
	    { */ 
	  
	   String str=(String) getSessionFactory().getCurrentSession().createQuery("select str_menuID from menuTransaction where int_subcriptionID=?").setParameter(0,id1).setCacheable(true).uniqueResult();
		System.out.println(str+"dskkj");
		  String[] strArray = str.split(",");
		  List<String> str2=new ArrayList<String>();
		  for (String str1 : strArray) {
		       
		       System.out.println(str1+"dsjjdfd");
		       int id=Integer.parseInt(str1);
		         str2.add((String) getSessionFactory().getCurrentSession().createQuery("select str_MenuName from ManuMaster where int_MenuID=?").setParameter(0,id).setCacheable(true).uniqueResult());
		       System.out.println(str2+"dskjfdjkdfkj");
		       
		          
		        }
		  System.out.println(str2+"dsjkdfkjdf");
		  return str2;
	  
	}
	@SuppressWarnings("unchecked")
	public List<String> getMenulist1()
	{
		 return getSessionFactory().getCurrentSession().createQuery("select str_MenuName from ManuMaster ").setCacheable(true).list();
	}
	@SuppressWarnings("unchecked")
	public Integer getMenuID(String str)
	{   System.out.println(str+"fdkgkggk");
	
		Integer id= (Integer) getSessionFactory().getCurrentSession().createQuery("select int_MenuID from ManuMaster where str_MenuName=?").setParameter(0,str).setCacheable(true).uniqueResult();
		System.out.println(id+"dflkkfldf");
		return id;
	}
	public void deleteAssignedMenus(Integer int_RoleId)
	{
		getSessionFactory().getCurrentSession().createQuery("delete From RoleMenuManagement where int_RoleID=?  and int_ApartmentID=?").setParameter(0, int_RoleId).setParameter(1,Util.getAppartmentId()).executeUpdate();
	}
	 @SuppressWarnings({ "deprecation", "unchecked" })
	public void saveRolemenuManagement(RoleMenuManagement menu)
	 
	 {
		
		
		 
		
		 
		  getSessionFactory().getCurrentSession().save(menu);   
	 
	 }
   @SuppressWarnings("unchecked")
public List<String> getRoleMenus(Integer i)
	 {   
	   List<Integer> id=new ArrayList<Integer>(); 
	   if(i==null)
		  
	   {
		 id=getSessionFactory().getCurrentSession().createQuery("select int_MenuID from RoleMenuManagement where int_RoleID=1 and int_ApartmentID=?").setParameter(0, Util.getAppartmentId()).list();
	   }
	   else
	   {
		id=getSessionFactory().getCurrentSession().createQuery("select int_MenuID from RoleMenuManagement where int_RoleID=? and int_ApartmentID=?").setParameter(0, i).setParameter(1, Util.getAppartmentId()).list();
		
		if(id==null)
		{
			List<String> id1=new ArrayList<String>(); 
			return id1;
		}
	   }
		ListIterator itr = id.listIterator();
		 List<String> str1=new ArrayList<String>();
		while(itr.hasNext())
		{  int id1=(int) itr.next();
		  String str=(String) getSessionFactory().getCurrentSession().createQuery("select str_MenuName from ManuMaster where int_MenuID=?").setParameter(0, id1).uniqueResult();
		
		 
		  str1.add(str);
		 
		}
		 return str1;
	 }
  @SuppressWarnings("unchecked")
public  List<String> getSideMenu()
  {  
	  String str="select int_RoleId from RoleAssignment where int_ApartmentId=? and int_UserId=?";
	Integer id= (Integer) getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,Util.getAppartmentId()).setParameter(1, Util.getUserId()).uniqueResult();
	System.out.println(id+"fjdfjdfjd");
	if(id==null)
	{
		Integer id1=(Integer) getSessionFactory().getCurrentSession().createQuery("select int_subscriptID from UserApartment where int_ApartmentId=?").setParameter(0,Util.getAppartmentId()).setCacheable(true).uniqueResult();
		   System.out.println(id1+"fcjdfjkdfjkfd");
		   String str2=(String) getSessionFactory().getCurrentSession().createQuery("select str_menuID from menuTransaction where int_subcriptionID=?").setParameter(0,id1).setCacheable(true).uniqueResult();
			System.out.println(str2+"dskkj");
			  String[] strArray = str2.split(",");
			  List<String> str3=new ArrayList<String>();
			  for (String str1 : strArray) {
			       
			       System.out.println(str1+"dsjjdfd");
			       int id2=Integer.parseInt(str1);
			         str3.add((String) getSessionFactory().getCurrentSession().createQuery("select str_MenuName from ManuMaster where int_MenuID=?").setParameter(0,id2).setCacheable(true).uniqueResult());
			     
			       
			          
			        }
			
			  return str3;
		  
		   
	}
	else
	{
	Integer id1=(Integer) getSessionFactory().getCurrentSession().createQuery("select int_MenuID from RoleMenuManagement where int_RoleID=? and int_ApartmentID=?").setParameter(0,id).setParameter(1,Util.getAppartmentId()).uniqueResult();
	
	List<String> str1=(List<String>) getSessionFactory().getCurrentSession().createQuery("select str_MenuName from ManuMaster where int_MenuID=?").setParameter(0,id1).list();
	 
	  return str1;
	}
  }
	}

