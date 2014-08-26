package com.appowner.dao;

import java.util.Date;
import java.util.List;




import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.AccountsOpeningBalance;
import com.appowner.model.ManualJournal;

@Repository
public class AccountsDaoImpl implements AccountsDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<AccountsOpeningBalance> listOpeningBalance()
	{
		return getSessionFactory().getCurrentSession().createCriteria(AccountsOpeningBalance.class).list();
	}
	public void addAccounts(Integer int_Accounts_OpeningID, Double int_Debit)
	{   String hql="update  AccountsOpeningBalance  set int_Debit =?  where int_Accounts_OpeningID =?";
        
	  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_Debit).setParameter(1,int_Accounts_OpeningID).executeUpdate();
	}
	public void saveAccounts(Integer int_Accounts_OpeningID, Double int_Credit)
	{
		String hql="update  AccountsOpeningBalance  set int_Credit =?  where int_Accounts_OpeningID =?";
      
	  getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_Credit).setParameter(1,int_Accounts_OpeningID).executeUpdate();
		
	}
	public void addManualJournal(ManualJournal journal){
		getSessionFactory().getCurrentSession().save(journal);
	}
	public void addBalance(Date date, Integer id1, Integer id)
	{   System.out.println(id);
	System.out.println(date);
	System.out.println(id1);
		String hql="update  AccountsOpeningBalance  set dat_openingDate =?,int_ApartmentID=?  where int_Accounts_OpeningID =?";
	    getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, date).setParameter(1, id1).setParameter(2, id).executeUpdate();
	}
	
}
