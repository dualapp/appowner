package com.appowner.bean;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            String subject, String message,String invoice,String date,String date1,String amount,String tax,String due,String organisation, String transaction,String date3,String block,String apartmentNo,String billperiod,String year,String dues,String taxName,String subTotal,String taxAmount,String notes,String username) throws AddressException,
            MessagingException, ParseException {
 
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
     
       System.out.println(notes+"fdkjfdjkfgjkfg");
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
    	  String str3="";
    	  System.out.println("jfcfkjdfdkjfdjkfd");
    	  System.out.println(amount+"dfjfdjkfdkj");
    	  String[] strArray = amount.split(",");
    	  List<String> subamount=new ArrayList<String>();
         String subamount1="";
          for (String str2: strArray) 
          {  
        	  
        	  subamount.add(str2) ;}
        	System.out.println(subamount+"jkffgfgvjgfj"); 
          	 System.out.println(subamount.get(0));
          	 subamount1=subamount.get(0);
          	 System.out.println(subamount.remove(0));
          System.out.println(subamount+"dsjkjsjdjkfdfdj");
          StringBuilder out = new StringBuilder();
          for (Object o1 : subamount)
          {
            out.append(o1.toString());
            out.append(",");
          }
          System.out.println(out+"cjkjkkjcxcx");
          amount=out.toString();
          System.out.println(amount+"sdjsdjhdsj");
          str3=str3+subamount1;
          System.out.println(str3+"dsdshjdsjhdsdsj");
        
    	 str=str+"<tr style="+"line-height:25px;"+">"+"<td style="+"padding-left:5px;width:440px;"+">"+dues+
  	    "</td>"+
  	  "<td align="+"right"+"" +"style="+"width:250px;"+">"+"</td>"+
  	"<td align="+"right"+"" +"style="+"width:250px;"+">"+str3+"</td>"+
  	  
      	
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
      
    ListIterator list2=InvoiceBean.getTransaction1().listIterator();
      System.out.println(tax+"fghjjggjf");
	    System.out.println(taxAmount+"fdklfkgk");
	  
       while(list2.hasNext())
       { 
       Object o=list2.next();
	   DueTemplate template=(DueTemplate)o;
	   taxName=template.getStr_TaxTemplate();
		String[] strArray2 = tax.split(",");  
	  
	    List<String> taxpercentage=new ArrayList<String>();
	 	String taxpercentage1="";
      
	   	for(String str2:strArray2)
	   	{   
	   		taxpercentage.add(str2);
	   		
	   	}
	   	taxpercentage1=taxpercentage.get(0);
     	 System.out.println(taxpercentage.remove(0));
     	 StringBuilder out = new StringBuilder();
         for (Object o1 : taxpercentage)
         {
           out.append(o1.toString());
           out.append(",");
         }
         System.out.println(out+"cjkjkkjcxcx");
         tax=out.toString(); 
         System.out.println(out+"fvfjgfjg");
         String[] strArray3 = taxAmount.split(",");  
	   	List<String> taxAmount2=new ArrayList<String>();
        String taxAmount1="";
	   	for(String str2:strArray3)
	   	{   
	   		taxAmount2.add(str2);
	   		
	   	}
	   	taxAmount1=taxAmount2.get(0);
	   	System.out.println(taxAmount2.remove(0));
	    StringBuilder out2 = new StringBuilder();
        for (Object o1 : taxAmount2)
        {
          out2.append(o1.toString());
          out2.append(",");
        }
        System.out.println(out2+"cjkjkkjcxcx");
        taxAmount=out2.toString(); 
        System.out.println(taxAmount+"fvfjgfjg");
        str1=str1+"<tr style="+"line-height:25px;"+">"+
       	     "<td align="+"right"+"" +"style="+"padding-right:5px;width:300px;"+">"+"</td>"+"<td align="+"right"+"" +"style="+"width:200px;"+">"+taxName+"&nbsp;&nbsp;"+"("+taxpercentage1+"%"+")"+"</td>"+"<td align="+"right"+"" +"style="+"width:250px;"+">"+taxAmount1+"</td>"+
       	     "</tr>";
        
	System.out.println(str1+"dfjkkjfgjkgfkjgfgfkj");
	   
	     
        
       }
       System.out.println(str1+"dfjkkjfgjkgfkjgfgfkj");
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
        		        "<td>"+"<font size="+3+">"+"Date:"+" "+date+" "+" "+"(Pay Invoice by"+" "+date1+")"+"</font>"+"</td>"+
        		        "</tr>"+"<tr>"+
        		        "<td>"+"<font size="+3+" color="+"#FFA07A"+">"+"Rs."+due+"</td>"+
                        "</tr>"+
                        "</table>"+
                        "<h1 style="+"text-align:center;"+">"+organisation+"</h1>"+
                        "<hr/>"+
                        "<table width="+600+" bgcolor="+"#FFFFFF"+">"+
       		         "<tr>"+
                       "<td>"+"<font size="+3+" color="+"#000000"+">"+"Invoice To:"+" "+username+"</td>"+
       		       
       		      
       		        "<td colspan="+3+">"+"<font size="+3+" color="+"#000000"+">"+"Bill Period:"+billperiod+""+"-"+""+year+""+"</td>"+
                       "</tr>"+
                       "<tr>"+
                       "<td>"+"<font size="+3+" color="+"#000000"+">"+"Block No:"+" "+block+"</td>"+
                       "</tr>"+
                       "<tr>"+
                       "<td>"+"<font size="+3+" color="+"#000000"+">"+"Flat No:"+" "+apartmentNo+"</td>"+
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
        	    
        	     "<tr>"+str1+
        	  "</tr>"+
        	   
        	    "<tr>"+
        	    "<td align="+"right"+"" +"style="+"width:200px;"+">"+"</td>"+
             "<td style="+"padding-left:5px;width:440px;line-height:20px;color:#E17009;" +"align="+"right"+">"+"Total Due"+"</td>"+"<td align="+"right"+"" +"style="+"width:250px;color:#E17009;"+">"+due+"</td>"+
        	  "</tr>"+
             
        	     "<tbody>"+"</table>"+"<hr/>"+"<table>"+"<tr>"+"<td>"+ "<strong>"+"Notes"+"</strong>"+"</td>"+
             	  "</tr>"+ "<tr>"+"<td>"+ "<strong>"+notes+"</strong>"+"</td>"+
               	  "</tr>"+"</table>"+
        	    
        		"</body>\n" +
        		
        		"</fieldset>"+
        		"</html>", "text/html");
        // sends the e-mail
		
        Transport.send(msg);
 
 
    }
}
