package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.AdminDao;
import com.appowner.model.User;
import com.appowner.model.UserApartment;

@Service("AdminService")
@Transactional 
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public User validate(String name,String password)
	{
		 return getAdminDao().validate(name,password);
	}
	public List<UserApartment> listApartment(){
		return getAdminDao().listApartment();
	}
	public Long count(String ApartmentName)
	{
		return getAdminDao().count(ApartmentName);
	}
	@SuppressWarnings("unchecked")
	public List<User> getUserlist(String str_Apartmentname)
	{
		return (List<User>) getAdminDao().getUserlist(str_Apartmentname);
	}
}
