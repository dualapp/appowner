package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.User;
import com.appowner.model.UserApartment;

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
			
		 System.out.println(name);
		 System.out.println(password);
			 String hql="from User  where str_Username=? and str_Password=?";
			
			 return (User)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,name).setParameter(1,password).uniqueResult();
			   
	 
	
}
	 @SuppressWarnings("unchecked")
	 public List<UserApartment> listApartment()
	 {
		 return (List<UserApartment>) getSessionFactory().getCurrentSession().createCriteria(UserApartment.class).list();	 
	 }
	 public Long count(String ApartmentName)
	 {
		 String hql="select count(*) from User where str_Apartment=?";
		 Long count1=(Long) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,ApartmentName).uniqueResult();
		   
		 System.out.println(count1);
		 return count1;
	 }
	 @SuppressWarnings("unchecked")
	public List<User> getUserlist(String str_Apartmentname)
	 {
		 String hql="from User where str_Apartment=?";
		  return (List<User>)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,str_Apartmentname).list();
		   
		
	 }
}
