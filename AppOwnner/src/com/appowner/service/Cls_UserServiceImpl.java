package com.appowner.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appowner.bean.Cls_UserBean;
import com.appowner.dao.In_UserDao;
import com.appowner.model.BookAFacility;
import com.appowner.model.MemberLog;
import com.appowner.model.ServiceRequest;
import com.appowner.model.User;
//import com.appowner.model.User.*;
import com.appowner.model.UserApartment;
import com.appowner.model.UserBlocks;
import com.appowner.model.UserExtraInfo;
import com.appowner.model.Vendor;

/**
 * @author kalpana jena
 *
 */
@Service("cls_UserService")
@Transactional 
public class Cls_UserServiceImpl implements In_UserService,Serializable {
	private static final long serialVersionUID = 1L;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Autowired
	private In_UserDao in_userdao;
	public In_UserDao getIn_userdao() {
		return in_userdao;
	}

	public void setIn_userdao(In_UserDao in_userdao) {
		this.in_userdao = in_userdao;
	}

	public void addUser(User user) {
		 System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		 
		getIn_userdao().addUser(user);
	}
	
	public List<User> listUsers() {
		return getIn_userdao().listUsers();
	}

	public User getEmployee(int int_UserId) {
		return in_userdao.getUser(int_UserId);
	}
	
	public void deleteUser(User user) {
		getIn_userdao().deleteUser(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> validateEmployee(Cls_UserBean user) {
		// TODO Auto-generated method stub
		return  getIn_userdao().validateUser(user);
	}

	@Override
	public void updateUser(int int_UserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(int int_UserId) {
		// TODO Auto-generated method stub
		return getIn_userdao().getUser(int_UserId);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	//public void update(User usr) {
		//getIn_userdao().updateUser(usr);
		
	//}

	/*@Override
	public void updateEmployee(int userid) {
		 getEmployeeDao().update(userid);
		// TODO Auto-generated method stub
		//return null;
	}*/
	@Override
	public List<String> cityList() {
		return getIn_userdao().cityList();
	}
	@Override
	public List<String> cityList1(String str_UserState) {
		return getIn_userdao().cityList1(str_UserState);
	}
	@Override
	public List<String> countryList() {
		return getIn_userdao().countryList();
	}
	@Override
	public List<String> stateList() {
		return getIn_userdao().stateList();
 	}

	@Override
	public List<String> apatrmentList1(String str_ApartmentCity) {
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		System.out.println(str_ApartmentCity);
		return getIn_userdao().apatrmentList1(str_ApartmentCity);
	}

	@Override
	public int getCityId(String str_ApartmentName) {
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		System.out.println(str_ApartmentName);
		return getIn_userdao().getCityId(str_ApartmentName);
		
 	}

	@Override
	public void addApartment(UserApartment ua) {
		getIn_userdao().addApartment(ua);
		
	}

	@Override
	public int getAppartmenId(String userapartment) {
		System.out.println("1111111111111111111111112222222222222233333333333");
		System.out.println(userapartment);
		return getIn_userdao().getApartmentId(userapartment);
		
	}

	@Override
	public String getRoleNameUser(int i) {
		
		return getIn_userdao().getRoleNameUser(i);
	}

	@Override
	public User getUserList(String formuserloginusername) {
		// TODO Auto-generated method stub
		return getIn_userdao().getUserDetails(formuserloginusername);
	}

	@Override
	public User validate(String str_Username) {
		// TODO Auto-generated method stub
		return getIn_userdao().validateUser(str_Username);
	}

	@Override
	public User validate1(String str_Email) {
		// TODO Auto-generated method stub
		return getIn_userdao().validateUser1(str_Email);
	}

	@Override
	public User getUserList1(Integer int_UserId) {
		// TODO Auto-generated method stub
		return getIn_userdao().getUserDetails(int_UserId);
	}

	@Override
	public void updateUs(User user) {
		getIn_userdao().updateUs(user);
		
	}


	@Override
	public void addMemberLog(MemberLog memberLog) {
		getIn_userdao().addMemberLog(memberLog);
		
	}

	@Override
	public List<MemberLog> getListMemberLog() {
		// TODO Auto-generated method stub
		return getIn_userdao().getListMemberLog();
	}

	@Override
	public void addServiceRequest(ServiceRequest serviceRequest) {
		getIn_userdao().addServiceRequest(serviceRequest);
		
	}

	@Override
	public void addBookAFacility(BookAFacility bookAFacility) {
		// TODO Auto-generated method stub
		getIn_userdao().addBookAFacility(bookAFacility);
		
	}

	@Override
	public List<ServiceRequest> getServiceRequestList() {
		// TODO Auto-generated method stub
		return getIn_userdao().getServiceRequestList();
	}

	@Override
	public List<BookAFacility> getBookAFacilityList() {
		// TODO Auto-generated method stub
		return getIn_userdao().getBookAFacilityList();
	}

	@Override
	public Collection<? extends User> userDetails(Integer int_apartment_id) {
		// TODO Auto-generated method stub
		return getIn_userdao().getuserDetails(int_apartment_id);
	}

	@Override
	public void addBlock(UserBlocks us) {
		// TODO Auto-generated method stub
		getIn_userdao().addBlocks(us);
		
	}

	@Override
	public Integer apartmentidget(String str_userapartment) {
		// TODO Auto-generated method stub
		return getIn_userdao().apartmentidget(str_userapartment);
	}

	@Override
	public Collection<? extends String> blocks(int aparmentid1) {
		// TODO Auto-generated method stub
		return getIn_userdao().blocks(aparmentid1);
	}

	@Override
	public User edit(int userid) {
		// TODO Auto-generated method stub
		return getIn_userdao().edit(userid);
	}

	@Override
	public void updateUser(User editlis) {
		// TODO Auto-generated method stub
		getIn_userdao().updateUser1(editlis);
	}

	@Override
	public void deleteUser(int int_UserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser2(Integer id) {
		getIn_userdao().deleteUser2(id);
		
	}

	@Override
	public int getUserRole(Integer userId) {
		// TODO Auto-generated method stub
		return getIn_userdao().getUserRole(userId);
	}

	@Override
	public UserExtraInfo getUserExtraInfo(Integer int_UserId) {
		// TODO Auto-generated method stub
		return getIn_userdao().getUserExtraInfo(int_UserId);
	}
	public Integer getStatus(String str_ApartmentName)
	{
		return getIn_userdao().getStatus(str_ApartmentName);
	}

	@Override
	public Integer getUserId(String str_Username) {
		// TODO Auto-generated method stub
		System.out.println(str_Username+"kkkppp");
		return getIn_userdao().getUserId(str_Username);
	}

	@Override
	public User getFbUser(Integer id) {
		// TODO Auto-generated method stub
		return getIn_userdao().getFbUser(id);
	}

	@Override
	public void updatePassword(Integer userId,String newPassword) {
		// TODO Auto-generated method stub
		getIn_userdao().updatePassword(userId,newPassword);
	}

	@Override
	public String getPassword(Integer userId) {
		// TODO Auto-generated method stub
		return getIn_userdao().getPassword(userId);
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return getIn_userdao().getUser( userName);
	}

	@Override
	public String getPassword(String str_EmailId) {
		// TODO Auto-generated method stub
		return  getIn_userdao().getPassword(str_EmailId);
	}

	@Override
	public void setPassword(String str_Email, String str_RecoverPassword) {
		// TODO Auto-generated method stub
		getIn_userdao().setPassword(str_Email,str_RecoverPassword);
	}
	public Date getEntryDate(Integer int_ApartmentId)
	{
		return getIn_userdao().getEntryDate(int_ApartmentId);
	}

	public Date getEndDate(Integer int_ApartmentId)
	{
		return getIn_userdao().getEndDate(int_ApartmentId);    
	}
	public String getSetUp()
	{
		return getIn_userdao().getSetUp();  
	}
	public String getId(String setup)
	{
		return getIn_userdao().getId(setup);  
	}
	@Override
	public User isUserStaying(String str_HouseNo,Integer int_UserRole) {
		// TODO Auto-generated method stub
		return getIn_userdao().isUserStaying(str_HouseNo,int_UserRole);
	}
	public List<String> getRoleAssign(Integer int_UserId, Integer int_ApartmentId)
	{
		return getIn_userdao().getRoleAssign(int_UserId,int_ApartmentId);
	}

	@Override
	public Vendor getVendor(String str_VendorName, String str_VendorType) {
		// TODO Auto-generated method stub
		return getIn_userdao().getVendor(str_VendorName,str_VendorType);
	}
	public void deleteRole(Integer id)
	{
		getIn_userdao().deleteRole(id);
	}

	@Override
	public BookAFacility checkAvailability(Date dat_OpenDate,
			Date dat_CloseDate, String str_StartTime, String str_StartTime1,
			String str_EndTime, String str_EndTime1, Integer appartmentId,String str_FacilityType) {
		// TODO Auto-generated method stub
		return getIn_userdao().checkAvailability(dat_OpenDate,dat_CloseDate,str_StartTime,str_StartTime1,str_EndTime,str_EndTime1,appartmentId,str_FacilityType);
	}

	@Override
	public void updateMemberLog(MemberLog memberLog) {
		// TODO Auto-generated method stub
		getIn_userdao().updateMemberLog( memberLog);
	}
	 
}