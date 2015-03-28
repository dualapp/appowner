package com.appowner.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.RandomStringUtils;
import org.primefaces.component.datatable.DataTable;

import com.appowner.model.DueTemplate;
import com.appowner.model.DueTransaction;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;
import com.appowner.service.DueService;
import com.appowner.service.InvoiceService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped
public class InvoiceBean  extends RuntimeException implements Serializable  {
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
	private Date dat_InvoiceDate;
	private String str_Status;
	private String int_InvoiceNo;
	private Integer int_Admin_ID;
	private String paymentMode;
	
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Integer getInt_Admin_ID() {
		int_Admin_ID=Util.getUserId();
		return int_Admin_ID;
	}
	public void setInt_Admin_ID(Integer int_Admin_ID) {
		this.int_Admin_ID = int_Admin_ID;
	}
	private String deposite_Account_Name;
	
	public String getDeposite_Account_Name() {
		return deposite_Account_Name;
	}
	public void setDeposite_Account_Name(String deposite_Account_Name) {
		this.deposite_Account_Name = deposite_Account_Name;
	}
	public InvoiceBean()
	{
		
	}
	public InvoiceBean(String msg)
	{
		super(msg);
	}
	
	public String getInt_InvoiceNo() {
		return int_InvoiceNo;
	}
	public void setInt_InvoiceNo(String int_InvoiceNo) {
		this.int_InvoiceNo = int_InvoiceNo;
	}
	public String getStr_Status() {
		
		return str_Status;
	}
	public void setStr_Status(String str_Status) {
		this.str_Status = str_Status;
	}
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

	public Date getDat_InvoiceDate() {
		dat_InvoiceDate=new java.util.Date();
		
		
		return dat_InvoiceDate;
	}
	
	private double outstandingBalance=0.00;
	public double getOutstandingBalance() {
	List<Double> outstandingBalance1=getInvoiceService().getOutstandingBalance();
		ListIterator list=outstandingBalance1.listIterator();
		outstandingBalance=0.00;
		while(list.hasNext())
		{
			double amount=(double)list.next();
			System.out.println(amount+"hjjhmjj");
			outstandingBalance=outstandingBalance+amount;
		}
		return outstandingBalance;
	}
	
	
	private double dueBalance;
	public double getDueBalance() {
		return dueBalance;
	}
	public void setDueBalance(double dueBalance) {
		this.dueBalance = dueBalance;
	}
	
	

	public void setDat_InvoiceDate(Date dat_InvoiceDate) {
		this.dat_InvoiceDate = dat_InvoiceDate;
	}
	public String getStr_Organisation() {
		str_Organisation=Util.getAppartmentName();
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
	private static  List<Double> tax1;
	
	public static String getTax1() {
		StringBuilder out = new StringBuilder();
		for (Object o : tax1)
		{
		  out.append(o.toString());
		  out.append(",");
		}
		System.out.println(out.toString()+"tax1");
		return out.toString();
	}
	public static void setTax1(List<Double> tax1) {
		InvoiceBean.tax1 = tax1;
	}
	public InvoiceTransaction getIinvoice() {
		return iinvoice;
	}
	public void setIinvoice(InvoiceTransaction iinvoice) {
		this.iinvoice = iinvoice;
	}
	private static String subject="subject";
	private static String content="content";
	private static List<String> mailid;
	
	public static String getMailid() {
		StringBuilder out = new StringBuilder();
		for (Object o : mailid)
		{
		  out.append(o.toString());
		  out.append(",");
		}
		return out.toString();
			
		
	}
	
	public static void setMailid(List<String> mailid) {
		InvoiceBean.mailid = mailid;
	}
	public static String getSubject() {
		return subject;
	}
	public static void setSubject(String subject) {
		InvoiceBean.subject = subject;
	}
	public static String getContent() {
		return content;
	}
	public static void setContent(String content) {
		InvoiceBean.content = content;
	}
	public void getTaxTemplate1(String str)
	{
		System.out.println("gfgfkjgkjkjgh555555555555555555555555555555555");
	}
	 private static String InvoiceNo="invoiceNo";
	   
	    private static java.util.Date Date;
	    private static List<Double> amount;
	    private static List<Double> tax;
	    private static Double due;
	    private static Date date1;
	    public static String Dues;
	    public static String taxname;
	    private static Double subtotal;
	
		
		public static Double getSubtotal() {
			return subtotal;
		}
		public static void setSubtotal(Double subtotal) {
			InvoiceBean.subtotal = subtotal;
		}
		public static String getTaxname() {
			return taxname;
		}
		public static void setTaxname(String taxname) {
			InvoiceBean.taxname = taxname;
		}
		public static String getDues() {
			return Dues;
		}
		public static void setDues(String dues) {
			Dues = dues;
		}
		private static String organisation="organisation";
	public static String getOrganisation() {
			return organisation;
		}
		public static void setOrganisation(String organisation) {
			InvoiceBean.organisation = organisation;
		}
	public static Date getDate1() {
			return date1;
		}
		public static void setDate1(Date date1) {
			InvoiceBean.date1 = date1;
		}
	public static String getInvoiceNo() {
			return InvoiceNo;
		}
		public static void setInvoiceNo(String invoiceNo) {
			InvoiceNo = invoiceNo;
		}
	

		
		
	
		
		public static java.util.Date getDate() {
			return Date;
		}
		public static void setDate(java.util.Date date) {
			Date = date;
		}
		
		public static String getAmount() {
			StringBuilder out = new StringBuilder();
			for (Object o : amount)
			{
			  out.append(o.toString());
			  out.append(",");
			}
			System.out.println(out.toString());
			return out.toString();
			
		}
		public static void setAmount(List<Double> amount) {
			InvoiceBean.amount = amount;
		}
		
		public static String getTax() {
			StringBuilder out = new StringBuilder();
			for (Object o : tax)
			{
			  out.append(o.toString());
			  out.append(",");
			}
			System.out.println(out.toString()+"tax");
			return out.toString();
			
		}
		public static void setTax(List<Double> tax) {
			InvoiceBean.tax = tax;
		}
		public static Double getDue() {
			return due;
		}
		public static void setDue(Double due) {
			InvoiceBean.due = due;
		}
		private static List<String> transaction1;
	
	
	public static List<String> getTransaction1() {
			return transaction1;
		}
		public static void setTransaction1(List<String> transaction1) {
			InvoiceBean.transaction1 = transaction1;
		}
		
		private static String date3;
	public static String getDate3() {
		java.util.Date d=new java.util.Date();
		 SimpleDateFormat ft = 
			      new SimpleDateFormat ("dd-MM-yyyy");
		//String str=ft.format(d);
		 Calendar c = Calendar.getInstance(); 
		 c.setTime(d); 
		 c.add(Calendar.DATE, 10);
		 d= c.getTime();
		 String str=ft.format(d);
			
			return str;
		
		}
		public static void setDate3(String date3) {
			InvoiceBean.date3 = date3;
		}
		private static String billperiod;
	public static String getBillperiod() {
			return billperiod;
		}
		public static void setBillperiod(String billperiod) {
			InvoiceBean.billperiod = billperiod;
		}
		private static String block;
		private static String apartmentNo;;
		private static Integer year;
	public static String getBlock() {
			return block;
		}
		public static void setBlock(String block) {
			InvoiceBean.block = block;
		}
		public static String getApartmentNo() {
			return apartmentNo;
		}
		public static void setApartmentNo(String apartmentNo) {
			InvoiceBean.apartmentNo = apartmentNo;
		}
	public static Integer getYear() {
			return year;
		}
		public static void setYear(Integer year) {
			InvoiceBean.year = year;
		}
		@ManagedProperty(value = "#{DueService}")
		private DueService dueService;
public DueService getDueService() {
	return dueService;
}
public void setDueService(DueService dueService) {
	this.dueService = dueService;
}
private static  List<Integer> dueID=new ArrayList<Integer>();
	
	public static List<Integer> getDueID() {
	return dueID;
}
	private Integer int_Organisation;
public Integer getInt_Organisation() {
	int_Organisation=Util.getAppartmentId();
		return int_Organisation;
	}
	public void setInt_Organisation(Integer int_Organisation) {
		this.int_Organisation = int_Organisation;
	}
public static void setDueID(List<Integer> dueID) {
	InvoiceBean.dueID = dueID;
}
public List<DueTransaction> getListDueTransaction() {
	listDueTransaction=new ArrayList<DueTransaction>();
	listDueTransaction.addAll(getDueService().listDueTransaction1(str_DueTemplate,str_Block,str_ApartmentNo,str_BillPeriod,int_Year));
	System.out.println(listDueTransaction+"jjkjkkj");
	return listDueTransaction;
}
public void setListDueTransaction(List<DueTransaction> listDueTransaction) {
	this.listDueTransaction = listDueTransaction;
}
private DueTransaction due1=new DueTransaction();
public DueTransaction getDue1() {
	return due1;
}
public void setDue1(DueTransaction due1) {
	this.due1 = due1;
}
private static String notes;
public static String getNotes() {
	return notes;
}
public static void setNotes(String notes) {
	InvoiceBean.notes = notes;
}
private static String username;
public static String getUsername() {
	return username;
}
public static void setUsername(String username) {
	InvoiceBean.username = username;
}
public void datechangeListener(ValueChangeEvent event)
{   System.out.println("jhjhjj");
dat_DueDate=(Date)event.getNewValue();
	System.out.println(dat_DueDate+"gjkfg");
	
}
private List<DueTransaction> listDueTransaction;
	public String addInvoiceTransaction()
	{   
		try{
			InvoiceTransaction invoice=new InvoiceTransaction();
			invoice.setStr_InvoiceTemplate(getStr_InvoiceTemplate());
			invoice.setStr_BillPeriod(getStr_BillPeriod());
			invoice.setInt_Year(getInt_Year());
			invoice.setDat_InvoiceDate(dat_InvoiceDate);
		     System.out.println(dat_DueDate+"dfkjfjkdfgkjfgkjgf");
			invoice.setDat_DueDate(dat_DueDate);
			invoice.setInt_Admin_ID(getInt_Admin_ID());
			System.out.println(bl_Show+"kjfkjgkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
			invoice.setInt_Organisation(getInt_Organisation());
			invoice.setStr_Block(getStr_Block());
			invoice.setStr_ApartmentNo(getStr_ApartmentNo());
			invoice.setInt_InvoiceNo(randomId());
			invoice.setSubTotal(getSubTotal());
			invoice.setTaxAmount(getTaxAmount2());
			invoice.setTotalDue(getTotalDue());
		    invoice.setDueBalance(getTotalDue());
			invoice.setTotalBalance(getTotalDue());
			invoice.setStr_Status("Due");
			invoice.setPaidBalance(dueBalance);
			
			
			 listDues=getInvoiceService().taxList(select);
		       System.out.println(listDues); 
		        
		          String[] strArray = listDues.split(",");
		        for (String str : strArray) 
		        {	 str_DueTemplate=str;
		             getListDueTransaction();
		 			System.out.println(listDueTransaction.listIterator().hasNext());
		 			if(listDueTransaction.listIterator().hasNext())
		 			{    Integer id=listDueTransaction.listIterator().next().getInt_DueTransactionID();
		 			     System.out.println(id+"hhjhj");
		 			     System.out.println(int_InvoiceNo+"hjhjjjk");
		 				due1.setInt_InvoiceNo(int_InvoiceNo);
		 			
		 			     due1.setInt_DueTransactionID(id);
		 			    getDueService().updateDue(id,int_InvoiceNo);
		 			}
		 			else{
		 				 due1.setStr_DueTemplate(str);
			            
		               due1.setStr_InitiatedOn(getDat_InvoiceDate());	
		              due1.setDat_LastDate(dat_DueDate);
		              due1.setStr_ApartmentNo(str_ApartmentNo);
		              due1.setStr_Block(str_Block);
		             due1.setDbl_TotalDueAmount(totalAmount);
		              due1.setStr_Status("Due");
		              due1.setStr_Period(str_BillPeriod);
		              due1.setInt_Year(getInt_Year());
		             due1.setInt_InvoiceNo(int_InvoiceNo);
		             due1.setStr_Organisation(int_Organisation);
		             due1.setDbl_DueAmount(totalAmount);
		          Integer id=getDueService().saveDueTransaction(due1);  
		          System.out.println(id);
		          dueID.add(id);
		 			}
		 			
		        } 
		        getInvoiceService().saveInvoiceTransaction(invoice);
			
			  if(bl_Show==true)
				{
					 mailid=getInvoiceService().getmailid(str_Block,str_ApartmentNo);
					 System.out.println(mailid+"flkgkllkf");
					 notes=getInvoiceService().getDescription(getStr_InvoiceTemplate());
					System.out.println("kdfkdfkjkjfkfj");
					subject="Invoice posted for your Apartment";
					content="";
					username=userName;
					InvoiceNo=int_InvoiceNo;
					Date=dat_InvoiceDate;
					date1=getDat_DueDate();
					amount=totalAmounts;
					System.out.println(amount+"kvcvjvkj");
					tax=tax2;
					tax1=taxAmounts; 
					due=getTotalDue();
					date3=getDate3();
					block=getStr_Block();
					subtotal=getSubTotal();
					apartmentNo=getStr_ApartmentNo();
					billperiod=getStr_BillPeriod();
					year=getInt_Year();
					organisation=getStr_Organisation();
					transaction1=transaction;
				System.out.println("kifglkfgf");
					return "/AfrteLoginViews/Accounting/invoice1.jsp";
				
				}
			  System.out.println("vfgjgfvfjfjk");
				return "invoice.xhtml";
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("hjjhhjhjhhjhjhjh");
		return "invoice.xhtml";
	}
	
	/*
	 * Random number
	 */
	 
	
	 
	public String randomId()
	{
		
		  int_InvoiceNo=RandomStringUtils.randomNumeric(10);
	      System.out.println(int_InvoiceNo);
	 
		 
		return int_InvoiceNo;
	}
	private String str_DueTemplate;
	private String str_TaxTemplate;

	
    private List<String> dueList;
	public List<String> getDueList() {
		return dueList;
	}
	public void setDueList(List<String> dueList) {
		this.dueList = dueList;
	}
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
	private String listDues;
	
	
	public String getListDues() {
		return listDues;
	}
	public void setListDues(String listDues) {
		this.listDues = listDues;
	}
	private List<String> listTax;
	
	public List<String> getListTax() {
		return listTax;
	}
	public void setListTax(List<String> listTax) {
		this.listTax = listTax;
	}
	private String periodIndicator;
	public String getPeriodIndicator() {
		return periodIndicator;
	}
	public void setPeriodIndicator(String periodIndicator) {
		this.periodIndicator = periodIndicator;
	}
	public List<String> selectRadioButton(ValueChangeEvent event) throws InvoiceBean
	{  try{
		select =( String )event.getNewValue();
		System.out.println(select+"hhjjhjh");
		str_Block="";
		str_ApartmentNo="";
		str_BillPeriod="";
		int_Year=int_Year;
         dueList=new ArrayList<String>();
	    if(select.equals(getSelect()))
	    {
	        listDues=getInvoiceService().taxList(select);
	       System.out.println(listDues); 
	        
	        String[] strArray = listDues.split(",");
	        for (String str : strArray) {
	          
	         listTax=new ArrayList<String>();
	         listTax.addAll(getInvoiceService().getTaxList(str));
	        
	       
	        
	         dueList.addAll(listTax);
	        }
	       
          return dueList;

	       
	    }
	    else
	    { 
	    	 dueList=new ArrayList<String>();
	         return dueList;
	    }
	   
	}
	catch(Exception e)
	{
		throw new InvoiceBean("DueTemplate is not Present");
	}
	 finally
	    {
	    	 periodIndicator=getInvoiceService().getPeriod(select);
				System.out.println(periodIndicator+"jhjjkkj");
	    }

	}
	public void periodChangeListener(ValueChangeEvent event)
	{
		str_BillPeriod=(String)event.getNewValue();
		System.out.println(str_BillPeriod+"hjjjjjj");
	}
	private List<InvoiceTransaction> listInvoiceTransaction;
	private List<InvoiceTransaction>  listInvoiceTransaction1;
	public List<InvoiceTransaction> getListInvoiceTransaction1() {
		listInvoiceTransaction1=new ArrayList<InvoiceTransaction>();
		System.out.println(str_InvoiceTemplate+"priya234");
		listInvoiceTransaction1.addAll(getInvoiceService().listInvoiceTransaction1(str_InvoiceTemplate,str_Block,str_ApartmentNo,int_Year,str_BillPeriod));
		System.out.println(listInvoiceTransaction);
		
		return listInvoiceTransaction1;
	}
	public void setListInvoiceTransaction1(
			List<InvoiceTransaction> listInvoiceTransaction1) {
		this.listInvoiceTransaction1 = listInvoiceTransaction1;
	}
	public List<InvoiceTransaction> getListInvoiceTransaction() {
		listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
		System.out.println(str_InvoiceTemplate+"priya");
		listInvoiceTransaction.addAll(getInvoiceService().listInvoiceTransaction(str_InvoiceTemplate,str_Block,str_ApartmentNo,str_Status,str_BillPeriod));
		System.out.println(listInvoiceTransaction);
		return listInvoiceTransaction;
	}
	public void setListInvoiceTransaction(
			List<InvoiceTransaction> listInvoiceTransaction) {
		this.listInvoiceTransaction = listInvoiceTransaction;
	}
	@ManagedProperty(value ="#{loginBean}")
	private LoginBean loginBean;
	
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	private String CreatedBy;
	public String getCreatedBy() {
		CreatedBy=Util.getUserName();
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	private List<String> str_Blocks;
	public List<String> getStr_Blocks() {
		str_Blocks=new ArrayList<String>();
		 str_Blocks.addAll(getInvoiceService().getBlockList(str_Organisation));
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
	private  double totalAmount;
	

	
	

	
	
	public double getTotalAmount() {
		
		System.out.println(select1+"gjkgkjfgkj");
		if(select1==null)
				{
			return totalAmount;
				}
		else if(select1.equalsIgnoreCase("Full"))
		{
			totalAmount=totalAmount1;
		}
		else if(select1.equalsIgnoreCase("Partial"))
		{  totalAmount=0.00;
		   System.out.println(totalAmount+"dfjfjjfjj");
		}
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<String> organisationChangeListener(ValueChangeEvent event)
	{   String str=(String)event.getNewValue();
	    System.out.println(str);
	    if(str==Util.getAppartmentName())
	    {
	    	return str_Blocks;
	    }
		return null;
	}
	public List<String> blockChangeListener1(ValueChangeEvent event)
	{
		 str_Block=(String)event.getNewValue();
		 str_BlockNo=new ArrayList<String>();
			str_BlockNo.addAll(getInvoiceService().getApartmentlist(str_Block));
			return str_BlockNo;
	}
	public List<String> blockChangeListener(ValueChangeEvent event)
	{   str_Block=(String)event.getNewValue();
	   System.out.println(str_Block);
	   System.out.println(select+"jkgfkjggfgfgf");
	   if(select==null)
	   {FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Select InvoiceTemplate", "Select InvoiceTemplate"));
		  
	   }
	   else
	   {   
		str_BlockNo=new ArrayList<String>();
		str_BlockNo.addAll(getInvoiceService().getApartmentlist(str_Block));
		
	   }
	   return str_BlockNo;
	}
	private double taxAmount;
	 
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	private double subTotal=0.00;
	
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	private double taxAmount1;
	
	public double getTaxAmount1() {
		return taxAmount1;
	}
	public void setTaxAmount1(double taxAmount1) {
		this.taxAmount1 = taxAmount1;
	}
	private double totalDue=0.00;
	
	public double getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}
	private boolean bl_Show;
	
	public boolean isBl_Show() {
		return bl_Show;
	}
	public void setBl_Show(boolean bl_Show) {
		this.bl_Show = bl_Show;
	}
	private double taxAmount2=0.00;
	
	public double getTaxAmount2() {
		return taxAmount2;
	}
	public void setTaxAmount2(double taxAmount2) {
		this.taxAmount2 = taxAmount2;
	}
	private List<String> transaction;
	
	public List<String> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<String> transaction) {
		this.transaction = transaction;
	}
	private List<Double> totalAmounts;
	public List<Double> getTotalAmounts() {
		return totalAmounts;
	}
	public void setTotalAmounts(List<Double> totalAmounts) {
		this.totalAmounts = totalAmounts;
	}
	private List<Double> taxAmounts=new ArrayList<Double>();
	public List<Double> getTaxAmounts() {
		return taxAmounts;
	}
	public void setTaxAmounts(List<Double> taxAmounts) {
		this.taxAmounts = taxAmounts;
	}
	private List<Double> tax2;
	
	public List<Double> getTax2() {
		return tax2;
	}
	public void setTax2(List<Double> tax2) {
		this.tax2 = tax2;
	}
	private List<String> transaction2;
	public List<String> getTransaction2() {
		return transaction2;
	}
	public void setTransaction2(List<String> transaction2) {
		this.transaction2 = transaction2;
	}
	
	@SuppressWarnings("rawtypes")
	public List<String> amountCalculation(String fff,String ddd)
	{
		 {  try
		 {
	       
		    
		  
		    listDues=getInvoiceService().taxList(fff);
	       
	        
	        String[] strArray = listDues.split(",");
	        transaction2=new ArrayList<String>();
	        for (String str1 : strArray) {
	       
	         listTax=new ArrayList<String>();
	         listTax.addAll(getInvoiceService().getTaxList(str1));
	       
	       
	          transaction2.addAll(listTax);
	        }
		     ListIterator list=transaction2.listIterator();
		     totalAmounts=new ArrayList<Double>();
		     subTotal=0.00;
		     totalDue=0.00;
		     taxAmount2=0.00;
		     double taxexceptionAmount=0.00;
		     tax2=new ArrayList<Double>();
		     while(list.hasNext())
		     {
		    	 Object obj=list.next();
		    	 DueTemplate template=(DueTemplate)obj;
		    	 String str2=template.getStr_TaxTemplate();
		    	 System.out.println(str2);
		    	 String str3=template.getStr_Calculation();
		    	
		    	 if(str2.isEmpty())
		    	 {   System.out.println("dfjkfkjfdkj");
		    		 taxAmount=0.00; 
		    	 }
		    	 else if(str2.equalsIgnoreCase("None"))
		    	 {
		    		 System.out.println("dfjkfkjfdkjsssssssssssssss");
		    		 taxAmount=0.00;  
		    	 }
		    	 else
		    	 {
		    	 taxAmount=getInvoiceService().getTaxAmount(str2);
		    	 System.out.println(taxAmount+"jkjkggf");
		    	 taxexceptionAmount=getInvoiceService().getTaxExceptionAmount(str2);
		    	 }
		    	
		    	 
		    	 tax2.add(taxAmount);
		    	
		    	 if(str3.equalsIgnoreCase("Sqft"))
		    	  {   Double sqrt=getInvoiceService().getSqft(ddd);
		    	      System.out.println("dksdsk");
		    	      totalAmount=template.getStr_Rate()*sqrt;
		    	      System.out.println(totalAmount+"fdkdfk");
		    	  }
		    	  else if(str3.equalsIgnoreCase("Flat"))
		    	  {
		    		  totalAmount= template.getStr_Rate(); 
		    		  System.out.println("fdjdfffd");
		    		  System.out.println(totalAmount+"dfjkdkjdf");
		    	  }
		    	
		    	 taxAmount1=(taxAmount*totalAmount)/100;
		    	 taxAmount1=taxAmount1-taxexceptionAmount;
		    	 taxAmounts.add(taxAmount1);
		    	 subTotal=subTotal+totalAmount;
		    	 System.out.println(subTotal+"jhj");
				 taxAmount2=taxAmount2+taxAmount1;
			     totalDue=subTotal+taxAmount2;
		    	 
			    	  totalAmounts.add(totalAmount);
			    	
			    	  System.out.println(totalAmounts+"jffd");
			  		StringBuilder out = new StringBuilder();
			  		for (Object o : totalAmounts)
			  		{
			  		  out.append(o.toString());
			  		  out.append(",");
			  		
			  		}
			  	
	 
		     }
		     return transaction2;
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return transaction2;
		 }
		 	
	}
	public void periodChangeListener1(ValueChangeEvent event)
	{
		int_Year=(Integer) event.getNewValue();
		System.out.println(int_Year+"hjbhjjh");
	}
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private boolean render;
	public boolean isRender() {
		return render;
	}
	public void setRender(boolean render) {
		this.render = render;
	}
	public List<String> amountChangeListener(ValueChangeEvent event)
	 {      String str=(String)event.getNewValue();
		System.out.println(str_BillPeriod+"hjjhj"); 
		System.out.println(str_InvoiceTemplate+"hjjhjj");
		str_ApartmentNo=str;
		userName=getInvoiceService().getUserName(str_Block,str_ApartmentNo);
		System.out.println(str+"jkjkjjk");	
		System.out.println(str_Block+"jjkkjkkjh");
		System.out.println(int_Year+"jkjkjkjk");
		getListInvoiceTransaction1();
		System.out.println(listInvoiceTransaction1.listIterator().hasNext());
		System.out.println(!listInvoiceTransaction1.listIterator().hasNext());
		
		if(listInvoiceTransaction1.listIterator().hasNext())
		{    render=false;
			  FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"This invoice already exists for the selected apartment. Duplicate invoice cannot be created.!", "This invoice already exists for the selected apartment. Duplicate invoice cannot be created.!"));
		}
		else
		{
		 try
		 {
		      
			 render=true;
			  
			    listDues=getInvoiceService().taxList(select);
		       
		        
		        String[] strArray = listDues.split(",");
		        transaction=new ArrayList<String>();
		        for (String str1 : strArray) {
		       
		         listTax=new ArrayList<String>();
		         listTax.addAll(getInvoiceService().getTaxList(str1));
		       
		       
		         transaction.addAll(listTax);
		        }
		        System.out.println(transaction.size()+"fdjffdjfdjjfd");
			     ListIterator list=transaction.listIterator();
			     totalAmounts=new ArrayList<Double>();
			     subTotal=0.00;
			     totalDue=0.00;
			     taxAmount2=0.00;
			     tax2=new ArrayList<Double>();
			     double taxexceptionAmount=0.00;
			     while(list.hasNext())
			     {
			    	 Object obj=list.next();
			    	 DueTemplate template=(DueTemplate)obj;
			    	 String str2=template.getStr_TaxTemplate();
			    	 System.out.println(str2+"gfjjgjkfg");
			    	 String str3=template.getStr_Calculation();
			    	 if(str2.isEmpty())
			    	 {   System.out.println("dfjkfkjfdkj");
			    		 taxAmount=0.00; 
			    	 }
			    	 else if(str2.equalsIgnoreCase("None"))
			    	 {
			    		 System.out.println("dfjkfkjfdkjsssssssssssssss");
			    		 taxAmount=0.00;  
			    	 }
			    	 else
			    	 {
			    	 taxAmount=getInvoiceService().getTaxAmount(str2);
			    	 System.out.println(taxAmount+"jkjkggf");
			    	 taxexceptionAmount=getInvoiceService().getTaxExceptionAmount(str2);
			    	 System.out.println(taxexceptionAmount+"fdkjkjgfjkggkj");
			    	 }
			    	
			    	  tax2.add(taxAmount);
			    	  tax=tax2;//for Mail purpose
			    	  if(str3.equalsIgnoreCase("Sqft"))
			    	  {   Double sqrt=getInvoiceService().getSqft(str);
			    	      System.out.println(sqrt+"dksdsk");
			    	      System.out.println(template.getStr_Rate()+"kjfdfjkd");
			    	      totalAmount=template.getStr_Rate()*sqrt;
			    	      System.out.println(totalAmount+"fdkdfk");
			    	  }
			    	  else if(str3.equalsIgnoreCase("Flat"))
			    	  {
			    		  totalAmount= template.getStr_Rate(); 
			    		  System.out.println("fdjdfffd");
			    		  System.out.println(totalAmount+"dfjkdkjdf");
			    	  }
			    	 taxAmount1=(taxAmount*totalAmount)/100;
			    	 System.out.println(taxAmount1+"fkjdfkjfg");
			    	 taxAmount1=taxAmount1-taxexceptionAmount;
			    	 System.out.println(taxAmount1+"dfjkkjfdjkfd");
			    	 taxAmounts.add(taxAmount1);
			    	 tax1=taxAmounts;  //for Mail purpose
			    	 System.out.println(taxAmounts+"jkkjkjjk");
			    	 subTotal=subTotal+totalAmount;
			    	 System.out.println(subTotal+"jkgfgfgf");
					 taxAmount2=taxAmount2+taxAmount1;
					 System.out.println(taxAmount2+"dkfkfdd");
				     totalDue=subTotal+taxAmount2;
			    	 System.out.println(totalDue+"fdjkfdjkfkjdfdkj");
				    	  totalAmounts.add(totalAmount);
				           amount=totalAmounts;  //for Mail purpose
				           System.out.println(amount+"gffkllkfgh");
				    	  System.out.println(totalAmounts);
				  	
		 
			     }
			     return transaction;
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			return transaction;
		}
	return null;		 
}
	
	private String accountName;

public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
private List<String> paymentAccountName;
public List<String> getPaymentAccountName() {
	paymentAccountName=new ArrayList<String>();
	paymentAccountName.addAll(getInvoiceService().getAccountName());
	return paymentAccountName;
}
public void setPaymentAccountName(List<String> paymentAccountName) {
	this.paymentAccountName = paymentAccountName;
}
private Date Payment_Date;
public Date getPayment_Date() {
	return Payment_Date;
}
public void setPayment_Date(Date payment_Date) {
	Payment_Date = payment_Date;
}

public String savePayment()
{  System.out.println(id+"hjhjjjjjjjjjj");
   System.out.println(invoiceNo+"fdkfgkkggfk");
	double amount=getInvoiceService().getAmount(id);
	System.out.println(paidAmount+"fdkjfdjfkd");
	System.out.println(amount+"jjk");
	System.out.println(totalAmount+"jjjj");
	System.out.println(select1+"jkkjds");
	if(select1.equalsIgnoreCase("Full"))
	{ 
		
		totalAmount=amount;
		Double amount1=amount-totalAmount;
		str_Status="Paid";
		 getInvoiceService().updatePayment(accountName,paymentMode,amount1,totalAmount,str_Status,id,dat_InvoiceDate,Payment_Date,Payment_No,deposite_Account_Name);
	}
	System.out.println(totalAmount+"hjhjjh");
	if(select1.equalsIgnoreCase("Partial"))
	{  System.out.println("fdjkfjkjkggfjkgfkj");
	   double dueamount=0.00;
	   double paidAmount1=0.00;
	   if(paidAmount==0.00)
	     { System.out.println("dfjfdjfdjfjfdfjfdj"); 
		paidAmount1=totalAmount;
		dueamount=amount-totalAmount;
		str_Status="Partial Due";
	     }
	  else
	   {  System.out.println("gfgfjgjkgfj");
		paidAmount1=paidAmount+totalAmount;
		dueamount=amount-paidAmount1;
		str_Status="Partial Due";
		  if(paidAmount1==amount)
		  {
			str_Status="Paid";
		  }
	}
		
	 getInvoiceService().updatePayment(accountName,paymentMode,dueamount,paidAmount1,str_Status,id,dat_InvoiceDate,Payment_Date,Payment_No,deposite_Account_Name);
	}
	
	List<Integer> str=getDueService().getDueTemplate1(invoiceNo);
	ListIterator list2=str.listIterator();
	while(list2.hasNext())
	{
		Integer str1=(Integer)list2.next();
		double ddd=getDueService().getDueAmount1(str1);
		getDueService().updateDueTransaction(str_Status,str1,ddd);
	}

	return "invoice.xhtml";
}
 public String  cancelInvoice()
{
	return "invoice.xhtml";
}
private InvoiceTransaction selectedInvoice;

public InvoiceTransaction getSelectedInvoice() {
	
	return selectedInvoice;
}
public void setSelectedInvoice(InvoiceTransaction selectedInvoice) 
{
	this.selectedInvoice = selectedInvoice;
}
private InvoiceTransaction invoice1;
public InvoiceTransaction getInvoice1() {
	invoice1=getInvoiceService().getInvoice(id);
	return invoice1;
}
public void setInvoice1(InvoiceTransaction invoice1) {
	this.invoice1 = invoice1;
}
public void getInvoice(int id1)
{
	invoice1=getInvoiceService().getInvoice(id1);
}
private boolean indicate;
public boolean isIndicate() {
	return indicate;
}
public void setIndicate(boolean indicate) {
	this.indicate = indicate;
}
private static Integer id;
public static Integer getId() {
	return id;
}
public static void setId(Integer id) {
	InvoiceBean.id = id;
}

public String select()
{   System.out.println(selectedInvoice.getInt_InvoiceTransactionID()+"fjfdjfdjffg");
   id=selectedInvoice.getInt_InvoiceTransactionID();
   
	return "viewinvoice.xhtml";
}
private static String invoiceNo;
private static double totalAmount1;
public static double getTotalAmount1() {
	return totalAmount1;
}
public static void setTotalAmount1(double totalAmount1) {
	InvoiceBean.totalAmount1 = totalAmount1;
}
private static double paidAmount;
public static double getPaidAmount() {
	return paidAmount;
}
public static void setPaidAmount(double paidAmount) {
	InvoiceBean.paidAmount = paidAmount;
}
public String cancel()

{   id=selectedInvoice.getInt_InvoiceTransactionID();

     System.out.println(id+"fjgfjkgfgfkj");
  str_Status=getInvoiceService().getStatus(id);
  System.out.println(str_Status+"jnfdjkdkjf");
  paidAmount=selectedInvoice.getPaidBalance();
  if(str_Status.equalsIgnoreCase("Due"))
  {   indicate=false;
  totalAmount1=selectedInvoice.getTotalBalance();
  
 
  invoiceNo=selectedInvoice.getInt_InvoiceNo();
  System.out.println(totalAmount1+"fkjfdkjfdkj");
    return "quickpayment.xhtml";
  }
  
  else if(str_Status.equalsIgnoreCase("Paid"))
  {
	  indicate=true;
	  FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"This invoice is already paid.!", "This invoice is already paid.!"));
 
	  return null;
  }
  else
	  {
	  indicate=false;
	  totalAmount1=selectedInvoice.getDueBalance();
	  System.out.println(paidAmount);
	  invoiceNo=selectedInvoice.getInt_InvoiceNo();
	  System.out.println(totalAmount1+"fkjfdkjfdkj");
	    return "quickpayment.xhtml";
	  }

	
}

private List<String> dueList3;

public List<String> getDueList3(String fff,String ddd) {
	System.out.println("fjjfdfd");
	System.out.println(fff+"fjdfkjf");
	System.out.println(ddd+"fgkjfjkfkj");
	 listDues=getInvoiceService().taxList(fff);
	
	 String[] strArray = listDues.split(",");
	 dueList3=new ArrayList<String>();
     for (String str : strArray) {
       
      listTax=new ArrayList<String>();
      listTax.addAll(getInvoiceService().getTaxList(str));
     
    
     
      dueList3.addAll(listTax);
      amountCalculation(fff,ddd);
     }
	
	return dueList3;
}
public void setDueList3(List<String> dueList3) {
	this.dueList3 = dueList3;
}
private List<String> listAccountName;
public List<String> getListAccountName() {
	listAccountName=new ArrayList<String>();
	listAccountName.addAll(getInvoiceService().getlistAccountName());
	return listAccountName;
}
public void setListAccountName(List<String> listAccountName) {
	this.listAccountName = listAccountName;
}
private Integer Payment_No;
public Integer getPayment_No() {
	return Payment_No;
}
public void setPayment_No(Integer payment_No) {
	Payment_No = payment_No;
}
public String select1;
public String getSelect1() {
	return select1;
}
public void setSelect1(String select1) {
	this.select1 = select1;
}
public double changeAccount(ValueChangeEvent event)
{    
	select1=(String)event.getNewValue();
	System.out.println(select1+"jkkjjskd");
	if(select1.equals("Full"))
	{
	System.out.println(totalAmount1+"dfjfjfj");
	}
	else
	{
		
		System.out.println(totalAmount1+"fcjddfjkfjk");
	}
	return totalAmount1;
}
public String deleteInvoice() {
	
System.out.println("fddffdk");
	Integer id=selectedInvoice.getInt_InvoiceTransactionID();
	String str=selectedInvoice.getInt_InvoiceNo();
	
	
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Delete Invoice? Payments recorded against this invoice will also be deleted.!", "Delete Invoice? Payments recorded against this invoice will also be deleted.!"));
   

		getInvoiceService().deleteInvoice(id);
		getInvoiceService().deleteDues(str);
    return "invoice.xhtml?faces-redirect=true";
}

}
