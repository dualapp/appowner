package com.appowner.bean;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
;
 
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class ContactEmailUtility {
   public static void sendEmail(String host, String port,
            final String userName,final String password,String recipient, 
           String content, String subject,String message,String PhoneNo ,String apratment ,String Usernames) throws AddressException,
            MessagingException {
System.out.println(PhoneNo+"''''''''''''';';';';';';';';';';';';kjkjkjkjkjkjkjkjk");
System.out.println(message+"fgfgkfgk");
System.out.println(apratment+"ddsdd");
System.out.println(recipient+"dkkdffkfdk");
System.out.println(Usernames+"dkkdffkfdk");
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
        msg.setSubject(apratment);
        msg.setSentDate(new Date());
       
      
		
		msg.setContent("<html>\n" +
        		
        		
                        "<fieldset style="+"width:70%"+" "+"height:80%" +">"+
                        "<table width="+450+" height="+20+" bgcolor="+":#FFCC66"+">"+
        		     
 	                     "<tr>"+
 		                     "<td style="+"width:0px;"+"color:#333300;"+" margin-left:60%;"+">"+""
		                      + "<h4>"
 		                     +"Mr/Mrs:-       &#150;      &#150;"
 		  		       + " "+" "+""+message+" "+"</h4>"+"</td>" +"</tr>"+
 		  		      "<tr>"+
                       "<td style="+"color:#333300;"+" margin-left:60%;"+">"+""
                       + "<h4> "
                       +"Name:-       &#150;      &#150;"
  		                + " "+" "+""+Usernames+" "+"</h4>"+"</td>" +"</tr>"+
		                      "<tr>"+
		               "<td style="+"width:px;"+"color:#333300;"+" margin-left:60%;"+">"+""
		           + "<h4>"+"ContactNo:-       &#150;      &#150;"
 		  		       + " "+" "+""+PhoneNo+" "+"</h4>"+"</td>" +"</tr>"+
                
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


