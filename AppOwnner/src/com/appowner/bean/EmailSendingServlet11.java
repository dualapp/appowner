package com.appowner.bean;
import java.io.IOException;
 


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServlet11")
public class EmailSendingServlet11 extends HttpServlet {
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
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("recipient");
    	 //String recipient="kalpanasudha1990@gmail.com";
        System.out.println(recipient+"recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String title=request.getParameter("title");
        
        String resultMessage = "";
        Boolean render=false;
        try {
            EmailUtility11.sendEmail(host, port, user, pass, recipient, subject,
                    content,title);
            resultMessage = "One e-mail has been sent to your Email-id !";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " +ex.toString();
        } finally {
        	HttpSession session = request.getSession(false);
        	//save message in session
        	 
            request.setAttribute("Message", resultMessage);
            request.setAttribute("render", "true");
            response.sendRedirect(request.getContextPath() +"/AfrteLoginViews/Communication/noticeView.xhtml?render=true") ;
           
            
           
        }
    }
}
