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
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
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
        String username=request.getParameter("username");
        String apartment=request.getParameter("apartment");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String url=request.getParameter("url");
        String resultMessage = "";
        Boolean render=false;
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content,username,apartment,password,email,url);
            resultMessage = "One e-mail has been sent to your Email-id !";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            request.setAttribute("render", "true");
            getServletContext().getRequestDispatcher("/NewRegistration.xhtml").forward(
                    request, response);
        }
    }
}
