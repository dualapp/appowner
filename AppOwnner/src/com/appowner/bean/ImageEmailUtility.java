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
public class ImageEmailUtility {
    public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String username, String message) throws AddressException,
            MessagingException {
 
        // sets SMTP serve properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
         System.out.println(toAddress+"priya");
        
         
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
        
        msg.setSentDate(new Date());
        msg.setText(message);
      msg.setContent("<html>\n" +
        		
        		
                        "<fieldset style="+"width:60%"+">"+
                      
                        "<table width="+700+" height="+100+">"+
        		         "<tr>"+
                        "<td>"+"<font size="+2+">"+"Hi subcriber:"+" "+username+""+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"As per the website policy we have found image uploaded by you not match the policy criteria.Hence we have deleted and uploaded Default image."+""+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"Requires you to upload Genuine Image"+""+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"Thanks:"+"</font>"+"</td>"+
        		         "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"From"+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+message+"</font>"+"</td>"+
        		        
        		        
        		        "</tr>"+"</table>"+
                	    
                		"</body>\n" +
                		"</fieldset>"+
                		"</html>", "text/html");
        // sends the e-mail
        Transport.send(msg);
 
    }
}
