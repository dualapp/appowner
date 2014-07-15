package com.appowner.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;

public class ProductAccessDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void AddProducts(Cls_ProductDetails pro) {
		getSessionFactory().getCurrentSession().save(pro);
	}

	@Override
	public void AddCategorys(Cls_categoryDetail cat) {
		getSessionFactory().getCurrentSession().save(cat);	
		
	}

	

}
