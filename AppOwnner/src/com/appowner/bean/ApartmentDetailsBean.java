package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.CommunitySetup;
import com.appowner.model.HouseDetails;
import com.appowner.model.UserBlocks;
import com.appowner.service.ApartmentDetailsService;
import com.appowner.util.Util;

@ManagedBean
@SessionScoped
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
	private List<UserBlocks> listBlockDetails;
	private List<HouseDetails> listHouseDetails;
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
	
	private CommunitySetup cs;
	private List<String> blockNameList;
	private Integer int_TotalNoOfHouses;
	public Integer getInt_TotalNoOfHouses() {
		return int_TotalNoOfHouses;
	}
	public void setInt_TotalNoOfHouses(Integer int_TotalNoOfHouses) {
		this.int_TotalNoOfHouses = int_TotalNoOfHouses;
	}
	private List list=new ArrayList();
	@SuppressWarnings("unchecked")
	public void communityTypeListener(ValueChangeEvent event)
	{
		list.addAll((List<String>) event.getNewValue());
	}
	private List<CommunitySetup> CommunityTypeList;
	public String saveCommunitySetup()
	{
		
		cs=new CommunitySetup();
		ListIterator itr1=list.listIterator();
		while(itr1.hasNext())
		{ 
			str_CommunityType=(String) itr1.next();
		 cs.setInt_TotalNoOfHouses(int_TotalNoOfHouses);
		 cs.setInt_year(int_year);
		 cs.setStr_CommunitySetupType(str_CommunityType);
		cs.setInt_NoOfBlocks(int_NoOfBlock);
		getApartmentDetailsService().saveCommunitySetup(cs);
		
		}
		return "blockdetails.xhtml";
	}
	public String saveBlockDetails()
	{
		UserBlocks ub=new UserBlocks();
		ub.setInt_NoOfHouses(int_NoOfHouse);
		ub.setStr_BlockName(str_BlockName);
		ub.setInt_ApartmentId(Util.getAppartmentId());
		getApartmentDetailsService().saveBlockDetails(ub);
		return "housedetails.xhtml";
	}
	private HouseDetails housedetails;
	public String saveHouseDetails()
	{ 
		
		housedetails=new HouseDetails();
		housedetails.setInt_ApartmentId(Util.getAppartmentId());
		
		housedetails.setStr_HouseNo(str_HouseNo);
		housedetails.setInt_HouseSize(int_HouseSize);
		housedetails.setInt_NoOfBalconies(int_NoOfBalconies);
		housedetails.setInt_NoOfBathRooms(int_NoOfBedRooms);
		//housedetails.setInt_NoOfUsers(int_NoOfUsers);
		housedetails.setIs_Rented(is_Rented);
		housedetails.setStr_TypeOfHouse(str_TypeOfHouse);
		getApartmentDetailsService().saveHouseDetails(housedetails);
		return "housedetails.xhtml";
	}
	public List<UserBlocks> getListBlockDetails() {
		listBlockDetails=new ArrayList<UserBlocks>();
		listBlockDetails.addAll(getApartmentDetailsService().getListBlockDetails());
		return listBlockDetails;
	}
	public HouseDetails getHousedetails() {
		System.out.println(str_HouseNo+"hno");
		housedetails=getApartmentDetailsService().getHouseDetailByHouseNo(str_HouseNo);
		System.out.println(housedetails+"Hdetails");
		if(housedetails==null)
			render=false;
			 
		else
			render=true;
		return housedetails;
	}
	public void setHousedetails(HouseDetails housedetails) {
		this.housedetails = housedetails;
	}
	public void setListBlockDetails(List<UserBlocks> listBlockDetails) {
		this.listBlockDetails = listBlockDetails;
	}
	private List<String> houseNoList;
	public List<HouseDetails> getListHouseDetails() {
		System.out.println(str_BlockName+"BBBBBBBBBBlock");
		listHouseDetails=new ArrayList<HouseDetails>();
		listHouseDetails.addAll(getApartmentDetailsService().getListHouseDetails());
		 
		return listHouseDetails;
	}
	public List<HouseDetails> getListHouseDetails1(String str_BlockName) {
		listHouseDetails=new ArrayList<HouseDetails>();
		System.out.println(str_BlockName+"BLOKKKKKKKKKKKKKKK");
		listHouseDetails.addAll(getApartmentDetailsService().getListHouseDetails(str_BlockName));
		System.out.println(listHouseDetails+"klap");
		return listHouseDetails;
	}
	public void setListHouseDetails(List<HouseDetails> listHouseDetails) {
		this.listHouseDetails = listHouseDetails;
	}
	public List<CommunitySetup> getCommunityTypeList() {
		return CommunityTypeList;
	}
	public void setCommunityTypeList(List<CommunitySetup> communityTypeList) {
		CommunityTypeList = communityTypeList;
	}
	public List<String> getBlockNameList() {
		blockNameList=new ArrayList<String>();
		
		blockNameList.addAll(getApartmentDetailsService().getBlockNameList());
		return blockNameList;
	}
	public void setBlockNameList(List<String> blockNameList) {
		this.blockNameList = blockNameList;
	}
	private Boolean render;
	public List<String> getHouseNoList() {
		houseNoList=new ArrayList<String>();
		houseNoList.addAll(getApartmentDetailsService().getHouseNoList(str_BlockName));
		
		 
		return houseNoList;
	}
	public void setHouseNoList(List<String> houseNoList) {
		this.houseNoList = houseNoList;
	}
	public void getHouseDetailByHouseNo()
	{
		System.out.println(str_HouseNo+"hno");
		housedetails=getApartmentDetailsService().getHouseDetailByHouseNo(str_HouseNo);
		System.out.println(housedetails+"Hdetails");
		/*if(housedetails==null)
			render=false;
			 
		else
			render=true;*/
		 
		
	}
	public Boolean getRender(String hno)
	{ 
		System.out.println(hno+"hno");
		render= getStr_HouseNo()==hno;
		System.out.println(render+"temp");
		return render;
	}
	 

}
