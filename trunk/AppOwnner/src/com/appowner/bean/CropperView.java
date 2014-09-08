package com.appowner.bean;

import java.io.File;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.model.CroppedImage;
 
@ManagedBean
public class CropperView {
     
    private CroppedImage croppedImage;
     
    private String newImageName;
    private String newFileName;
    
 
    public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public CroppedImage getCroppedImage() {
        return croppedImage;
    }
 
    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }
 
    public void crop() {
        if(croppedImage == null) {
        	System.out.println("//////////////////////");
            return;
        }
         System.out.println("..................");
        setNewImageName(getRandomImageName());
        System.out.println(getRandomImageName());
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
         newFileName = servletContext.getRealPath("") + File.separator + "images" +
                    File.separator + "saphi" + File.separator + "crop" + File.separator + getNewImageName() + ".jpg";
         System.out.println(newFileName);
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(croppedImage.getBytes(), 0, croppedImage.getBytes().length);
            System.out.println("iouoiouiuiuiuiuiuoiuio");
            imageOutput.close();
        } catch (Exception e) {
        	System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cropping failed."));
        }
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Cropping finished."));
    }
     
    private String getRandomImageName() {
        int i = (int) (Math.random() * 100000);
         
        return String.valueOf(i);
    }
     
    public String getNewImageName() {
        return newImageName;
    }
 
    public void setNewImageName(String newImageName) {
        this.newImageName = newImageName;
    }
}