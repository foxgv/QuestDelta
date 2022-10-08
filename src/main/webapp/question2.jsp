<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<br>
<form class="forms" action="ServletQuestions">
    <p><b>Ты принял вызов. Поднимаешься на мостик к капитану?</b></p>
    <p><input type="radio" name="answer" value="20">Подняться на мостик<Br>
        <input type="radio" name="answer" value="21">Отказаться подниматься на мостик<Br>
    <p><input type="submit"></p>
</form>
<br>
<h3>Ваш ответ: <c:out value="${requestScope.answerString}"/></h3>

<c:if test="${requestScope.answerNumber == 0}">
    <p><a href="question3.jsp" class="button_href">Перейти к следующему вопросу</a></p>
</c:if>

<c:if test="${requestScope.answerNumber > 0}">
    <h3>
        Ты не пошел на переговоры. Поражение!
    </h3>
    <p><a href="index.jsp" class="button_href">Перейти на начало</a></p>
</c:if>

</body>
</html>
