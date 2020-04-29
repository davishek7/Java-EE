<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<form action="Update" method="post">
<h2>Edit Profile</h2>
<table style="border: 1px solid black">
<tr>
<th>Username</th>
<th>Name</th>
<th>Email</th>
<th>Address</th>
<th>Gender</th>
<th>Password</th>
</tr>
<tr>
<td><input type="text" name="uname" value="${uname}" readonly></td>
<td><input type="text" name="name" value="${name}"></td>
<td><input type="email" name="email" value="${email}"></td>
<td><input type="text" name="address" value="${address}"></td>
<td><input type="text" name="gender" value="${gender}" readonly></td>
<td><input type="text" name="pass" value="${pass}"></td>
</tr>
</table><br>
<input type="submit" value="Update">
</form>
</body>
</html>