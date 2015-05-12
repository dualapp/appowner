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
public class EmailUtility12 {
    public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        System.out.println(toAddress+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
 
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
        		
                		
                        "<fieldset style="+"width:70%"+" "+"height:80%" +"border-top:1px #2270ab solid"+">"+
                        "<legend style="+" align="+"left"+">"+"Latest Poll"+"</legend>"+
                        "<table width="+600+" bgcolor="+"white"+">"+
        		         "<tr>"+
                       "<td style="+"width:350px;"+"color:#333300;"+" margin-left:15%;"+">"+""
 		          + "<h4> &#150;     &#150;    &#150;"+" " + " "+""+message+""+"</h4>"+"</td>" +"</tr>"+
 		  		"<tr>"+
 		  		"<td style="+"width:350px;"+"color:#333300;"+" margin-left:15%;"+">"+""
		          + "<h4> &#150;     &#150;    &#150;"+"To Vote This Poll Please Click This Below Link:"
 + " </td>" +"</tr>"+
		          
                  "<tr>"+
                  "<td width="+30+">"+
                    
           		  		 "<a href="+"http://www.appowners.com/"+">"+"Vote Poll"+"</a>" +
	                " </td>" +"</tr>"+
           
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

