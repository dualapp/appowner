package com.appowner.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.dao.DataAccessException;
 


import com.appowner.model.cls_Feedback;
import com.appowner.service.cls_FeedbackService;


@ManagedBean
@ViewScoped

public class cls_FeedbackBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "ViewFeedback";
	private static final String ERROR   = "error";
	private String date;
	private String str_Email;
	private Integer feedbackId;
	private String feedbackName;
	private String feedbackMsg;
	private List<cls_Feedback> feedbackList;
	
	
	
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackName() {
		return feedbackName;
	}
	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}
	public String getFeedbackMsg() {
		return feedbackMsg;
	}
	public void setFeedbackMsg(String feedbackMsg) {
		this.feedbackMsg = feedbackMsg;
	}
	public String getDate() {
		java.util.Date d=new java.util.Date();
		 SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
		return ft.format(d);
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public List<cls_Feedback> getFeedbackList() {
		feedbackList= new ArrayList<cls_Feedback>();
			feedbackList.addAll(getFeedbackService().listFeedbacks());		 
			return feedbackList;
	}
	public void setFeedbackList(List<cls_Feedback> feedbacklist) {
		feedbackList = feedbacklist;
	}

	@ManagedProperty(value="#{cls_FeedbackService}")
	private cls_FeedbackService feedbackService;
	
	
	
	public cls_FeedbackService getFeedbackService() {
		return feedbackService;
	}
	public void setFeedbackService(cls_FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
	public String addFeedback()
	{  
		try{
			System.out.println("Hi");
			cls_Feedback feedback=new cls_Feedback();
			feedback.setDate(getDate());
			feedback.setFeedbackId(getFeedbackId());
		    feedback.setFeedbackName(getFeedbackName());
		    feedback.setStr_Email(getStr_Email());		    
		    feedback.setFeedbackMsg(getFeedbackMsg());
		    getFeedbackService().addFeedback(feedback);
	
		 return SUCCESS;
	}
	catch(DataAccessException e)
	{e.printStackTrace();
		
	}
	return ERROR;
		
	} 
	
	public String deleteFeedback(int a)
	 {
		 cls_Feedback feedback=new cls_Feedback();		 
		 feedback.setFeedbackId(a);
		getFeedbackService().deleteFeedback1(feedback);
		 return SUCCESS;
	 }
	
	public String cancelFeedback() {
		return "ViewFeedback.xhtml?faces-redirect=true";
	}
	 
	public void getFeedback1() {
		feedback=getFeedbackService().getFeedback1(feedbackId);
	}
	
	public cls_Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(cls_Feedback feedback) {
		this.feedback = feedback;
	}

	private cls_Feedback feedback;
	
	public String saveFeedback() {
	    System.out.println("hihihihihihihihi");
		if(feedback.getFeedbackId()!=null)
		{	
			getFeedbackService().update(feedback);
		}
			else
			{	
			getFeedbackService().addFeedback(feedback);
			}
		return "ViewFeedback.xhtml?faces-redirect=true";
	}
	
	public void reset() {
        this.setFeedbackId(0);
        this.setFeedbackName("");
        
    }
	
	
}
