package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.*;
import com.appowner.model.*;


@Service("cls_UserService")
@Transactional 
public class cls_UserServiceImpl implements cls_UserService {

	@Autowired
	private cls_UserDao userDao;
	
	 public cls_UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(cls_UserDao userDao) {
		this.userDao = userDao;
	}

	public void addUser(cls_User user) {
		 System.out.println(userDao);
		 
		getUserDao().addUser(user);
	}
	
	public List<cls_User> listUsers() {
		return getUserDao().listUsers();
	}

	public cls_User getUser(int userId) {
		return userDao.getUser(userId);
	}
	
	public void deleteUser(cls_User user) {
		getUserDao().deleteUser(user);
	}
 

	@Override
	public void update(cls_User user) {
		getUserDao().update(user);
		
	}

	
	}

	
	

	
	 


