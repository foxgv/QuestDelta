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
    <h1 class="display-4">Game</h1>
</div>
<div>

    <h1><%= request.getAttribute("question") %> </h1>
</div>

<div class="form-check">

    <input class="form-check-input" type="radio" name="answer"  value="0" id="0">
    <label class="form-check-label" for="0">
        <%= request.getAttribute("ans1") %>
    </label>
    <br>
    <input class="form-check-input" type="radio" name="answer"  value="1" id="1">
    <label class="form-check-label" for="1">
        <%= request.getAttribute("ans2") %>
    </label>
</div>

<div class=" form-group">
    <label class="col-md-4 control-label" for="submit"></label>
    <div class="col-md-4">
        <button id="submit" class="btn btn-success">Играть</button>
    </div>
</div>

<div>
    <h5 class = "uk-heading-medium">Имя: <%= request.getSession().getAttribute("name") %> </h5>
    <h5 class = "uk-heading-medium">Игр сыграно: <%= request.getSession().getAttribute("count") %> </h5>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>