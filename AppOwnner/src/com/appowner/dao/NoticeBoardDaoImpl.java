package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Mail;
import com.appowner.model.Notice;

@Repository
public class NoticeBoardDaoImpl implements NoticeBoardDao {
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addNotice(Notice notice)
	{
		getSessionFactory().getCurrentSession().save(notice);	
	}
	@SuppressWarnings("unchecked")
	public List<Notice> listNotices(String str_Visible)
	{
	  /*{   String  query = "{ CALL expireCalculation() }";
				
	  List<Notice> notice = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Notice.class)
	          ).list();
         */
	  
		if(str_Visible.equalsIgnoreCase("Only Owner of this Complex"))
		
			return (List<Notice>) getSessionFactory().getCurrentSession().createCriteria(Notice.class).setCacheable(true).list();   
		else
		{
			String hql="from Notice where str_Visible=?";
			return (List<Notice>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Visible).setCacheable(true).list();   
		}
	}
	
		 @SuppressWarnings("unchecked")
			public List<String> getmailids(){
				 List<String> list1= (List<String>) getSessionFactory().getCurrentSession().createCriteria(Mail.class).setProjection(Projections.property("mail")).list();
				
				
						    return list1;
			 }
	 
}
