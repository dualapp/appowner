package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_msg-category")
public class cls_MessageCategory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@Column(name="int_MessageCategoryId")
	private Integer int_MessageCategoryId;
	
	@Column(name="var_MessageCategory")
	private String var_MessageCategory;

	public Integer getInt_MessageCategoryId() {
		return int_MessageCategoryId;
	}

	public void setInt_MessageCategoryId(Integer int_MessageCategoryId) {
		this.int_MessageCategoryId = int_MessageCategoryId;
	}

	public String getVar_MessageCategory() {
		return var_MessageCategory;
	}

	public void setVar_MessageCategory(String var_MessageCategory) {
		this.var_MessageCategory = var_MessageCategory;
	}

}
