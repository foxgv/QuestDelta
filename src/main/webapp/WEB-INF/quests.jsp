<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<div class="container">
    <c:forEach var="quest" items="${requestScope.all}">
        <div class="quests">
            <h2>${quest.name}</h2>
            <b>Описание: ${quest.description}</b>
            <br>
            <b>Автор: *доделать*</b>
            <br>
            <button class="answerButton" onclick="window.location.href='/game?questid=${quest.id}'">Играть!</button>
        </div>
        <br>
    </c:forEach>
</div>
<%@include file="parts/footer.jsp" %>
