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
public class EmailUtility1 {
    public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message,String Organization,String Block,String Flat,String Title,String Category,String OpenDate) throws AddressException,
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
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
        msg.setContent("<html>\n" +"<fieldset style="+"width:40%"+">"+
                       "<legend style="+"background-color:#40E0D0; color:#fff;"+" align="+"left"+">"+"Service Request"+"</legend>"+
                        "<table width="+600+" bgcolor="+"#40E0D0"+">"+
                        "<tr>"+"<td width="+30+">"+"Dear Mr/Mrs/Ms. :"+"</td>"+"<td width="+70+">"+userName+"</td>"+"</tr>"+
                       
        		         "<tr>"+"<td width="+30+">"+"A new Service has been raised on :"+"</td>"+"<td width="+70+">"+OpenDate+"</tr>"+
        		         "<tr>"+"<td>"+"<h2>"+"Details are:- "+"</h2>"+"<br/>"+ "<tr>"+"<td width="+30+">"+"Title:"+"</td>"+"<td width="+70+">"+Title+"</td>"+"</tr>"+
        		         "<tr>"+"<td width="+30+">"+"Organization:"+"</td>"+"<td width="+70+">"+Organization+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td width="+30+">"+"Block:"+"</td>"+"<td width="+70+">"+Block+"</td>"+
                        "</tr>"+"<tr>"+"<td width="+30+">"+"Flat Name:"+"</td>"+"<td width="+70+">"+Flat+"</td>"+"</tr>"+
                        "<tr>"+"<td width="+30+">"+"Service Category:"+"</td>"+"<td width="+70+">"+Category+"</td>"+"</tr>"+
                        "</table>"+
        		"</fieldset>"+
        		"</html>", "text/html");
        // sends the e-mail
        Transport.send(msg);
 
    }
}
