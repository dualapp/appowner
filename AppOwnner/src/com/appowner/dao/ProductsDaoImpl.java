package com.appowner.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.Cls_DocumentCategory;
import com.appowner.model.Cls_ProductDetails;
import com.appowner.model.Cls_categoryDetail;
import com.appowner.model.Cls_subcategoryDetail;
import com.appowner.model.DueTemplate;
import com.appowner.model.Notification;
import com.appowner.model.UserExtraInfo;
import com.appowner.model.cls_Ads;
import com.appowner.model.cls_Contact;
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
	public void AddProduct1(Cls_ProductDetails pro) 
	{
		
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
	public List<Cls_ProductDetails> getSearchByProducttype(String ch_Product_Type, String ch_Ad_Type, String status, Integer statusid)
	{
		System.out.println(ch_Product_Type+"ccccccccccccvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
		System.out.println(ch_Ad_Type+"ccccccccccccvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
		System.out.println(statusid+"ccccccccccccvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
		System.out.println(statusid+"jcfjfjhdfgggggggggggggggggggggggggggggggggggggggggg");
	
		if(statusid==0)
		{  
			System.out.println("hgfhf2222222222222222222222222222222222222222222222222222222222222222222222222");
			String  query = "{ CALL detail() }";
			
			List<Cls_ProductDetails> listdetails = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)
			          ).list();
		   
			 return listdetails;	
		}
		else 
		
		   { if(statusid==-1)
			   
		   {  
				System.out.println("hgfhf2222222222222222222222222222222222222222222222222222222222222222222222222");
				String  query = "{ CALL detail() }";
				
				List<Cls_ProductDetails> listdetails = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)
				          ).list();
			   
				 return listdetails;	
			}
		   else
		   {
			System.out.println("hffhrrrrrrrrrrrrrrrrrrrrrrrrr444444444444444444477777777777777777777777777777777777777777");
			String  query = "{ CALL details(?,?,?,?) }";
			
			List<Cls_ProductDetails>  listdetails = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)).setParameter(0,ch_Product_Type).setParameter(1,ch_Ad_Type).setParameter(2,status).setParameter(3, statusid).list();
			System.out.println(listdetails+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");	
			return listdetails;
			 }
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
	
	@Override
	public void update3(Cls_ProductDetails edit1) {
		sessionFactory.getCurrentSession().update(edit1);
		
	}

	@Override
	public void addContact1(Cls_ProductDetails edit1) {
		getSessionFactory().getCurrentSession().save(edit1);
		
	}

	@Override
	public Cls_ProductDetails getEdit1(Integer int_ProductId) {
		return (Cls_ProductDetails) getSessionFactory().getCurrentSession().get(Cls_ProductDetails.class, int_ProductId);
	}


	

	@Override
	public void change(String str, Integer id)
	{
		String hql="update Cls_ProductDetails set Status=? where Int_ProductId=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str).setParameter(1,id).executeUpdate();
	}

	@Override
	public void saveall(Cls_ProductDetails updation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valuechange(String str1, Integer id) {
		String hql="update Cls_ProductDetails set Status=? where Int_ProductId=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str1).setParameter(1,id).executeUpdate();
		
	}

	@Override
	public void valuereject(String str2, Integer id) {
		String hql="update Cls_ProductDetails set Status=? where Int_ProductId=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str2).setParameter(1,id).executeUpdate();
			
		
	}

	@Override
	public void updatedetails(Cls_ProductDetails productDetails) {
		System.out.println(productDetails.getVar_ImageName()+"jkjkdkdffnnnnnnnnnnnnnnnnnnmmmmmmmmmmmmm");
		 sessionFactory.getCurrentSession().update(productDetails);
		
	}

	@Override
	public void save1(Cls_ProductDetails productDetails) {
		sessionFactory.getCurrentSession().update(productDetails);
		
	}

	@Override
	public void deleteInvoice(Cls_ProductDetails detail) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Cls_ProductDetails WHERE Int_ProductId="+detail.getInt_ProductId()).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_ProductDetails> listDetail(String ch_Product_Type,
			String ch_Ad_Type, String status) {
		 
		
		{   if(ch_Product_Type==null&&ch_Ad_Type==null&&status==null)
	     {
		    return (List<Cls_ProductDetails>) getSessionFactory().getCurrentSession().createCriteria(Cls_ProductDetails.class).setCacheable(true).list();
	     }
	 else
	 {
		 String hql="from Cls_ProductDetails  where ch_Product_Type=? and ch_Ad_Type=? and status=?";
		    return (List<Cls_ProductDetails>)getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,ch_Product_Type).setParameter(1,ch_Ad_Type).setParameter(2,status).setCacheable(true).list();
	 }
		 
	 }
	}

	@Override
	public void updated(int int_Ad_categoryId) {
		String hql="update  Cls_categoryDetail set var_Ad_CategoryName=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_Ad_categoryId).executeUpdate();
		
	}

	@Override
	public void Addadss(cls_Ads ads) {
		getSessionFactory().getCurrentSession().save(ads);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getcat() {
		return getSessionFactory().getCurrentSession().createCriteria(cls_Ads.class).setProjection(Projections.property("str_category")).list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> gettitle() {
		return getSessionFactory().getCurrentSession().createCriteria(cls_Ads.class).setProjection(Projections.property("str_title")).list();
	}

	@Override
	public int getid(String select) {
		String hql2="select Adsid from cls_Ads where str_title=?";
		System.out.println("8888888888888888888888888888888888");
		return (int) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, select).uniqueResult();
	}

	@Override
	public String getmsg(int ads_id) {
		String hql2="select message1 from cls_Ads where adsid=?";
		System.out.println("8888888888888888888888888888888888");
		return (String) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, ads_id).uniqueResult();
	
	}

	@Override
	public String getname(String select1) {
		String hql2="select username from Cls_ProductDetails where str_ApartmentName=?";
		System.out.println("8888888888888888888888888888888888");
		return (String) sessionFactory.getCurrentSession().createQuery(hql2).uniqueResult();
	}

	@Override
	public String getname(Integer productid) {
		String hql="update  Cls_ProductDetails set  Status=? where int_ProductId=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, "Open").setParameter(1,productid).executeUpdate();
		return hql;
	}

	@Override
	public String getclose(Integer int_ProductId) {
		String hql="update  Cls_ProductDetails set  Status=? where int_ProductId=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, "Close").setParameter(1,int_ProductId).executeUpdate();
		return hql;
	}

	@Override
	public String getreject(Integer productsid) {
		String hql="update  Cls_ProductDetails set  Status=? where int_ProductId=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, "Ads Rejected").setParameter(1,productsid).executeUpdate();
		return hql;
	}

	@Override
	public int getrejectids(Integer int_ProductId) {
		String hql2="select UserId from Cls_ProductDetails where int_ProductId=?";
		System.out.println("8888888888888888888888888888888888");
		return (int) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, int_ProductId).uniqueResult();
	}

	@Override
	public String getemailids(int msgrejectid) {
		String hql2="select str_Email from User where int_UserId=?";
		System.out.println("8888888888888888888888888888888888");
		return (String) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0,  msgrejectid).uniqueResult();
	}

	@Override
	public void updateProfilePic(Cls_ProductDetails user) {
		 sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	public String statusmesg(Integer int_ProductId) {
		String hql2="select UserId from Cls_ProductDetails where int_ProductId=?";
		System.out.println("8888888888888888888888888888888888");
		return (String) sessionFactory.getCurrentSession().createQuery(hql2).setParameter(0, int_ProductId).uniqueResult();
	}

	@Override
	public void AddCategorys(Cls_subcategoryDetail detail) {
		 sessionFactory.getCurrentSession().save(detail);;
		
	}

	@Override
	public int getcatid(String var_Ad_CategoryName) {
		String hql4="select int_Ad_categoryId from Cls_categoryDetail where var_Ad_CategoryName=?";
		return  (Integer) getSessionFactory().getCurrentSession().createQuery(hql4).setParameter(0, var_Ad_CategoryName).uniqueResult();
	}

	@Override
	public int getids(String catname) {
		System.out.println(catname+"mukesh kumar");
		
		String hql4="select int_Ad_categoryId from Cls_categoryDetail where var_Ad_CategoryName=?";
	   return  (Integer) getSessionFactory().getCurrentSession().createQuery(hql4).setParameter(0,catname).uniqueResult();
		
	}

	@Override
	public List<String> getmessages(int msgid) {
		String hql4="select var_subscategoryname from Cls_subcategoryDetail where int_Ad_categoryId=?";
		return  (List<String>) getSessionFactory().getCurrentSession().createQuery(hql4).setParameter(0,  msgid).list();
	}

	@Override
	public int getdid(String var_Ad_SubCategoryName) {
		String hql1="select int_subcategoryId from Cls_subcategoryDetail  where var_subscategoryname=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, var_Ad_SubCategoryName).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cls_ProductDetails> getSearchBytype(String var_Ad_CategoryName,
			String var_subscategoryname, String ch_Ad_Type, int categorystatus) {
		System.out.println(var_Ad_CategoryName+";;;;;;;;;;;;;;;");
		System.out.println( var_subscategoryname+",........,.,.,,.,.,<><><><><>");
	     System.out.println( ch_Ad_Type);
	
		if(categorystatus==0)
		{  
			System.out.println("hgfhf2222222222222222222222222222222222222222222222222222222222222222222222222");
			String  query = "{ CALL search() }";
			
			List<Cls_ProductDetails> listdetails = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)
			          ).list();
		   
			 return listdetails;	
		}
		else 
		
		   { 
			if(categorystatus==-1)
			   
		        {
			   System.out.println("jggfffffffffffffffff777777777777777777777777777777777777777777777777777777777777777777777777777777777777");
		        }
		   else
		   {
			System.out.println("hffhrrrrrrrrrrrrrrrrrrrrrrrrr444444444444444444477777777777777777777777777777777777777777");
			String  query = "{ CALL searchcategory(?,?,?,?) }";
			
			List<Cls_ProductDetails>  listdetails = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)).setParameter(0,var_Ad_CategoryName).setParameter(1,var_subscategoryname).setParameter(2,ch_Ad_Type).setParameter(3, categorystatus).list();
			System.out.println(listdetails+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");	
			return listdetails;
			 }
		 }
		return null;
		}
		
	
		
	

	@Override
	public int getcatsid(String str_sub_catid) {
		String hql1="select int_subcategoryId from Cls_subcategoryDetail where var_subscategoryname=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 Integer cid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, str_sub_catid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	}

	@Override
	public int getdocid3(String var_Ad_SubCategoryName) {
		String hql1="select int_subcategoryId from Cls_subcategoryDetail where var_subscategoryname=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		 int cid=(Integer) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0, var_Ad_SubCategoryName).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	}

	@Override
	public String usremail(int id) {
		System.out.println(id+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="select str_Email from User where int_UserId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		String cid=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,id).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	}

	@Override
	public Cls_ProductDetails usrpostid(Integer postid) {
		System.out.println(postid+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		Cls_ProductDetails  cid= (Cls_ProductDetails) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,postid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	}

	@Override
	public int addid(Integer postid) {
		//System.out.println(id+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="select int_Ad_categoryId from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		int cid=(int) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,postid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		 return cid;
	}

	@Override
	public void updatePic(Cls_ProductDetails user) {
		// TODO Auto-generated method stub
	 String hql="update  Cls_ProductDetails set  Var_ImageName=? where int_ProductId=?";
			 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, "user").executeUpdate();
			
		}

	@Override
	public void updatePics(Integer int_ProductId,String var_ImageName) {
		String hql="update  Cls_ProductDetails set  Var_ImageName=? where int_ProductId=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, var_ImageName).setParameter(1, int_ProductId).executeUpdate();
		
	}

	@Override
	public int subcategoryid(Integer postid) {
		String hql1="select int_Ad_categoryId from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		int cid=(int) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,postid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		return cid;
		
	}

	@Override
	public String subcatname(int subcatid) {
		String hql1="select var_Ad_CategoryName from Cls_categoryDetail  where int_Ad_categoryId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		String cid=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,subcatid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		return cid;
		
	}

	@Override
	public int subcategoryname(Integer postid) {
		String hql1="select int_subcategoryId from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		int cid=(int) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,postid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		return cid;
	}

	@Override
	public String subscatnames(int subcategoryId) {
		String hql1="select var_subscategoryname from  Cls_subcategoryDetail where int_subcategoryId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		String cid=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,subcategoryId).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(cid);
		return cid;
	}

	@Override
	public int subcategoryids(Integer postid) {
		String hql1="select int_subcategoryId from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		int subcatid=(int) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,postid).uniqueResult();
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println(subcatid);
		return subcatid;
		
	}

	@Override
	public String subcatnames(int subcatids) {
		String hql1="select var_subscategoryname from  Cls_subcategoryDetail where int_subcategoryId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		String subcatname=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,subcatids).uniqueResult();
		 System.out.println("ccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		 System.out.println(subcatname);
		return subcatname;
	}

	@Override
	public List<String> getCatmessage(int int_Ad_categoryId) {
		// TODO Auto-generated method stub
		//String catName=(String) getSessionFactory().getCurrentSession().createQuery("select var_Ad_CategoryName from Cls_categoryDetail where int_Ad_categoryId=?").setParameter(0, int_Ad_categoryId).uniqueResult(); 
		return getSessionFactory().getCurrentSession().createQuery("select var_subscategoryname from Cls_subcategoryDetail where int_Ad_categoryId=?").setParameter(0,int_Ad_categoryId).list();
	}

	@Override
	public String getProductImg(Integer int_ProductId) {
		String hql1="select  Var_ImageName from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		String imagename=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,int_ProductId).uniqueResult();
		 System.out.println("ccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		 System.out.println(imagename);
		return imagename;
	}

	@Override
	public void deleteselected(Integer int_ProductId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Cls_ProductDetails WHERE Int_ProductId="+int_ProductId).executeUpdate();
	}

	@Override
	public String checkStatus(Integer int_ProductId) {
		String hql="select  Status from Cls_ProductDetails  where int_ProductId=?";
		 getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, "Open").setParameter(1,int_ProductId).executeUpdate();
		return hql;
		
	}
	public String checkStatuss(Integer int_ProductId) {
		String hql="select  Status from Cls_ProductDetails  where Int_ProductId=?";
		String status= (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_ProductId).uniqueResult();
		
		System.out.println(status+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		return status;
	}
	public String rejectStatuss(Integer int_ProductId) {
		String hql="select  Status from Cls_ProductDetails  where Int_ProductId=?";
		String status= (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_ProductId).uniqueResult();
		
		System.out.println(status+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		return status;
	}

	@Override
	public String checkclose(Integer int_ProductId) {
		String hql="select  Status from Cls_ProductDetails  where Int_ProductId=?";
		String status= (String) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,int_ProductId).uniqueResult();
		
		System.out.println(status+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		return status;
	}

	@Override
	public void editselected(Integer int_ProductId) {
		getSessionFactory().getCurrentSession().update(int_ProductId);
	}

	@Override
	public Cls_ProductDetails getpostdetail(Integer postId) {
		System.out.println(postId+"klklklklklkhghghghghghghghghghghghghghghghgggh");
		String hql1="from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hql1);
		 
		Cls_ProductDetails postdetail= (Cls_ProductDetails) getSessionFactory().getCurrentSession().get(Cls_ProductDetails.class, postId);
		 System.out.println("cccccccccccccccccccccccccccccccccccccc");
		 System.out.println( postdetail);
		 return  postdetail;
	}

	@Override
	public int getsubcategoryId(Integer postId) {
		String hql1="select  int_subcategoryId from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		int subcategoryId=(int) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,postId).uniqueResult();
		 System.out.println("ccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		 System.out.println( subcategoryId);
		return  subcategoryId;
	}

	@Override
	public List<String> getlistsubcategory(int subcategoryId) {
		return getSessionFactory().getCurrentSession().createQuery("select var_subscategoryname from Cls_subcategoryDetail where int_Ad_categoryId=?").setParameter(0,subcategoryId).list();
	}

	@Override
	public int getcategoryId(Integer postId) {
		String hql1="select  int_subcategoryId from Cls_ProductDetails where Int_ProductId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		int categoryId=(int) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,postId).uniqueResult();
		 System.out.println("ccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		 System.out.println( categoryId);
		return  categoryId;
	}

	@Override
	public String categoryname(int categoryId) {
		String hql1="select var_Ad_CategoryName from Cls_categoryDetail where int_Ad_categoryId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		String categoryName=(String) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,categoryId).uniqueResult();
		 System.out.println("ccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		 System.out.println( categoryId);
		return  categoryName;
	}

	@Override
	public String subcategorynames(int categoryId) {
		String var_subscategoryname = null;
		String hql1="select var_subscategoryname from Cls_subcategoryDetail where int_Ad_categoryId=?";
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		System.out.println("My nameeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(hql1);
		 
		List<String> subcategoryName=(List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,categoryId).list();
		Iterator<String> itr= subcategoryName.iterator();
		while(itr.hasNext())
		{
	     Object sub=itr.next();
	      var_subscategoryname=(String) sub;
		}
		 System.out.println("ccccccccccccccccccccccccccccccccccccccmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		 System.out.println( categoryId);
		return  var_subscategoryname;
	}

	@Override
	public int subcategorynames(String subcatsname) {
System.out.println( subcatsname+"mukesh kumar");
		
		String hql4="select int_Ad_categoryId from Cls_categoryDetail where var_Ad_CategoryName=?";
	   return  (Integer) getSessionFactory().getCurrentSession().createQuery(hql4).setParameter(0, subcatsname).uniqueResult();
		
	}

	@Override
	public List<String> getcatmessages(int subcatId) {
		String hql4="select var_subscategoryname from Cls_subcategoryDetail where int_Ad_categoryId=?";
		return  (List<String>) getSessionFactory().getCurrentSession().createQuery(hql4).setParameter(0, subcatId).list();
	}

	@Override
	public List<String> getcatdetail(int int_Ad_categoryId) {
		return getSessionFactory().getCurrentSession().createQuery("select var_subscategoryname from Cls_subcategoryDetail where int_Ad_categoryId=?").setParameter(0,int_Ad_categoryId).list();
	}

	@Override
	public List<Cls_ProductDetails> getSearchByProducttypes(
			String ch_Product_Type, String ch_Ad_Type, String status) {
		{
			System.out.println(ch_Product_Type+"ccccccccccccvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			System.out.println(ch_Ad_Type+"ccccccccccccvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			System.out.println(status+"ccccccccccccvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			
			if(ch_Product_Type=="Sell" && ch_Ad_Type=="My Community" && status==null )
			{
				String  query = "{ CALL detail() }";
				
				 @SuppressWarnings("unchecked")
				List<Cls_ProductDetails> listdetails = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)
				          ).list();
			   
				 return listdetails;	
			}
			else
			{
				String  query = "{ CALL details(?,?,?)}";
				@SuppressWarnings("unchecked")
				List<Cls_ProductDetails> listdetails=sessionFactory.getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)).setParameter(0, ch_Product_Type).setParameter(1, ch_Ad_Type).setParameter(2, status).list();
				
				return listdetails;
			
			
			
		
			}
	}
	}

	@Override
	public List<Cls_ProductDetails> getSearchByProducttypes1(
			String ch_Product_Type, String ch_Ad_Type, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cls_ProductDetails> getSearchBytype(String var_Ad_CategoryName,
			String var_subscategoryname, String ch_Ad_Type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cls_ProductDetails> getSearchBytypes(
			String var_Ad_CategoryName, String var_subscategoryname,
			String ch_Ad_Type1, String ch_Product_Type1, int categorystatus) {
		System.out.println(var_Ad_CategoryName+";;;;;;;;;;;;;;;");
		System.out.println( ch_Ad_Type1+",........,.,.,,.,.,<><><><><>");
	     System.out.println( categorystatus+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	System.out.println(ch_Product_Type1+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	System.out.println(var_subscategoryname+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	
		if(categorystatus==0)
		{  
			System.out.println("hgfhf2222222222222222222222222222222222222222222222222222222222222222222222222");
			String  query = "{ CALL search() }";
			
			
			List<Cls_ProductDetails> listdetails = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)
			          ).list();
		   
			 return listdetails;	
		}
		
		        
		   else
		   {
			System.out.println("hffhrrrrrrrrrrrrrrrrrrrrrrrrr444444444444444444477777777777777777777777777777777777777777");
			String  query = "{ CALL searchcategory(?,?,?,?,?) }";
			
			List<Cls_ProductDetails>  listdetails = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Cls_ProductDetails.class)).setParameter(0,var_Ad_CategoryName).setParameter(1,var_subscategoryname).setParameter(2,ch_Ad_Type1).setParameter(3,ch_Product_Type1).setParameter(4, categorystatus).list();
			System.out.println(listdetails+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");	
			return listdetails;
			 }
		 }
		
	

	@Override
	public List<String> getCount() {
		return getSessionFactory().getCurrentSession().createCriteria(Cls_categoryDetail.class).setProjection(Projections.property("var_Description")).list();
	}
		
	}

	
	


	

	

	
	


	

	


