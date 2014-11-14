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

@Table(name = "tb_HouseDetails")

public class HouseDetails  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private Integer int_HouseId;
	@Column 
	private Integer int_HouseNo;
	@Column 
	private Integer int_HouseSize;
     
    @Column 
    private Integer int_NoOfBedRooms;
    @Column 
    private Integer int_NoOfBalconies;
    @Column 
    private Integer int_NoOfUsers;
    @Column 
    private Integer int_BlockId;
    @Column 
    private Integer int_ApartmentId;
    @Column(name="var_TypeOfHouse")
	private String str_CommunitySetupType;
    @Column 
	private Boolean  is_Rented;
}