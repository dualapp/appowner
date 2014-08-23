package com.appowner.service;

import java.util.List;

import com.appowner.model.cls_Message;


public interface cls_MessageService {
	
	public void addMessage(cls_Message msg);

	public List<cls_Message> listMessages();
	
	public cls_Message getMessage(String messageId);
	
	public void deleteMessage(cls_Message msg);
 
	public void update(cls_Message msg);

	public List<String> getMessageCategoryList();
    
	 
 
}
