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
	  public List<Notice> listNotices(int firstRow, int rowPerPage,String str_Visible)
	  {
		  return  getNoticeBoardDao().listNotices( firstRow,  rowPerPage,str_Visible);  
	  }
	  public List<String> getmailids()
	  {
		  return  getNoticeBoardDao().getmailids();  
	  }
	 
	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return getNoticeBoardDao().count();
	}
	public Notice getNotice(int id)
	{
		return getNoticeBoardDao().getNotice(id);
	}
	public void updateNotice(Notice notice)
	{
		getNoticeBoardDao().updateNotice(notice);
	}
	 
}
