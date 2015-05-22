package com.appowner.service;

import java.util.Date;
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
	{ 
		return getInvoiceDao().taxList(select);
	}
	public List<String> getTaxList(String str)
	{
		return getInvoiceDao().getTaxList(str);
	}
	public List<InvoiceTransaction> listInvoiceTransaction(String str_InvoiceTemplate, String str_Block, String str_ApartmentNo, String str_Status, String str_BillPeriod)
	{
		return getInvoiceDao().listInvoiceTransaction(str_InvoiceTemplate,str_Block,str_ApartmentNo,str_Status,str_BillPeriod);
	}
	public List<InvoiceTransaction> listInvoiceTransaction1(String str_InvoiceTemplate, String str_Block, String str_ApartmentNo,
			Integer int_Year, String str_BillPeriod)
			{
		return getInvoiceDao().listInvoiceTransaction1(str_InvoiceTemplate,str_Block,str_ApartmentNo,int_Year,str_BillPeriod);
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
	  { 
		  return getInvoiceDao().getTaxAmount(str1);
	  }
	  public double getTaxExceptionAmount(String str1)
	  {
		  return getInvoiceDao().getTaxExceptionAmount(str1);
	  }
	  public double getSqft(String str)
	  {
		  return getInvoiceDao().getSqft(str);
	  }
	  public List<String> getmailid(String str_ApartmentNo, String BlockNo)
	  {
		  return (List<String>)getInvoiceDao().getmailid(str_ApartmentNo,BlockNo);
	  }
	  public List<String> getAccountName()
	  {
		  return getInvoiceDao().getAccountName();
	  }
	  public void updatePayment(String accountName,String paymentMode, double totalBalance, double dueBalance, String str_Status, Integer id, Date dat_InvoiceDate, Date payment_Date, Integer payment_No, String deposite_Account_Name)

	  {
		   getInvoiceDao().updatePayment(accountName,paymentMode,totalBalance,dueBalance,str_Status,id,dat_InvoiceDate,payment_Date,payment_No,deposite_Account_Name);
	  }
	  public InvoiceTransaction getInvoice(Integer int_InvoiceTransactionID)
	  {
		  return getInvoiceDao().getInvoice(int_InvoiceTransactionID);
	  }
	  public double getAmount(Integer id)
	  {
		  return getInvoiceDao().getAmount(id);
	  }
	  public void deleteInvoice(Integer id)
	  {
		  getInvoiceDao().deleteInvoice(id);
	  }
	  public List<String> getlistAccountName()
	  {
		return   getInvoiceDao().getlistAccountName();
	  }
	  public void deleteDues(String str)
	  {
		  getInvoiceDao().deleteDues(str);
	  }
	  public String getStatus(int id)
	  {
		  return getInvoiceDao().getStatus(id);
	  }
	  public String getPeriod(String select)
	  {
		  return getInvoiceDao().getPeriod(select);
	  }
	  public List<Double> getOutstandingBalance()
	  {
		  return getInvoiceDao().getOutstandingBalance();
	  }
	  public String getUserName(String str_Block, String str_ApartmentNo)
	  {
		  return getInvoiceDao().getUserName(str_Block,str_ApartmentNo);
	  }
	  public String getDescription(String str_InvoiceTemplate)
	  {
		  return getInvoiceDao().getDescription(str_InvoiceTemplate);
	  }
	  public List<InvoiceTransaction> listInvoiceTransaction(String query)
	  {
		  return getInvoiceDao().listInvoiceTransaction(query);
	  }
	  public List<InvoiceTransaction> listInvoiceTransaction()
	  {
		  return getInvoiceDao().listInvoiceTransaction();
	  }
				
}
