package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserExtraInfo;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		@Override
		public User validate(String name,String password) {
			
		
			 String hql="from User  where str_Username=? and str_Password=?";
			
			 return (User)sessionFactory.getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,name).setParameter(1,password).uniqueResult();
			   
	 
	
}
	 @SuppressWarnings("unchecked")
	 public List<UserApartment> listApartment()
	 {
		 return (List<UserApartment>) getSessionFactory().getCurrentSession().createCriteria(UserApartment.class).setCacheable(true).list();	 
	 }
	 public Long count(String ApartmentName)
	 {
		 String hql="select count(*) from User where str_Apartment=?";
		 Long count1=(Long) sessionFactory.getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,ApartmentName).uniqueResult();
		   
		
		 return count1;
	 }
	 @SuppressWarnings("unchecked")
	public List<User> getUserlist(String str_Apartmentname)
	 {
		 String hql="from User where str_Apartment=?";
		  return (List<User>)sessionFactory.getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,str_Apartmentname).list();
		   
		
	 }
	 public void updateStatus(int id,int status)
	 {
		 String hql="update UserApartment set status=? where int_ApartmentId=?";
		 sessionFactory.getCurrentSession().createQuery(hql).setCacheable(true).setParameter(0,status).setParameter(1,id).executeUpdate();
	 }
	 public void deleteApartment(int id)
	 {   System.out.println("jkkjjk");
		 sessionFactory.getCurrentSession().createQuery("delete from UserApartment where int_ApartmentId=?").setParameter(0,id).executeUpdate();
	 }
	 public UserApartment getApartmentDetails(Integer int_ApartmentId)
	 {
		 String str="from UserApartment where int_ApartmentId=?";
		return  (UserApartment) sessionFactory.getCurrentSession().createQuery(str).setCacheable(true).setParameter(0, int_ApartmentId).uniqueResult();
	 }
	 public void updateApartment(UserApartment apartmentinformation)
	 {
		 sessionFactory.getCurrentSession().update(apartmentinformation);
	 }
	 public User getUser(Integer user_ID)
	 {
		 String str="from User where int_UserId=?";
			return  (User) sessionFactory.getCurrentSession().createQuery(str).setCacheable(true).setParameter(0, user_ID).uniqueResult();
	 }
	 public void updateProfilePic(User user)
	 {
		 sessionFactory.getCurrentSession().update(user);
	 }
	 public UserExtraInfo getExtraUserInfo(Integer user_ID)
	 {
		 String str="from UserExtraInfo where int_UserID=?";
			return  (UserExtraInfo) sessionFactory.getCurrentSession().createQuery(str).setCacheable(true).setParameter(0, user_ID).uniqueResult();
	 }
}
