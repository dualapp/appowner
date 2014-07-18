package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;

public interface ProductDetailService {

	

	public void AddProduct1(Cls_ProductDetails pro);

	public void AddCategorys(Cls_categoryDetail cat);

	public List<String> getCategories();

	public int getdocid2(String intdocid1);

	
	
	
	
	

	

	

	

}
