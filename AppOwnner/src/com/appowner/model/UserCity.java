package com.appowner.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_city")
public class UserCity   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="int_CityId")
	private Integer int_CityId;
	@Column(name="int_StateId")
	private Integer int_StateId;
	@JoinColumn(name = "int_StateId", insertable = false, updatable=false)
	private UserState userState;
	public UserState getUserState() {
		return userState;
	}
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	public Integer getInt_StateId() {
		return int_StateId;
	}
	public void setInt_StateId(Integer int_StateId) {
		this.int_StateId = int_StateId;
	}
	@Column(name="var_CityName")
	private String str_CityName;
	public Integer getInt_CityId() {
		return int_CityId;
	}
	public void setInt_CityId(Integer int_CityId) {
		this.int_CityId = int_CityId;
	}
	public String getStr_CityName() {
		return str_CityName;
	}
	public void setStr_CityName(String str_CityName) {
		this.str_CityName = str_CityName;
	}
	//one to many relation
		@OneToMany(targetEntity = UserApartment.class, cascade = { CascadeType.ALL })
		private List<String> apatrments;
		public List<String> getApatrments() {
			return apatrments;
		}
		public void setApatrments(List<String> apatrments) {
			this.apatrments = apatrments;
		}
		
}
