package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.*;
import com.appowner.model.*;


@Service("cls_MessageService")
@Transactional 
public class cls_MessageServiceImpl implements cls_MessageService {

	@Autowired
	private cls_MessageTemplateDao msgDao;
	
	 public cls_MessageTemplateDao getMsgDao() {
		return msgDao;
	}

	public void setMessageTemplateDao(cls_MessageTemplateDao msgDao) {
		this.msgDao = msgDao;
	}

	public void addMessage(cls_Message msg) {
		 System.out.println(msgDao);
		 
		getMsgDao().addMessage(msg);
	}
	
	public List<cls_Message> listMessages() {
		return getMsgDao().listMessages();
	}

	public cls_Message getMessage(String messageId) {
		return msgDao.getMessage(messageId);
	}
	
	public void deleteMessage(cls_Message msg) {
		getMsgDao().deleteMessage(msg);
	}
 

	@Override
	public void update(cls_Message msg) {
		getMsgDao().update(msg);
		
	}

	@Override
	public List<String> getMessageCategoryList() {
		 
		return (List<String>) getMsgDao().getMessageCategoryList();
	}
 	 
	 
	 
	}
