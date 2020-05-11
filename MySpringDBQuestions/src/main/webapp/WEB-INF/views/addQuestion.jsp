<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to the QUANS App!</title>
<link href="css/common.css"
        rel="stylesheet">
</head>
<body>
<h4>Ask a new question:</h4>
<form method="POST" action="displayQuestions">
	Question = <input type="text" name="question"><br/>
	Answer = <input type="text" name="answer"><br/>
	<input type="submit" value="ADD">
</form>
</body>
</html>