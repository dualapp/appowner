package com.appowner.dao;

import java.util.Collection;
import java.util.List;

import com.appowner.model.BookAFacility;
import com.appowner.model.MemberLog;
import com.appowner.model.ServiceRequest;
import com.appowner.model.User;

//import org.apache.catalina.realm.JNDIRealm.User;


//import org.apache.catalina.User;

import com.appowner.model.UserApartment;
import com.appowner.model.UserBlocks;
//import org.apache.catalina.realm.JNDIRealm.User;
import com.appowner.bean.Cls_UserBean;
import com.appowner.model.*;
/**
 * @author pankaj
 *
 */
public interface In_UserDao {
	
	//public void addUser(org.apache.catalina.User user);

		public List<User> listUsers();
		
		public User getUser(int int_UserId);
		
		public void deleteUser(User user);
		//public void editEmployee(Employee employee);

		@SuppressWarnings("unchecked")
		public List validateUser(Cls_UserBean user);

		public void update(int int_UserId);

		public void updateUser(User usr);

		//public void addUser(User user);

		public void addUser(User user);
		public List<String> cityList();

		public List<String> cityList1(String str_UserState);
		public List<String> countryList();

		//public List<String> stateList();

		public List<String> stateList();

		public List<String> apatrmentList1(String str_ApartmentCity);

		public int getCityId(String str_ApartmentName);

		public void addApartment(UserApartment ua);

		public int getApartmentId(String userapartment);

		public String getRoleNameUser(int i);

		//public User getUserDetails(String formuserloginusername);

		public User getUserDetails(String formuserloginusername);

		public User validateUser(String str_Username);

		public User validateUser1(String str_Email);

		public User getUserDetails(Integer int_UserId);

		public void updateUs(User user);
	 
	public void addMemberLog(MemberLog memberLog);

	public List<MemberLog> getListMemberLog();

	public void addServiceRequest(ServiceRequest serviceRequest);

	public void addBookAFacility(BookAFacility bookAFacility);

	public List<ServiceRequest> getServiceRequestList();

	public List<BookAFacility> getBookAFacilityList();

	public Collection<? extends User> getuserDetails(Integer int_apartment_id);

	public void addBlocks(UserBlocks us);
}
