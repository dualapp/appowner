package com.appowner.service;

import java.util.List;

import com.appowner.model.Notice;

public interface NoticeBoardService {
	public void addNotice(Notice notice); 
	  public List<Notice> listNotices(int firstRow, int rowPerPage, String str_Visible);
	  public List<String> getmailids();
	 
	public Integer count();
}
