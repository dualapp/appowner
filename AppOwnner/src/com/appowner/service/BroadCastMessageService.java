package com.appowner.service;

import java.util.List;

import com.appowner.model.MessageType;

public interface BroadCastMessageService {

	List<String> getMessageTempTypeList();

	List<MessageType> getMessageTypeList();

}
