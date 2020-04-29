<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Register" method="post">
	<h2>Registration</h2>
		<input type="text" name="uname" placeholder="Username"><br> <input type="text"
			name="name" placeholder="Name"><br> <input type="text" name="email" placeholder="E-mail"><br>
		<textarea name="address" placeholder="Address"></textarea>
		<br> <input type="radio" name="gender" value="Male"> <label
			for="Male">Male</label> <input type="radio" name="gender"
			value="Female"> <label for="Female">Female</label><br> <input
			type="password" name="pass" placeholder="Password"><br> <input type="password"
			name="cpass" placeholder="Confirm Password"><br> <input type="submit" value="Register">
		<input type="reset" value="Reset">
	</form>
</body>
</html>