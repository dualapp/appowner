package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.CommiteeMember;
import com.appowner.model.CommitteeRole;
import com.appowner.model.User;
@Repository
public class CommitteeMemberDaoImpl  implements CommitteeMemberDao{
	@Autowired
	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_CommitteeRoles() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(CommitteeRole.class).setCacheable(true).setProjection(Projections.property("str_Committee_Role_Name")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStr_UserNames() {
		 
		return getSessionFactory().getCurrentSession().createCriteria(User.class).setCacheable(true).setProjection(Projections.property("str_Username")).list();
	}

	@Override
	public void addCommitteeMember(CommiteeMember commiteeMember) {
		getSessionFactory().getCurrentSession().save(commiteeMember);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommiteeMember> getCommitteememberlist() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(CommiteeMember.class).setCacheable(true) .list();
	}

	@Override
	public CommiteeMember getOneCommitteeMember(int int_MemberId) {
		// TODO Auto-generated method stub
		return (CommiteeMember) getSessionFactory().getCurrentSession().get(CommiteeMember.class,int_MemberId);
	}

	@Override
	public void updateCommitteeMember(CommiteeMember commiteeMember) {
		 getSessionFactory().getCurrentSession().update(commiteeMember);
		
	}

	@Override
	public void deleteCommitteeMember(CommiteeMember commiteeMember) {
		getSessionFactory().getCurrentSession().delete(commiteeMember);
		
	}

	@Override
	public Integer getUserId(String str_UserName) {
		// TODO Auto-generated method stub
		String hql="select int_UserId from User where str_Username=?";
		return (Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_UserName).uniqueResult();
	}
}
