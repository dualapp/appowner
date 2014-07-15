package com.appowner.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.appowner.dao.ProductDao;
import com.appowner.dao.SubcriptDao;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;

public class Cls_ProductDetailServiceImpl implements ProductDetailService {
	@Autowired
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void AddProducts(Cls_ProductDetails pro) {
		getProductDao().AddProducts(pro);
		
	}

	@Override
	public void AddCategorys(Cls_categoryDetail cat) {
		getProductDao().AddCategorys(cat);
		
	}

}
