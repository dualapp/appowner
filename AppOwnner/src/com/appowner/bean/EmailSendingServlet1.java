package com.appowner.bean;
import java.io.IOException;
 

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author kalpana jena
 * 
 */
@WebServlet("/EmailSendingServlet1")
public class EmailSendingServlet1 extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String Organization=request.getParameter("str_OrganizationName1");
        String Block=request.getParameter("str_Block1");
        String Flat=request.getParameter("str_Flat1");
        String Title=request.getParameter("str_Title1");
        String Category=request.getParameter("str_VendorType1");
        String OpenDate=request.getParameter("str_OpenDate1");
        System.out.println(Flat);
        System.out.println(subject);
        
        
 
        String resultMessage = "";
 
        try {
            EmailUtility1.sendEmail(host, port, user, pass, recipient, subject,
                    content,Organization,Block,Flat,Title,Category,OpenDate);
            resultMessage = "Request Successfully Sent !";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
        	  
            request.setAttribute("Message", resultMessage);
            response.sendRedirect(request.getContextPath()+"/AfrteLoginViews/Facilities/servicerequest.xhtml?render2=true");
        }
    }
}
