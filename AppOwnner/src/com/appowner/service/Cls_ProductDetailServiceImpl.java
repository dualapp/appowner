package com.appowner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.bean.Cls_AddDetailsBean;
import com.appowner.dao.ProductDao;
import com.appowner.dao.SubcriptDao;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
@Service("ProductDetailService")
@Transactional 
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
	public void AddProduct1(Cls_ProductDetails pro) {
		 getProductDao().AddProduct1(pro);
		
	}

	@Override
	public void AddCategorys(Cls_categoryDetail cat) {
		getProductDao().AddCategorys(cat);
		
	}

	

}
