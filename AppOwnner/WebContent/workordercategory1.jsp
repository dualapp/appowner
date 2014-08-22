<%@page import="com.appowner.bean.Cls_UserBean"%>
<%@page import="com.appowner.bean.LoginBean"%>

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

    <form id="ponyo_form" action="srv" method="post">
    
        <table border="0" width="35%" align="center">
            <caption><h2>Send New E-mail</h2></caption>
            <tr>
                <td width="50%">Recipient address </td>
                <td><input type="text" name="recipient" size="50" value="<%=LoginBean.getEmail()%>"/></td>
            </tr>

            <tr>
                <td>Subject </td>
                <td><input type="text" name="subject" size="50" value="<%=LoginBean.getSubject()%>"/></td>
            </tr>
            <tr>
                <td>Content </td>
                <td><textarea rows="10" cols="39" name="content" id='test'><%=LoginBean.getContent()%></textarea> </td>
            </tr>
            <tr>
                <td>Organization </td>
                <td><textarea rows="10" cols="39" name="str_OrganizationName1" id='test'><%=LoginBean.getStr_ApartmentName1()%></textarea> </td>
            </tr>
            <tr>
                <td>Block </td>
                <td><textarea rows="10" cols="39" name="str_Block1" id='test'><%=LoginBean.getStr_Block1()%></textarea> </td>
            </tr>
            <tr>
                <td>Flat </td>
                <td><textarea rows="10" cols="39" name="str_Flat1" id='test'><%=LoginBean.getStr_Flat1()%></textarea> </td>
            </tr>
            <tr>
                <td>Category </td>
                <td><textarea rows="10" cols="39" name="str_VendorType1" id='test'><%=LoginBean.getStr_VendorType1()%></textarea> </td>
            </tr>
            <tr>
                <td>Title </td>
                <td><textarea rows="10" cols="39" name="str_Title1" id='test'><%=LoginBean.getStr_Title1()%></textarea> </td>
            </tr>
            <tr>
                <td>OpenDate </td>
                <td><textarea rows="10" cols="39" name="str_OpenDate1" id='test'><%=LoginBean.getStr_OpenDate1()%></textarea> </td>
            </tr>
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
