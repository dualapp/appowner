package com.appowner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tb_create_document_management")
public class Cls_CreateDocumentManagement{
	/**
	 * mukesh
	 */
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Int_DocumentID;
	@Column
	private String str_FileNM;
	
	@Column
	private String str_Description;
	@Column
	private int int_Userid;
	@Column
	private int int_ApartmentID;
	private String Str_FirstName;
	private String Dt_Date;
    private String str_FolderNM;
	private String str_ApartmentName;
	
	
	public String getStr_ApartmentName() {
	return str_ApartmentName;
	}

	public void setStr_ApartmentName(String str_ApartmentName) {
		this.str_ApartmentName = str_ApartmentName;
	}

	public String getStr_FirstName() {
		return Str_FirstName;
	}

	public void setStr_FirstName(String str_FirstName) {
		Str_FirstName = str_FirstName;
	}

	public int getInt_ApartmentID() {
		return int_ApartmentID;
	}

	public void setInt_ApartmentID(int int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}

	public int getInt_Userid() {
		return int_Userid;
	}

	public void setInt_Userid(int int_Userid) {
		this.int_Userid = int_Userid;
	}

	public String getStr_Description() {
		return str_Description;
	}

	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}

	@Column
	private Integer Int_Document_CatID;
	@Column
	private String Ch_Access;
	
	@Column
	private String Bit_emailsend;
	
	
public Integer getInt_DocumentID() {
		return Int_DocumentID;
	}

	public void setInt_DocumentID(Integer int_DocumentID) {
		Int_DocumentID = int_DocumentID;
	}

	public String getStr_FileNM() {
		return str_FileNM;
	}

	public void setStr_FileNM(String str_FileNM) {
		this.str_FileNM = str_FileNM;
	}

	

	public Integer getInt_Document_CatID() {
		return Int_Document_CatID;
	}

	public void setInt_Document_CatID(Integer int_Document_CatID) {
		Int_Document_CatID = int_Document_CatID;
	}

	public String getCh_Access() {
		return Ch_Access;
	}

	public void setCh_Access(String ch_Access) {
		Ch_Access = ch_Access;
	}

	public String getBit_emailsend() {
		return Bit_emailsend;
	}

	public void setBit_emailsend(String bit_emailsend) {
		Bit_emailsend = bit_emailsend;
	}

	public String getDt_Date() {
		return Dt_Date;
	}

	public void setDt_Date(String dt_Date) {
		Dt_Date = dt_Date;
	}
public String getStr_FolderNM() {
		return str_FolderNM;
	}

	public void setStr_FolderNM(String str_FolderNM) {
		this.str_FolderNM = str_FolderNM;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInt_Document_CatNM() {
		return Int_Document_CatNM;
	}

	public void setInt_Document_CatNM(String int_Document_CatNM) {
		Int_Document_CatNM = int_Document_CatNM;
	}

	

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	private String Int_Document_CatNM;
	
	private String Action;
	private String Size;


}
