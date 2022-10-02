<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Игра</title>
</head>
<body>

<p>Вопрос: <%= request.getAttribute("questionText") %></p>

<br/>
<p>Age: <%= request.getAttribute("ans1") %></p>
<br/>
<p>Age: <%= request.getParameter("age") %></p>
</body>
</html>
