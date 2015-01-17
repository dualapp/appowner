package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity

@Table(name = "tb_housedetails")

public class HouseDetails  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer getInt_HouseId() {
		return int_HouseId;
	}
	public void setInt_HouseId(Integer int_HouseId) {
		this.int_HouseId = int_HouseId;
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
	 
	public Integer getInt_NoOfBathRooms() {
		return int_NoOfBathRooms;
	}
	public void setInt_NoOfBathRooms(Integer int_NoOfBathRooms) {
		this.int_NoOfBathRooms = int_NoOfBathRooms;
	}
	public Integer getInt_NoOfBalconies() {
		return int_NoOfBalconies;
	}
	public void setInt_NoOfBalconies(Integer int_NoOfBalconies) {
		this.int_NoOfBalconies = int_NoOfBalconies;
	}
	 
	public Long getInt_NoOfUsers() {
		return int_NoOfUsers;
	}
	public void setInt_NoOfUsers(Long int_NoOfUsers) {
		this.int_NoOfUsers = int_NoOfUsers;
	}
	public Integer getInt_BlockId() {
		return int_BlockId;
	}
	public void setInt_BlockId(Integer int_BlockId) {
		this.int_BlockId = int_BlockId;
	}
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	 
	public String getStr_TypeOfHouse() {
		return str_TypeOfHouse;
	}
	public void setStr_TypeOfHouse(String str_TypeOfHouse) {
		this.str_TypeOfHouse = str_TypeOfHouse;
	}
	 
	public String getIs_Rented() {
		return is_Rented;
	}
	public void setIs_Rented(String is_Rented) {
		this.is_Rented = is_Rented;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private Integer int_HouseId;
	@Column (name="var_HouseNo")
	private String str_HouseNo;
	@Column 
	private Integer int_HouseSize;
     
    @Column 
    private Integer int_NoOfBathRooms;
    @Column 
    private Integer int_NoOfBalconies;
    @Column 
    private Long int_NoOfUsers;
    @Column 
    private Integer int_BlockId;
    @Column 
    private Integer int_ApartmentId;
    @Column(name="var_TypeOfHouse")
	private String str_TypeOfHouse;
    @Column 
	private String  is_Rented;
}