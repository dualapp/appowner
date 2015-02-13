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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;

import org.springframework.dao.DataAccessException;

import com.appowner.model.Complain;
import com.appowner.model.PanelPrice;
import com.appowner.model.User;
import com.appowner.model.UserApartment;
import com.appowner.service.ComplainService;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
@ManagedBean
@RequestScoped
public class ComplainBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String ERROR   = "error";
	@ManagedProperty(value = "#{ComplainService}")
	private ComplainService complainService;
	public ComplainService getComplainService() {
		return complainService;
	}
	public void setComplainService(ComplainService complainService) {
		this.complainService = complainService;
	}
	private Integer int_ComplainID;
	public Integer getInt_ComplainID() {
		return int_ComplainID;
	}
	public void setInt_ComplainID(Integer int_ComplainID) {
		this.int_ComplainID = int_ComplainID;
	}
	
	private char ch_Complain;
	public char getCh_Complain() {
		return ch_Complain;
	}
	public void setCh_Complain(char ch_Complain) {
		this.ch_Complain = ch_Complain;
	}
	
	
	public void setStr_UserName(String str_UserName) {
		this.str_UserName = str_UserName;
	}
	private String str_UserName;
	public String getStr_UserName() {
		return str_UserName;
	}
	private String str_ComplainType;

	public String getStr_ComplainType() {
		return str_ComplainType;
	}
	public void setStr_ComplainType(String str_ComplainType) {
		this.str_ComplainType = str_ComplainType;
	}
	private String str_Description;

	public String getStr_Description() {
		return str_Description;
	}
	public void setStr_Description(String str_Description) {
		this.str_Description = str_Description;
	}
	
	
	private String str_VendorType;
	
	public String getStr_VendorType() {
		return str_VendorType;
	}
	public void setStr_VendorType(String str_VendorType) {
		this.str_VendorType = str_VendorType;
	}
	
	private String str_VenderName;
	public String getStr_VenderName() {
		return str_VenderName;
	}
	public void setStr_VenderName(String str_VenderName) {
		this.str_VenderName = str_VenderName;
	}
	private List<String> str_VendorTypes;
    public List<String> getStr_VendorTypes() {
    	str_VendorTypes = new ArrayList<String>();
		str_VendorTypes.addAll(getComplainService().vendorList());
		System.out.println(str_VendorTypes);
		return str_VendorTypes;
	}
	public void setStr_VendorTypes(List<String> str_VendorTypes) {
		this.str_VendorTypes = str_VendorTypes;
	} 
	private List<String> str_VendorNames;
	public List<String> getStr_VendorNames() {
		if ((str_VendorType != null)) {

			

			return nameByType;
		} else
			return new ArrayList<String>();
	}
	
	public void setStr_VendorNames(List<String> str_VendorNames) {
		this.str_VendorNames = str_VendorNames;
	}
	private List<String> nameByType;
	public List<String> getNameByType() {
		return nameByType;
	}
	public void setNameByType(List<String> nameByType) {
		this.nameByType = nameByType;
	}
	public List<String> vendorChangeListener(ValueChangeEvent event) {
		str_VendorType = (String) event.getNewValue();
		nameByType = new ArrayList<String>();
		nameByType.addAll(getComplainService().vendorListName(str_VendorType));

		return nameByType;
	
		

	}
	public String addComplain()
	{  try{
		Complain cmp=new Complain();
		cmp.setStr_UserName(getStr_UserName());
		cmp.setCh_Complain(getCh_Complain());
		cmp.setStr_ComplainType(getStr_ComplainType());
		cmp.setStr_Description(getStr_Description());
		cmp.setStr_File(path);
		cmp.setStr_VendorType(str_VendorType);
		System.out.println(str_VendorType);
		cmp.setStr_VenderName(str_VenderName);
		System.out.println(str_VenderName);
		getComplainService().addComplain(cmp);
		
		return "ComplainView.xhtml";
	}
	catch(DataAccessException e)
	{e.printStackTrace();
		
	}
	return ERROR;
		
	}
   
    private List<Complain> ListComplain;
	public List<Complain> getListComplain() {
		ListComplain= new ArrayList<Complain>();
		ListComplain.addAll(getComplainService().listComplain());
		return ListComplain;
	}
	public void setListComplain(List<Complain> listComplain) {
		ListComplain = listComplain;
	}
	public void reset() 
	{
       
        
    }
	
			private String str_File;
			
			
			
			 public String getStr_File() {
				return str_File;
			}
			public void setStr_File(String str_File) {
				this.str_File = str_File;
			}
			
			
			
		  
	        public Integer getFlatID() {
				return FlatID;
			}
			public void setFlatID(Integer flatID) {
				FlatID = flatID;
			}
			public String getFlat() {
				return Flat;
			}
			public void setFlat(String flat) {
				Flat = flat;
			}
			public String getBlock() {
				return Block;
			}
			public void setBlock(String block) {
				Block = block;
			}
			public String getBeHalfOf() {
				return BeHalfOf;
			}
			public void setBeHalfOf(String beHalfOf) {
				BeHalfOf = beHalfOf;
			}
			private Integer FlatID;
			private String Flat;
			private String Block;
			private String BeHalfOf;
			private List<String> Blocks;
			public List<String> getBlocks() {
				return Blocks;
			}
			public void setBlocks(List<String> blocks) {
				Blocks = blocks;
			}
			public List<String> selectRadioButton(ValueChangeEvent event)
			{
				String select =( String )event.getNewValue();
                 System.out.println(select);
			    if(select.equals("Personal"))
			    {    Blocks = new ArrayList<String>();
	    		   Blocks.addAll(getComplainService().blockList());
	    		   System.out.println(Blocks);
			    	return Blocks;
			    }
			    else
			    {
			    	Blocks=new ArrayList<String>();
			    	return Blocks;
			    }
			      
			}
            private List<String> faltNoByBlock;
			public List<String> getFaltNoByBlock() {
				return faltNoByBlock;
			}
			public void setFaltNoByBlock(List<String> faltNoByBlock) {
				this.faltNoByBlock = faltNoByBlock;
			}
			public List<String> blockChangeListener(ValueChangeEvent event)
			{   Block=(String)event.getNewValue();
			     System.out.println(Block);
			        faltNoByBlock = new ArrayList<String>();
			       faltNoByBlock.addAll(getComplainService().faltListBlock(Block));

			        return faltNoByBlock;
		
			}
			
			private List<String> Flats;
			public List<String> getFlats() {
				if ((Block != null)) {

					return faltNoByBlock;
				} else
					return new ArrayList<String>();
				
			}
			public void setFlats(List<String> flats) {
				Flats = flats;
			}
			private List<String> renterByFlat;
			public List<String> getRenterByFlat() {
				return renterByFlat;
			}
			public void setRenterByFlat(List<String> renterByFlat) {
				this.renterByFlat = renterByFlat;
			}
			public List<String> flatChangeListener(ValueChangeEvent event) {
				Flat= (String) event.getNewValue();
				System.out.println(Flat);
				renterByFlat = new ArrayList<String>();
				renterByFlat.addAll(getComplainService().renterListFlat(Flat));

				return renterByFlat;
			}
			private List<String> BeHalfOfs;
			public List<String> getBeHalfOfs() {
				if ((Flat!= null)) {

					return renterByFlat;
				} else
					return new ArrayList<String>();
			}
			public void setBeHalfOfs(List<String> beHalfOfs) {
				BeHalfOfs = beHalfOfs;
			}
			//FILE UPLOAD CONCEPT
		

			private Part part;
			private String statusMessage;
		    private String path;
			public String uploadFile() throws IOException {
System.out.println("fjkjkfdjkkjfjkfkj");
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
				 String fileName = fmt.format(new Date()) +getFileName(part).substring(getFileName(part).lastIndexOf('.'));
			
				System.out.println(fileName+"dfjkjkfjkfd");
		 
				
				String basePath = "E:" + File.separator + "sites" + File.separator+"AppOwnner"+File.separator+"WebContent"+File.separator+"images"+File.separator;
				System.out.println(basePath);
				File outputFilePath = new File(basePath+fileName);
				
				System.out.println(path+"path");
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
					path="E://sites/AppOwnner/WebContent/images"+File.separator+fileName;
				
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

			public String getPath() {
				System.out.println(path+"path1");
			//	path=user.getVar_ImageName1();
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

			private Complain cmp;
			 public Complain getCmp() {
				return cmp;
			}
			public void setCmp(Complain cmp) {
				this.cmp = cmp;
			}
			
			
			public void getComplain()
			{
			cmp=getComplainService().getComplain(int_ComplainID);
				
			}
			
			
			public String saveUser( ) {
				 
				//System.out.println(emp.getEmpId());
				
					getComplainService().update(cmp);
					
				
				
				
				return "ComplainView.xhtml";
			}
			
			
			
}			

	 

