package com.appowner.bean;
import com.appowner.bean.Cls_UserBeanMain;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
//import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class SelectOneMenuBean {
	public String cvalue;
	private String count1;
	public String state_Value;
	private String state;
	public String city_Value;
	private String city;
	public String apartment_Value;
	private String apartment;
	private List<String> blocks_value;

	public List<String> getBlocks_value() {
		return blocks_value;
	}

	public void setBlocks_value(List<String> blocks_value) {
		this.blocks_value = blocks_value;
	}

	public String getApartment() {
		return apartment_Value;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getCity() {
		return city_Value;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public String getState_Value() {
		return state_Value;
	}

	public void setState_Value(String state_Value) {
		this.state_Value = state_Value;
	}

	public String getCity_Value() {
		return city_Value;
	}

	public void setCity_Value(String city_Value) {
		this.city_Value = city_Value;
	}

	public String getApartment_Value() {
		return apartment_Value;
	}

	public void setApartment_Value(String apartment_Value) {
		this.apartment_Value = apartment_Value;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state_Value;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCount1() {
		System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggggg");
		System.out.println(cvalue);
		return cvalue;
	}

	public void setCount1(String count1) {
		this.count1 = count1;
	}

	public void getCount1(String str_UserCountry) {
		System.out.println("lllllllllllllllllllllllllleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeelllllllllllllllllllllllllllllllllllllllllllllll");
		cvalue=str_UserCountry;
		System.out.println(cvalue);
		
		
	}

	public void getState(String str_StateName) {
		state_Value=str_StateName;
		
	}

	public void getCity(String str_ApartmentName) {
		city_Value=str_ApartmentName;
		
	}

	public void getApartment(String str_userapartment) {
		System.out.println(str_userapartment+"jhjkkjkj");
		apartment_Value=str_userapartment;
		System.out.println(apartment_Value+"hjhjj");
	}
	public void getBlocks(List<String> strBlocks)
	{
		
		blocks_value=strBlocks;
	}

	


}
