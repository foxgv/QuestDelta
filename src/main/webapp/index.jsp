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
<form class="form-horizontal" action="signup" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="exampleInputLogin">login</label>
        <input type="Login" class="form-control" id="exampleInputLogin" placeholder="Enter login">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>