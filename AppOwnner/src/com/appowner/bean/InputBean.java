package com.appowner.bean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
 


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import com.appowner.util.Util;
 
@ManagedBean(name = "inputBean")
@SessionScoped
public class InputBean implements Serializable {
 
	private static final long serialVersionUID = 9040359120893077422L;
 
	private Part part;
	private String statusMessage;
    private String path;
	public String uploadFile() throws IOException {
 
		// Extract file name from content-disposition header of file part
		String fileName = getFileName(part);
		System.out.println("***** fileName: " + fileName);
 
		//String basePath = "D:" + File.separator + "temp" + File.separator;
		//File outputFilePath = new File(basePath + fileName);
		String basePath = "D:" + File.separator + "kalpanaproj" + File.separator+"AppOwnner"+File.separator+"WebContent"+File.separator+"images"+File.separator+Util.getAppartmentName()+File.separator;
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
 
			statusMessage = "File upload successfull !!";
			path="/images"+ File.separator +Util.getAppartmentName()+File.separator+fileName;
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
}