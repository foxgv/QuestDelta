<%@ page import="java.util.List" %>
<%@ page import="ua.com.javarush.quest.mogutov.questdelta.data.Quest" %>
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

<%
    // get current quest object
    Quest quest = (Quest) session.getAttribute("quest");

    // get current level text for user
    List<String> levelText = quest.getCurrentLevelText(quest.getLEVEL());
%>

<h3><%out.println(levelText.get(0));%></h3>

<form action="/quest" method="GET">
    <input type="radio"  name="answer" value="1" /> <% out.println(levelText.get(1)); %>
    <input type="radio" name="answer" value="0" /> <% out.println(levelText.get(2)); %>
    <input type="submit" value="submit">
</form>

<input type="button" value="TRY AGAIN" onClick="document.location = '/restart'"/>

<div class="footer">
    <h4>Statistic: </h4>
    <p class="username">User name: <% out.println(quest.getUserName()); %></p>
    <p class="user_address">IP Address - DeviceName/Address: <% out.println(quest.getUserAddress()); %> </p>
    <p class="sessionID">Session ID: <% out.println(session.getId()); %> </p>
</div>


</body>
</html>
