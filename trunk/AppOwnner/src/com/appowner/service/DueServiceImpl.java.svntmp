package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.DueDao;
import com.appowner.model.DueTransaction;

@Service("DueService")
@Transactional 
public class DueServiceImpl implements DueService{
	@Autowired
	private DueDao dueDao;

	public DueDao getDueDao() {
		return dueDao;
	}

	public void setDueDao(DueDao dueDao) {
		this.dueDao = dueDao;
	}
	public List<String> getAccountsList()
	{
		return getDueDao().getAccountsList();
	}

	public List<String> getDueTemplate()
	{
		return getDueDao().getDueTemplate();
	}
	public List<DueTransaction> listDueTransaction(){
		return getDueDao().listDueTransaction();
	}

	
	public void saveDueTransaction(DueTransaction due) {
		getDueDao().saveDueTransaction(due);
		
	}
	public List<String> getBlockList(String str_Organisation)
	{
		return getDueDao().getBlockList(str_Organisation);
	}
	public List<String> getApartmentlist(String str_Block)
	{
		return getDueDao().getApartmentlist(str_Block);
	}
	

}
