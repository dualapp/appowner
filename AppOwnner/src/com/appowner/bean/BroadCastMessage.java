package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.appowner.model.MessageType;
import com.appowner.service.BroadCastMessageService;

@ManagedBean
@ViewScoped
public class BroadCastMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{BroadCastMessageService}")
    private BroadCastMessageService broadCastMessageService;
    public BroadCastMessageService getBroadCastMessageService() {
		return broadCastMessageService;
	}
	public void setBroadCastMessageService(
			BroadCastMessageService broadCastMessageService) {
		this.broadCastMessageService = broadCastMessageService;
	}
	private String type="two";
	private String str_Block;
	private String str_MessageType;
	private String str_MessageTempType;
	private String str_Subject;
	private String str_Description;
	private String str_Date;
	
    private List<String> messageTempTypeList;
    private List<MessageType> messageTypeList;
    
	public String getStr_MessageType() {
		return str_MessageType;
	}
	public void setStr_MessageType(String str_MessageType) {
		this.str_MessageType = str_MessageType;
	}
	public String getStr_MessageTempType() {
		return str_MessageTempType;
	}
	public void setStr_MessageTempType(String str_MessageTempType) {
		this.str_MessageTempType = str_MessageTempType;
	}
	public String getStr_Subject() {
		return str_Subject;
	}
	public void setStr_Subject(String str_Subject) {
		this.str_Subject = str_Subject;
	}
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	public String getStr_Date() {
		return str_Date;
	}
	public void setStr_Date(String str_Date) {
		this.str_Date = str_Date;
	}
	public String getType() {
    	System.out.println(type+"type");
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Boolean checkType(String type1) {
        Boolean tmp =getStr_MessageType().equalsIgnoreCase(type1);
        System.out.println("checkType: "+this.type+" == "+type+"?  ("+tmp+")");
        return tmp;
    }
	public String getStr_Block() {
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public List<String> getMessageTempTypeList() {
		messageTempTypeList=new ArrayList<String>();
		messageTempTypeList.addAll(broadCastMessageService.getMessageTempTypeList());
		return messageTempTypeList;
	}
	 
	public List<MessageType> getMessageTypeList() {
		messageTypeList=new ArrayList<MessageType>();
		messageTypeList.addAll(broadCastMessageService.getMessageTypeList());
		return messageTypeList;
	}
	public void setMessageTypeList(List<MessageType> messageTypeList) {
		this.messageTypeList = messageTypeList;
	}

}
