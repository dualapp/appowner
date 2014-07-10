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
	

	public String getApartment() {
		return apartment_Value;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getCity() {
		return city_Value;
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
		apartment_Value=str_userapartment;
		
	}

	


}
