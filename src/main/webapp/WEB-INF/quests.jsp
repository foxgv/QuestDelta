<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>

<div class="lex-quests-content">
    <div class="bulb1"></div>
    <div class="bulb2"></div>
    <div class="bulb3"></div>
    <div class="lex-album-quests">
        <div class="lex-row-cols">
            <c:forEach var="quest" items="${requestScope.quests}">
                <div class="lex-col">
                    <div class="lex-card">
                        <div class="lex-quest-image-wrap">
                            <img src="quest_images/${quest.image}" class="lex-card-img-top" alt="No image found">
                        </div>
                        <div class="lex-card-body">
                            <div class="card-body">
                                <h5 class="card-title">${quest.name}</h5>
                                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                            <div class="lex-play-button">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.user}">
                                        <a href="game?questId=${quest.id}" class="btn btn-primary">Играть</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="cd-signup" href="#0">Зарегистрируйтесь чтобы играть</a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="card-footer text-muted">
                                AuthorID: ${quest.authorId}
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>