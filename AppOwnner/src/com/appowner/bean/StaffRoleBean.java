package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.Staff;
import com.appowner.service.ComplainService;
import com.appowner.service.StaffService;

@ManagedBean
@SessionScoped
public class StaffRoleBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{StaffService}")
	private StaffService staffService;
	
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	private Integer int_StaffID;
	public Integer getInt_StaffID() {
		return int_StaffID;
	}
	public void setInt_StaffID(Integer int_StaffID) {
		this.int_StaffID = int_StaffID;
	}
	public String getStr_StaffName() {
		return str_StaffName;
	}
	public void setStr_StaffName(String str_StaffName) {
		this.str_StaffName = str_StaffName;
	}
	
	
	public char getCh_StaffType() {
		return ch_StaffType;
	}
	public void setCh_StaffType(char ch_StaffType) {
		this.ch_StaffType = ch_StaffType;
	}
	public Integer getInt_isActive() {
		return int_isActive;
	}
	public void setInt_isActive(Integer int_isActive) {
		this.int_isActive = int_isActive;
	}
	public Integer getInt_isDelete() {
		return int_isDelete;
	}
	public void setInt_isDelete(Integer int_isDelete) {
		this.int_isDelete = int_isDelete;
	}
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
	private String str_StaffName;
	private char ch_StaffType;
	private Integer int_isActive;
	private Integer int_isDelete;
	private Integer int_ApartmentID;
	private List<Staff> ListStaffRoles;
	public List<Staff> getListStaffRoles() {
		ListStaffRoles=new ArrayList<Staff>();
		ListStaffRoles.addAll( getStaffService().listStaffRoles());
		System.out.println(ListStaffRoles);
		return ListStaffRoles;
	}
	public void setListStaffRoles(List<Staff> listStaffRoles) {
		ListStaffRoles = listStaffRoles;
	}
	private List<Staff> staff; 
	
	
	public List<Staff> getStaff() {
		return staff;
	}
	public void setStaff(List<Staff> staff) {
		this.staff= staff;
	}
	@PostConstruct
    public void init() {
	staff=new ArrayList<Staff>();
	}
	public void add() {
		Staff s=new Staff();
	     staff.add(s);
		 
	}
	private List<Object> list=new ArrayList();
	
    public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public void staffchangeListener(ValueChangeEvent event) {

		
		list.add(event.getNewValue());
		
	}
	private Staff staff1=new Staff();;
	
	public Staff getStaff1() {
		return staff1;
	}
	public void setStaff1(Staff staff1) {
		this.staff1 = staff1;
	}
	public String addStaff()
    {  
        @SuppressWarnings("rawtypes")
		ListIterator itr=list.listIterator();
           
        while(itr.hasNext()){
        	Object o=itr.next();
        	  
        	str_StaffName=(String)o;
        
        	staff1.setStr_StaffName(str_StaffName);
        	staff1.setCh_StaffType('C');
        	staff1.setFlag(2);
        	 getStaffService().addStaff(staff1);
        	
        }
        return "StaffRoles.xhtml";
    }
	private Integer flag;
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
   
	
}