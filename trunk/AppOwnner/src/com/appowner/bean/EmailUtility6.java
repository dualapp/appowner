package com.appowner.bean;
import java.util.Date;
import java.util.ListIterator;
import java.util.Properties;

import javax.faces.bean.ManagedProperty;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.appowner.model.DueTemplate;
;
 
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class EmailUtility6 {
   

	
	public static void sendEmail(String host, String port,
            final String userName, final String password,String recipient, 
            String subject,String content,String Organization) throws AddressException,
            MessagingException {
System.out.println( Organization+"''''''''''''';';';';';';';';';';';';kjkjkjkjkjkjkjkjk");
System.out.println(subject+"fgfgkfgk");
System.out.println(content+"ddsdd");
System.out.println(recipient+"dkkdffkfdk");
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(recipient));
        msg.setSubject(Organization);
        msg.setSentDate(new Date());
       
      
		
		msg.setContent("<html>\n" +
        		
        		
                        "<fieldset style="+"width:70%"+" "+"height:80%" +">"+
                        "<table width="+450+" height="+20+" bgcolor="+":#FFCC66"+">"+
        		         "<tr>"+
                       "<td style="+"width:350px;"+"color:#333300;"+" margin-left:15%;"+">"+""
 		          + "<h4> &#150;     &#150;    &#150;"+"This is inform you that ad posting "
 		  		 + " "+""+Organization+" is approved"+"</h4>"+"</td>" +"</tr>"+
 		  		"<tr>"+
 		  		"<td style="+"width:350px;"+"color:#333300;"+" margin-left:15%;"+">"+""
		          + "<h4> &#150;     &#150;    &#150;"+"To view this ad please click this below link"
		  		 + " </td>" +"</tr>"+
		          
                  "<tr>"+
	              "<td >"+
                    "<input type="+"button"+"  value="+"ViewYourAd"+" style="+"width:25%;"+""
           		    + "margin-left:40%;"+"color"+":#FF4500"+""
           		  		+ " a href="+"www.appowners.com"+">" +"</input>"
	               + " </td>" +"</tr>"+
           
           "<tr>"+
	             "<td style="+"width:350px;"+"color:#333300;"+" margin-left:15%;"+">"+""
                  + "<h4> &#150;     &#150;    &#150;"+"Note:This is auto generated so please not reply this email"
	                  + " </td>" +"</tr>"+
        		          "</table>"+
                        "<hr/>"+
                        

        	     "<tbody>"+"<table>"+
        	    
        		"</body>\n" +
        		"</fieldset>"+
        		"</html>", "text/html");
        // sends the e-mail
		
        Transport.send(msg);
 
 
    }

	
		
	}


