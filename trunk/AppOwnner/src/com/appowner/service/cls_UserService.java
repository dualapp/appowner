package com.appowner.service;

import java.util.List;

import com.appowner.model.cls_User;


public interface cls_UserService {
	
	public void addUser(cls_User user);

	public List<cls_User> listUsers();
	
	public cls_User getUser(int userid);
	
	public void deleteUser(cls_User user);

	 

	public void update(cls_User user);
}

