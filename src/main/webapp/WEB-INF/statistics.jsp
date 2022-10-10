<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="web-parts/HTML-header.jsp" %>
<%@include file="web-parts/page-header.jsp" %>

<div class="container" style="margin-top: 30px">
    <h2 class="display-6 text-center mb-4">Статистика игр</h2>
    <div class="table-responsive" style="padding-left: 10%; padding-right: 10%;">
        <table class="table text-center border-info">
            <thead>
            <tr>
                <th style="width: 34%;">Пользователь</th>
                <th style="width: 22%;">Дата</th>
                <th style="width: 34%;">Правильных ответов/Вопросов</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="statRow" items="${requestScope.statistics}">
                <tr>
                    <td>${statRow.user}</td>
                    <td>${statRow.date}</td>
                    <td>${statRow.correctAnswersCount}/${applicationScope.totalQuestionsCount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="web-parts/HTML-footer.jsp" %>