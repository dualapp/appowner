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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.springframework.dao.DataAccessException;

import com.appowner.model.FacilityNeeded;
import com.appowner.model.Notice;
import com.appowner.service.NoticeBoardService;
import com.appowner.util.Util;

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
private static List<String> mailids;





public static String getMailids() {
	
	
StringBuilder out = new StringBuilder();
for (Object o : mailids)
{
  out.append(o.toString());
  out.append(",");
}
return out.toString();
	
	
	
}
public static void setMailids(List<String> mailids) {
	NoticeBoardBean.mailids = mailids;
}
private static String subject="subject";
private static String content="content";
	
public static String getSubject() {
	return subject;
}
public static void setSubject(String subject) {
	NoticeBoardBean.subject = subject;
}
public static String getContent() {
	return content;
}
public static void setContent(String content) {
	NoticeBoardBean.content = content;
}
	private Date dat_EntryDate;
	public String addNotice()
	{    try{
		Notice notice=new Notice();
		  notice.setStr_Subject(getStr_Subject());
		notice.setBool_Flash(getBool_Flash());
		notice.setStr_Document(path1);
		
		  notice.setStr_Description(getStr_Description());
		  System.out.println(str_Description);
		  Date date=new java.util.Date();
		  notice.setDat_EntryDate(date);
		  int number=getInt_ExpireDay();
		  System.out.println(number+"jfjgf");
		  Calendar c = Calendar.getInstance(); 
			 c.setTime(date);
			 
			 c.add(Calendar.DATE,number);
			
		Date date1= c.getTime();
			System.out.println(date1+"kunkupriya");
		notice.setInt_ApartmentID(Util.getAppartmentId());
		  notice.setDat_ExpireOn(date1);
		  notice.setInt_ExpireDay(getInt_ExpireDay());
		 notice.setBool_SpecialNotice(getBool_SpecialNotice());
	     notice.setBool_Staff(getBool_Staff());
		  notice.setStr_Visible(getStr_Visible());
		  getNoticeService().addNotice(notice);
		  if(bool_SpecialNotice==true)
			{
				 mailids= getNoticeService().getmailids();
				
				subject="AppOwner.com";
				content="hello";
				return "/AfrteLoginViews/Communication/notice.jsp";
			}
			return null;
		
	}
	catch(DataAccessException e)
	{e.printStackTrace();
		
	}
	return null;
		
	}
	public void reset()
	{
		
	}
	private int rowPerPage=5;
	private Integer pageCurrent;
	 
	private Integer totalRows;
	 
	private int firstRow;
	private Integer[] pages ;
	private int pageRange = 10; 
	private int totalPages;

	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
    public Integer getPageCurrent() {
		 
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getrowPerPage() {
		 
		return rowPerPage;
	}
	public void setrowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	 
	 
	public int getFirstRow() {
	    return firstRow;
	}
	 
	public void setFirstRow(Integer firstRow) {
		this.firstRow = firstRow;
	}
	 /*
	  * paging Actions
	  */
	public void pageFirst() {
	    page(0);
	}

	public void pageNext() {
	    page(firstRow + rowPerPage);
	}

	public void pagePrevious() {
	    page(firstRow - rowPerPage);
	}

	public void pageLast() {
	    page(totalRows - ((totalRows % rowPerPage != 0) ? totalRows % rowPerPage : rowPerPage));
	}
	private void page(int firstRow) {
	    this.firstRow = firstRow;
	    loadListOfNotice(); // Load requested page.
	}
	public void page(ActionEvent event) {
	    page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowPerPage);
	}
	
	
	 
	 
	private List<Notice> listOfNotice;
	
	private void loadListOfNotice()
	{
		listOfNotice=new ArrayList<Notice>();
		if(LoginBean.isAdmin())
		 str_Visible="Only Owner of this Complex";
		else
			str_Visible="Only Member of this Complex";
		listOfNotice.addAll(getNoticeService().listNotices(firstRow, rowPerPage,str_Visible));
		 
		totalRows=getNoticeService().count();
		 
		  
		 System.out.println(totalRows+"totalrows");
		 totalPages = (totalRows / rowPerPage) + ((totalRows % rowPerPage != 0) ? 1 : 0); 
		 pageCurrent=(totalRows / rowPerPage) - ((totalRows - 0) / rowPerPage) + 1;
		 int pagesLength = Math.min(pageRange, totalPages);    
	     pages = new Integer[pagesLength];  
	     int firstPage = Math.min(Math.max(0, pageCurrent - (pageRange / 2)), totalPages - pagesLength);  
	     // Create pages (page numbers for page links).  
	     for (int i = 0; i < pagesLength; i++) {  
	         pages[i] = ++firstPage;  
	     }   
	}
	@SuppressWarnings("unchecked")
	public List<Notice> getListOfNotice() {
		if (listOfNotice== null) {
			loadListOfNotice(); // Preload page for the 1st view.
	    }
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
	
	private LoginBean loginBean;
	
	
	public LoginBean getLoginBean() {
		
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	//FILE UPLOAD CONCEPT
	

	private Part part;
	private String statusMessage;
    private static  String path1;
	public String uploadFile() throws IOException {
        System.out.println("fjkjkfdjkkjfjkfkj");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		 String fileName = fmt.format(new Date()) +getFileName(part).substring(getFileName(part).lastIndexOf('.'));
	
		System.out.println(fileName+"dfjkjkfjkfd");
 
		
		String basePath = "E:" + File.separator + "sites" + File.separator+"AppOwnner"+File.separator+"WebContent"+File.separator+"images"+File.separator;
		System.out.println(basePath);
		File outputFilePath = new File(basePath+fileName);
		
		System.out.println(outputFilePath+"path");
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
			path1=outputFilePath.getName();
			System.out.println(path1+"fkjdfkdl");
		
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
		System.out.println(part+"fdjkfkjkjf");
		System.out.println("partHeader: " +partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

	public static String getPath1() {
		return path1;
	}

	public static void setPath1(String path1) {
		NoticeBoardBean.path1 = path1;
	}

	

	
}