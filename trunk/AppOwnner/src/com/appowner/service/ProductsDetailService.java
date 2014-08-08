package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Notification;
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
			String ch_Product_Type, String ch_Ad_Type);

	public int getdocid3(String intdocid2);

	public int getdocid4(String intdocid3);

	

	

	//public List<String> getAprtmentName();

	

	//public Collection<? extends Cls_ProductDetails> getDetails(
		//	String ch_Product_Type);

	//public List getCategoryname1();

	
	

	

	
	
	
	
	

	

	

	

}
