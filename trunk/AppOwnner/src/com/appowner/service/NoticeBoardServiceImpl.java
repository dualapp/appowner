package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.NoticeBoardDao;
import com.appowner.model.Notice;

@Service("NoticeBoardService")
@Transactional 
public class NoticeBoardServiceImpl implements NoticeBoardService{
	@Autowired
	private NoticeBoardDao noticeBoardDao;
	public NoticeBoardDao getNoticeBoardDao() {
		return noticeBoardDao;
	}
	public void setNoticeBoardDao(NoticeBoardDao noticeBoardDao) {
		this.noticeBoardDao = noticeBoardDao;
	}
	public void addNotice(Notice notice)
	{
		getNoticeBoardDao().addNotice(notice);
	}
	  public List<Notice> listNotices()
	  {
		  return  getNoticeBoardDao().listNotices();  
	  }
}
