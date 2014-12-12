package com.appowner.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.AdminDao;
import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserExtraInfo;

@Service("AdminService")
@Transactional 
public class AdminServiceImpl implements AdminService,Serializable{
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
	public void updateStatus(int id,int status)
	{
		getAdminDao().updateStatus(id,status);
	}
	public void deleteApartment(int id)
	{
		getAdminDao().deleteApartment(id);
	}
	public UserApartment getApartmentDetails(Integer int_ApartmentId)
	{
		return getAdminDao().getApartmentDetails(int_ApartmentId);
	}
	public void updateApartment(UserApartment apartmentinformation)
	{
		getAdminDao().updateApartment(apartmentinformation);
	}
	public User getUser(Integer user_ID)
	{
		return getAdminDao().getUser(user_ID);
	}
	public void updateProfilePic(User user)
	{
		getAdminDao().updateProfilePic(user);
	}
	public UserExtraInfo getExtraUserInfo(Integer user_ID)
	{
		return getAdminDao().getExtraUserInfo(user_ID);
	}
}
