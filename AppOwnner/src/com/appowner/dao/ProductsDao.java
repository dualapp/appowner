package com.appowner.dao;

import java.util.Collection;
import java.util.List;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Notification;

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


	
	

	
}
