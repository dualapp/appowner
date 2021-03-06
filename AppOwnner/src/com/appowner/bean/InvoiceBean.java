package com.appowner.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.appowner.model.DueTemplate;
import com.appowner.model.DueTransaction;
import com.appowner.model.Expense;
import com.appowner.model.InvoiceTransaction;
import com.appowner.model.ManualJournal;
import com.appowner.service.AccountsService;
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
	@PostConstruct
	public void init() {
		select1="Partial";
		System.out.println("jnffggfjfjghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		 createBarModel();
		
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
		BigDecimal b1 = new BigDecimal(outstandingBalance).setScale(2,BigDecimal.ROUND_HALF_UP);
		outstandingBalance=b1.doubleValue();
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
	   
	    private static String Date;
	    private static List<Double> amount;
	    private static List<Double> tax;
	    private static Double due;
	    private static String date1;
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
	
	public static String getDate1() {
			return date1;
		}
		public static void setDate1(String date1) {
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
	public String addInvoiceTransaction() throws ParseException
	{   
		try{
			InvoiceTransaction invoice=new InvoiceTransaction();
			invoice.setStr_InvoiceTemplate(getStr_InvoiceTemplate());
			invoice.setStr_BillPeriod(getStr_BillPeriod());
			invoice.setInt_Year(getInt_Year());
		/*	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			String str4=request.getParameter("dat_InvoiceDate");
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
		 
			try {
		 
				dat_DueDate = formatter.parse(str4);
				
		 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		*/	
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
					System.out.println(dat_InvoiceDate+"fggjkgfgfh");
					
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					
				 
					Date = formatter.format(dat_InvoiceDate);
					
					System.out.println(Date);
					date1=formatter.format(dat_DueDate);
					System.out.println(getDat_DueDate()+"gfvjgvfkjfgj");
						
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
					return "/AfrteLoginViews/Accounting/sendinvoice.jsp";
				
				}
			  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Transaction Saved Successfully!"));
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
	public List<String> selectRadioButton(ValueChangeEvent event) 
	{  try{
		select =( String )event.getNewValue();
		System.out.println(select+"hhjjhjh");
		str_InvoiceTemplate=select;
		System.out.println(str_InvoiceTemplate+"fjjkdfdjkkjfdjkfdjkfdjdjfdfj44444444444444444444444444444");
		str_Block="";
		str_ApartmentNo="";
		str_BillPeriod="";
		int_Year=int_Year;
		render=false;
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
		e.printStackTrace();
	}
	 finally
	    {
	    	 periodIndicator=getInvoiceService().getPeriod(select);
				System.out.println(periodIndicator+"jhjjkkj");
	    }
	return dueList;

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
	private String query="";
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public List<InvoiceTransaction> getListInvoiceTransaction() {
		try
		{
		listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
		System.out.println(str_Block+"fgfggfgfgfgfgf111111111111111111111111111");
		System.out.println(str_ApartmentNo+"fjkkjfdjkfjfgjgjgf111111222222222222222222222222222222222");
		System.out.println(str_Status+"fgvkkjgfjkf333333333333333333333333333333333333333333");
		System.out.println(str_BillPeriod+"fdjkjkfjfdjkfdj666666666666666666666666666");
		System.out.println(str_InvoiceTemplate+"jfdjkfjkfjd3333333333333366666666666666666666666666");
		
		System.out.println(query+"dfjfdjfjfdjjfdqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		 if(str_Block==null && str_ApartmentNo==null && str_Status==null && str_BillPeriod==null && str_InvoiceTemplate==null)
		{  System.out.println("fdjfkjfjd111111111111111111111111111111111111111");
			query="";
		}
		 
	    
		 if(!(str_Block==null) && !(str_Block.isEmpty()) )
		{
			query=query+"str_Block="+"'"+str_Block+"'";
		}
	 if(!(str_ApartmentNo==null) && !(str_ApartmentNo.isEmpty()))
		{   System.out.println("hhh111111111111111111111111111111111111111111111111111111111111111");
			query=query+" and "+"str_ApartmentNo="+"'"+str_ApartmentNo+"'";
		}
     if(!(str_Status==null) && !(str_Status.isEmpty()))
		{
			query=query+" and "+"str_Status="+"'"+str_Status+"'";
		}
	if(!(str_BillPeriod==null) && !(str_BillPeriod.isEmpty()))
		{
			query=query+" and "+"str_BillPeriod="+"'"+str_BillPeriod+"'";
		}
	if(!(str_InvoiceTemplate==null) && !(str_InvoiceTemplate.isEmpty()))
		{
			query=query+" and "+"str_InvoiceTemplate="+"'"+str_InvoiceTemplate+"'";
		} 
		 
		System.out.println(query+"jdffjkdjhfdjfdfdfdffdjfdjfdjfjddfjhdfjhfdjhfd");
		System.out.println(query.indexOf("and"));
		
		if(query.indexOf("and")==1)
		{   System.out.println("jhujugfjf11111111111111111111111111111111111111111111");
		  
		   query=query.replaceFirst("and","" );
                   
		}
		System.out.println(query+"fdjjhgjjgfjgfjfjfjgjfgjgfjgfj");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		listInvoiceTransaction.addAll(getInvoiceService().listInvoiceTransaction(query));
		query="";
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
	public String blockChangeListener(ValueChangeEvent event)
	{   str_Block=(String)event.getNewValue();
	   System.out.println(str_Block);
	   System.out.println(select+"jkgfkjggfgfgf");
	   if(select==null)
	   {   System.out.println("djfdjhjdfjfdjdfjfdj44444444444444444444444444444444444444444444444444444445555555555555555555555555");
		   FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Select InvoiceTemplate", "Select InvoiceTemplate"));
		 return "invoice.xhtml";
		
	   }
	   else
	   {   
		str_BlockNo=new ArrayList<String>();
		str_BlockNo.addAll(getInvoiceService().getApartmentlist(str_Block));
		
	   }
	   return "invoice.xhtml?faces-redirect=true";
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
	private boolean bl_Show=true;
	
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
		     taxAmounts=new ArrayList<Double>();
		     subTotal=0.00;
		     totalDue=0.00;
		     taxAmount2=0.00;
		     double taxexceptionAmount=0.00;
		     tax2=new ArrayList<Double>();
		     taxAmounts=new ArrayList<Double>();
		     while(list.hasNext())
		     {
		    	 Object obj=list.next();
		    	 DueTemplate template=(DueTemplate)obj;
		    	 String str2=template.getStr_TaxTemplate();
		    	 System.out.println(str2);
		    	 String str3=template.getStr_Calculation();
		    	 taxexceptionAmount=0.00;
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
		    	      BigDecimal b = new BigDecimal(totalAmount).setScale(2,BigDecimal.ROUND_HALF_UP);
		    	      totalAmount=b.doubleValue(); 
		    	      System.out.println(totalAmount+"fdkdfk");
		    	  }
		    	  else if(str3.equalsIgnoreCase("Flat"))
		    	  {
		    		  totalAmount= template.getStr_Rate(); 
		    		  System.out.println("fdjdfffd");
		    		  System.out.println(totalAmount+"dfjkdkjdf");
		    	  }
		    	
		    	 taxAmount1=(taxAmount*totalAmount)/100;
		    	 taxAmount1=taxAmount1-taxexceptionAmount/10;
		    	 taxAmounts.add(taxAmount1);
		    	 subTotal=subTotal+totalAmount;
		    	 System.out.println(subTotal+"jhj");
				 taxAmount2=taxAmount2+taxAmount1;
			     totalDue=subTotal+taxAmount2;
			     BigDecimal b = new BigDecimal(totalDue).setScale(2,BigDecimal.ROUND_HALF_UP);
			     totalDue=b.doubleValue(); 
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
			     taxAmounts=new ArrayList<Double>();
			     double taxexceptionAmount=0.00;
			     while(list.hasNext())
			     {
			    	 Object obj=list.next();
			    	 DueTemplate template=(DueTemplate)obj;
			    	 String str2=template.getStr_TaxTemplate();
			    	 System.out.println(str2+"gfjjgjkfg");
			    	 String str3=template.getStr_Calculation();
			    	 taxexceptionAmount=0.00;
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
			    	      BigDecimal b = new BigDecimal(totalAmount).setScale(2,BigDecimal.ROUND_HALF_UP);
			    	      totalAmount=b.doubleValue(); 
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

			    	 System.out.println(taxexceptionAmount+"fdklfkjfdjk11111111111111111111111111111111111111");
			    	 if(taxAmount1 > taxexceptionAmount )
			    	 {
			    		 
			    	
			    	 taxAmount1=taxexceptionAmount;
			         }

			    	 System.out.println(taxexceptionAmount+"fdklfkjfdjk11111111111111111111111111111111111111");
			    	 taxAmount1=taxAmount1-taxexceptionAmount/10;

			    	 System.out.println(taxAmount1);
			    	 taxAmounts.add(taxAmount1);
			    	 tax1=taxAmounts;  //for Mail purpose
			    	 System.out.println(taxAmounts+"jkkjkjjk");
			    	 subTotal=subTotal+totalAmount;
			    	 System.out.println(subTotal+"jkgfgfgf");
					 taxAmount2=taxAmount2+taxAmount1;
					 System.out.println(taxAmount2+"dkfkfdd");
				     totalDue=subTotal+taxAmount2;
				     BigDecimal b = new BigDecimal(totalDue).setScale(2,BigDecimal.ROUND_HALF_UP);
				     totalDue=b.doubleValue(); 
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
	  double dueamount=0.00;
	   double paidAmount1=0.00;
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
	 
	   if(paidAmount==0.00)
	     { System.out.println("dfjfdjfdjfjfdfjfdj"); 
		paidAmount1=totalAmount;
		dueamount=amount-totalAmount;
		BigDecimal b1 = new BigDecimal(paidAmount1).setScale(2,BigDecimal.ROUND_HALF_UP);
		paidAmount1=b1.doubleValue();
		BigDecimal b2 = new BigDecimal(dueamount).setScale(2,BigDecimal.ROUND_HALF_UP);
		dueamount=b2.doubleValue();
		str_Status="Partial Due";
	     }
	  else
	   {  System.out.println("gfgfjgjkgfj");
		paidAmount1=paidAmount+totalAmount;
		BigDecimal b1 = new BigDecimal(paidAmount1).setScale(2,BigDecimal.ROUND_HALF_UP);
		paidAmount1=b1.doubleValue();
		dueamount=amount-paidAmount1;
		BigDecimal b2 = new BigDecimal(dueamount).setScale(2,BigDecimal.ROUND_HALF_UP);
		dueamount=b2.doubleValue();
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
		getDueService().updateDueTransaction(str_Status,str1,dueamount,paidAmount1);
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
{   
  try{ 
   if(indicator1==false)
   {   System.out.println("jcvkvcjvj11111111111111111111111111111111111111111111111111");
	   FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
		return "invoice.xhtml";
   }
   else
   { id=selectedInvoice.getInt_InvoiceTransactionID(); 
      System.out.println(id+"dfjkfjjkgfjkgf");
	  return "viewinvoice.xhtml";
   }
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  return null;
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

{  try
   {
	if(indicator1==false)
			{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
		return "invoice.xhtml";
			}
	else
	{
	id=selectedInvoice.getInt_InvoiceTransactionID();

     System.out.println(id+"fjgfjkgfgfkj");
  str_Status=getInvoiceService().getStatus(id);
  System.out.println(str_Status+"jnfdjkdkjf");
  paidAmount=selectedInvoice.getPaidBalance();
  if(str_Status.equalsIgnoreCase("Due"))
  {   
  totalAmount1=selectedInvoice.getTotalBalance();
  
 
  invoiceNo=selectedInvoice.getInt_InvoiceNo();
  System.out.println(totalAmount1+"fkjfdkjfdkj");
    return "quickpayment.xhtml";
  }
  
  else if(str_Status.equalsIgnoreCase("Paid"))
  {
	  
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
  }
catch(Exception e)
{
	e.printStackTrace();
}

return null;	
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
try
{
	System.out.println(indicate+"dfskjfdkjgfjkgfjk11111111111111111111111111111111111");
if(indicator1==false)
{
	 FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please Select an Item to View","Please Select an Item to View")); 
		return "invoice.xhtml?faces-redirect=true";
}
else
{
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
catch(Exception e)
{
	e.printStackTrace();
}
return null;
}
private boolean indicator1;
public boolean isIndicator1() {
	return indicator1;
}
public void setIndicator1(boolean indicator1) {
	this.indicator1 = indicator1;
}
public void getManualJournal(int id)
{
	System.out.println(id+"fjgjgfjfssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss333333333333333");
}
public void desabled1Listener( SelectEvent event)
{  System.out.println("11111111111111111111111111111111111111111111111111111");
	selectedInvoice=(InvoiceTransaction) event.getObject();
	indicator1=true;
	if(selectedInvoice.getStr_Status().equalsIgnoreCase("Paid"))
	{
		indicate=true;
		
	}
	else
	{
		indicate=false;
	}
	 
}
//MANUAL JOURNAL
private Integer int_ManualJournalID;
public Integer getInt_ManualJournalID() {
	return int_ManualJournalID;
}
public void setInt_ManualJournalID(Integer int_ManualJournalID) {
	this.int_ManualJournalID = int_ManualJournalID;
}

public Date getDat_Date() {
	dat_Date=new java.util.Date();
	
	
	return dat_Date;
	
}


private static String debitAccount;
private static String creditAccount;
public void accountchangeListener4(ValueChangeEvent event)
{
	System.out.println("fjkfgjkfgjkf");
	str_DebitAccount=(String)event.getNewValue();
   System.out.println(str_DebitAccount+"lovejjjjjjjjjjjjjjjjj");
	
}
public void accountchangeListener5(ValueChangeEvent event)
{
	System.out.println("fjkfgjkfgjkf123");
	str_CreditAccount=(String)event.getNewValue();
   System.out.println(str_CreditAccount+"lovejjjjjjjjjjjjjjjjj");
	
}
public static String getDebitAccount() {
	return debitAccount;
}

public static String getCreditAccount() {
	return creditAccount;
}
public static void setCreditAccount(String creditAccount) {
	InvoiceBean.creditAccount = creditAccount;
}
public String getStr_Organisation1() {
	return str_Organisation1;
}
public void setStr_Organisation1(String str_Organisation1) {
	this.str_Organisation1 = str_Organisation1;
}
public static void setDebitAccount(String debitAccount) {
	InvoiceBean.debitAccount = debitAccount;
}
public void setDat_Date(Date dat_Date) {
	this.dat_Date = dat_Date;
}
@ManagedProperty(value = "#{AccountsService}")
private AccountsService accountsService;
public AccountsService getAccountsService() {
	return accountsService;
}
 public void setAccountsService(AccountsService accountsService) {
	this.accountsService = accountsService;
}
public String getStr_Reference() {
	return str_Reference;
}
public void setStr_Reference(String str_Reference) {
	this.str_Reference = str_Reference;
}
public String getStr_Notes() {
	return str_Notes;
}
public void setStr_Notes(String str_Notes) {
	this.str_Notes = str_Notes;
}
public String getStr_DebitAccount() {
	return str_DebitAccount;
}
public void setStr_DebitAccount(String str_DebitAccount) {
	this.str_DebitAccount = str_DebitAccount;
}
public String getStr_CreditAccount() {
	return str_CreditAccount;
}
public void setStr_CreditAccount(String str_CreditAccount) {
	this.str_CreditAccount = str_CreditAccount;
}

public Double getStr_DebitAmount() {
	return str_DebitAmount;
}
public void setStr_DebitAmount(Double str_DebitAmount) {
	this.str_DebitAmount = str_DebitAmount;
}
public Double getStr_CreditAmount() {
	return str_CreditAmount;
}
public void setStr_CreditAmount(Double str_CreditAmount) {
	this.str_CreditAmount = str_CreditAmount;
}
private String str_Organisation1;
private Date dat_Date;
private String str_Reference;
private String str_Notes;
private String str_DebitAccount;
private String str_CreditAccount;
private Double str_DebitAmount;
private Double str_CreditAmount;
private ManualJournal selectedjournal=new ManualJournal();
public ManualJournal getSelectedjournal() {
	
	return selectedjournal;
}
public void setSelectedjournal(ManualJournal selectedjournal) {
	this.selectedjournal = selectedjournal;
}
private boolean indicate4;

public boolean isIndicate4() {
	return indicate4;
}
public void setIndicate4(boolean indicate4) {
	this.indicate4 = indicate4;
}
public void detectManualJournal()
{
	System.out.println("vcnmjnngffgjmfgmjngfgfm111111111111111111111111111111111");
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select an Item to View!"));
}
public void desabledListener( SelectEvent event)
{
	System.out.println("klcfkfkjfgfgkffkg33333333333333333333333333333");
	selectedjournal=(ManualJournal) event.getObject();
	System.out.println(selectedjournal.getInt_ManualJournalID()+"dfjjffjnfjjfgjgfjfgj");
	debitAccount=selectedjournal.getStr_DebitAccount();
	amount1=selectedjournal.getDbl_DebitAmount();
		 indicate4 = true;
}
public String addInvoiceManualJournal() 
{ System.out.println("dfjudffgviugfiugfiu");
	try{
	
	
	ManualJournal journal=new ManualJournal();
    journal.setStr_OrganisationID(Util.getAppartmentId());
    journal.setDat_Date(dat_Date);
    journal.setStr_Reference(getStr_Reference());
    journal.setStr_Notes(getStr_Notes());
    journal.setStr_DebitAccount(str_DebitAccount);
    
   
    journal.setStr_CreditAccount(str_CreditAccount);
    journal.setDbl_DebitAmount(getStr_DebitAmount());
  
    journal.setDbl_CreditAmount(getStr_CreditAmount());
   
   
    
    	 getAccountsService().addManualJournal(journal);
    	 FacesContext facesContext = FacesContext.getCurrentInstance();
 		Flash flash = facesContext.getExternalContext().getFlash();
 		flash.setKeepMessages(true);
 		flash.setRedirect(true);
 		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ManualJournal Saved Successfully!", "ManualJournal Saved Successfully!"));
    

    	
    	 }
    	
  catch(Exception e)
  {
	e.printStackTrace();
  }
	return "manualjournal.xhtml";
}

public String saveManualJournal(ManualJournal jouranl) {
	System.out.println("jhvvnjggggggggggggggggggggg11111111111111111111111111111111111111111111111111111111");
	
			 getAccountsService().updateManualJournal(jouranl);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Updated Successfully!", "Updated Successfully!"));

	
	return "manualjournal.xhtml?faces-redirect=true";
	
}
public void deleteManualJournal1() {
	try
	{ 
	
	System.out.println("hyjhhhhhhhhhhhhhhhhhhhhhhhhhhh");

	if(indicate4==false)
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select an Item to View!"));
	}
	else
	{
	id=selectedjournal.getInt_ManualJournalID();
	System.out.println(id+"gchhhhhhhhhhhhhhhhhh");
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ManualJournal deleted Successfully!", "ManualJournal deleted Successfully!"));
   

   getAccountsService().deleteManualJournal(id);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   
}
private static double amount1;

public static double getAmount1() {
	return amount1;
}
public static void setAmount1(double amount1) {
	InvoiceBean.amount1 = amount1;
}
public void amountchangeListener(ValueChangeEvent event)
{
	amount1=(double) event.getNewValue();
	System.out.println(amount1+"jhcfffdjhfjhdffdj1111111111111111111");
}

public void validateAccount(FacesContext context, UIComponent component,Object o) 
{System.out.println("111111111111111111111118888888888888888888888888888888888888888888");
	 
		HtmlSelectOneMenu menu =(HtmlSelectOneMenu) component;
		System.out.println(str_DebitAccount+"fdjfdfd");
	    System.out.println(str_CreditAccount+"djkfdkjfdkj");
	    System.out.println(menu.getSubmittedValue()+"fdjkjkfjkjffjkfgkjjkjkk");
		System.out.println(menu.getSubmittedValue().equals(str_DebitAccount)+"hjfddfhffgf");
		if(menu.getSubmittedValue().equals(str_DebitAccount)) {
			FacesMessage msg
	          = new FacesMessage();
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		        throw new ValidatorException(msg);
		}
		else
		{   
			System.out.println("jfdjjfjfgjfgj");
		}
}
public void validateAmount(FacesContext context, UIComponent component,Object o) 
 {
	 System.out.println("166666666666666666666666666666666666666666666666666666666666666666666666666");
		HtmlInputText input =(HtmlInputText) component;
		System.out.println(amount1+"sdmkldkmfdkkjfdkj");
		System.out.println(input.getSubmittedValue()+"jkjxkjcjkcjkckjcvjcvvjcvcjcvjcvj");
		double amount2= Double.parseDouble((String) input.getSubmittedValue());
		
		 int retval = Double.compare(amount1,amount2);
		
		
		if(retval==0) {
			System.out.println("vfgfjkfkjgfkj");
		}
		else
		{   
			FacesMessage msg
	          = new FacesMessage();
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		        throw new ValidatorException(msg);
		}
 }
private BarChartModel barModel;
/*@PostConstruct
public void init1() {
    createBarModel();
} */
/*public InvoiceBean(){
	System.out.println("fcbhfhjhggfgfhgfhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	 createBarModel();
}*/
public BarChartModel getBarModel() {
	return barModel;
}
public void setBarModel(BarChartModel barModel) {
	this.barModel = barModel;
}
private BarChartModel barModel1;

private void createBarModel() {
    barModel = initBarModel();
    barModel1=initBarModel1() ;
    barModel.setTitle("Bar Chart");
    barModel.setLegendPosition("ne");
    barModel1.setLegendPosition("ne");
    listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
    listInvoiceTransaction.addAll(getInvoiceService().listInvoiceTransaction());
    System.out.println(listInvoiceTransaction+"fkjgfkjgjkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
    ListIterator list=listInvoiceTransaction.listIterator();
    double amount=0.00;
    while(list.hasNext())
    {
    	InvoiceTransaction invoice=(InvoiceTransaction) list.next();
    	amount=amount+invoice.getTotalBalance();
    }
    System.out.println(amount+"kgvgkjkjggkjkjggghghgjhjh");
    Axis xAxis = barModel.getAxis(AxisType.X);
    xAxis.setLabel("Income");
     
    Axis yAxis = barModel.getAxis(AxisType.Y);
    yAxis.setLabel("Months");
    yAxis.setMin(0);
    yAxis.setMax(amount);
    Axis xAxis1 = barModel1.getAxis(AxisType.X);
    xAxis1.setLabel("Income");
     
    Axis yAxis1 = barModel1.getAxis(AxisType.Y);
    yAxis.setLabel("Months");
    yAxis1.setMin(0);
    yAxis1.setMax(amount);
}
private  List<Expense> listExpense;


public List<Expense> getListExpense() {
	return listExpense;
}
public void setListExpense(List<Expense> listExpense) {
	this.listExpense = listExpense;
}
private BarChartModel initBarModel() {
    BarChartModel model = new BarChartModel();
    Map<Object, Number> data =new LinkedHashMap<Object, Number>();
   
   

    List<String> number=Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11");
List<String> str1=Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
ListIterator list2=number.listIterator();
ListIterator list1=str1.listIterator();

while(list2.hasNext() && list1.hasNext())
{    String str=(String) list2.next();
	 int no=Integer.parseInt(str);
	  System.out.println(no+"fhjgfgfgffg");
	  listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
	    listInvoiceTransaction.addAll(getInvoiceService().listInvoiceTransaction());
	    
	   
	    ListIterator list=listInvoiceTransaction.listIterator();
	  System.out.println(list.hasNext());
	  String month=(String) list1.next();
	 Date date=new java.util.Date();
	 InvoiceTransaction invoice=new InvoiceTransaction();
	
	  double amount=0.00;
	 
	  while(list.hasNext() )
	  {  System.out.println("jfjgffjgfggfjgfgjgfjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	  invoice=(InvoiceTransaction) list.next();
	  	date=invoice.getDat_InvoiceDate();
	  
	  	System.out.println(month+"jgffggfgfgf");
	    System.out.println(date.getMonth()==no);
	  
	    if(date.getMonth()==no)
	     {  System.out.println("kunku");
	     amount=amount+ invoice.getTotalBalance();
		
	     }
  	   
	   
	  }
	  data.put(month, amount);   
	System.out.println(data+"hffhjfjgfjgjgjggjgjjgjgfj");  
}
ChartSeries invoice = new ChartSeries();

invoice.setLabel("Income");
invoice.setData(data);

    

    model.addSeries(invoice);
    
     
    return model;
}
public BarChartModel getBarModel1() {
	return barModel1;
}
public void setBarModel1(BarChartModel barModel1) {
	this.barModel1 = barModel1;
}
private BarChartModel initBarModel1() {
    BarChartModel model = new BarChartModel();
    Map<Object, Number> incomedata =new LinkedHashMap<Object, Number>();
    Map<Object, Number> expensedata =new LinkedHashMap<Object, Number>();
   

    List<String> number=Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11");
List<String> str1=Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
ListIterator list2=number.listIterator();
ListIterator list1=str1.listIterator();

while(list2.hasNext() && list1.hasNext())
{    String str=(String) list2.next();
	 int no=Integer.parseInt(str);
	  System.out.println(no+"fhjgfgfgffg");
	  listInvoiceTransaction=new ArrayList<InvoiceTransaction>();
	    listInvoiceTransaction.addAll(getInvoiceService().listInvoiceTransaction());
	    
	   
	    ListIterator list=listInvoiceTransaction.listIterator();
	  System.out.println(list.hasNext());
	  String month=(String) list1.next();
	 Date date=new java.util.Date();
	 InvoiceTransaction invoice=new InvoiceTransaction();
	 listExpense=new ArrayList<Expense>();
	 listExpense.addAll(getInvoiceService().listExpense());
	 ListIterator list3=listExpense.listIterator();
	  double amount=0.00;
	  double amount1=0.00;
	  while(list.hasNext() )
	  {  System.out.println("jfjgffjgfggfjgfgjgfjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	  invoice=(InvoiceTransaction) list.next();
	  	date=invoice.getDat_InvoiceDate();
	  
	  	System.out.println(month+"jgffggfgfgf");
	    System.out.println(date.getMonth()==no);
	  
	    if(date.getMonth()==no)
	     {  System.out.println("kunku");
	     amount=amount+ invoice.getTotalBalance();
		
	     }
  	   
	   
	  }
	  incomedata.put(month, amount);   
	System.out.println(incomedata+"hffhjfjgfjgjgjggjgjjgjgfj"); 
	Expense expense=new Expense();
	 while(list3.hasNext() )
	  {  
	  expense=(Expense) list3.next();
	  	date=expense.getDate_Duration();
	  System.out.println(date.getMonth()+"fdjfjdfjjfgjff");
	  	System.out.println(month+"jgffggfgfgf");
	    System.out.println(date.getMonth()==no);
	  
	    if(date.getMonth()==no)
	     {  System.out.println("kunku");
	     amount1=amount1+expense.getDbl_Ammount();
		
	     }
 	   
	   
	  }
	 expensedata.put(month, amount1);   
	 System.out.println(expensedata+"fdjfjkfjkgfjkgfjkgfjgfjkgfkjgjggffjk");
}

	
	  
	

	
	
	

ChartSeries invoice = new ChartSeries();
ChartSeries invoice1 = new ChartSeries();
invoice.setLabel("Income");
invoice.setData(incomedata);
invoice1.setData(expensedata);
 invoice1.setLabel("Expense");   

    model.addSeries(invoice);
    model.addSeries(invoice1);
     
    return model;
}

}
