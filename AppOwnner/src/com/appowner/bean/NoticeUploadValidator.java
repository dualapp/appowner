package com.appowner.bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
@FacesValidator("NoticeUploadValidator")
public class NoticeUploadValidator implements Validator {
	 public  static String filename;
		

		public static String getFilename() {
		return filename;
	}

	public static void setFilename(String filename) {
		NoticeUploadValidator.filename = filename;
	}

		@Override
		public void validate(FacesContext context, UIComponent uiComponent,
				Object value) throws ValidatorException {
	 
			Part part = (Part) value;
	 
			// 1. validate file name length
			String fileName = getFileName(part);
			filename=getFileName(part);
			System.out.println("----- validator fileName: " + fileName);
			if(fileName.length() == 0 ) {
				FacesMessage message = new FacesMessage("Error: File name is invalid !!");
				throw new ValidatorException(message);
			} else if (fileName.length() > 50) {
				FacesMessage message = new FacesMessage("Error: File name is too long !!");
				throw new ValidatorException(message);
			}
	 
			// 2. validate file type (only text files allowed)
			/* if (!"image/doc|docx|xls|xlsx|pdf".equals(part.getContentType())) {
				FacesMessage message = new FacesMessage("Error: File type is invalid !!");
				throw new ValidatorException(message);
			  }*/
			 switch (part.getContentType()) {
			  
	            case "application/doc":  
				 
	                     break;
	            case "application/docx":   
				 
	                     break;
	            case "application/xls":   
	            	 
	                     break;
	            case "application/xlsx":   
	           	 
	                break;
	            case "application/pdf":   
	           	 
	                break;
	            case "text/plain":
	                break;
	                case "application/msword":
	                	break;
	                case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
	                	break;
	                case "image/jpeg":  
	       			 
	                     break;
	            case "image/png":   
				 
	                     break;
	            case "image/bmp":   
	            	 
	                     break;
	            case "image/gif":   
	           	 
	                break;
	            case "image/jpg":   
	           	 
	                break;
	            case "image/PNG":   
	           	 
	                break;
	            case "image/JPEG":   
	              	 
	                break;
	            case "image/JPG":   
	             	 
	                break;
	            case "image/GIF":   
	           	 
	                break;
	                     
	            default: FacesMessage message = new FacesMessage("Error: File type is invalid !!");
				throw new ValidatorException(message);
	        } 
			 
	        
			// 3. validate file size (should not be greater than 512 bytes)
			if (part.getSize() >262144) {
				FacesMessage message = new FacesMessage("Error: File size is too big !!");
				throw new ValidatorException(message);
			}
		}
	 
		// Extract file name from content-disposition header of file part
		private String getFileName(Part part) {
			final String partHeader = part.getHeader("content-disposition");
			System.out.println("----- validator partHeader: " + partHeader);
			for (String content : part.getHeader("content-disposition").split(";")) {
				if (content.trim().startsWith("filename")) {
					return content.substring(content.indexOf('=') + 1).trim()
							.replace("\"", "");
				}
			}
			return "";
		}
	}