<%@page import="com.appowner.bean.ScriptBean"%>
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

    <form id="ponyo_form" action="../../srv20" method="post">
    
        <table border="0" width="35%" align="center">
            <caption><h2>Send New E-mail</h2></caption>
            <tr>
                <td width="50%">Recipient address </td>
                <td><input type="text" name="recipient" size="50" value="<%=ScriptBean.getRecipient()%>"/></td>
            </tr>

            
            <tr>
                <td>Message </td>
                <td><textarea rows="10" cols="39" name="content" id='test'><%=ScriptBean.getContent()%></textarea> </td>
                
            </tr>
             <tr>
                <td>Apartment Name </td>
                <td><textarea rows="10" cols="39" name="apartname" id='test'><%=ScriptBean.getAprtmentname()%></textarea> </td>
                
            </tr>
             <tr>
                <td>Block Name </td>
                <td><textarea rows="10" cols="39" name="BlockName" id='test'><%=ScriptBean.getBlockname()%></textarea> </td>
                
            </tr>
             <tr>
                <td>User Name </td>
                <td><textarea rows="10" cols="39" name="UserNames" id='test'><%=ScriptBean.getUsrname()%></textarea> </td>
                
            </tr>
            
             <tr>
                <td>Message  </td>
                <td><textarea rows="10" cols="39" name="message" id='test'><%=ScriptBean.getStr_message()%></textarea> </td>
                
            </tr>
            <tr>
                <td>Date  </td>
                <td><textarea rows="10" cols="39" name="date" id='test'><%=ScriptBean.getStr_date()%></textarea> </td>
                
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
