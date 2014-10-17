package com.appowner.bean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.dao.DataAccessException;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.PanelPrice;
import com.appowner.model.agency_information;
import com.appowner.service.AdvertisementService;
import com.ibm.icu.text.SimpleDateFormat;

@ManagedBean
@SessionScoped
public class AdvertisementBean  implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	private static final String ERROR   = "error";
	@ManagedProperty(value = "#{AdvertisementService}")
	private AdvertisementService advertisementService;

	public AdvertisementService getAdvertisementService() {
		return advertisementService;
	}
	public void setAdvertisementService(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}
	private Integer int_agencyid;
	
	public Integer getInt_agencyid() {
		return int_agencyid;
	}
	public void setInt_agencyid(Integer int_agencyid) {
		this.int_agencyid = int_agencyid;
	}
	private String str_agencyname;
	private String ads_type;
	private String str_addposition;
	private String str_content;
	 private String var_image; 	
	 private String cname;
	 
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getVar_image() {
		return var_image;
	}
	public void setVar_image(String var_image) {
		this.var_image = var_image;
	}
	public String getStr_agencyname() {
		return str_agencyname;
	}
	public void setStr_agencyname(String str_agencyname) {
		this.str_agencyname = str_agencyname;
	}
	public String getAds_type() {
		return ads_type;
	}
	public void setAds_type(String ads_type) {
		this.ads_type = ads_type;
	}
	public String getStr_addposition() {
		return str_addposition;
	}
	public void setStr_addposition(String str_addposition) {
		this.str_addposition = str_addposition;
	}
	public String getStr_content() {
		return str_content;
	}
	public void setStr_content(String str_content) {
		this.str_content = str_content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Integer int_CompanyPersonID;
	public Integer getInt_CompanyPersonID() {
		return int_CompanyPersonID;
	}
	public void setInt_CompanyPersonID(Integer int_CompanyPersonID) {
		this.int_CompanyPersonID = int_CompanyPersonID;
	}
	public String getStr_CompanyPersonName() {
		return str_CompanyPersonName;
	}
	public void setStr_CompanyPersonName(String str_CompanyPersonName) {
		this.str_CompanyPersonName = str_CompanyPersonName;
	}
	public String getStr_Designation() {
		return str_Designation;
	}
	public void setStr_Designation(String str_Designation) {
		this.str_Designation = str_Designation;
	}
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getStr_MobileNo() {
		return str_MobileNo;
	}
	public void setStr_MobileNo(String str_MobileNo) {
		this.str_MobileNo = str_MobileNo;
	}
	private String str_CompanyPersonName;
	private String str_Designation;
	private String str_Email;
	private String str_MobileNo;
    public String addCompany()
	{  try{
		Company cmp=new Company();
		cmp.setStr_CompanyName(getStr_CompanyName());
		cmp.setStr_CompanyAddress(getStr_CompanyAddress());
		cmp.setStr_City(getStr_City());
		cmp.setStr_State(getStr_State());
		cmp.setInt_Zipcode(getInt_Zipcode());
		cmp.setStr_Mobile(getStr_Mobile());
	//	cmp.setInt_NoOfPerson(getInt_NoOfPerson());
		cmp.setStr_CompanyType(getStr_CompanyType());
		
		getAdvertisementService().addCompany(cmp);
		CompanyPerson cmpp=new CompanyPerson();
		cmpp.setStr_CompanyPersonName(getStr_CompanyPersonName());
		cmpp.setStr_Designation(getStr_Designation());
		cmpp.setStr_Email(getStr_Email());
		cmpp.setStr_MobileNo(getStr_MobileNo());
		cmpp.setStr_CompanyName(cmp.getStr_CompanyName());
		cmpp.setInt_CompanyID(cmp.getInt_CompanyID());
		getAdvertisementService().addCompanyPerson(cmpp);
		return "companysuccess.xhtml";
	}
	catch(DataAccessException e)
	{e.printStackTrace();
		
	}
	return ERROR;
		
	}
   
    //Getting list of Company
    
    private List<Company> ListCompany;
	public List<Company> getListCompany() {
		ListCompany= new ArrayList<Company>();
		ListCompany.addAll(getAdvertisementService().listCompany());
		return ListCompany;
	}
	public void setListCompany(List<Company> listCompany) {
		ListCompany = listCompany;
	}
	
	//Getting list CompanyPerson
	
	
	
	private Integer int_CompanyID;
	public Integer getInt_CompanyID() {
		return int_CompanyID;
	}
	public void setInt_CompanyID(Integer int_CompanyID) {
		this.int_CompanyID = int_CompanyID;
	}
	public String getStr_CompanyName() {
		return str_CompanyName;
	}
	public void setStr_CompanyName(String str_CompanyName) {
		this.str_CompanyName = str_CompanyName;
	}
	public String getStr_CompanyAddress() {
		return str_CompanyAddress;
	}
	public void setStr_CompanyAddress(String str_CompanyAddress) {
		this.str_CompanyAddress = str_CompanyAddress;
	}
	public String getStr_City() {
		return str_City;
	}
	public void setStr_City(String str_City) {
		this.str_City = str_City;
	}
	public String getStr_State() {
	
		return str_State;
	}
	public void setStr_State(String str_State) {
		this.str_State = str_State;
	}
	public Integer getInt_Zipcode() {
		return int_Zipcode;
	}
	public void setInt_Zipcode(Integer int_Zipcode) {
		this.int_Zipcode = int_Zipcode;
	}
	public String getStr_Mobile() {
		return str_MobileNo;
	}
	public void setStr_Mobile(String str_Mobile) {
		this.str_Mobile = str_Mobile;
	}
	private String str_CompanyName;
	private String str_CompanyAddress;
	private String str_City;
	private String str_State;
	private Integer int_Zipcode;
	private String str_Mobile;
	private String str_CompanyType;

	public String getStr_CompanyType() {
		return str_CompanyType;
	}
	public void setStr_CompanyType(String str_CompanyType) {
		this.str_CompanyType = str_CompanyType;
	}
	
	
	private List<CompanyPerson> listCompanyPerson1;
	public List<CompanyPerson> getListCompanyPerson1() {
		listCompanyPerson1=new ArrayList<CompanyPerson>();
		listCompanyPerson1.addAll(getAdvertisementService().listCompanyPerson());
		return listCompanyPerson1;
	}
		
	public void setListCompanyPerson1(List<CompanyPerson> listCompanyPerson1) {
		this.listCompanyPerson1 = listCompanyPerson1;
	}
	private CompanyPerson person;	
			
	public CompanyPerson getPerson() {
		return person;
	}
	public void setPerson(CompanyPerson person) {
		this.person = person;
	}
	
		
	private List<CompanyPerson> person1;
	public List<CompanyPerson> getPerson1() {
		return person1;
	}
	public void setPerson1(List<CompanyPerson> person1) {
		this.person1 = person1;
	}
	@PostConstruct
    public void init() {
	person1=new ArrayList<CompanyPerson>();
	}
	public void add() {
		CompanyPerson person2=new CompanyPerson();
	     person1.add(person2);
		 
	}
	private PanelPrice panel;
	 public PanelPrice getPanel() {
		return panel;
	}
	public void setPanel(PanelPrice panel) {
		this.panel = panel;
	}
	private String str_Panel;
	  public String getStr_Panel() {
		return str_Panel;
	}
	public void setStr_Panel(String str_Panel) {
		this.str_Panel = str_Panel;
	}
	public double getDoub_Price() {
		return doub_Price;
	}
	public void setDoub_Price(double doub_Price) {
		this.doub_Price = doub_Price;
	}
	private double doub_Price;
	private Integer int_PanelID;
	  public Integer getInt_PanelID() {
			return int_PanelID;
		}
		public void setInt_PanelID(Integer int_PanelID) {
			this.int_PanelID = int_PanelID;
		}
		 public String addPanel()
			{  try{
				PanelPrice panel=new PanelPrice();
				panel.setStr_Panel(getStr_Panel());
				panel.setDoub_Price(getDoub_Price());
				getAdvertisementService().addPanel(panel);
				
				return "PanelPriceView.xhtml";
			}
			catch(DataAccessException e)
			{e.printStackTrace();
				
			}
			return ERROR;
				
			}
		 private List<PanelPrice> ListPanelPrice;
			public List<PanelPrice> getListPanelPrice() {
				ListPanelPrice	= new ArrayList<PanelPrice>();
				ListPanelPrice.addAll(getAdvertisementService().listPanelPrice());
				System.out.println(ListPanelPrice);
			return ListPanelPrice;
			}
			public void setListPanelPrice(List<PanelPrice> listPanelPrice) {
				ListPanelPrice= listPanelPrice;
			}
			public Boolean getEditable() {
				return editable;
			}
			public void setEditable(Boolean editable) {
				this.editable = editable;
			}
			private Boolean editable;

			public String editAction(PanelPrice panel) {
				panel.setEditable(true);
				 
				return  null;
			}
			public String saveAction() {
				 
				//get all existing value but set "editable" to false 
				for (PanelPrice panel : ListPanelPrice){
					panel.setEditable(false);
				}
				System.out.println(ListPanelPrice);
				//return to current page
				return null;
		 
			}
			private Company cmp1;
			public Company getCmp1() {
				return cmp1;
			}
			public void setCmp1(Company cmp1) {
				this.cmp1 = cmp1;
			}
			public void getCompany()
			{
			cmp1=getAdvertisementService() .getCompany(int_CompanyID);
				
			}
			
			
			public String saveCompany( ) {
				 
				//System.out.println(emp.getEmpId());
				
				getAdvertisementService() .update(cmp1);
					
				
				
				
				return "companysuccess.xhtml";
			}
			 private  List<CompanyPerson> listCompanyPerson2;
			 public  List<CompanyPerson> getListCompanyPerson2() {
				 listCompanyPerson1= new ArrayList<CompanyPerson>();
				 listCompanyPerson1.addAll(getAdvertisementService() .getCompanyPerson(int_CompanyID));
					return listCompanyPerson1;
					 
			}
			public  void setListCompanyPerson2(List<CompanyPerson> listCompanyPerson1) {
				this.listCompanyPerson1 = listCompanyPerson1;
			}
			 public CompanyPerson getCmpp() {
				return cmpp;
			}
			public void setCmpp(CompanyPerson cmpp) {
				this.cmpp = cmpp;
			}
			private CompanyPerson cmpp;

			
			
			
			
			
			public void getCompanyPerson1()
			
			{	
				 cmpp=getAdvertisementService().getCompanyPerson1(int_CompanyPersonID);
				
			}
			
			
			public String saveCompanyPerson( ) {
				 
				//System.out.println(emp.getEmpId());
				
				getAdvertisementService().update(cmpp);
					
				
				
				
				return "person1.xhtml";
			}
			 private String selected;  
			   
			    public String getSelected() {  
			        return selected;  
			    }  
			   
			    public void setSelected(String selected) {  
			        this.selected = selected;  
			    }  
			
			    public String onEdit(RowEditEvent event)
			    {
			   PanelPrice panel=(PanelPrice)event.getObject();
			  String str= panel.getStr_Panel();
			  double str1=panel.getDoub_Price();
			   System.out.println(str);
			   System.out.println(str1);
			     return null;
			     
			    
			  }
			    private String blb_image;
			    
			    public String getBlb_image() {
					return blb_image;
				}
				public void setBlb_image(String blb_image) {
					this.blb_image = blb_image;
				}
				private List<Company>listperson;

				public List<Company> getListperson() 
				{
					listperson= new ArrayList<Company>();
					listperson.addAll(getAdvertisementService().listperson1());
			    
					return listperson;
				}
				public void setListperson(List<Company> listperson) {
					this.listperson = listperson;
				}
				private String str_Description;
				
				public String getStr_Description() {
					return str_Description;
				}
				public void setStr_Description(String str_Description) {
					this.str_Description = str_Description;
				}
				private String var_ImageName;
				
				public String getVar_ImageName() {
					return var_ImageName;
				}
				public void setVar_ImageName(String var_ImageName) {
					this.var_ImageName = var_ImageName;
				}
				private String path1;
				public String getPath1() {
					return path1;
				}
				public void setPath1(String path1) {
					this.path1 = path1;
				}
				private String blb_image1;
				
				
				public String getBlb_image1() {
					blb_image1="aaa";
					return blb_image1;
				}
				public void setBlb_image1(String blb_image1) {
					this.blb_image1 = blb_image1;
				}
				public void handleFileUpload1(FileUploadEvent event) throws IOException {
					 System.out.println("hi");
					 String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
					    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
					    String name = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
					    System.out.println(name);
					    File file= new File("D://Image\\"+ "images" + name);
					    final UploadedFile uploadedFile = event.getFile();
					    blb_image=file.getAbsolutePath();
					   
					  
					   
					    blb_image2=file.getAbsolutePath();
					    blb_image3=file.getAbsolutePath();
					    System.out.println(blb_image);
					   
					   System.out.println(file);
				       InputStream is = event.getFile().getInputstream();
					    OutputStream out = new FileOutputStream(file);
					    byte buf[] = new byte[1024];
					    int len;
					    while ((len = is.read(buf)) > 0)
					        out.write(buf, 0, len);
					    is.close();
					    out.close();
					    path1=file.getName();
					    System.out.println(path1);
					   
				}
				private String blb_image3;
				
				public String getBlb_image3() {
					return blb_image3;
				}
				public void setBlb_image3(String blb_image3) {
					this.blb_image3 = blb_image3;
				}
				private String blb_image2;
				
				public String getBlb_image2() {
					return blb_image2;
				}
				public void setBlb_image2(String blb_image2) {
					this.blb_image2 = blb_image2;
				}
				private String path2;
				
				public String getPath2() {
					return path2;
				}
				public void setPath2(String path2) {
					this.path2 = path2;
				}
				public List<Company> agency;
				
				
				public List<Company> getAgency() {
					return agency;
				}
				public void setAgency(List<Company> agency) {
					this.agency = agency;
				}
				public String select;
				
				public String getSelect() {
					return select;
				}
				public void setSelect(String select) {
					this.select = select;
				}
				public List<String> selectinfo(ValueChangeEvent event)
				{  
					select =( String )event.getNewValue();
					System.out.println(select);
					agency=getAdvertisementService().listoperation(select);
				/*	getStr_City();
						ListIterator list=agency.listIterator();
					while(list.hasNext())
					{
						Object obj=list.next();
						Company company=(Company)obj;
						str_State=company.getStr_State();
						System.out.println(str_State);
						str_CompanyAddress=company.getStr_CompanyAddress();
						System.out.println(str_CompanyAddress);
						str_Mobile=company.getStr_Mobile();
						str_City=company.
					}*/
                			
					
					
					
					System.out.println(agency);
					return null;
		}
				public String agencyname1;
				public int agencyid1;
				public void addagency()
				{  
					agencyname1=getStr_CompanyName();
					System.out.println(agencyname1);
					agencyid1=getAdvertisementService().agency1(agencyname1);
					agency_information agency=new agency_information();
					agency.setInt_CompanyID(agencyid1);
					agency.setAds_type(getAds_type());
					agency.setStr_addposition(getStr_addposition());
					agency.setStr_CompanyName(getStr_CompanyName());
					agency.setVar_ImageName(path1);
					agency.setStr_content(getStr_content());
				    getAdvertisementService().addagencies(agency);
					
					
}
				
				private List<agency_information>agencies;

				public List<agency_information> getAgencies()
				{
					agencies=new ArrayList<agency_information>();
					agencies.addAll(getAdvertisementService().agencies1());
					System.out.println(agencies);
					return agencies;
				}
				public void setAgencies(List<agency_information> agencies) {
					this.agencies = agencies;
			
				}
				
				public String deleteagency(Integer id)
				{
					System.out.println(id);
					agency_information category=new agency_information();
					//System.out.println(Int_Document_CatID);
					category.setInt_agencyid(id);
					getAdvertisementService().Deleted(category);	
					System.out.println("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
					
					return "ViewAgency.xhtml";

				}
				public String Var_ImageName;
				 private String blb_images1;
				 
				public String getBlb_images1() {
					return blb_images1;
				}
				public void setBlb_images1(String blb_images1) {
					this.blb_images1 = blb_images1;
				}
				private agency_information pro2;
				 private List<String> pro1;
				 
				 
				 
				public List<String> getPro1() {
					return pro1;
				}
				public void setPro1(List<String> pro1) {
					this.pro1 = pro1;
				}
				public agency_information getPro() {
						return pro2;
					}
					public void setPro(agency_information pro2) {
						this.pro2 = pro2;
					}
				public void agencydetail(){
					System.out.println(int_agencyid);
					pro2=getAdvertisementService().editproduct(int_agencyid);
				System.out.println("111111111111111111111111111111111111111111");
					System.out.println(pro2.getInt_agencyid());
					prointcatid=getAdvertisementService().editproductaa(pro2.getInt_agencyid());
					System.out.println("222222222222222222222222222");
					System.out.println(prointcatid);
					pro1=getAdvertisementService().editproduct2(prointcatid);
					Var_ImageName=pro2.getVar_ImageName();
					 blb_image="D://Image\\"+Var_ImageName;
					 System.out.println(blb_image);
					ListIterator list=pro1.listIterator();
					while(list.hasNext())
					{
						Company company=(Company)list.next();
						str_City=company.getStr_City();
						str_State=company.getStr_State();
						str_Mobile=company.getStr_Mobile();
						str_CompanyAddress=company.getStr_CompanyAddress();
						str_MobileNo=company.getStr_Mobile();
						System.out.println(str_Mobile);
						System.out.println(str_City);
					}
					System.out.println(pro1);
					
					 }	
				
				public int prointcatid;

				public int getProintcatid() {
					return prointcatid;
				}
				public void setProintcatid(int prointcatid) {
					this.prointcatid = prointcatid;
				}
				
				
			
}
		
		
	

	 
	 
	

