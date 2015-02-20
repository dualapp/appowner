<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="display:none;">
<iframe id="ponyo_frame" name="ponyo_frame"></iframe>
 <form id="ponyo_form" action="/AppOwnner/layout.xhtml" method="post">
<%
  String activationkey1=request.getParameter("activationkey");
  Class.forName("com.mysql.jdbc.Driver");
  System.out.println("11111111111111111111111111111111111111111111111111111111111");
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_appowner","root","root");
  PreparedStatement statement = con.prepareStatement("update tb_user set int_activationbit=? where str_activationkey=?");
  statement.setInt(1, 1);
  statement.setString(2,activationkey1);
  int rs=statement.executeUpdate();
  if(rs!=1)
  {
	  
	  System.out.println("problem");
  }
  else
  {
	  System.out.println("updatedtttttttttttttttttttttttttttttttttt");
	  
	  System.out.println("updated");
  }
  
  //int k=stmt.executeUpdate(update tb_user set int_activationbit=1 where str_activationkey='activationkey1');
  System.out.println("1122222222222");
  //int k1=stmt.executeUpdate("update tb_user set int_activationbit=1 where str_activationkey=activationkey1");
 // ResultSet rs=stmt.executeQuery("select * from tb_user where str_activationkey= + activationkey1");
  //System.out.println("333333333333333333333333333333333333333333333333333333");
  
  //while(rs.next())
  //{
	//  System.out.println("11111111111111111111111111111111111111111111");
//System.out.println(rs.getString(6));
 // }
//System.out.println(")))))))))))))))))))))))))))))))))))))))00");
//System.out.println(uname);
  

%>
<input type="submit" value="Send"/>
 </form>
    <script>
document.getElementById("ponyo_form").submit();
</script>
</div>
</body>
</html>