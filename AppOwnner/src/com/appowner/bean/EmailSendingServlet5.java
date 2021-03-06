package com.appowner.bean;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailSendingServlet5")
public class EmailSendingServlet5 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
        String str_UserName=request.getParameter("str_UserName");
        String str_password=request.getParameter("str_Password");
        String  str_firstName=request.getParameter("str_firstName");
       
         Boolean render=false;
        
         request.setAttribute("render", "false");
        String resultMessage = "";
 
        try {
            EmailUtility5.sendEmail(host, port, user, pass, recipient, subject,
                    content,str_UserName,str_password, str_firstName);
            resultMessage = "New Password sent to"+" "+ recipient+"!";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
        	request.setAttribute("render", "true");
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/forgotpassword.xhtml").forward(
                    request, response);
        }
    }
}
