package com.appowner.bean;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ContactEmailSendingServlet")
public class ContactEmailSendingServlet extends HttpServlet 
{
    private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml fil
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
            {
         String recipient = request.getParameter("recipient");
    	 //String recipient="kalpanasudha1990@gmail.com";
        System.out.println(recipient+"recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
         String Message=request.getParameter("Message") ;
         String PhoneNo=request.getParameter("PhoneNo");
         String apratment=request.getParameter("apratment");
         String Usernames=request.getParameter("Usernames");
     
        String resultMessage = "";
          boolean render1;
        try {
        	ContactEmailUtility.sendEmail(host, port, user, pass,recipient, subject,
                    content,Message,PhoneNo,apratment,Usernames);
            resultMessage = "One e-mail has been sent to your Email-id !";
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } 
        finally {
            request.setAttribute("Message", resultMessage);
            response.sendRedirect(request.getContextPath() +"/AfrteLoginViews/Communication/SearchCategoryName.xhtml?render=true") ;
            }
    }
}
