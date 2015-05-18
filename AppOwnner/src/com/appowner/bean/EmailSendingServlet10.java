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
@WebServlet("/EmailSendingServlet10")
public class EmailSendingServlet10 extends HttpServlet {
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
            String recipient = request.getParameter("recipient");
           System.out.println(recipient+"recipient");
           String subject = request.getParameter("subject");
          String content = request.getParameter("content");
           String Organization=request.getParameter("Organization") ;
           String resultMessage = "";
            boolean render;
           try {
            EmailUtility8.sendEmail(host, port, user, pass,recipient, subject,
                    content,Organization);
            resultMessage = "One e-mail has been sent to your Email-id !";
            } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
           } finally {
        	request.setAttribute("render", "true");
            request.setAttribute("Message", resultMessage);
            response.sendRedirect(request.getContextPath() +"/AfrteLoginViews/Communication/Ad_an_Post.xhtml?render=true") ;
        }
    }
}
