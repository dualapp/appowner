package com.appowner.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.appowner.bean.Cls_UserBean;
import com.appowner.model.BookAFacility;
import com.appowner.model.MemberLog;
import com.appowner.model.ServiceRequest;
import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserBlocks;
import com.appowner.model.UserExtraInfo;

/**
 * @author pankaj
 *
 */
public interface In_UserService {
	
	public void addUser(User user);

	public List<User> listUsers();
	
	public User getUser(int int_UserId);
	
	public void deleteUser(int int_UserId);
	//public void editEmployee(Employee employee);

	public List<User> validateEmployee(Cls_UserBean user);

	public void updateUser(int int_UserId);

	public void update(User user);
	public List<String> cityList();
	public List<String> cityList1(String str_UserState);

	public List<String> countryList();
	public List<String> stateList();

	public List<String> apatrmentList1(String str_ApartmentName);

	public int getCityId(String str_ApartmentName);

	public void addApartment(UserApartment ua);	
	//public void update(Employee emp);

	public int getAppartmenId(String userapartment);

	public String getRoleNameUser(int i);

	public User getUserList(String formuserloginusername);

	public User validate(String str_Username);

	public User validate1(String str_Email);

	public User getUserList1(Integer int_UserId);

	public void updateUs(User user);

	//public void updateU(User user);


	public void addMemberLog(MemberLog memberLog);

	public List<MemberLog> getListMemberLog();

	public void addServiceRequest(ServiceRequest serviceRequest);

	public void addBookAFacility(BookAFacility bookAFacility);

	public List<ServiceRequest> getServiceRequestList();

	public List<BookAFacility> getBookAFacilityList();

	public Collection<? extends User> userDetails(Integer int_apartment_id);

	//public void addBlock(UserBlocks us);

	public void addBlock(UserBlocks us);

	public Integer apartmentidget(String str_userapartment);

	public Collection<? extends String> blocks(int aparmentid1);

	public User edit(int userid);

	public void updateUser(User editlis);

	public void deleteUser2(Integer id);

	public int getUserRole(Integer userId);

	public UserExtraInfo getUserExtraInfo(Integer int_UserId);

	public Integer getStatus(String str_ApartmentName);

	public Integer getUserId(String str_Username);

	public User getFbUser(Integer id);

	public void updatePassword(Integer userId, String newPassword);

	public String getPassword(Integer userId);

	public User getUser(String userName);

	public String getPassword(String str_EmailId);

	public void setPassword(String str_Email, String str_RecoverPassword);

	public Date getEntryDate(Integer int_ApartmentId);

	public Date getEndDate(Integer int_ApartmentId);

	public String getSetUp();

	public String getId(String setup);
	 

	public User isUserStaying(String str_HouseNo, Integer int_UserRole);

	public List<String> getRoleAssign(Integer int_UserId, Integer int_ApartmentId);
}

