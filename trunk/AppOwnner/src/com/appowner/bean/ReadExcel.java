package com.appowner.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.appowner.model.Employee;
import com.appowner.service.ApartmentDetailsService;
import com.appowner.util.Util;
@ManagedBean
@SessionScoped
public class ReadExcel {
	@ManagedProperty(value="#{ApartmentDetailsService}")
	private ApartmentDetailsService apartmentDetailsService;
	public ApartmentDetailsService getApartmentDetailsService() {
		return apartmentDetailsService;
	}
	public void setApartmentDetailsService(
			ApartmentDetailsService apartmentDetailsService) {
		this.apartmentDetailsService = apartmentDetailsService;
	}
public List<Employee> empList;

 
      
public List<Employee> getEmpList() {
	return empList;
}
public void setEmpList(List<Employee> empList) {
	this.empList = empList;
}

public   List<Employee> readExcel(String Appname,String filename) {
   try {
	   empList = new ArrayList<Employee>();
       FileInputStream file = new FileInputStream(new File("D:\\kalpanaproj\\AppOwnner\\WebContent\\images"+"\\"+Appname+"\\"+filename));

       // Getting the instance for XLS file
       HSSFWorkbook workbook = new HSSFWorkbook(file);

       // Get First sheet from the workbook
       HSSFSheet sheet = workbook.getSheetAt(0);

       ArrayList myList = new ArrayList();
       Employee employee;  

       // Iterate start from the first sheet of the uploaded excel file
       Iterator<Row> rowIterator = sheet.iterator();
      

       while (rowIterator.hasNext()) {
    	   employee = new Employee();
           Row row = rowIterator.next();

           /*     if (row.getRowNum() == 0) {
               continue;// skip to read the first row of file
           }*/

           // For each row, iterate through each coulumns
           Iterator<Cell> cellIterator = row.cellIterator();
           while (cellIterator.hasNext()) {
               Cell cell = cellIterator.next();
               if (cell.getColumnIndex() == 0 ) {
                   employee.setId((int)cell.getNumericCellValue());
                   empList.add(employee);
                   System.out.print(cell.getNumericCellValue() + "\t\t");
               }
               else if (cell.getColumnIndex() == 1 ) {
                   employee.setName(cell.getStringCellValue());
                   empList.add(employee);
                   System.out.print(cell.getStringCellValue() + "\t\t");
               }
               else if (cell.getColumnIndex() == 2 ) {
                   employee.setLocation(cell.getStringCellValue());
                   empList.add(employee);
                   System.out.print(cell.getStringCellValue() + "\t\t");
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
  
 
 
private static void persistToDB(List<Employee> employees) {
   /*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
   Session session = sessionFactory.openSession();
   */

       Configuration c = new Configuration();
       c.configure("/hibernate.cfg.xml");
       // SessionFactory holds cfg file properties like // driver props and
       // hibernate props and mapping file
       SessionFactory sf = c.buildSessionFactory();
       // create one session means Connection
       Session s = sf.openSession();
       // before starting save(),update(), delete() operation we need to
       // start TX // starting tx mean con.setAutoCommit(false);
       Transaction tx = s.beginTransaction();
       try {
       for (int i = 0; i < employees.size(); i++) {
           Employee emp = employees.get(i);
           s.save(emp);
       }
       tx.commit();
       s.close();

   } catch (Exception e) {
       tx.rollback();
   }
       
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
		//String fileName = getFileName(part);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName= fmt.format(new Date()) +getFileName(part).substring(getFileName(part).lastIndexOf('.'));
		System.out.println("***** fileName: " + fileName);
		String basePath = "D:" + File.separator + "kalpanaproj" + File.separator+"AppOwnner"+File.separator+"WebContent"+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
		String basePath1="D:\\kalpanaproj\\AppOwnner\\WebContent\\images"+"\\"+Util.getAppartmentName()+"\\";
		File outputFilePath = new File(basePath + fileName);
		
		 List<Employee>employees=readExcel(Util.getAppartmentName(),fileName);
		 System.out.println(employees);
		 getApartmentDetailsService().saveEmp(employees);
	       //persistToDB(employees);
	  
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

}