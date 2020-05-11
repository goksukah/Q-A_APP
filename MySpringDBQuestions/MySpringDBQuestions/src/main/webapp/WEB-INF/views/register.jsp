<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="css/common.css"
        rel="stylesheet">
</head>
<body>
<h4>Register</h4>
<h4>${message}</h4>
<form method="POST" action="register">
	Name = <input type="text" name="name"><br/>
	Password = <input type="password" name="pswd"><br/>
	<input type="submit" value="Create your account">
</form>
</body>
</html>