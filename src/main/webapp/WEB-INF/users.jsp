<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<%@page import="ru.javarush.quest.bogdanov.questdelta.entities.Role"%>
<div class="container">
    <ul>
        <c:forEach var="user" items="${requestScope.all}">
            <li>
                <a href="user?id=${user.id}">${user}</a>
            </li>
        </c:forEach>
        <c:if test="${not empty sessionScope.user}">
            <c:if test="${sessionScope.user.role == Role.ADMIN}">
                <li>
                    <a href="user?id=0">Create new user</a>
                </li>
            </c:if>
        </c:if>
    </ul>
</div>
<%@include file="parts/footer.jsp" %>
