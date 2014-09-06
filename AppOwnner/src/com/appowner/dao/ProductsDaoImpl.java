package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Notification;
@Repository
public class ProductsDaoImpl implements ProductsDao{
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
		{ 
			System.out.println(ch_Product_Type);
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
	public List<Cls_ProductDetails> getSearchByProducttype(String ch_Product_Type ,String ch_Ad_Type,String status)
	{
		if(ch_Product_Type==null && ch_Ad_Type==null)
		{
			String  query = "{ CALL detail() }";
			
			 List<Cls_ProductDetails> kkk = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)
			          ).list();
		      System.out.println("kkk");   
			 return kkk;	
		}
		else
		{
			String  query = "{ CALL details('Buy','Neighbourhood','Pending Approvl') }";
		
		 List<Cls_ProductDetails> kkk = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)
		          ).list();
	      System.out.println("kkk");   
		 return kkk;
		
	}
	
	}
	/*@SuppressWarnings("unchecked")
	@Override
	public List<String> getAprtmentName() {
		return getSessionFactory().getCurrentSession().createCriteria(UserApartment.class).setProjection(Projections.property("str_ApartmentName")).list();
	}
*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_categoryDetail> listcategory() {
		List<Cls_categoryDetail> List= getSessionFactory().getCurrentSession().createCriteria(Cls_categoryDetail.class).list();
		
		return List;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_ProductDetails> listcategory1() {
		List<Cls_ProductDetails> sss= getSessionFactory().getCurrentSession().createCriteria(Cls_ProductDetails.class).list();
		System.out.println(sss);
		return sss;
	}

	@Override
	public void Deletedoc(Cls_ProductDetails category) {
		 getSessionFactory().getCurrentSession().createQuery("delete from Cls_ProductDetails where  Int_ProductId="+category.getInt_ProductId()).executeUpdate();
	}

	
	@Override
	public Cls_categoryDetail editproduct1(int int_Ad_categoryId) 
	{
		System.out.println(int_Ad_categoryId);
		String hql2="select var_Ad_CategoryName from Cls_categoryDetail where int_Ad_categoryId=?";
		System.out.println("8888888888888888888888888888888888");
		return (Cls_categoryDetail)sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, int_Ad_categoryId).uniqueResult();
				
	}

	@Override
	public void edit(Cls_ProductDetails edit) {
		getSessionFactory().getCurrentSession().update(edit);
		
	}

	@Override
	public int editproductaa(Integer int_ProductId) 
	
	{
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(int_ProductId);
		String hql2="select int_Ad_categoryId from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("8888888888888888888888888888888888");
		return (int) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, int_ProductId).uniqueResult();
				
	}

	@Override
	public Cls_ProductDetails updation(Integer int_ProductId) {
		return(Cls_ProductDetails)getSessionFactory().getCurrentSession().get(Cls_ProductDetails.class,int_ProductId);
	}

	@Override
	public Cls_ProductDetails getEdit(Integer int_ProductId) {
		return (Cls_ProductDetails) getSessionFactory().getCurrentSession().get(Cls_ProductDetails.class, int_ProductId);
	}

	@Override
	public String editproduct2(int prointcatid) {
		System.out.println("mukeshhhhhhhhhhhhhhhhhhhhhhhhhh");
		System.out.println(prointcatid);
		String hql2="select var_Ad_CategoryName from Cls_categoryDetail where int_Ad_categoryId=?";
		System.out.println("8888888888888888888888888888888888");
		return (String) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, prointcatid).uniqueResult();
	}

	@Override
	public void update(Cls_ProductDetails edit) {
		sessionFactory.getCurrentSession().update(edit);
		
	}

	@Override
	public void addContact(Cls_ProductDetails edit) {
		getSessionFactory().getCurrentSession().save(edit);
		
	}
	
}
	
	


	

	


