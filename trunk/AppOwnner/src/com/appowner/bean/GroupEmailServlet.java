package com.appowner.bean;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GroupEmailServlet")
public class GroupEmailServlet extends HttpServlet {
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
        
        
        String subject = request.getParameter("subject");
        String recipient = request.getParameter("recipient");
        String apartname=request.getParameter("apartname");
        String BlockName=request.getParameter("BlockName");
        String  UserNames=request.getParameter("UserNames");
        System.out.println(UserNames+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        String  message=request.getParameter("message");
         String date=request.getParameter("date");
       
         Boolean render=false;
        
         request.setAttribute("render", "false");
        String resultMessage = "";
 
        try {
        	GroupEmailUtility.sendEmail(host, port, user, pass, subject,
        			recipient, apartname,  BlockName, UserNames,message, date);
           
       
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
        	request.setAttribute("render1", "true");
            request.setAttribute("Message", resultMessage);
            response.sendRedirect(request.getContextPath() +"/AfrteLoginViews/Repository/View-SubGroup.xhtml?render=true") ;
        }
    }
}
