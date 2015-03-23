package com.appowner.bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.appowner.dao.InvoiceDao;
import com.appowner.dao.InvoiceDaoImpl;
 
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class EmailUtility2 {
   

	
	public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message,String invoice,String date,String date1,String amount,String tax,String due,String organisation, String transaction,String date3,String block,String apartmentNo,String billperiod,String year,String dues,String taxName,String subTotal,String taxAmount) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
       System.out.println(invoice);
       System.out.println(date);
       System.out.println(date1); 
       System.out.println(amount+"fjdfdkjdf");
       System.out.println(tax+"klkdffd");
       System.out.println(taxAmount+"fdjfdjkfjkfdjkf");
       System.out.println(dues+"kldfklffd");
       System.out.println(transaction);
       System.out.println(taxName+"fdkjdkfkfdj");
      String str="";
      List<String> taxTemplate=new ArrayList<String>();
       ListIterator list=InvoiceBean.getTransaction1().listIterator();
       while(list.hasNext())
       {
    	   Object o=list.next();
    	   DueTemplate template=(DueTemplate)o;
    	  dues=template.getStr_DueTemplate();
    	  taxName=template.getStr_TaxTemplate();
    	  taxTemplate.add(taxName);
    	 
    	  System.out.println(dues+"kfdjkfjfdkdfkj");
    	 str=str+"<tr style="+"line-height:25px;"+">"+"<td style="+"padding-left:5px;width:440px;"+">"+dues+
  	    "</td>"+
  	  "<td align="+"right"+"" +"style="+"width:250px;"+">"+"</td>"+
  	    "<td align="+"right"+"" +"style="+"width:250px;"+">"+amount+
      	"</td>"+
      	
      	"<td align="+"right"+""+ "style="+"padding-right:5px;width:200px;"+">"+taxName+"</td>"+
      	 "</tr>"+
      	 "<tr>"+

        	    
        	    
        "<td colspan="+3+""+"style="+"border-bottom:1px solid #DADADA;"+">"+
        "</td>"+
        "</tr>"+"</td>"+
 	    "</tr>";
      	    
      	
	     
       }
     
   	System.out.println(taxTemplate+"fdjkfdkjdfkjf");
   	
   
       String str1="";
      ListIterator list1=taxTemplate.listIterator();
       while(list1.hasNext())
       { 
	      taxName=(String) list1.next();
	    System.out.println(taxName+"dkjdjkkjdfjk");
	    System.out.println(tax+"fghjjggjf");
	    System.out.println(taxAmount+"fdklfkgk");
	    String[] strArray = tax.split(",");
	   System.out.println(strArray.length+"fdjkdfjkfj");
        for (String str2: strArray) 
        {  
            
        	String tax2=str2;
        	System.out.println(str2+"fklfgvkgf");
        
	
	     str1=str1+"<tr style="+"line-height:25px;"+">"+
        	     "<td align="+"right"+"" +"style="+"padding-right:5px;width:300px;"+">"+"</td>"+"<td align="+"right"+"" +"style="+"width:200px;"+">"+taxName+"&nbsp;&nbsp;"+"("+tax2+"%"+")"+"</td>"+"<td align="+"right"+"" +"style="+"width:250px;"+">"+taxAmount+"</td>"+
        	     "</tr>";
        }
       }
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
                      
                        "<table width="+700+" height="+100+" bgcolor="+"#CCEEFF"+">"+
        		         "<tr>"+
                        "<td>"+"<font size="+5+" color="+"#BC8F8F"+">"+"INVOICE NO:"+" "+invoice+""+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"Date"+" "+date+""+" "+"(Pay Invoice by"+" "+date1+")"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+3+" color="+"#FFA07A"+">"+"Rs."+due+"</td>"+
                        "</tr>"+
                        "</table>"+
                        "<h1 style="+"text-align:center;"+">"+organisation+"</h1>"+
                        "<hr/>"+
                        "<table width="+600+" bgcolor="+"#FFFFFF"+">"+
       		         "<tr>"+
                       "<td>"+"<font size="+3+" color="+"#000000"+">"+"Invoice To:"+" "+block+""+"-"+apartmentNo+""+"</td>"+
       		        "<td>"+
       		       
       		        "</td>"+
       		        "<td>"+
     		       
       		        "</td>"+
       		      
       		        "<td>"+"Bill Period:"+billperiod+""+"-"+""+year+""+"</td>"+
                       "</tr>"+
                       "</table>"+
        		"<body>\n" +
        		 "<table  cellpadding="+0+"" +"cellspacing="+0+"" +"style="+"width:598px;align:center;"+ "font-family:arial;"+"font-size:14px;"+"line-height:15px;border:1px solid #DADADA;"+">"+
        		
        	    "<tbody>"+
        	    "<tr>"+
        	    "<td style="+"width:250px;"+"height:20px;"+"background:#0E94F9;color:#fff;padding-left:5px;line-height:25px;"+">"+
        	    "<strong>"+"Item"+"</strong>"+
        	    "</td>"+
        	    "<td style="+"width:200px;height:20px;background:#0E94F9;color:#fff;padding-left:5px;line-height:25px;"+">"+
        	    "<strong>"+""+"</strong>"+
        	    "</td>"+
        	    "<td style="+"width:200px;background:#0E94F9;color:#fff;line-height:25px;"+" "+"align=+right+"+">"+
        	    "Amount"+
        	    "</td>"+
        	    "<td style="+"width:220px;background:#0E94F9;color:#fff;line-height:20px;padding-right:5px;"+" "+"align=+right+" +">"+
        	    "<strong>"+"Tax Applied"+"</strong>"+
        	    "<br/>"+
        	    "<span style="+"font-size:10px;"+">"+"(Tax calculated below)"+"</span>"+
        	    "</td>"+
        	    "</tr>"+
                 "<tr>"+
        	    
        	    
        	    "<td colspan="+4+""+"style="+"border-bottom:1px solid #DADADA;"+">"+
        	    "</td>"+
        	    "</tr>"+str+
        	     "<tr>"+
        	     "<td align="+"right"+"" +"style="+"width:200px;"+">"+"</td>"+
        	    "<td style="+"padding-left:5px;width:440px;line-height:20px;color:#E17009;" +"align="+"right"+">"+"SubTotal"+"</td>"+
        	    "<td align="+"right"+"" +"style="+"width:250px;color:#E17009;"+">"+subTotal+"</td>"+
        	    "</tr>"+
        	    "<tr>"+"</tr>"+str1+
        	     "<tr>"+
        	  "<tr>"+
        	    "</tr>"+
        	    "<tr>"+
        	    "<td align="+"right"+"" +"style="+"width:200px;"+">"+"</td>"+
             "<td style="+"padding-left:5px;width:440px;line-height:20px;color:#E17009;" +"align="+"right"+">"+"Total Due"+"</td>"+"<td align="+"right"+"" +"style="+"width:250px;color:#E17009;"+">"+due+"</td>"+
        	  "</tr>"+
        	     "<tbody>"+"</table>"+
        	    
        		"</body>\n" +
        		"</fieldset>"+
        		"</html>", "text/html");
        // sends the e-mail
		
        Transport.send(msg);
 
 
    }
}
