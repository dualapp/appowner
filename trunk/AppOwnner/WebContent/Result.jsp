<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body bgcolor="#33FF33">
    <center>
        <font size="6" color="green">Your account created successfully......</font><br><br>
        <h3><%=request.getAttribute("Message")%></h3><br><br>
        <font size="5"><a href="https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail" >Login to gmail.com</a><br><br>
	   		</font> 
        <font size="5"><a href="Addapprt.xhtml" >Click here to Login With AppOwner</a>
	   		</font> 
    </center>
</body>
</html>
