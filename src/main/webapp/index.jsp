<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="./js/script.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>

<a href="/start">Start</a>
<br>
<br>
<br>
<button onclick="restart()">Start again</button>


</body>
</html>