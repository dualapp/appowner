package com.appowner.dao;

import java.util.List;




















import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.bean.Cls_UserBean;
import com.appowner.model.BookAFacility;
import com.appowner.model.MemberLog;
import com.appowner.model.ServiceRequest;
import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserCity;
import com.appowner.model.UserCountry;
import com.appowner.model.UserState;
//import com.appowner.model.VendorState;
//import com.appowner.model.VendorCountry;
//import com.appowner.model.VendorCountry;

/**
 * @author pankaj
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
			System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
			System.out.println(Userinfo);
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
			 String hql="from User where int_UserId=?";
				User Userinfo=(User) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, int_UserId).uniqueResult();
				System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
				System.out.println(Userinfo);
				return Userinfo;
		}

		public void updateUs(User user) {
			sessionFactory.getCurrentSession().update(user);
			
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

		//@Override
		//public void addUser(User user) {
			// TODO Auto-generated method stub
			
		//}
		


}
