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
@Table(name = "tb_option")
public class Option implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer int_optionId;
	public Integer getInt_optionId() {
		return int_optionId;
	}

	public void setInt_optionId(Integer int_optionId) {
		this.int_optionId = int_optionId;
	}
	@Column
	private String optionName;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	
	

	
}
