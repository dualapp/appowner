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
@SuppressWarnings("serial")
@WebServlet("/EmailSendingServlet2")
public class EmailSendingServlet2 extends HttpServlet {
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
        System.out.println(pass);
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("recipient");
        System.out.println(recipient+"fdkjfdjkfdkjf");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String invoice =request.getParameter("invoice");
        String date=request.getParameter("date");
        String date1=request.getParameter("date1");
        String amount=request.getParameter("amount");
        String tax=request.getParameter("tax");
        String due=request.getParameter("Due");
        String organisation=request.getParameter("organisation");
        String transaction=request.getParameter("organisation1");
        String date3=request.getParameter("date3");
        String block=request.getParameter("block");
        String apartmentNo=request.getParameter("apartmentNo");
        String bill=request.getParameter("period");
        String year=request.getParameter("year");
        String dues=request.getParameter("dues");
        String taxName=request.getParameter("taxName");
        String subTotal=request.getParameter("subtotal");
        String taxAmount=request.getParameter("taxAmount");
        String resultMessage = "";
 
        try {
            EmailUtility2.sendEmail(host, port, user, pass, recipient, subject,
                    content,invoice,date,date1,amount,tax,due,organisation,transaction,date3,block,apartmentNo,bill,year,dues,taxName,subTotal,taxAmount);
            resultMessage = "One e-mail has been sent to your Email-id !";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/Result.jsp").forward(
                    request, response);
        }
    }
}
