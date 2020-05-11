<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QUANS App</title>
<link href="css/common.css"
        rel="stylesheet">
</head>
<body>
<h4>Add Answer:</h4>
<form method="POST" action="addAnswer">
	Question = ${question}<br/>
	Answer = <input type="text" name="answer"><br/>
	<input type="hidden" name="id" value="${question.id}">
	<input type="submit" value="ADD">
</form>
</body>
</html>