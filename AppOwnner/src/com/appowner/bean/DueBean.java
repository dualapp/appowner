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

import com.appowner.model.DueTransaction;
import com.appowner.service.DueService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped
public class DueBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{DueService}")
			private DueService dueService;
	public DueService getDueService() {
		return dueService;
	}
	public void setDueService(DueService dueService) {
		this.dueService = dueService;
	}
	private Integer int_DueTransactionID;
	private String str_Accounts;
	private String str_DueTemplate;
	private String str_Period;
	private Integer int_Year;
	private String str_InitiatedOn;
	private Date dat_LastDate;
	private String str_Organisation;
	public String getStr_Status() {
		return str_Status;
	}
	public void setStr_Status(String str_Status) {
		this.str_Status = str_Status;
	}
	private String str_Block;
	private String str_ApartmentNo;
	private String str_Status;
	private Double dbl_DueAmount;
	private Double dbl_TotalDueAmount;
	public Integer getInt_DueTransactionID() {
		return int_DueTransactionID;
	}
	public void setInt_DueTransactionID(Integer int_DueTransactionID) {
		this.int_DueTransactionID = int_DueTransactionID;
	}
	public String getStr_Accounts() {
		return str_Accounts;
	}
	public void setStr_Accounts(String str_Accounts) {
		this.str_Accounts = str_Accounts;
	}
	public String getStr_DueTemplate() {
		return str_DueTemplate;
	}
	public void setStr_DueTemplate(String str_DueTemplate) {
		this.str_DueTemplate = str_DueTemplate;
	}
	public String getStr_Period() {
		return str_Period;
	}
	public void setStr_Period(String str_Period) {
		this.str_Period = str_Period;
	}
	public Integer getInt_Year() {
		return int_Year;
	}
	public void setInt_Year(Integer int_Year) {
		this.int_Year = int_Year;
	}
	public String getStr_InitiatedOn() {
		java.util.Date d=new java.util.Date();
		 SimpleDateFormat ft = 
			      new SimpleDateFormat ("dd-MM-yyyy");
		String str=ft.format(d);
		
		return str;
	}
	public void setStr_InitiatedOn(String str_InitiatedOn) {
		this.str_InitiatedOn = str_InitiatedOn;
	}
	public Date getDat_LastDate() {
		return dat_LastDate;
	}
	public void setDat_LastDate(Date dat_LastDate) {
		this.dat_LastDate = dat_LastDate;
	}
	public String getStr_Organisation() {
		str_Organisation=Util.getApartmentName();
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
	public Double getDbl_DueAmount() {
		return dbl_DueAmount;
	}
	public void setDbl_DueAmount(Double dbl_DueAmount) {
		this.dbl_DueAmount = dbl_DueAmount;
	}
	public Double getDbl_TotalDueAmount() {
		return dbl_TotalDueAmount;
	}
	public void setDbl_TotalDueAmount(Double dbl_TotalDueAmount) {
		this.dbl_TotalDueAmount = dbl_TotalDueAmount;
	}
	private List<String> str_Account;
	public List<String> getStr_Account() {
		str_Account=new ArrayList<String>();
		str_Account.addAll(getDueService().getAccountsList());
		return str_Account;
	}
	public void setStr_Account(List<String> str_Account) {
		this.str_Account = str_Account;
	}private List<String> str_DueTemplates;
	public List<String> getStr_DueTemplates() {
		str_DueTemplates=new ArrayList<String>();
		str_DueTemplates.addAll(getDueService().getDueTemplate());
		return str_DueTemplates;
	}
	public void setStr_DueTemplates(List<String> str_DueTemplates) {
		this.str_DueTemplates = str_DueTemplates;
	}
	public String addDueTransaction()
	{
		try
		{
			DueTransaction due=new DueTransaction();
			due.setStr_Accounts(getStr_Accounts());
			due.setStr_DueTemplate(getStr_DueTemplate());
			due.setStr_Period(getStr_Period());
			due.setInt_Year(getInt_Year());
			due.setStr_InitiatedOn(getStr_InitiatedOn());
			due.setDat_LastDate(getDat_LastDate());
			due.setStr_Organisation(str_Organisation);
			due.setStr_Block(getStr_Block());
			due.setStr_ApartmentNo(getStr_ApartmentNo());
			due.setDbl_DueAmount(getDbl_DueAmount());
			due.setDbl_TotalDueAmount(getDbl_TotalDueAmount());
			getDueService().saveDueTransaction(due);
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public List<DueTransaction> getListDueTransaction() {
		listDueTransaction=new ArrayList<DueTransaction>();
		listDueTransaction.addAll(getDueService().listDueTransaction());
		return listDueTransaction;
	}
	public void setListDueTransaction(List<DueTransaction> listDueTransaction) {
		this.listDueTransaction = listDueTransaction;
	}
	private List<DueTransaction> listDueTransaction;
	private List<String> str_Blocks;
	public List<String> getStr_Blocks() {
		str_Blocks=new ArrayList<String>();
		str_Blocks.addAll(getDueService().getBlockList(str_Organisation));
		return str_Blocks;
	}
	public void setStr_Blocks(List<String> str_Blocks) {
		this.str_Blocks = str_Blocks;
	}
	private List<String> str_BlockNo;
	public List<String> getStr_BlockNo() {
		return str_BlockNo;
	}
	public void setStr_BlockNo(List<String> str_BlockNo) {
		this.str_BlockNo = str_BlockNo;
	}
	public List<String> blockChangeListener(ValueChangeEvent event)
	{   str_Block=(String)event.getNewValue();
		str_BlockNo=new ArrayList<String>();
		str_BlockNo.addAll(getDueService().getApartmentlist(str_Block));
		return str_BlockNo;
	}
}
