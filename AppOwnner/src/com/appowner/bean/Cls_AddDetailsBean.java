package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.appowner.model.Cls_CreateDocumentManagement;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.service.ProductDetailService;
@ManagedBean
@ViewScoped
public class Cls_AddDetailsBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private Integer Int_ProductId;
	private String Ch_Product_Type;
	private String Var_Title;
	private String Var_FileName;
	private String Var_ImageName;
	private String var_Description;
	private String Ch_Ad_Type;
	private int int_Ad_categoryId;
	   
		public int getInt_Ad_categoryId() {
		return int_Ad_categoryId;
	}
	public void setInt_Ad_categoryId(int int_Ad_categoryId) {
		this.int_Ad_categoryId = int_Ad_categoryId;
	}
		public String getVar_Ad_CategoryName() {
			return var_Ad_CategoryName;
		}
		public void setVar_Ad_CategoryName(String var_Ad_CategoryName) {
			this.var_Ad_CategoryName = var_Ad_CategoryName;
		}
	private String var_Ad_CategoryName;

	public String getCh_Ad_Type()
	
	{
		
		return Ch_Ad_Type;
	}
	public void setCh_Ad_Type(String ch_Ad_Type) {
		Ch_Ad_Type = ch_Ad_Type;
	}
	public Integer getInt_ProductId() {
		return Int_ProductId;
	}
	public void setInt_ProductId(Integer int_ProductId) {
		Int_ProductId = int_ProductId;
	}
	
	public String getCh_Product_Type() {
		return Ch_Product_Type;
	}
	public void setCh_Product_Type(String ch_Product_Type) {
		Ch_Product_Type = ch_Product_Type;
	}
	public String getVar_Title() {
		return Var_Title;
	}
	public void setVar_Title(String var_Title) {
		Var_Title = var_Title;
	}
	public String getVar_FileName() {
		return Var_FileName;
	}
	public void setVar_FileName(String var_FileName) {
		Var_FileName = var_FileName;
	}
	public String getVar_ImageName() {
		return Var_ImageName;
	}
	public void setVar_ImageName(String var_ImageName) {
		Var_ImageName = var_ImageName;
	}
	public String getVar_Description() {
		return var_Description;
	}
	public void setVar_Description(String var_Description) {
		this.var_Description = var_Description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	
	}
	private ProductDetailService productDetailService;
	
	public ProductDetailService getProductDetailService() {
		return productDetailService;
	}
	public void setProductDetailService(ProductDetailService productDetailService) {
		this.productDetailService = productDetailService;
	}
	public void AddProduct(){
		Cls_ProductDetails pro=new Cls_ProductDetails();
		
		pro.setCh_Product_Type(getCh_Product_Type());
		pro.setInt_ProductId(getInt_ProductId());
		pro.setVar_Description(getVar_Description());
		pro.setVar_FileName(getVar_FileName());
		pro.setVar_ImageName(getVar_ImageName());
        pro.setVar_Title(getVar_Title());
		pro.setCh_Ad_Type(getCh_Ad_Type());
        getProductDetailService().AddProducts(pro);		
	}
	
	public void AddCategory(){
		Cls_categoryDetail Cat=new Cls_categoryDetail();
	      System.out.println("hi");
	      Cat.setInt_Ad_categoryId(getInt_Ad_categoryId());
		Cat.setVar_Ad_CategoryName(getVar_Ad_CategoryName());
		System.out.println(var_Ad_CategoryName);
		getProductDetailService().AddCategorys(Cat);
		
		
	}
	
}
	
	
	
	

