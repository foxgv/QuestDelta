<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<div>
    <form method="post">
        <div class="container">

            <ul>
                <legend>${requestScope.question}</legend>
                <c:forEach var="answer" items="${requestScope.answers}">
                    <li>
                        <input type="radio" id="contactChoice1"
                               name="nextQuestionID" value="${answer.nextQuestionID}">
                        <label for="contactChoice1">${answer.answer}</label>
                        <br>
                    </li>
                </c:forEach>
            </ul>


            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="Далее"
                            class="btn btn-success">Далее
                    </button>
                </div>
            </div>
        </div>
    </form>
    <form method="get">
        <div class="form-group">
            <label class="col-md-4 control-label" for="newGame"></label>
            <div class="col-md-4">
                <button id="newGame" name="newGame" value="newGame"
                        class="btn btn-warning">Начать заново
                </button>
            </div>
        </div>
    </form>
</div>

<%@include file="parts/footer.jsp" %>
