<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>

<div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach var="quest" items="${requestScope.quests}">
    <div class="col">
        <div class="card" style="width: 18rem;">
            <img src="images/quest.png" class="card-img-top" alt="...">
            <div class="card-body">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
                <a href="game?questId=${quest.id}" class="btn btn-primary">Играть</a>
            </div>
        </div>
    </div>
    </c:forEach>
</div>

<%@include file="footer.jsp" %>