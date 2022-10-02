<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<%@page import="ru.javarush.quest.bogdanov.questdelta.entities.GameState" %>
<div class="container">
    <div class="questText">
        <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
        <h2>${sessionScope.question.text}</h2>
        <br>
        <c:forEach var="answer" items="${sessionScope.question.answerList}">
            <button class="answerButton" onclick="sendAnswer(this)" id="${answer.id}">${answer.text}</button>
        </c:forEach>
        <c:if test="${sessionScope.game.gameState != GameState.STARTED}">
            <button class="answerButton" onclick="window.location.href='/finish'">Завершить!</button>
        </c:if>
        <br>
    </div>
</div>
<script>
    function sendAnswer(button) {
        $.ajax({
            type: 'POST',
            url: '/game?answerid=' + button.id + '&currentquestionid=' + ${sessionScope.game.currentQuestionId},
            contentType: 'application/json;charset=UTF-8',
            async: false,
            success: function () {
                location.reload();
            }
        });
    }
</script>
<%@include file="parts/footer.jsp" %>
