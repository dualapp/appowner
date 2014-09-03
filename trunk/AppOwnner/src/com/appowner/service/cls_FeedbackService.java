package com.appowner.service;


import java.util.List;

import com.appowner.model.cls_Feedback;


public interface cls_FeedbackService {

	public List<cls_Feedback> listFeedbacks();

	void addFeedback(cls_Feedback feedback);

	public void deleteFeedback1(cls_Feedback feedback);

	public cls_Feedback getFeedback1(Integer feedbackId);

	public void update(cls_Feedback feedback);
	
	
}
