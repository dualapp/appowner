package com.appowner.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.appowner.service.ApartmentDetailsService;

@ManagedBean
@ViewScoped
public class ApartmentDetailsBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{ApartmentDetailsService}")
	private ApartmentDetailsService apartmentDetailsService;
	public ApartmentDetailsService getApartmentDetailsService() {
		return apartmentDetailsService;
	}
	public void setApartmentDetailsService(
			ApartmentDetailsService apartmentDetailsService) {
		this.apartmentDetailsService = apartmentDetailsService;
	}
	private String str_CommunityType;
	private Integer int_year;
	private Integer int_NoOfBlock;
	private Integer int_TotalHouse;
	private Integer int_NoOfHouse;
	
	public Integer getInt_NoOfHouse() {
		return int_NoOfHouse;
	}
	public void setInt_NoOfHouse(Integer int_NoOfHouse) {
		this.int_NoOfHouse = int_NoOfHouse;
	}
	public String getStr_BlockName() {
		return str_BlockName;
	}
	public void setStr_BlockName(String str_BlockName) {
		this.str_BlockName = str_BlockName;
	}
	private String str_BlockName;
	private Integer int_NoOfBalconies;
	private Integer int_NoOfBedRooms;
	private Boolean is_Rented;
	private String str_TypeOfHouse;
	private String str_HouseNo;
	public Integer getInt_NoOfBalconies() {
		return int_NoOfBalconies;
	}
	public void setInt_NoOfBalconies(Integer int_NoOfBalconies) {
		this.int_NoOfBalconies = int_NoOfBalconies;
	}
	public Integer getInt_NoOfBedRooms() {
		return int_NoOfBedRooms;
	}
	public void setInt_NoOfBedRooms(Integer int_NoOfBedRooms) {
		this.int_NoOfBedRooms = int_NoOfBedRooms;
	}
	public Boolean getIs_Rented() {
		return is_Rented;
	}
	public void setIs_Rented(Boolean is_Rented) {
		this.is_Rented = is_Rented;
	}
	public String getStr_TypeOfHouse() {
		return str_TypeOfHouse;
	}
	public void setStr_TypeOfHouse(String str_TypeOfHouse) {
		this.str_TypeOfHouse = str_TypeOfHouse;
	}
	public String getStr_HouseNo() {
		return str_HouseNo;
	}
	public void setStr_HouseNo(String str_HouseNo) {
		this.str_HouseNo = str_HouseNo;
	}
	public Integer getInt_HouseSize() {
		return int_HouseSize;
	}
	public void setInt_HouseSize(Integer int_HouseSize) {
		this.int_HouseSize = int_HouseSize;
	}
	private Integer int_HouseSize;
	
	
	public String getStr_CommunityType() {
		return str_CommunityType;
	}
	public void setStr_CommunityType(String str_CommunityType) {
		this.str_CommunityType = str_CommunityType;
	}
	public Integer getInt_year() {
		return int_year;
	}
	public void setInt_year(Integer int_year) {
		this.int_year = int_year;
	}
	public Integer getInt_NoOfBlock() {
		return int_NoOfBlock;
	}
	public void setInt_NoOfBlock(Integer int_NoOfBlock) {
		this.int_NoOfBlock = int_NoOfBlock;
	}
	public Integer getInt_TotalHouse() {
		return int_TotalHouse;
	}
	public void setInt_TotalHouse(Integer int_TotalHouse) {
		this.int_TotalHouse = int_TotalHouse;
	}
	
	public void saveCommunitySetup()
	{
		getApartmentDetailsService().saveCommunitySetup();
	}

}
