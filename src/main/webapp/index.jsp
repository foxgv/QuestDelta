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

<%--<a href="/quest">Start</a>--%>

<form action="/quest" method="GET">
    Enter your name <input type="text" name="userName"/>
    <input type="submit" value="submit">
</form>
<br>
<input type="button" value="TRY AGAIN" onClick="document.location = '/restart'"/>

</body>
</html>