package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import org.springframework.dao.DataAccessException;







import com.appowner.model.cls_Person;
import com.appowner.model.cls_Userfeedback;
import com.appowner.service.cls_UserServicefeedback;
@ManagedBean
@SessionScoped

public class cls_FeedbackBean implements Serializable {
	private static final long serialVersionUID = 1L;
	  private static final String SUCCESS = "ViewFeedback";
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
		private cls_UserServicefeedback userService;
		
		public cls_UserServicefeedback getUserService() {
			return userService;
		}
		public void setUserService(cls_UserServicefeedback userService) {
			this.userService = userService;
		}
		public String addUser()
		{  try{
			cls_Userfeedback user=new cls_Userfeedback();
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
		public String deleteUser()
		{
			cls_Userfeedback user=new cls_Userfeedback();
			//maintainanceStaff.setInt_UserId(int_UserId);
			user.setUserId(userId);
			getUserService().deleteUser(user);
			return "ViewEnquiry.xhtml?faces-redirect=true";
		}
		public String cancelUser() {
			return "ViewEnquiry.xhtml?faces-redirect=true";
		}
		
		private List<cls_Userfeedback> ListUser;
		public List<cls_Userfeedback> getListUser() {
			ListUser= new ArrayList<cls_Userfeedback>();
				ListUser.addAll(getUserService().listUsers());
			
			return ListUser;
		}
		public void setListUser(List<cls_Userfeedback> listUser) {
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
