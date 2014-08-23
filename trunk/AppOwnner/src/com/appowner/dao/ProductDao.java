package com.appowner.dao;

import java.util.List;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;

public interface ProductDao {

	public void AddProducts(Cls_ProductDetails pro);

	public void AddProduct1(Cls_ProductDetails pro);
    public void AddCategorys(Cls_categoryDetail cat);

	public List<String> getCategories();

	public int getdocid2(String intdocid1);

	public Cls_ProductDetails editproduct(Integer int_ProductId);

	public void update1(Cls_ProductDetails pro);

	public List<Cls_ProductDetails> listPersons();

	

	
}
