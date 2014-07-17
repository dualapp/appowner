package com.appowner.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.springframework.dao.DataAccessException;

import com.appowner.model.Notice;
import com.appowner.service.NoticeBoardService;

@ManagedBean
@ViewScoped
public class NoticeBoardBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{NoticeBoardService}")
	private NoticeBoardService noticeService;

	public NoticeBoardService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeBoardService noticeService) {
		this.noticeService = noticeService;
	}
	private Integer int_NoticeID;
	public Integer getInt_NoticeID() {
		return int_NoticeID;
	}
	public void setInt_NoticeID(Integer int_NoticeID) {
		this.int_NoticeID = int_NoticeID;
	}
	public String getStr_Subject() {
		return str_Subject;
	}
	public void setStr_Subject(String str_Subject) {
		this.str_Subject = str_Subject;
	}
	
	public Boolean getBool_Flash() {
		return bool_Flash;
	}
	public void setBool_Flash(Boolean bool_Flash) {
		this.bool_Flash = bool_Flash;
	}
	
	public Integer getInt_ExpireDay() {
		return int_ExpireDay;
	}
	public void setInt_ExpireDay(Integer int_ExpireDay) {
		this.int_ExpireDay = int_ExpireDay;
	}

	
	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	public Boolean getBool_SpecialNotice() {
		return bool_SpecialNotice;
	}
	public void setBool_SpecialNotice(Boolean bool_SpecialNotice) {
		this.bool_SpecialNotice = bool_SpecialNotice;
	}
	public Boolean getBool_Staff() {
		return bool_Staff;
	}
	public void setBool_Staff(Boolean bool_Staff) {
		this.bool_Staff = bool_Staff;
	}
	public String getStr_Visible() {
		return str_Visible;
	}
	public void setStr_Visible(String str_Visible) {
		this.str_Visible = str_Visible;
	}
	private String str_Subject;
	private Boolean bool_Flash;
	private Integer int_ExpireDay;
	private String str_Document;
	public void setStr_Document(String str_Document) {
		this.str_Document = str_Document;
	}
	private String str_Description;
	private Boolean bool_SpecialNotice;
	private Boolean bool_Staff;
	private String str_Visible;
	
	
	public Date getDat_EntryDate() {
		return dat_EntryDate;
	}
	public void setDat_EntryDate(Date dat_EntryDate) {
		this.dat_EntryDate = dat_EntryDate;
	}
private	 String uploadedFileName;
	public String getUploadedFileName() {
		
	return uploadedFileName;
}
public void setUploadedFileName(String uploadedFileName) {
	this.uploadedFileName = uploadedFileName;
}
	private Date dat_EntryDate;
	public String addNotice()
	{    try{
		Notice notice=new Notice();
		  notice.setStr_Subject(getStr_Subject());
		notice.setBool_Flash(getBool_Flash());
		notice.setStr_Document(uploadedFileName);
		 System.out.println(uploadedFileName);
		  notice.setStr_Description(getStr_Description());
		  System.out.println(str_Description);
		  notice.setInt_ExpireDay(getInt_ExpireDay());
		 notice.setBool_SpecialNotice(getBool_SpecialNotice());
	     notice.setBool_Staff(getBool_Staff());
		  notice.setStr_Visible(getStr_Visible());
		  getNoticeService().addNotice(notice);
			
		return "noticeView.xhtml";
	}
	catch(DataAccessException e)
	{e.printStackTrace();
		
	}
	return null;
		
	}
	public void reset()
	{
		
	}
	
	private List<Notice> listOfNotice;
	@SuppressWarnings("unchecked")
	public List<Notice> getListOfNotice() throws ParseException {
		listOfNotice=new ArrayList<Notice>();
		listOfNotice.addAll(getNoticeService().listNotices());
		  /*ListIterator itr=listOfNotice.listIterator();
		   while(itr.hasNext())
		   {
			   Object obj=itr.next();
			   Notice notice=(Notice)obj;
			   dat_EntryDate=notice.getDat_EntryDate();
			   System.out.println(dat_EntryDate);
			   int_ExpireDay=notice.getInt_ExpireDay();
			   System.out.println(int_ExpireDay);
			   @SuppressWarnings("deprecation")
			int month = dat_EntryDate.getMonth() +1;
					   @SuppressWarnings("deprecation")
					int day = dat_EntryDate.getDate();
					   @SuppressWarnings("deprecation")
					int year=dat_EntryDate.getYear();
							   System.out.println(month);
					   System.out.println(day);
					   System.out.println(year);
				int day1=dat_EntryDate.getDate()+int_ExpireDay;
				System.out.println(day1);
				String date = year + "/" + month + "/" + day1;
			    java.util.Date dat_ExpireOn = null;

			  
			      SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			      dat_ExpireOn = formatter.parse(date);
			      System.out.println("utilDate:" + dat_ExpireOn);
			    
		   }
		  */ 
		  
		return listOfNotice;
			
	}
	public void setListOfNotice(List<Notice> listOfNotice) {
		this.listOfNotice = listOfNotice;
	}
	private Date dat_ExpireOn;
	public Date getDat_ExpireOn() {
		return dat_ExpireOn;
	}
	public void setDat_ExpireOn(Date dat_ExpireOn) {
		this.dat_ExpireOn = dat_ExpireOn;
	}
	
	
	
	//FILE UPLOAD CONCEPT
	 public void handleFileUpload(FileUploadEvent event) throws IOException {
		 System.out.println("hi");
		 String path = FacesContext.getCurrentInstance().getExternalContext()
		            .getRealPath("/");
		    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		    String name = fmt.format(new Date())
		            + event.getFile().getFileName().substring(
		                  event.getFile().getFileName().lastIndexOf('.'));
		    System.out.println(name);
		    File file= new File("E:\\myUploads\\" + "images" + name);
               System.out.println(file);
		    InputStream is = event.getFile().getInputstream();
		    OutputStream out = new FileOutputStream(file);
		    byte buf[] = new byte[1024];
		    int len;
		    while ((len = is.read(buf)) > 0)
		        out.write(buf, 0, len);
		    is.close();
		    out.close();
		     uploadedFileName = file.getName();
		    System.out.println(uploadedFileName);
		
	    
	    }
}