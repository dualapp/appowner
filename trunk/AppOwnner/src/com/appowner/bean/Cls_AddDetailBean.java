package com.appowner.bean;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.Column;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Cls_subcategoryDetail;
import com.appowner.model.DueTemplate;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.User;
import com.appowner.model.cls_Ads;
import com.appowner.service.ProductsDetailService;
import com.appowner.util.Util;
import com.ibm.icu.text.SimpleDateFormat;
@ManagedBean 
@SessionScoped
public class Cls_AddDetailBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final String SEARCHBYPRODUCTTYPE = "searchByProducttype";
	
	 @PostConstruct
	 public void init()
	 {
   Ch_Product_Type="Sell"; 
   Ch_Ad_Type = "My Community";
	 }
	  public String getCh_Product_Type() {
     return Ch_Product_Type;
		
	}
	public void setCh_Product_Type(String ch_Product_Type) {
		Ch_Product_Type = ch_Product_Type;
	}
	private Integer Int_ProductId;
	private String Ch_Product_Type;
	private Date dt_date;
	
	
	public Date getDt_date() {
		return dt_date;
	}
	public void setDt_date(Date dt_date) {
		this.dt_date = dt_date;
	}
	private boolean selected;
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
 	 public boolean isSelected() {
	    return selected;
	  }
 	private Integer Adsid;
 	private String str_category;
 	private String  str_title;
 	private String  message1;
	private String Var_Title;
	private String Var_FileName;
	private String Var_ImageName;
	public String shellname;
	private String Var_Description;
	//private String var_Ad_CategoryName;
	private String Ch_Ad_Type;
	private int int_Ad_categoryId;
	 public int intdocID1;
	 public String Aprtid; 
	public String intdocid1;
	private String Status;
	public int prointcatid;
	
	
	public int getProintcatid() {
		return prointcatid;
	}
	public void setProintcatid(int prointcatid) {
		this.prointcatid = prointcatid;
	}
	private String str_ApartmentName;
	   public String getStr_ApartmentName() {
		  str_ApartmentName=Util.getAppartmentName();
		   System.out.println(str_ApartmentName);
			return str_ApartmentName;
		}
		public void setStr_ApartmentName(String str_ApartmentName) {
			this.str_ApartmentName = str_ApartmentName;
		}
		
		private int userId;
		
       public int getUserId() {
	   userId=Util.getUserId();
	
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		
	private String usrname;
	
   public String getUsrname()
   {
	   usrname=Util.getUserName();
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
public int getInt_Ad_categoryId() {
      return int_Ad_categoryId;
	}
	public void setInt_Ad_categoryId(int int_Ad_categoryId) {
		this.int_Ad_categoryId = int_Ad_categoryId;
	}
		public String getVar_Ad_CategoryName() {
			return var_Ad_CategoryName;
		}
		public void setVar_Ad_CategoryName(String var_Ad_CategoryName) {
			this.var_Ad_CategoryName = var_Ad_CategoryName;
		}
	private String var_Ad_CategoryName;
	
	 public String getBlb_image() {
		return blb_image;
	}
	public void setBlb_image(String blb_image) {
		this.blb_image = blb_image;
	}
	private String blb_image;
	 private String blb_images1;

	public String getBlb_images1() {
		return blb_images1;
	}
	public void setBlb_images1(String blb_images1) {
		this.blb_images1 = blb_images1;
	}
	public String getVar_Description() {
		return Var_Description;
	}
	public void setVar_Description(String var_Description) {
		Var_Description = var_Description;
	}
	
	
	public String getCh_Ad_Type() {
		
		return Ch_Ad_Type;
	}
	public void setCh_Ad_Type(String ch_Ad_Type) {
		Ch_Ad_Type = ch_Ad_Type;
	}
	public Integer getInt_ProductId() {
		return Int_ProductId;
	}
	public void setInt_ProductId(Integer int_ProductId) {
		Int_ProductId = int_ProductId;
	}
	
	
	public String getVar_Title() {
		return Var_Title;
	}
	public void setVar_Title(String var_Title) {
		Var_Title = var_Title;
	}
	public String getVar_FileName() {
		return Var_FileName;
	}
	public void setVar_FileName(String var_FileName) {
		Var_FileName = var_FileName;
	}
	public String getVar_ImageName()
	{ 
		return Var_ImageName;
	}
	public void setVar_ImageName(String var_ImageName) {
		Var_ImageName = var_ImageName;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	
	}
	@ManagedProperty(value ="#{ProductDetailService}")
	 
	private ProductsDetailService productDetailService;
	
	
	public ProductsDetailService getProductDetailService() {
		return productDetailService;
	}
	public void setProductDetailService(ProductsDetailService productDetailService) {
		this.productDetailService = productDetailService;
	}
	private String intdocid2;
	private int intdocID2;
	
	private String intdocid3;
	private int intdocID3;
	private String subcatid;
	private int subid;
	private String str_Email;
	private String str_Block;
	
	public String getStr_Email() {
		return str_Email;
	}
	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}
	public String getStr_Block() {
		return str_Block;
	}
	public void setStr_Block(String str_Block) {
		this.str_Block = str_Block;
	}
	public String  AddProduct(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Var_Description=request.getParameter("limitedtextfield");
		 System.out.println("mukesh kumar 1989hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	     intdocid1=getVar_Ad_CategoryName();
		 System.out.println(intdocid1);
		 subcatid=getVar_subscategoryname();
		 System.out.println( subcatid+"mk bihar");
		 System.out.println(var_Ad_SubCategoryName+"mukesh bihar patna");
		 intdocID1=getProductDetailService().getdocid2(intdocid1);
		 subid=getProductDetailService().getdid(var_Ad_SubCategoryName);
		 System.out.println(subid+"khkjhkgkjhkjghkjghkguhguhu");
		 intdocid2=getStr_ApartmentName();
		 System.out.println(intdocid1);
		 Cls_ProductDetails pro=new Cls_ProductDetails();
		pro.setInt_Ad_categoryId(intdocID1);
		pro.setInt_subcategoryId( subid);
        pro.setUserId(getUserId());
		pro.setCh_Product_Type(getCh_Product_Type());
		pro.setInt_ProductId(getInt_ProductId());
		pro.setVar_Description(getVar_Description());
		pro.setUsername(Util.getUserName());
		pro.setApartementId(Util.getAppartmentId());
		pro.setVar_FileName("image");
		System.out.println(path+"fkjfdkjdfjk");
		pro.setVar_ImageName(path);
        pro.setVar_Title(getVar_Title());
		pro.setCh_Ad_Type(getCh_Ad_Type());
		pro.setStr_ApartmentName(str_ApartmentName);
		pro.setStr_Email(Util.getEmail());
		pro.setStr_PhoneNo(Util.getStr_PhoneNo());
		pro.setStr_Block(Util.getBlock());
		pro.setStatus("Pending Approval");
		java.util.Date d=new java.util.Date();
		System.out.println(d+"dskdskdslkk");
		Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.MONTH,1);
		d=cal1.getTime();
		pro.setClosedate(d);
		System.out.println(d+"sdkk");
		System.out.println(pro+"kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjjkjkjkjkjk");
		getProductDetailService().AddProduct1(pro);
		  str_Email=null;
		  str_Block=null;
		  path=null;
		  str_PhoneNo=null;
		  Ch_Product_Type="Sell";
	      Var_Title=null;
          Var_FileName=null;
          Ch_Ad_Type="My Community";
          dt_date=null;
     	  Status=null;
     	  closedate=null;
     	  Var_Description=null;
     	  Var_ImageName=null;
     	  var_Ad_CategoryName=null;
    	 var_subscategoryname=null;
    	
     	 selectedAll=null;
     	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Your Information  Post Successfully!"));
    	return"Ad_an_Post.xhtml";
		
	
	}
private Date closedate;
	
	
	
	
	public Date getClosedate() {
		return closedate;
	}
	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}
	private String var_Ad_SubCategoryName;
	public String getVar_Ad_SubCategoryName() {
		return var_Ad_SubCategoryName;}
	public void setVar_Ad_SubCategoryName(String var_Ad_SubCategoryName) {
		this.var_Ad_SubCategoryName = var_Ad_SubCategoryName;
	}
		public void AddCategory(){
		Cls_categoryDetail Cat=new Cls_categoryDetail();
	      System.out.println("hi");
	      Cat.setInt_Ad_categoryId(getInt_Ad_categoryId()); 
		  Cat.setVar_Ad_CategoryName(getVar_Ad_CategoryName());
		 System.out.println(var_Ad_CategoryName);
		 getProductDetailService().AddCategorys(Cat);
		}
		private int int_subcategoryId;
		private String var_subscategoryname;
		public int getInt_subcategoryId() {
			return int_subcategoryId;
		}
		public void setInt_subcategoryId(int int_subcategoryId) {
			this.int_subcategoryId = int_subcategoryId;
		}
		public String getVar_subscategoryname() {
			return var_subscategoryname;
		}
		public void setVar_subscategoryname(String var_subscategoryname) {
			this.var_subscategoryname = var_subscategoryname;
		}
	   
		public void AddSubCategory()
		{
		System.out.println(var_Ad_CategoryName+"jkjdkjcghjksdghjasghjshdlhkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		 Cls_subcategoryDetail detail=new Cls_subcategoryDetail();	
		detail.setInt_subcategoryId(int_subcategoryId);
		detail.setVar_subscategoryname(var_subscategoryname);
		detail.setInt_Ad_categoryId(getProductDetailService().getcatid(var_Ad_CategoryName));
		getProductDetailService().AddCategorys(detail);
		var_subscategoryname=null;
		
		}
		
	private List<String>Categories;
    public List<String> getCategories() 
	{
    Categories=new ArrayList<String>();
	Categories.addAll(getProductDetailService().getCategories());
	System.out.println(Categories);
	return Categories;
}
	public void setCategories(List<String> categories) {
	this.Categories = categories;
	
}

	
	private String path1;
	public String getPath1() {
		return path1;
	}
	public void setPath1(String path1) {
		this.path1 = path1;
	}
	public void handleFileUpload1(FileUploadEvent event) throws IOException {
		 System.out.println("hi");
		 String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		    String name = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
		    System.out.println(name);
		    File file= new File("E://"+ "images" + name);
		    final UploadedFile uploadedFile = event.getFile();
		    blb_image=file.getAbsolutePath();
		    System.out.println(blb_image);
		    blb_images1=file.getAbsolutePath();
		    System.out.println(blb_images1);
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
	
	

	//Edit
	 private Cls_ProductDetails pro2;
	 private String pro1;
	 
	 
	 public String getPro1() {
		return pro1;
	}
	public void setPro1(String pro1) {
		this.pro1 = pro1;
	}
	public Cls_ProductDetails getPro() {
			return pro2;
		}
		public void setPro(Cls_ProductDetails pro2) {
			this.pro2 = pro2;
		}
		public void getCls_ProductDetails(){
		System.out.println(Int_ProductId);
		pro2=getProductDetailService().editproduct(Int_ProductId);
	    System.out.println("111111111111111111111111111111111111111111");
		System.out.println(pro2.getInt_ProductId());
		prointcatid=getProductDetailService().editproductaa(pro2.getInt_ProductId());
		System.out.println("222222222222222222222222222");
		System.out.println(prointcatid);
		pro1=getProductDetailService().editproduct2(prointcatid);
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		System.out.println(pro1);
		Var_ImageName=pro2.getVar_ImageName();
		 blb_images1="D://Image\\"+Var_ImageName;
		 System.out.println(blb_images1);
		 }
	private List<Cls_ProductDetails> listPerson;
	public List<Cls_ProductDetails> getListPerson() {
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		listPerson= new ArrayList<Cls_ProductDetails>();
		listPerson.addAll(getProductDetailService().listPersons());
		
		System.out.println(listPerson);
		return listPerson;
	}
	public void setListPerson(List<Cls_ProductDetails> listPerson) {
		this.listPerson = listPerson;
	}
	
	
	/*private String list3;
	
	
	public String getList3() {
		list3.add(listcategory);
		list3.add(listcategory1);
		return list3;
	}
	public void setList3(List<String> list3) {
		this.list3 = list3;
	}
	*/
	private List<Cls_ProductDetails>listcategory1;
	
	
	public List<Cls_ProductDetails> getListcategory1() {
		listcategory1= new ArrayList<Cls_ProductDetails>();
		listcategory1.addAll(getProductDetailService().listcategory1());
		
		return listcategory1;
	}
	public void setListcategory1(List<Cls_ProductDetails> listcategory1) {
		this.listcategory1 = listcategory1;
	}
    private List<Cls_categoryDetail>listcategory;
	public List<Cls_categoryDetail> getListcategory() {
		listcategory= new ArrayList<Cls_categoryDetail>();
		listcategory.addAll(getProductDetailService().listcategory());
		
		return listcategory;
	}
	public void setListcategory(List<Cls_categoryDetail> listcategory) {
		this.listcategory = listcategory;
	}
	
	
	
	private Cls_ProductDetails product=new Cls_ProductDetails();

	public Cls_ProductDetails getProduct() {
		return product;
	}
	public void setProduct(Cls_ProductDetails product) {
		this.product = product;
	}
	private List<Cls_ProductDetails>  listDetails;
	public List<Cls_ProductDetails> getListDetails() {
		return listDetails;
	}
	public void setListDetails(List<Cls_ProductDetails> listDetails) {
		this.listDetails = listDetails;
	}
	private List<Cls_ProductDetails> searchByProducttype;
	
	 public List<Cls_ProductDetails> getSearchByProducttype() {
		 searchByProducttype=new ArrayList<Cls_ProductDetails>();
		 searchByProducttype.addAll(getProductDetailService().getSearchByProducttype(Ch_Product_Type,Ch_Ad_Type,Status));
		 blb_images1="E:/Var_ImageName";
			return searchByProducttype;
			
			
	 }
	      public String getSearchByProducttype1()
		{
			 searchByProducttype=new ArrayList<Cls_ProductDetails>();
			 System.out.println(Ch_Product_Type);
			 searchByProducttype.addAll(getProductDetailService().getSearchByProducttype(Ch_Product_Type,Ch_Ad_Type,Status));
			 Ch_Product_Type="Sell";
			 Ch_Ad_Type="My Community";
			return "Ad_an_Post.xhtml?faces-redirect=true";
		}
		
		public void setSearchByProducttype(List<Cls_ProductDetails> searchByProducttype) {
			this.searchByProducttype = searchByProducttype;
		}

		
	////////////////////////////////////////////////////
	/*public List<Cls_ProductDetails> typeChangeListener(ValueChangeEvent event)
	{
     System.out.println(event.getNewValue());
	Ch_Product_Type=(char) event.getNewValue();
	listDetails=new ArrayList<Cls_ProductDetails>();
	listDetails.addAll(getProductDetailService().getDetails(Ch_Product_Type));
	System.out.println(listDetails.listIterator().hasNext());
	      return listDetails;
	}
	public String searchbyname() {
	System.out.println(Ch_Product_Type);
	   if (listDetails!= null) 
	   {
			return "View_Details.xhtml?faces-redirect=true";
			
		} else
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("User does not exist!!!!!"));
			return null;
		}
	*/
		
		public String deleteDetail(int a)
		{
			System.out.println("hhhhhhhhhhhh");
			System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			System.out.println(a);
			Cls_ProductDetails category=new Cls_ProductDetails();
			//System.out.println(Int_Document_CatID);
			category.setInt_ProductId(a);
			getProductDetailService().Deletedoc(category);	
			System.out.println("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
			System.out.println(a);
			return "Ad_an_Post.xhtml";

		}
		private Cls_ProductDetails edit ;
		public void setEdit(Cls_ProductDetails edit) {
			this.edit = edit;
		}
		public Cls_ProductDetails getEdit() {
			return edit;
		}
		public void getedit()
		{ 
			
			edit=new Cls_ProductDetails();
		System.out.println(Int_ProductId);
		edit =getProductDetailService().getEdit(id);
		Var_ImageName=edit.getVar_ImageName();
		 blb_images1="D://Image\\"+Var_ImageName;
		 System.out.println(blb_images1);
			}
		public String saveContact( ) {
			 if(edit.getInt_ProductId()!=null)
		
				getProductDetailService().update(edit);
			else		
				getProductDetailService().addContact(edit);
		      return "Ad_an_Post.xhtml";
				 
		}
		
		private HtmlDataTable updatedAccounts;
		public HtmlDataTable getUpdatedAccounts() {
			return updatedAccounts;
		}
		public void setUpdatedAccounts(HtmlDataTable updatedAccounts) {
			this.updatedAccounts = updatedAccounts;
		}
		
	private static Integer id;	  
		
    public static Integer getId() {
		return id;
	}
	public static void setId(Integer id) {
		Cls_AddDetailBean.id = id;
	}
	private static String approval;
	public static String getApproval() {
		return approval;
	}
	public static void setApproval(String approval) {
		Cls_AddDetailBean.approval = approval;
	}
	
	
	private static String close;
	
    public static String getClose() {
		return close;
	}
	public static void setClose(String close) {
		Cls_AddDetailBean.close = close;
	}
	public void processValueChange(ValueChangeEvent event)  throws AbortProcessingException {
	System.out.println("mukesh yadav");
	product=(Cls_ProductDetails)dataTable.getRowData();
	id=product.getInt_ProductId();
	System.out.println(id);
	approval=product.getStatus();
	}
	private Cls_ProductDetails edit1 ;
	
	public Cls_ProductDetails getEdit1() {
		return edit1;
	}
	public void setEdit1(Cls_ProductDetails edit1) {
		this.edit1 = edit1;
	}
	public void getedit1(int id1)
	{ 
		
	edit1=new Cls_ProductDetails();
	System.out.println(Int_ProductId);
	edit1 =getProductDetailService().getEdit1(id1);
	Var_ImageName=edit1.getVar_ImageName();
	 blb_images1="E://Var_ImageName";
	 System.out.println(blb_images1);
	 System.out.println(edit1);
		}
	public String saveContact1( ) {
		 if(edit1.getInt_ProductId()!=null)
	
			getProductDetailService().update3(edit1);
		else		
			getProductDetailService().addContact1(edit1);
	      return "Ad_an_Post.xhtml";
			 
	}
	private DataTable dataTable;

	public DataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	
	
	private Cls_ProductDetails updation;

	public Cls_ProductDetails getUpdation() {
		return updation;
	}
	public void setUpdation(Cls_ProductDetails updation) {
		this.updation = updation;
	}
	private String str;
       public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public void updation(Integer id1){
	   System.out.println(approval);
	   System.out.println(id1);
	   str=LoginBean.getSs();
	   System.out.println(str); 
	   getProductDetailService().datachange(str,id);
	}
	private String str1;
    public String getStr1() {
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
    public void update()
    {
    	str1=LoginBean.getCls();
    	getProductDetailService().valuechange(str1,id);
    }
    private String str2;
    public String getStr2() {
		return str2;
	}
	public void setStr2(String str2) {
		this.str2 = str2;
	}
    private static String reject;

	public static String getReject() {
		return reject;
	}
	public static void setReject(String reject) {
		Cls_AddDetailBean.reject = reject;
	}	  
	
	public void reject1()
	{
		str2=LoginBean.getRes();
		getProductDetailService().valuereject(str2,id);
		
	}
	private String  s1="Ads Reject";
	private String  s2="Maintance got";
	private String  s3="house rent came";
	public String getS1() {
		return s1;
		}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getS3() {
		return s3;
	}
	public void setS3(String s3) {
		this.s3 = s3;
	}
	private String Stament;
	private  String msg;
	public String getMsg() {
		return msg;
	}
	private static String msg1;
	public String getMsg1() {
		
		return msg1;
	}
	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}
	
	public String getStament() {
		return Stament;
	}
	public void setStament(String stament) {
		Stament = stament;
	}
	 public void setMsg(String msg) {
		this.msg = msg;
	}
	
	 
	private String to;

	public String getTo() {
		
		to="im.mukeshkumar89@gmail.com";
		System.out.println(to);
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	 
	private static String message;

public static String getMessage() {
	
	return message;
}
public static void setMessage(String message) {
	Cls_AddDetailBean.message = message;
}
		

	private static String content="content";
	 public static String getContent() {
		return content;
	}
	public static void setContent(String content) {
		Cls_AddDetailBean.content = content;
	}
	public static String getRecipient() {
		return recipient;
	}
	public static void setRecipient(String recipient) {
		Cls_AddDetailBean.recipient = recipient;
	}
	private static String recipient="recipient";
	private static String subject="subject";
	public static String getSubject() {
		return subject;
	}
	public static void setSubject(String subject) {
		Cls_AddDetailBean.subject = subject;
	}
	public String send()
	{
		recipient=getTo();
		content=msg;
		subject="Appowner.com";
		System.out.println(recipient);
		System.out.println(content);
		return "Email.jsp";
	}
	private String msg2;
	
	public String getMsg2() {
		String str="This is to inform you that your ad posting in  ";
		String str1=Util.getAppartmentName();
		String str2="  is now approved.";
		msg2=str+str1+str2;
		System.out.println(msg2+"fjdkfdkjjkdf");
		return msg2;
	}
	public void setMsg2(String msg2) {
		this.msg2 = msg2;
	}
	public String send1()
	{    System.out.println("huyt");
		recipient=getTo();
		approval="approved";
		//System.out.println(id1);
		content=msg2;
		subject="Appowner.com";
		System.out.println(recipient);
		System.out.println(content);
		return "Email.jsp";
	}
	
	
private Cls_ProductDetails selectedAll;



public Cls_ProductDetails getSelectedAll() {
	return selectedAll;
}
public void setSelectedAll(Cls_ProductDetails selectedAll) {
	this.selectedAll = selectedAll;
}
private Cls_categoryDetail cat;
private int   int_subcatid; 
public int getInt_subcatid() {
	return int_subcatid;
}
public void setInt_subcatid(int int_subcatid) {
	this.int_subcatid = int_subcatid;
}
public String editdetail(Cls_ProductDetails ProductDetails)
{
	System.out.println(ProductDetails+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	 System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjlllllllllllllllll");
	 System.out.println(var_Ad_SubCategoryName+"jgfgfnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnmhhhhhhhhhhhhg");
	 System.out.println(var_Ad_CategoryName+"ndffdf");
	System.out.println(subname+"jkfjffjnnnnnnnnnnnnnnnnnn");
	
	 System.out.println(catname+"fdjfdkjfdjdfk");
	   if(catname==null)
	 {
		 
		 //int_Ad_categoryId=getProductDetailService().getdocid2(ProductDetails.getVar_Ad_CategoryName());
		 //int_subcatid=getProductDetailService().getdocid3(ProductDetails.getVar_subscategoryname());
		  System.out.println(int_Ad_categoryId+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		  System.out.println( int_subcatid+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		 // ProductDetails.setInt_Ad_categoryId(int_Ad_categoryId);
		   //ProductDetails.setInt_subcategoryId( int_subcatid);
		 
	 }
	 else{
	  int_Ad_categoryId=getProductDetailService().getdocid2(catname);
	  System.out.println(catname+"fjghjfjjjgopopopopopopopopopopopopopopopopopo");
	  System.out.println(var_Ad_SubCategoryName+"fjghjfjjjgopopopopopopopopopopopopopopopopopo");
	  int_subcatid=getProductDetailService().getdocid3(var_Ad_SubCategoryName);
	  
	   System.out.println( int_subcatid+"jkfkjfdkjpoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
	   ProductDetails.setInt_Ad_categoryId(int_Ad_categoryId);
	   ProductDetails.setInt_subcategoryId( int_subcatid);
	 }
	    if (ProductDetails.getInt_ProductId() != null) {
	    ProductDetails.setVar_Ad_CategoryName(var_Ad_CategoryName);
	    ProductDetails.setVar_ImageName(path3);
		getProductDetailService().updatedetails(ProductDetails);
		Ch_Product_Type="Sell";
        Ch_Ad_Type="My Community";
		 Status=null;
	     selectedAll=null;
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully!"));
	  
	} 
	    
	return "Ad_an_Post.xhtml";
}
	
	
public String deletedetail(){
	Cls_ProductDetails detail=new Cls_ProductDetails();
	System.out.println(Int_ProductId);
	detail.setInt_ProductId(Int_ProductId);;
	getProductDetailService().deleteInvoice(detail);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
	return "Ad_an_Post.xhtml?faces-redirect=true";
  
}

public String cancel() {
	return "Ad_an_Post.xhtml?faces-redirect=true";
}

private List<Cls_ProductDetails> details;

public List<Cls_ProductDetails> getDetails()
{
	System.out.println(Int_ProductId+";;;;;;;;;;;;;;;;;;;;;;;;;;++++++++++++++++++++++++++++++++++++++++");
	details=new ArrayList<Cls_ProductDetails>();
	details.addAll(getProductDetailService().listDetail(Ch_Product_Type,Ch_Ad_Type,Status));
   System.out.println(details+"gvghhhfhfh");
   
	return details;
}
public void setDetails(List<Cls_ProductDetails> details) {
	this.details = details;
}


private String msg3;

public String getMsg3() {
	String str="This is to inform you that your ad posting in  ";
	String str1=Util.getAppartmentName();
	String str2="   is not approved.";
	msg3=str+str1+str2;
	System.out.println(msg2+"fjdkfdkjjkdf");
	return msg3;
}
public void setMsg3(String msg3) {
	this.msg3 = msg3;
}
public String send2()
{    System.out.println("huyt");
	recipient=getTo();
	approval="approved";
	//System.out.println(id1);
	content=msg3;
	subject="Appowner.com";
	System.out.println(recipient);
	System.out.println(content);
	return "Email.jsp";
}
private String msg4;

public String getMsg4() {
	msg4="This is to inform you that your ad posting in Shaffi Paradise is now close.";
	return msg4;
}
public void setMsg4(String msg4) {
	this.msg4 = msg4;
}


private static String aprtmentname;
public static String getAprtmentname() {
	return aprtmentname;
}
public static void setAprtmentname(String aprtmentname) {
	Cls_AddDetailBean.aprtmentname = aprtmentname;
}



public String send4()
{   System.out.println("fkjdfkjfkjfjlkkkkkkkkkkkkkkkkkkkkkkkmukeshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

	recipient= emailids;
	content="";
	subject="Appowner.com";
	aprtmentname=getStr_ApartmentName();
	Ch_Product_Type="Sell";
    Ch_Ad_Type="My Community";
	 Status=null;
return "/AfrteLoginViews/Communication/ApproveEmail.jsp";
}



public static String getMessages() {
	return messages;
}
public static void setMessages(String messages) {
	Cls_AddDetailBean.messages = messages;
}
public Integer getAdsid() {
	return Adsid;
}
public void setAdsid(Integer adsid) {
	Adsid = adsid;
}
public String getStr_category() {
	return str_category;
}
public void setStr_category(String str_category) {
	this.str_category = str_category;
}
public String getStr_title() {
	return str_title;
}
public void setStr_title(String str_title) {
	this.str_title = str_title;
}
public String getMessage1() {
	return message1;
}
public void setMessage1(String message1) {
	this.message1 = message1;
}


public void AddAds(){
	cls_Ads  ads=new cls_Ads();
	
	ads.setMessage1(getMessage1());
	ads.setStr_category(getStr_category());
	ads.setStr_title(str_title);
	getProductDetailService().Addadss(ads);	
}

private List<String>Category;

public List<String> getCategory() {
Category=new ArrayList<String>();
Category.addAll(getProductDetailService().getcat());
System.out.println(Category+"kjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjk");
	return Category;
}
public void setCategory(List<String> category) {
	Category = category;
}
public List<String> adtitle;

public List<String> getAdtitle(){
	adtitle=new ArrayList<String>();
	adtitle.addAll(getProductDetailService().gettitle());
	
	return adtitle;
}
public void setAdtitle(List<String> adtitle) {
	this.adtitle = adtitle;
}
public String getStrmessage() {
	return strmessage;
}
public void setStrmessage(String strmessage) {
	this.strmessage = strmessage;
}
private int ads_id;
public  static  String select;
private String strmessage;

public String selectinfo(ValueChangeEvent event)
{  
select =( String )event.getNewValue();
System.out.println(select+"jhdsjdf");
ads_id=(getProductDetailService().getid(select));
strmessage=(getProductDetailService().getmsg(ads_id));
msgrejectid=(getProductDetailService().getrejectids(selectedAll.getInt_ProductId()));
emailids=(getProductDetailService().getemailids(msgrejectid));
System.out.println(ads_id+"-====-==-=-===-=-=-=-=-=-============-------------============--------------");
System.out.println(strmessage+"-====-==-=-===-=-=-=-=-=-============-------------============--------------");
return select;
}  
   private static String messages;
   
public String send5()
{
	recipient= emailids;
	content="";
	subject="Appowner.com";
	messages=getStrmessage();
	Ch_Product_Type="Sell";
    Ch_Ad_Type="My Community";
	 Status=null;
	return "/AfrteLoginViews/Communication/AdsEmail.jsp";
	
	
}
private boolean emailstatus=true;
public boolean isEmailstatus() {
	return emailstatus;
}
public void setEmailstatus(boolean emailstatus) {  
	this.emailstatus = emailstatus;
}
public String statusmsg;
public String msgupdate; 
public static String select1;
public int selectinfo1(ActionEvent e)
{ 
productid=selectedAll.getInt_ProductId();
System.out.println("lkllklklklklklklklklklklklklklklllkllklklklllllllllllllllkkkkkkkkkkkkkkkk");	
System.out.println(selectedAll.getInt_ProductId()+"dfjfjfjjfmmmmmmmmmmmmmmmmmmmmmmmmmmkesh");
msgupdate=(getProductDetailService().getname(selectedAll.getInt_ProductId()));
msgrejectid=(getProductDetailService().getrejectids(selectedAll.getInt_ProductId()));
emailids=(getProductDetailService().getemailids(msgrejectid));
System.out.println(selectedAll.getStatus()+"kjkjkjkjkjkjkjkjkjkjkjk");
System.out.println(statusmsg=="Ads Rejected"+"lklklklklklklklklklklklk;;';';';';';';';';';';';';';';");
//statusmsg=selectedAll.getStatus();
//if(statusmsg=="Ads Rejected")
//{
	//emailstatus=false;	
//}
   
//statusmsg=(getProductDetailService().statusmesg(selectedAll.getInt_ProductId()));
System.out.println(emailids+"jhdsjdfbnnnnnnnnnnnnnnnbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
System.out.println(msgrejectid+"jhdsjdfbnnnnnnnnnnnnnnnbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
System.out.println(msgupdate+"jhdsjdfbnnnnnnnnnnnnnnnbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
//msgname=(getProductDetailService().getname(select1));
//strmessage=(getProductDetailService().getmsg(ads_id));
return productid;
}  
public String msgclose;
public String selectinfo2(ActionEvent e)
{  
System.out.println("lkllklklklklklklklklklklklklklklllkllklklklllllllllllllllkkkkkkkkkkkkkkkk");	
System.out.println(selectedAll.getInt_ProductId()+"dfjfjfjjfmmmmmmmmmmmmmmmmmmmmmmmmmm");
msgclose=(getProductDetailService().getclose(selectedAll.getInt_ProductId()));
Ch_Product_Type="Sell";
Ch_Ad_Type="My Community";
Status=null;
System.out.println(select1+"jhdsjdf");
//msgname=(getProductDetailService().getname(select1));
//strmessage=(getProductDetailService().getmsg(ads_id));
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Post close  Successfully!"));
return "Ad_an_Post.xhtml?faces-redirect=true";
}	
public String send6()
{
	recipient= emailids;
	content="";
	subject="Appowner.com";
	aprtmentname=getStr_ApartmentName();
	System.out.println(emailids+"jshadkjashjdhkjashdjhasjhdhjdhfjlhdsfjhdhf");
	Ch_Product_Type="Sell";
    Ch_Ad_Type="My Community";
	 Status=null;
	return "/AfrteLoginViews/Communication/Ads1Email.jsp";
}	


public String getEmailids() {
	return emailids;
}
public void setEmailids(String emailids) {
	this.emailids = emailids;
}
public String emailids;
public String msgreject;
public int msgrejectid;
public static Integer productid;

public static Integer getProductid() {
	return productid;
}
public static void setProductid(Integer productid) {
	Cls_AddDetailBean.productid = productid;
}
public String selectinfo3(ActionEvent e)
{  
System.out.println("lkllklklklklklklklklklklklklklklllkllklklklllllllllllllllkkkkkkkkkkkkkkkk");	
System.out.println(selectedAll.getInt_ProductId()+"dfjfjfjjfmmmmmmmmmmmmmmmmmmmmmmmmmm");
productsid=selectedAll.getInt_ProductId();

msgrejectid=(getProductDetailService().getrejectids(selectedAll.getInt_ProductId()));
emailids=(getProductDetailService().getemailids(msgrejectid));
System.out.println(msgrejectid+"jhdsjdfbnnnnnnnnnnnnnnnnnnnnnnnnnnbbbbbbbbbbbbbb");
System.out.println(emailids+"lkkkkkkkkkkkkkkkkkAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//msgname=(getProductDetailService().getname(select1));
//strmessage=(getProductDetailService().getmsg(ads_id));
return select1;
}

public String selectinfo4(ActionEvent e)
{  
msgrejectid=(getProductDetailService().getrejectids(selectedAll.getInt_ProductId()));
emailids=(getProductDetailService().getemailids(msgrejectid));
System.out.println(msgrejectid+"jhdsjdfbnnnnnnnnnnnnnnnnnnnnnnnnnnbbbbbbbbbbbbbb");
System.out.println(emailids+"lkkkkkkkkkkkkkkkkkAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//msgname=(getProductDetailService().getname(select1));
//strmessage=(getProductDetailService().getmsg(ads_id));
return select1;
}

private Part part;
private String statusMessage;
private static String path;
private Cls_ProductDetails products;
public String uploadFile() throws IOException {

	SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	String fileName = fmt.format(new Date())
			+ getFileName(part).substring(
					getFileName(part).lastIndexOf('.'));
	
	System.out.println("***** fileName: " + fileName);
	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

	
	String basePath =servletContext.getRealPath("")
			+ File.separator + "images" 
			+ File.separator+Util.getAppartmentName()+File.separator;
	System.out.println(basePath);
	File outputFilePath = new File(basePath);
	outputFilePath=new File(basePath);
	if(!outputFilePath.exists())
	{
		if(outputFilePath.mkdirs())
		{
			System.out.println("directory");
		}
		else
			System.out.println("failed to create directory");
	}
    System.out.println(path + "path");
	// Copy uploaded file to destination path
    outputFilePath=new File(basePath,fileName);
	InputStream inputStream = null;
	OutputStream outputStream = null;
	try {
		inputStream = part.getInputStream();
		outputStream = new FileOutputStream(outputFilePath);

		int read = 0;
		final byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
		path = "/images" + File.separator + Util.getAppartmentName()
				+ File.separator + fileName;
		//products.setVar_ImageName(path);
		//products.setInt_ProductId(products.getInt_ProductId());
		//System.out.println((selectedAll.getInt_ProductId()+"mkkmkmmmkmkmkmmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkk"));
		//getProductDetailService().updateProfilePic(user);
		
		statusMessage = "File uploaded successfull !!";

	} catch (IOException e) {
		e.printStackTrace();
		statusMessage = "File upload failed !!";
	} finally {
		if (outputStream != null) {
			outputStream.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
	}
	part=null;
	return "Create_Detail.xhtml"; // return to same page
}
public Part getPart()  {
return part;
}
public void setPart(Part part) {
	this.part = part;
}
public String getStatusMessage() {
	return statusMessage;
}
public void setStatusMessage(String statusMessage) {
	this.statusMessage = statusMessage;}

// Extract file name from content-disposition header of file part
private String getFileName(Part part) {
	System.out.println(part+"dfjfdkjfdkjfdkj");
	final String partHeader = part.getHeader("content-disposition");
	System.out.println("***** partHeader: " + partHeader);
	for (String content : part.getHeader("content-disposition").split(";")) {
	if (content.trim().startsWith("filename")) {
			return content.substring(content.indexOf('=') + 1).trim()
					.replace("\"", "");
	}
	}
	return "filename";
}

public  String getPath() {
	System.out.println(path + "path1cvvvvvvvvvvvvvvvvvvvvvvvvvvcvcccccccccccvvvvvvvvvvvvv");
	System.out.println("i  $ youuuuuuuuuuuuuuuuuuuuuuu");
	if(path==null)
	{
		path = "/images/no_attach.png";
	}
	 return path;
	
}

/*public static void setPath(String path) {
	Cls_AddDetailBean.path = path;
}
HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
		.getExternalContext().getSession(false);
     public String getPath() {
	System.out.println(path + "path1");
	path = (String) session.getAttribute("Var_ImageName");
	if (user != null)
		path = user.getVar_ImageName();
	 else
		path = "/images/profilepic.png";
	 return path;
	 }
*/
private String msgupdate1;

public String getMsgupdate1() {
	return msgupdate1;
}
public void setMsgupdate1(String msgupdate1) {
	this.msgupdate1 = msgupdate1;
}
public String selectinfo6(ActionEvent e)
{  
System.out.println("mukesh kumar ");	
System.out.println(productid+"dfjfjfjjfmmmmmmmmmmmmmmmmmmmmmmmmmmmukeshhhhhhhhhhhhhhhhhhh");
System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
msgupdate1=(getProductDetailService().getname(productid));
return select1;
}

public static Integer productsid;
public String selectinfo7(ActionEvent e)
{  
System.out.println("mukesh kumar ");	
System.out.println(productid+"dfjfjfjjfmmmmmmmmmmmmmmmmmmmmmmmmmm");
msgreject=(getProductDetailService().getreject(productsid));
return select1;
}

public    static String catname;
public List<String> catmessage;
public int msgid;

public String selectinfo8(ValueChangeEvent event)
{  
catname =( String )event.getNewValue();
System.out.println(catname+"lklklklkkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkm");
msgid=(getProductDetailService().getids(catname));
System.out.println(catmessage+"lklklklkkjkjhjhjhjghjghjghjfgfghfghfghdhgdfhdfd");
System.out.println(postid+"lklklklkkjkjhjhjhjghjghjghjfgfghfghfghdhgdfhdfd");
catmessage=(getProductDetailService().getmessages(msgid));

System.out.println(subcatgeroynm+"fbdfgfdgdfsdsdfs");
return catname;

}

public List<String> getCatmessage()
{
	

	return catmessage;
}
public void setCatmessage(List<String> catmessage) {
	this.catmessage = catmessage;
}
public static String getCatname() {
	return catname;
}
public static void setCatname(String catname) {
	Cls_AddDetailBean.catname = catname;
}



private List<Cls_ProductDetails> searchByType;

public List<Cls_ProductDetails> getSearchByType() {
	
	searchByType=new ArrayList<Cls_ProductDetails>();
	searchByType.addAll(getProductDetailService().getSearchBytype(var_Ad_CategoryName,var_subscategoryname,Ch_Ad_Type));
	 blb_images1="E:/Var_ImageName";
	
		return searchByType;
}
public void setSearchByType(List<Cls_ProductDetails> searchByType) {
	this.searchByType = searchByType;
}
	
public static String  phnumber;

public static String getPhnumber() {
	return phnumber;
}
public static void setPhnumber(String phnumber) {
	Cls_AddDetailBean.phnumber = phnumber;
}
private String str_PhoneNo;

public String getStr_PhoneNo() {
	return str_PhoneNo;
}
public void setStr_PhoneNo(String str_PhoneNo) {
	this.str_PhoneNo = str_PhoneNo;
}
public String sell_msg;

public String getSell_msg() {
	return sell_msg;
}
public void setSell_msg(String sell_msg) {
	this.sell_msg = sell_msg;
}
public static String getmsg_sell;

public static String getGetmsg_sell() {
	return getmsg_sell;
}
public static void setGetmsg_sell(String getmsg_sell) {
	Cls_AddDetailBean.getmsg_sell = getmsg_sell;
}
public static String usrnames;

public static String getUsrnames() {
	return usrnames;
}
public static void setUsrnames(String usrnames) {
	Cls_AddDetailBean.usrnames = usrnames;
}
public String send9()
{   System.out.println("jgjgjgjgkjgkghghhghh");
	recipient=getTo();
	phnumber=Util.getStr_PhoneNo();
	usrnames=Util.getUserName();
	aprtmentname=getStr_ApartmentName();
	getmsg_sell=getSell_msg();
	subject="Appowner.com";
	System.out.println(recipient);
	System.out.println(phnumber+"jkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	return "/AfrteLoginViews/Communication/contact.jsp";
}		
	
public static int getUsreid() {
	return usreid;
}
public static void setUsreid(int usreid) {
	Cls_AddDetailBean.usreid = usreid;
}
public String emailid;

public String getEmailid() 
{
	emailid=(getProductDetailService().usremail(usreid));
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public static int usreid;

public String getemailid(Integer id1)
{
	 usreid=id1;
     System.out.println(id1+"lklklklklklklklklklklklklklklklklklklklklklklklklklklklklklk");
     System.out.println(emailid+";lmd;lmasldfmsamfmas;lfm;sakmf;lsa;lf;lasf;laslkmasmf;las");
	return emailid;
	
}
private Cls_ProductDetails adid;

public Cls_ProductDetails getAdid() {
	adid=(getProductDetailService().usrpostid(postid));
	System.out.println(var_Ad_CategoryName+"llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
	Ch_Product_Type="Sell";
    
    Ch_Ad_Type="My Community";
	return adid;
}
public void setAdid(Cls_ProductDetails adid) {
	this.adid = adid;
}
private static Integer   postid;
public static Integer getPostid() {
	return postid;
}
public static void setPostid(Integer postid) {
	Cls_AddDetailBean.postid = postid;
}
public String  subname;
public String subcatname;
public String getSubcatname() 
{
if(postid==null)
	{
		System.out.println("ffkjfkjgfgf");
	}
	else
	{
		int subcategoryId=(getProductDetailService().subcategoryname(postid));
		System.out.println( subcategoryId+"mppppmpppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp");
		subcatname=(getProductDetailService().subscatnames( subcategoryId));
		System.out.println(subcatname+"my jannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
	}
	return subcatname;
}
public void setSubcatname(String subcatname) {
	this.subcatname = subcatname;
}
public String subcatgeroynm;

public String getSubcatgeroynm() 
{
	
	return subcatgeroynm;
}
public void setSubcatgeroynm(String subcatgeroynm) {
	this.subcatgeroynm = subcatgeroynm;
}
public String getSubname() {
	if(postid==null)
	{
		System.out.println("ffkjfkjgfgf");
	}
	else
	{
		int subcatid=(getProductDetailService().subcategoryid(postid));
		System.out.println( subcatid+"mppppmppppppppppppppmmmmmmmmmmmmmmmmmmmppppppppppppppppppppppppp");
		subname=(getProductDetailService().subcatname( subcatid));
		System.out.println(postid+"my jannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
	}
	return subname;
}
public void setSubname(String subname) {
	this.subname = subname;
}
public String editselect1()
{
	if(indicate==false)
	  {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select One Item View"));
		Ch_Product_Type="Sell";
	    Ch_Ad_Type="My Community";
		 Status=null;
    	return"Ad_an_Post.xhtml";
	  }
	else{
		
	 postid=selectedAll.getInt_ProductId();	
	  System.out.println( postid+"mukeshkumaaaaaaarrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	  Ch_Product_Type="Sell";
	    Ch_Ad_Type="My Community";
		 Status=null;
		 
		 }return "ViewDetails.xhtml";
	
	  
}
public String editselect()
{
	
			if(indicate==false)
			  {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select One Item View"));
				Ch_Product_Type="Sell";
			    Ch_Ad_Type="My Community";
				 Status=null;
		    	return"Ad_an_Post.xhtml";
			  }
			
			
	 
	 if(selectedAll.getInt_Ad_categoryId()!=0)
	 {
	 	catmessage=new ArrayList<String>();
	 	catmessage.addAll(getProductDetailService().getCatmessage(selectedAll.getInt_Ad_categoryId()));
	 	System.out.println(catmessage+"pmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	 	System.out.println("kjjhjhjhjhlkjhlkh");
	 }
	 else
	 {
	 	catmessage=new ArrayList<String>();
	 }
	 postid=selectedAll.getInt_ProductId();	
	  System.out.println( postid+"mukeshkumaaaaaaarrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	  Ch_Product_Type="Sell";
	   Ch_Ad_Type="My Community";
	 Status=null;
	return "EditDetails.xhtml";
}

public String uploadFile1() throws IOException {

	SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	System.out.println((postid+"mkkmkmmmkmkmkmmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkk"));
	String fileName = fmt.format(new Date())
		+ getFileName(part).substring(
					getFileName(part).lastIndexOf('.'));
	
	System.out.println("***** fileName: " + fileName);
	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

	
	String basePath =servletContext.getRealPath("")
			+ File.separator + "images" 
			+ File.separator+Util.getAppartmentName()+File.separator;
	System.out.println(basePath);
	File outputFilePath = new File(basePath);
	outputFilePath=new File(basePath);
	if(!outputFilePath.exists())
	{
		if(outputFilePath.mkdirs())
		{
			System.out.println("directory");
		}
		else
			System.out.println("failed to create directory");
	}
    System.out.println(path + "path");
	// Copy uploaded file to destination path
    outputFilePath=new File(basePath,fileName);
	 
	InputStream inputStream = null;
	OutputStream outputStream = null;
	try {
		inputStream = part.getInputStream();
		outputStream = new FileOutputStream(outputFilePath);

		int read = 0;
		final byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
		path3 = "/images" + File.separator + Util.getAppartmentName()
				+ File.separator + fileName;
		 
		//products.setVar_ImageName(path);
		//products.setInt_ProductId(products.getInt_ProductId());
		System.out.println((postid+"mkkmkmmmkmkmkmmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkmkk"));
		
		getProductDetailService().updatePics(postid,path3);
		
		statusMessage = "File uploaded successfull !!";

	} catch (IOException e) {
		e.printStackTrace();
		statusMessage = "File upload failed !!";
	} finally {
		if (outputStream != null) {
			outputStream.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
	}
	part=null;
	return null; // return to same page
}


// Extract file name from content-disposition header of file part



/*public static void setPath(String path) {
	Cls_AddDetailBean.path = path;
}
HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
		.getExternalContext().getSession(false);
     public String getPath() {
	System.out.println(path + "path1");
	path = (String) session.getAttribute("Var_ImageName");
	if (user != null)
		path = user.getVar_ImageName();
	 else
		path = "/images/profilepic.png";
	 return path;
	 }
*/



private String path3;

public String getPath3() 
{
	if((selectedAll.getInt_ProductId()!=null))
	{
		
		
		 path3=getProductDetailService().getProductImg(selectedAll.getInt_ProductId());
		
	}
	else
		path3="images/no_attach.png";
	return path3;
}
public void setPath3(String path3) {
	this.path3 = path3;
}

 public String deleteselect()
 {
	
	 if(indicate==false)
	  {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select One Item View"));
		Ch_Product_Type="Sell";
	    Ch_Ad_Type="My Community";
		 Status=null;
   	return"Ad_an_Post.xhtml";
	  }
	 else
	 {
	 getProductDetailService().deleteselected(selectedAll.getInt_ProductId());
	 Ch_Product_Type="Sell";
	   Ch_Ad_Type="My Community";
	 Status=null;
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
	 
	 Ch_Product_Type="Sell";
	 Ch_Ad_Type="My Community";
	 Status=null;
     return "Ad_an_Post.xhtml";
}}

 public String editseand()
 {
	 Ch_Product_Type=null;
	 Ch_Ad_Type=null;
	 Status=null;
	 return "Ad_an_Post.xhtml";
 }
 
 private boolean indicate;
	public boolean isIndicate() {
		return indicate;
	}
	public void setIndicate(boolean indicate) {
		this.indicate = indicate;
	}
	private boolean indicate2;
	public boolean isIndicate2() {
		return indicate2;
	}
	public void setIndicate2(boolean indicate2) {
		this.indicate2 = indicate2;
	}
	public void desabledListener( SelectEvent event)
	{
		System.out.println("klcfkfkjfgfgkffkg33333333333333333333333333333mnmnmnmnnnnnnnnnnnnn");
		
		indicate=true;
		
		
	}
	
}	

	
	
	

	
	
	
	

