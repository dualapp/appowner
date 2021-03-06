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

	public List<String> getDueTemplate(String ddd)
	{
		return getDueDao().getDueTemplate(ddd);
	}
	public List<DueTransaction> listDueTransaction(String str_DueTemplate, String str_Block, String str_ApartmentNo, String str_Period, String str_Status)
	{
		return getDueDao().listDueTransaction(str_DueTemplate,str_Block,str_ApartmentNo,str_Period,str_Status);
	}
	public List<DueTransaction> listDueTransaction1(String str_DueTemplate, String str_Block, String str_ApartmentNo,String str_BillPeriod, Integer int_Year)
	{
		return getDueDao().listDueTransaction1(str_DueTemplate,str_Block,str_ApartmentNo,str_BillPeriod,int_Year);	
	}
	
	public Integer saveDueTransaction(DueTransaction due)
	{
		 return getDueDao().saveDueTransaction(due);
		
		
	}
	public List<String> getBlockList(String str_Organisation)
	{
		return getDueDao().getBlockList(str_Organisation);
	}
	public List<String> getApartmentlist(String str_Block)
	{
		return getDueDao().getApartmentlist(str_Block);
	}
	public List<DueTransaction> listUserDueTransaction(String query)

	{
		return getDueDao().listUserDueTransaction(query);
	}
	public DueTransaction getUserDueTransaction(Integer int_DueTransactionID)
	{
		return getDueDao().getUserDueTransaction(int_DueTransactionID);
	}
	public double getDueAmount(String str_Block, String str_DueTemplate)
	{
		return getDueDao().getDueAmount(str_Block,str_DueTemplate);
	}
	public List <String> listRavenues()
	{
		return getDueDao().listRavenues();
	}

	public List<Integer> getDueTemplate1(String invoiceNo)
	{
		return getDueDao().getDueTemplate1(invoiceNo);
	}
	public double getDueAmount1(Integer str1)
	{
		return getDueDao().getDueAmount1(str1);
	}
	public void updateDueTransaction(String str_Status, Integer str1, double dueAmount, double paidAmount1)
	{
		getDueDao().updateDueTransaction(str_Status,str1,dueAmount,paidAmount1);
	}
	public void deleteDues(Integer id)
	{
		getDueDao().deleteDues(id);
	}
	public String getFrequency(String ddd)
	{
		return getDueDao().getFrequency(ddd);
	}
	public void updateDue(Integer id, String int_InvoiceNo)
	{
		getDueDao().updateDue(id,int_InvoiceNo);
	}
	public boolean getInvoiceNo(Integer id)
	{
		return getDueDao().getInvoiceNo(id);
	}
	public DueTransaction getDueTransaction(Integer int_DueTransactionID)
	{
		return getDueDao().getDueTransaction(int_DueTransactionID);
	}
	public List<DueTransaction> listDueTransaction(String query)
	{
		return getDueDao().listDueTransaction(query);
	}
}
