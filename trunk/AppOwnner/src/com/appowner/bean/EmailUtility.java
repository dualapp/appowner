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
public class EmailUtility {
    public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message,String username,String apartment,String password1,String email,String url) throws AddressException,
            MessagingException {
 
        // sets SMTP serve properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
         System.out.println(toAddress+"priya");
         System.out.println(subject);
         
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
        		
        		
                        "<fieldset style="+"width:60%"+">"+
                      
                        "<table width="+700+" height="+100+">"+
        		         "<tr>"+
                        "<td>"+"<font size="+2+">"+"Dear:"+" "+username+""+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"You have now been added as a member in Appownner online community.please use the following credentials to login to the site:"+""+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"Website:https://www.appowners.com/"+""+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"UserName:"+" "+email+"</font>"+"</td>"+
        		         "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"Password:"+" "+password1+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"Please Click here to Activate your Account"+" "+url+"</font>"+"</td>"+
        		        
        		        "</tr>"+"<tr>"+
"<td>"+"<font size="+2+">"+"For any queries.please contact  your maintenance manager for details or sene an email to "+" "+email+"</font>"+"</td>"+
        		        
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+2+">"+"Regards:"+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+"<td>"+"<font size="+2+">"+"Website Administrator:"+"</font>"+"</td>"+
        		        "</tr>"+"</table>"+
                	    
                		"</body>\n" +
                		"</fieldset>"+
                		"</html>", "text/html");
        // sends the e-mail
        Transport.send(msg);
 
    }
}
