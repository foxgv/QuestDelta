<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal"></h5>
    <nav class="my-2 my-md-0 mr-md-3">

        <a class="p-2 text-dark" href="/">Главная<br></a>
    </nav>
</div>
<div class="header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">User</h1>
</div>
<div class="container px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <jsp:useBean id="user" scope="session" type="ua.com.javarush.quest.zazimko.questdelta.entity.User "/>
    <ul>
        <h1 class="display-3 fw-bold">User login: ${sessionScope.user.login}</h1>
        <h3 class="display-5 fw-bold">User role: ${sessionScope.user.role}</h3>
            <br>
    </ul>
    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
        <input type="hidden" name="id" value="${user.id}">
        <a class="p-2 text-dark" href="/game">Начать игру!</a>
        <a class="p-2 text-dark" href="/logout">Выход</a>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>
