package com.appowner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tb_Ads")
public class cls_Ads {
	/**
	 * mukesh
	 */
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Adsid;
	@Column
    private String str_category;
	@Column
    private String  str_title;
    @Column
    private String  message1;
	public Integer getAdsid() {
		return Adsid;
	}
	public void setAdsid(Integer adsid) {
		Adsid = adsid;
	}
	public String getStr_category() {
		return str_category;
	}
	public void setStr_category(String str_category) {
		this.str_category = str_category;
	}
	public String getStr_title() {
		return str_title;
	}
	public void setStr_title(String str_title) {
		this.str_title = str_title;
	}
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}
    
	
 
}
