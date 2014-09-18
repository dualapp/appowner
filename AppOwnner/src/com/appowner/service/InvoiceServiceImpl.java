package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.InvoiceDao;
import com.appowner.model.InvoiceTransaction;
@Service("InvoiceService")
@Transactional 
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	private  InvoiceDao invoiceDao;

	
	public  InvoiceDao getInvoiceDao() {
		return invoiceDao;
	}
	public void setInvoiceDao(InvoiceDao invoiceDao) {
		this.invoiceDao = invoiceDao;
	}
	public List<String> getInvoiceName()
	{
		return getInvoiceDao().getInvoiceName();
	}
	public void saveInvoiceTransaction(InvoiceTransaction invoice)
	{
		 getInvoiceDao().saveInvoiceTransaction(invoice);
	}
	public String taxList(String select)
	{   System.out.println(select);
		return getInvoiceDao().taxList(select);
	}
	public List<String> getTaxList(String str)
	{
		return getInvoiceDao().getTaxList(str);
	}
	public List<InvoiceTransaction> listInvoiceTransaction()
	{
		return getInvoiceDao().listInvoiceTransaction();
	}
	public List<String> getBlockList(String str_Organisation)
	{
		return getInvoiceDao().getBlockList(str_Organisation);
	}
	public List<String> getApartmentlist(String str_Block)
	{
		return getInvoiceDao().getApartmentlist(str_Block);
	}
	  public double getTaxAmount(String str1)
	  {   System.out.println(str1);
		  return getInvoiceDao().getTaxAmount(str1);
	  }
	  public double getSqft(String str)
	  {
		  return getInvoiceDao().getSqft(str);
	  }
	  public String getmailid(String str_ApartmentNo)
	  {
		  return getInvoiceDao().getmailid(str_ApartmentNo);
	  }
	  public List<String> getAccountName()
	  {
		  return getInvoiceDao().getAccountName();
	  }
	  public void updatePayment(String accountName, String str_Status, Integer id,String dat_InvoiceDate)
	  {
		   getInvoiceDao().updatePayment(accountName,str_Status,id,dat_InvoiceDate);
	  }
}
