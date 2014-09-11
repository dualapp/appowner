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
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.service.ProductsDetailService;
import com.appowner.util.Util;
import com.ibm.icu.text.SimpleDateFormat;
@ManagedBean 
@RequestScoped
public class Cls_AddDetailBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
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
	private boolean selected;
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isSelected() {
	    return selected;
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
		System.out.println(path1);
		pro.setVar_ImageName(path1);
        pro.setVar_Title(getVar_Title());
		pro.setCh_Ad_Type(getCh_Ad_Type());
		pro.setStr_ApartmentName(str_ApartmentName);
		pro.setStatus("Pending Approval");
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
		pro2=getProductDetailService().editproduct(id);
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
			return searchByProducttype;
			
			
	 }
	      public String getSearchByProducttype1()
		{
			 searchByProducttype=new ArrayList<Cls_ProductDetails>();
			 System.out.println(Ch_Product_Type);
			 searchByProducttype.addAll(getProductDetailService().getSearchByProducttype(Ch_Product_Type,Ch_Ad_Type,Status));
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
	public void processValueChange(ValueChangeEvent event)  
        throws AbortProcessingException {
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
	public void getedit1()
	{ 
		
	edit1=new Cls_ProductDetails();
	System.out.println(Int_ProductId);
	edit1 =getProductDetailService().getEdit1(Int_ProductId);
	Var_ImageName=edit1.getVar_ImageName();
	 blb_images1="D://Image\\"+Var_ImageName;
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
	public void updation(){
	   System.out.println(approval);
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
	public String  messageChangeListener1(ValueChangeEvent vce){
		System.out.println("mukesh");
		msg1=(String)vce.getNewValue();
		System.out.println(msg1);
		if (msg1.equals("s1"))
        {
           
msg="The ad you have posted is of commercial nature, hence it cannot be approved.Only ads of personal nature can be posted here.Regards,Admin";
        }
        else if (msg1.equals("s2"))
        {
            
        	 msg="Thanks for your payment on time";
        }
        else
        	
        	 msg="dfdfdfdfdf";
		 
		 return msg;
		
	}
		
	 
	private String to;

	public String getTo() {
		
		to=Util.getEmail();
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
	
	public String send()
	{
		recipient=getTo();
		content=msg;
		System.out.println(recipient);
		System.out.println(content);
		return "Email.jsp";
	}
	
	
	   
		  }  
   	
	
	
	
	
	
	
	
	 
	
	

	
	
	

	
	
	
	

