package com.appowner.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.appowner.model.CommunitySetup;
import com.appowner.model.CommunityType;
import com.appowner.model.Employee;
import com.appowner.model.HouseDetails;
import com.appowner.model.User;
import com.appowner.model.UserBlocks;
import com.appowner.model.Vendor;
import com.appowner.service.ApartmentDetailsService;
import com.appowner.util.Util;

@ManagedBean
@ViewScoped
public class ApartmentDetailsBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{ApartmentDetailsService}")
	private ApartmentDetailsService apartmentDetailsService;
	public ApartmentDetailsService getApartmentDetailsService() {
		return apartmentDetailsService;
	}
	public void setApartmentDetailsService(
			ApartmentDetailsService apartmentDetailsService) {
		this.apartmentDetailsService = apartmentDetailsService;
	}
	private String str_CommunityType;
	private List<UserBlocks> listBlockDetails;
	private List<HouseDetails> listHouseDetails;
	private Integer int_year;
	private Integer int_NoOfBlock;
	private Integer int_TotalHouse;
	private Integer int_NoOfHouse;
	
	public Integer getInt_NoOfHouse() {
		return int_NoOfHouse;
	}
	public void setInt_NoOfHouse(Integer int_NoOfHouse) {
		this.int_NoOfHouse = int_NoOfHouse;
	}
	public String getStr_BlockName() {
		return str_BlockName;
	}
	public void setStr_BlockName(String str_BlockName) {
		this.str_BlockName = str_BlockName;
	}
	private String str_BlockName;
	private Integer int_NoOfBalconies;
	private Integer int_NoOfBedRooms;
	private String is_Rented;
	private String str_TypeOfHouse;
	private String str_HouseNo;
	private Integer int_CommunitysetUpId;
	 
	@SuppressWarnings("unused")
	private List<String> communityTypelist;
	private CommunityType communityType;
	 
	 
	public List<String> getCommunityTypelist() {
		communityTypelist=new ArrayList<String>();
		communityTypelist.addAll( getApartmentDetailsService().getCommunityTypelist());
		return communityTypelist;
	}
	public void setCommunityTypelist(List<String> communityTypelist) {
		this.communityTypelist = communityTypelist;
	}
	public Integer getInt_CommunitysetUpId() {
		
		return int_CommunitysetUpId;
	}
	public void setInt_CommunitysetUpId(Integer int_CommunitysetUpId) {
		this.int_CommunitysetUpId = int_CommunitysetUpId;
	}
	public Integer getInt_NoOfBalconies() {
		return int_NoOfBalconies;
	}
	public void setInt_NoOfBalconies(Integer int_NoOfBalconies) {
		this.int_NoOfBalconies = int_NoOfBalconies;
	}
	public Integer getInt_NoOfBedRooms() {
		return int_NoOfBedRooms;
	}
	public void setInt_NoOfBedRooms(Integer int_NoOfBedRooms) {
		this.int_NoOfBedRooms = int_NoOfBedRooms;
	}
	 
	public String getIs_Rented() {
		return is_Rented;
	}
	public void setIs_Rented(String is_Rented) {
		this.is_Rented = is_Rented;
	}
	public String getStr_TypeOfHouse() {
		return str_TypeOfHouse;
	}
	public void setStr_TypeOfHouse(String str_TypeOfHouse) {
		this.str_TypeOfHouse = str_TypeOfHouse;
	}
	public String getStr_HouseNo() {
		return str_HouseNo;
	}
	public void setStr_HouseNo(String str_HouseNo) {
		this.str_HouseNo = str_HouseNo;
	}
	public Integer getInt_HouseSize() {
		return int_HouseSize;
	}
	public void setInt_HouseSize(Integer int_HouseSize) {
		this.int_HouseSize = int_HouseSize;
	}
	private Integer int_HouseSize;
	
	
	public String getStr_CommunityType() {
		return str_CommunityType;
	}
	public void setStr_CommunityType(String str_CommunityType) {
		this.str_CommunityType = str_CommunityType;
	}
	public Integer getInt_year() {
		return int_year;
	}
	public void setInt_year(Integer int_year) {
		this.int_year = int_year;
	}
	public Integer getInt_NoOfBlock() {
		return int_NoOfBlock;
	}
	public void setInt_NoOfBlock(Integer int_NoOfBlock) {
		this.int_NoOfBlock = int_NoOfBlock;
	}
	public Integer getInt_TotalHouse() {
		return int_TotalHouse;
	}
	public void setInt_TotalHouse(Integer int_TotalHouse) {
		this.int_TotalHouse = int_TotalHouse;
	}
	
	private CommunitySetup cs;
 
	private Integer int_TotalNoOfHouses;
	public Integer getInt_TotalNoOfHouses() {
		return int_TotalNoOfHouses;
	}
	public void setInt_TotalNoOfHouses(Integer int_TotalNoOfHouses) {
		this.int_TotalNoOfHouses = int_TotalNoOfHouses;
	}
	private List list=new ArrayList();
	@SuppressWarnings("unchecked")
	public void communityTypeListener(ValueChangeEvent event)
	{
		list.addAll((List<String>) event.getNewValue());
	}
	
	
	private List<CommunitySetup> CommunityTypeList;
	public String saveCommunitySetup()
	{
		
		CommunitySetup	cs1=new CommunitySetup();
		communityType=new CommunityType();
		cs1.setInt_TotalNoOfHouses(getInt_TotalHouse());;
		 cs1.setInt_UserId(Util.getUserId());
		 cs1.setInt_year(getInt_year());
		cs1.setInt_NoOfBlocks(getInt_NoOfBlock());
		cs=getApartmentDetailsService().getCommunitySetup(Util.getUserId());
		if(cs!=null)
		{
			
			cs1.setInt_CommunitySetupId(cs.getInt_CommunitySetupId());
			getApartmentDetailsService().updateCommunitySetup(cs1);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Updated Successfully!", "Updated Successfully!"));
		}
		else
		{
		getApartmentDetailsService().saveCommunitySetup(cs1);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Added Successfully!", "Added Successfully!"));
		}
		ListIterator itr1=list.listIterator();
		
		while(itr1.hasNext())
		{ 
			str_CommunityType=(String) itr1.next();
			communityType.setInt_CommunitySetupId(getApartmentDetailsService().getCommunitySetupId(Util.getUserId()));
		    communityType.setInt_CommunityTypeId(getApartmentDetailsService().getCommunityType(str_CommunityType));
		    getApartmentDetailsService().saveCommunitySetup(communityType);
		}
		 
		return "blockdetails.xhtml";
	}
	public CommunitySetup getCs() {
		cs=new CommunitySetup();
		cs=getApartmentDetailsService().getCommunitySetup(Util.getUserId());
		if(cs!=null)
		{
			int_NoOfBlock=cs.getInt_NoOfBlocks();
			
			int_year=cs.getInt_year();
			int_TotalHouse=cs.getInt_TotalNoOfHouses();
			str_CommunityType=cs.getStr_CommunitySetupType();
			
		}
		else
		{
			int_NoOfBlock=this.getInt_NoOfBlock();
			int_year=this.getInt_year();
			int_TotalHouse=this.getInt_TotalHouse();
			
			str_CommunityType=this.getStr_CommunityType();
		}
		return cs;
	}
	public void setCs(CommunitySetup cs) {
		this.cs = cs;
	}
	public String saveBlockDetails()
	{
		UserBlocks ub=new UserBlocks();
		ub.setInt_NoOfHouses(int_NoOfHouse);
		ub.setStr_BlockName(str_BlockName);
		ub.setInt_ApartmentId(Util.getAppartmentId());
		getApartmentDetailsService().saveBlockDetails(ub);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Added Successfully!", "Added Successfully!"));
		return null;
	}
	private HouseDetails housedetails=new HouseDetails();
	public HouseDetails getHousedetails() {
		return housedetails;
	}
	public void setHousedetails(HouseDetails housedetails) {
		this.housedetails = housedetails;
	}
	private List<HouseDetails> selectedHouse;
	public List<HouseDetails> getSelectedHouse() {
		return selectedHouse;
	}
	public void setSelectedHouse(List<HouseDetails> selectedHouse) {
		this.selectedHouse = selectedHouse;
	}
	/**
 * get particular House according to House id
 */
	 
	public void getHouseDetails1(Integer houseId)
	{    System.out.println( houseId+"hid");
	
		housedetails=getApartmentDetailsService().getHouseDetails(houseId);
		 
		System.out.println(housedetails+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhDddddddddddddd");
	}
	
	public String deleteHouseDetails(Integer HouseId)
	{System.out.println( HouseId+"hid1");
	housedetails=new HouseDetails();
		housedetails.setInt_HouseId(HouseId);
		
		getApartmentDetailsService().deleteHouseDetails(housedetails);	
		return null;
	}
	public String deleteSelectedHouse() {
	    List<HouseDetails> entitiesToDelete = new ArrayList<HouseDetails>();
 
	    for (HouseDetails house :selectedHouse) {
	    	 
	    	if (house.getInt_HouseId()!=null) 
	    	{
	            entitiesToDelete.add(house);
	        }
	    	
	    } 
System.out.println(entitiesToDelete+"entyt todelete");
 getApartmentDetailsService().deleteSelectedHouse(entitiesToDelete);
	    FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"  deleted Successfully!", " deleted Successfully!"));
	    return null;
	}
	public String updateHouseDetails()
	{
		if(housedetails.getInt_HouseId()!=null)
		{
			getApartmentDetailsService().updateHouseDetails(housedetails);
			 FacesContext facesContext = FacesContext.getCurrentInstance();
				Flash flash = facesContext.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"  Updated Successfully!", " Updateed Successfully!"));
		}
		return null;
	}
	public String saveHouseDetails()
	{ 
		
		housedetails=new HouseDetails();
		housedetails.setInt_ApartmentId(Util.getAppartmentId());
		
		housedetails.setStr_HouseNo(str_HouseNo);
		housedetails.setInt_HouseSize(int_HouseSize);
		housedetails.setInt_NoOfBalconies(int_NoOfBalconies);
		housedetails.setInt_NoOfBathRooms(int_NoOfBedRooms);
		 
		housedetails.setInt_NoOfUsers(getApartmentDetailsService().getNoOfUsers(str_HouseNo));
		housedetails.setIs_Rented(is_Rented);
		housedetails.setStr_TypeOfHouse(str_TypeOfHouse);
		housedetails.setInt_ApartmentId(Util.getAppartmentId());
		housedetails.setInt_BlockId(getApartmentDetailsService().getBlockId(str_BlockName));
		getApartmentDetailsService().saveHouseDetails(housedetails);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Added Successfully!", "Added Successfully!"));
		return null;
	}
	public List<UserBlocks> getListBlockDetails() {
		listBlockDetails=new ArrayList<UserBlocks>();
		listBlockDetails.addAll(getApartmentDetailsService().getListBlockDetails());
		return listBlockDetails;
	}
	 
	public void setListBlockDetails(List<UserBlocks> listBlockDetails) {
		this.listBlockDetails = listBlockDetails;
	}
	 
	public List<HouseDetails> getListHouseDetails() {
		 
		System.out.println(listHouseDetails+"klap");
		 
		return listHouseDetails;
	}
	private List<String> blockNameList;
	private Integer int_HouseId;
	public Integer getInt_HouseId() {
		return int_HouseId;
	}
	public void setInt_HouseId(Integer int_HouseId) {
		this.int_HouseId = int_HouseId;
	}
	public List<String> getBlockNameList() {
		blockNameList=new ArrayList<String>();
		
		blockNameList.addAll(getApartmentDetailsService().getBlockNameList());
		return blockNameList;
	}
	public void setBlockNameList(List<String> blockNameList) {
		this.blockNameList = blockNameList;
	}
	public List<HouseDetails> getListHouseDetails1(String str_BlockName) {
		listHouseDetails=new ArrayList<HouseDetails>();
		 
		listHouseDetails.addAll(getApartmentDetailsService().getListHouseDetails(str_BlockName));
		 
		
		 
		return listHouseDetails;
	}
	public void setListHouseDetails(List<HouseDetails> listHouseDetails) {
		this.listHouseDetails = listHouseDetails;
	}
	public List<CommunitySetup> getCommunityTypeList() {
		CommunityTypeList=new ArrayList<CommunitySetup>();
		CommunityTypeList.addAll(getApartmentDetailsService().getCommunityType(Util.getUserId()));
		return CommunityTypeList;
	}
	public void setCommunityTypeList(List<CommunitySetup> communityTypeList) {
		CommunityTypeList = communityTypeList;
	}
	 
	 
	public List<HouseDetails> empList;

	 
    
	public List<HouseDetails> getEmpList() {
		return empList;
	}
	public void setEmpList(List<HouseDetails> empList) {
		this.empList = empList;
	}

	public   List<HouseDetails> readExcel(String filePath) {
		System.out.println(filePath+"filePath");
	   try {
		   empList = new ArrayList<HouseDetails>();
	       FileInputStream file = new FileInputStream(new File(filePath));
	       // Getting the instance for XLS file
	       HSSFWorkbook workbook = new HSSFWorkbook(file);

	       // Get First sheet from the workbook
	       HSSFSheet sheet = workbook.getSheetAt(0);

	       ArrayList myList = new ArrayList();
	       HouseDetails hdetails;  

	       // Iterate start from the first sheet of the uploaded excel file
	       Iterator<Row> rowIterator = sheet.iterator();
	      

	       while (rowIterator.hasNext()) {
	    	   hdetails = new  HouseDetails();
	    	  
	    	   
	           Row row = rowIterator.next();

	              if (row.getRowNum() == 0) {
	               continue;// skip to read the first row of file
	           }

	           // For each row, iterate through each coulumns
	           Iterator<Cell> cellIterator = row.cellIterator();
	           
	           while (cellIterator.hasNext()) {
	               Cell cell = cellIterator.next();
	               hdetails.setInt_ApartmentId(Util.getAppartmentId());
	               empList.add( hdetails);
	                 if (cell.getColumnIndex() == 0 ) {
	                	 String Block=cell.getStringCellValue();
	            	   hdetails.setInt_BlockId(getApartmentDetailsService().getBlockId(str_BlockName));
	            	   
	                   empList.add( hdetails);
	                   System.out.print(cell.getStringCellValue()+ "\t\t");
	               }
	               else if (cell.getColumnIndex() == 1 ) {
	            	  
	            	   hdetails.setStr_HouseNo(cell.getStringCellValue());
	                   empList.add( hdetails);
	                   System.out.print(cell.getStringCellValue() + "\t\t");
	               }
	               
	               else if (cell.getColumnIndex() == 2 ) {
	            	   hdetails.setInt_HouseSize((int)cell.getNumericCellValue());
	            	  
	                   empList.add( hdetails);
	                   System.out.print((int)cell.getNumericCellValue() + "\t\t");
	               }
	                 
	               else if (cell.getColumnIndex() == 3 ) {
	            	   hdetails.setStr_TypeOfHouse(cell.getStringCellValue());
	            	   
	                   empList.add( hdetails);
	                   System.out.print(cell.getStringCellValue() + "\t\t");
	               }
	               else if (cell.getColumnIndex() == 4 ) {
	            	   hdetails.setInt_NoOfBalconies((int)cell.getNumericCellValue());
	            	   
	            	  
	                   empList.add( hdetails);
	                   System.out.print(cell.getNumericCellValue()+ "\t\t");
	               }
	               else if (cell.getColumnIndex() == 5 ) {
	            	   hdetails.setInt_NoOfBathRooms((int)cell.getNumericCellValue());
	            	   
	            	  
	                   empList.add( hdetails);
	                   System.out.print(cell.getNumericCellValue()+ "\t\t");
	               }
	               else if (cell.getColumnIndex() == 6 ) {
	            	   hdetails.setIs_Rented(cell.getStringCellValue());
	            	    
	                   empList.add( hdetails);
	                   System.out.print(cell.getStringCellValue()+ "\t\t");
	               }
	               }
	          
	           }


	       file.close();       

	}catch (FileNotFoundException fnfe) {
	   fnfe.printStackTrace();
	} catch (IOException e) {
	   e.printStackTrace();
	}
	   System.out.println(empList+"emplist"); 


	   return empList;
	}
	  
	 
	  
	//file Upload
		private Part part;
		public String getPath() {
			System.out.println(path+"path1");
			if(path==null)
			{
				path="/images/profilepic.png";
			}
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}

		private String statusMessage;
	  private String path;
		 public void uploadFile() throws IOException {
			

				// Extract file name from content-disposition header of file part
				String fileName = getFileName(part);
				System.out.println("***** fileName: " + fileName);
		  
				String basePath = "D:" + File.separator + "kalpanaproj" + File.separator+"AppOwnner"+File.separator+"WebContent"+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
				System.out.println(basePath);
				File outputFilePath = new File(basePath+fileName);
			System.out.println(outputFilePath.getAbsolutePath());
			
		        
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
					List<HouseDetails>  hDetailsList=readExcel(outputFilePath.getAbsolutePath());
					 System.out.println( hDetailsList);
				  getApartmentDetailsService().saveHouseDetails1( hDetailsList);
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
				 
		 
		} 
		 private Integer index;

		public Integer getIndex() {
			index=0;
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
		public Part getPart() {
			 
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
		/**
		   * Download file.
		   */
		  public String downloadFile() throws IOException
		  {
		     File file = new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images\\Community_setup_house.xls");
		     InputStream fis = new FileInputStream(file);
		     byte[] buf = new byte[1024];
		     int offset = 0;
		     int numRead = 0;
		     while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) 
		     {
		       offset += numRead;
		     }
		     fis.close();
		     HttpServletResponse response =
		        (HttpServletResponse) FacesContext.getCurrentInstance()
		            .getExternalContext().getResponse();
		    
		    response.setContentType("application/xls");
		    response.setHeader("Content-Disposition", "attachment;filename=Community_setup_house.xls");
		    response.getOutputStream().write(buf);
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
		    
		    FacesContext.getCurrentInstance().responseComplete();
		    return null;
		  }
  public void blockChangeListener(ValueChangeEvent event)
  {   listHouseDetails=new ArrayList<HouseDetails>();
	  String str_BlockName=(String) event.getNewValue();
	  System.out.println(str_BlockName+"kalpanaaaaaaaaaaaaaaaaaaaaa");
	  listHouseDetails.addAll(getApartmentDetailsService().getListHouseDetails(str_BlockName));
	  System.out.println(listHouseDetails+"klap1");
  }
}
