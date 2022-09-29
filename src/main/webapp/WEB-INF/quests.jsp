<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="parts/header.jsp" %>
<div class="container">
    <div class="container">
        <ul>
            <c:forEach var="quest" items="${requestScope.all}">
                <li>
                    <a href="quest?id=${quest.id}">${quest}</a>
                </li>
            </c:forEach>
            <c:if test="${not empty sessionScope.user}">
                <c:if test="${sessionScope.user.role == Role.ADMIN}">
                    <li>
                        <a href="quest?id=0">Create new quest</a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </div>
</div>
<%@include file="parts/footer.jsp" %>
