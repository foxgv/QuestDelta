<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<%@page import="ru.javarush.quest.bogdanov.questdelta.services.QuestService" %>
<div class="container">
    <c:forEach var="quest" items="${requestScope.all}">
        <div class="quests">
            <h2>${quest.name}</h2>
            <b>Описание: ${quest.description}</b>
            <br>
            <b>Автор: ${QuestService.QUEST_SERVICE.getAuthorLogin(quest.authorId)}</b>
            <br>
            <div class="buttons">
                <button onclick="window.location.href='/game?questid=${quest.id}'">Играть!</button>
            </div>
        </div>
        <br>
    </c:forEach>
</div>
<%@include file="parts/footer.jsp" %>
