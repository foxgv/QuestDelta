<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User registration</title>
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
<div class="container">
    <form class="form-horizontal" action="user?id=${requestScope.user.id}" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>User Form</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userLogin">Login</label>
                <div class="col-md-4">
                    <input id="userLogin" name="login" type="text" placeholder="set login" class="form-control input-md"
                           required=""
                           value="${requestScope.user.login}">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userPassword">Password</label>
                <div class="col-md-4">
                    <input id="userPassword" name="password" type="password" placeholder="set password"
                           class="form-control input-md" required=""
                           value="${requestScope.user.password}">
                    <span class="help-block">a-z, 1-9</span>
                </div>
            </div>

            <!-- Select role -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userRole">Select role</label>
                <div class="col-md-4">
                    <select id="userRole" name="role" class="form-control">
                        <c:forEach items="${applicationScope.roles}" var="role">
                            <option value="${role}" ${role==requestScope.user.role?"selected":""}>${role}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!-- Image Button
            <div class="form-group">
                <label class="col-md-4 control-label" for="userImage">Image</label>
                <div class="col-md-4">
                    <input id="userImage" name="image" class="input-file" type="file">
                </div>
            </div>
-->
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="save">Registration</label>
                <div class="col-md-4">
                    <button id="save" name="${requestScope.user.id>0?"update":"create"}"0
                            class="btn btn-success">${requestScope.user.id>0?"Update":"Create"}</button>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="delete">Single Button</label>
                <div class="col-md-4">
                    <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>
