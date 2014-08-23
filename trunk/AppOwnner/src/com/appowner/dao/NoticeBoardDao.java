package com.appowner.dao;

import java.util.List;

import com.appowner.model.Notice;

public interface NoticeBoardDao {
	public void addNotice(Notice notice); 
	 public List<Notice> listNotices();
	 public List<String> getmailids();
}
