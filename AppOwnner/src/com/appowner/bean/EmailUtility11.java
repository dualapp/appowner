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
 
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class EmailUtility11 {
    public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message,String title) throws AddressException,
            MessagingException {
 
        // sets SMTP serve properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
         System.out.println(toAddress+"priya");
         System.out.println(subject);
         System.out.println(title);
       String  url="http://localhost:4090/AppOwnner/layout.xhtml"
;         
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        
        msg.setFrom(new InternetAddress(userName));
        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(toAddress));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
      msg.setContent("<html>\n" +
        		
        		
"<fieldset style="+"width:40%"+">"+
      "<legend style="+"background-color:#40E0D0; color:#fff;"+" align="+"left"+">"+"Notice"+"</legend>"+
       "<table width="+600+" bgcolor="+"#40E0D0"+">"+
       "<tr>"+"<td width="+30+">"+
 		           "<h4> &#150;     &#150;    &#150;"+"A new notice"
 		  		 + " "+" "+title+" "+"has been posted."+"</h4>"+"</td>" +"</tr>"+
 		  		"<tr>"+"<td width="+30+">"
		          + "<h4> &#150;     &#150;    &#150;"+"To view this notice please click this below link:"
		  		 + " </td>" +"</tr>"+
		          
                  "<tr>"+
                  "<td width="+30+">"+
                    
           		  		 "<a href="+url+">"+"ViewNotice"+"</a>" +
	                " </td>" +"</tr>"+
           
          
        		          "</table>"+
                      
                        

        	   
        	    
        		
        		"</fieldset>"+
        		"</html>", "text/html");
        // sends the e-mail
        Transport.send(msg);
 
    }
}
