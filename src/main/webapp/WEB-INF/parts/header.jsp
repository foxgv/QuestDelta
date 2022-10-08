<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="${pageContext.request.contextPath}/"
           class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                <use xlink:href="#bootstrap"></use>
            </svg>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2 link-secondary">Домой</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Квесты</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Создать</a></li>
            <li><a href="${pageContext.request.contextPath}/question" class="nav-link px-2 link-dark">Играть</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Статистика</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <ul>
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <li><a href="${pageContext.request.contextPath}/profile"
                               class="nav-link px-2 link-dark">Profile</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout"
                               class="nav-link px-2 link-dark">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login" class="nav-link px-2 link-dark">Login</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/signup"
                               class="nav-link px-2 link-dark">Sign-up</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </header>
</div>