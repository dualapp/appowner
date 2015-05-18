package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.ProductsDao;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Cls_subcategoryDetail;
import com.appowner.model.Notification;
import com.appowner.model.cls_Ads;
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
		System.out.println(pro+"jhjhjhjhjhjhjhjhjhjss");
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
					String ch_Product_Type, String ch_Ad_Type,String status, Integer statusid) {
		return getProductDao().getSearchByProducttype(ch_Product_Type,ch_Ad_Type, status,statusid);
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

	@Override
	public void deleteInvoice(Cls_ProductDetails detail) {
		getProductDao().deleteInvoice( detail);
		
	}

	@Override
	public List<Cls_ProductDetails> listDetail(String ch_Product_Type,
			String ch_Ad_Type, String status) {
		return getProductDao().listDetail(ch_Product_Type,ch_Ad_Type,status);
	}

	@Override
	public void updated(int int_Ad_categoryId) {
		getProductDao().updated( int_Ad_categoryId);
		
	}

	@Override
	public void Addadss(cls_Ads ads) {
		getProductDao().Addadss( ads);
		
	}

	@Override
	public List<String> getcat() {
		return getProductDao().getcat();
	}

	@Override
	public List<String> gettitle() {
		return getProductDao().gettitle();
	}

	@Override
	public int getid(String select) {
		return getProductDao().getid(select);
	}

	@Override
	public String getmsg(int ads_id) {
		return getProductDao().getmsg(ads_id);
	}

	@Override
	public String getname(String select1) {
		return getProductDao().getname(select1);
	}

	@Override
	public String getname(Integer productid) {
		return getProductDao().getname( productid);
	}

	@Override
	public String getclose(Integer int_ProductId) {
		return getProductDao().getclose( int_ProductId);
	}

	@Override
	public String getreject(Integer productsid) {
		return getProductDao().getreject( productsid);
	}

	@Override
	public int getrejectids(Integer int_ProductId) {
		return getProductDao().getrejectids( int_ProductId);
	}

	@Override
	public String getemailids(int msgrejectid) {
		return getProductDao().getemailids( msgrejectid);
	}

	@Override
	public void updateProfilePic(Cls_ProductDetails user) {
		
		
	}

	@Override
	public String statusmesg(Integer int_ProductId) {
		return getProductDao().statusmesg(int_ProductId);
	}

	@Override
	public void AddCategorys(Cls_subcategoryDetail detail) {
		getProductDao().AddCategorys( detail);
		
	}

	@Override
	public int getcatid(String var_Ad_CategoryName) {
		// TODO Auto-generated method stub
		return getProductDao().getcatid(var_Ad_CategoryName);
	}

	@Override
	public int getids(String catname) {
		return getProductDao().getids(catname);
	}

	@Override
	public List<String> getmessages(int msgid) {
		return getProductDao().getmessages( msgid);
	}

	@Override
	public int getdid(String var_Ad_SubCategoryName) {
		return getProductDao().getdid( var_Ad_SubCategoryName) ;
	}

	@Override
	public List<Cls_ProductDetails> getSearchBytype(String var_Ad_CategoryName,
			String var_subscategoryname, String ch_Ad_Type, int categorystatus) {
		return getProductDao().getSearchBytype( var_Ad_CategoryName,
				 var_subscategoryname,  ch_Ad_Type, categorystatus); 
	

}

	@Override
	public int getcatsid(String str_sub_catid) {
		return getProductDao().getcatsid(str_sub_catid);
	}

	@Override
	public int getdocid3(String var_Ad_SubCategoryName) {
		return getProductDao().getdocid3(var_Ad_SubCategoryName);
	}

	@Override
	public String usremail(int id) {
		return getProductDao().usremail(id);
	}

	@Override
	public Cls_ProductDetails usrpostid(Integer postid) {
		// TODO Auto-generated method stub
	 return getProductDao().usrpostid( postid);
	}

	@Override
	public int addid(Integer postid) {
		// TODO Auto-generated method stub
		 return getProductDao().addid(postid);
	}

	@Override
	public void updatePic(Integer integer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePics(Integer int_ProductId,String var_ImageName) {
		 getProductDao().updatePics(int_ProductId,var_ImageName);
		
	}

	@Override
	public int subcategoryid(Integer postid) {
		return	getProductDao().subcategoryid(postid);
		 
	}

	@Override
	public String subcatname(int subcatid) {
		return	getProductDao().subcatname(subcatid);
	}

	@Override
	public int subcategoryname(Integer postid) {
		return	getProductDao().subcategoryname(postid);
	}

	@Override
	public String subscatnames(int subcategoryId) {
		return	getProductDao().subscatnames(subcategoryId);
	}

	@Override
	public int subcategoryids(Integer postid) {
		return	getProductDao().subcategoryids( postid);
	}

	@Override
	public String subcatnames(int subcatids) {
		return	getProductDao().subcatnames(subcatids);
	}

	@Override
	public List<String> getCatmessage(int int_Ad_categoryId) {
		// TODO Auto-generated method stub
		return getProductDao().getCatmessage(int_Ad_categoryId);
	}

	@Override
	public String getProductImg(Integer int_ProductId) {
		// TODO Auto-generated method stub
		return getProductDao().getProductImg(int_ProductId);
	}

	@Override
	public void deleteselected(Integer int_ProductId) {
		getProductDao().deleteselected(int_ProductId);
		
	}

	@Override
	public String checkStatus(Integer int_ProductId) {
		return getProductDao().checkStatus(int_ProductId);
	}

	@Override
	public String checkStatuss(Integer int_ProductId) {
		return getProductDao().checkStatuss(int_ProductId);
	}

	@Override
	public String rejectStatuss(Integer int_ProductId) {
		return getProductDao().rejectStatuss(int_ProductId);
	}

	@Override
	public String checkclose(Integer int_ProductId) {
		return getProductDao().checkclose( int_ProductId);
	}

	@Override
	public void editselected(Integer int_ProductId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cls_ProductDetails getpostdetail(Integer postId) {
		return getProductDao().getpostdetail( postId);
	}

	@Override
	public int getsubcategoryId(Integer postId) {
		return getProductDao().getsubcategoryId( postId);
	}

	@Override
	public List<String> getlistsubcategory(int subcategoryId) {
		return getProductDao().getlistsubcategory(subcategoryId);
	}

	@Override
	public int getcategoryId(Integer postId) {
		return getProductDao().getcategoryId( postId);
	}

	@Override
	public String categoryname(int categoryId) {
		return getProductDao().categoryname( categoryId);
	}

	@Override
	public String subcategorynames(int categoryId) {
		return getProductDao().subcategorynames(categoryId);
	}

	@Override
	public int gecatid(String subcatsname) {
		return getProductDao().subcategorynames(subcatsname);
	}

	@Override
	public List<String> getcatmessages(int subcatId) {
		return getProductDao().getcatmessages(subcatId);
	}

	@Override
	public List<String> getCatmessages(int int_Ad_categoryId) {
		return getProductDao().getcatmessages(int_Ad_categoryId);
	}

	@Override
	public List<String> getcatdetail(int int_Ad_categoryId) {
		return getProductDao().getcatdetail(int_Ad_categoryId);
	}

	@Override
	public List<Cls_ProductDetails> getSearchByProducttypes(
			String ch_Product_Type, String ch_Ad_Type, String status) {
		return getProductDao().getSearchByProducttypes1(
				 ch_Product_Type, ch_Ad_Type, status);
	}

	@Override
	public List<Cls_ProductDetails> getSearchBytype(String var_Ad_CategoryName,
			String var_subscategoryname, String ch_Ad_Type,
			Integer categorystatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cls_ProductDetails> getSearchBytype(String var_Ad_CategoryName,
			String var_subscategoryname, String ch_Ad_Type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cls_ProductDetails> getSearchBytypes(
			String var_Ad_CategoryName, String var_subscategoryname,
			String ch_Ad_Type1, Integer categorystatus) {
		return getProductDao().getSearchBytypes(
				var_Ad_CategoryName, var_subscategoryname,
				 ch_Ad_Type1,categorystatus);
	}

	
	
				 
	}

	
	
		


	
		
	

		

	
	
	
	

	


