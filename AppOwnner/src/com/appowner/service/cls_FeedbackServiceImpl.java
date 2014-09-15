package com.appowner.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.cls_FeedbackDao;
import com.appowner.model.cls_Feedback;


@Service("cls_FeedbackService")
@Transactional 
public class cls_FeedbackServiceImpl implements cls_FeedbackService {

	@Autowired
	private cls_FeedbackDao feedbackDao;

	public cls_FeedbackDao getFeedbackDao() {
		return feedbackDao;
	}

	public void setFeedbackDao(cls_FeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

	@Override
	public List<cls_Feedback> listFeedbacks() {
		return getFeedbackDao().listFeedbacks();
	}

	@Override
	public void addFeedback(cls_Feedback feedback) {
		getFeedbackDao().addFeedback(feedback);
		
	}

	@Override
	public void deleteFeedback1(cls_Feedback feedback) {
		getFeedbackDao().deleteFeedback1(feedback);
	}

	@Override
	public cls_Feedback getFeedback1(Integer feedbackId) {
		return feedbackDao.getFeedback1(feedbackId);
	}

	@Override
	public void update(cls_Feedback feedback) {
		getFeedbackDao().update(feedback);
	}

	@Override
	public List<String> var_feedbacktopicnamelist() {
		// TODO Auto-generated method stub
		return getFeedbackDao().var_feedbacktopicnamelist();
	}

	@Override
	public List<String> var_satisfactionnamelist() {
		// TODO Auto-generated method stub
		return getFeedbackDao().var_satisfactionnamelist();
	}

	 
	
	
}
