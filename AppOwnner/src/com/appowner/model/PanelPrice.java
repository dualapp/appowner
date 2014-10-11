package com.appowner.model;

import java.io.Serializable;



import javax.persistence.Cacheable;
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
@Table(name="tb_PanelPrice")
public class PanelPrice implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer int_PanelID;
  public Integer getInt_PanelID() {
		return int_PanelID;
	}
	public void setInt_PanelID(Integer int_PanelID) {
		this.int_PanelID = int_PanelID;
	}
public String getStr_Panel() {
		return str_Panel;
	}
	public void setStr_Panel(String str_Panel) {
		this.str_Panel = str_Panel;
	}
	public double getDoub_Price() {
		return doub_Price;
	}
	public void setDoub_Price(double doub_Price) {
		this.doub_Price = doub_Price;
	}
private String str_Panel;
  private double doub_Price;
 
	

	public Boolean getEditable() {
	return editable;
}
public void setEditable(Boolean editable) {
	this.editable = editable;
}
	private Boolean editable;

}
