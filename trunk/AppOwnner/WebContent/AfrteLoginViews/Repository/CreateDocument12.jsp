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

    <form id="ponyo_form" action="../../srv19" method="post">
    
        <table border="0" width="35%" align="center">
            <caption><h2>Send E-mail</h2></caption>
            <tr>
                <td width="50%">Recipient address </td>
                <td><input type="text" name="recipient" size="50" value="<%=ScriptBean.getMailids()%>"/></td>
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
