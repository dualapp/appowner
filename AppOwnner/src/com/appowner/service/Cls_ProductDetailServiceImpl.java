package com.appowner.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.bean.Cls_AddDetailsBean;
import com.appowner.dao.ProductDao;
import com.appowner.dao.SubcriptDao;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Notification;
import com.appowner.model.cls_Person;
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

	@Override
	public List<String> getCategories() {
		return (List<String>) getProductDao().getCategories();	
	}

	@Override
	public int getdocid2(String intdocid1) {
		return getProductDao().getdocid2(intdocid1);
		
	}

	@Override
	public Cls_ProductDetails editproduct(Integer int_ProductId) {
		return getProductDao().editproduct(int_ProductId);
	}

	@Override
	public void update1(Cls_ProductDetails pro) {
		getProductDao().update1(pro);
		
	}

	@Override
	public List<Cls_ProductDetails> listPersons() {
		return getProductDao().listPersons();
		
	}

	@Override
	public Cls_ProductDetails searchByName1(char ch_Product_Type) {
		return getProductDao().searchByName1();
	}
	

	@Override
	public List<Cls_ProductDetails> getDetails(char ch_Product_Type) {
		return (List<Cls_ProductDetails>) getProductDao().getDetails(ch_Product_Type);
	}

	@Override
	public void AddNotice(Notification p) {
		getProductDao().AddNotice(p);
		
	}

	@Override
	public List<Cls_ProductDetails> getSearchByProducttype(String ch_Product_Type) {
		 return getProductDao().getSearchByProducttype(ch_Product_Type);
	}

	/*@Override
	public List<String> getAprtmentName() {
		return (List<String>) getProductDao().getAprtmentName();
	}
*/
	
}
	
	
	
	
	

	


