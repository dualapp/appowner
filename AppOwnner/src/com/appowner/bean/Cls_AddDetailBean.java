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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.service.ProductsDetailService;
import com.appowner.util.Util;
import com.ibm.icu.text.SimpleDateFormat;
@ManagedBean
@SessionScoped
public class Cls_AddDetailBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private static final String SEARCHBYPRODUCTTYPE = "searchByProducttype";
	private Integer Int_ProductId;
	private String Ch_Product_Type;
	
	public String getCh_Product_Type() {
		return Ch_Product_Type;
	}
	public void setCh_Product_Type(String ch_Product_Type) {
		Ch_Product_Type = ch_Product_Type;
	}
	private Date dt_date;
	
	
	public Date getDt_date() {
		return dt_date;
	}
	public void setDt_date(Date dt_date) {
		this.dt_date = dt_date;
	}
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
	{ System.out.println("hi");
		System.out.println(Var_ImageName);
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
	public void AddProduct(){
		
	    intdocid1=getVar_Ad_CategoryName();
		System.out.println(intdocid1);
		intdocID1=getProductDetailService().getdocid2(intdocid1);
		intdocid2=getStr_ApartmentName();
		System.out.println(intdocid1);
		/*intdocID2=getProductDetailService().getdocid3(intdocid2);
		intdocid3=getStr_Username();
		System.out.println(intdocid3);
		intdocID3=getProductDetailService().getdocid4(intdocid3);
*/
		//Aprtid=getStr_ApartmentName();
		Cls_ProductDetails pro=new Cls_ProductDetails();
		pro.setInt_Ad_categoryId(intdocID1);
		
		//pro.setInt_ApartmentId(Util.getAppartmentId());
		pro.setUserId(getUserId());
		pro.setCh_Product_Type(getCh_Product_Type());
		pro.setInt_ProductId(getInt_ProductId());
		pro.setVar_Description(getVar_Description());
		pro.setUsername(Util.getUserName());
		pro.setApartementId(Util.getAppartmentId());
		pro.setVar_FileName("image");
		pro.setVar_ImageName(path1);
        pro.setVar_Title(getVar_Title());
		pro.setCh_Ad_Type(getCh_Ad_Type());
		getProductDetailService().AddProduct1(pro);		
	}
	
		public void AddCategory(){
		Cls_categoryDetail Cat=new Cls_categoryDetail();
	      System.out.println("hi");
	      Cat.setInt_Ad_categoryId(getInt_Ad_categoryId());
		Cat.setVar_Ad_CategoryName(getVar_Ad_CategoryName());
		System.out.println(var_Ad_CategoryName);
		getProductDetailService().AddCategorys(Cat);
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
		    File file= new File("D://Image\\"+ "images" + name);
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
	 private Cls_ProductDetails pro;

	public Cls_ProductDetails getPro() {
		return pro;
	}
	public void getCls_ProductDetails(){
		System.out.println(Int_ProductId);
		pro=getProductDetailService().editproduct(Int_ProductId);
	}
	public void setPro(Cls_ProductDetails pro) {
		this.pro = pro;
	}
	public String saveUser1(){
		getProductDetailService().update1(pro);
		System.out.println(pro);
		return "";
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
		 searchByProducttype.addAll(getProductDetailService().getSearchByProducttype(Ch_Product_Type,Ch_Ad_Type));
			return searchByProducttype;
			
			
	 }
	      public String getSearchByProducttype1()
		{
			 searchByProducttype=new ArrayList<Cls_ProductDetails>();
			 System.out.println(Ch_Product_Type);
			 searchByProducttype.addAll(getProductDetailService().getSearchByProducttype(Ch_Product_Type,Ch_Ad_Type));
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
	}
	
	
	
	
	
	
	
	
	
	
	 
	
	

	
	
	

	
	
	
	

