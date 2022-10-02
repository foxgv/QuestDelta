<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<%@page import="ru.javarush.quest.bogdanov.questdelta.entities.Role" %>
<div class="container">
    <c:if test="${not empty sessionScope.user}">
        <c:if test="${sessionScope.user.role == Role.ADMIN}">
            <div class="users">
                <a href="user?id=0">Create new user</a>
            </div>
        </c:if>
    </c:if>
    <br>
    <c:forEach var="user" items="${requestScope.all}">
        <div class="users">
            <a href="user?id=${user.id}">${user.login}</a>
            <br>
            <b>Роль: ${user.role}</b>
            <br>
            <b>Игры: ${user.games}</b>
            <br>
        </div>
        <br>
    </c:forEach>


</div>
<%@include file="parts/footer.jsp" %>
