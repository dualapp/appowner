package com.appowner.dao;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;

public interface ProductDao {

	public void AddProducts(Cls_ProductDetails pro);

	public void AddCategorys(Cls_categoryDetail cat);

	
}
