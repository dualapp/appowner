package com.appowner.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
































































import java.util.ListIterator;

import javax.mail.Session;
import javax.management.Query;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.bean.Cls_UserBean;
import com.appowner.model.BookAFacility;
import com.appowner.model.DueTransaction;
import com.appowner.model.MemberLog;
import com.appowner.model.ServiceRequest;
import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserBlocks;
import com.appowner.model.UserCity;
import com.appowner.model.UserCountry;
import com.appowner.model.UserExtraInfo;
import com.appowner.model.UserState;
import com.appowner.model.Vendor;
import com.appowner.util.Util;
//import com.appowner.model.VendorState;
//import com.appowner.model.VendorCountry;
//import com.appowner.model.VendorCountry;

/**
 * @author kalpana
 *
 */
@Repository
public class Cls_UserDaoImpl implements In_UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(User user) {
		System.out.println(getSessionFactory());
		getSessionFactory().getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		return (List<User>) getSessionFactory().getCurrentSession().createCriteria(User.class).list();
	}

	public User getUser(int int_UserId) {
		return (User) getSessionFactory().getCurrentSession().get(User.class, int_UserId);
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM tb_User WHERE int_UserId = "+user.getInt_UserId()).executeUpdate();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List validateUser(Cls_UserBean user) {
		String str_FirstName=user.getStr_FirstName();
		String str_Password=user.getStr_LastName();
		System.out.println(str_FirstName);
		String hql="from User  where str_FirstName='str_FirstName' and str_Password='str_Password'";
		return getSessionFactory().getCurrentSession().createQuery(hql).list();
		
	}

		
		public void update(User usr) {
			getSessionFactory().getCurrentSession().update(usr);
			 
		}

		//@Override
		//public void update(int int_UserId) {
			// TODO Auto-generated method stub
			
		//}

		@Override
		public void updateUser(User usr) {
			System.out.println(getSessionFactory());
			getSessionFactory().getCurrentSession().update(usr);
			
		}

		@Override
		public void update(int int_UserId) {
			// TODO Auto-generated method stub
			
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<String> cityList() {
			List<String> cityList= getSessionFactory().getCurrentSession().createCriteria(UserCity.class).setProjection(Projections.property("str_CityName")).list();
			  System.out.println("hello");
			  System.out.println( cityList.listIterator().hasNext());
			  return  cityList;
		}
		@Override
		public List<String> cityList1(String str_UserState) {
			System.out.println(str_UserState);
			String hql=" select int_stateId from UserState  where str_StateName=?";
			int StateId=(int) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_UserState).uniqueResult();
			 
			String hql1="select str_CityName from UserCity where int_stateId="+StateId;
			@SuppressWarnings("unchecked")
			List<String> cityList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).list();
			System.out.println(cityList);
			return cityList;
			 
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<String> countryList() {
			 System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
			// String hql=" select str_CityName from VendorCity where str_StateName=str_StateName";
			List<String> countryList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(UserCountry.class).setProjection(Projections.property("str_CountryName")).list();
			  System.out.println( ( countryList).listIterator().hasNext());
			  return  countryList ;
		}
		public List<String> stateList() {

			@SuppressWarnings("unchecked")
			List<String> stateList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(UserState.class).setProjection(Projections.property("str_StateName")).list();
			  System.out.println( ( stateList).listIterator().hasNext());
			  return  stateList ;
			 
		}

		@Override
		public List<String> apatrmentList1(String str_ApartmentCity) {
			System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
			System.out.println(str_ApartmentCity);
			String hql=" select int_CityId from UserCity  where str_CityName=?";
			System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
			int cityId=(int) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_ApartmentCity).uniqueResult();
			System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
			String hql1="select str_ApartmentName from UserApartment where int_CityId="+cityId;
			System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			@SuppressWarnings("unchecked")
			List<String> cityList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).list();
			System.out.println(cityList);
			return cityList;
		}

		@Override
		public int getCityId(String str_ApartmentName) {
			System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
			System.out.println(str_ApartmentName);
			String hql=" select int_CityId from UserCity  where str_CityName=?";
			System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuukkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
			System.out.println(str_ApartmentName);
			int cityId=(int) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_ApartmentName).uniqueResult();
			System.out.println(cityId);
			return cityId;
		}

		public void addApartment(UserApartment ua) {
			getSessionFactory().getCurrentSession().save(ua);
			System.out.println("apatrmtne added successfullly*****************************************");
			
		}

		
		public int getApartmentId(String userapartment) {
			System.out.println("qqqqqqqqqqqqqq0000000000000000005555555555555555qqqqqqqqqqqqqqqq");
			System.out.println(userapartment);
			String hql=" select int_ApartmentId from UserApartment  where str_ApartmentName=?";
			System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuukkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
			//System.out.println(str_ApartmentName);
			Integer appartmentId= (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,userapartment).uniqueResult();
			System.out.println("333333333333333333333333333333333333333333");
			System.out.println(appartmentId);
			return appartmentId;
		}

		@Override
		public String getRoleNameUser(int i) {
			String hqlrolename="select str_RoleName from RoleMaster where int_RoleID=?";
			String UserRoleName=(String) getSessionFactory().getCurrentSession().createQuery(hqlrolename).setParameter(0,i).uniqueResult();
			return UserRoleName;
		}

		@Override
		public User getUserDetails(String formuserloginusername) {
			 String hql="from User where str_Username=?";
			User Userinfo=(User) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, formuserloginusername).uniqueResult();
			 
			return Userinfo;
		}

		@Override
		public User validateUser(String str_Username) {
			String hql="from User  where str_Username=?";
			
			 return (User)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,str_Username).uniqueResult();
			   
		}

		@Override
		public User validateUser1(String str_Email) {
			String hql="from User  where str_Email=?";
			
			 return (User)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,str_Email).uniqueResult();
			   
		}

		@Override
		public User getUserDetails(Integer int_UserId) {
			 String hql="from User where int_UserId=? ";
			 System.out.println(int_UserId+"jkkjkjkj");
				User Userinfo=(User) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_UserId).uniqueResult();
				System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
				System.out.println(Userinfo);
				return Userinfo;
		}

		public void updateUs(User user) {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
		}

		//@Override
		//public void addUser(User user) {
			// TODO Auto-generated method stub
			
		//}
		

		@Override
		public void addMemberLog(MemberLog memberLog) {
			sessionFactory.getCurrentSession().save(memberLog);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<MemberLog> getListMemberLog() {
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().createCriteria(MemberLog.class).list();
		}

		@Override
		public void addServiceRequest(ServiceRequest serviceRequest) {
			sessionFactory.getCurrentSession().save(serviceRequest);
			
		}

		@Override
		public void addBookAFacility(BookAFacility bookAFacility) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().save(bookAFacility);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<ServiceRequest> getServiceRequestList() {
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().createCriteria(ServiceRequest.class).list();
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<BookAFacility> getBookAFacilityList() {
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().createCriteria(BookAFacility.class).list();
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<? extends User> getuserDetails(
				Integer int_apartment_id) {
			System.out.println("***********************************");
			String hql="from User where int_ApartmentId=?AND str_UserRoleName=?";
			List<User>   sss1=(List<User>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_apartment_id).setParameter(1, "User").list();
			System.out.println(sss1);
			return sss1;
		}

		public void addBlocks(UserBlocks us) {
			sessionFactory.getCurrentSession().save(us);
		}

		public Integer apartmentidget(String str_userapartment) {
			String hqlapartmentid="select int_ApartmentId from UserApartment where str_ApartmentName=?";
			Integer apartmentida=(Integer) getSessionFactory().getCurrentSession().createQuery(hqlapartmentid).setParameter(0,str_userapartment).uniqueResult();
			return apartmentida;
		}

		@Override
		public Collection<? extends String> blocks(int aparmentid1) {
			String hql5="select str_BlockName from UserBlocks where int_ApartmentId="+aparmentid1;
			System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			@SuppressWarnings("unchecked")
			List<String> Blocks= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql5).list();
			System.out.println(Blocks);
			return Blocks;
			// TODO Auto-generated method stub
			//return null;
		}

		@Override
		public User edit(int userid) {
			String hql41="from User where int_UserId=?";
			System.out.println("uuuuuuuuuuuuuuuuuuuueeeeeeeeeeeeeeuuuuuuuuuuuuuuuuuuuuuuuu");
			User Userinfo=(User) getSessionFactory().getCurrentSession().createQuery(hql41).setParameter(0,userid).uniqueResult();
			System.out.println("uuuuuuuuuuuuuuuuuuuuffffffffffuuuuuuuuuuuuuuuuuuuuuuuu");
			System.out.println(Userinfo.getStr_Email());
			return Userinfo;
		}

		public void updateUser1(User editlis) {
			sessionFactory.getCurrentSession().update(editlis);
			
		}

		@Override
		public void deleteUser2(Integer id) {
			
			
			sessionFactory.getCurrentSession().createQuery("delete from  User where  int_UserId=?").setParameter(0,id).setCacheable(true).executeUpdate();
			
			System.out.println("bnbnbnnnn");
				
			}

		@Override
		public int getUserRole(Integer userId) {
			// TODO Auto-generated method stub
			return (int) getSessionFactory().getCurrentSession().createQuery("select int_UserRole from User where int_UserId=?").setParameter(0, userId).uniqueResult();
		}

		@Override
		public UserExtraInfo getUserExtraInfo(Integer int_UserId) {
			// TODO Auto-generated method stub
			return  (UserExtraInfo) getSessionFactory().getCurrentSession().createQuery("from UserExtraInfo where int_UserId=?").setParameter(0, int_UserId).uniqueResult();
		}
			
		public Integer getStatus(String str_ApartmentName)
		{
			String hql="select status from UserApartment where str_ApartmentName=?";
			return (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0, str_ApartmentName).uniqueResult();
		}

		@Override
		public Integer getUserId(String str_Username) {
			// TODO Auto-generated method stub
			System.out.println(str_Username+"kkkkkkkkkkkkkpppppppppppp");
			System.out.println(getSessionFactory()+"kalpana");
			 
			return (Integer) getSessionFactory().getCurrentSession().createQuery("select int_UserId  from User where str_Username=?").setCacheable(true).setParameter(0, str_Username).uniqueResult();
		}

		@Override
		public User getFbUser(Integer id) {
			// TODO Auto-generated method stub
			return (User) getSessionFactory().getCurrentSession().get(User.class, id);
		}

		@Override
		public void updatePassword(Integer userId,String newPassword) {
			// TODO Auto-generated method stub
			getSessionFactory().getCurrentSession().createQuery("update User set str_Password = ? where int_UserId=?").setParameter(0, newPassword).setParameter(1, userId).executeUpdate();
		}

		@Override
		public String getPassword(Integer userId) {
			// TODO Auto-generated method stub
			return (String) getSessionFactory().getCurrentSession().createQuery(" select str_Password from  User  where int_UserId=?").setParameter(0, userId).uniqueResult();
		}

		@Override
		public User getUser(String userName) {
			// TODO Auto-generated method stub
			return (User) getSessionFactory().getCurrentSession().createQuery("from  User  where str_Email=?").setParameter(0, userName).uniqueResult();
		}

		@Override
		public String getPassword(String str_EmailId) {
			// TODO Auto-generated method stub
			return (String) getSessionFactory().getCurrentSession().createQuery(" select str_Password from  User  where str_Email=?").setParameter(0, str_EmailId).uniqueResult();
		}

		@Override
		public void setPassword(String str_Email, String str_RecoverPassword) {
			getSessionFactory().getCurrentSession().createQuery("update User set str_Password = ? where str_Email=?").setParameter(0, str_RecoverPassword).setParameter(1, str_Email).executeUpdate();
			
		}
		public Date getEntryDate(Integer int_ApartmentId)
		{
			return (Date) getSessionFactory().getCurrentSession().createQuery("select dat_EntryDate from UserApartment where int_ApartmentId=?").setParameter(0, int_ApartmentId).setCacheable(true).uniqueResult();
		}

		public Date getEndDate(Integer int_ApartmentId)
		{
			return (Date) getSessionFactory().getCurrentSession().createQuery("select dat_ExpireDate from UserApartment where int_ApartmentId=?").setParameter(0, int_ApartmentId).setCacheable(true).uniqueResult();
		}
		public String getSetUp()
		{   System.out.println(Util.getAppartmentId()+"fdjkdfkjfd11111111111111111111111111111111111111111111111");
		   System.out.println(Util.getUserId()+"jkfjkfgkjgfkjf22222222222222222222222222222222222222222222222");
			return (String) getSessionFactory().getCurrentSession().createQuery("select str_RoleName from RoleAssignment where int_ApartmentId=? and int_UserId=?").setParameter(0,Util.getAppartmentId()).setParameter(1,Util.getUserId()).setCacheable(true).uniqueResult();
		}
		public String getId(String setup)
		{
			int id=(int) getSessionFactory().getCurrentSession().createQuery("select int_RoleID from RoleMaster where str_RoleName=?").setParameter(0,setup).setCacheable(true).uniqueResult();
			System.out.println(id+"hhjhjjjh");
			int id1 =(int) getSessionFactory().getCurrentSession().createQuery("select int_MenuID from RoleMenuManagement where int_RoleID=? and int_ApartmentID=?").setParameter(0,id).setParameter(1, Util.getAppartmentId()).setCacheable(true).uniqueResult();
			String str=(String) getSessionFactory().getCurrentSession().createQuery("select str_MenuName  from ManuMaster where int_MenuID=?").setParameter(0,id1).setCacheable(true).uniqueResult();
			return str;
			
		}
		@Override
		public User isUserStaying(String str_HouseNo,Integer int_UserRole) {
			// TODO Auto-generated method stub
			return (User) getSessionFactory().getCurrentSession().createQuery("from User where str_Flat=? and int_ApartmentId=? and int_UserRole=?").setParameter(0, str_HouseNo).setParameter(1,Util.getAppartmentId()).setParameter(2,int_UserRole).uniqueResult();
		}
		@SuppressWarnings("unchecked")
		public List<String> getRoleAssign(Integer int_UserId, Integer int_ApartmentId)
		{  try
		   {
			
				 String str="select int_RoleId from RoleAssignment where int_ApartmentId=? and int_UserId=?";
				List<Integer> id= (List<Integer>) getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,int_ApartmentId).setParameter(1,int_UserId).list();
 
				
				if(id==null)
 
				System.out.println(id+"fdkfdjkfdjkkjf");
				if(id==null)
 
				{
					Integer id1=(Integer) getSessionFactory().getCurrentSession().createQuery("select int_subscriptID from UserApartment where int_ApartmentId=?").setParameter(0,int_ApartmentId).setCacheable(true).uniqueResult();
					  
					   String str2=(String) getSessionFactory().getCurrentSession().createQuery("select str_menuID from menuTransaction where int_subcriptionID=?").setParameter(0,id1).setCacheable(true).uniqueResult();
					
						  String[] strArray = str2.split(",");
						  List<String> str3=new ArrayList<String>();
						  for (String str1 : strArray) {
						       
						      
						       int id2=Integer.parseInt(str1);
						         str3.add((String) getSessionFactory().getCurrentSession().createQuery("select str_MenuName from ManuMaster where int_MenuID=?").setParameter(0,id2).setCacheable(true).uniqueResult());
						     
						       
						          
						        }
						
						  return str3;
					  
					   
				}
				else
				{
					 ListIterator list=id.listIterator();
					 while(list.hasNext())
					 {
					   Integer id2=(Integer) list.next();
					 
				    Integer id1=(Integer) getSessionFactory().getCurrentSession().createQuery("select int_MenuID from RoleMenuManagement where int_RoleID=? and int_ApartmentID=?").setParameter(0,id2).setParameter(1,int_ApartmentId).uniqueResult();
				
				    List<String> str1=(List<String>) getSessionFactory().getCurrentSession().createQuery("select str_MenuName from ManuMaster where int_MenuID=?").setParameter(0,id1).list();
				 
				    return str1;
					 }
				}
				
		   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		  }

		@Override
		public Vendor getVendor(String str_VendorName, String str_VendorType) {
			// TODO Auto-generated method stub
			return (Vendor) getSessionFactory().getCurrentSession().createQuery("from Vendor where str_VendorName=? and str_VendorType=?").setParameter(0, str_VendorName).setParameter(1, str_VendorType).uniqueResult();
		}

	 
}
		

		
		

		

	 


