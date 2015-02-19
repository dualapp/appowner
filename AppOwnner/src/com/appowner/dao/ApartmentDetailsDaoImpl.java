package com.appowner.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appowner.model.AssetCategory;
import com.appowner.model.CommunitySetup;
import com.appowner.model.CommunityType;
import com.appowner.model.CommunityTypeMaster;
import com.appowner.model.Employee;
import com.appowner.model.HouseDetails;
import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserBlocks;
import com.appowner.model.WorkOrderCategory;
import com.appowner.util.Util;

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
	public List<UserBlocks> getListBlockDetails(Integer apartmentid) {
		 
		return sessionFactory.getCurrentSession().createQuery("from UserBlocks where int_ApartmentId=?").setParameter(0,apartmentid).list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HouseDetails> getListHouseDetails(String str_BlockName, Integer ApartmentId)
	{ 
		 if(str_BlockName==null)
		 {
			List<Integer> id= sessionFactory.getCurrentSession().createQuery("select int_BlockId from UserBlocks where int_ApartmentId=?").setParameter(0, ApartmentId).list();
			Integer blockId=id.get(0);
			System.out.println(blockId+"mahesh");
			return sessionFactory.getCurrentSession().createQuery("from HouseDetails where int_BlockId=? and int_ApartmentId=?").setCacheable(true).setParameter(0, blockId).setParameter(1, ApartmentId).list();
		 }
		 else
		 {
			 System.out.println(str_BlockName+"blockname");
			 Integer id=(Integer) sessionFactory.getCurrentSession().createQuery("select int_BlockId from UserBlocks where  str_BlockName=? and int_ApartmentId=?").setParameter(0, str_BlockName).setParameter(1, ApartmentId).uniqueResult();
		     return sessionFactory.getCurrentSession().createQuery("from HouseDetails where int_BlockId=? and int_ApartmentId=?").setCacheable(true).setParameter(0, id).setParameter(1, ApartmentId).list();
		 }
	}
 
	@Override
	public void saveHouseDetails(HouseDetails housedetails) {
		
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(housedetails);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getBlockNameList(Integer ApartmentId) {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("select str_BlockName from UserBlocks where int_ApartmentId=?").setParameter(0, ApartmentId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getHouseNoList(String str_BlockName) {
		// TODO Auto-generated method stub
		Integer blockId=(Integer) sessionFactory.getCurrentSession().createQuery("select int_BlockId  from UserBlocks where str_BlockName=? and int_ApartmentId=?").setParameter(0, str_BlockName).setParameter(1, Util.getAppartmentId()).uniqueResult();
		return sessionFactory.getCurrentSession().createQuery("select str_HouseNo from HouseDetails where int_BlockId=? and int_ApartmentId=? ").setParameter(0, blockId).setParameter(1, Util.getAppartmentId()).list();
	}

	@Override
	public HouseDetails getHouseDetailByHouseNo(String str_HouseNo) {
		// TODO Auto-generated method stub
		return (HouseDetails) sessionFactory.getCurrentSession().createQuery("from HouseDetails where str_HouseNo=?").setParameter(0, str_HouseNo).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HouseDetails> getListHouseDetails(String str_BlockName) {
		// TODO Auto-generated method stub
		  	return sessionFactory.getCurrentSession().createCriteria(HouseDetails.class).setCacheable(true).list();
	}

	@Override
	public Integer getBlockId(String str_BlockName) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().createQuery("select int_BlockId from UserBlocks where str_BlockName=? and int_ApartmentId=?").setParameter(0, str_BlockName).setParameter(1, Util.getAppartmentId()).uniqueResult();
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

	@Override
	public Long getNoOfUsers(String str_HouseNo) {
		// TODO Auto-generated method stub
		return  (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from User  where str_Flat=?").setParameter(0, str_HouseNo).uniqueResult();
	}

	@Override
	public HouseDetails getHouseDetails(Integer houseId) {
		// TODO Auto-generated method stub
		return (HouseDetails) sessionFactory.getCurrentSession().get(HouseDetails.class, houseId);
	}

	@Override
	public void deleteHouseDetails(HouseDetails hd) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(hd);
	}

	@Override
	public void deleteSelectedHouse(List<HouseDetails> entitiesToDelete) {
		ListIterator itr=entitiesToDelete.listIterator();
		while(itr.hasNext())
		{
			HouseDetails Hd=(HouseDetails) itr.next();
		sessionFactory.getCurrentSession().delete(Hd);
	}


	}

	@Override
	public void updateHouseDetails(HouseDetails housedetails) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(housedetails);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommunitySetup> getCommunityType(Integer userId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("select str_CommunitySetupType from CommunitySetup where int_UserId=?").setParameter(0, userId).list();
	}

	@Override
	public CommunitySetup getCommunitySetup(Integer userId) {
		// TODO Auto-generated method stub
		return (CommunitySetup) sessionFactory.getCurrentSession().createQuery("from CommunitySetup where int_UserId=?").setParameter(0, userId).uniqueResult();
	}

	@Override
	public void updateCommunitySetup(CommunitySetup cs) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(cs);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getBlockNameByApartmentName(String str_UserApartment) {
		// TODO Auto-generated method stub
		System.out.println(str_UserApartment+"appname");
		Integer apartmentId=(Integer) sessionFactory.getCurrentSession().createQuery("select int_ApartmentId from UserApartment where str_ApartmentName=? ").setParameter(0, str_UserApartment).uniqueResult();
		System.out.println(apartmentId+"ApartmentId");
		
		return sessionFactory.getCurrentSession().createQuery("select str_BlockName from UserBlocks where int_ApartmentId=?").setParameter(0, apartmentId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCommunityTypelist() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createCriteria(CommunityTypeMaster.class).setCacheable(true).setProjection(Projections.property("str_CommunityType")).list();
	}

	@Override
	public void saveCommunitySetup(CommunityType communityType) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(communityType);
	}

	@Override
	public Integer getCommunityType(String str_CommunityType) {
		// TODO Auto-generated method stub
		return (Integer) getSessionFactory().getCurrentSession().createQuery("select int_MasterCommunityTypeId from CommunityTypeMaster where str_CommunityType=?").setParameter(0, str_CommunityType).uniqueResult();
	}

	@Override
	public Integer getCommunitySetupId(Integer userId) {
		// TODO Auto-generated method stub
		return (Integer) getSessionFactory().getCurrentSession().createQuery("select int_CommunitySetupId from CommunitySetup where int_UserId=?").setParameter(0, userId).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCommunityTypeIdLists(Integer int_CommunitySetupId) {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("select int_MasterCommunityTypeId from CommunityType where  int_CommunitySetupId=?").setParameter(0, int_CommunitySetupId).list();
	}

	@Override
	public String getCommunityMasterType(Integer cid) {
		// TODO Auto-generated method stub
		return (String) getSessionFactory().getCurrentSession().createQuery("select str_CommunityType from CommunityTypeMaster where int_MasterCommunityTypeId=?").setParameter(0, cid).uniqueResult();
	}

	@Override
	public void deleteCommunityType(String str_CommunityType) {
		Integer cmid=(Integer) getSessionFactory().getCurrentSession().createQuery("int_MasterCommunityTypeId from CommunityTypeMaster where str_CommunityType=?").setParameter(0, str_CommunityType).uniqueResult();
		getSessionFactory().getCurrentSession().createQuery("delete from CommunityType where int_MasterCommunityTypeId=?").setParameter(0, cmid);
	}

	@Override
	public void updateBlockDetails(UserBlocks ub,String oldBlockName) {
		// TODO Auto-generated method stub
		String newBlockName=ub.getStr_BlockName();
		Integer noOfHouses=ub.getInt_NoOfHouses();
		Integer organizationId=ub.getInt_ApartmentId();
		System.out.println(newBlockName+"kplakam");
		
		System.out.println(oldBlockName+"oldkalpam");
		Integer blockId=(Integer) getSessionFactory().getCurrentSession().createQuery("select int_BlockId from  UserBlocks where str_BlockName=? and int_ApartmentId=?").setParameter(0, oldBlockName).setParameter(1, organizationId).uniqueResult();
				
		if(newBlockName!=null)
		{
			getSessionFactory().getCurrentSession().createQuery("UPDATE UserBlocks SET str_BlockName =?  WHERE int_BlockId = ? and int_ApartmentId=?").setParameter(0, newBlockName).setParameter(1,blockId).setParameter(2, organizationId).executeUpdate();
		}
		if(noOfHouses!=null)
		getSessionFactory().getCurrentSession().createQuery("UPDATE UserBlocks SET int_NoOfHouses =?  WHERE int_BlockId = ? and int_ApartmentId=?").setParameter(0, noOfHouses).setParameter(1,blockId).setParameter(2, organizationId).executeUpdate();
	}

	@Override
	public void updateOneBlock(UserBlocks selectedBlock) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(selectedBlock);
	}
	
}