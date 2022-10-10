<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<%@page import="ru.javarush.quest.bogdanov.questdelta.services.StatsService" %>
<div class="container">
    <b>${requestScope.gamesStats}</b>
    <br>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Название квеcта
            </td>
            <th>Время
            </td>
            <th>Игрок
            </td>
            <th>Исход
            </td>
        </tr>

        <c:forEach var="playedGame" items="${requestScope.all}">
            <tr>
                <td>${playedGame.id}</td>
                <td>${StatsService.STATS_SERVICE.getQuestName(playedGame)}</td>
                <td>${playedGame.date}</td>
                <td>${StatsService.STATS_SERVICE.getUserLogin(playedGame)}</td>
                <td>${playedGame.gameState}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="parts/footer.jsp" %>
