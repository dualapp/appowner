package com.appowner.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.model.UserExtraInfo;
import com.appowner.service.AdminService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped
public class UserInformationBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{AdminService}")
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String validate (String name1,String Password)  
	{	user=getAdminService().validate(name1,Password);
	          if(user==null)
	        	{  
	        		FacesContext facesContext = FacesContext.getCurrentInstance();
	        		Flash flash = facesContext.getExternalContext().getFlash();
					flash.setKeepMessages(true);
					flash.setRedirect(true);
	        		facesContext.addMessage(null, new FacesMessage("invalid user name or password!!!!!"));
		    	  
		    	       return "SuperAdmin.xhtml";  
		       
	        	}
	   else    
	   { 
		   FacesContext facesContext = FacesContext.getCurrentInstance();
		   Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
		   facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Message", "Login Successful!!!!!!!!!!!"));
           return "/SuperAdmin/ApartmentView.xhtml";
	   }
	      
}
	 private List<UserApartment> listApartment;
	   	public List<UserApartment> getListApartment() {
	   		listApartment=new ArrayList<UserApartment>();
	   		listApartment.addAll(getAdminService().listApartment());
	   		ListIterator list=listApartment.listIterator();
	   		while(list.hasNext())
	   		{   Object o=list.next();
	   			UserApartment name = (UserApartment)o;
	   			String name1=name.getStr_ApartmentName();
	   			
	   			Long count=(Long)getAdminService().count(name1);
	   			
	   			name.setInt_NoOfUser(count);
	   			
	   		}
			return listApartment;
	   		
	   	}
	   	public void setListApartment(List<UserApartment> listApartment) {
	   		this.listApartment = listApartment;
	   	} 
	   	
		private List<User> userlist;
		
	   	
		
		public List<User> getUserlist() {
			userlist=new ArrayList<User>();
			userlist.addAll(getAdminService().getUserlist(str_ApartmentName));
			
			return userlist;
		}
		public void setUserlist(List<User> userlist) {
			this.userlist = userlist;
		}
		private String str_ApartmentName;
		public String getStr_ApartmentName() {
			return str_ApartmentName;
		}
		public void setStr_ApartmentName(String str_ApartmentName) {
			this.str_ApartmentName = str_ApartmentName;
		}
		public void changeStatus(int id,int status)
		{
			
			if(status==0)
			{  
				status=1;
				getAdminService().updateStatus(id,status);
			}
			else
			{
				status=0;
				
				getAdminService().updateStatus(id,status);
			}
		}
		public void deleteApartment(int id)
		{
			System.out.println(id+"jhjhj");
			getAdminService().deleteApartment(id);
		}
		private Integer int_ApartmentId;
		public Integer getInt_ApartmentId() {
			return int_ApartmentId;
		}

		public void setInt_ApartmentId(Integer int_ApartmentId) {
			this.int_ApartmentId = int_ApartmentId;
		}
       private UserApartment apartmentinformation;
		public UserApartment getApartmentinformation() {
		return apartmentinformation;
	}

	public void setApartmentinformation(UserApartment apartmentinformation) {
		this.apartmentinformation = apartmentinformation;
	}

		public void getApartmentlist()
		{
			apartmentinformation=getAdminService().getApartmentDetails(int_ApartmentId);
		}
		public String saveApartment()
		{
			getAdminService().updateApartment(apartmentinformation);
			return "ApartmentView.xhtml";
		}
		private Integer user_ID;
		public Integer getUser_ID() {
			return user_ID;
		}

		public void setUser_ID(Integer user_ID) {
			this.user_ID = user_ID;
		}

		public void getRegisteredUser()
		{
			user=getAdminService().getUser(user_ID);
			
		}
		private boolean indicator2;
		public boolean isIndicator2() {
			return indicator2;
		}

		public void setIndicator2(boolean indicator2) {
			this.indicator2 = indicator2;
		}
		private UserExtraInfo userInfo;
		public void getExtraUserInfo()
		{   try{
			userInfo=getAdminService().getExtraUserInfo(user_ID);
			
			indicator2=(userInfo.getInt_UserID().equals(user_ID));
			
			
		  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		public UserExtraInfo getUserInfo() {
			return userInfo;
		}

		public void setUserInfo(UserExtraInfo userInfo) {
			this.userInfo = userInfo;
		}
		private boolean indicator1=true;
		public boolean isIndicator1() {
			return indicator1;
		}

		public void setIndicator1(boolean indicator1) {
			this.indicator1 = indicator1;
		}
		private boolean indicator;
		public boolean isIndicator() {
			return indicator;
		}

		public void setIndicator(boolean indicator) {
			this.indicator = indicator;
		}

		public boolean changeListener(ActionEvent actionEvent)
		{
			System.out.println("jmncjkfcfgjk");
			indicator=true;
			indicator1=false;
			return indicator;
		}
		//file Upload

		private Part part;
		private String statusMessage;
	    private String path;
		public String uploadFile() throws IOException {

			SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
			 String fileName = fmt.format(new Date()) +getFileName(part).substring(getFileName(part).lastIndexOf('.'));
		
			System.out.println("***** fileName: " + fileName);
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			//String basePath = "D:" + File.separator + "temp" + File.separator;
			//File outputFilePath = new File(basePath + fileName);
			String basePath = servletContext.getRealPath("")
					+ File.separator + "images" + File.separator;
					
			System.out.println(basePath);
			File outputFilePath = new File(basePath);
			 if (!outputFilePath.exists()) {
				   	if (outputFilePath.mkdir()) {
				   		System.out.println("Directory is created!");
				   	} else {
				   		System.out.println("Failed to create directory!");
				   	}
			 }
			 outputFilePath = new File(basePath, fileName);
			System.out.println(path + "path");
			// Copy uploaded file to destination path
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				inputStream = part.getInputStream();
				outputStream = new FileOutputStream(outputFilePath);
	 
				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				path="/images" + File.separator+fileName; 
				user.setVar_ImageName1(path);
				user.setInt_UserId(user.getInt_UserId());
				getAdminService().updateProfilePic(user);
				statusMessage = "File upload successfull !!";
				
			} catch (IOException e) {
				e.printStackTrace();
				statusMessage = "File upload failed !!";
			} finally {
				if (outputStream != null) {
					outputStream.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			}
			return null;    // return to same page
		}
	 
		public Part getPart() throws IOException {
			 
			return part;
		}
	 
		public void setPart(Part part) {
			this.part = part;
		}
	 
		public String getStatusMessage() {
			return statusMessage;
		}
	 
		public void setStatusMessage(String statusMessage) {
			this.statusMessage = statusMessage;
		}
	 
		// Extract file name from content-disposition header of file part
		private String getFileName(Part part) {
			final String partHeader = part.getHeader("content-disposition");
			System.out.println("***** partHeader: " + partHeader);
			for (String content : part.getHeader("content-disposition").split(";")) {
				if (content.trim().startsWith("filename")) {
					return content.substring(content.indexOf('=') + 1).trim()
							.replace("\"", "");
				}
			}
			return null;
		}

		public String getPath() {
			System.out.println(path+"path1");
			path=user.getVar_ImageName1();
			if( path==null)
			{
				path="/images/profilepic.png";
				System.out.println(path+"img1");
			}
			 
			return path ;
		}

		public void setPath(String path) {
			this.path = path;
		}
		public void deleteProfilepic(int id)
		{
			
			user.setVar_ImageName1(null);
			user.setInt_UserId(id);
			getAdminService().updateProfilePic(user);
		}
	}


