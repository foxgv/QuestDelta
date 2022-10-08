<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quest</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>
    Играет: <c:out value="${sessionScope.name}"/>
</h2>

</body>
</html>
