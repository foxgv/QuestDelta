<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<br>
<form class="forms" action="ServletQuestions">
    <p><b>Ты поднялся на мостик. Ты кто?</b></p>
    <p><input type="radio" name="answer" value="30">Рассказать правду о себе<Br>
        <input type="radio" name="answer" value="31">Солгать о себе<Br>
    <p><input type="submit"></p>
</form>
<br>
<h3>Ваш ответ: <c:out value="${requestScope.answerString}"/></h3>

<c:if test="${requestScope.answerNumber == 0}">
    <h3>
        Тебя вернули домой. Победа!
    </h3>
    <br>
    <img src="images\gameover.jpg" height="150">
    <br>
    <p><a href="index.jsp" class="button_href">Перейти на начало</a></p>

</c:if>

<c:if test="${requestScope.answerNumber > 0}">
    <h3>
        Твою ложь разоблачили. Поражение!
    </h3>
    <p><a href="index.jsp" class="button_href">Перейти на начало</a></p>
</c:if>

</body>
</html>
