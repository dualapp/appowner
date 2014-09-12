package com.appowner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.dao.MemberDao;
import com.appowner.model.Members;
@Service("MembersDetailService")
@Transactional 
public class MemberDetailsServiceImpl implements MembersDetailService {
@Autowired
private MemberDao memberDao;

public MemberDao getMemberDao() {
	return memberDao;
}

public void setMemberDao(MemberDao memberDao) {
	this.memberDao = memberDao;
}

@Override
public void addmembers(Members m1) {
	getMemberDao().addmembers(m1);
	
}

}