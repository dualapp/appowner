<%@page import="com.appowner.bean.InvoiceBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.appowner.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send an e-mail</title>
</head>
<body>
 <%System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");%>
<div style="display:none;">
<iframe id="ponyo_frame" name="ponyo_frame"></iframe>

    <form id="ponyo_form" action="../../srv2" method="post">
    
        <table border="0" width="35%" align="center">
            <caption><h2>Send New E-mail</h2></caption>
            <tr>
                <td width="50%">Recipient address </td>
                <td><input type="text" name="recipient" size="50" value="<%=InvoiceBean.getMailid()%>"/></td>
            </tr>
<%System.out.println("zzzzzzzzggggggggggggzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");%>
            <tr>
                <td>Subject </td>
                <td><input type="text" name="subject" size="50" value="<%=InvoiceBean.getSubject()%>"/></td>
            </tr>
            <tr>
                <td>Content </td>
                <td><textarea rows="10" cols="39" name="content" id='test'><%=InvoiceBean.getContent()%></textarea> </td>
            </tr>
             <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="invoice" id='test'><%=InvoiceBean.getInvoiceNo()%></textarea> </td>
            </tr>
            <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="date" id='test'><%=InvoiceBean.getDate()%></textarea> </td>
            </tr>
            <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="date1" id='test'><%=InvoiceBean.getDate1()%></textarea> </td>
            </tr>
            <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="amount" id='test'><%=InvoiceBean.getAmount()%></textarea> </td>
            </tr>
            <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="tax" id='test'><%=InvoiceBean.getTax()%></textarea> </td>
            </tr>
              <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="Due" id='test'><%=InvoiceBean.getDue()%></textarea> </td>
            </tr>
             <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="organisation" id='test'><%=InvoiceBean.getOrganisation()%></textarea> </td>
            </tr>
             <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="organisation1" id='test'><%=InvoiceBean.getTransaction1()%></textarea> </td>
            </tr>
              <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="date3" id='test'><%=InvoiceBean.getDate3()%></textarea> </td>
            </tr>
              <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="block" id='test'><%=InvoiceBean.getBlock()%></textarea> </td>
            </tr>
              <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="apartmentNo" id='test'><%=InvoiceBean.getApartmentNo()%></textarea> </td>
            </tr>
              <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="period" id='test'><%=InvoiceBean.getBillperiod()%></textarea> </td>
            </tr>
              <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="year" id='test'><%=InvoiceBean.getYear()%></textarea> </td>
            </tr>
              <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="dues" id='test'><%=InvoiceBean.getDues()%></textarea> </td>
            </tr>
             <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="taxName" id='test'><%=InvoiceBean.getTaxname()%></textarea> </td>
            </tr>
              <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="subtotal" id='test'><%=InvoiceBean.getSubtotal()%></textarea> </td>
            </tr>
             <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="taxAmount" id='test'><%=InvoiceBean.getTax1()%></textarea> </td>
            </tr>
            <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="notes" id='test'><%=InvoiceBean.getNotes()%></textarea> </td>
            </tr>
            <tr>
                <td>Type</td>
                <td><textarea rows="10" cols="39" name="userName" id='test'><%=InvoiceBean.getUsername()%></textarea> </td>
            </tr>
            <%System.out.println("zzzzzzzzggggggggggggzzzzzzzzzzzzzjjjjjjzzzzzzzzzzzzzzzzzzz");%>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Send"/></td>
            </tr>
        </table>
         
    </form>
    <script>
document.getElementById("ponyo_form").submit();
</script>
</div>
    
    
</body>
</html>
