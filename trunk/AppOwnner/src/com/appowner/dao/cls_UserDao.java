package com.appowner.dao;

import java.util.List;

import com.appowner.model.*;

public interface cls_UserDao {
		
		public void addUser(cls_User user);

		public List<cls_User> listUsers();
		
		public cls_User getUser(int userid);
		
		public void deleteUser(cls_User user);

		 

		public void update(cls_User user);
	}


