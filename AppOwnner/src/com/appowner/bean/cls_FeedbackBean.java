package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;






import com.appowner.model.cls_User;
import com.appowner.service.cls_UserService;
@ManagedBean
@RequestScoped

public class cls_FeedbackBean implements Serializable {
	private static final long serialVersionUID = 1L;
	  private static final String SUCCESS = "success";
	    private static final String ERROR   = "error";
	    private String userEmail;
	    private String userMessage;
	    
	   public String getUserMessage() {
		   return userMessage;
	   }
	   public void setUserMessage(String userMessage) {
		   this.userMessage=userMessage;
	   }
	    
	    public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		
		@ManagedProperty(value="#{cls_UserService}")
		private cls_UserService userService;
		
		public cls_UserService getUserService() {
			return userService;
		}
		public void setUserService(cls_UserService userService) {
			this.userService = userService;
		}
		public String addUser()
		{  try{
			cls_User user=new cls_User();
			user.setUserId(getUserId());
			user.setUserName(getUserName());
			
			 user.setUserEmail(getUserEmail());
			 user.setUserMessage(getUserMessage());
	       
	        
	        
			
			getUserService().addUser(user);
		//	System.out.println("hii");
			return SUCCESS;
		}
		catch(DataAccessException e)
		{e.printStackTrace();
			
		}
		return ERROR;
			
		}
		public String deleteUser(int UserId)
		 {
			 cls_User user=new cls_User();
			 
			 user.setUserId(UserId);
			
			 getUserService().deleteUser(user);
			 return SUCCESS;
		 }
		
		private List<cls_User> ListUser;
		public List<cls_User> getListUser() {
			ListUser= new ArrayList<cls_User>();
				ListUser.addAll(getUserService().listUsers());
			
			return ListUser;
		}
		public void setListUser(List<cls_User> listUser) {
			ListUser = listUser;
		}
		
		private int userId;
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		private String userName;
		
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		public String getUserName() {
			return userName;
		}
		public void reset() {
	        this.setUserId(0);
	        this.setUserName("");
	        
	    }


}
