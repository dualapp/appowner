package com.appowner.dao;

import java.util.List;

import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserExtraInfo;

public interface AdminDao {
	public User validate(String name,String password);
	public List<UserApartment> listApartment();
	public Long count(String ApartmentName);
	public List<User> getUserlist(String str_Apartmentname);
	public void updateStatus(int id, int status);
	public void deleteApartment(int id);
	public UserApartment getApartmentDetails(Integer int_ApartmentId);
	public void updateApartment(UserApartment apartmentinformation);
	public User getUser(Integer user_ID);
	public void updateProfilePic(User user);
	public UserExtraInfo getExtraUserInfo(Integer user_ID);
}
