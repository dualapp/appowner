package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.FileUploadEvent;
import org.springframework.dao.DataAccessException;

import com.appowner.model.CommiteeRole;
import com.appowner.model.Notice;
import com.appowner.model.RoleMaster;
import com.appowner.service.ComplainService;
import com.appowner.service.StaffService;

@ManagedBean
@ViewScoped
public class RoleMasterBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{StaffService}")
	private StaffService staffService;
	
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	private Integer int_RoleID;
	public Integer getInt_RoleID() {
		return int_RoleID;
	}
	public void setInt_RoleID(Integer int_RoleID) {
		this.int_RoleID = int_RoleID;
	}
	public String getStr_RoleName() {
		return str_RoleName;
	}
	public void setStr_RoleName(String str_RoleName) {
		this.str_RoleName = str_RoleName;
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
	public Integer getInt_ApartmentID() {
		return int_ApartmentID;
	}
	public void setInt_ApartmentID(Integer int_ApartmentID) {
		this.int_ApartmentID = int_ApartmentID;
	}
	private String str_RoleName;
	private Integer isActive;
	private Integer isDelete;
	private Integer int_ApartmentID;
	private List<RoleMaster> listRoleMaster;
	public List<RoleMaster> getListRoleMaster() {
		listRoleMaster=new ArrayList<RoleMaster>();
		
		listRoleMaster.addAll(getStaffService().listRoleMaster());
		return listRoleMaster;
	}
	public void setListRoleMaster(List<RoleMaster> listRoleMaster) {
		this.listRoleMaster = listRoleMaster;
	}

	private List<RoleMaster> master1;
public List<RoleMaster> getMaster1() {
		return master1;
	}
	public void setMaster1(List<RoleMaster> master1) {
		this.master1 = master1;
	}
	@PostConstruct
    public void init() {
		master1=new ArrayList<RoleMaster>();
	}
private List<Object> list=new ArrayList();
	
    public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public void masterchangeListener(ValueChangeEvent event) {

		
		list.add(event.getNewValue());
		System.out.println(list);
		
	}
	private RoleMaster master2;
	
	
	
	public RoleMaster getMaster2() {
		return master2;
	}
	public void setMaster2(RoleMaster master2) {
		this.master2 = master2;
	}
	public String addMaster()
    {  
        @SuppressWarnings("rawtypes")
		ListIterator itr=list.listIterator();
           
        while(itr.hasNext()){
        	Object o=itr.next();
        	  
        	str_RoleName=(String)o;
           System.out.println(str_RoleName);
        master2.setStr_RoleName(str_RoleName);
        	master2.setCh_RoleMasterType('C');
        	master2.setFlag(2);
        	getStaffService().addMaster(master2);
        	
        }
        return "RoleMaster.xhtml";
    }

  public void 	getRoleMaster()
  {
	 master2= getStaffService().getRoleMaster(int_RoleID);
  }
  public String saveRoleMaster()
  {
	  getStaffService().updateRoleMaster(master2);
	return null; 
  }
	
	
}
