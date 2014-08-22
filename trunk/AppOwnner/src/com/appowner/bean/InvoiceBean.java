package com.appowner.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.RandomStringUtils;

import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTransaction;
import com.appowner.service.InvoiceService;
import com.appowner.util.Util;

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
	private String str_Status;
	private String int_InvoiceNo;
	
	
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

	public String getDat_InvoiceDate() {
		java.util.Date d=new java.util.Date();
		 SimpleDateFormat ft = 
			      new SimpleDateFormat ("dd-MM-yyyy");
		String str=ft.format(d);
		getDate3();
		return str;
	}
	public void setDat_InvoiceDate(String dat_InvoiceDate) {
		this.dat_InvoiceDate = dat_InvoiceDate;
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
	private static  double tax1;
	public static double getTax1() {
		return tax1;
	}
	public static void setTax1(double tax1) {
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
	private static String mailid;
	
	public static String getMailid() {
		return mailid;
	}
	public static void setMailid(String mailid) {
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
	 private static String InvoiceNo="invoiceNo";
	   
	    private static String Date="date";
	    private static Double amount;
	    private static Double tax;
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
	

		
		public static String getDate() {
			return Date;
		}
		public static void setDate(String date) {
			Date = date;
		}
	
		
		public static Double getAmount() {
			return amount;
		}
		public static void setAmount(Double amount) {
			InvoiceBean.amount = amount;
		}
		public static Double getTax() {
			return tax;
		}
		public static void setTax(Double tax) {
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
			invoice.setInt_InvoiceNo(randomId());
			invoice.setSubTotal(getSubTotal());
			invoice.setTaxAmount(getTaxAmount2());
			invoice.setTotalDue(getTotalDue());
		
			invoice.setTotalBalance(getTotalDue());
			invoice.setStr_Status("Due");
			getInvoiceService().saveInvoiceTransaction(invoice);
			
			  if(bl_Show==true)
				{
					 mailid= getInvoiceService().getmailid(str_ApartmentNo);
					
					subject="Shaffi Paradise - Invoice posted for your Apartment";
					content="";
					InvoiceNo=int_InvoiceNo;
					Date=dat_InvoiceDate;
					date1=getDat_DueDate();
					amount=getTotalAmount();
					tax=getTaxAmount1();
					tax1=getTaxAmount();
					due=getTotalDue();
					date3=getDate3();
					block=getStr_Block();
					subtotal=getSubTotal();
					apartmentNo=getStr_ApartmentNo();
					billperiod=getStr_BillPeriod();
					year=getInt_Year();
					organisation=getStr_Organisation();
					transaction1=transaction;
				
					return "invoice.jsp";
				}
				return null;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
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
	public List<String> selectRadioButton(ValueChangeEvent event)
	{  
		select =( String )event.getNewValue();
        
         dueList=new ArrayList<String>();
	    if(select.equals(getSelect()))
	    {
	        listDues=getInvoiceService().taxList(select);
	       
	        
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
	private List<InvoiceTransaction> listInvoiceTransaction;
	public List<InvoiceTransaction> getListInvoiceTransaction() {
		listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
		listInvoiceTransaction.addAll(getInvoiceService().listInvoiceTransaction());
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
	private double totalAmount;
	

	
	

	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<String> organisationChangeListener(ValueChangeEvent event)
	{   String str=(String)event.getNewValue();
	    if(str==Util.getApartmentName())
	    {
	    	return str_Blocks;
	    }
		return null;
	}
	public List<String> blockChangeListener(ValueChangeEvent event)
	{   str_Block=(String)event.getNewValue();
		str_BlockNo=new ArrayList<String>();
		str_BlockNo.addAll(getInvoiceService().getApartmentlist(str_Block));
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
	private List<String> transaction=new ArrayList<String>();
	
	public List<String> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<String> transaction) {
		this.transaction = transaction;
	}
	private List<Double> totalAmounts=new ArrayList<Double>();
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
	@SuppressWarnings("rawtypes")
	public List<String> amountChangeListener(ValueChangeEvent event)
	         
			 {  String str=(String)event.getNewValue();
			    
			    Double sqrt=getInvoiceService().getSqft(str);
			    listDues=getInvoiceService().taxList(select);
		       
		        
		        String[] strArray = listDues.split(",");
		        for (String str1 : strArray) {
		       
		         listTax=new ArrayList<String>();
		         listTax.addAll(getInvoiceService().getTaxList(str1));
		       
		       
		         transaction.addAll(listTax);
		        }
			     ListIterator list=transaction.listIterator();
			     while(list.hasNext())
			     {
			    	 Object obj=list.next();
			    	 DueTemplate template=(DueTemplate)obj;
			    	 String str2=template.getStr_TaxTemplate();
			    	 System.out.println(str2);
			    	
			    	
			    	
			    	 taxAmount=getInvoiceService().getTaxAmount(str2);
			    	 totalAmount=template.getStr_Rate()*sqrt;
			    	 System.out.println(totalAmount);
			    	 taxAmount1=(taxAmount*totalAmount)/100;
			    	 taxAmounts.add(taxAmount1);
			    	 subTotal=subTotal+totalAmount;
					 taxAmount2=taxAmount2+taxAmount1;
				     totalDue=subTotal+taxAmount2;
			    	 
				    	  totalAmounts.add(totalAmount);
				    	  System.out.println(totalAmounts);
				  		StringBuilder out = new StringBuilder();
				  		for (Object o : totalAmounts)
				  		{
				  		  out.append(o.toString());
				  		  out.append(",");
				  		
				  		}
				  	
		 
			     }
			     return transaction;
}
	
}
