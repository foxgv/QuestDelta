<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>

<div class="lex-content">
    <div class="question-form-wrapper">
        <jsp:useBean id="game" scope="request" type="ua.com.javarush.quest.gribanov.questdelta.dto.GameDTO"/>
        <img src="quest_images/${requestScope.question.image}">
        <h2 class="lex-question">${requestScope.question.questionText}</h2>
        <c:if test = "${not empty requestScope.question.answers}">
            <form id="answerForm" action="game?gameId=${game.id}" method="post">
                <c:forEach var="answer" items="${requestScope.question.answers}">
                    <div class="form-check">

                        <input class="form-check-input" type="radio" name="answer" id="answer${answer.id}" value="${answer.id}">
                        <label class="form-check-label" for=${answer.id}>
                                ${answer.answerText}
                        </label>
                    </div>
                </c:forEach>
                <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit" >Ответить</button>
                <div id="error-answer" class="is-hide">
                    <span class="cd-error-message">Ошибка! Не заполнен логин!</span>
                </div>
            </form>
        </c:if>
    </div>
</div>


<%@include file="footer.jsp" %>
