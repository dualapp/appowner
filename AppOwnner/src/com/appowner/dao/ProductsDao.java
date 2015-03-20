package com.appowner.dao;

import java.util.Collection;
import java.util.List;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Cls_subcategoryDetail;
import com.appowner.model.Notification;
import com.appowner.model.cls_Ads;

public interface ProductsDao {

	public void AddProducts(Cls_ProductDetails pro);

	public void AddProduct1(Cls_ProductDetails pro);
    public void AddCategorys(Cls_categoryDetail cat);

	public List<String> getCategories();

	public int getdocid2(String intdocid1);

	public Cls_ProductDetails editproduct(Integer int_ProductId);

	public void update1(Cls_ProductDetails pro);

	public List<Cls_ProductDetails> listPersons();

	public Cls_ProductDetails searchByName1();

	public List<Cls_ProductDetails> getDetails(char ch_Product_Type);

	public void AddNotice(Notification p);

	public List<Cls_ProductDetails> getSearchByProducttype(String ch_Product_Type, String ch_Ad_Type,String status);

	public List<Cls_categoryDetail> listcategory();

	public List<Cls_ProductDetails> listcategory1();

	public void Deletedoc(Cls_ProductDetails category);

	public Cls_categoryDetail editproduct1(int int_Ad_categoryId);

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


	public void change(String str, Integer id);

	public void saveall(Cls_ProductDetails updation);

	public void valuechange(String str1, Integer id);

	public void valuereject(String str2, Integer id);

	public void updatedetails(Cls_ProductDetails productDetails);

	public void save1(Cls_ProductDetails productDetails);

	public void deleteInvoice(Cls_ProductDetails detail);

	public List<Cls_ProductDetails> listDetail(String ch_Product_Type, String ch_Ad_Type,
			String status);

	public void updated(int int_Ad_categoryId);

	public void Addadss(cls_Ads ads);

	public List<String> getcat();

	public List<String> gettitle();

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

	public int getdid(String subcatid);

	public List<Cls_ProductDetails> getSearchBytype(String var_Ad_CategoryName,
			String var_subscategoryname, String ch_Ad_Type);

	public int getcatsid(String str_sub_catid);

	public int getdocid3(String var_Ad_SubCategoryName);

	public String usremail(int id);




	
	

	
}
