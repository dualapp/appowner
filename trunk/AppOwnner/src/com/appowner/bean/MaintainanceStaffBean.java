package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.MaintainanceStaff;
import com.appowner.service.MaintainanceStaffService;

@ManagedBean
@ViewScoped
public class MaintainanceStaffBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{MaintainanceStaffService}")
	private  MaintainanceStaffService maintainanceStaffService;
	private String str_UserName;
	private String str_Email;
	private String str_Mobile;
	private String str_RoleName;

	public String getStr_UserName() {
		return str_UserName;
	}
    
	public void setStr_UserName(String str_UserName) {
		this.str_UserName = str_UserName;
	}

	public String getStr_Email() {
		return str_Email;
	}

	public void setStr_Email(String str_Email) {
		this.str_Email = str_Email;
	}

	public String getStr_Mobile() {
		return str_Mobile;
	}

	public void setStr_Mobile(String str_Mobile) {
		this.str_Mobile = str_Mobile;
	}

	public String getStr_RoleName() {
		return str_RoleName;
	}

	public void setStr_RoleName(String str_RoleName) {
		this.str_RoleName = str_RoleName;
	}

	public MaintainanceStaffService getMaintainanceStaffService() {
		return maintainanceStaffService;
	}

	public void setMaintainanceStaffService(
			MaintainanceStaffService maintainanceStaffService) {
		this.maintainanceStaffService = maintainanceStaffService;
	}
	 
	
	private List<String> str_MaintainanceStaffRoles;
	 


	public List<String> getStr_MaintainanceStaffRoles() {
		
		str_MaintainanceStaffRoles=new ArrayList<String>();
		str_MaintainanceStaffRoles.addAll(getMaintainanceStaffService().getStr_MaintainanceStaffRoles());
		
		return str_MaintainanceStaffRoles;
	}

	public void setStr_MaintainanceStaffRoles(
			List<String> str_MaintainanceStaffRoles) {
		this.str_MaintainanceStaffRoles = str_MaintainanceStaffRoles;
	}

	public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

	public List getList2() {
		return list2;
	}

	public void setList2(List list2) {
		this.list2 = list2;
	}

	public List getList3() {
		return list3;
	}

	public void setList3(List list3) {
		this.list3 = list3;
	}

	public List getList4() {
		return list4;
	}

	public void setList4(List list4) {
		this.list4 = list4;
	}
	private List list1=new ArrayList();
	private List list2=new ArrayList();
	private List list3=new ArrayList();
	private List list4=new ArrayList();
	public void userNameListener(ValueChangeEvent event)
	{
		list1.add(event.getNewValue());
	}
	
	public void maintainanceStaffRoleListener(ValueChangeEvent event)
	{
		list2.add(event.getNewValue());
	}
	public void emailListener(ValueChangeEvent event)
	{
		list3.add(event.getNewValue());
	}
	public void mobileListener(ValueChangeEvent event)
	{
		list4.add(event.getNewValue());
	}
	private MaintainanceStaff maintainanceStaff;
	public MaintainanceStaff getMaintainanceStaff() {
		return maintainanceStaff;
	}

	public void setMaintainanceStaff(MaintainanceStaff maintainanceStaff) {
		this.maintainanceStaff = maintainanceStaff;
	}
private Integer int_MaintainanceStaffID;
	 

	public Integer getInt_MaintainanceStaffID() {
	return int_MaintainanceStaffID;
}

public void setInt_MaintainanceStaffID(Integer int_MaintainanceStaffID) {
	this.int_MaintainanceStaffID = int_MaintainanceStaffID;
}

	public String addMaintainanceStaff()
	{
		/*maintainanceStaff=new MaintainanceStaff();
		maintainanceStaff.setInt_UserId(getInt_UserId());
		maintainanceStaff.setStr_Email(getStr_Email());
		maintainanceStaff.setStr_Mobile(getStr_Mobile());
		maintainanceStaff.setStr_RoleName(getStr_RoleName());
		maintainanceStaff.setStr_UserName(getStr_UserName());
		getMaintainanceStaffService().addMaintainanceStaff(maintainanceStaff);*/
		
		ListIterator itr1 = list1.listIterator();
		ListIterator itr2 = list2.listIterator();
		ListIterator itr3 = list3.listIterator();
		ListIterator itr4 = list4.listIterator();
		while(itr1.hasNext()||itr2.hasNext()||itr3.hasNext()||itr4.hasNext())
		{
			str_UserName=(String) itr1.next();
			str_RoleName=(String) itr2.next();
			str_Email=(String) itr3.next();
			str_Mobile=(String) itr4.next();
			System.out.println(str_UserName);
			System.out.println(str_RoleName);
			maintainanceStaff=new MaintainanceStaff();
			maintainanceStaff.setStr_UserName(str_UserName);
			maintainanceStaff.setStr_RoleName(str_RoleName);
			maintainanceStaff.setInt_UserId(getMaintainanceStaffService().getUserId(str_UserName));
			maintainanceStaff.setInt_RoleId(getMaintainanceStaffService().getMaintainanceStaffRoleId(str_RoleName));
			maintainanceStaff.setStr_Email(str_Email);
			maintainanceStaff.setStr_Mobile(str_Mobile);
			maintainanceStaff.setChar_User_Type('S');
			getMaintainanceStaffService().addMaintainanceStaff(maintainanceStaff);
			
		}
		return "maintainancestafflist.xhtml";
	}
	private List<MaintainanceStaff> maintainanceStaffList;

	public List<MaintainanceStaff> getMaintainanceStaffList() {
		maintainanceStaffList=new ArrayList<MaintainanceStaff>();
		maintainanceStaffList.addAll(getMaintainanceStaffService().getMaintainanceStaffList());
		return maintainanceStaffList;
	}

	public void setMaintainanceStaffList(
			List<MaintainanceStaff> maintainanceStaffList) {
		this.maintainanceStaffList = maintainanceStaffList;
	}
	public MaintainanceStaff getOneMaintainanceStaff()
	{
		maintainanceStaff=getMaintainanceStaffService().getOneMaintainanceStaff(int_MaintainanceStaffID);
		return maintainanceStaff;
	}
	public String updateMaintainanceStaff()
	{
		getMaintainanceStaffService().updateMaintainanceStaff(maintainanceStaff);
		return "maintainancestafflist.xhtml";
	}
	public String deleteMaintainanceStaff()
	{
		maintainanceStaff=new MaintainanceStaff();
		//maintainanceStaff.setInt_UserId(int_UserId);
		maintainanceStaff.setInt_MaintainanceStaffID(int_MaintainanceStaffID);
		getMaintainanceStaffService().deleteMaintainanceStaff(maintainanceStaff);
		return "maintainancestafflist.xhtml?faces-redirect=true";
	}
	public String cancelMaintainanceStaff() {
		return "maintainancestafflist.xhtml?faces-redirect=true";
	}
}

