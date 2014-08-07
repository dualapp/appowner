package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.Vendor;
import com.appowner.model.WaterPayment;
import com.appowner.model.WaterVendorTransaction;
import com.appowner.service.VendorService;

@ManagedBean
@SessionScoped
public class VendorTransactionBean  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{VendorService}")
	private VendorService vendorservice;
	private List<WaterVendorTransaction> waterVendortransaction1;
	private int int_NoOfTankers;
	private int int_WaterCapacity;
	private int int_TransactionId;
	


	public int getInt_TransactionId() {
		return int_TransactionId;
	}

	public void setInt_TransactionId(int int_TransactionId) {
		this.int_TransactionId = int_TransactionId;
	}
	private WaterVendorTransaction waterVendorTransaction= new WaterVendorTransaction();
   public WaterVendorTransaction getWaterVendorTransaction() {
		return waterVendorTransaction;
	}

	public void setWaterVendorTransaction(
			WaterVendorTransaction waterVendorTransaction) {
		this.waterVendorTransaction = waterVendorTransaction;
	}
private Date date_TDate;
	 private String str_DriverName;
	 private int int_WaterPrice;

	public int getInt_NoOfTankers() {
		return int_NoOfTankers;
	}

	public void setInt_NoOfTankers(int int_NoOfTankers) {
		this.int_NoOfTankers = int_NoOfTankers;
	}

	public int getInt_WaterCapacity() {
		return int_WaterCapacity;
	}

	public void setInt_WaterCapacity(int int_WaterCapacity) {
		this.int_WaterCapacity = int_WaterCapacity;
	}

	public Date getDate_TDate() {
		return date_TDate;
	}

	public void setDate_TDate(Date date_TDate) {
		this.date_TDate = date_TDate;
	}

	public String getStr_DriverName() {
		return str_DriverName;
	}

	public void setStr_DriverName(String str_DriverName) {
		this.str_DriverName = str_DriverName;
	}

	 

	public int getInt_WaterPrice() {
		return int_WaterPrice;
	}

	public void setInt_WaterPrice(int int_WaterPrice) {
		this.int_WaterPrice = int_WaterPrice;
	}

	public void setStr_VendorNameByType(List<String> str_VendorNameByType) {
		this.str_VendorNameByType = str_VendorNameByType;
	}

	public VendorService getVendorservice() {
		return vendorservice;
	}

	public void setVendorservice(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	public List<String> str_VendorNameByType ;
	private String str_VendorType;
	private String str_VendorName1;

	public String getStr_VendorType() {
		return str_VendorType;
	}

	public void setStr_VendorType(String str_VendorType) {
		this.str_VendorType = str_VendorType;
	}

	public String getStr_VendorName1() {
		return str_VendorName1;
	}

	public void setStr_VendorName1(String str_VendorName1) {
		this.str_VendorName1 = str_VendorName1;
	}
	 
		public List<String> vendorTypeChangeListener(ValueChangeEvent event)
		{   
			str_VendorType=(String) event.getNewValue();
			System.out.println(str_VendorType);
			str_VendorNameByType=new ArrayList<String>();
			str_VendorNameByType.addAll(getVendorservice().listOfVendorNameByType(str_VendorType));
			System.out.println(str_VendorNameByType);
			return str_VendorNameByType ;
			
	}

		public List<String> getStr_VendorNameByType() {
			if ((str_VendorType != null)) {
				 
				return str_VendorNameByType;
			} else
				return new ArrayList<String>();
			 
		}
		
		public String saveVendorTransaction()
		{
			waterVendorTransaction.setStr_VendorType(getStr_VendorType());
			waterVendorTransaction.setStr_VendorName(getStr_VendorName1());
			waterVendorTransaction.setInt_NoOfTankers(getInt_NoOfTankers());
			waterVendorTransaction.setInt_WaterCapacity(getInt_WaterCapacity());
			waterVendorTransaction.setInt_WaterPrice(getInt_WaterPrice());
			waterVendorTransaction.setStr_DriverName(getStr_DriverName());
			waterVendorTransaction.setDate_TranscationDate(  getDate_TDate());
			waterVendorTransaction.setInt_TransactionId(getInt_TransactionId());
			
			getVendorservice().saveWaterTransaction(waterVendorTransaction);
			
			return "watervendortransactionlist.xhtml";
		}

		public List<WaterVendorTransaction> getWaterVendortransaction1() {
			waterVendortransaction1=new ArrayList<WaterVendorTransaction>();
			waterVendortransaction1.addAll(getVendorservice().getWaterVendortransaction());
			
			return waterVendortransaction1;
		}

		public void setWaterVendortransaction1(
				List<WaterVendorTransaction> waterVendortransaction1) {
			this.waterVendortransaction1 = waterVendortransaction1;
		}
		public String deleteVendorTransaction() {
			WaterVendorTransaction waterVendortransaction2 = new WaterVendorTransaction();
			waterVendortransaction2.setInt_TransactionId(int_TransactionId);
			

			getVendorservice().deleteVendorTransaction(waterVendortransaction2);

			return "watervendortransactionlist?faces-redirect=true";

		}

		public String cancel() 
		{
			return "watervendortransactionlist?faces-redirect=true";
		}

		public void getWaterVendorTransaction1() {
			 
			waterVendorTransaction=getVendorservice().getOneWaterVendorTransaction(int_TransactionId);
			
		}
		 public String updateWaterVendorTransaction()
		 { 
			 String name=waterVendorTransaction.getStr_VendorName();
			  
			 getVendorservice().updateWaterVendorTransaction(waterVendorTransaction); 
			 return "watervendortransactionlist?faces-redirect=true";
			 
		 }	 
		 
		 public List<WaterPayment> getSearchByVendortype() {
				System.out.println(str_VendorType);
				//searchByVendortype=new ArrayList<WaterPayment>();
				//searchByVendortype.addAll(getVendorservice().getSearchByVendortype(str_VendorType,date_FromDate,date_ToDate));
				//System.out.println(searchByVendortype);
				 
				return searchByVendortype;
				
			}
			public String getSearchByVendortype1()
			{
				searchByVendortype=new ArrayList<WaterPayment>();
				searchByVendortype.addAll(getVendorservice().getSearchByVendortype(str_VendorType,date_FromDate,date_ToDate));
				//System.out.println(searchByVendortype);
				return "waterpaymentlist.xhtml";
			}

			public void setSearchByVendortype(List<WaterPayment> searchByVendortype) {
				this.searchByVendortype = searchByVendortype;
			}
			private Date date_FromDate;
			private Date date_ToDate;

			public Date getDate_FromDate() {
				return date_FromDate;
			}

			public void setDate_FromDate(Date date_FromDate) {
				this.date_FromDate = date_FromDate;
			}

			public Date getDate_ToDate() {
				return date_ToDate;
			}

			public void setDate_ToDate(Date date_ToDate) {
				this.date_ToDate = date_ToDate;
			}
			private List<WaterPayment> searchByVendortype;
			 

 }
