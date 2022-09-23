<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="${pageContext.request.contextPath}/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">

            </svg>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a class="nav-link px-2 link-secondary">Главная</a></li>
            <li><a class="nav-link px-2 link-dark">Квесты</a></li>
            <li><a class="nav-link px-2 link-dark">Создать</a></li>
            <li><a class="nav-link px-2 link-dark">Играть</a></li>
            <li><a class="nav-link px-2 link-dark">Статистика</a></li>
            <li><a href="users" class="nav-link px-2 link-dark">Пользователи</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <button type="button" class="btn btn-outline-primary me-2">Login</button>
            <button type="button" class="btn btn-primary">Sign-up</button>
        </div>
    </header>
    <br/>
    <a href="helloServlet">Hello Servlet</a>
    <a href="user">User Servlet</a>

    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
        <div class="col-md-4 d-flex align-items-center">
            <a href="${pageContext.request.contextPath}/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
                <svg class="bi" width="30" height="24">

                </svg>
            </a>
            <span class="mb-3 mb-md-0 text-muted">© 2022 Company, Inc</span>
        </div>

        <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
            <li class="ms-3"><a class="text-muted" href="#">
                <svg class="bi" width="24" height="24">

                </svg>
            </a></li>
            <li class="ms-3"><a class="text-muted" href="#">
                <svg class="bi" width="24" height="24">

                </svg>
            </a></li>
            <li class="ms-3"><a class="text-muted" href="#">
                <svg class="bi" width="24" height="24">

                </svg>
            </a></li>
        </ul>
    </footer>
</div>
</body>
</html>