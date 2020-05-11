<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>QUANS App</title>
<link href="css/common.css"
        rel="stylesheet">
</head>
<body>
<h4>View Questions:</h4>
<ul class="one">
<c:forEach var="q" items="${questions}" varStatus="qcounter">
	<li class="item">Q${qcounter.count}. ${q}
	<button type="button" onclick="location.href='addAnswer?id=${q.id}'">Add Another Answer</button>
	</li>
	<ul>
		<c:forEach var="x" items="${q.answers}" varStatus="xcounter">
			<li class="one.xitem"> ${x}</li>
		</c:forEach>
	</ul>
</c:forEach>
</ul>
<a href="addQuestion">Ask New Question</a><br/>
</body>
</html>