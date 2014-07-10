package com.appowner.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.CommiteeRole;
import com.appowner.model.Company;
import com.appowner.model.CompanyPerson;
import com.appowner.model.Complain;
import com.appowner.model.Contact;
import com.appowner.model.Notice;
import com.appowner.model.PanelPrice;
import com.appowner.model.Staff;
import com.appowner.model.RoleMaster;
import com.appowner.model.User;
import com.appowner.model.Vendor;

@Repository
public class ComplainDaoImpl implements ComplainDao {
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addComplain(Complain complain)
	{
		getSessionFactory().getCurrentSession().save(complain);
	}
	public void addContact(Contact contact)
	{
		getSessionFactory().getCurrentSession().save(contact);
	}
	public void addCompany(Company company)
	{
		getSessionFactory().getCurrentSession().save(company);
	}
	public void addCompanyPerson(CompanyPerson person)
	{
		getSessionFactory().getCurrentSession().save(person);	
	}
	public void addStaff(Staff staff)
	{
		getSessionFactory().getCurrentSession().save(staff);	
	}
	public void addRole(CommiteeRole role)
	{
		getSessionFactory().getCurrentSession().save(role);	
	}
	public void addMaster(RoleMaster master)
	{
		getSessionFactory().getCurrentSession().save(master);	
	}
	public void addNotice(Notice notice)
	{
		getSessionFactory().getCurrentSession().save(notice);	
	}
	 @SuppressWarnings("unchecked")
	public List<Staff> listStaffRoles()
	  {
		 return (List<Staff>) getSessionFactory().getCurrentSession().createCriteria(Staff.class).list(); 
	  }
	  @SuppressWarnings("unchecked")
	public List<CommiteeRole> listCommiteeRoles()
	  {
		  return (List<CommiteeRole>) getSessionFactory().getCurrentSession().createCriteria(CommiteeRole.class).list(); 
	  }
	  @SuppressWarnings("unchecked")
	public List<RoleMaster> listRoleMaster()
	  {
		  return (List<RoleMaster>) getSessionFactory().getCurrentSession().createCriteria(RoleMaster.class).list();  
	  }
	  @SuppressWarnings("unchecked")
	public List<Notice> listNotices()
	  {   String  query = "{ CALL expireCalculation() }";
				
	  List<Notice> notice = getSessionFactory().getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(Notice.class)
	          ).list();
           
	 return notice;
		// return (List<Notice>) getSessionFactory().getCurrentSession().createCriteria(Notice.class).list();   
	  }
	public void addPanel(PanelPrice panel)
	{
		getSessionFactory().getCurrentSession().save(panel);	
	}
	 @SuppressWarnings("unchecked")
	public List<Complain> listComplain()
	 {
		 return (List<Complain>) getSessionFactory().getCurrentSession().createCriteria(Complain.class).list();
	 }
	 @SuppressWarnings("unchecked")
	public List<Contact> listContact()
	 {
		 return (List<Contact>) getSessionFactory().getCurrentSession().createCriteria(Contact.class).list();
	 }
	 @SuppressWarnings("unchecked")
	public List<PanelPrice> listPanelPrice()
	 {
		 return (List<PanelPrice>) getSessionFactory().getCurrentSession().createCriteria(PanelPrice.class).list();
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<Company> listCompany()
	 {
		 return (List<Company>) getSessionFactory().getCurrentSession().createCriteria(Company.class).list(); 
	 }
	 @SuppressWarnings("unchecked")
	public List<String> vendorList()
	{
		List<String> vendorList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(Vendor.class).setProjection(Projections.property("str_VendorType")).list();
		  System.out.println( (vendorList).listIterator().hasNext());
		  System.out.println(vendorList);
		  return  vendorList;
	 }
	 public List<String> vendorListName(String str_VendorType)
	 {
		 System.out.println(str_VendorType);
			String hql=" select int_VendorID from Vendor  where str_VendorType=?";
			int VendorID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_VendorType).uniqueResult();
			 
			String hql1="select str_VendorName from Vendor where int_VendorID="+VendorID;
			@SuppressWarnings("unchecked")
			List<String> nameList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).list();
			System.out.println(nameList);
			return nameList; 
	 }
	  @SuppressWarnings("unchecked")
	public List<String> blockList()
	  {
		  List<String> blockList= (List<String>) getSessionFactory().getCurrentSession().createCriteria(User.class).setProjection(Projections.property("Block")).list();
		  System.out.println( (blockList).listIterator().hasNext());
		  System.out.println(blockList);
		  return  blockList;
	  }
	  public List<String> flatListBlock(String Block)
	  {
		  System.out.println(Block);
			String hql=" select FlatID from User  where Block=?";
			int FlatID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Block).uniqueResult();
			 
			String hql1="select Flat from User where FlatID="+FlatID;
			@SuppressWarnings("unchecked")
			List<String> flatList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).list();
			System.out.println(flatList);
			return flatList;  
	  }
	  public List<String> renterListFlat(String Flat) {
		  System.out.println(Flat);
			String hql=" select FlatID from User  where Flat=?";
			int FlatID=(Integer) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,Flat).uniqueResult();
			 
			String hql1="select BeHalfOf from User where FlatID="+FlatID;
			@SuppressWarnings("unchecked")
			List<String> renterList= (List<String>) getSessionFactory().getCurrentSession().createQuery(hql1).list();
			System.out.println(renterList);
			return renterList;    
	  }
	    @SuppressWarnings("unchecked")
		public List<CompanyPerson> listCompanyPerson()
	    {
	    	 return (List<CompanyPerson>) getSessionFactory().getCurrentSession().createCriteria(CompanyPerson.class).list();	
	    }
	    
	 public Complain getComplain(int int_ComplainID)
	 { 
		 return (Complain)getSessionFactory().getCurrentSession().get(Complain.class,int_ComplainID);
	 }
	 
	 
	 public Company getCompany(int int_CompanyID)
	 {
		 return (Company)getSessionFactory().getCurrentSession().get(Company.class,int_CompanyID); 
	 }
	 @SuppressWarnings("unchecked")
	public List<CompanyPerson> getCompanyPerson(int int_CompanyID)
	 {String hql1="from CompanyPerson where int_CompanyID=?";
		List<CompanyPerson> person= (List<CompanyPerson>)getSessionFactory().getCurrentSession().createQuery(hql1).setParameter(0,int_CompanyID).list();
		return person;
		  
		 
	 }
	 
	 public void update(Complain cmp)
	 {
			sessionFactory.getCurrentSession().update(cmp);
	 }
	 public void update(Company cmp1)
	 {
		 sessionFactory.getCurrentSession().update(cmp1); 
	 }
	 public void update(CompanyPerson person)
	 {
		 sessionFactory.getCurrentSession().update(person); 
	 }
	 public void deleteComplain(Complain complain)
	 {//System.out.println("int_ComplainID");
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM Complain WHERE int_ComplainID = "+complain.getInt_ComplainID()).executeUpdate();
	 }
	 public CompanyPerson getCompanyPerson1(int int_CompanyPersonID)
	 {
		 return (CompanyPerson)getSessionFactory().getCurrentSession().get(CompanyPerson.class,int_CompanyPersonID); 
	 }
/*	 public int getNoPerson(String str_CompanyName)
	 {
		String hql="select count(int_CompanyPersonID) from CompanyPerson where str_CompanyName=?" ;
		System.out.println("count");
		 int count=(int) getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0,str_CompanyName).uniqueResult();
		 return count;
	 }
	 */
	 public void updatePanel(PanelPrice panel)
	 {
		 sessionFactory.getCurrentSession().update(panel); 
	 }
	 @SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public User validate(String name,String password) {
			
		 System.out.println(name);
		 System.out.println(password);
			 String hql="from User  where str_Username=? and str_Password=?";
			
			 return (User)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,name).setParameter(1,password).uniqueResult();
			   
	 
	
}
}
