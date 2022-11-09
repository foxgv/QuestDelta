<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>
<div class="lex-content">
    <div class="album py-5 bg-light">
        <div class="container-md">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <c:forEach var="quest" items="${requestScope.quests}">
                    <div class="col">
                        <div class="card h-100">
                            <img src="quest_images/${quest.image}" class="card-img-top" alt="No image found">
                            <div class="card-body">
                                <div class="card-body">
                                    <h5 class="card-title">${quest.name}</h5>
                                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                </div>
                                <c:if test = "${not empty sessionScope.user}">
                                    <a href="game?questId=${quest.id}" class="btn btn-primary">Играть</a>
                                </c:if>
                            </div>
                            <div class="card-footer text-muted">
                                AuthorID: ${quest.authorId}
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>