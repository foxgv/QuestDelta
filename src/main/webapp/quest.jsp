<%@ page import="java.util.List" %>
<%@ page import="ua.com.javarush.quest.khmelov.questdelta.data.Quest" %><%--
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

<%
    Quest quest = (Quest) session.getAttribute("quest");
    List<String> levelText = quest.getCurrentLevelText(quest.getLEVEL());

//    if (names != null && !names.isEmpty()) {
//        out.println("<ui>");
//        for (String s : names) {
//            out.println("<li>" + s + "</li>");
//        }
//        out.println("</ui>");
//    } else out.println("<p>There are no users yet!</p>");
%>

<h3><%

    out.println(levelText.get(0));
    out.println(request.getAttribute("userName"));
    out.println(session.getAttribute("userName"));
%></h3>


<form action="/quest" method="GET">
    <input type="checkbox" name="answer" value="1" /> <% out.println(levelText.get(1)); %>
    <input type="checkbox" name="answer" value="0" /> <% out.println(levelText.get(2)); %>
    <input type="submit" value="submit">
</form>

<input type="button" value="TRY AGAIN" onClick="document.location = '/restart'"/>

</body>
</html>
