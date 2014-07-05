package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Subcript;
import com.appowner.service.SubcriptService;



@ManagedBean
@ViewScoped
public class Update implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deletedocument;
	private String subscriptname;
	private float price;
	public String getSubscriptname() {
		return subscriptname;
	}
	public void setSubscriptname(String subscriptname) {
		this.subscriptname = subscriptname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getDeletedocument() {
		return deletedocument;
	}
	public void setDeletedocument(int deletedocument) {
		this.deletedocument = deletedocument;
	}
	@SuppressWarnings("rawtypes")
	@ManagedProperty(value = "#{SubcriptService}")
	private SubcriptService subcriptService;
	@SuppressWarnings("rawtypes")
	public SubcriptService getSubcriptService() {
		
		return subcriptService;
	}
	@SuppressWarnings("rawtypes")
	public void setSubcriptService(SubcriptService subcriptService) {
		this.subcriptService = subcriptService;
	}
	 public Integer getSubcriptID() {
		return subcriptID;
	}
	public void setSubcriptID(Integer subcriptID) {
		this.subcriptID = subcriptID;
	}
	private Integer subcriptID;
	private String int_Document_CatNM;	
	public String getInt_Document_CatNM() {
		return int_Document_CatNM;
	}
	public void setInt_Document_CatNM(String int_Document_CatNM) {
		this.int_Document_CatNM = int_Document_CatNM;
	}
	Cls_DocumentCategory cat;
		
	public Cls_DocumentCategory getCat() {
		return cat;
	}
	public void getCls_DocumentCategory(){
		cat=getSubcriptService().getCls_DocumentCategory(Int_Document_CatID);
	}
	public void setCat(Cls_DocumentCategory cat) {
		this.cat = cat;
	}
	
public Integer  Int_Document_CatID;	

public Integer getInt_Document_CatID() {
	return Int_Document_CatID;
}
public void setInt_Document_CatID(Integer int_Document_CatID) {
	Int_Document_CatID = int_Document_CatID;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
 private Subcript usr;

public Subcript getUsr() {
return usr;
}
public void getSubcript()
{
	usr=getSubcriptService().getSubcript(subcriptID);
}
public void setUsr(Subcript usr) {
	this.usr = usr;
}
public String saveUser(){
	
	
	
getSubcriptService().update(usr);
	return "SubcriptionList.xhtml";
	}
public String saveUser1(){
	getSubcriptService().update1(cat);
	return "DocumentList.xhtml";
	}
public String deletedocument(int a){
	System.out.println("hhhhhhhhhhhh");
	System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
	System.out.println(a);
	Cls_DocumentCategory category=new Cls_DocumentCategory();
	//System.out.println(Int_Document_CatID);
	getSubcriptService().Deletedoc(category);	
	System.out.println("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
	System.out.println(a);
	return "DocumentList.xhtml";

}


		
}