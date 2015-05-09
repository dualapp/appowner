package com.appowner.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Mail;
import com.appowner.model.Notice;
import com.appowner.util.Util;

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
	 /* {   String  query = "{ CALL expireCalculation() }";
				
	  List<Notice> notice = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Notice.class)
	          ).list();
	 
	  }   */
		Date date=new java.util.Date();
		Calendar c = Calendar.getInstance(); 
		 c.setTime(date);
		 
		 
		
	Date date1= c.getTime();
		System.out.println(date1+"kunkupriya");
		
	System.out.println(firstRow+"k22");
		if(str_Visible.equalsIgnoreCase("Only Owner of this Complex"))
		{
		     System.out.println("jkjkkjjjjjjjjjjjjjjjjjjjjj");
			return (List<Notice>) getSessionFactory().getCurrentSession().createQuery("from Notice where  int_ApartmentID=? and dat_ExpireOn >=?").setParameter(0,Util.getAppartmentId()).setParameter(1, date1).setFirstResult(firstRow).setMaxResults(rowPerPage).list();
		}
		else
		{   System.out.println("hjfvvhjfghjjj");
			String hql="from Notice where str_Visible=1 and int_ApartmentID=? and dat_ExpireOn >=?";
			return (List<Notice>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Util.getAppartmentId()).setParameter(1, date1).setFirstResult(firstRow).setMaxResults(rowPerPage).list();   
		}
	}
	@SuppressWarnings("unchecked")
	public List<Notice> listArchieveNotices(String str_Visible)
	{
		Date date=new java.util.Date();
		Calendar c = Calendar.getInstance(); 
		 c.setTime(date);
		 
		 
		
	Date date1= c.getTime();
		System.out.println(date1+"kunkupriya");
		
	
		if(str_Visible.equalsIgnoreCase("Only Owner of this Complex"))
		{
		     System.out.println("jkjkkjjjjjjjjjjjjjjjjjjjjj");
			return (List<Notice>) getSessionFactory().getCurrentSession().createQuery("from Notice where  int_ApartmentID=? and dat_ExpireOn <=?").setParameter(0,Util.getAppartmentId()).setParameter(1, date1).list();
		}
		else
		{   System.out.println("hjfvvhjfghjjj");
			String hql="from Notice where str_Visible=1 and int_ApartmentID=? and dat_ExpireOn <=?";
			return (List<Notice>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Util.getAppartmentId()).setParameter(1, date1).list();   
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
		public Notice getNotice(int id)
		{
			String hql="from Notice where int_NoticeID=? and int_ApartmentID=?";
			return (Notice) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,id).setParameter(1,Util.getAppartmentId()).uniqueResult();
		}
		public void updateNotice(Notice notice)
		{
			sessionFactory.getCurrentSession().update(notice);
		}
	 
}
