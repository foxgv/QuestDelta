<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>

<div>
    <h2>${requestScope.question.questionText}</h2>
    <c:if test = "${not empty requestScope.question.answers}">
        <form action="game?gameID=${game.id}" method="post">
            <c:forEach var="answer" items="${requestScope.question.answers}">
                <div class="form-check">

                    <input class="form-check-input" type="radio" name="answer" id="answer${answer.id}" value="${answer.id}">
                    <label class="form-check-label" for=${answer.id}>
                            ${answer.answerText}
                    </label>
                </div>
            </c:forEach>
            <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit" onclick="">Ответить</button>
        </form>
    </c:if>
</div>

<%@include file="footer.jsp" %>
