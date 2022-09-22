<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <c:import url="/WEB-INF/jsp/parts/links.jsp"/>
    <link rel="stylesheet" href="static/signin.css"/>
</head>
<body>
<%--<main class="form-signin w-100 m-auto">--%>
<%--        <form action="${pageContext.request.contextPath}/signup" method="post">--%>
<%--            <img class="mb-3 mx-auto d-block" src="images/eagle-black.svg" alt="" width="100" height="100">--%>
<%--            <h1 class="h3 mb-3 fw-normal">Register</h1>--%>

<%--            <div class="form-floating">--%>
<%--            <input type="text" class="form-control" id="floatingInput" name="login" placeholder="Username" required--%>
<%--                   minlength="1" maxlength="20" pattern="[A-Za-z0-9]+">--%>
<%--            <label for="floatingInput">Username</label>--%>
<%--        </div>--%>
<%--        <div class="form-floating">--%>
<%--            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password" required--%>
<%--                   minlength="1" maxlength="8" pattern="[A-Za-z0-9]+">--%>
<%--            <label for="floatingPassword">Password</label>--%>
<%--        </div>--%>

<%--        <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>--%>
<%--        <c:if test="${not empty requestScope.error}">--%>
<%--            <div class="form-floating text-danger my-3 p-2">--%>
<%--                <p class="text-center m-0">${requestScope.error}</p>--%>
<%--            </div>--%>
<%--        </c:if>--%>
<%--    </form>--%>
<%--</main>--%>

<main class="form-register w-100 m-auto">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/signup" method="post">

        <fieldset>
            <img class="mb-3 mx-auto d-block" src="images/eagle-black.svg" alt="" width="100" height="100">
            <legend class="text-center">Register</legend>

            <div class="form-group">
                <label class="col control-label" for="input_username"><strong>Username</strong></label>
                <div class="col d-flex flex-column mb-2">
                    <input id="input_username" name="input_username" type="text" placeholder="username"
                           class="form-control input-md" required
                           minlength="1" maxlength="20" pattern="[A-Za-z0-9]+">
                    <span class="form-text text-center"><small>Latin letters or digits</small></span>
                </div>
            </div>

            <div class="form-group">
                <label class="col control-label" for="input_password"><strong>Password</strong></label>
                <div class="col d-flex flex-column mb-2">
                    <input id="input_password" name="input_password" type="password" placeholder="********"
                           class="form-control input-md" required
                           minlength="1" maxlength="8" pattern="[A-Za-z0-9]+">
                    <span class="form-text text-center"><small>Latin letters or digits</small></span>
                </div>
            </div>

            <div class="form-group">
                <label class="col control-label" for="select_roles"><strong>Role</strong></label>
                <div class="col">
                    <select id="select_roles" name="select_roles" class="form-control">
                        <option value="1">Option one</option>
                        <option value="2">Option two</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col control-label" for="singlebutton"></label>
                <div class="col d-flex">
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary w-50 mx-auto">Submit</button>
                </div>
            </div>
            <c:if test="${not empty requestScope.error}">
                <div class="form-floating text-danger my-3 p-2">
                    <p class="text-center m-0">${requestScope.error}</p>
                </div>
            </c:if>
        </fieldset>
    </form>
</main>

<c:import url="/WEB-INF/jsp/parts/scripts.jsp"/>
</body>

</html>