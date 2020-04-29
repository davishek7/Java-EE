<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if (session == null || session.getAttribute("uname") == null) {
    response.sendRedirect("login.jsp"); // No logged-in user found, so redirect to login page.
} else%> 
<%{%>
<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);
}%>
<h2>Welcome ${name}</h2><br>
<form action="Profile" method="post">
<input type="submit" value="Edit Profile"><br>
</form>
<form action="Logout" method="post">
<input type="submit" value="Logout"><br>
</form>
</body>
</html>