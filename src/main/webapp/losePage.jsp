<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.09.2022
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOSE</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/js/jquery-3.6.0.min.js"/>"></script>
    <script src="./js/script.js"></script>
</head>
<body>
<h1>YOU ARE LOSE</h1>
<br>

<input type="button" value="TRY AGAIN" onClick="document.location = '/restart'"/>
</body>
</html>
