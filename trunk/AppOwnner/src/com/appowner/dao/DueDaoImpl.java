package com.appowner.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.DueTemplate;
import com.appowner.model.DueTransaction;
import com.appowner.model.InvoiceTemplate;
import com.appowner.model.Vendor;
import com.appowner.util.Util;

@Repository
public class DueDaoImpl implements DueDao{
	@Autowired
	private SessionFactory sessionFactory;
	private Integer apartmentID;
	public Integer getApartmentID() {
		apartmentID=Util.getAppartmentId();
		return apartmentID;
	}
	public void setApartmentID(Integer apartmentID) {
		this.apartmentID = apartmentID;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<String> getAccountsList()
	{   getApartmentID();
		List<String> accountList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setCacheable(true).setProjection(Projections.property("str_Accounts")).add(Restrictions.eq("int_Organisation", apartmentID)).list();
		return accountList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getDueTemplate()
	{    getApartmentID();
		List<String> dueTemplateList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(DueTemplate.class).setCacheable(true).setProjection(Projections.property("str_DueTemplate")).add(Restrictions.eq("int_Organisation", apartmentID)).list();
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
	    getApartmentID();
		if(str_DueTemplate==null && str_Block==null && str_ApartmentNo==null && str_Period==null && str_Status==null)
		{  System.out.println("ghhhhjhhh");
		return getSessionFactory().getCurrentSession().createCriteria(DueTransaction.class).setCacheable(true).add(Restrictions.eq("str_Organisation", apartmentID)).list();
		}
		else if(str_DueTemplate==null && str_Status==null)
		{   System.out.println("hbhjcjvf");
			return getSessionFactory().getCurrentSession().createCriteria(DueTransaction.class).setCacheable(true).add(Restrictions.eq("str_Organisation", apartmentID)).list();
		}
	/*	else if(str_DueTemplate.equals(str_DueTemplate))
		{
			
			System.out.println("ghhhhjhhh1111");
			return getSessionFactory().getCurrentSession().createCriteria(DueTransaction.class).setCacheable(true).add(Restrictions.eq("str_Organisation", apartmentID)).list();
		}  */
		else if(str_Status==null)
		{
			
			System.out.println(str_Status+"jkjkkkjkkk");
			System.out.println(str_DueTemplate+"jkjkkkjkkk123");
			System.out.println(str_Period+"jkjkkkjkkk456");
			System.out.println(str_Block+"jkjkkkjkkk789");
			System.out.println(str_ApartmentNo+"jkjkkkjkkk1265");
				String str="From DueTransaction where str_DueTemplate=? AND str_Period=? AND str_Block=? AND str_ApartmentNo=? and str_Organisation=?"; 
				return getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_DueTemplate).setParameter(1, str_Period).setParameter(2, str_Block).setParameter(3, str_ApartmentNo).setParameter(4, apartmentID).list();
			}
			else
			{
			String str="From DueTransaction where str_DueTemplate=? AND str_Period=? AND str_Block=? AND str_ApartmentNo=? AND str_Status=? and str_Organisation=?";
			return getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_DueTemplate).setParameter(1, str_Period).setParameter(2, str_Block).setParameter(3, str_ApartmentNo).setParameter(4, str_Status).setParameter(5, apartmentID).list();
		    }
		}
	@SuppressWarnings("unchecked")
	public List<DueTransaction> listDueTransaction1(String str_DueTemplate,String str_Block, String str_ApartmentNo, String str_BillPeriod,Integer int_Year)
	{   System.out.println(str_DueTemplate+"kklk13");
     System.out.println(str_Block+"jkjj34");
     System.out.println(str_ApartmentNo+"jkkjkj45");
     System.out.println(str_BillPeriod+"jjjjj34");
     System.out.println(int_Year+"jkjkjkjk76");
     getApartmentID();
		String str="From DueTransaction where str_DueTemplate=? AND str_Period=? AND str_Block=? AND str_ApartmentNo=? AND  int_Year=? and str_Organisation=?";
		return getSessionFactory().getCurrentSession().createQuery(str).setParameter(0, str_DueTemplate).setParameter(1, str_BillPeriod).setParameter(2, str_Block).setParameter(3, str_ApartmentNo).setParameter(4, int_Year).setParameter(5, apartmentID).list(); 
	}
	@SuppressWarnings("unchecked")
	public List<String> getBlockList(String str_Organisation)
	{
		String hql="select str_BlockName from UserBlocks where int_ApartmentId=?";
		return (List<String>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Util.getAppartmentId()).list();
	}
	@SuppressWarnings("unchecked")
	public List<String> getApartmentlist(String str_Block)
	{
		String hql="select int_BlockId from UserBlocks where str_BlockName=? and int_ApartmentId=?";
		List<Integer> list=(List<Integer>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Block).setParameter(1,Util.getAppartmentId()).list();
		ListIterator itr=list.listIterator();
		List<String> str2=new ArrayList<String>();
		while(itr.hasNext())
		{
			Integer id=(Integer) itr.next();
			System.out.println(id+"gfgfkgfkj");
			str2=(List<String>) getSessionFactory().getCurrentSession().createQuery("select str_HouseNo from HouseDetails where int_ApartmentId=? and int_BlockId=?").setParameter(0,Util.getAppartmentId()).setParameter(1,id).list();
			
		}
	System.out.println(str2+"fdjdff");
		return str2;
	}
	@SuppressWarnings("unchecked")
	public List<DueTransaction> listUserDueTransaction(String str_ApartmentNo, String str_ApartmentNo1, String str_Status, String str_Period, String str_DueTemplate)
	{   System.out.println(str_ApartmentNo+"kil");
	 getApartmentID();
		String hql="from DueTransaction where str_Block=? and str_ApartmentNo=? and str_Organisation=?";
		List<DueTransaction>   sss=(List<DueTransaction>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_ApartmentNo).setParameter(1, str_ApartmentNo1).setParameter(2, apartmentID).list();
		System.out.println(sss);
		return sss;
	}
	public DueTransaction getUserDueTransaction(Integer int_DueTransactionID)
	{
		 return (DueTransaction)getSessionFactory().getCurrentSession().get(DueTransaction.class,int_DueTransactionID); 
	}
	public double getDueAmount(String str_Block, String str_DueTemplate)
	{     getApartmentID();
		String str="select str_Rate from DueTemplate where str_DueTemplate=? and int_Organisation=?";
		double str1=(double)getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,str_DueTemplate).setParameter(1, apartmentID).uniqueResult();
		String hql1="select str_Calculation from DueTemplate where str_DueTemplate=? and int_Organisation=?";
		String str4=(String)getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,str_DueTemplate).setParameter(1, apartmentID).uniqueResult();
		System.out.println(str4+"hhjjhj");
		if(str4.equalsIgnoreCase("Sqft"))
		{
			
				String hql="select dbl_HouseSize from HouseDetails where str_HouseNo=? and int_ApartmentId=?";
				double  ddd=(double)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, str_Block).setParameter(1,Util.getAppartmentId()).uniqueResult();
			    
			    
				
		    
			
		System.out.println(str1*ddd);
		return (str1*ddd);
		}
		return str1;
	}
	@SuppressWarnings("unchecked")
	public List<String> listRavenues()
	{    getApartmentID();
		String hql=" select str_AccountName from ChartOfAccount  where ch_Group='R'AND int_ApartmentId=0 or int_ApartmentId=?";
		 
		List<String> ravenueList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, apartmentID).list();
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
	public void updateDueTransaction(String str_Status, Integer str1, double dueAmount, double paidAmount1)
	{  System.out.println();
		String hql="update DueTransaction set str_Status=?,int_paidAmount=?,dbl_DueAmount=? where int_DueTransactionID=?";
		sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,str_Status).setParameter(1,paidAmount1).setParameter(2,dueAmount).setParameter(3, str1).executeUpdate();
	}
	public void deleteDues(Integer id)
	{
		getSessionFactory().getCurrentSession().createQuery("DELETE FROM DueTransaction WHERE int_DueTransactionID = "+id).executeUpdate();
	}
	public String getFrequency(String ddd)
	{   getApartmentID();
		String str="select str_Frequency from DueTemplate where str_DueTemplate=? and int_Organisation=?" ;
		return (String) getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,ddd).setCacheable(true).setParameter(1, apartmentID).uniqueResult();
		
	}
	public void updateDue(Integer id, String int_InvoiceNo)
	{String str="update DueTransaction set int_InvoiceNo=? where int_DueTransactionID=?";
		getSessionFactory().getCurrentSession().createQuery(str).setParameter(0,int_InvoiceNo).setParameter(1,id).executeUpdate();
	}
	public boolean getInvoiceNo(Integer id)
	{
		String hql="select int_InvoiceNo from DueTransaction where int_DueTransactionID=?";
		String str=(String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,id).setCacheable(true).uniqueResult();
		System.out.println(str+"fjkfdjk");
		if(str==null)
			return false;
		else
			return true;
	}
	public DueTransaction getDueTransaction(Integer int_DueTransactionID)
	{
		String hql="from DueTransaction where int_DueTransactionID=?";
		return (DueTransaction) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_DueTransactionID).setCacheable(true).uniqueResult();
	}
}
