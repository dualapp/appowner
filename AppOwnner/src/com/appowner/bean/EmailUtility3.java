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
public class EmailUtility3 {
   

	
	public static void sendEmail(String host, String port,
            final String userName, final String password, 
            String subject,String content,String Organization, String Block,  String usrName,String messages,String Dates) throws AddressException,
            MessagingException {
 System.out.println(usrName+"''''''''''''';';';';';';';';';';';';");
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
        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(subject));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
       
      
		
		msg.setContent("<html>\n" +
        		
        		
                        "<fieldset style="+"width:70%"+" "+"height:80%" +">"+
                        "<table width="+450+" height="+20+" bgcolor="+":#FFCC66"+">"+
        		         "<tr>"+
                        
                      "<td style="+"width:350px;"+"color:#333300;"+"  margin-left:15%;"+">"+"<h4> &#150;     &#150;    &#150;"+Organization+"   "+"     "+"at AppOwner"+"</h4>"+"</td>" +
                      "</tr>"+"<tr>"+
        		         "<td style="+"width:250px;"+" color:#FFA500;"+">"+"<h4>" +"&#150;     &#150;     &#150;"+"You have a new message from a "+"  "+Organization+" "+"Admin"+ "</h4>"+"</td>"+
        		         "</tr>"+
        		          "</table>"+
                        "<hr/>"+
                        "<table width="+450+" height="+10+" bgcolor="+"#FFA500"+">"+
                         "<tr>"+
             "<td  style="+"width:350px;"+"color:#333300;"+">"+"<h4>"+"&#150;    &#150; "+usrName+"   Of "+"  "+Block+"   "+"Send a Message"+" </h4>"+"</td>"+
                   "<tr>"+
                 "<td> "+"<h4>"+"&#150;    &#150;   "+messages+" </h4>"+"</td>"+
                  "<tr>"+
                    "<td>"+"<h4>"+"&#150;    &#150;   "+  Dates+" </h4>" +"</td>"+
                      "</tr>"+
               "</tr>"+
           
           
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
