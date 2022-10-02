<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<div class="container">
    <b>${requestScope.gamesStats}</b>
    <ul>
        <c:forEach var="playedGame" items="${requestScope.all}">
            <li>
                <b>${playedGame}</b>
            </li>
        </c:forEach>
    </ul>
</div>
<%@include file="parts/footer.jsp" %>
