package com.appowner.bean;

import java.io.Serializable;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.dao.DataAccessException;

import com.appowner.model.cls_Message;
import com.appowner.service.cls_MessageService;
@ManagedBean
@SessionScoped

public class cls_MessageTemplateBean implements Serializable {
	private static final long serialVersionUID = 1L;
	  private static final String SUCCESS = "ViewMessageTemplate";
	    private static final String ERROR   = "error";
	    private String str_Email;
	    private String MessageMode;
	    private  String MessageCategory;
	    private String var_MessageDetails;
	    private String var_MessageSubject;
	    private String messageId;
	   
	    
	    @ManagedProperty(value="#{cls_MessageService}")
		private cls_MessageService messageService;
		
		
	    
		public cls_MessageService getMessageService() {
			return messageService;
		}
		public void setMessageService(cls_MessageService messageService) {
			this.messageService = messageService;
		}
		
		 private List<String> messageCategoryList;
		public List<String> getMessageCategoryList() 
		{   System.out.println("fjfjhvhvkv");
			messageCategoryList=new ArrayList<String>();
			messageCategoryList.addAll(getMessageService().getMessageCategoryList());
			return messageCategoryList;
		}
		
		public void setMessageCategoryList(List<String> messageCategoryList) {
			this.messageCategoryList = messageCategoryList;
		}
		public String getMessageId() {
			return messageId;
		}
		 
		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}
		public String getStr_Email() {
			return str_Email;
		}
		public void setStr_Email(String str_Email) {
			this.str_Email = str_Email;
		}
		public String getMessageMode() {
			return MessageMode;
		}
		public void setMessageMode(String messageMode) {
			MessageMode = messageMode;
		}
		public String getMessageCategory() {
			return MessageCategory;
		}
		public void setMessageCategory(String messageCategory) {
			MessageCategory = messageCategory;
		}
		public String getVar_MessageDetails() {
			return var_MessageDetails;
		}
		public void setVar_MessageDetails(String var_MessageDetails) {
			this.var_MessageDetails = var_MessageDetails;
		}
		public String getVar_MessageSubject() {
			return var_MessageSubject;
		}
		public void setVar_MessageSubject(String var_MessageSubject) {
			this.var_MessageSubject = var_MessageSubject;
		}
	    
		public String addMessage()
		{  
			try{
			 cls_Message msg=new cls_Message();
			 msg.setMessageId( getMessageId());
			 msg.setStr_Email(getStr_Email());
			 msg.setMessageMode(getMessageMode());
			 msg.setMessageCategory(getMessageCategory());
			 msg.setVar_MessageSubject(getVar_MessageSubject());
			 msg.setVar_MessageDetails(var_MessageDetails);
			 getMessageService().addMessage(msg);
		
			 return SUCCESS;
		}
		catch(DataAccessException e)
		{e.printStackTrace();
			
		}
         return ERROR;
			
		}
		
		public String deleteMessage(String MessageId)
		 {
			 cls_Message msg=new cls_Message();
			 
			 msg.setMessageId(MessageId);
			
			 getMessageService().deleteMessage(msg);
			 return SUCCESS;
		 }
		
		private List<cls_Message> ListMessage;
		public List<cls_Message> getListMessage() {
			ListMessage= new ArrayList<cls_Message>();
				ListMessage.addAll(getMessageService().listMessages());
			
			return ListMessage;
		}
		public void setListMessage(List<cls_Message> listMessage) {
			ListMessage = listMessage;
		}
		
		public void reset() {
	        this.setMessageId("");
	                 
	
		
		}
		

}
