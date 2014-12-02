package com.appowner.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.AssetCategory;
import com.appowner.model.CommunitySetup;
import com.appowner.model.Employee;
import com.appowner.model.HouseDetails;
import com.appowner.model.User;
import com.appowner.model.UserBlocks;

@Repository
public class ApartmentDetailsDaoImpl implements ApartmentDetailsDao {
	
	@Autowired SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveCommunitySetup(CommunitySetup cs) {
		
		sessionFactory.getCurrentSession().save(cs);
		
	}

	@Override
	public void saveBlockDetails(UserBlocks ub) {
		sessionFactory.getCurrentSession().save(ub);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBlocks> getListBlockDetails() {
		 
		return sessionFactory.getCurrentSession().createCriteria(UserBlocks.class).setCacheable(true).list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HouseDetails> getListHouseDetails(String str_BlockName)
	{ 
		if(str_BlockName.equals("ALL"))
		{
			return sessionFactory.getCurrentSession().createCriteria(HouseDetails.class).setCacheable(true).list();	 
		}
		else
		{
			 System.out.println(str_BlockName+"blockname");
			 Integer id=(Integer) sessionFactory.getCurrentSession().createQuery("select int_BlockId from UserBlocks where  str_BlockName=?").setParameter(0, str_BlockName).uniqueResult();
		     return sessionFactory.getCurrentSession().createQuery("from HouseDetails where int_BlockId=?").setCacheable(true).setParameter(0, id).list();
		}
	}
 
	@Override
	public void saveHouseDetails(HouseDetails housedetails) {
		
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(housedetails);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getBlockNameList() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(UserBlocks.class).setCacheable(true).setProjection(Projections.property("str_BlockName")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getHouseNoList(String str_BlockName) {
		// TODO Auto-generated method stub
		Integer blockId=(Integer) sessionFactory.getCurrentSession().createQuery("select int_BlockId  from UserBlocks where str_BlockName=?").setParameter(0, str_BlockName).uniqueResult();
		return sessionFactory.getCurrentSession().createQuery("select str_HouseNo from HouseDetails where int_BlockId=?").setParameter(0, blockId).list();
	}

	@Override
	public HouseDetails getHouseDetailByHouseNo(String str_HouseNo) {
		// TODO Auto-generated method stub
		return (HouseDetails) sessionFactory.getCurrentSession().createQuery("from HouseDetails where str_HouseNo=?").setParameter(0, str_HouseNo).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HouseDetails> getListHouseDetails() {
		// TODO Auto-generated method stub
		  	return sessionFactory.getCurrentSession().createCriteria(HouseDetails.class).setCacheable(true).list();
	}

	@Override
	public Integer getBlockId(String str_BlockName) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().createQuery("select int_BlockId from UserBlocks where str_BlockName=?").setParameter(0, str_BlockName).uniqueResult();
	}

	@Override
	public User primaryOwnerDetailsByHouseNo(String str_HouseNo,int role) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().createQuery("from User where str_Flat=? and int_UserRole=?").setParameter(0, str_HouseNo ).setParameter(1,role).uniqueResult();
	}

	 
	@Override
	public void saveHouseDetails1(List<HouseDetails> hDetailsList) {
		// TODO Auto-generated method stub
		ListIterator itr=hDetailsList.listIterator();
		while(itr.hasNext())
		{
			HouseDetails hdetails=(HouseDetails) itr.next();
		           sessionFactory.getCurrentSession().save(hdetails);
		       }
		       
	}

	@Override
	public void updateProfilePic(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
	}

}
