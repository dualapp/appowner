package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ProductsDao;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Notification;
@Service("ProductDetailService")
@Transactional 
public class Cls_ProductsDetailServiceImpl implements ProductsDetailService {
	@Autowired
	private ProductsDao productDao;
	public ProductsDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductsDao productDao) {
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

	

	

	/*@Override
	public List<String> getAprtmentName() {
		return (List<String>) getProductDao().getAprtmentName();return getProductDao().getSearchByProducttype(ch_Product_Type)
	}
*/
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_ProductDetails> getSearchByProducttype(
			String ch_Product_Type, String ch_Ad_Type,String status) {
		return getProductDao().getSearchByProducttype(ch_Product_Type,ch_Ad_Type, status);
	}

	@Override
	public List<Cls_categoryDetail> listcategory() {
		return getProductDao().listcategory();
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Cls_ProductDetails> listcategory1() {
		return getProductDao().listcategory1();
	}

	@Override
	public void Deletedoc(Cls_ProductDetails category) {
		getProductDao().Deletedoc(category);
		
	}

	

	@Override
	public void edit(Cls_ProductDetails edit) {
		 getProductDao().edit( edit);
		
	}

	
	@Override
	public int editproductaa(Integer int_ProductId) {
		// TODO Auto-generated method stub
		return  getProductDao().editproductaa(int_ProductId);
	}

	@Override
	public Cls_ProductDetails updation(Integer int_ProductId) {
		return  getProductDao().updation(int_ProductId);
	}

	@Override
	public Cls_ProductDetails getEdit(Integer int_ProductId) {
		return  getProductDao().getEdit( int_ProductId);
	}

	@Override
	public String editproduct2(int prointcatid) {
		return  getProductDao().editproduct2( prointcatid);
	}

	@Override
	public String editproduct1(int int_Ad_categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cls_ProductDetails edit) {
		getProductDao().update( edit);
		
	}

	@Override
	public void addContact(Cls_ProductDetails edit1) {
		getProductDao().addContact( edit1);
		
	}

	public void update3(Cls_ProductDetails edit1) {
		getProductDao().update( edit1);
		
	}

	@Override
	public void addContact1(Cls_ProductDetails edit) {
		getProductDao().addContact( edit);
		
	}

	@Override
	public Cls_ProductDetails getEdit1(Integer int_ProductId) {
		return  getProductDao().getEdit1( int_ProductId);
	}

	
	@Override
	public void datachange(String str, Integer id)
	{
		  getProductDao().change( str,id);
	}

	@Override
	public Cls_ProductDetails change(Integer int_ProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveall(Cls_ProductDetails updation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valuechange(String str1, Integer id) {
		 getProductDao().valuechange( str1,id);
		
	
	}

	@Override
	public void valuereject(String str2, Integer id) {
		getProductDao().valuereject(str2,id);
		
	}

	@Override
	public void updatedetails(Cls_ProductDetails productDetails) {
		getProductDao().updatedetails(productDetails);
		
	}

	@Override
	public void save1(Cls_ProductDetails productDetails) {
		getProductDao().save1(productDetails);
		
	}

	
	
		
	}

	
	

	
	
	
	

	


