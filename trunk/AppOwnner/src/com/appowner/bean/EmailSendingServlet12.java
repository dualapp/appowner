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
@WebServlet("/EmailSendingServlet12")
public class EmailSendingServlet12 extends HttpServlet {
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
        
        String resultMessage = "";
 
        try {
            EmailUtility12.sendEmail(host, port, user, pass, recipient, subject,
                    content );
            resultMessage = "Mail Successfully Sent !";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
        	  
            request.setAttribute("Message", resultMessage);
            response.sendRedirect(request.getContextPath()+"/AfrteLoginViews/Communication/pools.xhtml?render2=true");
        }
    }
}
