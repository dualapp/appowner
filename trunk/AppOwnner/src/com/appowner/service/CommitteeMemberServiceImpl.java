package com.appowner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.CommitteeMemberDao;
import com.appowner.model.CommiteeMember;

@Service("CommitteeMemberService")
@Transactional
public class CommitteeMemberServiceImpl implements CommitteeMemberService {
	@Autowired
	private CommitteeMemberDao  committeeMemberDao;
	public CommitteeMemberDao getCommitteeMemberDao() {
		return committeeMemberDao;
	}
	public void setCommitteeMemberDao(CommitteeMemberDao committeeMemberDao) {
		this.committeeMemberDao = committeeMemberDao;
	}
	@Override
	public List<String> getStr_CommitteeRoles() {
		// TODO Auto-generated method stub
		return getCommitteeMemberDao().getStr_CommitteeRoles();
	}
	@Override
	public List<String> getStr_UserNames() {
		// TODO Auto-generated method stub
		return getCommitteeMemberDao().getStr_UserNames();
	}
	@Override
	public void addCommitteeMember(CommiteeMember commiteeMember) {
		getCommitteeMemberDao().addCommitteeMember(commiteeMember);
		
	}
	@Override
	public List<CommiteeMember> getCommitteememberlist() {
		// TODO Auto-generated method stub
		return getCommitteeMemberDao(). getCommitteememberlist();
	}
	@Override
	public CommiteeMember getOneCommitteeMember(int int_MemberId) {
		// TODO Auto-generated method stub
		return getCommitteeMemberDao().getOneCommitteeMember(int_MemberId);
	}
	@Override
	public void updateCommitteeMember(CommiteeMember commiteeMember) {
		getCommitteeMemberDao().updateCommitteeMember(commiteeMember);
		
	}
	@Override
	public void deleteCommitteeMember(CommiteeMember commiteeMember) {
		getCommitteeMemberDao().deleteCommitteeMember(commiteeMember);
		
	}
	@Override
	public Integer getUserId(String str_UserName) {
		// TODO Auto-generated method stub
		return getCommitteeMemberDao().getUserId(str_UserName);
	}
	 
}
