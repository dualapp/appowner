package com.appowner.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTransaction;
import com.appowner.service.InvoiceService;

@ManagedBean
@ViewScoped
public class InvoiceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{InvoiceService}")
			private InvoiceService invoiceService;
	public InvoiceService getInvoiceService() {
		return invoiceService;
	}
	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	private Integer int_InvoiceTransactionID;
	private String str_InvoiceTemplate;
	private String str_BillPeriod;
	private Integer int_Year;
	private String dat_InvoiceDate;
	public String select;
	
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public Integer getInt_InvoiceTransactionID() {
		return int_InvoiceTransactionID;
	}
	public void setInt_InvoiceTransactionID(Integer int_InvoiceTransactionID) {
		this.int_InvoiceTransactionID = int_InvoiceTransactionID;
	}
	public String getStr_InvoiceTemplate() {
		return str_InvoiceTemplate;
	}
	public void setStr_InvoiceTemplate(String str_InvoiceTemplate) {
		this.str_InvoiceTemplate = str_InvoiceTemplate;
	}
	public String getStr_BillPeriod() {
		return str_BillPeriod;
	}
	public void setStr_BillPeriod(String str_BillPeriod) {
		this.str_BillPeriod = str_BillPeriod;
	}
	public Integer getInt_Year() {
		return int_Year;
	}
	public void setInt_Year(Integer int_Year) {
		this.int_Year = int_Year;
	}

	public String getDat_InvoiceDate() {
		java.util.Date d=new java.util.Date();
		 SimpleDateFormat ft = 
			      new SimpleDateFormat ("dd-MM-yyyy");
		String str=ft.format(d);
		
		return str;
	}
	public void setDat_InvoiceDate(String dat_InvoiceDate) {
		this.dat_InvoiceDate = dat_InvoiceDate;
	}
	
	public String getStr_Organisation() {
		return str_Organisation;
	}
	public void setStr_Organisation(String str_Organisation) {
		this.str_Organisation = str_Organisation;
	}
	public String getStr_Block() {
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public String getStr_ApartmentNo() {
		return str_ApartmentNo;
	}
	public void setStr_ApartmentNo(String str_ApartmentNo) {
		this.str_ApartmentNo = str_ApartmentNo;
	}
	private Date dat_DueDate;
	public Date getDat_DueDate() {
		return dat_DueDate;
	}
	public void setDat_DueDate(Date dat_DueDate) {
		this.dat_DueDate = dat_DueDate;
	}
	private String str_Organisation;
	private String str_Block;
	private String str_ApartmentNo;
	private List<String> listInvoiceName;
	public List<String> getListInvoiceName() {
		listInvoiceName=new ArrayList<String>();
		listInvoiceName.addAll(getInvoiceService().getInvoiceName());
		return listInvoiceName;
	}
	public void setListInvoiceName(List<String> listInvoiceName) {
		this.listInvoiceName = listInvoiceName;
	}
	private InvoiceTransaction iinvoice;
	public InvoiceTransaction getIinvoice() {
		return iinvoice;
	}
	public void setIinvoice(InvoiceTransaction iinvoice) {
		this.iinvoice = iinvoice;
	}
	public String addInvoiceTransaction()
	{
		try{
			InvoiceTransaction invoice=new InvoiceTransaction();
			invoice.setStr_InvoiceTemplate(getStr_InvoiceTemplate());
			invoice.setStr_BillPeriod(getStr_BillPeriod());
			invoice.setInt_Year(getInt_Year());
			invoice.setDat_InvoiceDate(getDat_InvoiceDate());
			invoice.setDat_DueDate(dat_DueDate);
			invoice.setStr_Organisation(getStr_Organisation());
			invoice.setStr_Block(getStr_Block());
			invoice.setStr_ApartmentNo(getStr_ApartmentNo());
			getInvoiceService().saveInvoiceTransaction(invoice);
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	private String str_DueTemplate;
	private String str_TaxTemplate;
public String getStr_DueTemplate() {
		return str_DueTemplate;
	}
	public void setStr_DueTemplate(String str_DueTemplate) {
		this.str_DueTemplate = str_DueTemplate;
	}
	public String getStr_TaxTemplate() {
		return str_TaxTemplate;
	}
	public void setStr_TaxTemplate(String str_TaxTemplate) {
		this.str_TaxTemplate = str_TaxTemplate;
	}
private List<String> listDues;
	
	public List<String> getListDues() {
		
		return listDues;
	}
	public void setListDues(List<String> listDues) {
		this.listDues = listDues;
	}
	public List<String> selectRadioButton(ValueChangeEvent event)
	{   System.out.println("hi");
		select =( String )event.getNewValue();
         System.out.println(select);
       
	    if(select.equals(getSelect()))
	    {    listDues = new ArrayList<String>();
	        listDues.addAll(getInvoiceService().taxList());
		   System.out.println(listDues);
	    	return listDues;
	    }
	    else
	    {
	    	listDues=new ArrayList<String>();
	    	return listDues;
	    }
	      
	}
}
