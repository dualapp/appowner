package com.appowner.dao;

import java.util.List;

import com.appowner.model.*;

public interface cls_MessageTemplateDao {
		
		public void addMessage(cls_Message msg);

		public List<cls_Message> listMessages();
		
		public cls_Message getMessage(String messageId);
		
		public void deleteMessage(cls_Message msg);
 
		public void update(cls_Message msg);

		public List<String> getMessageCategoryList();
   
		 
 
	}
