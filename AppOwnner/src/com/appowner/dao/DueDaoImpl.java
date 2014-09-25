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
		List<String> accountList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setProjection(Projections.property("str_Accounts")).list();
		return accountList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getDueTemplate()
	{
		List<String> dueTemplateList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setProjection(Projections.property("str_DueTemplate")).list();
		return dueTemplateList;
	}
	public Integer saveDueTransaction(DueTransaction due)
	{
		 return (Integer) getSessionFactory().getCurrentSession().save(due);
	}
	@SuppressWarnings("unchecked")
	public List<DueTransaction> listDueTransaction(String str_DueTemplate, String str_Block, String str_ApartmentNo, String str_Period, String str_Status)
	{
		if(str_DueTemplate==null && str_Block==null && str_ApartmentNo==null && str_Period==null && str_Status==null)
		{
		return getSessionFactory().getCurrentSession().createCriteria(DueTransaction.class).list();
		}
		else
		{
			String str="From DueTransaction where str_DueTemplate=? AND str_Period=? AND str_Block=? AND str_ApartmentNo=? AND str_Status=?";
			return getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_DueTemplate).setParameter(1, str_Period).setParameter(2, str_Block).setParameter(3, str_ApartmentNo).setParameter(4, str_Status).list();
		}
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
	public List<DueTransaction> listUserDueTransaction(String str_ApartmentNo)
	{   
		String hql="from DueTransaction where str_ApartmentNo=?";
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
		System.out.println(str1);
		String hql="select sqft from User where str_Flat=?";
		double str2=(double)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_Block).uniqueResult();
		System.out.println(str2);
		System.out.println(str1*str2);
		return (str1*str2);
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
}
