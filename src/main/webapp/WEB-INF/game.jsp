<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<div class="container">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <h1>Header</h1>
    <p class="text">${sessionScope.question.text}</p>
    <br>
    <c:forEach var="answer" items="${sessionScope.question.answerList}">
        <button onclick="sendAnswer(this)" id="${answer.id}">${answer.text}</button>
    </c:forEach>
    <br>
    <script>
        function sendAnswer(button) {
            $.ajax({
                type: 'POST',
                url: '/game?answerid=' + button.id + '&currentquestionid=' + ${sessionScope.question.id},
                contentType: 'application/json;charset=UTF-8',
                async: false,
                success: function () {
                    location.reload();
                }
            });
        }
    </script>
</div>
<%@include file="parts/footer.jsp" %>
