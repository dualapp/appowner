package com.appowner.dao;

import java.util.List;

import com.appowner.model.Notice;

public interface NoticeBoardDao {
	public void addNotice(Notice notice); 
	 public List<Notice> listNotices(int firstRow, int rowPerPage, String str_Visible);
	 public List<String> getmailids();
	 
	public Integer count();
	public Notice getNotice(int id);
	public void updateNotice(Notice notice);
	public List<Notice> listArchieveNotices(String str_Visible);
}
