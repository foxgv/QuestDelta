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
    <h1 class="display-4">List of users</h1>
</div>
<div class="container px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
<ul>
    <c:forEach var="user" items="${requestScope.users}">
        <li>
                ${user.role}: <a href="user?id=${user.id}"> ${user.login}</a>
        </li>
        <br>
    </c:forEach>
    <li><a href="/user">Create new user</a> </li>
</ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>
