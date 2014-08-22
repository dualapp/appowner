package com.appowner.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.appowner.model.User;
import com.appowner.service.In_UserService;
import com.appowner.util.Util;
import com.ibm.icu.text.SimpleDateFormat;
@ManagedBean
@SessionScoped
public class LoginBean {
	private String userloginpassword;
	private String userloginname;
	private String facebook_userloginname;
	private String facebook_userloginpassword;
	private String linkddin_userloginname;
	private String linkddin_userloginpassword;
	public String formuserloginusername;
	public String formuserloginuserpassword;
	private Integer int_ApartmentId;
	private Integer int_UserId;
	private String Var_ImageName1;
	private String blb_image1;
	private String blb_images2;
	private String path2;
	private String cropimage;
	private String str_userRoleName;
	
	
	
	
	
	public String getStr_userRoleName() {
		return str_userRoleName;
	}





	public void setStr_userRoleName(String str_userRoleName) {
		this.str_userRoleName = str_userRoleName;
	}





	public String getCropimage() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(cropimage);
		return cropimage;//("")+File.separator+"images"+File.separator+"saphi"+File.separator+"crop"+File.separator+"images20140811143252.jpg";
	}





	public void setCropimage(String cropimage) {
		this.cropimage = cropimage;
	}





	public String getPath2() {
		return path2;
	}





	public void setPath2(String path2) {
		this.path2 = path2;
	}





	public String getBlb_images2() {
		
		return blb_images2;
	}





	public void setBlb_images2(String blb_images2) {
		this.blb_images2 = blb_images2;
	}





	public String getBlb_image1() {
		return blb_image1;
	}





	public void setBlb_image1(String blb_image1) {
		this.blb_image1 = blb_image1;
	}





	public String getVar_ImageName1() {
		return Var_ImageName1;
	}





	public void setVar_ImageName1(String var_ImageName1) {
		Var_ImageName1 = var_ImageName1;
	}





	public Integer getInt_UserId() {
		return int_UserId;
	}





	public void setInt_UserId(Integer int_UserId) {
		this.int_UserId = int_UserId;
	}





	public String getUserloginpassword() {
		return userloginpassword;
	}





	public void setUserloginpassword(String userloginpassword) {
		this.userloginpassword = userloginpassword;
	}





	public String getUserloginname() {
		 
		return userloginname;
	}





	public void setUserloginname(String userloginname) {
		this.userloginname = userloginname;
	}





	public String getFacebook_userloginname() {
		return facebook_userloginname;
	}





	public void setFacebook_userloginname(String facebook_userloginname) {
		this.facebook_userloginname = facebook_userloginname;
	}





	public String getFacebook_userloginpassword() {
		return facebook_userloginpassword;
	}





	public void setFacebook_userloginpassword(String facebook_userloginpassword) {
		this.facebook_userloginpassword = facebook_userloginpassword;
	}





	public String getLinkddin_userloginname() {
		return linkddin_userloginname;
	}





	public void setLinkddin_userloginname(String linkddin_userloginname) {
		this.linkddin_userloginname = linkddin_userloginname;
	}





	public String getLinkddin_userloginpassword() {
		return linkddin_userloginpassword;
	}





	public void setLinkddin_userloginpassword(String linkddin_userloginpassword) {
		this.linkddin_userloginpassword = linkddin_userloginpassword;
	}

	@ManagedProperty(value = "#{cls_UserService}")
	private In_UserService userService;
	public In_UserService getUserService() {
		return userService;
	}
	public void setUserService(In_UserService userService) {
		this.userService = userService;
	}



private User user;

	public User getUser() {
	return user;
}





public void setUser(User user) {
	this.user = user;
}



 

	public String userLogin()
	{
		System.out.println("//////////////////////////////////");
		formuserloginusername=getUserloginname();
		formuserloginuserpassword=getUserloginpassword();
		
		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		System.out.println(formuserloginusername);
		System.out.println(formuserloginuserpassword);
		user=getUserService().getUserList(formuserloginusername);
		System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		System.out.println(user);
		str_userRoleName=user.getStr_UserRoleName();
		System.out.println(user.getStr_Password());
		int_UserId=user.getInt_UserId();
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjppppppppppppppppppppppppppppppppppppppppppppppppppppppppjjjjjjjjjjjjjjjjjjj");
		System.out.println(str_userRoleName);
		String admin1="admin";
		
		if(formuserloginuserpassword.equals(user.getStr_Password()))
		{   
			System.out.println("+++++++++++++++++++++++++++66666666666666666666666666666666");
			System.out.println(str_userRoleName);
			System.out.println(admin1);
		   if(admin1.equals(str_userRoleName))
		   {
			int_ApartmentId=user.getInt_ApartmentId();
			int_UserId=user.getInt_UserId();
			
			HttpSession session = Util.getSession();
            session.setAttribute("username", userloginname);
            session.setAttribute("int_ApartmentId", int_ApartmentId);
            session.setAttribute("int_UserId", int_UserId);
			System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
			System.out.println("hiiiiiiiiiiiii");
		 	String index="Adminwelcomepage.xhtml";
		  return index;
		   }
		   else
		   {
			   int_ApartmentId=user.getInt_ApartmentId();
				int_UserId=user.getInt_UserId();
				
				HttpSession session = Util.getSession();
	            session.setAttribute("username", userloginname);
	            session.setAttribute("int_ApartmentId", int_ApartmentId);
	            session.setAttribute("int_UserId", int_UserId);
				System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
				System.out.println("hiiiiiiiiiiiii");
			 String index1= "welcomepage.xhtml";
			 return index1;
		   }
		}
		else
		{FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("User name or password is invalid!"));
		return "layout.xhtml?error=yes";
		}
	}
	public String logout() {
	      HttpSession session = Util.getSession();
	      session.invalidate();
	      return "layout.xhtml";
	   }
	public void facebookuserLogin()
	{
		
		
		
	}
	public void linkedinuserLogin()
	{
		
		
		
	}
	public void getDetails()
	{
		System.out.println(int_UserId);
		user=getUserService().getUserList1(int_UserId);
		//pro=getProductDetailService().editproduct(Int_ProductId);	
		
		
	}
	public String updateUser(){
		user.setVar_FileName1(getPath2());
		user.setVar_ImageName1(getBlb_image1());
		getUserService().updateUs(user);
		//System.out.println(pro);
		return "updationconfirmation.xhtml";
		}
	//image uploading
	public void handleFileUpload1(FileUploadEvent event) throws IOException {
		 System.out.println("hi");
		 String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		    String name = fmt.format(new Date()) +event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
		    System.out.println(name);
		    File file= new File("C://myfinal project//9 august//AppOwnner//WebContent//images//saphi//crop\\"+ "images" + name);
		   
		    final UploadedFile uploadedFile = event.getFile();
		    blb_image1=file.getAbsolutePath();
		    System.out.println("ppppppppppppppppppppppppppppppppppppppppppppppppppppp");
		    System.out.println(blb_image1);
		    blb_images2=blb_image1.substring(49);
		    cropimage="/"+blb_images2;
		    System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
		    System.out.println(cropimage);
	        System.out.println(file);
		    InputStream is = event.getFile().getInputstream();
		    OutputStream out = new FileOutputStream(file);
		    byte buf[] = new byte[1024];
		    int len;
		    while ((len = is.read(buf)) > 0)
		        out.write(buf, 0, len);
		    is.close();
		    out.close();
		    path2=file.getName();
		    System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		    System.out.println(path2);
	}

}
