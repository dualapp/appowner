package com.appowner.bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
@FacesValidator("BulkUploadValidator")
public class BulkUploadValidator implements Validator {
	@Override
	public void validate(FacesContext context, UIComponent uiComponent,
			Object value) throws ValidatorException {
 
		Part part = (Part) value;
 if(part==null)
 {
	 FacesMessage message = new FacesMessage("File: not selected !!");
		throw new ValidatorException(message);
	 
 }
		// 1. validate file name length
		String fileName = getFileName(part);
		System.out.println("----- validator fileName: " + fileName);
		if(fileName.length() == 0 ) {
			FacesMessage message = new FacesMessage("Error: File name is invalid !!");
			throw new ValidatorException(message);
		} else if (fileName.length() > 50) {
			FacesMessage message = new FacesMessage("Error: File name is too long !!");
			throw new ValidatorException(message);
		}
 
		// 2. validate file type (only xls files allowed)
		if (!"application/kset".equals(part.getContentType())) {
			System.out.println(part.getContentType()+"content");
			FacesMessage message = new FacesMessage("Error: File type is invalid !!");
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
