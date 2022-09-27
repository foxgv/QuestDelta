<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 21.09.2022
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/js/jquery-3.6.0.min.js"/>"></script>
    <script src="./js/script.js"></script>
</head>
<body>
<h1>NEW PAGE HELLO</h1>
<br>
<br>
<p>You accepted the challenge. Go up to the bridge to the captain?</p>

<p><input type="checkbox" name="browser" value="IE" /> Go up to the bridge.</p>
<p><input type="checkbox" name="browser" value="IE" /> Refuse to go up to the bridge.</p>
<a href="/start"><input type="button" /> SUBMIT</a>


</body>
</html>
