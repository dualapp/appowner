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

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
	private Long int_NoOfBlock;
	private Long int_TotalHouse;
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
	@PostConstruct
    public void init() {
		listBlockDetails=new ArrayList<UserBlocks>();
		listBlockDetails.addAll(getApartmentDetailsService().getListBlockDetails(Util.getAppartmentId()));
		 
    }
 
	@SuppressWarnings("unused")
	private List<String> communityTypelist;
	private List<String> communityTypelist1;
	public List<String> getCommunityTypelist1() {
		
		return communityTypelist1;
	}
	public void setCommunityTypelist1(List<String> communityTypelist1) {
		this.communityTypelist1 = communityTypelist1;
	}
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
	 
	public Double getDbl_HouseSize() {
		return dbl_HouseSize;
	}
	public void setDbl_HouseSize(Double dbl_HouseSize) {
		this.dbl_HouseSize = dbl_HouseSize;
	}
	private Double dbl_HouseSize;
	
	
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
	public Long getInt_NoOfBlock() {
		return int_NoOfBlock;
	}
	public void setInt_NoOfBlock(Long int_NoOfBlock) {
		this.int_NoOfBlock = int_NoOfBlock;
	}
	 
	
	public Long getInt_TotalHouse() {
		return int_TotalHouse;
	}
	public void setInt_TotalHouse(Long int_TotalHouse) {
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
	@SuppressWarnings("rawtypes")
	private List list=new ArrayList();
	@SuppressWarnings("rawtypes")
	private List list1=new ArrayList();
	@SuppressWarnings("unchecked")
	public void communityTypeListener(ValueChangeEvent event)
	{
		
		 if(event.getOldValue() != null)
		 {
		list1.addAll((List<String>) event.getOldValue());
		 }
		 System.out.println("dfd");
		@SuppressWarnings("rawtypes")
		ListIterator itr1=list1.listIterator();
		while(itr1.hasNext())
		{
			str_CommunityType=(String) itr1.next();
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
			System.out.println(str_CommunityType);
			 
			getApartmentDetailsService().deleteCommunityType(str_CommunityType);
		}
		  
		list.addAll((List<String>) event.getNewValue());
	}
	
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public List getList1() {
		return list1;
	}
	public void setList1(List list1) {
		this.list1 = list1;
	}
	private List<CommunitySetup> CommunityTypeList;
	public String saveCommunitySetup()
	{
		
		CommunitySetup	cs1=new CommunitySetup();
		communityType=new CommunityType();
		cs1.setInt_TotalNoOfHouses(getInt_TotalHouse());;
		 cs1.setInt_UserId(Util.getUserId());
		 cs1.setInt_ApartmentID(Util.getAppartmentId());
		
		 cs1.setInt_year(getInt_year());
		cs1.setInt_NoOfBlocks(getInt_NoOfBlock());
		cs=getApartmentDetailsService().getCommunitySetup(Util.getUserId());
		if(cs!=null)
		{
			
			cs1.setInt_CommunitySetupId(cs.getInt_CommunitySetupId());
			getApartmentDetailsService().updateCommunitySetup(cs1);
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully!"));
			 
		}
		else
		{
		getApartmentDetailsService().saveCommunitySetup(cs1);
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Added Successfully!"));
		}
		ListIterator itr1=list.listIterator();
		
		while(itr1.hasNext())
		{ 
			str_CommunityType=(String) itr1.next();
			communityType.setInt_CommunitySetupId(getApartmentDetailsService().getCommunitySetupId(Util.getUserId()));
		    communityType.setInt_MasterCommunityTypeId(getApartmentDetailsService().getCommunityType(str_CommunityType));
		    communityType.setInt_ApartmentID(Util.getAppartmentId());
		    getApartmentDetailsService().saveCommunitySetup(communityType);
		}
		 
		return "instructions.xhtml";
	}
	 String  oldBlockName;
	 private UserBlocks selectedBlock;
	 private UserBlocks selectedBlock1=new UserBlocks();
	public UserBlocks getSelectedBlock1() {
		return selectedBlock1;
	}
	public void setSelectedBlock1(UserBlocks selectedBlock1) {
		this.selectedBlock1 = selectedBlock1;
	}
	public UserBlocks getSelectedBlock() {
		System.out.println(selectedBlock+"makhetbdbcccccccs");
		return selectedBlock;
	}
	public void setSelectedBlock(UserBlocks selectedBlock) {
		this.selectedBlock = selectedBlock;
	}
	
	public void getBlock1(Integer blockId)
	{
		System.out.println(blockId);
		 
		selectedBlock1=getApartmentDetailsService().getBlock(blockId);
		 
	}
	public String updateBlockDetails(UserBlocks selectedBlock)
	{
		if(selectedBlock1!=null)
		{
			String str_BlockName1=getApartmentDetailsService().checkBlock(selectedBlock1.getStr_BlockName(),Util.getAppartmentId());
			if(selectedBlock1.getStr_BlockName().equalsIgnoreCase(str_BlockName1))
			{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Block with same name already exist in appartment!"));
				return "blockdetails.xhtml";
			}
			Integer blockId=selectedBlock1.getInt_BlockId();
			UserBlocks block=getApartmentDetailsService().getBlock(blockId);
			String oldBlock=block.getStr_BlockName();
			String newBlock=selectedBlock1.getStr_BlockName();
		getApartmentDetailsService().updateOneBlock(selectedBlock1);
		getApartmentDetailsService().updateUserBlock(oldBlock,newBlock,Util.getAppartmentId());
		
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Block Updated Successfully!"));
		}
		 else{
			 FacesMessage message = null;
		FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return "blockdetails.xhtml";
		
	}

	 
		public void onCellEdit(CellEditEvent event) {
	 
		
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
      
        
       System.out.println(getSelectedBlock().getInt_BlockId()+"blockid");
        
        if(newValue != null && !newValue.equals(oldValue)) {
        	UserBlocks ub=new UserBlocks();
        	 if (newValue instanceof Integer)
        		 selectedBlock.setInt_NoOfHouses((Integer)newValue);  
             if (newValue instanceof String)
            	 selectedBlock.setStr_BlockName((String)newValue); 
              if(oldValue instanceof String)
            	  oldBlockName=(String)oldValue;
              System.out.println(ub.getStr_BlockName()+"kakkakak");
    	   System.out.println(ub.getInt_NoOfHouses()+"k1k1k1k1k");
    	   selectedBlock.setInt_ApartmentId(Util.getAppartmentId());
    	   getApartmentDetailsService().updateOneBlock(selectedBlock);
    		//getApartmentDetailsService().updateBlockDetails(ub, oldBlockName);
        	
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	private Integer int_blockId;
	@SuppressWarnings("unchecked")
	public String deleteBlock()
	{
		System.out.println(int_blockId+"BlockId");
		List<HouseDetails> hd=new ArrayList<HouseDetails>();
		  hd=getApartmentDetailsService().getHouseDetailsByBlockId(int_blockId);
		  System.out.println(hd+"nuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
		if(hd.isEmpty())
		{

			getApartmentDetailsService().deleteBlock(int_blockId);
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Block Deleted Successfully!"));
		
		}
		else
		{
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("This Block can't be deleted as it has some houses.Please delete the houses to proceed!"));
		}
		return "blockdetails.xhtml?faces-redirect=true";
	}
	public Integer getInt_blockId() {
		return int_blockId;
	}
	public void setInt_blockId(Integer int_blockId) {
		this.int_blockId = int_blockId;
	}
	public CommunitySetup getCs() {
		cs=new CommunitySetup();
		int_NoOfBlock=getApartmentDetailsService().getNoOfBlocks();
		int_TotalHouse=getApartmentDetailsService().getTotalNoOfHouses();
		if(int_NoOfBlock!=null ||int_TotalHouse!=null)
		{
			getApartmentDetailsService().updateCommunitySetup1(int_NoOfBlock,int_TotalHouse);
		}
		cs=getApartmentDetailsService().getCommunitySetup(Util.getUserId());
		if(cs!=null)
		{
			int_NoOfBlock=cs.getInt_NoOfBlocks();
			 
			int_year=cs.getInt_year();
			int_TotalHouse=cs.getInt_TotalNoOfHouses();
			 
			communityTypelist1=new ArrayList<String>();
			List<Integer> communityTypeId=getApartmentDetailsService().getCommunityTypeIdLists(cs.getInt_CommunitySetupId());
			ListIterator itr=communityTypeId.listIterator();
			while(itr.hasNext())
			{
				Integer cid=(Integer) itr.next();
				
				communityTypelist1.add(getApartmentDetailsService().getCommunityMasterType(cid));
			}
			 
			
		}
		 
		return cs;
	}
	public void setCs(CommunitySetup cs) {
		this.cs = cs;
	}
	public String saveBlockDetails()
	{
		
		if(str_BlockName!=null)
		{
			String str_BlockName1=getApartmentDetailsService().checkBlock(str_BlockName,Util.getAppartmentId());
			if(str_BlockName.equalsIgnoreCase(str_BlockName1))
			{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Block with same name already exist in appartment!"));
				return "blockdetails.xhtml";
			}
		UserBlocks ub=new UserBlocks();
		ub.setInt_NoOfHouses(int_NoOfHouse);
		ub.setStr_BlockName(str_BlockName);
		ub.setInt_ApartmentId(Util.getAppartmentId());
		getApartmentDetailsService().saveBlockDetails(ub);
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Added Successfully!"));
		}
		 else{
			 FacesMessage message = null;
		FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return "blockdetails.xhtml";
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
	housedetails=new HouseDetails();
		housedetails=getApartmentDetailsService().getHouseDetails(houseId);
		 
		System.out.println(housedetails+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhDddddddddddddd");
	}
	
	public String deleteHouseDetails(Integer HouseId)
	{  housedetails=new HouseDetails();
	 housedetails=getApartmentDetailsService().getHouseDetails(HouseId);
		Long u=getApartmentDetailsService().getNoOfUsers( housedetails.getStr_HouseNo());
		System.out.println(u+"uuuuuuuuuuuuuuuuuuuuser");
		if(u==0)
		{
			
			housedetails.setInt_HouseId(HouseId);
		getApartmentDetailsService().deleteHouseDetails(housedetails);	
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
		}
		else
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("The selected Houses have users or maintenance dues associated with them .so they  couldn't be deleted!.Please remove the members from the houses to proceed."));
			
		return null;
	}
	public String deleteSelectedHouse() {
	    List<HouseDetails> entitiesToDelete = new ArrayList<HouseDetails>();
 
	    for (HouseDetails house :selectedHouse) {
	    	Long u=getApartmentDetailsService().getNoOfUsers( house.getStr_HouseNo());
			if(u==0)
			{
	    	 
				getApartmentDetailsService().deleteHouseDetails(house);
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Deleted Successfully!"));
			}
			else
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("The selected Houses have users or maintenance dues associated with them .so they  couldn't be deleted!.Please remove the members from the houses to proceed."));
				
	    } 
  
	    return null;
	}
	public String updateHouseDetails()
	{
		if(housedetails!=null)
		{ 
			String str_HouseNo1=getApartmentDetailsService().checkHouse(housedetails.getStr_HouseNo(),Util.getAppartmentId(),housedetails.getInt_BlockId());
			if(housedetails.getStr_HouseNo().equalsIgnoreCase(str_HouseNo1))
			{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("House No with same name already exist in Block!"));
				return null;
			}
			Integer houseId=housedetails.getInt_HouseId();
		HouseDetails housedetails1=getApartmentDetailsService().getHouseDetails(houseId);
		String oldHouseNo=housedetails1.getStr_HouseNo();
		String newHouseNo=housedetails.getStr_HouseNo();
		Integer blockId=housedetails.getInt_BlockId();
		UserBlocks ub=getApartmentDetailsService().getBlock(blockId);
		String blockName=ub.getStr_BlockName();
		
			getApartmentDetailsService().updateHouseDetails(housedetails);
			getApartmentDetailsService().updateUserFlat(oldHouseNo,newHouseNo,blockName,Util.getAppartmentId());
			
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Updated Successfully!"));
		}
		 else{
			 FacesMessage message = null;
		FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return null;
	}
	public String getBlockName()
	{
		if(str_BlockName!=null)
		{
			return str_BlockName;
		}
			else{
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Please Select A Block!"));
			return null;
			}
		
	}
	public String saveHouseDetails()
	{ 
		if(str_HouseNo!=null)
		{ 
			Integer houseId=getApartmentDetailsService().getBlockId(str_BlockName);
			String str_HouseNo1=getApartmentDetailsService().checkHouse(str_HouseNo,Util.getAppartmentId(),houseId);
			if(str_HouseNo.equalsIgnoreCase(str_HouseNo1))
			{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("House Nowith same name already exist in Block!"));
				return null;
			}
		housedetails=new HouseDetails();
		housedetails.setInt_ApartmentId(Util.getAppartmentId());
		
		housedetails.setStr_HouseNo(str_HouseNo);
		 
		housedetails.setDbl_HouseSize(dbl_HouseSize);
		housedetails.setInt_NoOfBalconies(int_NoOfBalconies);
		housedetails.setInt_NoOfBathRooms(int_NoOfBedRooms);
		 
		housedetails.setInt_NoOfUsers(getApartmentDetailsService().getNoOfUsers(str_HouseNo));
		housedetails.setIs_Rented(is_Rented);
		housedetails.setStr_TypeOfHouse(str_TypeOfHouse);
		housedetails.setInt_ApartmentId(Util.getAppartmentId());
		housedetails.setInt_BlockId(getApartmentDetailsService().getBlockId(str_BlockName));
		getApartmentDetailsService().saveHouseDetails(housedetails);
		int_NoOfBlock=getApartmentDetailsService().getNoOfBlocks();
		int_TotalHouse=getApartmentDetailsService().getTotalNoOfHousesInABlock(str_BlockName,Util.getAppartmentId());
		if(int_TotalHouse!=null)
		{
			getApartmentDetailsService().updateBlockTotalhouse(str_BlockName,int_TotalHouse);
		}
		str_HouseNo="";
		dbl_HouseSize=0.0;
		int_NoOfBalconies=0;
		int_NoOfBedRooms=0;
		
		 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Added Successfully!"));
		}
		 else{
			 FacesMessage message = null;
		FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return null;
	}
	public List<UserBlocks> getListBlockDetails() {
		
		return listBlockDetails;
	}
	 
	public void setListBlockDetails(List<UserBlocks> listBlockDetails) {
		this.listBlockDetails = listBlockDetails;
	}
	 
	public List<HouseDetails> getListHouseDetails() {
		listHouseDetails=new ArrayList<HouseDetails>();
		
		 listHouseDetails.addAll(getApartmentDetailsService().getListHouseDetails(str_BlockName,Util.getAppartmentId()));
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
		
		blockNameList.addAll(getApartmentDetailsService().getBlockNameList(Util.getAppartmentId()));
		return blockNameList;
	}
	public void setBlockNameList(List<String> blockNameList) {
		this.blockNameList = blockNameList;
	}
	public List<HouseDetails> getListHouseDetails1(String str_BlockName) {
		listHouseDetails=new ArrayList<HouseDetails>();
		 
		listHouseDetails.addAll(getApartmentDetailsService().getListHouseDetails(str_BlockName,Util.getAppartmentId()));
		 
		
		 
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
	            	   
	            	   hdetails.setDbl_HouseSize((Double)cell.getNumericCellValue());
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
		 public String uploadFile() throws IOException {
			 String fileName = getFileName(part);
			
            if(fileName!=null)
            {
				// Extract file name from content-disposition header of file part
				
				System.out.println("***** fileName: " + fileName);
				 ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
					String basePath = servletContext.getRealPath("")+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
				 
				System.out.println(basePath);
				File outputFilePath = new File(basePath);
				if (!outputFilePath.exists()) {
				   	if (outputFilePath.mkdir()) {
				   		System.out.println("Directory is created!");
				   	} else {
				   		System.out.println("Failed to create directory!");
				   	}
			 }
				outputFilePath = new File(basePath,fileName);
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
				  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("House Details Added Successfully!"));
					statusMessage = "File upload successfull !!";
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (outputStream != null) {
						outputStream.close();
					}
					if (inputStream != null) {
						inputStream.close();
					}
				}
		 }
            else{
   			 FacesMessage message = null;
   		FacesContext.getCurrentInstance().addMessage(null, message);

   		}
		 return null;
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
			  ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
				String basePath = servletContext.getContextPath()+File.separator+"WebContent"+File.separator+"images"+File.separator;
		     File file = new File(basePath+"Community_setup_house.xls");
		      
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
	  listHouseDetails.addAll(getApartmentDetailsService().getListHouseDetails(str_BlockName,Util.getAppartmentId()));
	  System.out.println(listHouseDetails+"klap1");
  }
   
  public ApartmentDetailsBean() throws FileNotFoundException{        
	  ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext(); 
	  File result = new File(extContext.getRealPath("//images//Community_setup_house.xls"));     
	  InputStream stream = new FileInputStream(result.getAbsolutePath());
	  downloadFile = new DefaultStreamedContent(stream, "application/xls", "Community_setup_house.xls");
      
      
      System.out.println(downloadFile+"kkkkkkkkkkkkkkkkkkkkkkkkffffffffffffffffffffffff");
  }
  private StreamedContent downloadFile;
public StreamedContent getDownloadFile() {
	return downloadFile;
}
public void setDownloadFile(StreamedContent downloadFile) {
	this.downloadFile = downloadFile;
}
 
 
}
