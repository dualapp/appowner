package com.appowner.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.appowner.model.CommiteeMember;
import com.appowner.model.CommitteeRole;
import com.appowner.service.CommitteeMemberService;
import com.appowner.service.VendorService;

@ManagedBean
@ViewScoped
public class CommitteeMemberBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{CommitteeMemberService}")
	 private CommitteeMemberService committeeMemberService;
	public CommitteeMemberService getCommitteeMemberService() {
		return committeeMemberService;
	}
	public void setCommitteeMemberService(
			CommitteeMemberService committeeMemberService) {
		this.committeeMemberService = committeeMemberService;
	}
	private int int_MemberId;
	public int getInt_MemberId() {
		return int_MemberId;
	}
	public void setInt_MemberId(int int_MemberId) {
		this.int_MemberId = int_MemberId;
	}
	private List<String> str_UserNames;
	private String str_UserName;
	public String getStr_UserName() {
		return str_UserName;
	}
	public void setStr_UserName(String str_UserName) {
		this.str_UserName = str_UserName;
	}
	private CommitteeRole committeeRole;
	private String str_CommitteeRole;
	public String getStr_CommitteeRole() {
		return str_CommitteeRole;
	}
	public void setStr_CommitteeRole(String str_CommitteeRole) {
		this.str_CommitteeRole = str_CommitteeRole;
	}
	public CommitteeRole getCommitteeRole() {
		return committeeRole;
	}
	public void setCommitteeRole(CommitteeRole committeeRole) {
		this.committeeRole = committeeRole;
	}
	private List<String> str_CommitteeRoles;
	private String str_ResponsibleFor;
	private Date date_ElectionDate;
	 
	public List<String> getStr_UserNames() {
		str_UserNames=new ArrayList<String>();
		str_UserNames.addAll(getCommitteeMemberService().getStr_UserNames());
		return str_UserNames;
	}
	public void setStr_UserNames(List<String> str_UserNames) {
		this.str_UserNames = str_UserNames;
	}
	public List<String> getStr_CommitteeRoles() {
		str_CommitteeRoles=new ArrayList<String>();
		str_CommitteeRoles.addAll(getCommitteeMemberService().getStr_CommitteeRoles());
		System.out.println(str_CommitteeRoles);
		
		return str_CommitteeRoles;
	}
	public void setStr_CommitteeRoles(List<String> str_CommitteeRoles) {
		this.str_CommitteeRoles = str_CommitteeRoles;
	}
	public String getStr_ResponsibleFor() {
		return str_ResponsibleFor;
	}
	public void setStr_ResponsibleFor(String str_ResponsibleFor) {
		this.str_ResponsibleFor = str_ResponsibleFor;
	}
	public Date getDate_ElectionDate() {
		return date_ElectionDate;
	}
	public void setDate_ElectionDate(Date date_ElectionDate) {
		this.date_ElectionDate = date_ElectionDate;
	}
	
	private List list1=new ArrayList();
	private List list2=new ArrayList();
	private List list3=new ArrayList();
	private List list4=new ArrayList();
	
	
	
	
	public void userNameListener(ValueChangeEvent  event)
	{
		
		list1.add(event.getNewValue());
		
	}

	public void committeeRoleListener(ValueChangeEvent  event)
	{
		
		list2.add(event.getNewValue());
	}
	public void responsibleForListener(ValueChangeEvent  event)
	{
	list3.add(event.getNewValue());
		
	}
	public void electionDateListener(ValueChangeEvent  event)
	{
	list4.add(event.getNewValue());
		
	}
	
	private CommiteeMember commiteeMember ;
	 private Integer int_UserId;
	public Integer getInt_UserId() {
		return int_UserId;
	}
	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}
	@SuppressWarnings("rawtypes")
	public String addCommitteeMember()
	{
		ListIterator itr1 = list1.listIterator();
		ListIterator itr2 = list2.listIterator();
		ListIterator itr3 = list3.listIterator();
		ListIterator itr4 = list4.listIterator();
		while(itr1.hasNext()||itr2.hasNext()||itr3.hasNext()||itr4.hasNext())
		{
			
			str_UserName=(String) itr1.next();
			str_CommitteeRole=(String) itr2.next();
			str_ResponsibleFor=(String) itr3.next();
			date_ElectionDate=(Date) itr4.next();
		System.out.println(str_UserName);
		System.out.println(str_CommitteeRole);
		System.out.println(str_ResponsibleFor);
		System.out.println(date_ElectionDate);
		commiteeMember=new CommiteeMember();
		commiteeMember.setStr_UserName(str_UserName);
		commiteeMember.setInt_UserId(getCommitteeMemberService().getUserId(str_UserName));
		commiteeMember.setStr_CommitteeRole(str_CommitteeRole);
		commiteeMember.setStr_ResponsibleFor(str_ResponsibleFor);
		commiteeMember.setDate_Electiondate(date_ElectionDate);
		commiteeMember.setChar_User_Type('C');
		getCommitteeMemberService().addCommitteeMember(commiteeMember);
		}
		
		return "committeememberlist.xhtml";
	}
	
	public void cancelCommitteeMembers () {
		commiteeMember=new CommiteeMember();
		commiteeMember.setStr_ResponsibleFor("");
		//commiteeMember.setDate_Electiondate("");
		commiteeMember.setStr_CommitteeRole("");
		commiteeMember.setStr_UserName("");
		
	}
	
	private List<CommiteeMember> committeememberlist;
	public List<CommiteeMember> getCommitteememberlist() {
		committeememberlist=new ArrayList<CommiteeMember>();
		committeememberlist.addAll(getCommitteeMemberService().getCommitteememberlist());
		return committeememberlist;
	}
	public void setCommitteememberlist(List<CommiteeMember> committeememberlist) {
		this.committeememberlist = committeememberlist;
	}
	public CommiteeMember getCommiteeMember() {
		return commiteeMember;
	}
	public void setCommiteeMember(CommiteeMember commiteeMember) {
		this.commiteeMember = commiteeMember;
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
	public void getOneCommitteeMember()
	{
		commiteeMember = getCommitteeMemberService(). getOneCommitteeMember(int_MemberId);
	
	}
	
public String updateCommitteeMember()
{
	getCommitteeMemberService().updateCommitteeMember(commiteeMember);
	return "committeememberlist.xhtml";
}

public String deleteCommitteeMember()
{commiteeMember=new CommiteeMember();
 commiteeMember.setInt_MemberId(int_MemberId);
	getCommitteeMemberService().deleteCommitteeMember(commiteeMember);
	return "committeememberlist.xhtml?faces-redirect=true";
	
}
public String cancelCommitteeMember () {
	return "committeememberlist.xhtml?faces-redirect=true";
}

}
