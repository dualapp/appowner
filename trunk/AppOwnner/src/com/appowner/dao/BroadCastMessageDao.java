package com.appowner.dao;

import java.util.List;

import com.appowner.model.MessageType;

public interface BroadCastMessageDao   {

	List<String> getMessageTempTypeList();

	List<MessageType> getMessageTypeList();

}
