package com.appowner.dao;

import java.util.List;

import com.appowner.model.cls_Feedback;

public interface cls_FeedbackDao {

	public void addFeedback(cls_Feedback feedback);
	
	public List<cls_Feedback> listFeedbacks();

	public void deleteFeedback1(cls_Feedback feedback);

	public cls_Feedback getFeedback1(Integer feedbackId);

	public void update(cls_Feedback feedback);

	public List<String> var_feedbacktopicnamelist();

	public List<String> var_satisfactionnamelist();
	 
}
