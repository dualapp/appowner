package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.DueTemplate;
import com.appowner.model.DueTransaction;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.Vendor;

@Repository
public class DueDaoImpl implements DueDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<String> getAccountsList()
	{
		List<String> accountList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setCacheable(true).setProjection(Projections.property("str_Accounts")).list();
		return accountList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getDueTemplate()
	{
		List<String> dueTemplateList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setCacheable(true).setProjection(Projections.property("str_DueTemplate")).list();
		return dueTemplateList;
	}
	public Integer saveDueTransaction(DueTransaction due)
	{
		 return (Integer) getSessionFactory().getCurrentSession().save(due);
	}
	@SuppressWarnings("unchecked")
	public List<DueTransaction> listDueTransaction(String str_DueTemplate, String str_Block, String str_ApartmentNo, String str_Period, String str_Status)
	{  System.out.println(str_DueTemplate+"kklk");
	    System.out.println(str_Block+"jkjj");
	    System.out.println(str_ApartmentNo+"jkkjkj");
	    System.out.println(str_Period+"jjjjj");
	    System.out.println(str_Status+"jkjkjkjk");
	    
		if(str_DueTemplate==null && str_Block==null && str_ApartmentNo==null && str_Period==null && str_Status==null)
		{  System.out.println("ghhhhjhhh");
		return getSessionFactory().getCurrentSession().createCriteria(DueTransaction.class).setCacheable(true).list();
		}
		else if(str_DueTemplate.isEmpty())
		{   System.out.println("hbhjcjvf");
			return getSessionFactory().getCurrentSession().createCriteria(DueTransaction.class).setCacheable(true).list();
		}
		else if(str_DueTemplate.equals(str_DueTemplate))
		{
			
			System.out.println("ghhhhjhhh1111");
			return getSessionFactory().getCurrentSession().createCriteria(DueTransaction.class).setCacheable(true).list();
		}
		else if(str_Status==null)
		{
			
			System.out.println(str_Status+"jkjkkkjkkk");
			System.out.println(str_DueTemplate+"jkjkkkjkkk123");
			System.out.println(str_Period+"jkjkkkjkkk456");
			System.out.println(str_Block+"jkjkkkjkkk789");
			System.out.println(str_ApartmentNo+"jkjkkkjkkk1265");
				String str="From DueTransaction where str_DueTemplate=? AND str_Period=? AND str_Block=? AND str_ApartmentNo=?"; 
				return getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_DueTemplate).setParameter(1, str_Period).setParameter(2, str_Block).setParameter(3, str_ApartmentNo).list();
			}
			else
			{
			String str="From DueTransaction where str_DueTemplate=? AND str_Period=? AND str_Block=? AND str_ApartmentNo=? AND str_Status=?";
			return getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_DueTemplate).setParameter(1, str_Period).setParameter(2, str_Block).setParameter(3, str_ApartmentNo).setParameter(4, str_Status).list();
		    }
		}
	@SuppressWarnings("unchecked")
	public List<DueTransaction> listDueTransaction1(String str_DueTemplate,String str_Block, String str_ApartmentNo, String str_BillPeriod,Integer int_Year)
	{   System.out.println(str_DueTemplate+"kklk13");
     System.out.println(str_Block+"jkjj34");
     System.out.println(str_ApartmentNo+"jkkjkj45");
     System.out.println(str_BillPeriod+"jjjjj34");
     System.out.println(int_Year+"jkjkjkjk76");
		String str="From DueTransaction where str_DueTemplate=? AND str_Period=? AND str_Block=? AND str_ApartmentNo=? AND  int_Year=?";
		return getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_DueTemplate).setParameter(1, str_BillPeriod).setParameter(2, str_Block).setParameter(3, str_ApartmentNo).setParameter(4, int_Year).list(); 
	}
	@SuppressWarnings("unchecked")
	public List<String> getBlockList(String str_Organisation)
	{
		String hql="select str_Block from User where str_Apartment=?";
		return (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Organisation).list();
	}
	@SuppressWarnings("unchecked")
	public List<String> getApartmentlist(String str_Block)
	{
		String hql="select str_Flat from User where str_Block=?";
		List<String> list=(List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Block).list();
		System.out.println(list);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<DueTransaction> listUserDueTransaction(String str_ApartmentNo, String str_ApartmentNo1, String str_Status, String str_Period, String str_DueTemplate)
	{   System.out.println(str_ApartmentNo+"kil");
		String hql="from DueTransaction where str_Block=?";
		List<DueTransaction>   sss=(List<DueTransaction>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_ApartmentNo).list();
		System.out.println(sss);
		return sss;
	}
	public DueTransaction getUserDueTransaction(Integer int_DueTransactionID)
	{
		 return (DueTransaction)getSessionFactory().getCurrentSession().get(DueTransaction.class,int_DueTransactionID); 
	}
	public double getDueAmount(String str_Block, String str_DueTemplate)
	{
		String str="select str_Rate from DueTemplate where str_DueTemplate=?";
		double str1=(double)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,str_DueTemplate).uniqueResult();
		String hql1="select str_Calculation from DueTemplate where str_DueTemplate=?";
		String str4=(String)getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,str_DueTemplate).uniqueResult();
		System.out.println(str4+"hhjjhj");
		if(str4.equalsIgnoreCase("Sqft"))
		{
		String hql="select sqft from User where str_Flat=?";
		double str2=(double)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_Block).uniqueResult();
		System.out.println(str2);
		System.out.println(str1*str2);
		return (str1*str2);
		}
		return str1;
	}
	@SuppressWarnings("unchecked")
	public List<String> listRavenues()
	{
		String hql=" select str_AccountName from ChartOfAccount  where str_AccountType='Income'";
		 
		List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).list();
		return ravenueList; 
	}
	public void updateDueTransaction(DueTransaction due2)
	{
		sessionFactory.getCurrentSession().update(due2);
	}
	@SuppressWarnings("unchecked")
	public List<Integer> getDueTemplate1(String invoiceNo)
	{   System.out.println(invoiceNo);
		String str="select int_DueTransactionID from DueTransaction where int_InvoiceNo=?";
		List<Integer> ddd=(List<Integer>)sessionFactory.getCurrentSession().createQuery(str).setParameter(0,invoiceNo).list();
		System.out.println(ddd.listIterator().hasNext());
		return ddd;
		
	}
	public double getDueAmount1(Integer str1)
	{
		String str="select dbl_DueAmount from DueTransaction where int_DueTransactionID=?";
		return (double) sessionFactory.getCurrentSession().createQuery(str).setParameter(0,str1).uniqueResult();
	}
	public void updateDueTransaction(String str_Status, Integer str1, double ddd)
	{
		String hql="update DueTransaction set str_Status=?,int_paidAmount=?,dbl_TotalDueAmount=? where int_DueTransactionID=?";
		sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,"Paid").setParameter(1,ddd).setParameter(2, 0.00).setParameter(3, str1).executeUpdate();
	}
	public void deleteDues(Integer id)
	{
		getSessionFactory().getCurrentSession().createQuery("DELETE FROM DueTransaction WHERE int_DueTransactionID = "+id).executeUpdate();
	}
	public String getFrequency(String ddd)
	{   String str="select str_Frequency from DueTemplate where str_DueTemplate=?";
		return (String) getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,ddd).setCacheable(true).uniqueResult();
		
	}
	public void updateDue(Integer id, String int_InvoiceNo)
	{String str="update DueTransaction set int_InvoiceNo=? where int_DueTransactionID=?";
		getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,int_InvoiceNo).setParameter(1,id).executeUpdate();
	}
}
