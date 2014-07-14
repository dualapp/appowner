package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ProductDao;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;

@Service("ProductDetailService")
@Transactional
public class ProductServiceImpl implements ProductDetailService {
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
	public void getcategoryName() {
		getProductDao().getcategoryName();
		
	}


	

	
}
