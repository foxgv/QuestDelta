<%--
  Created by IntelliJ IDEA.
  User: zazmik
  Date: 22.09.2022
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User registration</title>
</head>
<body>
<div class="container">
    <form class="form-horizontal" action="user?id=${requestScope.user.id}" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>User Form</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userLogin">Login</label>
                <div class="col-md-4">
                    <input id="userLogin" name="login" type="text" placeholder="set login" class="form-control input-md" required=""
                    value="${requestScope.user.login}">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userPassword">Password</label>
                <div class="col-md-4">
                    <input id="userPassword" name="password" type="password" placeholder="set password" class="form-control input-md" required=""
                    value="${requestScope.user.password}">
                    <span class="help-block">a-z, 1-9</span>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userRole">Select role</label>
                <div class="col-md-4">
                    <select id="userRole" name="role" class="form-control">
                        <option value="USER">USER</option>
                        <option value="ADMIN">ADMIN</option>
                        <option value="GUEST">GUEST</option>
                    </select>
                </div>
            </div>

            <!-- File Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="filebutton">Image</label>
                <div class="col-md-4">
                    <input id="filebutton" name="filebutton" class="input-file" type="file">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="save">Registration</label>
                <div class="col-md-4">
                    <button id="save" name="save" class="btn btn-success">Save</button>
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
</body>
</html>
