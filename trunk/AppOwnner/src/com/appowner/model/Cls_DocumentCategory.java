package com.appowner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tb_document_category")
public class Cls_DocumentCategory {
	/**
	 * mukesh
	 */
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Int_Document_CatID;
	@Column
	private String Int_Document_CatNM;
	@Column
	private Integer isActive;
	@Column
	private Integer isDelete;
	@Column
	private char Ch_Category_Status;
	@Column
	private String Action;
	
public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

public Integer getInt_Document_CatID() {
		return Int_Document_CatID;
	}

public void setInt_Document_CatID(Integer int_Document_CatID) {
		Int_Document_CatID = int_Document_CatID;
	}



public String getInt_Document_CatNM() {
	return Int_Document_CatNM;
}

public void setInt_Document_CatNM(String int_Document_CatNM) {
	Int_Document_CatNM = int_Document_CatNM;
}

public char getCh_Category_Status() {
	return Ch_Category_Status;
}

public void setCh_Category_Status(char ch_Category_Status) {
	Ch_Category_Status = ch_Category_Status;
}

public Integer getIsActive() {
		return isActive;
	}
public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
public Integer getIsDelete() {
		return isDelete;
	}
public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
public static long getSerialversionuid() {
		return serialVersionUID;
	}

private Integer flag;

public Integer getFlag() {
	return flag;
}

public void setFlag(Integer flag) {
	this.flag = flag;
}

	
}


