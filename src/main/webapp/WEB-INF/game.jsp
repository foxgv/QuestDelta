<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="web-parts/HTML-header.jsp" %>
<%@include file="web-parts/page-header.jsp" %>

<div class="container" style="margin-top: 50px;">
    <h1 class="display-5 fw-bold">${requestScope.question.text}</h1>
    <form action="game" method="post">
        <ul>
            <c:forEach var="answer" items="${requestScope.question.answers}">
                <div class="form-check fs-4">
                    <input class="form-check-input" type="radio" name="answer" value="${answer.id}"
                           id="answer${answer.id}">
                    <label class="form-check-label" for="answer${answer.id}">
                            ${answer.text}
                    </label>
                </div>
            </c:forEach>
        </ul>
        <div class="form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
                <button id="submit" class="btn btn-outline-info btn-dark px-4 me-sm-3 fw-bold">ОК</button>
            </div>
        </div>
    </form>
</div>

<%@include file="web-parts/HTML-footer.jsp" %>