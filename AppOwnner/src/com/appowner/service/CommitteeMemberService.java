package com.appowner.service;

import java.util.Collection;
import java.util.List;

import com.appowner.model.CommiteeMember;

public interface CommitteeMemberService {

	List<String> getStr_CommitteeRoles();

	List<String> getStr_UserNames();

	void addCommitteeMember(CommiteeMember commiteeMember);

	List<CommiteeMember> getCommitteememberlist();

	CommiteeMember getOneCommitteeMember(int int_MemberId);

	void updateCommitteeMember(CommiteeMember commiteeMember);

	void deleteCommitteeMember(CommiteeMember commiteeMember);

	Integer getUserId(String str_UserName);
	
	

}
