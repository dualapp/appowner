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
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.springframework.dao.DataAccessException;

import com.appowner.model.FacilityNeeded;
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
private static List<String> mailids;





public static String getMailids() {
	
	/*String[] stockArr = new String[mailids.size()];
	stockArr = mailids.toArray(stockArr);
	for(String s : stockArr)
	{
		return s;
	
	}
	return null;
	*/
	/*String[] strArray = (String[]) mailids.toArray(new String[0]);
			    System.out.println(ArrayUtils.toString(strArray));
			 //   System.out.println(strarray);

	return ArrayUtils.toString(strArray);*/
	/*String[] strarray = new String[mailids.size()];
		    mailids.toArray(strarray );
		    for(String s : strarray)
			{ System.out.println(s);
				return s;
			
			}
	*/
	/*StringBuilder sb = new StringBuilder();
	for (String s : mailids)
	{
	    sb.append(s);
	    sb.append("\t");
	}
*/StringBuilder out = new StringBuilder();
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
		notice.setStr_Document(uploadedFileName);
		
		  notice.setStr_Description(getStr_Description());
		  System.out.println(str_Description);
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
		      File file= new File("E:\\myUploads//" + "images" + name);
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