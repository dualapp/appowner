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

@Entity
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="tb_workordercategory")
public class WorkOrderCategory  implements  Serializable,Comparable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Integer int_WorkOrderCategoryId;
	@Column 
	private Integer int_ApartmentId;
	public Integer getInt_ApartmentId() {
		return int_ApartmentId;
	}
	public void setInt_ApartmentId(Integer int_ApartmentId) {
		this.int_ApartmentId = int_ApartmentId;
	}
	@Column (name="var_VendorCategoryType")
	private String str_VendorCategoryType;
	public Integer getInt_WorkOrderCategoryId() {
		return int_WorkOrderCategoryId;
	}
	public void setInt_WorkOrderCategoryId(Integer int_WorkOrderCategoryId) {
		this.int_WorkOrderCategoryId = int_WorkOrderCategoryId;
	}
	public String getStr_VendorCategoryType() {
		return str_VendorCategoryType;
	}
	public void setStr_VendorCategoryType(String str_VendorCategoryType) {
		this.str_VendorCategoryType = str_VendorCategoryType;
	}
	@Override
	public int compareTo(Object workOrderCategory) {
		// TODO Auto-generated method stub
		Integer wid=((WorkOrderCategory)workOrderCategory).getInt_WorkOrderCategoryId();
		/* For Ascending order*/
	      //  return this.int_FacilityBookId;

	        /* For Descending order do like this */
		return wid-this.int_WorkOrderCategoryId;
	}

}
