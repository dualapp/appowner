package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Cls_subcategoryDetail;
import com.appowner.model.Notification;
import com.appowner.model.cls_Ads;
import com.appowner.model.cls_Person;

public interface ProductsDetailService {

	

	public void AddProduct1(Cls_ProductDetails pro);

	public void AddCategorys(Cls_categoryDetail cat);

	public List<String> getCategories();

	public int getdocid2(String intdocid1);

	public Cls_ProductDetails editproduct(Integer int_ProductId);

	public void update1(Cls_ProductDetails pro);
	public  List<Cls_ProductDetails> listPersons();

	public Cls_ProductDetails searchByName1(char ch_Product_Type);

	public List<Cls_ProductDetails> getDetails(char ch_Product_Type);

	public void AddNotice(Notification p);

	public List<Cls_ProductDetails> getSearchByProducttype(
			String ch_Product_Type, String ch_Ad_Type,String status, int statusid);

	public List<Cls_categoryDetail> listcategory();

	public List<Cls_ProductDetails> listcategory1();

	public void Deletedoc(Cls_ProductDetails category);

	public String editproduct1(int int_Ad_categoryId);

	public void edit(Cls_ProductDetails edit);

	

	public int editproductaa(Integer int_ProductId);

	public Cls_ProductDetails updation(Integer int_ProductId);

	public Cls_ProductDetails getEdit(Integer int_ProductId);

	public String editproduct2(int prointcatid);

	public void update(Cls_ProductDetails edit);

	public void addContact(Cls_ProductDetails edit);

	public void update3(Cls_ProductDetails edit1);

	public void addContact1(Cls_ProductDetails edit1);

	public Cls_ProductDetails getEdit1(Integer int_ProductId);

	public Cls_ProductDetails change(Integer int_ProductId);

	public void datachange(String str, Integer id);

	public void saveall(Cls_ProductDetails updation);

	public void valuechange(String str1, Integer id);

	public void valuereject(String str2, Integer id);

	public void updatedetails(Cls_ProductDetails productDetails);

	public void save1(Cls_ProductDetails productDetails);

	public void deleteInvoice(Cls_ProductDetails detail);

	public List< Cls_ProductDetails> listDetail(
			String ch_Product_Type, String ch_Ad_Type, String status);

	public void updated(int int_Ad_categoryId);

	public void Addadss(cls_Ads ads);

	public List<String> getcat();

	public List< String> gettitle();

	public int getid(String select);

	public String getmsg(int ads_id);

	public String getname(String select1);

	public String getname(Integer productid);

	public String getclose(Integer int_ProductId);

	public String getreject(Integer productsid);

	public int getrejectids(Integer int_ProductId);

	public String getemailids(int msgrejectid);

	public void updateProfilePic(Cls_ProductDetails user);

	public String statusmesg(Integer int_ProductId);

	public void AddCategorys(Cls_subcategoryDetail detail);

	public int getcatid(String var_Ad_CategoryName);

	public int getids(String catname);

	public List<String> getmessages(int msgid);

	public int getdid(String var_Ad_SubCategoryName);

	public List<Cls_ProductDetails> getSearchBytype(
			String var_Ad_CategoryName, String var_subscategoryname,
			String ch_Ad_Type, Integer categorystatus);

	public int getcatsid(String str_sub_catid);

	public int getdocid3(String var_Ad_SubCategoryName);

	public String usremail(int id);

	public Cls_ProductDetails usrpostid(Integer postid);

	public int addid(Integer postid);

	public void updatePic(Integer integer);

	public void updatePics(Integer int_ProductId, String var_ImageName);

	public int subcategoryid(Integer postid);

	public String subcatname(int subcatid);

	public int subcategoryname(Integer postid);

	public String subscatnames(int subcategoryId);

	public int subcategoryids(Integer postid);

	public String subcatnames(int subcatids);

	public List<String> getCatmessage(int int_Ad_categoryId);

	public String getProductImg(Integer int_ProductId);

	public void deleteselected(Integer int_ProductId);

	public String checkStatus(Integer int_ProductId);

	public String checkStatuss(Integer int_ProductId);

	public String rejectStatuss(Integer int_ProductId);

	public String checkclose(Integer int_ProductId);

	public void editselected(Integer int_ProductId);

	public Cls_ProductDetails getpostdetail(Integer postId);

	public int getsubcategoryId(Integer postId);

	public List<String> getlistsubcategory(int subcategoryId);

	public int getcategoryId(Integer postId);

	public String categoryname(int categoryId);

	public String subcategorynames(int categoryId);

	public int gecatid(String subcatsname);

	public List<String> getcatmessages(int subcatId);

	public List<String> getCatmessages(int int_Ad_categoryId);

	public List<String> getcatdetail(int int_Ad_categoryId);

	public List< Cls_ProductDetails> getSearchByProducttypes(
			String ch_Product_Type, String ch_Ad_Type, String status);

	List<Cls_ProductDetails> getSearchBytype(String var_Ad_CategoryName,
			String var_subscategoryname, String ch_Ad_Type);

	List<Cls_ProductDetails> getSearchBytype(String var_Ad_CategoryName,
			String var_subscategoryname, String ch_Ad_Type, int categorystatus);

	public List<Cls_ProductDetails> getSearchBytypes(
			String var_Ad_CategoryName, String var_subscategoryname,
			String ch_Ad_Type1, String ch_Product_Type1, Integer categorystatus);

	public List< String> getCount();

	

	

	

	
	

	
	

	

	

	//public List<String> getAprtmentName();

	

	//public Collection<? extends Cls_ProductDetails> getDetails(
		//	String ch_Product_Type);

	//public List getCategoryname1();

	
	

	

	
	
	
	
	

	

	

	

}
