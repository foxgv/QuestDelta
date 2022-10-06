<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Привет, давай пройдем квест!" %>
</h1>
<br/>
<h1><%= "История начинается неожиданно:"%></h1>
<br/>
<form class="form-horizontal" action="create" method="get">
<div class="form-group">
    <label class="col-md-4 control-label" for="name">Name</label>
    <div class="col-md-4">
        <input id="name" name="name" type="text" placeholder="set name" class="form-control input-md">
    </div>

    <div class=" form-group">
        <label class="col-md-4 control-label" for="submit"></label>
        <div class="col-md-4">
            <button id="submit" class="btn btn-success">Играть</button>
        </div>
    </div>
</div>
</form>
</body>
</html>