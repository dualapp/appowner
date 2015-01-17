package com.appowner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mukesh
 * 
 */

@Entity

@Table(name = "tb_subcription")
public class Subcript implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="subcriptID")
private int subcriptID;

	private String subscriptname;
	@Column
	private float price;
		
	public Integer getSubcriptID() {
		return subcriptID;
	}
	public void setSubcriptID(int subcriptID) {
		this.subcriptID = subcriptID;
	}
	public String getSubscriptname() {
		return subscriptname;
	}
	public void setSubscriptname(String subscriptname) {
		this.subscriptname = subscriptname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
