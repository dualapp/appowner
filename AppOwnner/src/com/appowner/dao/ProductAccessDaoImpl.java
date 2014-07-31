package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.bean.Cls_AddDetailsBean;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Notification;
import com.appowner.model.Subcript;
import com.appowner.model.Vendor;
@Repository
public class ProductAccessDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	

	public void add(Cls_categoryDetail cat) {
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(cat);
		getSessionFactory().getCurrentSession().save(cat);
	}

	@Override
	public void AddProduct1(Cls_ProductDetails pro) {
		getSessionFactory().getCurrentSession().save(pro);
		
	}

	@Override
	public void AddProducts(Cls_ProductDetails pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddCategorys(Cls_categoryDetail cat) {
		getSessionFactory().getCurrentSession().save(cat);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCategories() {
		return getSessionFactory().getCurrentSession().createCriteria(Cls_categoryDetail.class).setProjection(Projections.property("var_Ad_CategoryName")).list();
	}

	@Override
	public int getdocid2(String intdocid1) {
		String hql1="select int_Ad_categoryId from Cls_categoryDetail where var_Ad_CategoryName=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, intdocid1).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	
	
		
	}

	@Override
	public Cls_ProductDetails editproduct(Integer int_ProductId) {
		return(Cls_ProductDetails)getSessionFactory().getCurrentSession().get(Cls_ProductDetails.class,int_ProductId);
	}

	@Override
	public void update1(Cls_ProductDetails pro) {
		 getSessionFactory().getCurrentSession().update(pro);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_ProductDetails> listPersons() {
		 String  query = "{ CALL detail() }";
			
		 List<Cls_ProductDetails> kkk = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)
		          ).list();
	      System.out.println("kkk");   
		 return kkk;
	}
	
	
	
	

	@Override
	public Cls_ProductDetails searchByName1() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_ProductDetails> getDetails(char ch_Product_Type) {
		{ System.out.println(ch_Product_Type);
		String hql7="from  Cls_ProductDetails where Ch_Product_Type=?";
	 return sessionFactory.getCurrentSession().createQuery(hql7).setParameter(0, ch_Product_Type).list();
	}
	}

	@Override
	public void AddNotice(Notification p) {
		getSessionFactory().getCurrentSession().save(p);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getIntentes() {
		return getSessionFactory().getCurrentSession().createCriteria(Notification.class).setProjection(Projections.property("str_Intent")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStatuses() {
		return getSessionFactory().getCurrentSession().createCriteria(Notification.class).setProjection(Projections.property("str_Status")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getPosteds() {
		return getSessionFactory().getCurrentSession().createCriteria(Notification.class).setProjection(Projections.property("str_Posted")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTypes() {
		return getSessionFactory().getCurrentSession().createCriteria(Notification.class).setProjection(Projections.property("str_Type")).list();

	
	}

}
	
	


	

	


