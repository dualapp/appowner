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
	public List<Notice> listNotices(int firstRow, int rowPerPage,String str_Visible)
	{
	  {   String  query = "{ CALL expireCalculation() }";
				
	  List<Notice> notice = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Notice.class)
	          ).list();
	 
	  }   
	System.out.println(firstRow+"k22");
		if(str_Visible.equalsIgnoreCase("Only Owner of this Complex"))
		
			return (List<Notice>) getSessionFactory().getCurrentSession().createCriteria(Notice.class).setFirstResult(firstRow).setMaxResults(rowPerPage).list();   
		else
		{
			String hql="from Notice where str_Visible=?";
			return (List<Notice>) getSessionFactory().getCurrentSession().createQuery(hql).setFirstResult(firstRow).setMaxResults(rowPerPage).setParameter(0, str_Visible).list();   
		}
	}
	
		 @SuppressWarnings("unchecked")
			public List<String> getmailids(){
				 List<String> list1= (List<String>) getSessionFactory().getCurrentSession().createCriteria(Mail.class).setProjection(Projections.property("mail")).list();
				
				
						    return list1;
			 }
		 
		@Override
		public Integer count() {
			// TODO Auto-generated method stub
			return  (Integer) getSessionFactory().getCurrentSession().createCriteria(Notice.class).setCacheable(true).setProjection(Projections.rowCount()).uniqueResult();
		}
	 
}
