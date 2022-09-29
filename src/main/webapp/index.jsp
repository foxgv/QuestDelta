<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<div class="container">
    <form class="form-horizontal" method="post" action="signup">
        <fieldset>

            <!-- Form Name -->
            <legend>User Form</legend>

            <!-- Text input-->
                    <input id="userLogin" name="login" type="text" placeholder="set login" class="form-control input-md"
                           required=""
                           value="">



            <!-- Password input-->
            <br/>

                    <input id="userPassword" name="password" type="password" placeholder="pass req"
                           class="form-control input-md" required=""
                           value="">

            <br/>

            <!-- Button -->

                    <button id="submit"
                            class="btn btn-success">Create</button>

        </fieldset>
    </form>
</div>
</body>
</html>