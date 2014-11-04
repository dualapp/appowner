package com.appowner.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.BroadCastMessageDao;
import com.appowner.model.MessageType;

@Service("BroadCastMessageService")
@Transactional

public class BroadCastMessageServiceImpl implements  BroadCastMessageService{
	@Autowired
	private BroadCastMessageDao broadCastMessageDao ;
	public BroadCastMessageDao getBroadCastMessageDao() {
		return broadCastMessageDao;
	}

	public void setBroadCastMessageDao(BroadCastMessageDao broadCastMessageDao) {
		this.broadCastMessageDao = broadCastMessageDao;
	}

	@Override
	public List<String> getMessageTempTypeList() {
		// TODO Auto-generated method stub
		return broadCastMessageDao.getMessageTempTypeList();
	}

	@Override
	public List<MessageType> getMessageTypeList() {
		// TODO Auto-generated method stub
		return broadCastMessageDao.getMessageTypeList();
	}

	

}
