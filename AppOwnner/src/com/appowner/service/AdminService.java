package com.appowner.service;

import java.util.List;

import com.appowner.model.User;
import com.appowner.model.UserApartment;

public interface AdminService {
	public User validate(String name,String password);
	public List<UserApartment> listApartment();
	public Long count(String ApartmentName);
	public List<User> getUserlist(String str_Apartmentname);
}